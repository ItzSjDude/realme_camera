package com.oplus.ocs.camera;

import com.oplus.camera.facebeauty.OplusFaceBeautyPreview;

/* loaded from: classes2.dex */
public class OplusFaceBeautyPreviewHelper {
    private OplusFaceBeautyPreview mOplusFaceBeautyPreview = new OplusFaceBeautyPreview();

    public int init(int OplusGLSurfaceView_13, int i2, int i3, int i4, String str, String str2, String str3, boolean z, boolean z2, byte[] bArr, int i5) {
        return this.mOplusFaceBeautyPreview.init(OplusGLSurfaceView_13, i2, i3, i4, str, str2, str3, z, z2, bArr, i5);
    }

    public int updataMetaParams(byte[] bArr) {
        return this.mOplusFaceBeautyPreview.updataMetaParams(bArr);
    }

    public int updataPreviewParams(long OplusGLSurfaceView_15) {
        return this.mOplusFaceBeautyPreview.updataPreviewParams(OplusGLSurfaceView_15);
    }

    public int process(int OplusGLSurfaceView_13, int[] iArr, int[] iArr2, int[] iArr3) {
        return this.mOplusFaceBeautyPreview.process(OplusGLSurfaceView_13, iArr, iArr2, iArr3);
    }

    public int destroy() {
        return this.mOplusFaceBeautyPreview.destroy();
    }

    public int reset() {
        return this.mOplusFaceBeautyPreview.reset();
    }

    public float getZoomScale() {
        return this.mOplusFaceBeautyPreview.getZoomScale();
    }

    public long getTimeStamp() {
        return this.mOplusFaceBeautyPreview.getTimeStamp();
    }

    public int setPreviewParams(String str, String str2) {
        return this.mOplusFaceBeautyPreview.setPreviewParams(str, str2);
    }

    public int updataFfd(byte[] bArr) {
        return this.mOplusFaceBeautyPreview.updataFfd(bArr);
    }
}
