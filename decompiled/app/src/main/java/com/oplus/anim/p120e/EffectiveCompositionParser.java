package com.oplus.anim.p120e;

import android.util.JsonReader;
import android.util.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.EffectiveImageAsset;
import com.oplus.anim.L;
import com.oplus.anim.p115c.Font;
import com.oplus.anim.p115c.FontCharacter;
import com.oplus.anim.p115c.Marker;
import com.oplus.anim.p115c.p118c.Layer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: EffectiveCompositionParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class EffectiveCompositionParser {
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[PHI: r18
      0x00de: PHI (r18v16 float) = 
      (r18v2 float)
      (r18v3 float)
      (r18v4 float)
      (r18v5 float)
      (r18v6 float)
      (r18v7 float)
      (r18v8 float)
      (r18v9 float)
      (r18v10 float)
      (r18v11 float)
      (r18v12 float)
      (r18v17 float)
     binds: [B:39:0x00da, B:36:0x00ce, B:33:0x00c1, B:30:0x00b5, B:27:0x00a9, B:24:0x009d, B:21:0x0090, B:18:0x0084, B:15:0x0076, B:12:0x0068, B:9:0x005a, B:7:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.anim.EffectiveAnimationComposition m9192a(android.util.JsonReader r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.p120e.EffectiveCompositionParser.m9192a(android.util.JsonReader):com.oplus.anim.PlatformImplementations.kt_3");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m9195a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int OplusGLSurfaceView_13 = 0;
        while (jsonReader.hasNext()) {
            Layer c2350dM9222a = LayerParser.m9222a(jsonReader, c2272a);
            if (c2350dM9222a.m9103k() == Layer.PlatformImplementations.kt_3.IMAGE) {
                OplusGLSurfaceView_13++;
            }
            list.add(c2350dM9222a);
            longSparseArray.put(c2350dM9222a.m9097e(), c2350dM9222a);
            if (OplusGLSurfaceView_13 > 4) {
                L.m9348b("You have " + OplusGLSurfaceView_13 + " images. EffectiveAnimation should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m9196a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, Map<String, List<Layer>> map, Map<String, EffectiveImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                char c2 = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -1109732030) {
                    if (iHashCode != 104) {
                        if (iHashCode != 112) {
                            if (iHashCode != 117) {
                                if (iHashCode != 119) {
                                    if (iHashCode == 3355 && strNextName.equals(TtmlNode.ATTR_ID)) {
                                        c2 = 0;
                                    }
                                } else if (strNextName.equals("w")) {
                                    c2 = 2;
                                }
                            } else if (strNextName.equals("u")) {
                                c2 = 5;
                            }
                        } else if (strNextName.equals(TtmlNode.TAG_P)) {
                            c2 = 4;
                        }
                    } else if (strNextName.equals("COUIBaseListPopupWindow_10")) {
                        c2 = 3;
                    }
                } else if (strNextName.equals("layers")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    strNextString = jsonReader.nextString();
                } else if (c2 == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer c2350dM9222a = LayerParser.m9222a(jsonReader, c2272a);
                        longSparseArray.put(c2350dM9222a.m9097e(), c2350dM9222a);
                        arrayList.add(c2350dM9222a);
                    }
                    jsonReader.endArray();
                } else if (c2 == 2) {
                    iNextInt = jsonReader.nextInt();
                } else if (c2 == 3) {
                    iNextInt2 = jsonReader.nextInt();
                } else if (c2 == 4) {
                    strNextString2 = jsonReader.nextString();
                } else if (c2 == 5) {
                    strNextString3 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                EffectiveImageAsset c2416h = new EffectiveImageAsset(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(c2416h.m9340a(), c2416h);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m9197a(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            if (strNextName.hashCode() == 3322014 && strNextName.equals("list")) {
                c2 = 0;
            }
            if (c2 == 0) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font c2355dM9200a = FontParser.m9200a(jsonReader);
                    map.put(c2355dM9200a.m9128b(), c2355dM9200a);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m9193a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter c2356eM9199a = FontCharacterParser.m9199a(jsonReader, c2272a);
            sparseArrayCompat.put(c2356eM9199a.hashCode(), c2356eM9199a);
        }
        jsonReader.endArray();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m9194a(JsonReader jsonReader, EffectiveAnimationComposition c2272a, List<Marker> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String strNextString = null;
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                char c2 = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3178) {
                    if (iHashCode != 3214) {
                        if (iHashCode == 3705 && strNextName.equals("tm")) {
                            c2 = 1;
                        }
                    } else if (strNextName.equals("dr")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals("cm")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    strNextString = jsonReader.nextString();
                } else if (c2 == 1) {
                    fNextDouble = (float) jsonReader.nextDouble();
                } else if (c2 == 2) {
                    fNextDouble2 = (float) jsonReader.nextDouble();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            list.add(new Marker(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
