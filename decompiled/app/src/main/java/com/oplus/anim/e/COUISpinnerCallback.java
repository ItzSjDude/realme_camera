package com.oplus.anim.e_renamed;

/* compiled from: IntegerParser.java */
/* loaded from: classes2.dex */
public class p_renamed implements com.oplus.anim.e_renamed.aj_renamed<java.lang.Integer> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.anim.e_renamed.p_renamed f3657a = new com.oplus.anim.e_renamed.p_renamed();

    private p_renamed() {
    }

    @Override // com.oplus.anim.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer b_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        return java.lang.Integer.valueOf(java.lang.Math.round(com.oplus.anim.e_renamed.q_renamed.b_renamed(jsonReader) * f_renamed));
    }
}
