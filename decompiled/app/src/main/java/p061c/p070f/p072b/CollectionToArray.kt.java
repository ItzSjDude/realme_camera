package p061c.p070f.p072b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionToArray.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public final class CollectionToArray.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object[] f5052a = new Object[0];

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Object[] m5290a(Collection<?> collection) {
        Intrinsics.m5305d(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    int i2 = OplusGLSurfaceView_13 + 1;
                    objArrCopyOf[OplusGLSurfaceView_13] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i3 = 2147483645;
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                        Intrinsics.m5301b(objArrCopyOf, "Arrays.copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i2);
                        Intrinsics.m5301b(objArrCopyOf2, "Arrays.copyOf(result, size)");
                        return objArrCopyOf2;
                    }
                    OplusGLSurfaceView_13 = i2;
                }
            }
        }
        return f5052a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Object[] m5291a(Collection<?> collection, Object[] objArr) throws NegativeArraySizeException {
        Object[] objArrCopyOf;
        Intrinsics.m5305d(collection, "collection");
        if (objArr == null) {
            throw new NullPointerException();
        }
        int size = collection.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArrCopyOf = objArr;
        } else {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            if (objNewInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArrCopyOf = (Object[]) objNewInstance;
        }
        while (true) {
            int i2 = OplusGLSurfaceView_13 + 1;
            objArrCopyOf[OplusGLSurfaceView_13] = it.next();
            if (i2 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i3 = 2147483645;
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                Intrinsics.m5301b(objArrCopyOf, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArrCopyOf == objArr) {
                    objArr[i2] = null;
                    return objArr;
                }
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i2);
                Intrinsics.m5301b(objArrCopyOf2, "Arrays.copyOf(result, size)");
                return objArrCopyOf2;
            }
            OplusGLSurfaceView_13 = i2;
        }
    }
}
