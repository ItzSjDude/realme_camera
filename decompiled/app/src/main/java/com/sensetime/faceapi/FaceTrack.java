package com.sensetime.faceapi;

/* loaded from: classes2.dex */
public class FaceTrack extends com.sensetime.faceapi.FaceHandleBase {
    private static final boolean DEBUG = true;
    private static final java.lang.String TAG = "FaceTrack";

    public FaceTrack() {
        this(null, null, null, null, null);
    }

    public FaceTrack(com.sensetime.faceapi.model.FaceConfig.FaceImageResize faceImageResize, com.sensetime.faceapi.model.FaceConfig.FaceKeyPointCount faceKeyPointCount, com.sensetime.faceapi.model.FaceConfig.TrackThreadCount trackThreadCount) {
        this(null, null, faceImageResize, faceKeyPointCount, trackThreadCount);
    }

    public FaceTrack(java.lang.String str, java.lang.String str2, com.sensetime.faceapi.model.FaceConfig.FaceImageResize faceImageResize, com.sensetime.faceapi.model.FaceConfig.FaceKeyPointCount faceKeyPointCount, com.sensetime.faceapi.model.FaceConfig.TrackThreadCount trackThreadCount) {
        init(str, str2, (faceImageResize == null ? com.sensetime.faceapi.model.FaceConfig.FaceImageResize.RESIZE_320W : faceImageResize).getValue() | (faceKeyPointCount == null ? com.sensetime.faceapi.model.FaceConfig.FaceKeyPointCount.POINT_COUNT_21 : faceKeyPointCount).getValue() | (trackThreadCount == null ? com.sensetime.faceapi.model.FaceConfig.TrackThreadCount.DEFAULT_CONFIG : trackThreadCount).getValue());
    }

    private void init(java.lang.String str, java.lang.String str2, int i_renamed) {
        this.mCvFaceHandle = com.oplus.ocs.camera.FaceLibraryHelper.cvFaceCreateTracker(str, str2, i_renamed);
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(int[] iArr, com.sensetime.faceapi.model.CvPixelFormat cvPixelFormat, int i_renamed, int i2, int i3, com.sensetime.faceapi.model.FaceOrientation faceOrientation) {
        com.sensetime.faceapi.model.FaceInfo[] faceInfoArrCvFaceTrackInts = com.oplus.ocs.camera.FaceLibraryHelper.cvFaceTrackInts(this.mCvFaceHandle, iArr, cvPixelFormat.getValue(), i_renamed, i2, i3, faceOrientation.getValue(), this.mResultCode);
        checkResultCode();
        return faceInfoArrCvFaceTrackInts;
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(byte[] bArr, com.sensetime.faceapi.model.CvPixelFormat cvPixelFormat, int i_renamed, int i2, int i3, com.sensetime.faceapi.model.FaceOrientation faceOrientation) {
        com.sensetime.faceapi.model.FaceInfo[] faceInfoArrCvFaceTrackBytes = com.oplus.ocs.camera.FaceLibraryHelper.cvFaceTrackBytes(this.mCvFaceHandle, bArr, cvPixelFormat.getValue(), i_renamed, i2, i3, faceOrientation.getValue(), this.mResultCode);
        checkResultCode();
        return faceInfoArrCvFaceTrackBytes;
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(android.graphics.Bitmap bitmap) {
        return track(bitmap, com.sensetime.faceapi.model.FaceOrientation.UP);
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(android.graphics.Bitmap bitmap, com.sensetime.faceapi.model.FaceOrientation faceOrientation) {
        return track(bitmap, faceOrientation, null);
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(android.graphics.Bitmap bitmap, com.sensetime.faceapi.model.FaceOrientation faceOrientation, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled()) {
            android.util.Log.w_renamed(TAG, "track image is_renamed null or Recycled");
            return null;
        }
        if (bitmap.getConfig() != android.graphics.Bitmap.Config.ARGB_8888) {
            bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
        }
        if (bArr == null) {
            bArr = createBufferIfNeed(bitmap.getWidth(), bitmap.getHeight());
        } else if (bArr.length != bitmap.getWidth() * bitmap.getHeight() * 4) {
            throw new java.lang.RuntimeException("detect buffer is_renamed illegal !");
        }
        byte[] bArr2 = bArr;
        com.sensetime.faceapi.utils.ColorConvertUtil.getBGRADataFromBitmap(bitmap, bArr2);
        return track(bArr2, com.sensetime.faceapi.model.CvPixelFormat.BGRA8888, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth() * 4, faceOrientation);
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(byte[] bArr, com.sensetime.faceapi.model.CvPixelFormat cvPixelFormat, int i_renamed, int i2) {
        return track(bArr, cvPixelFormat, i_renamed, i2, com.sensetime.faceapi.model.FaceOrientation.UP);
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(byte[] bArr, com.sensetime.faceapi.model.CvPixelFormat cvPixelFormat, int i_renamed, int i2, com.sensetime.faceapi.model.FaceOrientation faceOrientation) {
        return track(bArr, cvPixelFormat, i_renamed, i2, i_renamed, faceOrientation);
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(int[] iArr, int i_renamed, int i2, com.sensetime.faceapi.model.FaceOrientation faceOrientation) {
        return track(iArr, com.sensetime.faceapi.model.CvPixelFormat.BGR888, i_renamed, i2, faceOrientation);
    }

    public com.sensetime.faceapi.model.FaceInfo[] track(int[] iArr, com.sensetime.faceapi.model.CvPixelFormat cvPixelFormat, int i_renamed, int i2, com.sensetime.faceapi.model.FaceOrientation faceOrientation) {
        return track(iArr, cvPixelFormat, i_renamed, i2, i_renamed * 4, faceOrientation);
    }

    public void reset() {
        if (!isHandleInitialized()) {
            android.util.Log.e_renamed(TAG, "reset Handle not Initialized");
        } else {
            com.oplus.ocs.camera.FaceLibraryHelper.cvFaceResetTracker(this.mCvFaceHandle);
        }
    }

    public void showInsideModelVersion() {
        com.oplus.ocs.camera.FaceLibraryHelper.cvFaceShowInsideModel();
    }

    public void setFaceTrackInterval(int i_renamed) {
        com.oplus.ocs.camera.FaceLibraryHelper.cvFaceTrackSetDetectInterval(this.mCvFaceHandle, i_renamed);
    }

    public void setFaceLimit(int i_renamed) {
        if (!isHandleInitialized()) {
            android.util.Log.e_renamed(TAG, "setFaceLimit Handle not Initialized");
            return;
        }
        long j_renamed = this.mCvFaceHandle;
        if (i_renamed <= 0) {
            i_renamed = -1;
        }
        checkResultCode(com.oplus.ocs.camera.FaceLibraryHelper.cvFaceTrackSetDetectFaceCntLimit(j_renamed, i_renamed));
    }

    @Override // com.sensetime.faceapi.FaceHandleBase
    protected void releaseHandle() {
        com.oplus.ocs.camera.FaceLibraryHelper.cvFaceDestroyTracker(this.mCvFaceHandle);
    }
}
