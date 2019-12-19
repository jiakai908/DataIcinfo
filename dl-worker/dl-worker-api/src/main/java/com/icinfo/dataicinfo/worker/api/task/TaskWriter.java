package com.icinfo.dataicinfo.worker.api.task;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.icinfo.dataicinfo.common.errors.RecordNotSupportException;
import com.icinfo.dataicinfo.contract.Record;
import com.icinfo.dataicinfo.domain.plugin.PluginWriterParameter;
import com.icinfo.dataicinfo.worker.api.handle.Handler;
import com.icinfo.dataicinfo.worker.api.util.statistic.WriterStatistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public abstract class TaskWriter<T extends PluginWriterParameter> extends TaskLifeCycle {
    private static final Logger logger = LoggerFactory.getLogger(TaskWriter.class);

    protected TaskWriterContext context;
    protected T parameter;
    protected LoadingCache<Class<? extends Record>, Handler> handers;

    /**
     * Initialize this TaskWriter with the specified context object.
     *
     * @param context
     */
    @SuppressWarnings("unchecked")
    public void initialize(TaskWriterContext context) {
        this.context = context;
        this.parameter = (T) context.getWriterParameter();
        this.handers = CacheBuilder.newBuilder().build(new CacheLoader<Class<? extends Record>, Handler>() {
            @Override
            public Handler load(Class<? extends Record> clazz) throws Exception {
                Handler handler = getHandler(clazz);
                if (handler == null) {
                    throw new RecordNotSupportException(clazz);
                }
                handler.initialize(context);
                return handler;
            }
        });
    }

    public void close() {
        handers.asMap().values().stream().forEach(Handler::destroy);
    }

    public void prePush() {
        context.beginSession();
        context.taskWriterSession().setData(WriterStatistic.KEY, new WriterStatistic(context.taskId(), parameter));
    }

    public void push(RecordChunk recordChunk) {
        doPush(recordChunk);
    }

    @SuppressWarnings("unchecked")
    protected void doPush(RecordChunk recordChunk) {
        List<? extends Record> records = recordChunk.getRecords();
        if (records != null && !records.isEmpty()) {
            Handler handler = handers.getUnchecked(records.get(0).getClass());//一个chunk里面的数据类型都是一样的
            handler.writeData(recordChunk, context);

        }
    }

    protected abstract Handler getHandler(Class<? extends Record> clazz);
}
