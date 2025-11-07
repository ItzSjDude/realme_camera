package androidx.loader.p050a;

import android.os.Bundle;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.p035g.DebugUtils;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.loader.p050a.LoaderManager;
import androidx.loader.p051b.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl.java */
/* renamed from: androidx.loader.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class LoaderManagerImpl extends LoaderManager {

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean f3656a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LifecycleOwner f3657b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final IntrinsicsJvm.kt_3 f3658c;

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3<D> extends MutableLiveData<D> implements Loader.PlatformImplementations.kt_3<D> {

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final int f3659e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private final Bundle f3660f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final Loader<D> f3661g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private LifecycleOwner f3662h;

        /* renamed from: OplusGLSurfaceView_13 */
        private IntrinsicsJvm.kt_4<D> f3663i;

        /* renamed from: OplusGLSurfaceView_15 */
        private Loader<D> f3664j;

        /* renamed from: COUIBaseListPopupWindow_8 */
        Loader<D> m3690e() {
            return this.f3661g;
        }

        @Override // androidx.lifecycle.LiveData
        /* renamed from: IntrinsicsJvm.kt_4 */
        protected void mo3616b() {
            if (LoaderManagerImpl.f3656a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f3661g.m3699a();
        }

        @Override // androidx.lifecycle.LiveData
        /* renamed from: IntrinsicsJvm.kt_3 */
        protected void mo3617c() {
            if (LoaderManagerImpl.f3656a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f3661g.m3705e();
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        void m3691f() {
            LifecycleOwner interfaceC0605h = this.f3662h;
            IntrinsicsJvm.kt_4<D> bVar = this.f3663i;
            if (interfaceC0605h == null || bVar == null) {
                return;
            }
            super.mo3614a((Observer) bVar);
            m3613a(interfaceC0605h, bVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3614a(Observer<? super D> interfaceC0611n) {
            super.mo3614a((Observer) interfaceC0611n);
            this.f3662h = null;
            this.f3663i = null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        Loader<D> m3688a(boolean z) {
            if (LoaderManagerImpl.f3656a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f3661g.m3703c();
            this.f3661g.m3707g();
            IntrinsicsJvm.kt_4<D> bVar = this.f3663i;
            if (bVar != null) {
                mo3614a((Observer) bVar);
                if (z) {
                    bVar.m3694b();
                }
            }
            this.f3661g.m3700a((Loader.PlatformImplementations.kt_3) this);
            if ((bVar != null && !bVar.m3693a()) || z) {
                this.f3661g.m3709i();
                return this.f3664j;
            }
            return this.f3661g;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3615a(D IntrinsicsJvm.kt_5) {
            super.mo3615a((PlatformImplementations.kt_3<D>) IntrinsicsJvm.kt_5);
            Loader<D> c0620a = this.f3664j;
            if (c0620a != null) {
                c0620a.m3709i();
                this.f3664j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3659e);
            sb.append(" : ");
            DebugUtils.m2527a(this.f3661g, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3689a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3659e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3660f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3661g);
            this.f3661g.m3701a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f3663i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f3663i);
                this.f3663i.m3692a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m3690e().m3698a((Loader<D>) m3610a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(m3618d());
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4<D> implements Observer<D> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Loader<D> f3665a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final LoaderManager.PlatformImplementations.kt_3<D> f3666b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f3667c;

        @Override // androidx.lifecycle.Observer
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3665a(D IntrinsicsJvm.kt_5) {
            if (LoaderManagerImpl.f3656a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f3665a + ": " + this.f3665a.m3698a((Loader<D>) IntrinsicsJvm.kt_5));
            }
            this.f3666b.m3687a(this.f3665a, IntrinsicsJvm.kt_5);
            this.f3667c = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m3693a() {
            return this.f3667c;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m3694b() {
            if (this.f3667c) {
                if (LoaderManagerImpl.f3656a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f3665a);
                }
                this.f3666b.m3686a(this.f3665a);
            }
        }

        public String toString() {
            return this.f3666b.toString();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3692a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3667c);
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 extends ViewModel {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final ViewModelProvider.PlatformImplementations.kt_3 f3668a = new ViewModelProvider.PlatformImplementations.kt_3() { // from class: androidx.loader.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.1
            @Override // androidx.lifecycle.ViewModelProvider.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public <T extends ViewModel> T mo3539a(Class<T> cls) {
                return new IntrinsicsJvm.kt_3();
            }
        };

        /* renamed from: IntrinsicsJvm.kt_4 */
        private SparseArrayCompat<PlatformImplementations.kt_3> f3669b = new SparseArrayCompat<>();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f3670c = false;

        IntrinsicsJvm.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static IntrinsicsJvm.kt_3 m3695a(ViewModelStore c0616s) {
            return (IntrinsicsJvm.kt_3) new ViewModelProvider(c0616s, f3668a).m3677a(IntrinsicsJvm.kt_3.class);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m3697b() {
            int size = this.f3669b.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f3669b.valueAt(OplusGLSurfaceView_13).m3691f();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        /* renamed from: PlatformImplementations.kt_3 */
        protected void mo3530a() {
            super.mo3530a();
            int size = this.f3669b.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f3669b.valueAt(OplusGLSurfaceView_13).m3688a(true);
            }
            this.f3669b.clear();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3696a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3669b.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3669b.size(); OplusGLSurfaceView_13++) {
                    PlatformImplementations.kt_3 aVarValueAt = this.f3669b.valueAt(OplusGLSurfaceView_13);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3669b.keyAt(OplusGLSurfaceView_13));
                    printWriter.print(": ");
                    printWriter.println(aVarValueAt.toString());
                    aVarValueAt.m3689a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    LoaderManagerImpl(LifecycleOwner interfaceC0605h, ViewModelStore c0616s) {
        this.f3657b = interfaceC0605h;
        this.f3658c = IntrinsicsJvm.kt_3.m3695a(c0616s);
    }

    @Override // androidx.loader.p050a.LoaderManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3684a() {
        this.f3658c.m3697b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.m2527a(this.f3657b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.loader.p050a.LoaderManager
    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3685a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3658c.m3696a(str, fileDescriptor, printWriter, strArr);
    }
}
