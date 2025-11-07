package com.oplus.anim.d_renamed;

/* compiled from: NetworkCache.java */
/* loaded from: classes2.dex */
class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f3644a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f3645b;

    b_renamed(android.content.Context context, java.lang.String str) {
        this.f3644a = context.getApplicationContext();
        this.f3645b = str;
    }

    private static java.lang.String a_renamed(java.lang.String str, com.oplus.anim.d_renamed.a_renamed aVar, boolean z_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("effective_anim_cache_");
        sb.append(str.replaceAll("\\W_renamed+", ""));
        sb.append(z_renamed ? aVar.tempExtension() : aVar.extension);
        return sb.toString();
    }

    android.util.Pair<com.oplus.anim.d_renamed.a_renamed, java.io.InputStream> a_renamed() {
        com.oplus.anim.d_renamed.a_renamed aVar;
        try {
            java.io.File fileA = a_renamed(this.f3645b);
            if (fileA == null) {
                return null;
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fileA);
            if (fileA.getAbsolutePath().endsWith(".zip")) {
                aVar = com.oplus.anim.d_renamed.a_renamed.ZIP;
            } else {
                aVar = com.oplus.anim.d_renamed.a_renamed.JSON;
            }
            com.oplus.anim.k_renamed.a_renamed("Cache hit for " + this.f3645b + " at_renamed " + fileA.getAbsolutePath());
            return new android.util.Pair<>(aVar, fileInputStream);
        } catch (java.io.FileNotFoundException unused) {
            return null;
        }
    }

    java.io.File a_renamed(java.io.InputStream inputStream, com.oplus.anim.d_renamed.a_renamed aVar) throws java.io.IOException {
        java.io.File file = new java.io.File(this.f3644a.getCacheDir(), a_renamed(this.f3645b, aVar, true));
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i_renamed = inputStream.read(bArr);
                    if (i_renamed != -1) {
                        fileOutputStream.write(bArr, 0, i_renamed);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    void a_renamed(com.oplus.anim.d_renamed.a_renamed aVar) {
        java.io.File file = new java.io.File(this.f3644a.getCacheDir(), a_renamed(this.f3645b, aVar, true));
        java.io.File file2 = new java.io.File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.oplus.anim.k_renamed.a_renamed("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.oplus.anim.k_renamed.b_renamed("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private java.io.File a_renamed(java.lang.String str) throws java.io.FileNotFoundException {
        java.io.File file = new java.io.File(this.f3644a.getCacheDir(), a_renamed(str, com.oplus.anim.d_renamed.a_renamed.JSON, false));
        if (file.exists()) {
            return file;
        }
        java.io.File file2 = new java.io.File(this.f3644a.getCacheDir(), a_renamed(str, com.oplus.anim.d_renamed.a_renamed.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }
}
