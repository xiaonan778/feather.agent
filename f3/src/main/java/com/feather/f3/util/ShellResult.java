package com.feather.f3.util;

import java.util.HashMap;

public class ShellResult extends HashMap<String, Object> {

    private static final long serialVersionUID = -4803724090820231421L;

    protected static final String KW_KEY_CODE = "code";
    protected static final String KW_KEY_MSG = "message";

    public static final int CODE_SUCCESS = 0;

    public static final int CODE_ERROR = 1;

    public ShellResult(int status, String message) {
        this.put(KW_KEY_CODE, status);
        this.put(KW_KEY_MSG, message);
    }

    public int getCode() {
        return (Integer) this.get(KW_KEY_CODE);
    }

    public String getMessage() {
        return (String) this.get(KW_KEY_MSG);
    }

    public void addObject(String key, Object value) {
        this.put(key, value);
    }

    public void removeObject(String key) {
        this.remove(key);
    }

}
