package androidx.vectordrawable.p055a.p056a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.graphics.PathParser;
import androidx.core.p027a.p028a.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: PathInterpolatorCompat.java */
/* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {

    /* renamed from: PlatformImplementations.kt_3 */
    private float[] f4704a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float[] f4705b;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4688l);
        m4865a(typedArrayM2311a, xmlPullParser);
        typedArrayM2311a.recycle();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4865a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.m2317a(xmlPullParser, "pathData")) {
            String strM2314a = TypedArrayUtils.m2314a(typedArray, xmlPullParser, "pathData", 4);
            Path pathM2593a = PathParser.m2593a(strM2314a);
            if (pathM2593a == null) {
                throw new InflateException("The path is null, which is created from " + strM2314a);
            }
            m4866a(pathM2593a);
            return;
        }
        if (!TypedArrayUtils.m2317a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.m2317a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fM2305a = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float fM2305a2 = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zM2317a = TypedArrayUtils.m2317a(xmlPullParser, "controlX2");
        if (zM2317a != TypedArrayUtils.m2317a(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (!zM2317a) {
            m4863a(fM2305a, fM2305a2);
        } else {
            m4864a(fM2305a, fM2305a2, TypedArrayUtils.m2305a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.m2305a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4863a(float COUIBaseListPopupWindow_12, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(COUIBaseListPopupWindow_12, f2, 1.0f, 1.0f);
        m4866a(path);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4864a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(COUIBaseListPopupWindow_12, f2, f3, f4, 1.0f, 1.0f);
        m4866a(path);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4866a(Path path) {
        int OplusGLSurfaceView_13 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has PlatformImplementations.kt_3 invalid length " + length);
        }
        this.f4704a = new float[iMin];
        this.f4705b = new float[iMin];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < iMin; i2++) {
            pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
            this.f4704a[i2] = fArr[0];
            this.f4705b[i2] = fArr[1];
        }
        if (Math.abs(this.f4704a[0]) <= 1.0E-5d && Math.abs(this.f4705b[0]) <= 1.0E-5d) {
            int i3 = iMin - 1;
            if (Math.abs(this.f4704a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f4705b[i3] - 1.0f) <= 1.0E-5d) {
                float COUIBaseListPopupWindow_12 = 0.0f;
                int i4 = 0;
                while (OplusGLSurfaceView_13 < iMin) {
                    float[] fArr2 = this.f4704a;
                    int i5 = i4 + 1;
                    float f2 = fArr2[i4];
                    if (f2 < COUIBaseListPopupWindow_12) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                    }
                    fArr2[OplusGLSurfaceView_13] = f2;
                    OplusGLSurfaceView_13++;
                    COUIBaseListPopupWindow_12 = f2;
                    i4 = i5;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f4704a[0]);
        sb.append(",");
        sb.append(this.f4705b[0]);
        sb.append(" end:");
        int i6 = iMin - 1;
        sb.append(this.f4704a[i6]);
        sb.append(",");
        sb.append(this.f4705b[i6]);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            return 0.0f;
        }
        if (COUIBaseListPopupWindow_12 >= 1.0f) {
            return 1.0f;
        }
        int OplusGLSurfaceView_13 = 0;
        int length = this.f4704a.length - 1;
        while (length - OplusGLSurfaceView_13 > 1) {
            int i2 = (OplusGLSurfaceView_13 + length) / 2;
            if (COUIBaseListPopupWindow_12 < this.f4704a[i2]) {
                length = i2;
            } else {
                OplusGLSurfaceView_13 = i2;
            }
        }
        float[] fArr = this.f4704a;
        float f2 = fArr[length] - fArr[OplusGLSurfaceView_13];
        if (f2 == 0.0f) {
            return this.f4705b[OplusGLSurfaceView_13];
        }
        float f3 = (COUIBaseListPopupWindow_12 - fArr[OplusGLSurfaceView_13]) / f2;
        float[] fArr2 = this.f4705b;
        float f4 = fArr2[OplusGLSurfaceView_13];
        return f4 + (f3 * (fArr2[length] - f4));
    }
}
