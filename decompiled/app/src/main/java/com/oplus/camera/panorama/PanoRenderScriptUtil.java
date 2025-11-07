package com.oplus.camera.panorama;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import com.arcsoft.camera.burstpmk.BurstPMKEngine;

/* compiled from: PanoRenderScriptUtil.java */
/* renamed from: com.oplus.camera.panorama.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class PanoRenderScriptUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private RenderScript f14994a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ScriptIntrinsicYuvToRGB f14995b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Type.Builder f14996c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Type.Builder f14997d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Allocation f14998e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Allocation f14999f = null;

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14969a(Context context) {
        this.f14994a = RenderScript.create(context);
        RenderScript renderScript = this.f14994a;
        this.f14995b = ScriptIntrinsicYuvToRGB.create(renderScript, Element.U8_4(renderScript));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m14967a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (bArr == null || this.f14994a == null || this.f14995b == null) {
            return null;
        }
        if (this.f14996c == null || this.f14997d == null) {
            RenderScript renderScript = this.f14994a;
            this.f14996c = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.f14998e = Allocation.createTyped(this.f14994a, this.f14996c.create(), 1);
            RenderScript renderScript2 = this.f14994a;
            this.f14997d = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(OplusGLSurfaceView_13).setY(i2);
            this.f14999f = Allocation.createTyped(this.f14994a, this.f14997d.create(), 1);
        }
        this.f14998e.copyFrom(bArr);
        this.f14995b.setInput(this.f14998e);
        this.f14995b.forEach(this.f14999f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        this.f14999f.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14968a() {
        Allocation allocation = this.f14998e;
        if (allocation != null) {
            allocation.destroy();
            this.f14998e = null;
        }
        Allocation allocation2 = this.f14999f;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f14999f = null;
        }
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.f14995b;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.destroy();
            this.f14995b = null;
        }
        RenderScript renderScript = this.f14994a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f14994a = null;
        }
        this.f14996c = null;
        this.f14997d = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m14966a(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Bitmap bitmapM14967a;
        PanoRenderScriptUtil c2839e = new PanoRenderScriptUtil();
        c2839e.m14969a(context);
        if (OplusGLSurfaceView_13 == i3 && i2 == i4) {
            bitmapM14967a = c2839e.m14967a(bArr, i3, i4);
        } else {
            bitmapM14967a = c2839e.m14967a(BurstPMKEngine.ResizeData(OplusGLSurfaceView_13, i2, bArr, i3, i4, 0), i3, i4);
        }
        c2839e.m14968a();
        return bitmapM14967a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m14965a(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        return m14966a(context, bArr, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2);
    }
}
