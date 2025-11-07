package androidx.vectordrawable.p055a.p056a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.graphics.PathParser;
import androidx.core.p027a.p028a.TypedArrayUtils;
import com.android.providers.downloads.Downloads;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatorInflaterCompat.java */
/* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class AnimatorInflaterCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m4859a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 >= 28 && OplusGLSurfaceView_13 <= 31;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Animator m4844a(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, OplusGLSurfaceView_13);
        }
        return m4845a(context, context.getResources(), context.getTheme(), OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Animator m4845a(Context context, Resources resources, Resources.Theme theme, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return m4846a(context, resources, theme, OplusGLSurfaceView_13, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Animator m4846a(Context context, Resources resources, Resources.Theme theme, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(OplusGLSurfaceView_13);
                    return m4847a(context, resources, theme, animation, COUIBaseListPopupWindow_12);
                } catch (XmlPullParserException COUIBaseListPopupWindow_8) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(OplusGLSurfaceView_13));
                    notFoundException.initCause(COUIBaseListPopupWindow_8);
                    throw notFoundException;
                }
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(OplusGLSurfaceView_13));
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
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 implements TypeEvaluator<PathParser.IntrinsicsJvm.kt_4[]> {

        /* renamed from: PlatformImplementations.kt_3 */
        private PathParser.IntrinsicsJvm.kt_4[] f4702a;

        PlatformImplementations.kt_3() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PathParser.IntrinsicsJvm.kt_4[] evaluate(float COUIBaseListPopupWindow_12, PathParser.IntrinsicsJvm.kt_4[] bVarArr, PathParser.IntrinsicsJvm.kt_4[] bVarArr2) {
            if (!PathParser.m2596a(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!PathParser.m2596a(this.f4702a, bVarArr)) {
                this.f4702a = PathParser.m2598a(bVarArr);
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bVarArr.length; OplusGLSurfaceView_13++) {
                this.f4702a[OplusGLSurfaceView_13].m2606a(bVarArr[OplusGLSurfaceView_13], bVarArr2[OplusGLSurfaceView_13], COUIBaseListPopupWindow_12);
            }
            return this.f4702a;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PropertyValuesHolder m4853a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2, int i3, String str) {
        int color;
        int color2;
        int color3;
        float dimension;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        float dimension2;
        float dimension3;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (OplusGLSurfaceView_13 == 4) {
            OplusGLSurfaceView_13 = ((z && m4859a(i4)) || (z2 && m4859a(i5))) ? 3 : 0;
        }
        boolean z3 = OplusGLSurfaceView_13 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (OplusGLSurfaceView_13 == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.IntrinsicsJvm.kt_4[] bVarArrM2600b = PathParser.m2600b(string);
            PathParser.IntrinsicsJvm.kt_4[] bVarArrM2600b2 = PathParser.m2600b(string2);
            if (bVarArrM2600b == null && bVarArrM2600b2 == null) {
                return null;
            }
            if (bVarArrM2600b == null) {
                if (bVarArrM2600b2 != null) {
                    return PropertyValuesHolder.ofObject(str, new PlatformImplementations.kt_3(), bVarArrM2600b2);
                }
                return null;
            }
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
            if (bVarArrM2600b2 != null) {
                if (!PathParser.m2596a(bVarArrM2600b, bVarArrM2600b2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrM2600b, bVarArrM2600b2);
            } else {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrM2600b);
            }
            return propertyValuesHolderOfObject;
        }
        ArgbEvaluator c0809fM4862a = OplusGLSurfaceView_13 == 3 ? ArgbEvaluator.m4862a() : null;
        if (z3) {
            if (z) {
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
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension2, dimension3);
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension2);
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArray.getDimension(i3, 0.0f);
                } else {
                    dimension = typedArray.getFloat(i3, 0.0f);
                }
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (m4859a(i4)) {
                color2 = typedArray.getColor(i2, 0);
            } else {
                color2 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (m4859a(i5)) {
                    color3 = typedArray.getColor(i3, 0);
                } else {
                    color3 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else if (m4859a(i5)) {
                color = typedArray.getColor(i3, 0);
            } else {
                color = typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || c0809fM4862a == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(c0809fM4862a);
        return propertyValuesHolderOfInt;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m4856a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float COUIBaseListPopupWindow_12, XmlPullParser xmlPullParser) {
        long jM2308a = TypedArrayUtils.m2308a(typedArray, xmlPullParser, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, 1, 300);
        long jM2308a2 = TypedArrayUtils.m2308a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iM2308a = TypedArrayUtils.m2308a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.m2317a(xmlPullParser, "valueFrom") && TypedArrayUtils.m2317a(xmlPullParser, "valueTo")) {
            if (iM2308a == 4) {
                iM2308a = m4843a(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderM4853a = m4853a(typedArray, iM2308a, 5, 6, "");
            if (propertyValuesHolderM4853a != null) {
                valueAnimator.setValues(propertyValuesHolderM4853a);
            }
        }
        valueAnimator.setDuration(jM2308a);
        valueAnimator.setStartDelay(jM2308a2);
        valueAnimator.setRepeatCount(TypedArrayUtils.m2308a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.m2308a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            m4855a(valueAnimator, typedArray2, iM2308a, COUIBaseListPopupWindow_12, xmlPullParser);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m4855a(ValueAnimator valueAnimator, TypedArray typedArray, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strM2314a = TypedArrayUtils.m2314a(typedArray, xmlPullParser, "pathData", 1);
        if (strM2314a != null) {
            String strM2314a2 = TypedArrayUtils.m2314a(typedArray, xmlPullParser, "propertyXName", 2);
            String strM2314a3 = TypedArrayUtils.m2314a(typedArray, xmlPullParser, "propertyYName", 3);
            if (OplusGLSurfaceView_13 != 2) {
            }
            if (strM2314a2 == null && strM2314a3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            m4857a(PathParser.m2593a(strM2314a), objectAnimator, COUIBaseListPopupWindow_12 * 0.5f, strM2314a2, strM2314a3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.m2314a(typedArray, xmlPullParser, "propertyName", 0));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m4857a(Path path, ObjectAnimator objectAnimator, float COUIBaseListPopupWindow_12, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / COUIBaseListPopupWindow_12)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f2 = length / (iMin - 1);
        int OplusGLSurfaceView_13 = 0;
        float f3 = 0.0f;
        int i2 = 0;
        while (true) {
            if (i2 >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(OplusGLSurfaceView_13)).floatValue(), fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f3 += f2;
            int i3 = OplusGLSurfaceView_13 + 1;
            if (i3 < arrayList.size() && f3 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                OplusGLSurfaceView_13 = i3;
            }
            i2++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Animator m4847a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float COUIBaseListPopupWindow_12) throws XmlPullParserException, IOException {
        return m4848a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, COUIBaseListPopupWindow_12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00df, code lost:
    
        if (r23 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e1, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e3, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f1, code lost:
    
        if (r2.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f3, code lost:
    
        r1[r14] = (android.animation.Animator) r2.next();
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ff, code lost:
    
        if (r24 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0101, code lost:
    
        r23.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0105, code lost:
    
        r23.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0108, code lost:
    
        return r0;
     */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.animation.Animator m4848a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.p055a.p056a.AnimatorInflaterCompat.m4848a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PropertyValuesHolder[] m4860a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int OplusGLSurfaceView_13;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4685i);
                    String strM2314a = TypedArrayUtils.m2314a(typedArrayM2311a, xmlPullParser, "propertyName", 3);
                    int iM2308a = TypedArrayUtils.m2308a(typedArrayM2311a, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderM4852a = m4852a(context, resources, theme, xmlPullParser, strM2314a, iM2308a);
                    if (propertyValuesHolderM4852a == null) {
                        propertyValuesHolderM4852a = m4853a(typedArrayM2311a, iM2308a, 0, 1, strM2314a);
                    }
                    if (propertyValuesHolderM4852a != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderM4852a);
                    }
                    typedArrayM2311a.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                propertyValuesHolderArr[OplusGLSurfaceView_13] = (PropertyValuesHolder) arrayList.get(OplusGLSurfaceView_13);
            }
        }
        return propertyValuesHolderArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m4842a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4686j);
        int OplusGLSurfaceView_13 = 0;
        TypedValue typedValueM2320b = TypedArrayUtils.m2320b(typedArrayM2311a, xmlPullParser, Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0);
        if ((typedValueM2320b != null) && m4859a(typedValueM2320b.type)) {
            OplusGLSurfaceView_13 = 3;
        }
        typedArrayM2311a.recycle();
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m4843a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        TypedValue typedValuePeekValue = typedArray.peekValue(OplusGLSurfaceView_13);
        boolean z = typedValuePeekValue != null;
        int i3 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && m4859a(i3)) || (z2 && m4859a(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PropertyValuesHolder m4852a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        int iM4842a = OplusGLSurfaceView_13;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iM4842a == 4) {
                    iM4842a = m4842a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeM4850a = m4850a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), iM4842a, xmlPullParser);
                if (keyframeM4850a != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeM4850a);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), m4849a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, m4849a(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
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
                            m4858a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (iM4842a == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(ArgbEvaluator.m4862a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Keyframe m4849a(Keyframe keyframe, float COUIBaseListPopupWindow_12) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(COUIBaseListPopupWindow_12);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(COUIBaseListPopupWindow_12);
        }
        return Keyframe.ofObject(COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m4858a(Keyframe[] keyframeArr, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2) {
        float f2 = COUIBaseListPopupWindow_12 / ((i2 - OplusGLSurfaceView_13) + 2);
        while (OplusGLSurfaceView_13 <= i2) {
            keyframeArr[OplusGLSurfaceView_13].setFraction(keyframeArr[OplusGLSurfaceView_13 - 1].getFraction() + f2);
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Keyframe m4850a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int OplusGLSurfaceView_13, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe keyframeOfInt;
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4686j);
        float fM2305a = TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueM2320b = TypedArrayUtils.m2320b(typedArrayM2311a, xmlPullParser, Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0);
        boolean z = typedValueM2320b != null;
        if (OplusGLSurfaceView_13 == 4) {
            OplusGLSurfaceView_13 = (z && m4859a(typedValueM2320b.type)) ? 3 : 0;
        }
        if (z) {
            if (OplusGLSurfaceView_13 == 0) {
                keyframeOfInt = Keyframe.ofFloat(fM2305a, TypedArrayUtils.m2305a(typedArrayM2311a, xmlPullParser, Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0, 0.0f));
            } else {
                keyframeOfInt = (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 3) ? Keyframe.ofInt(fM2305a, TypedArrayUtils.m2308a(typedArrayM2311a, xmlPullParser, Downloads.Impl.RequestHeaders.COLUMN_VALUE, 0, 0)) : null;
            }
        } else if (OplusGLSurfaceView_13 == 0) {
            keyframeOfInt = Keyframe.ofFloat(fM2305a);
        } else {
            keyframeOfInt = Keyframe.ofInt(fM2305a);
        }
        int iM2322c = TypedArrayUtils.m2322c(typedArrayM2311a, xmlPullParser, "interpolator", 1, 0);
        if (iM2322c > 0) {
            keyframeOfInt.setInterpolator(AnimationUtilsCompat.m4840a(context, iM2322c));
        }
        typedArrayM2311a.recycle();
        return keyframeOfInt;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static ObjectAnimator m4851a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float COUIBaseListPopupWindow_12, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m4854a(context, resources, theme, attributeSet, objectAnimator, COUIBaseListPopupWindow_12, xmlPullParser);
        return objectAnimator;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static ValueAnimator m4854a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float COUIBaseListPopupWindow_12, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4683g);
        TypedArray typedArrayM2311a2 = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4687k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m4856a(valueAnimator, typedArrayM2311a, typedArrayM2311a2, COUIBaseListPopupWindow_12, xmlPullParser);
        int iM2322c = TypedArrayUtils.m2322c(typedArrayM2311a, xmlPullParser, "interpolator", 0, 0);
        if (iM2322c > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.m4840a(context, iM2322c));
        }
        typedArrayM2311a.recycle();
        if (typedArrayM2311a2 != null) {
            typedArrayM2311a2.recycle();
        }
        return valueAnimator;
    }
}
