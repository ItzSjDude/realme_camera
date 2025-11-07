package com.airbnb.lottie.p089e;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.p084c.Font_2;
import com.airbnb.lottie.p084c.FontCharacter_2;
import com.airbnb.lottie.p084c.Marker_2;
import com.airbnb.lottie.p084c.p087c.Layer_4;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.Logger_3;
import com.airbnb.lottie.p091f.Utils_4;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.t */
/* loaded from: classes.dex */
public class LottieCompositionMoshiParser {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5809b = JsonReader.PlatformImplementations.kt_3.m5929a("w", "COUIBaseListPopupWindow_10", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: PlatformImplementations.kt_3 */
    static JsonReader.PlatformImplementations.kt_3 f5808a = JsonReader.PlatformImplementations.kt_3.m5929a(TtmlNode.ATTR_ID, "layers", "w", "COUIBaseListPopupWindow_10", TtmlNode.TAG_P, "u");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5810c = JsonReader.PlatformImplementations.kt_3.m5929a("list");

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final JsonReader.PlatformImplementations.kt_3 f5811d = JsonReader.PlatformImplementations.kt_3.m5929a("cm", "tm", "dr");

    /* renamed from: PlatformImplementations.kt_3 */
    public static LottieComposition m6007a(JsonReader abstractC1149c) throws IOException {
        HashMap map;
        ArrayList arrayList;
        JsonReader abstractC1149c2 = abstractC1149c;
        float fM6139a = Utils_4.m6139a();
        LongSparseArray<Layer_4> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<FontCharacter_2> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition c1136d = new LottieComposition();
        abstractC1149c.mo5917c();
        float fMo5925k = 0.0f;
        float fMo5925k2 = 0.0f;
        float fMo5925k3 = 0.0f;
        int iMo5926l = 0;
        int iMo5926l2 = 0;
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c2.mo5912a(f5809b)) {
                case 0:
                    iMo5926l = abstractC1149c.mo5926l();
                    break;
                case 1:
                    iMo5926l2 = abstractC1149c.mo5926l();
                    break;
                case 2:
                    map = map4;
                    arrayList = arrayList3;
                    fMo5925k = (float) abstractC1149c.mo5925k();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fMo5925k2 = ((float) abstractC1149c.mo5925k()) - 0.01f;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fMo5925k3 = (float) abstractC1149c.mo5925k();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] strArrSplit = abstractC1149c.mo5923i().split("\\.");
                    if (!Utils_4.m6150a(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        c1136d.m5843a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    m6010a(abstractC1149c2, c1136d, arrayList2, longSparseArray);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    m6011a(abstractC1149c2, c1136d, map2, map3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    m6012a(abstractC1149c2, map4);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    m6008a(abstractC1149c2, c1136d, sparseArrayCompat);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    m6009a(abstractC1149c2, c1136d, arrayList3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                default:
                    map = map4;
                    arrayList = arrayList3;
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
            }
            abstractC1149c2 = abstractC1149c;
        }
        c1136d.m5842a(new Rect(0, 0, (int) (iMo5926l * fM6139a), (int) (iMo5926l2 * fM6139a)), fMo5925k, fMo5925k2, fMo5925k3, arrayList2, longSparseArray, map2, map3, sparseArrayCompat, map4, arrayList3);
        return c1136d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m6010a(JsonReader abstractC1149c, LottieComposition c1136d, List<Layer_4> list, LongSparseArray<Layer_4> longSparseArray) throws IOException {
        abstractC1149c.mo5914a();
        int OplusGLSurfaceView_13 = 0;
        while (abstractC1149c.mo5919e()) {
            Layer_4 c1125dM6006a = LayerParser_2.m6006a(abstractC1149c, c1136d);
            if (c1125dM6006a.m5796k() == Layer_4.PlatformImplementations.kt_3.IMAGE) {
                OplusGLSurfaceView_13++;
            }
            list.add(c1125dM6006a);
            longSparseArray.put(c1125dM6006a.m5790e(), c1125dM6006a);
            if (OplusGLSurfaceView_13 > 4) {
                Logger_3.m6100b("You have " + OplusGLSurfaceView_13 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        abstractC1149c.mo5916b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m6011a(JsonReader abstractC1149c, LottieComposition c1136d, Map<String, List<Layer_4>> map, Map<String, LottieImageAsset> map2) throws IOException {
        abstractC1149c.mo5914a();
        while (abstractC1149c.mo5919e()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            abstractC1149c.mo5917c();
            int iMo5926l = 0;
            int iMo5926l2 = 0;
            String strMo5923i = null;
            String strMo5923i2 = null;
            String strMo5923i3 = null;
            while (abstractC1149c.mo5919e()) {
                int iMo5912a = abstractC1149c.mo5912a(f5808a);
                if (iMo5912a == 0) {
                    strMo5923i = abstractC1149c.mo5923i();
                } else if (iMo5912a == 1) {
                    abstractC1149c.mo5914a();
                    while (abstractC1149c.mo5919e()) {
                        Layer_4 c1125dM6006a = LayerParser_2.m6006a(abstractC1149c, c1136d);
                        longSparseArray.put(c1125dM6006a.m5790e(), c1125dM6006a);
                        arrayList.add(c1125dM6006a);
                    }
                    abstractC1149c.mo5916b();
                } else if (iMo5912a == 2) {
                    iMo5926l = abstractC1149c.mo5926l();
                } else if (iMo5912a == 3) {
                    iMo5926l2 = abstractC1149c.mo5926l();
                } else if (iMo5912a == 4) {
                    strMo5923i2 = abstractC1149c.mo5923i();
                } else if (iMo5912a == 5) {
                    strMo5923i3 = abstractC1149c.mo5923i();
                } else {
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                }
            }
            abstractC1149c.mo5918d();
            if (strMo5923i2 != null) {
                LottieImageAsset c1196g = new LottieImageAsset(iMo5926l, iMo5926l2, strMo5923i, strMo5923i2, strMo5923i3);
                map2.put(c1196g.m6160c(), c1196g);
            } else {
                map.put(strMo5923i, arrayList);
            }
        }
        abstractC1149c.mo5916b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m6012a(JsonReader abstractC1149c, Map<String, Font_2> map) throws IOException {
        abstractC1149c.mo5917c();
        while (abstractC1149c.mo5919e()) {
            if (abstractC1149c.mo5912a(f5810c) == 0) {
                abstractC1149c.mo5914a();
                while (abstractC1149c.mo5919e()) {
                    Font_2 c1121cM5981a = FontParser_2.m5981a(abstractC1149c);
                    map.put(c1121cM5981a.m5752b(), c1121cM5981a);
                }
                abstractC1149c.mo5916b();
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m6008a(JsonReader abstractC1149c, LottieComposition c1136d, SparseArrayCompat<FontCharacter_2> sparseArrayCompat) throws IOException {
        abstractC1149c.mo5914a();
        while (abstractC1149c.mo5919e()) {
            FontCharacter_2 c1130dM5980a = FontCharacterParser_2.m5980a(abstractC1149c, c1136d);
            sparseArrayCompat.put(c1130dM5980a.hashCode(), c1130dM5980a);
        }
        abstractC1149c.mo5916b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m6009a(JsonReader abstractC1149c, LottieComposition c1136d, List<Marker_2> list) throws IOException {
        abstractC1149c.mo5914a();
        while (abstractC1149c.mo5919e()) {
            String strMo5923i = null;
            abstractC1149c.mo5917c();
            float fMo5925k = 0.0f;
            float fMo5925k2 = 0.0f;
            while (abstractC1149c.mo5919e()) {
                int iMo5912a = abstractC1149c.mo5912a(f5811d);
                if (iMo5912a == 0) {
                    strMo5923i = abstractC1149c.mo5923i();
                } else if (iMo5912a == 1) {
                    fMo5925k = (float) abstractC1149c.mo5925k();
                } else if (iMo5912a == 2) {
                    fMo5925k2 = (float) abstractC1149c.mo5925k();
                } else {
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                }
            }
            abstractC1149c.mo5918d();
            list.add(new Marker_2(strMo5923i, fMo5925k, fMo5925k2));
        }
        abstractC1149c.mo5916b();
    }
}
