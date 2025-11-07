package com.oplus.camera.aps.util;

/* loaded from: classes2.dex */
public class AlgoSwitchConfig {
    public static final int APS_MODE_CAPTURE = 2;
    public static final int APS_MODE_FULL = 1;
    public static final int APS_MODE_NONE = 0;
    public static final int APS_MODE_PREVIEW = 3;
    public static final java.lang.String APS_PIPELINE_ASD = "asd";
    public static final java.lang.String APS_PIPELINE_PREVIEW = "preview";
    public static final java.lang.String APS_PIPELINE_VIDEO = "video";
    public static final int APS_VERSION_2 = 2;
    public static final int APS_VERSION_3 = 3;

    public static boolean getSupportCaptureAlgo(java.lang.String str, int i_renamed, java.lang.String str2) {
        return com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getSupportCaptureAlgo(str, i_renamed, str2);
    }

    public static boolean getSupportCameraFeature(java.lang.String str, int i_renamed) {
        return com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getSupportCameraFeature(str, i_renamed);
    }

    public static boolean getSupportPreviewAlgo(java.lang.String str, int i_renamed, java.lang.String str2, java.lang.String str3) {
        return com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getSupportPreviewAlgo(str, i_renamed, str2, str3);
    }

    public static int getApsVersion() {
        return com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getApsVersion();
    }

    public static boolean getSupportApsCapture() {
        return com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getSupportApsCapture();
    }

    public static boolean getSupportApsPreview() {
        return com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getSupportApsPreview();
    }

    public static com.oplus.camera.aps.util.AlgoSwitchConfig.CaptureConfig getCaptureConfig(java.lang.String str, int i_renamed) {
        return new com.oplus.camera.aps.util.AlgoSwitchConfig.CaptureConfig(com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getCaptureConfig(str, i_renamed));
    }

    public static com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig getPreviewConfig(java.lang.String str, int i_renamed) {
        return new com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig(com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getPreviewConfig(str, i_renamed));
    }

    public static com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig getPreviewConfig(java.lang.String str, int i_renamed, android.util.Size size, android.util.Size size2, boolean z_renamed, boolean z2, boolean z3) {
        return new com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig(com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig.getPreviewConfig(str, i_renamed, size, size2, z_renamed, z2, z3));
    }

    public static class CaptureConfig {
        public java.util.Set<java.lang.String> mAlgos = new java.util.HashSet();
        public int mCameraId;
        public java.lang.String mCameraMode;
        public boolean mbEnable;

        CaptureConfig(com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.CaptureConfig captureConfig) {
            this.mCameraMode = null;
            this.mCameraId = -1;
            this.mbEnable = true;
            this.mCameraMode = (java.lang.String) captureConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_CAPTURE_CONFIG_CAMERA_MODE);
            this.mCameraId = ((java.lang.Integer) captureConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_CAPTURE_CONFIG_CAMERA_ID)).intValue();
            this.mbEnable = ((java.lang.Boolean) captureConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_CAPTURE_CONFIG_ENABLE)).booleanValue();
            this.mAlgos.addAll((java.util.Collection) captureConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_CAPTURE_CONFIG_ALGO));
        }

        public java.lang.String toString() {
            return "mCameraMode: " + this.mCameraMode + ", mCameraId: " + this.mCameraId + ", mbEnable: " + this.mbEnable + ", mAlgos: " + this.mAlgos;
        }
    }

    public static class PreviewConfig {
        public int mCameraId;
        public java.lang.String mCameraMode;
        public int mCameraNum;
        public android.util.ArrayMap<java.lang.String, com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig.Component> mComponentMap = new android.util.ArrayMap<>();
        public int mIsSeparateStreamForPrevAndVideo;

        PreviewConfig(com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.PreviewConfig previewConfig) {
            this.mCameraMode = null;
            this.mCameraId = -1;
            this.mCameraNum = -1;
            this.mIsSeparateStreamForPrevAndVideo = 0;
            this.mCameraMode = (java.lang.String) previewConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_MODE);
            this.mCameraId = ((java.lang.Integer) previewConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_ID)).intValue();
            this.mCameraNum = ((java.lang.Integer) previewConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_NUM)).intValue();
            this.mIsSeparateStreamForPrevAndVideo = ((java.lang.Integer) previewConfig.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_PREV_VIDEO)).intValue();
            android.util.ArrayMap<java.lang.String, com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.Component> componentMap = previewConfig.getComponentMap();
            for (int i_renamed = 0; i_renamed < componentMap.size(); i_renamed++) {
                this.mComponentMap.put(componentMap.keyAt(i_renamed), new com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig.Component(componentMap.valueAt(i_renamed)));
            }
        }

        public java.lang.String toString() {
            return "mCameraMode: " + this.mCameraMode + ", mCameraId: " + this.mCameraId + ", mCameraNum: " + this.mCameraNum + ", mIsSeparateStreamForPrevAndVideo: " + this.mIsSeparateStreamForPrevAndVideo + ", mComponentMap: " + this.mComponentMap;
        }

        public static class Component {
            public java.lang.String[] mAlgoList;
            public java.lang.String mAlgoNodeCopyFrom;
            public int mFrameSkipCnt;
            public int mMasterInputHeight;
            public int mMasterInputWidth;
            public int mOutputHeight;
            public int mOutputWidth;
            public java.lang.String mPipelineCopyFrom;
            public int mSlaveInputHeight;
            public int mSlaveInputWidth;
            public int mThirdInputHeight;
            public int mThirdInputWidth;
            public boolean mbEnable;

            public Component(com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.Component component) {
                this.mbEnable = true;
                this.mMasterInputWidth = 0;
                this.mMasterInputHeight = 0;
                this.mSlaveInputWidth = 0;
                this.mSlaveInputHeight = 0;
                this.mThirdInputWidth = 0;
                this.mThirdInputHeight = 0;
                this.mOutputWidth = 0;
                this.mOutputHeight = 0;
                this.mFrameSkipCnt = 0;
                this.mPipelineCopyFrom = null;
                this.mAlgoNodeCopyFrom = null;
                this.mAlgoList = null;
                this.mbEnable = ((java.lang.Boolean) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_ENABLE)).booleanValue();
                this.mMasterInputWidth = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_MASTER_INPUT_WIDTH)).intValue();
                this.mMasterInputHeight = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_MASTER_INPUT_HEIGHT)).intValue();
                this.mSlaveInputWidth = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_SLAVE_INPUT_WIDTH)).intValue();
                this.mSlaveInputHeight = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_SLAVE_INPUT_HEIGHT)).intValue();
                this.mThirdInputWidth = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_THIRD_INPUT_WIDTH)).intValue();
                this.mThirdInputHeight = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_THIRD_INPUT_HEIGHT)).intValue();
                this.mOutputWidth = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_OUTPUT_WIDTH)).intValue();
                this.mOutputHeight = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_OUTPUT_HEIGHT)).intValue();
                this.mFrameSkipCnt = ((java.lang.Integer) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_FRAME_SKIP_CNT)).intValue();
                this.mPipelineCopyFrom = (java.lang.String) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_PIPELINE_COPY_FROM);
                this.mAlgoNodeCopyFrom = (java.lang.String) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_ALGO_NODE_COPY_FROM);
                this.mAlgoList = (java.lang.String[]) component.get(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_COMPONENT_ALGO_LIST);
            }
        }
    }
}
