package com.icinfo.dataicinfo.worker.api.task;

import com.icinfo.dataicinfo.domain.plugin.PluginReaderParameter;
import com.icinfo.dataicinfo.worker.api.position.PositionManager;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public interface TaskReaderContext extends TaskContext{
    /**
     * Get the PositionManager for the TaskReader.
     */
    PositionManager positionManager();

    /**
     * Get the Parameter for the TaskReader.
     */
    <T extends PluginReaderParameter> T getReaderParameter();

    /**
     * Get the reader-part session of this task,so the scope of the session data is just for TaskReader.
     */
    TaskSession taskReaderSession();

    /**
     * Get the reader-part Attributes of this task,so the scope of the Attributes is just for TaskReader.
     */
    TaskAttributes taskReaderAttributes();
}
