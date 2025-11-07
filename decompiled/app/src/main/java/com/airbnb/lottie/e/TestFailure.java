package com.airbnb.lottie.e_renamed;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f_renamed implements com.airbnb.lottie.e_renamed.aj_renamed<java.lang.Integer> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.airbnb.lottie.e_renamed.f_renamed f2188a = new com.airbnb.lottie.e_renamed.f_renamed();

    private f_renamed() {
    }

    @Override // com.airbnb.lottie.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        boolean z_renamed = cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY;
        if (z_renamed) {
            cVar.a_renamed();
        }
        double dK_renamed = cVar.k_renamed();
        double dK2 = cVar.k_renamed();
        double dK3 = cVar.k_renamed();
        double dK4 = cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.NUMBER ? cVar.k_renamed() : 1.0d;
        if (z_renamed) {
            cVar.b_renamed();
        }
        if (dK_renamed <= 1.0d && dK2 <= 1.0d && dK3 <= 1.0d) {
            dK_renamed *= 255.0d;
            dK2 *= 255.0d;
            dK3 *= 255.0d;
            if (dK4 <= 1.0d) {
                dK4 *= 255.0d;
            }
        }
        return java.lang.Integer.valueOf(android.graphics.Color.argb((int) dK4, (int) dK_renamed, (int) dK2, (int) dK3));
    }
}
