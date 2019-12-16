package com.icinfo.dataicinfo.worker.api.util.statistic;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月16
 */
public class Statistic {
    public String toJsonString(){
        return JSONObject.toJSONString(this,true);
    }
}
