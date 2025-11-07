package androidx.lifecycle;

/* compiled from: ViewModelProvider.java */
/* renamed from: androidx.lifecycle.r */
/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    private final PlatformImplementations.kt_3 f3653a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ViewModelStore f3654b;

    /* compiled from: ViewModelProvider.java */
    /* renamed from: androidx.lifecycle.r$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        <T extends ViewModel> T mo3539a(Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    /* renamed from: androidx.lifecycle.r$IntrinsicsJvm.kt_4 */
    static abstract class IntrinsicsJvm.kt_4 implements PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract <T extends ViewModel> T m3679a(String str, Class<T> cls);

        IntrinsicsJvm.kt_4() {
        }
    }

    public ViewModelProvider(ViewModelStore c0616s, PlatformImplementations.kt_3 aVar) {
        this.f3653a = aVar;
        this.f3654b = c0616s;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T extends ViewModel> T m3677a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) m3678a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T extends ViewModel> T m3678a(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.f3654b.m3680a(str);
        if (cls.isInstance(t2)) {
            return t2;
        }
        PlatformImplementations.kt_3 aVar = this.f3653a;
        if (aVar instanceof IntrinsicsJvm.kt_4) {
            t = (T) ((IntrinsicsJvm.kt_4) aVar).m3679a(str, cls);
        } else {
            t = (T) aVar.mo3539a(cls);
        }
        this.f3654b.m3682a(str, t);
        return t;
    }
}
