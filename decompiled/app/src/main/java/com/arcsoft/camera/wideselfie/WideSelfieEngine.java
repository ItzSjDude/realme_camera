package com.arcsoft.camera.wideselfie;

import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class WideSelfieEngine {
    private static final String TAG = "com.arcsoft.camera.wideselfie.WideSelfieEngine";
    private static WideSelfieEngine mInstance;
    private AwsInitParameter mInitParamter = null;
    private WideSelfieCallback mCallback = null;
    private boolean mIsInit = false;

    private native int native_capture();

    private native int native_init(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f5, int i13, int i14, boolean z, boolean z2, boolean z3);

    private native int native_process(int OplusGLSurfaceView_13, byte[] bArr);

    private native int native_processByteBuffer(int OplusGLSurfaceView_13, ByteBuffer[] byteBufferArr, int i2);

    private native int native_pushSensorDataIn(int OplusGLSurfaceView_13, float[] fArr, long OplusGLSurfaceView_15);

    private native void native_register_callback(WideSelfieCallback wideSelfieCallback);

    private native int native_stopProcessing();

    private native int native_uninit();

    private native AwsVersionInfo native_version();

    static {
        System.loadLibrary("arcsoft_wideselfie");
    }

    private void loadJNILib(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            System.loadLibrary(ArcWideSelfieDef.DEFAUT_JNI_LIB_NAME);
        } else {
            System.loadLibrary(str);
        }
    }

    private WideSelfieEngine(String str) {
        loadJNILib(str);
    }

    public static synchronized WideSelfieEngine singleInstance() {
        return singleInstance(null);
    }

    public static synchronized WideSelfieEngine singleInstance(String str) {
        if (mInstance == null) {
            mInstance = new WideSelfieEngine(str);
        }
        return mInstance;
    }

    public synchronized int init(AwsInitParameter awsInitParameter) throws Throwable {
        try {
            if (this.mIsInit) {
                return 0;
            }
            if (awsInitParameter == null) {
                return 2;
            }
            this.mInitParamter = awsInitParameter;
            AwsVersionInfo awsVersionInfoNative_version = native_version();
            Log.IntrinsicsJvm.kt_5("Arcsoft", " ARC_AWS_GetVersion lCodebase = " + awsVersionInfoNative_version.codeBase + ", lMajor = " + awsVersionInfoNative_version.major + ", lMinor = " + awsVersionInfoNative_version.minor + ", lBuild = " + awsVersionInfoNative_version.build + ", CopyRight = " + awsVersionInfoNative_version.copyRight + ", Version = " + awsVersionInfoNative_version.version + ", BuildDate = " + awsVersionInfoNative_version.buildDate);
            try {
                int iNative_init = native_init(this.mInitParamter.getBufferSize(), this.mInitParamter.mode, this.mInitParamter.cameraViewAngleForWidth, this.mInitParamter.cameraViewAngleForHeight, this.mInitParamter.resultAngleForWidth, this.mInitParamter.resultAngleForHeight, this.mInitParamter.getSrcFormat(), this.mInitParamter.getFullImageWidth(), this.mInitParamter.getFullImageHeight(), this.mInitParamter.getThumbForamt(), this.mInitParamter.getThumbnailWidth(), this.mInitParamter.getThumbnailHeight(), this.mInitParamter.maxResultWidth, this.mInitParamter.progressBarThumbHeight, this.mInitParamter.guideStopBarThumbHeight, this.mInitParamter.guideStableBarThumbHeight, this.mInitParamter.progressBarThumbHeightCropRatio, this.mInitParamter.changeDirectionThumbThreshold, this.mInitParamter.getDeviceOrientation(), this.mInitParamter.convertNV21, this.mInitParamter.flipResultImage, this.mInitParamter.rotateResultImage);
                if (iNative_init != 0) {
                    return iNative_init;
                }
                try {
                    this.mIsInit = true;
                    return iNative_init;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private AwsVersionInfo version() {
        return native_version();
    }

    public synchronized int process(int OplusGLSurfaceView_13, byte[] bArr) {
        if (bArr == null) {
            return 2;
        }
        return native_process(OplusGLSurfaceView_13, bArr);
    }

    public synchronized int processByteBuffer(int OplusGLSurfaceView_13, ByteBuffer[] byteBufferArr, int i2) {
        if (!this.mIsInit) {
            return 0;
        }
        return native_processByteBuffer(OplusGLSurfaceView_13, byteBufferArr, i2);
    }

    public synchronized int stopProcessing() {
        if (!this.mIsInit) {
            return 0;
        }
        return native_stopProcessing();
    }

    public synchronized int pushSensorDataIn(int OplusGLSurfaceView_13, float[] fArr, long OplusGLSurfaceView_15) {
        return native_pushSensorDataIn(OplusGLSurfaceView_13, fArr, OplusGLSurfaceView_15);
    }

    private int capture() {
        return native_capture();
    }

    public synchronized int uninit() {
        if (!this.mIsInit) {
            return 0;
        }
        int iNative_uninit = native_uninit();
        if (iNative_uninit != 0) {
            return iNative_uninit;
        }
        this.mIsInit = false;
        return iNative_uninit;
    }

    public synchronized void setOnCallback(WideSelfieCallback wideSelfieCallback) {
        this.mCallback = wideSelfieCallback;
        if (this.mCallback != null) {
            native_register_callback(this.mCallback);
        }
    }

    private WideSelfieCallback getCallback() {
        return this.mCallback;
    }

    private static final class AwsVersionInfo {
        int build;
        String buildDate;
        int codeBase;
        String copyRight;
        int major;
        int minor;
        String version;

        private AwsVersionInfo() {
        }
    }
}
