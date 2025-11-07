package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.Job.kt_5;
import kotlinx.coroutines.internal.Atomic.kt_3;
import kotlinx.coroutines.internal.LockFreeLinkedList.kt_3;
import kotlinx.coroutines.internal.LockFreeLinkedList.kt;
import kotlinx.coroutines.internal.StackTraceRecovery.kt;
import p061c.Exceptions.kt_2;
import p061c.Unit.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.bc */
/* loaded from: classes2.dex */
public class JobSupport.kt_6 implements Job.kt_5, Job.kt_8, Job.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final AtomicReferenceFieldUpdater f24650a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.kt_6.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo25561b(Object obj) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m25754c(Throwable th) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean mo25756d(Throwable th) {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo25566e() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public String mo25567f() {
        return "Job was cancelled";
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m25758f(Object obj) {
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m25762m() {
        return false;
    }

    /* renamed from: o */
    protected boolean m25764o() {
        return false;
    }

    /* renamed from: p */
    public boolean m25765p() {
        return true;
    }

    public JobSupport.kt_6(boolean z) {
        this._state = z ? JobSupport.kt_3.f24665g : JobSupport.kt_3.f24664f;
        this._parentHandle = null;
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public <R> R fold(R r, Functions.kt_19<? super R, ? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
        return (R) Job.kt_5.PlatformImplementations.kt_3.m25655a(this, r, interfaceC0954m);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4.IntrinsicsJvm.kt_4, p061c.p064c.CoroutineContext.kt_4
    public <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E get(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
        return (E) Job.kt_5.PlatformImplementations.kt_3.m25653a(this, cVar);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 minusKey(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        return Job.kt_5.PlatformImplementations.kt_3.m25657b(this, cVar);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 plus(CoroutineContext.kt_4 interfaceC0932g) {
        return Job.kt_5.PlatformImplementations.kt_3.m25654a(this, interfaceC0932g);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4.IntrinsicsJvm.kt_4
    public final CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> getKey() {
        return Job.kt_5.f24595b;
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: kotlinx.coroutines.bc$IntrinsicsJvm.kt_3 */
    public static final class IntrinsicsJvm.kt_3 extends LockFreeLinkedList.kt.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ LockFreeLinkedList.kt f24656a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ JobSupport.kt_6 f24657b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ Object f24658c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntrinsicsJvm.kt_3(LockFreeLinkedList.kt c3931i, LockFreeLinkedList.kt c3931i2, JobSupport.kt_6 c3900bc, Object obj) {
            super(c3931i2);
            this.f24656a = c3931i;
            this.f24657b = c3900bc;
            this.f24658c = obj;
        }

        @Override // kotlinx.coroutines.internal.Atomic.kt
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Object mo25778a(LockFreeLinkedList.kt c3931i) {
            if (this.f24657b.m25760k() == this.f24658c) {
                return null;
            }
            return LockFreeLinkedList.kt_3.m25847a();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public final Job.kt_2 m25759j() {
        return (Job.kt_2) this._parentHandle;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25752a(Job.kt_2 interfaceC3921h) {
        this._parentHandle = interfaceC3921h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25749a(Job.kt_5 interfaceC3881ay) {
        if (Debug.kt.m25574a()) {
            if (!(m25759j() == null)) {
                throw new AssertionError();
            }
        }
        if (interfaceC3881ay == null) {
            m25752a((Job.kt_2) Job.kt_3.f24667a);
            return;
        }
        interfaceC3881ay.mo25652i();
        Job.kt_2 interfaceC3921hMo25650a = interfaceC3881ay.mo25650a(this);
        m25752a(interfaceC3921hMo25650a);
        if (m25761l()) {
            interfaceC3921hMo25650a.mo25604a();
            m25752a((Job.kt_2) Job.kt_3.f24667a);
        }
    }

    @Override // kotlinx.coroutines.Job.kt_5
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo25562b() {
        Object objM25760k = m25760k();
        return (objM25760k instanceof JobSupport.kt_13) && ((JobSupport.kt_13) objM25760k).mo25605b();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public final boolean m25761l() {
        return !(m25760k() instanceof JobSupport.kt_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object m25721a(IntrinsicsJvm.kt_4 bVar, Object obj) throws Throwable {
        boolean zM25777f;
        Throwable thM25723a;
        boolean z = true;
        if (Debug.kt.m25574a()) {
            if (!(m25760k() == bVar)) {
                throw new AssertionError();
            }
        }
        if (Debug.kt.m25574a() && !(!bVar.m25776e())) {
            throw new AssertionError();
        }
        if (Debug.kt.m25574a() && !bVar.m25774c()) {
            throw new AssertionError();
        }
        CompletedExceptionally.kt c3950l = (CompletedExceptionally.kt) (!(obj instanceof CompletedExceptionally.kt) ? null : obj);
        Throwable th = c3950l != null ? c3950l.f24734a : null;
        synchronized (bVar) {
            zM25777f = bVar.m25777f();
            List<Throwable> listM25772b = bVar.m25772b(th);
            thM25723a = m25723a(bVar, (List<? extends Throwable>) listM25772b);
            if (thM25723a != null) {
                m25728a(thM25723a, (List<? extends Throwable>) listM25772b);
            }
        }
        if (thM25723a != null && thM25723a != th) {
            obj = new CompletedExceptionally.kt(thM25723a, false, 2, null);
        }
        if (thM25723a != null) {
            if (!m25743e(thM25723a) && !mo25756d(thM25723a)) {
                z = false;
            }
            if (z) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((CompletedExceptionally.kt) obj).m25938c();
            }
        }
        if (!zM25777f) {
            m25754c(thM25723a);
        }
        mo25561b(obj);
        boolean zCompareAndSet = f24650a.compareAndSet(this, bVar, JobSupport.kt_3.m25779a(obj));
        if (Debug.kt.m25574a() && !zCompareAndSet) {
            throw new AssertionError();
        }
        m25737b(bVar, obj);
        return obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Throwable m25723a(IntrinsicsJvm.kt_4 bVar, List<? extends Throwable> list) {
        Object next;
        Object next2;
        if (list.isEmpty()) {
            if (!bVar.m25777f()) {
                return null;
            }
            return new Exceptions.kt(mo25567f(), (Throwable) null, this);
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof Timeout.kt) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof Timeout.kt)) {
                    break;
                }
            }
            Throwable th4 = (Throwable) next2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m25728a(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable thM25889a = !Debug.kt.m25576c() ? th : StackTraceRecovery.kt.m25889a(th);
        for (Throwable thM25889a2 : list) {
            if (Debug.kt.m25576c()) {
                thM25889a2 = StackTraceRecovery.kt.m25889a(thM25889a2);
            }
            if (thM25889a2 != th && thM25889a2 != thM25889a && !(thM25889a2 instanceof CancellationException) && setNewSetFromMap.add(thM25889a2)) {
                Exceptions.kt_2.m5247a(th, thM25889a2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m25733a(JobSupport.kt_13 interfaceC3877au, Object obj) throws Throwable {
        if (Debug.kt.m25574a()) {
            if (!((interfaceC3877au instanceof JobSupport.kt) || (interfaceC3877au instanceof JobSupport.kt_12))) {
                throw new AssertionError();
            }
        }
        if (Debug.kt.m25574a()) {
            if (!(!(obj instanceof CompletedExceptionally.kt))) {
                throw new AssertionError();
            }
        }
        if (!f24650a.compareAndSet(this, interfaceC3877au, JobSupport.kt_3.m25779a(obj))) {
            return false;
        }
        m25754c((Throwable) null);
        mo25561b(obj);
        m25737b(interfaceC3877au, obj);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final void m25737b(JobSupport.kt_13 interfaceC3877au, Object obj) throws Throwable {
        Job.kt_2 interfaceC3921hM25759j = m25759j();
        if (interfaceC3921hM25759j != null) {
            interfaceC3921hM25759j.mo25604a();
            m25752a((Job.kt_2) Job.kt_3.f24667a);
        }
        if (!(obj instanceof CompletedExceptionally.kt)) {
            obj = null;
        }
        CompletedExceptionally.kt c3950l = (CompletedExceptionally.kt) obj;
        Throwable th = c3950l != null ? c3950l.f24734a : null;
        if (interfaceC3877au instanceof JobSupport.kt_12) {
            try {
                ((JobSupport.kt_12) interfaceC3877au).mo25648b(th);
                return;
            } catch (Throwable th2) {
                mo25558a((Throwable) new Exceptions.common.kt_2("Exception in completion handler " + interfaceC3877au + " for " + this, th2));
                return;
            }
        }
        JobSupport.kt_4 c3904bgMo25606k_ = interfaceC3877au.mo25606k_();
        if (c3904bgMo25606k_ != null) {
            m25740b(c3904bgMo25606k_, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m25731a(kotlinx.coroutines.JobSupport.kt_4 r8, java.lang.Throwable r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.m25754c(r9)
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlinx.coroutines.internal.COUIBaseListPopupWindow_11 r8 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt_5) r8
            java.lang.Object r1 = r8.m25856e()
            if (r1 == 0) goto L60
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r1 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt) r1
        L10:
            boolean r2 = p061c.p070f.p072b.Intrinsics.m5299a(r1, r8)
            r2 = r2 ^ 1
            if (r2 == 0) goto L57
            boolean r2 = r1 instanceof kotlinx.coroutines.JobSupport.kt_15
            if (r2 == 0) goto L52
            r2 = r1
            kotlinx.coroutines.bb r2 = (kotlinx.coroutines.JobSupport.kt_12) r2
            r2.mo25648b(r9)     // Catch: java.lang.Throwable -> L23
            goto L52
        L23:
            r3 = move-exception
            if (r0 == 0) goto L2c
            p061c.Exceptions.kt_2.m5247a(r0, r3)
            if (r0 == 0) goto L2c
            goto L52
        L2c:
            r0 = r7
            kotlinx.coroutines.bc r0 = (kotlinx.coroutines.JobSupport.kt_6) r0
            kotlinx.coroutines.q r4 = new kotlinx.coroutines.q
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Exception in completion handler "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = " for "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.<init>(r0, r3)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            IntrinsicsJvm.kt_3.s r0 = p061c.Unit.kt.f5071a
            r0 = r4
        L52:
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r1 = r1.m25857f()
            goto L10
        L57:
            if (r0 == 0) goto L5c
            r7.mo25558a(r0)
        L5c:
            r7.m25743e(r9)
            return
        L60:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.kt_6.m25731a(kotlinx.coroutines.bg_renamed, java.lang.Throwable):void");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean m25743e(Throwable th) {
        if (m25764o()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        Job.kt_2 interfaceC3921hM25759j = m25759j();
        return (interfaceC3921hM25759j == null || interfaceC3921hM25759j == Job.kt_3.f24667a) ? z : interfaceC3921hM25759j.mo25788a(th) || z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final int m25719a(Object obj) {
        if (obj instanceof JobSupport.kt) {
            if (((JobSupport.kt) obj).mo25605b()) {
                return 0;
            }
            if (!f24650a.compareAndSet(this, obj, JobSupport.kt_3.f24665g)) {
                return -1;
            }
            mo25566e();
            return 1;
        }
        if (!(obj instanceof JobSupport.kt_10)) {
            return 0;
        }
        if (!f24650a.compareAndSet(this, obj, ((JobSupport.kt_10) obj).mo25606k_())) {
            return -1;
        }
        mo25566e();
        return 1;
    }

    @Override // kotlinx.coroutines.Job.kt_5
    /* renamed from: COUIBaseListPopupWindow_10 */
    public final CancellationException mo25651h() {
        Object objM25760k = m25760k();
        if (objM25760k instanceof IntrinsicsJvm.kt_4) {
            Throwable thM25775d = ((IntrinsicsJvm.kt_4) objM25760k).m25775d();
            if (thM25775d != null) {
                CancellationException cancellationExceptionM25748a = m25748a(thM25775d, DebugStrings.kt.m25580b(this) + " is cancelling");
                if (cancellationExceptionM25748a != null) {
                    return cancellationExceptionM25748a;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM25760k instanceof JobSupport.kt_13) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM25760k instanceof CompletedExceptionally.kt) {
            return m25724a(this, ((CompletedExceptionally.kt) objM25760k).f24734a, null, 1, null);
        }
        return new Exceptions.kt(DebugStrings.kt.m25580b(this) + " has completed normally", null, this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ CancellationException m25724a(JobSupport.kt_6 c3900bc, Throwable th, String str, int OplusGLSurfaceView_13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            str = (String) null;
        }
        return c3900bc.m25748a(th, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected final CancellationException m25748a(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException != null) {
            return cancellationException;
        }
        if (str == null) {
            str = mo25567f();
        }
        return new Exceptions.kt(str, th, this);
    }

    @Override // kotlinx.coroutines.Job.kt_5
    /* renamed from: PlatformImplementations.kt_3 */
    public final Job.kt_4 mo25649a(boolean z, boolean z2, Functions.kt_3<? super Throwable, Unit.kt> interfaceC0943b) {
        JobSupport.kt_12<?> abstractC3899bbM25725a = (JobSupport.kt_12) null;
        while (true) {
            Object objM25760k = m25760k();
            if (objM25760k instanceof JobSupport.kt) {
                JobSupport.kt c3865al = (JobSupport.kt) objM25760k;
                if (c3865al.mo25605b()) {
                    if (abstractC3899bbM25725a == null) {
                        abstractC3899bbM25725a = m25725a(interfaceC0943b, z);
                    }
                    if (f24650a.compareAndSet(this, objM25760k, abstractC3899bbM25725a)) {
                        return abstractC3899bbM25725a;
                    }
                } else {
                    m25729a(c3865al);
                }
            } else if (objM25760k instanceof JobSupport.kt_13) {
                JobSupport.kt_4 c3904bgMo25606k_ = ((JobSupport.kt_13) objM25760k).mo25606k_();
                if (c3904bgMo25606k_ != null) {
                    Throwable thM25775d = (Throwable) null;
                    JobSupport.kt_12<?> abstractC3899bb = Job.kt_3.f24667a;
                    if (z && (objM25760k instanceof IntrinsicsJvm.kt_4)) {
                        synchronized (objM25760k) {
                            thM25775d = ((IntrinsicsJvm.kt_4) objM25760k).m25775d();
                            if (thM25775d == null || ((interfaceC0943b instanceof JobSupport.kt_14) && !((IntrinsicsJvm.kt_4) objM25760k).m25774c())) {
                                if (abstractC3899bbM25725a == null) {
                                    abstractC3899bbM25725a = m25725a(interfaceC0943b, z);
                                }
                                if (m25732a(objM25760k, c3904bgMo25606k_, abstractC3899bbM25725a)) {
                                    if (thM25775d == null) {
                                        return abstractC3899bbM25725a;
                                    }
                                    abstractC3899bb = abstractC3899bbM25725a;
                                }
                            }
                            Unit.kt c1025s = Unit.kt.f5071a;
                        }
                    }
                    if (thM25775d != null) {
                        if (z2) {
                            interfaceC0943b.invoke(thM25775d);
                        }
                        return abstractC3899bb;
                    }
                    if (abstractC3899bbM25725a == null) {
                        abstractC3899bbM25725a = m25725a(interfaceC0943b, z);
                    }
                    if (m25732a(objM25760k, c3904bgMo25606k_, abstractC3899bbM25725a)) {
                        return abstractC3899bbM25725a;
                    }
                } else {
                    if (objM25760k == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    }
                    m25738b((JobSupport.kt_12<?>) objM25760k);
                }
            } else {
                if (z2) {
                    if (!(objM25760k instanceof CompletedExceptionally.kt)) {
                        objM25760k = null;
                    }
                    CompletedExceptionally.kt c3950l = (CompletedExceptionally.kt) objM25760k;
                    interfaceC0943b.invoke(c3950l != null ? c3950l.f24734a : null);
                }
                return Job.kt_3.f24667a;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002c  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.JobSupport.kt_12<?> m25725a(p061c.p070f.p071a.Functions.kt_3<? super java.lang.Throwable, p061c.Unit.kt> r5, boolean r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L39
            boolean r6 = r5 instanceof kotlinx.coroutines.JobSupport.kt_15
            if (r6 != 0) goto La
            goto Lb
        La:
            r2 = r5
        Lb:
            kotlinx.coroutines.ba r2 = (kotlinx.coroutines.JobSupport.kt_15) r2
            if (r2 == 0) goto L2c
            boolean r6 = kotlinx.coroutines.Debug.kt.m25574a()
            if (r6 == 0) goto L29
            J extends kotlinx.coroutines.ay r6 = r2.f24649b
            r3 = r4
            kotlinx.coroutines.bc r3 = (kotlinx.coroutines.JobSupport.kt_6) r3
            if (r6 != r3) goto L1d
            goto L1e
        L1d:
            r0 = r1
        L1e:
            if (r0 == 0) goto L21
            goto L29
        L21:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            throw r4
        L29:
            if (r2 == 0) goto L2c
            goto L36
        L2c:
            kotlinx.coroutines.aw r6 = new kotlinx.coroutines.aw
            kotlinx.coroutines.ay r4 = (kotlinx.coroutines.Job.kt_5) r4
            r6.<init>(r4, r5)
            r2 = r6
            kotlinx.coroutines.ba r2 = (kotlinx.coroutines.JobSupport.kt_15) r2
        L36:
            kotlinx.coroutines.bb r2 = (kotlinx.coroutines.JobSupport.kt_12) r2
            goto L6e
        L39:
            boolean r6 = r5 instanceof kotlinx.coroutines.JobSupport.kt_12
            if (r6 != 0) goto L3e
            goto L3f
        L3e:
            r2 = r5
        L3f:
            kotlinx.coroutines.bb r2 = (kotlinx.coroutines.JobSupport.kt_12) r2
            if (r2 == 0) goto L64
            boolean r6 = kotlinx.coroutines.Debug.kt.m25574a()
            if (r6 == 0) goto L61
            J extends kotlinx.coroutines.ay r6 = r2.f24649b
            r3 = r4
            kotlinx.coroutines.bc r3 = (kotlinx.coroutines.JobSupport.kt_6) r3
            if (r6 != r3) goto L55
            boolean r6 = r2 instanceof kotlinx.coroutines.JobSupport.kt_15
            if (r6 != 0) goto L55
            goto L56
        L55:
            r0 = r1
        L56:
            if (r0 == 0) goto L59
            goto L61
        L59:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            throw r4
        L61:
            if (r2 == 0) goto L64
            goto L6e
        L64:
            kotlinx.coroutines.ax r6 = new kotlinx.coroutines.ax
            kotlinx.coroutines.ay r4 = (kotlinx.coroutines.Job.kt_5) r4
            r6.<init>(r4, r5)
            r2 = r6
            kotlinx.coroutines.bb r2 = (kotlinx.coroutines.JobSupport.kt_12) r2
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.kt_6.m25725a(IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4, boolean):kotlinx.coroutines.bb");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m25732a(Object obj, JobSupport.kt_4 c3904bg, JobSupport.kt_12<?> abstractC3899bb) {
        int iM25854a;
        JobSupport.kt_4 c3904bg2 = c3904bg;
        JobSupport.kt_12<?> abstractC3899bb2 = abstractC3899bb;
        IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3(abstractC3899bb2, abstractC3899bb2, this, obj);
        do {
            iM25854a = c3904bg2.m25858g().m25854a(abstractC3899bb2, c3904bg2, cVar);
            if (iM25854a == 1) {
                return true;
            }
        } while (iM25854a != 2);
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m25729a(JobSupport.kt c3865al) {
        JobSupport.kt_4 c3904bg = new JobSupport.kt_4();
        f24650a.compareAndSet(this, c3865al, c3865al.mo25605b() ? c3904bg : new JobSupport.kt_10(c3904bg));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final void m25738b(JobSupport.kt_12<?> abstractC3899bb) {
        abstractC3899bb.m25855a(new JobSupport.kt_4());
        f24650a.compareAndSet(this, abstractC3899bb, abstractC3899bb.m25857f());
    }

    @Override // kotlinx.coroutines.Job.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25751a(Job.kt_8 interfaceC3907bj) throws Throwable {
        m25755d(interfaceC3907bj);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m25753b(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m25755d((Object) th) && m25765p();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final boolean m25755d(Object obj) throws Throwable {
        Object objM25745h = JobSupport.kt_3.f24660b;
        if (m25762m() && (objM25745h = m25741c(obj)) == JobSupport.kt_3.f24659a) {
            return true;
        }
        if (objM25745h == JobSupport.kt_3.f24660b) {
            objM25745h = m25745h(obj);
        }
        if (objM25745h == JobSupport.kt_3.f24660b || objM25745h == JobSupport.kt_3.f24659a) {
            return true;
        }
        if (objM25745h == JobSupport.kt_3.f24662d) {
            return false;
        }
        m25758f(objM25745h);
        return true;
    }

    @Override // kotlinx.coroutines.Job.kt_8
    /* renamed from: OplusGLSurfaceView_11 */
    public CancellationException mo25763n() {
        Throwable thM25775d;
        Object objM25760k = m25760k();
        if (objM25760k instanceof IntrinsicsJvm.kt_4) {
            thM25775d = ((IntrinsicsJvm.kt_4) objM25760k).m25775d();
        } else if (objM25760k instanceof CompletedExceptionally.kt) {
            thM25775d = ((CompletedExceptionally.kt) objM25760k).f24734a;
        } else {
            if (objM25760k instanceof JobSupport.kt_13) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objM25760k).toString());
            }
            thM25775d = null;
        }
        CancellationException cancellationException = (CancellationException) (thM25775d instanceof CancellationException ? thM25775d : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        return new Exceptions.kt("Parent job is " + m25747j(objM25760k), thM25775d, this);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Throwable m25744g(Object obj) {
        if (!(obj != null ? obj instanceof Throwable : true)) {
            if (obj != null) {
                return ((Job.kt_8) obj).mo25763n();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
        if (obj != null) {
            return (Throwable) obj;
        }
        return new Exceptions.kt(mo25567f(), (Throwable) null, this);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Object m25745h(Object obj) throws Throwable {
        Throwable thM25744g = (Throwable) null;
        while (true) {
            Object objM25760k = m25760k();
            if (!(objM25760k instanceof IntrinsicsJvm.kt_4)) {
                if (!(objM25760k instanceof JobSupport.kt_13)) {
                    return JobSupport.kt_3.f24662d;
                }
                if (thM25744g == null) {
                    thM25744g = m25744g(obj);
                }
                JobSupport.kt_13 interfaceC3877au = (JobSupport.kt_13) objM25760k;
                if (interfaceC3877au.mo25605b()) {
                    if (m25734a(interfaceC3877au, thM25744g)) {
                        return JobSupport.kt_3.f24660b;
                    }
                } else {
                    Object objM25720a = m25720a(objM25760k, new CompletedExceptionally.kt(thM25744g, false, 2, null));
                    if (objM25720a != JobSupport.kt_3.f24660b) {
                        if (objM25720a != JobSupport.kt_3.f24661c) {
                            return objM25720a;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + objM25760k).toString());
                    }
                }
            } else {
                synchronized (objM25760k) {
                    if (((IntrinsicsJvm.kt_4) objM25760k).m25776e()) {
                        return JobSupport.kt_3.f24662d;
                    }
                    boolean zM25777f = ((IntrinsicsJvm.kt_4) objM25760k).m25777f();
                    if (obj != null || !zM25777f) {
                        if (thM25744g == null) {
                            thM25744g = m25744g(obj);
                        }
                        ((IntrinsicsJvm.kt_4) objM25760k).m25773c(thM25744g);
                    }
                    Throwable thM25775d = ((IntrinsicsJvm.kt_4) objM25760k).m25775d();
                    if (!(!zM25777f)) {
                        thM25775d = null;
                    }
                    if (thM25775d != null) {
                        m25731a(((IntrinsicsJvm.kt_4) objM25760k).mo25606k_(), thM25775d);
                    }
                    return JobSupport.kt_3.f24660b;
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final JobSupport.kt_4 m25726a(JobSupport.kt_13 interfaceC3877au) {
        JobSupport.kt_4 c3904bgMo25606k_ = interfaceC3877au.mo25606k_();
        if (c3904bgMo25606k_ != null) {
            return c3904bgMo25606k_;
        }
        if (interfaceC3877au instanceof JobSupport.kt) {
            return new JobSupport.kt_4();
        }
        if (interfaceC3877au instanceof JobSupport.kt_12) {
            m25738b((JobSupport.kt_12<?>) interfaceC3877au);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC3877au).toString());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m25734a(JobSupport.kt_13 interfaceC3877au, Throwable th) throws Throwable {
        if (Debug.kt.m25574a()) {
            if (!(!(interfaceC3877au instanceof IntrinsicsJvm.kt_4))) {
                throw new AssertionError();
            }
        }
        if (Debug.kt.m25574a() && !interfaceC3877au.mo25605b()) {
            throw new AssertionError();
        }
        JobSupport.kt_4 c3904bgM25726a = m25726a(interfaceC3877au);
        if (c3904bgM25726a == null) {
            return false;
        }
        if (!f24650a.compareAndSet(this, interfaceC3877au, new IntrinsicsJvm.kt_4(c3904bgM25726a, false, th))) {
            return false;
        }
        m25731a(c3904bgM25726a, th);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object m25720a(Object obj, Object obj2) {
        if (!(obj instanceof JobSupport.kt_13)) {
            return JobSupport.kt_3.f24660b;
        }
        if ((!(obj instanceof JobSupport.kt) && !(obj instanceof JobSupport.kt_12)) || (obj instanceof JobSupport.kt_14) || (obj2 instanceof CompletedExceptionally.kt)) {
            return m25742c((JobSupport.kt_13) obj, obj2);
        }
        return m25733a((JobSupport.kt_13) obj, obj2) ? obj2 : JobSupport.kt_3.f24661c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Object m25742c(JobSupport.kt_13 interfaceC3877au, Object obj) throws Throwable {
        JobSupport.kt_4 c3904bgM25726a = m25726a(interfaceC3877au);
        if (c3904bgM25726a == null) {
            return JobSupport.kt_3.f24661c;
        }
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) (!(interfaceC3877au instanceof IntrinsicsJvm.kt_4) ? null : interfaceC3877au);
        if (bVar == null) {
            bVar = new IntrinsicsJvm.kt_4(c3904bgM25726a, false, null);
        }
        synchronized (bVar) {
            if (bVar.m25774c()) {
                return JobSupport.kt_3.f24660b;
            }
            bVar.m25771a(true);
            if (bVar != interfaceC3877au && !f24650a.compareAndSet(this, interfaceC3877au, bVar)) {
                return JobSupport.kt_3.f24661c;
            }
            if (Debug.kt.m25574a() && !(!bVar.m25776e())) {
                throw new AssertionError();
            }
            boolean zM25777f = bVar.m25777f();
            CompletedExceptionally.kt c3950l = (CompletedExceptionally.kt) (!(obj instanceof CompletedExceptionally.kt) ? null : obj);
            if (c3950l != null) {
                bVar.m25773c(c3950l.f24734a);
            }
            Throwable thM25775d = true ^ zM25777f ? bVar.m25775d() : null;
            Unit.kt c1025s = Unit.kt.f5071a;
            if (thM25775d != null) {
                m25731a(c3904bgM25726a, thM25775d);
            }
            JobSupport.kt_14 c3922iM25736b = m25736b(interfaceC3877au);
            if (c3922iM25736b != null && m25735a(bVar, c3922iM25736b, obj)) {
                return JobSupport.kt_3.f24659a;
            }
            return m25721a(bVar, obj);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private final Throwable m25746i(Object obj) {
        if (!(obj instanceof CompletedExceptionally.kt)) {
            obj = null;
        }
        CompletedExceptionally.kt c3950l = (CompletedExceptionally.kt) obj;
        if (c3950l != null) {
            return c3950l.f24734a;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final JobSupport.kt_14 m25736b(JobSupport.kt_13 interfaceC3877au) {
        JobSupport.kt_14 c3922i = (JobSupport.kt_14) (!(interfaceC3877au instanceof JobSupport.kt_14) ? null : interfaceC3877au);
        if (c3922i != null) {
            return c3922i;
        }
        JobSupport.kt_4 c3904bgMo25606k_ = interfaceC3877au.mo25606k_();
        if (c3904bgMo25606k_ != null) {
            return m25727a((LockFreeLinkedList.kt) c3904bgMo25606k_);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m25735a(IntrinsicsJvm.kt_4 bVar, JobSupport.kt_14 c3922i, Object obj) {
        while (Job.kt_5.PlatformImplementations.kt_3.m25656a(c3922i.f24679a, false, false, new PlatformImplementations.kt_3(this, bVar, c3922i, obj), 1, null) == Job.kt_3.f24667a) {
            c3922i = m25727a((LockFreeLinkedList.kt) c3922i);
            if (c3922i == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m25739b(IntrinsicsJvm.kt_4 bVar, JobSupport.kt_14 c3922i, Object obj) {
        if (Debug.kt.m25574a()) {
            if (!(m25760k() == bVar)) {
                throw new AssertionError();
            }
        }
        JobSupport.kt_14 c3922iM25727a = m25727a((LockFreeLinkedList.kt) c3922i);
        if (c3922iM25727a == null || !m25735a(bVar, c3922iM25727a, obj)) {
            m25758f(m25721a(bVar, obj));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final JobSupport.kt_14 m25727a(LockFreeLinkedList.kt c3931i) {
        while (c3931i.mo25846d()) {
            c3931i = c3931i.m25858g();
        }
        while (true) {
            c3931i = c3931i.m25857f();
            if (!c3931i.mo25846d()) {
                if (c3931i instanceof JobSupport.kt_14) {
                    return (JobSupport.kt_14) c3931i;
                }
                if (c3931i instanceof JobSupport.kt_4) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job.kt_5
    /* renamed from: PlatformImplementations.kt_3 */
    public final Job.kt_2 mo25650a(Job.kt interfaceC3948j) {
        Job.kt_4 interfaceC3864akM25656a = Job.kt_5.PlatformImplementations.kt_3.m25656a(this, true, false, new JobSupport.kt_14(this, interfaceC3948j), 2, null);
        if (interfaceC3864akM25656a != null) {
            return (Job.kt_2) interfaceC3864akM25656a;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25558a(Throwable th) throws Throwable {
        throw th;
    }

    public String toString() {
        return m25766q() + '@' + DebugStrings.kt.m25579a(this);
    }

    /* renamed from: q */
    public final String m25766q() {
        return mo25568g() + '{' + m25747j(m25760k()) + '}';
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public String mo25568g() {
        return DebugStrings.kt.m25580b(this);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private final String m25747j(Object obj) {
        if (!(obj instanceof IntrinsicsJvm.kt_4)) {
            return obj instanceof JobSupport.kt_13 ? ((JobSupport.kt_13) obj).mo25605b() ? "Active" : "New" : obj instanceof CompletedExceptionally.kt ? "Cancelled" : "Completed";
        }
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) obj;
        return bVar.m25777f() ? "Cancelling" : bVar.m25774c() ? "Completing" : "Active";
    }

    /* compiled from: JobSupport.kt */
    /* renamed from: kotlinx.coroutines.bc$IntrinsicsJvm.kt_4 */
    private static final class IntrinsicsJvm.kt_4 implements JobSupport.kt_13 {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: PlatformImplementations.kt_3 */
        private final JobSupport.kt_4 f24655a;

        @Override // kotlinx.coroutines.JobSupport.kt_13
        /* renamed from: k_ */
        public JobSupport.kt_4 mo25606k_() {
            return this.f24655a;
        }

        public IntrinsicsJvm.kt_4(JobSupport.kt_4 c3904bg, boolean z, Throwable th) {
            this.f24655a = c3904bg;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
        /* renamed from: IntrinsicsJvm.kt_3 */
        public final boolean m25774c() {
            return this._isCompleting;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final void m25771a(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public final Throwable m25775d() {
            return (Throwable) this._rootCause;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final void m25770a(Throwable th) {
            this._rootCause = th;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final Object m25768g() {
            return this._exceptionsHolder;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private final void m25767a(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public final boolean m25776e() {
            return m25768g() == JobSupport.kt_3.f24663e;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public final boolean m25777f() {
            return m25775d() != null;
        }

        @Override // kotlinx.coroutines.JobSupport.kt_13
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo25605b() {
            return m25775d() == null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final List<Throwable> m25772b(Throwable th) {
            ArrayList<Throwable> arrayListM25769h;
            Object objM25768g = m25768g();
            if (objM25768g == null) {
                arrayListM25769h = m25769h();
            } else if (objM25768g instanceof Throwable) {
                ArrayList<Throwable> arrayListM25769h2 = m25769h();
                arrayListM25769h2.add(objM25768g);
                arrayListM25769h = arrayListM25769h2;
            } else {
                if (!(objM25768g instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objM25768g).toString());
                }
                arrayListM25769h = (ArrayList) objM25768g;
            }
            Throwable thM25775d = m25775d();
            if (thM25775d != null) {
                arrayListM25769h.add(0, thM25775d);
            }
            if (th != null && (!Intrinsics.m5299a(th, thM25775d))) {
                arrayListM25769h.add(th);
            }
            m25767a(JobSupport.kt_3.f24663e);
            return arrayListM25769h;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final void m25773c(Throwable th) {
            Throwable thM25775d = m25775d();
            if (thM25775d == null) {
                m25770a(th);
                return;
            }
            if (th == thM25775d) {
                return;
            }
            Object objM25768g = m25768g();
            if (objM25768g == null) {
                m25767a((Object) th);
                return;
            }
            if (!(objM25768g instanceof Throwable)) {
                if (objM25768g instanceof ArrayList) {
                    ((ArrayList) objM25768g).add(th);
                    return;
                }
                throw new IllegalStateException(("State is " + objM25768g).toString());
            }
            if (th == objM25768g) {
                return;
            }
            ArrayList<Throwable> arrayListM25769h = m25769h();
            arrayListM25769h.add(objM25768g);
            arrayListM25769h.add(th);
            Unit.kt c1025s = Unit.kt.f5071a;
            m25767a(arrayListM25769h);
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        private final ArrayList<Throwable> m25769h() {
            return new ArrayList<>(4);
        }

        public String toString() {
            return "Finishing[cancelling=" + m25777f() + ", completing=" + m25774c() + ", rootCause=" + m25775d() + ", exceptions=" + m25768g() + ", list=" + mo25606k_() + ']';
        }
    }

    /* compiled from: JobSupport.kt */
    /* renamed from: kotlinx.coroutines.bc$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 extends JobSupport.kt_12<Job.kt_5> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final JobSupport.kt_6 f24651a;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final IntrinsicsJvm.kt_4 f24652e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private final JobSupport.kt_14 f24653f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final Object f24654g;

        @Override // p061c.p070f.p071a.Functions.kt_3
        public /* synthetic */ Unit.kt invoke(Throwable th) {
            mo25648b(th);
            return Unit.kt.f5071a;
        }

        public PlatformImplementations.kt_3(JobSupport.kt_6 c3900bc, IntrinsicsJvm.kt_4 bVar, JobSupport.kt_14 c3922i, Object obj) {
            super(c3922i.f24679a);
            this.f24651a = c3900bc;
            this.f24652e = bVar;
            this.f24653f = c3922i;
            this.f24654g = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandler.kt
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo25648b(Throwable th) {
            this.f24651a.m25739b(this.f24652e, this.f24653f, this.f24654g);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedList.kt
        public String toString() {
            return "ChildCompletion[" + this.f24653f + ", " + this.f24654g + ']';
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public final Object m25760k() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof Atomic.kt_3)) {
                return obj;
            }
            ((Atomic.kt_3) obj).mo25832c(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m25740b(kotlinx.coroutines.JobSupport.kt_4 r8, java.lang.Throwable r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlinx.coroutines.internal.COUIBaseListPopupWindow_11 r8 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt_5) r8
            java.lang.Object r1 = r8.m25856e()
            if (r1 == 0) goto L5a
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r1 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt) r1
        Ld:
            boolean r2 = p061c.p070f.p072b.Intrinsics.m5299a(r1, r8)
            r2 = r2 ^ 1
            if (r2 == 0) goto L54
            boolean r2 = r1 instanceof kotlinx.coroutines.JobSupport.kt_12
            if (r2 == 0) goto L4f
            r2 = r1
            kotlinx.coroutines.bb r2 = (kotlinx.coroutines.JobSupport.kt_12) r2
            r2.mo25648b(r9)     // Catch: java.lang.Throwable -> L20
            goto L4f
        L20:
            r3 = move-exception
            if (r0 == 0) goto L29
            p061c.Exceptions.kt_2.m5247a(r0, r3)
            if (r0 == 0) goto L29
            goto L4f
        L29:
            r0 = r7
            kotlinx.coroutines.bc r0 = (kotlinx.coroutines.JobSupport.kt_6) r0
            kotlinx.coroutines.q r4 = new kotlinx.coroutines.q
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Exception in completion handler "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = " for "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.<init>(r0, r3)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            IntrinsicsJvm.kt_3.s r0 = p061c.Unit.kt.f5071a
            r0 = r4
        L4f:
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r1 = r1.m25857f()
            goto Ld
        L54:
            if (r0 == 0) goto L59
            r7.mo25558a(r0)
        L59:
            return
        L5a:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.kt_6.m25740b(kotlinx.coroutines.bg_renamed, java.lang.Throwable):void");
    }

    @Override // kotlinx.coroutines.Job.kt_5
    /* renamed from: OplusGLSurfaceView_13 */
    public final boolean mo25652i() {
        int iM25719a;
        do {
            iM25719a = m25719a(m25760k());
            if (iM25719a == 0) {
                return false;
            }
        } while (iM25719a != 1);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25750a(JobSupport.kt_12<?> abstractC3899bb) {
        Object objM25760k;
        do {
            objM25760k = m25760k();
            if (!(objM25760k instanceof JobSupport.kt_12)) {
                if (!(objM25760k instanceof JobSupport.kt_13) || ((JobSupport.kt_13) objM25760k).mo25606k_() == null) {
                    return;
                }
                abstractC3899bb.mo25845c();
                return;
            }
            if (objM25760k != abstractC3899bb) {
                return;
            }
        } while (!f24650a.compareAndSet(this, objM25760k, JobSupport.kt_3.f24665g));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Object m25741c(Object obj) {
        Object objM25720a;
        do {
            Object objM25760k = m25760k();
            if (!(objM25760k instanceof JobSupport.kt_13) || ((objM25760k instanceof IntrinsicsJvm.kt_4) && ((IntrinsicsJvm.kt_4) objM25760k).m25774c())) {
                return JobSupport.kt_3.f24660b;
            }
            objM25720a = m25720a(objM25760k, new CompletedExceptionally.kt(m25744g(obj), false, 2, null));
        } while (objM25720a == JobSupport.kt_3.f24661c);
        return objM25720a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final Object m25757e(Object obj) {
        Object objM25720a;
        do {
            objM25720a = m25720a(m25760k(), obj);
            if (objM25720a == JobSupport.kt_3.f24660b) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, m25746i(obj));
            }
        } while (objM25720a == JobSupport.kt_3.f24661c);
        return objM25720a;
    }
}
