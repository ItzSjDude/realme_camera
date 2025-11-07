package com.oplus.shield.p196a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ServiceMap.java */
/* renamed from: com.oplus.shield.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ServiceMap {

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<ISystemServiceMap> f23730a = new CopyOnWriteArrayList();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Map<String, String> f23731b = new ConcurrentHashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static List<String> f23732c = new ArrayList(Arrays.asList("android.app.IActivityManager", "android.content.pm.IPackageManager", "android.view.IWindowManager"));

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25127a(String str, int OplusGLSurfaceView_13) {
        if (f23731b.containsKey(str)) {
            return f23731b.get(str);
        }
        for (ISystemServiceMap interfaceC3687a : f23730a) {
            if (TextUtils.equals(interfaceC3687a.mo25125a(), str)) {
                return interfaceC3687a.mo25126a(OplusGLSurfaceView_13);
            }
        }
        SystemServiceMap c3689c = new SystemServiceMap(str);
        f23730a.add(c3689c);
        return c3689c.mo25126a(OplusGLSurfaceView_13);
    }
}
