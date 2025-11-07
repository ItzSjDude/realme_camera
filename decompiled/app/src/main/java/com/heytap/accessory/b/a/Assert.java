package com.heytap.accessory.b_renamed.a_renamed;

/* compiled from: Buffer.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final byte[] f3254b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f3255c;

    /* renamed from: a_renamed, reason: collision with root package name */
    boolean f3253a = false;
    private int e_renamed = 0;
    private int d_renamed = 0;

    a_renamed(byte[] bArr, int i_renamed) {
        this.f3254b = bArr;
        this.f3255c = i_renamed;
    }

    public synchronized byte[] a_renamed() {
        if (this.f3253a) {
            throw new java.lang.IllegalStateException("Cannot refer to a_renamed recycled buffer!");
        }
        return this.f3254b;
    }

    public synchronized int b_renamed() {
        if (this.f3253a) {
            throw new java.lang.IllegalStateException("Cannot refer to a_renamed recycled buffer!");
        }
        return this.d_renamed;
    }

    public synchronized void a_renamed(int i_renamed) {
        if (this.f3253a) {
            throw new java.lang.IllegalStateException("Cannot refer to a_renamed recycled buffer!");
        }
        this.d_renamed = i_renamed;
    }

    public synchronized int c_renamed() {
        if (this.f3253a) {
            throw new java.lang.IllegalStateException("Cannot refer to a_renamed recycled buffer!");
        }
        return this.e_renamed;
    }

    public synchronized boolean d_renamed() {
        if (this.f3253a) {
            return false;
        }
        this.f3253a = com.heytap.accessory.b_renamed.a_renamed.e_renamed.a_renamed(this.f3254b);
        return this.f3253a;
    }

    public synchronized void a_renamed(byte[] bArr, int i_renamed, int i2) throws com.heytap.accessory.b_renamed.a_renamed.b_renamed {
        if (this.f3253a) {
            throw new java.lang.IllegalStateException("Failed to extract from a_renamed recycled buffer!");
        }
        if (this.d_renamed + this.e_renamed + i2 > this.f3255c) {
            throw new com.heytap.accessory.b_renamed.a_renamed.b_renamed(-2, "Cannot extract from byte[]. Buffer length exceeded! [buff offset=" + this.d_renamed + "; payload len=" + this.e_renamed + "; length to write = " + i2 + "; buff len = " + this.f3255c + "]");
        }
        com.heytap.accessory.b_renamed.i_renamed.a_renamed(bArr, i_renamed, this.f3254b, this.d_renamed + this.e_renamed, i2);
        this.e_renamed += i2;
    }

    public java.lang.String toString() {
        return "Buffer{data=" + java.util.Arrays.toString(this.f3254b) + ", length=" + this.f3255c + ", offset=" + this.d_renamed + ", payloadLength=" + this.e_renamed + ", isRecycled=" + this.f3253a + '}';
    }
}
