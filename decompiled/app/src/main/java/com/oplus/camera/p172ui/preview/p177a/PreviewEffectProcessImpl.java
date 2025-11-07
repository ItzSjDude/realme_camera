package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.renderscript.Matrix4f;
import android.util.Size;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.doubleexposure.DecodeVideoRequest;
import com.oplus.camera.p146gl.BasicTexture;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLRootView;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p146gl.p148b.OesDrawerEngine;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.tiltshift.TiltShiftParam;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PreviewEffectProcessImpl.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u */
/* loaded from: classes2.dex */
public class PreviewEffectProcessImpl implements PreviewEffectProcess {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float[] f21473g;

    /* renamed from: OplusGLSurfaceView_5 */
    private TexturePreviewRequest f21477k;

    /* renamed from: OplusGLSurfaceView_14 */
    private HashMap<Integer, TexturePreview> f21478l;

    /* renamed from: PlatformImplementations.kt_3 */
    private volatile boolean f21467a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private volatile boolean f21468b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private volatile boolean f21469c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21470d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f21471e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float[] f21472f = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private GLRootView f21474h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private PreviewEffectProcess.PlatformImplementations.kt_3 f21475i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private SurfaceTextureScreenNail f21476j = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private ConcurrentHashMap<Integer, Boolean> f21479m = new ConcurrentHashMap<>();

    /* renamed from: OplusGLSurfaceView_11 */
    private List<Long> f21480n = new ArrayList();

