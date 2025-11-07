package com.oplus.camera.ui.beauty3d;

/* compiled from: Beauty3DEditStack.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.Stack<com.oplus.camera.ui.beauty3d.b_renamed> f5903a = new java.util.Stack<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.Stack<com.oplus.camera.ui.beauty3d.b_renamed> f5904b = new java.util.Stack<>();

    public com.oplus.camera.ui.beauty3d.b_renamed a_renamed() {
        if (this.f5903a.size() < 0) {
            return null;
        }
        return this.f5903a.pop();
    }

    public com.oplus.camera.ui.beauty3d.b_renamed b_renamed() {
        if (this.f5904b.size() < 0) {
            return null;
        }
        return this.f5904b.pop();
    }

    public com.oplus.camera.ui.beauty3d.b_renamed a_renamed(com.oplus.camera.ui.beauty3d.b_renamed bVar) {
        return this.f5903a.push(bVar);
    }

    public com.oplus.camera.ui.beauty3d.b_renamed b_renamed(com.oplus.camera.ui.beauty3d.b_renamed bVar) {
        return this.f5904b.push(bVar);
    }

    public int c_renamed() {
        return this.f5903a.size();
    }

    public int d_renamed() {
        return this.f5904b.size();
    }

    public void e_renamed() {
        while (!this.f5904b.isEmpty()) {
            this.f5904b.pop();
        }
    }

    public void f_renamed() {
        while (!this.f5903a.isEmpty()) {
            this.f5903a.pop();
        }
        while (!this.f5904b.isEmpty()) {
            this.f5904b.pop();
        }
    }
}
