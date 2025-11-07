package com.oplus.anim;

/* compiled from: EffectiveCompositionFactory.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Map<java.lang.String, com.oplus.anim.f_renamed<com.oplus.anim.a_renamed>> f3682a = new java.util.HashMap();

    public static com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> a_renamed(final android.content.Context context, final java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromUrl url = " + str.toString());
        }
        return a_renamed("url_" + str, new java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>>() { // from class: com.oplus.anim.g_renamed.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> call() {
                return com.oplus.anim.d_renamed.c_renamed.a_renamed(context, str);
            }
        });
    }

    public static com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> b_renamed(android.content.Context context, final java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromAsset fileName = " + str.toString());
        }
        final android.content.Context applicationContext = context.getApplicationContext();
        return a_renamed(str, new java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>>() { // from class: com.oplus.anim.g_renamed.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> call() {
                return com.oplus.anim.g_renamed.c_renamed(applicationContext, str);
            }
        });
    }

    public static com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> a_renamed(final android.content.res.AssetManager assetManager, final java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromAsset fileName = " + str.toString());
        }
        return a_renamed(str, new java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>>() { // from class: com.oplus.anim.g_renamed.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> call() {
                return com.oplus.anim.g_renamed.b_renamed(assetManager, str);
            }
        });
    }

    public static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> c_renamed(android.content.Context context, java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromAssetSync fileName = " + str.toString());
        }
        try {
            java.lang.String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return a_renamed(new java.util.zip.ZipInputStream(context.getAssets().open(str)), str2);
            }
            return a_renamed(context.getAssets().open(str), str2);
        } catch (java.io.IOException e_renamed) {
            return new com.oplus.anim.e_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    public static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> b_renamed(android.content.res.AssetManager assetManager, java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromAssetSync fileName = " + str.toString());
        }
        try {
            java.lang.String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return a_renamed(new java.util.zip.ZipInputStream(assetManager.open(str)), str2);
            }
            return a_renamed(assetManager.open(str), str2);
        } catch (java.io.IOException e_renamed) {
            return new com.oplus.anim.e_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    public static com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> a_renamed(android.content.Context context, final int i_renamed) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromRawRes.");
        }
        final android.content.Context applicationContext = context.getApplicationContext();
        return a_renamed(a_renamed(i_renamed), new java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>>() { // from class: com.oplus.anim.g_renamed.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> call() {
                return com.oplus.anim.g_renamed.c_renamed(applicationContext, i_renamed);
            }
        });
    }

    public static com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> b_renamed(android.content.Context context, final int i_renamed) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromRawResUsingActivityContext.");
        }
        final java.lang.ref.WeakReference weakReference = new java.lang.ref.WeakReference(context);
        return a_renamed(a_renamed(i_renamed), new java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>>() { // from class: com.oplus.anim.g_renamed.8
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> call() {
                java.lang.ref.WeakReference weakReference2 = weakReference;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return null;
                }
                return com.oplus.anim.g_renamed.c_renamed((android.content.Context) weakReference.get(), i_renamed);
            }
        });
    }

    public static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> c_renamed(android.content.Context context, int i_renamed) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromRawResSync.");
        }
        try {
            return a_renamed(context.getResources().openRawResource(i_renamed), a_renamed(i_renamed));
        } catch (android.content.res.Resources.NotFoundException e_renamed) {
            return new com.oplus.anim.e_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    private static java.lang.String a_renamed(int i_renamed) {
        return "rawRes_" + i_renamed;
    }

    public static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> a_renamed(java.io.InputStream inputStream, java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromJsonInputStreamSync cacheKey = " + str);
        }
        return a_renamed(inputStream, str, true);
    }

    private static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> a_renamed(java.io.InputStream inputStream, java.lang.String str, boolean z_renamed) throws java.io.IOException {
        try {
            return b_renamed(new android.util.JsonReader(new java.io.InputStreamReader(inputStream)), str);
        } finally {
            if (z_renamed) {
                com.oplus.anim.f_renamed.g_renamed.a_renamed(inputStream);
            }
        }
    }

    public static com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> a_renamed(final android.util.JsonReader jsonReader, final java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromJsonReader cacheKey = " + str);
        }
        return a_renamed(str, new java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>>() { // from class: com.oplus.anim.g_renamed.9
            @Override // java.util.concurrent.Callable
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> call() {
                return com.oplus.anim.g_renamed.b_renamed(jsonReader, str);
            }
        });
    }

    public static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> b_renamed(android.util.JsonReader jsonReader, java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromJsonReaderSync cacheKey = " + str);
        }
        return a_renamed(jsonReader, str, true);
    }

    private static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> a_renamed(android.util.JsonReader jsonReader, java.lang.String str, boolean z_renamed) throws java.io.IOException {
        try {
            try {
                com.oplus.anim.a_renamed aVarA = com.oplus.anim.e_renamed.i_renamed.a_renamed(jsonReader);
                com.oplus.anim.c_renamed.c_renamed.a_renamed().a_renamed(str, aVarA);
                com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> eVar = new com.oplus.anim.e_renamed<>(aVarA);
                if (z_renamed) {
                    com.oplus.anim.f_renamed.g_renamed.a_renamed(jsonReader);
                }
                return eVar;
            } catch (java.lang.Exception e_renamed) {
                com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> eVar2 = new com.oplus.anim.e_renamed<>(e_renamed);
                if (z_renamed) {
                    com.oplus.anim.f_renamed.g_renamed.a_renamed(jsonReader);
                }
                return eVar2;
            }
        } catch (java.lang.Throwable th) {
            if (z_renamed) {
                com.oplus.anim.f_renamed.g_renamed.a_renamed(jsonReader);
            }
            throw th;
        }
    }

    public static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> a_renamed(java.util.zip.ZipInputStream zipInputStream, java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromZipStreamSync cacheKey = " + str);
        }
        try {
            return a_renamed(zipInputStream, str, (android.graphics.BitmapFactory.Options) null);
        } finally {
            com.oplus.anim.f_renamed.g_renamed.a_renamed(zipInputStream);
        }
    }

    private static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> a_renamed(java.util.zip.ZipInputStream zipInputStream, java.lang.String str, android.graphics.BitmapFactory.Options options) throws java.io.IOException {
        java.util.HashMap map = new java.util.HashMap();
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromZipStreamSyncInternal cacheKey = " + str);
        }
        try {
            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("EffectiveCompositionFactory::fromZipStreamSyncInternal entry == null ? ");
                sb.append(nextEntry == null);
                com.oplus.anim.f_renamed.f_renamed.b_renamed(sb.toString());
            }
            com.oplus.anim.a_renamed aVarA = null;
            while (nextEntry != null) {
                if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
                    com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::fromZipStreamSyncInternal entry.getName() = " + nextEntry.getName());
                }
                if (nextEntry.getName().contains("__MACOSX") || nextEntry.getName().contains("../")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    aVarA = a_renamed(new android.util.JsonReader(new java.io.InputStreamReader(zipInputStream)), (java.lang.String) null, false).a_renamed();
                } else if (nextEntry.getName().endsWith(".png")) {
                    java.lang.String[] strArrSplit = nextEntry.getName().split("/");
                    map.put(strArrSplit[strArrSplit.length - 1], android.graphics.BitmapFactory.decodeStream(zipInputStream, null, options));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (aVarA == null) {
                return new com.oplus.anim.e_renamed<>((java.lang.Throwable) new java.lang.IllegalArgumentException("Unable to parse composition"));
            }
            for (java.util.Map.Entry entry : map.entrySet()) {
                com.oplus.anim.h_renamed hVarA = a_renamed(aVarA, (java.lang.String) entry.getKey());
                if (hVarA != null) {
                    hVarA.a_renamed((android.graphics.Bitmap) entry.getValue());
                }
            }
            for (java.util.Map.Entry<java.lang.String, com.oplus.anim.h_renamed> entry2 : aVarA.l_renamed().entrySet()) {
                if (entry2.getValue().c_renamed() == null) {
                    return new com.oplus.anim.e_renamed<>((java.lang.Throwable) new java.lang.IllegalStateException("There is_renamed no image for " + entry2.getValue().b_renamed()));
                }
            }
            com.oplus.anim.c_renamed.c_renamed.a_renamed().a_renamed(str, aVarA);
            return new com.oplus.anim.e_renamed<>(aVarA);
        } catch (java.io.IOException e_renamed) {
            return new com.oplus.anim.e_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    private static com.oplus.anim.h_renamed a_renamed(com.oplus.anim.a_renamed aVar, java.lang.String str) {
        for (com.oplus.anim.h_renamed hVar : aVar.l_renamed().values()) {
            if (hVar.b_renamed().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    private static com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> a_renamed(final java.lang.String str, java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>> callable) {
        final com.oplus.anim.a_renamed aVarA = str == null ? null : com.oplus.anim.c_renamed.c_renamed.a_renamed().a_renamed(str);
        float f_renamed = android.content.res.Resources.getSystem().getDisplayMetrics().density;
        if (aVarA != null && aVarA.n_renamed() == f_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::cached Composition isn't_renamed null, cacheKey is_renamed " + str);
            return new com.oplus.anim.f_renamed<>(new java.util.concurrent.Callable<com.oplus.anim.e_renamed<com.oplus.anim.a_renamed>>() { // from class: com.oplus.anim.g_renamed.2
                @Override // java.util.concurrent.Callable
                /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
                public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> call() {
                    return new com.oplus.anim.e_renamed<>(aVarA);
                }
            }, true);
        }
        if (aVarA != null && aVarA.n_renamed() != f_renamed) {
            com.oplus.anim.f_renamed.g_renamed.b_renamed();
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveCompositionFactory::cachedComposition density = " + aVarA.n_renamed() + "; curDensity = " + f_renamed);
        }
        if (str != null && f3682a.containsKey(str)) {
            return f3682a.get(str);
        }
        com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> fVar = new com.oplus.anim.f_renamed<>(callable);
        fVar.a_renamed(new com.oplus.anim.c_renamed<com.oplus.anim.a_renamed>() { // from class: com.oplus.anim.g_renamed.3
            @Override // com.oplus.anim.c_renamed
            public void a_renamed(com.oplus.anim.a_renamed aVar) {
                com.oplus.anim.g_renamed.f3682a.remove(str);
            }
        });
        fVar.b_renamed(new com.oplus.anim.c_renamed<java.lang.Throwable>() { // from class: com.oplus.anim.g_renamed.4
            @Override // com.oplus.anim.c_renamed
            public void a_renamed(java.lang.Throwable th) {
                com.oplus.anim.g_renamed.f3682a.remove(str);
            }
        });
        f3682a.put(str, fVar);
        return fVar;
    }
}
