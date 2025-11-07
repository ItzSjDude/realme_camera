package com.oplus.camera.ui.preview;

/* compiled from: GuideLineView.java */
/* loaded from: classes2.dex */
public class r_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Paint f7129a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f7130b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f7131c;
    private java.lang.String d_renamed;
    private java.util.List<com.oplus.camera.ui.preview.r_renamed.b_renamed> e_renamed;
    private android.graphics.PointF f_renamed;
    private com.oplus.camera.ui.preview.r_renamed.c_renamed g_renamed;
    private com.oplus.camera.ui.preview.r_renamed.a_renamed h_renamed;
    private com.oplus.camera.ui.preview.r_renamed.a_renamed i_renamed;
    private int j_renamed;
    private android.graphics.Canvas k_renamed;
    private android.graphics.Bitmap l_renamed;
    private float m_renamed;

    public r_renamed(android.content.Context context) {
        super(context);
        this.f7129a = null;
        this.f7130b = null;
        this.f7131c = false;
        this.d_renamed = "grid";
        this.e_renamed = null;
        this.f_renamed = new android.graphics.PointF();
        this.g_renamed = new com.oplus.camera.ui.preview.r_renamed.c_renamed();
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = 0;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = 0.0f;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.m_renamed = context.getResources().getDimension(com.oplus.camera.R_renamed.dimen.guideline_stroke_width);
        this.f7129a = new android.graphics.Paint();
        this.f7129a.setStyle(android.graphics.Paint.Style.STROKE);
        this.f7129a.setColor(android.graphics.Color.parseColor("#A6ffffff"));
        this.f7129a.setStrokeWidth(this.m_renamed);
        this.f7129a.setAntiAlias(true);
        this.f7130b = new android.graphics.Paint();
        this.h_renamed = new com.oplus.camera.ui.preview.r_renamed.a_renamed();
        this.h_renamed.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.r_renamed.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                com.oplus.camera.ui.preview.r_renamed.this.setVisibility(0);
            }
        });
        this.i_renamed = new com.oplus.camera.ui.preview.r_renamed.a_renamed();
        this.i_renamed.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.r_renamed.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.oplus.camera.ui.preview.r_renamed.this.setVisibility(8);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            com.oplus.camera.e_renamed.f_renamed("GuideLineView", "onDraw, width or height <= 0");
            return;
        }
        if (this.f7131c) {
            a_renamed(width, height);
            int iA = a_renamed();
            java.lang.String str = this.d_renamed;
            char c2 = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != -895939855) {
                if (iHashCode != 3181382) {
                    if (iHashCode == 1497762312 && str.equals("triangle")) {
                        c2 = 1;
                    }
                } else if (str.equals("grid")) {
                    c2 = 0;
                }
            } else if (str.equals("spiral")) {
                c2 = 2;
            }
            if (c2 == 0) {
                c_renamed(0, 0, width, height);
            } else if (c2 == 1) {
                b_renamed(0, 0, width, height);
            } else if (c2 == 2) {
                float f_renamed = 0;
                float f2 = this.m_renamed;
                int i_renamed = (int) (f_renamed + f2);
                int i2 = (int) (f_renamed + f2);
                int iD = com.oplus.camera.util.Util.d_renamed(height, width);
                if (1 == iD || 5 == iD) {
                    float f3 = this.m_renamed;
                    width = (int) (width - (f3 * 2.0f));
                    height = (int) (height - (f3 * 2.0f));
                }
                a_renamed(i_renamed, i2, width, height);
            }
            for (int i3 = 0; i3 < iA; i3++) {
                com.oplus.camera.ui.preview.r_renamed.b_renamed bVar = this.e_renamed.get(i3);
                if (bVar.f7138b == 0) {
                    this.k_renamed.drawLine(bVar.f7139c.x_renamed, bVar.f7139c.y_renamed, bVar.d_renamed.x_renamed, bVar.d_renamed.y_renamed, this.f7129a);
                } else if (1 == bVar.f7138b) {
                    this.k_renamed.drawArc(bVar.g_renamed, bVar.e_renamed, bVar.f_renamed, bVar.h_renamed, this.f7129a);
                }
            }
            this.f7130b.setAlpha(this.j_renamed);
            canvas.drawBitmap(this.l_renamed, 0.0f, 0.0f, this.f7130b);
        }
    }

    private void a_renamed(int i_renamed, int i2) {
        android.graphics.Canvas canvas = this.k_renamed;
        if (canvas == null || i_renamed != canvas.getWidth() || i2 != this.k_renamed.getHeight()) {
            this.k_renamed = new android.graphics.Canvas();
        }
        android.graphics.Bitmap bitmap = this.l_renamed;
        if (bitmap != null) {
            if (i_renamed != bitmap.getWidth() || i2 != this.l_renamed.getHeight()) {
                this.l_renamed.recycle();
                this.l_renamed = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
            }
        } else {
            this.l_renamed = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        }
        this.k_renamed.setBitmap(this.l_renamed);
        this.k_renamed.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.graphics.Bitmap bitmap = this.l_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.l_renamed = null;
        }
    }

    private void a_renamed(int i_renamed, int i2, int i3, int i4) {
        float f_renamed = i3;
        float f2 = i4;
        if ((1.0f * f_renamed) / f2 >= this.g_renamed.g_renamed) {
            this.g_renamed.i_renamed = f2;
            com.oplus.camera.ui.preview.r_renamed.c_renamed cVar = this.g_renamed;
            cVar.h_renamed = cVar.i_renamed * this.g_renamed.g_renamed;
            com.oplus.camera.ui.preview.r_renamed.c_renamed cVar2 = this.g_renamed;
            cVar2.j_renamed = (f_renamed - cVar2.h_renamed) * 0.5f;
            this.g_renamed.k_renamed = 0.0f;
        } else {
            this.g_renamed.h_renamed = f_renamed;
            com.oplus.camera.ui.preview.r_renamed.c_renamed cVar3 = this.g_renamed;
            cVar3.i_renamed = cVar3.h_renamed / this.g_renamed.g_renamed;
            this.g_renamed.j_renamed = 0.0f;
            com.oplus.camera.ui.preview.r_renamed.c_renamed cVar4 = this.g_renamed;
            cVar4.k_renamed = (f2 - cVar4.i_renamed) * 0.5f;
        }
        int i5 = 0;
        this.e_renamed.get(0).a_renamed(i_renamed + this.g_renamed.j_renamed, (i2 + i4) - this.g_renamed.k_renamed, this.g_renamed.a_renamed(0), this.g_renamed.b_renamed(0), 0, 90);
        int i6 = 1;
        while (i6 < 9) {
            int i7 = i5 + 1;
            com.oplus.camera.ui.preview.r_renamed.b_renamed bVar = this.e_renamed.get(i5);
            this.e_renamed.get(i7).a_renamed(bVar.f7139c.x_renamed, bVar.f7139c.y_renamed, this.g_renamed.a_renamed(i7), this.g_renamed.b_renamed(i7), bVar.e_renamed - 90, 90);
            i6++;
            i5 = i7;
        }
        com.oplus.camera.ui.preview.r_renamed.b_renamed bVar2 = this.e_renamed.get(4);
        this.e_renamed.get(i5 + 1).a_renamed(bVar2.d_renamed.x_renamed, bVar2.d_renamed.y_renamed, bVar2.f7139c.x_renamed, bVar2.d_renamed.y_renamed);
    }

    private void b_renamed(int i_renamed, int i2, int i3, int i4) {
        float f_renamed = i_renamed + i3;
        float f2 = i2;
        float f3 = i_renamed;
        this.e_renamed.get(0).a_renamed(f_renamed, f2, f3, i2 + i4);
        float f4 = i3;
        float f5 = i4;
        this.f_renamed.set((f4 * 0.33333334f) + f3, (f5 * 0.6666667f) + f2);
        this.e_renamed.get(1).a_renamed(f3, (float) ((java.lang.Math.pow(f3 - this.f_renamed.x_renamed, 2.0d) / (this.f_renamed.y_renamed - r2)) + this.f_renamed.y_renamed), this.f_renamed.x_renamed, this.f_renamed.y_renamed);
        this.f_renamed.set(f3 + (f4 * 0.6666667f), (f5 * 0.33333334f) + f2);
        this.e_renamed.get(2).a_renamed(f_renamed, (float) ((java.lang.Math.pow(f_renamed - this.f_renamed.x_renamed, 2.0d) / (this.f_renamed.y_renamed - f2)) + this.f_renamed.y_renamed), this.f_renamed.x_renamed, this.f_renamed.y_renamed);
    }

    private void c_renamed(int i_renamed, int i2, int i3, int i4) {
        float f_renamed = i_renamed;
        float f2 = i2;
        float f3 = i4;
        float f4 = (f3 * 0.33333334f) + f2;
        float f5 = i_renamed + i3;
        this.e_renamed.get(0).a_renamed(f_renamed, f4, f5, f4);
        float f6 = (f3 * 0.6666667f) + f2;
        this.e_renamed.get(1).a_renamed(f_renamed, f6, f5, f6);
        float f7 = i3;
        float f8 = (0.33333334f * f7) + f_renamed;
        float f9 = i2 + i4;
        this.e_renamed.get(2).a_renamed(f8, f2, f8, f9);
        float f10 = f_renamed + (f7 * 0.6666667f);
        this.e_renamed.get(3).a_renamed(f10, f2, f10, f9);
    }

    public void a_renamed(java.lang.String str) {
        if (str == null || "off".equals(str)) {
            a_renamed(false);
            return;
        }
        this.d_renamed = str;
        if (this.f7131c) {
            return;
        }
        this.f7131c = true;
        setVisibility(0);
        if (this.h_renamed != null) {
            clearAnimation();
            setAnimation(this.h_renamed);
            this.h_renamed.a_renamed(0.0f, 127.5f);
        }
    }

    private int a_renamed() {
        if (this.e_renamed == null) {
            this.e_renamed = new java.util.ArrayList();
        }
        java.lang.String str = this.d_renamed;
        char c2 = 65535;
        int iHashCode = str.hashCode();
        int i_renamed = 0;
        if (iHashCode != -895939855) {
            if (iHashCode != 3181382) {
                if (iHashCode == 1497762312 && str.equals("triangle")) {
                    c2 = 1;
                }
            } else if (str.equals("grid")) {
                c2 = 0;
            }
        } else if (str.equals("spiral")) {
            c2 = 2;
        }
        if (c2 == 0) {
            i_renamed = 4;
        } else if (c2 == 1) {
            i_renamed = 3;
        } else if (c2 == 2) {
            i_renamed = 10;
        }
        while (this.e_renamed.size() < i_renamed) {
            this.e_renamed.add(new com.oplus.camera.ui.preview.r_renamed.b_renamed(new android.graphics.PointF(0.0f, 0.0f), new android.graphics.PointF(0.0f, 0.0f)));
        }
        return i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        if (this.f7131c) {
            this.f7131c = false;
            clearAnimation();
            if (z_renamed) {
                setAnimation(this.i_renamed);
                this.i_renamed.a_renamed(127.5f, 0.0f);
            } else {
                setVisibility(8);
            }
        }
    }

    /* compiled from: GuideLineView.java */
    private class a_renamed extends android.view.animation.Animation {

        /* renamed from: b_renamed, reason: collision with root package name */
        private float f7135b = 0.0f;

        /* renamed from: c_renamed, reason: collision with root package name */
        private float f7136c = 0.0f;

        public a_renamed() {
            setDuration(310L);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f_renamed, android.view.animation.Transformation transformation) {
            float f2 = this.f7136c;
            float f3 = this.f7135b;
            com.oplus.camera.ui.preview.r_renamed.this.j_renamed = (int) (((f2 - f3) * f_renamed) + f3);
            com.oplus.camera.ui.preview.r_renamed.this.invalidate();
        }

        public void a_renamed(float f_renamed, float f2) {
            this.f7135b = f_renamed;
            this.f7136c = f2;
            start();
        }
    }

    /* compiled from: GuideLineView.java */
    public static class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final int[] f7140a = {0, 1, 3, 5, 7};

        /* renamed from: b_renamed, reason: collision with root package name */
        private static final int[] f7141b = {1, 2, 4, 6, 8};

        /* renamed from: c_renamed, reason: collision with root package name */
        private static final int[] f7142c = {4, 5, 6, 7};
        private float[] d_renamed = new float[9];
        private float e_renamed = 0.0f;
        private float f_renamed = 0.0f;
        private float g_renamed = 0.0f;
        private float h_renamed = 0.0f;
        private float i_renamed = 0.0f;
        private float j_renamed = 0.0f;
        private float k_renamed = 0.0f;

        public c_renamed() {
            a_renamed();
        }

        private void a_renamed() {
            float[] fArr = this.d_renamed;
            fArr[0] = 1.0f;
            fArr[1] = 1.0f;
            int i_renamed = 2;
            while (true) {
                float[] fArr2 = this.d_renamed;
                if (i_renamed >= fArr2.length) {
                    break;
                }
                fArr2[i_renamed] = fArr2[i_renamed - 1] + fArr2[i_renamed - 2];
                i_renamed++;
            }
            for (int i2 : f7140a) {
                this.e_renamed += this.d_renamed[i2];
            }
            for (int i3 : f7141b) {
                this.f_renamed += this.d_renamed[i3];
            }
            this.g_renamed = this.e_renamed / this.f_renamed;
        }

        public float a_renamed(int i_renamed) {
            return (this.d_renamed[(r0.length - 1) - i_renamed] * this.h_renamed) / this.e_renamed;
        }

        public boolean b_renamed(int i_renamed) {
            for (int i2 : f7142c) {
                if (i2 == (this.d_renamed.length - 1) - i_renamed) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: GuideLineView.java */
    public class b_renamed {

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.graphics.PointF f7139c;
        private android.graphics.PointF d_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f7138b = 0;
        private int e_renamed = 0;
        private int f_renamed = 0;
        private android.graphics.RectF g_renamed = null;
        private boolean h_renamed = false;

        public b_renamed(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
            this.f7139c = null;
            this.d_renamed = null;
            this.f7139c = pointF;
            this.d_renamed = pointF2;
        }

        public void a_renamed(float f_renamed, float f2, float f3, float f4) {
            this.f7139c.set(f_renamed, f2);
            this.d_renamed.set(f3, f4);
            this.f7138b = 0;
        }

        public void a_renamed(float f_renamed, float f2, float f3, boolean z_renamed, int i_renamed, int i2) {
            this.d_renamed.set(f_renamed, f2);
            this.e_renamed = i_renamed;
            this.f_renamed = i2;
            this.h_renamed = z_renamed;
            this.f7138b = 1;
            if (this.g_renamed == null) {
                this.g_renamed = new android.graphics.RectF();
            }
            int i3 = i_renamed % 360;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 == 0) {
                float f4 = f_renamed + f3;
                this.f7139c.set(f4, f2 - f3);
                this.g_renamed.set(f_renamed - f3, f2 - (f3 * 2.0f), f4, f2);
                return;
            }
            if (i3 == 90) {
                float f5 = f2 + f3;
                this.f7139c.set(f_renamed + f3, f5);
                this.g_renamed.set(f_renamed, f2 - f3, (f3 * 2.0f) + f_renamed, f5);
            } else if (i3 == 180) {
                float f6 = f_renamed - f3;
                this.f7139c.set(f6, f2 + f3);
                this.g_renamed.set(f6, f2, f_renamed + f3, (f3 * 2.0f) + f2);
            } else {
                if (i3 != 270) {
                    return;
                }
                float f7 = f2 - f3;
                this.f7139c.set(f_renamed - f3, f7);
                this.g_renamed.set(f_renamed - (2.0f * f3), f7, f_renamed, f2 + f3);
            }
        }
    }
}
