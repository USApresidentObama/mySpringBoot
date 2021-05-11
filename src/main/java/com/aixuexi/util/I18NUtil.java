package com.aixuexi.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NUtil {
    /** 简历信息中文资源化配置 */
    private static ResourceBundle ZH_RESOURCE = ResourceBundle.getBundle("resume", Locale.CHINESE);
    /** 简历信息英文资源化配置 */
    private static ResourceBundle EN_RESOURCE = ResourceBundle.getBundle("resume", Locale.ENGLISH);

    private static I18NUtil zhUtil = new I18NUtil(ZH_RESOURCE);
    private static I18NUtil enUtil = new I18NUtil(EN_RESOURCE);

    private final ResourceBundle resourceBundle;

    private I18NUtil(ResourceBundle _resourceBundle) {
        this.resourceBundle = _resourceBundle;
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static I18NUtil getInstance() {
        return  enUtil;
    }

    /**
     * 获取标签文本
     *
     * @param key
     * @return
     */
    public String getLable(String key) {
        try {
            return this.resourceBundle.getString(key);
        } catch (Exception e) {
            return "";
        }
    }
}
