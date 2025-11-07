package androidx.lifecycle;

/* compiled from: Lifecycle.java */
/* loaded from: classes.dex */
public abstract class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    java.util.concurrent.atomic.AtomicReference<java.lang.Object> f1235a = new java.util.concurrent.atomic.AtomicReference<>();

    public abstract androidx.lifecycle.e_renamed.b_renamed a_renamed();

    public abstract void a_renamed(androidx.lifecycle.g_renamed gVar);

    public abstract void b_renamed(androidx.lifecycle.g_renamed gVar);

    /* compiled from: Lifecycle.java */
    public enum a_renamed {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static androidx.lifecycle.e_renamed.a_renamed downFrom(androidx.lifecycle.e_renamed.b_renamed bVar) {
            int i_renamed = androidx.lifecycle.e_renamed.SceneLoader_2.f1236a[bVar.ordinal()];
            if (i_renamed == 1) {
                return ON_DESTROY;
            }
            if (i_renamed == 2) {
                return ON_STOP;
            }
            if (i_renamed != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static androidx.lifecycle.e_renamed.a_renamed downTo(androidx.lifecycle.e_renamed.b_renamed bVar) {
            int i_renamed = androidx.lifecycle.e_renamed.SceneLoader_2.f1236a[bVar.ordinal()];
            if (i_renamed == 1) {
                return ON_STOP;
            }
            if (i_renamed == 2) {
                return ON_PAUSE;
            }
            if (i_renamed != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        public static androidx.lifecycle.e_renamed.a_renamed upFrom(androidx.lifecycle.e_renamed.b_renamed bVar) {
            int i_renamed = androidx.lifecycle.e_renamed.SceneLoader_2.f1236a[bVar.ordinal()];
            if (i_renamed == 1) {
                return ON_START;
            }
            if (i_renamed == 2) {
                return ON_RESUME;
            }
            if (i_renamed != 5) {
                return null;
            }
            return ON_CREATE;
        }

        public static androidx.lifecycle.e_renamed.a_renamed upTo(androidx.lifecycle.e_renamed.b_renamed bVar) {
            int i_renamed = androidx.lifecycle.e_renamed.SceneLoader_2.f1236a[bVar.ordinal()];
            if (i_renamed == 1) {
                return ON_CREATE;
            }
            if (i_renamed == 2) {
                return ON_START;
            }
            if (i_renamed != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public androidx.lifecycle.e_renamed.b_renamed getTargetState() {
            switch (this) {
                case ON_CREATE:
                case ON_STOP:
                    return androidx.lifecycle.e_renamed.b_renamed.CREATED;
                case ON_START:
                case ON_PAUSE:
                    return androidx.lifecycle.e_renamed.b_renamed.STARTED;
                case ON_RESUME:
                    return androidx.lifecycle.e_renamed.b_renamed.RESUMED;
                case ON_DESTROY:
                    return androidx.lifecycle.e_renamed.b_renamed.DESTROYED;
                default:
                    throw new java.lang.IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Lifecycle.java */
    /* renamed from: androidx.lifecycle.e_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f1236a;

        static {
            try {
                f1237b[androidx.lifecycle.e_renamed.a_renamed.ON_CREATE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1237b[androidx.lifecycle.e_renamed.a_renamed.ON_STOP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1237b[androidx.lifecycle.e_renamed.a_renamed.ON_START.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f1237b[androidx.lifecycle.e_renamed.a_renamed.ON_PAUSE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f1237b[androidx.lifecycle.e_renamed.a_renamed.ON_RESUME.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f1237b[androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f1237b[androidx.lifecycle.e_renamed.a_renamed.ON_ANY.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            f1236a = new int[androidx.lifecycle.e_renamed.b_renamed.values().length];
            try {
                f1236a[androidx.lifecycle.e_renamed.b_renamed.CREATED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                f1236a[androidx.lifecycle.e_renamed.b_renamed.STARTED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                f1236a[androidx.lifecycle.e_renamed.b_renamed.RESUMED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                f1236a[androidx.lifecycle.e_renamed.b_renamed.DESTROYED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                f1236a[androidx.lifecycle.e_renamed.b_renamed.INITIALIZED.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: Lifecycle.java */
    public enum b_renamed {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(androidx.lifecycle.e_renamed.b_renamed bVar) {
            return compareTo(bVar) >= 0;
        }
    }
}
