package org.andresoviedo.android_3d_model_engine.p230b;

import android.opengl.Matrix;
import org.andresoviedo.p225a.p228c.Math3DUtils;

/* compiled from: BoundingBox.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class BoundingBox {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f24879a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final float[] f24880b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final float[] f24881c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final float[] f24882d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final float[] f24883e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final float[] f24884f;

    public BoundingBox(String str, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        this(str, new float[]{COUIBaseListPopupWindow_12, f3, f5, 1.0f}, new float[]{f2, f4, f6, 1.0f}, Math3DUtils.f24819a);
    }

    private BoundingBox(String str, float[] fArr, float[] fArr2, float[] fArr3) {
        this.f24879a = str;
        this.f24880b = new float[]{fArr[0], fArr[1], fArr[2], 1.0f};
        this.f24881c = new float[]{fArr2[0], fArr2[1], fArr2[2], 1.0f};
        this.f24882d = fArr3;
        this.f24883e = new float[4];
        this.f24884f = new float[4];
        m26170g();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m26170g() {
        Matrix.multiplyMV(this.f24883e, 0, this.f24882d, 0, this.f24880b, 0);
        Matrix.multiplyMV(this.f24884f, 0, this.f24882d, 0, this.f24881c, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m26171a() {
        return this.f24883e[0];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m26172b() {
        return this.f24884f[0];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m26173c() {
        return this.f24883e[1];
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m26174d() {
        return this.f24884f[1];
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m26175e() {
        return this.f24883e[2];
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float m26176f() {
        return this.f24884f[2];
    }

    public String toString() {
        return "BoundingBox{id_renamed='" + this.f24879a + "', xMin=" + m26171a() + ", xMax=" + m26172b() + ", yMin=" + m26173c() + ", yMax=" + m26174d() + ", zMin=" + m26175e() + ", zMax=" + m26176f() + '}';
    }
}
