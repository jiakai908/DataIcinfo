package com.icinfo.dataicinfo.worker.api.task;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.icinfo.dataicinfo.contract.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:  A batch of records with some execution info.<br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public class RecordChunk< R extends Record> {
    /**
     * 待同步数据
     */
    private List<R> records;
    /**
     * 第一条数据的时间，用于计算延迟时间
     */
    private long firstEntryTime;

    /**
     * 有效负载流量，单位：字节
     */
    private long payloadSize;

    /**
     * 元数据，自定义扩展
     */
    private Map<String, Object> metaData;

    public RecordChunk() {
    }

    public RecordChunk(List<R> records, long firstEntryTime, long payloadSize) {
        this.records = Lists.newLinkedList(records);
        this.firstEntryTime = firstEntryTime;
        this.payloadSize = payloadSize;
        this.metaData = new HashMap<>();
    }

    public RecordChunk<R> copyWithoutRecords() {
        RecordChunk<R> result = new RecordChunk<>();
        result.firstEntryTime = this.firstEntryTime;
        result.payloadSize = this.payloadSize;
        result.metaData = Maps.newHashMap(this.metaData);
        result.records = Lists.newLinkedList();
        return result;
    }

    public void merge(R data) {
        this.records.add(data);
    }

    public List<R> getRecords() {
        return records;
    }

    public void setRecords(List<R> records) {
        this.records = records;
    }

    public long getFirstEntryTime() {
        return firstEntryTime;
    }

    public void setFirstEntryTime(long firstEntryTime) {
        this.firstEntryTime = firstEntryTime;
    }

    public long getPayloadSize() {
        return payloadSize;
    }

    public void setPayloadSize(long payloadSize) {
        this.payloadSize = payloadSize;
    }

    @SuppressWarnings("unchecked")
    public <T> T getMetaData(String key) {
        return (T) metaData.get(key);
    }

    public <T> void putMetaData(String key, T value) {
        this.metaData.put(key, value);
    }
}
