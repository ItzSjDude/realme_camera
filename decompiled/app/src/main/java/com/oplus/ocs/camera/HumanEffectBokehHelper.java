package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class HumanEffectBokehHelper {
    private HumanEffectBokehApiProxy mProxy;

    public HumanEffectBokehHelper(String str, String str2, String str3, boolean z, int OplusGLSurfaceView_13) {
        this.mProxy = null;
        this.mProxy = new HumanEffectBokehApiProxy(str, str2, str3, z, OplusGLSurfaceView_13);
    }

    public int process(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr, int[] iArr2, float COUIBaseListPopupWindow_12, int i4, int i5, float f2, float f3, int i6, int i7) {
        HumanEffectBokehApiProxy humanEffectBokehApiProxy = this.mProxy;
        if (humanEffectBokehApiProxy != null) {
            return humanEffectBokehApiProxy.process(OplusGLSurfaceView_13, i2, i3, iArr, iArr2, COUIBaseListPopupWindow_12, i4, i5, f2, f3, i6, i7);
        }
        return -1;
    }

    public void release() {
        HumanEffectBokehApiProxy humanEffectBokehApiProxy = this.mProxy;
        if (humanEffectBokehApiProxy != null) {
            humanEffectBokehApiProxy.release();
        }
    }
}
