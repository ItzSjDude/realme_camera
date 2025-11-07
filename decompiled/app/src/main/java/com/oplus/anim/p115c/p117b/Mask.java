package com.oplus.anim.p115c.p117b;

import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p116a.AnimatableShapeValue;

/* compiled from: Mask.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class Mask {

    /* renamed from: PlatformImplementations.kt_3 */
    private final PlatformImplementations.kt_3 f10159a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableShapeValue f10160b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableIntegerValue f10161c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f10162d;

    /* compiled from: Mask.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT
    }

    public Mask(PlatformImplementations.kt_3 aVar, AnimatableShapeValue c2321h, AnimatableIntegerValue c2317d, boolean z) {
        this.f10159a = aVar;
        this.f10160b = c2321h;
        this.f10161c = c2317d;
        this.f10162d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PlatformImplementations.kt_3 m9003a() {
        return this.f10159a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableShapeValue m9004b() {
        return this.f10160b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableIntegerValue m9005c() {
        return this.f10161c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m9006d() {
        return this.f10162d;
    }
}
