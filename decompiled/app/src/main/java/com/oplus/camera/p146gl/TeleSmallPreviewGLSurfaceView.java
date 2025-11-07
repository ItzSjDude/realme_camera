package com.oplus.camera.p146gl;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Matrix;
import android.hardware.HardwareBuffer;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.renderscript.Matrix4f;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.jni.PreviewShow;
import com.oplus.camera.p146gl.OplusGLSurfaceView;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

/* compiled from: TeleSmallPreviewGLSurfaceView.java */
/* renamed from: com.oplus.camera.gl.u */
/* loaded from: classes2.dex */
public class TeleSmallPreviewGLSurfaceView extends OplusGLSurfaceView implements GLRoot, OplusGLSurfaceView.OplusGLSurfaceView_6 {

    /* renamed from: A */
    private float f14260A;

    /* renamed from: B */
    private float f14261B;

    /* renamed from: C */
    private int f14262C;

    /* renamed from: D */
    private long f14263D;

    /* renamed from: E */
    private int f14264E;

    /* renamed from: F */
    private int f14265F;

    /* renamed from: G */
    private float f14266G;

    /* renamed from: H */
    private int f14267H;

    /* renamed from: I */
    private int f14268I;

    /* renamed from: J */
    private Context f14269J;

    /* renamed from: K */
    private boolean f14270K;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f14271a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ReentrantLock f14272b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Condition f14273c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ArrayList<HardwareBuffer> f14274d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private GLPaint f14275e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private GLPaint f14276f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private GLPaint f14277g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private GLPaint f14278h;

    /* renamed from: OplusGLSurfaceView_13 */
    private GL11 f14279i;

    /* renamed from: OplusGLSurfaceView_15 */
    private GLCanvas f14280j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ExtTexture f14281k;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f14282l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float[] f14283m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f14284n;

    /* renamed from: o */
    private boolean f14285o;

    /* renamed from: p */
    private boolean f14286p;

    /* renamed from: q */
    private boolean f14287q;

    /* renamed from: r */
    private boolean f14288r;

    /* renamed from: s */
    private boolean f14289s;

    /* renamed from: t */
    private boolean f14290t;

    /* renamed from: u */
    private AnimatorSet f14291u;

    /* renamed from: v */
    private Interpolator f14292v;

    /* renamed from: w */
    private long f14293w;

    /* renamed from: x */
    private long f14294x;

    /* renamed from: y */
    private long f14295y;

    /* renamed from: z */
    private long f14296z;

    public int getCompensation() {
        return 0;
    }

    public Matrix getCompensationMatrix() {
        return null;
    }

    public int getDisplayRotation() {
        return 0;
    }

    public void setContentPane(GLView gLView) {
    }

    public void setLightsOutMode(boolean z) {
    }

    public TeleSmallPreviewGLSurfaceView(Context context) {
        this(context, null);
        this.f14269J = context;
    }

    public TeleSmallPreviewGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14271a = new Object();
        this.f14272b = new ReentrantLock();
        this.f14273c = this.f14272b.newCondition();
        this.f14274d = null;
        this.f14275e = null;
        this.f14276f = null;
        this.f14277g = null;
        this.f14278h = null;
        this.f14279i = null;
        this.f14280j = null;
        this.f14281k = null;
        this.f14282l = 0L;
        this.f14283m = new float[16];
        this.f14284n = false;
        this.f14285o = false;
        this.f14286p = false;
        this.f14287q = true;
        this.f14288r = false;
        this.f14289s = false;
        this.f14290t = false;
        this.f14291u = null;
        this.f14292v = null;
        this.f14293w = Long.MAX_VALUE;
        this.f14294x = Long.MAX_VALUE;
        this.f14295y = 0L;
        this.f14296z = 0L;
        this.f14260A = 0.0f;
        this.f14261B = 1.0f;
        this.f14262C = 0;
        this.f14263D = 0L;
        this.f14264E = 0;
        this.f14265F = 0;
        this.f14266G = 0.0f;
        this.f14267H = 0;
        this.f14268I = 0;
        this.f14269J = null;
        this.f14270K = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14268b() {
        setEGLContextClientVersion(2);
        setBackgroundDrawable(null);
        m14130a(8, 8, 8, 8, 8, 8);
        getHolder().setFormat(-3);
        m14131a(this, "TeleSmallPreviewGLThread");
        this.f14282l = PreviewShow.init();
        this.f14274d = new ArrayList<>();
        this.f14278h = new GLPaint();
        setOuterFramePaint(this.f14278h);
        setInnerFramePaint(this.f14278h);
        setLinePaint(this.f14278h);
    }

