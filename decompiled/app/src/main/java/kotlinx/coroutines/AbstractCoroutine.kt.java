package kotlinx.coroutines;

import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;

/* compiled from: AbstractCoroutine.kt */
/* renamed from: kotlinx.coroutines.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class AbstractCoroutine.kt<T> extends JobSupport.kt_6 implements Continuation.kt_2<T>, Job.kt_5, CoroutineScope.kt_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final CoroutineContext.kt_4 f24548a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final CoroutineContext.kt_4 f24549c;

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m25557a(T t) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m25559a(Throwable th, boolean z) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo25565d() {
    }

    public AbstractCoroutine.kt(CoroutineContext.kt_4 interfaceC0932g, boolean z) {
        super(z);
        this.f24548a = interfaceC0932g;
        this.f24549c = this.f24548a.plus(this);
    }

    @Override // p061c.p064c.Continuation.kt_2
    public final CoroutineContext.kt_4 getContext() {
        return this.f24549c;
    }

    @Override // kotlinx.coroutines.CoroutineScope.kt_2
    /* renamed from: PlatformImplementations.kt_3 */
    public CoroutineContext.kt_4 mo25556a() {
        return this.f24549c;
    }

    @Override // kotlinx.coroutines.JobSupport.kt_6, kotlinx.coroutines.Job.kt_5
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo25562b() {
        return super.mo25562b();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m25563c() {
        m25749a((Job.kt_5) this.f24548a.get(Job.kt_5.f24595b));
    }

    @Override // kotlinx.coroutines.JobSupport.kt_6
    /* renamed from: COUIBaseListPopupWindow_8 */
    public final void mo25566e() {
        mo25565d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport.kt_6
    /* renamed from: COUIBaseListPopupWindow_12 */
    public String mo25567f() {
        return DebugStrings.kt.m25580b(this) + " was cancelled";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport.kt_6
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final void mo25561b(Object obj) {
        if (obj instanceof CompletedExceptionally.kt) {
            CompletedExceptionally.kt c3950l = (CompletedExceptionally.kt) obj;
            m25559a(c3950l.f24734a, c3950l.m25937b());
        } else {
            m25557a((AbstractCoroutine.kt<T>) obj);
        }
    }

    @Override // p061c.p064c.Continuation.kt_2
    public final void resumeWith(Object obj) {
        Object objE = m25757e(CompletedExceptionally.kt_3.m25939a(obj));
        if (objE == JobSupport.kt_3.f24659a) {
            return;
        }
        m25564c(objE);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m25564c(Object obj) {
        m25758f(obj);
    }

    @Override // kotlinx.coroutines.JobSupport.kt_6
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25558a(Throwable th) {
        CoroutineExceptionHandler.kt.m25946a(this.f24549c, th);
    }

    @Override // kotlinx.coroutines.JobSupport.kt_6
    /* renamed from: COUIBaseListPopupWindow_11 */
    public String mo25568g() {
        String strM25942a = CoroutineContext.kt_3.m25942a(this.f24549c);
        if (strM25942a == null) {
            return super.mo25568g();
        }
        return '\"' + strM25942a + "\":" + super.mo25568g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final <R> void m25560a(CoroutineStart.kt enumC3964z, R r, Functions.kt_19<? super R, ? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0954m) {
        m25563c();
        enumC3964z.invoke(interfaceC0954m, r, this);
    }
}
