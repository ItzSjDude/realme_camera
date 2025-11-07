package com.airbnb.lottie.p091f;

import android.util.Log;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class LogcatLogger implements LottieLogger {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Set<String> f5868a = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6093a(String str) {
        m6097c(str, null);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6097c(String str, Throwable th) {
        if (L_2.f5465a) {
            Log.IntrinsicsJvm.kt_5("LOTTIE", str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6095b(String str) {
        mo6094a(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6094a(String str, Throwable th) {
        if (f5868a.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        f5868a.add(str);
    }

    @Override // com.airbnb.lottie.LottieLogger
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6096b(String str, Throwable th) {
        if (L_2.f5465a) {
            Log.IntrinsicsJvm.kt_5("LOTTIE", str, th);
        }
    }
}