    public void setOuterFramePaint(GLPaint c2761l) {
        this.f14275e = c2761l;
    }

    public void setInnerFramePaint(GLPaint c2761l) {
        this.f14276f = c2761l;
    }

    public void setLinePaint(GLPaint c2761l) {
        this.f14277g = c2761l;
    }

    public void setFrameDelta(float COUIBaseListPopupWindow_12) {
        this.f14266G = COUIBaseListPopupWindow_12;
        float f2 = this.f14264E;
        float f3 = this.f14266G;
        this.f14267H = (int) (f2 * f3);
        this.f14268I = (int) (this.f14265F * f3);
    }

    public void setTeleSmallPreviewRenderModeDirty(boolean z) {
        if (z) {
            setRenderMode(0);
        } else {
            setRenderMode(1);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m14266a(HardwareBuffer hardwareBuffer) {
        synchronized (this.f14271a) {
            if (this.f14274d == null) {
                hardwareBuffer.close();
                CameraLog.m12959b("TeleSmallPreviewGLSurfaceView", "addFrame, imageList is null");
                return 0;
            }
            if (this.f14274d.size() > 15) {
                this.f14274d.remove(0).close();
            }
            if (hardwareBuffer != null) {
                this.f14274d.add(hardwareBuffer);
            }
            return this.f14274d.size();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14269e() {
        CameraLog.m12959b("TeleSmallPreviewGLSurfaceView", "removeTeleSmallPreviewImage");
        synchronized (this.f14271a) {
            if (this.f14274d == null) {
                return;
            }
            this.f14274d.clear();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14267a(AnimatorSet animatorSet, int OplusGLSurfaceView_13, Interpolator interpolator) {
        if (animatorSet != null) {
            this.f14291u = animatorSet;
            this.f14294x = this.f14291u.getDuration();
            this.f14296z = this.f14291u.getStartDelay();
            this.f14260A = OplusGLSurfaceView_13 == 0 ? 0.0f : 1.0f;
            this.f14261B = OplusGLSurfaceView_13 == 0 ? 1.0f : 0.0f;
        }
        if (interpolator != null) {
            this.f14292v = interpolator;
        }
        CameraLog.m12959b("TeleSmallPreviewGLSurfaceView", "setTeleSmallPreviewAnimation");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14270f() {
        this.f14289s = true;
        this.f14290t = true;
        AnimatorSet animatorSet = this.f14291u;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimationTime.m13866a();
        CameraLog.m12959b("TeleSmallPreviewGLSurfaceView", "startTeleSmallPreviewAnimation");
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13792a(GL10 gl10, EGLConfig eGLConfig) {
        CameraLog.m12962c("TeleSmallPreviewGLSurfaceView", "onSurfaceCreated(GL10 gl1, EGLConfig config)");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11 gl11 = (GL11) gl10;
        if (this.f14279i != null) {
            CameraLog.m12962c("TeleSmallPreviewGLSurfaceView", "GLObject has changed from " + this.f14279i + " to " + gl11);
        }
        this.f14272b.lock();
        try {
            this.f14279i = gl11;
            this.f14280j = new GLES20Canvas();
            this.f14281k = new ExtTexture(this.f14280j, 36197);
            Matrix4f matrix4f = new Matrix4f();
            matrix4f.scale(1.0f, -1.0f, 1.0f);
            matrix4f.translate(0.0f, -1.0f, 0.0f);
            matrix4f.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            matrix4f.translate(0.0f, -1.0f, 0.0f);
            this.f14283m = matrix4f.getArray();
            this.f14272b.unlock();
            if (!this.f14289s) {
                setRenderMode(0);
            }
            this.f14284n = true;
            this.f14285o = false;
        } catch (Throwable th) {
            this.f14272b.unlock();
            throw th;
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13791a(GL10 gl10, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12962c("TeleSmallPreviewGLSurfaceView", "onSurfaceChanged, size: " + OplusGLSurfaceView_13 + "x" + i2 + ", gl10: " + gl10.toString());
        Utils_3.m14289a(this.f14279i == ((GL11) gl10));
        if (this.f14281k == null) {
            this.f14281k = new ExtTexture(this.f14280j, 36197);
        }
        if (0 == this.f14282l) {
            this.f14282l = PreviewShow.init();
        }
        this.f14264E = OplusGLSurfaceView_13;
        this.f14265F = i2;
        this.f14280j.mo13966a(OplusGLSurfaceView_13, i2);
        float COUIBaseListPopupWindow_12 = this.f14264E;
        float f2 = this.f14266G;
        this.f14267H = (int) (COUIBaseListPopupWindow_12 * f2);
        this.f14268I = (int) (this.f14265F * f2);
        this.f14284n = true;
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13789a(GL10 gl10) {
        this.f14272b.lock();
        while (this.f14288r) {
            this.f14273c.awaitUninterruptibly();
        }
        try {
            m14264b(gl10);
            this.f14272b.unlock();
            if (this.f14287q) {
                this.f14287q = false;
            }
        } catch (Throwable th) {
            this.f14272b.unlock();
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14264b(GL10 gl10) {
        this.f14280j.mo13986g();
        this.f14286p = false;
        this.f14280j.mo13965a(-1);
        this.f14280j.mo13977a(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        if (this.f14290t && this.f14291u != null) {
            this.f14280j.mo13958a(this.f14260A);
        }
        m14263a(this.f14280j, 0, 0, this.f14264E, this.f14265F);
        this.f14280j.mo13985f();
        m14265n();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m14265n() {
        float COUIBaseListPopupWindow_12;
        if (this.f14290t && this.f14291u != null) {
            this.f14293w = AnimationTime.m13867b();
            this.f14290t = false;
        }
        if (this.f14289s) {
            this.f14295y = SystemClock.uptimeMillis();
            long OplusGLSurfaceView_15 = this.f14294x;
            if (0 != OplusGLSurfaceView_15) {
                COUIBaseListPopupWindow_12 = (this.f14295y - (this.f14293w + this.f14296z)) / OplusGLSurfaceView_15;
            } else {
                COUIBaseListPopupWindow_12 = this.f14295y < this.f14293w ? 0.0f : 1.0f;
            }
            if (COUIBaseListPopupWindow_12 > 1.0f) {
                this.f14289s = false;
                this.f14280j.mo13958a(this.f14261B);
                this.f14291u = null;
            } else {
                float interpolation = this.f14292v.getInterpolation(COUIBaseListPopupWindow_12);
                float f2 = this.f14260A;
                this.f14280j.mo13958a(f2 + ((this.f14261B - f2) * interpolation));
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14263a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        HardwareBuffer hardwareBufferRemove;
        synchronized (this.f14271a) {
            hardwareBufferRemove = this.f14274d.size() > 0 ? this.f14274d.remove(0) : null;
        }
        if (hardwareBufferRemove != null && 0 == this.f14282l) {
            synchronized (this.f14271a) {
                if (this.f14274d.size() == 0) {
                    this.f14274d.add(hardwareBufferRemove);
                } else {
                    hardwareBufferRemove.close();
                }
            }
        }
        if (0 == this.f14282l || hardwareBufferRemove == null) {
            return;
        }
        interfaceC2757h.mo13965a(2);
        int iMo13983d = interfaceC2757h.mo13983d();
        int iMo13984e = interfaceC2757h.mo13984e();
        interfaceC2757h.mo13966a(i3, i4);
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 + (i3 / 2);
        float f2 = i2 + (i4 / 2);
        interfaceC2757h.mo13959a(COUIBaseListPopupWindow_12, f2);
        interfaceC2757h.mo13960a(this.f14270K ? -1.0f : 1.0f, -1.0f, 1.0f);
        interfaceC2757h.mo13959a(-r14, -r15);
        PreviewShow.process(hardwareBufferRemove, 36197, this.f14281k.m13934e(), this.f14282l);
        interfaceC2757h.mo13973a(this.f14281k, this.f14283m, OplusGLSurfaceView_13, i2, i3, i4);
        float fM14025b = this.f14275e.m14025b() / 2.0f;
        float f3 = i4;
        interfaceC2757h.mo13964a(fM14025b, 0.0f, fM14025b, f3, this.f14275e);
        float f4 = i3;
        float f5 = f4 - fM14025b;
        interfaceC2757h.mo13964a(f5, 0.0f, f5, f3, this.f14275e);
        float f6 = fM14025b * 2.0f;
        float f7 = f4 - f6;
        interfaceC2757h.mo13964a(f6, fM14025b, f7, fM14025b, this.f14275e);
        float f8 = f3 - fM14025b;
        interfaceC2757h.mo13964a(f6, f8, f7, f8, this.f14275e);
        float fM14025b2 = this.f14276f.m14025b() / 2.0f;
        int i5 = this.f14267H;
        int i6 = this.f14268I;
        float f9 = 2.0f * fM14025b2;
        interfaceC2757h.mo13964a((r14 - i5) - fM14025b2, (r15 - i6) - f9, (r14 - i5) - fM14025b2, i6 + r15 + f9, this.f14276f);
        int i7 = this.f14267H;
        int i8 = this.f14268I;
        interfaceC2757h.mo13964a(r14 + i7 + fM14025b2, (r15 - i8) - f9, i7 + r14 + fM14025b2, i8 + r15 + f9, this.f14276f);
        int i9 = this.f14267H;
        int i10 = this.f14268I;
        interfaceC2757h.mo13964a(r14 - i9, r15 + i10 + fM14025b2, i9 + r14, i10 + r15 + fM14025b2, this.f14276f);
        int i11 = this.f14267H;
        int i12 = this.f14268I;
        interfaceC2757h.mo13964a(r14 - i11, (r15 - i12) - fM14025b2, i11 + r14, (r15 - i12) - fM14025b2, this.f14276f);
        interfaceC2757h.mo13964a(0.0f, f2, r14 - this.f14267H, f2, this.f14277g);
        interfaceC2757h.mo13964a(r14 + this.f14267H, f2, f4, f2, this.f14277g);
        interfaceC2757h.mo13964a(COUIBaseListPopupWindow_12, 0.0f, COUIBaseListPopupWindow_12, r15 - this.f14268I, this.f14277g);
        interfaceC2757h.mo13964a(COUIBaseListPopupWindow_12, r15 + this.f14268I, COUIBaseListPopupWindow_12, f3, this.f14277g);
        interfaceC2757h.mo13966a(iMo13983d, iMo13984e);
        interfaceC2757h.mo13985f();
        synchronized (this.f14271a) {
            if (this.f14274d.size() == 0) {
                this.f14274d.add(hardwareBufferRemove);
            } else {
                hardwareBufferRemove.close();
            }
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13794c() {
        super.mo13794c();
        this.f14285o = false;
        CameraLog.m12954a("TeleSmallPreviewGLSurfaceView", "onResume");
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13795d() {
        m14271m();
        super.mo13795d();
        this.f14284n = false;
        long OplusGLSurfaceView_15 = this.f14282l;
        if (0 != OplusGLSurfaceView_15) {
            PreviewShow.release(OplusGLSurfaceView_15);
            this.f14282l = 0L;
        }
        ExtTexture c2756g = this.f14281k;
        if (c2756g != null) {
            c2756g.mo13944o();
            this.f14281k = null;
        }
        CameraLog.m12954a("TeleSmallPreviewGLSurfaceView", "onPause");
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m14271m() {
        CameraLog.m12954a("TeleSmallPreviewGLSurfaceView", "unfreeze");
        this.f14272b.lock();
        this.f14288r = false;
        this.f14273c.signalAll();
        this.f14272b.unlock();
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView
    protected void finalize() throws Throwable {
        try {
            m14271m();
        } finally {
            super.finalize();
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView, com.oplus.camera.p146gl.GLRoot
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13788a() {
        if (this.f14285o) {
            CameraLog.m12962c("TeleSmallPreviewGLSurfaceView", "requestRender, Activity.finish(), so return");
        } else {
            if (this.f14286p) {
                return;
            }
            this.f14286p = true;
            super.mo13788a();
        }
    }

    public void setRearMirrorEnable(boolean z) {
        this.f14270K = z;
    }
}
