package com.oplus.c_renamed.a_renamed.a_renamed.a_renamed;

/* compiled from: BlobCacheManager.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.HashMap<java.lang.String, com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed> f3739a = new java.util.HashMap<>();

    public static com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed a_renamed(android.content.Context context, java.lang.String str, int i_renamed, int i2, int i3) {
        synchronized (f3739a) {
            if (f3739a.get(str) == null) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("CacheManager", "getCacheDir, filename:" + str);
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                java.io.File fileA = a_renamed(context);
                if (fileA != null) {
                    java.lang.String str2 = fileA.getAbsolutePath() + "/" + str;
                    com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("CacheManager", "getCacheDir:" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                    try {
                        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed aVar = new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed(str2, i_renamed, i2, false, i3);
                        f3739a.put(str, aVar);
                        return aVar;
                    } catch (java.io.IOException e_renamed) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("CacheManager", "Cannot instantiate cache!", e_renamed);
                    }
                }
            }
            return null;
        }
    }

    private static java.io.File a_renamed(android.content.Context context) {
        java.io.File fileA = com.oplus.c_renamed.a_renamed.c_renamed.a_renamed();
        if (fileA != null) {
            return a_renamed(fileA);
        }
        return a_renamed(context.getExternalCacheDir());
    }

    public static void a_renamed(android.content.Context context, java.lang.String str) {
        com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed.a_renamed(a_renamed(context) + "/" + str);
        f3739a.clear();
    }

    private static java.io.File a_renamed(java.io.File file) {
        if (file == null) {
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
