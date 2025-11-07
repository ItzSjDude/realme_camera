package com.oplus.camera.p172ui.inverse;

import java.lang.ref.WeakReference;

/* compiled from: InverseData.java */
/* renamed from: com.oplus.camera.ui.inverse.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class InverseData {

    /* renamed from: COUIBaseListPopupWindow_8 */
    public PlatformImplementations.kt_3 f18749e;

    /* renamed from: PlatformImplementations.kt_3 */
    public int f18745a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f18746b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean f18747c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float f18748d = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public WeakReference<?> f18750f = null;

    /* compiled from: InverseData.java */
    /* renamed from: com.oplus.camera.ui.inverse.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        common,
        background,
        mask,
        preview
    }

    public InverseData(PlatformImplementations.kt_3 aVar) {
        this.f18749e = PlatformImplementations.kt_3.common;
        this.f18749e = aVar;
    }
}
