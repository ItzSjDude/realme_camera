package c_renamed.h_renamed;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes.dex */
public final class b_renamed extends c_renamed.a_renamed.w_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f1917a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f1918b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f1919c;
    private final int d_renamed;

    public b_renamed(int i_renamed, int i2, int i3) {
        this.d_renamed = i3;
        this.f1917a = i2;
        boolean z_renamed = true;
        if (this.d_renamed <= 0 ? i_renamed < i2 : i_renamed > i2) {
            z_renamed = false;
        }
        this.f1918b = z_renamed;
        this.f1919c = this.f1918b ? i_renamed : this.f1917a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1918b;
    }

    @Override // c_renamed.a_renamed.w_renamed
    public int b_renamed() {
        int i_renamed = this.f1919c;
        if (i_renamed == this.f1917a) {
            if (!this.f1918b) {
                throw new java.util.NoSuchElementException();
            }
            this.f1918b = false;
        } else {
            this.f1919c = this.d_renamed + i_renamed;
        }
        return i_renamed;
    }
}
