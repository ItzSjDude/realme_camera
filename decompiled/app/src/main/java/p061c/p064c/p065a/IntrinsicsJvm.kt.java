package p061c.p064c.p065a;

import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.CoroutineContextImpl.kt_3;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.p066b.p067a.AbstractC0918a;
import p061c.p064c.p066b.p067a.ContinuationImpl.kt;
import p061c.p064c.p066b.p067a.ContinuationImpl.kt_2;
import p061c.p064c.p066b.p067a.DebugProbes.kt_2;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Intrinsics;
import p061c.p070f.p072b.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class IntrinsicsJvm.kt {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Continuation.kt_2<Unit.kt> m5250a(Functions.kt_3<? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0943b, Continuation.kt_2<? super T> interfaceC0929d) {
        IntrinsicsJvm.kt_4 bVar;
        Intrinsics.m5305d(interfaceC0943b, "$this$createCoroutineUnintercepted");
        Intrinsics.m5305d(interfaceC0929d, "completion");
        Continuation.kt_2<?> interfaceC0929dM5264a = DebugProbes.kt_2.m5264a(interfaceC0929d);
        if (interfaceC0943b instanceof AbstractC0918a) {
            return ((AbstractC0918a) interfaceC0943b).create(interfaceC0929dM5264a);
        }
        CoroutineContext.kt_4 context = interfaceC0929dM5264a.getContext();
        if (context == CoroutineContextImpl.kt_3.INSTANCE) {
            if (interfaceC0929dM5264a == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            bVar = new PlatformImplementations.kt_3(interfaceC0929dM5264a, interfaceC0929dM5264a, interfaceC0943b);
        } else if (interfaceC0929dM5264a != null) {
            bVar = new IntrinsicsJvm.kt_4(interfaceC0929dM5264a, context, interfaceC0929dM5264a, context, interfaceC0943b);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <R, T> Continuation.kt_2<Unit.kt> m5251a(Functions.kt_19<? super R, ? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0954m, R r, Continuation.kt_2<? super T> interfaceC0929d) {
        IntrinsicsJvm.kt_5 dVar;
        Intrinsics.m5305d(interfaceC0954m, "$this$createCoroutineUnintercepted");
        Intrinsics.m5305d(interfaceC0929d, "completion");
        Continuation.kt_2<?> interfaceC0929dM5264a = DebugProbes.kt_2.m5264a(interfaceC0929d);
        if (interfaceC0954m instanceof AbstractC0918a) {
            return ((AbstractC0918a) interfaceC0954m).create(r, interfaceC0929dM5264a);
        }
        CoroutineContext.kt_4 context = interfaceC0929dM5264a.getContext();
        if (context == CoroutineContextImpl.kt_3.INSTANCE) {
            if (interfaceC0929dM5264a == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            dVar = new IntrinsicsJvm.kt_3(interfaceC0929dM5264a, interfaceC0929dM5264a, interfaceC0954m, r);
        } else if (interfaceC0929dM5264a != null) {
            dVar = new IntrinsicsJvm.kt_5(interfaceC0929dM5264a, context, interfaceC0929dM5264a, context, interfaceC0954m, r);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Continuation.kt_2<T> m5249a(Continuation.kt_2<? super T> interfaceC0929d) {
        Continuation.kt_2<T> interfaceC0929d2;
        Intrinsics.m5305d(interfaceC0929d, "$this$intercepted");
        ContinuationImpl.kt abstractC0920c = !(interfaceC0929d instanceof ContinuationImpl.kt) ? null : interfaceC0929d;
        return (abstractC0920c == null || (interfaceC0929d2 = (Continuation.kt_2<T>) abstractC0920c.intercepted()) == null) ? interfaceC0929d : interfaceC0929d2;
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 extends ContinuationImpl.kt_2 {
        final /* synthetic */ Continuation.kt_2 $completion;
        final /* synthetic */ Functions.kt_3 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformImplementations.kt_3(Continuation.kt_2 interfaceC0929d, Continuation.kt_2 interfaceC0929d2, Functions.kt_3 interfaceC0943b) {
            super(interfaceC0929d2);
            this.$completion = interfaceC0929d;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC0943b;
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        protected Object invokeSuspend(Object obj) {
            int OplusGLSurfaceView_13 = this.label;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 == 1) {
                    this.label = 2;
                    Result.kt_4.m5381a(obj);
                    return obj;
                }
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            Result.kt_4.m5381a(obj);
            PlatformImplementations.kt_3 aVar = this;
            Functions.kt_3 interfaceC0943b = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC0943b != null) {
                return ((Functions.kt_3) TypeIntrinsics.m5320b(interfaceC0943b, 1)).invoke(aVar);
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    public static final class IntrinsicsJvm.kt_3 extends ContinuationImpl.kt_2 {
        final /* synthetic */ Continuation.kt_2 $completion;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ Functions.kt_19 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntrinsicsJvm.kt_3(Continuation.kt_2 interfaceC0929d, Continuation.kt_2 interfaceC0929d2, Functions.kt_19 interfaceC0954m, Object obj) {
            super(interfaceC0929d2);
            this.$completion = interfaceC0929d;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC0954m;
            this.$receiver$inlined = obj;
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        protected Object invokeSuspend(Object obj) {
            int OplusGLSurfaceView_13 = this.label;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 == 1) {
                    this.label = 2;
                    Result.kt_4.m5381a(obj);
                    return obj;
                }
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            Result.kt_4.m5381a(obj);
            IntrinsicsJvm.kt_3 cVar = this;
            Functions.kt_19 interfaceC0954m = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC0954m != null) {
                return ((Functions.kt_19) TypeIntrinsics.m5320b(interfaceC0954m, 2)).invoke(this.$receiver$inlined, cVar);
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 extends ContinuationImpl.kt {
        final /* synthetic */ Continuation.kt_2 $completion;
        final /* synthetic */ CoroutineContext.kt_4 $context;
        final /* synthetic */ Functions.kt_3 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntrinsicsJvm.kt_4(Continuation.kt_2 interfaceC0929d, CoroutineContext.kt_4 interfaceC0932g, Continuation.kt_2 interfaceC0929d2, CoroutineContext.kt_4 interfaceC0932g2, Functions.kt_3 interfaceC0943b) {
            super(interfaceC0929d2, interfaceC0932g2);
            this.$completion = interfaceC0929d;
            this.$context = interfaceC0932g;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC0943b;
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        protected Object invokeSuspend(Object obj) {
            int OplusGLSurfaceView_13 = this.label;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 == 1) {
                    this.label = 2;
                    Result.kt_4.m5381a(obj);
                    return obj;
                }
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            Result.kt_4.m5381a(obj);
            IntrinsicsJvm.kt_4 bVar = this;
            Functions.kt_3 interfaceC0943b = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC0943b != null) {
                return ((Functions.kt_3) TypeIntrinsics.m5320b(interfaceC0943b, 1)).invoke(bVar);
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_5 */
    public static final class IntrinsicsJvm.kt_5 extends ContinuationImpl.kt {
        final /* synthetic */ Continuation.kt_2 $completion;
        final /* synthetic */ CoroutineContext.kt_4 $context;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ Functions.kt_19 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntrinsicsJvm.kt_5(Continuation.kt_2 interfaceC0929d, CoroutineContext.kt_4 interfaceC0932g, Continuation.kt_2 interfaceC0929d2, CoroutineContext.kt_4 interfaceC0932g2, Functions.kt_19 interfaceC0954m, Object obj) {
            super(interfaceC0929d2, interfaceC0932g2);
            this.$completion = interfaceC0929d;
            this.$context = interfaceC0932g;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC0954m;
            this.$receiver$inlined = obj;
        }

        @Override // p061c.p064c.p066b.p067a.AbstractC0918a
        protected Object invokeSuspend(Object obj) {
            int OplusGLSurfaceView_13 = this.label;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 == 1) {
                    this.label = 2;
                    Result.kt_4.m5381a(obj);
                    return obj;
                }
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 1;
            Result.kt_4.m5381a(obj);
            IntrinsicsJvm.kt_5 dVar = this;
            Functions.kt_19 interfaceC0954m = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC0954m != null) {
                return ((Functions.kt_19) TypeIntrinsics.m5320b(interfaceC0954m, 2)).invoke(this.$receiver$inlined, dVar);
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }
}
