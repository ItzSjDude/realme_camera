package androidx.core.graphics;

/* compiled from: TypefaceCompat.java */
@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final androidx.core.graphics.l_renamed f941a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> f942b;

    static {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            f941a = new androidx.core.graphics.k_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 28) {
            f941a = new androidx.core.graphics.j_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            f941a = new androidx.core.graphics.i_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 24 && androidx.core.graphics.h_renamed.a_renamed()) {
            f941a = new androidx.core.graphics.h_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            f941a = new androidx.core.graphics.g_renamed();
        } else {
            f941a = new androidx.core.graphics.l_renamed();
        }
        f942b = new androidx.collection.LruCache<>(16);
    }

    public static android.graphics.Typeface a_renamed(android.content.res.Resources resources, int i_renamed, int i2) {
        return f942b.get(b_renamed(resources, i_renamed, i2));
    }

    private static java.lang.String b_renamed(android.content.res.Resources resources, int i_renamed, int i2) {
        return resources.getResourcePackageName(i_renamed) + "-" + i_renamed + "-" + i2;
    }

    public static android.graphics.Typeface a_renamed(android.content.Context context, androidx.core.a_renamed.a_renamed.c_renamed.a_renamed aVar, android.content.res.Resources resources, int i_renamed, int i2, androidx.core.a_renamed.a_renamed.f_renamed.a_renamed aVar2, android.os.Handler handler, boolean z_renamed) throws java.lang.NoSuchFieldException {
        android.graphics.Typeface typefaceA;
        if (aVar instanceof androidx.core.a_renamed.a_renamed.c_renamed.d_renamed) {
            androidx.core.a_renamed.a_renamed.c_renamed.d_renamed dVar = (androidx.core.a_renamed.a_renamed.c_renamed.d_renamed) aVar;
            boolean z2 = false;
            if (!z_renamed ? aVar2 == null : dVar.b_renamed() == 0) {
                z2 = true;
            }
            typefaceA = androidx.core.e_renamed.b_renamed.a_renamed(context, dVar.a_renamed(), aVar2, handler, z2, z_renamed ? dVar.c_renamed() : -1, i2);
        } else {
            typefaceA = f941a.a_renamed(context, (androidx.core.a_renamed.a_renamed.c_renamed.b_renamed) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceA != null) {
                    aVar2.callbackSuccessAsync(typefaceA, handler);
                } else {
                    aVar2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f942b.put(b_renamed(resources, i_renamed, i2), typefaceA);
        }
        return typefaceA;
    }

    public static android.graphics.Typeface a_renamed(android.content.Context context, android.content.res.Resources resources, int i_renamed, java.lang.String str, int i2) {
        android.graphics.Typeface typefaceA = f941a.a_renamed(context, resources, i_renamed, str, i2);
        if (typefaceA != null) {
            f942b.put(b_renamed(resources, i_renamed, i2), typefaceA);
        }
        return typefaceA;
    }

    public static android.graphics.Typeface a_renamed(android.content.Context context, android.os.CancellationSignal cancellationSignal, androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] c0016bArr, int i_renamed) {
        return f941a.a_renamed(context, cancellationSignal, c0016bArr, i_renamed);
    }

    private static android.graphics.Typeface b_renamed(android.content.Context context, android.graphics.Typeface typeface, int i_renamed) throws java.lang.NoSuchFieldException {
        androidx.core.a_renamed.a_renamed.c_renamed.b_renamed bVarA = f941a.a_renamed(typeface);
        if (bVarA == null) {
            return null;
        }
        return f941a.a_renamed(context, bVarA, context.getResources(), i_renamed);
    }

    public static android.graphics.Typeface a_renamed(android.content.Context context, android.graphics.Typeface typeface, int i_renamed) {
        android.graphics.Typeface typefaceB;
        if (context != null) {
            return (android.os.Build.VERSION.SDK_INT >= 21 || (typefaceB = b_renamed(context, typeface, i_renamed)) == null) ? android.graphics.Typeface.create(typeface, i_renamed) : typefaceB;
        }
        throw new java.lang.IllegalArgumentException("Context cannot be_renamed null");
    }
}
