package androidx.appcompat.widget;

/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.View f609a;
    private androidx.appcompat.widget.ap_renamed d_renamed;
    private androidx.appcompat.widget.ap_renamed e_renamed;
    private androidx.appcompat.widget.ap_renamed f_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f611c = -1;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.appcompat.widget.i_renamed f610b = androidx.appcompat.widget.i_renamed.b_renamed();

    e_renamed(android.view.View view) {
        this.f609a = view;
    }

    void a_renamed(android.util.AttributeSet attributeSet, int i_renamed) {
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(this.f609a.getContext(), attributeSet, androidx.appcompat.R_renamed.styleable.ViewBackgroundHelper, i_renamed, 0);
        try {
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ViewBackgroundHelper_android_background)) {
                this.f611c = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ViewBackgroundHelper_android_background, -1);
                android.content.res.ColorStateList colorStateListB = this.f610b.b_renamed(this.f609a.getContext(), this.f611c);
                if (colorStateListB != null) {
                    b_renamed(colorStateListB);
                }
            }
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.h_renamed.v_renamed.a_renamed(this.f609a, arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.h_renamed.v_renamed.a_renamed(this.f609a, androidx.appcompat.widget.aa_renamed.a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            arVarA.b_renamed();
        }
    }

    void a_renamed(int i_renamed) {
        this.f611c = i_renamed;
        androidx.appcompat.widget.i_renamed iVar = this.f610b;
        b_renamed(iVar != null ? iVar.b_renamed(this.f609a.getContext(), i_renamed) : null);
        c_renamed();
    }

    void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.f611c = -1;
        b_renamed((android.content.res.ColorStateList) null);
        c_renamed();
    }

    void a_renamed(android.content.res.ColorStateList colorStateList) {
        if (this.e_renamed == null) {
            this.e_renamed = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.e_renamed;
        apVar.f573a = colorStateList;
        apVar.d_renamed = true;
        c_renamed();
    }

    android.content.res.ColorStateList a_renamed() {
        androidx.appcompat.widget.ap_renamed apVar = this.e_renamed;
        if (apVar != null) {
            return apVar.f573a;
        }
        return null;
    }

    void a_renamed(android.graphics.PorterDuff.Mode mode) {
        if (this.e_renamed == null) {
            this.e_renamed = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.e_renamed;
        apVar.f574b = mode;
        apVar.f575c = true;
        c_renamed();
    }

    android.graphics.PorterDuff.Mode b_renamed() {
        androidx.appcompat.widget.ap_renamed apVar = this.e_renamed;
        if (apVar != null) {
            return apVar.f574b;
        }
        return null;
    }

    void c_renamed() {
        android.graphics.drawable.Drawable background = this.f609a.getBackground();
        if (background != null) {
            if (d_renamed() && b_renamed(background)) {
                return;
            }
            androidx.appcompat.widget.ap_renamed apVar = this.e_renamed;
            if (apVar != null) {
                androidx.appcompat.widget.i_renamed.a_renamed(background, apVar, this.f609a.getDrawableState());
                return;
            }
            androidx.appcompat.widget.ap_renamed apVar2 = this.d_renamed;
            if (apVar2 != null) {
                androidx.appcompat.widget.i_renamed.a_renamed(background, apVar2, this.f609a.getDrawableState());
            }
        }
    }

    void b_renamed(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d_renamed == null) {
                this.d_renamed = new androidx.appcompat.widget.ap_renamed();
            }
            androidx.appcompat.widget.ap_renamed apVar = this.d_renamed;
            apVar.f573a = colorStateList;
            apVar.d_renamed = true;
        } else {
            this.d_renamed = null;
        }
        c_renamed();
    }

    private boolean d_renamed() {
        int i_renamed = android.os.Build.VERSION.SDK_INT;
        return i_renamed > 21 ? this.d_renamed != null : i_renamed == 21;
    }

    private boolean b_renamed(android.graphics.drawable.Drawable drawable) {
        if (this.f_renamed == null) {
            this.f_renamed = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.f_renamed;
        apVar.a_renamed();
        android.content.res.ColorStateList colorStateListW = androidx.core.h_renamed.v_renamed.w_renamed(this.f609a);
        if (colorStateListW != null) {
            apVar.d_renamed = true;
            apVar.f573a = colorStateListW;
        }
        android.graphics.PorterDuff.Mode modeX = androidx.core.h_renamed.v_renamed.x_renamed(this.f609a);
        if (modeX != null) {
            apVar.f575c = true;
            apVar.f574b = modeX;
        }
        if (!apVar.d_renamed && !apVar.f575c) {
            return false;
        }
        androidx.appcompat.widget.i_renamed.a_renamed(drawable, apVar, this.f609a.getDrawableState());
        return true;
    }
}
