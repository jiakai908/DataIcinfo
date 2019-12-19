package com.icinfo.dataicinfo.domain.media.task;

import com.icinfo.dataicinfo.domain.Parameter;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public class TaskParameter extends Parameter {
    private Long taskId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
