package com.oplus.camera.ui.widget;

/* compiled from: Wheel.java */
/* loaded from: classes2.dex */
public class f_renamed extends android.view.View {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final int f7279b = android.graphics.Color.argb(46, 255, 255, 255);

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int f7280c = android.graphics.Color.argb(255, 255, 255, 255);

    /* renamed from: a_renamed, reason: collision with root package name */
    public final android.graphics.Rect f7281a;
    private final java.util.List<com.oplus.camera.ui.widget.f_renamed.a_renamed> d_renamed;
    private int e_renamed;
    private android.graphics.drawable.Drawable f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private android.graphics.drawable.Drawable j_renamed;
    private com.oplus.camera.ui.widget.f_renamed.c_renamed k_renamed;
    private android.graphics.Bitmap l_renamed;
    private android.graphics.Bitmap m_renamed;
    private int n_renamed;
    private final android.graphics.Rect o_renamed;
    private final android.graphics.Rect p_renamed;
    private android.graphics.Paint q_renamed;
    private boolean r_renamed;
    private int s_renamed;
    private int t_renamed;
    private float u_renamed;
    private final android.graphics.Rect v_renamed;
    private float w_renamed;
    private int x_renamed;
    private android.graphics.drawable.Drawable y_renamed;
    private float z_renamed;

    /* compiled from: Wheel.java */
    public static abstract class a_renamed {
        public void a_renamed(com.oplus.camera.ui.widget.f_renamed fVar) {
        }

        public void a_renamed(com.oplus.camera.ui.widget.f_renamed fVar, int i_renamed, boolean z_renamed) {
        }

        public void b_renamed(com.oplus.camera.ui.widget.f_renamed fVar) {
        }
    }

    /* compiled from: Wheel.java */
    public static class c_renamed extends android.graphics.drawable.Drawable {

        /* renamed from: a_renamed, reason: collision with root package name */
        protected int f7285a;

        /* renamed from: b_renamed, reason: collision with root package name */
        protected int f7286b;

        /* renamed from: c_renamed, reason: collision with root package name */
        protected int f7287c;
        protected final float d_renamed;
        protected final int e_renamed;
        protected int g_renamed;
        protected final int h_renamed;
        protected final int f_renamed = 0;
        protected final android.graphics.Paint i_renamed = new android.graphics.Paint();

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public c_renamed(android.content.res.Resources resources, int i_renamed) {
            this.e_renamed = i_renamed;
            this.h_renamed = com.oplus.camera.ui.widget.f_renamed.a_renamed(resources, 12.0f);
            this.d_renamed = com.oplus.camera.ui.widget.f_renamed.a_renamed(resources, 7.0f);
            this.i_renamed.setStyle(android.graphics.Paint.Style.STROKE);
            this.i_renamed.setStrokeWidth(com.oplus.camera.ui.widget.f_renamed.a_renamed(resources, 1.5f));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            int i_renamed;
            android.graphics.Rect bounds = getBounds();
            if (this.e_renamed == 0 && (i_renamed = this.h_renamed) > 0) {
                int iWidth = (int) (bounds.width() / this.d_renamed);
                int i2 = ((bounds.top + bounds.bottom) / 2) - (this.h_renamed / 2);
                int i3 = i_renamed + i2;
                a_renamed(bounds, bounds.left);
                float f_renamed = i2;
                float f2 = i3;
                canvas.drawLine(bounds.left, f_renamed, bounds.left, f2, this.i_renamed);
                for (int i4 = 1; i4 <= iWidth; i4++) {
                    int iRound = java.lang.Math.round(bounds.left + (bounds.width() * (i4 / iWidth)));
                    a_renamed(bounds, iRound);
                    float f3 = iRound;
                    canvas.drawLine(f3, f_renamed, f3, f2, this.i_renamed);
                }
            }
        }

        public int a_renamed() {
            return this.f7285a;
        }

