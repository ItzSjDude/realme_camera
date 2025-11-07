package com.sensetime.faceapi;

/* loaded from: classes2.dex */
public class FigureSegment extends com.sensetime.faceapi.FaceHandleBase {
    public static final int CV_COMMON_SEGMENT_DEFLICKER = 16;
    public static final int CV_COMMON_SEGMENT_NV21MODEL = 8;
    public static final int CV_FACE_SEGMENT_ANTI_SHAKE = 2;
    public static final int CV_FACE_SEGMENT_REDUCE_HOLE = 4;
    public static final int CV_FACE_SEGMENT_RESET = 1;
    private static final boolean DEBUG = true;
    private static final java.lang.String TAG = "FaceSegment";
    private static com.sensetime.faceapi.FigureSegment mInstance;
    private final java.lang.Object mSyncObject = new java.lang.Object();

    private FigureSegment() {
    }

    public static com.sensetime.faceapi.FigureSegment getInstance(java.lang.String str, com.sensetime.faceapi.model.FaceConfig.FaceImageResize faceImageResize) {
        if (mInstance == null) {
            synchronized (com.sensetime.faceapi.FigureSegment.class) {
                if (mInstance == null) {
                    mInstance = new com.sensetime.faceapi.FigureSegment();
                }
            }
        }
        mInstance.initHandle(str, faceImageResize);
        return mInstance;
    }

    public void initHandle(java.lang.String str, com.sensetime.faceapi.model.FaceConfig.FaceImageResize faceImageResize) {
        synchronized (this.mSyncObject) {
            if (this.mCvFaceHandle == 0) {
                this.mCvFaceHandle = com.oplus.ocs.camera.FaceLibraryHelper.cvFaceCreateFigureSeg(str, faceImageResize.getValue());
                android.util.Log.e_renamed(TAG, "cvFaceCreateFigureSeg handle: " + this.mCvFaceHandle);
            }
        }
    }

    public int createOutputBuffer(int i_renamed, int i2, int i3, int[] iArr) {
        return com.oplus.ocs.camera.FaceLibraryHelper.cvFaceFigureSegSetOuputLength(this.mCvFaceHandle, i_renamed, i2, i3, iArr);
    }

    public int segment(byte[] bArr, com.sensetime.faceapi.model.CvPixelFormat cvPixelFormat, int i_renamed, int i2, int i3, com.sensetime.faceapi.model.FaceOrientation faceOrientation, byte[] bArr2) {
        return segment(bArr, cvPixelFormat, i_renamed, i2, i3, faceOrientation, bArr2, 0);
    }

    public int segment(byte[] bArr, com.sensetime.faceapi.model.CvPixelFormat cvPixelFormat, int i_renamed, int i2, int i3, com.sensetime.faceapi.model.FaceOrientation faceOrientation, byte[] bArr2, int i4) {
        int iCvFaceFigureSeg;
        android.util.Log.e_renamed(TAG, "segment width: " + i_renamed + " height: " + i2 + " stride: " + i3 + " orientation: " + faceOrientation.getValue());
        synchronized (this.mSyncObject) {
            iCvFaceFigureSeg = com.oplus.ocs.camera.FaceLibraryHelper.cvFaceFigureSeg(this.mCvFaceHandle, bArr, cvPixelFormat.getValue(), i_renamed, i2, i3, faceOrientation.getValue(), bArr2, i4);
        }
        return iCvFaceFigureSeg;
    }

    @Override // com.sensetime.faceapi.FaceHandleBase
    protected void releaseHandle() {
        android.util.Log.e_renamed(TAG, "releaseHandle handle : " + this.mCvFaceHandle);
        synchronized (this.mSyncObject) {
            com.oplus.ocs.camera.FaceLibraryHelper.cvFaceDestroyFigureSeg(this.mCvFaceHandle);
            this.mCvFaceHandle = 0L;
        }
    }
}
