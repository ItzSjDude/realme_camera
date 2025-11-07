package c_renamed;

/* compiled from: Lazy.kt */
/* loaded from: classes.dex */
public final class d_renamed<T_renamed> implements c_renamed.g_renamed<T_renamed>, java.io.Serializable {
    private final T_renamed value;

    public boolean isInitialized() {
        return true;
    }

    public d_renamed(T_renamed t_renamed) {
        this.value = t_renamed;
    }

    @Override // c_renamed.g_renamed
    public T_renamed getValue() {
        return this.value;
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(getValue());
    }
}
