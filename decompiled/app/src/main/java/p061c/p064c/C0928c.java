package p061c.p064c;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.Serializable;
import p061c.Unit.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Lambda.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;
import p061c.p070f.p072b.Ref;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class C0928c implements CoroutineContext.kt_4, Serializable {
    private final CoroutineContext.kt_4.IntrinsicsJvm.kt_4 element;
    private final CoroutineContext.kt_4 left;

    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    static final class IntrinsicsJvm.kt_3 extends Lambda.kt implements Functions.kt_19<Unit.kt, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, Unit.kt> {
        final /* synthetic */ CoroutineContext.kt_4[] $elements;
        final /* synthetic */ Ref.PlatformImplementations.kt_3 $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        IntrinsicsJvm.kt_3(CoroutineContext.kt_4[] interfaceC0932gArr, Ref.PlatformImplementations.kt_3 aVar) {
            super(2);
            this.$elements = interfaceC0932gArr;
            this.$index = aVar;
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public /* bridge */ /* synthetic */ Unit.kt invoke(Unit.kt c1025s, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
            invoke2(c1025s, bVar);
            return Unit.kt.f5071a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit.kt c1025s, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
            Intrinsics.m5305d(c1025s, "<anonymous parameter 0>");
            Intrinsics.m5305d(bVar, "element");
            CoroutineContext.kt_4[] interfaceC0932gArr = this.$elements;
            Ref.PlatformImplementations.kt_3 aVar = this.$index;
            int OplusGLSurfaceView_13 = aVar.element;
            aVar.element = OplusGLSurfaceView_13 + 1;
            interfaceC0932gArr[OplusGLSurfaceView_13] = bVar;
        }
    }

    public C0928c(CoroutineContext.kt_4 interfaceC0932g, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
        Intrinsics.m5305d(interfaceC0932g, TtmlNode.LEFT);
        Intrinsics.m5305d(bVar, "element");
        this.left = interfaceC0932g;
        this.element = bVar;
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 plus(CoroutineContext.kt_4 interfaceC0932g) {
        Intrinsics.m5305d(interfaceC0932g, "context");
        return CoroutineContext.kt_4.PlatformImplementations.kt_3.m5274a(this, interfaceC0932g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // p061c.p064c.CoroutineContext.kt_4
    public <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E get(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
        Intrinsics.m5305d(cVar, "key");
        ?? r1 = this;
        while (true) {
            C0928c c0928c = (C0928c) r1;
            E COUIBaseListPopupWindow_8 = (E) c0928c.element.get(cVar);
            if (COUIBaseListPopupWindow_8 != null) {
                return COUIBaseListPopupWindow_8;
            }
            CoroutineContext.kt_4 interfaceC0932g = c0928c.left;
            if (!(interfaceC0932g instanceof C0928c)) {
                return (E) interfaceC0932g.get(cVar);
            }
            r1 = interfaceC0932g;
        }
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public <R> R fold(R r, Functions.kt_19<? super R, ? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
        Intrinsics.m5305d(interfaceC0954m, "operation");
        return interfaceC0954m.invoke((Object) this.left.fold(r, interfaceC0954m), this.element);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 minusKey(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        Intrinsics.m5305d(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        CoroutineContext.kt_4 interfaceC0932gMinusKey = this.left.minusKey(cVar);
        return interfaceC0932gMinusKey == this.left ? this : interfaceC0932gMinusKey == CoroutineContextImpl.kt_3.INSTANCE ? this.element : new C0928c(interfaceC0932gMinusKey, this.element);
    }

    private final int size() {
        C0928c c0928c = this;
        int OplusGLSurfaceView_13 = 2;
        while (true) {
            CoroutineContext.kt_4 interfaceC0932g = c0928c.left;
            if (!(interfaceC0932g instanceof C0928c)) {
                interfaceC0932g = null;
            }
            c0928c = (C0928c) interfaceC0932g;
            if (c0928c == null) {
                return OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
    }

    private final boolean contains(CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
        return Intrinsics.m5299a(get(bVar.getKey()), bVar);
    }

    private final boolean containsAll(C0928c c0928c) {
        while (contains(c0928c.element)) {
            CoroutineContext.kt_4 interfaceC0932g = c0928c.left;
            if (!(interfaceC0932g instanceof C0928c)) {
                if (interfaceC0932g != null) {
                    return contains((CoroutineContext.kt_4.IntrinsicsJvm.kt_4) interfaceC0932g);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            c0928c = (C0928c) interfaceC0932g;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C0928c) {
                C0928c c0928c = (C0928c) obj;
                if (c0928c.size() != size() || !c0928c.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    static final class IntrinsicsJvm.kt_4 extends Lambda.kt implements Functions.kt_19<String, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, String> {
        public static final IntrinsicsJvm.kt_4 INSTANCE = new IntrinsicsJvm.kt_4();

        IntrinsicsJvm.kt_4() {
            super(2);
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public final String invoke(String str, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
            Intrinsics.m5305d(str, "acc");
            Intrinsics.m5305d(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public String toString() {
        return "[" + ((String) fold("", IntrinsicsJvm.kt_4.INSTANCE)) + "]";
    }

    private final Object writeReplace() {
        int size = size();
        CoroutineContext.kt_4[] interfaceC0932gArr = new CoroutineContext.kt_4[size];
        Ref.PlatformImplementations.kt_3 aVar = new Ref.PlatformImplementations.kt_3();
        aVar.element = 0;
        fold(Unit.kt.f5071a, new IntrinsicsJvm.kt_3(interfaceC0932gArr, aVar));
        if (!(aVar.element == size)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return new PlatformImplementations.kt_3(interfaceC0932gArr);
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 implements Serializable {
        public static final C4115a Companion = new C4115a(null);
        private static final long serialVersionUID = 0;
        private final CoroutineContext.kt_4[] elements;

        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        public static final class C4115a {
            private C4115a() {
            }

            public /* synthetic */ C4115a(DefaultConstructorMarker c0970f) {
                this();
            }
        }

        public PlatformImplementations.kt_3(CoroutineContext.kt_4[] interfaceC0932gArr) {
            Intrinsics.m5305d(interfaceC0932gArr, "elements");
            this.elements = interfaceC0932gArr;
        }

        public final CoroutineContext.kt_4[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            CoroutineContext.kt_4[] interfaceC0932gArr = this.elements;
            CoroutineContext.kt_4 interfaceC0932gPlus = CoroutineContextImpl.kt_3.INSTANCE;
            for (CoroutineContext.kt_4 interfaceC0932g : interfaceC0932gArr) {
                interfaceC0932gPlus = interfaceC0932gPlus.plus(interfaceC0932g);
            }
            return interfaceC0932gPlus;
        }
    }
}
