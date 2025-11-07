package androidx.core.graphics;

/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class h_renamed extends androidx.core.graphics.l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Class<?> f946a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.reflect.Constructor<?> f947b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.reflect.Method f948c;
    private static final java.lang.reflect.Method d_renamed;

    h_renamed() {
    }

    static {
        java.lang.Class<?> cls;
        java.lang.reflect.Method method;
        java.lang.reflect.Method method2;
        java.lang.reflect.Constructor<?> constructor = null;
        try {
            cls = java.lang.Class.forName("android.graphics.FontFamily");
            java.lang.reflect.Constructor<?> constructor2 = cls.getConstructor(new java.lang.Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", java.nio.ByteBuffer.class, java.lang.Integer.TYPE, java.util.List.class, java.lang.Integer.TYPE, java.lang.Boolean.TYPE);
            method = android.graphics.Typeface.class.getMethod("createFromFamiliesWithDefault", java.lang.reflect.Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException e_renamed) {
            android.util.Log.e_renamed("TypefaceCompatApi24Impl", e_renamed.getClass().getName(), e_renamed);
            cls = null;
            method = null;
            method2 = null;
        }
        f947b = constructor;
        f946a = cls;
        f948c = method2;
        d_renamed = method;
    }

    public static boolean a_renamed() {
        if (f948c == null) {
            android.util.Log.w_renamed("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f948c != null;
    }

    private static java.lang.Object b_renamed() {
        try {
            return f947b.newInstance(new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a_renamed(java.lang.Object obj, java.nio.ByteBuffer byteBuffer, int i_renamed, int i2, boolean z_renamed) {
        try {
            return ((java.lang.Boolean) f948c.invoke(obj, byteBuffer, java.lang.Integer.valueOf(i_renamed), null, java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z_renamed))).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private static android.graphics.Typeface a_renamed(java.lang.Object obj) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException {
        try {
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(f946a, 1);
            java.lang.reflect.Array.set(objNewInstance, 0, obj);
            return (android.graphics.Typeface) d_renamed.invoke(null, objNewInstance);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.l_renamed
    public android.graphics.Typeface a_renamed(android.content.Context context, android.os.CancellationSignal cancellationSignal, androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] c0016bArr, int i_renamed) throws java.lang.Throwable {
        java.lang.Object objB = b_renamed();
        if (objB == null) {
            return null;
        }
        androidx.collection.SimpleArrayMap simpleArrayMap = new androidx.collection.SimpleArrayMap();
        for (androidx.core.e_renamed.b_renamed.FontsContractCompat_3 c0016b : c0016bArr) {
            android.net.Uri uriA = c0016b.a_renamed();
            java.nio.ByteBuffer byteBufferA = (java.nio.ByteBuffer) simpleArrayMap.get(uriA);
            if (byteBufferA == null) {
                byteBufferA = androidx.core.graphics.m_renamed.a_renamed(context, cancellationSignal, uriA);
                simpleArrayMap.put(uriA, byteBufferA);
            }
            if (byteBufferA == null || !a_renamed(objB, byteBufferA, c0016b.b_renamed(), c0016b.c_renamed(), c0016b.d_renamed())) {
                return null;
            }
        }
        android.graphics.Typeface typefaceA = a_renamed(objB);
        if (typefaceA == null) {
            return null;
        }
        return android.graphics.Typeface.create(typefaceA, i_renamed);
    }

    @Override // androidx.core.graphics.l_renamed
    public android.graphics.Typeface a_renamed(android.content.Context context, androidx.core.a_renamed.a_renamed.c_renamed.b_renamed bVar, android.content.res.Resources resources, int i_renamed) {
        java.lang.Object objB = b_renamed();
        if (objB == null) {
            return null;
        }
        for (androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 c0013c : bVar.a_renamed()) {
            java.nio.ByteBuffer byteBufferA = androidx.core.graphics.m_renamed.a_renamed(context, resources, c0013c.f_renamed());
            if (byteBufferA == null || !a_renamed(objB, byteBufferA, c0013c.e_renamed(), c0013c.b_renamed(), c0013c.c_renamed())) {
                return null;
            }
        }
        return a_renamed(objB);
    }
}
