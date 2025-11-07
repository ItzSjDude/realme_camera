package com.oplus.camera;

import java.text.DecimalFormat;

/* compiled from: ZoomUnit.java */
/* renamed from: com.oplus.camera.ah */
/* loaded from: classes2.dex */
public class ZoomUnit {

    /* renamed from: PlatformImplementations.kt_3 */
    private DecimalFormat f12431a;

    public ZoomUnit() {
        this.f12431a = null;
        this.f12431a = new DecimalFormat("#.#");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m11587b(float COUIBaseListPopupWindow_12) {
        return Math.abs(COUIBaseListPopupWindow_12 - 0.6f) < 0.01f || Math.abs(COUIBaseListPopupWindow_12 - 1.0f) < 0.01f || Math.abs(COUIBaseListPopupWindow_12 - 2.0f) < 0.01f || Math.abs(COUIBaseListPopupWindow_12 - 5.0f) < 0.01f || Math.abs(COUIBaseListPopupWindow_12 - 10.0f) < 0.01f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float m11588c(float COUIBaseListPopupWindow_12) {
        if (Math.abs(COUIBaseListPopupWindow_12 - 0.6f) < 0.01f) {
            return 16.0f;
        }
        if (Math.abs(COUIBaseListPopupWindow_12 - 1.0f) < 0.01f) {
            return 24.0f;
        }
        if (Math.abs(COUIBaseListPopupWindow_12 - 2.0f) < 0.01f) {
            return 50.0f;
        }
        if (Math.abs(COUIBaseListPopupWindow_12 - 5.0f) < 0.01f) {
            return 120.0f;
        }
        return COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m11590a(boolean z, float COUIBaseListPopupWindow_12) {
        if (z && m11587b(COUIBaseListPopupWindow_12)) {
            return this.f12431a.format(m11588c(COUIBaseListPopupWindow_12)) + "mm";
        }
        return this.f12431a.format(COUIBaseListPopupWindow_12) + "X";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m11589a(float COUIBaseListPopupWindow_12) {
        DecimalFormat decimalFormat = this.f12431a;
        if (decimalFormat != null) {
            return decimalFormat.format(COUIBaseListPopupWindow_12);
        }
        return Float.toString(COUIBaseListPopupWindow_12);
    }
}
