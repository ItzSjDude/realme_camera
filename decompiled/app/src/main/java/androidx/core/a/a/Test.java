package androidx.core.a_renamed.a_renamed;

/* compiled from: GradientColorInflaterCompat.java */
/* loaded from: classes.dex */
final class d_renamed {
    static android.graphics.Shader a_renamed(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new org.xmlpull.v1.XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.core.R_renamed.styleable.GradientColor);
        float fA_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "startX", androidx.core.R_renamed.styleable.GradientColor_android_startX, 0.0f);
        float fA2 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "startY", androidx.core.R_renamed.styleable.GradientColor_android_startY, 0.0f);
        float fA3 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "endX", androidx.core.R_renamed.styleable.GradientColor_android_endX, 0.0f);
        float fA4 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "endY", androidx.core.R_renamed.styleable.GradientColor_android_endY, 0.0f);
        float fA5 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "centerX", androidx.core.R_renamed.styleable.GradientColor_android_centerX, 0.0f);
        float fA6 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "centerY", androidx.core.R_renamed.styleable.GradientColor_android_centerY, 0.0f);
        int iA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE, androidx.core.R_renamed.styleable.GradientColor_android_type, 0);
        int iB = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayA, xmlPullParser, "startColor", androidx.core.R_renamed.styleable.GradientColor_android_startColor, 0);
        boolean zA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "centerColor");
        int iB2 = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayA, xmlPullParser, "centerColor", androidx.core.R_renamed.styleable.GradientColor_android_centerColor, 0);
        int iB3 = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayA, xmlPullParser, "endColor", androidx.core.R_renamed.styleable.GradientColor_android_endColor, 0);
        int iA2 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "tileMode", androidx.core.R_renamed.styleable.GradientColor_android_tileMode, 0);
        float fA7 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "gradientRadius", androidx.core.R_renamed.styleable.GradientColor_android_gradientRadius, 0.0f);
        typedArrayA.recycle();
        androidx.core.a_renamed.a_renamed.d_renamed.a_renamed aVarA = a_renamed(b_renamed(resources, xmlPullParser, attributeSet, theme), iB, iB3, zA, iB2);
        if (iA != 1) {
            if (iA == 2) {
                return new android.graphics.SweepGradient(fA5, fA6, aVarA.f792a, aVarA.f793b);
            }
            return new android.graphics.LinearGradient(fA_renamed, fA2, fA3, fA4, aVarA.f792a, aVarA.f793b, a_renamed(iA2));
        }
        if (fA7 <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        return new android.graphics.RadialGradient(fA5, fA6, fA7, aVarA.f792a, aVarA.f793b, a_renamed(iA2));
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:23:0x0089, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:25:0x0090, code lost:
    
        return new androidx.core.a_renamed.a_renamed.d_renamed.a_renamed(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:26:0x0091, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.core.a_renamed.a_renamed.d_renamed.a_renamed b_renamed(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
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
            int[] r3 = androidx.core.R_renamed.styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(r8, r11, r10, r3)
            int r5 = androidx.core.R_renamed.styleable.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R_renamed.styleable.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = androidx.core.R_renamed.styleable.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R_renamed.styleable.GradientColorItem_android_offset
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
            java.lang.String r9 = ": <item> tag requires a_renamed 'color' attribute and a_renamed 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L85:
            int r8 = r4.size()
            if (r8 <= 0) goto L91
            androidx.core.a_renamed.a_renamed.d_renamed$a_renamed r8 = new androidx.core.a_renamed.a_renamed.d_renamed$a_renamed
            r8.<init>(r4, r2)
            return r8
        L91:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a_renamed.a_renamed.d_renamed.b_renamed(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.a_renamed.a_renamed.d_renamed$a_renamed");
    }

    private static androidx.core.a_renamed.a_renamed.d_renamed.a_renamed a_renamed(androidx.core.a_renamed.a_renamed.d_renamed.a_renamed aVar, int i_renamed, int i2, boolean z_renamed, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z_renamed) {
            return new androidx.core.a_renamed.a_renamed.d_renamed.a_renamed(i_renamed, i3, i2);
        }
        return new androidx.core.a_renamed.a_renamed.d_renamed.a_renamed(i_renamed, i2);
    }

    private static android.graphics.Shader.TileMode a_renamed(int i_renamed) {
        if (i_renamed == 1) {
            return android.graphics.Shader.TileMode.REPEAT;
        }
        if (i_renamed == 2) {
            return android.graphics.Shader.TileMode.MIRROR;
        }
        return android.graphics.Shader.TileMode.CLAMP;
    }

    /* compiled from: GradientColorInflaterCompat.java */
    static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final int[] f792a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final float[] f793b;

        a_renamed(java.util.List<java.lang.Integer> list, java.util.List<java.lang.Float> list2) {
            int size = list.size();
            this.f792a = new int[size];
            this.f793b = new float[size];
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f792a[i_renamed] = list.get(i_renamed).intValue();
                this.f793b[i_renamed] = list2.get(i_renamed).floatValue();
            }
        }

        a_renamed(int i_renamed, int i2) {
            this.f792a = new int[]{i_renamed, i2};
            this.f793b = new float[]{0.0f, 1.0f};
        }

        a_renamed(int i_renamed, int i2, int i3) {
            this.f792a = new int[]{i_renamed, i2, i3};
            this.f793b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
