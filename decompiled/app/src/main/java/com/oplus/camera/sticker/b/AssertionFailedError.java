package com.oplus.camera.sticker.b_renamed;

/* compiled from: OkHttpClientHelper.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.sticker.b_renamed.b_renamed f5435a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private okhttp3.OkHttpClient f5436b;

    public static com.oplus.camera.sticker.b_renamed.b_renamed a_renamed() {
        if (f5435a == null) {
            synchronized (com.oplus.camera.sticker.b_renamed.b_renamed.class) {
                if (f5435a == null) {
                    f5435a = new com.oplus.camera.sticker.b_renamed.b_renamed();
                }
            }
        }
        return f5435a;
    }

    public b_renamed() {
        this.f5436b = null;
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        builder.connectTimeout(15L, java.util.concurrent.TimeUnit.SECONDS);
        builder.readTimeout(15L, java.util.concurrent.TimeUnit.SECONDS);
        builder.writeTimeout(15L, java.util.concurrent.TimeUnit.SECONDS);
        if (com.oplus.camera.sticker.c_renamed.d_renamed.d_renamed(com.oplus.camera.util.Util.l_renamed())) {
            builder.sslSocketFactory(com.oplus.camera.sticker.b_renamed.c_renamed.a_renamed(), new com.oplus.camera.sticker.b_renamed.c_renamed());
            builder.hostnameVerifier(new javax.net.ssl.HostnameVerifier() { // from class: com.oplus.camera.sticker.b_renamed.b_renamed.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
                    return javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            });
        }
        this.f5436b = builder.build();
    }

    public okhttp3.OkHttpClient b_renamed() {
        return this.f5436b;
    }
}
