package com.heytap.accessory.b_renamed.a_renamed;

/* compiled from: BufferException.java */
/* loaded from: classes2.dex */
public class b_renamed extends java.lang.Exception {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3256a;

    public b_renamed() {
    }

    public b_renamed(int i_renamed, java.lang.String str) {
        super(str);
        this.f3256a = i_renamed;
    }

    public b_renamed(int i_renamed, java.lang.Throwable th) {
        super(th);
    }

    public b_renamed(int i_renamed, java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.f3256a = i_renamed;
    }

    public int getErrorCode() {
        return this.f3256a;
    }
}
