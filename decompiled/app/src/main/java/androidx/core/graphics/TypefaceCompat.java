package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.p027a.p028a.FontResourcesParserCompat;
import androidx.core.p027a.p028a.ResourcesCompat;
import androidx.core.p033e.FontsContractCompat;

/* compiled from: TypefaceCompat.java */
@SuppressLint({"NewApi"})
/* renamed from: androidx.core.graphics.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class TypefaceCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final TypefaceCompatBaseImpl f2974a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final LruCache<String, Typeface> f2975b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2974a = new TypefaceCompatApi29Impl();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f2974a = new TypefaceCompatApi28Impl();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f2974a = new TypefaceCompatApi26Impl();
        } else if (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.m2622a()) {
            f2974a = new TypefaceCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2974a = new TypefaceCompatApi21Impl();
        } else {
            f2974a = new TypefaceCompatBaseImpl();
        }
        f2975b = new LruCache<>(16);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2611a(Resources resources, int OplusGLSurfaceView_13, int i2) {
        return f2975b.get(m2613b(resources, OplusGLSurfaceView_13, i2));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String m2613b(Resources resources, int OplusGLSurfaceView_13, int i2) {
        return resources.getResourcePackageName(OplusGLSurfaceView_13) + "-" + OplusGLSurfaceView_13 + "-" + i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2610a(Context context, FontResourcesParserCompat.PlatformImplementations.kt_3 aVar, Resources resources, int OplusGLSurfaceView_13, int i2, ResourcesCompat.PlatformImplementations.kt_3 aVar2, Handler handler, boolean z) throws NoSuchFieldException {
        Typeface typefaceMo2620a;
        if (aVar instanceof FontResourcesParserCompat.IntrinsicsJvm.kt_5) {
            FontResourcesParserCompat.IntrinsicsJvm.kt_5 dVar = (FontResourcesParserCompat.IntrinsicsJvm.kt_5) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.m2289b() == 0) {
                z2 = true;
            }
            typefaceMo2620a = FontsContractCompat.m2457a(context, dVar.m2288a(), aVar2, handler, z2, z ? dVar.m2290c() : -1, i2);
        } else {
            typefaceMo2620a = f2974a.mo2620a(context, (FontResourcesParserCompat.IntrinsicsJvm.kt_4) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceMo2620a != null) {
                    aVar2.callbackSuccessAsync(typefaceMo2620a, handler);
                } else {
                    aVar2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typefaceMo2620a != null) {
            f2975b.put(m2613b(resources, OplusGLSurfaceView_13, i2), typefaceMo2620a);
        }
        return typefaceMo2620a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2607a(Context context, Resources resources, int OplusGLSurfaceView_13, String str, int i2) {
        Typeface typefaceMo2631a = f2974a.mo2631a(context, resources, OplusGLSurfaceView_13, str, i2);
        if (typefaceMo2631a != null) {
            f2975b.put(m2613b(resources, OplusGLSurfaceView_13, i2), typefaceMo2631a);
        }
        return typefaceMo2631a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2609a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.IntrinsicsJvm.kt_4[] bVarArr, int OplusGLSurfaceView_13) {
        return f2974a.mo2619a(context, cancellationSignal, bVarArr, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Typeface m2612b(Context context, Typeface typeface, int OplusGLSurfaceView_13) throws NoSuchFieldException {
        FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVarM2646a = f2974a.m2646a(typeface);
        if (bVarM2646a == null) {
            return null;
        }
        return f2974a.mo2620a(context, bVarM2646a, context.getResources(), OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2608a(Context context, Typeface typeface, int OplusGLSurfaceView_13) {
        Typeface typefaceM2612b;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceM2612b = m2612b(context, typeface, OplusGLSurfaceView_13)) == null) ? Typeface.create(typeface, OplusGLSurfaceView_13) : typefaceM2612b;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
