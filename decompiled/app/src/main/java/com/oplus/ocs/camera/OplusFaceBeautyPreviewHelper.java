package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class OplusFaceBeautyPreviewHelper {
    private com.oplus.camera.facebeauty.OplusFaceBeautyPreview mOplusFaceBeautyPreview = new com.oplus.camera.facebeauty.OplusFaceBeautyPreview();

    public int init(int i_renamed, int i2, int i3, int i4, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed, boolean z2, byte[] bArr, int i5) {
        return this.mOplusFaceBeautyPreview.init(i_renamed, i2, i3, i4, str, str2, str3, z_renamed, z2, bArr, i5);
    }

    public int updataMetaParams(byte[] bArr) {
        return this.mOplusFaceBeautyPreview.updataMetaParams(bArr);
    }

    public int updataPreviewParams(long j_renamed) {
        return this.mOplusFaceBeautyPreview.updataPreviewParams(j_renamed);
    }

    public int process(int i_renamed, int[] iArr, int[] iArr2, int[] iArr3) {
        return this.mOplusFaceBeautyPreview.process(i_renamed, iArr, iArr2, iArr3);
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

    public int setPreviewParams(java.lang.String str, java.lang.String str2) {
        return this.mOplusFaceBeautyPreview.setPreviewParams(str, str2);
    }

    public int updataFfd(byte[] bArr) {
        return this.mOplusFaceBeautyPreview.updataFfd(bArr);
    }
}
