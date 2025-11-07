package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public class bc_renamed implements kotlinx.coroutines.ay_renamed, kotlinx.coroutines.bj_renamed, kotlinx.coroutines.j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7836a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.bc_renamed.class, java.lang.Object.class, "_state");
    private volatile java.lang.Object _parentHandle;
    private volatile java.lang.Object _state;

    protected void b_renamed(java.lang.Object obj) {
    }

    protected void c_renamed(java.lang.Throwable th) {
    }

    protected boolean d_renamed(java.lang.Throwable th) {
        return false;
    }

    public void e_renamed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public java.lang.String f_renamed() {
        return "Job was cancelled";
    }

    protected void f_renamed(java.lang.Object obj) {
    }

    public boolean m_renamed() {
        return false;
    }

    protected boolean o_renamed() {
        return false;
    }

    public boolean p_renamed() {
        return true;
    }

    public bc_renamed(boolean z_renamed) {
        this._state = z_renamed ? kotlinx.coroutines.bd_renamed.g_renamed : kotlinx.coroutines.bd_renamed.f_renamed;
        this._parentHandle = null;
    }

    @Override // c_renamed.c_renamed.g_renamed
    public <R_renamed> R_renamed fold(R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
        return (R_renamed) kotlinx.coroutines.ay_renamed.a_renamed.a_renamed(this, r_renamed, mVar);
    }

    @Override // c_renamed.c_renamed.g_renamed.b_renamed, c_renamed.c_renamed.g_renamed
    public <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
        return (E_renamed) kotlinx.coroutines.ay_renamed.a_renamed.a_renamed(this, cVar);
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed minusKey(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        return kotlinx.coroutines.ay_renamed.a_renamed.b_renamed(this, cVar);
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed plus(c_renamed.c_renamed.g_renamed gVar) {
        return kotlinx.coroutines.ay_renamed.a_renamed.a_renamed(this, gVar);
    }

    @Override // c_renamed.c_renamed.g_renamed.b_renamed
    public final c_renamed.c_renamed.g_renamed.c_renamed<?> getKey() {
        return kotlinx.coroutines.ay_renamed.f7812b;
    }

    /* compiled from: LockFreeLinkedList.kt */
    public static final class c_renamed extends kotlinx.coroutines.internal.i_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.i_renamed f7839a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.bc_renamed f7840b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ java.lang.Object f7841c;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public c_renamed(kotlinx.coroutines.internal.i_renamed iVar, kotlinx.coroutines.internal.i_renamed iVar2, kotlinx.coroutines.bc_renamed bcVar, java.lang.Object obj) {
            super(iVar2);
            this.f7839a = iVar;
            this.f7840b = bcVar;
            this.f7841c = obj;
        }

        @Override // kotlinx.coroutines.internal.c_renamed
        public java.lang.Object a_renamed(kotlinx.coroutines.internal.i_renamed iVar) {
            if (this.f7840b.k_renamed() == this.f7841c) {
                return null;
            }
            return kotlinx.coroutines.internal.h_renamed.a_renamed();
        }
    }

    public final kotlinx.coroutines.h_renamed j_renamed() {
        return (kotlinx.coroutines.h_renamed) this._parentHandle;
    }

    public final void a_renamed(kotlinx.coroutines.h_renamed hVar) {
        this._parentHandle = hVar;
    }

    public final void a_renamed(kotlinx.coroutines.ay_renamed ayVar) {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(j_renamed() == null)) {
                throw new java.lang.AssertionError();
            }
        }
        if (ayVar == null) {
            a_renamed((kotlinx.coroutines.h_renamed) kotlinx.coroutines.bh_renamed.f7846a);
            return;
        }
        ayVar.i_renamed();
        kotlinx.coroutines.h_renamed hVarA = ayVar.a_renamed(this);
        a_renamed(hVarA);
        if (l_renamed()) {
            hVarA.a_renamed();
            a_renamed((kotlinx.coroutines.h_renamed) kotlinx.coroutines.bh_renamed.f7846a);
        }
    }

    @Override // kotlinx.coroutines.ay_renamed
    public boolean b_renamed() {
        java.lang.Object objK = k_renamed();
        return (objK instanceof kotlinx.coroutines.au_renamed) && ((kotlinx.coroutines.au_renamed) objK).b_renamed();
    }

    public final boolean l_renamed() {
        return !(k_renamed() instanceof kotlinx.coroutines.au_renamed);
    }

    private final java.lang.Object a_renamed(kotlinx.coroutines.bc_renamed.b_renamed bVar, java.lang.Object obj) throws java.lang.Throwable {
        boolean zF;
        java.lang.Throwable thA;
        boolean z_renamed = true;
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(k_renamed() == bVar)) {
                throw new java.lang.AssertionError();
            }
        }
        if (kotlinx.coroutines.ac_renamed.a_renamed() && !(!bVar.e_renamed())) {
            throw new java.lang.AssertionError();
        }
        if (kotlinx.coroutines.ac_renamed.a_renamed() && !bVar.c_renamed()) {
            throw new java.lang.AssertionError();
        }
        kotlinx.coroutines.l_renamed lVar = (kotlinx.coroutines.l_renamed) (!(obj instanceof kotlinx.coroutines.l_renamed) ? null : obj);
        java.lang.Throwable th = lVar != null ? lVar.f7899a : null;
        synchronized (bVar) {
            zF = bVar.f_renamed();
            java.util.List<java.lang.Throwable> listB = bVar.b_renamed(th);
            thA = a_renamed(bVar, (java.util.List<? extends java.lang.Throwable>) listB);
            if (thA != null) {
                a_renamed(thA, (java.util.List<? extends java.lang.Throwable>) listB);
            }
        }
        if (thA != null && thA != th) {
            obj = new kotlinx.coroutines.l_renamed(thA, false, 2, null);
        }
        if (thA != null) {
            if (!e_renamed(thA) && !d_renamed(thA)) {
                z_renamed = false;
            }
            if (z_renamed) {
                if (obj == null) {
                    throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((kotlinx.coroutines.l_renamed) obj).c_renamed();
            }
        }
        if (!zF) {
            c_renamed(thA);
        }
        b_renamed(obj);
        boolean zCompareAndSet = f7836a.compareAndSet(this, bVar, kotlinx.coroutines.bd_renamed.a_renamed(obj));
        if (kotlinx.coroutines.ac_renamed.a_renamed() && !zCompareAndSet) {
            throw new java.lang.AssertionError();
        }
        b_renamed(bVar, obj);
        return obj;
    }

    private final java.lang.Throwable a_renamed(kotlinx.coroutines.bc_renamed.b_renamed bVar, java.util.List<? extends java.lang.Throwable> list) {
        java.lang.Object next;
        java.lang.Object next2;
        if (list.isEmpty()) {
            if (!bVar.f_renamed()) {
                return null;
            }
            return new kotlinx.coroutines.az_renamed(f_renamed(), (java.lang.Throwable) null, this);
        }
        java.util.List<? extends java.lang.Throwable> list2 = list;
        java.util.Iterator<T_renamed> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((java.lang.Throwable) next) instanceof java.util.concurrent.CancellationException)) {
                break;
            }
        }
        java.lang.Throwable th = (java.lang.Throwable) next;
        if (th != null) {
            return th;
        }
        java.lang.Throwable th2 = list.get(0);
        if (th2 instanceof kotlinx.coroutines.bp_renamed) {
            java.util.Iterator<T_renamed> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                java.lang.Throwable th3 = (java.lang.Throwable) next2;
                if (th3 != th2 && (th3 instanceof kotlinx.coroutines.bp_renamed)) {
                    break;
                }
            }
            java.lang.Throwable th4 = (java.lang.Throwable) next2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final void a_renamed(java.lang.Throwable th, java.util.List<? extends java.lang.Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        java.util.Set setNewSetFromMap = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap(list.size()));
        java.lang.Throwable thA = !kotlinx.coroutines.ac_renamed.c_renamed() ? th : kotlinx.coroutines.internal.q_renamed.a_renamed(th);
        for (java.lang.Throwable thA2 : list) {
            if (kotlinx.coroutines.ac_renamed.c_renamed()) {
                thA2 = kotlinx.coroutines.internal.q_renamed.a_renamed(thA2);
            }
            if (thA2 != th && thA2 != thA && !(thA2 instanceof java.util.concurrent.CancellationException) && setNewSetFromMap.add(thA2)) {
                c_renamed.a_renamed.a_renamed(th, thA2);
            }
        }
    }

    private final boolean a_renamed(kotlinx.coroutines.au_renamed auVar, java.lang.Object obj) throws java.lang.Throwable {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!((auVar instanceof kotlinx.coroutines.al_renamed) || (auVar instanceof kotlinx.coroutines.bb_renamed))) {
                throw new java.lang.AssertionError();
            }
        }
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(!(obj instanceof kotlinx.coroutines.l_renamed))) {
                throw new java.lang.AssertionError();
            }
        }
        if (!f7836a.compareAndSet(this, auVar, kotlinx.coroutines.bd_renamed.a_renamed(obj))) {
            return false;
        }
        c_renamed((java.lang.Throwable) null);
        b_renamed(obj);
        b_renamed(auVar, obj);
        return true;
    }

    private final void b_renamed(kotlinx.coroutines.au_renamed auVar, java.lang.Object obj) throws java.lang.Throwable {
        kotlinx.coroutines.h_renamed hVarJ = j_renamed();
        if (hVarJ != null) {
            hVarJ.a_renamed();
            a_renamed((kotlinx.coroutines.h_renamed) kotlinx.coroutines.bh_renamed.f7846a);
        }
        if (!(obj instanceof kotlinx.coroutines.l_renamed)) {
            obj = null;
        }
        kotlinx.coroutines.l_renamed lVar = (kotlinx.coroutines.l_renamed) obj;
        java.lang.Throwable th = lVar != null ? lVar.f7899a : null;
        if (auVar instanceof kotlinx.coroutines.bb_renamed) {
            try {
                ((kotlinx.coroutines.bb_renamed) auVar).b_renamed(th);
                return;
            } catch (java.lang.Throwable th2) {
                a_renamed((java.lang.Throwable) new kotlinx.coroutines.q_renamed("Exception in_renamed completion handler " + auVar + " for " + this, th2));
                return;
            }
        }
        kotlinx.coroutines.bg_renamed bgVarK_ = auVar.k__renamed();
        if (bgVarK_ != null) {
            b_renamed(bgVarK_, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a_renamed(kotlinx.coroutines.bg_renamed r8, java.lang.Throwable r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.c_renamed(r9)
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlinx.coroutines.internal.g_renamed r8 = (kotlinx.coroutines.internal.g_renamed) r8
            java.lang.Object r1 = r8.e_renamed()
            if (r1 == 0) goto L60
            kotlinx.coroutines.internal.i_renamed r1 = (kotlinx.coroutines.internal.i_renamed) r1
        L10:
            boolean r2 = c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r1, r8)
            r2 = r2 ^ 1
            if (r2 == 0) goto L57
            boolean r2 = r1 instanceof kotlinx.coroutines.ba_renamed
            if (r2 == 0) goto L52
            r2 = r1
            kotlinx.coroutines.bb_renamed r2 = (kotlinx.coroutines.bb_renamed) r2
            r2.b_renamed(r9)     // Catch: java.lang.Throwable -> L23
            goto L52
        L23:
            r3 = move-exception
            if (r0 == 0) goto L2c
            c_renamed.a_renamed.a_renamed(r0, r3)
            if (r0 == 0) goto L2c
            goto L52
        L2c:
            r0 = r7
            kotlinx.coroutines.bc_renamed r0 = (kotlinx.coroutines.bc_renamed) r0
            kotlinx.coroutines.q_renamed r4 = new kotlinx.coroutines.q_renamed
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Exception in_renamed completion handler "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = " for "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.<init>(r0, r3)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            c_renamed.s_renamed r0 = c_renamed.s_renamed.f1925a
            r0 = r4
        L52:
            kotlinx.coroutines.internal.i_renamed r1 = r1.f_renamed()
            goto L10
        L57:
            if (r0 == 0) goto L5c
            r7.a_renamed(r0)
        L5c:
            r7.e_renamed(r9)
            return
        L60:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be_renamed cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bc_renamed.a_renamed(kotlinx.coroutines.bg_renamed, java.lang.Throwable):void");
    }

    private final boolean e_renamed(java.lang.Throwable th) {
        if (o_renamed()) {
            return true;
        }
        boolean z_renamed = th instanceof java.util.concurrent.CancellationException;
        kotlinx.coroutines.h_renamed hVarJ = j_renamed();
        return (hVarJ == null || hVarJ == kotlinx.coroutines.bh_renamed.f7846a) ? z_renamed : hVarJ.a_renamed(th) || z_renamed;
    }

    private final int a_renamed(java.lang.Object obj) {
        if (obj instanceof kotlinx.coroutines.al_renamed) {
            if (((kotlinx.coroutines.al_renamed) obj).b_renamed()) {
                return 0;
            }
            if (!f7836a.compareAndSet(this, obj, kotlinx.coroutines.bd_renamed.g_renamed)) {
                return -1;
            }
            e_renamed();
            return 1;
        }
        if (!(obj instanceof kotlinx.coroutines.at_renamed)) {
            return 0;
        }
        if (!f7836a.compareAndSet(this, obj, ((kotlinx.coroutines.at_renamed) obj).k__renamed())) {
            return -1;
        }
        e_renamed();
        return 1;
    }

    @Override // kotlinx.coroutines.ay_renamed
    public final java.util.concurrent.CancellationException h_renamed() {
        java.lang.Object objK = k_renamed();
        if (objK instanceof kotlinx.coroutines.bc_renamed.b_renamed) {
            java.lang.Throwable thD = ((kotlinx.coroutines.bc_renamed.b_renamed) objK).d_renamed();
            if (thD != null) {
                java.util.concurrent.CancellationException cancellationExceptionA = a_renamed(thD, kotlinx.coroutines.ad_renamed.b_renamed(this) + " is_renamed cancelling");
                if (cancellationExceptionA != null) {
                    return cancellationExceptionA;
                }
            }
            throw new java.lang.IllegalStateException(("Job is_renamed still new or active: " + this).toString());
        }
        if (objK instanceof kotlinx.coroutines.au_renamed) {
            throw new java.lang.IllegalStateException(("Job is_renamed still new or active: " + this).toString());
        }
        if (objK instanceof kotlinx.coroutines.l_renamed) {
            return a_renamed(this, ((kotlinx.coroutines.l_renamed) objK).f7899a, null, 1, null);
        }
        return new kotlinx.coroutines.az_renamed(kotlinx.coroutines.ad_renamed.b_renamed(this) + " has completed normally", null, this);
    }

    public static /* synthetic */ java.util.concurrent.CancellationException a_renamed(kotlinx.coroutines.bc_renamed bcVar, java.lang.Throwable th, java.lang.String str, int i_renamed, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in_renamed this target, function: toCancellationException");
        }
        if ((i_renamed & 1) != 0) {
            str = (java.lang.String) null;
        }
        return bcVar.a_renamed(th, str);
    }

    protected final java.util.concurrent.CancellationException a_renamed(java.lang.Throwable th, java.lang.String str) {
        java.util.concurrent.CancellationException cancellationException = (java.util.concurrent.CancellationException) (!(th instanceof java.util.concurrent.CancellationException) ? null : th);
        if (cancellationException != null) {
            return cancellationException;
        }
        if (str == null) {
            str = f_renamed();
        }
        return new kotlinx.coroutines.az_renamed(str, th, this);
    }

    @Override // kotlinx.coroutines.ay_renamed
    public final kotlinx.coroutines.ak_renamed a_renamed(boolean z_renamed, boolean z2, c_renamed.f_renamed.a_renamed.b_renamed<? super java.lang.Throwable, c_renamed.s_renamed> bVar) {
        kotlinx.coroutines.bb_renamed<?> bbVarA = (kotlinx.coroutines.bb_renamed) null;
        while (true) {
            java.lang.Object objK = k_renamed();
            if (objK instanceof kotlinx.coroutines.al_renamed) {
                kotlinx.coroutines.al_renamed alVar = (kotlinx.coroutines.al_renamed) objK;
                if (alVar.b_renamed()) {
                    if (bbVarA == null) {
                        bbVarA = a_renamed(bVar, z_renamed);
                    }
                    if (f7836a.compareAndSet(this, objK, bbVarA)) {
                        return bbVarA;
                    }
                } else {
                    a_renamed(alVar);
                }
            } else if (objK instanceof kotlinx.coroutines.au_renamed) {
                kotlinx.coroutines.bg_renamed bgVarK_ = ((kotlinx.coroutines.au_renamed) objK).k__renamed();
                if (bgVarK_ != null) {
                    java.lang.Throwable thD = (java.lang.Throwable) null;
                    kotlinx.coroutines.bb_renamed<?> bbVar = kotlinx.coroutines.bh_renamed.f7846a;
                    if (z_renamed && (objK instanceof kotlinx.coroutines.bc_renamed.b_renamed)) {
                        synchronized (objK) {
                            thD = ((kotlinx.coroutines.bc_renamed.b_renamed) objK).d_renamed();
                            if (thD == null || ((bVar instanceof kotlinx.coroutines.i_renamed) && !((kotlinx.coroutines.bc_renamed.b_renamed) objK).c_renamed())) {
                                if (bbVarA == null) {
                                    bbVarA = a_renamed(bVar, z_renamed);
                                }
                                if (a_renamed(objK, bgVarK_, bbVarA)) {
                                    if (thD == null) {
                                        return bbVarA;
                                    }
                                    bbVar = bbVarA;
                                }
                            }
                            c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                        }
                    }
                    if (thD != null) {
                        if (z2) {
                            bVar.invoke(thD);
                        }
                        return bbVar;
                    }
                    if (bbVarA == null) {
                        bbVarA = a_renamed(bVar, z_renamed);
                    }
                    if (a_renamed(objK, bgVarK_, bbVarA)) {
                        return bbVarA;
                    }
                } else {
                    if (objK == null) {
                        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.JobNode<*>");
                    }
                    b_renamed((kotlinx.coroutines.bb_renamed<?>) objK);
                }
            } else {
                if (z2) {
                    if (!(objK instanceof kotlinx.coroutines.l_renamed)) {
                        objK = null;
                    }
                    kotlinx.coroutines.l_renamed lVar = (kotlinx.coroutines.l_renamed) objK;
                    bVar.invoke(lVar != null ? lVar.f7899a : null);
                }
                return kotlinx.coroutines.bh_renamed.f7846a;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.bb_renamed<?> a_renamed(c_renamed.f_renamed.a_renamed.b_renamed<? super java.lang.Throwable, c_renamed.s_renamed> r5, boolean r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L39
            boolean r6 = r5 instanceof kotlinx.coroutines.ba_renamed
            if (r6 != 0) goto La
            goto Lb
        La:
            r2 = r5
        Lb:
            kotlinx.coroutines.ba_renamed r2 = (kotlinx.coroutines.ba_renamed) r2
            if (r2 == 0) goto L2c
            boolean r6 = kotlinx.coroutines.ac_renamed.a_renamed()
            if (r6 == 0) goto L29
            J_renamed extends kotlinx.coroutines.ay_renamed r6 = r2.f7835b
            r3 = r4
            kotlinx.coroutines.bc_renamed r3 = (kotlinx.coroutines.bc_renamed) r3
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
            kotlinx.coroutines.aw_renamed r6 = new kotlinx.coroutines.aw_renamed
            kotlinx.coroutines.ay_renamed r4 = (kotlinx.coroutines.ay_renamed) r4
            r6.<init>(r4, r5)
            r2 = r6
            kotlinx.coroutines.ba_renamed r2 = (kotlinx.coroutines.ba_renamed) r2
        L36:
            kotlinx.coroutines.bb_renamed r2 = (kotlinx.coroutines.bb_renamed) r2
            goto L6e
        L39:
            boolean r6 = r5 instanceof kotlinx.coroutines.bb_renamed
            if (r6 != 0) goto L3e
            goto L3f
        L3e:
            r2 = r5
        L3f:
            kotlinx.coroutines.bb_renamed r2 = (kotlinx.coroutines.bb_renamed) r2
            if (r2 == 0) goto L64
            boolean r6 = kotlinx.coroutines.ac_renamed.a_renamed()
            if (r6 == 0) goto L61
            J_renamed extends kotlinx.coroutines.ay_renamed r6 = r2.f7835b
            r3 = r4
            kotlinx.coroutines.bc_renamed r3 = (kotlinx.coroutines.bc_renamed) r3
            if (r6 != r3) goto L55
            boolean r6 = r2 instanceof kotlinx.coroutines.ba_renamed
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
            kotlinx.coroutines.ax_renamed r6 = new kotlinx.coroutines.ax_renamed
            kotlinx.coroutines.ay_renamed r4 = (kotlinx.coroutines.ay_renamed) r4
            r6.<init>(r4, r5)
            r2 = r6
            kotlinx.coroutines.bb_renamed r2 = (kotlinx.coroutines.bb_renamed) r2
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bc_renamed.a_renamed(c_renamed.f_renamed.a_renamed.b_renamed, boolean):kotlinx.coroutines.bb_renamed");
    }

    private final boolean a_renamed(java.lang.Object obj, kotlinx.coroutines.bg_renamed bgVar, kotlinx.coroutines.bb_renamed<?> bbVar) {
        int iA;
        kotlinx.coroutines.bg_renamed bgVar2 = bgVar;
        kotlinx.coroutines.bb_renamed<?> bbVar2 = bbVar;
        kotlinx.coroutines.bc_renamed.c_renamed cVar = new kotlinx.coroutines.bc_renamed.c_renamed(bbVar2, bbVar2, this, obj);
        do {
            iA = bgVar2.g_renamed().a_renamed(bbVar2, bgVar2, cVar);
            if (iA == 1) {
                return true;
            }
        } while (iA != 2);
        return false;
    }

    private final void a_renamed(kotlinx.coroutines.al_renamed alVar) {
        kotlinx.coroutines.bg_renamed bgVar = new kotlinx.coroutines.bg_renamed();
        f7836a.compareAndSet(this, alVar, alVar.b_renamed() ? bgVar : new kotlinx.coroutines.at_renamed(bgVar));
    }

    private final void b_renamed(kotlinx.coroutines.bb_renamed<?> bbVar) {
        bbVar.a_renamed(new kotlinx.coroutines.bg_renamed());
        f7836a.compareAndSet(this, bbVar, bbVar.f_renamed());
    }

    @Override // kotlinx.coroutines.j_renamed
    public final void a_renamed(kotlinx.coroutines.bj_renamed bjVar) throws java.lang.Throwable {
        d_renamed(bjVar);
    }

    public boolean b_renamed(java.lang.Throwable th) {
        if (th instanceof java.util.concurrent.CancellationException) {
            return true;
        }
        return d_renamed((java.lang.Object) th) && p_renamed();
    }

    public final boolean d_renamed(java.lang.Object obj) throws java.lang.Throwable {
        java.lang.Object objH = kotlinx.coroutines.bd_renamed.f7843b;
        if (m_renamed() && (objH = c_renamed(obj)) == kotlinx.coroutines.bd_renamed.f7842a) {
            return true;
        }
        if (objH == kotlinx.coroutines.bd_renamed.f7843b) {
            objH = h_renamed(obj);
        }
        if (objH == kotlinx.coroutines.bd_renamed.f7843b || objH == kotlinx.coroutines.bd_renamed.f7842a) {
            return true;
        }
        if (objH == kotlinx.coroutines.bd_renamed.d_renamed) {
            return false;
        }
        f_renamed(objH);
        return true;
    }

    @Override // kotlinx.coroutines.bj_renamed
    public java.util.concurrent.CancellationException n_renamed() {
        java.lang.Throwable thD;
        java.lang.Object objK = k_renamed();
        if (objK instanceof kotlinx.coroutines.bc_renamed.b_renamed) {
            thD = ((kotlinx.coroutines.bc_renamed.b_renamed) objK).d_renamed();
        } else if (objK instanceof kotlinx.coroutines.l_renamed) {
            thD = ((kotlinx.coroutines.l_renamed) objK).f7899a;
        } else {
            if (objK instanceof kotlinx.coroutines.au_renamed) {
                throw new java.lang.IllegalStateException(("Cannot be_renamed cancelling child in_renamed this state: " + objK).toString());
            }
            thD = null;
        }
        java.util.concurrent.CancellationException cancellationException = (java.util.concurrent.CancellationException) (thD instanceof java.util.concurrent.CancellationException ? thD : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        return new kotlinx.coroutines.az_renamed("Parent job is_renamed " + j_renamed(objK), thD, this);
    }

    private final java.lang.Throwable g_renamed(java.lang.Object obj) {
        if (!(obj != null ? obj instanceof java.lang.Throwable : true)) {
            if (obj != null) {
                return ((kotlinx.coroutines.bj_renamed) obj).n_renamed();
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.ParentJob");
        }
        if (obj != null) {
            return (java.lang.Throwable) obj;
        }
        return new kotlinx.coroutines.az_renamed(f_renamed(), (java.lang.Throwable) null, this);
    }

    private final java.lang.Object h_renamed(java.lang.Object obj) throws java.lang.Throwable {
        java.lang.Throwable thG = (java.lang.Throwable) null;
        while (true) {
            java.lang.Object objK = k_renamed();
            if (!(objK instanceof kotlinx.coroutines.bc_renamed.b_renamed)) {
                if (!(objK instanceof kotlinx.coroutines.au_renamed)) {
                    return kotlinx.coroutines.bd_renamed.d_renamed;
                }
                if (thG == null) {
                    thG = g_renamed(obj);
                }
                kotlinx.coroutines.au_renamed auVar = (kotlinx.coroutines.au_renamed) objK;
                if (auVar.b_renamed()) {
                    if (a_renamed(auVar, thG)) {
                        return kotlinx.coroutines.bd_renamed.f7843b;
                    }
                } else {
                    java.lang.Object objA = a_renamed(objK, new kotlinx.coroutines.l_renamed(thG, false, 2, null));
                    if (objA != kotlinx.coroutines.bd_renamed.f7843b) {
                        if (objA != kotlinx.coroutines.bd_renamed.f7844c) {
                            return objA;
                        }
                    } else {
                        throw new java.lang.IllegalStateException(("Cannot happen in_renamed " + objK).toString());
                    }
                }
            } else {
                synchronized (objK) {
                    if (((kotlinx.coroutines.bc_renamed.b_renamed) objK).e_renamed()) {
                        return kotlinx.coroutines.bd_renamed.d_renamed;
                    }
                    boolean zF = ((kotlinx.coroutines.bc_renamed.b_renamed) objK).f_renamed();
                    if (obj != null || !zF) {
                        if (thG == null) {
                            thG = g_renamed(obj);
                        }
                        ((kotlinx.coroutines.bc_renamed.b_renamed) objK).c_renamed(thG);
                    }
                    java.lang.Throwable thD = ((kotlinx.coroutines.bc_renamed.b_renamed) objK).d_renamed();
                    if (!(!zF)) {
                        thD = null;
                    }
                    if (thD != null) {
                        a_renamed(((kotlinx.coroutines.bc_renamed.b_renamed) objK).k__renamed(), thD);
                    }
                    return kotlinx.coroutines.bd_renamed.f7843b;
                }
            }
        }
    }

    private final kotlinx.coroutines.bg_renamed a_renamed(kotlinx.coroutines.au_renamed auVar) {
        kotlinx.coroutines.bg_renamed bgVarK_ = auVar.k__renamed();
        if (bgVarK_ != null) {
            return bgVarK_;
        }
        if (auVar instanceof kotlinx.coroutines.al_renamed) {
            return new kotlinx.coroutines.bg_renamed();
        }
        if (auVar instanceof kotlinx.coroutines.bb_renamed) {
            b_renamed((kotlinx.coroutines.bb_renamed<?>) auVar);
            return null;
        }
        throw new java.lang.IllegalStateException(("State should have list: " + auVar).toString());
    }

    private final boolean a_renamed(kotlinx.coroutines.au_renamed auVar, java.lang.Throwable th) throws java.lang.Throwable {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(!(auVar instanceof kotlinx.coroutines.bc_renamed.b_renamed))) {
                throw new java.lang.AssertionError();
            }
        }
        if (kotlinx.coroutines.ac_renamed.a_renamed() && !auVar.b_renamed()) {
            throw new java.lang.AssertionError();
        }
        kotlinx.coroutines.bg_renamed bgVarA = a_renamed(auVar);
        if (bgVarA == null) {
            return false;
        }
        if (!f7836a.compareAndSet(this, auVar, new kotlinx.coroutines.bc_renamed.b_renamed(bgVarA, false, th))) {
            return false;
        }
        a_renamed(bgVarA, th);
        return true;
    }

    private final java.lang.Object a_renamed(java.lang.Object obj, java.lang.Object obj2) {
        if (!(obj instanceof kotlinx.coroutines.au_renamed)) {
            return kotlinx.coroutines.bd_renamed.f7843b;
        }
        if ((!(obj instanceof kotlinx.coroutines.al_renamed) && !(obj instanceof kotlinx.coroutines.bb_renamed)) || (obj instanceof kotlinx.coroutines.i_renamed) || (obj2 instanceof kotlinx.coroutines.l_renamed)) {
            return c_renamed((kotlinx.coroutines.au_renamed) obj, obj2);
        }
        return a_renamed((kotlinx.coroutines.au_renamed) obj, obj2) ? obj2 : kotlinx.coroutines.bd_renamed.f7844c;
    }

    private final java.lang.Object c_renamed(kotlinx.coroutines.au_renamed auVar, java.lang.Object obj) throws java.lang.Throwable {
        kotlinx.coroutines.bg_renamed bgVarA = a_renamed(auVar);
        if (bgVarA == null) {
            return kotlinx.coroutines.bd_renamed.f7844c;
        }
        kotlinx.coroutines.bc_renamed.b_renamed bVar = (kotlinx.coroutines.bc_renamed.b_renamed) (!(auVar instanceof kotlinx.coroutines.bc_renamed.b_renamed) ? null : auVar);
        if (bVar == null) {
            bVar = new kotlinx.coroutines.bc_renamed.b_renamed(bgVarA, false, null);
        }
        synchronized (bVar) {
            if (bVar.c_renamed()) {
                return kotlinx.coroutines.bd_renamed.f7843b;
            }
            bVar.a_renamed(true);
            if (bVar != auVar && !f7836a.compareAndSet(this, auVar, bVar)) {
                return kotlinx.coroutines.bd_renamed.f7844c;
            }
            if (kotlinx.coroutines.ac_renamed.a_renamed() && !(!bVar.e_renamed())) {
                throw new java.lang.AssertionError();
            }
            boolean zF = bVar.f_renamed();
            kotlinx.coroutines.l_renamed lVar = (kotlinx.coroutines.l_renamed) (!(obj instanceof kotlinx.coroutines.l_renamed) ? null : obj);
            if (lVar != null) {
                bVar.c_renamed(lVar.f7899a);
            }
            java.lang.Throwable thD = true ^ zF ? bVar.d_renamed() : null;
            c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
            if (thD != null) {
                a_renamed(bgVarA, thD);
            }
            kotlinx.coroutines.i_renamed iVarB = b_renamed(auVar);
            if (iVarB != null && a_renamed(bVar, iVarB, obj)) {
                return kotlinx.coroutines.bd_renamed.f7842a;
            }
            return a_renamed(bVar, obj);
        }
    }

    private final java.lang.Throwable i_renamed(java.lang.Object obj) {
        if (!(obj instanceof kotlinx.coroutines.l_renamed)) {
            obj = null;
        }
        kotlinx.coroutines.l_renamed lVar = (kotlinx.coroutines.l_renamed) obj;
        if (lVar != null) {
            return lVar.f7899a;
        }
        return null;
    }

    private final kotlinx.coroutines.i_renamed b_renamed(kotlinx.coroutines.au_renamed auVar) {
        kotlinx.coroutines.i_renamed iVar = (kotlinx.coroutines.i_renamed) (!(auVar instanceof kotlinx.coroutines.i_renamed) ? null : auVar);
        if (iVar != null) {
            return iVar;
        }
        kotlinx.coroutines.bg_renamed bgVarK_ = auVar.k__renamed();
        if (bgVarK_ != null) {
            return a_renamed((kotlinx.coroutines.internal.i_renamed) bgVarK_);
        }
        return null;
    }

    private final boolean a_renamed(kotlinx.coroutines.bc_renamed.b_renamed bVar, kotlinx.coroutines.i_renamed iVar, java.lang.Object obj) {
        while (kotlinx.coroutines.ay_renamed.a_renamed.a_renamed(iVar.f7857a, false, false, new kotlinx.coroutines.bc_renamed.a_renamed(this, bVar, iVar, obj), 1, null) == kotlinx.coroutines.bh_renamed.f7846a) {
            iVar = a_renamed((kotlinx.coroutines.internal.i_renamed) iVar);
            if (iVar == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b_renamed(kotlinx.coroutines.bc_renamed.b_renamed bVar, kotlinx.coroutines.i_renamed iVar, java.lang.Object obj) {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(k_renamed() == bVar)) {
                throw new java.lang.AssertionError();
            }
        }
        kotlinx.coroutines.i_renamed iVarA = a_renamed((kotlinx.coroutines.internal.i_renamed) iVar);
        if (iVarA == null || !a_renamed(bVar, iVarA, obj)) {
            f_renamed(a_renamed(bVar, obj));
        }
    }

    private final kotlinx.coroutines.i_renamed a_renamed(kotlinx.coroutines.internal.i_renamed iVar) {
        while (iVar.d_renamed()) {
            iVar = iVar.g_renamed();
        }
        while (true) {
            iVar = iVar.f_renamed();
            if (!iVar.d_renamed()) {
                if (iVar instanceof kotlinx.coroutines.i_renamed) {
                    return (kotlinx.coroutines.i_renamed) iVar;
                }
                if (iVar instanceof kotlinx.coroutines.bg_renamed) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.ay_renamed
    public final kotlinx.coroutines.h_renamed a_renamed(kotlinx.coroutines.j_renamed jVar) {
        kotlinx.coroutines.ak_renamed akVarA = kotlinx.coroutines.ay_renamed.a_renamed.a_renamed(this, true, false, new kotlinx.coroutines.i_renamed(this, jVar), 2, null);
        if (akVarA != null) {
            return (kotlinx.coroutines.h_renamed) akVarA;
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public void a_renamed(java.lang.Throwable th) throws java.lang.Throwable {
        throw th;
    }

    public java.lang.String toString() {
        return q_renamed() + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this);
    }

    public final java.lang.String q_renamed() {
        return g_renamed() + '{' + j_renamed(k_renamed()) + '}';
    }

    public java.lang.String g_renamed() {
        return kotlinx.coroutines.ad_renamed.b_renamed(this);
    }

    private final java.lang.String j_renamed(java.lang.Object obj) {
        if (!(obj instanceof kotlinx.coroutines.bc_renamed.b_renamed)) {
            return obj instanceof kotlinx.coroutines.au_renamed ? ((kotlinx.coroutines.au_renamed) obj).b_renamed() ? "Active" : "New" : obj instanceof kotlinx.coroutines.l_renamed ? "Cancelled" : "Completed";
        }
        kotlinx.coroutines.bc_renamed.b_renamed bVar = (kotlinx.coroutines.bc_renamed.b_renamed) obj;
        return bVar.f_renamed() ? "Cancelling" : bVar.c_renamed() ? "Completing" : "Active";
    }

    /* compiled from: JobSupport.kt */
    private static final class b_renamed implements kotlinx.coroutines.au_renamed {
        private volatile java.lang.Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile java.lang.Object _rootCause;

        /* renamed from: a_renamed, reason: collision with root package name */
        private final kotlinx.coroutines.bg_renamed f7838a;

        @Override // kotlinx.coroutines.au_renamed
        public kotlinx.coroutines.bg_renamed k__renamed() {
            return this.f7838a;
        }

        public b_renamed(kotlinx.coroutines.bg_renamed bgVar, boolean z_renamed, java.lang.Throwable th) {
            this.f7838a = bgVar;
            this._isCompleting = z_renamed ? 1 : 0;
            this._rootCause = th;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
        public final boolean c_renamed() {
            return this._isCompleting;
        }

        public final void a_renamed(boolean z_renamed) {
            this._isCompleting = z_renamed ? 1 : 0;
        }

        public final java.lang.Throwable d_renamed() {
            return (java.lang.Throwable) this._rootCause;
        }

        public final void a_renamed(java.lang.Throwable th) {
            this._rootCause = th;
        }

        private final java.lang.Object g_renamed() {
            return this._exceptionsHolder;
        }

        private final void a_renamed(java.lang.Object obj) {
            this._exceptionsHolder = obj;
        }

        public final boolean e_renamed() {
            return g_renamed() == kotlinx.coroutines.bd_renamed.e_renamed;
        }

        public final boolean f_renamed() {
            return d_renamed() != null;
        }

        @Override // kotlinx.coroutines.au_renamed
        public boolean b_renamed() {
            return d_renamed() == null;
        }

        public final java.util.List<java.lang.Throwable> b_renamed(java.lang.Throwable th) {
            java.util.ArrayList<java.lang.Throwable> arrayListH;
            java.lang.Object objG = g_renamed();
            if (objG == null) {
                arrayListH = h_renamed();
            } else if (objG instanceof java.lang.Throwable) {
                java.util.ArrayList<java.lang.Throwable> arrayListH2 = h_renamed();
                arrayListH2.add(objG);
                arrayListH = arrayListH2;
            } else {
                if (!(objG instanceof java.util.ArrayList)) {
                    throw new java.lang.IllegalStateException(("State is_renamed " + objG).toString());
                }
                arrayListH = (java.util.ArrayList) objG;
            }
            java.lang.Throwable thD = d_renamed();
            if (thD != null) {
                arrayListH.add(0, thD);
            }
            if (th != null && (!c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(th, thD))) {
                arrayListH.add(th);
            }
            a_renamed(kotlinx.coroutines.bd_renamed.e_renamed);
            return arrayListH;
        }

        public final void c_renamed(java.lang.Throwable th) {
            java.lang.Throwable thD = d_renamed();
            if (thD == null) {
                a_renamed(th);
                return;
            }
            if (th == thD) {
                return;
            }
            java.lang.Object objG = g_renamed();
            if (objG == null) {
                a_renamed((java.lang.Object) th);
                return;
            }
            if (!(objG instanceof java.lang.Throwable)) {
                if (objG instanceof java.util.ArrayList) {
                    ((java.util.ArrayList) objG).add(th);
                    return;
                }
                throw new java.lang.IllegalStateException(("State is_renamed " + objG).toString());
            }
            if (th == objG) {
                return;
            }
            java.util.ArrayList<java.lang.Throwable> arrayListH = h_renamed();
            arrayListH.add(objG);
            arrayListH.add(th);
            c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
            a_renamed(arrayListH);
        }

        private final java.util.ArrayList<java.lang.Throwable> h_renamed() {
            return new java.util.ArrayList<>(4);
        }

        public java.lang.String toString() {
            return "Finishing[cancelling=" + f_renamed() + ", completing=" + c_renamed() + ", rootCause=" + d_renamed() + ", exceptions=" + g_renamed() + ", list=" + k__renamed() + ']';
        }
    }

    /* compiled from: JobSupport.kt */
    private static final class a_renamed extends kotlinx.coroutines.bb_renamed<kotlinx.coroutines.ay_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final kotlinx.coroutines.bc_renamed f7837a;
        private final kotlinx.coroutines.bc_renamed.b_renamed e_renamed;
        private final kotlinx.coroutines.i_renamed f_renamed;
        private final java.lang.Object g_renamed;

        @Override // c_renamed.f_renamed.a_renamed.b_renamed
        public /* synthetic */ c_renamed.s_renamed invoke(java.lang.Throwable th) {
            b_renamed(th);
            return c_renamed.s_renamed.f1925a;
        }

        public a_renamed(kotlinx.coroutines.bc_renamed bcVar, kotlinx.coroutines.bc_renamed.b_renamed bVar, kotlinx.coroutines.i_renamed iVar, java.lang.Object obj) {
            super(iVar.f7857a);
            this.f7837a = bcVar;
            this.e_renamed = bVar;
            this.f_renamed = iVar;
            this.g_renamed = obj;
        }

        @Override // kotlinx.coroutines.p_renamed
        public void b_renamed(java.lang.Throwable th) {
            this.f7837a.b_renamed(this.e_renamed, this.f_renamed, this.g_renamed);
        }

        @Override // kotlinx.coroutines.internal.i_renamed
        public java.lang.String toString() {
            return "ChildCompletion[" + this.f_renamed + ", " + this.g_renamed + ']';
        }
    }

    public final java.lang.Object k_renamed() {
        while (true) {
            java.lang.Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.o_renamed)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.o_renamed) obj).c_renamed(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b_renamed(kotlinx.coroutines.bg_renamed r8, java.lang.Throwable r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlinx.coroutines.internal.g_renamed r8 = (kotlinx.coroutines.internal.g_renamed) r8
            java.lang.Object r1 = r8.e_renamed()
            if (r1 == 0) goto L5a
            kotlinx.coroutines.internal.i_renamed r1 = (kotlinx.coroutines.internal.i_renamed) r1
        Ld:
            boolean r2 = c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r1, r8)
            r2 = r2 ^ 1
            if (r2 == 0) goto L54
            boolean r2 = r1 instanceof kotlinx.coroutines.bb_renamed
            if (r2 == 0) goto L4f
            r2 = r1
            kotlinx.coroutines.bb_renamed r2 = (kotlinx.coroutines.bb_renamed) r2
            r2.b_renamed(r9)     // Catch: java.lang.Throwable -> L20
            goto L4f
        L20:
            r3 = move-exception
            if (r0 == 0) goto L29
            c_renamed.a_renamed.a_renamed(r0, r3)
            if (r0 == 0) goto L29
            goto L4f
        L29:
            r0 = r7
            kotlinx.coroutines.bc_renamed r0 = (kotlinx.coroutines.bc_renamed) r0
            kotlinx.coroutines.q_renamed r4 = new kotlinx.coroutines.q_renamed
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Exception in_renamed completion handler "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = " for "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.<init>(r0, r3)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            c_renamed.s_renamed r0 = c_renamed.s_renamed.f1925a
            r0 = r4
        L4f:
            kotlinx.coroutines.internal.i_renamed r1 = r1.f_renamed()
            goto Ld
        L54:
            if (r0 == 0) goto L59
            r7.a_renamed(r0)
        L59:
            return
        L5a:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be_renamed cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bc_renamed.b_renamed(kotlinx.coroutines.bg_renamed, java.lang.Throwable):void");
    }

    @Override // kotlinx.coroutines.ay_renamed
    public final boolean i_renamed() {
        int iA;
        do {
            iA = a_renamed(k_renamed());
            if (iA == 0) {
                return false;
            }
        } while (iA != 1);
        return true;
    }

    public final void a_renamed(kotlinx.coroutines.bb_renamed<?> bbVar) {
        java.lang.Object objK;
        do {
            objK = k_renamed();
            if (!(objK instanceof kotlinx.coroutines.bb_renamed)) {
                if (!(objK instanceof kotlinx.coroutines.au_renamed) || ((kotlinx.coroutines.au_renamed) objK).k__renamed() == null) {
                    return;
                }
                bbVar.c_renamed();
                return;
            }
            if (objK != bbVar) {
                return;
            }
        } while (!f7836a.compareAndSet(this, objK, kotlinx.coroutines.bd_renamed.g_renamed));
    }

    private final java.lang.Object c_renamed(java.lang.Object obj) {
        java.lang.Object objA;
        do {
            java.lang.Object objK = k_renamed();
            if (!(objK instanceof kotlinx.coroutines.au_renamed) || ((objK instanceof kotlinx.coroutines.bc_renamed.b_renamed) && ((kotlinx.coroutines.bc_renamed.b_renamed) objK).c_renamed())) {
                return kotlinx.coroutines.bd_renamed.f7843b;
            }
            objA = a_renamed(objK, new kotlinx.coroutines.l_renamed(g_renamed(obj), false, 2, null));
        } while (objA == kotlinx.coroutines.bd_renamed.f7844c);
        return objA;
    }

    public final java.lang.Object e_renamed(java.lang.Object obj) {
        java.lang.Object objA;
        do {
            objA = a_renamed(k_renamed(), obj);
            if (objA == kotlinx.coroutines.bd_renamed.f7843b) {
                throw new java.lang.IllegalStateException("Job " + this + " is_renamed already complete or completing, but is_renamed being completed with " + obj, i_renamed(obj));
            }
        } while (objA == kotlinx.coroutines.bd_renamed.f7844c);
        return objA;
    }
}
