package com.oplus.anim.c_renamed.a_renamed;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes2.dex */
public class e_renamed implements com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF>> f3553a;

    public e_renamed() {
        this.f3553a = java.util.Collections.singletonList(new com.oplus.anim.g_renamed.c_renamed(new android.graphics.PointF(0.0f, 0.0f)));
    }

    public e_renamed(java.util.List<com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF>> list) {
        this.f3553a = list;
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public java.util.List<com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF>> c_renamed() {
        return this.f3553a;
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public boolean b_renamed() {
        return this.f3553a.size() == 1 && this.f3553a.get(0).e_renamed();
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> a_renamed() {
        if (this.f3553a.get(0).e_renamed()) {
            if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
                com.oplus.anim.f_renamed.f_renamed.b_renamed("AnimatablePathValue.create PointKeyframeAnimation, keyframes is_renamed :" + toString());
            }
            return new com.oplus.anim.a_renamed.b_renamed.j_renamed(this.f3553a);
        }
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("AnimatablePathValue.create PathKeyframeAnimation, keyframes is_renamed :" + toString());
        }
        return new com.oplus.anim.a_renamed.b_renamed.i_renamed(this.f3553a);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!this.f3553a.isEmpty()) {
            sb.append("values=");
            sb.append(java.util.Arrays.toString(this.f3553a.toArray()));
        }
        return sb.toString();
    }
}
