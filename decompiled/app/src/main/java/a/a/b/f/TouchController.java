package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public final class l_renamed {
    public static java.lang.Object a_renamed(java.lang.Object obj) throws java.lang.NegativeArraySizeException {
        int length = java.lang.reflect.Array.getLength(obj);
        java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(obj.getClass().getComponentType(), length);
        java.lang.System.arraycopy(obj, 0, objNewInstance, 0, length);
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E_renamed> java.util.Collection<E_renamed> a_renamed(java.util.Collection<E_renamed> collection) {
        java.util.ArrayList linkedList = collection instanceof java.util.LinkedList ? new java.util.LinkedList() : collection instanceof java.util.SortedSet ? new java.util.TreeSet() : collection instanceof java.util.Set ? new java.util.HashSet() : new java.util.ArrayList();
        java.util.Iterator<E_renamed> it = collection.iterator();
        while (it.hasNext()) {
            ((java.util.Collection) linkedList).add(b_renamed(it.next()));
        }
        return (java.util.Collection<E_renamed>) linkedList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> a_renamed(java.util.Map<K_renamed, V_renamed> map) {
        java.util.HashMap linkedHashMap = map instanceof java.util.LinkedHashMap ? new java.util.LinkedHashMap() : map instanceof java.util.TreeMap ? new java.util.TreeMap() : new java.util.HashMap();
        for (java.util.Map.Entry<K_renamed, V_renamed> entry : map.entrySet()) {
            ((java.util.Map) linkedHashMap).put(b_renamed(entry.getKey()), b_renamed(entry.getValue()));
        }
        return (java.util.Map<K_renamed, V_renamed>) linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E_renamed> E_renamed[] a_renamed(E_renamed[] eArr) {
        E_renamed[] eArr2 = (E_renamed[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(eArr.getClass().getComponentType(), eArr.length));
        for (int i_renamed = 0; i_renamed < eArr.length; i_renamed++) {
            eArr2[i_renamed] = b_renamed(eArr[i_renamed]);
        }
        return eArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <X_renamed> X_renamed b_renamed(X_renamed x_renamed) {
        return x_renamed == 0 ? x_renamed : x_renamed instanceof java.util.Map ? (X_renamed) a_renamed((java.util.Map) x_renamed) : x_renamed instanceof java.util.Collection ? (X_renamed) a_renamed((java.util.Collection) x_renamed) : x_renamed instanceof java.lang.Object[] ? (X_renamed) a_renamed((java.lang.Object[]) x_renamed) : x_renamed.getClass().isArray() ? (X_renamed) a_renamed(x_renamed) : x_renamed;
    }
}
