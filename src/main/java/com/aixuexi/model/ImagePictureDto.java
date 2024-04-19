package com.aixuexi.model;

import lombok.Data;

/**
 * @Author zengfeiyang
 * @Date: 2022-04-01 17:17
 * @Description
 */
@Data
public class ImagePictureDto {
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 资源位ID
     */
    private Long positionId;
    /**
     * 图片上传至文件服务器id
     */
    private String fileUniqueId;
    /**
     * 图片跳转链接地址
     */
    private String targetUrl;
    /**
     * 图片名称
     */
    private String name;
    /**
     * 图片大小
     */
    private String size;



}
