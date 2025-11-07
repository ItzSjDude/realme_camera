package com.oplus.camera.e_renamed;

/* compiled from: OplusMeteringRectangle.java */
/* loaded from: classes2.dex */
public final class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f4457a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f4458b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f4459c;
    private final int d_renamed;
    private final int e_renamed;

    public i_renamed(android.hardware.camera2.params.MeteringRectangle meteringRectangle) {
        this.f4457a = meteringRectangle.getX();
        this.f4458b = meteringRectangle.getY();
        this.f4459c = meteringRectangle.getWidth();
        this.d_renamed = meteringRectangle.getHeight();
        this.e_renamed = meteringRectangle.getMeteringWeight();
    }

    public i_renamed(android.graphics.Rect rect, int i_renamed) {
        this.f4457a = rect.left;
        this.f4458b = rect.top;
        this.f4459c = rect.width();
        this.d_renamed = rect.height();
        this.e_renamed = i_renamed;
    }

    public int[] a_renamed() {
        int i_renamed = this.f4457a;
        int i2 = this.f4458b;
        return new int[]{i_renamed, i2, i_renamed + this.f4459c, i2 + this.d_renamed, this.e_renamed};
    }

    public int hashCode() {
        return com.oplus.camera.util.Util.c_renamed(this.f4457a, this.f4458b, this.f4459c, this.d_renamed, this.e_renamed);
    }

    public java.lang.String toString() {
        return java.lang.String.format("(x_renamed:%d_renamed, y_renamed:%d_renamed, w_renamed:%d_renamed, h_renamed:%d_renamed, wt:%d_renamed)", java.lang.Integer.valueOf(this.f4457a), java.lang.Integer.valueOf(this.f4458b), java.lang.Integer.valueOf(this.f4459c), java.lang.Integer.valueOf(this.d_renamed), java.lang.Integer.valueOf(this.e_renamed));
    }
}
