package com.airbnb.lottie.e_renamed;

/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public class y_renamed implements com.airbnb.lottie.e_renamed.aj_renamed<android.graphics.PointF> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.airbnb.lottie.e_renamed.y_renamed f2218a = new com.airbnb.lottie.e_renamed.y_renamed();

    private y_renamed() {
    }

    @Override // com.airbnb.lottie.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed bVarF = cVar.f_renamed();
        if (bVarF == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY) {
            return com.airbnb.lottie.e_renamed.p_renamed.b_renamed(cVar, f_renamed);
        }
        if (bVarF == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_OBJECT) {
            return com.airbnb.lottie.e_renamed.p_renamed.b_renamed(cVar, f_renamed);
        }
        if (bVarF == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.NUMBER) {
            android.graphics.PointF pointF = new android.graphics.PointF(((float) cVar.k_renamed()) * f_renamed, ((float) cVar.k_renamed()) * f_renamed);
            while (cVar.e_renamed()) {
                cVar.m_renamed();
            }
            return pointF;
        }
        throw new java.lang.IllegalArgumentException("Cannot convert json to point. Next token is_renamed " + bVarF);
    }
}
