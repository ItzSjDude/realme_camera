package com.oplus.camera;

/* compiled from: MagShellResponseStatus.java */
/* loaded from: classes2.dex */
public class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private byte f5318a = 0;

    public boolean a_renamed() {
        return (this.f5318a & 2) != 0;
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.f5318a = (byte) (this.f5318a | 2);
        } else {
            this.f5318a = (byte) (this.f5318a & (-3));
        }
    }

    public void b_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.f5318a = (byte) (this.f5318a | 8);
        } else {
            this.f5318a = (byte) (this.f5318a & (-9));
        }
    }

    public boolean b_renamed() {
        return (this.f5318a & 4) != 0;
    }

    public void c_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.f5318a = (byte) (this.f5318a | 4);
        } else {
            this.f5318a = (byte) (this.f5318a & (-5));
        }
    }

    public void d_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.f5318a = (byte) (this.f5318a | 1);
        } else {
            this.f5318a = (byte) (this.f5318a & (-2));
        }
    }

    public boolean c_renamed() {
        return (this.f5318a & 16) != 0;
    }

    public void e_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.f5318a = (byte) (this.f5318a | 16);
        } else {
            this.f5318a = (byte) (this.f5318a & (-17));
        }
    }

    public boolean d_renamed() {
        return (this.f5318a & 32) != 0;
    }

    public void f_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.f5318a = (byte) (this.f5318a | 32);
        } else {
            this.f5318a = (byte) (this.f5318a & (-33));
        }
    }

    public boolean e_renamed() {
        return (!a_renamed() || c_renamed() || d_renamed()) ? false : true;
    }

    public void f_renamed() {
        this.f5318a = (byte) 0;
    }

    public boolean g_renamed() {
        byte b2 = this.f5318a;
        return (b2 & 1) != 0 && (b2 & 12) == 0;
    }

    public java.lang.String toString() {
        return java.lang.String.format(java.util.Locale.getDefault(), "MagShellResponseStatus: 0x%x_renamed.", java.lang.Byte.valueOf(this.f5318a));
    }
}
