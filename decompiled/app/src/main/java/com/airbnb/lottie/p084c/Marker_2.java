package com.airbnb.lottie.p084c;

/* compiled from: Marker.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class Marker_2 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String f5703c = "\r";

    /* renamed from: PlatformImplementations.kt_3 */
    public final float f5704a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final float f5705b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f5706d;

    public Marker_2(String str, float COUIBaseListPopupWindow_12, float f2) {
        this.f5706d = str;
        this.f5705b = f2;
        this.f5704a = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m5837a(String str) {
        if (this.f5706d.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f5706d.endsWith(f5703c)) {
            String str2 = this.f5706d;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
