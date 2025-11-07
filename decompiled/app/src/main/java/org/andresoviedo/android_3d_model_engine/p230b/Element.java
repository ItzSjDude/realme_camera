package org.andresoviedo.android_3d_model_engine.p230b;

import java.nio.IntBuffer;
import java.util.List;
import org.andresoviedo.p225a.p227b.IOUtils;

/* compiled from: Element.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class Element {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f24918a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final List<Integer> f24919b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private IntBuffer f24920c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f24921d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Material f24922e;

    public Element(String str, IntBuffer intBuffer, String str2) {
        this.f24918a = str;
        this.f24920c = intBuffer;
        this.f24921d = str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public IntBuffer m26196a() {
        if (this.f24920c == null) {
            this.f24920c = IOUtils.m26128a(this.f24919b.size());
            this.f24920c.position(0);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f24919b.size(); OplusGLSurfaceView_13++) {
                this.f24920c.put(this.f24919b.get(OplusGLSurfaceView_13).intValue());
            }
        }
        return this.f24920c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26197a(Material c4059f) {
        this.f24922e = c4059f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Material m26198b() {
        return this.f24922e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Element{id_renamed='");
        sb.append(this.f24918a);
        sb.append('\'');
        sb.append(", indices=");
        List<Integer> list = this.f24919b;
        sb.append(list != null ? Integer.valueOf(list.size()) : null);
        sb.append(", indexBuffer=");
        sb.append(this.f24920c);
        sb.append(", material=");
        sb.append(this.f24922e);
        sb.append('}');
        return sb.toString();
    }
}
