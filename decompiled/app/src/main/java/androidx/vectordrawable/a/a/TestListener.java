package androidx.vectordrawable.a_renamed.a_renamed;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public class g_renamed implements android.view.animation.Interpolator {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float[] f1777a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float[] f1778b;

    public g_renamed(android.content.Context context, android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public g_renamed(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.l_renamed);
        a_renamed(typedArrayA, xmlPullParser);
        typedArrayA.recycle();
    }

    private void a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        if (androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "pathData")) {
            java.lang.String strA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "pathData", 4);
            android.graphics.Path pathA = androidx.core.graphics.e_renamed.a_renamed(strA);
            if (pathA == null) {
                throw new android.view.InflateException("The path is_renamed null, which is_renamed created from " + strA);
            }
            a_renamed(pathA);
            return;
        }
        if (!androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "controlX1")) {
            throw new android.view.InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "controlY1")) {
            throw new android.view.InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fA_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float fA2 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "controlX2");
        if (zA != androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "controlY2")) {
            throw new android.view.InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (!zA) {
            a_renamed(fA_renamed, fA2);
        } else {
            a_renamed(fA_renamed, fA2, androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "controlX2", 2, 0.0f), androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        }
    }

    private void a_renamed(float f_renamed, float f2) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f_renamed, f2, 1.0f, 1.0f);
        a_renamed(path);
    }

    private void a_renamed(float f_renamed, float f2, float f3, float f4) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f_renamed, f2, f3, f4, 1.0f, 1.0f);
        a_renamed(path);
    }

    private void a_renamed(android.graphics.Path path) {
        int i_renamed = 0;
        android.graphics.PathMeasure pathMeasure = new android.graphics.PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = java.lang.Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new java.lang.IllegalArgumentException("The Path has a_renamed invalid length " + length);
        }
        this.f1777a = new float[iMin];
        this.f1778b = new float[iMin];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < iMin; i2++) {
            pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
            this.f1777a[i2] = fArr[0];
            this.f1778b[i2] = fArr[1];
        }
        if (java.lang.Math.abs(this.f1777a[0]) <= 1.0E-5d && java.lang.Math.abs(this.f1778b[0]) <= 1.0E-5d) {
            int i3 = iMin - 1;
            if (java.lang.Math.abs(this.f1777a[i3] - 1.0f) <= 1.0E-5d && java.lang.Math.abs(this.f1778b[i3] - 1.0f) <= 1.0E-5d) {
                float f_renamed = 0.0f;
                int i4 = 0;
                while (i_renamed < iMin) {
                    float[] fArr2 = this.f1777a;
                    int i5 = i4 + 1;
                    float f2 = fArr2[i4];
                    if (f2 < f_renamed) {
                        throw new java.lang.IllegalArgumentException("The Path cannot loop back on_renamed itself, x_renamed :" + f2);
                    }
                    fArr2[i_renamed] = f2;
                    i_renamed++;
                    f_renamed = f2;
                    i4 = i5;
                }
                if (pathMeasure.nextContour()) {
                    throw new java.lang.IllegalArgumentException("The Path should be_renamed continuous, can't_renamed have 2+ contours");
                }
                return;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("The Path must start at_renamed (0,0) and end at_renamed (1,1) start: ");
        sb.append(this.f1777a[0]);
        sb.append(",");
        sb.append(this.f1778b[0]);
        sb.append(" end:");
        int i6 = iMin - 1;
        sb.append(this.f1777a[i6]);
        sb.append(",");
        sb.append(this.f1778b[i6]);
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f_renamed) {
        if (f_renamed <= 0.0f) {
            return 0.0f;
        }
        if (f_renamed >= 1.0f) {
            return 1.0f;
        }
        int i_renamed = 0;
        int length = this.f1777a.length - 1;
        while (length - i_renamed > 1) {
            int i2 = (i_renamed + length) / 2;
            if (f_renamed < this.f1777a[i2]) {
                length = i2;
            } else {
                i_renamed = i2;
            }
        }
        float[] fArr = this.f1777a;
        float f2 = fArr[length] - fArr[i_renamed];
        if (f2 == 0.0f) {
            return this.f1778b[i_renamed];
        }
        float f3 = (f_renamed - fArr[i_renamed]) / f2;
        float[] fArr2 = this.f1778b;
        float f4 = fArr2[i_renamed];
        return f4 + (f3 * (fArr2[length] - f4));
    }
}
