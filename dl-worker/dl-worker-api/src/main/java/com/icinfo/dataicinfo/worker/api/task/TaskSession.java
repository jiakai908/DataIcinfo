package com.icinfo.dataicinfo.worker.api.task;

/**
 * 描述:  完成一次RecordChunk数据同步的过程定义为一次会话,TaskSession主要用来支持一次会话内的数据共享.<br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public interface TaskSession {

    /**
     * Add session data with the specified key.
     * If the data for the key has already exist,replace the old value with the new value.
     */
    <K,V> void setData(K key, V value);

    /**
     * Get session data with the specified key ,if not exist ,return null.
     */
    <K, V> V getData(K key);

    /**
     * Remove session data with the specified key.
     */
    <K> void removeData(K key);
}
