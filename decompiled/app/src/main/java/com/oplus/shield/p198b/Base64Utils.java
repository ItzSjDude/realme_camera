package com.oplus.shield.p198b;

import android.annotation.SuppressLint;
import java.util.Base64;

/* compiled from: Base64Utils.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class Base64Utils {
    @SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m25182a(String str) {
        return Base64.getDecoder().decode(str);
    }
}
