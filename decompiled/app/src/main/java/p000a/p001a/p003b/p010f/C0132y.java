package p000a.p001a.p003b.p010f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.FaceItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.p005b.C0070g;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0096f;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.y */
/* loaded from: classes.dex */
public class C0132y {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Map<String, List<FaceItem>> f634a = new HashMap();

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.y$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_4 f635a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float[] f636b;
    }

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.y$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public float[][] f637a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float[][] f638b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float[][] f639c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float[][] f640d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public float[][] f641e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public float[][] f642f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public float[][] f643g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public float[][] f644h;

        /* renamed from: OplusGLSurfaceView_13 */
        public float[][] f645i;

        /* renamed from: OplusGLSurfaceView_15 */
        public float[][] f646j;

        /* renamed from: OplusGLSurfaceView_5 */
        public float[][] f647k;

        /* renamed from: OplusGLSurfaceView_14 */
        public float[][] f648l;

        /* renamed from: OplusGLSurfaceView_6 */
        public float[][] f649m;

        /* renamed from: OplusGLSurfaceView_11 */
        public float[] f650n;

        /* renamed from: o */
        public float[][] f651o;

        /* renamed from: p */
        public float[] f652p;

        /* renamed from: q */
        public float[] f653q;

        /* renamed from: r */
        public float[] f654r;

        /* renamed from: s */
        public float[] f655s;

        /* renamed from: t */
        public float[] f656t;

        /* renamed from: u */
        public float[][] f657u;

        /* renamed from: v */
        public float[][] f658v;
    }

    static {
        ArrayList arrayList = new ArrayList();
        FaceItem faceItem = new FaceItem();
        faceItem.markers = new float[][]{new float[]{0.43973213f, 0.48983365f}, new float[]{0.44515306f, 0.5485213f}, new float[]{0.453125f, 0.60489833f}, new float[]{0.46269134f, 0.6621996f}, new float[]{0.47895408f, 0.715342f}, new float[]{0.5041454f, 0.7610906f}, new float[]{0.53348213f, 0.8012939f}, new float[]{0.5660077f, 0.83687615f}, new float[]{0.6029974f, 0.8461183f}, new float[]{0.63998723f, 0.8359519f}, new float[]{0.674426f, 0.79990757f}, new float[]{0.70471936f, 0.7560074f}, new float[]{0.7279974f, 0.7051756f}, new float[]{0.7413903f, 0.6478743f}, new float[]{0.7471301f, 0.58641404f}, new float[]{0.75127554f, 0.5254159f}, new float[]{0.75191325f, 0.46395564f}, new float[]{0.46205357f, 0.43715343f}, new float[]{0.48086736f, 0.41913125f}, new float[]{0.50510204f, 0.41451016f}, new float[]{0.53061223f, 0.42144176f}, new float[]{0.55452806f, 0.435305f}, new float[]{0.6176658f, 0.4292976f}, new float[]{0.64285713f, 0.4108133f}, new float[]{0.6686862f, 0.40064695f}, new float[]{0.69547194f, 0.4029575f}, new float[]{0.71811223f, 0.42051756f}, new float[]{0.5883291f, 0.4801294f}, new float[]{0.58896685f, 0.5207948f}, new float[]{0.58992344f, 0.5623845f}, new float[]{0.5905612f, 0.6044362f}, new float[]{0.5682398f, 0.62569314f}, new float[]{0.58003825f, 0.63308686f}, new float[]{0.59247446f, 0.6390943f}, new float[]{0.60491073f, 0.6321627f}, new float[]{0.61734694f, 0.625231f}, new float[]{0.49330357f, 0.48567468f}, new float[]{0.5098852f, 0.4690388f}, new float[]{0.5315689f, 0.4690388f}, new float[]{0.54751277f, 0.49121997f}, new float[]{0.52965564f, 0.49815157f}, new float[]{0.5089286f, 0.49815157f}, new float[]{0.63297194f, 0.4861368f}, new float[]{0.64859694f, 0.46349353f}, new float[]{0.67091835f, 0.46025878f}, new float[]{0.68813777f, 0.47550833f}, new float[]{0.67315054f, 0.48983365f}, new float[]{0.65242344f, 0.49214417f}, new float[]{0.5385842f, 0.6991682f}, new float[]{0.5567602f, 0.68207026f}, new float[]{0.5778061f, 0.67467654f}, new float[]{0.59470665f, 0.6802218f}, new float[]{0.61065054f, 0.6742144f}, new float[]{0.6345663f, 0.681146f}, new float[]{0.65720665f, 0.6968577f}, new float[]{0.6377551f, 0.73937154f}, new float[]{0.61383927f, 0.7569316f}, new float[]{0.59598213f, 0.7592421f}, new float[]{0.5784439f, 0.7569316f}, new float[]{0.5567602f, 0.73983365f}, new float[]{0.54846936f, 0.70194083f}, new float[]{0.578125f, 0.694085f}, new float[]{0.59502554f, 0.6963956f}, new float[]{0.61160713f, 0.6945471f}, new float[]{0.6470026f, 0.70009243f}, new float[]{0.6122449f, 0.72643256f}, new float[]{0.59502554f, 0.7292052f}, new float[]{0.5784439f, 0.72643256f}};
        faceItem.boundaries = new float[]{0.41390306f, 0.3133087f, 0.35586736f, 0.51571167f};
        arrayList.add(faceItem);
        FaceItem faceItem2 = new FaceItem();
        faceItem2.markers = new float[][]{new float[]{0.16007653f, 0.6012015f}, new float[]{0.16677296f, 0.6603512f}, new float[]{0.17506377f, 0.71626616f}, new float[]{0.18622449f, 0.7703327f}, new float[]{0.20535715f, 0.81654346f}, new float[]{0.23405612f, 0.8521257f}, new float[]{0.2688138f, 0.87939f}, new float[]{0.3067602f, 0.8983364f}, new float[]{0.3421556f, 0.90110904f}, new float[]{0.3721301f, 0.8886322f}, new float[]{0.39445153f, 0.8539741f}, new float[]{0.41358417f, 0.8137708f}, new float[]{0.4276148f, 0.76756006f}, new float[]{0.43686223f, 0.7185767f}, new float[]{0.44228315f, 0.66774493f}, new float[]{0.44579083f, 0.61737525f}, new float[]{0.44387755f, 0.56654346f}, new float[]{0.20376275f, 0.5272643f}, new float[]{0.2244898f, 0.5064695f}, new float[]{0.2484056f, 0.4944547f}, new float[]{0.2755102f, 0.4930684f}, new float[]{0.30038264f, 0.5046211f}, new float[]{0.36033162f, 0.504159f}, new float[]{0.3791454f, 0.48983365f}, new float[]{0.40019134f, 0.48798522f}, new float[]{0.41996172f, 0.49491683f}, new float[]{0.4343112f, 0.5124769f}, new float[]{0.33545917f, 0.55221814f}, new float[]{0.34024236f, 0.58687615f}, new float[]{0.34598213f, 0.6229205f}, new float[]{0.35140306f, 0.6589649f}, new float[]{0.31855866f, 0.6866913f}, new float[]{0.3322704f, 0.6922366f}, new float[]{0.34598213f, 0.69778186f}, new float[]{0.3565051f, 0.6917745f}, new float[]{0.36575255f, 0.6829944f}, new float[]{0.23660715f, 0.564695f}, new float[]{0.2528699f, 0.5457486f}, new float[]{0.27295917f, 0.5457486f}, new float[]{0.28922194f, 0.56561923f}, new float[]{0.27168366f, 0.5716266f}, new float[]{0.2528699f, 0.5720887f}, new float[]{0.3622449f, 0.56146026f}, new float[]{0.37850764f, 0.5397412f}, new float[]{0.39795917f, 0.5383549f}, new float[]{0.41167092f, 0.5554529f}, new float[]{0.39923468f, 0.56561923f}, new float[]{0.38042092f, 0.56608135f}, new float[]{0.27519134f, 0.7592421f}, new float[]{0.30165815f, 0.7389094f}, new float[]{0.32748723f, 0.7292052f}, new float[]{0.34406888f, 0.73243994f}, new float[]{0.35841838f, 0.7268946f}, new float[]{0.37436223f, 0.7319778f}, new float[]{0.38679847f, 0.7504621f}, new float[]{0.37531888f, 0.7823475f}, new float[]{0.35969388f, 0.7966728f}, new float[]{0.34375f, 0.79990757f}, new float[]{0.32716838f, 0.79944545f}, new float[]{0.30165815f, 0.79020333f}, new float[]{0.2844388f, 0.75970423f}, new float[]{0.32780612f, 0.74676526f}, new float[]{0.34406888f, 0.7472274f}, new float[]{0.35841838f, 0.7453789f}, new float[]{0.3778699f, 0.7527726f}, new float[]{0.3577806f, 0.7712569f}, new float[]{0.34311223f, 0.7754159f}, new float[]{0.3268495f, 0.7763401f}};
        faceItem2.boundaries = new float[]{0.16581632f, 0.42791128f, 0.31887755f, 0.4621072f};
        arrayList.add(faceItem2);
        f634a.put("sample_faces.jpg", arrayList);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0096f m652a(Resources resources, Context context, int OplusGLSurfaceView_13, Bitmap bitmap, float COUIBaseListPopupWindow_12) {
        C0096f c0096fM282a;
        C0096f[] c0096fArr = context.faceMasks;
        if (c0096fArr[OplusGLSurfaceView_13] == null) {
            int[] iArr = new int[1];
            int length = iArr.length;
            C0094d c0094d = context.imageTexture;
            C0113f.m480a(length, iArr, 0, 6408, c0094d.f388b, c0094d.f389c);
            int i2 = iArr[0];
            C0094d c0094d2 = context.imageTexture;
            c0096fM282a = C0096f.m282a(C0113f.m486b(i2, 6408, c0094d2.f388b, c0094d2.f389c));
            context.faceMasks[OplusGLSurfaceView_13] = c0096fM282a;
        } else {
            c0096fM282a = c0096fArr[OplusGLSurfaceView_13];
        }
        C0113f.m490b(c0096fM282a, bitmap.getWidth(), bitmap.getHeight());
        GLES20.glBindTexture(3553, c0096fM282a.f387a);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        m656a(resources, context, c0096fM282a, COUIBaseListPopupWindow_12);
        return c0096fM282a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IntrinsicsJvm.kt_4 m653a(float[][] fArr, boolean z, float[] fArr2) {
        if (fArr2 == null) {
            fArr2 = new float[]{1.0f, 1.0f};
        }
        if (z) {
            float[][] fArr3 = new float[fArr.length][];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fArr.length; OplusGLSurfaceView_13++) {
                fArr3[OplusGLSurfaceView_13] = new float[]{(fArr[OplusGLSurfaceView_13][0] * 2.0f) - 1.0f, (fArr[OplusGLSurfaceView_13][1] * 2.0f) - 1.0f};
            }
            fArr = fArr3;
        }
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4();
        bVar.f637a = (float[][]) Arrays.copyOfRange(fArr, 0, 17);
        bVar.f638b = (float[][]) Arrays.copyOfRange(fArr, 27, 31);
        bVar.f639c = (float[][]) Arrays.copyOfRange(fArr, 31, 36);
        bVar.f640d = (float[][]) Arrays.copyOfRange(fArr, 36, 42);
        bVar.f641e = (float[][]) Arrays.copyOfRange(fArr, 42, 48);
        bVar.f642f = (float[][]) Arrays.copyOfRange(fArr, 48, 55);
        bVar.f643g = (float[][]) Arrays.copyOfRange(fArr, 60, 66);
        bVar.f644h = (float[][]) Arrays.copyOfRange(fArr, 54, 61);
        bVar.f645i = (float[][]) Arrays.copyOfRange(fArr, 65, 68);
        float[][] fArr4 = bVar.f639c;
        bVar.f648l = new float[fArr4.length + 1][];
        System.arraycopy(fArr4, 0, bVar.f648l, 0, fArr4.length);
        System.arraycopy(bVar.f638b, 0, bVar.f648l, bVar.f639c.length, 1);
        float[][] fArr5 = bVar.f643g;
        bVar.f647k = new float[fArr5.length + bVar.f645i.length][];
        System.arraycopy(fArr5, 0, bVar.f647k, 0, fArr5.length);
        float[][] fArr6 = bVar.f645i;
        System.arraycopy(fArr6, 0, bVar.f647k, bVar.f643g.length, fArr6.length);
        float[][] fArr7 = bVar.f642f;
        bVar.f646j = new float[fArr7.length + bVar.f644h.length][];
        System.arraycopy(fArr7, 0, bVar.f646j, 0, fArr7.length);
        float[][] fArr8 = bVar.f644h;
        System.arraycopy(fArr8, 0, bVar.f646j, bVar.f642f.length, fArr8.length);
        bVar.f649m = bVar.f646j;
        float[][] fArr9 = bVar.f638b;
        double IntrinsicsJvm.kt_5 = (float) (-Math.atan2(fArr9[0][0] - fArr9[3][0], fArr9[0][1] - fArr9[3][1]));
        float fCos = (float) Math.cos(IntrinsicsJvm.kt_5);
        float fSin = (float) Math.sin(IntrinsicsJvm.kt_5);
        bVar.f650n = new float[]{fCos, fSin};
        float[][] fArr10 = bVar.f637a;
        float[] fArrM661a = m661a(fArr10[0], fArr10[16]);
        bVar.f656t = m660a(C0123p.m583a(bVar.f640d), fSin, fCos);
        bVar.f655s = m660a(C0123p.m583a(bVar.f641e), fSin, fCos);
        float[][] fArr11 = bVar.f647k;
        bVar.f654r = m660a(m661a(fArr11[2], fArr11[6]), fSin, fCos);
        bVar.f653q = m660a(fArrM661a, fSin, fCos);
        bVar.f652p = m660a(bVar.f638b[0], fSin, fCos);
        bVar.f651o = new float[][]{m660a(bVar.f642f[0], fSin, fCos), m660a(bVar.f642f[6], fSin, fCos)};
        float[][] fArr12 = new float[5][];
        float[] fArr13 = {0.0f, 0.0f};
        float COUIBaseListPopupWindow_12 = z ? 30.0f : -30.0f;
        C0123p.m589d(fArr13, fArrM661a, fArr2);
        for (int i2 = 1; i2 < 6; i2++) {
            float[] fArr14 = {0.0f, 0.0f};
            C0123p.m589d(fArr14, bVar.f637a[16], fArr2);
            C0123p.m590e(fArr14, fArr14, fArr13);
            float[] fArrM581a = C0123p.m581a(fArr14, i2 * COUIBaseListPopupWindow_12);
            C0123p.m587b(fArrM581a, fArrM581a, fArr13);
            C0123p.m588c(fArrM581a, fArrM581a, fArr2);
            fArr12[i2 - 1] = fArrM581a;
        }
        float[][] fArr15 = bVar.f637a;
        bVar.f657u = new float[fArr15.length + fArr12.length][];
        System.arraycopy(fArr15, 0, bVar.f657u, 0, fArr15.length);
        System.arraycopy(fArr12, 0, bVar.f657u, bVar.f637a.length, fArr12.length);
        bVar.f658v = new float[fArr12.length + 2][];
        System.arraycopy(bVar.f637a, 16, bVar.f658v, 0, 1);
        System.arraycopy(fArr12, 0, bVar.f658v, 1, fArr12.length);
        System.arraycopy(bVar.f637a, 0, bVar.f658v, fArr12.length + 1, 1);
        return bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<PlatformImplementations.kt_3> m654a(List<FaceItem> list, int OplusGLSurfaceView_13, int i2) {
        ArrayList arrayList = new ArrayList();
        for (FaceItem faceItem : list) {
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
            float[][] fArr = faceItem.markers;
            if (fArr != null) {
                float[][] fArr2 = new float[fArr.length][];
                for (int i3 = 0; i3 < fArr2.length; i3++) {
                    float[][] fArr3 = faceItem.markers;
                    fArr2[i3] = new float[]{fArr3[i3][0] * OplusGLSurfaceView_13, fArr3[i3][1] * i2};
                }
                aVar.f635a = m653a(fArr2, false, new float[]{1.0f, 1.0f});
            }
            float[] fArr4 = faceItem.boundaries;
            if (fArr4 != null) {
                float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
                float f2 = i2;
                aVar.f636b = new float[]{fArr4[0] * COUIBaseListPopupWindow_12, fArr4[1] * f2, fArr4[2] * COUIBaseListPopupWindow_12, fArr4[3] * f2};
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m655a(float COUIBaseListPopupWindow_12, float f2, List<FaceItem> list, Resources resources, Context context) {
        boolean z;
        List<FaceItem> list2 = list;
        Context context2 = context;
        float fMax = Math.max(512.0f / COUIBaseListPopupWindow_12, 512.0f / f2);
        ?? r4 = 0;
        int OplusGLSurfaceView_13 = ((int) (COUIBaseListPopupWindow_12 * fMax)) >> 0;
        int i2 = ((int) (fMax * f2)) >> 0;
        List<PlatformImplementations.kt_3> listM654a = m654a(list2, OplusGLSurfaceView_13, i2);
        C0096f[] c0096fArr = context2.faceMasks;
        if (c0096fArr == null) {
            context2.faceMasks = new C0096f[list.size()];
        } else if (c0096fArr.length < list.size()) {
            C0096f[] c0096fArr2 = new C0096f[list.size()];
            C0096f[] c0096fArr3 = context2.faceMasks;
            System.arraycopy(c0096fArr3, 0, c0096fArr2, 0, c0096fArr3.length);
            context2.faceMasks = c0096fArr2;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int i3 = 0;
        while (i3 < listM654a.size()) {
            PlatformImplementations.kt_3 aVar = listM654a.get(i3);
            float[] fArr = new float[2];
            fArr[r4] = list2.get(i3).boundaries[2];
            fArr[1] = list2.get(i3).boundaries[3];
            float fM584b = C0123p.m584b(fArr);
            Paint paint = new Paint(1);
            canvas.drawColor(Color.argb((int) r4, 255, 255, 255));
            IntrinsicsJvm.kt_4 bVar = aVar.f635a;
            if (bVar != null) {
                m658a(canvas, paint, bVar.f657u, -16777216, (boolean) r4);
                m658a(canvas, paint, aVar.f635a.f646j, -65536, (boolean) r4);
                m658a(canvas, paint, aVar.f635a.f647k, -16711936, (boolean) r4);
                m658a(canvas, paint, aVar.f635a.f640d, -16776961, (boolean) r4);
                m658a(canvas, paint, aVar.f635a.f641e, -16776961, (boolean) r4);
            } else {
                float[] fArr2 = aVar.f636b;
                if (fArr2 != null) {
                    m657a(canvas, paint, fArr2, -16777216);
                }
            }
            boolean z2 = (context2.faceMasks[i3] != null || aVar.f635a == null) ? r4 : true;
            C0096f c0096fM652a = m652a(resources, context2, i3, bitmapCreateBitmap, 0.05f * fM584b);
            if (z2) {
                float[][] fArr3 = context2.distortionVertices;
                int length = fArr3.length;
                C0096f.PlatformImplementations.kt_3 aVar2 = new C0096f.PlatformImplementations.kt_3();
                aVar2.f393a = new int[length];
                aVar2.f394b = new int[length];
                aVar2.f395c = new int[length];
                aVar2.f396d = new int[length];
                aVar2.f397e = new int[length];
                aVar2.f398f = new int[length];
                z = false;
                IntrinsicsJvm.kt_4 bVarM653a = m653a(list2.get(i3).markers, true, new float[]{1.0f, i2 / OplusGLSurfaceView_13});
                float f3 = fM584b * 0.3f;
                for (int i4 = 0; i4 < length; i4++) {
                    float fM572a = C0123p.m572a(fArr3[i4], bVarM653a.f640d);
                    if (fM572a <= f3) {
                        float fMin = 1.0f - Math.min(1.0f, fM572a / f3);
                        aVar2.f393a[i4] = (int) (fMin * fMin * 255.0f);
                    }
                    float fM572a2 = C0123p.m572a(fArr3[i4], bVarM653a.f641e);
                    if (fM572a2 <= f3) {
                        float fMin2 = 1.0f - Math.min(1.0f, fM572a2 / f3);
                        aVar2.f394b[i4] = (int) (fMin2 * fMin2 * 255.0f);
                    }
                    float fM572a3 = C0123p.m572a(fArr3[i4], bVarM653a.f658v);
                    if (fM572a3 <= f3) {
                        float fMin3 = 1.0f - Math.min(1.0f, fM572a3 / f3);
                        aVar2.f395c[i4] = (int) (fMin3 * fMin3 * 255.0f);
                    }
                    float fM572a4 = C0123p.m572a(fArr3[i4], bVarM653a.f637a);
                    if (fM572a4 <= f3) {
                        float fMin4 = 1.0f - Math.min(1.0f, fM572a4 / f3);
                        aVar2.f396d[i4] = (int) (fMin4 * fMin4 * 255.0f);
                    }
                    float fM572a5 = C0123p.m572a(fArr3[i4], bVarM653a.f648l);
                    if (fM572a5 <= f3) {
                        float fMin5 = 1.0f - Math.min(1.0f, fM572a5 / f3);
                        aVar2.f397e[i4] = (int) (fMin5 * fMin5 * 255.0f);
                    }
                    float fM572a6 = C0123p.m572a(fArr3[i4], bVarM653a.f649m);
                    if (fM572a6 <= f3) {
                        float fMin6 = 1.0f - Math.min(1.0f, fM572a6 / f3);
                        aVar2.f398f[i4] = (int) (fMin6 * fMin6 * 255.0f);
                    }
                }
                c0096fM652a.f391e = aVar2;
                c0096fM652a.f392f = bVarM653a;
            } else {
                z = r4;
            }
            i3++;
            list2 = list;
            context2 = context;
            r4 = z;
        }
        bitmapCreateBitmap.recycle();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m656a(Resources resources, Context context, C0094d c0094d, float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 < 0.0f) {
            COUIBaseListPopupWindow_12 = 0.024f;
        }
        int OplusGLSurfaceView_13 = c0094d.f388b;
        int i2 = c0094d.f389c;
        C0094d c0094d2 = context.writableTexture;
        int i3 = c0094d2.f388b;
        int i4 = c0094d2.f389c;
        C0113f.m490b(c0094d2, OplusGLSurfaceView_13, i2);
        C0070g c0070gM227a = C0070g.m227a(resources, context);
        c0070gM227a.f312r = new float[]{0.0f, (OplusGLSurfaceView_13 / i2) * COUIBaseListPopupWindow_12};
        C0097g.m299a(context, c0094d.f387a, context.writableTexture, (AbstractC0008a) c0070gM227a, false);
        c0070gM227a.f312r = new float[]{COUIBaseListPopupWindow_12, 0.0f};
        C0097g.m299a(context, context.writableTexture.f387a, c0094d, (AbstractC0008a) c0070gM227a, false);
        C0113f.m490b(context.writableTexture, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m657a(Canvas canvas, Paint paint, float[] fArr, int OplusGLSurfaceView_13) {
        paint.setColor(OplusGLSurfaceView_13);
        float COUIBaseListPopupWindow_12 = fArr[0];
        float f2 = fArr[1];
        canvas.drawOval(new RectF(COUIBaseListPopupWindow_12, f2, fArr[2] + COUIBaseListPopupWindow_12, fArr[3] + f2), paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m658a(Canvas canvas, Paint paint, float[][] fArr, int OplusGLSurfaceView_13, boolean z) {
        paint.setColor(OplusGLSurfaceView_13);
        float[] fArr2 = fArr[fArr.length - 1];
        Path path = new Path();
        path.moveTo(fArr2[0], fArr2[1]);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            float[] fArr3 = fArr[i2];
            if (fArr3 != null) {
                if (i2 < fArr.length - 1) {
                    int i3 = i2 + 1;
                    path.quadTo(fArr3[0], fArr3[1], fArr[i3][0], fArr[i3][1]);
                } else {
                    path.lineTo(fArr3[0], fArr3[1]);
                }
            }
        }
        canvas.drawPath(path, paint);
        if (z) {
            float[] fArr4 = fArr[0];
            float[] fArr5 = {C0123p.m569a(0.5f, fArr4[0], fArr2[0]), C0123p.m569a(0.5f, fArr4[1], fArr2[1])};
            canvas.save();
            canvas.translate(fArr5[0], fArr5[1]);
            canvas.rotate(3.1415927f);
            canvas.translate(-fArr5[0], -fArr5[1]);
            path.reset();
            path.moveTo(fArr2[0], fArr2[1]);
            for (int i4 = 0; i4 < fArr.length; i4++) {
                float[] fArr6 = fArr[i4];
                if (fArr6 != null) {
                    if (i4 < fArr.length - 1) {
                        int i5 = i4 + 1;
                        path.quadTo(fArr6[0], fArr6[1], fArr[i5][0], fArr[i5][1]);
                    } else {
                        path.lineTo(fArr6[0], fArr6[1]);
                    }
                }
            }
            canvas.drawPath(path, paint);
            canvas.restore();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m659a(List<FaceItem> list, Resources resources, Context context) {
        List<FaceItem> list2 = (List) context.renderStates.get("prevFaces");
        if (list == null || list.isEmpty() || C0123p.m577a(list2, list)) {
            list = list2;
        } else {
            C0094d c0094d = context.imageTexture;
            m655a(c0094d.f388b, c0094d.f389c, list, resources, context);
        }
        context.renderStates.put("prevFaces", list);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m660a(float[] fArr, float COUIBaseListPopupWindow_12, float f2) {
        float f3 = -COUIBaseListPopupWindow_12;
        return new float[]{(fArr[0] * f2) - (fArr[1] * f3), (fArr[0] * f3) + (fArr[1] * f2)};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m661a(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[0] * 0.5f) + (fArr2[0] * 0.5f), (fArr[1] * 0.5f) + (fArr2[1] * 0.5f)};
    }
}
