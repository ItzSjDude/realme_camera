package androidx.media;

/* compiled from: VolumeProviderCompat.java */
/* loaded from: classes.dex */
public abstract class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f1284a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f1285b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f1286c;
    private androidx.media.i_renamed.a_renamed d_renamed;
    private java.lang.Object e_renamed;

    /* compiled from: VolumeProviderCompat.java */
    public static abstract class a_renamed {
        public abstract void onVolumeChanged(androidx.media.i_renamed iVar);
    }

    public void a_renamed(int i_renamed) {
    }

    public void b_renamed(int i_renamed) {
    }

    public final int a_renamed() {
        return this.f1286c;
    }

    public final int b_renamed() {
        return this.f1284a;
    }

    public final int c_renamed() {
        return this.f1285b;
    }

    public void a_renamed(androidx.media.i_renamed.a_renamed aVar) {
        this.d_renamed = aVar;
    }

    public java.lang.Object d_renamed() {
        if (this.e_renamed == null && android.os.Build.VERSION.SDK_INT >= 21) {
            this.e_renamed = androidx.media.j_renamed.a_renamed(this.f1284a, this.f1285b, this.f1286c, new androidx.media.j_renamed.a_renamed() { // from class: androidx.media.i_renamed.1
                @Override // androidx.media.j_renamed.a_renamed
                public void a_renamed(int i_renamed) {
                    androidx.media.i_renamed.this.a_renamed(i_renamed);
                }

                @Override // androidx.media.j_renamed.a_renamed
                public void b_renamed(int i_renamed) {
                    androidx.media.i_renamed.this.b_renamed(i_renamed);
                }
            });
        }
        return this.e_renamed;
    }
}
