package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.p027a.p028a.FontResourcesParserCompat;
import androidx.core.p033e.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl.java */
/* renamed from: androidx.core.graphics.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
class TypefaceCompatBaseImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private ConcurrentHashMap<Long, FontResourcesParserCompat.IntrinsicsJvm.kt_4> f2992a = new ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: androidx.core.graphics.OplusGLSurfaceView_14$PlatformImplementations.kt_3 */
    private interface PlatformImplementations.kt_3<T> {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo2647a(T t);

        /* renamed from: IntrinsicsJvm.kt_4 */
        int mo2648b(T t);
    }

    TypefaceCompatBaseImpl() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> T m2643a(T[] tArr, int OplusGLSurfaceView_13, PlatformImplementations.kt_3<T> aVar) {
        int i2 = (OplusGLSurfaceView_13 & 1) == 0 ? 400 : 700;
        boolean z = (OplusGLSurfaceView_13 & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T t = null;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(aVar.mo2648b(t2) - i2) * 2) + (aVar.mo2647a(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static long m2645b(Typeface typeface) throws NoSuchFieldException {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("TypefaceCompatBaseImpl", "Could not retrieve font from family.", COUIBaseListPopupWindow_8);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.COUIBaseListPopupWindow_8("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected FontsContractCompat.IntrinsicsJvm.kt_4 mo2641a(FontsContractCompat.IntrinsicsJvm.kt_4[] bVarArr, int OplusGLSurfaceView_13) {
        return (FontsContractCompat.IntrinsicsJvm.kt_4) m2643a(bVarArr, OplusGLSurfaceView_13, new PlatformImplementations.kt_3<FontsContractCompat.IntrinsicsJvm.kt_4>() { // from class: androidx.core.graphics.OplusGLSurfaceView_14.1
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo2648b(FontsContractCompat.IntrinsicsJvm.kt_4 bVar) {
                return bVar.m2472c();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo2647a(FontsContractCompat.IntrinsicsJvm.kt_4 bVar) {
                return bVar.m2473d();
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected Typeface mo2640a(Context context, InputStream inputStream) {
        File fileM2649a = TypefaceCompatUtil.m2649a(context);
        if (fileM2649a == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.m2655a(fileM2649a, inputStream)) {
                return Typeface.createFromFile(fileM2649a.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM2649a.delete();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2619a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.IntrinsicsJvm.kt_4[] bVarArr, int OplusGLSurfaceView_13) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(mo2641a(bVarArr, OplusGLSurfaceView_13).m2470a());
        } catch (IOException unused) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface typefaceMo2640a = mo2640a(context, inputStreamOpenInputStream);
            TypefaceCompatUtil.m2653a(inputStreamOpenInputStream);
            return typefaceMo2640a;
        } catch (IOException unused2) {
            TypefaceCompatUtil.m2653a(inputStreamOpenInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
            TypefaceCompatUtil.m2653a(inputStream);
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FontResourcesParserCompat.IntrinsicsJvm.kt_3 m2642a(FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13) {
        return (FontResourcesParserCompat.IntrinsicsJvm.kt_3) m2643a(bVar.m2281a(), OplusGLSurfaceView_13, new PlatformImplementations.kt_3<FontResourcesParserCompat.IntrinsicsJvm.kt_3>() { // from class: androidx.core.graphics.OplusGLSurfaceView_14.2
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo2648b(FontResourcesParserCompat.IntrinsicsJvm.kt_3 cVar) {
                return cVar.m2283b();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo2647a(FontResourcesParserCompat.IntrinsicsJvm.kt_3 cVar) {
                return cVar.m2284c();
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2620a(Context context, FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVar, Resources resources, int OplusGLSurfaceView_13) throws NoSuchFieldException {
        FontResourcesParserCompat.IntrinsicsJvm.kt_3 cVarM2642a = m2642a(bVar, OplusGLSurfaceView_13);
        if (cVarM2642a == null) {
            return null;
        }
        Typeface typefaceM2607a = TypefaceCompat.m2607a(context, resources, cVarM2642a.m2287f(), cVarM2642a.m2282a(), OplusGLSurfaceView_13);
        m2644a(typefaceM2607a, bVar);
        return typefaceM2607a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2631a(Context context, Resources resources, int OplusGLSurfaceView_13, String str, int i2) {
        File fileM2649a = TypefaceCompatUtil.m2649a(context);
        if (fileM2649a == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.m2654a(fileM2649a, resources, OplusGLSurfaceView_13)) {
                return Typeface.createFromFile(fileM2649a.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM2649a.delete();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    FontResourcesParserCompat.IntrinsicsJvm.kt_4 m2646a(Typeface typeface) throws NoSuchFieldException {
        long jM2645b = m2645b(typeface);
        if (jM2645b == 0) {
            return null;
        }
        return this.f2992a.get(Long.valueOf(jM2645b));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2644a(Typeface typeface, FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVar) throws NoSuchFieldException {
        long jM2645b = m2645b(typeface);
        if (jM2645b != 0) {
            this.f2992a.put(Long.valueOf(jM2645b), bVar);
        }
    }
}
