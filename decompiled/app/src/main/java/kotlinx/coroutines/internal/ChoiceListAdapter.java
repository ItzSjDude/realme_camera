package kotlinx.coroutines.internal;

/* compiled from: ThreadContext.kt */
/* loaded from: classes2.dex */
public final class v_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.r_renamed f7888a = new kotlinx.coroutines.internal.r_renamed("ZERO");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final c_renamed.f_renamed.a_renamed.m_renamed<java.lang.Object, c_renamed.c_renamed.g_renamed.b_renamed, java.lang.Object> f7889b = kotlinx.coroutines.internal.v_renamed.a_renamed.INSTANCE;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.bl_renamed<?>, c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.bl_renamed<?>> f7890c = kotlinx.coroutines.internal.v_renamed.b_renamed.INSTANCE;
    private static final c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.internal.y_renamed, c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.internal.y_renamed> d_renamed = kotlinx.coroutines.internal.v_renamed.d_renamed.INSTANCE;
    private static final c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.internal.y_renamed, c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.internal.y_renamed> e_renamed = kotlinx.coroutines.internal.v_renamed.c_renamed.INSTANCE;

    /* compiled from: ThreadContext.kt */
    static final class a_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<java.lang.Object, c_renamed.c_renamed.g_renamed.b_renamed, java.lang.Object> {
        public static final kotlinx.coroutines.internal.v_renamed.a_renamed INSTANCE = new kotlinx.coroutines.internal.v_renamed.a_renamed();

        a_renamed() {
            super(2);
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public final java.lang.Object invoke(java.lang.Object obj, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
            if (!(bVar instanceof kotlinx.coroutines.bl_renamed)) {
                return obj;
            }
            if (!(obj instanceof java.lang.Integer)) {
                obj = null;
            }
            java.lang.Integer num = (java.lang.Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : java.lang.Integer.valueOf(iIntValue + 1);
        }
    }

    /* compiled from: ThreadContext.kt */
    static final class b_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.bl_renamed<?>, c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.bl_renamed<?>> {
        public static final kotlinx.coroutines.internal.v_renamed.b_renamed INSTANCE = new kotlinx.coroutines.internal.v_renamed.b_renamed();

        b_renamed() {
            super(2);
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public final kotlinx.coroutines.bl_renamed<?> invoke(kotlinx.coroutines.bl_renamed<?> blVar, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
            if (blVar != null) {
                return blVar;
            }
            if (!(bVar instanceof kotlinx.coroutines.bl_renamed)) {
                bVar = null;
            }
            return (kotlinx.coroutines.bl_renamed) bVar;
        }
    }

    /* compiled from: ThreadContext.kt */
    static final class d_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.internal.y_renamed, c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.internal.y_renamed> {
        public static final kotlinx.coroutines.internal.v_renamed.d_renamed INSTANCE = new kotlinx.coroutines.internal.v_renamed.d_renamed();

        d_renamed() {
            super(2);
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public final kotlinx.coroutines.internal.y_renamed invoke(kotlinx.coroutines.internal.y_renamed yVar, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
            if (bVar instanceof kotlinx.coroutines.bl_renamed) {
                yVar.a_renamed(((kotlinx.coroutines.bl_renamed) bVar).b_renamed(yVar.c_renamed()));
            }
            return yVar;
        }
    }

    /* compiled from: ThreadContext.kt */
    static final class c_renamed extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<kotlinx.coroutines.internal.y_renamed, c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.internal.y_renamed> {
        public static final kotlinx.coroutines.internal.v_renamed.c_renamed INSTANCE = new kotlinx.coroutines.internal.v_renamed.c_renamed();

        c_renamed() {
            super(2);
        }

        @Override // c_renamed.f_renamed.a_renamed.m_renamed
        public final kotlinx.coroutines.internal.y_renamed invoke(kotlinx.coroutines.internal.y_renamed yVar, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
            if (bVar instanceof kotlinx.coroutines.bl_renamed) {
                ((kotlinx.coroutines.bl_renamed) bVar).a_renamed(yVar.c_renamed(), yVar.a_renamed());
            }
            return yVar;
        }
    }

    public static final java.lang.Object a_renamed(c_renamed.c_renamed.g_renamed gVar) {
        java.lang.Object objFold = gVar.fold(0, f7889b);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(objFold);
        return objFold;
    }

    public static final java.lang.Object a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Object obj) {
        if (obj == null) {
            obj = a_renamed(gVar);
        }
        if (obj == 0) {
            return f7888a;
        }
        if (obj instanceof java.lang.Integer) {
            return gVar.fold(new kotlinx.coroutines.internal.y_renamed(gVar, ((java.lang.Number) obj).intValue()), d_renamed);
        }
        if (obj == null) {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        return ((kotlinx.coroutines.bl_renamed) obj).b_renamed(gVar);
    }

    public static final void b_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Object obj) {
        if (obj == f7888a) {
            return;
        }
        if (obj instanceof kotlinx.coroutines.internal.y_renamed) {
            ((kotlinx.coroutines.internal.y_renamed) obj).b_renamed();
            gVar.fold(obj, e_renamed);
        } else {
            java.lang.Object objFold = gVar.fold(null, f7890c);
            if (objFold == null) {
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((kotlinx.coroutines.bl_renamed) objFold).a_renamed(gVar, obj);
        }
    }
}
