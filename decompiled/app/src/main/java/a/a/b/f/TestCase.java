package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f84a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final int f85b;

    public e_renamed(int i_renamed) {
        this.f85b = java.lang.Math.max(1, i_renamed);
    }

    public boolean a_renamed() {
        int i_renamed = this.f84a;
        if (i_renamed == this.f85b) {
            this.f84a = 0;
            return true;
        }
        this.f84a = i_renamed + 1;
        return false;
    }
}
