package c_renamed.c_renamed;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes.dex */
public final class c_renamed implements c_renamed.c_renamed.g_renamed, java.io.Serializable {
    private final c_renamed.c_renamed.g_renamed.b_renamed element;
    private final c_renamed.c_renamed.g_renamed left;

    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: c_renamed.c_renamed.c_renamed$c_renamed, reason: collision with other inner class name */
    static final class C0045c extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<c_renamed.s_renamed, c_renamed.c_renamed.g_renamed.b_renamed, c_renamed.s_renamed> {
        final /* synthetic */ c_renamed.c_renamed.g_renamed[] $elements;
        final /* synthetic */ c_renamed.f_renamed.b_renamed.j_renamed.a_renamed $index;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        C0045c(c_renamed.c_renamed.g_renamed[] gVarArr, c_renamed.f_renamed.b_renamed.j_renamed.a_renamed aVar) {
            super(2);
            this.$elements = gVarArr;
            this.$index = aVar;
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public /* bridge */ /* synthetic */ c_renamed.s_renamed invoke(c_renamed.s_renamed sVar, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
            invoke2(sVar, bVar);
            return c_renamed.s_renamed.f1925a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in_renamed other method */
        public final void invoke2(c_renamed.s_renamed sVar, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(sVar, "<anonymous parameter 0>");
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "element");
            c_renamed.c_renamed.g_renamed[] gVarArr = this.$elements;
            c_renamed.f_renamed.b_renamed.j_renamed.a_renamed aVar = this.$index;
            int i_renamed = aVar.element;
            aVar.element = i_renamed + 1;
            gVarArr[i_renamed] = bVar;
        }
    }

    public c_renamed(c_renamed.c_renamed.g_renamed gVar, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVar, com.google.android.exoplayer2.text.ttml.TtmlNode.LEFT);
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "element");
        this.left = gVar;
        this.element = bVar;
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed plus(c_renamed.c_renamed.g_renamed gVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVar, "context");
        return c_renamed.c_renamed.g_renamed.a_renamed.a_renamed(this, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // c_renamed.c_renamed.g_renamed
    public <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        ?? r1 = this;
        while (true) {
            c_renamed.c_renamed.c_renamed cVar2 = (c_renamed.c_renamed.c_renamed) r1;
            E_renamed e_renamed = (E_renamed) cVar2.element.get(cVar);
            if (e_renamed != null) {
                return e_renamed;
            }
            c_renamed.c_renamed.g_renamed gVar = cVar2.left;
            if (!(gVar instanceof c_renamed.c_renamed.c_renamed)) {
                return (E_renamed) gVar.get(cVar);
            }
            r1 = gVar;
        }
    }

    @Override // c_renamed.c_renamed.g_renamed
    public <R_renamed> R_renamed fold(R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(mVar, "operation");
        return mVar.invoke((java.lang.Object) this.left.fold(r_renamed, mVar), this.element);
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed minusKey(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        c_renamed.c_renamed.g_renamed gVarMinusKey = this.left.minusKey(cVar);
        return gVarMinusKey == this.left ? this : gVarMinusKey == c_renamed.c_renamed.h_renamed.INSTANCE ? this.element : new c_renamed.c_renamed.c_renamed(gVarMinusKey, this.element);
    }

    private final int size() {
        c_renamed.c_renamed.c_renamed cVar = this;
        int i_renamed = 2;
        while (true) {
            c_renamed.c_renamed.g_renamed gVar = cVar.left;
            if (!(gVar instanceof c_renamed.c_renamed.c_renamed)) {
                gVar = null;
            }
            cVar = (c_renamed.c_renamed.c_renamed) gVar;
            if (cVar == null) {
                return i_renamed;
            }
            i_renamed++;
        }
    }

    private final boolean contains(c_renamed.c_renamed.g_renamed.b_renamed bVar) {
        return c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(get(bVar.getKey()), bVar);
    }

    private final boolean containsAll(c_renamed.c_renamed.c_renamed cVar) {
        while (contains(cVar.element)) {
            c_renamed.c_renamed.g_renamed gVar = cVar.left;
            if (!(gVar instanceof c_renamed.c_renamed.c_renamed)) {
                if (gVar != null) {
                    return contains((c_renamed.c_renamed.g_renamed.b_renamed) gVar);
                }
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            cVar = (c_renamed.c_renamed.c_renamed) gVar;
        }
        return false;
    }

    public boolean equals(java.lang.Object obj) {
        if (this != obj) {
            if (obj instanceof c_renamed.c_renamed.c_renamed) {
                c_renamed.c_renamed.c_renamed cVar = (c_renamed.c_renamed.c_renamed) obj;
                if (cVar.size() != size() || !cVar.containsAll(this)) {
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
    static final class b_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<java.lang.String, c_renamed.c_renamed.g_renamed.b_renamed, java.lang.String> {
        public static final c_renamed.c_renamed.c_renamed.b_renamed INSTANCE = new c_renamed.c_renamed.c_renamed.b_renamed();

        b_renamed() {
            super(2);
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public final java.lang.String invoke(java.lang.String str, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "acc");
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public java.lang.String toString() {
        return "[" + ((java.lang.String) fold("", c_renamed.c_renamed.c_renamed.b_renamed.INSTANCE)) + "]";
    }

    private final java.lang.Object writeReplace() {
        int size = size();
        c_renamed.c_renamed.g_renamed[] gVarArr = new c_renamed.c_renamed.g_renamed[size];
        c_renamed.f_renamed.b_renamed.j_renamed.a_renamed aVar = new c_renamed.f_renamed.b_renamed.j_renamed.a_renamed();
        aVar.element = 0;
        fold(c_renamed.s_renamed.f1925a, new c_renamed.c_renamed.c_renamed.C0045c(gVarArr, aVar));
        if (!(aVar.element == size)) {
            throw new java.lang.IllegalStateException("Check failed.".toString());
        }
        return new c_renamed.c_renamed.c_renamed.a_renamed(gVarArr);
    }

    /* compiled from: CoroutineContextImpl.kt */
    private static final class a_renamed implements java.io.Serializable {
        public static final c_renamed.c_renamed.c_renamed.a_renamed.C0044a Companion = new c_renamed.c_renamed.c_renamed.a_renamed.C0044a(null);
        private static final long serialVersionUID = 0;
        private final c_renamed.c_renamed.g_renamed[] elements;

        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: c_renamed.c_renamed.c_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        public static final class C0044a {
            private C0044a() {
            }

            public /* synthetic */ C0044a(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
                this();
            }
        }

        public a_renamed(c_renamed.c_renamed.g_renamed[] gVarArr) {
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVarArr, "elements");
            this.elements = gVarArr;
        }

        public final c_renamed.c_renamed.g_renamed[] getElements() {
            return this.elements;
        }

        private final java.lang.Object readResolve() {
            c_renamed.c_renamed.g_renamed[] gVarArr = this.elements;
            c_renamed.c_renamed.g_renamed gVarPlus = c_renamed.c_renamed.h_renamed.INSTANCE;
            for (c_renamed.c_renamed.g_renamed gVar : gVarArr) {
                gVarPlus = gVarPlus.plus(gVar);
            }
            return gVarPlus;
        }
    }
}
