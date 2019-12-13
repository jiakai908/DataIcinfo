package com.icinfo.dataicinfo.domain;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public abstract class Parameter implements Serializable {
    public String toJsonString(){
        return JSONObject.toJSONString(this, SerializerFeature.WriteClassName);
    }

    public static String listToJsonString(List list) {
        return JSONObject.toJSONString(list, SerializerFeature.WriteClassName);
    }
}
