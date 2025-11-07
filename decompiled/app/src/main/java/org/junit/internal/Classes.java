package org.junit.internal;

/* loaded from: classes2.dex */
public class Classes {
    public static java.lang.Class<?> getClass(java.lang.String str) throws java.lang.ClassNotFoundException {
        return java.lang.Class.forName(str, true, java.lang.Thread.currentThread().getContextClassLoader());
    }
}
