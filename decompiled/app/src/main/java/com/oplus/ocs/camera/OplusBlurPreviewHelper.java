package com.oplus.ocs.camera;

import com.oplus.blur.OplusBlurPreview;

/* loaded from: classes2.dex */
public class OplusBlurPreviewHelper {
    private static OplusBlurPreviewHelper mInstance;

    private OplusBlurPreviewHelper() {
    }

    public static OplusBlurPreviewHelper getInstance() {
        if (mInstance == null) {
            synchronized (OplusBlurPreviewHelper.class) {
                if (mInstance == null) {
                    mInstance = new OplusBlurPreviewHelper();
                }
            }
        }
        return mInstance;
    }

    public long bokehPreviewInit(int OplusGLSurfaceView_13, int i2) {
        return OplusBlurPreview.getInstance().bokehPreviewInit(OplusGLSurfaceView_13, i2);
    }

    public int bokehPreviewProcess(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr) {
        return OplusBlurPreview.getInstance().bokehPreviewProcess(OplusGLSurfaceView_13, i2, i3, i4, iArr);
    }

    public int bokehPreviewGetMaskTexture(byte[] bArr, int[] iArr, boolean z) {
        return OplusBlurPreview.getInstance().bokehPreviewGetMaskTexture(bArr, iArr, z);
    }

    public String bokehPreviewGetVersion() {
        return OplusBlurPreview.getInstance().bokehPreviewGetVersion();
    }

    public int bokehPreviewSetParam(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return OplusBlurPreview.getInstance().bokehPreviewSetParam(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    public int bokehPreviewTextureCopy(int OplusGLSurfaceView_13, int[] iArr, boolean z) {
        return OplusBlurPreview.getInstance().bokehPreviewTextureCopy(OplusGLSurfaceView_13, iArr, z);
    }

    public int bokehPreviewTextureResize(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z) {
        return OplusBlurPreview.getInstance().bokehPreviewTextureResize(OplusGLSurfaceView_13, i2, i3, i4, z);
    }

    public int bokehPreviewSetDebug(boolean z) {
        return OplusBlurPreview.getInstance().bokehPreviewSetDebug(z);
    }

    public int bokehPreviewDestory() {
        return OplusBlurPreview.getInstance().bokehPreviewDestory();
    }

    public String segGetVersion() {
        return OplusBlurPreview.getInstance().segGetVersion();
    }

    public int[] segInit(String str, String str2, String str3, String str4, int OplusGLSurfaceView_13, int i2) {
        return OplusBlurPreview.getInstance().segInit(str, str2, str3, str4, OplusGLSurfaceView_13, i2);
    }

    public int segExecute(byte[] bArr, byte[] bArr2, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        return OplusBlurPreview.getInstance().segExecute(bArr, bArr2, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr, iArr2, iArr3, iArr4, iArr5);
    }

    public int segUnInit() {
        return OplusBlurPreview.getInstance().segUnInit();
    }

    public int segLogLevel(int OplusGLSurfaceView_13) {
        return OplusBlurPreview.getInstance().segLogLevel(OplusGLSurfaceView_13);
    }
}
