package com.airbnb.lottie;

import android.content.Context;
import androidx.core.p032d.TraceCompat;
import com.airbnb.lottie.p088d.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.p088d.NetworkCache_2;
import com.airbnb.lottie.p088d.NetworkFetcher_2;
import com.airbnb.lottie.p088d.LottieNetworkCacheProvider;
import com.airbnb.lottie.p088d.LottieNetworkFetcher;
import java.io.File;

/* compiled from: L.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class L_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean f5465a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f5466b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String[] f5467c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static long[] f5468d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int f5469e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static int f5470f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static LottieNetworkFetcher f5471g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static LottieNetworkCacheProvider f5472h;

    /* renamed from: OplusGLSurfaceView_13 */
    private static volatile NetworkFetcher_2 f5473i;

    /* renamed from: OplusGLSurfaceView_15 */
    private static volatile NetworkCache_2 f5474j;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5637a(String str) {
        if (f5466b) {
            int OplusGLSurfaceView_13 = f5469e;
            if (OplusGLSurfaceView_13 == 20) {
                f5470f++;
                return;
            }
            f5467c[OplusGLSurfaceView_13] = str;
            f5468d[OplusGLSurfaceView_13] = System.nanoTime();
            TraceCompat.m2449a(str);
            f5469e++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m5638b(String str) {
        int OplusGLSurfaceView_13 = f5470f;
        if (OplusGLSurfaceView_13 > 0) {
            f5470f = OplusGLSurfaceView_13 - 1;
            return 0.0f;
        }
        if (!f5466b) {
            return 0.0f;
        }
        f5469e--;
        int i2 = f5469e;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(f5467c[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f5467c[f5469e] + ".");
        }
        TraceCompat.m2448a();
        return (System.nanoTime() - f5468d[f5469e]) / 1000000.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static NetworkFetcher_2 m5636a(Context context) {
        NetworkFetcher_2 c1144h = f5473i;
        if (c1144h == null) {
            synchronized (NetworkFetcher_2.class) {
                c1144h = f5473i;
                if (c1144h == null) {
                    c1144h = new NetworkFetcher_2(m5639b(context), f5471g != null ? f5471g : new DefaultLottieNetworkFetcher());
                    f5473i = c1144h;
                }
            }
        }
        return c1144h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static NetworkCache_2 m5639b(final Context context) {
        NetworkCache_2 c1143g = f5474j;
        if (c1143g == null) {
            synchronized (NetworkCache_2.class) {
                c1143g = f5474j;
                if (c1143g == null) {
                    c1143g = new NetworkCache_2(f5472h != null ? f5472h : new LottieNetworkCacheProvider() { // from class: com.airbnb.lottie.IntrinsicsJvm.kt_3.1
                        @Override // com.airbnb.lottie.p088d.LottieNetworkCacheProvider
                        /* renamed from: PlatformImplementations.kt_3 */
                        public File mo5640a() {
                            return new File(context.getCacheDir(), "lottie_network_cache");
                        }
                    });
                    f5474j = c1143g;
                }
            }
        }
        return c1143g;
    }
}
