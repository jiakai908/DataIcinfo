package com.icinfo.dataicinfo.biz.com.icinfo.dataicinfo.biz.service;

import com.icinfo.dataicinfo.domain.media.MediaMappingInfo;

import java.util.List;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public interface MediaService {

    /**
     * 通过Record的namespace和mediaName，获取某个Task下的MediaMapping集合
     */
    List<MediaMappingInfo> getMediaMappingsByMedia(Long taskId, String namespace, String mediaName, boolean justValid);
}
