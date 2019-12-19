package com.icinfo.dataicinfo.common.errors;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public class RecordNotSupportException extends DatalinkException {
    private Class recordClass;

    public RecordNotSupportException(Class recordClass){
        super(String.format("The record type %s is not support.",recordClass.getCanonicalName()));
    }

    public Class getRecordClass(){
        return recordClass;
    }
}
