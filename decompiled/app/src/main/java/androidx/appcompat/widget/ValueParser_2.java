package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
class aj_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f551a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f552b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f553c = Integer.MIN_VALUE;
    private int d_renamed = Integer.MIN_VALUE;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private boolean g_renamed = false;
    private boolean h_renamed = false;

    aj_renamed() {
    }

    public int a_renamed() {
        return this.f551a;
    }

    public int b_renamed() {
        return this.f552b;
    }

    public int c_renamed() {
        return this.g_renamed ? this.f552b : this.f551a;
    }

    public int d_renamed() {
        return this.g_renamed ? this.f551a : this.f552b;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f553c = i_renamed;
        this.d_renamed = i2;
        this.h_renamed = true;
        if (this.g_renamed) {
            if (i2 != Integer.MIN_VALUE) {
                this.f551a = i2;
            }
            if (i_renamed != Integer.MIN_VALUE) {
                this.f552b = i_renamed;
                return;
            }
            return;
        }
        if (i_renamed != Integer.MIN_VALUE) {
            this.f551a = i_renamed;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f552b = i2;
        }
    }

    public void b_renamed(int i_renamed, int i2) {
        this.h_renamed = false;
        if (i_renamed != Integer.MIN_VALUE) {
            this.e_renamed = i_renamed;
            this.f551a = i_renamed;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f_renamed = i2;
            this.f552b = i2;
        }
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed == this.g_renamed) {
            return;
        }
        this.g_renamed = z_renamed;
        if (!this.h_renamed) {
            this.f551a = this.e_renamed;
            this.f552b = this.f_renamed;
            return;
        }
        if (z_renamed) {
            int i_renamed = this.d_renamed;
            if (i_renamed == Integer.MIN_VALUE) {
                i_renamed = this.e_renamed;
            }
            this.f551a = i_renamed;
            int i2 = this.f553c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f_renamed;
            }
            this.f552b = i2;
            return;
        }
        int i3 = this.f553c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.e_renamed;
        }
        this.f551a = i3;
        int i4 = this.d_renamed;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f_renamed;
        }
        this.f552b = i4;
    }
}
