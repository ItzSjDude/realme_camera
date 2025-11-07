package androidx.loader.p050a;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.p051b.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* renamed from: androidx.loader.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class LoaderManager {

    /* compiled from: LoaderManager.java */
    /* renamed from: androidx.loader.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3<D> {
        /* renamed from: PlatformImplementations.kt_3 */
        void m3686a(Loader<D> c0620a);

        /* renamed from: PlatformImplementations.kt_3 */
        void m3687a(Loader<D> c0620a, D IntrinsicsJvm.kt_5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3684a();

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3685a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager m3683a(T t) {
        return new LoaderManagerImpl(t, t.getViewModelStore());
    }
}
