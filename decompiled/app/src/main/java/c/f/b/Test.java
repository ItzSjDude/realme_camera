package c_renamed.f_renamed.b_renamed;

/* compiled from: ClassReference.kt */
/* loaded from: classes.dex */
public final class d_renamed implements c_renamed.f_renamed.b_renamed.c_renamed, c_renamed.i_renamed.a_renamed<java.lang.Object> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final c_renamed.f_renamed.b_renamed.d_renamed.a_renamed f1905a = new c_renamed.f_renamed.b_renamed.d_renamed.a_renamed(null);

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.Map<java.lang.Class<? extends c_renamed.c_renamed<?>>, java.lang.Integer> f1906c;
    private static final java.util.HashMap<java.lang.String, java.lang.String> d_renamed;
    private static final java.util.HashMap<java.lang.String, java.lang.String> e_renamed;
    private static final java.util.HashMap<java.lang.String, java.lang.String> f_renamed;
    private static final java.util.Map<java.lang.String, java.lang.String> g_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Class<?> f1907b;

    public d_renamed(java.lang.Class<?> cls) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cls, "jClass");
        this.f1907b = cls;
    }

    @Override // c_renamed.f_renamed.b_renamed.c_renamed
    public java.lang.Class<?> a_renamed() {
        return this.f1907b;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof c_renamed.f_renamed.b_renamed.d_renamed) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(c_renamed.f_renamed.a_renamed.a_renamed(this), c_renamed.f_renamed.a_renamed.a_renamed((c_renamed.i_renamed.a_renamed) obj));
    }

    public int hashCode() {
        return c_renamed.f_renamed.a_renamed.a_renamed(this).hashCode();
    }

    public java.lang.String toString() {
        return a_renamed().toString() + " (Kotlin reflection is_renamed not available)";
    }

    /* compiled from: ClassReference.kt */
    public static final class a_renamed {
        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    static {
        int i_renamed = 0;
        java.util.List listA = c_renamed.a_renamed.h_renamed.a_renamed((java.lang.Object[]) new java.lang.Class[]{c_renamed.f_renamed.a_renamed.a_renamed.class, c_renamed.f_renamed.a_renamed.b_renamed.class, c_renamed.f_renamed.a_renamed.m_renamed.class, c_renamed.f_renamed.a_renamed.q_renamed.class, c_renamed.f_renamed.a_renamed.r_renamed.class, c_renamed.f_renamed.a_renamed.s_renamed.class, c_renamed.f_renamed.a_renamed.t_renamed.class, c_renamed.f_renamed.a_renamed.u_renamed.class, c_renamed.f_renamed.a_renamed.v_renamed.class, c_renamed.f_renamed.a_renamed.w_renamed.class, c_renamed.f_renamed.a_renamed.c_renamed.class, c_renamed.f_renamed.a_renamed.d_renamed.class, c_renamed.f_renamed.a_renamed.e_renamed.class, c_renamed.f_renamed.a_renamed.f_renamed.class, c_renamed.f_renamed.a_renamed.g_renamed.class, c_renamed.f_renamed.a_renamed.h_renamed.class, c_renamed.f_renamed.a_renamed.i_renamed.class, c_renamed.f_renamed.a_renamed.j_renamed.class, c_renamed.f_renamed.a_renamed.k_renamed.class, c_renamed.f_renamed.a_renamed.l_renamed.class, c_renamed.f_renamed.a_renamed.n_renamed.class, c_renamed.f_renamed.a_renamed.o_renamed.class, c_renamed.f_renamed.a_renamed.p_renamed.class});
        java.util.ArrayList arrayList = new java.util.ArrayList(c_renamed.a_renamed.h_renamed.a_renamed(listA, 10));
        for (java.lang.Object obj : listA) {
            int i2 = i_renamed + 1;
            if (i_renamed < 0) {
                c_renamed.a_renamed.h_renamed.b_renamed();
            }
            arrayList.add(c_renamed.p_renamed.a_renamed((java.lang.Class) obj, java.lang.Integer.valueOf(i_renamed)));
            i_renamed = i2;
        }
        f1906c = c_renamed.a_renamed.x_renamed.a_renamed(arrayList);
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        d_renamed = map;
        java.util.HashMap<java.lang.String, java.lang.String> map2 = new java.util.HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        e_renamed = map2;
        java.util.HashMap<java.lang.String, java.lang.String> map3 = new java.util.HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(d_renamed);
        map3.putAll(e_renamed);
        java.util.Collection<java.lang.String> collectionValues = d_renamed.values();
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(collectionValues, "primitiveFqNames.values");
        for (java.lang.String str : collectionValues) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("kotlin.jvm.internal.");
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(str, "kotlinName");
            sb.append(c_renamed.k_renamed.d_renamed.b_renamed(str, '.', (java.lang.String) null, 2, (java.lang.Object) null));
            sb.append("CompanionObject");
            c_renamed.l_renamed lVarA = c_renamed.p_renamed.a_renamed(sb.toString(), str + ".Companion");
            map3.put(lVarA.getFirst(), lVarA.getSecond());
        }
        for (java.util.Map.Entry<java.lang.Class<? extends c_renamed.c_renamed<?>>, java.lang.Integer> entry : f1906c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f_renamed = map3;
        java.util.HashMap<java.lang.String, java.lang.String> map4 = f_renamed;
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(c_renamed.a_renamed.x_renamed.a_renamed(map4.size()));
        java.util.Iterator<T_renamed> it = map4.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry2 = (java.util.Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), c_renamed.k_renamed.d_renamed.b_renamed((java.lang.String) entry2.getValue(), '.', (java.lang.String) null, 2, (java.lang.Object) null));
        }
        g_renamed = linkedHashMap;
    }
}
