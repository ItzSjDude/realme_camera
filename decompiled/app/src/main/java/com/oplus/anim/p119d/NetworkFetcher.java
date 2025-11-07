package com.oplus.anim.p119d;

import android.content.Context;
import android.util.Pair;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.EffectiveAnimationResult;
import com.oplus.anim.EffectiveCompositionFactory;
import com.oplus.anim.L;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class NetworkFetcher {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f10347a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f10348b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final NetworkCache f10349c;

    private NetworkFetcher(Context context, String str) {
        this.f10347a = context.getApplicationContext();
        this.f10348b = str;
        this.f10349c = new NetworkCache(this.f10347a, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EffectiveAnimationResult<EffectiveAnimationComposition> m9149a(Context context, String str) {
        return new NetworkFetcher(context, str).m9153a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public EffectiveAnimationResult<EffectiveAnimationComposition> m9153a() {
        EffectiveAnimationComposition c2272aM9150b = m9150b();
        if (c2272aM9150b != null) {
            return new EffectiveAnimationResult<>(c2272aM9150b);
        }
        L.m9347a("Animation for " + this.f10348b + " not found in cache. Fetching from network.");
        return m9151c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private EffectiveAnimationComposition m9150b() {
        EffectiveAnimationResult<EffectiveAnimationComposition> c2365eM9299a;
        Pair<FileExtension, InputStream> pairM9146a = this.f10349c.m9146a();
        if (pairM9146a == null) {
            return null;
        }
        FileExtension enumC2362a = (FileExtension) pairM9146a.first;
        InputStream inputStream = (InputStream) pairM9146a.second;
        if (enumC2362a == FileExtension.ZIP) {
            c2365eM9299a = EffectiveCompositionFactory.m9301a(new ZipInputStream(inputStream), this.f10348b);
        } else {
            c2365eM9299a = EffectiveCompositionFactory.m9299a(inputStream, this.f10348b);
        }
        if (c2365eM9299a.m9154a() != null) {
            return c2365eM9299a.m9154a();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private EffectiveAnimationResult<EffectiveAnimationComposition> m9151c() {
        try {
            return m9152d();
        } catch (IOException COUIBaseListPopupWindow_8) {
            return new EffectiveAnimationResult<>((Throwable) COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private EffectiveAnimationResult m9152d() throws IOException {
        FileExtension enumC2362a;
        EffectiveAnimationResult<EffectiveAnimationComposition> c2365eM9301a;
        L.m9347a("Fetching " + this.f10348b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f10348b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() != null || httpURLConnection.getResponseCode() != 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\OplusGLSurfaceView_11');
                } else {
                    return new EffectiveAnimationResult((Throwable) new IllegalArgumentException("Unable to fetch " + this.f10348b + ". Failed with " + httpURLConnection.getResponseCode() + "\OplusGLSurfaceView_11" + ((Object) sb)));
                }
            }
        } else {
            String contentType = httpURLConnection.getContentType();
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
                L.m9347a("Handling zip response.");
                enumC2362a = FileExtension.ZIP;
                c2365eM9301a = EffectiveCompositionFactory.m9301a(new ZipInputStream(new FileInputStream(this.f10349c.m9147a(httpURLConnection.getInputStream(), enumC2362a))), this.f10348b);
            } else {
                L.m9347a("Received json response.");
                enumC2362a = FileExtension.JSON;
                c2365eM9301a = EffectiveCompositionFactory.m9299a(new FileInputStream(new File(this.f10349c.m9147a(httpURLConnection.getInputStream(), enumC2362a).getAbsolutePath())), this.f10348b);
            }
            if (c2365eM9301a.m9154a() != null) {
                this.f10349c.m9148a(enumC2362a);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Completed fetch from network. Success: ");
            sb2.append(c2365eM9301a.m9154a() != null);
            L.m9347a(sb2.toString());
            return c2365eM9301a;
        }
    }
}
