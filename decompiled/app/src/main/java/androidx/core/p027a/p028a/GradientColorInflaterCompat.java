package androidx.core.p027a.p028a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import com.oplus.ocs.camera.CameraParameter;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: GradientColorInflaterCompat.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
final class GradientColorInflaterCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    static Shader m2292a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, R.styleable.GradientColor);
        float fM2305a = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float fM2305a2 = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float fM2305a3 = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float fM2305a4 = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float fM2305a5 = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float fM2305a6 = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int iM2308a = TypedArrayUtils.m2308a(typedArrayM2311a, xmlPullParser, CameraParameter.TiltShiftParamKeys.TYPE, R.styleable.GradientColor_android_type, 0);
        int iM2319b = TypedArrayUtils.m2319b(typedArrayM2311a, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean zM2317a = TypedArrayUtils.m2317a(xmlPullParser, "centerColor");
        int iM2319b2 = TypedArrayUtils.m2319b(typedArrayM2311a, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int iM2319b3 = TypedArrayUtils.m2319b(typedArrayM2311a, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int iM2308a2 = TypedArrayUtils.m2308a(typedArrayM2311a, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float fM2305a7 = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        typedArrayM2311a.recycle();
        PlatformImplementations.kt_3 aVarM2293a = m2293a(m2294b(resources, xmlPullParser, attributeSet, theme), iM2319b, iM2319b3, zM2317a, iM2319b2);
        if (iM2308a != 1) {
            if (iM2308a == 2) {
                return new SweepGradient(fM2305a5, fM2305a6, aVarM2293a.f2701a, aVarM2293a.f2702b);
            }
            return new LinearGradient(fM2305a, fM2305a2, fM2305a3, fM2305a4, aVarM2293a.f2701a, aVarM2293a.f2702b, m2291a(iM2308a2));
        }
        if (fM2305a7 <= 0.0f) {
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        return new RadialGradient(fM2305a5, fM2305a6, fM2305a7, aVarM2293a.f2701a, aVarM2293a.f2702b, m2291a(iM2308a2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        return new androidx.core.p027a.p028a.GradientColorInflaterCompat.PlatformImplementations.kt_3(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        return null;
     */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.core.p027a.p028a.GradientColorInflaterCompat.PlatformImplementations.kt_3 m2294b(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L85
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L85
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R.styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.p027a.p028a.TypedArrayUtils.m2311a(r8, r11, r10, r3)
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires PlatformImplementations.kt_3 'color' attribute and PlatformImplementations.kt_3 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L85:
            int r8 = r4.size()
            if (r8 <= 0) goto L91
            androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 r8 = new androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3
            r8.<init>(r4, r2)
            return r8
        L91:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p027a.p028a.GradientColorInflaterCompat.m2294b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PlatformImplementations.kt_3 m2293a(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new PlatformImplementations.kt_3(OplusGLSurfaceView_13, i3, i2);
        }
        return new PlatformImplementations.kt_3(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Shader.TileMode m2291a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.CLAMP;
    }

    /* compiled from: GradientColorInflaterCompat.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final int[] f2701a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final float[] f2702b;

        PlatformImplementations.kt_3(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f2701a = new int[size];
            this.f2702b = new float[size];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f2701a[OplusGLSurfaceView_13] = list.get(OplusGLSurfaceView_13).intValue();
                this.f2702b[OplusGLSurfaceView_13] = list2.get(OplusGLSurfaceView_13).floatValue();
            }
        }

        PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2) {
            this.f2701a = new int[]{OplusGLSurfaceView_13, i2};
            this.f2702b = new float[]{0.0f, 1.0f};
        }

        PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f2701a = new int[]{OplusGLSurfaceView_13, i2, i3};
            this.f2702b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
