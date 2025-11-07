package com.oplus.camera.gl_renamed;

/* compiled from: IntArray.java */
/* loaded from: classes2.dex */
public class o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int[] f4642a = new int[8];

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4643b = 0;

    public void a_renamed(int i_renamed) {
        int[] iArr = this.f4642a;
        int length = iArr.length;
        int i2 = this.f4643b;
        if (length == i2) {
            int[] iArr2 = new int[i2 + i2];
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f4642a = iArr2;
        }
        int[] iArr3 = this.f4642a;
        int i3 = this.f4643b;
        this.f4643b = i3 + 1;
        iArr3[i3] = i_renamed;
    }

    public int a_renamed() {
        this.f4643b--;
        return this.f4642a[this.f4643b];
    }

    public int b_renamed() {
        return this.f4643b;
    }

    public int[] c_renamed() {
        return this.f4642a;
    }

    public void d_renamed() {
        for (int i_renamed = 0; i_renamed < this.f4643b; i_renamed++) {
            this.f4642a[i_renamed] = 0;
        }
        this.f4643b = 0;
        if (this.f4642a.length != 8) {
            this.f4642a = new int[8];
        }
    }
}
