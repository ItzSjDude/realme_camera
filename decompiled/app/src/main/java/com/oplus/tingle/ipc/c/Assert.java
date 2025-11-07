package com.oplus.tingle.ipc.c_renamed;

/* compiled from: Logger.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f7753a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.concurrent.atomic.AtomicBoolean f7754b = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* compiled from: Logger.java */
    /* renamed from: com.oplus.tingle.ipc.c_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class Logger_2 extends android.database.ContentObserver {
        private Logger_2(android.os.Handler handler) {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z_renamed, android.net.Uri uri) {
            boolean unused = com.oplus.tingle.ipc.c_renamed.a_renamed.f7753a = android.os.SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.content.Context context) {
        if (f7754b.getAndSet(true)) {
            return;
        }
        if (context != null && context.getContentResolver() != null) {
            if (com.oplus.tingle.a_renamed.d_renamed().equals(context.getPackageName())) {
                context.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("log_switch_type"), false, new com.oplus.tingle.ipc.c_renamed.a_renamed.Logger_2(null));
            }
            f7753a = android.os.SystemProperties.getBoolean("persist.sys.assert.panic", false);
            return;
        }
        f7753a = false;
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (f7753a) {
            android.util.Log.d_renamed("Tingle->" + str, a_renamed(str2, objArr));
        }
    }

    public static void b_renamed(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        android.util.Log.e_renamed("Tingle->" + str, a_renamed(str2, objArr));
    }

    private static java.lang.String a_renamed(java.lang.String str, java.lang.Object[] objArr) {
        return (str == null || objArr == null || objArr.length <= 0) ? str : java.lang.String.format(str, objArr);
    }
}
