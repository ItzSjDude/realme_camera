package com.oplus.camera.p172ui.preview;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.preview.CameraTimeView;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;

/* compiled from: VideoRecordingTimeUI.java */
/* renamed from: com.oplus.camera.ui.preview.ae */
/* loaded from: classes2.dex */
public class VideoRecordingTimeUI {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f21642a;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21652k;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RelativeLayout f21643b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21644c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f21645d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f21646e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f21647f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CameraTimeView f21648g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CameraTimeView f21649h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private long f21650i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private long f21651j = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f21653l = 0;

    public VideoRecordingTimeUI(Activity activity) {
        this.f21642a = null;
        this.f21652k = 0;
        this.f21642a = activity;
        this.f21652k = activity.getResources().getDimensionPixelSize(R.dimen.movie_time_margin_top);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m23037e(boolean z) throws Resources.NotFoundException {
        this.f21643b = (RelativeLayout) this.f21642a.findViewById(R.id_renamed.camera);
        if (this.f21643b == null) {
            return;
        }
        PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f21642a.findViewById(R.id_renamed.frame_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        LayoutInflater layoutInflater = this.f21642a.getLayoutInflater();
        if (this.f21648g == null) {
            this.f21648g = (CameraTimeView) layoutInflater.inflate(R.layout.record_time, (ViewGroup) null);
            this.f21643b.addView(this.f21648g);
            this.f21648g.m22097a(false, this.f21644c, top, height, m23038f(z));
        }
        this.f21648g.setScreenLayoutMode(this.f21653l);
        if (this.f21645d && this.f21649h == null) {
            this.f21649h = (CameraTimeView) layoutInflater.inflate(R.layout.record_time, (ViewGroup) null);
            this.f21643b.addView(this.f21649h);
            this.f21648g.setScreenLayoutMode(this.f21653l);
            this.f21648g.measure(Util.getScreenWidth(), Util.getScreenWidth());
            this.f21649h.m22097a(this.f21645d, this.f21644c, top, height, (this.f21648g.getMeasuredWidth() - this.f21648g.getBlinkRecordIconWidth()) / 2);
            this.f21649h.measure(Util.getScreenWidth(), Util.getScreenWidth());
            this.f21648g.m22092a((-this.f21649h.getMeasuredWidth()) / 2);
            if (180 == this.f21647f) {
                this.f21648g.m22092a(this.f21649h.getMeasuredWidth() / 2);
                this.f21649h.m22092a((this.f21648g.getBlinkRecordIconWidth() - this.f21648g.getMeasuredWidth()) / 2);
            } else {
                this.f21648g.m22092a((-this.f21649h.getMeasuredWidth()) / 2);
                this.f21649h.m22092a((this.f21648g.getMeasuredWidth() - this.f21648g.getBlinkRecordIconWidth()) / 2);
            }
            CameraTimeView.InterfaceC3375a interfaceC3375a = new CameraTimeView.InterfaceC3375a() { // from class: com.oplus.camera.ui.preview.ae.1
                @Override // com.oplus.camera.p172ui.preview.CameraTimeView.InterfaceC3375a
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo22103a(int OplusGLSurfaceView_13) {
                    if (VideoRecordingTimeUI.this.f21649h != null) {
                        VideoRecordingTimeUI.this.f21649h.m22092a((OplusGLSurfaceView_13 - VideoRecordingTimeUI.this.f21648g.getBlinkRecordIconWidth()) / 2);
                    }
                }
            };
            CameraTimeView.InterfaceC3375a interfaceC3375a2 = new CameraTimeView.InterfaceC3375a() { // from class: com.oplus.camera.ui.preview.ae.2
                @Override // com.oplus.camera.p172ui.preview.CameraTimeView.InterfaceC3375a
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo22103a(int OplusGLSurfaceView_13) {
                    if (VideoRecordingTimeUI.this.f21648g != null) {
                        VideoRecordingTimeUI.this.f21648g.m22092a((-OplusGLSurfaceView_13) / 2);
                    }
                }
            };
            this.f21648g.setCameraTimeListener(interfaceC3375a);
            this.f21649h.setCameraTimeListener(interfaceC3375a2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23048a() {
        CameraTimeView cameraTimeView = this.f21648g;
        if (cameraTimeView != null) {
            return cameraTimeView.getVisibility() == 0;
        }
        CameraTimeView cameraTimeView2 = this.f21649h;
        return cameraTimeView2 != null && cameraTimeView2.getVisibility() == 0;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m23039l() {
        this.f21643b = (RelativeLayout) this.f21642a.findViewById(R.id_renamed.camera);
        if (this.f21643b == null) {
            return;
        }
        CameraTimeView cameraTimeView = this.f21648g;
        if (cameraTimeView != null) {
            cameraTimeView.m22100c();
            this.f21643b.removeView(this.f21648g);
            this.f21648g = null;
        }
        CameraTimeView cameraTimeView2 = this.f21649h;
        if (cameraTimeView2 != null) {
            cameraTimeView2.m22100c();
            this.f21643b.removeView(this.f21649h);
            this.f21649h = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23041a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        m23042a(OplusGLSurfaceView_13, i2, z, z2, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23042a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        m23040a(OplusGLSurfaceView_13, i2, this.f21647f, z, z2, z3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23040a(int OplusGLSurfaceView_13, int i2, int i3, boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        this.f21644c = OplusGLSurfaceView_13;
        this.f21645d = z;
        this.f21647f = i3;
        m23039l();
        m23037e(z2);
        CameraTimeView cameraTimeView = this.f21649h;
        if (cameraTimeView != null) {
            cameraTimeView.m22093a(OplusGLSurfaceView_13, i2, i3, z2, z3);
        }
        CameraTimeView cameraTimeView2 = this.f21648g;
        if (cameraTimeView2 != null) {
            cameraTimeView2.m22093a(OplusGLSurfaceView_13, i2, i3, z2, z3);
        }
        CameraLog.m12967f("VideoRecordingTimeUI", "CameraTest Video Shutter Timing Start");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23049b() {
        this.f21650i = 0L;
        this.f21651j = 0L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23046a(boolean z) {
        m23047a(z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23047a(boolean z, boolean z2) {
        CameraTimeView cameraTimeView = this.f21649h;
        if (cameraTimeView != null) {
            cameraTimeView.m22098a(z, z2);
        }
        CameraTimeView cameraTimeView2 = this.f21648g;
        if (cameraTimeView2 != null) {
            cameraTimeView2.m22098a(z, z2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23050b(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        if (this.f21647f == i2) {
            return;
        }
        this.f21647f = i2;
        CameraTimeView cameraTimeView = this.f21648g;
        if (cameraTimeView != null && cameraTimeView.getVisibility() == 0 && !this.f21648g.m22101d()) {
            m23042a(this.f21644c, OplusGLSurfaceView_13, this.f21645d, z, z2);
        }
        m23043a(this.f21650i, this.f21651j, false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m23052c() {
        return this.f21647f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23054d() {
        CameraLog.m12954a("VideoRecordingTimeUI", "onPause");
        CameraTimeView cameraTimeView = this.f21649h;
        if (cameraTimeView != null) {
            cameraTimeView.clearAnimation();
            this.f21649h.setVisibility(8);
        }
        CameraTimeView cameraTimeView2 = this.f21648g;
        if (cameraTimeView2 != null) {
            cameraTimeView2.clearAnimation();
            this.f21648g.setVisibility(8);
        }
        m23039l();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m23056e() {
        return this.f21644c;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m23057f() {
        return this.f21645d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23051b(boolean z) {
        CameraTimeView cameraTimeView = this.f21648g;
        if (cameraTimeView != null) {
            cameraTimeView.m22096a(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m23058g() {
        m23043a(this.f21650i, this.f21651j, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23044a(long OplusGLSurfaceView_15, long j2, boolean z, boolean z2, long j3) {
        this.f21650i = OplusGLSurfaceView_15;
        this.f21651j = j2;
        CameraTimeView cameraTimeView = this.f21648g;
        if (cameraTimeView != null) {
            if (!z2) {
                cameraTimeView.m22094a(OplusGLSurfaceView_15, z);
            } else {
                long j4 = j3 - OplusGLSurfaceView_15;
                if (300 >= j4) {
                    j4 = 0;
                }
                cameraTimeView.m22095a(j4, z, true);
            }
        }
        CameraTimeView cameraTimeView2 = this.f21649h;
        if (cameraTimeView2 != null) {
            cameraTimeView2.m22094a(j2, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23043a(long OplusGLSurfaceView_15, long j2, boolean z) {
        m23044a(OplusGLSurfaceView_15, j2, z, false, 0L);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m23059h() {
        CameraTimeView cameraTimeView = this.f21648g;
        return cameraTimeView != null && cameraTimeView.m22102e();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m23060i() {
        this.f21642a = null;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public int m23061j() {
        CameraTimeView cameraTimeView = this.f21648g;
        if (cameraTimeView == null) {
            return 0;
        }
        cameraTimeView.measure(Util.getScreenWidth(), Util.getScreenWidth());
        return this.f21648g.getMeasuredWidth();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m23062k() {
        CameraTimeView cameraTimeView = this.f21648g;
        return cameraTimeView != null && cameraTimeView.getVisibility() == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23053c(boolean z) {
        this.f21648g.m22092a(m23038f(z));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23055d(boolean z) {
        this.f21646e = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int m23038f(boolean z) {
        if (this.f21642a == null) {
            return 0;
        }
        int iM23061j = (m23061j() / 2) + this.f21652k;
        if (this.f21646e && z) {
            return iM23061j;
        }
        CameraTimeView cameraTimeView = this.f21649h;
        if (cameraTimeView == null || !this.f21645d) {
            return 0;
        }
        if (180 == this.f21647f) {
            return cameraTimeView.getMeasuredWidth() / 2;
        }
        return (-cameraTimeView.getMeasuredWidth()) / 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23045a(BaseScreenMode abstractC2934a) throws Resources.NotFoundException {
        this.f21653l = abstractC2934a.mo16539j();
        m23042a(abstractC2934a.mo16494a(this.f21642a, this.f21644c), 0, this.f21645d, false, false);
    }
}
