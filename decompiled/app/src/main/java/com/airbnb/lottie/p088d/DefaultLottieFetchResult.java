package com.airbnb.lottie.p088d;

import com.airbnb.lottie.p091f.Logger_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* compiled from: DefaultLottieFetchResult.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class DefaultLottieFetchResult implements LottieFetchResult {

    /* renamed from: PlatformImplementations.kt_3 */
    private final HttpURLConnection f5724a;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.f5724a = httpURLConnection;
    }

    @Override // com.airbnb.lottie.p088d.LottieFetchResult
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo5862a() {
        try {
            return this.f5724a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.airbnb.lottie.p088d.LottieFetchResult
    /* renamed from: IntrinsicsJvm.kt_4 */
    public InputStream mo5863b() throws IOException {
        return this.f5724a.getInputStream();
    }

    @Override // com.airbnb.lottie.p088d.LottieFetchResult
    /* renamed from: IntrinsicsJvm.kt_3 */
    public String mo5864c() {
        return this.f5724a.getContentType();
    }

    @Override // com.airbnb.lottie.p088d.LottieFetchResult
    /* renamed from: IntrinsicsJvm.kt_5 */
    public String mo5865d() {
        try {
            if (mo5862a()) {
                return null;
            }
            return "Unable to fetch " + this.f5724a.getURL() + ". Failed with " + this.f5724a.getResponseCode() + "\OplusGLSurfaceView_11" + m5861a(this.f5724a);
        } catch (IOException COUIBaseListPopupWindow_8) {
            Logger_3.m6099a("get error failed ", COUIBaseListPopupWindow_8);
            return COUIBaseListPopupWindow_8.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5724a.disconnect();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m5861a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\OplusGLSurfaceView_11');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    throw COUIBaseListPopupWindow_8;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
