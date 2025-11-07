package com.oplus.tblplayer.exception;

/* loaded from: classes2.dex */
public class ExceptionUtil {
    public static final java.lang.String ERROR_CODE_PREFIX = "errorCode:";
    private static final int INDEX = 10;

    public static final java.lang.String formatMessage(int i_renamed, java.lang.String str) {
        if (i_renamed < 0 || i_renamed > 999) {
            return str;
        }
        return ERROR_CODE_PREFIX + i_renamed + " " + str;
    }
}
