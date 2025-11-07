package org.andresoviedo.android_3d_model_engine.p230b;

import java.util.Arrays;

/* compiled from: Material.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class Material {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float[] f24923a = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f24924b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float[] f24925c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float[] f24926d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float[] f24927e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f24928f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f24930h;

    /* renamed from: OplusGLSurfaceView_13 */
    private byte[] f24931i;

    /* renamed from: OplusGLSurfaceView_5 */
    private float[] f24933k;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f24929g = 1.0f;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f24932j = -1;

    public Material() {
    }

    public Material(String str) {
        this.f24924b = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] m26199a() {
        return this.f24931i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m26200b() {
        return this.f24932j;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float[] m26201c() {
        float[] fArr;
        if (m26199a() != null) {
            return f24923a;
        }
        if (this.f24933k == null && (fArr = this.f24926d) != null) {
            this.f24933k = new float[4];
            float[] fArr2 = this.f24933k;
            fArr2[0] = fArr[0];
            fArr2[1] = fArr[1];
            fArr2[2] = fArr[2];
            fArr2[3] = this.f24929g;
        }
        return this.f24933k;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Material{name='");
        sb.append(this.f24924b);
        sb.append('\'');
        sb.append(", ambient=");
        sb.append(Arrays.toString(this.f24925c));
        sb.append(", diffuse=");
        sb.append(Arrays.toString(this.f24926d));
        sb.append(", specular=");
        sb.append(Arrays.toString(this.f24927e));
        sb.append(", shininess=");
        sb.append(this.f24928f);
        sb.append(", alpha=");
        sb.append(this.f24929g);
        sb.append(", textureFile='");
        sb.append(this.f24930h);
        sb.append('\'');
        sb.append(", textureData=");
        if (this.f24931i != null) {
            str = this.f24931i.length + " (bytes)";
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", textureId=");
        sb.append(this.f24932j);
        sb.append('}');
        return sb.toString();
    }
}
