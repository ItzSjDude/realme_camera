package com.oplus.anim.e_renamed;

/* compiled from: ColorParser.java */
/* loaded from: classes2.dex */
public class f_renamed implements com.oplus.anim.e_renamed.aj_renamed<java.lang.Integer> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.anim.e_renamed.f_renamed f3653a = new com.oplus.anim.e_renamed.f_renamed();

    private f_renamed() {
    }

    @Override // com.oplus.anim.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer b_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        boolean z_renamed = jsonReader.peek() == android.util.JsonToken.BEGIN_ARRAY;
        if (z_renamed) {
            jsonReader.beginArray();
        }
        double dNextDouble = jsonReader.nextDouble();
        double dNextDouble2 = jsonReader.nextDouble();
        double dNextDouble3 = jsonReader.nextDouble();
        double dNextDouble4 = jsonReader.nextDouble();
        if (z_renamed) {
            jsonReader.endArray();
        }
        if (dNextDouble <= 1.0d && dNextDouble2 <= 1.0d && dNextDouble3 <= 1.0d && dNextDouble4 <= 1.0d) {
            dNextDouble *= 255.0d;
            dNextDouble2 *= 255.0d;
            dNextDouble3 *= 255.0d;
            dNextDouble4 *= 255.0d;
        }
        return java.lang.Integer.valueOf(android.graphics.Color.argb((int) dNextDouble4, (int) dNextDouble, (int) dNextDouble2, (int) dNextDouble3));
    }
}
