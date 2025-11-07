package com.oplus.camera.algovisualization;

/* compiled from: AlgoVisualAPSProcessor.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.e_renamed.d_renamed f4142a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4143b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4144c;

    public b_renamed(com.oplus.camera.e_renamed.d_renamed dVar, boolean z_renamed, boolean z2) {
        this.f4142a = dVar;
        this.f4143b = z_renamed;
        this.f4144c = z2;
    }

    public void a_renamed() {
        this.f4142a.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.ALGO_VISUALIZATION_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (this.f4143b ? "on_renamed" : "off"));
    }

    public void b_renamed() {
        this.f4142a.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.PICTURE_VISUALIZATION_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (this.f4144c ? "on_renamed" : "off"));
    }
}
