package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class FaceView extends android.view.View implements com.oplus.camera.ui.preview.m_renamed {
    private float A_renamed;
    private int B_renamed;
    private int C_renamed;
    private int D_renamed;
    private android.hardware.camera2.params.Face[] E_renamed;
    private android.hardware.camera2.params.Face[] F_renamed;
    private java.util.ArrayList<android.graphics.Rect> G_renamed;
    private java.util.ArrayList<android.graphics.Rect> H_renamed;
    private java.util.HashMap<java.lang.String, java.lang.String> I_renamed;
    private android.animation.ValueAnimator J_renamed;
    private android.animation.ValueAnimator K_renamed;
    private int L_renamed;
    private int M_renamed;
    private boolean N_renamed;
    private boolean O_renamed;
    private float P_renamed;
    private volatile boolean Q_renamed;
    private int R_renamed;
    private volatile int S_renamed;
    private java.util.Queue<android.graphics.Rect[]> T_renamed;
    private int U_renamed;
    private com.oplus.camera.ui.preview.k_renamed V_renamed;
    private float W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6785a;
    private android.graphics.drawable.Drawable aa_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6786b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6787c;
    private boolean d_renamed;
    private boolean e_renamed;
    private android.graphics.Matrix f_renamed;
    private android.graphics.Rect g_renamed;
    private android.graphics.Rect[] h_renamed;
    private java.util.ArrayList<android.graphics.RectF> i_renamed;
    private android.graphics.RectF j_renamed;
    private android.hardware.camera2.params.Face[] k_renamed;
    private android.hardware.camera2.params.Face[] l_renamed;
    private android.graphics.Paint m_renamed;
    private int n_renamed;
    private int[] o_renamed;
    private int[] p_renamed;
    private int[] q_renamed;
    private long r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private boolean v_renamed;
    private long w_renamed;
    private float x_renamed;
    private float y_renamed;
    private float z_renamed;

    private boolean h_renamed() {
        return true;
    }

    public FaceView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d_renamed = false;
        this.f_renamed = new android.graphics.Matrix();
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = new android.graphics.RectF();
        this.n_renamed = 0;
        this.r_renamed = 0L;
        this.s_renamed = false;
        this.t_renamed = false;
        this.u_renamed = true;
        this.v_renamed = false;
        this.w_renamed = 0L;
        this.x_renamed = 0.0f;
        this.y_renamed = 0.0f;
        this.z_renamed = 1.0f;
        this.A_renamed = 1.0f;
        this.B_renamed = 0;
        this.C_renamed = 0;
        this.D_renamed = 0;
        this.E_renamed = null;
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.J_renamed = null;
        this.K_renamed = null;
        this.L_renamed = 32;
        this.M_renamed = 255;
        this.N_renamed = false;
        this.O_renamed = false;
        this.P_renamed = 1.0f;
        this.Q_renamed = false;
        this.R_renamed = 0;
        this.S_renamed = 0;
        this.T_renamed = null;
        this.U_renamed = 0;
        this.V_renamed = null;
        this.W_renamed = 0.0f;
        this.aa_renamed = null;
        this.R_renamed = (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_face_outer_width);
        this.m_renamed = new android.graphics.Paint();
        this.m_renamed.setAntiAlias(true);
        this.m_renamed.setDither(true);
        this.m_renamed.setColor(com.oplus.camera.util.Util.A_renamed(context));
        this.m_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.m_renamed.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.m_renamed.setStrokeWidth(context.getResources().getDimension(com.oplus.camera.R_renamed.dimen.focus_common_stroke_width));
        this.T_renamed = new java.util.LinkedList();
        this.i_renamed = new java.util.ArrayList<>();
        this.V_renamed = new com.oplus.camera.ui.preview.k_renamed(this);
        this.W_renamed = context.getResources().getDimension(com.oplus.camera.R_renamed.dimen.video_tracking_focus_frame_radius);
        this.aa_renamed = com.oplus.camera.util.Util.b_renamed(context, com.oplus.camera.R_renamed.drawable.icon_face_detect);
        if (h_renamed()) {
            k_renamed();
        }
    }

    public void a_renamed(android.hardware.camera2.params.Face[] faceArr, int[] iArr) {
        android.hardware.camera2.params.Face[] faceArr2;
        android.hardware.camera2.params.Face[] faceArr3;
        if (this.e_renamed) {
            return;
        }
        this.V_renamed.a_renamed(iArr);
        if (faceArr == null || this.V_renamed.b_renamed()) {
            return;
        }
        this.l_renamed = this.k_renamed;
        this.k_renamed = faceArr;
        a_renamed(faceArr);
        if (h_renamed()) {
            if (this.O_renamed) {
                return;
            }
            if (this.M_renamed != 0 && this.u_renamed && !this.N_renamed && (faceArr3 = this.k_renamed) != null && faceArr3.length > 0) {
                b_renamed(faceArr3);
            }
            if (this.D_renamed != 0 && this.u_renamed && !this.N_renamed) {
                i_renamed();
                return;
            }
            if (android.os.SystemClock.uptimeMillis() - this.w_renamed > 100 && this.M_renamed == 255 && this.t_renamed && ((faceArr2 = this.k_renamed) == null || faceArr2.length == 0 || !this.u_renamed)) {
                j_renamed();
                return;
            }
            if (this.N_renamed || !a_renamed(this.l_renamed, this.k_renamed) || !this.u_renamed) {
                return;
            }
            this.M_renamed = 255;
            this.H_renamed.clear();
            int i_renamed = 0;
            while (true) {
                android.hardware.camera2.params.Face[] faceArr4 = this.k_renamed;
                if (i_renamed < faceArr4.length) {
                    this.H_renamed.add(new android.graphics.Rect(faceArr4[i_renamed].getBounds().left, this.k_renamed[i_renamed].getBounds().top, this.k_renamed[i_renamed].getBounds().right, this.k_renamed[i_renamed].getBounds().bottom));
                    i_renamed++;
                } else {
                    invalidate();
                    return;
                }
            }
        } else {
            invalidate();
        }
    }

    private void a_renamed(android.hardware.camera2.params.Face[] faceArr) {
        boolean z_renamed;
        float f_renamed;
        if (this.n_renamed == faceArr.length) {
            z_renamed = false;
        } else {
            this.n_renamed = faceArr.length;
            this.o_renamed = new int[faceArr.length];
            this.p_renamed = new int[faceArr.length];
            this.q_renamed = new int[faceArr.length];
            for (int i_renamed = 0; i_renamed < faceArr.length; i_renamed++) {
                android.hardware.camera2.params.Face face = faceArr[i_renamed];
                this.o_renamed[i_renamed] = b_renamed(face.getBounds().left, face.getBounds().right);
                this.p_renamed[i_renamed] = b_renamed(face.getBounds().top, face.getBounds().bottom);
                this.q_renamed[i_renamed] = a_renamed(face);
            }
            this.s_renamed = false;
            z_renamed = true;
        }
        boolean z2 = z_renamed;
        for (int i2 = 0; i2 < faceArr.length; i2++) {
            android.hardware.camera2.params.Face face2 = faceArr[i2];
            int iB = b_renamed(face2.getBounds().left, face2.getBounds().right);
            int iB2 = b_renamed(face2.getBounds().top, face2.getBounds().bottom);
            int iA = a_renamed(face2);
            if (this.q_renamed[i2] > 0) {
                float f2 = iA / r7[i2];
                if (f2 < 1.0f) {
                    f2 = 1.0f / f2;
                }
                f_renamed = f2 - 1.0f;
            } else {
                f_renamed = 0.3f;
            }
            if (a_renamed(iB, iB2, this.o_renamed[i2], this.p_renamed[i2]) > 260 || f_renamed >= 0.3f) {
                this.s_renamed = false;
                z2 = true;
            }
            if (z2) {
                this.o_renamed[i2] = iB;
                this.p_renamed[i2] = iB2;
                this.q_renamed[i2] = iA;
            }
        }
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (!z2 && this.s_renamed && jElapsedRealtime - this.r_renamed > 3000 && !this.O_renamed) {
            this.u_renamed = false;
            java.util.Queue<android.graphics.Rect[]> queue = this.T_renamed;
            if (queue != null) {
                queue.clear();
                return;
            }
            return;
        }
        if (!this.u_renamed) {
            this.w_renamed = android.os.SystemClock.uptimeMillis();
            java.util.Queue<android.graphics.Rect[]> queue2 = this.T_renamed;
            if (queue2 != null) {
                queue2.clear();
            }
        }
        this.u_renamed = true;
    }

    private int a_renamed(int i_renamed, int i2) {
        return java.lang.Math.abs(i2 - i_renamed);
    }

    private int a_renamed(int i_renamed, int i2, int i3, int i4) {
        int i5 = i3 - i_renamed;
        int i6 = i4 - i2;
        return (int) java.lang.Math.sqrt((i5 * i5) + (i6 * i6));
    }

    private int b_renamed(int i_renamed, int i2) {
        return (i_renamed + i2) / 2;
    }

    private int a_renamed(android.hardware.camera2.params.Face face) {
        return java.lang.Math.abs(face.getBounds().right - face.getBounds().left) * java.lang.Math.abs(face.getBounds().bottom - face.getBounds().top);
    }

    private int a_renamed(android.graphics.Rect rect) {
        if (rect == null) {
            return 0;
        }
        return java.lang.Math.abs(rect.right - rect.left) * java.lang.Math.abs(rect.bottom - rect.top);
    }

    public android.graphics.Rect[] getFaceRects() {
        return this.h_renamed;
    }

    public void setDisplayOrientation(int i_renamed) {
        this.f6785a = i_renamed;
        this.V_renamed.a_renamed(i_renamed);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.f6786b = i_renamed;
        invalidate();
    }

    public void setMirror(boolean z_renamed) {
        this.f6787c = z_renamed;
        this.V_renamed.a_renamed(z_renamed);
    }

    public void setRearMirrorEnable(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public void a_renamed(android.graphics.Rect rect, android.util.Size size) {
        this.g_renamed = rect;
        this.V_renamed.a_renamed(size);
    }

    public void setEISScale(float f_renamed) {
        this.P_renamed = f_renamed;
        this.U_renamed = ((int) java.lang.Math.sqrt(this.z_renamed * this.P_renamed * this.A_renamed)) + 4;
    }

    public void setZoomValue(float f_renamed) {
        this.z_renamed = f_renamed;
        this.U_renamed = ((int) java.lang.Math.sqrt(this.z_renamed * this.P_renamed * this.A_renamed)) + 4;
    }

    public void setFaceSlenderZoomValue(float f_renamed) {
        this.A_renamed = f_renamed;
        this.U_renamed = ((int) java.lang.Math.sqrt(this.z_renamed * this.P_renamed * this.A_renamed)) + 4;
    }

    public boolean a_renamed() {
        android.hardware.camera2.params.Face[] faceArr = this.k_renamed;
        return faceArr != null && faceArr.length > 0;
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.k_renamed kVar = this.V_renamed;
        if (kVar == null || !kVar.e_renamed() || this.V_renamed.b_renamed()) {
            return;
        }
        this.V_renamed.b_renamed(z_renamed);
    }

    @Override // com.oplus.camera.ui.preview.m_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("FaceView", "showSuccess()");
        invalidate();
    }

    public void b_renamed() {
        if (this.k_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("FaceView", "clear()");
            this.k_renamed = null;
            this.n_renamed = 0;
            java.util.ArrayList<android.graphics.Rect> arrayList = this.H_renamed;
            if (arrayList != null && arrayList.size() > 0) {
                this.H_renamed.clear();
                invalidate();
            }
        }
        java.util.Queue<android.graphics.Rect[]> queue = this.T_renamed;
        if (queue != null) {
            queue.clear();
        }
        java.util.ArrayList<android.graphics.RectF> arrayList2 = this.i_renamed;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceView", "pause()");
        this.e_renamed = true;
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceView", "resume()");
        this.e_renamed = false;
    }

    public void e_renamed() {
        this.e_renamed = true;
        this.k_renamed = null;
        this.i_renamed = null;
        this.f_renamed = null;
        this.m_renamed = null;
        this.T_renamed = null;
        l_renamed();
        com.oplus.camera.ui.preview.k_renamed kVar = this.V_renamed;
        if (kVar != null) {
            kVar.d_renamed();
        }
        this.V_renamed = null;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int length;
        java.util.ArrayList<android.graphics.RectF> arrayList;
        android.hardware.camera2.params.Face[] faceArr;
        this.f_renamed.reset();
        this.t_renamed = false;
        java.util.ArrayList<android.graphics.Rect> arrayList2 = this.H_renamed;
        if (arrayList2 != null) {
            length = arrayList2.size();
        } else {
            android.hardware.camera2.params.Face[] faceArr2 = this.k_renamed;
            length = faceArr2 != null ? faceArr2.length : 0;
        }
        java.util.ArrayList<android.graphics.RectF> arrayList3 = this.i_renamed;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        this.V_renamed.a_renamed(canvas);
        if (length > 0) {
            this.f_renamed.setTranslate((-this.g_renamed.width()) / 2, (-this.g_renamed.height()) / 2);
            this.f_renamed.postScale(this.f6787c ? -1.0f : 1.0f, this.d_renamed ? -1.0f : 1.0f);
            this.f_renamed.postRotate(this.f6785a);
            this.f_renamed.postScale((((getWidth() * this.z_renamed) * this.P_renamed) * this.A_renamed) / this.g_renamed.height(), (((getHeight() * this.z_renamed) * this.P_renamed) * this.A_renamed) / this.g_renamed.width());
            this.f_renamed.postTranslate(getWidth() / 2, getHeight() / 2);
            this.h_renamed = new android.graphics.Rect[length];
            int i_renamed = 0;
            for (int i2 = 0; i2 < length; i2++) {
                java.util.ArrayList<android.graphics.Rect> arrayList4 = this.H_renamed;
                if (arrayList4 != null) {
                    this.j_renamed.set(arrayList4.get(i2));
                } else {
                    this.j_renamed.set(this.k_renamed[i2].getBounds());
                }
                this.j_renamed.offset(-this.g_renamed.left, -this.g_renamed.top);
                this.f_renamed.mapRect(this.j_renamed);
                android.graphics.Rect rect = new android.graphics.Rect(java.lang.Math.max(0, java.lang.Math.round(this.j_renamed.left)), java.lang.Math.max(0, java.lang.Math.round(this.j_renamed.top)), java.lang.Math.min(getWidth(), java.lang.Math.round(this.j_renamed.right)), java.lang.Math.min(getHeight(), java.lang.Math.round(this.j_renamed.bottom)));
                int iA = a_renamed(rect);
                if (iA >= i_renamed) {
                    i_renamed = iA;
                }
                this.h_renamed[i2] = rect;
            }
            java.util.Queue<android.graphics.Rect[]> queue = this.T_renamed;
            if (queue != null) {
                android.graphics.Rect[] rectArr = this.h_renamed;
                if (rectArr.length > 0) {
                    queue.offer(rectArr);
                }
            }
            while (true) {
                java.util.Queue<android.graphics.Rect[]> queue2 = this.T_renamed;
                if (queue2 == null || queue2.size() <= this.U_renamed) {
                    break;
                } else {
                    this.T_renamed.poll();
                }
            }
            java.util.Queue<android.graphics.Rect[]> queue3 = this.T_renamed;
            if (queue3 != null && (faceArr = this.l_renamed) != null && this.h_renamed.length != faceArr.length) {
                queue3.clear();
                this.T_renamed.offer(this.h_renamed);
            }
            java.util.Queue<android.graphics.Rect[]> queue4 = this.T_renamed;
            if (queue4 != null && queue4.size() > 0) {
                for (int i3 = 0; i3 < this.h_renamed.length; i3++) {
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    for (android.graphics.Rect[] rectArr2 : this.T_renamed) {
                        if (rectArr2.length > i3 && !rectArr2[i3].isEmpty()) {
                            i5 += rectArr2[i3].left;
                            i7 += rectArr2[i3].right;
                            i6 += rectArr2[i3].top;
                            i8 += rectArr2[i3].bottom;
                            i4++;
                        }
                    }
                    if (i4 != 0 && (arrayList = this.i_renamed) != null) {
                        arrayList.add(new android.graphics.RectF(i5 / i4, i6 / i4, i7 / i4, i8 / i4));
                    }
                }
            }
            java.util.ArrayList<android.graphics.RectF> arrayList5 = this.i_renamed;
            if (arrayList5 == null || arrayList5.isEmpty()) {
                return;
            }
            for (int i9 = 0; i9 < this.i_renamed.size(); i9++) {
                if (this.u_renamed) {
                    if (!this.s_renamed) {
                        this.r_renamed = android.os.SystemClock.elapsedRealtime();
                    }
                    this.s_renamed = true;
                    this.t_renamed = true;
                    this.m_renamed.setAlpha(this.M_renamed);
                    android.graphics.RectF rectF = this.i_renamed.get(i9);
                    a_renamed(rectF);
                    this.aa_renamed.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.aa_renamed.setAlpha(this.M_renamed);
                    this.aa_renamed.draw(canvas);
                }
            }
        }
        java.util.ArrayList<android.graphics.Rect> arrayList6 = this.H_renamed;
        if (arrayList6 != null && this.M_renamed == 0 && arrayList6.size() > 0) {
            this.H_renamed.clear();
        }
        java.util.ArrayList<android.graphics.RectF> arrayList7 = this.i_renamed;
        if (arrayList7 != null) {
            arrayList7.clear();
        }
        super.onDraw(canvas);
    }

    private void i_renamed() {
        if (this.N_renamed) {
            return;
        }
        this.N_renamed = true;
        this.M_renamed = 255;
        setLayerType(2, null);
        int i_renamed = this.L_renamed;
        this.B_renamed = (i_renamed / 16) + 1;
        this.C_renamed = 0;
        this.y_renamed = 100.0f / this.B_renamed;
        android.animation.ValueAnimator valueAnimator = this.J_renamed;
        if (valueAnimator != null) {
            valueAnimator.setDuration(i_renamed);
            this.J_renamed.start();
        }
    }

    private boolean a_renamed(android.hardware.camera2.params.Face[] faceArr, android.hardware.camera2.params.Face[] faceArr2) {
        int i_renamed;
        if (faceArr == null || faceArr2 == null || faceArr.length <= 0 || faceArr.length != faceArr2.length) {
            i_renamed = 0;
        } else {
            i_renamed = 0;
            for (int i2 = 0; i2 < faceArr.length; i2++) {
                android.graphics.Rect bounds = faceArr[i2].getBounds();
                int iB = b_renamed(bounds.left, bounds.right);
                int iB2 = b_renamed(bounds.top, bounds.bottom);
                int iA = a_renamed(faceArr[i2]);
                int i3 = 0;
                while (true) {
                    if (i3 >= faceArr2.length) {
                        break;
                    }
                    if (-1 == faceArr2[i2].getId() || faceArr[i2].getId() != faceArr2[i3].getId()) {
                        i3++;
                    } else {
                        android.graphics.Rect bounds2 = faceArr2[i3].getBounds();
                        int iB3 = b_renamed(bounds2.left, bounds2.right);
                        int iB4 = b_renamed(bounds2.top, bounds2.bottom);
                        int iA2 = a_renamed(faceArr2[i3]);
                        if (a_renamed(iB, iB2, iB3, iB4) == 0 && a_renamed(iA, iA2) == 0) {
                            i_renamed++;
                        }
                    }
                }
            }
        }
        if (faceArr == null || faceArr2 == null || i_renamed != faceArr2.length || i_renamed != faceArr.length) {
            return (faceArr == null && faceArr2 == null) ? false : true;
        }
        return false;
    }

    private void b_renamed(android.hardware.camera2.params.Face[] faceArr) {
        android.hardware.camera2.params.Face[] faceArr2;
        if (!a_renamed(this.F_renamed, faceArr)) {
            return;
        }
        this.L_renamed = 32;
        int i_renamed = 0;
        this.D_renamed = 0;
        this.E_renamed = this.F_renamed;
        this.F_renamed = faceArr;
        this.G_renamed.clear();
        this.I_renamed.clear();
        android.hardware.camera2.params.Face[] faceArr3 = this.E_renamed;
        if (faceArr3 != null && (faceArr2 = this.F_renamed) != null && faceArr3.length > 0 && faceArr2.length > 0) {
            int i2 = 0;
            while (true) {
                android.hardware.camera2.params.Face[] faceArr4 = this.E_renamed;
                if (i2 >= faceArr4.length) {
                    break;
                }
                android.graphics.Rect bounds = faceArr4[i2].getBounds();
                int iB = b_renamed(bounds.left, bounds.right);
                int iB2 = b_renamed(bounds.top, bounds.bottom);
                int iA = a_renamed(this.E_renamed[i2]);
                int i3 = 0;
                while (true) {
                    android.hardware.camera2.params.Face[] faceArr5 = this.F_renamed;
                    if (i3 < faceArr5.length) {
                        if (-1 != faceArr5[i3].getId() && this.F_renamed[i3].getId() == this.E_renamed[i2].getId() && !this.I_renamed.containsKey(java.lang.String.valueOf(i3))) {
                            android.graphics.Rect bounds2 = this.F_renamed[i3].getBounds();
                            int iB3 = b_renamed(bounds2.left, bounds2.right);
                            int iB4 = b_renamed(bounds2.top, bounds2.bottom);
                            int iA2 = a_renamed(this.F_renamed[i3]);
                            a_renamed(iA, iA2);
                            int iA3 = a_renamed(iB, iB2, iB3, iB4);
                            float f_renamed = 0.0f;
                            if (iA > 0) {
                                float f2 = (iA2 * 1.0f) / iA;
                                if (f2 < 1.0f) {
                                    f2 = 1.0f / f2;
                                }
                                f_renamed = f2 - 1.0f;
                            }
                            if (iA3 > 2 || f_renamed > 0.01f) {
                                int iA4 = com.oplus.camera.util.Util.a_renamed((int) ((iA3 / 30.0f) * 32.0f), 32, 96);
                                int iA5 = com.oplus.camera.util.Util.a_renamed((int) (f_renamed * 32.0f * 1.5f), 32, 160);
                                if (iA4 > this.L_renamed) {
                                    this.L_renamed = iA4;
                                }
                                if (iA5 > this.L_renamed) {
                                    this.L_renamed = iA5;
                                }
                                this.D_renamed = 1 << i3;
                                this.I_renamed.put(java.lang.String.valueOf(i3), java.lang.String.valueOf(i2));
                                this.G_renamed.add(new android.graphics.Rect(bounds2.left - bounds.left, bounds2.top - bounds.top, bounds2.right - bounds.right, bounds2.bottom - bounds.bottom));
                            }
                        }
                        i3++;
                    }
                }
                i2++;
            }
        }
        if (this.D_renamed == 0) {
            return;
        }
        this.H_renamed.clear();
        while (true) {
            android.hardware.camera2.params.Face[] faceArr6 = this.F_renamed;
            if (i_renamed >= faceArr6.length) {
                return;
            }
            this.H_renamed.add(new android.graphics.Rect(faceArr6[i_renamed].getBounds().left, this.F_renamed[i_renamed].getBounds().top, this.F_renamed[i_renamed].getBounds().right, this.F_renamed[i_renamed].getBounds().bottom));
            i_renamed++;
        }
    }

    private void j_renamed() {
        if (this.O_renamed) {
            return;
        }
        this.u_renamed = true;
        android.animation.ValueAnimator valueAnimator = this.J_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.J_renamed.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.K_renamed;
        if (valueAnimator2 != null) {
            this.O_renamed = true;
            valueAnimator2.start();
        }
    }

    private void k_renamed() {
        this.G_renamed = new java.util.ArrayList<>();
        this.H_renamed = new java.util.ArrayList<>();
        this.I_renamed = new java.util.HashMap<>();
        this.J_renamed = android.animation.ValueAnimator.ofInt(0, 100);
        this.J_renamed.setDuration(this.L_renamed);
        this.J_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.J_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.FaceView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) throws java.lang.NumberFormatException {
                int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                if (!com.oplus.camera.ui.preview.FaceView.this.e_renamed || com.oplus.camera.ui.preview.FaceView.this.J_renamed == null) {
                    if (!com.oplus.camera.ui.preview.FaceView.this.N_renamed || com.oplus.camera.ui.preview.FaceView.this.C_renamed >= com.oplus.camera.ui.preview.FaceView.this.B_renamed) {
                        return;
                    }
                    if (!com.oplus.camera.ui.preview.FaceView.this.O_renamed || com.oplus.camera.ui.preview.FaceView.this.J_renamed == null) {
                        com.oplus.camera.ui.preview.FaceView.this.a_renamed(iIntValue);
                        com.oplus.camera.ui.preview.FaceView.this.invalidate();
                        return;
                    } else {
                        com.oplus.camera.ui.preview.FaceView.this.J_renamed.end();
                        return;
                    }
                }
                com.oplus.camera.ui.preview.FaceView.this.J_renamed.cancel();
            }
        });
        this.J_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.FaceView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.preview.FaceView.this.N_renamed = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.preview.FaceView.this.setLayerType(0, null);
                com.oplus.camera.ui.preview.FaceView.this.N_renamed = false;
                com.oplus.camera.ui.preview.FaceView.this.D_renamed = 0;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ui.preview.FaceView.this.N_renamed = false;
            }
        });
        this.K_renamed = android.animation.ValueAnimator.ofInt(255, 0);
        this.K_renamed.setDuration(300L);
        this.K_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.K_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.FaceView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.FaceView.this.M_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.preview.FaceView.this.invalidate();
            }
        });
        this.K_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.FaceView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.preview.FaceView.this.O_renamed = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed) throws java.lang.NumberFormatException {
        int i2 = this.C_renamed;
        this.C_renamed = i2 + 1;
        float f_renamed = (i2 < this.B_renamed ? this.C_renamed * this.y_renamed : 100.0f) / 100.0f;
        if (i_renamed >= 100) {
            f_renamed = 1.0f;
            this.C_renamed = this.B_renamed;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            java.util.ArrayList<android.graphics.Rect> arrayList = this.H_renamed;
            if (arrayList == null || i3 >= arrayList.size()) {
                return;
            }
            if ((this.D_renamed & (1 << i3)) != 0) {
                int i5 = java.lang.Integer.parseInt(this.I_renamed.get(java.lang.String.valueOf(i3)));
                this.H_renamed.get(i3).left = this.E_renamed[i5].getBounds().left + ((int) (this.G_renamed.get(i4).left * f_renamed));
                this.H_renamed.get(i3).top = this.E_renamed[i5].getBounds().top + ((int) (this.G_renamed.get(i4).top * f_renamed));
                this.H_renamed.get(i3).right = this.E_renamed[i5].getBounds().right + ((int) (this.G_renamed.get(i4).right * f_renamed));
                this.H_renamed.get(i3).bottom = this.E_renamed[i5].getBounds().bottom + ((int) (this.G_renamed.get(i4).bottom * f_renamed));
                i4++;
            }
            i3++;
        }
    }

    private void l_renamed() {
        if (h_renamed()) {
            this.D_renamed = 0;
            this.E_renamed = null;
            this.F_renamed = null;
            this.l_renamed = null;
            this.k_renamed = null;
            android.animation.ValueAnimator valueAnimator = this.J_renamed;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.J_renamed.end();
            }
            android.animation.ValueAnimator valueAnimator2 = this.K_renamed;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.K_renamed.end();
            }
            this.J_renamed = null;
            this.K_renamed = null;
            java.util.ArrayList<android.graphics.Rect> arrayList = this.G_renamed;
            if (arrayList != null) {
                arrayList.clear();
                this.G_renamed = null;
            }
            java.util.ArrayList<android.graphics.Rect> arrayList2 = this.H_renamed;
            if (arrayList2 != null) {
                arrayList2.clear();
                this.H_renamed = null;
            }
            java.util.HashMap<java.lang.String, java.lang.String> map = this.I_renamed;
            if (map != null) {
                map.clear();
                this.I_renamed = null;
            }
        }
    }

    public void setShowBeauty3DFace(boolean z_renamed) {
        this.Q_renamed = z_renamed;
    }

    public void setMainFaceIndex(int i_renamed) {
        this.S_renamed = i_renamed;
    }

    public boolean f_renamed() {
        android.hardware.camera2.params.Face[] faceArr = this.k_renamed;
        return faceArr == null || faceArr.length == 0 || !(this.u_renamed || this.O_renamed);
    }

    public void g_renamed() {
        com.oplus.camera.ui.preview.k_renamed kVar = this.V_renamed;
        if (kVar != null) {
            kVar.a_renamed();
        }
    }

    public void setFacePointAnimationListener(com.oplus.camera.ui.preview.k_renamed.b_renamed bVar) {
        com.oplus.camera.ui.preview.k_renamed kVar = this.V_renamed;
        if (kVar != null) {
            kVar.a_renamed(bVar);
        }
    }

    public void a_renamed(boolean z_renamed, float f_renamed) {
        this.v_renamed = z_renamed;
        this.x_renamed = (getWidth() * (1.0f - f_renamed)) / 2.0f;
    }

    private void a_renamed(android.graphics.RectF rectF) {
        if (this.v_renamed) {
            if (rectF.right > getRight() - this.x_renamed) {
                rectF.right = getRight() - this.x_renamed;
            } else {
                float f_renamed = rectF.right;
                float f2 = this.x_renamed;
                if (f_renamed < f2) {
                    rectF.right = f2;
                }
            }
            if (rectF.left < getLeft() + this.x_renamed) {
                rectF.left = getLeft() + this.x_renamed;
            } else if (rectF.left > getRight() - this.x_renamed) {
                rectF.left = getRight() - this.x_renamed;
            }
            if (rectF.bottom > getBottom()) {
                rectF.bottom = getBottom();
            } else if (rectF.bottom < 0.0f) {
                rectF.bottom = 0.0f;
            }
            if (rectF.top > getBottom()) {
                rectF.top = getBottom();
            } else if (rectF.top < 0.0f) {
                rectF.top = 0.0f;
            }
        }
    }
}
