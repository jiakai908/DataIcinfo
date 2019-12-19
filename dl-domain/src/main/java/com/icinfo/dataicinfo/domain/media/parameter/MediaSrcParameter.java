package com.icinfo.dataicinfo.domain.media.parameter;

import com.icinfo.dataicinfo.domain.Parameter;
import com.icinfo.dataicinfo.domain.media.MediaSourceType;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public abstract class MediaSrcParameter extends Parameter {

    private MediaSourceType mediaSourceType;
    private String namespace;

    public MediaSourceType getMediaSourceType() {
        return mediaSourceType;
    }

    public void setMediaSourceType(MediaSourceType mediaSourceType) {
        this.mediaSourceType = mediaSourceType;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
