package com.arcsoft.camera.burstpmk;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;

/* loaded from: classes.dex */
public class ArcRenderScriptUtil {
    private Allocation mInAllocation;
    private Allocation mOutAllocation;
    private RenderScript mRS;
    private Type.Builder mRgbaType;
    private ScriptIntrinsicYuvToRGB mYuvToRgbIntrinsic;
    private Type.Builder mYuvType;

    private void create(Context context) {
        this.mRS = RenderScript.create(context);
        RenderScript renderScript = this.mRS;
        this.mYuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(renderScript, Element.U8_4(renderScript));
    }

    private Bitmap yuv420spToARGB(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (bArr == null || this.mRS == null || this.mYuvToRgbIntrinsic == null) {
            return null;
        }
        System.currentTimeMillis();
        if (this.mYuvType == null || this.mRgbaType == null) {
            RenderScript renderScript = this.mRS;
            this.mYuvType = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.mInAllocation = Allocation.createTyped(this.mRS, this.mYuvType.create(), 1);
            RenderScript renderScript2 = this.mRS;
            this.mRgbaType = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(OplusGLSurfaceView_13).setY(i2);
            this.mOutAllocation = Allocation.createTyped(this.mRS, this.mRgbaType.create(), 1);
        }
        System.currentTimeMillis();
        this.mInAllocation.copyFrom(bArr);
        System.currentTimeMillis();
        this.mYuvToRgbIntrinsic.setInput(this.mInAllocation);
        System.currentTimeMillis();
        this.mYuvToRgbIntrinsic.forEach(this.mOutAllocation);
        System.currentTimeMillis();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        System.currentTimeMillis();
        this.mOutAllocation.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    private void destory() {
        Allocation allocation = this.mInAllocation;
        if (allocation != null) {
            allocation.destroy();
            this.mInAllocation = null;
        }
        Allocation allocation2 = this.mOutAllocation;
        if (allocation2 != null) {
            allocation2.destroy();
            this.mOutAllocation = null;
        }
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.mYuvToRgbIntrinsic;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.destroy();
            this.mYuvToRgbIntrinsic = null;
        }
        RenderScript renderScript = this.mRS;
        if (renderScript != null) {
            renderScript.destroy();
            this.mRS = null;
        }
        this.mYuvType = null;
        this.mRgbaType = null;
    }

    public static Bitmap YUV420_TO_ARGB_WITH_DOWNSCALE(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Bitmap bitmapYuv420spToARGB;
        System.currentTimeMillis();
        ArcRenderScriptUtil arcRenderScriptUtil = new ArcRenderScriptUtil();
        arcRenderScriptUtil.create(context);
        if (OplusGLSurfaceView_13 == i3 && i2 == i4) {
            System.currentTimeMillis();
            bitmapYuv420spToARGB = arcRenderScriptUtil.yuv420spToARGB(bArr, i3, i4);
        } else {
            System.currentTimeMillis();
            byte[] bArrResizeData = BurstPMKEngine.ResizeData(OplusGLSurfaceView_13, i2, bArr, i3, i4, 0);
            System.currentTimeMillis();
            bitmapYuv420spToARGB = arcRenderScriptUtil.yuv420spToARGB(bArrResizeData, i3, i4);
        }
        arcRenderScriptUtil.destory();
        return bitmapYuv420spToARGB;
    }

    public static Bitmap YUV420_TO_ARGB(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        return YUV420_TO_ARGB_WITH_DOWNSCALE(context, bArr, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2);
    }
}
