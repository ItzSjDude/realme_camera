package com.oplus.shield.p196a;

import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: SystemServiceMap.java */
/* renamed from: com.oplus.shield.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class SystemServiceMap implements ISystemServiceMap {

    /* renamed from: PlatformImplementations.kt_3 */
    private HashMap<Integer, String> f23733a = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f23734b;

    SystemServiceMap(String str) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException {
        this.f23734b = str;
        m25128b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m25128b() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException {
        try {
            Class<?> cls = Class.forName(this.f23734b + "$Stub");
            for (Field field : cls.getDeclaredFields()) {
                if (field.getName().startsWith("TRANSACTION_")) {
                    field.setAccessible(true);
                    this.f23733a.put(Integer.valueOf(field.getInt(cls)), field.getName().replaceFirst("TRANSACTION_", ""));
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    @Override // com.oplus.shield.p196a.ISystemServiceMap
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo25126a(int OplusGLSurfaceView_13) {
        if (this.f23733a.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            return this.f23733a.get(Integer.valueOf(OplusGLSurfaceView_13));
        }
        return null;
    }

    @Override // com.oplus.shield.p196a.ISystemServiceMap
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo25125a() {
        return this.f23734b;
    }
}
