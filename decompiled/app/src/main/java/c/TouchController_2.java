package c_renamed;

/* compiled from: Result.kt */
/* loaded from: classes.dex */
public final class m_renamed<T_renamed> implements java.io.Serializable {
    public static final c_renamed.m_renamed.a_renamed Companion = new c_renamed.m_renamed.a_renamed(null);
    private final java.lang.Object value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ c_renamed.m_renamed m3boximpl(java.lang.Object obj) {
        return new c_renamed.m_renamed(obj);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static java.lang.Object m4constructorimpl(java.lang.Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5equalsimpl(java.lang.Object obj, java.lang.Object obj2) {
        return (obj2 instanceof c_renamed.m_renamed) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(obj, ((c_renamed.m_renamed) obj2).m13unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6equalsimpl0(java.lang.Object obj, java.lang.Object obj2) {
        return c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(obj, obj2);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m9hashCodeimpl(java.lang.Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        return m5equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m9hashCodeimpl(this.value);
    }

    public java.lang.String toString() {
        return m12toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ java.lang.Object m13unboximpl() {
        return this.value;
    }

    private /* synthetic */ m_renamed(java.lang.Object obj) {
        this.value = obj;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m11isSuccessimpl(java.lang.Object obj) {
        return !(obj instanceof c_renamed.m_renamed.b_renamed);
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m10isFailureimpl(java.lang.Object obj) {
        return obj instanceof c_renamed.m_renamed.b_renamed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T_renamed m8getOrNullimpl(java.lang.Object obj) {
        if (m10isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final java.lang.Throwable m7exceptionOrNullimpl(java.lang.Object obj) {
        if (obj instanceof c_renamed.m_renamed.b_renamed) {
            return ((c_renamed.m_renamed.b_renamed) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m12toStringimpl(java.lang.Object obj) {
        if (obj instanceof c_renamed.m_renamed.b_renamed) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    /* compiled from: Result.kt */
    public static final class a_renamed {
        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    /* compiled from: Result.kt */
    public static final class b_renamed implements java.io.Serializable {
        public final java.lang.Throwable exception;

        public b_renamed(java.lang.Throwable th) {
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(th, "exception");
            this.exception = th;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof c_renamed.m_renamed.b_renamed) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(this.exception, ((c_renamed.m_renamed.b_renamed) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public java.lang.String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
