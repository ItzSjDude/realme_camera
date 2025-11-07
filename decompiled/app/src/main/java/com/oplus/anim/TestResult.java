package com.oplus.anim;

/* compiled from: EffectiveImageAsset.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f3709a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f3710b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f3711c;
    private final java.lang.String d_renamed;
    private final java.lang.String e_renamed;
    private android.graphics.Bitmap f_renamed;

    public h_renamed(int i_renamed, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f3709a = i_renamed;
        this.f3710b = i2;
        this.f3711c = str;
        this.d_renamed = str2;
        this.e_renamed = str3;
    }

    public java.lang.String a_renamed() {
        return this.f3711c;
    }

    public java.lang.String b_renamed() {
        return this.d_renamed;
    }

    public android.graphics.Bitmap c_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2 = this.f_renamed;
        if (bitmap2 != null && bitmap == null) {
            bitmap2.recycle();
        }
        this.f_renamed = bitmap;
    }
}
