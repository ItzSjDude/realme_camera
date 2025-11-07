package com.p094b.p095a.p096a;

import java.util.Arrays;
import org.andresoviedo.android_3d_model_engine.p230b.Camera;

/* compiled from: CameraAnimator.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public abstract class CameraAnimator implements IAnimator {

    /* renamed from: PlatformImplementations.kt_3 */
    Camera f6042a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    PlatformImplementations.kt_3 f6043b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean f6044c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    AnimDirection f6045d;

    public CameraAnimator(Camera c4056c, boolean z) {
        this.f6043b = null;
        this.f6044c = true;
        this.f6045d = AnimDirection.ANIM_DIRECTION_DEFAULT;
        this.f6042a = c4056c;
        this.f6044c = z;
    }

    public CameraAnimator(Camera c4056c, boolean z, AnimConfig c1220a) {
        this.f6043b = null;
        this.f6044c = true;
        this.f6045d = AnimDirection.ANIM_DIRECTION_DEFAULT;
        this.f6042a = c4056c;
        if (c1220a.f6018b != null) {
            c4056c.f24885a = c1220a.f6018b.f6019a;
            c4056c.f24886b = c1220a.f6018b.f6020b;
            c4056c.f24887c = c1220a.f6018b.f6021c;
            c4056c.m26181a(true);
        }
        this.f6044c = z;
        this.f6045d = c1220a.f6017a;
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6248b() {
        this.f6043b = new PlatformImplementations.kt_3(this.f6042a);
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo6251d() {
        if (this.f6043b != null) {
            this.f6043b = null;
            this.f6042a.m26181a(true);
        }
    }

    /* compiled from: CameraAnimator.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        float f6046a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f6047b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        float f6048c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        float[] f6049d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        float f6050e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        float f6051f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        float f6052g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        float f6053h;

        PlatformImplementations.kt_3(Camera c4056c) {
            this.f6046a = c4056c.f24885a;
            this.f6047b = c4056c.f24886b;
            this.f6048c = c4056c.f24887c;
            this.f6049d = Arrays.copyOf(c4056c.m26182a(), c4056c.m26182a().length);
            this.f6050e = c4056c.f24894j;
            this.f6051f = c4056c.f24897m;
            this.f6052g = c4056c.f24895k;
            this.f6053h = c4056c.f24896l;
        }
    }
}
