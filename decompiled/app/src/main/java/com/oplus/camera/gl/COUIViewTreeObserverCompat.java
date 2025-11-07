package com.oplus.camera.gl_renamed;

/* compiled from: TeleSmallPreviewGLSurfaceView.java */
/* loaded from: classes2.dex */
public class u_renamed extends com.oplus.camera.gl_renamed.q_renamed implements com.oplus.camera.gl_renamed.n_renamed, com.oplus.camera.gl_renamed.q_renamed.m_renamed {
    private float A_renamed;
    private float B_renamed;
    private int C_renamed;
    private long D_renamed;
    private int E_renamed;
    private int F_renamed;
    private float G_renamed;
    private int H_renamed;
    private int I_renamed;
    private android.content.Context J_renamed;
    private boolean K_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f4675a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.concurrent.locks.ReentrantLock f4676b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.concurrent.locks.Condition f4677c;
    private java.util.ArrayList<android.hardware.HardwareBuffer> d_renamed;
    private com.oplus.camera.gl_renamed.l_renamed e_renamed;
    private com.oplus.camera.gl_renamed.l_renamed f_renamed;
    private com.oplus.camera.gl_renamed.l_renamed g_renamed;
    private com.oplus.camera.gl_renamed.l_renamed h_renamed;
    private javax.microedition.khronos.opengles.GL11 i_renamed;
    private com.oplus.camera.gl_renamed.h_renamed j_renamed;
    private com.oplus.camera.gl_renamed.g_renamed k_renamed;
    private long l_renamed;
    private float[] m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private android.animation.AnimatorSet u_renamed;
    private android.view.animation.Interpolator v_renamed;
    private long w_renamed;
    private long x_renamed;
    private long y_renamed;
    private long z_renamed;

    public int getCompensation() {
        return 0;
    }

    public android.graphics.Matrix getCompensationMatrix() {
        return null;
    }

    public int getDisplayRotation() {
        return 0;
    }

    public void setContentPane(com.oplus.camera.gl_renamed.GLView gLView) {
    }

    public void setLightsOutMode(boolean z_renamed) {
    }

    public u_renamed(android.content.Context context) {
        this(context, null);
        this.J_renamed = context;
    }

