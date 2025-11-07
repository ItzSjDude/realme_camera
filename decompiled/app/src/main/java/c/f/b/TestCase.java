package c_renamed.f_renamed.b_renamed;

/* compiled from: CollectionToArray.kt */
/* loaded from: classes.dex */
public final class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object[] f1908a = new java.lang.Object[0];

    public static final java.lang.Object[] a_renamed(java.util.Collection<?> collection) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            java.util.Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                java.lang.Object[] objArrCopyOf = new java.lang.Object[size];
                int i_renamed = 0;
                while (true) {
                    int i2 = i_renamed + 1;
                    objArrCopyOf[i_renamed] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            if (i2 >= 2147483645) {
                                throw new java.lang.OutOfMemoryError();
                            }
                            i3 = 2147483645;
                        }
                        objArrCopyOf = java.util.Arrays.copyOf(objArrCopyOf, i3);
                        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objArrCopyOf, "Arrays.copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        java.lang.Object[] objArrCopyOf2 = java.util.Arrays.copyOf(objArrCopyOf, i2);
                        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objArrCopyOf2, "Arrays.copyOf(result, size)");
                        return objArrCopyOf2;
                    }
                    i_renamed = i2;
                }
            }
        }
        return f1908a;
    }

    public static final java.lang.Object[] a_renamed(java.util.Collection<?> collection, java.lang.Object[] objArr) throws java.lang.NegativeArraySizeException {
        java.lang.Object[] objArrCopyOf;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(collection, "collection");
        if (objArr == null) {
            throw new java.lang.NullPointerException();
        }
        int size = collection.size();
        int i_renamed = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        java.util.Iterator<?> it = collection.iterator();
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
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(objArr.getClass().getComponentType(), size);
            if (objNewInstance == null) {
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArrCopyOf = (java.lang.Object[]) objNewInstance;
        }
        while (true) {
            int i2 = i_renamed + 1;
            objArrCopyOf[i_renamed] = it.next();
            if (i2 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= 2147483645) {
                        throw new java.lang.OutOfMemoryError();
                    }
                    i3 = 2147483645;
                }
                objArrCopyOf = java.util.Arrays.copyOf(objArrCopyOf, i3);
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objArrCopyOf, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArrCopyOf == objArr) {
                    objArr[i2] = null;
                    return objArr;
                }
                java.lang.Object[] objArrCopyOf2 = java.util.Arrays.copyOf(objArrCopyOf, i2);
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objArrCopyOf2, "Arrays.copyOf(result, size)");
                return objArrCopyOf2;
            }
            i_renamed = i2;
        }
    }
}
