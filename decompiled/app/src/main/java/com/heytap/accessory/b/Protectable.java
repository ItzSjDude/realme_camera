package com.heytap.accessory.b_renamed;

/* compiled from: ClassUtils.java */
/* loaded from: classes2.dex */
public class c_renamed {
    public static boolean a_renamed(java.lang.Class cls, java.lang.Class cls2) {
        while (cls2 != null && cls != null && (cls2 = cls2.getSuperclass()) != null) {
            if (cls2.equals(cls)) {
                return true;
            }
        }
        return false;
    }
}
