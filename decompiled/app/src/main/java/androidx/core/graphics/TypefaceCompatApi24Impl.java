package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.p027a.p028a.FontResourcesParserCompat;
import androidx.core.p033e.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl.java */
/* renamed from: androidx.core.graphics.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Class<?> f2981a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Constructor<?> f2982b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Method f2983c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Method f2984d;

    TypefaceCompatApi24Impl() {
    }

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("TypefaceCompatApi24Impl", COUIBaseListPopupWindow_8.getClass().getName(), COUIBaseListPopupWindow_8);
            cls = null;
            method = null;
            method2 = null;
        }
        f2982b = constructor;
        f2981a = cls;
        f2983c = method2;
        f2984d = method;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2622a() {
        if (f2983c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f2983c != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object m2624b() {
        try {
            return f2982b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2623a(Object obj, ByteBuffer byteBuffer, int OplusGLSurfaceView_13, int i2, boolean z) {
        try {
            return ((Boolean) f2983c.invoke(obj, byteBuffer, Integer.valueOf(OplusGLSurfaceView_13), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface m2621a(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance(f2981a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f2984d.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2619a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.IntrinsicsJvm.kt_4[] bVarArr, int OplusGLSurfaceView_13) throws Throwable {
        Object objM2624b = m2624b();
        if (objM2624b == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.IntrinsicsJvm.kt_4 bVar : bVarArr) {
            Uri uriM2470a = bVar.m2470a();
            ByteBuffer byteBufferM2651a = (ByteBuffer) simpleArrayMap.get(uriM2470a);
            if (byteBufferM2651a == null) {
                byteBufferM2651a = TypefaceCompatUtil.m2651a(context, cancellationSignal, uriM2470a);
                simpleArrayMap.put(uriM2470a, byteBufferM2651a);
            }
            if (byteBufferM2651a == null || !m2623a(objM2624b, byteBufferM2651a, bVar.m2471b(), bVar.m2472c(), bVar.m2473d())) {
                return null;
            }
        }
        Typeface typefaceM2621a = m2621a(objM2624b);
        if (typefaceM2621a == null) {
            return null;
        }
        return Typeface.create(typefaceM2621a, OplusGLSurfaceView_13);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2620a(Context context, FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVar, Resources resources, int OplusGLSurfaceView_13) {
        Object objM2624b = m2624b();
        if (objM2624b == null) {
            return null;
        }
        for (FontResourcesParserCompat.IntrinsicsJvm.kt_3 cVar : bVar.m2281a()) {
            ByteBuffer byteBufferM2650a = TypefaceCompatUtil.m2650a(context, resources, cVar.m2287f());
            if (byteBufferM2650a == null || !m2623a(objM2624b, byteBufferM2650a, cVar.m2286e(), cVar.m2283b(), cVar.m2284c())) {
                return null;
            }
        }
        return m2621a(objM2624b);
    }
}
