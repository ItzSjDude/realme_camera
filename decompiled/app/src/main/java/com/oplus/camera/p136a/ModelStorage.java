package com.oplus.camera.p136a;

import com.oplus.camera.p160q.DocumentUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ModelStorage.java */
/* renamed from: com.oplus.camera.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class ModelStorage {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<String, byte[]> f12157a = new HashMap();

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m11168a(String str) {
        if (!f12157a.containsKey(str)) {
            f12157a.put(str, DocumentUtil.m16208d("/odm/etc/camera/" + str));
        }
        return f12157a.get(str);
    }
}
