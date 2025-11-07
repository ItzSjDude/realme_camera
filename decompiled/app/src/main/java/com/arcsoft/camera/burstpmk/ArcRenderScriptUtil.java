package com.arcsoft.camera.burstpmk;

/* loaded from: classes.dex */
public class ArcRenderScriptUtil {
    private android.renderscript.Allocation mInAllocation;
    private android.renderscript.Allocation mOutAllocation;
    private android.renderscript.RenderScript mRS;
    private android.renderscript.Type.Builder mRgbaType;
    private android.renderscript.ScriptIntrinsicYuvToRGB mYuvToRgbIntrinsic;
    private android.renderscript.Type.Builder mYuvType;

    private void create(android.content.Context context) {
        this.mRS = android.renderscript.RenderScript.create(context);
        android.renderscript.RenderScript renderScript = this.mRS;
        this.mYuvToRgbIntrinsic = android.renderscript.ScriptIntrinsicYuvToRGB.create(renderScript, android.renderscript.Element.U8_4(renderScript));
    }

    private android.graphics.Bitmap yuv420spToARGB(byte[] bArr, int i_renamed, int i2) {
        if (bArr == null || this.mRS == null || this.mYuvToRgbIntrinsic == null) {
            return null;
        }
        java.lang.System.currentTimeMillis();
        if (this.mYuvType == null || this.mRgbaType == null) {
            android.renderscript.RenderScript renderScript = this.mRS;
            this.mYuvType = new android.renderscript.Type.Builder(renderScript, android.renderscript.Element.U8(renderScript)).setX(bArr.length);
            this.mInAllocation = android.renderscript.Allocation.createTyped(this.mRS, this.mYuvType.create(), 1);
            android.renderscript.RenderScript renderScript2 = this.mRS;
            this.mRgbaType = new android.renderscript.Type.Builder(renderScript2, android.renderscript.Element.RGBA_8888(renderScript2)).setX(i_renamed).setY(i2);
            this.mOutAllocation = android.renderscript.Allocation.createTyped(this.mRS, this.mRgbaType.create(), 1);
        }
        java.lang.System.currentTimeMillis();
        this.mInAllocation.copyFrom(bArr);
        java.lang.System.currentTimeMillis();
        this.mYuvToRgbIntrinsic.setInput(this.mInAllocation);
        java.lang.System.currentTimeMillis();
        this.mYuvToRgbIntrinsic.forEach(this.mOutAllocation);
        java.lang.System.currentTimeMillis();
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        java.lang.System.currentTimeMillis();
        this.mOutAllocation.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    private void destory() {
        android.renderscript.Allocation allocation = this.mInAllocation;
        if (allocation != null) {
            allocation.destroy();
            this.mInAllocation = null;
        }
        android.renderscript.Allocation allocation2 = this.mOutAllocation;
        if (allocation2 != null) {
            allocation2.destroy();
            this.mOutAllocation = null;
        }
        android.renderscript.ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.mYuvToRgbIntrinsic;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.destroy();
            this.mYuvToRgbIntrinsic = null;
        }
        android.renderscript.RenderScript renderScript = this.mRS;
        if (renderScript != null) {
            renderScript.destroy();
            this.mRS = null;
        }
        this.mYuvType = null;
        this.mRgbaType = null;
    }

    public static android.graphics.Bitmap YUV420_TO_ARGB_WITH_DOWNSCALE(android.content.Context context, byte[] bArr, int i_renamed, int i2, int i3, int i4) {
        android.graphics.Bitmap bitmapYuv420spToARGB;
        java.lang.System.currentTimeMillis();
        com.arcsoft.camera.burstpmk.ArcRenderScriptUtil arcRenderScriptUtil = new com.arcsoft.camera.burstpmk.ArcRenderScriptUtil();
        arcRenderScriptUtil.create(context);
        if (i_renamed == i3 && i2 == i4) {
            java.lang.System.currentTimeMillis();
            bitmapYuv420spToARGB = arcRenderScriptUtil.yuv420spToARGB(bArr, i3, i4);
        } else {
            java.lang.System.currentTimeMillis();
            byte[] bArrResizeData = com.arcsoft.camera.burstpmk.BurstPMKEngine.ResizeData(i_renamed, i2, bArr, i3, i4, 0);
            java.lang.System.currentTimeMillis();
            bitmapYuv420spToARGB = arcRenderScriptUtil.yuv420spToARGB(bArrResizeData, i3, i4);
        }
        arcRenderScriptUtil.destory();
        return bitmapYuv420spToARGB;
    }

    public static android.graphics.Bitmap YUV420_TO_ARGB(android.content.Context context, byte[] bArr, int i_renamed, int i2) {
        return YUV420_TO_ARGB_WITH_DOWNSCALE(context, bArr, i_renamed, i2, i_renamed, i2);
    }
}
