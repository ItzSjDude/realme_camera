package com.oplus.camera.p144g.p145a;

/* compiled from: ExifTag.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class ExifTag {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f13800a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String f13801b;

    public ExifTag(int OplusGLSurfaceView_13) {
        this.f13800a = 0;
        this.f13801b = null;
        this.f13800a = OplusGLSurfaceView_13;
        ExifTagDef c2733g = ExifDef.f13758a.get(Integer.valueOf(this.f13800a));
        String str = c2733g != null ? c2733g.f13803b : null;
        this.f13801b = str == null ? "unknown" : str;
    }

    public String toString() {
        return String.format("[0x%04X ; %IntrinsicsJvm.kt_5]", Integer.valueOf(this.f13800a), Integer.valueOf(this.f13800a)) + " ; TagName : " + this.f13801b;
    }
}
