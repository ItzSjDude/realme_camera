package c_renamed.c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes.dex */
public class c_renamed {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T_renamed> c_renamed.c_renamed.d_renamed<c_renamed.s_renamed> a_renamed(c_renamed.f_renamed.a_renamed.b_renamed<? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object> bVar, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        c_renamed.c_renamed.a_renamed.c_renamed.b_renamed bVar2;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "$this$createCoroutineUnintercepted");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(dVar, "completion");
        c_renamed.c_renamed.d_renamed<?> dVarA = c_renamed.c_renamed.b_renamed.a_renamed.g_renamed.a_renamed(dVar);
        if (bVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.a_renamed) {
            return ((c_renamed.c_renamed.b_renamed.a_renamed.a_renamed) bVar).create(dVarA);
        }
        c_renamed.c_renamed.g_renamed context = dVarA.getContext();
        if (context == c_renamed.c_renamed.h_renamed.INSTANCE) {
            if (dVarA == null) {
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            bVar2 = new c_renamed.c_renamed.a_renamed.c_renamed.a_renamed(dVarA, dVarA, bVar);
        } else if (dVarA != null) {
            bVar2 = new c_renamed.c_renamed.a_renamed.c_renamed.b_renamed(dVarA, context, dVarA, context, bVar);
        } else {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return bVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R_renamed, T_renamed> c_renamed.c_renamed.d_renamed<c_renamed.s_renamed> a_renamed(c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object> mVar, R_renamed r_renamed, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        c_renamed.c_renamed.a_renamed.c_renamed.d_renamed dVar2;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(mVar, "$this$createCoroutineUnintercepted");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(dVar, "completion");
        c_renamed.c_renamed.d_renamed<?> dVarA = c_renamed.c_renamed.b_renamed.a_renamed.g_renamed.a_renamed(dVar);
        if (mVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.a_renamed) {
            return ((c_renamed.c_renamed.b_renamed.a_renamed.a_renamed) mVar).create(r_renamed, dVarA);
        }
        c_renamed.c_renamed.g_renamed context = dVarA.getContext();
        if (context == c_renamed.c_renamed.h_renamed.INSTANCE) {
            if (dVarA == null) {
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            dVar2 = new c_renamed.c_renamed.a_renamed.c_renamed.IntrinsicsJvm.kt_3(dVarA, dVarA, mVar, r_renamed);
        } else if (dVarA != null) {
            dVar2 = new c_renamed.c_renamed.a_renamed.c_renamed.d_renamed(dVarA, context, dVarA, context, mVar, r_renamed);
        } else {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return dVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T_renamed> c_renamed.c_renamed.d_renamed<T_renamed> a_renamed(c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        c_renamed.c_renamed.d_renamed<T_renamed> dVar2;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(dVar, "$this$intercepted");
        c_renamed.c_renamed.b_renamed.a_renamed.c_renamed cVar = !(dVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.c_renamed) ? null : dVar;
        return (cVar == null || (dVar2 = (c_renamed.c_renamed.d_renamed<T_renamed>) cVar.intercepted()) == null) ? dVar : dVar2;
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class a_renamed extends c_renamed.c_renamed.b_renamed.a_renamed.i_renamed {
        final /* synthetic */ c_renamed.c_renamed.d_renamed $completion;
        final /* synthetic */ c_renamed.f_renamed.a_renamed.b_renamed $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public a_renamed(c_renamed.c_renamed.d_renamed dVar, c_renamed.c_renamed.d_renamed dVar2, c_renamed.f_renamed.a_renamed.b_renamed bVar) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = bVar;
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        protected java.lang.Object invokeSuspend(java.lang.Object obj) {
            int i_renamed = this.label;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    this.label = 2;
                    c_renamed.n_renamed.a_renamed(obj);
                    return obj;
                }
                throw new java.lang.IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            c_renamed.n_renamed.a_renamed(obj);
            c_renamed.c_renamed.a_renamed.c_renamed.a_renamed aVar = this;
            c_renamed.f_renamed.a_renamed.b_renamed bVar = this.$this_createCoroutineUnintercepted$inlined;
            if (bVar != null) {
                return ((c_renamed.f_renamed.a_renamed.b_renamed) c_renamed.f_renamed.b_renamed.m_renamed.b_renamed(bVar, 1)).invoke(aVar);
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type (kotlin.coroutines.Continuation<T_renamed>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: c_renamed.c_renamed.a_renamed.c_renamed$c_renamed, reason: collision with other inner class name */
    public static final class IntrinsicsJvm.kt_3 extends c_renamed.c_renamed.b_renamed.a_renamed.i_renamed {
        final /* synthetic */ c_renamed.c_renamed.d_renamed $completion;
        final /* synthetic */ java.lang.Object $receiver$inlined;
        final /* synthetic */ c_renamed.f_renamed.a_renamed.m_renamed $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public IntrinsicsJvm.kt_3(c_renamed.c_renamed.d_renamed dVar, c_renamed.c_renamed.d_renamed dVar2, c_renamed.f_renamed.a_renamed.m_renamed mVar, java.lang.Object obj) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = mVar;
            this.$receiver$inlined = obj;
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        protected java.lang.Object invokeSuspend(java.lang.Object obj) {
            int i_renamed = this.label;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    this.label = 2;
                    c_renamed.n_renamed.a_renamed(obj);
                    return obj;
                }
                throw new java.lang.IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            c_renamed.n_renamed.a_renamed(obj);
            c_renamed.c_renamed.a_renamed.c_renamed.IntrinsicsJvm.kt_3 c0043c = this;
            c_renamed.f_renamed.a_renamed.m_renamed mVar = this.$this_createCoroutineUnintercepted$inlined;
            if (mVar != null) {
                return ((c_renamed.f_renamed.a_renamed.m_renamed) c_renamed.f_renamed.b_renamed.m_renamed.b_renamed(mVar, 2)).invoke(this.$receiver$inlined, c0043c);
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type (R_renamed, kotlin.coroutines.Continuation<T_renamed>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class b_renamed extends c_renamed.c_renamed.b_renamed.a_renamed.c_renamed {
        final /* synthetic */ c_renamed.c_renamed.d_renamed $completion;
        final /* synthetic */ c_renamed.c_renamed.g_renamed $context;
        final /* synthetic */ c_renamed.f_renamed.a_renamed.b_renamed $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public b_renamed(c_renamed.c_renamed.d_renamed dVar, c_renamed.c_renamed.g_renamed gVar, c_renamed.c_renamed.d_renamed dVar2, c_renamed.c_renamed.g_renamed gVar2, c_renamed.f_renamed.a_renamed.b_renamed bVar) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = bVar;
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        protected java.lang.Object invokeSuspend(java.lang.Object obj) {
            int i_renamed = this.label;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    this.label = 2;
                    c_renamed.n_renamed.a_renamed(obj);
                    return obj;
                }
                throw new java.lang.IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            c_renamed.n_renamed.a_renamed(obj);
            c_renamed.c_renamed.a_renamed.c_renamed.b_renamed bVar = this;
            c_renamed.f_renamed.a_renamed.b_renamed bVar2 = this.$this_createCoroutineUnintercepted$inlined;
            if (bVar2 != null) {
                return ((c_renamed.f_renamed.a_renamed.b_renamed) c_renamed.f_renamed.b_renamed.m_renamed.b_renamed(bVar2, 1)).invoke(bVar);
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type (kotlin.coroutines.Continuation<T_renamed>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    public static final class d_renamed extends c_renamed.c_renamed.b_renamed.a_renamed.c_renamed {
        final /* synthetic */ c_renamed.c_renamed.d_renamed $completion;
        final /* synthetic */ c_renamed.c_renamed.g_renamed $context;
        final /* synthetic */ java.lang.Object $receiver$inlined;
        final /* synthetic */ c_renamed.f_renamed.a_renamed.m_renamed $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public d_renamed(c_renamed.c_renamed.d_renamed dVar, c_renamed.c_renamed.g_renamed gVar, c_renamed.c_renamed.d_renamed dVar2, c_renamed.c_renamed.g_renamed gVar2, c_renamed.f_renamed.a_renamed.m_renamed mVar, java.lang.Object obj) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = mVar;
            this.$receiver$inlined = obj;
        }

        @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
        protected java.lang.Object invokeSuspend(java.lang.Object obj) {
            int i_renamed = this.label;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    this.label = 2;
                    c_renamed.n_renamed.a_renamed(obj);
                    return obj;
                }
                throw new java.lang.IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            c_renamed.n_renamed.a_renamed(obj);
            c_renamed.c_renamed.a_renamed.c_renamed.d_renamed dVar = this;
            c_renamed.f_renamed.a_renamed.m_renamed mVar = this.$this_createCoroutineUnintercepted$inlined;
            if (mVar != null) {
                return ((c_renamed.f_renamed.a_renamed.m_renamed) c_renamed.f_renamed.b_renamed.m_renamed.b_renamed(mVar, 2)).invoke(this.$receiver$inlined, dVar);
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type (R_renamed, kotlin.coroutines.Continuation<T_renamed>) -> kotlin.Any?");
        }
    }
}
