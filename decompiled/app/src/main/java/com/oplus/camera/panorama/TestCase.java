package com.oplus.camera.panorama;

/* compiled from: PanoRenderScriptUtil.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.renderscript.RenderScript f4945a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.renderscript.ScriptIntrinsicYuvToRGB f4946b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.renderscript.Type.Builder f4947c = null;
    private android.renderscript.Type.Builder d_renamed = null;
    private android.renderscript.Allocation e_renamed = null;
    private android.renderscript.Allocation f_renamed = null;

    private void a_renamed(android.content.Context context) {
        this.f4945a = android.renderscript.RenderScript.create(context);
        android.renderscript.RenderScript renderScript = this.f4945a;
        this.f4946b = android.renderscript.ScriptIntrinsicYuvToRGB.create(renderScript, android.renderscript.Element.U8_4(renderScript));
    }

    private android.graphics.Bitmap a_renamed(byte[] bArr, int i_renamed, int i2) {
        if (bArr == null || this.f4945a == null || this.f4946b == null) {
            return null;
        }
        if (this.f4947c == null || this.d_renamed == null) {
            android.renderscript.RenderScript renderScript = this.f4945a;
            this.f4947c = new android.renderscript.Type.Builder(renderScript, android.renderscript.Element.U8(renderScript)).setX(bArr.length);
            this.e_renamed = android.renderscript.Allocation.createTyped(this.f4945a, this.f4947c.create(), 1);
            android.renderscript.RenderScript renderScript2 = this.f4945a;
            this.d_renamed = new android.renderscript.Type.Builder(renderScript2, android.renderscript.Element.RGBA_8888(renderScript2)).setX(i_renamed).setY(i2);
            this.f_renamed = android.renderscript.Allocation.createTyped(this.f4945a, this.d_renamed.create(), 1);
        }
        this.e_renamed.copyFrom(bArr);
        this.f4946b.setInput(this.e_renamed);
        this.f4946b.forEach(this.f_renamed);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        this.f_renamed.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    private void a_renamed() {
        android.renderscript.Allocation allocation = this.e_renamed;
        if (allocation != null) {
            allocation.destroy();
            this.e_renamed = null;
        }
        android.renderscript.Allocation allocation2 = this.f_renamed;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f_renamed = null;
        }
        android.renderscript.ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.f4946b;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.destroy();
            this.f4946b = null;
        }
        android.renderscript.RenderScript renderScript = this.f4945a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f4945a = null;
        }
        this.f4947c = null;
        this.d_renamed = null;
    }

    public static android.graphics.Bitmap a_renamed(android.content.Context context, byte[] bArr, int i_renamed, int i2, int i3, int i4) {
        android.graphics.Bitmap bitmapA;
        com.oplus.camera.panorama.e_renamed eVar = new com.oplus.camera.panorama.e_renamed();
        eVar.a_renamed(context);
        if (i_renamed == i3 && i2 == i4) {
            bitmapA = eVar.a_renamed(bArr, i3, i4);
        } else {
            bitmapA = eVar.a_renamed(com.arcsoft.camera.burstpmk.BurstPMKEngine.ResizeData(i_renamed, i2, bArr, i3, i4, 0), i3, i4);
        }
        eVar.a_renamed();
        return bitmapA;
    }

    public static android.graphics.Bitmap a_renamed(android.content.Context context, byte[] bArr, int i_renamed, int i2) {
        return a_renamed(context, bArr, i_renamed, i2, i_renamed, i2);
    }
}
