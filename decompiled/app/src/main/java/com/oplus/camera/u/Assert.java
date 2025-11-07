package com.oplus.camera.u_renamed;

/* compiled from: DetectResult.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Point[] f5733a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.PointF[] f5734b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.PointF[] f5735c = null;
    private boolean d_renamed;

    public a_renamed() {
        this.d_renamed = false;
        this.d_renamed = false;
    }

    public android.graphics.PointF[] a_renamed() {
        return this.f5735c;
    }

    public void a_renamed(android.graphics.PointF[] pointFArr) {
        this.f5735c = pointFArr;
    }

    public android.graphics.PointF[] b_renamed() {
        return this.f5734b;
    }

    public void b_renamed(android.graphics.PointF[] pointFArr) {
        this.f5734b = pointFArr;
    }

    public void a_renamed(android.graphics.Point[] pointArr) {
        this.f5733a = pointArr;
    }

    public boolean c_renamed() {
        return this.d_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public java.lang.String toString() {
        return "DetectResult{mActualResultPointsArray=" + java.util.Arrays.toString(this.f5733a) + ", mPercentResultArrayForPreview=" + java.util.Arrays.toString(this.f5734b) + ", mPercentResultArrayForCapture=" + java.util.Arrays.toString(this.f5735c) + ", mbHasResult=" + this.d_renamed + '}';
    }
}
