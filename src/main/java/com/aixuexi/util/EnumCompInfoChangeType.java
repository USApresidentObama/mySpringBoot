package com.aixuexi.util;

public enum EnumCompInfoChangeType {
    COMP_INDUSTRYS_CHANGE("1", "企业行业变更"),
    COMP_SCALE_CHANGE("2", "企业规模变更"),
    COMP_STAGE_CHANGE("3", "融资阶段变更"),
    COMP_STOCK_TYPE_CHANGE("4", "股票市场变更"),
    COMP_FULL_NAME_CHANGE("5", "企业工商名变更"),
    COMP_DESC_CHANGE("6", "企业介绍变更");

    private String code;
    private String name;

    private EnumCompInfoChangeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EnumCompInfoChangeType getEnum(String code) {
        for (EnumCompInfoChangeType enumValue : EnumCompInfoChangeType.values()) {
            if (enumValue.getCode().equals(code)) {
                return enumValue;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
