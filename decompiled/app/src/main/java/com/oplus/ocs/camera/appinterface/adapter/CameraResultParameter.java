package com.oplus.ocs.camera.appinterface.adapter;

/* loaded from: classes2.dex */
public class CameraResultParameter {

    public static final class CameraAlgoSwitchConfigKey<T> {
        private T mDefault;
        private String mKeyName;
        private Class<T> mType;

        public CameraAlgoSwitchConfigKey(String str, Class<T> cls, T t) {
            this.mKeyName = null;
            this.mType = null;
            this.mKeyName = str;
            this.mType = cls;
            this.mDefault = t;
        }

        public String getKeyName() {
            return this.mKeyName;
        }

        public Class<T> getType() {
            return this.mType;
        }

        public T getDefault() {
            return this.mDefault;
        }

        public String toString() {
            return "mKeyName: " + this.mKeyName + ", mType: " + this.mType + ", mDefault: " + this.mDefault;
        }
    }
}
