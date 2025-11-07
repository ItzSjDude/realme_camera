package kotlinx.coroutines;

import kotlinx.coroutines.ThreadContextElement.kt;
import p061c.Unit.kt;
import p061c.p064c.CoroutineContextImpl.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;
import p061c.p077k.C1005d;

/* compiled from: CoroutineContext.kt */
/* renamed from: kotlinx.coroutines.w */
/* loaded from: classes2.dex */
public final class CoroutineContext.kt extends CoroutineContextImpl.kt_2 implements ThreadContextElement.kt<String> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PlatformImplementations.kt_3 f24741a = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final long f24742b;

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoroutineContext.kt) && this.f24742b == ((CoroutineContext.kt) obj).f24742b;
        }
        return true;
    }

    public int hashCode() {
        long OplusGLSurfaceView_15 = this.f24742b;
        return (int) (OplusGLSurfaceView_15 ^ (OplusGLSurfaceView_15 >>> 32));
    }

    @Override // p061c.p064c.CoroutineContextImpl.kt_2, p061c.p064c.CoroutineContext.kt_4
    public <R> R fold(R r, Functions.kt_19<? super R, ? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
        return (R) ThreadContextElement.kt.PlatformImplementations.kt_3.m25793a(this, r, interfaceC0954m);
    }

    @Override // p061c.p064c.CoroutineContextImpl.kt_2, p061c.p064c.CoroutineContext.kt_4.IntrinsicsJvm.kt_4, p061c.p064c.CoroutineContext.kt_4
    public <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E get(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
        return (E) ThreadContextElement.kt.PlatformImplementations.kt_3.m25791a(this, cVar);
    }

    @Override // p061c.p064c.CoroutineContextImpl.kt_2, p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 minusKey(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        return ThreadContextElement.kt.PlatformImplementations.kt_3.m25794b(this, cVar);
    }

    @Override // p061c.p064c.CoroutineContextImpl.kt_2, p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 plus(CoroutineContext.kt_4 interfaceC0932g) {
        return ThreadContextElement.kt.PlatformImplementations.kt_3.m25792a(this, interfaceC0932g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final long m25947a() {
        return this.f24742b;
    }

    /* compiled from: CoroutineContext.kt */
    /* renamed from: kotlinx.coroutines.w$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 implements CoroutineContext.kt_4.IntrinsicsJvm.kt_3<CoroutineContext.kt> {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    public CoroutineContext.kt(long OplusGLSurfaceView_15) {
        super(f24741a);
        this.f24742b = OplusGLSurfaceView_15;
    }

    public String toString() {
        return "CoroutineId(" + this.f24742b + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement.kt
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public String mo25790b(CoroutineContext.kt_4 interfaceC0932g) {
        String strM25949a;
        CoroutineName.kt c3962x = (CoroutineName.kt) interfaceC0932g.get(CoroutineName.kt.f24743a);
        if (c3962x == null || (strM25949a = c3962x.m25949a()) == null) {
            strM25949a = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iB = C1005d.m5374b((CharSequence) name, " @", 0, false, 6, (Object) null);
        if (iB < 0) {
            iB = name.length();
        }
        StringBuilder sb = new StringBuilder(strM25949a.length() + iB + 10);
        if (name != null) {
            String strSubstring = name.substring(0, iB);
            Intrinsics.m5301b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append(" @");
            sb.append(strM25949a);
            sb.append('#');
            sb.append(this.f24742b);
            Unit.kt c1025s = Unit.kt.f5071a;
            String string = sb.toString();
            Intrinsics.m5301b(string, "StringBuilder(capacity).…builderAction).toString()");
            threadCurrentThread.setName(string);
            return name;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // kotlinx.coroutines.ThreadContextElement.kt
    /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo25789a(CoroutineContext.kt_4 interfaceC0932g, String str) {
        Thread.currentThread().setName(str);
    }
}
