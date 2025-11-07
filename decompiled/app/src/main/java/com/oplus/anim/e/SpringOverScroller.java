package com.oplus.anim.e_renamed;

/* compiled from: PointFParser.java */
/* loaded from: classes2.dex */
public class y_renamed implements com.oplus.anim.e_renamed.aj_renamed<android.graphics.PointF> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.anim.e_renamed.y_renamed f3662a = new com.oplus.anim.e_renamed.y_renamed();

    private y_renamed() {
    }

    @Override // com.oplus.anim.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF b_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        android.util.JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == android.util.JsonToken.BEGIN_ARRAY) {
            return com.oplus.anim.e_renamed.q_renamed.b_renamed(jsonReader, f_renamed);
        }
        if (jsonTokenPeek == android.util.JsonToken.BEGIN_OBJECT) {
            return com.oplus.anim.e_renamed.q_renamed.b_renamed(jsonReader, f_renamed);
        }
        if (jsonTokenPeek == android.util.JsonToken.NUMBER) {
            android.graphics.PointF pointF = new android.graphics.PointF(((float) jsonReader.nextDouble()) * f_renamed, ((float) jsonReader.nextDouble()) * f_renamed);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new java.lang.IllegalArgumentException("Cannot convert json to point. Next token is_renamed " + jsonTokenPeek);
    }
}
