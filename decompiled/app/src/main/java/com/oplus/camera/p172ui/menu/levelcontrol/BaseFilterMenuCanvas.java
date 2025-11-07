package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.opengl.GLES20;
import co.polarr.renderer.entities.DrawingItem;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p172ui.preview.p177a.AbstractFilterSdk;
import com.oplus.camera.p172ui.preview.p177a.AncFilterSdk;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.PolarrFilterSdk;
import com.oplus.camera.util.Util;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseFilterMenuCanvas.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseFilterMenuCanvas {

    /* renamed from: C */
    private float f19570C;

    /* renamed from: w */
    private PolarrFilterSdk f19593w;

    /* renamed from: x */
    private AncFilterSdk f19594x;

    /* renamed from: y */
    private boolean f19595y = false;

    /* renamed from: z */
    private float f19596z = 0.0f;

    /* renamed from: A */
    private FilterTexturePreview.PlatformImplementations.kt_3 f19568A = FilterTexturePreview.PlatformImplementations.kt_3.Polarr;

    /* renamed from: PlatformImplementations.kt_3 */
    protected int f19571a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f19572b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f19573c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f19574d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected float f19575e = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected float f19576f = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected float f19577g = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected float f19578h = 1.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    protected ArrayList<Integer> f19579i = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_15 */
    protected ArrayList<FloatBuffer> f19580j = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_5 */
    protected ArrayList<FloatBuffer> f19581k = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_14 */
    protected ArrayList<FloatBuffer> f19582l = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_6 */
    protected float f19583m = 1.0f;

    /* renamed from: OplusGLSurfaceView_11 */
    protected float f19584n = 1.0f;

    /* renamed from: o */
    protected int f19585o = -1;

    /* renamed from: p */
    protected int f19586p = -1;

    /* renamed from: q */
    protected float[] f19587q = {0.0f, 0.0f};

    /* renamed from: r */
    protected float f19588r = 1.0f;

    /* renamed from: s */
    protected float f19589s = 1.0f;

    /* renamed from: t */
    protected float f19590t = 0.0f;

    /* renamed from: u */
    protected float f19591u = 0.0f;

    /* renamed from: B */
    private float f19569B = 0.0f;

    /* renamed from: v */
    protected float[] f19592v = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20785a(float COUIBaseListPopupWindow_12, float f2, float f3, int OplusGLSurfaceView_13, float f4, float f5, boolean z, GLModelParam c3284i) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20790a(GLModelParam c3284i) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo20797b(Context context);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo20799c(int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo20801d(int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract void mo20802e(int OplusGLSurfaceView_13, int i2);

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract void mo20804f(int OplusGLSurfaceView_13, int i2);

    public BaseFilterMenuCanvas() {
        this.f19593w = null;
        this.f19594x = null;
        this.f19570C = 0.0f;
        this.f19593w = new PolarrFilterSdk();
        this.f19594x = new AncFilterSdk();
        this.f19570C = Util.m24456h(R.dimen.filter_selector_thickness);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private AbstractFilterSdk m20781f() {
        if (FilterTexturePreview.PlatformImplementations.kt_3.Polarr == this.f19568A) {
            return this.f19593w;
        }
        return this.f19594x;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20791a(FilterTexturePreview.PlatformImplementations.kt_3 aVar) {
        this.f19568A = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20787a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("BaseFilterMenuCanvas", "setSize, width = " + OplusGLSurfaceView_13 + ", height = " + i2);
        float[] fArr = this.f19587q;
        fArr[0] = (float) OplusGLSurfaceView_13;
        fArr[1] = (float) i2;
        this.f19571a = OplusGLSurfaceView_13;
        this.f19572b = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20783a(float COUIBaseListPopupWindow_12) {
        this.f19596z = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20782a() {
        ArrayList<Integer> arrayList = this.f19579i;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<FloatBuffer> arrayList2 = this.f19580j;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<FloatBuffer> arrayList3 = this.f19581k;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        ArrayList<FloatBuffer> arrayList4 = this.f19582l;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m20794b() {
        ArrayList<FloatBuffer> arrayList = this.f19580j;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20789a(Context context) {
        this.f19595y = true;
        this.f19593w.m22773a(context, 2, 2);
        if (CameraConfig.isSupportMicroscope() && CameraConfig.isSupportMicroscopeFilter()) {
            this.f19594x.m22496a(context, 2, 2);
        }
        this.f19595y = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20796b(int OplusGLSurfaceView_13, int i2) {
        PolarrFilterSdk c3422s = this.f19593w;
        if (c3422s != null) {
            c3422s.m22772a(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20798c() {
        if (this.f19593w != null) {
            CameraLog.m12954a("BaseFilterMenuCanvas", "destroyFilterEngine mPolarrRender");
            this.f19593w.mo22245e();
            GLES20Canvas.m14010i();
            CameraLog.m12954a("BaseFilterMenuCanvas", "destroyFilterEngine mPolarrRender X");
        }
        if (this.f19594x != null) {
            CameraLog.m12954a("BaseFilterMenuCanvas", "destroyFilterEngine mAncFilterSdk");
            this.f19594x.mo22245e();
            GLES20Canvas.m14010i();
            CameraLog.m12954a("BaseFilterMenuCanvas", "destroyFilterEngine mAncFilterSdk X");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20800d() {
        PolarrFilterSdk c3422s = this.f19593w;
        if (c3422s != null) {
            c3422s.m22774f();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m20793a(int OplusGLSurfaceView_13, int i2, List<DrawingItem> list, float COUIBaseListPopupWindow_12) {
        if (list == null) {
            return false;
        }
        GLES20.glDisable(3042);
        m20781f().mo22239a(list, OplusGLSurfaceView_13, i2, this.f19596z, COUIBaseListPopupWindow_12);
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m20803e() {
        return m20781f() != null && m20781f().mo22240a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20788a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CameraLog.m12959b("BaseFilterMenuCanvas", "setTextureSize: width = " + OplusGLSurfaceView_13 + ", height = " + i2);
        this.f19573c = OplusGLSurfaceView_13;
        this.f19574d = i2;
        if ((1 == i4 && i3 != 0) || 4 == i4) {
            if (this.f19572b > 0) {
                this.f19584n = this.f19573c / this.f19571a;
            }
            if (this.f19571a > 0) {
                this.f19583m = this.f19574d / this.f19572b;
                return;
            }
            return;
        }
        int i5 = this.f19572b;
        if (i5 > 0) {
            this.f19583m = this.f19573c / i5;
        }
        int i6 = this.f19571a;
        if (i6 > 0) {
            this.f19584n = this.f19574d / i6;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20795b(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = this.f19571a;
        if (OplusGLSurfaceView_13 > 0) {
            this.f19575e = COUIBaseListPopupWindow_12 / OplusGLSurfaceView_13;
        }
        int i2 = this.f19572b;
        if (i2 > 0) {
            this.f19576f = COUIBaseListPopupWindow_12 / i2;
        }
        this.f19569B = COUIBaseListPopupWindow_12;
        this.f19588r = this.f19571a > this.f19572b ? this.f19576f : this.f19575e;
        this.f19589s = this.f19570C / (COUIBaseListPopupWindow_12 / 2.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20784a(float COUIBaseListPopupWindow_12, float f2) {
        int OplusGLSurfaceView_13 = this.f19571a;
        if (OplusGLSurfaceView_13 > 0) {
            this.f19577g = COUIBaseListPopupWindow_12 / (OplusGLSurfaceView_13 / 2.0f);
            this.f19590t = COUIBaseListPopupWindow_12 / (this.f19569B / 2.0f);
        }
        int i2 = this.f19572b;
        if (i2 > 0) {
            this.f19578h = f2 / (i2 / 2.0f);
            this.f19591u = f2 / (this.f19569B / 2.0f);
        }
        CameraLog.m12959b("BaseFilterMenuCanvas", "setSelectorPosition, x: " + COUIBaseListPopupWindow_12 + ", y: " + f2 + ", mSelectorOffsetX: " + this.f19577g + ", mSelectorOffsetY: " + this.f19578h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20786a(int OplusGLSurfaceView_13) {
        this.f19586p = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20792a(float[] fArr) {
        this.f19592v = fArr;
    }
}
