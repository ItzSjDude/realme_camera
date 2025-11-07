package com.oplus.anim.d_renamed;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f3646a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f3647b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.d_renamed.b_renamed f3648c;

    private c_renamed(android.content.Context context, java.lang.String str) {
        this.f3646a = context.getApplicationContext();
        this.f3647b = str;
        this.f3648c = new com.oplus.anim.d_renamed.b_renamed(this.f3646a, str);
    }

    public static com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> a_renamed(android.content.Context context, java.lang.String str) {
        return new com.oplus.anim.d_renamed.c_renamed(context, str).a_renamed();
    }

    public com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> a_renamed() {
        com.oplus.anim.a_renamed aVarB = b_renamed();
        if (aVarB != null) {
            return new com.oplus.anim.e_renamed<>(aVarB);
        }
        com.oplus.anim.k_renamed.a_renamed("Animation for " + this.f3647b + " not found in_renamed cache. Fetching from network.");
        return c_renamed();
    }

    private com.oplus.anim.a_renamed b_renamed() {
        com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> eVarA;
        android.util.Pair<com.oplus.anim.d_renamed.a_renamed, java.io.InputStream> pairA = this.f3648c.a_renamed();
        if (pairA == null) {
            return null;
        }
        com.oplus.anim.d_renamed.a_renamed aVar = (com.oplus.anim.d_renamed.a_renamed) pairA.first;
        java.io.InputStream inputStream = (java.io.InputStream) pairA.second;
        if (aVar == com.oplus.anim.d_renamed.a_renamed.ZIP) {
            eVarA = com.oplus.anim.g_renamed.a_renamed(new java.util.zip.ZipInputStream(inputStream), this.f3647b);
        } else {
            eVarA = com.oplus.anim.g_renamed.a_renamed(inputStream, this.f3647b);
        }
        if (eVarA.a_renamed() != null) {
            return eVarA.a_renamed();
        }
        return null;
    }

    private com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> c_renamed() {
        try {
            return d_renamed();
        } catch (java.io.IOException e_renamed) {
            return new com.oplus.anim.e_renamed<>((java.lang.Throwable) e_renamed);
        }
    }

    private com.oplus.anim.e_renamed d_renamed() throws java.io.IOException {
        com.oplus.anim.d_renamed.a_renamed aVar;
        com.oplus.anim.e_renamed<com.oplus.anim.a_renamed> eVarA;
        com.oplus.anim.k_renamed.a_renamed("Fetching " + this.f3647b);
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.f3647b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() != null || httpURLConnection.getResponseCode() != 200) {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getErrorStream()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n_renamed');
                } else {
                    return new com.oplus.anim.e_renamed((java.lang.Throwable) new java.lang.IllegalArgumentException("Unable to fetch " + this.f3647b + ". Failed with " + httpURLConnection.getResponseCode() + "\n_renamed" + ((java.lang.Object) sb)));
                }
            }
        } else {
            java.lang.String contentType = httpURLConnection.getContentType();
            char c2 = 65535;
            int iHashCode = contentType.hashCode();
            if (iHashCode != -1248325150) {
                if (iHashCode == -43840953 && contentType.equals("application/json")) {
                    c2 = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c2 = 0;
            }
            if (c2 == 0) {
                com.oplus.anim.k_renamed.a_renamed("Handling zip response.");
                aVar = com.oplus.anim.d_renamed.a_renamed.ZIP;
                eVarA = com.oplus.anim.g_renamed.a_renamed(new java.util.zip.ZipInputStream(new java.io.FileInputStream(this.f3648c.a_renamed(httpURLConnection.getInputStream(), aVar))), this.f3647b);
            } else {
                com.oplus.anim.k_renamed.a_renamed("Received json response.");
                aVar = com.oplus.anim.d_renamed.a_renamed.JSON;
                eVarA = com.oplus.anim.g_renamed.a_renamed(new java.io.FileInputStream(new java.io.File(this.f3648c.a_renamed(httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f3647b);
            }
            if (eVarA.a_renamed() != null) {
                this.f3648c.a_renamed(aVar);
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Completed fetch from network. Success: ");
            sb2.append(eVarA.a_renamed() != null);
            com.oplus.anim.k_renamed.a_renamed(sb2.toString());
            return eVarA;
        }
    }
}
