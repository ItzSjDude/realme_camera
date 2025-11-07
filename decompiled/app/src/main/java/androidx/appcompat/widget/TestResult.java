package androidx.appcompat.widget;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.widget.CompoundButton f614a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.res.ColorStateList f615b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.PorterDuff.Mode f616c = null;
    private boolean d_renamed = false;
    private boolean e_renamed = false;
    private boolean f_renamed;

    h_renamed(android.widget.CompoundButton compoundButton) {
        this.f614a = compoundButton;
    }

    void a_renamed(android.util.AttributeSet attributeSet, int i_renamed) {
        boolean z_renamed;
        int resourceId;
        int resourceId2;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.f614a.getContext().obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.CompoundButton, i_renamed, 0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.CompoundButton_buttonCompat) || (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.CompoundButton_buttonCompat, 0)) == 0) {
                z_renamed = false;
            } else {
                try {
                    this.f614a.setButtonDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.f614a.getContext(), resourceId2));
                    z_renamed = true;
                } catch (android.content.res.Resources.NotFoundException unused) {
                }
            }
            if (!z_renamed && typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f614a.setButtonDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.f614a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.CompoundButton_buttonTint)) {
                androidx.core.widget.c_renamed.a_renamed(this.f614a, typedArrayObtainStyledAttributes.getColorStateList(androidx.appcompat.R_renamed.styleable.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.CompoundButton_buttonTintMode)) {
                androidx.core.widget.c_renamed.a_renamed(this.f614a, androidx.appcompat.widget.aa_renamed.a_renamed(typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R_renamed.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    void a_renamed(android.content.res.ColorStateList colorStateList) {
        this.f615b = colorStateList;
        this.d_renamed = true;
        d_renamed();
    }

    android.content.res.ColorStateList a_renamed() {
        return this.f615b;
    }

    void a_renamed(android.graphics.PorterDuff.Mode mode) {
        this.f616c = mode;
        this.e_renamed = true;
        d_renamed();
    }

    android.graphics.PorterDuff.Mode b_renamed() {
        return this.f616c;
    }

    void c_renamed() {
        if (this.f_renamed) {
            this.f_renamed = false;
        } else {
            this.f_renamed = true;
            d_renamed();
        }
    }

    void d_renamed() {
        android.graphics.drawable.Drawable drawableB = androidx.core.widget.c_renamed.b_renamed(this.f614a);
        if (drawableB != null) {
            if (this.d_renamed || this.e_renamed) {
                android.graphics.drawable.Drawable drawableMutate = androidx.core.graphics.drawable.a_renamed.g_renamed(drawableB).mutate();
                if (this.d_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(drawableMutate, this.f615b);
                }
                if (this.e_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(drawableMutate, this.f616c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f614a.getDrawableState());
                }
                this.f614a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int a_renamed(int i_renamed) {
        android.graphics.drawable.Drawable drawableB;
        return (android.os.Build.VERSION.SDK_INT >= 17 || (drawableB = androidx.core.widget.c_renamed.b_renamed(this.f614a)) == null) ? i_renamed : i_renamed + drawableB.getIntrinsicWidth();
    }
}
