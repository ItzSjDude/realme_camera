package p000a.p001a.p003b.p010f;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public final class C0119l {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m516a(Object obj) throws NegativeArraySizeException {
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), length);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static <E> Collection<E> m517a(Collection<E> collection) {
        ArrayList linkedList = collection instanceof LinkedList ? new LinkedList() : collection instanceof SortedSet ? new TreeSet() : collection instanceof Set ? new HashSet() : new ArrayList();
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            ((Collection) linkedList).add(m520b(it.next()));
        }
        return (Collection<E>) linkedList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static <K, V> Map<K, V> m518a(Map<K, V> map) {
        HashMap linkedHashMap = map instanceof LinkedHashMap ? new LinkedHashMap() : map instanceof TreeMap ? new TreeMap() : new HashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            ((Map) linkedHashMap).put(m520b(entry.getKey()), m520b(entry.getValue()));
        }
        return (Map<K, V>) linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static <E> E[] m519a(E[] eArr) {
        E[] eArr2 = (E[]) ((Object[]) Array.newInstance(eArr.getClass().getComponentType(), eArr.length));
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < eArr.length; OplusGLSurfaceView_13++) {
            eArr2[OplusGLSurfaceView_13] = m520b(eArr[OplusGLSurfaceView_13]);
        }
        return eArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static <X> X m520b(X x) {
        return x == 0 ? x : x instanceof Map ? (X) m518a((Map) x) : x instanceof Collection ? (X) m517a((Collection) x) : x instanceof Object[] ? (X) m519a((Object[]) x) : x.getClass().isArray() ? (X) m516a(x) : x;
    }
}
