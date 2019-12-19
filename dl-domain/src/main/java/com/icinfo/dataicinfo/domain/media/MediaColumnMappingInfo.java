package com.icinfo.dataicinfo.domain.media;

import com.icinfo.dataicinfo.domain.Storable;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
@Alias("mediaColumnMapping")
public class MediaColumnMappingInfo implements Serializable, Storable {
    private Long id;
    private String sourceColumn;
    private String targetColumn;
    private Long mediaMappingId;
    private Date createTime;
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceColumn() {
        return sourceColumn;
    }

    public void setSourceColumn(String sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    public String getTargetColumn() {
        return targetColumn;
    }

    public void setTargetColumn(String targetColumn) {
        this.targetColumn = targetColumn;
    }

    public Long getMediaMappingId() {
        return mediaMappingId;
    }

    public void setMediaMappingId(Long mediaMappingId) {
        this.mediaMappingId = mediaMappingId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
