package com.icinfo.dataicinfo.worker.api.handle;

import com.icinfo.dataicinfo.worker.api.task.RecordChunk;
import com.icinfo.dataicinfo.worker.api.task.TaskWriterContext;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public interface Handler {
    void initialize(TaskWriterContext context);
    void destroy();
    void writeData(RecordChunk recordChunk,TaskWriterContext context);
}
