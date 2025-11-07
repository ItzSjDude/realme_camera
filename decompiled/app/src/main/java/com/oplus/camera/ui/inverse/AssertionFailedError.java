package com.oplus.camera.ui.inverse;

/* compiled from: InverseChangeModeData.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f6246a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f6247b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f6248c;
    public float d_renamed;
    public long e_renamed;
    public long f_renamed;
    public boolean g_renamed;

    public java.lang.String toString() {
        return "InverseChangeModeData{toScreenMode=" + this.f6246a + ", orientation=" + this.f6247b + ", toRadius=" + this.f6248c + ", toOffsetY=" + this.d_renamed + ", duration=" + this.e_renamed + ", isRackMode=" + this.g_renamed + '}';
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.oplus.camera.ui.inverse.b_renamed bVar = (com.oplus.camera.ui.inverse.b_renamed) obj;
        return this.f6246a == bVar.f6246a && this.f6247b == bVar.f6247b && this.f6248c == bVar.f6248c && this.g_renamed == bVar.g_renamed;
    }

    public int hashCode() {
        return java.util.Objects.hash(java.lang.Integer.valueOf(this.f6246a), java.lang.Integer.valueOf(this.f6247b), java.lang.Integer.valueOf(this.f6248c), java.lang.Boolean.valueOf(this.g_renamed));
    }
}
