package com.icinfo.dataicinfo.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public abstract class Position implements Serializable {
    private static final long serialVersionUID = -6657206423434207280L;
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
