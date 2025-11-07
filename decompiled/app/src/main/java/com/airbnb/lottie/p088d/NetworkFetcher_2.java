package com.airbnb.lottie.p088d;

import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.p091f.Logger_3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_5.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class NetworkFetcher_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final NetworkCache_2 f5726a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LottieNetworkFetcher f5727b;

    public NetworkFetcher_2(NetworkCache_2 c1143g, LottieNetworkFetcher interfaceC1142f) {
        this.f5726a = c1143g;
        this.f5727b = interfaceC1142f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public LottieResult<LottieComposition> m5878a(String str, String str2) {
        LottieComposition c1136dM5875b = m5875b(str, str2);
        if (c1136dM5875b != null) {
            return new LottieResult<>(c1136dM5875b);
        }
        Logger_3.m6098a("Animation for " + str + " not found in cache. Fetching from network.");
        return m5877c(str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LottieComposition m5875b(String str, String str2) {
        Pair<FileExtension_2, InputStream> pairM5870a;
        LottieResult<LottieComposition> c1206lM5895b;
        if (str2 == null || (pairM5870a = this.f5726a.m5870a(str)) == null) {
            return null;
        }
        FileExtension_2 enumC1139c = (FileExtension_2) pairM5870a.first;
        InputStream inputStream = (InputStream) pairM5870a.second;
        if (enumC1139c == FileExtension_2.ZIP) {
            c1206lM5895b = LottieCompositionFactory.m5883a(new ZipInputStream(inputStream), str);
        } else {
            c1206lM5895b = LottieCompositionFactory.m5895b(inputStream, str);
        }
        if (c1206lM5895b.m6179a() != null) {
            return c1206lM5895b.m6179a();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LottieResult<LottieComposition> m5877c(String str, String str2) {
        Logger_3.m6098a("Fetching " + str);
        LottieFetchResult interfaceC1140d = null;
        try {
            try {
                LottieFetchResult interfaceC1140dMo5866a = this.f5727b.mo5866a(str);
                if (!interfaceC1140dMo5866a.mo5862a()) {
                    LottieResult<LottieComposition> c1206l = new LottieResult<>(new IllegalArgumentException(interfaceC1140dMo5866a.mo5865d()));
                    if (interfaceC1140dMo5866a != null) {
                        try {
                            interfaceC1140dMo5866a.close();
                        } catch (IOException COUIBaseListPopupWindow_8) {
                            Logger_3.m6099a("LottieFetchResult close failed ", COUIBaseListPopupWindow_8);
                        }
                    }
                    return c1206l;
                }
                LottieResult<LottieComposition> c1206lM5874a = m5874a(str, interfaceC1140dMo5866a.mo5863b(), interfaceC1140dMo5866a.mo5864c(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(c1206lM5874a.m6179a() != null);
                Logger_3.m6098a(sb.toString());
                if (interfaceC1140dMo5866a != null) {
                    try {
                        interfaceC1140dMo5866a.close();
                    } catch (IOException e2) {
                        Logger_3.m6099a("LottieFetchResult close failed ", e2);
                    }
                }
                return c1206lM5874a;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        interfaceC1140d.close();
                    } catch (IOException e3) {
                        Logger_3.m6099a("LottieFetchResult close failed ", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            LottieResult<LottieComposition> c1206l2 = new LottieResult<>(e4);
            if (0 != 0) {
                try {
                    interfaceC1140d.close();
                } catch (IOException e5) {
                    Logger_3.m6099a("LottieFetchResult close failed ", e5);
                }
            }
            return c1206l2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private LottieResult<LottieComposition> m5874a(String str, InputStream inputStream, String str2, String str3) throws IOException {
        FileExtension_2 enumC1139c;
        LottieResult<LottieComposition> c1206lM5873a;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger_3.m6098a("Handling zip response.");
            enumC1139c = FileExtension_2.ZIP;
            c1206lM5873a = m5873a(str, inputStream, str3);
        } else {
            Logger_3.m6098a("Received json response.");
            enumC1139c = FileExtension_2.JSON;
            c1206lM5873a = m5876b(str, inputStream, str3);
        }
        if (str3 != null && c1206lM5873a.m6179a() != null) {
            this.f5726a.m5872a(str, enumC1139c);
        }
        return c1206lM5873a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private LottieResult<LottieComposition> m5873a(String str, InputStream inputStream, String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.m5883a(new ZipInputStream(inputStream), (String) null);
        }
        return LottieCompositionFactory.m5883a(new ZipInputStream(new FileInputStream(this.f5726a.m5871a(str, inputStream, FileExtension_2.ZIP))), str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LottieResult<LottieComposition> m5876b(String str, InputStream inputStream, String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.m5895b(inputStream, (String) null);
        }
        return LottieCompositionFactory.m5895b(new FileInputStream(new File(this.f5726a.m5871a(str, inputStream, FileExtension_2.JSON).getAbsolutePath())), str);
    }
}
