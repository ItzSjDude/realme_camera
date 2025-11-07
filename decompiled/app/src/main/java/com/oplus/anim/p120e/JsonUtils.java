package com.oplus.anim.p120e;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.q */
/* loaded from: classes2.dex */
class JsonUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    static int m9207a(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static List<PointF> m9208a(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(m9210b(jsonReader, COUIBaseListPopupWindow_12));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* compiled from: JsonUtils.java */
    /* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.q$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f10359a = new int[JsonToken.values().length];

        static {
            try {
                f10359a[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10359a[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10359a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static PointF m9210b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f10359a[jsonReader.peek().ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            return m9211c(jsonReader, COUIBaseListPopupWindow_12);
        }
        if (OplusGLSurfaceView_13 == 2) {
            return m9212d(jsonReader, COUIBaseListPopupWindow_12);
        }
        if (OplusGLSurfaceView_13 == 3) {
            return m9213e(jsonReader, COUIBaseListPopupWindow_12);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static PointF m9211c(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(fNextDouble * COUIBaseListPopupWindow_12, fNextDouble2 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static PointF m9212d(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(fNextDouble * COUIBaseListPopupWindow_12, fNextDouble2 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static PointF m9213e(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        jsonReader.beginObject();
        float fM9209b = 0.0f;
        float fM9209b2 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 120) {
                if (iHashCode == 121 && strNextName.equals("y")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("x")) {
                c2 = 0;
            }
            if (c2 == 0) {
                fM9209b = m9209b(jsonReader);
            } else if (c2 == 1) {
                fM9209b2 = m9209b(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(fM9209b * COUIBaseListPopupWindow_12, fM9209b2 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static float m9209b(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f10359a[jsonTokenPeek.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (OplusGLSurfaceView_13 == 2) {
            jsonReader.beginArray();
            float fNextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return fNextDouble;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + jsonTokenPeek);
    }
}
