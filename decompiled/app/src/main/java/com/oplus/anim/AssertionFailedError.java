package com.oplus.anim;

/* compiled from: EffectiveAnimationDrawable.java */
/* loaded from: classes2.dex */
public class b_renamed extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable, android.graphics.drawable.Drawable.Callback {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.String f3514c = "b_renamed";

    /* renamed from: a_renamed, reason: collision with root package name */
    com.oplus.anim.i_renamed f3515a;

    /* renamed from: b_renamed, reason: collision with root package name */
    com.oplus.anim.p_renamed f3516b;
    private com.oplus.anim.a_renamed h_renamed;
    private com.oplus.anim.b_renamed.b_renamed j_renamed;
    private java.lang.String k_renamed;
    private com.oplus.anim.j_renamed l_renamed;
    private com.oplus.anim.b_renamed.a_renamed m_renamed;
    private boolean n_renamed;
    private com.oplus.anim.c_renamed.c_renamed.b_renamed o_renamed;
    private boolean q_renamed;
    private final android.graphics.Matrix d_renamed = new android.graphics.Matrix();
    private final com.oplus.anim.f_renamed.b_renamed e_renamed = new com.oplus.anim.f_renamed.b_renamed();
    private final java.util.Set<java.lang.Object> f_renamed = new java.util.HashSet();
    private final java.util.ArrayList<com.oplus.anim.b_renamed.a_renamed> g_renamed = new java.util.ArrayList<>();
    private float i_renamed = 1.0f;
    private int p_renamed = 255;
    private boolean r_renamed = false;

