package com.oplus.camera.aps.service;

/* loaded from: classes2.dex */
public class ApsService extends android.app.Service {
    private static final java.lang.String BURST_SHOT_TEMP_DIRECTORY_FLAG = ".cshot";
    private static final long SELF_PROTECT_ADD_TIME = 600000;
    private static final java.lang.String TAG = "ApsService";
    private static final int WAIT_THUMBNAIL_UPDATE_TIME_LIMIT = 6000;
    private final android.os.IBinder mBinder = new com.oplus.camera.aps.service.ApsService.LocalBinder();
    private final java.lang.Object mOplusWhiteListLock = new java.lang.Object();
    private final java.lang.Object mThumbnailMapLock = new java.lang.Object();
    private final java.lang.Object mBurstShotTempDirectoryLock = new java.lang.Object();
    private android.app.OplusWhiteListManager mOplusWhiteListManager = null;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oplus.camera.aps.service.ThumbnailCategory> mThumbnailMap = new java.util.concurrent.ConcurrentHashMap<>();
    private long mLatestThumbnailIdentity = 0;
    private android.os.ConditionVariable mThumbnailUpdateSig = new android.os.ConditionVariable();
    private boolean mbCapturing = false;
    private com.oplus.camera.e_renamed.d_renamed.a_renamed mCaptureCallback = null;
    private com.oplus.camera.e_renamed.d_renamed.e_renamed mStateObserver = null;
    private com.oplus.camera.aps.service.CaptureRequestParam mCaptureRequestParam = null;
    private com.oplus.ocs.camera.CameraPictureCallback mCameraPictureListener = null;
    private com.oplus.camera.statistics.model.CaptureMsgData mCaptureMsgData = null;
    private boolean mbHeicCodecOpen = false;
    private boolean mbHighPictureSize = false;
    private long mLastProcessTimeStamp = 0;
    private com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult mCameraPictureResult = null;
    private long mMaxBurstShotIdentity = 0;
    private com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult mBurstShotPictureResult = null;
    private com.oplus.ocs.camera.CameraPictureCallback mCameraPictureCallback = new com.oplus.ocs.camera.CameraPictureCallback() { // from class: com.oplus.camera.aps.service.ApsService.1
        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureShutter(long j_renamed) {
            super.onCaptureShutter(j_renamed);
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onCaptureStarted(null, null, j_renamed, 0L);
                com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onCaptureShutter");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCapturePrepared() {
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onCapturePrepared();
                com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onCapturePrepared");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onPictureCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onPictureCaptureProgressed(captureRequest, cameraPictureResult);
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onCaptureProgressed(captureRequest, new com.oplus.camera.aps.service.CameraCaptureResult(cameraPictureResult.getCaptureResult()), (com.oplus.camera.e_renamed.c_renamed) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_REQUEST_TAG));
                com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onPictureCaptureProgressed");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureFailed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onCaptureFailed(cameraPictureResult);
            com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onCaptureFailed");
            java.lang.Integer num = cameraPictureResult != null ? (java.lang.Integer) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.CAPTURE_FAIL_CODE) : num;
            num = num != null ? num : 0;
            com.oplus.camera.aps.service.ApsService.this.mbCapturing = false;
            com.oplus.camera.e_renamed.a_renamed("captureX onCaptureFailed failCode: " + num, "22ct_CaptureFailed", com.oplus.camera.d_renamed.d_renamed.longValue());
            if (num.intValue() > 0 || cameraPictureResult == null || cameraPictureResult.getCaptureFailure() == null) {
                if (com.oplus.camera.aps.service.ApsService.this.mCameraPictureListener != null) {
                    com.oplus.camera.aps.service.ApsService.this.mCameraPictureListener.onCaptureFailed(cameraPictureResult);
                    com.oplus.camera.aps.service.ApsService.this.mCaptureRequestParam.mApsServiceListener.a_renamed(0, 0, false, 256);
                }
            } else if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onCaptureFailed(cameraPictureResult.getCaptureFailure().getRequest(), (com.oplus.camera.e_renamed.c_renamed) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_REQUEST_TAG));
            }
            com.oplus.camera.e_renamed.d_renamed("captureX onCaptureFailed failCode: " + num, "22ct_CaptureFailed");
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onCaptureFirstFrameArrived(captureRequest, cameraPictureResult);
            com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult = new com.oplus.camera.aps.service.CameraCaptureResult(cameraPictureResult.getCaptureResult());
            java.lang.Long l_renamed = (java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.CAPTURE_RESULT_NIGHT_TOTAL_EXPTIME);
            java.lang.Long l2 = (java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.CAPTURE_RESULT_FIRST_EXPOSURE_TIME);
            java.lang.Object obj = cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_REQUEST_TAG);
            com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onCaptureFirstFrameArrived, nightTotalTime: " + l_renamed + ", firstExposureTime: " + l2);
            if (l_renamed != null) {
                cameraCaptureResult.mNightCaptureTotaltime = l_renamed.longValue();
            }
            if (l2 != null) {
                cameraCaptureResult.mFirstExposureTime = l2.longValue();
            }
            if (obj != null) {
                cameraCaptureResult.setRequestTag((com.oplus.camera.e_renamed.c_renamed) obj);
            }
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureMetaReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            super.onCaptureMetaReceived(cameraPictureResult);
            com.oplus.camera.aps.service.ApsService.this.mCameraPictureResult = cameraPictureResult;
            com.oplus.camera.e_renamed.c_renamed cVar = (com.oplus.camera.e_renamed.c_renamed) com.oplus.camera.aps.service.ApsService.this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_REQUEST_TAG);
            com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult = new com.oplus.camera.aps.service.CameraCaptureResult(cameraPictureResult.getCaptureResult());
            java.lang.Long l_renamed = (java.lang.Long) com.oplus.camera.aps.service.ApsService.this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.PICTURE_IDENTITY);
            com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onCaptureMetaReceived, pictureIdentity: " + l_renamed);
            com.oplus.camera.e_renamed.a_renamed("captureX onCaptureMetaReceived", "24ct_CaptureMetaReceived", com.oplus.camera.d_renamed.d_renamed.longValue());
            if (l_renamed != null) {
                cameraCaptureResult.mIdentity = l_renamed.longValue();
            }
            com.oplus.camera.perf.ComprehensivePerformance.a_renamed((java.util.HashMap<java.lang.String, java.lang.Long>) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.APS_PROC_TIMER), java.lang.System.currentTimeMillis(), l_renamed);
            cameraCaptureResult.mMeshPtr = ((java.lang.Long) com.oplus.camera.aps.service.ApsService.this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.MESH_PTR)).longValue();
            if (com.oplus.camera.aps.service.ApsService.this.mStateObserver != null) {
                com.oplus.camera.aps.service.ApsService.this.mStateObserver.a_renamed(cameraPictureResult.getCaptureResult(), cVar);
            }
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onCaptureCompleted(cameraCaptureResult, cVar);
            }
            com.oplus.camera.e_renamed.d_renamed("captureX onCaptureMetaReceived", "24ct_CaptureMetaReceived");
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
            super.onImageReceived(cameraPictureImage);
            com.oplus.camera.aps.service.ApsService.this.mbCapturing = false;
            if (cameraPictureImage == null) {
                com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onImageReceived, image is_renamed null, return");
                return;
            }
            if (32 == cameraPictureImage.getFormat()) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureRequestParam.mApsServiceListener.b_renamed(cameraPictureImage);
                return;
            }
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureRequestParam.mApsServiceListener.a_renamed(cameraPictureImage)) {
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("captureX onImageReceived size: " + cameraPictureImage.getWidth() + "x_renamed" + cameraPictureImage.getHeight(), "28ct_ImageReceived", com.oplus.camera.d_renamed.d_renamed.longValue());
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureRequestParam.mApsServiceListener.c_renamed(cameraPictureImage)) {
                com.oplus.camera.e_renamed.d_renamed("captureX onImageReceived size: " + cameraPictureImage.getWidth() + "x_renamed" + cameraPictureImage.getHeight(), "28ct_ImageReceived");
                return;
            }
            com.oplus.camera.e_renamed.d_renamed("captureX onImageReceived size: " + cameraPictureImage.getWidth() + "x_renamed" + cameraPictureImage.getHeight(), "28ct_ImageReceived");
            long timestamp = cameraPictureImage.getTimestamp();
            com.oplus.camera.m_renamed.b_renamed.a_renamed().i_renamed();
            synchronized (com.oplus.camera.aps.service.ApsService.this.mThumbnailMapLock) {
                com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory = (com.oplus.camera.aps.service.ThumbnailCategory) com.oplus.camera.aps.service.ApsService.this.mThumbnailMap.get(java.lang.Long.valueOf(timestamp));
                com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onImageReceived, identity: " + timestamp + ", size: " + com.oplus.camera.aps.service.ApsService.this.mThumbnailMap.size());
                if (thumbnailCategory == null) {
                    return;
                }
                if (thumbnailCategory.isValid()) {
                    com.oplus.camera.aps.service.ApsService.this.savePicture(thumbnailCategory, cameraPictureImage);
                } else {
                    com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult = thumbnailCategory.mPictureResult;
                    if (cameraPictureResult != null && ((java.lang.Integer) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_REC_BURST_NUMBER)).intValue() > 1) {
                        com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "onImageReceived, the burst capture is_renamed already stopped, complete directly");
                        com.oplus.camera.aps.service.ApsService.this.pictureSaveEnd(timestamp, thumbnailCategory.mPictureResult);
                        com.oplus.camera.m_renamed.b_renamed.a_renamed().k_renamed();
                    } else {
                        thumbnailCategory.mCameraPictureImage = cameraPictureImage;
                    }
                }
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onBurstShotStart(long j_renamed) {
            com.oplus.camera.e_renamed.a_renamed("captureX onBurstShotStart burstShotFlagId: " + j_renamed);
            com.oplus.camera.aps.service.ApsService.this.createBurstShotFlagFile(j_renamed);
            com.oplus.camera.e_renamed.b_renamed("captureX onBurstShotStart burstShotFlagId: " + j_renamed);
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onBurstShotEnd(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            com.oplus.camera.e_renamed.a_renamed("captureX onBurstShotEnd");
            com.oplus.camera.aps.service.ApsService.this.deleteBurstShotFlagFile(((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue());
            com.oplus.camera.e_renamed.b_renamed("captureX onBurstShotEnd");
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void afterProcessImage(int i_renamed, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.aps.service.ApsService.TAG, "afterProcessImage, processResult: " + i_renamed + ", pictureResult: " + cameraPictureResult + ", identity: " + cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY) + ", captureForVideo: " + cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_CAPTURE_FOR_VIDEO));
            if (((java.lang.Boolean) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_CAPTURE_FOR_VIDEO)).booleanValue()) {
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("captureX afterProcessImage", "15ct_afterProcessImage", com.oplus.camera.d_renamed.d_renamed.longValue());
            com.oplus.camera.aps.service.ApsService.this.mLastProcessTimeStamp = ((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue();
            com.oplus.camera.perf.ComprehensivePerformance.a_renamed(com.oplus.camera.aps.service.ApsService.this.mLastProcessTimeStamp);
            synchronized (com.oplus.camera.aps.service.ApsService.this.mThumbnailMapLock) {
                if (i_renamed == -1) {
                    com.oplus.camera.aps.service.ApsService.this.mThumbnailMap.remove(cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY));
                    com.oplus.camera.aps.service.ApsService.this.mLatestThumbnailIdentity = 0L;
                    com.oplus.camera.e_renamed.d_renamed("captureX afterProcessImage", "15ct_afterProcessImage");
                    return;
                }
                if (((java.lang.Boolean) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) {
                    com.oplus.camera.aps.service.ApsService.this.mCaptureRequestParam.mBurstShotThumbnailCallBack.a_renamed(((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue(), ((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue(), null);
                }
                if (((java.lang.Boolean) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_END_OF_CAPTURE)).booleanValue()) {
                    if (com.oplus.camera.aps.service.ApsService.this.mThumbnailMap != null) {
                        if (com.oplus.camera.aps.service.ApsService.this.mThumbnailMap.containsKey(cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY))) {
                            com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory = (com.oplus.camera.aps.service.ThumbnailCategory) com.oplus.camera.aps.service.ApsService.this.mThumbnailMap.get(cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY));
                            thumbnailCategory.mPictureResult = cameraPictureResult;
                            thumbnailCategory.mCaptureMsgData = com.oplus.camera.aps.service.ApsService.this.mCaptureMsgData;
                        } else {
                            com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory2 = new com.oplus.camera.aps.service.ThumbnailCategory();
                            thumbnailCategory2.mThumbnailItem = new com.oplus.camera.aps.service.ThumbnailItem();
                            thumbnailCategory2.mPictureResult = cameraPictureResult;
                            thumbnailCategory2.mCaptureMsgData = com.oplus.camera.aps.service.ApsService.this.mCaptureMsgData;
                            if (((java.lang.Boolean) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) {
                                thumbnailCategory2.mThumbnailItem.mbBurstShot = true;
                            }
                            com.oplus.camera.aps.service.ApsService.this.mThumbnailMap.put((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY), thumbnailCategory2);
                        }
                    }
                    com.oplus.camera.m_renamed.b_renamed.a_renamed().h_renamed();
                }
                com.oplus.camera.e_renamed.d_renamed("captureX afterProcessImage", "15ct_afterProcessImage");
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onPictureCaptureSequenceCompleted(int i_renamed, long j_renamed) {
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onCaptureSequenceCompleted();
            }
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void fillApsParameters(int i_renamed, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
            com.oplus.camera.statistics.model.PerformanceMsgData.startPointTime(com.oplus.camera.statistics.model.CaptureMsgData.PROCESS_DURATION);
            com.oplus.camera.aps.service.ApsService.this.fillParameters(i_renamed, map);
            com.oplus.camera.e_renamed.c_renamed(com.oplus.camera.aps.service.ApsService.TAG, "fillApsParameters, type: " + i_renamed + ", parameters: " + map);
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onFinishAddFrame(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            com.oplus.camera.aps.service.ApsService.this.mCaptureRequestParam.mApsServiceListener.a_renamed(((java.lang.Integer) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_WIDTH)).intValue(), ((java.lang.Integer) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_HEIGHT)).intValue(), ((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() != -1, ((java.lang.Integer) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_FORMAT)).intValue());
        }

        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onFirstCaptureFrameAdd() {
            if (com.oplus.camera.aps.service.ApsService.this.mCaptureCallback != null) {
                com.oplus.camera.aps.service.ApsService.this.mCaptureCallback.onFirstCaptureFrameAdd();
            }
        }
    };

    private void handlePreviewFailed(long j_renamed) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePicture(com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.e_renamed.a_renamed("captureX savePicture size: " + cameraPictureImage.getWidth() + "x_renamed" + cameraPictureImage.getHeight(), "32ct_savePicture", com.oplus.camera.d_renamed.d_renamed.longValue());
        long timestamp = cameraPictureImage.getTimestamp();
        com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult = thumbnailCategory.mPictureResult;
        com.oplus.camera.aps.service.ThumbnailItem thumbnailItem = thumbnailCategory.mThumbnailItem;
        final com.oplus.camera.Storage.CameraPicture cameraPicture = new com.oplus.camera.Storage.CameraPicture();
        cameraPicture.f4066a = thumbnailItem.mResolver;
        cameraPicture.g_renamed = thumbnailItem.mJpegName;
        cameraPicture.e_renamed = cameraPictureImage.getImage();
        cameraPicture.f4068c = thumbnailItem.mUri;
        cameraPicture.o_renamed = cameraPictureImage.getWidth();
        cameraPicture.p_renamed = cameraPictureImage.getHeight();
        cameraPicture.r_renamed = cameraPictureImage.getScanline();
        cameraPicture.q_renamed = cameraPictureImage.getStride();
        cameraPicture.f4067b = new com.oplus.camera.aps.util.CameraApsExifData(this.mCameraPictureResult);
        cameraPicture.n_renamed = cameraPictureResult != null ? ((java.lang.Integer) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_REC_BURST_NUMBER)).intValue() : -1;
        cameraPicture.h_renamed = cameraPictureImage.getFormat() == 256 ? com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG : thumbnailItem.mPictureFormat;
        cameraPicture.v_renamed = true;
        cameraPicture.H_renamed = thumbnailItem.mTimeStamp;
        cameraPicture.I_renamed = cameraPictureImage.getTimestamp();
        cameraPicture.E_renamed = thumbnailItem.mbLockScreen;
        cameraPicture.m_renamed = cameraPictureResult != null ? ((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT_FLAG_ID)).longValue() : -1L;
        cameraPicture.k_renamed = cameraPictureResult != null ? (java.lang.String) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_CSHOT_PATH) : null;
        cameraPicture.R_renamed = thumbnailItem.mbUltraHighResolution;
        cameraPicture.W_renamed = ((java.lang.Boolean) this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.HEIF_PROCESS_IN_APS)).booleanValue();
        cameraPicture.Y_renamed = this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_REQUEST_TAG) != null && ((com.oplus.camera.e_renamed.c_renamed) this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.RESULT_REQUEST_TAG)).aa_renamed;
        if (thumbnailItem.mDate != 0) {
            cameraPicture.l_renamed = thumbnailItem.mDate;
        } else {
            cameraPicture.l_renamed = java.lang.System.currentTimeMillis();
        }
        cameraPicture.t_renamed = com.oplus.camera.util.Util.b_renamed(cameraPicture.e_renamed);
        cameraPicture.N_renamed = this.mCaptureRequestParam.mPictureTakenCallback;
        cameraPicture.T_renamed = this.mCaptureRequestParam.mbSuperTextOpen;
        if (thumbnailItem.mIdentity == this.mLatestThumbnailIdentity) {
            cameraPicture.J_renamed = true;
        }
        if (thumbnailItem.mCameraUiUpdateThumbnail != null) {
            cameraPicture.u_renamed = this.mCaptureRequestParam.mThumbWidth;
            cameraPicture.y_renamed = thumbnailItem.mCameraUiUpdateThumbnail;
        }
        if (thumbnailItem.mUri == null && ("heic_8bits".equalsIgnoreCase(cameraPicture.h_renamed) || "heic_10bits".equalsIgnoreCase(cameraPicture.h_renamed))) {
            cameraPicture.D_renamed = true;
        }
        boolean zBooleanValue = ((java.lang.Boolean) this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.HAS_SUPER_TEXT_RESULT)).booleanValue();
        final int iIntValue = ((java.lang.Integer) this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.SUPER_TEXT_WIDTH)).intValue();
        final int iIntValue2 = ((java.lang.Integer) this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.SUPER_TEXT_HEIGHT)).intValue();
        if (zBooleanValue && this.mCaptureRequestParam.mSuperTextResultProcessor != null) {
            cameraPicture.K_renamed = this.mCaptureRequestParam.mSuperTextResultProcessor;
            cameraPicture.P_renamed = true;
            cameraPicture.Q_renamed = this.mCaptureRequestParam.mCaptureOrientation;
            com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.aps.service.ApsService.2
                @Override // java.lang.Runnable
                public void run() {
                    int screenWidth;
                    int i_renamed = iIntValue2;
                    int i2 = iIntValue;
                    float f_renamed = i_renamed < i2 ? i_renamed : i2;
                    if (com.oplus.camera.util.Util.u_renamed()) {
                        screenWidth = com.oplus.camera.util.Util.V_renamed();
                    } else {
                        screenWidth = com.oplus.camera.util.Util.getScreenWidth();
                    }
                    float f2 = screenWidth / f_renamed;
                    com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.aps.service.ApsService.TAG, "savePicture, scale: " + f2);
                    int i3 = com.oplus.camera.aps.service.ApsService.this.mCaptureRequestParam.mCaptureOrientation;
                    android.graphics.Bitmap bitmapB = com.oplus.camera.util.Util.b_renamed(android.graphics.BitmapFactory.decodeByteArray(cameraPicture.e_renamed, 0, cameraPicture.e_renamed.length), f2);
                    if (!com.oplus.camera.util.Util.u_renamed()) {
                        bitmapB = com.oplus.camera.util.Util.b_renamed(bitmapB, (360 - i3) % 360);
                    }
                    android.graphics.Bitmap bitmap = bitmapB;
                    if (cameraPicture.K_renamed != null) {
                        synchronized (cameraPicture.K_renamed) {
                            if (cameraPicture.A_renamed != null) {
                                cameraPicture.K_renamed.a_renamed(bitmap, cameraPicture.A_renamed, cameraPicture.P_renamed, cameraPicture.Q_renamed, cameraPicture.T_renamed, cameraPicture.Y_renamed, cameraPicture.l_renamed);
                            } else {
                                cameraPicture.L_renamed = bitmap;
                            }
                        }
                    }
                }
            });
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "savePicture, picture: " + cameraPicture + ", thumbnailItem: " + thumbnailItem);
        if (thumbnailItem.mProductProcessor != null) {
            thumbnailItem.mProductProcessor.a_renamed(cameraPicture);
        } else {
            com.oplus.camera.m_renamed.b_renamed.a_renamed().c_renamed(cameraPicture);
        }
        if (!thumbnailItem.mbBurstShot && thumbnailCategory.mCaptureMsgData != null) {
            int iIntValue3 = ((java.lang.Integer) this.mCameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.NOISE_REDUCTION_STRENGTH)).intValue();
            int i_renamed = (iIntValue3 >> 4) & 15;
            thumbnailCategory.mCaptureMsgData.mMultiFrameNum = java.lang.String.valueOf(i_renamed);
            thumbnailCategory.mCaptureMsgData.mLostFrameNum = java.lang.String.valueOf(i_renamed - (iIntValue3 & 15));
            this.mCaptureRequestParam.mApsServiceListener.a_renamed(thumbnailCategory, cameraPicture);
            this.mCaptureMsgData = null;
        }
        pictureSaveEnd(timestamp, cameraPictureResult);
        com.oplus.camera.e_renamed.d_renamed("captureX savePicture size: " + cameraPictureImage.getWidth() + "x_renamed" + cameraPictureImage.getHeight(), "32ct_savePicture");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParameters(int i_renamed, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
        if (i_renamed != 1) {
            return;
        }
        com.oplus.camera.aps.service.ThumbnailItem thumbnailItem = getThumbnailItem(java.lang.Long.parseLong(map.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PROCESS_IMAGE_IDENTITY)));
        com.oplus.camera.aps.service.ThumbnailItem thumbnailItem2 = null;
        if (thumbnailItem == null && this.mbHeicCodecOpen && !java.lang.Boolean.parseBoolean(map.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_BURST_SHOT))) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "fillApsParameters, get proper thumbnail null, wait.");
            thumbnailItem2 = getThumbnailItem(this.mLatestThumbnailIdentity);
            this.mThumbnailUpdateSig.close();
            this.mThumbnailUpdateSig.block(6000L);
            thumbnailItem = getThumbnailItem(java.lang.Long.parseLong(map.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PROCESS_IMAGE_IDENTITY)));
        }
        if (thumbnailItem == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "fillApsParameters, use last thumbnailItem");
            thumbnailItem = thumbnailItem2;
        }
        if (thumbnailItem != null) {
            if ("heic_8bits".equalsIgnoreCase(thumbnailItem.mPictureFormat) || "heic_10bits".equalsIgnoreCase(thumbnailItem.mPictureFormat)) {
                if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ONLY_HIGH_PICTURE_SIZE_HEIF_IN_APS) || this.mbHighPictureSize) {
                    map.put(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_HEIF_ENABLE, java.lang.String.valueOf(1));
                    fillHeifFD(thumbnailItem, map);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pictureSaveEnd(long j_renamed, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
        this.mThumbnailMap.remove(java.lang.Long.valueOf(j_renamed));
        if ((cameraPictureResult != null && ((java.lang.Boolean) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_BURST_SHOT)).booleanValue()) && j_renamed > this.mMaxBurstShotIdentity) {
            this.mMaxBurstShotIdentity = j_renamed;
            this.mBurstShotPictureResult = cameraPictureResult;
        }
        if (this.mThumbnailMap.size() == 0) {
            this.mLatestThumbnailIdentity = 0L;
            removeStageProtectInfo(getPackageName());
            com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult2 = this.mBurstShotPictureResult;
            if (cameraPictureResult2 != null) {
                this.mCameraPictureCallback.onBurstShotEnd(cameraPictureResult2);
                this.mBurstShotPictureResult = null;
            }
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "pictureSaveEnd, remaining thumb info: " + this.mThumbnailMap);
    }

    public com.oplus.ocs.camera.CameraPictureCallback getCameraPictureCallback() {
        return this.mCameraPictureCallback;
    }

    public void setCaptureCallback(com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) {
        this.mCaptureCallback = aVar;
    }

    public void setCameraPictureListener(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback) {
        this.mCameraPictureListener = cameraPictureCallback;
    }

    public void setStateObserver(com.oplus.camera.e_renamed.d_renamed.e_renamed eVar) {
        this.mStateObserver = eVar;
    }

    public void setCaptureRequestParam(com.oplus.camera.aps.service.CaptureRequestParam captureRequestParam) {
        this.mCaptureRequestParam = captureRequestParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean createBurstShotFlagFile(long j_renamed) {
        boolean zMkdirs;
        java.io.File file;
        java.io.File file2;
        synchronized (this.mBurstShotTempDirectoryLock) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "createBurstShotFlagFile, burstShotFlagId: " + j_renamed);
            zMkdirs = true;
            try {
                if (com.oplus.camera.Storage.c_renamed()) {
                    file = new java.io.File(com.oplus.camera.Storage.a_renamed());
                    file2 = new java.io.File(file.getAbsolutePath() + java.io.File.separator + j_renamed + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                } else {
                    java.lang.String strA = com.oplus.camera.Storage.a_renamed(java.lang.String.valueOf(j_renamed), "");
                    file = new java.io.File(strA);
                    file2 = new java.io.File(strA + java.io.File.separator + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                }
                if (!file.exists() || !file.isDirectory()) {
                    com.oplus.camera.e_renamed.a_renamed(TAG, "createBurstShotFlagFile, make directory");
                    zMkdirs = file.mkdirs();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                zMkdirs = false;
                com.oplus.camera.e_renamed.f_renamed(TAG, "createBurstShotFlagFile, Exception");
            }
            if (!file2.exists() || !file2.isFile()) {
                com.oplus.camera.e_renamed.a_renamed(TAG, "createBurstShotFlagFile, path: " + file2.getAbsolutePath());
                zMkdirs = file2.createNewFile();
            }
        }
        return zMkdirs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteBurstShotFlagFile(long j_renamed) {
        boolean z_renamed;
        java.io.File file;
        java.io.File file2;
        synchronized (this.mBurstShotTempDirectoryLock) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "deleteBurstShotFlagFile, burstShotFlagId: " + j_renamed);
            z_renamed = false;
            try {
                if (com.oplus.camera.Storage.c_renamed()) {
                    file = new java.io.File(com.oplus.camera.Storage.a_renamed());
                    file2 = new java.io.File(file.getAbsolutePath() + java.io.File.separator + j_renamed + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                } else {
                    java.lang.String strA = com.oplus.camera.Storage.a_renamed(java.lang.String.valueOf(j_renamed), "");
                    file = new java.io.File(strA);
                    file2 = new java.io.File(strA + java.io.File.separator + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                }
                boolean z2 = true;
                if (file.exists() && file2.exists()) {
                    com.oplus.camera.e_renamed.a_renamed(TAG, "deleteBurstShotFlagFile, path: " + file2.getAbsolutePath());
                    boolean zDelete = file2.delete();
                    com.oplus.camera.e_renamed.a_renamed(TAG, "deleteBurstShotFlagFile, notify gallery start");
                    android.content.ContentResolver contentResolver = getContentResolver();
                    if (!"on_renamed".equals(com.oplus.camera.Storage.u_renamed) || !com.oplus.camera.Storage.d_renamed()) {
                        z2 = false;
                    }
                    contentResolver.notifyChange(com.oplus.camera.Storage.c_renamed(z2), null);
                    com.oplus.camera.e_renamed.a_renamed(TAG, "deleteBurstShotFlagFile, notify gallery end");
                    z_renamed = zDelete;
                } else {
                    z_renamed = true;
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                com.oplus.camera.e_renamed.f_renamed(TAG, "deleteBurstShotFlagFile, Exception");
            }
        }
        return z_renamed;
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBind, this: " + this);
        synchronized (this.mOplusWhiteListLock) {
            if (this.mOplusWhiteListManager == null) {
                this.mOplusWhiteListManager = new android.app.OplusWhiteListManager(this);
            }
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.oplus.camera.e_renamed.b_renamed(TAG, "onCreate");
        super.onCreate();
        startForeground();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.oplus.camera.e_renamed.b_renamed(TAG, "onDestroy");
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "onStartCommand");
        super.onStartCommand(intent, i_renamed, i2);
        startForeground();
        return 1;
    }

    private void startForeground() {
        if (android.os.Build.VERSION.SDK_INT > 26) {
            startForeground(1, new androidx.core.app.h_renamed.d_renamed(this, createNotificationChannel(com.oplus.ocs.camera.BuildConfig.APPLICATION_ID, getString(com.oplus.camera.R_renamed.string.camera_app_name))).a_renamed(true).c_renamed(-2).a_renamed("service").b_renamed());
        } else {
            startForeground(1, new android.app.Notification());
        }
    }

    private java.lang.String createNotificationChannel(java.lang.String str, java.lang.String str2) {
        android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(str, str2, 0);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        ((android.app.NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        return str;
    }

    private void addStageProtectInfo(java.lang.String str) {
        synchronized (this.mOplusWhiteListLock) {
            if (this.mOplusWhiteListManager != null) {
                java.util.ArrayList stageProtectListFromPkg = this.mOplusWhiteListManager.getStageProtectListFromPkg(str, 0);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("StageProtectList: ");
                java.util.Iterator it = stageProtectListFromPkg.iterator();
                while (it.hasNext()) {
                    java.lang.String str2 = (java.lang.String) it.next();
                    sb.append("[");
                    sb.append(str2);
                    sb.append("] ");
                }
                com.oplus.camera.e_renamed.b_renamed(TAG, "addStageProtectInfo, nameBuilder: " + sb.toString());
                if (!stageProtectListFromPkg.contains(getPackageName())) {
                    this.mOplusWhiteListManager.addStageProtectInfo(str, SELF_PROTECT_ADD_TIME);
                }
            }
        }
    }

    private void removeStageProtectInfo(java.lang.String str) {
        synchronized (this.mOplusWhiteListLock) {
            if (this.mOplusWhiteListManager != null) {
                com.oplus.camera.e_renamed.b_renamed(TAG, "removeStageProtectInfo, pkgName: " + str);
                this.mOplusWhiteListManager.removeStageProtectInfo(str);
            }
        }
    }

    public java.util.HashSet<java.lang.String> getSloganPathsInUse() {
        java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet<>();
        synchronized (this.mThumbnailMapLock) {
            if (this.mThumbnailMap != null && this.mThumbnailMap.size() != 0) {
                java.util.Iterator<com.oplus.camera.aps.service.ThumbnailCategory> it = this.mThumbnailMap.values().iterator();
                while (it.hasNext()) {
                    com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult = it.next().mPictureResult;
                    if (cameraPictureResult != null) {
                        hashSet.add((java.lang.String) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_WATERMARK_PATH));
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

    public void addThumbnailInfo(com.oplus.camera.aps.service.ThumbnailItem thumbnailItem) {
        synchronized (this.mThumbnailMapLock) {
            long j_renamed = thumbnailItem.mIdentity;
            com.oplus.camera.e_renamed.b_renamed(TAG, "addThumbnailInfo, timeStamp: " + j_renamed + ", mThumbnailMap: " + this.mThumbnailMap);
            if (this.mThumbnailMap != null) {
                if (j_renamed > this.mLatestThumbnailIdentity) {
                    this.mLatestThumbnailIdentity = j_renamed;
                }
                if (this.mThumbnailMap.containsKey(java.lang.Long.valueOf(j_renamed))) {
                    com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory = this.mThumbnailMap.get(java.lang.Long.valueOf(j_renamed));
                    thumbnailCategory.mThumbnailItem = thumbnailItem;
                    if (thumbnailCategory.isValid() && thumbnailCategory.mCameraPictureImage != null) {
                        savePicture(thumbnailCategory, thumbnailCategory.mCameraPictureImage);
                        this.mThumbnailMap.remove(java.lang.Long.valueOf(j_renamed));
                    }
                } else {
                    com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory2 = new com.oplus.camera.aps.service.ThumbnailCategory();
                    thumbnailCategory2.mThumbnailItem = thumbnailItem;
                    this.mThumbnailMap.put(java.lang.Long.valueOf(j_renamed), thumbnailCategory2);
                }
            }
            addStageProtectInfo(getPackageName());
            this.mThumbnailUpdateSig.open();
        }
    }

    public boolean containThumbnailInfo(long j_renamed) {
        boolean zContainsKey;
        synchronized (this.mThumbnailMapLock) {
            zContainsKey = this.mThumbnailMap.containsKey(java.lang.Long.valueOf(j_renamed));
        }
        return zContainsKey;
    }

    public void deleteThumbnailAndCache(com.oplus.camera.aps.service.ThumbnailItem thumbnailItem) {
        if (thumbnailItem != null) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "deleteThumbnailAndCache, thumbnailItem: " + thumbnailItem.toString());
            com.oplus.camera.Storage.CameraPicture cameraPicture = new com.oplus.camera.Storage.CameraPicture();
            cameraPicture.f4066a = thumbnailItem.mResolver;
            cameraPicture.f4068c = thumbnailItem.mUri;
            cameraPicture.v_renamed = false;
            cameraPicture.E_renamed = thumbnailItem.mbLockScreen;
            cameraPicture.z_renamed = thumbnailItem.mUpdateLastThumbTask;
            com.oplus.camera.m_renamed.b_renamed.a_renamed().c_renamed(cameraPicture);
        }
    }

    public void notifyErrorType(com.oplus.camera.aps.service.ApsService.ApsFailure apsFailure) {
        com.oplus.camera.e_renamed.f_renamed(TAG, "notifyErrorType, failure: " + apsFailure);
        int i_renamed = apsFailure.mType;
        if (i_renamed == 1) {
            handleCaptureFailed(apsFailure.mTimestamp, apsFailure.mImageNums, apsFailure.mMergeNums);
        } else {
            if (i_renamed != 2) {
                return;
            }
            handlePreviewFailed(apsFailure.mFrameNumber);
        }
    }

    private void handleCaptureFailed(long j_renamed, int i_renamed, int i2) {
        synchronized (this.mThumbnailMapLock) {
            if (this.mThumbnailMap.get(java.lang.Long.valueOf(j_renamed)) != null) {
                deleteThumbnailAndCache(this.mThumbnailMap.get(java.lang.Long.valueOf(j_renamed)).mThumbnailItem);
            }
            if (j_renamed != this.mLastProcessTimeStamp) {
                this.mThumbnailMap.remove(java.lang.Long.valueOf(j_renamed));
            }
            com.oplus.camera.e_renamed.b_renamed(TAG, "handleCaptureFailed, timestamp: " + j_renamed + ", mThumbnailMap size: " + this.mThumbnailMap.size());
            this.mLatestThumbnailIdentity = 0L;
        }
    }

    public class LocalBinder extends android.os.Binder {
        public LocalBinder() {
        }

        public com.oplus.camera.aps.service.ApsService getService() {
            return com.oplus.camera.aps.service.ApsService.this;
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

        public ApsFailure(int i_renamed, long j_renamed) {
            this(i_renamed, j_renamed, 0L, 0, 0);
        }

        public ApsFailure(int i_renamed, long j_renamed, long j2, int i2, int i3) {
            this.mType = 0;
            this.mFrameNumber = -1L;
            this.mTimestamp = 0L;
            this.mImageNums = 0;
            this.mMergeNums = 0;
            this.mType = i_renamed;
            this.mFrameNumber = j_renamed;
            this.mTimestamp = j2;
            this.mImageNums = i2;
            this.mMergeNums = i3;
        }

        public java.lang.String toString() {
            return "{mType: " + this.mType + ", mFrameNumber: " + this.mFrameNumber + ", mTimestamp: " + this.mTimestamp + ", mImageNums: " + this.mImageNums + ", mMergeNums: " + this.mMergeNums + "}";
        }
    }

    public com.oplus.camera.aps.service.ThumbnailItem getThumbnailItem(long j_renamed) {
        com.oplus.camera.aps.service.ThumbnailCategory thumbnailCategory = this.mThumbnailMap.get(java.lang.Long.valueOf(j_renamed));
        if (thumbnailCategory != null) {
            return thumbnailCategory.mThumbnailItem;
        }
        return null;
    }

    private android.os.ParcelFileDescriptor getParcelFileDescriptor(android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.io.IOException {
        android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        com.oplus.camera.e_renamed.b_renamed(TAG, "getParcelFileDescriptor, begin");
        try {
            parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "rw");
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed(TAG, "getFileDescriptor, dup fd_renamed error, uri: " + uri, e_renamed);
            parcelFileDescriptorOpenFileDescriptor = null;
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "getParcelFileDescriptor, end");
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            return parcelFileDescriptorOpenFileDescriptor;
        }
        com.oplus.camera.e_renamed.f_renamed(TAG, "getFileDescriptor, fd_renamed error, uri: " + uri);
        closeParcelFD(parcelFileDescriptorOpenFileDescriptor);
        return null;
    }

    private void closeParcelFD(android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (java.io.IOException e_renamed) {
                com.oplus.camera.e_renamed.d_renamed(TAG, "closeParcelFD, close parcelFD error, parcelFD: " + parcelFileDescriptor, e_renamed);
            }
        }
    }

    private void fillHeifFD(com.oplus.camera.aps.service.ThumbnailItem thumbnailItem, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
        if (thumbnailItem.mResolver == null || thumbnailItem.mUri == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "fillHeifFD, param invalid, item: " + thumbnailItem);
            return;
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "fillHeifFD");
        android.os.ParcelFileDescriptor parcelFileDescriptor = getParcelFileDescriptor(thumbnailItem.mResolver, thumbnailItem.mUri);
        if (parcelFileDescriptor == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "fillHeifFD, parcelfd is_renamed null.");
            return;
        }
        map.put(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_HEIF_FILE_FD, java.lang.String.valueOf(parcelFileDescriptor.detachFd()));
        try {
            parcelFileDescriptor.close();
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public void setHeicCodecOpen(boolean z_renamed) {
        this.mbHeicCodecOpen = z_renamed;
    }

    public void setHighPictureSize(boolean z_renamed) {
        this.mbHighPictureSize = z_renamed;
    }

    public void setCaptureMsgData(com.oplus.camera.statistics.model.CaptureMsgData captureMsgData) {
        this.mCaptureMsgData = captureMsgData;
    }
}
