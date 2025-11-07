package com.airbnb.lottie;

import java.util.Map;

/* compiled from: TextDelegate.java */
/* renamed from: com.airbnb.lottie.q */
/* loaded from: classes.dex */
public class TextDelegate_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Map<String, String> f5968a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f5969b;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m6197b(String str) {
        return str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final String m6198a(String str) {
        if (this.f5969b && this.f5968a.containsKey(str)) {
            return this.f5968a.get(str);
        }
        String strM6197b = m6197b(str);
        if (this.f5969b) {
            this.f5968a.put(str, strM6197b);
        }
        return strM6197b;
    }
}
