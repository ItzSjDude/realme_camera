package androidx.vectordrawable.a_renamed.a_renamed;

/* compiled from: AnimatorInflaterCompat.java */
/* loaded from: classes.dex */
public class e_renamed {
    private static boolean a_renamed(int i_renamed) {
        return i_renamed >= 28 && i_renamed <= 31;
    }

    public static android.animation.Animator a_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return android.animation.AnimatorInflater.loadAnimator(context, i_renamed);
        }
        return a_renamed(context, context.getResources(), context.getTheme(), i_renamed);
    }

    public static android.animation.Animator a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, int i_renamed) throws android.content.res.Resources.NotFoundException {
        return a_renamed(context, resources, theme, i_renamed, 1.0f);
    }

    public static android.animation.Animator a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, int i_renamed, float f_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.res.XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i_renamed);
                    return a_renamed(context, resources, theme, animation, f_renamed);
                } catch (org.xmlpull.v1.XmlPullParserException e_renamed) {
                    android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException("Can't_renamed load animation resource ID_renamed #0x" + java.lang.Integer.toHexString(i_renamed));
                    notFoundException.initCause(e_renamed);
                    throw notFoundException;
                }
            } catch (java.io.IOException e2) {
                android.content.res.Resources.NotFoundException notFoundException2 = new android.content.res.Resources.NotFoundException("Can't_renamed load animation resource ID_renamed #0x" + java.lang.Integer.toHexString(i_renamed));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (animation != null) {
                animation.close();
            }
        }
    }

    /* compiled from: AnimatorInflaterCompat.java */
    private static class a_renamed implements android.animation.TypeEvaluator<androidx.core.graphics.e_renamed.b_renamed[]> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private androidx.core.graphics.e_renamed.b_renamed[] f1775a;

        a_renamed() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.core.graphics.e_renamed.b_renamed[] evaluate(float f_renamed, androidx.core.graphics.e_renamed.b_renamed[] bVarArr, androidx.core.graphics.e_renamed.b_renamed[] bVarArr2) {
            if (!androidx.core.graphics.e_renamed.a_renamed(bVarArr, bVarArr2)) {
                throw new java.lang.IllegalArgumentException("Can't_renamed interpolate between two incompatible pathData");
            }
            if (!androidx.core.graphics.e_renamed.a_renamed(this.f1775a, bVarArr)) {
                this.f1775a = androidx.core.graphics.e_renamed.a_renamed(bVarArr);
            }
            for (int i_renamed = 0; i_renamed < bVarArr.length; i_renamed++) {
                this.f1775a[i_renamed].a_renamed(bVarArr[i_renamed], bVarArr2[i_renamed], f_renamed);
            }
            return this.f1775a;
        }
    }

    private static android.animation.PropertyValuesHolder a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2, int i3, java.lang.String str) {
        int color;
        int color2;
        int color3;
        float dimension;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat;
        float dimension2;
        float dimension3;
        android.animation.PropertyValuesHolder propertyValuesHolderOfObject;
        android.util.TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z_renamed = typedValuePeekValue != null;
        int i4 = z_renamed ? typedValuePeekValue.type : 0;
        android.util.TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i_renamed == 4) {
            i_renamed = ((z_renamed && a_renamed(i4)) || (z2 && a_renamed(i5))) ? 3 : 0;
        }
        boolean z3 = i_renamed == 0;
        android.animation.PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i_renamed == 2) {
            java.lang.String string = typedArray.getString(i2);
            java.lang.String string2 = typedArray.getString(i3);
            androidx.core.graphics.e_renamed.b_renamed[] bVarArrB = androidx.core.graphics.e_renamed.b_renamed(string);
            androidx.core.graphics.e_renamed.b_renamed[] bVarArrB2 = androidx.core.graphics.e_renamed.b_renamed(string2);
            if (bVarArrB == null && bVarArrB2 == null) {
                return null;
            }
            if (bVarArrB == null) {
                if (bVarArrB2 != null) {
                    return android.animation.PropertyValuesHolder.ofObject(str, new androidx.vectordrawable.a_renamed.a_renamed.e_renamed.a_renamed(), bVarArrB2);
                }
                return null;
            }
            androidx.vectordrawable.a_renamed.a_renamed.e_renamed.a_renamed aVar = new androidx.vectordrawable.a_renamed.a_renamed.e_renamed.a_renamed();
            if (bVarArrB2 != null) {
                if (!androidx.core.graphics.e_renamed.a_renamed(bVarArrB, bVarArrB2)) {
                    throw new android.view.InflateException(" Can't_renamed morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = android.animation.PropertyValuesHolder.ofObject(str, aVar, bVarArrB, bVarArrB2);
            } else {
                propertyValuesHolderOfObject = android.animation.PropertyValuesHolder.ofObject(str, aVar, bVarArrB);
            }
            return propertyValuesHolderOfObject;
        }
        androidx.vectordrawable.a_renamed.a_renamed.f_renamed fVarA = i_renamed == 3 ? androidx.vectordrawable.a_renamed.a_renamed.f_renamed.a_renamed() : null;
        if (z3) {
            if (z_renamed) {
                if (i4 == 5) {
                    dimension2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    dimension2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i5 == 5) {
                        dimension3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        dimension3 = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat(str, dimension2, dimension3);
                } else {
                    propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat(str, dimension2);
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArray.getDimension(i3, 0.0f);
                } else {
                    dimension = typedArray.getFloat(i3, 0.0f);
                }
                propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat(str, dimension);
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z_renamed) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (a_renamed(i4)) {
                color2 = typedArray.getColor(i2, 0);
            } else {
                color2 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (a_renamed(i5)) {
                    color3 = typedArray.getColor(i3, 0);
                } else {
                    color3 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else if (a_renamed(i5)) {
                color = typedArray.getColor(i3, 0);
            } else {
                color = typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || fVarA == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(fVarA);
        return propertyValuesHolderOfInt;
    }

    private static void a_renamed(android.animation.ValueAnimator valueAnimator, android.content.res.TypedArray typedArray, android.content.res.TypedArray typedArray2, float f_renamed, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        long jA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, 1, 300);
        long jA2 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "valueType", 7, 4);
        if (androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "valueFrom") && androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "valueTo")) {
            if (iA == 4) {
                iA = a_renamed(typedArray, 5, 6);
            }
            android.animation.PropertyValuesHolder propertyValuesHolderA = a_renamed(typedArray, iA, 5, 6, "");
            if (propertyValuesHolderA != null) {
                valueAnimator.setValues(propertyValuesHolderA);
            }
        }
        valueAnimator.setDuration(jA);
        valueAnimator.setStartDelay(jA2);
        valueAnimator.setRepeatCount(androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a_renamed(valueAnimator, typedArray2, iA, f_renamed, xmlPullParser);
        }
    }

    private static void a_renamed(android.animation.ValueAnimator valueAnimator, android.content.res.TypedArray typedArray, int i_renamed, float f_renamed, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.animation.ObjectAnimator objectAnimator = (android.animation.ObjectAnimator) valueAnimator;
        java.lang.String strA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "pathData", 1);
        if (strA != null) {
            java.lang.String strA2 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "propertyXName", 2);
            java.lang.String strA3 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "propertyYName", 3);
            if (i_renamed != 2) {
            }
            if (strA2 == null && strA3 == null) {
                throw new android.view.InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is_renamed needed for PathData");
            }
            a_renamed(androidx.core.graphics.e_renamed.a_renamed(strA), objectAnimator, f_renamed * 0.5f, strA2, strA3);
            return;
        }
        objectAnimator.setPropertyName(androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void a_renamed(android.graphics.Path path, android.animation.ObjectAnimator objectAnimator, float f_renamed, java.lang.String str, java.lang.String str2) {
        android.graphics.PathMeasure pathMeasure = new android.graphics.PathMeasure(path, false);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(java.lang.Float.valueOf(length));
        } while (pathMeasure.nextContour());
        android.graphics.PathMeasure pathMeasure2 = new android.graphics.PathMeasure(path, false);
        int iMin = java.lang.Math.min(100, ((int) (length / f_renamed)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f2 = length / (iMin - 1);
        int i_renamed = 0;
        float f3 = 0.0f;
        int i2 = 0;
        while (true) {
            if (i2 >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f3 - ((java.lang.Float) arrayList.get(i_renamed)).floatValue(), fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f3 += f2;
            int i3 = i_renamed + 1;
            if (i3 < arrayList.size() && f3 > ((java.lang.Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i_renamed = i3;
            }
            i2++;
        }
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? android.animation.PropertyValuesHolder.ofFloat(str, fArr) : null;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? android.animation.PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }

    private static android.animation.Animator a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, float f_renamed) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return a_renamed(context, resources, theme, xmlPullParser, android.util.Xml.asAttributeSet(xmlPullParser), null, 0, f_renamed);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:37:0x00df, code lost:
    
        if (r23 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:38:0x00e1, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:39:0x00e3, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:41:0x00f1, code lost:
    
        if (r2.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:42:0x00f3, code lost:
    
        r1[r14] = (android.animation.Animator) r2.next();
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:43:0x00ff, code lost:
    
        if (r24 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:44:0x0101, code lost:
    
        r23.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:45:0x0105, code lost:
    
        r23.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:46:0x0108, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.animation.Animator a_renamed(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a_renamed.a_renamed.e_renamed.a_renamed(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static android.animation.PropertyValuesHolder[] a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i_renamed;
        android.animation.PropertyValuesHolder[] propertyValuesHolderArr = null;
        java.util.ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.i_renamed);
                    java.lang.String strA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "propertyName", 3);
                    int iA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "valueType", 2, 4);
                    android.animation.PropertyValuesHolder propertyValuesHolderA = a_renamed(context, resources, theme, xmlPullParser, strA, iA);
                    if (propertyValuesHolderA == null) {
                        propertyValuesHolderA = a_renamed(typedArrayA, iA, 0, 1, strA);
                    }
                    if (propertyValuesHolderA != null) {
                        if (arrayList == null) {
                            arrayList = new java.util.ArrayList();
                        }
                        arrayList.add(propertyValuesHolderA);
                    }
                    typedArrayA.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new android.animation.PropertyValuesHolder[size];
            for (i_renamed = 0; i_renamed < size; i_renamed++) {
                propertyValuesHolderArr[i_renamed] = (android.animation.PropertyValuesHolder) arrayList.get(i_renamed);
            }
        }
        return propertyValuesHolderArr;
    }

    private static int a_renamed(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.j_renamed);
        int i_renamed = 0;
        android.util.TypedValue typedValueB = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayA, xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0);
        if ((typedValueB != null) && a_renamed(typedValueB.type)) {
            i_renamed = 3;
        }
        typedArrayA.recycle();
        return i_renamed;
    }

    private static int a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        android.util.TypedValue typedValuePeekValue = typedArray.peekValue(i_renamed);
        boolean z_renamed = typedValuePeekValue != null;
        int i3 = z_renamed ? typedValuePeekValue.type : 0;
        android.util.TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z_renamed && a_renamed(i3)) || (z2 && a_renamed(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    private static android.animation.PropertyValuesHolder a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int size;
        android.animation.PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        int iA = i_renamed;
        java.util.ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iA == 4) {
                    iA = a_renamed(resources, theme, android.util.Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                android.animation.Keyframe keyframeA = a_renamed(context, resources, theme, android.util.Xml.asAttributeSet(xmlPullParser), iA, xmlPullParser);
                if (keyframeA != null) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                    }
                    arrayList.add(keyframeA);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            android.animation.Keyframe keyframe = (android.animation.Keyframe) arrayList.get(0);
            android.animation.Keyframe keyframe2 = (android.animation.Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), a_renamed(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, a_renamed(keyframe, 0.0f));
                    size++;
                }
            }
            android.animation.Keyframe[] keyframeArr = new android.animation.Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                android.animation.Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            a_renamed(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = android.animation.PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (iA == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(androidx.vectordrawable.a_renamed.a_renamed.f_renamed.a_renamed());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    private static android.animation.Keyframe a_renamed(android.animation.Keyframe keyframe, float f_renamed) {
        if (keyframe.getType() == java.lang.Float.TYPE) {
            return android.animation.Keyframe.ofFloat(f_renamed);
        }
        if (keyframe.getType() == java.lang.Integer.TYPE) {
            return android.animation.Keyframe.ofInt(f_renamed);
        }
        return android.animation.Keyframe.ofObject(f_renamed);
    }

    private static void a_renamed(android.animation.Keyframe[] keyframeArr, float f_renamed, int i_renamed, int i2) {
        float f2 = f_renamed / ((i2 - i_renamed) + 2);
        while (i_renamed <= i2) {
            keyframeArr[i_renamed].setFraction(keyframeArr[i_renamed - 1].getFraction() + f2);
            i_renamed++;
        }
    }

    private static android.animation.Keyframe a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int i_renamed, org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.animation.Keyframe keyframeOfInt;
        android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.j_renamed);
        float fA_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, "fraction", 3, -1.0f);
        android.util.TypedValue typedValueB = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayA, xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0);
        boolean z_renamed = typedValueB != null;
        if (i_renamed == 4) {
            i_renamed = (z_renamed && a_renamed(typedValueB.type)) ? 3 : 0;
        }
        if (z_renamed) {
            if (i_renamed == 0) {
                keyframeOfInt = android.animation.Keyframe.ofFloat(fA_renamed, androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0, 0.0f));
            } else {
                keyframeOfInt = (i_renamed == 1 || i_renamed == 3) ? android.animation.Keyframe.ofInt(fA_renamed, androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayA, xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0, 0)) : null;
            }
        } else if (i_renamed == 0) {
            keyframeOfInt = android.animation.Keyframe.ofFloat(fA_renamed);
        } else {
            keyframeOfInt = android.animation.Keyframe.ofInt(fA_renamed);
        }
        int iC = androidx.core.a_renamed.a_renamed.g_renamed.c_renamed(typedArrayA, xmlPullParser, "interpolator", 1, 0);
        if (iC > 0) {
            keyframeOfInt.setInterpolator(androidx.vectordrawable.a_renamed.a_renamed.d_renamed.a_renamed(context, iC));
        }
        typedArrayA.recycle();
        return keyframeOfInt;
    }

    private static android.animation.ObjectAnimator a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, float f_renamed, org.xmlpull.v1.XmlPullParser xmlPullParser) throws android.content.res.Resources.NotFoundException {
        android.animation.ObjectAnimator objectAnimator = new android.animation.ObjectAnimator();
        a_renamed(context, resources, theme, attributeSet, objectAnimator, f_renamed, xmlPullParser);
        return objectAnimator;
    }

    private static android.animation.ValueAnimator a_renamed(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, android.animation.ValueAnimator valueAnimator, float f_renamed, org.xmlpull.v1.XmlPullParser xmlPullParser) throws android.content.res.Resources.NotFoundException {
        android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.g_renamed);
        android.content.res.TypedArray typedArrayA2 = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.k_renamed);
        if (valueAnimator == null) {
            valueAnimator = new android.animation.ValueAnimator();
        }
        a_renamed(valueAnimator, typedArrayA, typedArrayA2, f_renamed, xmlPullParser);
        int iC = androidx.core.a_renamed.a_renamed.g_renamed.c_renamed(typedArrayA, xmlPullParser, "interpolator", 0, 0);
        if (iC > 0) {
            valueAnimator.setInterpolator(androidx.vectordrawable.a_renamed.a_renamed.d_renamed.a_renamed(context, iC));
        }
        typedArrayA.recycle();
        if (typedArrayA2 != null) {
            typedArrayA2.recycle();
        }
        return valueAnimator;
    }
}