    /* renamed from: o */
    private TexturePreview.IntrinsicsJvm.kt_4 f21481o = new TexturePreview.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.1
        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo22930a(String str) {
            if (PreviewEffectProcessImpl.this.f21475i != null) {
                PreviewEffectProcessImpl.this.f21475i.mo10426b(str);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo22926a() {
            if (PreviewEffectProcessImpl.this.f21475i != null) {
                PreviewEffectProcessImpl.this.f21475i.mo10425b();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Rect[] mo22931b() {
            if (PreviewEffectProcessImpl.this.f21475i != null) {
                return PreviewEffectProcessImpl.this.f21475i.mo10424a();
            }
            return null;
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo22924a(int OplusGLSurfaceView_13, int i2) {
            if (PreviewEffectProcessImpl.this.f21475i != null) {
                return PreviewEffectProcessImpl.this.f21475i.mo10418a(OplusGLSurfaceView_13, i2);
            }
            return 0;
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public DetectResult mo22925a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z, long OplusGLSurfaceView_15) {
            if (PreviewEffectProcessImpl.this.f21475i == null) {
                return null;
            }
            PreviewEffectProcessImpl.this.f21475i.mo10419a(OplusGLSurfaceView_13, i2, i3, i4, i5, z, OplusGLSurfaceView_15);
            return null;
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo22929a(DetectResult c3077a) {
            if (PreviewEffectProcessImpl.this.f21475i != null) {
                PreviewEffectProcessImpl.this.f21475i.mo10422a(c3077a);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo22928a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3) {
            if (PreviewEffectProcessImpl.this.f21475i != null) {
                PreviewEffectProcessImpl.this.f21475i.mo10421a(OplusGLSurfaceView_13, i2, z, z2, z3, z4, z5, z6, i3);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo22927a(int OplusGLSurfaceView_13) {
            if (PreviewEffectProcessImpl.this.f21475i != null) {
                PreviewEffectProcessImpl.this.f21475i.mo10420a(OplusGLSurfaceView_13);
            }
        }
    };

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22800a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return false;
    }

    public PreviewEffectProcessImpl(Context context) {
        TexturePreview abstractC3428yM22968a;
        int OplusGLSurfaceView_13 = 0;
        this.f21473g = null;
        this.f21477k = null;
        this.f21478l = null;
        this.f21478l = new HashMap<>();
        while (true) {
            int i2 = (1 << OplusGLSurfaceView_13) & 4095;
            if (i2 != 0 && (abstractC3428yM22968a = TexturePreviewFactory.m22968a(context.getApplicationContext(), i2)) != null) {
                abstractC3428yM22968a.mo22533a(this.f21481o);
                this.f21478l.put(Integer.valueOf(i2), abstractC3428yM22968a);
            }
            int i3 = OplusGLSurfaceView_13 + 1;
            if ((4095 >> OplusGLSurfaceView_13) == 0) {
                this.f21477k = new TexturePreviewRequest();
                Matrix4f matrix4f = new Matrix4f();
                matrix4f.scale(1.0f, -1.0f, 1.0f);
                matrix4f.translate(0.0f, -1.0f, 0.0f);
                this.f21473g = matrix4f.getArray();
                return;
            }
            OplusGLSurfaceView_13 = i3;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22776a() {
        this.f21480n.clear();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22791a(PreviewEffectProcess.PlatformImplementations.kt_3 aVar) {
        this.f21475i = aVar;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22785a(GLRootView gLRootView) {
        this.f21474h = gLRootView;
        Iterator<TexturePreview> it = this.f21478l.values().iterator();
        while (it.hasNext()) {
            it.next().m22964a(gLRootView);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22786a(SurfaceTextureScreenNail abstractC2769t) {
        this.f21476j = abstractC2769t;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22794a(boolean z) {
        synchronized (this) {
            this.f21467a = z;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22790a(FilterTexturePreview.PlatformImplementations.kt_3 aVar) {
        ((FilterTexturePreview) this.f21478l.get(2)).m22658a(aVar);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22793a(String str, int OplusGLSurfaceView_13) {
        Iterator<TexturePreview> it = this.f21478l.values().iterator();
        while (it.hasNext()) {
            it.next().m22965a(str, OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22807b() {
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.2
                @Override // java.lang.Runnable
                public void run() {
                    PreviewEffectProcessImpl c3424u = PreviewEffectProcessImpl.this;
                    c3424u.m22913m(c3424u.mo22845k());
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22779a(int OplusGLSurfaceView_13, int i2) {
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.3
                @Override // java.lang.Runnable
                public void run() {
                    PreviewEffectProcessImpl c3424u = PreviewEffectProcessImpl.this;
                    c3424u.m22913m(c3424u.mo22845k());
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo22833g() {
        this.f21478l.get(8).mo22287c();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22809b(final int OplusGLSurfaceView_13) {
        m22881c(this.f21470d, this.f21471e);
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.4
                @Override // java.lang.Runnable
                public void run() {
                    PreviewEffectProcessImpl.this.m22913m(OplusGLSurfaceView_13);
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22819c(int OplusGLSurfaceView_13) {
        final int iMo22845k = mo22845k();
        CameraLog.m12954a("PreviewEffectProcessImpl", "destroyEngine, type: " + OplusGLSurfaceView_13);
        final int i2 = 16;
        final int i3 = 0;
        if (OplusGLSurfaceView_13 == 0) {
            i2 = 1463;
        } else if (OplusGLSurfaceView_13 == 1) {
            i3 = 16;
            i2 = 1430;
        } else if (OplusGLSurfaceView_13 != 2) {
            i2 = 0;
        }
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.5
                @Override // java.lang.Runnable
                public void run() {
                    for (Map.Entry entry : PreviewEffectProcessImpl.this.f21478l.entrySet()) {
                        if ((i2 & ((Integer) entry.getKey()).intValue()) != 0 && ((i3 & ((Integer) entry.getKey()).intValue()) == 0 || (i3 & iMo22845k) != 0)) {
                            ((TexturePreview) entry.getValue()).mo22290e();
                        }
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22802a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        boolean zBooleanValue = this.f21479m.containsKey(2) ? this.f21479m.get(2).booleanValue() : false;
        boolean zBooleanValue2 = this.f21479m.containsKey(4) ? this.f21479m.get(4).booleanValue() : false;
        boolean zBooleanValue3 = this.f21479m.containsKey(8) ? this.f21479m.get(8).booleanValue() : false;
        boolean zBooleanValue4 = this.f21479m.containsKey(16) ? this.f21479m.get(16).booleanValue() : false;
        boolean zBooleanValue5 = this.f21479m.containsKey(32) ? this.f21479m.get(32).booleanValue() : false;
        boolean zBooleanValue6 = this.f21479m.containsKey(1024) ? this.f21479m.get(1024).booleanValue() : false;
        boolean zMo22283a = this.f21478l.get(128).mo22283a(mo22845k());
        boolean zMo22283a2 = this.f21478l.get(256).mo22283a(mo22845k());
        boolean zMo22283a3 = this.f21478l.get(512).mo22283a(mo22845k());
        TexturePreview abstractC3428y = this.f21478l.get(16);
        boolean z = abstractC3428y != null && abstractC3428y.mo22282a();
        boolean z2 = zBooleanValue5 && this.f21478l.get(32).mo22428y();
        if (zBooleanValue4 && z) {
            m22894f(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            return true;
        }
        if (zBooleanValue3) {
            m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            return true;
        }
        if (zMo22283a) {
            return m22874a(interfaceC2757h, c2756g, this.f21473g, this.f21472f, OplusGLSurfaceView_13, i2, i3, i4, z2, zBooleanValue, zBooleanValue2, zMo22283a2, zMo22283a3, zBooleanValue6, i5);
        }
        if (zBooleanValue) {
            m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            return true;
        }
        if (z2) {
            return m22897g(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        if (zMo22283a3) {
            m22900h(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            return true;
        }
        if (zBooleanValue2 && !zMo22283a2) {
            m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            return true;
        }
        if (zMo22283a2) {
            return m22903i(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        if (zBooleanValue6) {
            return m22909k(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22801a(GLCanvas interfaceC2757h, OesDrawerEngine c2749f, RawTexture c2768s, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        if (this.f21478l.get(128).mo22283a(mo22845k())) {
            return m22875a(interfaceC2757h, c2768s, this.f21472f, OplusGLSurfaceView_13, i2, i3, i4, i5);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_15 */
    public TexturePreview mo22843j(int OplusGLSurfaceView_13) {
        return this.f21478l.get(Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22803a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, CameraApsResult cameraApsResult, boolean z) {
        boolean zM22911k;
        boolean z2;
        int iMo22845k = mo22845k();
        boolean zMo22283a = this.f21478l.get(1).mo22673a_(iMo22845k) ? this.f21478l.get(1).mo22283a(iMo22845k) : false;
        boolean zMo22283a2 = this.f21478l.get(2).mo22673a_(iMo22845k) ? this.f21478l.get(2).mo22283a(iMo22845k) : false;
        boolean zMo22283a3 = this.f21478l.get(4).mo22673a_(iMo22845k) ? this.f21478l.get(4).mo22283a(iMo22845k) : false;
        boolean zMo22283a4 = (this.f21478l.get(8) == null || !this.f21478l.get(8).mo22673a_(iMo22845k)) ? false : this.f21478l.get(8).mo22283a(iMo22845k);
        boolean zMo22283a5 = (this.f21478l.get(16) == null || !this.f21478l.get(16).mo22673a_(iMo22845k)) ? false : this.f21478l.get(16).mo22283a(iMo22845k);
        boolean zMo22283a6 = this.f21478l.get(32).mo22673a_(iMo22845k) ? this.f21478l.get(32).mo22283a(iMo22845k) : false;
        boolean zMo22283a7 = this.f21478l.get(512).mo22673a_(iMo22845k) ? this.f21478l.get(512).mo22283a(iMo22845k) : false;
        boolean zMo22283a8 = (this.f21478l.get(64) == null || !this.f21478l.get(64).mo22673a_(iMo22845k)) ? false : this.f21478l.get(64).mo22283a(iMo22845k);
        boolean zMo22283a9 = this.f21478l.get(256).mo22673a_(iMo22845k) ? this.f21478l.get(256).mo22283a(iMo22845k) : false;
        boolean zMo22283a10 = this.f21478l.get(1024).mo22673a_(iMo22845k) ? this.f21478l.get(1024).mo22283a(iMo22845k) : false;
        boolean zMo22283a11 = this.f21478l.get(2048).mo22673a_(iMo22845k) ? this.f21478l.get(2048).mo22283a(iMo22845k) : false;
        this.f21479m.put(2, Boolean.valueOf(zMo22283a2));
        this.f21479m.put(4, Boolean.valueOf(zMo22283a3));
        this.f21479m.put(8, Boolean.valueOf(zMo22283a4));
        this.f21479m.put(16, Boolean.valueOf(zMo22283a5));
        this.f21479m.put(32, Boolean.valueOf(zMo22283a6));
        this.f21479m.put(512, Boolean.valueOf(zMo22283a7));
        if (zMo22283a10 || zMo22283a || zMo22283a2 || zMo22283a4 || zMo22283a5 || zMo22283a3 || zMo22283a6 || zMo22283a8 || zMo22283a9 || zMo22283a7 || zMo22283a11) {
            if (zMo22283a10) {
                zM22911k = m22868a(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, cameraApsResult);
            } else if (zMo22283a5) {
                zM22911k = m22877b(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a11) {
                if (zMo22283a2) {
                    zM22911k = m22915n(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
                } else {
                    zM22911k = m22914m(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
                }
            } else if (zMo22283a && !zMo22283a2 && !zMo22283a4 && !zMo22283a3) {
                zM22911k = m22866a(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a && !zMo22283a2 && zMo22283a4) {
                zM22911k = m22883c(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a && zMo22283a2 && !zMo22283a4 && !zMo22283a3) {
                zM22911k = m22898g(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a && zMo22283a2 && zMo22283a4) {
                zM22911k = m22888d(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a && !zMo22283a2 && !zMo22283a4 && zMo22283a3) {
                zM22911k = m22879b(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (zMo22283a && zMo22283a2 && !zMo22283a4 && zMo22283a3) {
                zM22911k = m22884c(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (!zMo22283a && zMo22283a2 && !zMo22283a4 && !zMo22283a3 && !zMo22283a6 && !zMo22283a7) {
                zM22911k = m22869a(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, z || mo22849l());
            } else if (!zMo22283a && zMo22283a2 && zMo22283a4 && !zMo22283a3) {
                zM22911k = m22892e(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (!zMo22283a && !zMo22283a2 && zMo22283a4 && !zMo22283a3) {
                zM22911k = m22895f(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (!zMo22283a && !zMo22283a7 && !zMo22283a2 && !zMo22283a4 && zMo22283a3 && !zMo22283a6 && !zMo22283a9) {
                zM22911k = m22867a(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (!zMo22283a && zMo22283a2 && !zMo22283a4 && zMo22283a3 && !zMo22283a6 && !zMo22283a7) {
                zM22911k = m22889d(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (!zMo22283a && !zMo22283a2 && zMo22283a4 && zMo22283a3) {
                zM22911k = m22893e(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (!zMo22283a && zMo22283a2 && zMo22283a4 && zMo22283a3) {
                zM22911k = m22896f(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (zMo22283a7 && !zMo22283a2 && !zMo22283a3) {
                zM22911k = m22907j(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a7 && zMo22283a2 && !zMo22283a3) {
                zM22911k = m22910k(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a7 && !zMo22283a2 && zMo22283a3) {
                zM22911k = m22902h(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (zMo22283a7 && zMo22283a2 && zMo22283a3) {
                zM22911k = m22908j(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (zMo22283a6 && !zMo22283a2 && !zMo22283a3) {
                zM22911k = m22904i(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a6 && zMo22283a2 && !zMo22283a3) {
                zM22911k = m22916o(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (zMo22283a6 && !zMo22283a2 && zMo22283a3) {
                zM22911k = m22899g(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (zMo22283a6 && zMo22283a2 && zMo22283a3) {
                zM22911k = m22905i(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
            } else if (zMo22283a8) {
                zM22911k = m22878b(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            } else if (!zMo22283a9 || zMo22283a6 || zMo22283a3) {
                if (zMo22283a9 && !zMo22283a6 && zMo22283a3) {
                    zM22911k = m22911k(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
                }
                z2 = false;
            } else {
                zM22911k = m22917p(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            }
            z2 = zM22911k;
        } else {
            z2 = false;
        }
        if (!z2 && !c2756g.m13956t()) {
            if (z || mo22849l()) {
                interfaceC2757h.mo13974a((BasicTexture) c2756g, this.f21472f, OplusGLSurfaceView_13, i2, i3, i4, true);
            } else {
                interfaceC2757h.mo13973a(c2756g, this.f21472f, OplusGLSurfaceView_13, i2, i3, i4);
            }
        }
        int i6 = (zMo22283a ? 1 : 0) | (zMo22283a2 ? 2 : 0) | (zMo22283a3 ? 4 : 0) | (zMo22283a4 ? 8 : 0) | (zMo22283a5 ? 16 : 0) | (zMo22283a6 ? 32 : 0) | (zMo22283a7 ? 512 : 0) | (zMo22283a8 ? 64 : 0) | (zMo22283a9 ? 256 : 0) | (zMo22283a10 ? 1024 : 0);
        c2756g.m13952a(z2 ? i6 : 0);
        this.f21480n.add(Long.valueOf(c2756g.m13940k()));
        c2756g.m13926a((this.f21480n.size() > m22921l(i6) ? this.f21480n.remove(0) : this.f21480n.get(0)).longValue());
        return !c2756g.m13956t();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22804a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z) {
        int iMo22845k = mo22845k();
        boolean zBooleanValue = this.f21479m.containsKey(2) ? this.f21479m.get(2).booleanValue() : false;
        boolean zBooleanValue2 = this.f21479m.containsKey(4) ? this.f21479m.get(4).booleanValue() : false;
        boolean zBooleanValue3 = this.f21479m.containsKey(8) ? this.f21479m.get(8).booleanValue() : false;
        boolean zBooleanValue4 = this.f21479m.containsKey(16) ? this.f21479m.get(16).booleanValue() : false;
        boolean zBooleanValue5 = this.f21479m.containsKey(32) ? this.f21479m.get(32).booleanValue() : false;
        this.f21478l.get(128).mo22283a(mo22845k());
        boolean zMo22283a = this.f21478l.get(256).mo22283a(mo22845k());
        boolean z2 = zBooleanValue5 && this.f21478l.get(32).mo22428y();
        boolean zMo22673a_ = this.f21478l.get(1).mo22673a_(iMo22845k);
        if (zBooleanValue4) {
            if (z) {
                m22894f(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            }
            return true;
        }
        if (zBooleanValue3) {
            if (z) {
                m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
            }
            return true;
        }
        if (zBooleanValue) {
            if (z) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
            return true;
        }
        if (zMo22673a_) {
            if (z) {
                if (this.f21478l.get(1).mo22283a(iMo22845k)) {
                    m22891e(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
                } else {
                    interfaceC2757h.mo13973a(c2756g, this.f21472f, OplusGLSurfaceView_13, i2, i3, i4);
                }
            }
            return true;
        }
        if (z2) {
            if (z) {
                return m22897g(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        } else {
            if (zBooleanValue2 && !zMo22283a) {
                if (z) {
                    m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
                }
                return true;
            }
            if (zMo22283a && z) {
                return m22903i(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo22815b(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        int iMo22845k = mo22845k();
        if (this.f21478l.get(4).mo22673a_(iMo22845k) ? this.f21478l.get(4).mo22283a(iMo22845k) : false) {
            return m22867a(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g, i5);
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public RawTexture mo22775a(GLCanvas interfaceC2757h, ExtTexture c2756g, RawTexture c2768s, boolean z) {
        RawTexture c2768sM22859a;
        int iM13955s = c2756g.m13955s();
        CameraLog.m12954a("PreviewEffectProcessImpl", "captureEffectPreview, flag: " + Integer.toBinaryString(iM13955s) + "IntrinsicsJvm.kt_4");
        if ((iM13955s & 16) != 0) {
            c2768sM22859a = m22860a(interfaceC2757h, this.f21478l.get(16).mo22292g(), c2768s, this.f21473g, !Util.m24169C());
        } else if ((iM13955s & 8) != 0) {
            c2768sM22859a = m22860a(interfaceC2757h, this.f21478l.get(8).mo22292g(), c2768s, this.f21473g, !Util.m24169C());
        } else if ((iM13955s & 2) == 0 || this.f21478l.get(2).mo22292g() == null || !this.f21478l.get(2).mo22292g().m13943n()) {
            if ((iM13955s & 1) == 0 || this.f21478l.get(1).mo22292g() == null || !this.f21478l.get(1).mo22292g().m13943n()) {
                if ((iM13955s & 4) == 0 || this.f21478l.get(4).mo22292g() == null || !this.f21478l.get(4).mo22292g().m13943n()) {
                    c2768sM22859a = m22859a(interfaceC2757h, c2756g, c2768s, (float[]) null);
                } else if (z) {
                    c2768sM22859a = m22858a(interfaceC2757h, 4, c2768s);
                } else {
                    c2768sM22859a = m22860a(interfaceC2757h, this.f21478l.get(4).mo22292g(), c2768s, (float[]) null, !Util.m24169C());
                }
            } else if (z) {
                c2768sM22859a = m22858a(interfaceC2757h, 1, c2768s);
            } else {
                c2768sM22859a = m22860a(interfaceC2757h, this.f21478l.get(1).mo22292g(), c2768s, (float[]) null, !Util.m24169C());
            }
        } else if (z) {
            c2768sM22859a = m22858a(interfaceC2757h, 2, c2768s);
        } else {
            c2768sM22859a = m22860a(interfaceC2757h, this.f21478l.get(2).mo22292g(), c2768s, (float[]) null, !Util.m24169C());
        }
        c2768sM22859a.m13926a(c2756g.m13939j());
        c2768sM22859a.m13930b(c2756g.m13940k());
        return c2768sM22859a;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22799a(ExtTexture c2756g, RawTexture c2768s) {
        int iM13955s = c2756g.m13955s();
        if ((iM13955s & 16) != 0 || (iM13955s & 8) != 0) {
            return false;
        }
        if ((iM13955s & 2) != 0 && this.f21478l.get(2).mo22292g() != null && this.f21478l.get(2).mo22292g().m13943n()) {
            return this.f21478l.get(2).mo22292g().m14192a(c2768s);
        }
        if ((iM13955s & 1) != 0 && this.f21478l.get(1).mo22292g() != null && this.f21478l.get(1).mo22292g().m13943n()) {
            return this.f21478l.get(1).mo22292g().m14192a(c2768s);
        }
        if ((iM13955s & 4) == 0 || this.f21478l.get(4).mo22292g() == null || !this.f21478l.get(4).mo22292g().m13943n()) {
            return false;
        }
        return this.f21478l.get(4).mo22292g().m14192a(c2768s);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22817c() {
        if (this.f21478l.get(8) != null) {
            this.f21478l.get(8).mo22958m();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22822d() {
        if (this.f21478l.get(8) != null) {
            this.f21478l.get(8).mo22959n();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo22832f() {
        return this.f21478l.get(8).mo22283a(mo22845k()) || this.f21478l.get(16).mo22283a(mo22845k());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo22829e() {
        if (this.f21478l.get(8) != null) {
            if (this.f21478l.get(8).mo22283a(mo22845k())) {
                this.f21478l.get(8).mo22293h();
            } else {
                this.f21478l.get(8).mo22960o();
                this.f21478l.get(8).mo22961p();
            }
        }
        if (this.f21478l.get(16) == null) {
            return false;
        }
        if (m22918u()) {
            this.f21478l.get(16).mo22281a(this.f21477k);
            this.f21478l.get(16).mo22293h();
            return false;
        }
        this.f21478l.get(16).mo22290e();
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22782a(Size size, boolean z) {
        for (TexturePreview abstractC3428y : this.f21478l.values()) {
            int iMo22845k = mo22845k();
            if (abstractC3428y.mo22673a_(iMo22845k) && abstractC3428y.mo22283a(iMo22845k)) {
                abstractC3428y.mo22523a(size, z);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22780a(long OplusGLSurfaceView_15) {
        for (TexturePreview abstractC3428y : this.f21478l.values()) {
            int iMo22845k = mo22845k();
            if (abstractC3428y.mo22673a_(iMo22845k) && abstractC3428y.mo22283a(iMo22845k)) {
                abstractC3428y.mo22957a(OplusGLSurfaceView_15);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22805a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        TexturePreview abstractC3428y = this.f21478l.get(Integer.valueOf(i3));
        if (abstractC3428y == null || !abstractC3428y.mo22283a(i3)) {
            return false;
        }
        abstractC3428y.mo22524a(bArr, OplusGLSurfaceView_13, i2);
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22806a(byte[] bArr, byte[] bArr2, int OplusGLSurfaceView_13, int i2, int i3) {
        TexturePreview abstractC3428y = this.f21478l.get(Integer.valueOf(i3));
        if (abstractC3428y == null || !abstractC3428y.mo22283a(i3)) {
            return false;
        }
        abstractC3428y.mo22558a(bArr, bArr2, OplusGLSurfaceView_13, i2);
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo22836h() {
        this.f21479m.clear();
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.6
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = PreviewEffectProcessImpl.this.f21478l.values().iterator();
                    while (it.hasNext()) {
                        ((TexturePreview) it.next()).mo22295j();
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22839i() {
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PreviewEffectProcessImpl.this.f21478l != null) {
                        for (TexturePreview abstractC3428y : PreviewEffectProcessImpl.this.f21478l.values()) {
                            abstractC3428y.mo22285b();
                            abstractC3428y.m22964a((GLRootView) null);
                            abstractC3428y.m22966s();
                        }
                    }
                }
            });
            this.f21474h = null;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22810b(int OplusGLSurfaceView_13, int i2) {
        this.f21470d = OplusGLSurfaceView_13;
        this.f21471e = i2;
        m22881c(OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22824d(int OplusGLSurfaceView_13) {
        Iterator<TexturePreview> it = this.f21478l.values().iterator();
        while (it.hasNext()) {
            it.next().mo22286b(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22827e(int OplusGLSurfaceView_13) {
        Iterator<TexturePreview> it = this.f21478l.values().iterator();
        while (it.hasNext()) {
            it.next().mo22457d(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22796a(byte[] bArr) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22359a(bArr);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22811b(long OplusGLSurfaceView_15) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22347a(OplusGLSurfaceView_15);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22797a(float[] fArr) {
        this.f21472f = fArr;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo22830f(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22368c(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22789a(TexturePreviewRequest.IntrinsicsJvm.kt_4 bVar) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22353a(bVar);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22792a(String str) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22363b(str);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22813b(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22384g(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22820c(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22385h(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22812b(String str) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22357a(str);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo22837h(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22362b(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22825d(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22382f(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo22834g(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22346a(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22777a(float COUIBaseListPopupWindow_12) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22345a(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22808b(float COUIBaseListPopupWindow_12) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22361b(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22828e(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22369c(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22818c(float COUIBaseListPopupWindow_12) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22367c(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22788a(TiltShiftParam tiltShiftParam) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22351a(tiltShiftParam);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22787a(StickerItem stickerItem) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22350a(stickerItem);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22798a(int[] iArr) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22370c(iArr);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22783a(BaseSloganUtil.PlatformImplementations.kt_3 aVar) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22349a(aVar);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo22831f(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22390j(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo22835g(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22392k(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_15 */
    public StickerItem mo22842j() {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            return c3397aa.m22398o();
        }
        return null;
    }

    /* renamed from: s */
    public boolean m22922s() {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            return c3397aa.m22401r();
        }
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo22816b(StickerItem stickerItem) {
        if (mo22842j() == null || stickerItem == null || stickerItem.getStickerUUID() == null) {
            return false;
        }
        return stickerItem.getStickerUUID().equals(mo22842j().getStickerUUID());
    }

    /* renamed from: t */
    public boolean m22923t() {
        return mo22842j() != null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22841i(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22358a(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22844j(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22395m(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22840i(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22381f(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo22848l(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22374d(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo22851m(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22379e(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22814b(int[] iArr) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22360a(iArr);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22821c(int[] iArr) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22365b(iArr);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22778a(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22373d(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22781a(Point point) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22348a(point);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo22838h(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22364b(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo22847k(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22387i(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_5 */
    public int mo22845k() {
        PreviewEffectProcess.PlatformImplementations.kt_3 aVar = this.f21475i;
        if (aVar == null) {
            return 0;
        }
        int OplusGLSurfaceView_13 = aVar.mo10423a(CameraFunction.FACE_BLUR) ? 1 : 0;
        if (this.f21475i.mo10423a(CameraUIInterface.KEY_FILTER_PROCESS)) {
            OplusGLSurfaceView_13 |= 2;
        }
        if (this.f21475i.mo10423a(CameraUIInterface.KEY_STICKER_PROCESS)) {
            OplusGLSurfaceView_13 |= 8;
        }
        if (this.f21475i.mo10423a(CameraUIInterface.KEY_OMOJI_PROCESS)) {
            OplusGLSurfaceView_13 |= 16;
        }
        if (this.f21475i.mo10423a(CameraFunction.FACE_SLENDER_PROCESS)) {
            OplusGLSurfaceView_13 |= 4;
        }
        if (this.f21475i.mo10423a(CameraFunction.VIDEO_BLUR_PROCESS)) {
            OplusGLSurfaceView_13 |= 32;
        }
        if (this.f21475i.mo10423a(CameraFunction.SUPER_TEXT_GPU_PROCESS)) {
            OplusGLSurfaceView_13 |= 64;
        }
        if (this.f21475i.mo10423a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            OplusGLSurfaceView_13 |= 128;
        }
        if (this.f21475i.mo10423a(CameraFunction.VIDEO_RETENTION)) {
            OplusGLSurfaceView_13 |= 256;
        }
        if (this.f21475i.mo10423a(CameraFunction.TILT_SHIFT)) {
            OplusGLSurfaceView_13 |= 512;
        }
        if (this.f21475i.mo10423a(CameraFunction.DOUBLE_EXPOSURE)) {
            OplusGLSurfaceView_13 |= 1024;
        }
        return this.f21475i.mo10423a(CameraFunction.FISH_EYE) ? OplusGLSurfaceView_13 | 2048 : OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo22853n(boolean z) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22394l(z);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo22849l() {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            return c3397aa.m22335D();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22823d(float COUIBaseListPopupWindow_12) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22372d(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22826e(float COUIBaseListPopupWindow_12) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22377e(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_6 */
    public float mo22850m() {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            return c3397aa.m22336E();
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_11 */
    public float mo22852n() {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            return c3397aa.m22337F();
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22784a(DecodeVideoRequest c2684c) {
        if (this.f21478l.get(1024) != null) {
            this.f21478l.get(1024).mo22279a(c2684c);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: o */
    public void mo22854o() {
        if (this.f21478l.get(1024) != null) {
            this.f21478l.get(1024).mo22296u();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: p */
    public void mo22855p() {
        if (this.f21478l.get(1024) != null) {
            this.f21478l.get(1024).mo22297v();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: q */
    public void mo22856q() {
        if (this.f21478l.get(1024) != null) {
            this.f21478l.get(1024).mo22298w();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: r */
    public void mo22857r() {
        if (this.f21478l.get(1024) != null) {
            this.f21478l.get(1024).mo22299x();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22795a(boolean z, boolean z2) {
        this.f21468b = z;
        this.f21469c = z2;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public int m22921l(int OplusGLSurfaceView_13) {
        int iMo22560l = (OplusGLSurfaceView_13 & 1) != 0 ? 0 + this.f21478l.get(1).mo22560l() : 0;
        return (OplusGLSurfaceView_13 & 4) != 0 ? iMo22560l + this.f21478l.get(4).mo22560l() : iMo22560l;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo22846k(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa = this.f21477k;
        if (c3397aa != null) {
            c3397aa.m22378e(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: u */
    private boolean m22918u() {
        return m22922s() && m22923t() && 2 == mo22842j().getMaterialType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m22913m(int OplusGLSurfaceView_13) {
        GLRootView gLRootView = this.f21474h;
        if (gLRootView == null || !gLRootView.getSurfaceState()) {
            CameraLog.m12967f("PreviewEffectProcessImpl", "onlyCreateEngines, mGLRootView: " + this.f21474h);
            return;
        }
        synchronized (this) {
            if (!this.f21467a) {
                CameraLog.m12954a("PreviewEffectProcessImpl", "onlyCreateEngines, texture has been released");
                return;
            }
            CameraLog.m12954a("PreviewEffectProcessImpl", "onlyCreateEngines, effectFlag: " + OplusGLSurfaceView_13);
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (Map.Entry<Integer, TexturePreview> entry : this.f21478l.entrySet()) {
                if ((16 & entry.getKey().intValue()) == 0 && entry.getValue().mo22673a_(OplusGLSurfaceView_13) && this.f21477k != null) {
                    entry.getValue().mo22281a(this.f21477k);
                }
            }
            if (this.f21478l.get(16) != null && this.f21477k != null) {
                if ((OplusGLSurfaceView_13 & 16) != 0 && m22918u()) {
                    this.f21478l.get(16).mo22281a(this.f21477k);
                } else {
                    this.f21478l.get(16).mo22290e();
                }
            }
            CameraLog.m12954a("PreviewEffectProcessImpl", "onlyCreateEngines, cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m22881c(int OplusGLSurfaceView_13, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        m22886d(OplusGLSurfaceView_13, i2);
        m22920w();
        m22919v();
        CameraLog.m12954a("PreviewEffectProcessImpl", "updateTextureRes, cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m22886d(int OplusGLSurfaceView_13, int i2) {
        for (TexturePreview abstractC3428y : this.f21478l.values()) {
            if (abstractC3428y.mo22673a_(mo22845k())) {
                abstractC3428y.mo22278a(OplusGLSurfaceView_13, i2);
            }
        }
    }

    /* renamed from: v */
    private void m22919v() {
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.8
                @Override // java.lang.Runnable
                public void run() {
                    for (TexturePreview abstractC3428y : PreviewEffectProcessImpl.this.f21478l.values()) {
                        if (abstractC3428y.mo22673a_(PreviewEffectProcessImpl.this.mo22845k())) {
                            abstractC3428y.mo22427a(true);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: w */
    private void m22920w() {
        GLRootView gLRootView = this.f21474h;
        if (gLRootView != null) {
            gLRootView.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.u.9
                @Override // java.lang.Runnable
                public void run() {
                    for (TexturePreview abstractC3428y : PreviewEffectProcessImpl.this.f21478l.values()) {
                        if (abstractC3428y.mo22673a_(PreviewEffectProcessImpl.this.mo22845k())) {
                            abstractC3428y.mo22295j();
                            abstractC3428y.mo22294i();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RawTexture m22858a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, RawTexture c2768s) {
        RawTexture c2768sMo22292g = this.f21478l.get(Integer.valueOf(OplusGLSurfaceView_13)).mo22292g();
        c2768s.m13925a(c2768sMo22292g.f13967a, c2768sMo22292g.f13968b);
        this.f21478l.get(Integer.valueOf(OplusGLSurfaceView_13)).mo22532a(c2768s);
        if (!c2768s.m13943n()) {
            c2768s.m14193c(interfaceC2757h);
        }
        if (c2768sMo22292g.m14195t() == null) {
            c2768sMo22292g.m14191a(new float[16]);
        }
        this.f21476j.m14235a(c2768sMo22292g.m14195t());
        CameraLog.m12962c("PreviewEffectProcessImpl", "swapTexture, inTexture: " + c2768s.m13934e() + ", outTexture: " + c2768sMo22292g.m13934e());
        return c2768sMo22292g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RawTexture m22859a(GLCanvas interfaceC2757h, BasicTexture abstractC2752c, RawTexture c2768s, float[] fArr) {
        return m22860a(interfaceC2757h, abstractC2752c, c2768s, fArr, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RawTexture m22860a(GLCanvas interfaceC2757h, BasicTexture abstractC2752c, RawTexture c2768s, float[] fArr, boolean z) {
        if (c2768s == null) {
            return null;
        }
        if (!c2768s.m13943n()) {
            c2768s.m14193c(interfaceC2757h);
        }
        int iF = c2768s.mo13935f();
        int iG = c2768s.mo13936g();
        interfaceC2757h.mo13975a(c2768s);
        if (z) {
            GLES20.glFinish();
        }
        interfaceC2757h.mo13959a(0.0f, iG);
        interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
        this.f21476j.m14235a(this.f21472f);
        if (fArr == null) {
            fArr = this.f21472f;
        }
        interfaceC2757h.mo13973a(abstractC2752c, fArr, 0, 0, iF, iG);
        interfaceC2757h.mo13987h();
        return c2768s;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22866a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(1).mo22280a(interfaceC2757h);
        boolean zM22873a = m22873a(interfaceC2757h, c2756g, fArr, false);
        if (zM22873a && !c2756g.m13956t()) {
            m22891e(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        return zM22873a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m22878b(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(64).mo22280a(interfaceC2757h);
        this.f21476j.m14257k();
        this.f21476j.m14235a(this.f21472f);
        return m22901h(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, fArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22869a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, boolean z) {
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, false, false, fArr, (RawTexture) null);
        if (zM22871a && !c2756g.m13956t()) {
            m22863a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f, z);
        }
        return zM22871a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22867a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        if (zM22872a && !c2756g.m13956t()) {
            m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        return zM22872a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22862a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(4).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22874a(GLCanvas interfaceC2757h, ExtTexture c2756g, float[] fArr, float[] fArr2, int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i5) {
        this.f21478l.get(128).mo22280a(interfaceC2757h);
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(128).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        aVarM22967t.f21549c = this.f21478l.get(128).mo22291f();
        aVarM22967t.f21548b = c2756g;
        aVarM22967t.f21555i = fArr2;
        aVarM22967t.f21556j = i3;
        aVarM22967t.f21557k = i4;
        aVarM22967t.f21558l = OplusGLSurfaceView_13;
        aVarM22967t.f21559m = i2;
        aVarM22967t.f21561o = i5;
        if (z2) {
            aVarM22967t.f21549c = this.f21478l.get(2).mo22292g();
        } else if (z && (Float.compare(this.f21477k.m22383g(), 0.0f) != 0 || this.f21477k.m22388i())) {
            aVarM22967t.f21549c = this.f21478l.get(32).mo22292g();
        } else if (z4) {
            aVarM22967t.f21549c = this.f21478l.get(256).mo22292g();
        } else if (z5) {
            aVarM22967t.f21549c = this.f21478l.get(512).mo22292g();
        } else if (z3) {
            aVarM22967t.f21549c = this.f21478l.get(4).mo22292g();
        } else if (z6) {
            aVarM22967t.f21549c = this.f21478l.get(1024).mo22292g();
        } else {
            m22859a(interfaceC2757h, c2756g, this.f21478l.get(128).mo22291f(), fArr);
        }
        return this.f21478l.get(128).mo22284a(aVarM22967t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22875a(GLCanvas interfaceC2757h, RawTexture c2768s, float[] fArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        this.f21478l.get(128).mo22280a(interfaceC2757h);
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(128).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        aVarM22967t.f21549c = c2768s;
        Matrix.setIdentityM(fArr, 0);
        aVarM22967t.f21555i = fArr;
        aVarM22967t.f21556j = i3;
        aVarM22967t.f21557k = i4;
        aVarM22967t.f21558l = OplusGLSurfaceView_13;
        aVarM22967t.f21559m = i2;
        aVarM22967t.f21561o = i5;
        return this.f21478l.get(128).mo22284a(aVarM22967t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22872a(GLCanvas interfaceC2757h, ExtTexture c2756g, float[] fArr, int OplusGLSurfaceView_13) {
        m22859a(interfaceC2757h, c2756g, this.f21478l.get(4).mo22291f(), fArr);
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(4).m22967t();
        aVarM22967t.f21549c = this.f21478l.get(4).mo22291f();
        aVarM22967t.f21560n = OplusGLSurfaceView_13;
        aVarM22967t.f21554h = this.f21469c ? this.f21468b : true;
        return this.f21478l.get(4).mo22284a(aVarM22967t);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m22877b(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        boolean zM22865a = m22865a(interfaceC2757h, i3, i4, fArr);
        if (zM22865a) {
            m22894f(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21473g);
        }
        return zM22865a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m22882c(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(8).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22870a(GLCanvas interfaceC2757h, ExtTexture c2756g, boolean z, boolean z2, boolean z3) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(8).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        aVarM22967t.f21549c = this.f21478l.get(8).mo22291f();
        if (z2) {
            m22859a(interfaceC2757h, this.f21478l.get(2).mo22292g(), this.f21478l.get(8).mo22291f(), (float[]) null);
            return this.f21478l.get(8).mo22284a(aVarM22967t);
        }
        if (z) {
            m22859a(interfaceC2757h, this.f21478l.get(1).mo22292g(), this.f21478l.get(8).mo22291f(), (float[]) null);
            return this.f21478l.get(8).mo22284a(aVarM22967t);
        }
        if (z3) {
            m22859a(interfaceC2757h, this.f21478l.get(4).mo22292g(), this.f21478l.get(8).mo22291f(), (float[]) null);
            return this.f21478l.get(8).mo22284a(aVarM22967t);
        }
        m22859a(interfaceC2757h, c2756g, this.f21478l.get(8).mo22291f(), (float[]) null);
        return this.f21478l.get(8).mo22284a(aVarM22967t);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m22883c(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(1).mo22280a(interfaceC2757h);
        this.f21478l.get(8).mo22280a(interfaceC2757h);
        boolean zM22873a = m22873a(interfaceC2757h, c2756g, fArr, false);
        boolean zM22870a = m22870a(interfaceC2757h, c2756g, zM22873a, false, false);
        if (!c2756g.m13956t()) {
            if (zM22870a) {
                m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
            } else if (zM22873a) {
                m22891e(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
            }
        }
        return zM22870a || zM22873a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m22888d(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(1).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        this.f21478l.get(8).mo22280a(interfaceC2757h);
        boolean zM22873a = m22873a(interfaceC2757h, c2756g, fArr, false);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, zM22873a, false, fArr, this.f21478l.get(1).mo22292g());
        boolean zM22870a = m22870a(interfaceC2757h, c2756g, zM22873a, zM22871a, false);
        if (!c2756g.m13956t()) {
            if (zM22870a) {
                m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
            } else if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22873a) {
                m22891e(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
            }
        }
        return zM22870a || zM22871a || zM22873a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m22892e(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        this.f21478l.get(8).mo22280a(interfaceC2757h);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, false, false, fArr, (RawTexture) null);
        boolean zM22870a = m22870a(interfaceC2757h, c2756g, false, zM22871a, false);
        if (!c2756g.m13956t()) {
            if (zM22870a) {
                m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
            } else if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22870a || zM22871a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m22895f(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(8).mo22280a(interfaceC2757h);
        boolean zM22870a = m22870a(interfaceC2757h, c2756g, false, false, false);
        if (zM22870a && !c2756g.m13956t()) {
            m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
        }
        return zM22870a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m22879b(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(1).mo22280a(interfaceC2757h);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22873a = m22873a(interfaceC2757h, c2756g, fArr, zM22872a);
        if (!c2756g.m13956t()) {
            if (zM22873a) {
                m22891e(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22872a) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22873a || zM22872a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m22884c(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(1).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22873a = m22873a(interfaceC2757h, c2756g, fArr, zM22872a);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, zM22873a, false, fArr, this.f21478l.get(1).mo22292g());
        if (!c2756g.m13956t()) {
            if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22873a) {
                m22891e(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22872a) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22871a || zM22873a || zM22872a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m22889d(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, false, zM22872a, fArr, (RawTexture) null);
        if (!c2756g.m13956t()) {
            if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22872a) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22871a || zM22872a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m22893e(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(8).mo22280a(interfaceC2757h);
        this.f21476j.m14257k();
        this.f21476j.m14235a(this.f21472f);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22870a = m22870a(interfaceC2757h, c2756g, false, false, zM22872a);
        if (!c2756g.m13956t()) {
            if (zM22870a) {
                m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
            } else if (zM22872a) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22870a || zM22872a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m22896f(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        this.f21478l.get(8).mo22280a(interfaceC2757h);
        this.f21476j.m14257k();
        this.f21476j.m14235a(this.f21472f);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, false, zM22872a, fArr, (RawTexture) null);
        boolean zM22870a = m22870a(interfaceC2757h, c2756g, false, zM22871a, zM22872a);
        if (!c2756g.m13956t()) {
            if (zM22870a) {
                m22882c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, fArr);
            } else if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22872a) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22870a || zM22871a || zM22872a;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m22898g(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(1).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        boolean zM22873a = m22873a(interfaceC2757h, c2756g, fArr, false);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, zM22873a, false, fArr, this.f21478l.get(1).mo22292g());
        if (!c2756g.m13956t()) {
            if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22873a) {
                m22891e(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22871a || zM22873a;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m22901h(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(64).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        aVarM22967t.f21556j = i3;
        aVarM22967t.f21557k = i4;
        aVarM22967t.f21548b = c2756g;
        return this.f21478l.get(64).mo22284a(aVarM22967t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22873a(GLCanvas interfaceC2757h, ExtTexture c2756g, float[] fArr, boolean z) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(1).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        if (z) {
            aVarM22967t.f21549c = this.f21478l.get(4).mo22292g();
            return this.f21478l.get(1).mo22284a(aVarM22967t);
        }
        m22859a(interfaceC2757h, c2756g, this.f21478l.get(1).mo22291f(), fArr);
        aVarM22967t.f21549c = this.f21478l.get(1).mo22291f();
        return this.f21478l.get(1).mo22284a(aVarM22967t);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m22880b(GLCanvas interfaceC2757h, ExtTexture c2756g, float[] fArr, boolean z) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(512).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        if (z) {
            aVarM22967t.f21549c = this.f21478l.get(4).mo22292g();
            return this.f21478l.get(512).mo22284a(aVarM22967t);
        }
        m22859a(interfaceC2757h, c2756g, this.f21478l.get(512).mo22291f(), fArr);
        aVarM22967t.f21549c = this.f21478l.get(512).mo22291f();
        return this.f21478l.get(512).mo22284a(aVarM22967t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22871a(GLCanvas interfaceC2757h, ExtTexture c2756g, boolean z, boolean z2, float[] fArr, RawTexture c2768s) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(2).m22967t();
        if (z) {
            aVarM22967t.f21549c = c2768s;
            return this.f21478l.get(2).mo22284a(aVarM22967t);
        }
        if (z2) {
            aVarM22967t.f21549c = this.f21478l.get(4).mo22292g();
            return this.f21478l.get(2).mo22284a(aVarM22967t);
        }
        m22859a(interfaceC2757h, c2756g, this.f21478l.get(2).mo22291f(), fArr);
        aVarM22967t.f21549c = this.f21478l.get(2).mo22291f();
        return this.f21478l.get(2).mo22284a(aVarM22967t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22865a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, float[] fArr) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(16).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        aVarM22967t.f21556j = OplusGLSurfaceView_13;
        aVarM22967t.f21557k = i2;
        return this.f21478l.get(16).mo22284a(aVarM22967t);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m22904i(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(32).mo22280a(interfaceC2757h);
        boolean zM22885c = m22885c(interfaceC2757h, c2756g, fArr, false);
        return zM22885c && ((!zM22885c || c2756g.m13956t()) ? false : m22897g(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f));
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m22907j(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(512).mo22280a(interfaceC2757h);
        boolean zM22880b = m22880b(interfaceC2757h, c2756g, fArr, false);
        if (zM22880b && !c2756g.m13956t()) {
            m22900h(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        return zM22880b;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m22910k(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(512).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        boolean zM22880b = m22880b(interfaceC2757h, c2756g, fArr, false);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, zM22880b, false, fArr, this.f21478l.get(512).mo22292g());
        if (!c2756g.m13956t()) {
            if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22880b) {
                m22900h(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22871a || zM22880b;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m22912l(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        TexturePreview abstractC3428y = this.f21478l.get(2048);
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = abstractC3428y.m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        aVarM22967t.f21555i = fArr;
        return abstractC3428y.mo22284a(aVarM22967t);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean m22914m(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        TexturePreview abstractC3428y = this.f21478l.get(2048);
        abstractC3428y.mo22280a(interfaceC2757h);
        m22859a(interfaceC2757h, c2756g, abstractC3428y.mo22292g(), fArr);
        if (!m22912l(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, fArr)) {
            return false;
        }
        interfaceC2757h.mo13973a(abstractC3428y.mo22292g(), this.f21472f, OplusGLSurfaceView_13, i2, i3, i4);
        return true;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean m22915n(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        TexturePreview abstractC3428y = this.f21478l.get(2);
        TexturePreview abstractC3428y2 = this.f21478l.get(2048);
        abstractC3428y.mo22280a(interfaceC2757h);
        abstractC3428y2.mo22280a(interfaceC2757h);
        if (m22871a(interfaceC2757h, c2756g, false, false, fArr, (RawTexture) null)) {
            m22859a(interfaceC2757h, abstractC3428y.mo22292g(), abstractC3428y2.mo22292g(), fArr);
        } else {
            m22859a(interfaceC2757h, c2756g, abstractC3428y2.mo22292g(), fArr);
        }
        if (!m22912l(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4, fArr)) {
            return false;
        }
        interfaceC2757h.mo13973a(abstractC3428y2.mo22292g(), this.f21472f, OplusGLSurfaceView_13, i2, i3, i4);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m22885c(GLCanvas interfaceC2757h, ExtTexture c2756g, float[] fArr, boolean z) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(32).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        if (z) {
            aVarM22967t.f21549c = this.f21478l.get(4).mo22292g();
        } else {
            m22859a(interfaceC2757h, c2756g, this.f21478l.get(32).mo22291f(), fArr);
            aVarM22967t.f21549c = this.f21478l.get(32).mo22291f();
        }
        return this.f21478l.get(32).mo22284a(aVarM22967t);
    }

    /* renamed from: o */
    private boolean m22916o(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        boolean zM22897g;
        this.f21478l.get(32).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        boolean zM22885c = m22885c(interfaceC2757h, c2756g, fArr, false);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, zM22885c, false, fArr, this.f21478l.get(32).mo22292g());
        if (!zM22871a || c2756g.m13956t()) {
            if (zM22885c) {
                zM22897g = !c2756g.m13956t() ? m22897g(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f) : true;
            }
            return !zM22871a || (zM22885c && zM22897g);
        }
        m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        zM22897g = false;
        if (zM22871a) {
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m22899g(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        boolean zM22897g;
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(32).mo22280a(interfaceC2757h);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22885c = m22885c(interfaceC2757h, c2756g, fArr, zM22872a);
        if (zM22885c) {
            zM22897g = !c2756g.m13956t() ? m22897g(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f) : true;
        } else {
            zM22897g = false;
        }
        if ((!zM22885c || !zM22897g) && zM22872a && !c2756g.m13956t()) {
            m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        return (zM22885c && zM22897g) || zM22872a;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m22902h(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(512).mo22280a(interfaceC2757h);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22880b = m22880b(interfaceC2757h, c2756g, fArr, zM22872a);
        if (!c2756g.m13956t()) {
            if (zM22880b) {
                m22900h(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22872a) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22880b || zM22872a;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m22905i(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        boolean zM22897g;
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(32).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        this.f21476j.m14257k();
        this.f21476j.m14235a(this.f21472f);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22885c = m22885c(interfaceC2757h, c2756g, fArr, zM22872a);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, zM22885c, zM22872a, fArr, this.f21478l.get(32).mo22292g());
        if (zM22871a && !c2756g.m13956t()) {
            m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            zM22897g = false;
        } else {
            if (zM22885c) {
                zM22897g = !c2756g.m13956t() ? m22897g(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f) : true;
            } else {
                zM22897g = false;
            }
            if ((!zM22885c || !zM22897g) && zM22872a && !c2756g.m13956t()) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        if (zM22871a) {
            return true;
        }
        return (zM22885c && zM22897g) || zM22872a;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m22908j(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(512).mo22280a(interfaceC2757h);
        this.f21478l.get(2).mo22280a(interfaceC2757h);
        this.f21476j.m14257k();
        this.f21476j.m14235a(this.f21472f);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22880b = m22880b(interfaceC2757h, c2756g, fArr, zM22872a);
        boolean zM22871a = m22871a(interfaceC2757h, c2756g, zM22880b, zM22872a, fArr, this.f21478l.get(512).mo22292g());
        if (!c2756g.m13956t()) {
            if (zM22871a) {
                m22887d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22880b) {
                m22900h(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            } else if (zM22872a) {
                m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return zM22871a || zM22880b || zM22872a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m22887d(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(2).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22863a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, boolean z) {
        if (z) {
            interfaceC2757h.mo13974a((BasicTexture) this.f21478l.get(2).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4, true);
        } else {
            interfaceC2757h.mo13973a(this.f21478l.get(2).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m22891e(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(1).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m22894f(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(16).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m22897g(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        if (Float.compare(this.f21477k.m22383g(), 0.0f) == 0 && !this.f21477k.m22388i()) {
            return false;
        }
        interfaceC2757h.mo13973a(this.f21478l.get(32).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
        return true;
    }

    /* renamed from: p */
    private boolean m22917p(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        this.f21478l.get(256).mo22280a(interfaceC2757h);
        return c2756g.m13956t() || (m22890d(interfaceC2757h, c2756g, fArr, false) && m22903i(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f));
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m22900h(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(512).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m22911k(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, int i5) {
        boolean zM22903i;
        this.f21478l.get(4).mo22280a(interfaceC2757h);
        this.f21478l.get(256).mo22280a(interfaceC2757h);
        boolean zM22872a = m22872a(interfaceC2757h, c2756g, fArr, i5);
        boolean zM22890d = m22890d(interfaceC2757h, c2756g, fArr, zM22872a);
        if (zM22890d) {
            zM22903i = !c2756g.m13956t() ? m22903i(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f) : true;
        } else {
            zM22903i = false;
        }
        if ((!zM22890d || !zM22903i) && zM22872a && !c2756g.m13956t()) {
            m22862a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
        }
        return (zM22890d && zM22903i) || zM22872a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m22890d(GLCanvas interfaceC2757h, ExtTexture c2756g, float[] fArr, boolean z) {
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(256).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        if (z) {
            aVarM22967t.f21549c = this.f21478l.get(4).mo22292g();
        } else {
            m22859a(interfaceC2757h, c2756g, this.f21478l.get(256).mo22291f(), fArr);
            aVarM22967t.f21549c = this.f21478l.get(256).mo22291f();
        }
        return this.f21478l.get(256).mo22284a(aVarM22967t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22868a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr, CameraApsResult cameraApsResult) {
        this.f21478l.get(1024).mo22280a(interfaceC2757h);
        TexturePreview.PlatformImplementations.kt_3 aVarM22967t = this.f21478l.get(1024).m22967t();
        aVarM22967t.f21547a = interfaceC2757h;
        aVarM22967t.f21556j = i3;
        aVarM22967t.f21557k = i4;
        aVarM22967t.f21551e = cameraApsResult;
        boolean zMo22284a = this.f21478l.get(1024).mo22284a(aVarM22967t);
        this.f21479m.put(1024, Boolean.valueOf(zMo22284a));
        if (!c2756g.m13956t()) {
            if (aVarM22967t.f21552f) {
                interfaceC2757h.mo13973a(aVarM22967t.f21550d, this.f21473g, OplusGLSurfaceView_13, i2, i3, i4);
            } else if (zMo22284a) {
                m22906j(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4, this.f21472f);
            }
        }
        return aVarM22967t.f21552f || zMo22284a;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m22903i(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        if (!this.f21477k.m22386h()) {
            return false;
        }
        interfaceC2757h.mo13973a(this.f21478l.get(256).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
        return true;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m22906j(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(1024).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m22909k(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr) {
        interfaceC2757h.mo13973a(this.f21478l.get(1024).mo22292g(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
        return true;
    }
}
