package c_renamed.g_renamed;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes.dex */
public abstract class a_renamed extends c_renamed.g_renamed.c_renamed {
    public abstract java.util.Random a_renamed();

    @Override // c_renamed.g_renamed.c_renamed
    public int a_renamed(int i_renamed) {
        return c_renamed.g_renamed.d_renamed.a_renamed(a_renamed().nextInt(), i_renamed);
    }

    @Override // c_renamed.g_renamed.c_renamed
    public int b_renamed() {
        return a_renamed().nextInt();
    }
}
