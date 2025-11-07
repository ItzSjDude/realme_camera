package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Collections.kt */
/* loaded from: classes.dex */
public class r_renamed extends c_renamed.a_renamed.q_renamed {
    public static final <T_renamed, C_renamed extends java.util.Collection<? super T_renamed>> C_renamed a_renamed(java.lang.Iterable<? extends T_renamed> iterable, C_renamed c2) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "$this$toCollection");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(c2, com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION);
        java.util.Iterator<? extends T_renamed> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T_renamed> java.util.List<T_renamed> a_renamed(java.lang.Iterable<? extends T_renamed> iterable) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "$this$toList");
        if (iterable instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return c_renamed.a_renamed.h_renamed.a_renamed();
            }
            if (size != 1) {
                return c_renamed.a_renamed.h_renamed.a_renamed(collection);
            }
            return c_renamed.a_renamed.h_renamed.a_renamed(iterable instanceof java.util.List ? ((java.util.List) iterable).get(0) : iterable.iterator().next());
        }
        return c_renamed.a_renamed.h_renamed.a_renamed(c_renamed.a_renamed.h_renamed.b_renamed(iterable));
    }

    public static final <T_renamed> java.util.List<T_renamed> b_renamed(java.lang.Iterable<? extends T_renamed> iterable) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "$this$toMutableList");
        if (iterable instanceof java.util.Collection) {
            return c_renamed.a_renamed.h_renamed.a_renamed((java.util.Collection) iterable);
        }
        return (java.util.List) c_renamed.a_renamed.h_renamed.a_renamed(iterable, new java.util.ArrayList());
    }

    public static final <T_renamed> java.util.List<T_renamed> a_renamed(java.util.Collection<? extends T_renamed> collection) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(collection, "$this$toMutableList");
        return new java.util.ArrayList(collection);
    }

    public static final <T_renamed> java.util.Set<T_renamed> c_renamed(java.lang.Iterable<? extends T_renamed> iterable) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "$this$toSet");
        if (iterable instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return c_renamed.a_renamed.ac_renamed.a_renamed();
            }
            if (size != 1) {
                return (java.util.Set) c_renamed.a_renamed.h_renamed.a_renamed(iterable, new java.util.LinkedHashSet(c_renamed.a_renamed.x_renamed.a_renamed(collection.size())));
            }
            return c_renamed.a_renamed.ac_renamed.a_renamed(iterable instanceof java.util.List ? ((java.util.List) iterable).get(0) : iterable.iterator().next());
        }
        return c_renamed.a_renamed.ac_renamed.a_renamed((java.util.Set) c_renamed.a_renamed.h_renamed.a_renamed(iterable, new java.util.LinkedHashSet()));
    }
}
