package androidx.dynamicanimation.p043a;

import androidx.dynamicanimation.p043a.DynamicAnimation;

/* compiled from: COUIPanelDragToHiddenAnimation.java */
/* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class COUIPanelDragToHiddenAnimation extends DynamicAnimation<COUIPanelDragToHiddenAnimation> {

    /* renamed from: A */
    private long f3281A;

    /* renamed from: w */
    private final PlatformImplementations.kt_3 f3282w;

    /* renamed from: x */
    private float f3283x;

    /* renamed from: y */
    private float f3284y;

    /* renamed from: z */
    private long f3285z;

    public <K> COUIPanelDragToHiddenAnimation(K OplusGLSurfaceView_5, FloatPropertyCompat<K> abstractC0550d) {
        super(OplusGLSurfaceView_5, abstractC0550d);
        this.f3282w = new PlatformImplementations.kt_3();
        this.f3283x = 0.0f;
        this.f3284y = -1.0f;
        this.f3285z = 0L;
        this.f3281A = 120L;
        this.f3282w.m3209a(m3221d());
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public COUIPanelDragToHiddenAnimation mo3197e(float COUIBaseListPopupWindow_12) {
        super.mo3197e(COUIBaseListPopupWindow_12);
        return this;
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public COUIPanelDragToHiddenAnimation mo3198f(float COUIBaseListPopupWindow_12) {
        super.mo3198f(COUIBaseListPopupWindow_12);
        return this;
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
    public COUIPanelDragToHiddenAnimation mo3199g(float COUIBaseListPopupWindow_12) {
        super.mo3199g(COUIBaseListPopupWindow_12);
        this.f3283x = COUIBaseListPopupWindow_12;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public COUIPanelDragToHiddenAnimation m3196d(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            throw new IllegalArgumentException("Velocity must be positive");
        }
        this.f3284y = COUIBaseListPopupWindow_12;
        return this;
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3191a() {
        this.f3285z = System.currentTimeMillis();
        this.f3282w.f3288c = this.f3285z;
        this.f3282w.f3289d = this.f3285z + this.f3281A;
        this.f3282w.f3290e = this.f3283x;
        this.f3282w.f3291f = this.f3284y;
        this.f3282w.f3292g = 0.0f;
        this.f3282w.f3293h = this.f3315u;
        super.mo3191a();
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo3194b(long OplusGLSurfaceView_15) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DynamicAnimation.PlatformImplementations.kt_3 aVarM3208a = this.f3282w.m3208a(this.f3310p, this.f3309o, jCurrentTimeMillis, OplusGLSurfaceView_15);
        this.f3310p = aVarM3208a.f3323a;
        this.f3309o = aVarM3208a.f3324b;
        if (this.f3284y >= 0.0f && (this.f3309o <= this.f3284y || jCurrentTimeMillis >= this.f3285z + this.f3281A)) {
            this.f3310p = this.f3315u;
            return true;
        }
        if (this.f3310p < this.f3316v) {
            this.f3310p = this.f3316v;
            return true;
        }
        if (this.f3310p <= this.f3315u) {
            return mo3192a(this.f3310p, this.f3309o);
        }
        this.f3310p = this.f3315u;
        return true;
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo3192a(float COUIBaseListPopupWindow_12, float f2) {
        return COUIBaseListPopupWindow_12 >= this.f3315u || COUIBaseListPopupWindow_12 <= this.f3316v || this.f3282w.m3210a(COUIBaseListPopupWindow_12, f2);
    }

    /* compiled from: COUIPanelDragToHiddenAnimation.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f3287b;

        /* renamed from: PlatformImplementations.kt_3 */
        private float f3286a = -4.2f;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f3288c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private long f3289d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f3290e = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f3291f = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f3292g = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f3293h = 0.0f;

        /* renamed from: OplusGLSurfaceView_13 */
        private final DynamicAnimation.PlatformImplementations.kt_3 f3294i = new DynamicAnimation.PlatformImplementations.kt_3();

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        DynamicAnimation.PlatformImplementations.kt_3 m3208a(float COUIBaseListPopupWindow_12, float f2, long OplusGLSurfaceView_15, long j2) {
            if (this.f3291f < 0.0f) {
                float f3 = j2;
                this.f3294i.f3324b = (float) (f2 * Math.exp((f3 / 1000.0f) * this.f3286a));
                DynamicAnimation.PlatformImplementations.kt_3 aVar = this.f3294i;
                float f4 = this.f3286a;
                aVar.f3323a = (float) ((COUIBaseListPopupWindow_12 - (f2 / f4)) + ((f2 / f4) * Math.exp((f4 * f3) / 1000.0f)));
            } else {
                this.f3294i.f3324b = m3200a(OplusGLSurfaceView_15);
                this.f3294i.f3323a = m3203b(OplusGLSurfaceView_15);
            }
            if (m3210a(this.f3294i.f3323a, this.f3294i.f3324b)) {
                this.f3294i.f3324b = 0.0f;
            }
            return this.f3294i;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private float m3200a(long OplusGLSurfaceView_15) {
            if (OplusGLSurfaceView_15 >= this.f3289d) {
                return this.f3291f;
            }
            long j2 = this.f3288c;
            float COUIBaseListPopupWindow_12 = (OplusGLSurfaceView_15 - j2) / (r0 - j2);
            float f2 = this.f3290e;
            return f2 + ((this.f3291f - f2) * COUIBaseListPopupWindow_12);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float m3203b(long OplusGLSurfaceView_15) {
            if (OplusGLSurfaceView_15 >= this.f3289d) {
                return this.f3293h;
            }
            long j2 = this.f3288c;
            float COUIBaseListPopupWindow_12 = (OplusGLSurfaceView_15 - j2) / (r0 - j2);
            float f2 = this.f3292g;
            return f2 + ((this.f3293h - f2) * COUIBaseListPopupWindow_12);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m3210a(float COUIBaseListPopupWindow_12, float f2) {
            return Math.abs(f2) < this.f3287b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m3209a(float COUIBaseListPopupWindow_12) {
            this.f3287b = COUIBaseListPopupWindow_12 * 62.5f;
        }
    }
}
