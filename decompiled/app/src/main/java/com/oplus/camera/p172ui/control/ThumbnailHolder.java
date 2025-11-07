package com.oplus.camera.p172ui.control;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oplus.camera.util.Util;

/* compiled from: ThumbnailHolder.java */
/* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class ThumbnailHolder {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Thumbnail f18302a;

    /* compiled from: ThumbnailHolder.java */
    /* renamed from: com.oplus.camera.ui.control.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final HandlerThread f18303a = new HandlerThread("ClearThumbnail");

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static final Handler f18304b;

        static {
            f18303a.start();
            f18304b = new Handler(f18303a.getLooper(), new Handler.Callback() { // from class: com.oplus.camera.ui.control.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message.what == 1) {
                        ThumbnailHolder.m19300a();
                    }
                    return true;
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized Thumbnail m19299a(ContentResolver contentResolver) {
        if (f18302a != null) {
            PlatformImplementations.kt_3.f18304b.removeMessages(1);
            Thumbnail c3203e = f18302a;
            f18302a = null;
            if (Util.m24290a(c3203e.m19291e(), contentResolver)) {
                return c3203e;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized void m19300a() {
        PlatformImplementations.kt_3.f18304b.removeMessages(1);
        f18302a = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized void m19301a(Thumbnail c3203e) {
        f18302a = c3203e;
        PlatformImplementations.kt_3.f18304b.removeMessages(1);
        PlatformImplementations.kt_3.f18304b.sendEmptyMessageDelayed(1, 3000L);
    }
}
