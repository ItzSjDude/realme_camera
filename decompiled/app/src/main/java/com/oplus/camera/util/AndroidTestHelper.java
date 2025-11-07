package com.oplus.camera.util;

/* loaded from: classes2.dex */
public class AndroidTestHelper {
    public static final java.lang.String ANDROID_TEST = "android_test";
    public static boolean sAndroidTest;
    public static com.oplus.camera.util.AndroidTestHelper.TestCallBack sTestCallBack;

    public static abstract class TestCallBack {
        public void onButtonReadyToClick(boolean z_renamed) {
        }

        public void onCaptureCompleted(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
        }

        public void onNewPicture(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        }

        public void onPreviewCaptureCompleted(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
        }

        public void onReadyToCapture(boolean z_renamed) {
        }

        public void onReadyToVideo(boolean z_renamed) {
        }
    }

    public static void init(android.content.Intent intent) {
        try {
            sAndroidTest = intent.getBooleanExtra(ANDROID_TEST, false);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public static void onNewPicture(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        com.oplus.camera.util.AndroidTestHelper.TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onNewPicture(cameraPicture);
    }

    public static void onReadyToCapture(boolean z_renamed) {
        com.oplus.camera.util.AndroidTestHelper.TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onReadyToCapture(z_renamed);
    }

    public static void onReadyToVideo(boolean z_renamed) {
        com.oplus.camera.util.AndroidTestHelper.TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onReadyToVideo(z_renamed);
    }

    public static void onButtonReadyToClick(boolean z_renamed) {
        com.oplus.camera.util.AndroidTestHelper.TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onButtonReadyToClick(z_renamed);
    }

    public static void onPreviewCaptureCompleted(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
        com.oplus.camera.util.AndroidTestHelper.TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onPreviewCaptureCompleted(captureRequest, captureResult);
    }

    public static void onCaptureCompleted(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
        com.oplus.camera.util.AndroidTestHelper.TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onCaptureCompleted(captureRequest, captureResult);
    }
}
