package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* loaded from: classes.dex */
public class z_renamed extends c_renamed.a_renamed.y_renamed {
    public static final int a_renamed(int i_renamed) {
        if (i_renamed < 0) {
            return i_renamed;
        }
        if (i_renamed < 3) {
            return i_renamed + 1;
        }
        if (i_renamed < 1073741824) {
            return (int) ((i_renamed / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> a_renamed(c_renamed.l_renamed<? extends K_renamed, ? extends V_renamed> lVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(lVar, "pair");
        java.util.Map<K_renamed, V_renamed> mapSingletonMap = java.util.Collections.singletonMap(lVar.getFirst(), lVar.getSecond());
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> a_renamed(java.util.Map<? extends K_renamed, ? extends V_renamed> map) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(map, "$this$toSingletonMap");
        java.util.Map.Entry<? extends K_renamed, ? extends V_renamed> next = map.entrySet().iterator().next();
        java.util.Map<K_renamed, V_renamed> mapSingletonMap = java.util.Collections.singletonMap(next.getKey(), next.getValue());
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