    /* compiled from: EffectiveAnimationDrawable.java */
    private interface a_renamed {
        void a_renamed(com.oplus.anim.a_renamed aVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public b_renamed() {
        this.e_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.anim.b_renamed.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (com.oplus.anim.b_renamed.this.o_renamed != null) {
                    com.oplus.anim.b_renamed.this.o_renamed.a_renamed(com.oplus.anim.b_renamed.this.e_renamed.d_renamed());
                }
            }
        });
    }

    public boolean a_renamed() {
        return this.n_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        if (this.n_renamed == z_renamed) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 19) {
            android.util.Log.w_renamed(f3514c, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.n_renamed = z_renamed;
        if (this.h_renamed != null) {
            v_renamed();
        }
    }

    public void a_renamed(java.lang.String str) {
        this.k_renamed = str;
    }

    public java.lang.String b_renamed() {
        return this.k_renamed;
    }

    public boolean a_renamed(com.oplus.anim.a_renamed aVar) {
        if (this.h_renamed == aVar) {
            return false;
        }
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveAnimationDrawable::setComposition:composition = " + aVar.toString());
        }
        com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveAnimationDrawable::setComposition");
        this.r_renamed = false;
        d_renamed();
        this.h_renamed = aVar;
        v_renamed();
        this.e_renamed.a_renamed(aVar);
        e_renamed(this.e_renamed.getAnimatedFraction());
        d_renamed(this.i_renamed);
        w_renamed();
        java.util.Iterator it = new java.util.ArrayList(this.g_renamed).iterator();
        while (it.hasNext()) {
            ((com.oplus.anim.b_renamed.a_renamed) it.next()).a_renamed(aVar);
            it.remove();
        }
        this.g_renamed.clear();
        aVar.b_renamed(this.q_renamed);
        return true;
    }

    public void b_renamed(boolean z_renamed) {
        this.q_renamed = z_renamed;
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.b_renamed(z_renamed);
        }
    }

    public com.oplus.anim.m_renamed c_renamed() {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            return aVar.c_renamed();
        }
        return null;
    }

    private void v_renamed() {
        this.o_renamed = new com.oplus.anim.c_renamed.c_renamed.b_renamed(this, com.oplus.anim.e_renamed.t_renamed.a_renamed(this.h_renamed), this.h_renamed.i_renamed(), this.h_renamed);
    }

    public void d_renamed() {
        if (this.e_renamed.isRunning()) {
            this.e_renamed.cancel();
        }
        this.h_renamed = null;
        this.o_renamed = null;
        this.j_renamed = null;
        this.e_renamed.f_renamed();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.r_renamed) {
            return;
        }
        this.r_renamed = true;
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.p_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        android.util.Log.w_renamed("EffectiveAnimation", "Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        float f_renamed;
        this.r_renamed = false;
        com.oplus.anim.k_renamed.a_renamed("Drawable#draw#start");
        com.oplus.anim.k_renamed.c_renamed("Drawable#draw");
        if (this.o_renamed == null) {
            return;
        }
        float f2 = this.i_renamed;
        float fA_renamed = a_renamed(canvas);
        if (f2 > fA_renamed) {
            f_renamed = this.i_renamed / fA_renamed;
        } else {
            fA_renamed = f2;
            f_renamed = 1.0f;
        }
        int iSave = -1;
        if (f_renamed > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.h_renamed.d_renamed().width() / 2.0f;
            float fHeight = this.h_renamed.d_renamed().height() / 2.0f;
            float f3 = fWidth * fA_renamed;
            float f4 = fHeight * fA_renamed;
            canvas.translate((q_renamed() * fWidth) - f3, (q_renamed() * fHeight) - f4);
            canvas.scale(f_renamed, f_renamed, f3, f4);
        }
        this.d_renamed.reset();
        this.d_renamed.preScale(fA_renamed, fA_renamed);
        this.o_renamed.a_renamed(canvas, this.d_renamed, this.p_renamed);
        com.oplus.anim.k_renamed.a_renamed("Drawable#draw#end time = " + com.oplus.anim.k_renamed.d_renamed("Drawable#draw"));
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        e_renamed();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        f_renamed();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return n_renamed();
    }

    public void e_renamed() {
        if (this.o_renamed == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.7
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar) {
                    com.oplus.anim.b_renamed.this.e_renamed();
                }
            });
        } else {
            this.e_renamed.i_renamed();
        }
    }

    public void f_renamed() {
        this.g_renamed.clear();
        this.e_renamed.j_renamed();
    }

    public void g_renamed() {
        if (this.o_renamed == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.8
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar) {
                    com.oplus.anim.b_renamed.this.g_renamed();
                }
            });
        } else {
            this.e_renamed.l_renamed();
        }
    }

    public void a_renamed(final int i_renamed) {
        if (this.h_renamed == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.9
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar) {
                    com.oplus.anim.b_renamed.this.a_renamed(i_renamed);
                }
            });
        } else {
            this.e_renamed.b_renamed(i_renamed);
        }
    }

    public float h_renamed() {
        return this.e_renamed.m_renamed();
    }

    public void b_renamed(final java.lang.String str) {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.10
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar2) {
                    com.oplus.anim.b_renamed.this.b_renamed(str);
                }
            });
            return;
        }
        com.oplus.anim.c_renamed.h_renamed hVarC = aVar.c_renamed(str);
        if (hVarC == null) {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        a_renamed((int) hVarC.f3637b);
    }

    public void a_renamed(final float f_renamed) {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.11
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar2) {
                    com.oplus.anim.b_renamed.this.a_renamed(f_renamed);
                }
            });
        } else {
            a_renamed((int) com.oplus.anim.f_renamed.e_renamed.a_renamed(aVar.f_renamed(), this.h_renamed.g_renamed(), f_renamed));
        }
    }

    public void b_renamed(final int i_renamed) {
        if (this.h_renamed == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.12
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar) {
                    com.oplus.anim.b_renamed.this.b_renamed(i_renamed);
                }
            });
        } else {
            this.e_renamed.b_renamed(i_renamed + 0.99f);
        }
    }

    public float i_renamed() {
        return this.e_renamed.n_renamed();
    }

    public void c_renamed(final java.lang.String str) {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.13
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar2) {
                    com.oplus.anim.b_renamed.this.c_renamed(str);
                }
            });
            return;
        }
        com.oplus.anim.c_renamed.h_renamed hVarC = aVar.c_renamed(str);
        if (hVarC == null) {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        b_renamed((int) (hVarC.f3637b + hVarC.f3638c));
    }

    public void b_renamed(final float f_renamed) {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.14
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar2) {
                    com.oplus.anim.b_renamed.this.b_renamed(f_renamed);
                }
            });
        } else {
            b_renamed((int) com.oplus.anim.f_renamed.e_renamed.a_renamed(aVar.f_renamed(), this.h_renamed.g_renamed(), f_renamed));
        }
    }

    public void d_renamed(final java.lang.String str) {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.2
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar2) {
                    com.oplus.anim.b_renamed.this.d_renamed(str);
                }
            });
            return;
        }
        com.oplus.anim.c_renamed.h_renamed hVarC = aVar.c_renamed(str);
        if (hVarC == null) {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i_renamed = (int) hVarC.f3637b;
        a_renamed(i_renamed, ((int) hVarC.f3638c) + i_renamed);
    }

    public void a_renamed(final int i_renamed, final int i2) {
        if (this.h_renamed == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.3
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar) {
                    com.oplus.anim.b_renamed.this.a_renamed(i_renamed, i2);
                }
            });
        } else {
            this.e_renamed.a_renamed(i_renamed, i2 + 0.99f);
        }
    }

    public float j_renamed() {
        return this.e_renamed.h_renamed();
    }

    public void c_renamed(float f_renamed) {
        this.e_renamed.a_renamed(f_renamed);
    }

    public int k_renamed() {
        return (int) this.e_renamed.e_renamed();
    }

    public void c_renamed(final int i_renamed) {
        if (this.h_renamed == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.4
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar) {
                    com.oplus.anim.b_renamed.this.c_renamed(i_renamed);
                }
            });
        } else {
            this.e_renamed.a_renamed(i_renamed);
        }
    }

    public int l_renamed() {
        return this.e_renamed.getRepeatMode();
    }

    public void d_renamed(int i_renamed) {
        this.e_renamed.setRepeatMode(i_renamed);
    }

    public int m_renamed() {
        return this.e_renamed.getRepeatCount();
    }

    public void e_renamed(int i_renamed) {
        this.e_renamed.setRepeatCount(i_renamed);
    }

    public boolean n_renamed() {
        return this.e_renamed.isRunning();
    }

    public void a_renamed(com.oplus.anim.j_renamed jVar) {
        this.l_renamed = jVar;
        com.oplus.anim.b_renamed.b_renamed bVar = this.j_renamed;
        if (bVar != null) {
            bVar.a_renamed(jVar);
        }
    }

    public void a_renamed(com.oplus.anim.i_renamed iVar) {
        this.f3515a = iVar;
        com.oplus.anim.b_renamed.a_renamed aVar = this.m_renamed;
        if (aVar != null) {
            aVar.a_renamed(iVar);
        }
    }

    public com.oplus.anim.p_renamed o_renamed() {
        return this.f3516b;
    }

    public void a_renamed(com.oplus.anim.p_renamed pVar) {
        this.f3516b = pVar;
    }

    public boolean p_renamed() {
        return this.f3516b == null && this.h_renamed.j_renamed().size() > 0;
    }

    public float q_renamed() {
        return this.i_renamed;
    }

    public void d_renamed(float f_renamed) {
        this.i_renamed = f_renamed;
        w_renamed();
    }

    public com.oplus.anim.a_renamed r_renamed() {
        return this.h_renamed;
    }

    private void w_renamed() {
        if (this.h_renamed == null) {
            return;
        }
        float fQ_renamed = q_renamed();
        setBounds(0, 0, (int) (this.h_renamed.d_renamed().width() * fQ_renamed), (int) (this.h_renamed.d_renamed().height() * fQ_renamed));
    }

    public void s_renamed() {
        this.g_renamed.clear();
        this.e_renamed.cancel();
    }

    public void t_renamed() {
        this.g_renamed.clear();
        this.e_renamed.k_renamed();
    }

    public float u_renamed() {
        return this.e_renamed.d_renamed();
    }

    public void e_renamed(final float f_renamed) {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.5
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar2) {
                    com.oplus.anim.b_renamed.this.e_renamed(f_renamed);
                }
            });
        } else {
            c_renamed((int) com.oplus.anim.f_renamed.e_renamed.a_renamed(aVar.f_renamed(), this.h_renamed.g_renamed(), f_renamed));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.h_renamed == null) {
            return -1;
        }
        return (int) (r0.d_renamed().width() * q_renamed());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.h_renamed == null) {
            return -1;
        }
        return (int) (r0.d_renamed().height() * q_renamed());
    }

    public java.util.List<com.oplus.anim.c_renamed.f_renamed> a_renamed(com.oplus.anim.c_renamed.f_renamed fVar) {
        if (this.o_renamed == null) {
            android.util.Log.w_renamed("EffectiveAnimation", "Cannot resolve KeyPath. Composition is_renamed not set yet.");
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.o_renamed.a_renamed(fVar, 0, arrayList, new com.oplus.anim.c_renamed.f_renamed(new java.lang.String[0]));
        return arrayList;
    }

    public <T_renamed> void a_renamed(final com.oplus.anim.c_renamed.f_renamed fVar, final T_renamed t_renamed, final com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        if (this.o_renamed == null) {
            this.g_renamed.add(new com.oplus.anim.b_renamed.a_renamed() { // from class: com.oplus.anim.b_renamed.6
                @Override // com.oplus.anim.b_renamed.a_renamed
                public void a_renamed(com.oplus.anim.a_renamed aVar) {
                    com.oplus.anim.b_renamed.this.a_renamed(fVar, t_renamed, bVar);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (fVar.a_renamed() != null) {
            fVar.a_renamed().a_renamed(t_renamed, bVar);
        } else {
            java.util.List<com.oplus.anim.c_renamed.f_renamed> listA = a_renamed(fVar);
            for (int i_renamed = 0; i_renamed < listA.size(); i_renamed++) {
                if (com.oplus.anim.f_renamed.f_renamed.f3678c) {
                    com.oplus.anim.f_renamed.f_renamed.a_renamed("EffectiveAnimationDrawable::KeyPath = " + listA.get(i_renamed));
                }
                listA.get(i_renamed).a_renamed().a_renamed(t_renamed, bVar);
            }
            zIsEmpty = true ^ listA.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t_renamed == com.oplus.anim.d_renamed.y_renamed) {
                e_renamed(u_renamed());
            }
        }
    }

    public android.graphics.Bitmap e_renamed(java.lang.String str) {
        com.oplus.anim.b_renamed.b_renamed bVarX = x_renamed();
        if (bVarX != null) {
            return bVarX.a_renamed(str);
        }
        return null;
    }

    private com.oplus.anim.b_renamed.b_renamed x_renamed() {
        if (getCallback() == null) {
            return null;
        }
        com.oplus.anim.b_renamed.b_renamed bVar = this.j_renamed;
        if (bVar != null && !bVar.a_renamed(z_renamed())) {
            this.j_renamed = null;
        }
        if (this.j_renamed == null) {
            this.j_renamed = new com.oplus.anim.b_renamed.b_renamed(getCallback(), this.k_renamed, this.l_renamed, this.h_renamed.l_renamed());
        }
        return this.j_renamed;
    }

    public android.graphics.Typeface a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.anim.b_renamed.a_renamed aVarY = y_renamed();
        if (aVarY != null) {
            return aVarY.a_renamed(str, str2);
        }
        return null;
    }

    private com.oplus.anim.b_renamed.a_renamed y_renamed() {
        if (getCallback() == null) {
            return null;
        }
        if (this.m_renamed == null) {
            this.m_renamed = new com.oplus.anim.b_renamed.a_renamed(getCallback(), this.f3515a);
        }
        return this.m_renamed;
    }

    private android.content.Context z_renamed() {
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

    private float a_renamed(android.graphics.Canvas canvas) {
        return java.lang.Math.min(canvas.getWidth() / this.h_renamed.d_renamed().width(), canvas.getHeight() / this.h_renamed.d_renamed().height());
    }
}
