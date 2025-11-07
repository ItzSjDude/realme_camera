package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Lifecycle.java */
/* renamed from: androidx.lifecycle.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* renamed from: PlatformImplementations.kt_3 */
    AtomicReference<Object> f3633a = new AtomicReference<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract IntrinsicsJvm.kt_4 mo3638a();

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3639a(LifecycleObserver interfaceC0604g);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo3640b(LifecycleObserver interfaceC0604g);

    /* compiled from: Lifecycle.java */
    /* renamed from: androidx.lifecycle.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static PlatformImplementations.kt_3 downFrom(IntrinsicsJvm.kt_4 bVar) {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f3634a[bVar.ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return ON_DESTROY;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return ON_STOP;
            }
            if (OplusGLSurfaceView_13 != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static PlatformImplementations.kt_3 downTo(IntrinsicsJvm.kt_4 bVar) {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f3634a[bVar.ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return ON_STOP;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return ON_PAUSE;
            }
            if (OplusGLSurfaceView_13 != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        public static PlatformImplementations.kt_3 upFrom(IntrinsicsJvm.kt_4 bVar) {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f3634a[bVar.ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return ON_START;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return ON_RESUME;
            }
            if (OplusGLSurfaceView_13 != 5) {
                return null;
            }
            return ON_CREATE;
        }

        public static PlatformImplementations.kt_3 upTo(IntrinsicsJvm.kt_4 bVar) {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f3634a[bVar.ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return ON_CREATE;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return ON_START;
            }
            if (OplusGLSurfaceView_13 != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public IntrinsicsJvm.kt_4 getTargetState() {
            switch (this) {
                case ON_CREATE:
                case ON_STOP:
                    return IntrinsicsJvm.kt_4.CREATED;
                case ON_START:
                case ON_PAUSE:
                    return IntrinsicsJvm.kt_4.STARTED;
                case ON_RESUME:
                    return IntrinsicsJvm.kt_4.RESUMED;
                case ON_DESTROY:
                    return IntrinsicsJvm.kt_4.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Lifecycle.java */
    /* renamed from: androidx.lifecycle.COUIBaseListPopupWindow_8$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f3634a;

        static {
            try {
                f3635b[PlatformImplementations.kt_3.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3635b[PlatformImplementations.kt_3.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3635b[PlatformImplementations.kt_3.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3635b[PlatformImplementations.kt_3.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3635b[PlatformImplementations.kt_3.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3635b[PlatformImplementations.kt_3.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3635b[PlatformImplementations.kt_3.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f3634a = new int[IntrinsicsJvm.kt_4.values().length];
            try {
                f3634a[IntrinsicsJvm.kt_4.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3634a[IntrinsicsJvm.kt_4.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3634a[IntrinsicsJvm.kt_4.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3634a[IntrinsicsJvm.kt_4.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3634a[IntrinsicsJvm.kt_4.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: Lifecycle.java */
    /* renamed from: androidx.lifecycle.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(IntrinsicsJvm.kt_4 bVar) {
            return compareTo(bVar) >= 0;
        }
    }
}
