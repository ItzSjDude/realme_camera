package androidx.appcompat.widget;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
class v_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.widget.TextView f641a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ap_renamed f642b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ap_renamed f643c;
    private androidx.appcompat.widget.ap_renamed d_renamed;
    private androidx.appcompat.widget.ap_renamed e_renamed;
    private androidx.appcompat.widget.ap_renamed f_renamed;
    private androidx.appcompat.widget.ap_renamed g_renamed;
    private androidx.appcompat.widget.ap_renamed h_renamed;
    private final androidx.appcompat.widget.w_renamed i_renamed;
    private int j_renamed = 0;
    private int k_renamed = -1;
    private android.graphics.Typeface l_renamed;
    private boolean m_renamed;

    v_renamed(android.widget.TextView textView) {
        this.f641a = textView;
        this.i_renamed = new androidx.appcompat.widget.w_renamed(this.f641a);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:48:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:55:0x012b  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a_renamed(android.util.AttributeSet r19, int r20) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v_renamed.a_renamed(android.util.AttributeSet, int):void");
    }

    public void a_renamed(android.graphics.Typeface typeface) {
        if (this.m_renamed) {
            this.f641a.setTypeface(typeface);
            this.l_renamed = typeface;
        }
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.f641a.post(runnable);
    }

    /* compiled from: AppCompatTextHelper.java */
    private static class a_renamed extends androidx.core.a_renamed.a_renamed.f_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.ref.WeakReference<androidx.appcompat.widget.v_renamed> f644a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f645b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f646c;

        @Override // androidx.core.a_renamed.a_renamed.f_renamed.a_renamed
        public void onFontRetrievalFailed(int i_renamed) {
        }

        /* compiled from: AppCompatTextHelper.java */
        /* renamed from: androidx.appcompat.widget.v_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        private class AppCompatTextHelper_3 implements java.lang.Runnable {

            /* renamed from: b_renamed, reason: collision with root package name */
            private final java.lang.ref.WeakReference<androidx.appcompat.widget.v_renamed> f648b;

            /* renamed from: c_renamed, reason: collision with root package name */
            private final android.graphics.Typeface f649c;

            AppCompatTextHelper_3(java.lang.ref.WeakReference<androidx.appcompat.widget.v_renamed> weakReference, android.graphics.Typeface typeface) {
                this.f648b = weakReference;
                this.f649c = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.appcompat.widget.v_renamed vVar = this.f648b.get();
                if (vVar == null) {
                    return;
                }
                vVar.a_renamed(this.f649c);
            }
        }

        a_renamed(androidx.appcompat.widget.v_renamed vVar, int i_renamed, int i2) {
            this.f644a = new java.lang.ref.WeakReference<>(vVar);
            this.f645b = i_renamed;
            this.f646c = i2;
        }

        @Override // androidx.core.a_renamed.a_renamed.f_renamed.a_renamed
        public void onFontRetrieved(android.graphics.Typeface typeface) {
            int i_renamed;
            androidx.appcompat.widget.v_renamed vVar = this.f644a.get();
            if (vVar == null) {
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 28 && (i_renamed = this.f645b) != -1) {
                typeface = android.graphics.Typeface.create(typeface, i_renamed, (this.f646c & 2) != 0);
            }
            vVar.a_renamed(new androidx.appcompat.widget.v_renamed.a_renamed.AppCompatTextHelper_3(this.f644a, typeface));
        }
    }

    private void a_renamed(android.content.Context context, androidx.appcompat.widget.ar_renamed arVar) {
        java.lang.String strD;
        this.j_renamed = arVar.a_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textStyle, this.j_renamed);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.k_renamed = arVar.a_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textFontWeight, -1);
            if (this.k_renamed != -1) {
                this.j_renamed = (this.j_renamed & 2) | 0;
            }
        }
        if (arVar.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_fontFamily) || arVar.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_fontFamily)) {
            this.l_renamed = null;
            int i_renamed = arVar.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_fontFamily) ? androidx.appcompat.R_renamed.styleable.TextAppearance_fontFamily : androidx.appcompat.R_renamed.styleable.TextAppearance_android_fontFamily;
            int i2 = this.k_renamed;
            int i3 = this.j_renamed;
            if (!context.isRestricted()) {
                try {
                    android.graphics.Typeface typefaceA = arVar.a_renamed(i_renamed, this.j_renamed, new androidx.appcompat.widget.v_renamed.a_renamed(this, i2, i3));
                    if (typefaceA != null) {
                        if (android.os.Build.VERSION.SDK_INT >= 28 && this.k_renamed != -1) {
                            this.l_renamed = android.graphics.Typeface.create(android.graphics.Typeface.create(typefaceA, 0), this.k_renamed, (this.j_renamed & 2) != 0);
                        } else {
                            this.l_renamed = typefaceA;
                        }
                    }
                    this.m_renamed = this.l_renamed == null;
                } catch (android.content.res.Resources.NotFoundException | java.lang.UnsupportedOperationException unused) {
                }
            }
            if (this.l_renamed != null || (strD = arVar.d_renamed(i_renamed)) == null) {
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 28 && this.k_renamed != -1) {
                this.l_renamed = android.graphics.Typeface.create(android.graphics.Typeface.create(strD, 0), this.k_renamed, (this.j_renamed & 2) != 0);
                return;
            } else {
                this.l_renamed = android.graphics.Typeface.create(strD, this.j_renamed);
                return;
            }
        }
        if (arVar.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_typeface)) {
            this.m_renamed = false;
            int iA = arVar.a_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_typeface, 1);
            if (iA == 1) {
                this.l_renamed = android.graphics.Typeface.SANS_SERIF;
            } else if (iA == 2) {
                this.l_renamed = android.graphics.Typeface.SERIF;
            } else {
                if (iA != 3) {
                    return;
                }
                this.l_renamed = android.graphics.Typeface.MONOSPACE;
            }
        }
    }

    void a_renamed(android.content.Context context, int i_renamed) {
        java.lang.String strD;
        android.content.res.ColorStateList colorStateListE;
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, i_renamed, androidx.appcompat.R_renamed.styleable.TextAppearance);
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_textAllCaps)) {
            a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_textAllCaps, false));
        }
        if (android.os.Build.VERSION.SDK_INT < 23 && arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textColor) && (colorStateListE = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textColor)) != null) {
            this.f641a.setTextColor(colorStateListE);
        }
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textSize) && arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f641a.setTextSize(0, 0.0f);
        }
        a_renamed(context, arVarA);
        if (android.os.Build.VERSION.SDK_INT >= 26 && arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_fontVariationSettings) && (strD = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f641a.setFontVariationSettings(strD);
        }
        arVarA.b_renamed();
        android.graphics.Typeface typeface = this.l_renamed;
        if (typeface != null) {
            this.f641a.setTypeface(typeface, this.j_renamed);
        }
    }

    void a_renamed(boolean z_renamed) {
        this.f641a.setAllCaps(z_renamed);
    }

    void a_renamed() {
        b_renamed();
    }

    void b_renamed() {
        if (this.f642b != null || this.f643c != null || this.d_renamed != null || this.e_renamed != null) {
            android.graphics.drawable.Drawable[] compoundDrawables = this.f641a.getCompoundDrawables();
            a_renamed(compoundDrawables[0], this.f642b);
            a_renamed(compoundDrawables[1], this.f643c);
            a_renamed(compoundDrawables[2], this.d_renamed);
            a_renamed(compoundDrawables[3], this.e_renamed);
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            if (this.f_renamed == null && this.g_renamed == null) {
                return;
            }
            android.graphics.drawable.Drawable[] compoundDrawablesRelative = this.f641a.getCompoundDrawablesRelative();
            a_renamed(compoundDrawablesRelative[0], this.f_renamed);
            a_renamed(compoundDrawablesRelative[2], this.g_renamed);
        }
    }

    private void a_renamed(android.graphics.drawable.Drawable drawable, androidx.appcompat.widget.ap_renamed apVar) {
        if (drawable == null || apVar == null) {
            return;
        }
        androidx.appcompat.widget.i_renamed.a_renamed(drawable, apVar, this.f641a.getDrawableState());
    }

    private static androidx.appcompat.widget.ap_renamed a_renamed(android.content.Context context, androidx.appcompat.widget.i_renamed iVar, int i_renamed) {
        android.content.res.ColorStateList colorStateListB = iVar.b_renamed(context, i_renamed);
        if (colorStateListB == null) {
            return null;
        }
        androidx.appcompat.widget.ap_renamed apVar = new androidx.appcompat.widget.ap_renamed();
        apVar.d_renamed = true;
        apVar.f573a = colorStateListB;
        return apVar;
    }

    void a_renamed(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        if (androidx.core.widget.b_renamed.d_renamed) {
            return;
        }
        c_renamed();
    }

    void a_renamed(int i_renamed, float f_renamed) {
        if (androidx.core.widget.b_renamed.d_renamed || d_renamed()) {
            return;
        }
        b_renamed(i_renamed, f_renamed);
    }

    void c_renamed() {
        this.i_renamed.f_renamed();
    }

    boolean d_renamed() {
        return this.i_renamed.g_renamed();
    }

    private void b_renamed(int i_renamed, float f_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        this.i_renamed.a_renamed(i_renamed, f_renamed);
    }

    void a_renamed(int i_renamed) {
        this.i_renamed.a_renamed(i_renamed);
    }

    void a_renamed(int i_renamed, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        this.i_renamed.a_renamed(i_renamed, i2, i3, i4);
    }

    void a_renamed(int[] iArr, int i_renamed) throws java.lang.IllegalArgumentException {
        this.i_renamed.a_renamed(iArr, i_renamed);
    }

    int e_renamed() {
        return this.i_renamed.a_renamed();
    }

    int f_renamed() {
        return this.i_renamed.b_renamed();
    }

    int g_renamed() {
        return this.i_renamed.c_renamed();
    }

    int h_renamed() {
        return this.i_renamed.d_renamed();
    }

    int[] i_renamed() {
        return this.i_renamed.e_renamed();
    }

    android.content.res.ColorStateList j_renamed() {
        androidx.appcompat.widget.ap_renamed apVar = this.h_renamed;
        if (apVar != null) {
            return apVar.f573a;
        }
        return null;
    }

    void a_renamed(android.content.res.ColorStateList colorStateList) {
        if (this.h_renamed == null) {
            this.h_renamed = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.h_renamed;
        apVar.f573a = colorStateList;
        apVar.d_renamed = colorStateList != null;
        l_renamed();
    }

    android.graphics.PorterDuff.Mode k_renamed() {
        androidx.appcompat.widget.ap_renamed apVar = this.h_renamed;
        if (apVar != null) {
            return apVar.f574b;
        }
        return null;
    }

    void a_renamed(android.graphics.PorterDuff.Mode mode) {
        if (this.h_renamed == null) {
            this.h_renamed = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.h_renamed;
        apVar.f574b = mode;
        apVar.f575c = mode != null;
        l_renamed();
    }

    private void l_renamed() {
        androidx.appcompat.widget.ap_renamed apVar = this.h_renamed;
        this.f642b = apVar;
        this.f643c = apVar;
        this.d_renamed = apVar;
        this.e_renamed = apVar;
        this.f_renamed = apVar;
        this.g_renamed = apVar;
    }

    private void a_renamed(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4, android.graphics.drawable.Drawable drawable5, android.graphics.drawable.Drawable drawable6) {
        if (android.os.Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            android.graphics.drawable.Drawable[] compoundDrawablesRelative = this.f641a.getCompoundDrawablesRelative();
            android.widget.TextView textView = this.f641a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            android.graphics.drawable.Drawable[] compoundDrawablesRelative2 = this.f641a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                android.widget.TextView textView2 = this.f641a;
                android.graphics.drawable.Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                android.graphics.drawable.Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        android.graphics.drawable.Drawable[] compoundDrawables = this.f641a.getCompoundDrawables();
        android.widget.TextView textView3 = this.f641a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }
}
