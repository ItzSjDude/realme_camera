package p000a.p001a.p003b.p010f;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.text.TextPaint;
import co.polarr.renderer.entities.TextItem;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.v */
/* loaded from: classes.dex */
public class C0129v {

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.v$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public float f591a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float f592b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String[] f593c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Float[] f594d;
    }

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.v$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public float f595a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public RectF f596b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float f597c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float f598d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public float f599e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public float f600f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public float[] f601g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public float[] f602h;

        /* renamed from: OplusGLSurfaceView_13 */
        public TextItem f603i;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f604j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m614a(Canvas canvas, Paint paint, String str, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, String str2) {
        if (str.isEmpty()) {
            return 0.0f;
        }
        while (true) {
            String strSubstring = str.substring(0, 1);
            str = str.substring(1);
            canvas.drawText(strSubstring, COUIBaseListPopupWindow_12, paint.getFontMetrics().descent + f2, paint);
            float fM615a = str.isEmpty() ? 0.0f : m615a(str, paint);
            COUIBaseListPopupWindow_12 += (f3 - fM615a) + f4;
            if (str.isEmpty()) {
                return COUIBaseListPopupWindow_12;
            }
            f3 = fM615a;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m615a(String str, Paint paint) {
        return paint.measureText(str, 0, str.length());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0094d m616a(Context context, AssetManager assetManager, TextItem textItem, co.polarr.renderer.entities.Context context2, C0094d c0094d) {
        int OplusGLSurfaceView_13;
        if (c0094d != null) {
            GLES20.glBindTexture(3553, c0094d.f387a);
            OplusGLSurfaceView_13 = 0;
        } else {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            C0097g.m306c(iArr[0]);
            GLES20.glBindTexture(3553, iArr[0]);
            OplusGLSurfaceView_13 = iArr[0];
        }
        GLES20.glPixelStorei(3317, 1);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        Bitmap bitmapM619a = m619a(context, assetManager, textItem, context2);
        GLUtils.texImage2D(3553, 0, 6408, bitmapM619a, 0);
        if (c0094d == null) {
            c0094d = C0113f.m486b(OplusGLSurfaceView_13, 6408, bitmapM619a.getWidth(), bitmapM619a.getHeight());
        } else {
            c0094d.f388b = bitmapM619a.getWidth();
            c0094d.f389c = bitmapM619a.getHeight();
        }
        bitmapM619a.recycle();
        return c0094d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PlatformImplementations.kt_3 m617a(Context context, AssetManager assetManager, TextItem textItem, IntrinsicsJvm.kt_4 bVar) {
        RectF rectF = bVar.f596b;
        float COUIBaseListPopupWindow_12 = bVar.f600f;
        float f2 = bVar.f598d;
        float f3 = bVar.f595a;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(C0111d.m470a(context, assetManager, textItem, bVar.f604j));
        textPaint.setTextSize(bVar.f597c);
        String[] strArrM623a = m623a(context, assetManager, textItem.text.replaceAll("/ +$/COUIBaseListPopupWindow_11", ""), bVar);
        ArrayList arrayList = new ArrayList();
        float fMax = 0.0f;
        for (String str : strArrM623a) {
            float fM615a = m615a(str, textPaint);
            fMax = Math.max(fMax, (r7.length() * COUIBaseListPopupWindow_12) + fM615a);
            arrayList.add(Float.valueOf(fM615a));
        }
        float length = strArrM623a.length;
        float f4 = rectF.bottom;
        if (f3 > 0.0f) {
            fMax = Math.max(fMax, f3);
        }
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
        aVar.f591a = fMax;
        aVar.f592b = (f2 * length) + f4;
        aVar.f593c = strArrM623a;
        aVar.f594d = (Float[]) arrayList.toArray(new Float[arrayList.size()]);
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p003b.p010f.C0129v.IntrinsicsJvm.kt_4 m618a(android.content.Context r9, android.content.res.AssetManager r10, co.polarr.renderer.entities.TextItem r11, int r12) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p010f.C0129v.m618a(android.content.Context, android.content.res.AssetManager, co.polarr.renderer.entities.TextItem, int):PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.v$IntrinsicsJvm.kt_4");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m619a(Context context, AssetManager assetManager, TextItem textItem, co.polarr.renderer.entities.Context context2) {
        float COUIBaseListPopupWindow_12;
        float f2;
        Bitmap bitmap;
        float f3;
        Canvas canvas;
        float f4;
        Float[] fArr;
        float f5;
        IntrinsicsJvm.kt_4 bVarM618a = m618a(context, assetManager, textItem, context2.imageTexture.f388b);
        RectF rectF = bVarM618a.f596b;
        float f6 = bVarM618a.f600f;
        float f7 = bVarM618a.f598d;
        float[] fArr2 = bVarM618a.f601g;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(C0111d.m470a(context, assetManager, textItem, bVarM618a.f604j));
        textPaint.setTextSize(bVarM618a.f597c);
        PlatformImplementations.kt_3 aVarM617a = m617a(context, assetManager, textItem, bVarM618a);
        String[] strArr = aVarM617a.f593c;
        Float[] fArr3 = aVarM617a.f594d;
        float f8 = aVarM617a.f591a;
        float f9 = aVarM617a.f592b;
        float f10 = (int) (rectF.left + f8 + rectF.right);
        float f11 = (int) f9;
        float fMax = Math.max(fArr2[0] * f10, fArr2[1] * f11);
        float fMin = Math.min(fMax, 2048) / fMax;
        float[] fArr4 = {Math.abs(fArr2[0] * fMin), Math.abs(fMin * fArr2[1])};
        int OplusGLSurfaceView_13 = (int) (f10 * fArr4[0]);
        int i2 = (int) (f11 * fArr4[1]);
        if (OplusGLSurfaceView_13 == 0 || i2 == 0) {
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        canvas2.scale(fArr4[0], fArr4[1]);
        float f12 = rectF.left;
        float length = ((f9 / 2.0f) - (((strArr.length - 1) * f7) / 2.0f)) - (rectF.bottom / 2.0f);
        float[] fArr5 = bVarM618a.f602h;
        Bitmap bitmap2 = bitmapCreateBitmap;
        textPaint.setColor(Color.argb((int) (fArr5[3] * 255.0f), (int) (fArr5[0] * 255.0f), (int) (fArr5[1] * 255.0f), (int) (fArr5[2] * 255.0f)));
        String str = textItem.type;
        if (str != null && str.equalsIgnoreCase("artwork")) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            length += fontMetrics.descent - fontMetrics.leading;
        }
        if (textItem.mode.equals("outline")) {
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(bVarM618a.f599e);
        } else {
            textPaint.setStyle(Paint.Style.FILL);
        }
        if (!textItem.align.equals("justify")) {
            float f13 = length;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str2 = strArr[i3];
                float fFloatValue = fArr3[i3].floatValue();
                float length2 = f8 - (str2.length() * f6);
                String str3 = textItem.align;
                char c2 = 65535;
                int iHashCode = str3.hashCode();
                if (iHashCode != -1364013995) {
                    if (iHashCode == 108511772 && str3.equals(TtmlNode.RIGHT)) {
                        c2 = 0;
                    }
                } else if (str3.equals(TtmlNode.CENTER)) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    COUIBaseListPopupWindow_12 = (f12 + length2) - fFloatValue;
                } else if (c2 != 1) {
                    f2 = f12;
                    m614a(canvas2, textPaint, str2, f2, f13 + (i3 * f7), fFloatValue, f6, textItem.mode);
                } else {
                    COUIBaseListPopupWindow_12 = f12 + ((length2 - fFloatValue) / 2.0f);
                }
                f2 = COUIBaseListPopupWindow_12;
                m614a(canvas2, textPaint, str2, f2, f13 + (i3 * f7), fFloatValue, f6, textItem.mode);
            }
            return bitmap2;
        }
        int i4 = 0;
        while (i4 < strArr.length) {
            String str4 = strArr[i4];
            float length3 = f8 - (str4.length() * f6);
            float f14 = length + (i4 * f7);
            if (fArr3[i4].floatValue() < length3) {
                String[] strArrSplit = str4.split("/\\s/COUIBaseListPopupWindow_11");
                float[] fArrM622a = m622a(strArrSplit, textPaint);
                float f15 = 0.0f;
                for (float f16 : fArrM622a) {
                    f15 += f16;
                }
                float length4 = (length3 - f15) / (strArrSplit.length - 1);
                float f17 = f12;
                int i5 = 0;
                while (i5 < strArrSplit.length) {
                    float fM614a = m614a(canvas2, textPaint, strArrSplit[i5], f17, f14, fArrM622a[i5], f6, textItem.mode);
                    i5++;
                    fArr3 = fArr3;
                    canvas2 = canvas2;
                    fArrM622a = fArrM622a;
                    f8 = f8;
                    f12 = f12;
                    length = length;
                    f17 = fM614a + length4 + f6;
                }
                bitmap = bitmap2;
                f3 = length;
                canvas = canvas2;
                f4 = f8;
                fArr = fArr3;
                f5 = f12;
            } else {
                bitmap = bitmap2;
                f3 = length;
                canvas = canvas2;
                f4 = f8;
                fArr = fArr3;
                f5 = f12;
                m614a(canvas, textPaint, str4, f5, f14, fArr[i4].floatValue(), f6, textItem.mode);
            }
            i4++;
            length = f3;
            bitmap2 = bitmap;
            fArr3 = fArr;
            canvas2 = canvas;
            f8 = f4;
            f12 = f5;
        }
        return bitmap2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m620a(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            sb.append(list.get(OplusGLSurfaceView_13));
            if (OplusGLSurfaceView_13 != list.size() - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m621a(TextItem textItem, co.polarr.renderer.entities.Context context, C0094d c0094d) {
        float COUIBaseListPopupWindow_12 = c0094d.f388b;
        float f2 = c0094d.f389c;
        C0094d c0094d2 = context.imageTexture;
        float f3 = c0094d2.f388b;
        float f4 = c0094d2.f389c;
        float f5 = f3 / f4;
        float[] fArr = textItem.orientation % 2.0f != 0.0f ? new float[]{f4, f3} : new float[]{f3, f4};
        float f6 = fArr[0];
        float f7 = fArr[1];
        float[] fArrM596a = C0125r.m596a();
        float[] fArrM596a2 = C0125r.m596a();
        float[] fArrM596a3 = C0125r.m596a();
        Matrix.orthoM(fArrM596a2, 0, f6 / (-2.0f), f6 / 2.0f, f7 / (-2.0f), f7 / 2.0f, -1.0f, 1.0f);
        Matrix.invertM(fArrM596a3, 0, fArrM596a2, 0);
        if (textItem.position == null) {
            textItem.position = new float[]{0.0f, 0.0f};
        }
        float[] fArr2 = textItem.position;
        Matrix.translateM(fArrM596a, 0, (fArr2[0] - 0.5f) * 2.0f, (fArr2[1] - 0.5f) * 2.0f * f5, 0.0f);
        Matrix.multiplyMM(fArrM596a, 0, fArrM596a, 0, fArrM596a2, 0);
        Matrix.rotateM(fArrM596a, 0, textItem.angle + textItem.orientation, 0.0f, 0.0f, 1.0f);
        Matrix.multiplyMM(fArrM596a, 0, fArrM596a, 0, fArrM596a3, 0);
        C0094d c0094d3 = context.imageTexture;
        Matrix.scaleM(fArrM596a, 0, COUIBaseListPopupWindow_12 / c0094d3.f388b, f2 / c0094d3.f389c, 1.0f);
        return fArrM596a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m622a(String[] strArr, TextPaint textPaint) {
        float[] fArr = new float[strArr.length];
        int length = strArr.length;
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < length) {
            fArr[i2] = m615a(strArr[OplusGLSurfaceView_13], textPaint);
            OplusGLSurfaceView_13++;
            i2++;
        }
        return fArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String[] m623a(Context context, AssetManager assetManager, String str, IntrinsicsJvm.kt_4 bVar) {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(C0111d.m470a(context, assetManager, bVar.f603i, bVar.f604j));
        textPaint.setTextSize(bVar.f597c);
        float COUIBaseListPopupWindow_12 = bVar.f600f;
        float f2 = bVar.f595a;
        float f3 = 0.0f;
        if (f2 == 0.0f) {
            return str.split("\OplusGLSurfaceView_11");
        }
        ArrayList arrayList = new ArrayList();
        float fM615a = m615a(" ", textPaint);
        float f4 = (int) f2;
        String[] strArrSplit = str.split("\OplusGLSurfaceView_11");
        int length = strArrSplit.length;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < length) {
            String str2 = strArrSplit[OplusGLSurfaceView_13];
            ArrayList arrayList2 = new ArrayList();
            float f5 = f3;
            int i2 = 0;
            for (String str3 : str2.split(" ")) {
                float fM615a2 = m615a(str3, textPaint) + (str3.length() * COUIBaseListPopupWindow_12);
                f5 += fM615a2;
                if (f5 <= f4) {
                    f5 += fM615a + COUIBaseListPopupWindow_12;
                } else if (i2 > 0) {
                    arrayList.add(m620a(arrayList2, " "));
                    arrayList2.clear();
                    f5 = fM615a2;
                }
                arrayList2.add(str3);
                i2++;
            }
            OplusGLSurfaceView_13++;
            f3 = 0.0f;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
