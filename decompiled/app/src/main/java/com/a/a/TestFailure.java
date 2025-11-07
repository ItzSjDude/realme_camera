package com.a_renamed.a_renamed;

/* compiled from: Spring.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f1967a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.a_renamed.a_renamed.g_renamed f1968b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f1969c;
    private final java.lang.String d_renamed;
    private final com.a_renamed.a_renamed.f_renamed.a_renamed e_renamed;
    private final com.a_renamed.a_renamed.f_renamed.a_renamed f_renamed;
    private final com.a_renamed.a_renamed.f_renamed.a_renamed g_renamed;
    private double h_renamed;
    private double i_renamed;
    private boolean j_renamed = true;
    private double k_renamed = 0.005d;
    private double l_renamed = 0.005d;
    private java.util.concurrent.CopyOnWriteArraySet<com.a_renamed.a_renamed.h_renamed> m_renamed = new java.util.concurrent.CopyOnWriteArraySet<>();
    private double n_renamed = 0.0d;
    private final com.a_renamed.a_renamed.b_renamed o_renamed;

    /* compiled from: Spring.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        double f1970a;

        /* renamed from: b_renamed, reason: collision with root package name */
        double f1971b;

        private a_renamed() {
        }
    }

    f_renamed(com.a_renamed.a_renamed.b_renamed bVar) {
        this.e_renamed = new com.a_renamed.a_renamed.f_renamed.a_renamed();
        this.f_renamed = new com.a_renamed.a_renamed.f_renamed.a_renamed();
        this.g_renamed = new com.a_renamed.a_renamed.f_renamed.a_renamed();
        if (bVar == null) {
            throw new java.lang.IllegalArgumentException("Spring cannot be_renamed created outside of_renamed a_renamed BaseSpringSystem");
        }
        this.o_renamed = bVar;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("spring:");
        int i_renamed = f1967a;
        f1967a = i_renamed + 1;
        sb.append(i_renamed);
        this.d_renamed = sb.toString();
        a_renamed(com.a_renamed.a_renamed.g_renamed.f1972c);
    }

    public void a_renamed() {
        this.m_renamed.clear();
        this.o_renamed.b_renamed(this);
    }

    public java.lang.String b_renamed() {
        return this.d_renamed;
    }

    public com.a_renamed.a_renamed.f_renamed a_renamed(com.a_renamed.a_renamed.g_renamed gVar) {
        if (gVar == null) {
            throw new java.lang.IllegalArgumentException("springConfig is_renamed required");
        }
        this.f1968b = gVar;
        return this;
    }

    public com.a_renamed.a_renamed.f_renamed a_renamed(double d_renamed) {
        return a_renamed(d_renamed, true);
    }

    public com.a_renamed.a_renamed.f_renamed a_renamed(double d_renamed, boolean z_renamed) {
        this.h_renamed = d_renamed;
        this.e_renamed.f1970a = d_renamed;
        this.o_renamed.a_renamed(b_renamed());
        java.util.Iterator<com.a_renamed.a_renamed.h_renamed> it = this.m_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(this);
        }
        if (z_renamed) {
            j_renamed();
        }
        return this;
    }

    public double c_renamed() {
        return this.e_renamed.f1970a;
    }

    private double a_renamed(com.a_renamed.a_renamed.f_renamed.a_renamed aVar) {
        return java.lang.Math.abs(this.i_renamed - aVar.f1970a);
    }

    public com.a_renamed.a_renamed.f_renamed b_renamed(double d_renamed) {
        if (this.i_renamed == d_renamed && i_renamed()) {
            return this;
        }
        this.h_renamed = c_renamed();
        this.i_renamed = d_renamed;
        this.o_renamed.a_renamed(b_renamed());
        java.util.Iterator<com.a_renamed.a_renamed.h_renamed> it = this.m_renamed.iterator();
        while (it.hasNext()) {
            it.next().d_renamed(this);
        }
        return this;
    }

    public double d_renamed() {
        return this.i_renamed;
    }

    public com.a_renamed.a_renamed.f_renamed c_renamed(double d_renamed) {
        if (d_renamed == this.e_renamed.f1971b) {
            return this;
        }
        this.e_renamed.f1971b = d_renamed;
        this.o_renamed.a_renamed(b_renamed());
        return this;
    }

    public double e_renamed() {
        return this.e_renamed.f1971b;
    }

    public com.a_renamed.a_renamed.f_renamed a_renamed(boolean z_renamed) {
        this.f1969c = z_renamed;
        return this;
    }

    public boolean f_renamed() {
        return this.f1968b.f1974b > 0.0d && ((this.h_renamed < this.i_renamed && c_renamed() > this.i_renamed) || (this.h_renamed > this.i_renamed && c_renamed() < this.i_renamed));
    }

    void d_renamed(double d_renamed) {
        double d2;
        boolean z_renamed;
        boolean zI = i_renamed();
        if (zI && this.j_renamed) {
            return;
        }
        this.n_renamed += d_renamed <= 0.064d ? d_renamed : 0.064d;
        double d3 = this.f1968b.f1974b;
        double d4 = this.f1968b.f1973a;
        double d5 = this.e_renamed.f1970a;
        double d6 = this.e_renamed.f1971b;
        double d7 = this.g_renamed.f1970a;
        double d8 = this.g_renamed.f1971b;
        while (true) {
            d2 = this.n_renamed;
            if (d2 < 0.001d) {
                break;
            }
            this.n_renamed = d2 - 0.001d;
            if (this.n_renamed < 0.001d) {
                com.a_renamed.a_renamed.f_renamed.a_renamed aVar = this.f_renamed;
                aVar.f1970a = d5;
                aVar.f1971b = d6;
            }
            double d9 = this.i_renamed;
            double d10 = ((d9 - d7) * d3) - (d4 * d6);
            double d11 = d6 + (d10 * 0.001d * 0.5d);
            double d12 = ((d9 - (((d6 * 0.001d) * 0.5d) + d5)) * d3) - (d4 * d11);
            double d13 = d6 + (d12 * 0.001d * 0.5d);
            double d14 = ((d9 - (d5 + ((d11 * 0.001d) * 0.5d))) * d3) - (d4 * d13);
            double d15 = d5 + (d13 * 0.001d);
            double d16 = d6 + (d14 * 0.001d);
            d5 += (d6 + ((d11 + d13) * 2.0d) + d16) * 0.16666666666666666d * 0.001d;
            d6 += (d10 + ((d12 + d14) * 2.0d) + (((d9 - d15) * d3) - (d4 * d16))) * 0.16666666666666666d * 0.001d;
            d7 = d15;
            d8 = d16;
        }
        com.a_renamed.a_renamed.f_renamed.a_renamed aVar2 = this.g_renamed;
        aVar2.f1970a = d7;
        aVar2.f1971b = d8;
        com.a_renamed.a_renamed.f_renamed.a_renamed aVar3 = this.e_renamed;
        aVar3.f1970a = d5;
        aVar3.f1971b = d6;
        if (d2 > 0.0d) {
            e_renamed(d2 / 0.001d);
        }
        if (i_renamed() || (this.f1969c && f_renamed())) {
            if (d3 > 0.0d) {
                double d17 = this.i_renamed;
                this.h_renamed = d17;
                this.e_renamed.f1970a = d17;
            } else {
                this.i_renamed = this.e_renamed.f1970a;
                this.h_renamed = this.i_renamed;
            }
            c_renamed(0.0d);
            zI = true;
        }
        boolean z2 = false;
        if (this.j_renamed) {
            this.j_renamed = false;
            z_renamed = true;
        } else {
            z_renamed = false;
        }
        if (zI) {
            this.j_renamed = true;
            z2 = true;
        }
        java.util.Iterator<com.a_renamed.a_renamed.h_renamed> it = this.m_renamed.iterator();
        while (it.hasNext()) {
            com.a_renamed.a_renamed.h_renamed next = it.next();
            if (z_renamed) {
                next.c_renamed(this);
            }
            next.a_renamed(this);
            if (z2) {
                next.b_renamed(this);
            }
        }
    }

    public boolean g_renamed() {
        return (i_renamed() && h_renamed()) ? false : true;
    }

    public boolean h_renamed() {
        return this.j_renamed;
    }

    public boolean i_renamed() {
        return java.lang.Math.abs(this.e_renamed.f1971b) <= this.k_renamed && (a_renamed(this.e_renamed) <= this.l_renamed || this.f1968b.f1974b == 0.0d);
    }

    public com.a_renamed.a_renamed.f_renamed j_renamed() {
        this.i_renamed = this.e_renamed.f1970a;
        this.g_renamed.f1970a = this.e_renamed.f1970a;
        this.e_renamed.f1971b = 0.0d;
        return this;
    }

    private void e_renamed(double d_renamed) {
        com.a_renamed.a_renamed.f_renamed.a_renamed aVar = this.e_renamed;
        double d2 = 1.0d - d_renamed;
        aVar.f1970a = (aVar.f1970a * d_renamed) + (this.f_renamed.f1970a * d2);
        com.a_renamed.a_renamed.f_renamed.a_renamed aVar2 = this.e_renamed;
        aVar2.f1971b = (aVar2.f1971b * d_renamed) + (this.f_renamed.f1971b * d2);
    }

    public com.a_renamed.a_renamed.f_renamed a_renamed(com.a_renamed.a_renamed.h_renamed hVar) {
        if (hVar == null) {
            throw new java.lang.IllegalArgumentException("newListener is_renamed required");
        }
        this.m_renamed.add(hVar);
        return this;
    }

    public com.a_renamed.a_renamed.f_renamed k_renamed() {
        this.m_renamed.clear();
        return this;
    }
}
