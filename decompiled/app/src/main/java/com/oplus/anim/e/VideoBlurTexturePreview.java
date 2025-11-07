package com.oplus.anim.e_renamed;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes2.dex */
public class ac_renamed implements com.oplus.anim.e_renamed.aj_renamed<com.oplus.anim.g_renamed.d_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.anim.e_renamed.ac_renamed f3651a = new com.oplus.anim.e_renamed.ac_renamed();

    private ac_renamed() {
    }

    @Override // com.oplus.anim.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.anim.g_renamed.d_renamed b_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        boolean z_renamed = jsonReader.peek() == android.util.JsonToken.BEGIN_ARRAY;
        if (z_renamed) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z_renamed) {
            jsonReader.endArray();
        }
        return new com.oplus.anim.g_renamed.d_renamed((fNextDouble / 100.0f) * f_renamed, (fNextDouble2 / 100.0f) * f_renamed);
    }
}
