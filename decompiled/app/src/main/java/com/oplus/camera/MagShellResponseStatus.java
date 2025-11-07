package com.oplus.camera;

import java.util.Locale;

/* compiled from: MagShellResponseStatus.java */
/* renamed from: com.oplus.camera.s */
/* loaded from: classes2.dex */
public class MagShellResponseStatus {

    /* renamed from: PlatformImplementations.kt_3 */
    private byte f15889a = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m16295a() {
        return (this.f15889a & 2) != 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16294a(boolean z) {
        if (z) {
            this.f15889a = (byte) (this.f15889a | 2);
        } else {
            this.f15889a = (byte) (this.f15889a & (-3));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16296b(boolean z) {
        if (z) {
            this.f15889a = (byte) (this.f15889a | 8);
        } else {
            this.f15889a = (byte) (this.f15889a & (-9));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m16297b() {
        return (this.f15889a & 4) != 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16298c(boolean z) {
        if (z) {
            this.f15889a = (byte) (this.f15889a | 4);
        } else {
            this.f15889a = (byte) (this.f15889a & (-5));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16300d(boolean z) {
        if (z) {
            this.f15889a = (byte) (this.f15889a | 1);
        } else {
            this.f15889a = (byte) (this.f15889a & (-2));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m16299c() {
        return (this.f15889a & 16) != 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m16302e(boolean z) {
        if (z) {
            this.f15889a = (byte) (this.f15889a | 16);
        } else {
            this.f15889a = (byte) (this.f15889a & (-17));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m16301d() {
        return (this.f15889a & 32) != 0;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m16305f(boolean z) {
        if (z) {
            this.f15889a = (byte) (this.f15889a | 32);
        } else {
            this.f15889a = (byte) (this.f15889a & (-33));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m16303e() {
        return (!m16295a() || m16299c() || m16301d()) ? false : true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m16304f() {
        this.f15889a = (byte) 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m16306g() {
        byte b2 = this.f15889a;
        return (b2 & 1) != 0 && (b2 & 12) == 0;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "MagShellResponseStatus: 0x%x.", Byte.valueOf(this.f15889a));
    }
}
