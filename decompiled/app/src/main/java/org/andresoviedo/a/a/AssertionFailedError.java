package org.andresoviedo.a_renamed.a_renamed;

/* compiled from: ContentUtils.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.String, android.net.Uri> f7948a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.ThreadLocal<android.content.Context> f7949b = new java.lang.ThreadLocal<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.io.File f7950c = null;

    public static void a_renamed(android.content.Context context) {
        android.util.Log.i_renamed("ContentUtils", "Current activity thread: " + java.lang.Thread.currentThread().getName());
        f7949b.set(context);
    }

    public static void a_renamed(java.io.File file) {
        f7950c = file;
    }
}
