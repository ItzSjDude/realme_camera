package com.oplus.camera.ui.preview;

/* compiled from: FacePointAnimationManager.java */
/* loaded from: classes2.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[][] f7081a = {new int[]{121}, new int[]{115, 127}, new int[]{110, 132}, new int[]{-1, 118, 39, -1, 124, 36}, new int[]{-1, 38, 37}, new int[]{105, 104}, new int[]{106, 136}, new int[]{44}, new int[]{30, 3}, new int[]{46}, new int[]{-1, 81, 61, -1, 82, 52}, new int[]{-1, 49, 87}, new int[]{25, 8}, new int[]{90, 96}, new int[]{16}};
    private com.oplus.camera.ui.preview.FaceView h_renamed;
    private boolean j_renamed;
    private android.view.animation.Interpolator m_renamed;
    private android.view.animation.Interpolator n_renamed;
    private android.view.animation.Interpolator o_renamed;
    private android.view.animation.Interpolator p_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int[] f7082b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.util.Size f7083c = null;
    private int d_renamed = 0;
    private boolean e_renamed = false;
    private android.graphics.Matrix f_renamed = new android.graphics.Matrix();
    private java.util.List<com.oplus.camera.ui.preview.j_renamed> g_renamed = new java.util.ArrayList();
    private boolean i_renamed = false;
    private java.util.Random k_renamed = new java.util.Random();
    private com.oplus.camera.ui.preview.k_renamed.b_renamed l_renamed = null;
    private android.os.Handler q_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.preview.k_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (com.oplus.camera.ui.preview.k_renamed.this.j_renamed) {
                return;
            }
            int i_renamed = message.what;
            if (i_renamed == 1) {
                if (com.oplus.camera.ui.preview.k_renamed.this.l_renamed != null) {
                    com.oplus.camera.ui.preview.k_renamed.this.l_renamed.al_renamed();
                }
                com.oplus.camera.ui.preview.k_renamed.this.c_renamed();
            } else {
                if (i_renamed != 2) {
                    return;
                }
                if (com.oplus.camera.ui.preview.k_renamed.this.i_renamed || com.oplus.camera.ui.preview.k_renamed.this.l_renamed == null || !com.oplus.camera.ui.preview.k_renamed.this.l_renamed.am_renamed()) {
                    com.oplus.camera.ui.preview.k_renamed.this.q_renamed.sendEmptyMessageDelayed(2, 50L);
                } else {
                    com.oplus.camera.ui.preview.k_renamed.this.a_renamed();
                }
            }
        }
    };

    /* compiled from: FacePointAnimationManager.java */
    private enum a_renamed {
        ALPHA,
        SCALE,
        TRANSLATION_X,
        TRANSLATION_Y
    }

    /* compiled from: FacePointAnimationManager.java */
    public interface b_renamed {
        void ak_renamed();

        void al_renamed();

        boolean am_renamed();
    }

    public k_renamed(com.oplus.camera.ui.preview.FaceView faceView) {
        this.h_renamed = null;
        this.j_renamed = false;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.j_renamed = false;
        this.h_renamed = faceView;
        this.m_renamed = android.view.animation.AnimationUtils.loadInterpolator(this.h_renamed.getContext(), com.oplus.camera.R_renamed.anim.face_point_scale_interpolator1);
        this.n_renamed = android.view.animation.AnimationUtils.loadInterpolator(this.h_renamed.getContext(), com.oplus.camera.R_renamed.anim.face_point_scale_interpolator2);
        this.o_renamed = android.view.animation.AnimationUtils.loadInterpolator(this.h_renamed.getContext(), com.oplus.camera.R_renamed.anim.face_point_scale_interpolator3);
        this.p_renamed = android.view.animation.AnimationUtils.loadInterpolator(this.h_renamed.getContext(), com.oplus.camera.R_renamed.anim.face_point_translation_interpolator);
    }

    public void a_renamed(android.util.Size size) {
        this.f7083c = size;
    }

    public void a_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    public void a_renamed(android.graphics.Canvas canvas) {
        if (this.h_renamed == null || this.f7082b == null || this.g_renamed.size() == 0 || this.f7083c == null || !this.i_renamed) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.preview.j_renamed> it = this.g_renamed.iterator();
        while (it.hasNext()) {
            for (com.oplus.camera.ui.preview.l_renamed lVar : it.next().a_renamed()) {
                if (lVar.f_renamed()) {
                    float fQ_renamed = lVar.q_renamed();
                    float fR_renamed = lVar.r_renamed();
                    canvas.drawCircle(fQ_renamed, fR_renamed, lVar.n_renamed(), lVar.u_renamed());
                    canvas.drawCircle(fQ_renamed, fR_renamed, lVar.m_renamed(), lVar.t_renamed());
                    canvas.drawCircle(fQ_renamed, fR_renamed, lVar.l_renamed(), lVar.s_renamed());
                }
            }
        }
    }

    public void a_renamed(int[] iArr) {
        com.oplus.camera.ui.preview.FaceView faceView;
        this.f7082b = iArr;
        if (iArr == null || (faceView = this.h_renamed) == null || faceView.getWidth() <= 0) {
            return;
        }
        com.oplus.camera.ui.preview.k_renamed.b_renamed bVar = this.l_renamed;
        if (bVar != null && !bVar.am_renamed()) {
            c_renamed();
            return;
        }
        if (this.i_renamed) {
            try {
                f_renamed();
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                c_renamed();
            }
        }
    }

    private void f_renamed() {
        int i_renamed;
        char c2;
        int i2;
        int i3;
        int i4;
        int iCenterX;
        int iCenterY;
        int i5;
        int[] iArr = this.f7082b;
        if (iArr == null) {
            return;
        }
        int i6 = iArr[3];
        char c3 = 1;
        int i7 = iArr[1];
        if (i7 == 0) {
            return;
        }
        int i8 = 0;
        if (i7 < this.g_renamed.size()) {
            this.g_renamed = this.g_renamed.subList(0, i7);
        }
        int i9 = 0;
        int i10 = 0;
        while (i10 < i7) {
            int i11 = i10 == 0 ? 12 : i9 + i6;
            int i12 = i11 + i6;
            int[] iArrCopyOfRange = java.util.Arrays.copyOfRange(this.f7082b, i11, i12);
            int i13 = i12 + i6;
            int[] iArrCopyOfRange2 = java.util.Arrays.copyOfRange(this.f7082b, i12, i13);
            android.graphics.RectF rectFA = a_renamed(iArrCopyOfRange[i8], iArrCopyOfRange2[i8], iArrCopyOfRange[32], iArrCopyOfRange2[32]);
            if (this.g_renamed.size() == 0 || i10 >= this.g_renamed.size()) {
                float[] fArrA = a_renamed(iArrCopyOfRange[45], iArrCopyOfRange2[45]);
                float f_renamed = fArrA[i8];
                float f2 = fArrA[c3];
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int i14 = i8;
                while (i14 < f7081a.length) {
                    int iNextInt = this.k_renamed.nextInt(2);
                    int i15 = i8;
                    while (true) {
                        int[][] iArr2 = f7081a;
                        if (i15 < iArr2[i14].length) {
                            int i16 = iArr2[i14][i15];
                            if (i16 < 0) {
                                int i17 = iArr2[i14][i15 + 1];
                                i5 = i15 + 2;
                                int i18 = iArr2[i14][i5];
                                float f3 = iArrCopyOfRange[i17];
                                i3 = i15;
                                float f4 = iArrCopyOfRange2[i17];
                                i4 = iNextInt;
                                android.graphics.RectF rectF = new android.graphics.RectF(f3, f4, iArrCopyOfRange[i18], iArrCopyOfRange2[i18]);
                                iCenterX = (int) rectF.centerX();
                                iCenterY = (int) rectF.centerY();
                            } else {
                                i3 = i15;
                                i4 = iNextInt;
                                iCenterX = iArrCopyOfRange[i16];
                                iCenterY = iArrCopyOfRange2[i16];
                                i5 = i3;
                            }
                            int i19 = i3;
                            int i20 = i6;
                            int i21 = i4;
                            int i22 = i7;
                            int i23 = i14;
                            int[] iArr3 = iArrCopyOfRange;
                            java.util.ArrayList arrayList2 = arrayList;
                            com.oplus.camera.ui.preview.l_renamed lVarA = a_renamed(iCenterX, iCenterY, f_renamed, f2, rectFA);
                            lVarA.a_renamed(i16);
                            lVarA.b_renamed(i21);
                            lVarA.c_renamed(i23);
                            lVarA.d_renamed(i19);
                            if (i21 == 0) {
                                lVarA.s_renamed().setAlpha(153);
                            } else {
                                lVarA.s_renamed().setAlpha(229);
                            }
                            arrayList2.add(lVarA);
                            i15 = i5 + 1;
                            c3 = 1;
                            iNextInt = i21;
                            i14 = i23;
                            arrayList = arrayList2;
                            i7 = i22;
                            i6 = i20;
                            iArrCopyOfRange = iArr3;
                        }
                    }
                    i14++;
                    i7 = i7;
                    iArrCopyOfRange = iArrCopyOfRange;
                    i8 = 0;
                }
                i_renamed = i6;
                c2 = c3;
                i2 = i7;
                this.g_renamed.add(new com.oplus.camera.ui.preview.j_renamed(arrayList));
            } else {
                a_renamed(iArrCopyOfRange, iArrCopyOfRange2, this.g_renamed.get(i10), rectFA);
                i_renamed = i6;
                c2 = c3;
                i2 = i7;
            }
            i10++;
            c3 = c2;
            i9 = i13;
            i7 = i2;
            i6 = i_renamed;
            i8 = 0;
        }
    }

    private void a_renamed(int[] iArr, int[] iArr2, com.oplus.camera.ui.preview.j_renamed jVar, android.graphics.RectF rectF) {
        int iCenterY;
        int iCenterX;
        java.util.List<com.oplus.camera.ui.preview.l_renamed> listA = jVar.a_renamed();
        int size = listA.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.oplus.camera.ui.preview.l_renamed lVar = listA.get(i_renamed);
            int iB = lVar.b_renamed();
            float fD_renamed = lVar.d_renamed();
            float fE_renamed = lVar.e_renamed();
            if (iB < 0) {
                int i2 = f7081a[lVar.h_renamed()][lVar.v_renamed() + 1];
                int i3 = f7081a[lVar.h_renamed()][lVar.v_renamed() + 2];
                android.graphics.RectF rectF2 = new android.graphics.RectF(iArr[i2], iArr2[i2], iArr[i3], iArr2[i3]);
                iCenterX = (int) rectF2.centerX();
                iCenterY = (int) rectF2.centerY();
            } else {
                int i4 = iArr[iB];
                iCenterY = iArr2[iB];
                iCenterX = i4;
            }
            float[] fArrA = a_renamed(iCenterX, iCenterY);
            double dE_renamed = (lVar.e_renamed() - fArrA[1]) / java.lang.Math.sin(java.lang.Math.atan2(lVar.e_renamed() - fArrA[1], lVar.d_renamed() - fArrA[0]));
            if (30.0d < dE_renamed) {
                lVar.a_renamed(rectF.width() * 0.2f * 0.5f);
                lVar.b_renamed(fArrA[0]);
                lVar.c_renamed(fArrA[1]);
            }
            if (30.0d < dE_renamed && !lVar.a_renamed()) {
                lVar.j_renamed(fD_renamed);
                lVar.k_renamed(fE_renamed);
                a_renamed(lVar, 100, new android.view.animation.LinearInterpolator(), 0).start();
            }
        }
    }

    private com.oplus.camera.ui.preview.l_renamed a_renamed(int i_renamed, int i2, float f_renamed, float f2, android.graphics.RectF rectF) {
        com.oplus.camera.ui.preview.l_renamed lVar = new com.oplus.camera.ui.preview.l_renamed();
        float[] fArrA = a_renamed(i_renamed, i2);
        lVar.a_renamed(rectF.width() * 0.2f * 0.5f);
        lVar.b_renamed(fArrA[0]);
        lVar.c_renamed(fArrA[1]);
        double dAtan2 = java.lang.Math.atan2(f2 - lVar.e_renamed(), f_renamed - lVar.d_renamed());
        double dE_renamed = ((f2 - lVar.e_renamed()) / java.lang.Math.sin(dAtan2)) + 200.0d;
        lVar.j_renamed((float) (f_renamed - (java.lang.Math.cos(dAtan2) * dE_renamed)));
        lVar.k_renamed((float) (f2 - (dE_renamed * java.lang.Math.sin(dAtan2))));
        lVar.l_renamed(0.0f);
        lVar.m_renamed(0.0f);
        lVar.s_renamed().setColor(-1);
        lVar.s_renamed().setAntiAlias(true);
        lVar.s_renamed().setStyle(android.graphics.Paint.Style.FILL);
        lVar.t_renamed().set(lVar.s_renamed());
        lVar.t_renamed().setAlpha(0);
        lVar.u_renamed().set(lVar.s_renamed());
        lVar.u_renamed().setAlpha(0);
        return lVar;
    }

    private float[] a_renamed(int i_renamed, int i2) {
        int width = this.h_renamed.getWidth();
        int height = this.h_renamed.getHeight();
        this.f_renamed.reset();
        this.f_renamed.setTranslate((-this.f7083c.getWidth()) / 2, (-this.f7083c.getHeight()) / 2);
        this.f_renamed.postScale(this.e_renamed ? -1.0f : 1.0f, 1.0f);
        this.f_renamed.postRotate(this.d_renamed);
        this.f_renamed.postScale((width * 1.0f) / this.f7083c.getHeight(), (height * 1.0f) / this.f7083c.getWidth());
        this.f_renamed.postTranslate(width / 2, height / 2);
        float[] fArr = {i_renamed, i2};
        this.f_renamed.mapPoints(fArr);
        return fArr;
    }

    private android.graphics.RectF a_renamed(int i_renamed, int i2, int i3, int i4) {
        int width = this.h_renamed.getWidth();
        int height = this.h_renamed.getHeight();
        this.f_renamed.reset();
        this.f_renamed.setTranslate((-this.f7083c.getWidth()) / 2, (-this.f7083c.getHeight()) / 2);
        this.f_renamed.postScale(this.e_renamed ? -1.0f : 1.0f, 1.0f);
        this.f_renamed.postRotate(this.d_renamed);
        this.f_renamed.postScale((width * 1.0f) / this.f7083c.getHeight(), (height * 1.0f) / this.f7083c.getWidth());
        this.f_renamed.postTranslate(width / 2, height / 2);
        android.graphics.RectF rectF = new android.graphics.RectF(i_renamed, i2, i3, i4);
        this.f_renamed.mapRect(rectF);
        return rectF;
    }

    public void a_renamed() {
        com.oplus.camera.ui.preview.FaceView faceView = this.h_renamed;
        if (faceView == null || this.i_renamed) {
            return;
        }
        int[] iArr = this.f7082b;
        if (iArr != null && iArr.length != 0 && faceView.getWidth() > 0) {
            if (this.f7082b[1] != 0) {
                this.g_renamed.clear();
                int i_renamed = this.f7082b[1];
                try {
                    f_renamed();
                    java.util.Iterator<com.oplus.camera.ui.preview.j_renamed> it = this.g_renamed.iterator();
                    while (it.hasNext()) {
                        for (com.oplus.camera.ui.preview.l_renamed lVar : it.next().a_renamed()) {
                            if (!lVar.f_renamed()) {
                                a_renamed(lVar);
                            }
                        }
                    }
                    this.i_renamed = i_renamed > 0;
                    com.oplus.camera.ui.preview.k_renamed.b_renamed bVar = this.l_renamed;
                    if (bVar == null || !this.i_renamed) {
                        return;
                    }
                    bVar.ak_renamed();
                    return;
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    c_renamed();
                    return;
                }
            }
        }
        this.q_renamed.removeMessages(2);
        this.q_renamed.sendEmptyMessageDelayed(2, 50L);
    }

    private void a_renamed(com.oplus.camera.ui.preview.l_renamed lVar) {
        if (this.j_renamed) {
            return;
        }
        int iH = lVar.h_renamed() * 50;
        lVar.a_renamed(true);
        android.animation.ValueAnimator valueAnimatorA = a_renamed(lVar, 250, this.p_renamed, iH);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 0, iH, 400, this.m_renamed, 0.0f, 0.45f);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar2 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 0, 0, 767, this.n_renamed, 0.45f, 0.35f);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar3 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 0, 0, 600, this.o_renamed, 0.35f, 0.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playSequentially(cVar, cVar2, cVar3);
        float f_renamed = lVar.g_renamed() == 0 ? 0.32f : 0.48f;
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar4 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 1, iH, 400, this.n_renamed, 0.2f, f_renamed);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar5 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 1, 0, 367, this.n_renamed, f_renamed, 0.2f);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar6 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 1, 0, 400, this.n_renamed, 0.2f, f_renamed);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar7 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 1, 0, 367, this.n_renamed, f_renamed, 0.2f);
        android.animation.AnimatorSet animatorSet2 = new android.animation.AnimatorSet();
        animatorSet2.playSequentially(cVar4, cVar5, cVar6, cVar7);
        float f2 = lVar.g_renamed() == 0 ? 0.61f : 0.77f;
        int i_renamed = iH + 767;
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar8 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 2, i_renamed, 400, this.n_renamed, 0.16f, f2);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar9 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 2, 0, 367, this.n_renamed, f2, 0.16f);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar10 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.ALPHA, 2, i_renamed, 400, this.n_renamed, 0.0f, 0.1f);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar11 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.ALPHA, 2, 0, 367, this.n_renamed, 0.1f, 0.0f);
        android.animation.AnimatorSet animatorSet3 = new android.animation.AnimatorSet();
        animatorSet3.playSequentially(cVar8, cVar9);
        android.animation.AnimatorSet animatorSet4 = new android.animation.AnimatorSet();
        animatorSet4.playSequentially(cVar10, cVar11);
        float f3 = lVar.g_renamed() == 0 ? 0.84f : 1.0f;
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar12 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 3, i_renamed, 400, this.n_renamed, 0.16f, f3);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar13 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE, 3, 0, 367, this.n_renamed, f3, 0.16f);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar14 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.ALPHA, 3, i_renamed, 400, this.n_renamed, 0.0f, 0.1f);
        com.oplus.camera.ui.preview.k_renamed.c_renamed cVar15 = new com.oplus.camera.ui.preview.k_renamed.c_renamed(lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed.ALPHA, 3, 0, 367, this.n_renamed, 0.1f, 0.0f);
        android.animation.AnimatorSet animatorSet5 = new android.animation.AnimatorSet();
        animatorSet5.playSequentially(cVar12, cVar13);
        android.animation.AnimatorSet animatorSet6 = new android.animation.AnimatorSet();
        animatorSet6.playSequentially(cVar14, cVar15);
        animatorSet.playTogether(valueAnimatorA, animatorSet2, animatorSet3, animatorSet4, animatorSet5, animatorSet6);
        animatorSet.start();
    }

    private android.animation.ValueAnimator a_renamed(final com.oplus.camera.ui.preview.l_renamed lVar, int i_renamed, android.view.animation.Interpolator interpolator, int i2) {
        android.animation.ValueAnimator valueAnimatorOfObject = android.animation.ValueAnimator.ofObject(new android.animation.PointFEvaluator() { // from class: com.oplus.camera.ui.preview.k_renamed.2
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.animation.TypeEvaluator
            public android.graphics.PointF evaluate(float f_renamed, android.graphics.PointF pointF, android.graphics.PointF pointF2) {
                pointF.set(lVar.o_renamed(), lVar.p_renamed());
                pointF2.set(lVar.d_renamed(), lVar.e_renamed());
                return new android.graphics.PointF(pointF.x_renamed + ((pointF2.x_renamed - pointF.x_renamed) * f_renamed), pointF.y_renamed + (f_renamed * (pointF2.y_renamed - pointF.y_renamed)));
            }
        }, new android.graphics.PointF(), new android.graphics.PointF());
        valueAnimatorOfObject.setDuration(i_renamed);
        valueAnimatorOfObject.setStartDelay(i2);
        valueAnimatorOfObject.setInterpolator(interpolator);
        valueAnimatorOfObject.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.k_renamed.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (com.oplus.camera.ui.preview.k_renamed.this.j_renamed) {
                    valueAnimator.cancel();
                    return;
                }
                android.graphics.PointF pointF = (android.graphics.PointF) valueAnimator.getAnimatedValue();
                lVar.l_renamed(pointF.x_renamed);
                lVar.m_renamed(pointF.y_renamed);
                if (1.0f <= valueAnimator.getAnimatedFraction()) {
                    lVar.a_renamed(false);
                } else {
                    lVar.a_renamed(true);
                }
                com.oplus.camera.ui.preview.k_renamed.this.h_renamed.invalidate();
            }
        });
        return valueAnimatorOfObject;
    }

    public void a_renamed(com.oplus.camera.ui.preview.k_renamed.b_renamed bVar) {
        this.l_renamed = bVar;
    }

    public boolean b_renamed() {
        return this.i_renamed;
    }

    public void c_renamed() {
        b_renamed(true);
    }

    public void b_renamed(boolean z_renamed) {
        this.f7082b = null;
        java.util.List<com.oplus.camera.ui.preview.j_renamed> list = this.g_renamed;
        if (list != null) {
            list.clear();
            this.i_renamed = false;
        }
        android.os.Handler handler = this.q_renamed;
        if (handler == null || !z_renamed) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public void d_renamed() {
        android.os.Handler handler;
        if (this.l_renamed != null && (handler = this.q_renamed) != null && handler.hasMessages(1)) {
            this.l_renamed.al_renamed();
        }
        c_renamed();
        this.j_renamed = true;
        this.h_renamed = null;
    }

    public boolean e_renamed() {
        android.os.Handler handler;
        int[] iArr = this.f7082b;
        return (iArr != null && iArr.length > 0) || ((handler = this.q_renamed) != null && handler.hasMessages(2));
    }

    /* compiled from: FacePointAnimationManager.java */
    private class c_renamed extends android.animation.ValueAnimator implements android.animation.Animator.AnimatorListener, android.animation.ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.oplus.camera.ui.preview.l_renamed f7090b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private com.oplus.camera.ui.preview.k_renamed.a_renamed f7091c;
        private int d_renamed;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        public c_renamed(com.oplus.camera.ui.preview.l_renamed lVar, com.oplus.camera.ui.preview.k_renamed.a_renamed aVar, int i_renamed, int i2, int i3, android.view.animation.Interpolator interpolator, float... fArr) {
            this.f7090b = null;
            this.f7091c = com.oplus.camera.ui.preview.k_renamed.a_renamed.SCALE;
            this.d_renamed = 0;
            this.f7090b = lVar;
            this.d_renamed = i_renamed;
            setFloatValues(fArr);
            setDuration(i3);
            setStartDelay(i2);
            setInterpolator(interpolator);
            addUpdateListener(this);
            addListener(this);
            this.f7091c = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            if (com.oplus.camera.ui.preview.k_renamed.this.j_renamed) {
                cancel();
                return;
            }
            float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            if (com.oplus.camera.ui.preview.k_renamed.a_renamed.ALPHA == this.f7091c) {
                int i_renamed = (int) (fFloatValue * 255.0f);
                int i2 = this.d_renamed;
                if (1 == i2) {
                    this.f7090b.s_renamed().setAlpha(i_renamed);
                    return;
                } else if (2 == i2) {
                    this.f7090b.t_renamed().setAlpha(i_renamed);
                    return;
                } else {
                    if (3 == i2) {
                        this.f7090b.u_renamed().setAlpha(i_renamed);
                        return;
                    }
                    return;
                }
            }
            if (com.oplus.camera.ui.preview.k_renamed.a_renamed.TRANSLATION_X == this.f7091c) {
                this.f7090b.l_renamed(fFloatValue);
                return;
            }
            if (com.oplus.camera.ui.preview.k_renamed.a_renamed.TRANSLATION_Y == this.f7091c) {
                this.f7090b.m_renamed(fFloatValue);
                return;
            }
            int i3 = this.d_renamed;
            if (i3 != 0) {
                if (1 == i3) {
                    this.f7090b.d_renamed(fFloatValue);
                    return;
                } else if (2 == i3) {
                    this.f7090b.e_renamed(fFloatValue);
                    return;
                } else {
                    if (3 == i3) {
                        this.f7090b.f_renamed(fFloatValue);
                        return;
                    }
                    return;
                }
            }
            this.f7090b.n_renamed(fFloatValue);
            com.oplus.camera.ui.preview.l_renamed lVar = this.f7090b;
            lVar.g_renamed(lVar.i_renamed() * this.f7090b.c_renamed() * fFloatValue);
            com.oplus.camera.ui.preview.l_renamed lVar2 = this.f7090b;
            lVar2.h_renamed(lVar2.j_renamed() * this.f7090b.c_renamed() * fFloatValue);
            com.oplus.camera.ui.preview.l_renamed lVar3 = this.f7090b;
            lVar3.i_renamed(lVar3.k_renamed() * this.f7090b.c_renamed() * fFloatValue);
            com.oplus.camera.ui.preview.k_renamed.this.h_renamed.invalidate();
            com.oplus.camera.ui.preview.k_renamed.this.q_renamed.removeMessages(1);
            com.oplus.camera.ui.preview.k_renamed.this.q_renamed.sendEmptyMessageDelayed(1, 50L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (this.d_renamed == 0) {
                this.f7090b.b_renamed(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.d_renamed == 0) {
                this.f7090b.b_renamed(false);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            if (this.d_renamed == 0) {
                this.f7090b.b_renamed(false);
            }
        }
    }
}
