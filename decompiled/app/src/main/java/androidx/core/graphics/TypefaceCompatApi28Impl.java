package androidx.core.graphics;

import android.graphics.Typeface;
import com.google.android.exoplayer2.C1547C;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi28Impl.java */
/* renamed from: androidx.core.graphics.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    /* renamed from: PlatformImplementations.kt_3 */
    protected Typeface mo2632a(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance(this.f2985a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f2991g.invoke(null, objNewInstance, C1547C.SANS_SERIF_NAME, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected Method mo2639f(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
