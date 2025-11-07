package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.p012a.p013a.p015b.FastSafeIterableMap;
import androidx.p012a.p013a.p015b.SafeIterableMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* renamed from: androidx.lifecycle.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final WeakReference<LifecycleOwner> f3638d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FastSafeIterableMap<LifecycleObserver, PlatformImplementations.kt_3> f3636b = new FastSafeIterableMap<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f3639e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f3640f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f3641g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ArrayList<Lifecycle.IntrinsicsJvm.kt_4> f3642h = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Lifecycle.IntrinsicsJvm.kt_4 f3637c = Lifecycle.IntrinsicsJvm.kt_4.INITIALIZED;

    public LifecycleRegistry(LifecycleOwner interfaceC0605h) {
        this.f3638d = new WeakReference<>(interfaceC0605h);
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void m3654a(Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        m3655b(bVar);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3655b(Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        m3648c(bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3653a(Lifecycle.PlatformImplementations.kt_3 aVar) {
        m3648c(m3643b(aVar));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3648c(Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        if (this.f3637c == bVar) {
            return;
        }
        this.f3637c = bVar;
        if (this.f3640f || this.f3639e != 0) {
            this.f3641g = true;
            return;
        }
        this.f3640f = true;
        m3649d();
        this.f3640f = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m3645b() {
        if (this.f3636b.m702a() == 0) {
            return true;
        }
        Lifecycle.IntrinsicsJvm.kt_4 bVar = this.f3636b.m706d().getValue().f3645a;
        Lifecycle.IntrinsicsJvm.kt_4 bVar2 = this.f3636b.m707e().getValue().f3645a;
        return bVar == bVar2 && this.f3637c == bVar2;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Lifecycle.IntrinsicsJvm.kt_4 m3646c(LifecycleObserver interfaceC0604g) {
        Map.Entry<LifecycleObserver, PlatformImplementations.kt_3> entryM701d = this.f3636b.m701d(interfaceC0604g);
        Lifecycle.IntrinsicsJvm.kt_4 bVar = null;
        Lifecycle.IntrinsicsJvm.kt_4 bVar2 = entryM701d != null ? entryM701d.getValue().f3645a : null;
        if (!this.f3642h.isEmpty()) {
            bVar = this.f3642h.get(r0.size() - 1);
        }
        return m3641a(m3641a(this.f3637c, bVar2), bVar);
    }

    @Override // androidx.lifecycle.Lifecycle
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3639a(LifecycleObserver interfaceC0604g) {
        LifecycleOwner interfaceC0605h;
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(interfaceC0604g, this.f3637c == Lifecycle.IntrinsicsJvm.kt_4.DESTROYED ? Lifecycle.IntrinsicsJvm.kt_4.DESTROYED : Lifecycle.IntrinsicsJvm.kt_4.INITIALIZED);
        if (this.f3636b.mo698a(interfaceC0604g, aVar) == null && (interfaceC0605h = this.f3638d.get()) != null) {
            boolean z = this.f3639e != 0 || this.f3640f;
            Lifecycle.IntrinsicsJvm.kt_4 bVarM3646c = m3646c(interfaceC0604g);
            this.f3639e++;
            while (aVar.f3645a.compareTo(bVarM3646c) < 0 && this.f3636b.m700c(interfaceC0604g)) {
                m3650d(aVar.f3645a);
                aVar.m3656a(interfaceC0605h, m3652f(aVar.f3645a));
                m3647c();
                bVarM3646c = m3646c(interfaceC0604g);
            }
            if (!z) {
                m3649d();
            }
            this.f3639e--;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3647c() {
        this.f3642h.remove(r1.size() - 1);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3650d(Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        this.f3642h.add(bVar);
    }

    @Override // androidx.lifecycle.Lifecycle
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3640b(LifecycleObserver interfaceC0604g) {
        this.f3636b.mo699b(interfaceC0604g);
    }

    @Override // androidx.lifecycle.Lifecycle
    /* renamed from: PlatformImplementations.kt_3 */
    public Lifecycle.IntrinsicsJvm.kt_4 mo3638a() {
        return this.f3637c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static Lifecycle.IntrinsicsJvm.kt_4 m3643b(Lifecycle.PlatformImplementations.kt_3 aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.IntrinsicsJvm.kt_4.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.IntrinsicsJvm.kt_4.STARTED;
            case ON_RESUME:
                return Lifecycle.IntrinsicsJvm.kt_4.RESUMED;
            case ON_DESTROY:
                return Lifecycle.IntrinsicsJvm.kt_4.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* compiled from: LifecycleRegistry.java */
    /* renamed from: androidx.lifecycle.OplusGLSurfaceView_13$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        static final /* synthetic */ int[] f3644b = new int[Lifecycle.IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f3644b[Lifecycle.IntrinsicsJvm.kt_4.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3644b[Lifecycle.IntrinsicsJvm.kt_4.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3644b[Lifecycle.IntrinsicsJvm.kt_4.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3644b[Lifecycle.IntrinsicsJvm.kt_4.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3644b[Lifecycle.IntrinsicsJvm.kt_4.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f3643a = new int[Lifecycle.PlatformImplementations.kt_3.values().length];
            try {
                f3643a[Lifecycle.PlatformImplementations.kt_3.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3643a[Lifecycle.PlatformImplementations.kt_3.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3643a[Lifecycle.PlatformImplementations.kt_3.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3643a[Lifecycle.PlatformImplementations.kt_3.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3643a[Lifecycle.PlatformImplementations.kt_3.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3643a[Lifecycle.PlatformImplementations.kt_3.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3643a[Lifecycle.PlatformImplementations.kt_3.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Lifecycle.PlatformImplementations.kt_3 m3651e(Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f3644b[bVar.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            throw new IllegalArgumentException();
        }
        if (OplusGLSurfaceView_13 == 2) {
            return Lifecycle.PlatformImplementations.kt_3.ON_DESTROY;
        }
        if (OplusGLSurfaceView_13 == 3) {
            return Lifecycle.PlatformImplementations.kt_3.ON_STOP;
        }
        if (OplusGLSurfaceView_13 == 4) {
            return Lifecycle.PlatformImplementations.kt_3.ON_PAUSE;
        }
        if (OplusGLSurfaceView_13 == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static Lifecycle.PlatformImplementations.kt_3 m3652f(Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f3644b[bVar.ordinal()];
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2) {
                return Lifecycle.PlatformImplementations.kt_3.ON_START;
            }
            if (OplusGLSurfaceView_13 == 3) {
                return Lifecycle.PlatformImplementations.kt_3.ON_RESUME;
            }
            if (OplusGLSurfaceView_13 == 4) {
                throw new IllegalArgumentException();
            }
            if (OplusGLSurfaceView_13 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return Lifecycle.PlatformImplementations.kt_3.ON_CREATE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private void m3642a(LifecycleOwner interfaceC0605h) {
        SafeIterableMap<LifecycleObserver, PlatformImplementations.kt_3>.IntrinsicsJvm.kt_5 dVarC = this.f3636b.m705c();
        while (dVarC.hasNext() && !this.f3641g) {
            Map.Entry next = dVarC.next();
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) next.getValue();
            while (aVar.f3645a.compareTo(this.f3637c) < 0 && !this.f3641g && this.f3636b.m700c(next.getKey())) {
                m3650d(aVar.f3645a);
                aVar.m3656a(interfaceC0605h, m3652f(aVar.f3645a));
                m3647c();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3644b(LifecycleOwner interfaceC0605h) {
        Iterator<Map.Entry<LifecycleObserver, PlatformImplementations.kt_3>> itB = this.f3636b.m704b();
        while (itB.hasNext() && !this.f3641g) {
            Map.Entry<LifecycleObserver, PlatformImplementations.kt_3> next = itB.next();
            PlatformImplementations.kt_3 value = next.getValue();
            while (value.f3645a.compareTo(this.f3637c) > 0 && !this.f3641g && this.f3636b.m700c(next.getKey())) {
                Lifecycle.PlatformImplementations.kt_3 aVarM3651e = m3651e(value.f3645a);
                m3650d(m3643b(aVarM3651e));
                value.m3656a(interfaceC0605h, aVarM3651e);
                m3647c();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3649d() {
        LifecycleOwner interfaceC0605h = this.f3638d.get();
        if (interfaceC0605h == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!m3645b()) {
            this.f3641g = false;
            if (this.f3637c.compareTo(this.f3636b.m706d().getValue().f3645a) < 0) {
                m3644b(interfaceC0605h);
            }
            Map.Entry<LifecycleObserver, PlatformImplementations.kt_3> entryE = this.f3636b.m707e();
            if (!this.f3641g && entryE != null && this.f3637c.compareTo(entryE.getValue().f3645a) > 0) {
                m3642a(interfaceC0605h);
            }
        }
        this.f3641g = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static Lifecycle.IntrinsicsJvm.kt_4 m3641a(Lifecycle.IntrinsicsJvm.kt_4 bVar, Lifecycle.IntrinsicsJvm.kt_4 bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* compiled from: LifecycleRegistry.java */
    /* renamed from: androidx.lifecycle.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        Lifecycle.IntrinsicsJvm.kt_4 f3645a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        LifecycleEventObserver f3646b;

        PlatformImplementations.kt_3(LifecycleObserver interfaceC0604g, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
            this.f3646b = Lifecycling.m3659a(interfaceC0604g);
            this.f3645a = bVar;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m3656a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
            Lifecycle.IntrinsicsJvm.kt_4 bVarM3643b = LifecycleRegistry.m3643b(aVar);
            this.f3645a = LifecycleRegistry.m3641a(this.f3645a, bVarM3643b);
            this.f3646b.mo714a(interfaceC0605h, aVar);
            this.f3645a = bVarM3643b;
        }
    }
}
