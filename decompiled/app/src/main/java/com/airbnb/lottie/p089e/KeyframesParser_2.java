package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p080a.p082b.PathKeyframe_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.r */
/* loaded from: classes.dex */
class KeyframesParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    static JsonReader.PlatformImplementations.kt_3 f5803a = JsonReader.PlatformImplementations.kt_3.m5929a("OplusGLSurfaceView_5");

    /* renamed from: PlatformImplementations.kt_3 */
    static <T> List<Keyframe_2<T>> m6003a(JsonReader abstractC1149c, LottieComposition c1136d, float COUIBaseListPopupWindow_12, ValueParser_2<T> interfaceC1161aj, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.STRING) {
            c1136d.m5843a("Lottie doesn't support expressions.");
            return arrayList;
        }
        abstractC1149c.mo5917c();
        while (abstractC1149c.mo5919e()) {
            if (abstractC1149c.mo5912a(f5803a) == 0) {
                if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY) {
                    abstractC1149c.mo5914a();
                    if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.NUMBER) {
                        arrayList.add(KeyframeParser_2.m5999a(abstractC1149c, c1136d, COUIBaseListPopupWindow_12, interfaceC1161aj, false, z));
                    } else {
                        while (abstractC1149c.mo5919e()) {
                            arrayList.add(KeyframeParser_2.m5999a(abstractC1149c, c1136d, COUIBaseListPopupWindow_12, interfaceC1161aj, true, z));
                        }
                    }
                    abstractC1149c.mo5916b();
                } else {
                    arrayList.add(KeyframeParser_2.m5999a(abstractC1149c, c1136d, COUIBaseListPopupWindow_12, interfaceC1161aj, false, z));
                }
            } else {
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
        m6004a(arrayList);
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> void m6004a(List<? extends Keyframe_2<T>> list) {
        int OplusGLSurfaceView_13;
        int size = list.size();
        int i2 = 0;
        while (true) {
            OplusGLSurfaceView_13 = size - 1;
            if (i2 >= OplusGLSurfaceView_13) {
                break;
            }
            Keyframe_2<T> c1197a = list.get(i2);
            i2++;
            Keyframe_2<T> c1197a2 = list.get(i2);
            c1197a.f5900g = Float.valueOf(c1197a2.f5899f);
            if (c1197a.f5895b == null && c1197a2.f5894a != null) {
                c1197a.f5895b = c1197a2.f5894a;
                if (c1197a instanceof PathKeyframe_2) {
                    ((PathKeyframe_2) c1197a).m5605a();
                }
            }
        }
        Keyframe_2<T> c1197a3 = list.get(OplusGLSurfaceView_13);
        if ((c1197a3.f5894a == null || c1197a3.f5895b == null) && list.size() > 1) {
            list.remove(c1197a3);
        }
    }
}
