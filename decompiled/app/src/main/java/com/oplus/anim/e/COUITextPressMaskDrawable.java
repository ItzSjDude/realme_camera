package com.oplus.anim.e_renamed;

/* compiled from: JsonUtils.java */
/* loaded from: classes2.dex */
class q_renamed {
    static int a_renamed(android.util.JsonReader jsonReader) throws java.io.IOException {
        jsonReader.beginArray();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return android.graphics.Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    static java.util.List<android.graphics.PointF> a_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == android.util.JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(b_renamed(jsonReader, f_renamed));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* compiled from: JsonUtils.java */
    /* renamed from: com.oplus.anim.e_renamed.q_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f3658a = new int[android.util.JsonToken.values().length];

        static {
            try {
                f3658a[android.util.JsonToken.NUMBER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f3658a[android.util.JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f3658a[android.util.JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    static android.graphics.PointF b_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        int i_renamed = com.oplus.anim.e_renamed.q_renamed.SceneLoader_2.f3658a[jsonReader.peek().ordinal()];
        if (i_renamed == 1) {
            return c_renamed(jsonReader, f_renamed);
        }
        if (i_renamed == 2) {
            return d_renamed(jsonReader, f_renamed);
        }
        if (i_renamed == 3) {
            return e_renamed(jsonReader, f_renamed);
        }
        throw new java.lang.IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    private static android.graphics.PointF c_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new android.graphics.PointF(fNextDouble * f_renamed, fNextDouble2 * f_renamed);
    }

    private static android.graphics.PointF d_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != android.util.JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new android.graphics.PointF(fNextDouble * f_renamed, fNextDouble2 * f_renamed);
    }

    private static android.graphics.PointF e_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        jsonReader.beginObject();
        float fB_renamed = 0.0f;
        float fB2 = 0.0f;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 120) {
                if (iHashCode == 121 && strNextName.equals("y_renamed")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("x_renamed")) {
                c2 = 0;
            }
            if (c2 == 0) {
                fB_renamed = b_renamed(jsonReader);
            } else if (c2 == 1) {
                fB2 = b_renamed(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new android.graphics.PointF(fB_renamed * f_renamed, fB2 * f_renamed);
    }

    static float b_renamed(android.util.JsonReader jsonReader) throws java.io.IOException {
        android.util.JsonToken jsonTokenPeek = jsonReader.peek();
        int i_renamed = com.oplus.anim.e_renamed.q_renamed.SceneLoader_2.f3658a[jsonTokenPeek.ordinal()];
        if (i_renamed == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i_renamed == 2) {
            jsonReader.beginArray();
            float fNextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return fNextDouble;
        }
        throw new java.lang.IllegalArgumentException("Unknown value for token of_renamed type " + jsonTokenPeek);
    }
}
