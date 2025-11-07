package com.airbnb.lottie.p089e;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTextFrame_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTextProperties_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTransform_2;
import com.airbnb.lottie.p084c.p086b.ContentModel_2;
import com.airbnb.lottie.p084c.p087c.Layer_4;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.s */
/* loaded from: classes.dex */
public class LayerParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5804a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "COUIBaseListPopupWindow_10", "ip", "op", "tm", "cl", "hd");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5805b = JsonReader.PlatformImplementations.kt_3.m5929a("IntrinsicsJvm.kt_5", "PlatformImplementations.kt_3");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5806c = JsonReader.PlatformImplementations.kt_3.m5929a("nm");

    /* renamed from: PlatformImplementations.kt_3 */
    public static Layer_4 m6005a(LottieComposition c1136d) {
        Rect rectM5851d = c1136d.m5851d();
        return new Layer_4(Collections.emptyList(), c1136d, "__container", -1L, Layer_4.PlatformImplementations.kt_3.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform_2(), 0, 0, 0, 0.0f, 0.0f, rectM5851d.width(), rectM5851d.height(), null, null, Collections.emptyList(), Layer_4.IntrinsicsJvm.kt_4.NONE, null, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Layer_4 m6006a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        float COUIBaseListPopupWindow_12;
        ArrayList arrayList;
        float f2;
        Layer_4.IntrinsicsJvm.kt_4 bVar = Layer_4.IntrinsicsJvm.kt_4.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        abstractC1149c.mo5917c();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        Layer_4.IntrinsicsJvm.kt_4 bVar2 = bVar;
        int iMo5926l = 0;
        int iMo5926l2 = 0;
        int color = 0;
        int iMo5926l3 = 0;
        int iMo5926l4 = 0;
        boolean zMo5924j = false;
        Layer_4.PlatformImplementations.kt_3 aVar = null;
        String strMo5923i = null;
        AnimatableTransform_2 c1100lM5957a = null;
        AnimatableTextFrame_2 c1098jM5973f = null;
        AnimatableTextProperties_2 c1099kM5955a = null;
        AnimatableFloatValue_2 c1090bM5965a = null;
        float fMo5925k = 0.0f;
        float fMo5925k2 = 0.0f;
        long jMo5926l = -1;
        float fMo5925k3 = 1.0f;
        float fMo5925k4 = 0.0f;
        long jMo5926l2 = 0;
        String strMo5923i2 = null;
        String strMo5923i3 = "UNSET";
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c.mo5912a(f5804a)) {
                case 0:
                    strMo5923i3 = abstractC1149c.mo5923i();
                    break;
                case 1:
                    jMo5926l2 = abstractC1149c.mo5926l();
                    break;
                case 2:
                    strMo5923i = abstractC1149c.mo5923i();
                    break;
                case 3:
                    int iMo5926l5 = abstractC1149c.mo5926l();
                    if (iMo5926l5 < Layer_4.PlatformImplementations.kt_3.UNKNOWN.ordinal()) {
                        aVar = Layer_4.PlatformImplementations.kt_3.values()[iMo5926l5];
                        break;
                    } else {
                        aVar = Layer_4.PlatformImplementations.kt_3.UNKNOWN;
                        break;
                    }
                case 4:
                    jMo5926l = abstractC1149c.mo5926l();
                    break;
                case 5:
                    iMo5926l = (int) (abstractC1149c.mo5926l() * Utils_4.m6139a());
                    break;
                case 6:
                    iMo5926l2 = (int) (abstractC1149c.mo5926l() * Utils_4.m6139a());
                    break;
                case 7:
                    color = Color.parseColor(abstractC1149c.mo5923i());
                    break;
                case 8:
                    c1100lM5957a = AnimatableTransformParser_2.m5957a(abstractC1149c, c1136d);
                    break;
                case 9:
                    int iMo5926l6 = abstractC1149c.mo5926l();
                    if (iMo5926l6 >= Layer_4.IntrinsicsJvm.kt_4.values().length) {
                        c1136d.m5843a("Unsupported matte type: " + iMo5926l6);
                        break;
                    } else {
                        bVar2 = Layer_4.IntrinsicsJvm.kt_4.values()[iMo5926l6];
                        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f5807a[bVar2.ordinal()];
                        if (OplusGLSurfaceView_13 == 1) {
                            c1136d.m5843a("Unsupported matte type: Luma");
                        } else if (OplusGLSurfaceView_13 == 2) {
                            c1136d.m5843a("Unsupported matte type: Luma Inverted");
                        }
                        c1136d.m5841a(1);
                        break;
                    }
                case 10:
                    abstractC1149c.mo5914a();
                    while (abstractC1149c.mo5919e()) {
                        arrayList2.add(MaskParser_2.m6013a(abstractC1149c, c1136d));
                    }
                    c1136d.m5841a(arrayList2.size());
                    abstractC1149c.mo5916b();
                    break;
                case 11:
                    abstractC1149c.mo5914a();
                    while (abstractC1149c.mo5919e()) {
                        ContentModel_2 interfaceC1105bM5977a = ContentModelParser_2.m5977a(abstractC1149c, c1136d);
                        if (interfaceC1105bM5977a != null) {
                            arrayList3.add(interfaceC1105bM5977a);
                        }
                    }
                    abstractC1149c.mo5916b();
                    break;
                case 12:
                    abstractC1149c.mo5917c();
                    while (abstractC1149c.mo5919e()) {
                        int iMo5912a = abstractC1149c.mo5912a(f5805b);
                        if (iMo5912a == 0) {
                            c1098jM5973f = AnimatableValueParser_2.m5973f(abstractC1149c, c1136d);
                        } else if (iMo5912a == 1) {
                            abstractC1149c.mo5914a();
                            if (abstractC1149c.mo5919e()) {
                                c1099kM5955a = AnimatableTextPropertiesParser_2.m5955a(abstractC1149c, c1136d);
                            }
                            while (abstractC1149c.mo5919e()) {
                                abstractC1149c.mo5927m();
                            }
                            abstractC1149c.mo5916b();
                        } else {
                            abstractC1149c.mo5922h();
                            abstractC1149c.mo5927m();
                        }
                    }
                    abstractC1149c.mo5918d();
                    break;
                case 13:
                    abstractC1149c.mo5914a();
                    ArrayList arrayList4 = new ArrayList();
                    while (abstractC1149c.mo5919e()) {
                        abstractC1149c.mo5917c();
                        while (abstractC1149c.mo5919e()) {
                            if (abstractC1149c.mo5912a(f5806c) == 0) {
                                arrayList4.add(abstractC1149c.mo5923i());
                            } else {
                                abstractC1149c.mo5922h();
                                abstractC1149c.mo5927m();
                            }
                        }
                        abstractC1149c.mo5918d();
                    }
                    abstractC1149c.mo5916b();
                    c1136d.m5843a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    fMo5925k3 = (float) abstractC1149c.mo5925k();
                    break;
                case 15:
                    fMo5925k2 = (float) abstractC1149c.mo5925k();
                    break;
                case 16:
                    iMo5926l3 = (int) (abstractC1149c.mo5926l() * Utils_4.m6139a());
                    break;
                case 17:
                    iMo5926l4 = (int) (abstractC1149c.mo5926l() * Utils_4.m6139a());
                    break;
                case 18:
                    fMo5925k = (float) abstractC1149c.mo5925k();
                    break;
                case 19:
                    fMo5925k4 = (float) abstractC1149c.mo5925k();
                    break;
                case 20:
                    c1090bM5965a = AnimatableValueParser_2.m5965a(abstractC1149c, c1136d, false);
                    break;
                case 21:
                    strMo5923i2 = abstractC1149c.mo5923i();
                    break;
                case 22:
                    zMo5924j = abstractC1149c.mo5924j();
                    break;
                default:
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                    break;
            }
        }
        abstractC1149c.mo5918d();
        float f3 = fMo5925k / fMo5925k3;
        float fM5854g = fMo5925k4 / fMo5925k3;
        ArrayList arrayList5 = new ArrayList();
        if (f3 > 0.0f) {
            COUIBaseListPopupWindow_12 = fMo5925k3;
            arrayList = arrayList5;
            arrayList.add(new Keyframe_2(c1136d, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f3)));
            f2 = 0.0f;
        } else {
            COUIBaseListPopupWindow_12 = fMo5925k3;
            arrayList = arrayList5;
            f2 = 0.0f;
        }
        if (fM5854g <= f2) {
            fM5854g = c1136d.m5854g();
        }
        arrayList.add(new Keyframe_2(c1136d, fValueOf, fValueOf, null, f3, Float.valueOf(fM5854g)));
        arrayList.add(new Keyframe_2(c1136d, fValueOf2, fValueOf2, null, fM5854g, Float.valueOf(Float.MAX_VALUE)));
        if (strMo5923i3.endsWith(".ai") || "ai".equals(strMo5923i2)) {
            c1136d.m5843a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer_4(arrayList3, c1136d, strMo5923i3, jMo5926l2, aVar, jMo5926l, strMo5923i, arrayList2, c1100lM5957a, iMo5926l, iMo5926l2, color, COUIBaseListPopupWindow_12, fMo5925k2, iMo5926l3, iMo5926l4, c1098jM5973f, c1099kM5955a, arrayList, bVar2, c1090bM5965a, zMo5924j);
    }

    /* compiled from: LayerParser.java */
    /* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.s$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5807a = new int[Layer_4.IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f5807a[Layer_4.IntrinsicsJvm.kt_4.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5807a[Layer_4.IntrinsicsJvm.kt_4.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