    public u_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4675a = new java.lang.Object();
        this.f4676b = new java.util.concurrent.locks.ReentrantLock();
        this.f4677c = this.f4676b.newCondition();
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = 0L;
        this.m_renamed = new float[16];
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = true;
        this.r_renamed = false;
        this.s_renamed = false;
        this.t_renamed = false;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = Long.MAX_VALUE;
        this.x_renamed = Long.MAX_VALUE;
        this.y_renamed = 0L;
        this.z_renamed = 0L;
        this.A_renamed = 0.0f;
        this.B_renamed = 1.0f;
        this.C_renamed = 0;
        this.D_renamed = 0L;
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.G_renamed = 0.0f;
        this.H_renamed = 0;
        this.I_renamed = 0;
        this.J_renamed = null;
        this.K_renamed = false;
    }

    public void b_renamed() {
        setEGLContextClientVersion(2);
        setBackgroundDrawable(null);
        a_renamed(8, 8, 8, 8, 8, 8);
        getHolder().setFormat(-3);
        a_renamed(this, "TeleSmallPreviewGLThread");
        this.l_renamed = com.oplus.camera.jni.PreviewShow.init();
        this.d_renamed = new java.util.ArrayList<>();
        this.h_renamed = new com.oplus.camera.gl_renamed.l_renamed();
        setOuterFramePaint(this.h_renamed);
        setInnerFramePaint(this.h_renamed);
        setLinePaint(this.h_renamed);
    }

    public void setOuterFramePaint(com.oplus.camera.gl_renamed.l_renamed lVar) {
        this.e_renamed = lVar;
    }

    public void setInnerFramePaint(com.oplus.camera.gl_renamed.l_renamed lVar) {
        this.f_renamed = lVar;
    }

    public void setLinePaint(com.oplus.camera.gl_renamed.l_renamed lVar) {
        this.g_renamed = lVar;
    }

    public void setFrameDelta(float f_renamed) {
        this.G_renamed = f_renamed;
        float f2 = this.E_renamed;
        float f3 = this.G_renamed;
        this.H_renamed = (int) (f2 * f3);
        this.I_renamed = (int) (this.F_renamed * f3);
    }

    public void setTeleSmallPreviewRenderModeDirty(boolean z_renamed) {
        if (z_renamed) {
            setRenderMode(0);
        } else {
            setRenderMode(1);
        }
    }

    public int a_renamed(android.hardware.HardwareBuffer hardwareBuffer) {
        synchronized (this.f4675a) {
            if (this.d_renamed == null) {
                hardwareBuffer.close();
                com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewGLSurfaceView", "addFrame, imageList is_renamed null");
                return 0;
            }
            if (this.d_renamed.size() > 15) {
                this.d_renamed.remove(0).close();
            }
            if (hardwareBuffer != null) {
                this.d_renamed.add(hardwareBuffer);
            }
            return this.d_renamed.size();
        }
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewGLSurfaceView", "removeTeleSmallPreviewImage");
        synchronized (this.f4675a) {
            if (this.d_renamed == null) {
                return;
            }
            this.d_renamed.clear();
        }
    }

    public void a_renamed(android.animation.AnimatorSet animatorSet, int i_renamed, android.view.animation.Interpolator interpolator) {
        if (animatorSet != null) {
            this.u_renamed = animatorSet;
            this.x_renamed = this.u_renamed.getDuration();
            this.z_renamed = this.u_renamed.getStartDelay();
            this.A_renamed = i_renamed == 0 ? 0.0f : 1.0f;
            this.B_renamed = i_renamed == 0 ? 1.0f : 0.0f;
        }
        if (interpolator != null) {
            this.v_renamed = interpolator;
        }
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewGLSurfaceView", "setTeleSmallPreviewAnimation");
    }

    public void f_renamed() {
        this.s_renamed = true;
        this.t_renamed = true;
        android.animation.AnimatorSet animatorSet = this.u_renamed;
        if (animatorSet != null) {
            animatorSet.start();
        }
        com.oplus.camera.gl_renamed.b_renamed.a_renamed();
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewGLSurfaceView", "startTeleSmallPreviewAnimation");
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed.m_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        com.oplus.camera.e_renamed.c_renamed("TeleSmallPreviewGLSurfaceView", "onSurfaceCreated(GL10 gl1, EGLConfig config)");
        android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        javax.microedition.khronos.opengles.GL11 gl11 = (javax.microedition.khronos.opengles.GL11) gl10;
        if (this.i_renamed != null) {
            com.oplus.camera.e_renamed.c_renamed("TeleSmallPreviewGLSurfaceView", "GLObject has changed from " + this.i_renamed + " to " + gl11);
        }
        this.f4676b.lock();
        try {
            this.i_renamed = gl11;
            this.j_renamed = new com.oplus.camera.gl_renamed.i_renamed();
            this.k_renamed = new com.oplus.camera.gl_renamed.g_renamed(this.j_renamed, 36197);
            android.renderscript.Matrix4f matrix4f = new android.renderscript.Matrix4f();
            matrix4f.scale(1.0f, -1.0f, 1.0f);
            matrix4f.translate(0.0f, -1.0f, 0.0f);
            matrix4f.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            matrix4f.translate(0.0f, -1.0f, 0.0f);
            this.m_renamed = matrix4f.getArray();
            this.f4676b.unlock();
            if (!this.s_renamed) {
                setRenderMode(0);
            }
            this.n_renamed = true;
            this.o_renamed = false;
        } catch (java.lang.Throwable th) {
            this.f4676b.unlock();
            throw th;
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed.m_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.c_renamed("TeleSmallPreviewGLSurfaceView", "onSurfaceChanged, size: " + i_renamed + "x_renamed" + i2 + ", gl10: " + gl10.toString());
        com.oplus.camera.gl_renamed.y_renamed.a_renamed(this.i_renamed == ((javax.microedition.khronos.opengles.GL11) gl10));
        if (this.k_renamed == null) {
            this.k_renamed = new com.oplus.camera.gl_renamed.g_renamed(this.j_renamed, 36197);
        }
        if (0 == this.l_renamed) {
            this.l_renamed = com.oplus.camera.jni.PreviewShow.init();
        }
        this.E_renamed = i_renamed;
        this.F_renamed = i2;
        this.j_renamed.a_renamed(i_renamed, i2);
        float f_renamed = this.E_renamed;
        float f2 = this.G_renamed;
        this.H_renamed = (int) (f_renamed * f2);
        this.I_renamed = (int) (this.F_renamed * f2);
        this.n_renamed = true;
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed.m_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        this.f4676b.lock();
        while (this.r_renamed) {
            this.f4677c.awaitUninterruptibly();
        }
        try {
            b_renamed(gl10);
            this.f4676b.unlock();
            if (this.q_renamed) {
                this.q_renamed = false;
            }
        } catch (java.lang.Throwable th) {
            this.f4676b.unlock();
            throw th;
        }
    }

    private void b_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        this.j_renamed.g_renamed();
        this.p_renamed = false;
        this.j_renamed.a_renamed(-1);
        this.j_renamed.a_renamed(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        if (this.t_renamed && this.u_renamed != null) {
            this.j_renamed.a_renamed(this.A_renamed);
        }
        a_renamed(this.j_renamed, 0, 0, this.E_renamed, this.F_renamed);
        this.j_renamed.f_renamed();
        n_renamed();
    }

    private void n_renamed() {
        float f_renamed;
        if (this.t_renamed && this.u_renamed != null) {
            this.w_renamed = com.oplus.camera.gl_renamed.b_renamed.b_renamed();
            this.t_renamed = false;
        }
        if (this.s_renamed) {
            this.y_renamed = android.os.SystemClock.uptimeMillis();
            long j_renamed = this.x_renamed;
            if (0 != j_renamed) {
                f_renamed = (this.y_renamed - (this.w_renamed + this.z_renamed)) / j_renamed;
            } else {
                f_renamed = this.y_renamed < this.w_renamed ? 0.0f : 1.0f;
            }
            if (f_renamed > 1.0f) {
                this.s_renamed = false;
                this.j_renamed.a_renamed(this.B_renamed);
                this.u_renamed = null;
            } else {
                float interpolation = this.v_renamed.getInterpolation(f_renamed);
                float f2 = this.A_renamed;
                this.j_renamed.a_renamed(f2 + ((this.B_renamed - f2) * interpolation));
            }
        }
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4) {
        android.hardware.HardwareBuffer hardwareBufferRemove;
        synchronized (this.f4675a) {
            hardwareBufferRemove = this.d_renamed.size() > 0 ? this.d_renamed.remove(0) : null;
        }
        if (hardwareBufferRemove != null && 0 == this.l_renamed) {
            synchronized (this.f4675a) {
                if (this.d_renamed.size() == 0) {
                    this.d_renamed.add(hardwareBufferRemove);
                } else {
                    hardwareBufferRemove.close();
                }
            }
        }
        if (0 == this.l_renamed || hardwareBufferRemove == null) {
            return;
        }
        hVar.a_renamed(2);
        int iD = hVar.d_renamed();
        int iE = hVar.e_renamed();
        hVar.a_renamed(i3, i4);
        float f_renamed = i_renamed + (i3 / 2);
        float f2 = i2 + (i4 / 2);
        hVar.a_renamed(f_renamed, f2);
        hVar.a_renamed(this.K_renamed ? -1.0f : 1.0f, -1.0f, 1.0f);
        hVar.a_renamed(-r14, -r15);
        com.oplus.camera.jni.PreviewShow.process(hardwareBufferRemove, 36197, this.k_renamed.e_renamed(), this.l_renamed);
        hVar.a_renamed(this.k_renamed, this.m_renamed, i_renamed, i2, i3, i4);
        float fB_renamed = this.e_renamed.b_renamed() / 2.0f;
        float f3 = i4;
        hVar.a_renamed(fB_renamed, 0.0f, fB_renamed, f3, this.e_renamed);
        float f4 = i3;
        float f5 = f4 - fB_renamed;
        hVar.a_renamed(f5, 0.0f, f5, f3, this.e_renamed);
        float f6 = fB_renamed * 2.0f;
        float f7 = f4 - f6;
        hVar.a_renamed(f6, fB_renamed, f7, fB_renamed, this.e_renamed);
        float f8 = f3 - fB_renamed;
        hVar.a_renamed(f6, f8, f7, f8, this.e_renamed);
        float fB2 = this.f_renamed.b_renamed() / 2.0f;
        int i5 = this.H_renamed;
        int i6 = this.I_renamed;
        float f9 = 2.0f * fB2;
        hVar.a_renamed((r14 - i5) - fB2, (r15 - i6) - f9, (r14 - i5) - fB2, i6 + r15 + f9, this.f_renamed);
        int i7 = this.H_renamed;
        int i8 = this.I_renamed;
        hVar.a_renamed(r14 + i7 + fB2, (r15 - i8) - f9, i7 + r14 + fB2, i8 + r15 + f9, this.f_renamed);
        int i9 = this.H_renamed;
        int i10 = this.I_renamed;
        hVar.a_renamed(r14 - i9, r15 + i10 + fB2, i9 + r14, i10 + r15 + fB2, this.f_renamed);
        int i11 = this.H_renamed;
        int i12 = this.I_renamed;
        hVar.a_renamed(r14 - i11, (r15 - i12) - fB2, i11 + r14, (r15 - i12) - fB2, this.f_renamed);
        hVar.a_renamed(0.0f, f2, r14 - this.H_renamed, f2, this.g_renamed);
        hVar.a_renamed(r14 + this.H_renamed, f2, f4, f2, this.g_renamed);
        hVar.a_renamed(f_renamed, 0.0f, f_renamed, r15 - this.I_renamed, this.g_renamed);
        hVar.a_renamed(f_renamed, r15 + this.I_renamed, f_renamed, f3, this.g_renamed);
        hVar.a_renamed(iD, iE);
        hVar.f_renamed();
        synchronized (this.f4675a) {
            if (this.d_renamed.size() == 0) {
                this.d_renamed.add(hardwareBufferRemove);
            } else {
                hardwareBufferRemove.close();
            }
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed
    public void c_renamed() {
        super.c_renamed();
        this.o_renamed = false;
        com.oplus.camera.e_renamed.a_renamed("TeleSmallPreviewGLSurfaceView", "onResume");
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed
    public void d_renamed() {
        m_renamed();
        super.d_renamed();
        this.n_renamed = false;
        long j_renamed = this.l_renamed;
        if (0 != j_renamed) {
            com.oplus.camera.jni.PreviewShow.release(j_renamed);
            this.l_renamed = 0L;
        }
        com.oplus.camera.gl_renamed.g_renamed gVar = this.k_renamed;
        if (gVar != null) {
            gVar.o_renamed();
            this.k_renamed = null;
        }
        com.oplus.camera.e_renamed.a_renamed("TeleSmallPreviewGLSurfaceView", "onPause");
    }

    public void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TeleSmallPreviewGLSurfaceView", "unfreeze");
        this.f4676b.lock();
        this.r_renamed = false;
        this.f4677c.signalAll();
        this.f4676b.unlock();
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed
    protected void finalize() throws java.lang.Throwable {
        try {
            m_renamed();
        } finally {
            super.finalize();
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed, com.oplus.camera.gl_renamed.n_renamed
    public void a_renamed() {
        if (this.o_renamed) {
            com.oplus.camera.e_renamed.c_renamed("TeleSmallPreviewGLSurfaceView", "requestRender, Activity.finish(), so return");
        } else {
            if (this.p_renamed) {
                return;
            }
            this.p_renamed = true;
            super.a_renamed();
        }
    }

    public void setRearMirrorEnable(boolean z_renamed) {
        this.K_renamed = z_renamed;
    }
}
