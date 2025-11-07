package com.google.android.exoplayer2.util;

import android.text.TextUtils;

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

    public static void setLogLevel(int OplusGLSurfaceView_13) {
        logLevel = OplusGLSurfaceView_13;
    }

    public static void setLogStackTraces(boolean z) {
        logStackTraces = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m8318d(String str, String str2) {
        if (logLevel == 0) {
            android.util.Log.IntrinsicsJvm.kt_5(str, str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m8319d(String str, String str2, Throwable th) {
        if (!logStackTraces) {
            m8318d(str, appendThrowableMessage(str2, th));
        }
        if (logLevel == 0) {
            android.util.Log.IntrinsicsJvm.kt_5(str, str2, th);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m8322i(String str, String str2) {
        if (logLevel <= 1) {
            android.util.Log.OplusGLSurfaceView_13(str, str2);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m8323i(String str, String str2, Throwable th) {
        if (!logStackTraces) {
            m8322i(str, appendThrowableMessage(str2, th));
        }
        if (logLevel <= 1) {
            android.util.Log.OplusGLSurfaceView_13(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m8324w(String str, String str2) {
        if (logLevel <= 2) {
            android.util.Log.w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m8325w(String str, String str2, Throwable th) {
        if (!logStackTraces) {
            m8324w(str, appendThrowableMessage(str2, th));
        }
        if (logLevel <= 2) {
            android.util.Log.w(str, str2, th);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m8320e(String str, String str2) {
        if (logLevel <= 3) {
            android.util.Log.COUIBaseListPopupWindow_8(str, str2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m8321e(String str, String str2, Throwable th) {
        if (!logStackTraces) {
            m8320e(str, appendThrowableMessage(str2, th));
        }
        if (logLevel <= 3) {
            android.util.Log.COUIBaseListPopupWindow_8(str, str2, th);
        }
    }

    private static String appendThrowableMessage(String str, Throwable th) {
        if (th == null) {
            return str;
        }
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return str;
        }
        return str + " - " + message;
    }
}
