package com.airbnb.lottie;

/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class f_renamed extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable, android.graphics.drawable.Drawable.Callback {

    /* renamed from: a_renamed, reason: collision with root package name */
    com.airbnb.lottie.a_renamed f2220a;

    /* renamed from: b_renamed, reason: collision with root package name */
    com.airbnb.lottie.q_renamed f2221b;
    private com.airbnb.lottie.d_renamed d_renamed;
    private com.airbnb.lottie.b_renamed.b_renamed k_renamed;
    private java.lang.String l_renamed;
    private com.airbnb.lottie.b_renamed m_renamed;
    private com.airbnb.lottie.b_renamed.a_renamed n_renamed;
    private boolean o_renamed;
    private com.airbnb.lottie.c_renamed.c_renamed.b_renamed p_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.Matrix f2222c = new android.graphics.Matrix();
    private final com.airbnb.lottie.f_renamed.e_renamed e_renamed = new com.airbnb.lottie.f_renamed.e_renamed();
    private float f_renamed = 1.0f;
    private boolean g_renamed = true;
    private boolean h_renamed = false;
    private final java.util.ArrayList<com.airbnb.lottie.f_renamed.a_renamed> i_renamed = new java.util.ArrayList<>();
    private final android.animation.ValueAnimator.AnimatorUpdateListener j_renamed = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f_renamed.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            if (com.airbnb.lottie.f_renamed.this.p_renamed != null) {
                com.airbnb.lottie.f_renamed.this.p_renamed.a_renamed(com.airbnb.lottie.f_renamed.this.e_renamed.d_renamed());
            }
        }
    };
    private int q_renamed = 255;
    private boolean u_renamed = true;
    private boolean v_renamed = false;

    /* compiled from: LottieDrawable.java */
    private interface a_renamed {
        void a_renamed(com.airbnb.lottie.d_renamed dVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public f_renamed() {
        this.e_renamed.addUpdateListener(this.j_renamed);
    }

    public boolean a_renamed() {
        return this.o_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        if (this.o_renamed == z_renamed) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 19) {
            com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.o_renamed = z_renamed;
        if (this.d_renamed != null) {
            x_renamed();
        }
    }

    public void a_renamed(java.lang.String str) {
        this.l_renamed = str;
    }

    public java.lang.String b_renamed() {
        return this.l_renamed;
    }

    public boolean a_renamed(com.airbnb.lottie.d_renamed dVar) {
        if (this.d_renamed == dVar) {
            return false;
        }
        this.v_renamed = false;
        e_renamed();
        this.d_renamed = dVar;
        x_renamed();
        this.e_renamed.a_renamed(dVar);
        d_renamed(this.e_renamed.getAnimatedFraction());
        e_renamed(this.f_renamed);
        java.util.Iterator it = new java.util.ArrayList(this.i_renamed).iterator();
        while (it.hasNext()) {
            com.airbnb.lottie.f_renamed.a_renamed aVar = (com.airbnb.lottie.f_renamed.a_renamed) it.next();
            if (aVar != null) {
                aVar.a_renamed(dVar);
            }
            it.remove();
        }
        this.i_renamed.clear();
        dVar.b_renamed(this.r_renamed);
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (!(callback instanceof android.widget.ImageView)) {
            return true;
        }
        android.widget.ImageView imageView = (android.widget.ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void b_renamed(boolean z_renamed) {
        this.r_renamed = z_renamed;
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        if (dVar != null) {
            dVar.b_renamed(z_renamed);
        }
    }

    public void c_renamed(boolean z_renamed) {
        if (this.s_renamed == z_renamed) {
            return;
        }
        this.s_renamed = z_renamed;
        com.airbnb.lottie.c_renamed.c_renamed.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            bVar.a_renamed(z_renamed);
        }
    }

    public com.airbnb.lottie.n_renamed c_renamed() {
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        if (dVar != null) {
            return dVar.c_renamed();
        }
        return null;
    }

    public void d_renamed(boolean z_renamed) {
        this.t_renamed = z_renamed;
    }

    public boolean d_renamed() {
        return this.t_renamed;
    }

    private void x_renamed() {
        this.p_renamed = new com.airbnb.lottie.c_renamed.c_renamed.b_renamed(this, com.airbnb.lottie.e_renamed.s_renamed.a_renamed(this.d_renamed), this.d_renamed.i_renamed(), this.d_renamed);
        if (this.s_renamed) {
            this.p_renamed.a_renamed(true);
        }
    }

    public void e_renamed() {
        if (this.e_renamed.isRunning()) {
            this.e_renamed.cancel();
        }
        this.d_renamed = null;
        this.p_renamed = null;
        this.k_renamed = null;
        this.e_renamed.f_renamed();
        invalidateSelf();
    }

    public void e_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.v_renamed) {
            return;
        }
        this.v_renamed = true;
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        this.q_renamed = i_renamed;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.v_renamed = false;
        com.airbnb.lottie.c_renamed.a_renamed("Drawable#draw");
        if (this.h_renamed) {
            try {
                a_renamed(canvas);
            } catch (java.lang.Throwable th) {
                com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Lottie crashed in_renamed draw!", th);
            }
        } else {
            a_renamed(canvas);
        }
        com.airbnb.lottie.c_renamed.b_renamed("Drawable#draw");
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        if (!y_renamed()) {
            c_renamed(canvas);
        } else {
            d_renamed(canvas);
        }
    }

    private boolean y_renamed() {
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        return dVar == null || getBounds().isEmpty() || a_renamed(getBounds()) == a_renamed(dVar.d_renamed());
    }

    private float a_renamed(android.graphics.Rect rect) {
        return rect.width() / rect.height();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (!(callback instanceof android.view.View) || ((android.view.View) callback).isInEditMode()) {
            return;
        }
        f_renamed();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        g_renamed();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return p_renamed();
    }

    public void f_renamed() {
        if (this.p_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.7
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.f_renamed();
                }
            });
            return;
        }
        if (this.g_renamed || o_renamed() == 0) {
            this.e_renamed.i_renamed();
        }
        if (this.g_renamed) {
            return;
        }
        c_renamed((int) (k_renamed() < 0.0f ? i_renamed() : j_renamed()));
        this.e_renamed.j_renamed();
    }

    public void g_renamed() {
        this.i_renamed.clear();
        this.e_renamed.j_renamed();
    }

    public void h_renamed() {
        if (this.p_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.8
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.h_renamed();
                }
            });
            return;
        }
        if (this.g_renamed || o_renamed() == 0) {
            this.e_renamed.l_renamed();
        }
        if (this.g_renamed) {
            return;
        }
        c_renamed((int) (k_renamed() < 0.0f ? i_renamed() : j_renamed()));
        this.e_renamed.j_renamed();
    }

    public void a_renamed(final int i_renamed) {
        if (this.d_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.9
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.a_renamed(i_renamed);
                }
            });
        } else {
            this.e_renamed.a_renamed(i_renamed);
        }
    }

    public float i_renamed() {
        return this.e_renamed.m_renamed();
    }

    public void a_renamed(final float f_renamed) {
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        if (dVar == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.10
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar2) {
                    com.airbnb.lottie.f_renamed.this.a_renamed(f_renamed);
                }
            });
        } else {
            a_renamed((int) com.airbnb.lottie.f_renamed.g_renamed.a_renamed(dVar.f_renamed(), this.d_renamed.g_renamed(), f_renamed));
        }
    }

    public void b_renamed(final int i_renamed) {
        if (this.d_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.11
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.b_renamed(i_renamed);
                }
            });
        } else {
            this.e_renamed.b_renamed(i_renamed + 0.99f);
        }
    }

    public float j_renamed() {
        return this.e_renamed.n_renamed();
    }

    public void b_renamed(final float f_renamed) {
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        if (dVar == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.12
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar2) {
                    com.airbnb.lottie.f_renamed.this.b_renamed(f_renamed);
                }
            });
        } else {
            b_renamed((int) com.airbnb.lottie.f_renamed.g_renamed.a_renamed(dVar.f_renamed(), this.d_renamed.g_renamed(), f_renamed));
        }
    }

    public void b_renamed(final java.lang.String str) {
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        if (dVar == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.13
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar2) {
                    com.airbnb.lottie.f_renamed.this.b_renamed(str);
                }
            });
            return;
        }
        com.airbnb.lottie.c_renamed.h_renamed hVarC = dVar.c_renamed(str);
        if (hVarC == null) {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        a_renamed((int) hVarC.f2139a);
    }

    public void c_renamed(final java.lang.String str) {
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        if (dVar == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.14
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar2) {
                    com.airbnb.lottie.f_renamed.this.c_renamed(str);
                }
            });
            return;
        }
        com.airbnb.lottie.c_renamed.h_renamed hVarC = dVar.c_renamed(str);
        if (hVarC == null) {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        b_renamed((int) (hVarC.f2139a + hVarC.f2140b));
    }

    public void d_renamed(final java.lang.String str) {
        com.airbnb.lottie.d_renamed dVar = this.d_renamed;
        if (dVar == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.2
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar2) {
                    com.airbnb.lottie.f_renamed.this.d_renamed(str);
                }
            });
            return;
        }
        com.airbnb.lottie.c_renamed.h_renamed hVarC = dVar.c_renamed(str);
        if (hVarC == null) {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i_renamed = (int) hVarC.f2139a;
        a_renamed(i_renamed, ((int) hVarC.f2140b) + i_renamed);
    }

    public void a_renamed(final int i_renamed, final int i2) {
        if (this.d_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.3
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.a_renamed(i_renamed, i2);
                }
            });
        } else {
            this.e_renamed.a_renamed(i_renamed, i2 + 0.99f);
        }
    }

    public void c_renamed(float f_renamed) {
        this.e_renamed.c_renamed(f_renamed);
    }

    public float k_renamed() {
        return this.e_renamed.h_renamed();
    }

    public void a_renamed(android.animation.Animator.AnimatorListener animatorListener) {
        this.e_renamed.addListener(animatorListener);
    }

    public void l_renamed() {
        this.e_renamed.removeAllListeners();
    }

    public void c_renamed(final int i_renamed) {
        if (this.d_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.4
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.c_renamed(i_renamed);
                }
            });
        } else {
            this.e_renamed.a_renamed(i_renamed);
        }
    }

    public int m_renamed() {
        return (int) this.e_renamed.e_renamed();
    }

    public void d_renamed(final float f_renamed) {
        if (this.d_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.5
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.d_renamed(f_renamed);
                }
            });
            return;
        }
        com.airbnb.lottie.c_renamed.a_renamed("Drawable#setProgress");
        this.e_renamed.a_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(this.d_renamed.f_renamed(), this.d_renamed.g_renamed(), f_renamed));
        com.airbnb.lottie.c_renamed.b_renamed("Drawable#setProgress");
    }

    public void d_renamed(int i_renamed) {
        this.e_renamed.setRepeatMode(i_renamed);
    }

    public int n_renamed() {
        return this.e_renamed.getRepeatMode();
    }

    public void e_renamed(int i_renamed) {
        this.e_renamed.setRepeatCount(i_renamed);
    }

    public int o_renamed() {
        return this.e_renamed.getRepeatCount();
    }

    public boolean p_renamed() {
        com.airbnb.lottie.f_renamed.e_renamed eVar = this.e_renamed;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    void a_renamed(java.lang.Boolean bool) {
        this.g_renamed = bool.booleanValue();
    }

    public void e_renamed(float f_renamed) {
        this.f_renamed = f_renamed;
    }

    public void a_renamed(com.airbnb.lottie.b_renamed bVar) {
        this.m_renamed = bVar;
        com.airbnb.lottie.b_renamed.b_renamed bVar2 = this.k_renamed;
        if (bVar2 != null) {
            bVar2.a_renamed(bVar);
        }
    }

    public void a_renamed(com.airbnb.lottie.a_renamed aVar) {
        this.f2220a = aVar;
        com.airbnb.lottie.b_renamed.a_renamed aVar2 = this.n_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed(aVar);
        }
    }

    public void a_renamed(com.airbnb.lottie.q_renamed qVar) {
        this.f2221b = qVar;
    }

    public com.airbnb.lottie.q_renamed q_renamed() {
        return this.f2221b;
    }

    public boolean r_renamed() {
        return this.f2221b == null && this.d_renamed.j_renamed().size() > 0;
    }

    public float s_renamed() {
        return this.f_renamed;
    }

    public com.airbnb.lottie.d_renamed t_renamed() {
        return this.d_renamed;
    }

    public void u_renamed() {
        this.i_renamed.clear();
        this.e_renamed.cancel();
    }

    public void v_renamed() {
        this.i_renamed.clear();
        this.e_renamed.k_renamed();
    }

    public float w_renamed() {
        return this.e_renamed.d_renamed();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.d_renamed == null) {
            return -1;
        }
        return (int) (r0.d_renamed().width() * s_renamed());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.d_renamed == null) {
            return -1;
        }
        return (int) (r0.d_renamed().height() * s_renamed());
    }

    public java.util.List<com.airbnb.lottie.c_renamed.e_renamed> a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar) {
        if (this.p_renamed == null) {
            com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Cannot resolve KeyPath. Composition is_renamed not set yet.");
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.p_renamed.a_renamed(eVar, 0, arrayList, new com.airbnb.lottie.c_renamed.e_renamed(new java.lang.String[0]));
        return arrayList;
    }

    public <T_renamed> void a_renamed(final com.airbnb.lottie.c_renamed.e_renamed eVar, final T_renamed t_renamed, final com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        if (this.p_renamed == null) {
            this.i_renamed.add(new com.airbnb.lottie.f_renamed.a_renamed() { // from class: com.airbnb.lottie.f_renamed.6
                @Override // com.airbnb.lottie.f_renamed.a_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.f_renamed.this.a_renamed(eVar, t_renamed, cVar);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (eVar == com.airbnb.lottie.c_renamed.e_renamed.f2133a) {
            this.p_renamed.a_renamed((com.airbnb.lottie.c_renamed.c_renamed.b_renamed) t_renamed, (com.airbnb.lottie.g_renamed.c_renamed<com.airbnb.lottie.c_renamed.c_renamed.b_renamed>) cVar);
        } else if (eVar.a_renamed() != null) {
            eVar.a_renamed().a_renamed(t_renamed, cVar);
        } else {
            java.util.List<com.airbnb.lottie.c_renamed.e_renamed> listA = a_renamed(eVar);
            for (int i_renamed = 0; i_renamed < listA.size(); i_renamed++) {
                listA.get(i_renamed).a_renamed().a_renamed(t_renamed, cVar);
            }
            zIsEmpty = true ^ listA.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t_renamed == com.airbnb.lottie.k_renamed.C_renamed) {
                d_renamed(w_renamed());
            }
        }
    }

    public android.graphics.Bitmap e_renamed(java.lang.String str) {
        com.airbnb.lottie.b_renamed.b_renamed bVarZ = z_renamed();
        if (bVarZ != null) {
            return bVarZ.a_renamed(str);
        }
        return null;
    }

    private com.airbnb.lottie.b_renamed.b_renamed z_renamed() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.b_renamed.b_renamed bVar = this.k_renamed;
        if (bVar != null && !bVar.a_renamed(B_renamed())) {
            this.k_renamed = null;
        }
        if (this.k_renamed == null) {
            this.k_renamed = new com.airbnb.lottie.b_renamed.b_renamed(getCallback(), this.l_renamed, this.m_renamed, this.d_renamed.l_renamed());
        }
        return this.k_renamed;
    }

    public android.graphics.Typeface a_renamed(java.lang.String str, java.lang.String str2) {
        com.airbnb.lottie.b_renamed.a_renamed aVarA = A_renamed();
        if (aVarA != null) {
            return aVarA.a_renamed(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b_renamed.a_renamed A_renamed() {
        if (getCallback() == null) {
            return null;
        }
        if (this.n_renamed == null) {
            this.n_renamed = new com.airbnb.lottie.b_renamed.a_renamed(getCallback(), this.f2220a);
        }
        return this.n_renamed;
    }

    private android.content.Context B_renamed() {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof android.view.View)) {
            return ((android.view.View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j_renamed) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j_renamed);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private float b_renamed(android.graphics.Canvas canvas) {
        return java.lang.Math.min(canvas.getWidth() / this.d_renamed.d_renamed().width(), canvas.getHeight() / this.d_renamed.d_renamed().height());
    }

    private void c_renamed(android.graphics.Canvas canvas) {
        float f_renamed;
        if (this.p_renamed == null) {
            return;
        }
        int iSave = -1;
        android.graphics.Rect bounds = getBounds();
        float fWidth = bounds.width() / this.d_renamed.d_renamed().width();
        float fHeight = bounds.height() / this.d_renamed.d_renamed().height();
        if (this.u_renamed) {
            float fMin = java.lang.Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                f_renamed = 1.0f / fMin;
                fWidth /= f_renamed;
                fHeight /= f_renamed;
            } else {
                f_renamed = 1.0f;
            }
            if (f_renamed > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f2 = fWidth2 * fMin;
                float f3 = fMin * fHeight2;
                canvas.translate(fWidth2 - f2, fHeight2 - f3);
                canvas.scale(f_renamed, f_renamed, f2, f3);
            }
        }
        this.f2222c.reset();
        this.f2222c.preScale(fWidth, fHeight);
        this.p_renamed.a_renamed(canvas, this.f2222c, this.q_renamed);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    private void d_renamed(android.graphics.Canvas canvas) {
        float f_renamed;
        if (this.p_renamed == null) {
            return;
        }
        float f2 = this.f_renamed;
        float fB_renamed = b_renamed(canvas);
        if (f2 > fB_renamed) {
            f_renamed = this.f_renamed / fB_renamed;
        } else {
            fB_renamed = f2;
            f_renamed = 1.0f;
        }
        int iSave = -1;
        if (f_renamed > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.d_renamed.d_renamed().width() / 2.0f;
            float fHeight = this.d_renamed.d_renamed().height() / 2.0f;
            float f3 = fWidth * fB_renamed;
            float f4 = fHeight * fB_renamed;
            canvas.translate((s_renamed() * fWidth) - f3, (s_renamed() * fHeight) - f4);
            canvas.scale(f_renamed, f_renamed, f3, f4);
        }
        this.f2222c.reset();
        this.f2222c.preScale(fB_renamed, fB_renamed);
        this.p_renamed.a_renamed(canvas, this.f2222c, this.q_renamed);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }
}
