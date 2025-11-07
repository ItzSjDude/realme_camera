package kotlinx.coroutines;

/* compiled from: MainCoroutineDispatcher.kt */
/* renamed from: kotlinx.coroutines.bf */
/* loaded from: classes2.dex */
public abstract class MainCoroutineDispatcher.kt extends CoroutineDispatcher.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public abstract MainCoroutineDispatcher.kt mo25639a();

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        String strM25786b = m25786b();
        if (strM25786b != null) {
            return strM25786b;
        }
        return DebugStrings.kt.m25580b(this) + '@' + DebugStrings.kt.m25579a(this);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final String m25786b() {
        MainCoroutineDispatcher.kt abstractC3903bfMo25639a;
        MainCoroutineDispatcher.kt abstractC3903bfM25602b = Dispatchers.kt.m25602b();
        MainCoroutineDispatcher.kt abstractC3903bf = this;
        if (abstractC3903bf == abstractC3903bfM25602b) {
            return "Dispatchers.Main";
        }
        try {
            abstractC3903bfMo25639a = abstractC3903bfM25602b.mo25639a();
        } catch (UnsupportedOperationException unused) {
            abstractC3903bfMo25639a = null;
        }
        if (abstractC3903bf == abstractC3903bfMo25639a) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
