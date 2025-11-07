package com.airbnb.lottie.d_renamed;

/* compiled from: DefaultLottieNetworkFetcher.java */
/* loaded from: classes.dex */
public class b_renamed implements com.airbnb.lottie.d_renamed.f_renamed {
    @Override // com.airbnb.lottie.d_renamed.f_renamed
    public com.airbnb.lottie.d_renamed.d_renamed a_renamed(java.lang.String str) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new com.airbnb.lottie.d_renamed.a_renamed(httpURLConnection);
    }
}
