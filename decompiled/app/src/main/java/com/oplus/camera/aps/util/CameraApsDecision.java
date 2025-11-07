package com.oplus.camera.aps.util;

import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class CameraApsDecision {
    private static final String TAG = "CameraApsDecision";
    public int mAISState;
    public String[] mApsAlgoFlag;
    public int mApsBracketMode;
    public int mApsDecisionFeatureType;
    public int mApsDecisionSceneMode;
    public int mApsDecisionShowHdrIcon;
    public int mAsdSceneValue;
    public int mCameraId;
    public int[] mCaptureEVList;
    public int mCaptureNoNeedMatchMeta = 0;
    public String mFullAlgoKey;
    public String mFullAlgoValue;
    public int mMFSRFrameCount;
    public int mMasterPipeline;
    public int mMetaIndex;
    public int mMultiFrameCount;
    public int mNightTotalExpTime;
    public int mRequestFormat;
    public int[] mSensorMask;
    public int mSuperNightScene;
    public int mSupportCaptureZoomFeature;
    public int mThumbnailIndex;
    public boolean mbAIShutter;

    public CameraApsDecision(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        this.mCameraId = -1;
        this.mRequestFormat = 0;
        this.mMultiFrameCount = 1;
        this.mSuperNightScene = 0;
        this.mNightTotalExpTime = 0;
        this.mApsDecisionSceneMode = 0;
        this.mApsDecisionShowHdrIcon = -1;
        this.mApsDecisionFeatureType = 0;
        this.mApsAlgoFlag = null;
        this.mCaptureEVList = null;
        this.mSensorMask = null;
        this.mMasterPipeline = 0;
        this.mApsBracketMode = 0;
        this.mFullAlgoKey = "";
        this.mFullAlgoValue = "";
        this.mAsdSceneValue = 0;
        this.mMFSRFrameCount = 0;
        this.mSupportCaptureZoomFeature = 0;
        this.mbAIShutter = false;
        this.mAISState = 0;
        this.mThumbnailIndex = 1;
        this.mMetaIndex = 0;
        if (cameraPreviewResult != null) {
            this.mCameraId = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAMERA_ID)).intValue();
            this.mRequestFormat = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_REQUEST_FORMAT)).intValue();
            this.mMultiFrameCount = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_MULTI_FRAME_COUNT)).intValue();
            this.mSuperNightScene = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_SUPER_NIGHT_SCENE)).intValue();
            this.mNightTotalExpTime = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_NIGHT_TOTAL_EXPTIME)).intValue();
            this.mApsDecisionSceneMode = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_SCENE_MODE)).intValue();
            this.mApsDecisionShowHdrIcon = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_SHOW_HDR_ICON)).intValue();
            this.mApsDecisionFeatureType = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_FEATURE_TYPE)).intValue();
            this.mApsAlgoFlag = (String[]) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_ALGO_FLAG);
            this.mCaptureEVList = (int[]) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAPTURE_EV_LIST);
            this.mSensorMask = (int[]) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_SENSOR_MASK);
            this.mMasterPipeline = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_MASTER_PIPELINE)).intValue();
            this.mApsBracketMode = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_BRACKET_MODE)).intValue();
            this.mFullAlgoKey = (String) cameraPreviewResult.get(CameraParameter.KEY_ALGO_VISUALIZATION_KEY);
            this.mFullAlgoValue = (String) cameraPreviewResult.get(CameraParameter.KEY_ALGO_VISUALIZATION_VALUE);
            this.mAsdSceneValue = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_AI_SCENE)).intValue();
            this.mMFSRFrameCount = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_MFSR_FRAME_COUNT)).intValue();
            this.mSupportCaptureZoomFeature = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_SUPPORT_ZOOM_FEATURE)).intValue();
            this.mbAIShutter = ((Boolean) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_AI_SHUTTER)).booleanValue();
            this.mAISState = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_AIS_STATE)).intValue();
            this.mThumbnailIndex = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_THUMBNAIL_INDEX)).intValue();
            this.mMetaIndex = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_META_INDEX)).intValue();
        }
    }

    public String toString() {
        return "mCameraId: " + this.mCameraId + ", mRequestFormat: " + this.mRequestFormat + ", mMultiFrameCount: " + this.mMultiFrameCount + ", mSuperNightScene: " + this.mSuperNightScene + ", mNightTotalExpTime: " + this.mNightTotalExpTime + ", mApsDecisionSceneMode: " + this.mApsDecisionSceneMode + ", mApsDecisionFeatureType: " + this.mApsDecisionFeatureType + ", mApsAlgoFlag: " + Arrays.toString(this.mApsAlgoFlag) + ", mCaptureEVList: " + Arrays.toString(this.mCaptureEVList) + ", mSensorMask: " + Arrays.toString(this.mSensorMask) + ", mMasterPipeline: " + this.mMasterPipeline + ", mMFSRFrameCount: " + this.mMFSRFrameCount + ", mApsBracketMode: " + this.mApsBracketMode + ", mSupportCaptureZoomFeature: " + this.mSupportCaptureZoomFeature + ", mCaptureNoNeedMatchMeta: " + this.mCaptureNoNeedMatchMeta + ", mAsdSceneValue: " + this.mAsdSceneValue + ", mbAIShutter: " + this.mbAIShutter + ", mThumbnailIndex: " + this.mThumbnailIndex + ", mMetaIndex: " + this.mMetaIndex;
    }
}
