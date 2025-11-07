package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class HumanEffectBokehHelper {
    private com.oplus.ocs.camera.HumanEffectBokehApiProxy mProxy;

    public HumanEffectBokehHelper(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed, int i_renamed) {
        this.mProxy = null;
        this.mProxy = new com.oplus.ocs.camera.HumanEffectBokehApiProxy(str, str2, str3, z_renamed, i_renamed);
    }

    public int process(int i_renamed, int i2, int i3, int[] iArr, int[] iArr2, float f_renamed, int i4, int i5, float f2, float f3, int i6, int i7) {
        com.oplus.ocs.camera.HumanEffectBokehApiProxy humanEffectBokehApiProxy = this.mProxy;
        if (humanEffectBokehApiProxy != null) {
            return humanEffectBokehApiProxy.process(i_renamed, i2, i3, iArr, iArr2, f_renamed, i4, i5, f2, f3, i6, i7);
        }
        return -1;
    }

    public void release() {
        com.oplus.ocs.camera.HumanEffectBokehApiProxy humanEffectBokehApiProxy = this.mProxy;
        if (humanEffectBokehApiProxy != null) {
            humanEffectBokehApiProxy.release();
        }
    }
}
