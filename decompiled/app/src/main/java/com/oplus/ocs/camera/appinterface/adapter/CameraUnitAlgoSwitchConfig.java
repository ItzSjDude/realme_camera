package com.oplus.ocs.camera.appinterface.adapter;

/* loaded from: classes2.dex */
public class CameraUnitAlgoSwitchConfig {
    public static final int APS_MODE_CAPTURE = 2;
    public static final int APS_MODE_FULL = 1;
    public static final int APS_MODE_NONE = 0;
    public static final int APS_MODE_PREVIEW = 3;
    public static final java.lang.String APS_PIPELINE_ASD = "asd";
    public static final java.lang.String APS_PIPELINE_PREVIEW = "preview";
    public static final java.lang.String APS_PIPELINE_VIDEO = "video";
    public static final int APS_VERSION_2 = 2;
    public static final int APS_VERSION_3 = 3;

    public static boolean getSupportCaptureAlgo(java.lang.String str, int i_renamed, java.lang.String str2) {
        return com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getSupportCaptureAlgo(str, i_renamed, str2);
    }

    public static boolean getSupportCameraFeature(java.lang.String str, int i_renamed) {
        return com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getSupportCameraFeature(str, i_renamed);
    }

    public static boolean getSupportPreviewAlgo(java.lang.String str, int i_renamed, java.lang.String str2, java.lang.String str3) {
        return com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getSupportPreviewAlgo(str, i_renamed, str2, str3);
    }

    public static boolean getSupportApsPreview() {
        return com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getSupportApsPreview();
    }

    public static com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.CaptureConfig getCaptureConfig(java.lang.String str, int i_renamed) {
        return new com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.CaptureConfig(com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getCaptureConfig(str, i_renamed));
    }

    public static int getApsVersion() {
        return com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getApsVersion();
    }

    public static boolean getSupportApsCapture() {
        return com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getSupportApsCapture();
    }

    public static com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.PreviewConfig getPreviewConfig(java.lang.String str, int i_renamed) {
        return new com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.PreviewConfig(com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getPreviewConfig(str, i_renamed));
    }

    public static com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.PreviewConfig getPreviewConfig(java.lang.String str, int i_renamed, android.util.Size size, android.util.Size size2, boolean z_renamed, boolean z2, boolean z3) {
        return new com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.PreviewConfig(com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfig.getPreviewConfig(str, i_renamed, size, size2, z_renamed, z2, z3));
    }
}
