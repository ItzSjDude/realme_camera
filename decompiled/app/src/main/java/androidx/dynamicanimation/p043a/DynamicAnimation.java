package androidx.dynamicanimation.p043a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.p036h.ViewCompat;
import androidx.dynamicanimation.p043a.DynamicAnimation;
import androidx.dynamicanimation.p043a.AnimationHandler;
import java.util.ArrayList;

/* compiled from: DynamicAnimation.java */
/* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.IntrinsicsJvm.kt_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final IntrinsicsJvm.kt_5 f3295a = new IntrinsicsJvm.kt_5("translationX") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.1
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setTranslationX(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getTranslationX();
        }
    };

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final IntrinsicsJvm.kt_5 f3296b = new IntrinsicsJvm.kt_5("translationY") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.8
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setTranslationY(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getTranslationY();
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final IntrinsicsJvm.kt_5 f3297c = new IntrinsicsJvm.kt_5("translationZ") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.9
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            ViewCompat.m2866b(view, COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return ViewCompat.m2897p(view);
        }
    };

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final IntrinsicsJvm.kt_5 f3298d = new IntrinsicsJvm.kt_5("scaleX") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.10
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setScaleX(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getScaleX();
        }
    };

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static final IntrinsicsJvm.kt_5 f3299e = new IntrinsicsJvm.kt_5("scaleY") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.11
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setScaleY(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getScaleY();
        }
    };

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static final IntrinsicsJvm.kt_5 f3300f = new IntrinsicsJvm.kt_5("rotation") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.12
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setRotation(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getRotation();
        }
    };

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static final IntrinsicsJvm.kt_5 f3301g = new IntrinsicsJvm.kt_5("rotationX") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.13
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setRotationX(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getRotationX();
        }
    };

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static final IntrinsicsJvm.kt_5 f3302h = new IntrinsicsJvm.kt_5("rotationY") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.14
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setRotationY(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getRotationY();
        }
    };

    /* renamed from: OplusGLSurfaceView_13 */
    public static final IntrinsicsJvm.kt_5 f3303i = new IntrinsicsJvm.kt_5("x") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.15
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setX(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getX();
        }
    };

    /* renamed from: OplusGLSurfaceView_15 */
    public static final IntrinsicsJvm.kt_5 f3304j = new IntrinsicsJvm.kt_5("y") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.2
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setY(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getY();
        }
    };

    /* renamed from: OplusGLSurfaceView_5 */
    public static final IntrinsicsJvm.kt_5 f3305k = new IntrinsicsJvm.kt_5("z") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.3
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            ViewCompat.m2873c(view, COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return ViewCompat.m2824B(view);
        }
    };

    /* renamed from: OplusGLSurfaceView_14 */
    public static final IntrinsicsJvm.kt_5 f3306l = new IntrinsicsJvm.kt_5("alpha") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.4
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setAlpha(COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getAlpha();
        }
    };

    /* renamed from: OplusGLSurfaceView_6 */
    public static final IntrinsicsJvm.kt_5 f3307m = new IntrinsicsJvm.kt_5("scrollX") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.5
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setScrollX((int) COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getScrollX();
        }
    };

    /* renamed from: OplusGLSurfaceView_11 */
    public static final IntrinsicsJvm.kt_5 f3308n = new IntrinsicsJvm.kt_5("scrollY") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.6
        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3224a(View view, float COUIBaseListPopupWindow_12) {
            view.setScrollY((int) COUIBaseListPopupWindow_12);
        }

        @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public float mo3223a(View view) {
            return view.getScrollY();
        }
    };

    /* renamed from: o */
    float f3309o;

    /* renamed from: p */
    float f3310p;

    /* renamed from: q */
    boolean f3311q;

    /* renamed from: r */
    final Object f3312r;

    /* renamed from: s */
    final FloatPropertyCompat f3313s;

    /* renamed from: t */
    boolean f3314t;

    /* renamed from: u */
    float f3315u;

    /* renamed from: v */
    float f3316v;

    /* renamed from: w */
    private long f3317w;

    /* renamed from: x */
    private float f3318x;

    /* renamed from: y */
    private final ArrayList<IntrinsicsJvm.kt_4> f3319y;

    /* renamed from: z */
    private final ArrayList<IntrinsicsJvm.kt_3> f3320z;

    /* compiled from: DynamicAnimation.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3225a(DynamicAnimation abstractC0549c, boolean z, float COUIBaseListPopupWindow_12, float f2);
    }

    /* compiled from: DynamicAnimation.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3226a(DynamicAnimation abstractC0549c, float COUIBaseListPopupWindow_12, float f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    abstract boolean mo3192a(float COUIBaseListPopupWindow_12, float f2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    abstract boolean mo3194b(long OplusGLSurfaceView_15);

    /* compiled from: DynamicAnimation.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_5 */
    public static abstract class IntrinsicsJvm.kt_5 extends FloatPropertyCompat<View> {
        private IntrinsicsJvm.kt_5(String str) {
            super(str);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        float f3323a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f3324b;

        PlatformImplementations.kt_3() {
        }
    }

    DynamicAnimation(final FloatValueHolder c0551e) {
        this.f3309o = 0.0f;
        this.f3310p = Float.MAX_VALUE;
        this.f3311q = false;
        this.f3314t = false;
        this.f3315u = Float.MAX_VALUE;
        this.f3316v = -this.f3315u;
        this.f3317w = 0L;
        this.f3319y = new ArrayList<>();
        this.f3320z = new ArrayList<>();
        this.f3312r = null;
        this.f3313s = new FloatPropertyCompat("FloatValueHolder") { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.7
            @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
            /* renamed from: PlatformImplementations.kt_3 */
            public float mo3223a(Object obj) {
                return c0551e.m3227a();
            }

            @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo3224a(Object obj, float COUIBaseListPopupWindow_12) {
                c0551e.m3228a(COUIBaseListPopupWindow_12);
            }
        };
        this.f3318x = 1.0f;
    }

    <K> DynamicAnimation(K OplusGLSurfaceView_5, FloatPropertyCompat<K> abstractC0550d) {
        this.f3309o = 0.0f;
        this.f3310p = Float.MAX_VALUE;
        this.f3311q = false;
        this.f3314t = false;
        this.f3315u = Float.MAX_VALUE;
        this.f3316v = -this.f3315u;
        this.f3317w = 0L;
        this.f3319y = new ArrayList<>();
        this.f3320z = new ArrayList<>();
        this.f3312r = OplusGLSurfaceView_5;
        this.f3313s = abstractC0550d;
        FloatPropertyCompat abstractC0550d2 = this.f3313s;
        if (abstractC0550d2 == f3300f || abstractC0550d2 == f3301g || abstractC0550d2 == f3302h) {
            this.f3318x = 0.1f;
            return;
        }
        if (abstractC0550d2 == f3306l) {
            this.f3318x = 0.00390625f;
        } else if (abstractC0550d2 == f3298d || abstractC0550d2 == f3299e) {
            this.f3318x = 0.00390625f;
        } else {
            this.f3318x = 1.0f;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public T mo3199g(float COUIBaseListPopupWindow_12) {
        this.f3309o = COUIBaseListPopupWindow_12;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public T mo3198f(float COUIBaseListPopupWindow_12) {
        this.f3315u = COUIBaseListPopupWindow_12;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public T mo3197e(float COUIBaseListPopupWindow_12) {
        this.f3316v = COUIBaseListPopupWindow_12;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public T m3216a(IntrinsicsJvm.kt_4 bVar) {
        if (!this.f3319y.contains(bVar)) {
            this.f3319y.add(bVar);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public T m3217a(IntrinsicsJvm.kt_3 cVar) {
        if (m3220c()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f3320z.contains(cVar)) {
            this.f3320z.add(cVar);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3219b(IntrinsicsJvm.kt_3 cVar) {
        m3212a(this.f3320z, cVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> void m3211a(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> void m3212a(ArrayList<T> arrayList, T t) {
        int iIndexOf = arrayList.indexOf(t);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3191a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f3314t) {
            return;
        }
        m3214e();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3218b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f3314t) {
            m3213a(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m3220c() {
        return this.f3314t;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m3214e() {
        if (this.f3314t) {
            return;
        }
        this.f3314t = true;
        if (!this.f3311q) {
            this.f3310p = m3215f();
        }
        float COUIBaseListPopupWindow_12 = this.f3310p;
        if (COUIBaseListPopupWindow_12 > this.f3315u || COUIBaseListPopupWindow_12 < this.f3316v) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        AnimationHandler.m3180a().m3185a(this, 0L);
    }

    @Override // androidx.dynamicanimation.p043a.AnimationHandler.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo3188a(long OplusGLSurfaceView_15) {
        long j2 = this.f3317w;
        if (j2 == 0) {
            this.f3317w = OplusGLSurfaceView_15;
            m3222h(this.f3310p);
            return false;
        }
        this.f3317w = OplusGLSurfaceView_15;
        boolean zMo3194b = mo3194b(OplusGLSurfaceView_15 - j2);
        this.f3310p = Math.min(this.f3310p, this.f3315u);
        this.f3310p = Math.max(this.f3310p, this.f3316v);
        m3222h(this.f3310p);
        if (zMo3194b) {
            m3213a(false);
        }
        return zMo3194b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3213a(boolean z) {
        this.f3314t = false;
        AnimationHandler.m3180a().m3184a(this);
        this.f3317w = 0L;
        this.f3311q = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3319y.size(); OplusGLSurfaceView_13++) {
            if (this.f3319y.get(OplusGLSurfaceView_13) != null) {
                this.f3319y.get(OplusGLSurfaceView_13).mo3225a(this, z, this.f3310p, this.f3309o);
            }
        }
        m3211a(this.f3319y);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m3222h(float COUIBaseListPopupWindow_12) {
        this.f3313s.mo3224a(this.f3312r, COUIBaseListPopupWindow_12);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3320z.size(); OplusGLSurfaceView_13++) {
            if (this.f3320z.get(OplusGLSurfaceView_13) != null) {
                this.f3320z.get(OplusGLSurfaceView_13).mo3226a(this, this.f3310p, this.f3309o);
            }
        }
        m3211a(this.f3320z);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    float m3221d() {
        return this.f3318x * 0.75f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float m3215f() {
        return this.f3313s.mo3223a(this.f3312r);
    }
}
