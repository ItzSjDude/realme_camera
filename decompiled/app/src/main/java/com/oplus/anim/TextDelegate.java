package com.oplus.anim;

import java.util.Map;

/* compiled from: TextDelegate.java */
/* renamed from: com.oplus.anim.p */
/* loaded from: classes2.dex */
public class TextDelegate {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Map<String, String> f10454a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f10455b;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m9356b(String str) {
        return str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final String m9357a(String str) {
        if (this.f10455b && this.f10454a.containsKey(str)) {
            return this.f10454a.get(str);
        }
        String strM9356b = m9356b(str);
        if (this.f10455b) {
            this.f10454a.put(str, strM9356b);
        }
        return strM9356b;
    }
}
