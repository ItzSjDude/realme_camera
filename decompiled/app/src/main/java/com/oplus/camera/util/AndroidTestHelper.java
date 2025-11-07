package com.oplus.camera.util;

import android.content.Intent;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.oplus.camera.Storage;

/* loaded from: classes2.dex */
public class AndroidTestHelper {
    public static final String ANDROID_TEST = "android_test";
    public static boolean sAndroidTest;
    public static TestCallBack sTestCallBack;

    public static abstract class TestCallBack {
        public void onButtonReadyToClick(boolean z) {
        }

        public void onCaptureCompleted(CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        public void onNewPicture(Storage.CameraPicture cameraPicture) {
        }

        public void onPreviewCaptureCompleted(CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        public void onReadyToCapture(boolean z) {
        }

        public void onReadyToVideo(boolean z) {
        }
    }

    public static void init(Intent intent) {
        try {
            sAndroidTest = intent.getBooleanExtra(ANDROID_TEST, false);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public static void onNewPicture(Storage.CameraPicture cameraPicture) {
        TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onNewPicture(cameraPicture);
    }

    public static void onReadyToCapture(boolean z) {
        TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onReadyToCapture(z);
    }

    public static void onReadyToVideo(boolean z) {
        TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onReadyToVideo(z);
    }

    public static void onButtonReadyToClick(boolean z) {
        TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onButtonReadyToClick(z);
    }

    public static void onPreviewCaptureCompleted(CaptureRequest captureRequest, CaptureResult captureResult) {
        TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onPreviewCaptureCompleted(captureRequest, captureResult);
    }

    public static void onCaptureCompleted(CaptureRequest captureRequest, CaptureResult captureResult) {
        TestCallBack testCallBack;
        if (!sAndroidTest || (testCallBack = sTestCallBack) == null) {
            return;
        }
        testCallBack.onCaptureCompleted(captureRequest, captureResult);
    }
}
