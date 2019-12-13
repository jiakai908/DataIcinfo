package com.icinfo.dataicinfo.worker.api.task;


import com.icinfo.dataicinfo.domain.plugin.PluginWriterParameter;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public interface TaskWriterContext {
    /**
     * Get the Parameter for the TaskWriter.
     */
    PluginWriterParameter getWriterParameter();

    /**
     * Get the writer-part session of this task,so the scope of the session data is just for TaskWriter.
     */
    TaskSession taskWriterSession();

    /**
     * Get the writer-part Attributes of this task,so the scope of the Attributes is just for TaskWriter.
     */
    TaskAttributes taskWriterAttributes();
}
