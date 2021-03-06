package com.icinfo.dataicinfo.domain.plugin;

/**
 * 描述:  Plugin-Reader参数基类<br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public abstract class PluginReaderParameter extends PluginParameter{
    /**
     * 是否需要dump fetch到的数据
     */
    private boolean dump = false;

    /**
     * Reader关联的mediaSource的id
     */
    private Long mediaSourceId;

    /**
     * 是否同步ddl操作(主要针对关系型数据库)
     */
    private boolean ddlSync = true;

    public boolean isDump() {
        return dump;
    }

    public void setDump(boolean dump) {
        this.dump = dump;
    }

    public Long getMediaSourceId() {
        return mediaSourceId;
    }

    public void setMediaSourceId(Long mediaSourceId) {
        this.mediaSourceId = mediaSourceId;
    }

    public boolean isDdlSync() {
        return ddlSync;
    }

    public void setDdlSync(boolean ddlSync) {
        this.ddlSync = ddlSync;
    }
}
