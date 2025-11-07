package com.oplus.camera.aps.util;

import android.util.ArrayMap;
import android.util.Size;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil;
import com.oplus.ocs.camera.appinterface.adapter.CameraUnitAlgoSwitchConfig;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class AlgoSwitchConfig {
    public static final int APS_MODE_CAPTURE = 2;
    public static final int APS_MODE_FULL = 1;
    public static final int APS_MODE_NONE = 0;
    public static final int APS_MODE_PREVIEW = 3;
    public static final String APS_PIPELINE_ASD = "asd";
    public static final String APS_PIPELINE_PREVIEW = "preview";
    public static final String APS_PIPELINE_VIDEO = "video";
    public static final int APS_VERSION_2 = 2;
    public static final int APS_VERSION_3 = 3;

    public static boolean getSupportCaptureAlgo(String str, int OplusGLSurfaceView_13, String str2) {
        return CameraUnitAlgoSwitchConfig.getSupportCaptureAlgo(str, OplusGLSurfaceView_13, str2);
    }

    public static boolean getSupportCameraFeature(String str, int OplusGLSurfaceView_13) {
        return CameraUnitAlgoSwitchConfig.getSupportCameraFeature(str, OplusGLSurfaceView_13);
    }

    public static boolean getSupportPreviewAlgo(String str, int OplusGLSurfaceView_13, String str2, String str3) {
        return CameraUnitAlgoSwitchConfig.getSupportPreviewAlgo(str, OplusGLSurfaceView_13, str2, str3);
    }

    public static int getApsVersion() {
        return CameraUnitAlgoSwitchConfig.getApsVersion();
    }

    public static boolean getSupportApsCapture() {
        return CameraUnitAlgoSwitchConfig.getSupportApsCapture();
    }

    public static boolean getSupportApsPreview() {
        return CameraUnitAlgoSwitchConfig.getSupportApsPreview();
    }

    public static CaptureConfig getCaptureConfig(String str, int OplusGLSurfaceView_13) {
        return new CaptureConfig(CameraUnitAlgoSwitchConfig.getCaptureConfig(str, OplusGLSurfaceView_13));
    }

    public static PreviewConfig getPreviewConfig(String str, int OplusGLSurfaceView_13) {
        return new PreviewConfig(CameraUnitAlgoSwitchConfig.getPreviewConfig(str, OplusGLSurfaceView_13));
    }

    public static PreviewConfig getPreviewConfig(String str, int OplusGLSurfaceView_13, Size size, Size size2, boolean z, boolean z2, boolean z3) {
        return new PreviewConfig(CameraUnitAlgoSwitchConfig.getPreviewConfig(str, OplusGLSurfaceView_13, size, size2, z, z2, z3));
    }

    public static class CaptureConfig {
        public Set<String> mAlgos = new HashSet();
        public int mCameraId;
        public String mCameraMode;
        public boolean mbEnable;

        CaptureConfig(AlgoSwitchConfigUtil.CaptureConfig captureConfig) {
            this.mCameraMode = null;
            this.mCameraId = -1;
            this.mbEnable = true;
            this.mCameraMode = (String) captureConfig.get(CameraUnitKeys.KEY_CAPTURE_CONFIG_CAMERA_MODE);
            this.mCameraId = ((Integer) captureConfig.get(CameraUnitKeys.KEY_CAPTURE_CONFIG_CAMERA_ID)).intValue();
            this.mbEnable = ((Boolean) captureConfig.get(CameraUnitKeys.KEY_CAPTURE_CONFIG_ENABLE)).booleanValue();
            this.mAlgos.addAll((Collection) captureConfig.get(CameraUnitKeys.KEY_CAPTURE_CONFIG_ALGO));
        }

        public String toString() {
            return "mCameraMode: " + this.mCameraMode + ", mCameraId: " + this.mCameraId + ", mbEnable: " + this.mbEnable + ", mAlgos: " + this.mAlgos;
        }
    }

    public static class PreviewConfig {
        public int mCameraId;
        public String mCameraMode;
        public int mCameraNum;
        public ArrayMap<String, Component> mComponentMap = new ArrayMap<>();
        public int mIsSeparateStreamForPrevAndVideo;

        PreviewConfig(AlgoSwitchConfigUtil.PreviewConfig previewConfig) {
            this.mCameraMode = null;
            this.mCameraId = -1;
            this.mCameraNum = -1;
            this.mIsSeparateStreamForPrevAndVideo = 0;
            this.mCameraMode = (String) previewConfig.get(CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_MODE);
            this.mCameraId = ((Integer) previewConfig.get(CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_ID)).intValue();
            this.mCameraNum = ((Integer) previewConfig.get(CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_NUM)).intValue();
            this.mIsSeparateStreamForPrevAndVideo = ((Integer) previewConfig.get(CameraUnitKeys.KEY_PREVIEW_CONFIG_CAMERA_PREV_VIDEO)).intValue();
            ArrayMap<String, AlgoSwitchConfigUtil.Component> componentMap = previewConfig.getComponentMap();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < componentMap.size(); OplusGLSurfaceView_13++) {
                this.mComponentMap.put(componentMap.keyAt(OplusGLSurfaceView_13), new Component(componentMap.valueAt(OplusGLSurfaceView_13)));
            }
        }

        public String toString() {
            return "mCameraMode: " + this.mCameraMode + ", mCameraId: " + this.mCameraId + ", mCameraNum: " + this.mCameraNum + ", mIsSeparateStreamForPrevAndVideo: " + this.mIsSeparateStreamForPrevAndVideo + ", mComponentMap: " + this.mComponentMap;
        }

        public static class Component {
            public String[] mAlgoList;
            public String mAlgoNodeCopyFrom;
            public int mFrameSkipCnt;
            public int mMasterInputHeight;
            public int mMasterInputWidth;
            public int mOutputHeight;
            public int mOutputWidth;
            public String mPipelineCopyFrom;
            public int mSlaveInputHeight;
            public int mSlaveInputWidth;
            public int mThirdInputHeight;
            public int mThirdInputWidth;
            public boolean mbEnable;

            public Component(AlgoSwitchConfigUtil.Component component) {
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
                this.mbEnable = ((Boolean) component.get(CameraUnitKeys.KEY_COMPONENT_ENABLE)).booleanValue();
                this.mMasterInputWidth = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_MASTER_INPUT_WIDTH)).intValue();
                this.mMasterInputHeight = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_MASTER_INPUT_HEIGHT)).intValue();
                this.mSlaveInputWidth = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_SLAVE_INPUT_WIDTH)).intValue();
                this.mSlaveInputHeight = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_SLAVE_INPUT_HEIGHT)).intValue();
                this.mThirdInputWidth = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_THIRD_INPUT_WIDTH)).intValue();
                this.mThirdInputHeight = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_THIRD_INPUT_HEIGHT)).intValue();
                this.mOutputWidth = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_OUTPUT_WIDTH)).intValue();
                this.mOutputHeight = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_OUTPUT_HEIGHT)).intValue();
                this.mFrameSkipCnt = ((Integer) component.get(CameraUnitKeys.KEY_COMPONENT_FRAME_SKIP_CNT)).intValue();
                this.mPipelineCopyFrom = (String) component.get(CameraUnitKeys.KEY_COMPONENT_PIPELINE_COPY_FROM);
                this.mAlgoNodeCopyFrom = (String) component.get(CameraUnitKeys.KEY_COMPONENT_ALGO_NODE_COPY_FROM);
                this.mAlgoList = (String[]) component.get(CameraUnitKeys.KEY_COMPONENT_ALGO_LIST);
            }
        }
    }
}
