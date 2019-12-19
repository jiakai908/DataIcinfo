package com.icinfo.dataicinfo.domain.media;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public enum  ColumnMappingMode {
    NONE, INCLUDE, EXCLUDE;
    public boolean isNone() {
        return this == NONE;
    }

    public boolean isInclude() {
        return this == INCLUDE;
    }

    public boolean isExclude() {
        return this == EXCLUDE;
    }
}
