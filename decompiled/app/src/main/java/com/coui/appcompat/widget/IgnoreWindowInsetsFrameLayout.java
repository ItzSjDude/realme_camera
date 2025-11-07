package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class IgnoreWindowInsetsFrameLayout extends android.widget.FrameLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f2879a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f2880b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f2881c;
    private boolean d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;

    public IgnoreWindowInsetsFrameLayout(android.content.Context context) {
        super(context);
        this.f2879a = true;
        this.f2880b = true;
        this.f2881c = true;
        this.d_renamed = true;
    }

    public IgnoreWindowInsetsFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2879a = true;
        this.f2880b = true;
        this.f2881c = true;
        this.d_renamed = true;
        a_renamed(attributeSet);
    }

    public IgnoreWindowInsetsFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2879a = true;
        this.f2880b = true;
        this.f2881c = true;
        this.d_renamed = true;
        a_renamed(attributeSet);
    }

    private void a_renamed(android.util.AttributeSet attributeSet) {
        if (getContext() != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.IgnoreWindowInsetsFrameLayout);
            this.f2879a = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.IgnoreWindowInsetsFrameLayout_ignoreWindowInsetsLeft, true);
            this.f2880b = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.IgnoreWindowInsetsFrameLayout_ignoreWindowInsetsTop, true);
            this.f2881c = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.IgnoreWindowInsetsFrameLayout_ignoreWindowInsetsRight, true);
            this.d_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.IgnoreWindowInsetsFrameLayout_ignoreWindowInsetsBottom, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets windowInsets) {
        setPadding(this.f2879a ? 0 : java.lang.Math.max(0, windowInsets.getSystemWindowInsetLeft() + this.e_renamed), this.f2880b ? 0 : java.lang.Math.max(0, windowInsets.getSystemWindowInsetTop() + this.f_renamed), this.f2881c ? 0 : java.lang.Math.max(0, windowInsets.getSystemWindowInsetRight() + this.g_renamed), this.d_renamed ? 0 : java.lang.Math.max(0, windowInsets.getSystemWindowInsetBottom() + this.h_renamed));
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        return windowInsets.consumeSystemWindowInsets();
    }

    public void setIgnoreWindowInsetsLeft(boolean z_renamed) {
        this.f2879a = z_renamed;
    }

    public void setIgnoreWindowInsetsTop(boolean z_renamed) {
        this.f2880b = z_renamed;
    }

    public void setIgnoreWindowInsetsRight(boolean z_renamed) {
        this.f2881c = z_renamed;
    }

    public void setIgnoreWindowInsetsBottom(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public void setWindowInsetsLeftOffset(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public void setWindowInsetsTopOffset(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    public void setWindowInsetsRightOffset(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    public void setWindowInsetsBottomOffset(int i_renamed) {
        this.h_renamed = i_renamed;
    }
}
