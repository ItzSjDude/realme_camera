package com.oplus.epona.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;

/* loaded from: classes2.dex */
public class Logger {
    private static final String TAG = "Epona->";
    public static boolean sDEBUG = SystemProperties.getBoolean("persist.sys.assert.panic", false);

    private static class LoggerObserver extends ContentObserver {
        private LoggerObserver(Handler handler) {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            Logger.sDEBUG = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void init(Context context) {
        if (context == null || context.getContentResolver() == null || !"com.oplus.appplatform".equals(context.getPackageName())) {
            return;
        }
        context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new LoggerObserver(null));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m24999d(String str, String str2, Object... objArr) {
        if (sDEBUG) {
            Log.IntrinsicsJvm.kt_5(TAG + str, formatMessage(str2, objArr));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25000e(String str, String str2, Object... objArr) {
        if (sDEBUG) {
            Log.COUIBaseListPopupWindow_8(TAG + str, formatMessage(str2, objArr));
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m25001i(String str, String str2, Object... objArr) {
        if (sDEBUG) {
            Log.OplusGLSurfaceView_13(TAG + str, formatMessage(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m25002w(String str, String str2, Object... objArr) {
        if (sDEBUG) {
            Log.w(TAG + str, formatMessage(str2, objArr));
        }
    }

    private static String formatMessage(String str, Object[] objArr) {
        return (str == null || objArr == null || objArr.length <= 0) ? "" : String.format(str, objArr);
    }
}
