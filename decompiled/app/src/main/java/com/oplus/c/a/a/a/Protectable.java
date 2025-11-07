package com.oplus.c_renamed.a_renamed.a_renamed.a_renamed;

/* compiled from: BytesBufferPool.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f3740a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f3741b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.ArrayList<com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.c_renamed.a_renamed> f3742c;

    /* compiled from: BytesBufferPool.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public byte[] f3743a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f3744b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f3745c;

        private a_renamed(int i_renamed) {
            this.f3743a = new byte[i_renamed];
        }
    }

    public c_renamed(int i_renamed, int i2) {
        this.f3742c = new java.util.ArrayList<>(i_renamed);
        this.f3740a = i_renamed;
        this.f3741b = i2;
    }

    public synchronized com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.c_renamed.a_renamed a_renamed() {
        int size;
        size = this.f3742c.size();
        return size > 0 ? this.f3742c.remove(size - 1) : new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.c_renamed.a_renamed(this.f3741b);
    }

    public synchronized void a_renamed(com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.c_renamed.a_renamed aVar) {
        if (aVar.f3743a.length != this.f3741b) {
            return;
        }
        if (this.f3742c.size() < this.f3740a) {
            aVar.f3744b = 0;
            aVar.f3745c = 0;
            this.f3742c.add(aVar);
        }
    }

    public synchronized void b_renamed() {
        this.f3742c.clear();
    }
}
