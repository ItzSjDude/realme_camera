package com.arcsoft.camera.wideselfie;

/* loaded from: classes.dex */
public class WideSelfieEngine {
    private static final java.lang.String TAG = "com.arcsoft.camera.wideselfie.WideSelfieEngine";
    private static com.arcsoft.camera.wideselfie.WideSelfieEngine mInstance;
    private com.arcsoft.camera.wideselfie.AwsInitParameter mInitParamter = null;
    private com.arcsoft.camera.wideselfie.WideSelfieCallback mCallback = null;
    private boolean mIsInit = false;

    private native int native_capture();

    private native int native_init(int i_renamed, int i2, float f_renamed, float f2, float f3, float f4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f5, int i13, int i14, boolean z_renamed, boolean z2, boolean z3);

    private native int native_process(int i_renamed, byte[] bArr);

    private native int native_processByteBuffer(int i_renamed, java.nio.ByteBuffer[] byteBufferArr, int i2);

    private native int native_pushSensorDataIn(int i_renamed, float[] fArr, long j_renamed);

    private native void native_register_callback(com.arcsoft.camera.wideselfie.WideSelfieCallback wideSelfieCallback);

    private native int native_stopProcessing();

    private native int native_uninit();

    private native com.arcsoft.camera.wideselfie.WideSelfieEngine.AwsVersionInfo native_version();

    static {
        java.lang.System.loadLibrary("arcsoft_wideselfie");
    }

    private void loadJNILib(java.lang.String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            java.lang.System.loadLibrary(com.arcsoft.camera.wideselfie.ArcWideSelfieDef.DEFAUT_JNI_LIB_NAME);
        } else {
            java.lang.System.loadLibrary(str);
        }
    }

    private WideSelfieEngine(java.lang.String str) {
        loadJNILib(str);
    }

    public static synchronized com.arcsoft.camera.wideselfie.WideSelfieEngine singleInstance() {
        return singleInstance(null);
    }

    public static synchronized com.arcsoft.camera.wideselfie.WideSelfieEngine singleInstance(java.lang.String str) {
        if (mInstance == null) {
            mInstance = new com.arcsoft.camera.wideselfie.WideSelfieEngine(str);
        }
        return mInstance;
    }

    public synchronized int init(com.arcsoft.camera.wideselfie.AwsInitParameter awsInitParameter) throws java.lang.Throwable {
        try {
            if (this.mIsInit) {
                return 0;
            }
            if (awsInitParameter == null) {
                return 2;
            }
            this.mInitParamter = awsInitParameter;
            com.arcsoft.camera.wideselfie.WideSelfieEngine.AwsVersionInfo awsVersionInfoNative_version = native_version();
            android.util.Log.d_renamed("Arcsoft", " ARC_AWS_GetVersion lCodebase = " + awsVersionInfoNative_version.codeBase + ", lMajor = " + awsVersionInfoNative_version.major + ", lMinor = " + awsVersionInfoNative_version.minor + ", lBuild = " + awsVersionInfoNative_version.build + ", CopyRight = " + awsVersionInfoNative_version.copyRight + ", Version = " + awsVersionInfoNative_version.version + ", BuildDate = " + awsVersionInfoNative_version.buildDate);
            try {
                int iNative_init = native_init(this.mInitParamter.getBufferSize(), this.mInitParamter.mode, this.mInitParamter.cameraViewAngleForWidth, this.mInitParamter.cameraViewAngleForHeight, this.mInitParamter.resultAngleForWidth, this.mInitParamter.resultAngleForHeight, this.mInitParamter.getSrcFormat(), this.mInitParamter.getFullImageWidth(), this.mInitParamter.getFullImageHeight(), this.mInitParamter.getThumbForamt(), this.mInitParamter.getThumbnailWidth(), this.mInitParamter.getThumbnailHeight(), this.mInitParamter.maxResultWidth, this.mInitParamter.progressBarThumbHeight, this.mInitParamter.guideStopBarThumbHeight, this.mInitParamter.guideStableBarThumbHeight, this.mInitParamter.progressBarThumbHeightCropRatio, this.mInitParamter.changeDirectionThumbThreshold, this.mInitParamter.getDeviceOrientation(), this.mInitParamter.convertNV21, this.mInitParamter.flipResultImage, this.mInitParamter.rotateResultImage);
                if (iNative_init != 0) {
                    return iNative_init;
                }
                try {
                    this.mIsInit = true;
                    return iNative_init;
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    private com.arcsoft.camera.wideselfie.WideSelfieEngine.AwsVersionInfo version() {
        return native_version();
    }

    public synchronized int process(int i_renamed, byte[] bArr) {
        if (bArr == null) {
            return 2;
        }
        return native_process(i_renamed, bArr);
    }

    public synchronized int processByteBuffer(int i_renamed, java.nio.ByteBuffer[] byteBufferArr, int i2) {
        if (!this.mIsInit) {
            return 0;
        }
        return native_processByteBuffer(i_renamed, byteBufferArr, i2);
    }

    public synchronized int stopProcessing() {
        if (!this.mIsInit) {
            return 0;
        }
        return native_stopProcessing();
    }

    public synchronized int pushSensorDataIn(int i_renamed, float[] fArr, long j_renamed) {
        return native_pushSensorDataIn(i_renamed, fArr, j_renamed);
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

    public synchronized void setOnCallback(com.arcsoft.camera.wideselfie.WideSelfieCallback wideSelfieCallback) {
        this.mCallback = wideSelfieCallback;
        if (this.mCallback != null) {
            native_register_callback(this.mCallback);
        }
    }

    private com.arcsoft.camera.wideselfie.WideSelfieCallback getCallback() {
        return this.mCallback;
    }

    private static final class AwsVersionInfo {
        int build;
        java.lang.String buildDate;
        int codeBase;
        java.lang.String copyRight;
        int major;
        int minor;
        java.lang.String version;

        private AwsVersionInfo() {
        }
    }
}
