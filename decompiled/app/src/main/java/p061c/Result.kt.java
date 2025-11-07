package p061c;

import java.io.Serializable;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Result.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public final class Result.kt<T> implements Serializable {
    public static final PlatformImplementations.kt_3 Companion = new PlatformImplementations.kt_3(null);
    private final Object value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result.kt m26269boximpl(Object obj) {
        return new Result.kt(obj);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m26270constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m26271equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result.kt) && Intrinsics.m5299a(obj, ((Result.kt) obj2).m26279unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m26272equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.m5299a(obj, obj2);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m26275hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return m26271equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m26275hashCodeimpl(this.value);
    }

    public String toString() {
        return m26278toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m26279unboximpl() {
        return this.value;
    }

    private /* synthetic */ Result.kt(Object obj) {
        this.value = obj;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m26277isSuccessimpl(Object obj) {
        return !(obj instanceof IntrinsicsJvm.kt_4);
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m26276isFailureimpl(Object obj) {
        return obj instanceof IntrinsicsJvm.kt_4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m26274getOrNullimpl(Object obj) {
        if (m26276isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m26273exceptionOrNullimpl(Object obj) {
        if (obj instanceof IntrinsicsJvm.kt_4) {
            return ((IntrinsicsJvm.kt_4) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m26278toStringimpl(Object obj) {
        if (obj instanceof IntrinsicsJvm.kt_4) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    /* compiled from: Result.kt */
    /* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_6$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    /* compiled from: Result.kt */
    /* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_6$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 implements Serializable {
        public final Throwable exception;

        public IntrinsicsJvm.kt_4(Throwable th) {
            Intrinsics.m5305d(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof IntrinsicsJvm.kt_4) && Intrinsics.m5299a(this.exception, ((IntrinsicsJvm.kt_4) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
