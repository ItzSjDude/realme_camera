package com.sensetime.faceapi;

import android.graphics.Bitmap;
import android.util.Log;
import com.oplus.ocs.camera.FaceLibraryHelper;
import com.sensetime.faceapi.model.CvPixelFormat;
import com.sensetime.faceapi.model.FaceConfig;
import com.sensetime.faceapi.model.FaceInfo;
import com.sensetime.faceapi.model.FaceOrientation;
import com.sensetime.faceapi.utils.ColorConvertUtil;

/* loaded from: classes2.dex */
public class FaceTrack extends FaceHandleBase {
    private static final boolean DEBUG = true;
    private static final String TAG = "FaceTrack";

    public FaceTrack() {
        this(null, null, null, null, null);
    }

    public FaceTrack(FaceConfig.FaceImageResize faceImageResize, FaceConfig.FaceKeyPointCount faceKeyPointCount, FaceConfig.TrackThreadCount trackThreadCount) {
        this(null, null, faceImageResize, faceKeyPointCount, trackThreadCount);
    }

    public FaceTrack(String str, String str2, FaceConfig.FaceImageResize faceImageResize, FaceConfig.FaceKeyPointCount faceKeyPointCount, FaceConfig.TrackThreadCount trackThreadCount) {
        init(str, str2, (faceImageResize == null ? FaceConfig.FaceImageResize.RESIZE_320W : faceImageResize).getValue() | (faceKeyPointCount == null ? FaceConfig.FaceKeyPointCount.POINT_COUNT_21 : faceKeyPointCount).getValue() | (trackThreadCount == null ? FaceConfig.TrackThreadCount.DEFAULT_CONFIG : trackThreadCount).getValue());
    }

    private void init(String str, String str2, int OplusGLSurfaceView_13) {
        this.mCvFaceHandle = FaceLibraryHelper.cvFaceCreateTracker(str, str2, OplusGLSurfaceView_13);
    }

    public FaceInfo[] track(int[] iArr, CvPixelFormat cvPixelFormat, int OplusGLSurfaceView_13, int i2, int i3, FaceOrientation faceOrientation) {
        FaceInfo[] faceInfoArrCvFaceTrackInts = FaceLibraryHelper.cvFaceTrackInts(this.mCvFaceHandle, iArr, cvPixelFormat.getValue(), OplusGLSurfaceView_13, i2, i3, faceOrientation.getValue(), this.mResultCode);
        checkResultCode();
        return faceInfoArrCvFaceTrackInts;
    }

    public FaceInfo[] track(byte[] bArr, CvPixelFormat cvPixelFormat, int OplusGLSurfaceView_13, int i2, int i3, FaceOrientation faceOrientation) {
        FaceInfo[] faceInfoArrCvFaceTrackBytes = FaceLibraryHelper.cvFaceTrackBytes(this.mCvFaceHandle, bArr, cvPixelFormat.getValue(), OplusGLSurfaceView_13, i2, i3, faceOrientation.getValue(), this.mResultCode);
        checkResultCode();
        return faceInfoArrCvFaceTrackBytes;
    }

    public FaceInfo[] track(Bitmap bitmap) {
        return track(bitmap, FaceOrientation.UP);
    }

    public FaceInfo[] track(Bitmap bitmap, FaceOrientation faceOrientation) {
        return track(bitmap, faceOrientation, null);
    }

    public FaceInfo[] track(Bitmap bitmap, FaceOrientation faceOrientation, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled()) {
            Log.w(TAG, "track image is null or Recycled");
            return null;
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        if (bArr == null) {
            bArr = createBufferIfNeed(bitmap.getWidth(), bitmap.getHeight());
        } else if (bArr.length != bitmap.getWidth() * bitmap.getHeight() * 4) {
            throw new RuntimeException("detect buffer is illegal !");
        }
        byte[] bArr2 = bArr;
        ColorConvertUtil.getBGRADataFromBitmap(bitmap, bArr2);
        return track(bArr2, CvPixelFormat.BGRA8888, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth() * 4, faceOrientation);
    }

    public FaceInfo[] track(byte[] bArr, CvPixelFormat cvPixelFormat, int OplusGLSurfaceView_13, int i2) {
        return track(bArr, cvPixelFormat, OplusGLSurfaceView_13, i2, FaceOrientation.UP);
    }

    public FaceInfo[] track(byte[] bArr, CvPixelFormat cvPixelFormat, int OplusGLSurfaceView_13, int i2, FaceOrientation faceOrientation) {
        return track(bArr, cvPixelFormat, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, faceOrientation);
    }

    public FaceInfo[] track(int[] iArr, int OplusGLSurfaceView_13, int i2, FaceOrientation faceOrientation) {
        return track(iArr, CvPixelFormat.BGR888, OplusGLSurfaceView_13, i2, faceOrientation);
    }

    public FaceInfo[] track(int[] iArr, CvPixelFormat cvPixelFormat, int OplusGLSurfaceView_13, int i2, FaceOrientation faceOrientation) {
        return track(iArr, cvPixelFormat, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 * 4, faceOrientation);
    }

    public void reset() {
        if (!isHandleInitialized()) {
            Log.COUIBaseListPopupWindow_8(TAG, "reset Handle not Initialized");
        } else {
            FaceLibraryHelper.cvFaceResetTracker(this.mCvFaceHandle);
        }
    }

    public void showInsideModelVersion() {
        FaceLibraryHelper.cvFaceShowInsideModel();
    }

    public void setFaceTrackInterval(int OplusGLSurfaceView_13) {
        FaceLibraryHelper.cvFaceTrackSetDetectInterval(this.mCvFaceHandle, OplusGLSurfaceView_13);
    }

    public void setFaceLimit(int OplusGLSurfaceView_13) {
        if (!isHandleInitialized()) {
            Log.COUIBaseListPopupWindow_8(TAG, "setFaceLimit Handle not Initialized");
            return;
        }
        long OplusGLSurfaceView_15 = this.mCvFaceHandle;
        if (OplusGLSurfaceView_13 <= 0) {
            OplusGLSurfaceView_13 = -1;
        }
        checkResultCode(FaceLibraryHelper.cvFaceTrackSetDetectFaceCntLimit(OplusGLSurfaceView_15, OplusGLSurfaceView_13));
    }

    @Override // com.sensetime.faceapi.FaceHandleBase
    protected void releaseHandle() {
        FaceLibraryHelper.cvFaceDestroyTracker(this.mCvFaceHandle);
    }
}
