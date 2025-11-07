package androidx.appcompat.widget;

/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.widget.ImageView f623a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ap_renamed f624b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ap_renamed f625c;
    private androidx.appcompat.widget.ap_renamed d_renamed;

    public m_renamed(android.widget.ImageView imageView) {
        this.f623a = imageView;
    }

    public void a_renamed(android.util.AttributeSet attributeSet, int i_renamed) {
        int iG;
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(this.f623a.getContext(), attributeSet, androidx.appcompat.R_renamed.styleable.AppCompatImageView, i_renamed, 0);
        try {
            android.graphics.drawable.Drawable drawable = this.f623a.getDrawable();
            if (drawable == null && (iG = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.f623a.getContext(), iG)) != null) {
                this.f623a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                androidx.appcompat.widget.aa_renamed.b_renamed(drawable);
            }
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.AppCompatImageView_tint)) {
                androidx.core.widget.e_renamed.a_renamed(this.f623a, arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.AppCompatImageView_tint));
            }
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.e_renamed.a_renamed(this.f623a, androidx.appcompat.widget.aa_renamed.a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            arVarA.b_renamed();
        }
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed != 0) {
            android.graphics.drawable.Drawable drawableB = androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.f623a.getContext(), i_renamed);
            if (drawableB != null) {
                androidx.appcompat.widget.aa_renamed.b_renamed(drawableB);
            }
            this.f623a.setImageDrawable(drawableB);
        } else {
            this.f623a.setImageDrawable(null);
        }
        d_renamed();
    }

    boolean a_renamed() {
        return android.os.Build.VERSION.SDK_INT < 21 || !(this.f623a.getBackground() instanceof android.graphics.drawable.RippleDrawable);
    }

    void a_renamed(android.content.res.ColorStateList colorStateList) {
        if (this.f625c == null) {
            this.f625c = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.f625c;
        apVar.f573a = colorStateList;
        apVar.d_renamed = true;
        d_renamed();
    }

    android.content.res.ColorStateList b_renamed() {
        androidx.appcompat.widget.ap_renamed apVar = this.f625c;
        if (apVar != null) {
            return apVar.f573a;
        }
        return null;
    }

    void a_renamed(android.graphics.PorterDuff.Mode mode) {
        if (this.f625c == null) {
            this.f625c = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.f625c;
        apVar.f574b = mode;
        apVar.f575c = true;
        d_renamed();
    }

    android.graphics.PorterDuff.Mode c_renamed() {
        androidx.appcompat.widget.ap_renamed apVar = this.f625c;
        if (apVar != null) {
            return apVar.f574b;
        }
        return null;
    }

    void d_renamed() {
        android.graphics.drawable.Drawable drawable = this.f623a.getDrawable();
        if (drawable != null) {
            androidx.appcompat.widget.aa_renamed.b_renamed(drawable);
        }
        if (drawable != null) {
            if (e_renamed() && a_renamed(drawable)) {
                return;
            }
            androidx.appcompat.widget.ap_renamed apVar = this.f625c;
            if (apVar != null) {
                androidx.appcompat.widget.i_renamed.a_renamed(drawable, apVar, this.f623a.getDrawableState());
                return;
            }
            androidx.appcompat.widget.ap_renamed apVar2 = this.f624b;
            if (apVar2 != null) {
                androidx.appcompat.widget.i_renamed.a_renamed(drawable, apVar2, this.f623a.getDrawableState());
            }
        }
    }

    private boolean e_renamed() {
        int i_renamed = android.os.Build.VERSION.SDK_INT;
        return i_renamed > 21 ? this.f624b != null : i_renamed == 21;
    }

    private boolean a_renamed(android.graphics.drawable.Drawable drawable) {
        if (this.d_renamed == null) {
            this.d_renamed = new androidx.appcompat.widget.ap_renamed();
        }
        androidx.appcompat.widget.ap_renamed apVar = this.d_renamed;
        apVar.a_renamed();
        android.content.res.ColorStateList colorStateListA = androidx.core.widget.e_renamed.a_renamed(this.f623a);
        if (colorStateListA != null) {
            apVar.d_renamed = true;
            apVar.f573a = colorStateListA;
        }
        android.graphics.PorterDuff.Mode modeB = androidx.core.widget.e_renamed.b_renamed(this.f623a);
        if (modeB != null) {
            apVar.f575c = true;
            apVar.f574b = modeB;
        }
        if (!apVar.d_renamed && !apVar.f575c) {
            return false;
        }
        androidx.appcompat.widget.i_renamed.a_renamed(drawable, apVar, this.f623a.getDrawableState());
        return true;
    }
}
