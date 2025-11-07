package kotlinx.coroutines;

/* compiled from: CoroutineName.kt */
/* loaded from: classes2.dex */
public final class x_renamed extends c_renamed.c_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.x_renamed.a_renamed f7908a = new kotlinx.coroutines.x_renamed.a_renamed(null);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f7909b;

    public boolean equals(java.lang.Object obj) {
        if (this != obj) {
            return (obj instanceof kotlinx.coroutines.x_renamed) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) this.f7909b, (java.lang.Object) ((kotlinx.coroutines.x_renamed) obj).f7909b);
        }
        return true;
    }

    public int hashCode() {
        java.lang.String str = this.f7909b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final java.lang.String a_renamed() {
        return this.f7909b;
    }

    /* compiled from: CoroutineName.kt */
    public static final class a_renamed implements c_renamed.c_renamed.g_renamed.c_renamed<kotlinx.coroutines.x_renamed> {
        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    public java.lang.String toString() {
        return "CoroutineName(" + this.f7909b + ')';
    }
}
