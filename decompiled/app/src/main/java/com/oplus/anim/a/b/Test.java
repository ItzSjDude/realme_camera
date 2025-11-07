package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.anim.a_renamed.b_renamed.f_renamed<com.oplus.anim.c_renamed.b_renamed.c_renamed> {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.b_renamed.c_renamed f3501c;

    public d_renamed(java.util.List<com.oplus.anim.g_renamed.c_renamed<com.oplus.anim.c_renamed.b_renamed.c_renamed>> list) {
        super(list);
        com.oplus.anim.c_renamed.b_renamed.c_renamed cVar = list.get(0).f3704a;
        int iC = cVar != null ? cVar.c_renamed() : 0;
        this.f3501c = new com.oplus.anim.c_renamed.b_renamed.c_renamed(new float[iC], new int[iC]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.anim.c_renamed.b_renamed.c_renamed a_renamed(com.oplus.anim.g_renamed.c_renamed<com.oplus.anim.c_renamed.b_renamed.c_renamed> cVar, float f_renamed) {
        this.f3501c.a_renamed(cVar.f3704a, cVar.d_renamed, f_renamed);
        return this.f3501c;
    }
}
