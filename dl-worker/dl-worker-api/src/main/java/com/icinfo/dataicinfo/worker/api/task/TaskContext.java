package com.icinfo.dataicinfo.worker.api.task;

/**
 * 描述:  每个Task都会绑定一个TaskContext,通过context可以实现task和runtime之间的交互.<br>
 * TaskContext的生命周期和Task的运行生命周期保持一致，当Task关闭时TaskContext也随之销毁。
 * @author jkk
 * @date 2019年12月13
 */
public interface TaskContext {
    /**
     * Get the identifier of the task.
     */
    String taskId();

    /**
     * get the executing id for this execution,the id is a uuid string.
     */
    String taskExecutionId();

    /**
     * Get the service component by service interface type.
     */
    <T> T getService(Class<? extends T> clazz);

    /**
     * Get the global session of this task, TaskReader & TaskWriter can share data by this session.
     */
    TaskSession taskSession();

    /**
     * Get the global Attributes of this task, TaskReader & TaskWriter can share data by this Attributes.
     */
    TaskAttributes taskAttributes();

    /**
     * begin a new session
     */
    void beginSession();
}
