package androidx.a_renamed.a_renamed.b_renamed;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a_renamed<K_renamed, V_renamed> extends androidx.a_renamed.a_renamed.b_renamed.b_renamed<K_renamed, V_renamed> {

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.HashMap<K_renamed, androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed>> f164b = new java.util.HashMap<>();

    @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed
    protected androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> a_renamed(K_renamed k_renamed) {
        return this.f164b.get(k_renamed);
    }

    @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed
    public V_renamed a_renamed(K_renamed k_renamed, V_renamed v_renamed) {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVarA = a_renamed(k_renamed);
        if (cVarA != null) {
            return cVarA.f169b;
        }
        this.f164b.put(k_renamed, b_renamed(k_renamed, v_renamed));
        return null;
    }

    @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed
    public V_renamed b_renamed(K_renamed k_renamed) {
        V_renamed v_renamed = (V_renamed) super.b_renamed(k_renamed);
        this.f164b.remove(k_renamed);
        return v_renamed;
    }

    public boolean c_renamed(K_renamed k_renamed) {
        return this.f164b.containsKey(k_renamed);
    }

    public java.util.Map.Entry<K_renamed, V_renamed> d_renamed(K_renamed k_renamed) {
        if (c_renamed(k_renamed)) {
            return this.f164b.get(k_renamed).d_renamed;
        }
        return null;
    }
}
