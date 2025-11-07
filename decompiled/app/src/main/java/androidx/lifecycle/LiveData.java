package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.p012a.p013a.p014a.ArchTaskExecutor;
import androidx.p012a.p013a.p015b.SafeIterableMap;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final Object f3605b = new Object();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f3610f;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f3613i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f3614j;

    /* renamed from: PlatformImplementations.kt_3 */
    final Object f3606a = new Object();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SafeIterableMap<Observer<? super T>, LiveData<T>.AbstractC0597a> f3609e = new SafeIterableMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f3607c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    volatile Object f3608d = f3605b;

    /* renamed from: OplusGLSurfaceView_5 */
    private final Runnable f3615k = new Runnable() { // from class: androidx.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3606a) {
                obj = LiveData.this.f3608d;
                LiveData.this.f3608d = LiveData.f3605b;
            }
            LiveData.this.mo3615a((LiveData) obj);
        }
    };

    /* renamed from: COUIBaseListPopupWindow_11 */
    private volatile Object f3611g = f3605b;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f3612h = -1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo3616b() {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo3617c() {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3609b(LiveData<T>.AbstractC0597a abstractC0597a) {
        if (abstractC0597a.f3620d) {
            if (!abstractC0597a.mo3619a()) {
                abstractC0597a.m3622a(false);
                return;
            }
            int OplusGLSurfaceView_13 = abstractC0597a.f3621e;
            int i2 = this.f3612h;
            if (OplusGLSurfaceView_13 >= i2) {
                return;
            }
            abstractC0597a.f3621e = i2;
            abstractC0597a.f3619c.mo3665a((Object) this.f3611g);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3612a(LiveData<T>.AbstractC0597a abstractC0597a) {
        if (this.f3613i) {
            this.f3614j = true;
            return;
        }
        this.f3613i = true;
        do {
            this.f3614j = false;
            if (abstractC0597a != null) {
                m3609b(abstractC0597a);
                abstractC0597a = null;
            } else {
                SafeIterableMap<Observer<? super T>, LiveData<T>.AbstractC0597a>.IntrinsicsJvm.kt_5 dVarM705c = this.f3609e.m705c();
                while (dVarM705c.hasNext()) {
                    m3609b((AbstractC0597a) dVarM705c.next().getValue());
                    if (this.f3614j) {
                        break;
                    }
                }
            }
        } while (this.f3614j);
        this.f3613i = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3613a(LifecycleOwner interfaceC0605h, Observer<? super T> interfaceC0611n) {
        m3608a("observe");
        if (interfaceC0605h.getLifecycle().mo3638a() == Lifecycle.IntrinsicsJvm.kt_4.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(interfaceC0605h, interfaceC0611n);
        LiveData<T>.AbstractC0597a abstractC0597aMo698a = this.f3609e.mo698a(interfaceC0611n, lifecycleBoundObserver);
        if (abstractC0597aMo698a != null && !abstractC0597aMo698a.mo3620a(interfaceC0605h)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0597aMo698a != null) {
            return;
        }
        interfaceC0605h.getLifecycle().mo3639a(lifecycleBoundObserver);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3614a(Observer<? super T> interfaceC0611n) {
        m3608a("removeObserver");
        LiveData<T>.AbstractC0597a abstractC0597aMo699b = this.f3609e.mo699b(interfaceC0611n);
        if (abstractC0597aMo699b == null) {
            return;
        }
        abstractC0597aMo699b.mo3621b();
        abstractC0597aMo699b.m3622a(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3615a(T t) {
        m3608a("setValue");
        this.f3612h++;
        this.f3611g = t;
        m3612a((AbstractC0597a) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public T m3610a() {
        T t = (T) this.f3611g;
        if (t != f3605b) {
            return t;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m3618d() {
        return this.f3607c > 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3611a(int OplusGLSurfaceView_13) {
        int i2 = this.f3607c;
        this.f3607c = OplusGLSurfaceView_13 + i2;
        if (this.f3610f) {
            return;
        }
        this.f3610f = true;
        while (true) {
            try {
                if (i2 == this.f3607c) {
                    return;
                }
                boolean z = i2 == 0 && this.f3607c > 0;
                boolean z2 = i2 > 0 && this.f3607c == 0;
                int i3 = this.f3607c;
                if (z) {
                    mo3616b();
                } else if (z2) {
                    mo3617c();
                }
                i2 = i3;
            } finally {
                this.f3610f = false;
            }
        }
    }

    class LifecycleBoundObserver extends LiveData<T>.AbstractC0597a implements LifecycleEventObserver {

        /* renamed from: PlatformImplementations.kt_3 */
        final LifecycleOwner f3617a;

        LifecycleBoundObserver(LifecycleOwner interfaceC0605h, Observer<? super T> interfaceC0611n) {
            super(interfaceC0611n);
            this.f3617a = interfaceC0605h;
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0597a
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo3619a() {
            return this.f3617a.getLifecycle().mo3638a().isAtLeast(Lifecycle.IntrinsicsJvm.kt_4.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
            Lifecycle.IntrinsicsJvm.kt_4 bVarMo3638a = this.f3617a.getLifecycle().mo3638a();
            if (bVarMo3638a == Lifecycle.IntrinsicsJvm.kt_4.DESTROYED) {
                LiveData.this.mo3614a((Observer) this.f3619c);
                return;
            }
            Lifecycle.IntrinsicsJvm.kt_4 bVar = null;
            while (bVar != bVarMo3638a) {
                m3622a(mo3619a());
                bVar = bVarMo3638a;
                bVarMo3638a = this.f3617a.getLifecycle().mo3638a();
            }
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0597a
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo3620a(LifecycleOwner interfaceC0605h) {
            return this.f3617a == interfaceC0605h;
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0597a
        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo3621b() {
            this.f3617a.getLifecycle().mo3640b(this);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$PlatformImplementations.kt_3 */
    private abstract class AbstractC0597a {

        /* renamed from: IntrinsicsJvm.kt_3 */
        final Observer<? super T> f3619c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f3620d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f3621e = -1;

        /* renamed from: PlatformImplementations.kt_3 */
        abstract boolean mo3619a();

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo3620a(LifecycleOwner interfaceC0605h) {
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo3621b() {
        }

        AbstractC0597a(Observer<? super T> interfaceC0611n) {
            this.f3619c = interfaceC0611n;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m3622a(boolean z) {
            if (z == this.f3620d) {
                return;
            }
            this.f3620d = z;
            LiveData.this.m3611a(this.f3620d ? 1 : -1);
            if (this.f3620d) {
                LiveData.this.m3612a(this);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m3608a(String str) {
        if (ArchTaskExecutor.m691a().mo695c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on PlatformImplementations.kt_3 background thread");
    }
}
