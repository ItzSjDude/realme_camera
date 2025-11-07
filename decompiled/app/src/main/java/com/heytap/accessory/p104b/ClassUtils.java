package com.heytap.accessory.p104b;

/* compiled from: ClassUtils.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class ClassUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m8581a(Class cls, Class cls2) {
        while (cls2 != null && cls != null && (cls2 = cls2.getSuperclass()) != null) {
            if (cls2.equals(cls)) {
                return true;
            }
        }
        return false;
    }
}
