package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* renamed from: androidx.appcompat.widget.w */
/* loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final RectF f2009a = new RectF();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ConcurrentHashMap<String, Method> f2010b = new ConcurrentHashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static ConcurrentHashMap<String, Field> f2011c = new ConcurrentHashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f2012d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f2013e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f2014f = -1.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f2015g = -1.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f2016h = -1.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    private int[] f2017i = new int[0];

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f2018j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private TextPaint f2019k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final TextView f2020l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final Context f2021m;

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.f2020l = textView;
        this.f2021m = this.f2020l.getContext();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1755a(AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException, IllegalArgumentException {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f2021m.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, OplusGLSurfaceView_13, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f2012d = typedArrayObtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m1739a(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (m1749k()) {
            if (this.f2012d == 1) {
                if (!this.f2018j) {
                    DisplayMetrics displayMetrics = this.f2021m.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    m1738a(dimension2, dimension3, dimension);
                }
                m1747i();
                return;
            }
            return;
        }
        this.f2012d = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1752a(int OplusGLSurfaceView_13) throws IllegalArgumentException {
        if (m1749k()) {
            if (OplusGLSurfaceView_13 == 0) {
                m1748j();
                return;
            }
            if (OplusGLSurfaceView_13 == 1) {
                DisplayMetrics displayMetrics = this.f2021m.getResources().getDisplayMetrics();
                m1738a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (m1747i()) {
                    m1762f();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Unknown auto-size text type: " + OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1754a(int OplusGLSurfaceView_13, int i2, int i3, int i4) throws IllegalArgumentException {
        if (m1749k()) {
            DisplayMetrics displayMetrics = this.f2021m.getResources().getDisplayMetrics();
            m1738a(TypedValue.applyDimension(i4, OplusGLSurfaceView_13, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m1747i()) {
                m1762f();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1756a(int[] iArr, int OplusGLSurfaceView_13) throws IllegalArgumentException {
        if (m1749k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (OplusGLSurfaceView_13 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f2021m.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(OplusGLSurfaceView_13, iArr[i2], displayMetrics));
                    }
                }
                this.f2017i = m1741a(iArrCopyOf);
                if (!m1746h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f2018j = false;
            }
            if (m1747i()) {
                m1762f();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m1750a() {
        return this.f2012d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    int m1757b() {
        return Math.round(this.f2014f);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    int m1759c() {
        return Math.round(this.f2015g);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    int m1760d() {
        return Math.round(this.f2016h);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    int[] m1761e() {
        return this.f2017i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1739a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                iArr[OplusGLSurfaceView_13] = typedArray.getDimensionPixelSize(OplusGLSurfaceView_13, -1);
            }
            this.f2017i = m1741a(iArr);
            m1746h();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m1746h() {
        this.f2018j = this.f2017i.length > 0;
        if (this.f2018j) {
            this.f2012d = 1;
            int[] iArr = this.f2017i;
            this.f2015g = iArr[0];
            this.f2016h = iArr[r0 - 1];
            this.f2014f = -1.0f;
        }
        return this.f2018j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] m1741a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 : iArr) {
            if (OplusGLSurfaceView_13 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(OplusGLSurfaceView_13)) < 0) {
                arrayList.add(Integer.valueOf(OplusGLSurfaceView_13));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1738a(float COUIBaseListPopupWindow_12, float f2, float f3) throws IllegalArgumentException {
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + COUIBaseListPopupWindow_12 + "px) is less or equal to (0px)");
        }
        if (f2 <= COUIBaseListPopupWindow_12) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + COUIBaseListPopupWindow_12 + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f2012d = 1;
        this.f2015g = COUIBaseListPopupWindow_12;
        this.f2016h = f2;
        this.f2014f = f3;
        this.f2018j = false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m1747i() {
        if (m1749k() && this.f2012d == 1) {
            if (!this.f2018j || this.f2017i.length == 0) {
                int iFloor = ((int) Math.floor((this.f2016h - this.f2015g) / this.f2014f)) + 1;
                int[] iArr = new int[iFloor];
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iFloor; OplusGLSurfaceView_13++) {
                    iArr[OplusGLSurfaceView_13] = Math.round(this.f2015g + (OplusGLSurfaceView_13 * this.f2014f));
                }
                this.f2017i = m1741a(iArr);
            }
            this.f2013e = true;
        } else {
            this.f2013e = false;
        }
        return this.f2013e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    void m1762f() {
        boolean zBooleanValue;
        if (m1763g()) {
            if (this.f2013e) {
                if (this.f2020l.getMeasuredHeight() <= 0 || this.f2020l.getMeasuredWidth() <= 0) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    zBooleanValue = this.f2020l.isHorizontallyScrollable();
                } else {
                    zBooleanValue = ((Boolean) m1735a(this.f2020l, "getHorizontallyScrolling", false)).booleanValue();
                }
                int measuredWidth = zBooleanValue ? ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES : (this.f2020l.getMeasuredWidth() - this.f2020l.getTotalPaddingLeft()) - this.f2020l.getTotalPaddingRight();
                int height = (this.f2020l.getHeight() - this.f2020l.getCompoundPaddingBottom()) - this.f2020l.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (f2009a) {
                    f2009a.setEmpty();
                    f2009a.right = measuredWidth;
                    f2009a.bottom = height;
                    float fM1733a = m1733a(f2009a);
                    if (fM1733a != this.f2020l.getTextSize()) {
                        m1753a(0, fM1733a);
                    }
                }
            }
            this.f2013e = true;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m1748j() {
        this.f2012d = 0;
        this.f2015g = -1.0f;
        this.f2016h = -1.0f;
        this.f2014f = -1.0f;
        this.f2017i = new int[0];
        this.f2013e = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1753a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Resources resources;
        Context context = this.f2021m;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        m1737a(TypedValue.applyDimension(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, resources.getDisplayMetrics()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1737a(float COUIBaseListPopupWindow_12) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (COUIBaseListPopupWindow_12 != this.f2020l.getPaint().getTextSize()) {
            this.f2020l.getPaint().setTextSize(COUIBaseListPopupWindow_12);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.f2020l.isInLayout() : false;
            if (this.f2020l.getLayout() != null) {
                this.f2013e = false;
                try {
                    Method methodM1736a = m1736a("nullLayouts");
                    if (methodM1736a != null) {
                        methodM1736a.invoke(this.f2020l, new Object[0]);
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", COUIBaseListPopupWindow_8);
                }
                if (!zIsInLayout) {
                    this.f2020l.requestLayout();
                } else {
                    this.f2020l.forceLayout();
                }
                this.f2020l.invalidate();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m1733a(RectF rectF) {
        int OplusGLSurfaceView_13;
        int length = this.f2017i.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = length - 1;
        while (true) {
            int i5 = i3;
            int i6 = i2;
            i2 = i5;
            while (i2 <= i4) {
                OplusGLSurfaceView_13 = (i2 + i4) / 2;
                if (m1740a(this.f2017i[OplusGLSurfaceView_13], rectF)) {
                    break;
                }
                i6 = OplusGLSurfaceView_13 - 1;
                i4 = i6;
            }
            return this.f2017i[i6];
            i3 = OplusGLSurfaceView_13 + 1;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1758b(int OplusGLSurfaceView_13) {
        TextPaint textPaint = this.f2019k;
        if (textPaint == null) {
            this.f2019k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f2019k.set(this.f2020l.getPaint());
        this.f2019k.setTextSize(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    StaticLayout m1751a(CharSequence charSequence, Layout.Alignment alignment, int OplusGLSurfaceView_13, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return m1743b(charSequence, alignment, OplusGLSurfaceView_13, i2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return m1734a(charSequence, alignment, OplusGLSurfaceView_13);
        }
        return m1742b(charSequence, alignment, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1740a(int OplusGLSurfaceView_13, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f2020l.getText();
        TransformationMethod transformationMethod = this.f2020l.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f2020l)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f2020l.getMaxLines() : -1;
        m1758b(OplusGLSurfaceView_13);
        StaticLayout staticLayoutM1751a = m1751a(text, (Layout.Alignment) m1735a(this.f2020l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutM1751a.getLineCount() <= maxLines && staticLayoutM1751a.getLineEnd(staticLayoutM1751a.getLineCount() - 1) == text.length())) && ((float) staticLayoutM1751a.getHeight()) <= rectF.bottom;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private StaticLayout m1743b(CharSequence charSequence, Layout.Alignment alignment, int OplusGLSurfaceView_13, int i2) {
        TextDirectionHeuristic textDirectionHeuristic;
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f2019k, OplusGLSurfaceView_13);
        StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(this.f2020l.getLineSpacingExtra(), this.f2020l.getLineSpacingMultiplier()).setIncludePad(this.f2020l.getIncludeFontPadding()).setBreakStrategy(this.f2020l.getBreakStrategy()).setHyphenationFrequency(this.f2020l.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                textDirectionHeuristic = this.f2020l.getTextDirectionHeuristic();
            } else {
                textDirectionHeuristic = (TextDirectionHeuristic) m1735a(this.f2020l, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
            }
            builderObtain.setTextDirection(textDirectionHeuristic);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return builderObtain.build();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private StaticLayout m1734a(CharSequence charSequence, Layout.Alignment alignment, int OplusGLSurfaceView_13) {
        return new StaticLayout(charSequence, this.f2019k, OplusGLSurfaceView_13, alignment, this.f2020l.getLineSpacingMultiplier(), this.f2020l.getLineSpacingExtra(), this.f2020l.getIncludeFontPadding());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private StaticLayout m1742b(CharSequence charSequence, Layout.Alignment alignment, int OplusGLSurfaceView_13) {
        return new StaticLayout(charSequence, this.f2019k, OplusGLSurfaceView_13, alignment, ((Float) m1744b(this.f2020l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) m1744b(this.f2020l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) m1744b(this.f2020l, "mIncludePad", true)).booleanValue());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> T m1735a(Object obj, String str, T t) {
        try {
            return (T) m1736a(str).invoke(obj, new Object[0]);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", COUIBaseListPopupWindow_8);
            return t;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static <T> T m1744b(Object obj, String str, T t) {
        try {
            Field fieldM1745b = m1745b(str);
            return fieldM1745b == null ? t : (T) fieldM1745b.get(obj);
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", COUIBaseListPopupWindow_8);
            return t;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method m1736a(String str) {
        try {
            Method declaredMethod = f2010b.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f2010b.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Field m1745b(String str) {
        try {
            Field declaredField = f2011c.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                f2011c.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean m1763g() {
        return m1749k() && this.f2012d != 0;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m1749k() {
        return !(this.f2020l instanceof AppCompatEditText);
    }
}
