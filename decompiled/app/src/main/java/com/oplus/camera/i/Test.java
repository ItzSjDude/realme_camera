package com.oplus.camera.i_renamed;

/* compiled from: FeatureHDR.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.i_renamed.a_renamed implements com.oplus.camera.i_renamed.e_renamed {
    @Override // com.oplus.camera.i_renamed.e_renamed
    public java.lang.String c_renamed() {
        return "auto";
    }

    public d_renamed(com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        super(aVar, cameraUIInterface);
    }

    @Override // com.oplus.camera.i_renamed.e_renamed
    public void a_renamed() {
        this.f4715c.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, "off").apply();
        this.f4714b.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
    }

    @Override // com.oplus.camera.i_renamed.e_renamed
    public java.lang.String b_renamed() {
        return com.oplus.ocs.camera.CameraParameter.CAPTURE_HDR_MODE.getKeyName();
    }
}
