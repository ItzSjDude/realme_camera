package androidx.appcompat.b_renamed.a_renamed;

/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
class b_renamed extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 f312a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Rect f313b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.drawable.Drawable f314c;
    private android.graphics.drawable.Drawable d_renamed;
    private boolean f_renamed;
    private boolean i_renamed;
    private java.lang.Runnable j_renamed;
    private long k_renamed;
    private long l_renamed;
    private androidx.appcompat.b_renamed.a_renamed.b_renamed.a_renamed m_renamed;
    private int e_renamed = 255;
    private int g_renamed = -1;
    private int h_renamed = -1;

    b_renamed() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        android.graphics.drawable.Drawable drawable2 = this.d_renamed;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f312a.getChangingConfigurations() | super.getChangingConfigurations();
    }

    private boolean a_renamed() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        boolean padding;
        android.graphics.Rect rectF = this.f312a.f_renamed();
        if (rectF != null) {
            rect.set(rectF);
            padding = (rectF.right | ((rectF.left | rectF.top) | rectF.bottom)) != 0;
        } else {
            android.graphics.drawable.Drawable drawable = this.f314c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (a_renamed()) {
            int i_renamed = rect.left;
            rect.left = rect.right;
            rect.right = i_renamed;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(android.graphics.Outline outline) {
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        if (this.f_renamed && this.e_renamed == i_renamed) {
            return;
        }
        this.f_renamed = true;
        this.e_renamed = i_renamed;
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            if (this.k_renamed == 0) {
                drawable.setAlpha(i_renamed);
            } else {
                a_renamed(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z_renamed) {
        if (this.f312a.z_renamed != z_renamed) {
            androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b = this.f312a;
            abstractC0005b.z_renamed = z_renamed;
            android.graphics.drawable.Drawable drawable = this.f314c;
            if (drawable != null) {
                drawable.setDither(abstractC0005b.z_renamed);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b = this.f312a;
        abstractC0005b.G_renamed = true;
        if (abstractC0005b.F_renamed != colorFilter) {
            this.f312a.F_renamed = colorFilter;
            android.graphics.drawable.Drawable drawable = this.f314c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b = this.f312a;
        abstractC0005b.J_renamed = true;
        if (abstractC0005b.H_renamed != colorStateList) {
            this.f312a.H_renamed = colorStateList;
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f314c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b = this.f312a;
        abstractC0005b.K_renamed = true;
        if (abstractC0005b.I_renamed != mode) {
            this.f312a.I_renamed = mode;
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f314c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.d_renamed;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        android.graphics.drawable.Drawable drawable2 = this.f314c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f312a.n_renamed();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z_renamed) {
        if (this.f312a.E_renamed != z_renamed) {
            androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b = this.f312a;
            abstractC0005b.E_renamed = z_renamed;
            android.graphics.drawable.Drawable drawable = this.f314c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, abstractC0005b.E_renamed);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f312a.E_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z_renamed;
        android.graphics.drawable.Drawable drawable = this.d_renamed;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.d_renamed = null;
            this.h_renamed = -1;
            z_renamed = true;
        } else {
            z_renamed = false;
        }
        android.graphics.drawable.Drawable drawable2 = this.f314c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f_renamed) {
                this.f314c.setAlpha(this.e_renamed);
            }
        }
        if (this.l_renamed != 0) {
            this.l_renamed = 0L;
            z_renamed = true;
        }
        if (this.k_renamed != 0) {
            this.k_renamed = 0L;
            z_renamed = true;
        }
        if (z_renamed) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f_renamed, float f2) {
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, f_renamed, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i_renamed, int i2, int i3, int i4) {
        android.graphics.Rect rect = this.f313b;
        if (rect == null) {
            this.f313b = new android.graphics.Rect(i_renamed, i2, i3, i4);
        } else {
            rect.set(i_renamed, i2, i3, i4);
        }
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, i_renamed, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(android.graphics.Rect rect) {
        android.graphics.Rect rect2 = this.f313b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        android.graphics.drawable.Drawable drawable = this.d_renamed;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        android.graphics.drawable.Drawable drawable2 = this.f314c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i_renamed) {
        android.graphics.drawable.Drawable drawable = this.d_renamed;
        if (drawable != null) {
            return drawable.setLevel(i_renamed);
        }
        android.graphics.drawable.Drawable drawable2 = this.f314c;
        if (drawable2 != null) {
            return drawable2.setLevel(i_renamed);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i_renamed) {
        return this.f312a.d_renamed(i_renamed, d_renamed());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f312a.g_renamed()) {
            return this.f312a.h_renamed();
        }
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f312a.g_renamed()) {
            return this.f312a.i_renamed();
        }
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f312a.g_renamed()) {
            return this.f312a.j_renamed();
        }
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f312a.g_renamed()) {
            return this.f312a.k_renamed();
        }
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b = this.f312a;
        if (abstractC0005b != null) {
            abstractC0005b.b_renamed();
        }
        if (drawable != this.f314c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j_renamed) {
        if (drawable != this.f314c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j_renamed);
    }

    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
        if (drawable != this.f314c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z_renamed, boolean z2) {
        boolean visible = super.setVisible(z_renamed, z2);
        android.graphics.drawable.Drawable drawable = this.d_renamed;
        if (drawable != null) {
            drawable.setVisible(z_renamed, z2);
        }
        android.graphics.drawable.Drawable drawable2 = this.f314c;
        if (drawable2 != null) {
            drawable2.setVisible(z_renamed, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        android.graphics.drawable.Drawable drawable = this.f314c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f312a.m_renamed();
    }

    int d_renamed() {
        return this.g_renamed;
    }

    boolean a_renamed(int i_renamed) {
        if (i_renamed == this.g_renamed) {
            return false;
        }
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        if (this.f312a.D_renamed > 0) {
            android.graphics.drawable.Drawable drawable = this.d_renamed;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            android.graphics.drawable.Drawable drawable2 = this.f314c;
            if (drawable2 != null) {
                this.d_renamed = drawable2;
                this.h_renamed = this.g_renamed;
                this.l_renamed = this.f312a.D_renamed + jUptimeMillis;
            } else {
                this.d_renamed = null;
                this.h_renamed = -1;
                this.l_renamed = 0L;
            }
        } else {
            android.graphics.drawable.Drawable drawable3 = this.f314c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i_renamed >= 0 && i_renamed < this.f312a.j_renamed) {
            android.graphics.drawable.Drawable drawableB = this.f312a.b_renamed(i_renamed);
            this.f314c = drawableB;
            this.g_renamed = i_renamed;
            if (drawableB != null) {
                if (this.f312a.C_renamed > 0) {
                    this.k_renamed = jUptimeMillis + this.f312a.C_renamed;
                }
                a_renamed(drawableB);
            }
        } else {
            this.f314c = null;
            this.g_renamed = -1;
        }
        if (this.k_renamed != 0 || this.l_renamed != 0) {
            java.lang.Runnable runnable = this.j_renamed;
            if (runnable == null) {
                this.j_renamed = new java.lang.Runnable() { // from class: androidx.appcompat.b_renamed.a_renamed.b_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        androidx.appcompat.b_renamed.a_renamed.b_renamed.this.a_renamed(true);
                        androidx.appcompat.b_renamed.a_renamed.b_renamed.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            a_renamed(true);
        }
        invalidateSelf();
        return true;
    }

    private void a_renamed(android.graphics.drawable.Drawable drawable) {
        if (this.m_renamed == null) {
            this.m_renamed = new androidx.appcompat.b_renamed.a_renamed.b_renamed.a_renamed();
        }
        drawable.setCallback(this.m_renamed.a_renamed(drawable.getCallback()));
        try {
            if (this.f312a.C_renamed <= 0 && this.f_renamed) {
                drawable.setAlpha(this.e_renamed);
            }
            if (this.f312a.G_renamed) {
                drawable.setColorFilter(this.f312a.F_renamed);
            } else {
                if (this.f312a.J_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.f312a.H_renamed);
                }
                if (this.f312a.K_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.f312a.I_renamed);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f312a.z_renamed);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (android.os.Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f312a.E_renamed);
            }
            android.graphics.Rect rect = this.f313b;
            if (android.os.Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m_renamed.a_renamed());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x006d A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:? A_renamed[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a_renamed(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f_renamed = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f314c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.k_renamed
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.e_renamed
            r3.setAlpha(r9)
            r13.k_renamed = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.b_renamed.a_renamed.b_renamed$b_renamed r9 = r13.f312a
            int r9 = r9.C_renamed
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.f314c
            int r3 = 255 - r3
            int r10 = r13.e_renamed
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = r0
            goto L3b
        L38:
            r13.k_renamed = r7
        L3a:
            r3 = r6
        L3b:
            android.graphics.drawable.Drawable r9 = r13.d_renamed
            if (r9 == 0) goto L68
            long r10 = r13.l_renamed
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L6a
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L55
            r9.setVisible(r6, r6)
            r0 = 0
            r13.d_renamed = r0
            r0 = -1
            r13.h_renamed = r0
            r13.l_renamed = r7
            goto L6a
        L55:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.b_renamed.a_renamed.b_renamed$b_renamed r4 = r13.f312a
            int r4 = r4.D_renamed
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.d_renamed
            int r5 = r13.e_renamed
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L6b
        L68:
            r13.l_renamed = r7
        L6a:
            r0 = r3
        L6b:
            if (r14 == 0) goto L77
            if (r0 == 0) goto L77
            java.lang.Runnable r14 = r13.j_renamed
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b_renamed.a_renamed.b_renamed.a_renamed(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable getCurrent() {
        return this.f314c;
    }

    final void a_renamed(android.content.res.Resources resources) {
        this.f312a.a_renamed(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(android.content.res.Resources.Theme theme) {
        this.f312a.a_renamed(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f312a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final android.graphics.drawable.Drawable.ConstantState getConstantState() {
        if (!this.f312a.o_renamed()) {
            return null;
        }
        this.f312a.f_renamed = getChangingConfigurations();
        return this.f312a;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (!this.i_renamed && super.mutate() == this) {
            androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005bC = c_renamed();
            abstractC0005bC.a_renamed();
            a_renamed(abstractC0005bC);
            this.i_renamed = true;
        }
        return this;
    }

    androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 c_renamed() {
        return this.f312a;
    }

    void clearMutated() {
        this.f312a.e_renamed();
        this.i_renamed = false;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.b_renamed.a_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    static abstract class DrawableContainer_2 extends android.graphics.drawable.Drawable.ConstantState {
        boolean A_renamed;
        int B_renamed;
        int C_renamed;
        int D_renamed;
        boolean E_renamed;
        android.graphics.ColorFilter F_renamed;
        boolean G_renamed;
        android.content.res.ColorStateList H_renamed;
        android.graphics.PorterDuff.Mode I_renamed;
        boolean J_renamed;
        boolean K_renamed;

        /* renamed from: c_renamed, reason: collision with root package name */
        final androidx.appcompat.b_renamed.a_renamed.b_renamed f317c;
        android.content.res.Resources d_renamed;
        int e_renamed;
        int f_renamed;
        int g_renamed;
        android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> h_renamed;
        android.graphics.drawable.Drawable[] i_renamed;
        int j_renamed;
        boolean k_renamed;
        boolean l_renamed;
        android.graphics.Rect m_renamed;
        boolean n_renamed;
        boolean o_renamed;
        int p_renamed;
        int q_renamed;
        int r_renamed;
        int s_renamed;
        boolean t_renamed;
        int u_renamed;
        boolean v_renamed;
        boolean w_renamed;
        boolean x_renamed;
        boolean y_renamed;
        boolean z_renamed;

        DrawableContainer_2(androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b, androidx.appcompat.b_renamed.a_renamed.b_renamed bVar, android.content.res.Resources resources) {
            android.content.res.Resources resources2;
            this.e_renamed = 160;
            this.k_renamed = false;
            this.n_renamed = false;
            this.z_renamed = true;
            this.C_renamed = 0;
            this.D_renamed = 0;
            this.f317c = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = abstractC0005b != null ? abstractC0005b.d_renamed : null;
            }
            this.d_renamed = resources2;
            this.e_renamed = androidx.appcompat.b_renamed.a_renamed.b_renamed.a_renamed(resources, abstractC0005b != null ? abstractC0005b.e_renamed : 0);
            if (abstractC0005b != null) {
                this.f_renamed = abstractC0005b.f_renamed;
                this.g_renamed = abstractC0005b.g_renamed;
                this.x_renamed = true;
                this.y_renamed = true;
                this.k_renamed = abstractC0005b.k_renamed;
                this.n_renamed = abstractC0005b.n_renamed;
                this.z_renamed = abstractC0005b.z_renamed;
                this.A_renamed = abstractC0005b.A_renamed;
                this.B_renamed = abstractC0005b.B_renamed;
                this.C_renamed = abstractC0005b.C_renamed;
                this.D_renamed = abstractC0005b.D_renamed;
                this.E_renamed = abstractC0005b.E_renamed;
                this.F_renamed = abstractC0005b.F_renamed;
                this.G_renamed = abstractC0005b.G_renamed;
                this.H_renamed = abstractC0005b.H_renamed;
                this.I_renamed = abstractC0005b.I_renamed;
                this.J_renamed = abstractC0005b.J_renamed;
                this.K_renamed = abstractC0005b.K_renamed;
                if (abstractC0005b.e_renamed == this.e_renamed) {
                    if (abstractC0005b.l_renamed) {
                        this.m_renamed = new android.graphics.Rect(abstractC0005b.m_renamed);
                        this.l_renamed = true;
                    }
                    if (abstractC0005b.o_renamed) {
                        this.p_renamed = abstractC0005b.p_renamed;
                        this.q_renamed = abstractC0005b.q_renamed;
                        this.r_renamed = abstractC0005b.r_renamed;
                        this.s_renamed = abstractC0005b.s_renamed;
                        this.o_renamed = true;
                    }
                }
                if (abstractC0005b.t_renamed) {
                    this.u_renamed = abstractC0005b.u_renamed;
                    this.t_renamed = true;
                }
                if (abstractC0005b.v_renamed) {
                    this.w_renamed = abstractC0005b.w_renamed;
                    this.v_renamed = true;
                }
                android.graphics.drawable.Drawable[] drawableArr = abstractC0005b.i_renamed;
                this.i_renamed = new android.graphics.drawable.Drawable[drawableArr.length];
                this.j_renamed = abstractC0005b.j_renamed;
                android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> sparseArray = abstractC0005b.h_renamed;
                if (sparseArray != null) {
                    this.h_renamed = sparseArray.clone();
                } else {
                    this.h_renamed = new android.util.SparseArray<>(this.j_renamed);
                }
                int i_renamed = this.j_renamed;
                for (int i2 = 0; i2 < i_renamed; i2++) {
                    if (drawableArr[i2] != null) {
                        android.graphics.drawable.Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.h_renamed.put(i2, constantState);
                        } else {
                            this.i_renamed[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.i_renamed = new android.graphics.drawable.Drawable[10];
            this.j_renamed = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.g_renamed | this.f_renamed;
        }

        public final int a_renamed(android.graphics.drawable.Drawable drawable) {
            int i_renamed = this.j_renamed;
            if (i_renamed >= this.i_renamed.length) {
                e_renamed(i_renamed, i_renamed + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f317c);
            this.i_renamed[i_renamed] = drawable;
            this.j_renamed++;
            this.g_renamed = drawable.getChangingConfigurations() | this.g_renamed;
            b_renamed();
            this.m_renamed = null;
            this.l_renamed = false;
            this.o_renamed = false;
            this.x_renamed = false;
            return i_renamed;
        }

        void b_renamed() {
            this.t_renamed = false;
            this.v_renamed = false;
        }

        final int c_renamed() {
            return this.i_renamed.length;
        }

        private void p_renamed() {
            android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> sparseArray = this.h_renamed;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    this.i_renamed[this.h_renamed.keyAt(i_renamed)] = b_renamed(this.h_renamed.valueAt(i_renamed).newDrawable(this.d_renamed));
                }
                this.h_renamed = null;
            }
        }

        private android.graphics.drawable.Drawable b_renamed(android.graphics.drawable.Drawable drawable) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.B_renamed);
            }
            android.graphics.drawable.Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f317c);
            return drawableMutate;
        }

        public final int d_renamed() {
            return this.j_renamed;
        }

        public final android.graphics.drawable.Drawable b_renamed(int i_renamed) {
            int iIndexOfKey;
            android.graphics.drawable.Drawable drawable = this.i_renamed[i_renamed];
            if (drawable != null) {
                return drawable;
            }
            android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> sparseArray = this.h_renamed;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i_renamed)) < 0) {
                return null;
            }
            android.graphics.drawable.Drawable drawableB = b_renamed(this.h_renamed.valueAt(iIndexOfKey).newDrawable(this.d_renamed));
            this.i_renamed[i_renamed] = drawableB;
            this.h_renamed.removeAt(iIndexOfKey);
            if (this.h_renamed.size() == 0) {
                this.h_renamed = null;
            }
            return drawableB;
        }

        final boolean d_renamed(int i_renamed, int i2) {
            int i3 = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            boolean z_renamed = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = android.os.Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i_renamed) : false;
                    if (i4 == i2) {
                        z_renamed = layoutDirection;
                    }
                }
            }
            this.B_renamed = i_renamed;
            return z_renamed;
        }

        final void a_renamed(android.content.res.Resources resources) {
            if (resources != null) {
                this.d_renamed = resources;
                int iA = androidx.appcompat.b_renamed.a_renamed.b_renamed.a_renamed(resources, this.e_renamed);
                int i_renamed = this.e_renamed;
                this.e_renamed = iA;
                if (i_renamed != iA) {
                    this.o_renamed = false;
                    this.l_renamed = false;
                }
            }
        }

        final void a_renamed(android.content.res.Resources.Theme theme) {
            if (theme != null) {
                p_renamed();
                int i_renamed = this.j_renamed;
                android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
                for (int i2 = 0; i2 < i_renamed; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.g_renamed |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                a_renamed(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i_renamed = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            for (int i2 = 0; i2 < i_renamed; i2++) {
                android.graphics.drawable.Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    android.graphics.drawable.Drawable.ConstantState constantState = this.h_renamed.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        void a_renamed() {
            int i_renamed = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            for (int i2 = 0; i2 < i_renamed; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.A_renamed = true;
        }

        final void e_renamed() {
            this.A_renamed = false;
        }

        public final void a_renamed(boolean z_renamed) {
            this.k_renamed = z_renamed;
        }

        public final android.graphics.Rect f_renamed() {
            if (this.k_renamed) {
                return null;
            }
            if (this.m_renamed != null || this.l_renamed) {
                return this.m_renamed;
            }
            p_renamed();
            android.graphics.Rect rect = new android.graphics.Rect();
            int i_renamed = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            android.graphics.Rect rect2 = null;
            for (int i2 = 0; i2 < i_renamed; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new android.graphics.Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.l_renamed = true;
            this.m_renamed = rect2;
            return rect2;
        }

        public final void b_renamed(boolean z_renamed) {
            this.n_renamed = z_renamed;
        }

        public final boolean g_renamed() {
            return this.n_renamed;
        }

        public final int h_renamed() {
            if (!this.o_renamed) {
                l_renamed();
            }
            return this.p_renamed;
        }

        public final int i_renamed() {
            if (!this.o_renamed) {
                l_renamed();
            }
            return this.q_renamed;
        }

        public final int j_renamed() {
            if (!this.o_renamed) {
                l_renamed();
            }
            return this.r_renamed;
        }

        public final int k_renamed() {
            if (!this.o_renamed) {
                l_renamed();
            }
            return this.s_renamed;
        }

        protected void l_renamed() {
            this.o_renamed = true;
            p_renamed();
            int i_renamed = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            this.q_renamed = -1;
            this.p_renamed = -1;
            this.s_renamed = 0;
            this.r_renamed = 0;
            for (int i2 = 0; i2 < i_renamed; i2++) {
                android.graphics.drawable.Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.p_renamed) {
                    this.p_renamed = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.q_renamed) {
                    this.q_renamed = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.r_renamed) {
                    this.r_renamed = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.s_renamed) {
                    this.s_renamed = minimumHeight;
                }
            }
        }

        public final void c_renamed(int i_renamed) {
            this.C_renamed = i_renamed;
        }

        public final void d_renamed(int i_renamed) {
            this.D_renamed = i_renamed;
        }

        public final int m_renamed() {
            if (this.t_renamed) {
                return this.u_renamed;
            }
            p_renamed();
            int i_renamed = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            int opacity = i_renamed > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i_renamed; i2++) {
                opacity = android.graphics.drawable.Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.u_renamed = opacity;
            this.t_renamed = true;
            return opacity;
        }

        public final boolean n_renamed() {
            if (this.v_renamed) {
                return this.w_renamed;
            }
            p_renamed();
            int i_renamed = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            boolean z_renamed = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i_renamed) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z_renamed = true;
                    break;
                }
                i2++;
            }
            this.w_renamed = z_renamed;
            this.v_renamed = true;
            return z_renamed;
        }

        public void e_renamed(int i_renamed, int i2) {
            android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[i2];
            java.lang.System.arraycopy(this.i_renamed, 0, drawableArr, 0, i_renamed);
            this.i_renamed = drawableArr;
        }

        public synchronized boolean o_renamed() {
            if (this.x_renamed) {
                return this.y_renamed;
            }
            p_renamed();
            this.x_renamed = true;
            int i_renamed = this.j_renamed;
            android.graphics.drawable.Drawable[] drawableArr = this.i_renamed;
            for (int i2 = 0; i2 < i_renamed; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.y_renamed = false;
                    return false;
                }
            }
            this.y_renamed = true;
            return true;
        }
    }

    void a_renamed(androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b) {
        this.f312a = abstractC0005b;
        int i_renamed = this.g_renamed;
        if (i_renamed >= 0) {
            this.f314c = abstractC0005b.b_renamed(i_renamed);
            android.graphics.drawable.Drawable drawable = this.f314c;
            if (drawable != null) {
                a_renamed(drawable);
            }
        }
        this.h_renamed = -1;
        this.d_renamed = null;
    }

    /* compiled from: DrawableContainer.java */
    static class a_renamed implements android.graphics.drawable.Drawable.Callback {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.graphics.drawable.Drawable.Callback f316a;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        }

        a_renamed() {
        }

        public androidx.appcompat.b_renamed.a_renamed.b_renamed.a_renamed a_renamed(android.graphics.drawable.Drawable.Callback callback) {
            this.f316a = callback;
            return this;
        }

        public android.graphics.drawable.Drawable.Callback a_renamed() {
            android.graphics.drawable.Drawable.Callback callback = this.f316a;
            this.f316a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j_renamed) {
            android.graphics.drawable.Drawable.Callback callback = this.f316a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j_renamed);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
            android.graphics.drawable.Drawable.Callback callback = this.f316a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int a_renamed(android.content.res.Resources resources, int i_renamed) {
        if (resources != null) {
            i_renamed = resources.getDisplayMetrics().densityDpi;
        }
        if (i_renamed == 0) {
            return 160;
        }
        return i_renamed;
    }
}
