package com.oplus.camera.sticker.p166b;

import com.oplus.camera.sticker.p167c.PrefUtils;
import com.oplus.camera.util.Util;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;

/* compiled from: OkHttpClientHelper.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class OkHttpClientHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile OkHttpClientHelper f16201a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private OkHttpClient f16202b;

    /* renamed from: PlatformImplementations.kt_3 */
    public static OkHttpClientHelper m16794a() {
        if (f16201a == null) {
            synchronized (OkHttpClientHelper.class) {
                if (f16201a == null) {
                    f16201a = new OkHttpClientHelper();
                }
            }
        }
        return f16201a;
    }

    public OkHttpClientHelper() {
        this.f16202b = null;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15L, TimeUnit.SECONDS);
        builder.readTimeout(15L, TimeUnit.SECONDS);
        builder.writeTimeout(15L, TimeUnit.SECONDS);
        if (PrefUtils.m16834d(Util.m24472l())) {
            builder.sslSocketFactory(TrustAllCerts.m16796a(), new TrustAllCerts());
            builder.hostnameVerifier(new HostnameVerifier() { // from class: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            });
        }
        this.f16202b = builder.build();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public OkHttpClient m16795b() {
        return this.f16202b;
    }
}