        public int b_renamed() {
            return this.f7286b;
        }

        public int c_renamed() {
            return this.f7287c;
        }

        private void a_renamed(android.graphics.Rect rect, int i_renamed) {
            int iA = a_renamed();
            if (iA < 0) {
                this.i_renamed.setColor(com.oplus.camera.ui.widget.f_renamed.f7279b);
                return;
            }
            int iB = b_renamed();
            if (this.e_renamed != 0) {
                return;
            }
            float fWidth = rect.left + ((rect.width() * iA) / c_renamed());
            float f_renamed = iB;
            if (java.lang.Math.abs(f_renamed - fWidth) <= 2.0f) {
                this.i_renamed.setColor(com.oplus.camera.ui.widget.f_renamed.f7279b);
                return;
            }
            if (f_renamed < fWidth) {
                if (i_renamed < iB || i_renamed > fWidth) {
                    this.i_renamed.setColor(com.oplus.camera.ui.widget.f_renamed.f7279b);
                    return;
                } else {
                    this.i_renamed.setColor(com.oplus.camera.ui.widget.f_renamed.f7280c);
                    return;
                }
            }
            if (i_renamed > iB || i_renamed < fWidth) {
                this.i_renamed.setColor(com.oplus.camera.ui.widget.f_renamed.f7279b);
            } else {
                this.i_renamed.setColor(com.oplus.camera.ui.widget.f_renamed.f7280c);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i_renamed) {
            this.i_renamed.setAlpha(i_renamed);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            this.i_renamed.setColorFilter(colorFilter);
        }

        final void a_renamed(int i_renamed) {
            this.f7286b = i_renamed;
        }

        final void a_renamed(int i_renamed, int i2, int i3) {
            this.f7287c = i_renamed;
            this.f7285a = i2;
            this.g_renamed = i3;
        }
    }

    /* compiled from: Wheel.java */
    private static final class b_renamed extends android.graphics.drawable.Drawable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static float f7282a = 24.0f;

        /* renamed from: b_renamed, reason: collision with root package name */
        private static float f7283b = 2.5f;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.graphics.Paint f7284c = new android.graphics.Paint();
        private final int d_renamed;
        private final int e_renamed;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public b_renamed(android.content.res.Resources resources, int i_renamed) {
            this.f7284c.setStyle(android.graphics.Paint.Style.STROKE);
            this.f7284c.setAntiAlias(true);
            this.f7284c.setColor(com.oplus.camera.ui.widget.f_renamed.f7280c);
            this.f7284c.setStrokeWidth(com.oplus.camera.ui.widget.f_renamed.a_renamed(resources, f7283b));
            this.d_renamed = com.oplus.camera.ui.widget.f_renamed.a_renamed(resources, f7282a);
            this.e_renamed = i_renamed;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            android.graphics.Rect bounds = getBounds();
            if (this.e_renamed != 0) {
                return;
            }
            float fRound = java.lang.Math.round(bounds.left + (bounds.width() / 2));
            canvas.drawLine(fRound, bounds.top, fRound, bounds.bottom, this.f7284c);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.d_renamed;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.d_renamed;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i_renamed) {
            this.f7284c.setAlpha(i_renamed);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            this.f7284c.setColorFilter(colorFilter);
        }
    }

