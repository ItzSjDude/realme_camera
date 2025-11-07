package com.coui.responsiveui.config;

/* loaded from: classes.dex */
public class UIScreenSize {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3152a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3153b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f3154c;

    @java.lang.Deprecated
    public UIScreenSize(int i_renamed, int i2) {
        this.f3152a = i_renamed;
        this.f3153b = i2;
    }

    public UIScreenSize(int i_renamed, int i2, int i3) {
        this.f3152a = i_renamed;
        this.f3153b = i2;
        this.f3154c = i3;
    }

    public int getWidthDp() {
        return this.f3152a;
    }

    public void setWidthDp(int i_renamed) {
        this.f3152a = i_renamed;
    }

    public int getHeightDp() {
        return this.f3153b;
    }

    public void setHeightDp(int i_renamed) {
        this.f3153b = i_renamed;
    }

    int a_renamed() {
        return this.f3154c;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.coui.responsiveui.config.UIScreenSize uIScreenSize = (com.coui.responsiveui.config.UIScreenSize) obj;
        return this.f3152a == uIScreenSize.f3152a && this.f3153b == uIScreenSize.f3153b;
    }

    public int hashCode() {
        return java.util.Objects.hash(java.lang.Integer.valueOf(this.f3152a), java.lang.Integer.valueOf(this.f3153b), java.lang.Integer.valueOf(this.f3154c));
    }

    public java.lang.String toString() {
        return "UIScreenSize{W_renamed-Dp=" + this.f3152a + ", H_renamed-Dp=" + this.f3153b + ", SW-Dp=" + this.f3154c + "}";
    }
}
