package com.oplus.shield.a_renamed;

/* compiled from: ServiceMap.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.List<com.oplus.shield.a_renamed.a_renamed> f7603a = new java.util.concurrent.CopyOnWriteArrayList();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.String, java.lang.String> f7604b = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.List<java.lang.String> f7605c = new java.util.ArrayList(java.util.Arrays.asList("android.app.IActivityManager", "android.content.pm.IPackageManager", "android.view.IWindowManager"));

    public static java.lang.String a_renamed(java.lang.String str, int i_renamed) {
        if (f7604b.containsKey(str)) {
            return f7604b.get(str);
        }
        for (com.oplus.shield.a_renamed.a_renamed aVar : f7603a) {
            if (android.text.TextUtils.equals(aVar.a_renamed(), str)) {
                return aVar.a_renamed(i_renamed);
            }
        }
        com.oplus.shield.a_renamed.c_renamed cVar = new com.oplus.shield.a_renamed.c_renamed(str);
        f7603a.add(cVar);
        return cVar.a_renamed(i_renamed);
    }
}
