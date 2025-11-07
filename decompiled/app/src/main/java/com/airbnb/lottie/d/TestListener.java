package com.airbnb.lottie.d_renamed;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.d_renamed.e_renamed f2147a;

    public g_renamed(com.airbnb.lottie.d_renamed.e_renamed eVar) {
        this.f2147a = eVar;
    }

    android.util.Pair<com.airbnb.lottie.d_renamed.c_renamed, java.io.InputStream> a_renamed(java.lang.String str) {
        com.airbnb.lottie.d_renamed.c_renamed cVar;
        try {
            java.io.File fileB = b_renamed(str);
            if (fileB == null) {
                return null;
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fileB);
            if (fileB.getAbsolutePath().endsWith(".zip")) {
                cVar = com.airbnb.lottie.d_renamed.c_renamed.ZIP;
            } else {
                cVar = com.airbnb.lottie.d_renamed.c_renamed.JSON;
            }
            com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Cache hit for " + str + " at_renamed " + fileB.getAbsolutePath());
            return new android.util.Pair<>(cVar, fileInputStream);
        } catch (java.io.FileNotFoundException unused) {
            return null;
        }
    }

    java.io.File a_renamed(java.lang.String str, java.io.InputStream inputStream, com.airbnb.lottie.d_renamed.c_renamed cVar) throws java.io.IOException {
        java.io.File file = new java.io.File(a_renamed(), a_renamed(str, cVar, true));
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

    void a_renamed(java.lang.String str, com.airbnb.lottie.d_renamed.c_renamed cVar) {
        java.io.File file = new java.io.File(a_renamed(), a_renamed(str, cVar, true));
        java.io.File file2 = new java.io.File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private java.io.File b_renamed(java.lang.String str) throws java.io.FileNotFoundException {
        java.io.File file = new java.io.File(a_renamed(), a_renamed(str, com.airbnb.lottie.d_renamed.c_renamed.JSON, false));
        if (file.exists()) {
            return file;
        }
        java.io.File file2 = new java.io.File(a_renamed(), a_renamed(str, com.airbnb.lottie.d_renamed.c_renamed.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private java.io.File a_renamed() {
        java.io.File fileA = this.f2147a.a_renamed();
        if (fileA.isFile()) {
            fileA.delete();
        }
        if (!fileA.exists()) {
            fileA.mkdirs();
        }
        return fileA;
    }

    private static java.lang.String a_renamed(java.lang.String str, com.airbnb.lottie.d_renamed.c_renamed cVar, boolean z_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W_renamed+", ""));
        sb.append(z_renamed ? cVar.tempExtension() : cVar.extension);
        return sb.toString();
    }
}
