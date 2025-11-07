package com.oplus.camera.aps.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.OplusWhiteListManager;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.camera2.CaptureRequest;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.util.CameraApsExifData;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p154m.ImageSaverThread;
import com.oplus.camera.perf.ComprehensivePerformance;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.PerformanceMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.BuildConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class ApsService extends Service {
    private static final String BURST_SHOT_TEMP_DIRECTORY_FLAG = ".cshot";
    private static final long SELF_PROTECT_ADD_TIME = 600000;
    private static final String TAG = "ApsService";
    private static final int WAIT_THUMBNAIL_UPDATE_TIME_LIMIT = 6000;
    private final IBinder mBinder = new LocalBinder();
    private final Object mOplusWhiteListLock = new Object();
    private final Object mThumbnailMapLock = new Object();
    private final Object mBurstShotTempDirectoryLock = new Object();
    private OplusWhiteListManager mOplusWhiteListManager = null;
    private ConcurrentHashMap<Long, ThumbnailCategory> mThumbnailMap = new ConcurrentHashMap<>();
    private long mLatestThumbnailIdentity = 0;
    private ConditionVariable mThumbnailUpdateSig = new ConditionVariable();
    private boolean mbCapturing = false;
    private OneCamera.PlatformImplementations.kt_3 mCaptureCallback = null;
    private OneCamera.COUIBaseListPopupWindow_8 mStateObserver = null;
    private CaptureRequestParam mCaptureRequestParam = null;
    private CameraPictureCallback mCameraPictureListener = null;
    private CaptureMsgData mCaptureMsgData = null;
    private boolean mbHeicCodecOpen = false;
    private boolean mbHighPictureSize = false;
    private long mLastProcessTimeStamp = 0;
    private CameraPictureCallback.CameraPictureResult mCameraPictureResult = null;
    private long mMaxBurstShotIdentity = 0;
    private CameraPictureCallback.CameraPictureResult mBurstShotPictureResult = null;
    private CameraPictureCallback mCameraPictureCallback = new CameraPictureCallback() { // from class: com.oplus.camera.aps.service.ApsService.1
        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureShutter(long OplusGLSurfaceView_15) {
            super.onCaptureShutter(OplusGLSurfaceView_15);
            if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onCaptureStarted(null, null, OplusGLSurfaceView_15, 0L);
                CameraLog.m12959b(ApsService.TAG, "onCaptureShutter");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCapturePrepared() {
            if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onCapturePrepared();
                CameraLog.m12959b(ApsService.TAG, "onCapturePrepared");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onPictureCaptureProgressed(CaptureRequest captureRequest, CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onPictureCaptureProgressed(captureRequest, cameraPictureResult);
            if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onCaptureProgressed(captureRequest, new CameraCaptureResult(cameraPictureResult.getCaptureResult()), (CameraRequestTag) cameraPictureResult.get(CameraParameter.RESULT_REQUEST_TAG));
                CameraLog.m12959b(ApsService.TAG, "onPictureCaptureProgressed");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureFailed(CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onCaptureFailed(cameraPictureResult);
            CameraLog.m12967f(ApsService.TAG, "onCaptureFailed");
            Integer num = cameraPictureResult != null ? (Integer) cameraPictureResult.get(CameraParameter.CAPTURE_FAIL_CODE) : num;
            num = num != null ? num : 0;
            ApsService.this.mbCapturing = false;
            CameraLog.m12955a("captureX onCaptureFailed failCode: " + num, "22ct_CaptureFailed", CameraConstant.f13119d.longValue());
            if (num.intValue() > 0 || cameraPictureResult == null || cameraPictureResult.getCaptureFailure() == null) {
                if (ApsService.this.mCameraPictureListener != null) {
                    ApsService.this.mCameraPictureListener.onCaptureFailed(cameraPictureResult);
                    ApsService.this.mCaptureRequestParam.mApsServiceListener.m10937a(0, 0, false, 256);
                }
            } else if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onCaptureFailed(cameraPictureResult.getCaptureFailure().getRequest(), (CameraRequestTag) cameraPictureResult.get(CameraParameter.RESULT_REQUEST_TAG));
            }
            CameraLog.m12964d("captureX onCaptureFailed failCode: " + num, "22ct_CaptureFailed");
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onCaptureFirstFrameArrived(captureRequest, cameraPictureResult);
            CameraCaptureResult cameraCaptureResult = new CameraCaptureResult(cameraPictureResult.getCaptureResult());
            Long OplusGLSurfaceView_14 = (Long) cameraPictureResult.get(CameraParameter.CAPTURE_RESULT_NIGHT_TOTAL_EXPTIME);
            Long l2 = (Long) cameraPictureResult.get(CameraParameter.CAPTURE_RESULT_FIRST_EXPOSURE_TIME);
            Object obj = cameraPictureResult.get(CameraParameter.RESULT_REQUEST_TAG);
            CameraLog.m12959b(ApsService.TAG, "onCaptureFirstFrameArrived, nightTotalTime: " + OplusGLSurfaceView_14 + ", firstExposureTime: " + l2);
            if (OplusGLSurfaceView_14 != null) {
                cameraCaptureResult.mNightCaptureTotaltime = OplusGLSurfaceView_14.longValue();
            }
            if (l2 != null) {
                cameraCaptureResult.mFirstExposureTime = l2.longValue();
            }
            if (obj != null) {
                cameraCaptureResult.setRequestTag((CameraRequestTag) obj);
            }
            if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureMetaReceived(CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onCaptureMetaReceived(cameraPictureResult);
            ApsService.this.mCameraPictureResult = cameraPictureResult;
            CameraRequestTag c2693c = (CameraRequestTag) ApsService.this.mCameraPictureResult.get(CameraParameter.RESULT_REQUEST_TAG);
            CameraCaptureResult cameraCaptureResult = new CameraCaptureResult(cameraPictureResult.getCaptureResult());
            Long OplusGLSurfaceView_14 = (Long) ApsService.this.mCameraPictureResult.get(CameraParameter.PICTURE_IDENTITY);
            CameraLog.m12959b(ApsService.TAG, "onCaptureMetaReceived, pictureIdentity: " + OplusGLSurfaceView_14);
            CameraLog.m12955a("captureX onCaptureMetaReceived", "24ct_CaptureMetaReceived", CameraConstant.f13119d.longValue());
            if (OplusGLSurfaceView_14 != null) {
                cameraCaptureResult.mIdentity = OplusGLSurfaceView_14.longValue();
            }
            ComprehensivePerformance.m15116a((HashMap<String, Long>) cameraPictureResult.get(CameraParameter.APS_PROC_TIMER), System.currentTimeMillis(), OplusGLSurfaceView_14);
            cameraCaptureResult.mMeshPtr = ((Long) ApsService.this.mCameraPictureResult.get(CameraParameter.MESH_PTR)).longValue();
            if (ApsService.this.mStateObserver != null) {
                ApsService.this.mStateObserver.mo10952a(cameraPictureResult.getCaptureResult(), c2693c);
            }
            if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onCaptureCompleted(cameraCaptureResult, c2693c);
            }
            CameraLog.m12964d("captureX onCaptureMetaReceived", "24ct_CaptureMetaReceived");
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
            super.onImageReceived(cameraPictureImage);
            ApsService.this.mbCapturing = false;
            if (cameraPictureImage == null) {
                CameraLog.m12967f(ApsService.TAG, "onImageReceived, image is null, return");
                return;
            }
            if (32 == cameraPictureImage.getFormat()) {
                ApsService.this.mCaptureRequestParam.mApsServiceListener.m10940b(cameraPictureImage);
                return;
            }
            if (ApsService.this.mCaptureRequestParam.mApsServiceListener.m10939a(cameraPictureImage)) {
                return;
            }
            CameraLog.m12955a("captureX onImageReceived size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "28ct_ImageReceived", CameraConstant.f13119d.longValue());
            if (ApsService.this.mCaptureRequestParam.mApsServiceListener.m10941c(cameraPictureImage)) {
                CameraLog.m12964d("captureX onImageReceived size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "28ct_ImageReceived");
                return;
            }
            CameraLog.m12964d("captureX onImageReceived size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "28ct_ImageReceived");
            long timestamp = cameraPictureImage.getTimestamp();
            ImageSaverThread.m14696a().m14713i();
            synchronized (ApsService.this.mThumbnailMapLock) {
                ThumbnailCategory thumbnailCategory = (ThumbnailCategory) ApsService.this.mThumbnailMap.get(Long.valueOf(timestamp));
                CameraLog.m12959b(ApsService.TAG, "onImageReceived, identity: " + timestamp + ", size: " + ApsService.this.mThumbnailMap.size());
                if (thumbnailCategory == null) {
                    return;
                }
                if (thumbnailCategory.isValid()) {
                    ApsService.this.savePicture(thumbnailCategory, cameraPictureImage);
                } else {
                    CameraPictureCallback.CameraPictureResult cameraPictureResult = thumbnailCategory.mPictureResult;
                    if (cameraPictureResult != null && ((Integer) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_REC_BURST_NUMBER)).intValue() > 1) {
                        CameraLog.m12959b(ApsService.TAG, "onImageReceived, the burst capture is already stopped, complete directly");
                        ApsService.this.pictureSaveEnd(timestamp, thumbnailCategory.mPictureResult);
                        ImageSaverThread.m14696a().m14715k();
                    } else {
                        thumbnailCategory.mCameraPictureImage = cameraPictureImage;
                    }
                }
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onBurstShotStart(long OplusGLSurfaceView_15) {
            CameraLog.m12952a("captureX onBurstShotStart burstShotFlagId: " + OplusGLSurfaceView_15);
            ApsService.this.createBurstShotFlagFile(OplusGLSurfaceView_15);
            CameraLog.m12958b("captureX onBurstShotStart burstShotFlagId: " + OplusGLSurfaceView_15);
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onBurstShotEnd(CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            CameraLog.m12952a("captureX onBurstShotEnd");
            ApsService.this.deleteBurstShotFlagFile(((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue());
            CameraLog.m12958b("captureX onBurstShotEnd");
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void afterProcessImage(int OplusGLSurfaceView_13, CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            CameraLog.m12954a(ApsService.TAG, "afterProcessImage, processResult: " + OplusGLSurfaceView_13 + ", pictureResult: " + cameraPictureResult + ", identity: " + cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY) + ", captureForVideo: " + cameraPictureResult.get(CameraParameter.RESULT_CAPTURE_FOR_VIDEO));
            if (((Boolean) cameraPictureResult.get(CameraParameter.RESULT_CAPTURE_FOR_VIDEO)).booleanValue()) {
                return;
            }
            CameraLog.m12955a("captureX afterProcessImage", "15ct_afterProcessImage", CameraConstant.f13119d.longValue());
            ApsService.this.mLastProcessTimeStamp = ((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue();
            ComprehensivePerformance.m15114a(ApsService.this.mLastProcessTimeStamp);
            synchronized (ApsService.this.mThumbnailMapLock) {
                if (OplusGLSurfaceView_13 == -1) {
                    ApsService.this.mThumbnailMap.remove(cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY));
                    ApsService.this.mLatestThumbnailIdentity = 0L;
                    CameraLog.m12964d("captureX afterProcessImage", "15ct_afterProcessImage");
                    return;
                }
                if (((Boolean) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) {
                    ApsService.this.mCaptureRequestParam.mBurstShotThumbnailCallBack.mo10597a(((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue(), ((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue(), null);
                }
                if (((Boolean) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_END_OF_CAPTURE)).booleanValue()) {
                    if (ApsService.this.mThumbnailMap != null) {
                        if (ApsService.this.mThumbnailMap.containsKey(cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY))) {
                            ThumbnailCategory thumbnailCategory = (ThumbnailCategory) ApsService.this.mThumbnailMap.get(cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY));
                            thumbnailCategory.mPictureResult = cameraPictureResult;
                            thumbnailCategory.mCaptureMsgData = ApsService.this.mCaptureMsgData;
                        } else {
                            ThumbnailCategory thumbnailCategory2 = new ThumbnailCategory();
                            thumbnailCategory2.mThumbnailItem = new ThumbnailItem();
                            thumbnailCategory2.mPictureResult = cameraPictureResult;
                            thumbnailCategory2.mCaptureMsgData = ApsService.this.mCaptureMsgData;
                            if (((Boolean) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) {
                                thumbnailCategory2.mThumbnailItem.mbBurstShot = true;
                            }
                            ApsService.this.mThumbnailMap.put((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY), thumbnailCategory2);
                        }
                    }
                    ImageSaverThread.m14696a().m14712h();
                }
                CameraLog.m12964d("captureX afterProcessImage", "15ct_afterProcessImage");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onPictureCaptureSequenceCompleted(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onCaptureSequenceCompleted();
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void fillApsParameters(int OplusGLSurfaceView_13, Map<String, String> map) throws IOException {
            PerformanceMsgData.startPointTime(CaptureMsgData.PROCESS_DURATION);
            ApsService.this.fillParameters(OplusGLSurfaceView_13, map);
            CameraLog.m12962c(ApsService.TAG, "fillApsParameters, type: " + OplusGLSurfaceView_13 + ", parameters: " + map);
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onFinishAddFrame(CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            ApsService.this.mCaptureRequestParam.mApsServiceListener.m10937a(((Integer) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_WIDTH)).intValue(), ((Integer) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_HEIGHT)).intValue(), ((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() != -1, ((Integer) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_FORMAT)).intValue());
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onFirstCaptureFrameAdd() {
            if (ApsService.this.mCaptureCallback != null) {
                ApsService.this.mCaptureCallback.onFirstCaptureFrameAdd();
            }
        }
    };

    private void handlePreviewFailed(long OplusGLSurfaceView_15) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePicture(ThumbnailCategory thumbnailCategory, CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        CameraLog.m12955a("captureX savePicture size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "32ct_savePicture", CameraConstant.f13119d.longValue());
        long timestamp = cameraPictureImage.getTimestamp();
        CameraPictureCallback.CameraPictureResult cameraPictureResult = thumbnailCategory.mPictureResult;
        ThumbnailItem thumbnailItem = thumbnailCategory.mThumbnailItem;
        final Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
        cameraPicture.f12128a = thumbnailItem.mResolver;
        cameraPicture.f12134g = thumbnailItem.mJpegName;
        cameraPicture.f12132e = cameraPictureImage.getImage();
        cameraPicture.f12130c = thumbnailItem.mUri;
        cameraPicture.f12142o = cameraPictureImage.getWidth();
        cameraPicture.f12143p = cameraPictureImage.getHeight();
        cameraPicture.f12145r = cameraPictureImage.getScanline();
        cameraPicture.f12144q = cameraPictureImage.getStride();
        cameraPicture.f12129b = new CameraApsExifData(this.mCameraPictureResult);
        cameraPicture.f12141n = cameraPictureResult != null ? ((Integer) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_REC_BURST_NUMBER)).intValue() : -1;
        cameraPicture.f12135h = cameraPictureImage.getFormat() == 256 ? CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG : thumbnailItem.mPictureFormat;
        cameraPicture.f12149v = true;
        cameraPicture.f12110H = thumbnailItem.mTimeStamp;
        cameraPicture.f12111I = cameraPictureImage.getTimestamp();
        cameraPicture.f12107E = thumbnailItem.mbLockScreen;
        cameraPicture.f12140m = cameraPictureResult != null ? ((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() : -1L;
        cameraPicture.f12138k = cameraPictureResult != null ? (String) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_CSHOT_PATH) : null;
        cameraPicture.f12120R = thumbnailItem.mbUltraHighResolution;
        cameraPicture.f12125W = ((Boolean) this.mCameraPictureResult.get(CameraParameter.HEIF_PROCESS_IN_APS)).booleanValue();
        cameraPicture.f12127Y = this.mCameraPictureResult.get(CameraParameter.RESULT_REQUEST_TAG) != null && ((CameraRequestTag) this.mCameraPictureResult.get(CameraParameter.RESULT_REQUEST_TAG)).f13399aa;
        if (thumbnailItem.mDate != 0) {
            cameraPicture.f12139l = thumbnailItem.mDate;
        } else {
            cameraPicture.f12139l = System.currentTimeMillis();
        }
        cameraPicture.f12147t = Util.m24369b(cameraPicture.f12132e);
        cameraPicture.f12116N = this.mCaptureRequestParam.mPictureTakenCallback;
        cameraPicture.f12122T = this.mCaptureRequestParam.mbSuperTextOpen;
        if (thumbnailItem.mIdentity == this.mLatestThumbnailIdentity) {
            cameraPicture.f12112J = true;
        }
        if (thumbnailItem.mCameraUiUpdateThumbnail != null) {
            cameraPicture.f12148u = this.mCaptureRequestParam.mThumbWidth;
            cameraPicture.f12152y = thumbnailItem.mCameraUiUpdateThumbnail;
        }
        if (thumbnailItem.mUri == null && ("heic_8bits".equalsIgnoreCase(cameraPicture.f12135h) || "heic_10bits".equalsIgnoreCase(cameraPicture.f12135h))) {
            cameraPicture.f12106D = true;
        }
        boolean zBooleanValue = ((Boolean) this.mCameraPictureResult.get(CameraParameter.HAS_SUPER_TEXT_RESULT)).booleanValue();
        final int iIntValue = ((Integer) this.mCameraPictureResult.get(CameraParameter.SUPER_TEXT_WIDTH)).intValue();
        final int iIntValue2 = ((Integer) this.mCameraPictureResult.get(CameraParameter.SUPER_TEXT_HEIGHT)).intValue();
        if (zBooleanValue && this.mCaptureRequestParam.mSuperTextResultProcessor != null) {
            cameraPicture.f12113K = this.mCaptureRequestParam.mSuperTextResultProcessor;
            cameraPicture.f12118P = true;
            cameraPicture.f12119Q = this.mCaptureRequestParam.mCaptureOrientation;
            Util.m24279a(new Runnable() { // from class: com.oplus.camera.aps.service.ApsService.2
                @Override // java.lang.Runnable
                public void run() {
                    int screenWidth;
                    int OplusGLSurfaceView_13 = iIntValue2;
                    int i2 = iIntValue;
                    float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 < i2 ? OplusGLSurfaceView_13 : i2;
                    if (Util.m24498u()) {
                        screenWidth = Util.m24194V();
                    } else {
                        screenWidth = Util.getScreenWidth();
                    }
                    float f2 = screenWidth / COUIBaseListPopupWindow_12;
                    CameraLog.m12959b(ApsService.TAG, "savePicture, scale: " + f2);
                    int i3 = ApsService.this.mCaptureRequestParam.mCaptureOrientation;
                    Bitmap bitmapM24372b = Util.m24372b(BitmapFactory.decodeByteArray(cameraPicture.f12132e, 0, cameraPicture.f12132e.length), f2);
                    if (!Util.m24498u()) {
                        bitmapM24372b = Util.m24373b(bitmapM24372b, (360 - i3) % 360);
                    }
                    Bitmap bitmap = bitmapM24372b;
                    if (cameraPicture.f12113K != null) {
                        synchronized (cameraPicture.f12113K) {
                            if (cameraPicture.f12103A != null) {
                                cameraPicture.f12113K.mo10410a(bitmap, cameraPicture.f12103A, cameraPicture.f12118P, cameraPicture.f12119Q, cameraPicture.f12122T, cameraPicture.f12127Y, cameraPicture.f12139l);
                            } else {
                                cameraPicture.f12114L = bitmap;
                            }
                        }
                    }
                }
            });
        }
        CameraLog.m12954a(TAG, "savePicture, picture: " + cameraPicture + ", thumbnailItem: " + thumbnailItem);
        if (thumbnailItem.mProductProcessor != null) {
            thumbnailItem.mProductProcessor.mo10408a(cameraPicture);
        } else {
            ImageSaverThread.m14696a().m14707c(cameraPicture);
        }
        if (!thumbnailItem.mbBurstShot && thumbnailCategory.mCaptureMsgData != null) {
            int iIntValue3 = ((Integer) this.mCameraPictureResult.get(CameraParameter.NOISE_REDUCTION_STRENGTH)).intValue();
            int OplusGLSurfaceView_13 = (iIntValue3 >> 4) & 15;
            thumbnailCategory.mCaptureMsgData.mMultiFrameNum = String.valueOf(OplusGLSurfaceView_13);
            thumbnailCategory.mCaptureMsgData.mLostFrameNum = String.valueOf(OplusGLSurfaceView_13 - (iIntValue3 & 15));
            this.mCaptureRequestParam.mApsServiceListener.m10938a(thumbnailCategory, cameraPicture);
            this.mCaptureMsgData = null;
        }
        pictureSaveEnd(timestamp, cameraPictureResult);
        CameraLog.m12964d("captureX savePicture size: " + cameraPictureImage.getWidth() + "x" + cameraPictureImage.getHeight(), "32ct_savePicture");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParameters(int OplusGLSurfaceView_13, Map<String, String> map) throws IOException {
        if (OplusGLSurfaceView_13 != 1) {
            return;
        }
        ThumbnailItem thumbnailItem = getThumbnailItem(Long.parseLong(map.get(CameraUnitKeys.KEY_PROCESS_IMAGE_IDENTITY)));
        ThumbnailItem thumbnailItem2 = null;
        if (thumbnailItem == null && this.mbHeicCodecOpen && !Boolean.parseBoolean(map.get(CameraUnitKeys.KEY_BURST_SHOT))) {
            CameraLog.m12967f(TAG, "fillApsParameters, get proper thumbnail null, wait.");
            thumbnailItem2 = getThumbnailItem(this.mLatestThumbnailIdentity);
            this.mThumbnailUpdateSig.close();
            this.mThumbnailUpdateSig.block(6000L);
            thumbnailItem = getThumbnailItem(Long.parseLong(map.get(CameraUnitKeys.KEY_PROCESS_IMAGE_IDENTITY)));
        }
        if (thumbnailItem == null) {
            CameraLog.m12967f(TAG, "fillApsParameters, use last thumbnailItem");
            thumbnailItem = thumbnailItem2;
        }
        if (thumbnailItem != null) {
            if ("heic_8bits".equalsIgnoreCase(thumbnailItem.mPictureFormat) || "heic_10bits".equalsIgnoreCase(thumbnailItem.mPictureFormat)) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONLY_HIGH_PICTURE_SIZE_HEIF_IN_APS) || this.mbHighPictureSize) {
                    map.put(CameraUnitKeys.KEY_HEIF_ENABLE, String.valueOf(1));
                    fillHeifFD(thumbnailItem, map);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pictureSaveEnd(long OplusGLSurfaceView_15, CameraPictureCallback.CameraPictureResult cameraPictureResult) {
        this.mThumbnailMap.remove(Long.valueOf(OplusGLSurfaceView_15));
        if ((cameraPictureResult != null && ((Boolean) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) && OplusGLSurfaceView_15 > this.mMaxBurstShotIdentity) {
            this.mMaxBurstShotIdentity = OplusGLSurfaceView_15;
            this.mBurstShotPictureResult = cameraPictureResult;
        }
        if (this.mThumbnailMap.size() == 0) {
            this.mLatestThumbnailIdentity = 0L;
            removeStageProtectInfo(getPackageName());
            CameraPictureCallback.CameraPictureResult cameraPictureResult2 = this.mBurstShotPictureResult;
            if (cameraPictureResult2 != null) {
                this.mCameraPictureCallback.onBurstShotEnd(cameraPictureResult2);
                this.mBurstShotPictureResult = null;
            }
        }
        CameraLog.m12959b(TAG, "pictureSaveEnd, remaining thumb info: " + this.mThumbnailMap);
    }

    public CameraPictureCallback getCameraPictureCallback() {
        return this.mCameraPictureCallback;
    }

    public void setCaptureCallback(OneCamera.PlatformImplementations.kt_3 aVar) {
        this.mCaptureCallback = aVar;
    }

    public void setCameraPictureListener(CameraPictureCallback cameraPictureCallback) {
        this.mCameraPictureListener = cameraPictureCallback;
    }

    public void setStateObserver(OneCamera.COUIBaseListPopupWindow_8 eVar) {
        this.mStateObserver = eVar;
    }

    public void setCaptureRequestParam(CaptureRequestParam captureRequestParam) {
        this.mCaptureRequestParam = captureRequestParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean createBurstShotFlagFile(long OplusGLSurfaceView_15) {
        boolean zMkdirs;
        File file;
        File file2;
        synchronized (this.mBurstShotTempDirectoryLock) {
            CameraLog.m12954a(TAG, "createBurstShotFlagFile, burstShotFlagId: " + OplusGLSurfaceView_15);
            zMkdirs = true;
            try {
                if (Storage.m11134c()) {
                    file = new File(Storage.m11109a());
                    file2 = new File(file.getAbsolutePath() + File.separator + OplusGLSurfaceView_15 + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                } else {
                    String strM11110a = Storage.m11110a(String.valueOf(OplusGLSurfaceView_15), "");
                    file = new File(strM11110a);
                    file2 = new File(strM11110a + File.separator + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                }
                if (!file.exists() || !file.isDirectory()) {
                    CameraLog.m12954a(TAG, "createBurstShotFlagFile, make directory");
                    zMkdirs = file.mkdirs();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                zMkdirs = false;
                CameraLog.m12967f(TAG, "createBurstShotFlagFile, Exception");
            }
            if (!file2.exists() || !file2.isFile()) {
                CameraLog.m12954a(TAG, "createBurstShotFlagFile, path: " + file2.getAbsolutePath());
                zMkdirs = file2.createNewFile();
            }
        }
        return zMkdirs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteBurstShotFlagFile(long OplusGLSurfaceView_15) {
        boolean z;
        File file;
        File file2;
        synchronized (this.mBurstShotTempDirectoryLock) {
            CameraLog.m12954a(TAG, "deleteBurstShotFlagFile, burstShotFlagId: " + OplusGLSurfaceView_15);
            z = false;
            try {
                if (Storage.m11134c()) {
                    file = new File(Storage.m11109a());
                    file2 = new File(file.getAbsolutePath() + File.separator + OplusGLSurfaceView_15 + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                } else {
                    String strM11110a = Storage.m11110a(String.valueOf(OplusGLSurfaceView_15), "");
                    file = new File(strM11110a);
                    file2 = new File(strM11110a + File.separator + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                }
                boolean z2 = true;
                if (file.exists() && file2.exists()) {
                    CameraLog.m12954a(TAG, "deleteBurstShotFlagFile, path: " + file2.getAbsolutePath());
                    boolean zDelete = file2.delete();
                    CameraLog.m12954a(TAG, "deleteBurstShotFlagFile, notify gallery start");
                    ContentResolver contentResolver = getContentResolver();
                    if (!"on".equals(Storage.f12095u) || !Storage.m11138d()) {
                        z2 = false;
                    }
                    contentResolver.notifyChange(Storage.m11130c(z2), null);
                    CameraLog.m12954a(TAG, "deleteBurstShotFlagFile, notify gallery end");
                    z = zDelete;
                } else {
                    z = true;
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                CameraLog.m12967f(TAG, "deleteBurstShotFlagFile, Exception");
            }
        }
        return z;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CameraLog.m12954a(TAG, "onBind, this: " + this);
        synchronized (this.mOplusWhiteListLock) {
            if (this.mOplusWhiteListManager == null) {
                this.mOplusWhiteListManager = new OplusWhiteListManager(this);
            }
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        CameraLog.m12959b(TAG, "onCreate");
        super.onCreate();
        startForeground();
    }

    @Override // android.app.Service
    public void onDestroy() {
        CameraLog.m12959b(TAG, "onDestroy");
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12959b(TAG, "onStartCommand");
        super.onStartCommand(intent, OplusGLSurfaceView_13, i2);
        startForeground();
        return 1;
    }

    private void startForeground() {
        if (Build.VERSION.SDK_INT > 26) {
            startForeground(1, new NotificationCompat.IntrinsicsJvm.kt_5(this, createNotificationChannel(BuildConfig.APPLICATION_ID, getString(R.string.camera_app_name))).m2407a(true).m2412c(-2).m2406a("service").m2408b());
        } else {
            startForeground(1, new Notification());
        }
    }

    private String createNotificationChannel(String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 0);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        return str;
    }

    private void addStageProtectInfo(String str) {
        synchronized (this.mOplusWhiteListLock) {
            if (this.mOplusWhiteListManager != null) {
                ArrayList stageProtectListFromPkg = this.mOplusWhiteListManager.getStageProtectListFromPkg(str, 0);
                StringBuilder sb = new StringBuilder("StageProtectList: ");
                Iterator it = stageProtectListFromPkg.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    sb.append("[");
                    sb.append(str2);
                    sb.append("] ");
                }
                CameraLog.m12959b(TAG, "addStageProtectInfo, nameBuilder: " + sb.toString());
                if (!stageProtectListFromPkg.contains(getPackageName())) {
                    this.mOplusWhiteListManager.addStageProtectInfo(str, SELF_PROTECT_ADD_TIME);
                }
            }
        }
    }

    private void removeStageProtectInfo(String str) {
        synchronized (this.mOplusWhiteListLock) {
            if (this.mOplusWhiteListManager != null) {
                CameraLog.m12959b(TAG, "removeStageProtectInfo, pkgName: " + str);
                this.mOplusWhiteListManager.removeStageProtectInfo(str);
            }
        }
    }

    public HashSet<String> getSloganPathsInUse() {
        HashSet<String> hashSet = new HashSet<>();
        synchronized (this.mThumbnailMapLock) {
            if (this.mThumbnailMap != null && this.mThumbnailMap.size() != 0) {
                Iterator<ThumbnailCategory> it = this.mThumbnailMap.values().iterator();
                while (it.hasNext()) {
                    CameraPictureCallback.CameraPictureResult cameraPictureResult = it.next().mPictureResult;
                    if (cameraPictureResult != null) {
                        hashSet.add((String) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_WATERMARK_PATH));
                    }
                }
                return hashSet;
            }
            return hashSet;
        }
    }

    public boolean isApsProcessing() {
        return this.mbCapturing;
    }

    public void addThumbnailInfo(ThumbnailItem thumbnailItem) {
        synchronized (this.mThumbnailMapLock) {
            long OplusGLSurfaceView_15 = thumbnailItem.mIdentity;
            CameraLog.m12959b(TAG, "addThumbnailInfo, timeStamp: " + OplusGLSurfaceView_15 + ", mThumbnailMap: " + this.mThumbnailMap);
            if (this.mThumbnailMap != null) {
                if (OplusGLSurfaceView_15 > this.mLatestThumbnailIdentity) {
                    this.mLatestThumbnailIdentity = OplusGLSurfaceView_15;
                }
                if (this.mThumbnailMap.containsKey(Long.valueOf(OplusGLSurfaceView_15))) {
                    ThumbnailCategory thumbnailCategory = this.mThumbnailMap.get(Long.valueOf(OplusGLSurfaceView_15));
                    thumbnailCategory.mThumbnailItem = thumbnailItem;
                    if (thumbnailCategory.isValid() && thumbnailCategory.mCameraPictureImage != null) {
                        savePicture(thumbnailCategory, thumbnailCategory.mCameraPictureImage);
                        this.mThumbnailMap.remove(Long.valueOf(OplusGLSurfaceView_15));
                    }
                } else {
                    ThumbnailCategory thumbnailCategory2 = new ThumbnailCategory();
                    thumbnailCategory2.mThumbnailItem = thumbnailItem;
                    this.mThumbnailMap.put(Long.valueOf(OplusGLSurfaceView_15), thumbnailCategory2);
                }
            }
            addStageProtectInfo(getPackageName());
            this.mThumbnailUpdateSig.open();
        }
    }

    public boolean containThumbnailInfo(long OplusGLSurfaceView_15) {
        boolean zContainsKey;
        synchronized (this.mThumbnailMapLock) {
            zContainsKey = this.mThumbnailMap.containsKey(Long.valueOf(OplusGLSurfaceView_15));
        }
        return zContainsKey;
    }

    public void deleteThumbnailAndCache(ThumbnailItem thumbnailItem) {
        if (thumbnailItem != null) {
            CameraLog.m12959b(TAG, "deleteThumbnailAndCache, thumbnailItem: " + thumbnailItem.toString());
            Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
            cameraPicture.f12128a = thumbnailItem.mResolver;
            cameraPicture.f12130c = thumbnailItem.mUri;
            cameraPicture.f12149v = false;
            cameraPicture.f12107E = thumbnailItem.mbLockScreen;
            cameraPicture.f12153z = thumbnailItem.mUpdateLastThumbTask;
            ImageSaverThread.m14696a().m14707c(cameraPicture);
        }
    }

    public void notifyErrorType(ApsFailure apsFailure) {
        CameraLog.m12967f(TAG, "notifyErrorType, failure: " + apsFailure);
        int OplusGLSurfaceView_13 = apsFailure.mType;
        if (OplusGLSurfaceView_13 == 1) {
            handleCaptureFailed(apsFailure.mTimestamp, apsFailure.mImageNums, apsFailure.mMergeNums);
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            handlePreviewFailed(apsFailure.mFrameNumber);
        }
    }

    private void handleCaptureFailed(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) {
        synchronized (this.mThumbnailMapLock) {
            if (this.mThumbnailMap.get(Long.valueOf(OplusGLSurfaceView_15)) != null) {
                deleteThumbnailAndCache(this.mThumbnailMap.get(Long.valueOf(OplusGLSurfaceView_15)).mThumbnailItem);
            }
            if (OplusGLSurfaceView_15 != this.mLastProcessTimeStamp) {
                this.mThumbnailMap.remove(Long.valueOf(OplusGLSurfaceView_15));
            }
            CameraLog.m12959b(TAG, "handleCaptureFailed, timestamp: " + OplusGLSurfaceView_15 + ", mThumbnailMap size: " + this.mThumbnailMap.size());
            this.mLatestThumbnailIdentity = 0L;
        }
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ApsService getService() {
            return ApsService.this;
        }
    }

    public static class ApsFailure {
        public static final int TYPE_CAPTURE_FAIL = 1;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_PREVIEW_FAIL = 2;
        public long mFrameNumber;
        public int mImageNums;
        public int mMergeNums;
        public long mTimestamp;
        public int mType;

        public ApsFailure(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this(OplusGLSurfaceView_13, OplusGLSurfaceView_15, 0L, 0, 0);
        }

        public ApsFailure(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, int i2, int i3) {
            this.mType = 0;
            this.mFrameNumber = -1L;
            this.mTimestamp = 0L;
            this.mImageNums = 0;
            this.mMergeNums = 0;
            this.mType = OplusGLSurfaceView_13;
            this.mFrameNumber = OplusGLSurfaceView_15;
            this.mTimestamp = j2;
            this.mImageNums = i2;
            this.mMergeNums = i3;
        }

        public String toString() {
            return "{mType: " + this.mType + ", mFrameNumber: " + this.mFrameNumber + ", mTimestamp: " + this.mTimestamp + ", mImageNums: " + this.mImageNums + ", mMergeNums: " + this.mMergeNums + "}";
        }
    }

    public ThumbnailItem getThumbnailItem(long OplusGLSurfaceView_15) {
        ThumbnailCategory thumbnailCategory = this.mThumbnailMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (thumbnailCategory != null) {
            return thumbnailCategory.mThumbnailItem;
        }
        return null;
    }

    private ParcelFileDescriptor getParcelFileDescriptor(ContentResolver contentResolver, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        CameraLog.m12959b(TAG, "getParcelFileDescriptor, begin");
        try {
            parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "rw");
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d(TAG, "getFileDescriptor, dup fd error, uri: " + uri, COUIBaseListPopupWindow_8);
            parcelFileDescriptorOpenFileDescriptor = null;
        }
        CameraLog.m12959b(TAG, "getParcelFileDescriptor, end");
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            return parcelFileDescriptorOpenFileDescriptor;
        }
        CameraLog.m12967f(TAG, "getFileDescriptor, fd error, uri: " + uri);
        closeParcelFD(parcelFileDescriptorOpenFileDescriptor);
        return null;
    }

    private void closeParcelFD(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                CameraLog.m12965d(TAG, "closeParcelFD, close parcelFD error, parcelFD: " + parcelFileDescriptor, COUIBaseListPopupWindow_8);
            }
        }
    }

    private void fillHeifFD(ThumbnailItem thumbnailItem, Map<String, String> map) throws IOException {
        if (thumbnailItem.mResolver == null || thumbnailItem.mUri == null) {
            CameraLog.m12967f(TAG, "fillHeifFD, param invalid, item: " + thumbnailItem);
            return;
        }
        CameraLog.m12959b(TAG, "fillHeifFD");
        ParcelFileDescriptor parcelFileDescriptor = getParcelFileDescriptor(thumbnailItem.mResolver, thumbnailItem.mUri);
        if (parcelFileDescriptor == null) {
            CameraLog.m12967f(TAG, "fillHeifFD, parcelfd is null.");
            return;
        }
        map.put(CameraUnitKeys.KEY_HEIF_FILE_FD, String.valueOf(parcelFileDescriptor.detachFd()));
        try {
            parcelFileDescriptor.close();
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public void setHeicCodecOpen(boolean z) {
        this.mbHeicCodecOpen = z;
    }

    public void setHighPictureSize(boolean z) {
        this.mbHighPictureSize = z;
    }

    public void setCaptureMsgData(CaptureMsgData captureMsgData) {
        this.mCaptureMsgData = captureMsgData;
    }
}
