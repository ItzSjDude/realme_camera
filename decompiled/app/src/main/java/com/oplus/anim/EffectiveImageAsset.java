package com.oplus.anim;

import android.graphics.Bitmap;

/* compiled from: EffectiveImageAsset.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class EffectiveImageAsset {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f10437a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f10438b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f10439c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f10440d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f10441e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Bitmap f10442f;

    public EffectiveImageAsset(int OplusGLSurfaceView_13, int i2, String str, String str2, String str3) {
        this.f10437a = OplusGLSurfaceView_13;
        this.f10438b = i2;
        this.f10439c = str;
        this.f10440d = str2;
        this.f10441e = str3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9340a() {
        return this.f10439c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m9342b() {
        return this.f10440d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Bitmap m9343c() {
        return this.f10442f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9341a(Bitmap bitmap) {
        Bitmap bitmap2 = this.f10442f;
        if (bitmap2 != null && bitmap == null) {
            bitmap2.recycle();
        }
        this.f10442f = bitmap;
    }
}
