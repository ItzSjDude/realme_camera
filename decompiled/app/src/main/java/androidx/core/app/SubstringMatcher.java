package androidx.core.app;

/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f847a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.CharSequence f848b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.CharSequence[] f849c;
    private final boolean d_renamed;
    private final int e_renamed;
    private final android.os.Bundle f_renamed;
    private final java.util.Set<java.lang.String> g_renamed;

    public java.lang.String a_renamed() {
        return this.f847a;
    }

    public java.lang.CharSequence b_renamed() {
        return this.f848b;
    }

    public java.lang.CharSequence[] c_renamed() {
        return this.f849c;
    }

    public java.util.Set<java.lang.String> d_renamed() {
        return this.g_renamed;
    }

    public boolean e_renamed() {
        return this.d_renamed;
    }

    public int f_renamed() {
        return this.e_renamed;
    }

    public android.os.Bundle g_renamed() {
        return this.f_renamed;
    }

    static android.app.RemoteInput[] a_renamed(androidx.core.app.k_renamed[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr = new android.app.RemoteInput[kVarArr.length];
        for (int i_renamed = 0; i_renamed < kVarArr.length; i_renamed++) {
            remoteInputArr[i_renamed] = a_renamed(kVarArr[i_renamed]);
        }
        return remoteInputArr;
    }

    static android.app.RemoteInput a_renamed(androidx.core.app.k_renamed kVar) {
        android.app.RemoteInput.Builder builderAddExtras = new android.app.RemoteInput.Builder(kVar.a_renamed()).setLabel(kVar.b_renamed()).setChoices(kVar.c_renamed()).setAllowFreeFormInput(kVar.e_renamed()).addExtras(kVar.g_renamed());
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            builderAddExtras.setEditChoicesBeforeSending(kVar.f_renamed());
        }
        return builderAddExtras.build();
    }
}
