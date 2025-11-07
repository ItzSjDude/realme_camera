package com.oplus.anim.c_renamed.a_renamed;

/* compiled from: AnimatableTransform.java */
/* loaded from: classes2.dex */
public class l_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.e_renamed f3559a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> f3560b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.g_renamed f3561c;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed d_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.d_renamed e_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed g_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed h_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed i_renamed;

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        return null;
    }

    public l_renamed() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public l_renamed(com.oplus.anim.c_renamed.a_renamed.e_renamed eVar, com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar, com.oplus.anim.c_renamed.a_renamed.g_renamed gVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar, com.oplus.anim.c_renamed.a_renamed.d_renamed dVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar2, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar3, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar4, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar5) {
        this.f3559a = eVar;
        this.f3560b = mVar;
        this.f3561c = gVar;
        this.d_renamed = bVar;
        this.e_renamed = dVar;
        this.h_renamed = bVar2;
        this.i_renamed = bVar3;
        this.f_renamed = bVar4;
        this.g_renamed = bVar5;
    }

    public com.oplus.anim.c_renamed.a_renamed.e_renamed a_renamed() {
        return this.f3559a;
    }

    public com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> b_renamed() {
        return this.f3560b;
    }

    public com.oplus.anim.c_renamed.a_renamed.g_renamed c_renamed() {
        return this.f3561c;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed d_renamed() {
        return this.d_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.d_renamed e_renamed() {
        return this.e_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed f_renamed() {
        return this.h_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed g_renamed() {
        return this.i_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed h_renamed() {
        return this.f_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed i_renamed() {
        return this.g_renamed;
    }

    public com.oplus.anim.a_renamed.b_renamed.o_renamed j_renamed() {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("AnimatableTransform create TransformKeyframeAnimation, " + k_renamed());
        }
        return new com.oplus.anim.a_renamed.b_renamed.o_renamed(this);
    }

    private java.lang.String k_renamed() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("AnimatableTransform:{");
        if (this.f3559a != null) {
            sb.append("anchorPoint = ");
            sb.append(this.f3559a.toString());
        }
        if (this.f3561c != null) {
            sb.append("scale = ");
            sb.append(this.f3561c.toString());
        }
        if (this.d_renamed != null) {
            sb.append("rotation = ");
            sb.append(this.d_renamed.toString());
        }
        if (this.e_renamed != null) {
            sb.append("opacity = ");
            sb.append(this.e_renamed.toString());
        }
        if (this.f_renamed != null) {
            sb.append("skew = ");
            sb.append(this.f_renamed.toString());
        }
        if (this.g_renamed != null) {
            sb.append("skewAngle = ");
            sb.append(this.g_renamed.toString());
        }
        if (this.h_renamed != null) {
            sb.append("startOpacity = ");
            sb.append(this.h_renamed.toString());
        }
        if (this.i_renamed != null) {
            sb.append("endOpacity = ");
            sb.append(this.i_renamed.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
