package androidx.appcompat.widget;

/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
class t_renamed extends androidx.appcompat.widget.p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.widget.SeekBar f636a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.drawable.Drawable f637b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.res.ColorStateList f638c;
    private android.graphics.PorterDuff.Mode d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;

    t_renamed(android.widget.SeekBar seekBar) {
        super(seekBar);
        this.f638c = null;
        this.d_renamed = null;
        this.e_renamed = false;
        this.f_renamed = false;
        this.f636a = seekBar;
    }

    @Override // androidx.appcompat.widget.p_renamed
    void a_renamed(android.util.AttributeSet attributeSet, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super.a_renamed(attributeSet, i_renamed);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(this.f636a.getContext(), attributeSet, androidx.appcompat.R_renamed.styleable.AppCompatSeekBar, i_renamed, 0);
        android.graphics.drawable.Drawable drawableB = arVarA.b_renamed(androidx.appcompat.R_renamed.styleable.AppCompatSeekBar_android_thumb);
        if (drawableB != null) {
            this.f636a.setThumb(drawableB);
        }
        a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.AppCompatSeekBar_tickMark));
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.d_renamed = androidx.appcompat.widget.aa_renamed.a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.d_renamed);
            this.f_renamed = true;
        }
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f638c = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.AppCompatSeekBar_tickMarkTint);
            this.e_renamed = true;
        }
        arVarA.b_renamed();
        d_renamed();
    }

    void a_renamed(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.graphics.drawable.Drawable drawable2 = this.f637b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f637b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f636a);
            androidx.core.graphics.drawable.a_renamed.b_renamed(drawable, androidx.core.h_renamed.v_renamed.g_renamed(this.f636a));
            if (drawable.isStateful()) {
                drawable.setState(this.f636a.getDrawableState());
            }
            d_renamed();
        }
        this.f636a.invalidate();
    }

    private void d_renamed() {
        if (this.f637b != null) {
            if (this.e_renamed || this.f_renamed) {
                this.f637b = androidx.core.graphics.drawable.a_renamed.g_renamed(this.f637b.mutate());
                if (this.e_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.f637b, this.f638c);
                }
                if (this.f_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.f637b, this.d_renamed);
                }
                if (this.f637b.isStateful()) {
                    this.f637b.setState(this.f636a.getDrawableState());
                }
            }
        }
    }

    void b_renamed() {
        android.graphics.drawable.Drawable drawable = this.f637b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void c_renamed() {
        android.graphics.drawable.Drawable drawable = this.f637b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f636a.getDrawableState())) {
            this.f636a.invalidateDrawable(drawable);
        }
    }

    void a_renamed(android.graphics.Canvas canvas) {
        if (this.f637b != null) {
            int max = this.f636a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f637b.getIntrinsicWidth();
                int intrinsicHeight = this.f637b.getIntrinsicHeight();
                int i_renamed = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f637b.setBounds(-i_renamed, -i2, i_renamed, i2);
                float width = ((this.f636a.getWidth() - this.f636a.getPaddingLeft()) - this.f636a.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f636a.getPaddingLeft(), this.f636a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f637b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
