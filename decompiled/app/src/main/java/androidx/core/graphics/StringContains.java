package androidx.core.graphics;

/* compiled from: TypefaceCompatApi28Impl.java */
/* loaded from: classes.dex */
public class j_renamed extends androidx.core.graphics.i_renamed {
    @Override // androidx.core.graphics.i_renamed
    protected android.graphics.Typeface a_renamed(java.lang.Object obj) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException {
        try {
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(this.f949a, 1);
            java.lang.reflect.Array.set(objNewInstance, 0, obj);
            return (android.graphics.Typeface) this.g_renamed.invoke(null, objNewInstance, com.google.android.exoplayer2.C_renamed.SANS_SERIF_NAME, -1, -1);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    @Override // androidx.core.graphics.i_renamed
    protected java.lang.reflect.Method f_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method declaredMethod = android.graphics.Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", java.lang.reflect.Array.newInstance(cls, 1).getClass(), java.lang.String.class, java.lang.Integer.TYPE, java.lang.Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
