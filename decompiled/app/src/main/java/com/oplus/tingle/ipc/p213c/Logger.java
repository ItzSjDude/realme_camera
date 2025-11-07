package com.oplus.tingle.ipc.p213c;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import com.oplus.tingle.Constants_2;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Logger.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class Logger {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f24153a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static AtomicBoolean f24154b = new AtomicBoolean(false);

    /* compiled from: Logger.java */
    /* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends ContentObserver {
        private PlatformImplementations.kt_3(Handler handler) {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            boolean unused = Logger.f24153a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25511a(Context context) {
        if (f24154b.getAndSet(true)) {
            return;
        }
        if (context != null && context.getContentResolver() != null) {
            if (Constants_2.m25461d().equals(context.getPackageName())) {
                context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new PlatformImplementations.kt_3(null));
            }
            f24153a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
            return;
        }
        f24153a = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25512a(String str, String str2, Object... objArr) {
        if (f24153a) {
            Log.IntrinsicsJvm.kt_5("Tingle->" + str, m25510a(str2, objArr));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25514b(String str, String str2, Object... objArr) {
        Log.COUIBaseListPopupWindow_8("Tingle->" + str, m25510a(str2, objArr));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m25510a(String str, Object[] objArr) {
        return (str == null || objArr == null || objArr.length <= 0) ? str : String.format(str, objArr);
    }
}
