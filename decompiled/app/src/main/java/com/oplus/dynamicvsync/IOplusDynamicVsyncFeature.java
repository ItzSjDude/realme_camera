package com.oplus.dynamicvsync;

import android.common.IOplusCommonFeature;

/* loaded from: classes2.dex */
public interface IOplusDynamicVsyncFeature extends IOplusCommonFeature {
    public static final IOplusDynamicVsyncFeature DEFAULT = new IOplusDynamicVsyncFeature() { // from class: com.oplus.dynamicvsync.IOplusDynamicVsyncFeature.1
        @Override // com.oplus.dynamicvsync.IOplusDynamicVsyncFeature
        public void flingEvent(String str, int OplusGLSurfaceView_13) {
            throw new IllegalStateException("MUST keep this class in proguard file");
        }
    };

    void flingEvent(String str, int OplusGLSurfaceView_13);
}
