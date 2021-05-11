package com.aixuexi.util;

public enum EnumUser {
    /** 用户角色:非管理员普通用户 */
    COMMONUSER("0", "非管理员普通用户"),

    /** 用户角色：机构管理员 */
    ECOMPMANAGER("1", "机构管理员"),

    /** 用户角色：集团管理员 */
    GROUPMANAGER("2", "集团管理员"),

    /** 用户角色：集团管理员 */
    DEPTMANAGER("3", "部门管理员")
    ;



    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private EnumUser(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EnumUser getEnum(String value) {

        for (EnumUser enumValue : EnumUser.values()) {
            if (enumValue.getCode().equals(value))
                return enumValue;
        }

        return null;
    }

    public static String[] getCodes() {
        EnumUser[] values = EnumUser.values();
        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i].getCode();
        }
        return result;
    }
}
