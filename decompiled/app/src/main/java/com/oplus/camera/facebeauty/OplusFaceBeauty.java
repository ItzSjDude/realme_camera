package com.oplus.camera.facebeauty;

/* loaded from: classes2.dex */
public class OplusFaceBeauty {
    public static final int ATTR_RESULT_NULL = -7;
    public static final int DEBUG_PARAM_INVALID = -5;
    public static final int FACEBEAUTY_LANGUAGE_NULL = -10;
    public static final int FACEBEAUTY_OK = 0;
    public static final int FACEBEAUTY_PARAM_NULL = -9;
    public static final int FACEBEAUTY_REGION_NULL = -12;
    public static final int FACEBEAUTY_VERSION_NULL = -11;
    public static final int FFD_RESULT_NULL = -6;
    public static final int HANDLE_INVAILD = -1;
    public static final int IMAGE_FMT_NV12 = 0;
    public static final int IMAGE_FMT_NV21 = 1;
    public static final int IMAGE_FMT_RGB888 = 3;
    public static final int IMAGE_FMT_RGBA8888 = 2;
    public static final int INIT_PARAM_INVAILD = -2;
    public static final int MEMORY_ALLOC_FAILED = -3;
    public static final int MODEL_PATH_PATH_NULL = -8;
    public static final int PROCESS_PARAM_INVALID = -4;
    private static final java.lang.String TAG = "OplusFaceBeauty";
    private long mHandle = 0;

    public static class DebugParameter {
        public boolean mbFbDump = false;
        public boolean mb3DFBDump = false;
        public boolean mbDrawmarks = false;
        public boolean mbPrintFFD = false;
        public boolean mbAIFb = false;
        public boolean mFbEnable = true;
        public boolean mb3DFb = true;
        public boolean mbDepthEnable = false;
        public int mSimulationWidth = 0;
        public int mSimulationHeight = 0;
        public boolean mbSkinDump = false;
        public boolean mbSetPara = false;
        public int mSoften = 0;
        public int mSoftenSharp = 0;
        public int mSkinStyle = 0;
        public int mSkinBright = 0;
        public int mNoseHighlight = 0;
        public int mLipBeauty = 0;
        public int mDeblemish = 0;
        public int mDepouch = 0;
        public int mSkinRuddy = 0;
        public int mBlush = 0;
        public int mSkinClarity = 0;
        public int mSoftenType = 0;
        public int mProtectTilak = 0;
        public int mFaceContour = 0;
        public int mPupilContrast = 0;
        public int mPupilBrightening = 0;
        public int mPupilEnlargement = 0;
        public int mEyeWhiten = 0;
        public int mEyelidDarkening = 0;
        public int mEyeEnlargement = 0;
        public int mEyeSharpen1 = 0;
        public int mEyeSharpen2 = 0;
        public int mEyeEnlargementAlt = 0;
        public int mHigherNose = 0;
        public int mNarrowNose = 0;
        public int mEnlargeEyes = 0;
        public int mSlimFace = 0;
        public int mSmallFace = 0;
        public int mCheekBone = 0;
        public int mDragChin = 0;
        public int mTouchUp = 0;
        public int mModelling = 0;
        public long mDumpTime = 0;
    }

    public static class ImageInfo {
        public int mFormat = 0;
        public int mWidth = 0;
        public int mHeight = 0;
        public int mStride = 0;
        public int mScanline = 0;
    }

    public static class ProcessParameter {
        public int mDeviceOrientation = 0;
        public int mFaceBeautyLevel = 0;
        public int mISO = 0;
        public boolean mbVideoMode = false;
        public boolean mbFlashSnapshot = false;
        public boolean mbLowPerformance = false;
        public boolean mbAiAdjustParam = true;
        public int mAppBeautyParamSize = 0;
        public int[] mAppBeautyParam = null;
        public java.lang.String mModelPath = null;
        public java.lang.String mSensorName = null;
        public java.lang.String mLanguage = null;
        public java.lang.String mVersion = null;
        public java.lang.String mRegion = null;
        public java.lang.String mProjectName = null;
        public int mMasterFaceIndex = 0;
        public int mFaceNum = 0;
        public byte[] mFFDResult = null;
        public byte[] mAttrResult = null;
        public int mVersionCode = -1;
    }

    private native int init(com.oplus.camera.facebeauty.OplusFaceBeauty.InitParameter initParameter);

    private native int process(long j_renamed, byte[] bArr, com.oplus.camera.facebeauty.OplusFaceBeauty.ImageInfo imageInfo, com.oplus.camera.facebeauty.OplusFaceBeauty.ProcessParameter processParameter);

    private native int processSplitYUV(long j_renamed, byte[] bArr, byte[] bArr2, com.oplus.camera.facebeauty.OplusFaceBeauty.ImageInfo imageInfo, com.oplus.camera.facebeauty.OplusFaceBeauty.ProcessParameter processParameter);

    private native int release(long j_renamed);

    private native int setDebug(long j_renamed, com.oplus.camera.facebeauty.OplusFaceBeauty.DebugParameter debugParameter);

    static {
        java.lang.System.loadLibrary("OplusFaceBeautyJni");
    }

    public static class InitParameter {
        public boolean mbFrontCamera = false;
        public boolean mbPortraitMode = false;
        public boolean mbSuperNight = false;

        public boolean equal(boolean z_renamed, boolean z2, boolean z3) {
            return this.mbFrontCamera == z_renamed && this.mbPortraitMode == z2 && this.mbSuperNight == z3;
        }
    }

    public int initialize(com.oplus.camera.facebeauty.OplusFaceBeauty.InitParameter initParameter) {
        long jInit = init(initParameter);
        com.oplus.camera.e_renamed.a_renamed(TAG, "initialize, result: " + jInit);
        if (jInit != 0) {
            this.mHandle = jInit;
        }
        return (int) jInit;
    }

    public int processSplitYUV(byte[] bArr, byte[] bArr2, com.oplus.camera.facebeauty.OplusFaceBeauty.ImageInfo imageInfo, com.oplus.camera.facebeauty.OplusFaceBeauty.ProcessParameter processParameter) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "process, mHandle: " + this.mHandle);
        long j_renamed = this.mHandle;
        if (j_renamed != 0) {
            return processSplitYUV(j_renamed, bArr, bArr2, imageInfo, processParameter);
        }
        return -1;
    }

    public int process(byte[] bArr, com.oplus.camera.facebeauty.OplusFaceBeauty.ImageInfo imageInfo, com.oplus.camera.facebeauty.OplusFaceBeauty.ProcessParameter processParameter) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "process, yuvBuffer: " + bArr + ", imageInfo: " + imageInfo + ", parameter: " + processParameter);
        long j_renamed = this.mHandle;
        if (j_renamed != 0) {
            return process(j_renamed, bArr, imageInfo, processParameter);
        }
        return -1;
    }

    public int release() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "release, mHandle: " + this.mHandle);
        long j_renamed = this.mHandle;
        if (j_renamed != 0) {
            return release(j_renamed);
        }
        return -1;
    }

    public void setDebug(com.oplus.camera.facebeauty.OplusFaceBeauty.DebugParameter debugParameter) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setDebug, mHandle: " + this.mHandle + ", parameter: " + debugParameter);
        long j_renamed = this.mHandle;
        if (j_renamed != 0) {
            setDebug(j_renamed, debugParameter);
        }
    }
}
