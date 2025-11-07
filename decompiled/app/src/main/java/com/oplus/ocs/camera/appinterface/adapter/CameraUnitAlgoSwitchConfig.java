package com.oplus.ocs.camera.appinterface.adapter;

import android.util.Size;
import com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil;

/* loaded from: classes2.dex */
public class CameraUnitAlgoSwitchConfig {
    public static final int APS_MODE_CAPTURE = 2;
    public static final int APS_MODE_FULL = 1;
    public static final int APS_MODE_NONE = 0;
    public static final int APS_MODE_PREVIEW = 3;
    public static final String APS_PIPELINE_ASD = "asd";
    public static final String APS_PIPELINE_PREVIEW = "preview";
    public static final String APS_PIPELINE_VIDEO = "video";
    public static final int APS_VERSION_2 = 2;
    public static final int APS_VERSION_3 = 3;

    public static boolean getSupportCaptureAlgo(String str, int OplusGLSurfaceView_13, String str2) {
        return CameraAlgoSwitchConfig.getSupportCaptureAlgo(str, OplusGLSurfaceView_13, str2);
    }

    public static boolean getSupportCameraFeature(String str, int OplusGLSurfaceView_13) {
        return CameraAlgoSwitchConfig.getSupportCameraFeature(str, OplusGLSurfaceView_13);
    }

    public static boolean getSupportPreviewAlgo(String str, int OplusGLSurfaceView_13, String str2, String str3) {
        return CameraAlgoSwitchConfig.getSupportPreviewAlgo(str, OplusGLSurfaceView_13, str2, str3);
    }

    public static boolean getSupportApsPreview() {
        return CameraAlgoSwitchConfig.getSupportApsPreview();
    }

    public static AlgoSwitchConfigUtil.CaptureConfig getCaptureConfig(String str, int OplusGLSurfaceView_13) {
        return new AlgoSwitchConfigUtil.CaptureConfig(CameraAlgoSwitchConfig.getCaptureConfig(str, OplusGLSurfaceView_13));
    }

    public static int getApsVersion() {
        return CameraAlgoSwitchConfig.getApsVersion();
    }

    public static boolean getSupportApsCapture() {
        return CameraAlgoSwitchConfig.getSupportApsCapture();
    }

    public static AlgoSwitchConfigUtil.PreviewConfig getPreviewConfig(String str, int OplusGLSurfaceView_13) {
        return new AlgoSwitchConfigUtil.PreviewConfig(CameraAlgoSwitchConfig.getPreviewConfig(str, OplusGLSurfaceView_13));
    }

    public static AlgoSwitchConfigUtil.PreviewConfig getPreviewConfig(String str, int OplusGLSurfaceView_13, Size size, Size size2, boolean z, boolean z2, boolean z3) {
        return new AlgoSwitchConfigUtil.PreviewConfig(CameraAlgoSwitchConfig.getPreviewConfig(str, OplusGLSurfaceView_13, size, size2, z, z2, z3));
    }
}
