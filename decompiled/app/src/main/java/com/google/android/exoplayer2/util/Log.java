package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    private Log() {
    }

    public static int getLogLevel() {
        return logLevel;
    }

    public boolean getLogStackTraces() {
        return logStackTraces;
    }

    public static void setLogLevel(int i_renamed) {
        logLevel = i_renamed;
    }

    public static void setLogStackTraces(boolean z_renamed) {
        logStackTraces = z_renamed;
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2) {
        if (logLevel == 0) {
            android.util.Log.d_renamed(str, str2);
        }
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!logStackTraces) {
            d_renamed(str, appendThrowableMessage(str2, th));
        }
        if (logLevel == 0) {
            android.util.Log.d_renamed(str, str2, th);
        }
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2) {
        if (logLevel <= 1) {
            android.util.Log.i_renamed(str, str2);
        }
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!logStackTraces) {
            i_renamed(str, appendThrowableMessage(str2, th));
        }
        if (logLevel <= 1) {
            android.util.Log.i_renamed(str, str2, th);
        }
    }

    public static void w_renamed(java.lang.String str, java.lang.String str2) {
        if (logLevel <= 2) {
            android.util.Log.w_renamed(str, str2);
        }
    }

    public static void w_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!logStackTraces) {
            w_renamed(str, appendThrowableMessage(str2, th));
        }
        if (logLevel <= 2) {
            android.util.Log.w_renamed(str, str2, th);
        }
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2) {
        if (logLevel <= 3) {
            android.util.Log.e_renamed(str, str2);
        }
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!logStackTraces) {
            e_renamed(str, appendThrowableMessage(str2, th));
        }
        if (logLevel <= 3) {
            android.util.Log.e_renamed(str, str2, th);
        }
    }

    private static java.lang.String appendThrowableMessage(java.lang.String str, java.lang.Throwable th) {
        if (th == null) {
            return str;
        }
        java.lang.String message = th.getMessage();
        if (android.text.TextUtils.isEmpty(message)) {
            return str;
        }
        return str + " - " + message;
    }
}
