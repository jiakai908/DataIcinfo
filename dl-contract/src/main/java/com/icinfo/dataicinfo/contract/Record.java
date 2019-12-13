package com.icinfo.dataicinfo.contract;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public abstract class Record<T> implements Serializable {

    private Map<String,Object> metaData = new HashMap<>();

    public abstract T getId();

    public Map<String,Object> metaData(){
        return metaData;
    }

    public abstract RSI RSI();
}
