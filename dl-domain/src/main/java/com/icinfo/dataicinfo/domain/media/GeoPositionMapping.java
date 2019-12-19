package com.icinfo.dataicinfo.domain.media;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public class GeoPositionMapping {
    //名称
    private String columnName;
    //经度
    private String lonColumnName;
    //维度
    private String latColumnName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getLonColumnName() {
        return lonColumnName;
    }

    public void setLonColumnName(String lonColumnName) {
        this.lonColumnName = lonColumnName;
    }

    public String getLatColumnName() {
        return latColumnName;
    }

    public void setLatColumnName(String latColumnName) {
        this.latColumnName = latColumnName;
    }
}
