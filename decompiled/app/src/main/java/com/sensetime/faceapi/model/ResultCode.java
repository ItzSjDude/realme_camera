package com.sensetime.faceapi.model;

/* loaded from: classes2.dex */
public enum ResultCode {
    OK(0),
    E_INVALIDARG(-1),
    E_HANDLE(-2),
    E_OUTOFMEMORY(-3),
    E_FAIL(-4),
    E_DELNOTFOUND(-5),
    E_INVALID_PIXEL_FORMAT(-6),
    E_FILE_NOT_FOUND(-7),
    E_INVALID_FILE_FORMAT(-8),
    E_FILE_EXPIRE(-9),
    E_INVALID_AUTH(-13),
    E_INVALID_APPID(-14),
    E_AUTH_EXPIRE(-15),
    E_UUID_MISMATCH(-16),
    E_ONLINE_AUTH_CONNECT_FAIL(-17),
    E_ONLINE_AUTH_TIMEOUT(-18),
    E_ONLINE_AUTH_INVALID(-19),
    E_LICENSE_IS_NOT_ACTIVABLE(-20),
    E_ACTIVE_FAIL(-21),
    E_ACTIVE_CODE_INVALID(-22),
    E_UNSUPPORTED(-1000),
    E_MISSLICENSE(-1001),
    E_MULTI_CALLS(-1002);

    private static final java.lang.String DESCRIPTION_E_ACTIVE_CODE_INVALID = "invalid active code";
    private static final java.lang.String DESCRIPTION_E_ACTIVE_FAIL = "license active failed";
    private static final java.lang.String DESCRIPTION_E_AUTH_EXPIRE = "date expired";
    private static final java.lang.String DESCRIPTION_E_DELNOTFOUND = "define not found";
    private static final java.lang.String DESCRIPTION_E_FAIL = "run in_renamed fail inside";
    private static final java.lang.String DESCRIPTION_E_FILE_EXPIRE = "model out of_renamed date";
    private static final java.lang.String DESCRIPTION_E_FILE_NOT_FOUND = "file no found";
    private static final java.lang.String DESCRIPTION_E_HANDLE = "handle Error,may be_renamed cause by_renamed sdk out of_renamed date or model file incorrect";
    private static final java.lang.String DESCRIPTION_E_INVALIDARG = "invalid argument";
    private static final java.lang.String DESCRIPTION_E_INVALID_APPID = "invalid appid";
    private static final java.lang.String DESCRIPTION_E_INVALID_AUTH = "invalid license";
    private static final java.lang.String DESCRIPTION_E_INVALID_FILE_FORMAT = "model format error";
    private static final java.lang.String DESCRIPTION_E_INVALID_PIXEL_FORMAT = "invalid pixel format";
    private static final java.lang.String DESCRIPTION_E_LICENSE_IS_NOT_ACTIVABLE = "invalid active code";
    private static final java.lang.String DESCRIPTION_E_MISSLICENSE = "con't_renamed find license";
    private static final java.lang.String DESCRIPTION_E_MULTI_CALLS = "multi calls init license";
    private static final java.lang.String DESCRIPTION_E_ONLINE_AUTH_CONNECT_FAIL = "online auth connect fail";
    private static final java.lang.String DESCRIPTION_E_ONLINE_AUTH_INVALID = "check online fail";
    private static final java.lang.String DESCRIPTION_E_ONLINE_AUTH_TIMEOUT = "check online timeout";
    private static final java.lang.String DESCRIPTION_E_OUTOFMEMORY = "out of_renamed memory";
    private static final java.lang.String DESCRIPTION_E_UNSUPPORTED = "unsupport function called";
    private static final java.lang.String DESCRIPTION_E_UUID_MISMATCH = "uuid mismatch";
    private static final java.lang.String DESCRIPTION_OK = "OK";
    private final int resultCode;

    public static java.lang.String getDescription(int i_renamed) {
        switch (i_renamed) {
            case -1002:
                break;
            case -1001:
                break;
            case -1000:
                break;
            default:
                switch (i_renamed) {
                    case -22:
                        break;
                    case -21:
                        break;
                    case -20:
                        break;
                    case -19:
                        break;
                    case -18:
                        break;
                    case -17:
                        break;
                    case -16:
                        break;
                    case -15:
                        break;
                    case -14:
                        break;
                    case -13:
                        break;
                    default:
                        switch (i_renamed) {
                        }
                }
        }
        return "invalid active code";
    }

    ResultCode(int i_renamed) {
        this.resultCode = i_renamed;
    }

    public int getValue() {
        return this.resultCode;
    }
}
