package com.airbnb.lottie.p089e;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableGradientColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p086b.GradientStroke_2;
import com.airbnb.lottie.p084c.p086b.ShapeStroke_5;
import com.airbnb.lottie.p084c.p086b.GradientType_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: GradientStrokeParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
class GradientStrokeParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static JsonReader.PlatformImplementations.kt_3 f5793a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "COUIBaseListPopupWindow_11", "o", "t", "s", "COUIBaseListPopupWindow_8", "w", "lc", "lj", "ml", "hd", "IntrinsicsJvm.kt_5");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5794b = JsonReader.PlatformImplementations.kt_3.m5929a(TtmlNode.TAG_P, "OplusGLSurfaceView_5");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5795c = JsonReader.PlatformImplementations.kt_3.m5929a("OplusGLSurfaceView_11", "v");

    /* renamed from: PlatformImplementations.kt_3 */
    static GradientStroke_2 m5986a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        AnimatableGradientColorValue_2 c1091c;
        ArrayList arrayList = new ArrayList();
        float fMo5925k = 0.0f;
        AnimatableIntegerValue_2 c1092d = null;
        String strMo5923i = null;
        GradientType_2 enumC1109f = null;
        AnimatableGradientColorValue_2 c1091cM5966a = null;
        AnimatablePointValue_2 c1094fM5970c = null;
        AnimatablePointValue_2 c1094fM5970c2 = null;
        AnimatableFloatValue_2 c1090bM5964a = null;
        ShapeStroke_5.PlatformImplementations.kt_3 aVar = null;
        ShapeStroke_5.IntrinsicsJvm.kt_4 bVar = null;
        AnimatableFloatValue_2 c1090b = null;
        boolean zMo5924j = false;
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c.mo5912a(f5793a)) {
                case 0:
                    strMo5923i = abstractC1149c.mo5923i();
                    break;
                case 1:
                    int iMo5926l = -1;
                    abstractC1149c.mo5917c();
                    while (abstractC1149c.mo5919e()) {
                        int iMo5912a = abstractC1149c.mo5912a(f5794b);
                        if (iMo5912a != 0) {
                            c1091c = c1091cM5966a;
                            if (iMo5912a == 1) {
                                c1091cM5966a = AnimatableValueParser_2.m5966a(abstractC1149c, c1136d, iMo5926l);
                            } else {
                                abstractC1149c.mo5922h();
                                abstractC1149c.mo5927m();
                            }
                        } else {
                            c1091c = c1091cM5966a;
                            iMo5926l = abstractC1149c.mo5926l();
                        }
                        c1091cM5966a = c1091c;
                    }
                    abstractC1149c.mo5918d();
                    break;
                case 2:
                    c1092d = AnimatableValueParser_2.m5969b(abstractC1149c, c1136d);
                    break;
                case 3:
                    enumC1109f = abstractC1149c.mo5926l() == 1 ? GradientType_2.LINEAR : GradientType_2.RADIAL;
                    break;
                case 4:
                    c1094fM5970c = AnimatableValueParser_2.m5970c(abstractC1149c, c1136d);
                    break;
                case 5:
                    c1094fM5970c2 = AnimatableValueParser_2.m5970c(abstractC1149c, c1136d);
                    break;
                case 6:
                    c1090bM5964a = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
                    break;
                case 7:
                    aVar = ShapeStroke_5.PlatformImplementations.kt_3.values()[abstractC1149c.mo5926l() - 1];
                    break;
                case 8:
                    bVar = ShapeStroke_5.IntrinsicsJvm.kt_4.values()[abstractC1149c.mo5926l() - 1];
                    break;
                case 9:
                    fMo5925k = (float) abstractC1149c.mo5925k();
                    break;
                case 10:
                    zMo5924j = abstractC1149c.mo5924j();
                    break;
                case 11:
                    abstractC1149c.mo5914a();
                    while (abstractC1149c.mo5919e()) {
                        abstractC1149c.mo5917c();
                        String strMo5923i2 = null;
                        AnimatableFloatValue_2 c1090bM5964a2 = null;
                        while (abstractC1149c.mo5919e()) {
                            int iMo5912a2 = abstractC1149c.mo5912a(f5795c);
                            if (iMo5912a2 != 0) {
                                AnimatableFloatValue_2 c1090b2 = c1090b;
                                if (iMo5912a2 == 1) {
                                    c1090bM5964a2 = AnimatableValueParser_2.m5964a(abstractC1149c, c1136d);
                                } else {
                                    abstractC1149c.mo5922h();
                                    abstractC1149c.mo5927m();
                                }
                                c1090b = c1090b2;
                            } else {
                                strMo5923i2 = abstractC1149c.mo5923i();
                            }
                        }
                        AnimatableFloatValue_2 c1090b3 = c1090b;
                        abstractC1149c.mo5918d();
                        if (strMo5923i2.equals("o")) {
                            c1090b = c1090bM5964a2;
                        } else {
                            if (strMo5923i2.equals("IntrinsicsJvm.kt_5") || strMo5923i2.equals("COUIBaseListPopupWindow_11")) {
                                c1136d.m5844a(true);
                                arrayList.add(c1090bM5964a2);
                            }
                            c1090b = c1090b3;
                        }
                    }
                    AnimatableFloatValue_2 c1090b4 = c1090b;
                    abstractC1149c.mo5916b();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    c1090b = c1090b4;
                    break;
                default:
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                    break;
            }
        }
        if (c1092d == null) {
            c1092d = new AnimatableIntegerValue_2(Collections.singletonList(new Keyframe_2(100)));
        }
        return new GradientStroke_2(strMo5923i, enumC1109f, c1091cM5966a, c1092d, c1094fM5970c, c1094fM5970c2, c1090bM5964a, aVar, bVar, fMo5925k, arrayList, c1090b, zMo5924j);
    }
}
