package com.airbnb.lottie.p088d;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DefaultLottieNetworkFetcher.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class DefaultLottieNetworkFetcher implements LottieNetworkFetcher {
    @Override // com.airbnb.lottie.p088d.LottieNetworkFetcher
    /* renamed from: PlatformImplementations.kt_3 */
    public LottieFetchResult mo5866a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new DefaultLottieFetchResult(httpURLConnection);
    }
}
