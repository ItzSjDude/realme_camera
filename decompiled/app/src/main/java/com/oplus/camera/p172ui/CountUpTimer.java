package com.oplus.camera.p172ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.camera.CameraLog;

/* compiled from: CountUpTimer.java */
/* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class CountUpTimer {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f18684a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f18685b = 1000;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f18686c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraUIInterface f18687d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Handler f18688e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f18689f;

    /* compiled from: CountUpTimer.java */
    /* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12535a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12536a(boolean z);
    }

    public CountUpTimer(CameraUIInterface cameraUIInterface, PlatformImplementations.kt_3 aVar) {
        this.f18687d = null;
        this.f18688e = null;
        this.f18689f = null;
        this.f18687d = cameraUIInterface;
        this.f18689f = aVar;
        this.f18688e = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.OplusGLSurfaceView_13.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 1) {
                    CountUpTimer.this.f18689f.mo12535a();
                    return;
                }
                if (OplusGLSurfaceView_13 == 2) {
                    CountUpTimer.this.f18689f.mo12536a(false);
                    CountUpTimer.this.f18686c = false;
                } else {
                    if (OplusGLSurfaceView_13 != 3) {
                        return;
                    }
                    CountUpTimer.this.f18689f.mo12536a(true);
                    CountUpTimer.this.f18686c = false;
                }
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20110a() {
        CameraLog.m12954a("CountUpTimer", "stop");
        this.f18686c = false;
        this.f18688e.removeMessages(1);
        this.f18688e.sendEmptyMessage(3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m20109a(long OplusGLSurfaceView_15) {
        this.f18684a = OplusGLSurfaceView_15;
        return OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long m20111b() {
        return this.f18684a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20113c() {
        CameraLog.m12954a("CountUpTimer", TtmlNode.START);
        this.f18686c = true;
        m20109a(0L);
        this.f18687d.mo18168b(m20111b());
        this.f18688e.sendEmptyMessageDelayed(1, this.f18685b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20112b(long OplusGLSurfaceView_15) {
        this.f18685b = OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m20114d() {
        return this.f18686c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20115e() {
        m20109a(this.f18684a + this.f18685b);
        CameraLog.m12954a("CountUpTimer", "updateTime, mTotalTime: " + this.f18684a);
        this.f18687d.mo18168b(m20111b());
        this.f18688e.sendEmptyMessageDelayed(1, this.f18685b);
    }
}
