package com.airbnb.lottie.d_renamed;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.d_renamed.g_renamed f2148a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.d_renamed.f_renamed f2149b;

    public h_renamed(com.airbnb.lottie.d_renamed.g_renamed gVar, com.airbnb.lottie.d_renamed.f_renamed fVar) {
        this.f2148a = gVar;
        this.f2149b = fVar;
    }

    public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> a_renamed(java.lang.String str, java.lang.String str2) {
        com.airbnb.lottie.d_renamed dVarB = b_renamed(str, str2);
        if (dVarB != null) {
            return new com.airbnb.lottie.l_renamed<>(dVarB);
        }
        com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Animation for " + str + " not found in_renamed cache. Fetching from network.");
        return c_renamed(str, str2);
    }

    private com.airbnb.lottie.d_renamed b_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Pair<com.airbnb.lottie.d_renamed.c_renamed, java.io.InputStream> pairA;
        com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVarB;
        if (str2 == null || (pairA = this.f2148a.a_renamed(str)) == null) {
            return null;
        }
        com.airbnb.lottie.d_renamed.c_renamed cVar = (com.airbnb.lottie.d_renamed.c_renamed) pairA.first;
        java.io.InputStream inputStream = (java.io.InputStream) pairA.second;
        if (cVar == com.airbnb.lottie.d_renamed.c_renamed.ZIP) {
            lVarB = com.airbnb.lottie.e_renamed.a_renamed(new java.util.zip.ZipInputStream(inputStream), str);
        } else {
            lVarB = com.airbnb.lottie.e_renamed.b_renamed(inputStream, str);
        }
        if (lVarB.a_renamed() != null) {
            return lVarB.a_renamed();
        }
        return null;
    }

    private com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> c_renamed(java.lang.String str, java.lang.String str2) {
        com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Fetching " + str);
        com.airbnb.lottie.d_renamed.d_renamed dVar = null;
        try {
            try {
                com.airbnb.lottie.d_renamed.d_renamed dVarA = this.f2149b.a_renamed(str);
                if (!dVarA.a_renamed()) {
                    com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVar = new com.airbnb.lottie.l_renamed<>(new java.lang.IllegalArgumentException(dVarA.d_renamed()));
                    if (dVarA != null) {
                        try {
                            dVarA.close();
                        } catch (java.io.IOException e_renamed) {
                            com.airbnb.lottie.f_renamed.d_renamed.a_renamed("LottieFetchResult close failed ", e_renamed);
                        }
                    }
                    return lVar;
                }
                com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVarA = a_renamed(str, dVarA.b_renamed(), dVarA.c_renamed(), str2);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(lVarA.a_renamed() != null);
                com.airbnb.lottie.f_renamed.d_renamed.a_renamed(sb.toString());
                if (dVarA != null) {
                    try {
                        dVarA.close();
                    } catch (java.io.IOException e2) {
                        com.airbnb.lottie.f_renamed.d_renamed.a_renamed("LottieFetchResult close failed ", e2);
                    }
                }
                return lVarA;
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    try {
                        dVar.close();
                    } catch (java.io.IOException e3) {
                        com.airbnb.lottie.f_renamed.d_renamed.a_renamed("LottieFetchResult close failed ", e3);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e4) {
            com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVar2 = new com.airbnb.lottie.l_renamed<>(e4);
            if (0 != 0) {
                try {
                    dVar.close();
                } catch (java.io.IOException e5) {
                    com.airbnb.lottie.f_renamed.d_renamed.a_renamed("LottieFetchResult close failed ", e5);
                }
            }
            return lVar2;
        }
    }

    private com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> a_renamed(java.lang.String str, java.io.InputStream inputStream, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        com.airbnb.lottie.d_renamed.c_renamed cVar;
        com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> lVarA;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Handling zip response.");
            cVar = com.airbnb.lottie.d_renamed.c_renamed.ZIP;
            lVarA = a_renamed(str, inputStream, str3);
        } else {
            com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Received json response.");
            cVar = com.airbnb.lottie.d_renamed.c_renamed.JSON;
            lVarA = b_renamed(str, inputStream, str3);
        }
        if (str3 != null && lVarA.a_renamed() != null) {
            this.f2148a.a_renamed(str, cVar);
        }
        return lVarA;
    }

    private com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> a_renamed(java.lang.String str, java.io.InputStream inputStream, java.lang.String str2) throws java.io.IOException {
        if (str2 == null) {
            return com.airbnb.lottie.e_renamed.a_renamed(new java.util.zip.ZipInputStream(inputStream), (java.lang.String) null);
        }
        return com.airbnb.lottie.e_renamed.a_renamed(new java.util.zip.ZipInputStream(new java.io.FileInputStream(this.f2148a.a_renamed(str, inputStream, com.airbnb.lottie.d_renamed.c_renamed.ZIP))), str);
    }

    private com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> b_renamed(java.lang.String str, java.io.InputStream inputStream, java.lang.String str2) throws java.io.IOException {
        if (str2 == null) {
            return com.airbnb.lottie.e_renamed.b_renamed(inputStream, (java.lang.String) null);
        }
        return com.airbnb.lottie.e_renamed.b_renamed(new java.io.FileInputStream(new java.io.File(this.f2148a.a_renamed(str, inputStream, com.airbnb.lottie.d_renamed.c_renamed.JSON).getAbsolutePath())), str);
    }
}
