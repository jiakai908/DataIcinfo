package com.icinfo.dataicinfo.domain.media.task;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public enum TaskType {
    MYSQL, HBASE;

    public boolean mustRestartWhenPause() {
        return HBASE.equals(this);
    }
}
