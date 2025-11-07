package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class v_renamed {

    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f128a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public float f129b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.lang.String[] f130c;
        public java.lang.Float[] d_renamed;
    }

    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f131a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public android.graphics.RectF f132b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f133c;
        public float d_renamed;
        public float e_renamed;
        public float f_renamed;
        public float[] g_renamed;
        public float[] h_renamed;
        public co_renamed.polarr.renderer.entities.TextItem i_renamed;
        public int j_renamed;
    }

    public static float a_renamed(android.graphics.Canvas canvas, android.graphics.Paint paint, java.lang.String str, float f_renamed, float f2, float f3, float f4, java.lang.String str2) {
        if (str.isEmpty()) {
            return 0.0f;
        }
        while (true) {
            java.lang.String strSubstring = str.substring(0, 1);
            str = str.substring(1);
            canvas.drawText(strSubstring, f_renamed, paint.getFontMetrics().descent + f2, paint);
            float fA_renamed = str.isEmpty() ? 0.0f : a_renamed(str, paint);
            f_renamed += (f3 - fA_renamed) + f4;
            if (str.isEmpty()) {
                return f_renamed;
            }
            f3 = fA_renamed;
        }
    }

    public static float a_renamed(java.lang.String str, android.graphics.Paint paint) {
        return paint.measureText(str, 0, str.length());
    }

    public static a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(android.content.Context context, android.content.res.AssetManager assetManager, co_renamed.polarr.renderer.entities.TextItem textItem, co_renamed.polarr.renderer.entities.Context context2, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        int i_renamed;
        if (dVar != null) {
            android.opengl.GLES20.glBindTexture(3553, dVar.f34a);
            i_renamed = 0;
        } else {
            int[] iArr = new int[1];
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(iArr[0]);
            android.opengl.GLES20.glBindTexture(3553, iArr[0]);
            i_renamed = iArr[0];
        }
        android.opengl.GLES20.glPixelStorei(3317, 1);
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
        android.graphics.Bitmap bitmapA = a_renamed(context, assetManager, textItem, context2);
        android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmapA, 0);
        if (dVar == null) {
            dVar = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(i_renamed, 6408, bitmapA.getWidth(), bitmapA.getHeight());
        } else {
            dVar.f35b = bitmapA.getWidth();
            dVar.f36c = bitmapA.getHeight();
        }
        bitmapA.recycle();
        return dVar;
    }

    public static a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed a_renamed(android.content.Context context, android.content.res.AssetManager assetManager, co_renamed.polarr.renderer.entities.TextItem textItem, a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.b_renamed bVar) {
        android.graphics.RectF rectF = bVar.f132b;
        float f_renamed = bVar.f_renamed;
        float f2 = bVar.d_renamed;
        float f3 = bVar.f131a;
        android.text.TextPaint textPaint = new android.text.TextPaint(1);
        textPaint.setTypeface(a_renamed.a_renamed.b_renamed.f_renamed.d_renamed.a_renamed(context, assetManager, textItem, bVar.j_renamed));
        textPaint.setTextSize(bVar.f133c);
        java.lang.String[] strArrA = a_renamed(context, assetManager, textItem.text.replaceAll("/ +$/g_renamed", ""), bVar);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        float fMax = 0.0f;
        for (java.lang.String str : strArrA) {
            float fA_renamed = a_renamed(str, textPaint);
            fMax = java.lang.Math.max(fMax, (r7.length() * f_renamed) + fA_renamed);
            arrayList.add(java.lang.Float.valueOf(fA_renamed));
        }
        float length = strArrA.length;
        float f4 = rectF.bottom;
        if (f3 > 0.0f) {
            fMax = java.lang.Math.max(fMax, f3);
        }
        a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed aVar = new a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed();
        aVar.f128a = fMax;
        aVar.f129b = (f2 * length) + f4;
        aVar.f130c = strArrA;
        aVar.d_renamed = (java.lang.Float[]) arrayList.toArray(new java.lang.Float[arrayList.size()]);
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.b_renamed a_renamed(android.content.Context r9, android.content.res.AssetManager r10, co_renamed.polarr.renderer.entities.TextItem r11, int r12) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed(android.content.Context, android.content.res.AssetManager, co_renamed.polarr.renderer.entities.TextItem, int):a_renamed.a_renamed.b_renamed.f_renamed.v_renamed$b_renamed");
    }

    public static android.graphics.Bitmap a_renamed(android.content.Context context, android.content.res.AssetManager assetManager, co_renamed.polarr.renderer.entities.TextItem textItem, co_renamed.polarr.renderer.entities.Context context2) {
        float f_renamed;
        float f2;
        android.graphics.Bitmap bitmap;
        float f3;
        android.graphics.Canvas canvas;
        float f4;
        java.lang.Float[] fArr;
        float f5;
        a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.b_renamed bVarA = a_renamed(context, assetManager, textItem, context2.imageTexture.f35b);
        android.graphics.RectF rectF = bVarA.f132b;
        float f6 = bVarA.f_renamed;
        float f7 = bVarA.d_renamed;
        float[] fArr2 = bVarA.g_renamed;
        android.text.TextPaint textPaint = new android.text.TextPaint(1);
        textPaint.setTypeface(a_renamed.a_renamed.b_renamed.f_renamed.d_renamed.a_renamed(context, assetManager, textItem, bVarA.j_renamed));
        textPaint.setTextSize(bVarA.f133c);
        a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.a_renamed aVarA = a_renamed(context, assetManager, textItem, bVarA);
        java.lang.String[] strArr = aVarA.f130c;
        java.lang.Float[] fArr3 = aVarA.d_renamed;
        float f8 = aVarA.f128a;
        float f9 = aVarA.f129b;
        float f10 = (int) (rectF.left + f8 + rectF.right);
        float f11 = (int) f9;
        float fMax = java.lang.Math.max(fArr2[0] * f10, fArr2[1] * f11);
        float fMin = java.lang.Math.min(fMax, 2048) / fMax;
        float[] fArr4 = {java.lang.Math.abs(fArr2[0] * fMin), java.lang.Math.abs(fMin * fArr2[1])};
        int i_renamed = (int) (f10 * fArr4[0]);
        int i2 = (int) (f11 * fArr4[1]);
        if (i_renamed == 0 || i2 == 0) {
            return android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas2 = new android.graphics.Canvas(bitmapCreateBitmap);
        canvas2.scale(fArr4[0], fArr4[1]);
        float f12 = rectF.left;
        float length = ((f9 / 2.0f) - (((strArr.length - 1) * f7) / 2.0f)) - (rectF.bottom / 2.0f);
        float[] fArr5 = bVarA.h_renamed;
        android.graphics.Bitmap bitmap2 = bitmapCreateBitmap;
        textPaint.setColor(android.graphics.Color.argb((int) (fArr5[3] * 255.0f), (int) (fArr5[0] * 255.0f), (int) (fArr5[1] * 255.0f), (int) (fArr5[2] * 255.0f)));
        java.lang.String str = textItem.type;
        if (str != null && str.equalsIgnoreCase("artwork")) {
            android.graphics.Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            length += fontMetrics.descent - fontMetrics.leading;
        }
        if (textItem.mode.equals("outline")) {
            textPaint.setStyle(android.graphics.Paint.Style.STROKE);
            textPaint.setStrokeWidth(bVarA.e_renamed);
        } else {
            textPaint.setStyle(android.graphics.Paint.Style.FILL);
        }
        if (!textItem.align.equals("justify")) {
            float f13 = length;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                java.lang.String str2 = strArr[i3];
                float fFloatValue = fArr3[i3].floatValue();
                float length2 = f8 - (str2.length() * f6);
                java.lang.String str3 = textItem.align;
                char c2 = 65535;
                int iHashCode = str3.hashCode();
                if (iHashCode != -1364013995) {
                    if (iHashCode == 108511772 && str3.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.RIGHT)) {
                        c2 = 0;
                    }
                } else if (str3.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.CENTER)) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    f_renamed = (f12 + length2) - fFloatValue;
                } else if (c2 != 1) {
                    f2 = f12;
                    a_renamed(canvas2, textPaint, str2, f2, f13 + (i3 * f7), fFloatValue, f6, textItem.mode);
                } else {
                    f_renamed = f12 + ((length2 - fFloatValue) / 2.0f);
                }
                f2 = f_renamed;
                a_renamed(canvas2, textPaint, str2, f2, f13 + (i3 * f7), fFloatValue, f6, textItem.mode);
            }
            return bitmap2;
        }
        int i4 = 0;
        while (i4 < strArr.length) {
            java.lang.String str4 = strArr[i4];
            float length3 = f8 - (str4.length() * f6);
            float f14 = length + (i4 * f7);
            if (fArr3[i4].floatValue() < length3) {
                java.lang.String[] strArrSplit = str4.split("/\\s_renamed/g_renamed");
                float[] fArrA = a_renamed(strArrSplit, textPaint);
                float f15 = 0.0f;
                for (float f16 : fArrA) {
                    f15 += f16;
                }
                float length4 = (length3 - f15) / (strArrSplit.length - 1);
                float f17 = f12;
                int i5 = 0;
                while (i5 < strArrSplit.length) {
                    float fA_renamed = a_renamed(canvas2, textPaint, strArrSplit[i5], f17, f14, fArrA[i5], f6, textItem.mode);
                    i5++;
                    fArr3 = fArr3;
                    canvas2 = canvas2;
                    fArrA = fArrA;
                    f8 = f8;
                    f12 = f12;
                    length = length;
                    f17 = fA_renamed + length4 + f6;
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
                a_renamed(canvas, textPaint, str4, f5, f14, fArr[i4].floatValue(), f6, textItem.mode);
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

    public static java.lang.String a_renamed(java.util.List<java.lang.String> list, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            sb.append(list.get(i_renamed));
            if (i_renamed != list.size() - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static float[] a_renamed(co_renamed.polarr.renderer.entities.TextItem textItem, co_renamed.polarr.renderer.entities.Context context, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        float f_renamed = dVar.f35b;
        float f2 = dVar.f36c;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = context.imageTexture;
        float f3 = dVar2.f35b;
        float f4 = dVar2.f36c;
        float f5 = f3 / f4;
        float[] fArr = textItem.orientation % 2.0f != 0.0f ? new float[]{f4, f3} : new float[]{f3, f4};
        float f6 = fArr[0];
        float f7 = fArr[1];
        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        float[] fArrA2 = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        float[] fArrA3 = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        android.opengl.Matrix.orthoM(fArrA2, 0, f6 / (-2.0f), f6 / 2.0f, f7 / (-2.0f), f7 / 2.0f, -1.0f, 1.0f);
        android.opengl.Matrix.invertM(fArrA3, 0, fArrA2, 0);
        if (textItem.position == null) {
            textItem.position = new float[]{0.0f, 0.0f};
        }
        float[] fArr2 = textItem.position;
        android.opengl.Matrix.translateM(fArrA, 0, (fArr2[0] - 0.5f) * 2.0f, (fArr2[1] - 0.5f) * 2.0f * f5, 0.0f);
        android.opengl.Matrix.multiplyMM(fArrA, 0, fArrA, 0, fArrA2, 0);
        android.opengl.Matrix.rotateM(fArrA, 0, textItem.angle + textItem.orientation, 0.0f, 0.0f, 1.0f);
        android.opengl.Matrix.multiplyMM(fArrA, 0, fArrA, 0, fArrA3, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = context.imageTexture;
        android.opengl.Matrix.scaleM(fArrA, 0, f_renamed / dVar3.f35b, f2 / dVar3.f36c, 1.0f);
        return fArrA;
    }

    public static float[] a_renamed(java.lang.String[] strArr, android.text.TextPaint textPaint) {
        float[] fArr = new float[strArr.length];
        int length = strArr.length;
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            fArr[i2] = a_renamed(strArr[i_renamed], textPaint);
            i_renamed++;
            i2++;
        }
        return fArr;
    }

    public static java.lang.String[] a_renamed(android.content.Context context, android.content.res.AssetManager assetManager, java.lang.String str, a_renamed.a_renamed.b_renamed.f_renamed.v_renamed.b_renamed bVar) {
        android.text.TextPaint textPaint = new android.text.TextPaint(1);
        textPaint.setTypeface(a_renamed.a_renamed.b_renamed.f_renamed.d_renamed.a_renamed(context, assetManager, bVar.i_renamed, bVar.j_renamed));
        textPaint.setTextSize(bVar.f133c);
        float f_renamed = bVar.f_renamed;
        float f2 = bVar.f131a;
        float f3 = 0.0f;
        if (f2 == 0.0f) {
            return str.split("\n_renamed");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        float fA_renamed = a_renamed(" ", textPaint);
        float f4 = (int) f2;
        java.lang.String[] strArrSplit = str.split("\n_renamed");
        int length = strArrSplit.length;
        int i_renamed = 0;
        while (i_renamed < length) {
            java.lang.String str2 = strArrSplit[i_renamed];
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            float f5 = f3;
            int i2 = 0;
            for (java.lang.String str3 : str2.split(" ")) {
                float fA2 = a_renamed(str3, textPaint) + (str3.length() * f_renamed);
                f5 += fA2;
                if (f5 <= f4) {
                    f5 += fA_renamed + f_renamed;
                } else if (i2 > 0) {
                    arrayList.add(a_renamed(arrayList2, " "));
                    arrayList2.clear();
                    f5 = fA2;
                }
                arrayList2.add(str3);
                i2++;
            }
            i_renamed++;
            f3 = 0.0f;
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }
}
