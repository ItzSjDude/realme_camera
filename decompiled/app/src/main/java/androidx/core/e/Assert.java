package androidx.core.e_renamed;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f855a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f856b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f857c;
    private final java.util.List<java.util.List<byte[]>> d_renamed;
    private final int e_renamed = 0;
    private final java.lang.String f_renamed;

    public a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<java.util.List<byte[]>> list) {
        this.f855a = (java.lang.String) androidx.core.g_renamed.f_renamed.a_renamed(str);
        this.f856b = (java.lang.String) androidx.core.g_renamed.f_renamed.a_renamed(str2);
        this.f857c = (java.lang.String) androidx.core.g_renamed.f_renamed.a_renamed(str3);
        this.d_renamed = (java.util.List) androidx.core.g_renamed.f_renamed.a_renamed(list);
        this.f_renamed = this.f855a + "-" + this.f856b + "-" + this.f857c;
    }

    public java.lang.String a_renamed() {
        return this.f855a;
    }

    public java.lang.String b_renamed() {
        return this.f856b;
    }

    public java.lang.String c_renamed() {
        return this.f857c;
    }

    public java.util.List<java.util.List<byte[]>> d_renamed() {
        return this.d_renamed;
    }

    public int e_renamed() {
        return this.e_renamed;
    }

    public java.lang.String f_renamed() {
        return this.f_renamed;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f855a + ", mProviderPackage: " + this.f856b + ", mQuery: " + this.f857c + ", mCertificates:");
        for (int i_renamed = 0; i_renamed < this.d_renamed.size(); i_renamed++) {
            sb.append(" [");
            java.util.List<byte[]> list = this.d_renamed.get(i_renamed);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(android.util.Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e_renamed);
        return sb.toString();
    }
}
