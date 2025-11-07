package com.coui.appcompat.a_renamed;

/* compiled from: COUIRtlSpacingHelper.java */
/* loaded from: classes.dex */
public class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2396a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2397b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2398c = Integer.MIN_VALUE;
    private int d_renamed = Integer.MIN_VALUE;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private boolean g_renamed = false;
    private boolean h_renamed = false;

    public int a_renamed() {
        return this.f2396a;
    }

    public int b_renamed() {
        return this.f2397b;
    }

    public int c_renamed() {
        return this.g_renamed ? this.f2397b : this.f2396a;
    }

    public int d_renamed() {
        return this.g_renamed ? this.f2396a : this.f2397b;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f2398c = i_renamed;
        this.d_renamed = i2;
        this.h_renamed = true;
        if (this.g_renamed) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2396a = i2;
            }
            if (i_renamed != Integer.MIN_VALUE) {
                this.f2397b = i_renamed;
                return;
            }
            return;
        }
        if (i_renamed != Integer.MIN_VALUE) {
            this.f2396a = i_renamed;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2397b = i2;
        }
    }

    public void b_renamed(int i_renamed, int i2) {
        this.h_renamed = false;
        if (i_renamed != Integer.MIN_VALUE) {
            this.e_renamed = i_renamed;
            this.f2396a = i_renamed;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f_renamed = i2;
            this.f2397b = i2;
        }
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed == this.g_renamed) {
            return;
        }
        this.g_renamed = z_renamed;
        if (!this.h_renamed) {
            this.f2396a = this.e_renamed;
            this.f2397b = this.f_renamed;
            return;
        }
        if (z_renamed) {
            int i_renamed = this.d_renamed;
            if (i_renamed == Integer.MIN_VALUE) {
                i_renamed = this.e_renamed;
            }
            this.f2396a = i_renamed;
            int i2 = this.f2398c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f_renamed;
            }
            this.f2397b = i2;
            return;
        }
        int i3 = this.f2398c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.e_renamed;
        }
        this.f2396a = i3;
        int i4 = this.d_renamed;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f_renamed;
        }
        this.f2397b = i4;
    }
}
