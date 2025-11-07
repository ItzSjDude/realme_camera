package org.andresoviedo.android_3d_model_engine.b_renamed;

/* compiled from: Element.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f7976a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.List<java.lang.Integer> f7977b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.nio.IntBuffer f7978c;
    private java.lang.String d_renamed;
    private org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed e_renamed;

    public e_renamed(java.lang.String str, java.nio.IntBuffer intBuffer, java.lang.String str2) {
        this.f7976a = str;
        this.f7978c = intBuffer;
        this.d_renamed = str2;
    }

    public java.nio.IntBuffer a_renamed() {
        if (this.f7978c == null) {
            this.f7978c = org.andresoviedo.a_renamed.b_renamed.a_renamed.a_renamed(this.f7977b.size());
            this.f7978c.position(0);
            for (int i_renamed = 0; i_renamed < this.f7977b.size(); i_renamed++) {
                this.f7978c.put(this.f7977b.get(i_renamed).intValue());
            }
        }
        return this.f7978c;
    }

    public void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed fVar) {
        this.e_renamed = fVar;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed b_renamed() {
        return this.e_renamed;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Element{id_renamed='");
        sb.append(this.f7976a);
        sb.append('\'');
        sb.append(", indices=");
        java.util.List<java.lang.Integer> list = this.f7977b;
        sb.append(list != null ? java.lang.Integer.valueOf(list.size()) : null);
        sb.append(", indexBuffer=");
        sb.append(this.f7978c);
        sb.append(", material=");
        sb.append(this.e_renamed);
        sb.append('}');
        return sb.toString();
    }
}
