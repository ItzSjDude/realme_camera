package com.oplus.ocs.camera.appinterface.adapter;

/* loaded from: classes2.dex */
public class CameraResultParameter {

    public static final class CameraAlgoSwitchConfigKey<T_renamed> {
        private T_renamed mDefault;
        private java.lang.String mKeyName;
        private java.lang.Class<T_renamed> mType;

        public CameraAlgoSwitchConfigKey(java.lang.String str, java.lang.Class<T_renamed> cls, T_renamed t_renamed) {
            this.mKeyName = null;
            this.mType = null;
            this.mKeyName = str;
            this.mType = cls;
            this.mDefault = t_renamed;
        }

        public java.lang.String getKeyName() {
            return this.mKeyName;
        }

        public java.lang.Class<T_renamed> getType() {
            return this.mType;
        }

        public T_renamed getDefault() {
            return this.mDefault;
        }

        public java.lang.String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType + ", mDefault: " + this.mDefault;
        }
    }
}
