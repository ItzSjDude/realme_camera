package kotlinx.coroutines.android;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class a_renamed extends kotlinx.coroutines.android.b_renamed {
    private volatile kotlinx.coroutines.android.a_renamed _immediate;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final kotlinx.coroutines.android.a_renamed f7803b;
    private final android.os.Handler d_renamed;
    private final java.lang.String e_renamed;
    private final boolean f_renamed;

    private a_renamed(android.os.Handler handler, java.lang.String str, boolean z_renamed) {
        super(null);
        this.d_renamed = handler;
        this.e_renamed = str;
        this.f_renamed = z_renamed;
        this._immediate = this.f_renamed ? this : null;
        kotlinx.coroutines.android.a_renamed aVar = this._immediate;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.android.a_renamed(this.d_renamed, this.e_renamed, true);
            this._immediate = aVar;
            c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
        }
        this.f7803b = aVar;
    }

    public /* synthetic */ a_renamed(android.os.Handler handler, java.lang.String str, int i_renamed, c_renamed.f_renamed.b_renamed.f_renamed fVar) {
        this(handler, (i_renamed & 2) != 0 ? (java.lang.String) null : str);
    }

    public a_renamed(android.os.Handler handler, java.lang.String str) {
        this(handler, str, false);
    }

    @Override // kotlinx.coroutines.bf_renamed
    /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
    public kotlinx.coroutines.android.a_renamed a_renamed() {
        return this.f7803b;
    }

    @Override // kotlinx.coroutines.t_renamed
    public boolean a_renamed(c_renamed.c_renamed.g_renamed gVar) {
        return !this.f_renamed || (c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(android.os.Looper.myLooper(), this.d_renamed.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.t_renamed
    public void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable) {
        this.d_renamed.post(runnable);
    }

    @Override // kotlinx.coroutines.bf_renamed, kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        java.lang.String strB = b_renamed();
        if (strB != null) {
            return strB;
        }
        kotlinx.coroutines.android.a_renamed aVar = this;
        java.lang.String string = aVar.e_renamed;
        if (string == null) {
            string = aVar.d_renamed.toString();
        }
        if (!aVar.f_renamed) {
            return string;
        }
        return string + ".immediate";
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlinx.coroutines.android.a_renamed) && ((kotlinx.coroutines.android.a_renamed) obj).d_renamed == this.d_renamed;
    }

    public int hashCode() {
        return java.lang.System.identityHashCode(this.d_renamed);
    }
}
