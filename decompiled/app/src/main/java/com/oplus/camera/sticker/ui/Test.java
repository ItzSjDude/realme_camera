package com.oplus.camera.sticker.ui;

/* compiled from: ImageTagInfo.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.ui.b_renamed f5518a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.drawable.Drawable f5519b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f5520c = null;
    private boolean d_renamed = false;
    private boolean e_renamed = false;
    private int f_renamed = 0;

    public com.oplus.camera.sticker.ui.b_renamed a_renamed() {
        return this.f5518a;
    }

    public void a_renamed(com.oplus.camera.sticker.ui.b_renamed bVar) {
        this.f5518a = bVar;
    }

    public android.graphics.drawable.Drawable b_renamed() {
        return this.f5519b;
    }

    public java.lang.String c_renamed() {
        return this.f5520c;
    }

    public void a_renamed(java.lang.String str) {
        this.f5520c = str;
    }

    public boolean d_renamed() {
        return this.d_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public boolean e_renamed() {
        return this.e_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    public int f_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        a_renamed(sb, "mDrawable", this.f5519b);
        a_renamed(sb, "mStickerUUID", this.f5520c);
        a_renamed(sb, "mbStickerNew", java.lang.Boolean.valueOf(this.d_renamed));
        a_renamed(sb, "mbHasMusic", java.lang.Boolean.valueOf(this.e_renamed));
        a_renamed(sb, "mState", java.lang.Integer.valueOf(this.f_renamed));
        return sb.toString();
    }

    private void a_renamed(java.lang.StringBuilder sb, java.lang.String str, java.lang.Object obj) {
        if (sb != null) {
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(", ");
        }
    }
}
