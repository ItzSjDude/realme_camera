package com.oplus.util;

/* loaded from: classes2.dex */
public class OplusHoraeThermalHelper {
    public int[] getAllShellTemps() {
        return null;
    }

    public float getCurrentThermal() {
        return -1.0f;
    }

    public int[] getShellTempAndType() {
        return null;
    }

    /* renamed from: com.oplus.util.OplusHoraeThermalHelper$PlatformImplementations.kt_3 */
    private static class C3818a {

        /* renamed from: PlatformImplementations.kt_3 */
        private static OplusHoraeThermalHelper f24155a = new OplusHoraeThermalHelper();
    }

    public static OplusHoraeThermalHelper getInstance() {
        return C3818a.f24155a;
    }

    private OplusHoraeThermalHelper() {
    }
}
