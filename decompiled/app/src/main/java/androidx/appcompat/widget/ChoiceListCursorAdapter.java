package androidx.appcompat.widget;

/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* loaded from: classes.dex */
class w_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.graphics.RectF f650a = new android.graphics.RectF();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.reflect.Method> f651b = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.reflect.Field> f652c = new java.util.concurrent.ConcurrentHashMap<>();
    private int d_renamed = 0;
    private boolean e_renamed = false;
    private float f_renamed = -1.0f;
    private float g_renamed = -1.0f;
    private float h_renamed = -1.0f;
    private int[] i_renamed = new int[0];
    private boolean j_renamed = false;
    private android.text.TextPaint k_renamed;
    private final android.widget.TextView l_renamed;
    private final android.content.Context m_renamed;

    w_renamed(android.widget.TextView textView) {
        this.l_renamed = textView;
        this.m_renamed = this.l_renamed.getContext();
    }

    void a_renamed(android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        int resourceId;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.m_renamed.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.AppCompatTextView, i_renamed, 0);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeTextType)) {
            this.d_renamed = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            android.content.res.TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            a_renamed(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (k_renamed()) {
            if (this.d_renamed == 1) {
                if (!this.j_renamed) {
                    android.util.DisplayMetrics displayMetrics = this.m_renamed.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = android.util.TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = android.util.TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    a_renamed(dimension2, dimension3, dimension);
                }
                i_renamed();
                return;
            }
            return;
        }
        this.d_renamed = 0;
    }

    void a_renamed(int i_renamed) throws java.lang.IllegalArgumentException {
        if (k_renamed()) {
            if (i_renamed == 0) {
                j_renamed();
                return;
            }
            if (i_renamed == 1) {
                android.util.DisplayMetrics displayMetrics = this.m_renamed.getResources().getDisplayMetrics();
                a_renamed(android.util.TypedValue.applyDimension(2, 12.0f, displayMetrics), android.util.TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (i_renamed()) {
                    f_renamed();
                    return;
                }
                return;
            }
            throw new java.lang.IllegalArgumentException("Unknown auto-size text type: " + i_renamed);
        }
    }

    void a_renamed(int i_renamed, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        if (k_renamed()) {
            android.util.DisplayMetrics displayMetrics = this.m_renamed.getResources().getDisplayMetrics();
            a_renamed(android.util.TypedValue.applyDimension(i4, i_renamed, displayMetrics), android.util.TypedValue.applyDimension(i4, i2, displayMetrics), android.util.TypedValue.applyDimension(i4, i3, displayMetrics));
            if (i_renamed()) {
                f_renamed();
            }
        }
    }

    void a_renamed(int[] iArr, int i_renamed) throws java.lang.IllegalArgumentException {
        if (k_renamed()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i_renamed == 0) {
                    iArrCopyOf = java.util.Arrays.copyOf(iArr, length);
                } else {
                    android.util.DisplayMetrics displayMetrics = this.m_renamed.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = java.lang.Math.round(android.util.TypedValue.applyDimension(i_renamed, iArr[i2], displayMetrics));
                    }
                }
                this.i_renamed = a_renamed(iArrCopyOf);
                if (!h_renamed()) {
                    throw new java.lang.IllegalArgumentException("None of_renamed the preset sizes is_renamed valid: " + java.util.Arrays.toString(iArr));
                }
            } else {
                this.j_renamed = false;
            }
            if (i_renamed()) {
                f_renamed();
            }
        }
    }

    int a_renamed() {
        return this.d_renamed;
    }

    int b_renamed() {
        return java.lang.Math.round(this.f_renamed);
    }

    int c_renamed() {
        return java.lang.Math.round(this.g_renamed);
    }

    int d_renamed() {
        return java.lang.Math.round(this.h_renamed);
    }

    int[] e_renamed() {
        return this.i_renamed;
    }

    private void a_renamed(android.content.res.TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                iArr[i_renamed] = typedArray.getDimensionPixelSize(i_renamed, -1);
            }
            this.i_renamed = a_renamed(iArr);
            h_renamed();
        }
    }

    private boolean h_renamed() {
        this.j_renamed = this.i_renamed.length > 0;
        if (this.j_renamed) {
            this.d_renamed = 1;
            int[] iArr = this.i_renamed;
            this.g_renamed = iArr[0];
            this.h_renamed = iArr[r0 - 1];
            this.f_renamed = -1.0f;
        }
        return this.j_renamed;
    }

    private int[] a_renamed(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        java.util.Arrays.sort(iArr);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed : iArr) {
            if (i_renamed > 0 && java.util.Collections.binarySearch(arrayList, java.lang.Integer.valueOf(i_renamed)) < 0) {
                arrayList.add(java.lang.Integer.valueOf(i_renamed));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((java.lang.Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    private void a_renamed(float f_renamed, float f2, float f3) throws java.lang.IllegalArgumentException {
        if (f_renamed <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Minimum auto-size text size (" + f_renamed + "px) is_renamed less or equal to (0px)");
        }
        if (f2 <= f_renamed) {
            throw new java.lang.IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is_renamed less or equal to minimum auto-size text size (" + f_renamed + "px)");
        }
        if (f3 <= 0.0f) {
            throw new java.lang.IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is_renamed less or equal to (0px)");
        }
        this.d_renamed = 1;
        this.g_renamed = f_renamed;
        this.h_renamed = f2;
        this.f_renamed = f3;
        this.j_renamed = false;
    }

    private boolean i_renamed() {
        if (k_renamed() && this.d_renamed == 1) {
            if (!this.j_renamed || this.i_renamed.length == 0) {
                int iFloor = ((int) java.lang.Math.floor((this.h_renamed - this.g_renamed) / this.f_renamed)) + 1;
                int[] iArr = new int[iFloor];
                for (int i_renamed = 0; i_renamed < iFloor; i_renamed++) {
                    iArr[i_renamed] = java.lang.Math.round(this.g_renamed + (i_renamed * this.f_renamed));
                }
                this.i_renamed = a_renamed(iArr);
            }
            this.e_renamed = true;
        } else {
            this.e_renamed = false;
        }
        return this.e_renamed;
    }

    void f_renamed() {
        boolean zBooleanValue;
        if (g_renamed()) {
            if (this.e_renamed) {
                if (this.l_renamed.getMeasuredHeight() <= 0 || this.l_renamed.getMeasuredWidth() <= 0) {
                    return;
                }
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    zBooleanValue = this.l_renamed.isHorizontallyScrollable();
                } else {
                    zBooleanValue = ((java.lang.Boolean) a_renamed(this.l_renamed, "getHorizontallyScrolling", false)).booleanValue();
                }
                int measuredWidth = zBooleanValue ? com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES : (this.l_renamed.getMeasuredWidth() - this.l_renamed.getTotalPaddingLeft()) - this.l_renamed.getTotalPaddingRight();
                int height = (this.l_renamed.getHeight() - this.l_renamed.getCompoundPaddingBottom()) - this.l_renamed.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (f650a) {
                    f650a.setEmpty();
                    f650a.right = measuredWidth;
                    f650a.bottom = height;
                    float fA_renamed = a_renamed(f650a);
                    if (fA_renamed != this.l_renamed.getTextSize()) {
                        a_renamed(0, fA_renamed);
                    }
                }
            }
            this.e_renamed = true;
        }
    }

    private void j_renamed() {
        this.d_renamed = 0;
        this.g_renamed = -1.0f;
        this.h_renamed = -1.0f;
        this.f_renamed = -1.0f;
        this.i_renamed = new int[0];
        this.e_renamed = false;
    }

    void a_renamed(int i_renamed, float f_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.content.res.Resources resources;
        android.content.Context context = this.m_renamed;
        if (context == null) {
            resources = android.content.res.Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        a_renamed(android.util.TypedValue.applyDimension(i_renamed, f_renamed, resources.getDisplayMetrics()));
    }

    private void a_renamed(float f_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (f_renamed != this.l_renamed.getPaint().getTextSize()) {
            this.l_renamed.getPaint().setTextSize(f_renamed);
            boolean zIsInLayout = android.os.Build.VERSION.SDK_INT >= 18 ? this.l_renamed.isInLayout() : false;
            if (this.l_renamed.getLayout() != null) {
                this.e_renamed = false;
                try {
                    java.lang.reflect.Method methodA = a_renamed("nullLayouts");
                    if (methodA != null) {
                        methodA.invoke(this.l_renamed, new java.lang.Object[0]);
                    }
                } catch (java.lang.Exception e_renamed) {
                    android.util.Log.w_renamed("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e_renamed);
                }
                if (!zIsInLayout) {
                    this.l_renamed.requestLayout();
                } else {
                    this.l_renamed.forceLayout();
                }
                this.l_renamed.invalidate();
            }
        }
    }

    private int a_renamed(android.graphics.RectF rectF) {
        int i_renamed;
        int length = this.i_renamed.length;
        if (length == 0) {
            throw new java.lang.IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = length - 1;
        while (true) {
            int i5 = i3;
            int i6 = i2;
            i2 = i5;
            while (i2 <= i4) {
                i_renamed = (i2 + i4) / 2;
                if (a_renamed(this.i_renamed[i_renamed], rectF)) {
                    break;
                }
                i6 = i_renamed - 1;
                i4 = i6;
            }
            return this.i_renamed[i6];
            i3 = i_renamed + 1;
        }
    }

    void b_renamed(int i_renamed) {
        android.text.TextPaint textPaint = this.k_renamed;
        if (textPaint == null) {
            this.k_renamed = new android.text.TextPaint();
        } else {
            textPaint.reset();
        }
        this.k_renamed.set(this.l_renamed.getPaint());
        this.k_renamed.setTextSize(i_renamed);
    }

    android.text.StaticLayout a_renamed(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i_renamed, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return b_renamed(charSequence, alignment, i_renamed, i2);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return a_renamed(charSequence, alignment, i_renamed);
        }
        return b_renamed(charSequence, alignment, i_renamed);
    }

    private boolean a_renamed(int i_renamed, android.graphics.RectF rectF) {
        java.lang.CharSequence transformation;
        java.lang.CharSequence text = this.l_renamed.getText();
        android.text.method.TransformationMethod transformationMethod = this.l_renamed.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.l_renamed)) != null) {
            text = transformation;
        }
        int maxLines = android.os.Build.VERSION.SDK_INT >= 16 ? this.l_renamed.getMaxLines() : -1;
        b_renamed(i_renamed);
        android.text.StaticLayout staticLayoutA = a_renamed(text, (android.text.Layout.Alignment) a_renamed(this.l_renamed, "getLayoutAlignment", android.text.Layout.Alignment.ALIGN_NORMAL), java.lang.Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutA.getLineCount() <= maxLines && staticLayoutA.getLineEnd(staticLayoutA.getLineCount() - 1) == text.length())) && ((float) staticLayoutA.getHeight()) <= rectF.bottom;
    }

    private android.text.StaticLayout b_renamed(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i_renamed, int i2) {
        android.text.TextDirectionHeuristic textDirectionHeuristic;
        android.text.StaticLayout.Builder builderObtain = android.text.StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.k_renamed, i_renamed);
        android.text.StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(this.l_renamed.getLineSpacingExtra(), this.l_renamed.getLineSpacingMultiplier()).setIncludePad(this.l_renamed.getIncludeFontPadding()).setBreakStrategy(this.l_renamed.getBreakStrategy()).setHyphenationFrequency(this.l_renamed.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                textDirectionHeuristic = this.l_renamed.getTextDirectionHeuristic();
            } else {
                textDirectionHeuristic = (android.text.TextDirectionHeuristic) a_renamed(this.l_renamed, "getTextDirectionHeuristic", android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR);
            }
            builderObtain.setTextDirection(textDirectionHeuristic);
        } catch (java.lang.ClassCastException unused) {
            android.util.Log.w_renamed("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be_renamed incorrect");
        }
        return builderObtain.build();
    }

    private android.text.StaticLayout a_renamed(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i_renamed) {
        return new android.text.StaticLayout(charSequence, this.k_renamed, i_renamed, alignment, this.l_renamed.getLineSpacingMultiplier(), this.l_renamed.getLineSpacingExtra(), this.l_renamed.getIncludeFontPadding());
    }

    private android.text.StaticLayout b_renamed(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i_renamed) {
        return new android.text.StaticLayout(charSequence, this.k_renamed, i_renamed, alignment, ((java.lang.Float) b_renamed(this.l_renamed, "mSpacingMult", java.lang.Float.valueOf(1.0f))).floatValue(), ((java.lang.Float) b_renamed(this.l_renamed, "mSpacingAdd", java.lang.Float.valueOf(0.0f))).floatValue(), ((java.lang.Boolean) b_renamed(this.l_renamed, "mIncludePad", true)).booleanValue());
    }

    private static <T_renamed> T_renamed a_renamed(java.lang.Object obj, java.lang.String str, T_renamed t_renamed) {
        try {
            return (T_renamed) a_renamed(str).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.w_renamed("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e_renamed);
            return t_renamed;
        }
    }

    private static <T_renamed> T_renamed b_renamed(java.lang.Object obj, java.lang.String str, T_renamed t_renamed) {
        try {
            java.lang.reflect.Field fieldB = b_renamed(str);
            return fieldB == null ? t_renamed : (T_renamed) fieldB.get(obj);
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.w_renamed("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e_renamed);
            return t_renamed;
        }
    }

    private static java.lang.reflect.Method a_renamed(java.lang.String str) {
        try {
            java.lang.reflect.Method declaredMethod = f651b.get(str);
            if (declaredMethod == null && (declaredMethod = android.widget.TextView.class.getDeclaredMethod(str, new java.lang.Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f651b.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.w_renamed("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e_renamed);
            return null;
        }
    }

    private static java.lang.reflect.Field b_renamed(java.lang.String str) {
        try {
            java.lang.reflect.Field declaredField = f652c.get(str);
            if (declaredField == null && (declaredField = android.widget.TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                f652c.put(str, declaredField);
            }
            return declaredField;
        } catch (java.lang.NoSuchFieldException e_renamed) {
            android.util.Log.w_renamed("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e_renamed);
            return null;
        }
    }

    boolean g_renamed() {
        return k_renamed() && this.d_renamed != 0;
    }

    private boolean k_renamed() {
        return !(this.l_renamed instanceof androidx.appcompat.widget.j_renamed);
    }
}
