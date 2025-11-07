package com.oplus.camera.ui.control;

/* compiled from: ThumbnailHolder.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.ui.control.e_renamed f6064a;

    /* compiled from: ThumbnailHolder.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final android.os.HandlerThread f6065a = new android.os.HandlerThread("ClearThumbnail");

        /* renamed from: b_renamed, reason: collision with root package name */
        public static final android.os.Handler f6066b;

        static {
            f6065a.start();
            f6066b = new android.os.Handler(f6065a.getLooper(), new android.os.Handler.Callback() { // from class: com.oplus.camera.ui.control.g_renamed.a_renamed.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(android.os.Message message) {
                    if (message.what == 1) {
                        com.oplus.camera.ui.control.g_renamed.a_renamed();
                    }
                    return true;
                }
            });
        }
    }

    public static synchronized com.oplus.camera.ui.control.e_renamed a_renamed(android.content.ContentResolver contentResolver) {
        if (f6064a != null) {
            com.oplus.camera.ui.control.g_renamed.a_renamed.f6066b.removeMessages(1);
            com.oplus.camera.ui.control.e_renamed eVar = f6064a;
            f6064a = null;
            if (com.oplus.camera.util.Util.a_renamed(eVar.e_renamed(), contentResolver)) {
                return eVar;
            }
        }
        return null;
    }

    public static synchronized void a_renamed() {
        com.oplus.camera.ui.control.g_renamed.a_renamed.f6066b.removeMessages(1);
        f6064a = null;
    }

    public static synchronized void a_renamed(com.oplus.camera.ui.control.e_renamed eVar) {
        f6064a = eVar;
        com.oplus.camera.ui.control.g_renamed.a_renamed.f6066b.removeMessages(1);
        com.oplus.camera.ui.control.g_renamed.a_renamed.f6066b.sendEmptyMessageDelayed(1, 3000L);
    }
}
