package com.airbnb.lottie.p089e;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableGradientColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p086b.GradientFill_2;
import com.airbnb.lottie.p084c.p086b.GradientType_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Collections;

/* compiled from: GradientFillParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
class GradientFillParser_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final JsonReader.PlatformImplementations.kt_3 f5791a = JsonReader.PlatformImplementations.kt_3.m5929a("nm", "COUIBaseListPopupWindow_11", "o", "t", "s", "COUIBaseListPopupWindow_8", "r", "hd");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5792b = JsonReader.PlatformImplementations.kt_3.m5929a(TtmlNode.TAG_P, "OplusGLSurfaceView_5");

    /* renamed from: PlatformImplementations.kt_3 */
    static GradientFill_2 m5985a(JsonReader abstractC1149c, LottieComposition c1136d) throws IOException {
        AnimatableIntegerValue_2 c1092d = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strMo5923i = null;
        GradientType_2 enumC1109f = null;
        AnimatableGradientColorValue_2 c1091cM5966a = null;
        AnimatablePointValue_2 c1094fM5970c = null;
        AnimatablePointValue_2 c1094fM5970c2 = null;
        boolean zMo5924j = false;
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c.mo5912a(f5791a)) {
                case 0:
                    strMo5923i = abstractC1149c.mo5923i();
                    break;
                case 1:
                    int iMo5926l = -1;
                    abstractC1149c.mo5917c();
                    while (abstractC1149c.mo5919e()) {
                        int iMo5912a = abstractC1149c.mo5912a(f5792b);
                        if (iMo5912a == 0) {
                            iMo5926l = abstractC1149c.mo5926l();
                        } else if (iMo5912a == 1) {
                            c1091cM5966a = AnimatableValueParser_2.m5966a(abstractC1149c, c1136d, iMo5926l);
                        } else {
                            abstractC1149c.mo5922h();
                            abstractC1149c.mo5927m();
                        }
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
                    fillType = abstractC1149c.mo5926l() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zMo5924j = abstractC1149c.mo5924j();
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
        return new GradientFill_2(strMo5923i, enumC1109f, fillType, c1091cM5966a, c1092d, c1094fM5970c, c1094fM5970c2, null, null, zMo5924j);
    }
}
