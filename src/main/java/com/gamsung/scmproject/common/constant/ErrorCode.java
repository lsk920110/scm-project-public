package com.gamsung.scmproject.common.constant;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {
    SUCCESS("0000", "message.success"),
    LOGIN_FAILED("0001","message.login_failed"),

    ETC("9999", "message.etc");

    private ErrorCode(String code, String key) {
        this.code = code;
        this.message = key;
    }
    public static Map<String, ErrorCode> getErrorCodeMap() {
        return map;
    }

    public static ErrorCode findByCode(String i) {
        return map.get(i);
    }


    private final String code;
    private final String message;
    private static final Map<String, ErrorCode> map;

    static {
        map = new HashMap<String, ErrorCode>();
        for (ErrorCode v : ErrorCode.values()) {
            map.put(v.code, v);
        }
    }
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return code + ": " + message;
    }
}
