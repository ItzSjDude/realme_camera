package com.oplus.ocs.camera.appinterface.adapter;

import android.util.ArrayMap;
import com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil;
import com.oplus.ocs.camera.appinterface.adapter.CameraResultParameter;

/* loaded from: classes2.dex */
public class AlgoSwitchConfigUtil {

    public static class PreviewConfig {
        private ArrayMap<String, Component> mComponentMap = new ArrayMap<>();
        CameraAlgoSwitchConfigUtil.PreviewConfig mPreviewConfig;

        /* JADX WARN: Multi-variable type inference failed */
        public PreviewConfig(CameraAlgoSwitchConfigUtil.PreviewConfig previewConfig) {
            this.mPreviewConfig = null;
            this.mPreviewConfig = previewConfig;
            ArrayMap comonentMap = previewConfig.getComonentMap();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < comonentMap.size(); OplusGLSurfaceView_13++) {
                this.mComponentMap.put(comonentMap.keyAt(OplusGLSurfaceView_13), new Component((CameraAlgoSwitchConfigUtil.Component) comonentMap.valueAt(OplusGLSurfaceView_13)));
            }
        }

        public <T> T get(CameraResultParameter.CameraAlgoSwitchConfigKey<T> cameraAlgoSwitchConfigKey) {
            return (T) this.mPreviewConfig.get(cameraAlgoSwitchConfigKey.getKeyName(), cameraAlgoSwitchConfigKey.getType(), cameraAlgoSwitchConfigKey.getDefault());
        }

        public ArrayMap<String, Component> getComponentMap() {
            return this.mComponentMap;
        }
    }

    public static class CaptureConfig {
        CameraAlgoSwitchConfigUtil.CaptureConfig mCaptureConfig;

        public CaptureConfig(CameraAlgoSwitchConfigUtil.CaptureConfig captureConfig) {
            this.mCaptureConfig = null;
            this.mCaptureConfig = captureConfig;
        }

        public <T> T get(CameraResultParameter.CameraAlgoSwitchConfigKey<T> cameraAlgoSwitchConfigKey) {
            return (T) this.mCaptureConfig.get(cameraAlgoSwitchConfigKey.getKeyName(), cameraAlgoSwitchConfigKey.getType(), cameraAlgoSwitchConfigKey.getDefault());
        }
    }

    public static class Component {
        private CameraAlgoSwitchConfigUtil.Component mComponent;

        Component(CameraAlgoSwitchConfigUtil.Component component) {
            this.mComponent = null;
            this.mComponent = component;
        }

        public <T> T get(CameraResultParameter.CameraAlgoSwitchConfigKey<T> cameraAlgoSwitchConfigKey) {
            return (T) this.mComponent.get(cameraAlgoSwitchConfigKey.getKeyName(), cameraAlgoSwitchConfigKey.getType());
        }
    }
}
