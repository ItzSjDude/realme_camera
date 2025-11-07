package com.oplus.camera.sticker.p168ui;

import android.graphics.drawable.Drawable;

/* compiled from: ImageTagInfo.java */
/* renamed from: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ImageTagInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    private GridItemViewTag f16347a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable f16348b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f16349c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f16350d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f16351e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f16352f = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public GridItemViewTag m17058a() {
        return this.f16347a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17060a(GridItemViewTag c3009b) {
        this.f16347a = c3009b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Drawable m17063b() {
        return this.f16348b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m17065c() {
        return this.f16349c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17061a(String str) {
        this.f16349c = str;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m17066d() {
        return this.f16350d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17062a(boolean z) {
        this.f16350d = z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m17067e() {
        return this.f16351e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17064b(boolean z) {
        this.f16351e = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m17068f() {
        return this.f16352f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17059a(int OplusGLSurfaceView_13) {
        this.f16352f = OplusGLSurfaceView_13;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m17057a(sb, "mDrawable", this.f16348b);
        m17057a(sb, "mStickerUUID", this.f16349c);
        m17057a(sb, "mbStickerNew", Boolean.valueOf(this.f16350d));
        m17057a(sb, "mbHasMusic", Boolean.valueOf(this.f16351e));
        m17057a(sb, "mState", Integer.valueOf(this.f16352f));
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17057a(StringBuilder sb, String str, Object obj) {
        if (sb != null) {
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(", ");
        }
    }
}