    public f_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d_renamed = new java.util.ArrayList();
        this.e_renamed = 50;
        this.n_renamed = 0;
        this.o_renamed = new android.graphics.Rect();
        this.p_renamed = new android.graphics.Rect();
        this.s_renamed = 100;
        this.t_renamed = 0;
        this.v_renamed = new android.graphics.Rect();
        this.f7281a = new android.graphics.Rect();
        this.z_renamed = 1.2f;
    }

    public void a_renamed(com.oplus.camera.ui.widget.f_renamed.a_renamed aVar) {
        this.d_renamed.add(aVar);
    }

    public int getCenterValue() {
        return this.e_renamed;
    }

    public int getFadingEdgeLength() {
        return this.n_renamed;
    }

    public int getMaxValue() {
        return this.s_renamed;
    }

    public int getValue() {
        return this.x_renamed;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int iMax = java.lang.Math.max(0, (getWidth() - paddingLeft) - 0);
        int iMax2 = java.lang.Math.max(0, (getHeight() - paddingTop) - paddingBottom);
        int iSaveLayer = canvas.saveLayer(paddingLeft, paddingTop, paddingLeft + iMax, paddingTop + iMax2, null);
        try {
            android.graphics.drawable.Drawable drawable = this.y_renamed;
            if (drawable == null) {
                if (this.k_renamed == null) {
                    this.k_renamed = new com.oplus.camera.ui.widget.f_renamed.c_renamed(getResources(), this.t_renamed);
                }
                drawable = this.k_renamed;
            }
            if (drawable instanceof com.oplus.camera.ui.widget.f_renamed.c_renamed) {
                if (this.t_renamed == 0) {
                    ((com.oplus.camera.ui.widget.f_renamed.c_renamed) drawable).a_renamed(this.i_renamed);
                }
                ((com.oplus.camera.ui.widget.f_renamed.c_renamed) drawable).a_renamed(this.s_renamed, this.e_renamed, this.x_renamed);
            }
            drawable.setBounds(this.f7281a);
            drawable.draw(canvas);
            android.graphics.drawable.Drawable drawable2 = this.f_renamed;
            if (drawable2 == null) {
                if (this.j_renamed == null) {
                    this.j_renamed = new com.oplus.camera.ui.widget.f_renamed.b_renamed(getResources(), this.t_renamed);
                    this.h_renamed = this.j_renamed.getIntrinsicWidth();
                    this.g_renamed = this.j_renamed.getIntrinsicHeight();
                }
                drawable2 = this.j_renamed;
            }
            int i_renamed = this.h_renamed;
            int i2 = this.g_renamed;
            if (this.t_renamed == 1 || i_renamed <= 0 || i_renamed > iMax) {
                i_renamed = iMax;
            }
            if (this.t_renamed == 0 || i2 <= 0 || i2 > iMax2) {
                i2 = iMax2;
            }
            int i3 = paddingLeft + ((iMax - i_renamed) / 2);
            int i4 = paddingTop + ((iMax2 - i2) / 2);
            drawable2.setBounds(i3, i4, i_renamed + i3, i2 + i4);
            drawable2.draw(canvas);
            if (this.n_renamed > 0) {
                int width = getWidth();
                int height = getHeight();
                if (this.q_renamed == null) {
                    this.q_renamed = new android.graphics.Paint();
                    this.q_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
                }
                if (this.t_renamed == 0) {
                    if (this.m_renamed == null || this.m_renamed.getWidth() != this.n_renamed || this.m_renamed.getHeight() != 1) {
                        this.m_renamed = android.graphics.Bitmap.createBitmap(this.n_renamed, 1, android.graphics.Bitmap.Config.ARGB_8888);
                        this.l_renamed = android.graphics.Bitmap.createBitmap(this.n_renamed, 1, android.graphics.Bitmap.Config.ARGB_8888);
                        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, -1});
                        gradientDrawable.setBounds(0, 0, this.m_renamed.getWidth(), this.m_renamed.getHeight());
                        gradientDrawable.draw(new android.graphics.Canvas(this.m_renamed));
                        gradientDrawable.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT);
                        gradientDrawable.draw(new android.graphics.Canvas(this.l_renamed));
                    }
                    this.p_renamed.set(0, 0, this.m_renamed.getWidth(), this.m_renamed.getHeight());
                    this.o_renamed.set(0, 0, this.n_renamed, height);
                    canvas.drawBitmap(this.m_renamed, this.p_renamed, this.o_renamed, this.q_renamed);
                    this.o_renamed.set(width - this.n_renamed, 0, width, height);
                    canvas.drawBitmap(this.l_renamed, this.p_renamed, this.o_renamed, this.q_renamed);
                }
            }
        } finally {
            canvas.restoreToCount(iSaveLayer);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        c_renamed();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x0072  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getX()
            float r1 = r5.getY()
            int r5 = r5.getAction()
            r2 = 1
            if (r5 == 0) goto L8b
            r1 = 0
            if (r5 == r2) goto L72
            r3 = 2
            if (r5 == r3) goto L1a
            r0 = 3
            if (r5 == r0) goto L72
            goto Laf
        L1a:
            int r5 = r4.t_renamed
            if (r5 == 0) goto L1f
            goto L6e
        L1f:
            android.graphics.Rect r5 = r4.f7281a
            android.graphics.Rect r3 = r4.v_renamed
            r5.set(r3)
            android.graphics.Rect r5 = r4.f7281a
            float r3 = r4.u_renamed
            float r0 = r0 - r3
            int r0 = java.lang.Math.round(r0)
            r5.offset(r0, r1)
            android.graphics.Rect r5 = r4.f7281a
            int r5 = r5.left
            int r0 = r4.i_renamed
            if (r5 <= r0) goto L43
            android.graphics.Rect r5 = r4.f7281a
            int r3 = r5.left
            int r0 = r0 - r3
            r5.offset(r0, r1)
            goto L53
        L43:
            android.graphics.Rect r5 = r4.f7281a
            int r5 = r5.right
            int r0 = r4.i_renamed
            if (r5 >= r0) goto L53
            android.graphics.Rect r5 = r4.f7281a
            int r3 = r5.right
            int r0 = r0 - r3
            r5.offset(r0, r1)
        L53:
            int r5 = r4.i_renamed
            android.graphics.Rect r0 = r4.f7281a
            int r0 = r0.left
            int r5 = r5 - r0
            float r5 = (float) r5
            android.graphics.Rect r0 = r4.f7281a
            int r0 = r0.width()
            float r0 = (float) r0
            float r5 = r5 / r0
            int r0 = r4.s_renamed
            float r0 = (float) r0
            float r0 = r0 * r5
            int r5 = java.lang.Math.round(r0)
            r4.a_renamed(r5, r1, r2)
        L6e:
            r4.invalidate()
            goto Laf
        L72:
            r4.r_renamed = r1
            java.util.List<com.oplus.camera.ui.widget.f_renamed$a_renamed> r5 = r4.d_renamed
            int r5 = r5.size()
            int r5 = r5 - r2
        L7b:
            if (r5 < 0) goto Laf
            java.util.List<com.oplus.camera.ui.widget.f_renamed$a_renamed> r0 = r4.d_renamed
            java.lang.Object r0 = r0.get(r5)
            com.oplus.camera.ui.widget.f_renamed$a_renamed r0 = (com.oplus.camera.ui.widget.f_renamed.a_renamed) r0
            r0.b_renamed(r4)
            int r5 = r5 + (-1)
            goto L7b
        L8b:
            r4.u_renamed = r0
            r4.w_renamed = r1
            r4.r_renamed = r2
            android.graphics.Rect r5 = r4.v_renamed
            android.graphics.Rect r0 = r4.f7281a
            r5.set(r0)
            java.util.List<com.oplus.camera.ui.widget.f_renamed$a_renamed> r5 = r4.d_renamed
            int r5 = r5.size()
            int r5 = r5 - r2
        L9f:
            if (r5 < 0) goto Laf
            java.util.List<com.oplus.camera.ui.widget.f_renamed$a_renamed> r0 = r4.d_renamed
            java.lang.Object r0 = r0.get(r5)
            com.oplus.camera.ui.widget.f_renamed$a_renamed r0 = (com.oplus.camera.ui.widget.f_renamed.a_renamed) r0
            r0.a_renamed(r4)
            int r5 = r5 + (-1)
            goto L9f
        Laf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.widget.f_renamed.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        if (i_renamed < 0) {
            i_renamed = 0;
        } else {
            int i2 = this.s_renamed;
            if (i_renamed > i2) {
                i_renamed = i2;
            }
        }
        if (this.x_renamed == i_renamed) {
            return;
        }
        this.x_renamed = i_renamed;
        if (z_renamed) {
            c_renamed();
            invalidate();
        }
        for (int size = this.d_renamed.size() - 1; size >= 0; size--) {
            this.d_renamed.get(size).a_renamed(this, i_renamed, z2);
        }
    }

    public void setCenterValue(int i_renamed) {
        if (i_renamed < 0) {
            i_renamed = -1;
        } else {
            int i2 = this.s_renamed;
            if (i_renamed > i2) {
                i_renamed = i2;
            }
        }
        if (this.e_renamed == i_renamed) {
            return;
        }
        this.e_renamed = i_renamed;
        invalidate();
    }

    public void setCurrentValueIndicatorDrawable(android.graphics.drawable.Drawable drawable) {
        this.f_renamed = drawable;
    }

    @Override // android.view.View
    public void setFadingEdgeLength(int i_renamed) {
        if (this.n_renamed == i_renamed) {
            return;
        }
        this.n_renamed = i_renamed;
        this.m_renamed = null;
        this.l_renamed = null;
        invalidate();
    }

    public void setMaxValue(int i_renamed) {
        if (i_renamed < 0) {
            i_renamed = 0;
        }
        int i2 = this.s_renamed;
        if (i2 == i_renamed) {
            return;
        }
        if (i2 > i_renamed) {
            this.e_renamed = java.lang.Math.min(this.e_renamed, i_renamed);
            if (this.x_renamed > i_renamed) {
                this.x_renamed = i_renamed;
                a_renamed(this.x_renamed, false, false);
            }
        }
        this.s_renamed = i_renamed;
        c_renamed();
        invalidate();
    }

    public void setValue(int i_renamed) {
        if (i_renamed < 0) {
            i_renamed = 0;
        } else {
            int i2 = this.s_renamed;
            if (i_renamed > i2) {
                i_renamed = i2;
            }
        }
        a_renamed(i_renamed, true, false);
    }

    public void setWheelDrawable(android.graphics.drawable.Drawable drawable) {
        this.y_renamed = drawable;
    }

    public void setWheelLengthRatio(float f_renamed) {
        this.z_renamed = f_renamed;
        c_renamed();
    }

    private void c_renamed() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iMax = java.lang.Math.max(0, (getWidth() - paddingLeft) - paddingRight);
        int iMax2 = java.lang.Math.max(0, (getHeight() - paddingTop) - paddingBottom);
        int i_renamed = this.s_renamed;
        if (i_renamed <= 0) {
            android.util.Log.w_renamed("Wheel", "updateWheelBounds, Invalid max value");
            return;
        }
        float f_renamed = this.x_renamed / i_renamed;
        if (this.t_renamed != 0) {
            return;
        }
        this.i_renamed = paddingLeft + (iMax / 2);
        int iRound = java.lang.Math.round(iMax * this.z_renamed);
        android.graphics.drawable.Drawable drawable = this.y_renamed;
        int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        if (intrinsicHeight <= 0 || intrinsicHeight > iMax2) {
            intrinsicHeight = iMax2;
        }
        this.f7281a.set(0, 0, iRound, intrinsicHeight);
        this.f7281a.offsetTo(this.i_renamed - java.lang.Math.round(iRound * f_renamed), paddingTop + ((iMax2 - intrinsicHeight) / 2));
    }

    public static int a_renamed(android.content.res.Resources resources, float f_renamed) {
        return java.lang.Math.round(f_renamed * (resources.getDisplayMetrics().densityDpi / 160.0f));
    }
}
