package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class OplusBlurPreviewHelper {
    private static com.oplus.ocs.camera.OplusBlurPreviewHelper mInstance;

    private OplusBlurPreviewHelper() {
    }

    public static com.oplus.ocs.camera.OplusBlurPreviewHelper getInstance() {
        if (mInstance == null) {
            synchronized (com.oplus.ocs.camera.OplusBlurPreviewHelper.class) {
                if (mInstance == null) {
                    mInstance = new com.oplus.ocs.camera.OplusBlurPreviewHelper();
                }
            }
        }
        return mInstance;
    }

    public long bokehPreviewInit(int i_renamed, int i2) {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewInit(i_renamed, i2);
    }

    public int bokehPreviewProcess(int i_renamed, int i2, int i3, int i4, int[] iArr) {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewProcess(i_renamed, i2, i3, i4, iArr);
    }

    public int bokehPreviewGetMaskTexture(byte[] bArr, int[] iArr, boolean z_renamed) {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewGetMaskTexture(bArr, iArr, z_renamed);
    }

    public java.lang.String bokehPreviewGetVersion() {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewGetVersion();
    }

    public int bokehPreviewSetParam(int i_renamed, float f_renamed) {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewSetParam(i_renamed, f_renamed);
    }

    public int bokehPreviewTextureCopy(int i_renamed, int[] iArr, boolean z_renamed) {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewTextureCopy(i_renamed, iArr, z_renamed);
    }

    public int bokehPreviewTextureResize(int i_renamed, int i2, int i3, int i4, boolean z_renamed) {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewTextureResize(i_renamed, i2, i3, i4, z_renamed);
    }

    public int bokehPreviewSetDebug(boolean z_renamed) {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewSetDebug(z_renamed);
    }

    public int bokehPreviewDestory() {
        return com.oplus.blur.OplusBlurPreview.getInstance().bokehPreviewDestory();
    }

    public java.lang.String segGetVersion() {
        return com.oplus.blur.OplusBlurPreview.getInstance().segGetVersion();
    }

    public int[] segInit(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2) {
        return com.oplus.blur.OplusBlurPreview.getInstance().segInit(str, str2, str3, str4, i_renamed, i2);
    }

    public int segExecute(byte[] bArr, byte[] bArr2, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        return com.oplus.blur.OplusBlurPreview.getInstance().segExecute(bArr, bArr2, i_renamed, i2, i3, i4, i5, iArr, iArr2, iArr3, iArr4, iArr5);
    }

    public int segUnInit() {
        return com.oplus.blur.OplusBlurPreview.getInstance().segUnInit();
    }

    public int segLogLevel(int i_renamed) {
        return com.oplus.blur.OplusBlurPreview.getInstance().segLogLevel(i_renamed);
    }
}
