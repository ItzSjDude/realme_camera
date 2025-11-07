package androidx.core.graphics;

/* compiled from: TypefaceCompatBaseImpl.java */
/* loaded from: classes.dex */
class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, androidx.core.a_renamed.a_renamed.c_renamed.b_renamed> f952a = new java.util.concurrent.ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl.java */
    private interface a_renamed<T_renamed> {
        boolean a_renamed(T_renamed t_renamed);

        int b_renamed(T_renamed t_renamed);
    }

    l_renamed() {
    }

    private static <T_renamed> T_renamed a_renamed(T_renamed[] tArr, int i_renamed, androidx.core.graphics.l_renamed.a_renamed<T_renamed> aVar) {
        int i2 = (i_renamed & 1) == 0 ? 400 : 700;
        boolean z_renamed = (i_renamed & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T_renamed t_renamed = null;
        for (T_renamed t2 : tArr) {
            int iAbs = (java.lang.Math.abs(aVar.b_renamed(t2) - i2) * 2) + (aVar.a_renamed(t2) == z_renamed ? 0 : 1);
            if (t_renamed == null || i3 > iAbs) {
                t_renamed = t2;
                i3 = iAbs;
            }
        }
        return t_renamed;
    }

    private static long b_renamed(android.graphics.Typeface typeface) throws java.lang.NoSuchFieldException {
        if (typeface == null) {
            return 0L;
        }
        try {
            java.lang.reflect.Field declaredField = android.graphics.Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((java.lang.Number) declaredField.get(typeface)).longValue();
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.e_renamed("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e_renamed);
            return 0L;
        } catch (java.lang.NoSuchFieldException e2) {
            android.util.Log.e_renamed("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    protected androidx.core.e_renamed.b_renamed.FontsContractCompat_3 a_renamed(androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] c0016bArr, int i_renamed) {
        return (androidx.core.e_renamed.b_renamed.FontsContractCompat_3) a_renamed(c0016bArr, i_renamed, new androidx.core.graphics.l_renamed.a_renamed<androidx.core.e_renamed.b_renamed.FontsContractCompat_3>() { // from class: androidx.core.graphics.l_renamed.1
            @Override // androidx.core.graphics.l_renamed.a_renamed
            /* renamed from: a_renamed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
            public int b_renamed(androidx.core.e_renamed.b_renamed.FontsContractCompat_3 c0016b) {
                return c0016b.c_renamed();
            }

            @Override // androidx.core.graphics.l_renamed.a_renamed
            /* renamed from: b_renamed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
            public boolean a_renamed(androidx.core.e_renamed.b_renamed.FontsContractCompat_3 c0016b) {
                return c0016b.d_renamed();
            }
        });
    }

    protected android.graphics.Typeface a_renamed(android.content.Context context, java.io.InputStream inputStream) {
        java.io.File fileA = androidx.core.graphics.m_renamed.a_renamed(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (androidx.core.graphics.m_renamed.a_renamed(fileA, inputStream)) {
                return android.graphics.Typeface.createFromFile(fileA.getPath());
            }
            return null;
        } catch (java.lang.RuntimeException unused) {
            return null;
        } finally {
            fileA.delete();
        }
    }

    public android.graphics.Typeface a_renamed(android.content.Context context, android.os.CancellationSignal cancellationSignal, androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] c0016bArr, int i_renamed) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpenInputStream;
        java.io.InputStream inputStream = null;
        if (c0016bArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(a_renamed(c0016bArr, i_renamed).a_renamed());
        } catch (java.io.IOException unused) {
            inputStreamOpenInputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            android.graphics.Typeface typefaceA = a_renamed(context, inputStreamOpenInputStream);
            androidx.core.graphics.m_renamed.a_renamed(inputStreamOpenInputStream);
            return typefaceA;
        } catch (java.io.IOException unused2) {
            androidx.core.graphics.m_renamed.a_renamed(inputStreamOpenInputStream);
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
            androidx.core.graphics.m_renamed.a_renamed(inputStream);
            throw th;
        }
    }

    private androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 a_renamed(androidx.core.a_renamed.a_renamed.c_renamed.b_renamed bVar, int i_renamed) {
        return (androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4) a_renamed(bVar.a_renamed(), i_renamed, new androidx.core.graphics.l_renamed.a_renamed<androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4>() { // from class: androidx.core.graphics.l_renamed.2
            @Override // androidx.core.graphics.l_renamed.a_renamed
            /* renamed from: a_renamed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
            public int b_renamed(androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 c0013c) {
                return c0013c.b_renamed();
            }

            @Override // androidx.core.graphics.l_renamed.a_renamed
            /* renamed from: b_renamed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
            public boolean a_renamed(androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 c0013c) {
                return c0013c.c_renamed();
            }
        });
    }

    public android.graphics.Typeface a_renamed(android.content.Context context, androidx.core.a_renamed.a_renamed.c_renamed.b_renamed bVar, android.content.res.Resources resources, int i_renamed) throws java.lang.NoSuchFieldException {
        androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 c0013cA = a_renamed(bVar, i_renamed);
        if (c0013cA == null) {
            return null;
        }
        android.graphics.Typeface typefaceA = androidx.core.graphics.f_renamed.a_renamed(context, resources, c0013cA.f_renamed(), c0013cA.a_renamed(), i_renamed);
        a_renamed(typefaceA, bVar);
        return typefaceA;
    }

    public android.graphics.Typeface a_renamed(android.content.Context context, android.content.res.Resources resources, int i_renamed, java.lang.String str, int i2) {
        java.io.File fileA = androidx.core.graphics.m_renamed.a_renamed(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (androidx.core.graphics.m_renamed.a_renamed(fileA, resources, i_renamed)) {
                return android.graphics.Typeface.createFromFile(fileA.getPath());
            }
            return null;
        } catch (java.lang.RuntimeException unused) {
            return null;
        } finally {
            fileA.delete();
        }
    }

    androidx.core.a_renamed.a_renamed.c_renamed.b_renamed a_renamed(android.graphics.Typeface typeface) throws java.lang.NoSuchFieldException {
        long jB = b_renamed(typeface);
        if (jB == 0) {
            return null;
        }
        return this.f952a.get(java.lang.Long.valueOf(jB));
    }

    private void a_renamed(android.graphics.Typeface typeface, androidx.core.a_renamed.a_renamed.c_renamed.b_renamed bVar) throws java.lang.NoSuchFieldException {
        long jB = b_renamed(typeface);
        if (jB != 0) {
            this.f952a.put(java.lang.Long.valueOf(jB), bVar);
        }
    }
}
