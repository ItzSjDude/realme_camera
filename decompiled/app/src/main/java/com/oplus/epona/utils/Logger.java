package com.oplus.epona.utils;

/* loaded from: classes2.dex */
public class Logger {
    private static final java.lang.String TAG = "Epona->";
    public static boolean sDEBUG = android.os.SystemProperties.getBoolean("persist.sys.assert.panic", false);

    private static class LoggerObserver extends android.database.ContentObserver {
        private LoggerObserver(android.os.Handler handler) {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z_renamed, android.net.Uri uri) {
            com.oplus.epona.utils.Logger.sDEBUG = android.os.SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void init(android.content.Context context) {
        if (context == null || context.getContentResolver() == null || !"com.oplus.appplatform".equals(context.getPackageName())) {
            return;
        }
        context.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("log_switch_type"), false, new com.oplus.epona.utils.Logger.LoggerObserver(null));
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sDEBUG) {
            android.util.Log.d_renamed(TAG + str, formatMessage(str2, objArr));
        }
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sDEBUG) {
            android.util.Log.e_renamed(TAG + str, formatMessage(str2, objArr));
        }
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sDEBUG) {
            android.util.Log.i_renamed(TAG + str, formatMessage(str2, objArr));
        }
    }

    public static void w_renamed(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sDEBUG) {
            android.util.Log.w_renamed(TAG + str, formatMessage(str2, objArr));
        }
    }

    private static java.lang.String formatMessage(java.lang.String str, java.lang.Object[] objArr) {
        return (str == null || objArr == null || objArr.length <= 0) ? "" : java.lang.String.format(str, objArr);
    }
}
