package com.oplus.ocs.camera.appinterface.adapter;

/* loaded from: classes2.dex */
public class AlgoSwitchConfigUtil {

    public static class PreviewConfig {
        private android.util.ArrayMap<java.lang.String, com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.Component> mComponentMap = new android.util.ArrayMap<>();
        com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil.PreviewConfig mPreviewConfig;

        /* JADX WARN: Multi-variable type inference failed */
        public PreviewConfig(com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil.PreviewConfig previewConfig) {
            this.mPreviewConfig = null;
            this.mPreviewConfig = previewConfig;
            android.util.ArrayMap comonentMap = previewConfig.getComonentMap();
            for (int i_renamed = 0; i_renamed < comonentMap.size(); i_renamed++) {
                this.mComponentMap.put(comonentMap.keyAt(i_renamed), new com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.Component((com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil.Component) comonentMap.valueAt(i_renamed)));
            }
        }

        public <T_renamed> T_renamed get(com.oplus.ocs.camera.appinterface.adapter.CameraResultParameter.CameraAlgoSwitchConfigKey<T_renamed> cameraAlgoSwitchConfigKey) {
            return (T_renamed) this.mPreviewConfig.get(cameraAlgoSwitchConfigKey.getKeyName(), cameraAlgoSwitchConfigKey.getType(), cameraAlgoSwitchConfigKey.getDefault());
        }

        public android.util.ArrayMap<java.lang.String, com.oplus.ocs.camera.appinterface.adapter.AlgoSwitchConfigUtil.Component> getComponentMap() {
            return this.mComponentMap;
        }
    }

    public static class CaptureConfig {
        com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil.CaptureConfig mCaptureConfig;

        public CaptureConfig(com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil.CaptureConfig captureConfig) {
            this.mCaptureConfig = null;
            this.mCaptureConfig = captureConfig;
        }

        public <T_renamed> T_renamed get(com.oplus.ocs.camera.appinterface.adapter.CameraResultParameter.CameraAlgoSwitchConfigKey<T_renamed> cameraAlgoSwitchConfigKey) {
            return (T_renamed) this.mCaptureConfig.get(cameraAlgoSwitchConfigKey.getKeyName(), cameraAlgoSwitchConfigKey.getType(), cameraAlgoSwitchConfigKey.getDefault());
        }
    }

    public static class Component {
        private com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil.Component mComponent;

        Component(com.oplus.ocs.camera.appinterface.adapter.CameraAlgoSwitchConfigUtil.Component component) {
            this.mComponent = null;
            this.mComponent = component;
        }

        public <T_renamed> T_renamed get(com.oplus.ocs.camera.appinterface.adapter.CameraResultParameter.CameraAlgoSwitchConfigKey<T_renamed> cameraAlgoSwitchConfigKey) {
            return (T_renamed) this.mComponent.get(cameraAlgoSwitchConfigKey.getKeyName(), cameraAlgoSwitchConfigKey.getType());
        }
    }
}
