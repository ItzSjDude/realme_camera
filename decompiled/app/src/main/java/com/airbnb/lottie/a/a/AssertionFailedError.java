package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.List<com.airbnb.lottie.a_renamed.a_renamed.s_renamed> f1993a = new java.util.ArrayList();

    void a_renamed(com.airbnb.lottie.a_renamed.a_renamed.s_renamed sVar) {
        this.f1993a.add(sVar);
    }

    public void a_renamed(android.graphics.Path path) {
        for (int size = this.f1993a.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.f_renamed.h_renamed.a_renamed(path, this.f1993a.get(size));
        }
    }
}
