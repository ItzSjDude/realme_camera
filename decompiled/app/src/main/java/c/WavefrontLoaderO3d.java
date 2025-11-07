package c_renamed;

/* compiled from: LazyJVM.kt */
/* loaded from: classes.dex */
final class o_renamed<T_renamed> implements c_renamed.g_renamed<T_renamed>, java.io.Serializable {
    private volatile java.lang.Object _value;
    private c_renamed.f_renamed.a_renamed.a_renamed<? extends T_renamed> initializer;
    private final java.lang.Object lock;

    public o_renamed(c_renamed.f_renamed.a_renamed.a_renamed<? extends T_renamed> aVar, java.lang.Object obj) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(aVar, "initializer");
        this.initializer = aVar;
        this._value = c_renamed.q_renamed.f1924a;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ o_renamed(c_renamed.f_renamed.a_renamed.a_renamed aVar, java.lang.Object obj, int i_renamed, c_renamed.f_renamed.b_renamed.f_renamed fVar) {
        this(aVar, (i_renamed & 2) != 0 ? null : obj);
    }

    @Override // c_renamed.g_renamed
    public T_renamed getValue() {
        T_renamed tInvoke;
        T_renamed t_renamed = (T_renamed) this._value;
        if (t_renamed != c_renamed.q_renamed.f1924a) {
            return t_renamed;
        }
        synchronized (this.lock) {
            tInvoke = (T_renamed) this._value;
            if (tInvoke == c_renamed.q_renamed.f1924a) {
                c_renamed.f_renamed.a_renamed.a_renamed<? extends T_renamed> aVar = this.initializer;
                c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(aVar);
                tInvoke = aVar.invoke();
                this._value = tInvoke;
                this.initializer = (c_renamed.f_renamed.a_renamed.a_renamed) null;
            }
        }
        return tInvoke;
    }

    public boolean isInitialized() {
        return this._value != c_renamed.q_renamed.f1924a;
    }

    public java.lang.String toString() {
        return isInitialized() ? java.lang.String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final java.lang.Object writeReplace() {
        return new c_renamed.d_renamed(getValue());
    }
}
