package com.oplus.camera.aps.util;

/* loaded from: classes2.dex */
public class CameraApsDecision {
    private static final java.lang.String TAG = "CameraApsDecision";
    public int mAISState;
    public java.lang.String[] mApsAlgoFlag;
    public int mApsBracketMode;
    public int mApsDecisionFeatureType;
    public int mApsDecisionSceneMode;
    public int mApsDecisionShowHdrIcon;
    public int mAsdSceneValue;
    public int mCameraId;
    public int[] mCaptureEVList;
    public int mCaptureNoNeedMatchMeta = 0;
    public java.lang.String mFullAlgoKey;
    public java.lang.String mFullAlgoValue;
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

    public CameraApsDecision(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
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
            this.mCameraId = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_CAMERA_ID)).intValue();
            this.mRequestFormat = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_REQUEST_FORMAT)).intValue();
            this.mMultiFrameCount = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_MULTI_FRAME_COUNT)).intValue();
            this.mSuperNightScene = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_SUPER_NIGHT_SCENE)).intValue();
            this.mNightTotalExpTime = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_NIGHT_TOTAL_EXPTIME)).intValue();
            this.mApsDecisionSceneMode = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_SCENE_MODE)).intValue();
            this.mApsDecisionShowHdrIcon = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_SHOW_HDR_ICON)).intValue();
            this.mApsDecisionFeatureType = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_FEATURE_TYPE)).intValue();
            this.mApsAlgoFlag = (java.lang.String[]) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_ALGO_FLAG);
            this.mCaptureEVList = (int[]) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_CAPTURE_EV_LIST);
            this.mSensorMask = (int[]) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_SENSOR_MASK);
            this.mMasterPipeline = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_MASTER_PIPELINE)).intValue();
            this.mApsBracketMode = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_BRACKET_MODE)).intValue();
            this.mFullAlgoKey = (java.lang.String) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.KEY_ALGO_VISUALIZATION_KEY);
            this.mFullAlgoValue = (java.lang.String) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.KEY_ALGO_VISUALIZATION_VALUE);
            this.mAsdSceneValue = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_AI_SCENE)).intValue();
            this.mMFSRFrameCount = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_MFSR_FRAME_COUNT)).intValue();
            this.mSupportCaptureZoomFeature = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_SUPPORT_ZOOM_FEATURE)).intValue();
            this.mbAIShutter = ((java.lang.Boolean) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_AI_SHUTTER)).booleanValue();
            this.mAISState = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_AIS_STATE)).intValue();
            this.mThumbnailIndex = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_THUMBNAIL_INDEX)).intValue();
            this.mMetaIndex = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_META_INDEX)).intValue();
        }
    }

    public java.lang.String toString() {
        return "mCameraId: " + this.mCameraId + ", mRequestFormat: " + this.mRequestFormat + ", mMultiFrameCount: " + this.mMultiFrameCount + ", mSuperNightScene: " + this.mSuperNightScene + ", mNightTotalExpTime: " + this.mNightTotalExpTime + ", mApsDecisionSceneMode: " + this.mApsDecisionSceneMode + ", mApsDecisionFeatureType: " + this.mApsDecisionFeatureType + ", mApsAlgoFlag: " + java.util.Arrays.toString(this.mApsAlgoFlag) + ", mCaptureEVList: " + java.util.Arrays.toString(this.mCaptureEVList) + ", mSensorMask: " + java.util.Arrays.toString(this.mSensorMask) + ", mMasterPipeline: " + this.mMasterPipeline + ", mMFSRFrameCount: " + this.mMFSRFrameCount + ", mApsBracketMode: " + this.mApsBracketMode + ", mSupportCaptureZoomFeature: " + this.mSupportCaptureZoomFeature + ", mCaptureNoNeedMatchMeta: " + this.mCaptureNoNeedMatchMeta + ", mAsdSceneValue: " + this.mAsdSceneValue + ", mbAIShutter: " + this.mbAIShutter + ", mThumbnailIndex: " + this.mThumbnailIndex + ", mMetaIndex: " + this.mMetaIndex;
    }
}
