package c_renamed.g_renamed;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes.dex */
public final class b_renamed extends c_renamed.g_renamed.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final c_renamed.g_renamed.b_renamed.a_renamed f1911b = new c_renamed.g_renamed.b_renamed.a_renamed();

    /* compiled from: PlatformRandom.kt */
    public static final class a_renamed extends java.lang.ThreadLocal<java.util.Random> {
        a_renamed() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // c_renamed.g_renamed.a_renamed
    public java.util.Random a_renamed() {
        java.util.Random random = this.f1911b.get();
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(random, "implStorage.get()");
        return random;
    }
}
