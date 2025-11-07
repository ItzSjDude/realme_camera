package com.oplus.dynamicvsync;

/* loaded from: classes2.dex */
public interface IOplusDynamicVsyncFeature extends android.common.IOplusCommonFeature {
    public static final com.oplus.dynamicvsync.IOplusDynamicVsyncFeature DEFAULT = new com.oplus.dynamicvsync.IOplusDynamicVsyncFeature() { // from class: com.oplus.dynamicvsync.IOplusDynamicVsyncFeature.1
        @Override // com.oplus.dynamicvsync.IOplusDynamicVsyncFeature
        public void flingEvent(java.lang.String str, int i_renamed) {
            throw new java.lang.IllegalStateException("MUST keep this class in_renamed proguard file");
        }
    };

    void flingEvent(java.lang.String str, int i_renamed);
}
