package com.airbnb.lottie;

/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Map<java.lang.String, com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed>> f2150a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final byte[] f2151b = {80, 75, 3, 4};

    public static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(android.content.Context context, java.lang.String str) {
        return a_renamed(context, str, "url_" + str);
    }

    public static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(final android.content.Context context, final java.lang.String str, final java.lang.String str2) {
        return a_renamed(str2, new java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>>() { // from class: com.airbnb.lottie.e_renamed.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> call() {
                com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVarA = com.airbnb.lottie.c_renamed.a_renamed(context).a_renamed(str, str2);
                if (str2 != null && lVarA.a_renamed() != null) {
                    com.airbnb.lottie.c_renamed.g_renamed.a_renamed().a_renamed(str2, lVarA.a_renamed());
                }
                return lVarA;
            }
        });
    }

    public static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> b_renamed(android.content.Context context, java.lang.String str) {
        return b_renamed(context, str, "asset_" + str);
    }

    public static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> b_renamed(android.content.Context context, final java.lang.String str, final java.lang.String str2) {
        final android.content.Context applicationContext = context.getApplicationContext();
        return a_renamed(str2, new java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>>() { // from class: com.airbnb.lottie.e_renamed.4
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> call() {
                return com.airbnb.lottie.e_renamed.c_renamed(applicationContext, str, str2);
            }
        });
    }

    public static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> c_renamed(android.content.Context context, java.lang.String str) {
        return c_renamed(context, str, "asset_" + str);
    }

    public static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> c_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return b_renamed(context.getAssets().open(str), str2);
            }
            return a_renamed(new java.util.zip.ZipInputStream(context.getAssets().open(str)), str2);
        } catch (java.io.IOException e_renamed) {
            return new com.airbnb.lottie.l_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    public static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(android.content.Context context, int i_renamed) {
        return a_renamed(context, i_renamed, c_renamed(context, i_renamed));
    }

    public static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(android.content.Context context, final int i_renamed, final java.lang.String str) {
        final java.lang.ref.WeakReference weakReference = new java.lang.ref.WeakReference(context);
        final android.content.Context applicationContext = context.getApplicationContext();
        return a_renamed(str, new java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>>() { // from class: com.airbnb.lottie.e_renamed.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> call() {
                android.content.Context context2 = (android.content.Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return com.airbnb.lottie.e_renamed.b_renamed(context2, i_renamed, str);
            }
        });
    }

    public static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> b_renamed(android.content.Context context, int i_renamed) {
        return b_renamed(context, i_renamed, c_renamed(context, i_renamed));
    }

    public static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> b_renamed(android.content.Context context, int i_renamed, java.lang.String str) {
        try {
            okio.BufferedSource bufferedSourceBuffer = okio.Okio.buffer(okio.Okio.source(context.getResources().openRawResource(i_renamed)));
            if (a_renamed(bufferedSourceBuffer).booleanValue()) {
                return a_renamed(new java.util.zip.ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            return b_renamed(bufferedSourceBuffer.inputStream(), str);
        } catch (android.content.res.Resources.NotFoundException e_renamed) {
            return new com.airbnb.lottie.l_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    private static java.lang.String c_renamed(android.content.Context context, int i_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("rawRes");
        sb.append(a_renamed(context) ? "_night_" : "_day_");
        sb.append(i_renamed);
        return sb.toString();
    }

    private static boolean a_renamed(android.content.Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(final java.io.InputStream inputStream, final java.lang.String str) {
        return a_renamed(str, new java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>>() { // from class: com.airbnb.lottie.e_renamed.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> call() {
                return com.airbnb.lottie.e_renamed.b_renamed(inputStream, str);
            }
        });
    }

    public static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> b_renamed(java.io.InputStream inputStream, java.lang.String str) {
        return a_renamed(inputStream, str, true);
    }

    private static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> a_renamed(java.io.InputStream inputStream, java.lang.String str, boolean z_renamed) throws java.io.IOException {
        try {
            return a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed(okio.Okio.buffer(okio.Okio.source(inputStream))), str);
        } finally {
            if (z_renamed) {
                com.airbnb.lottie.f_renamed.h_renamed.a_renamed(inputStream);
            }
        }
    }

    public static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, java.lang.String str) {
        return a_renamed(cVar, str, true);
    }

    private static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, java.lang.String str, boolean z_renamed) throws java.io.IOException {
        try {
            try {
                com.airbnb.lottie.d_renamed dVarA = com.airbnb.lottie.e_renamed.t_renamed.a_renamed(cVar);
                if (str != null) {
                    com.airbnb.lottie.c_renamed.g_renamed.a_renamed().a_renamed(str, dVarA);
                }
                com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVar = new com.airbnb.lottie.l_renamed<>(dVarA);
                if (z_renamed) {
                    com.airbnb.lottie.f_renamed.h_renamed.a_renamed(cVar);
                }
                return lVar;
            } catch (java.lang.Exception e_renamed) {
                com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVar2 = new com.airbnb.lottie.l_renamed<>(e_renamed);
                if (z_renamed) {
                    com.airbnb.lottie.f_renamed.h_renamed.a_renamed(cVar);
                }
                return lVar2;
            }
        } catch (java.lang.Throwable th) {
            if (z_renamed) {
                com.airbnb.lottie.f_renamed.h_renamed.a_renamed(cVar);
            }
            throw th;
        }
    }

    public static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> a_renamed(java.util.zip.ZipInputStream zipInputStream, java.lang.String str) {
        try {
            return b_renamed(zipInputStream, str);
        } finally {
            com.airbnb.lottie.f_renamed.h_renamed.a_renamed(zipInputStream);
        }
    }

    private static com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> b_renamed(java.util.zip.ZipInputStream zipInputStream, java.lang.String str) throws java.io.IOException {
        java.util.HashMap map = new java.util.HashMap();
        try {
            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.d_renamed dVarA = null;
            while (nextEntry != null) {
                java.lang.String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVarA = a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed(okio.Okio.buffer(okio.Okio.source(zipInputStream))), (java.lang.String) null, false).a_renamed();
                } else if (name.contains(".png") || name.contains(".webp")) {
                    map.put(name.split("/")[r1.length - 1], android.graphics.BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVarA == null) {
                return new com.airbnb.lottie.l_renamed<>((java.lang.Throwable) new java.lang.IllegalArgumentException("Unable to parse composition"));
            }
            for (java.util.Map.Entry entry : map.entrySet()) {
                com.airbnb.lottie.g_renamed gVarA = a_renamed(dVarA, (java.lang.String) entry.getKey());
                if (gVarA != null) {
                    gVarA.a_renamed(com.airbnb.lottie.f_renamed.h_renamed.a_renamed((android.graphics.Bitmap) entry.getValue(), gVarA.a_renamed(), gVarA.b_renamed()));
                }
            }
            for (java.util.Map.Entry<java.lang.String, com.airbnb.lottie.g_renamed> entry2 : dVarA.l_renamed().entrySet()) {
                if (entry2.getValue().e_renamed() == null) {
                    return new com.airbnb.lottie.l_renamed<>((java.lang.Throwable) new java.lang.IllegalStateException("There is_renamed no image for " + entry2.getValue().d_renamed()));
                }
            }
            if (str != null) {
                com.airbnb.lottie.c_renamed.g_renamed.a_renamed().a_renamed(str, dVarA);
            }
            return new com.airbnb.lottie.l_renamed<>(dVarA);
        } catch (java.io.IOException e_renamed) {
            return new com.airbnb.lottie.l_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    private static java.lang.Boolean a_renamed(okio.BufferedSource bufferedSource) {
        try {
            okio.BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b2 : f2151b) {
                if (bufferedSourcePeek.readByte() != b2) {
                    return false;
                }
            }
            bufferedSourcePeek.close();
            return true;
        } catch (java.lang.Exception e_renamed) {
            com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Failed to check zip file header", e_renamed);
            return false;
        }
    }

    private static com.airbnb.lottie.g_renamed a_renamed(com.airbnb.lottie.d_renamed dVar, java.lang.String str) {
        for (com.airbnb.lottie.g_renamed gVar : dVar.l_renamed().values()) {
            if (gVar.d_renamed().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    private static com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(final java.lang.String str, java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>> callable) {
        final com.airbnb.lottie.d_renamed dVarA = str == null ? null : com.airbnb.lottie.c_renamed.g_renamed.a_renamed().a_renamed(str);
        if (dVarA != null) {
            return new com.airbnb.lottie.m_renamed<>(new java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>>() { // from class: com.airbnb.lottie.e_renamed.7
                @Override // java.util.concurrent.Callable
                /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
                public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> call() {
                    return new com.airbnb.lottie.l_renamed<>(dVarA);
                }
            });
        }
        if (str != null && f2150a.containsKey(str)) {
            return f2150a.get(str);
        }
        com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> mVar = new com.airbnb.lottie.m_renamed<>(callable);
        if (str != null) {
            mVar.a_renamed(new com.airbnb.lottie.h_renamed<com.airbnb.lottie.d_renamed>() { // from class: com.airbnb.lottie.e_renamed.2
                @Override // com.airbnb.lottie.h_renamed
                public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                    com.airbnb.lottie.e_renamed.f2150a.remove(str);
                }
            });
            mVar.c_renamed(new com.airbnb.lottie.h_renamed<java.lang.Throwable>() { // from class: com.airbnb.lottie.e_renamed.3
                @Override // com.airbnb.lottie.h_renamed
                public void a_renamed(java.lang.Throwable th) {
                    com.airbnb.lottie.e_renamed.f2150a.remove(str);
                }
            });
            f2150a.put(str, mVar);
        }
        return mVar;
    }
}
