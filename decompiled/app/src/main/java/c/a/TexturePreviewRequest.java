package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
/* loaded from: classes.dex */
public class aa_renamed extends c_renamed.a_renamed.z_renamed {
    public static final <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> a_renamed() {
        c_renamed.a_renamed.u_renamed uVar = c_renamed.a_renamed.u_renamed.INSTANCE;
        if (uVar != null) {
            return uVar;
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.collections.Map<K_renamed, V_renamed>");
    }

    public static final <K_renamed, V_renamed> void a_renamed(java.util.Map<? super K_renamed, ? super V_renamed> map, java.lang.Iterable<? extends c_renamed.l_renamed<? extends K_renamed, ? extends V_renamed>> iterable) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(map, "$this$putAll");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "pairs");
        for (c_renamed.l_renamed<? extends K_renamed, ? extends V_renamed> lVar : iterable) {
            map.put(lVar.component1(), lVar.component2());
        }
    }

    public static final <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> a_renamed(java.lang.Iterable<? extends c_renamed.l_renamed<? extends K_renamed, ? extends V_renamed>> iterable) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "$this$toMap");
        if (iterable instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return c_renamed.a_renamed.x_renamed.a_renamed();
            }
            if (size != 1) {
                return c_renamed.a_renamed.x_renamed.a_renamed(iterable, new java.util.LinkedHashMap(c_renamed.a_renamed.x_renamed.a_renamed(collection.size())));
            }
            return c_renamed.a_renamed.x_renamed.a_renamed(iterable instanceof java.util.List ? (c_renamed.l_renamed<? extends K_renamed, ? extends V_renamed>) ((java.util.List) iterable).get(0) : iterable.iterator().next());
        }
        return c_renamed.a_renamed.x_renamed.b_renamed(c_renamed.a_renamed.x_renamed.a_renamed(iterable, new java.util.LinkedHashMap()));
    }

    public static final <K_renamed, V_renamed, M_renamed extends java.util.Map<? super K_renamed, ? super V_renamed>> M_renamed a_renamed(java.lang.Iterable<? extends c_renamed.l_renamed<? extends K_renamed, ? extends V_renamed>> iterable, M_renamed m_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "$this$toMap");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(m_renamed, com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION);
        c_renamed.a_renamed.x_renamed.a_renamed(m_renamed, iterable);
        return m_renamed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> b_renamed(java.util.Map<K_renamed, ? extends V_renamed> map) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : c_renamed.a_renamed.x_renamed.a_renamed(map);
        }
        return c_renamed.a_renamed.x_renamed.a_renamed();
    }
}
