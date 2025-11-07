package com.google.android.material.slider;

/* loaded from: classes.dex */
public class Slider extends android.view.View {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_Slider;
    private static final java.lang.String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value must be_renamed equal to valueFrom plus a_renamed multiple of_renamed stepSize when using stepSize";
    private static final java.lang.String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize must be_renamed 0, or a_renamed factor of_renamed the valueFrom-valueTo range";
    private static final java.lang.String EXCEPTION_ILLEGAL_VALUE = "Slider value must be_renamed greater or equal to valueFrom, and lower or equal to valueTo";
    private static final java.lang.String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom must be_renamed smaller than valueTo";
    private static final java.lang.String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo must be_renamed greater than valueFrom";
    private static final int HALO_ALPHA = 63;
    public static final int LABEL_FLOATING = 0;
    public static final int LABEL_GONE = 2;
    public static final int LABEL_WITHIN_BOUNDS = 1;
    private static final java.lang.String TAG = "Slider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private com.google.android.material.slider.Slider.AccessibilityEventSender accessibilityEventSender;
    private final com.google.android.material.slider.Slider.AccessibilityHelper accessibilityHelper;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    private final android.graphics.Paint activeTicksPaint;
    private final android.graphics.Paint activeTrackPaint;
    private final java.util.List<com.google.android.material.slider.Slider.OnChangeListener> changeListeners;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private com.google.android.material.slider.Slider.LabelFormatter formatter;
    private android.content.res.ColorStateList haloColor;
    private final android.graphics.Paint haloPaint;
    private int haloRadius;
    private final android.graphics.Paint inactiveTicksPaint;
    private final android.graphics.Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private final com.google.android.material.slider.Slider.TooltipDrawableFactory labelMaker;
    private int labelPadding;
    private final java.util.List<com.google.android.material.tooltip.TooltipDrawable> labels;
    private android.view.MotionEvent lastEvent;
    private final int scaledTouchSlop;
    private float stepSize;
    private final com.google.android.material.shape.MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;
    private final android.graphics.Paint thumbPaint;
    private int thumbRadius;
    private android.content.res.ColorStateList tickColorActive;
    private android.content.res.ColorStateList tickColorInactive;
    private float[] ticksCoordinates;
    private float touchDownX;
    private final java.util.List<com.google.android.material.slider.Slider.OnSliderTouchListener> touchListeners;
    private float touchPosition;
    private android.content.res.ColorStateList trackColorActive;
    private android.content.res.ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private java.util.ArrayList<java.lang.Float> values;
    private int widgetHeight;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface LabelBehavior {
    }

    public interface LabelFormatter {
        java.lang.String getFormattedValue(float f_renamed);
    }

    public interface OnChangeListener {
        void onValueChange(com.google.android.material.slider.Slider slider, float f_renamed, boolean z_renamed);
    }

    public interface OnSliderTouchListener {
        void onStartTrackingTouch(com.google.android.material.slider.Slider slider);

        void onStopTrackingTouch(com.google.android.material.slider.Slider slider);
    }

    private interface TooltipDrawableFactory {
        com.google.android.material.tooltip.TooltipDrawable createTooltipDrawable();
    }

    public static final class BasicLabelFormatter implements com.google.android.material.slider.Slider.LabelFormatter {
        private static final int BILLION = 1000000000;
        private static final int MILLION = 1000000;
        private static final int THOUSAND = 1000;
        private static final long TRILLION = 1000000000000L;

        @Override // com.google.android.material.slider.Slider.LabelFormatter
        public java.lang.String getFormattedValue(float f_renamed) {
            return f_renamed >= 1.0E12f ? java.lang.String.format(java.util.Locale.US, "%.1fT", java.lang.Float.valueOf(f_renamed / 1.0E12f)) : f_renamed >= 1.0E9f ? java.lang.String.format(java.util.Locale.US, "%.1fB", java.lang.Float.valueOf(f_renamed / 1.0E9f)) : f_renamed >= 1000000.0f ? java.lang.String.format(java.util.Locale.US, "%.1fM", java.lang.Float.valueOf(f_renamed / 1000000.0f)) : f_renamed >= 1000.0f ? java.lang.String.format(java.util.Locale.US, "%.1fK", java.lang.Float.valueOf(f_renamed / 1000.0f)) : java.lang.String.format(java.util.Locale.US, "%.0f", java.lang.Float.valueOf(f_renamed));
        }
    }

    public Slider(android.content.Context context) {
        this(context, null);
    }

    public Slider(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.sliderStyle);
    }

    public Slider(android.content.Context context, final android.util.AttributeSet attributeSet, final int i_renamed) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.labels = new java.util.ArrayList();
        this.changeListeners = new java.util.ArrayList();
        this.touchListeners = new java.util.ArrayList();
        this.thumbIsPressed = false;
        this.values = new java.util.ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        this.thumbDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        android.content.Context context2 = getContext();
        this.inactiveTrackPaint = new android.graphics.Paint();
        this.inactiveTrackPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.inactiveTrackPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.activeTrackPaint = new android.graphics.Paint();
        this.activeTrackPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.activeTrackPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.thumbPaint = new android.graphics.Paint(1);
        this.thumbPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.thumbPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        this.haloPaint = new android.graphics.Paint(1);
        this.haloPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.inactiveTicksPaint = new android.graphics.Paint();
        this.inactiveTicksPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.inactiveTicksPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.activeTicksPaint = new android.graphics.Paint();
        this.activeTicksPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.activeTicksPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new com.google.android.material.slider.Slider.TooltipDrawableFactory() { // from class: com.google.android.material.slider.Slider.1
            @Override // com.google.android.material.slider.Slider.TooltipDrawableFactory
            public com.google.android.material.tooltip.TooltipDrawable createTooltipDrawable() {
                android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(com.google.android.material.slider.Slider.this.getContext(), attributeSet, com.google.android.material.R_renamed.styleable.Slider, i_renamed, com.google.android.material.slider.Slider.DEF_STYLE_RES, new int[0]);
                com.google.android.material.tooltip.TooltipDrawable labelDrawable = com.google.android.material.slider.Slider.parseLabelDrawable(com.google.android.material.slider.Slider.this.getContext(), typedArrayObtainStyledAttributes);
                typedArrayObtainStyledAttributes.recycle();
                return labelDrawable;
            }
        };
        processAttributes(context2, attributeSet, i_renamed);
        setFocusable(true);
        this.thumbDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = android.view.ViewConfiguration.get(context2).getScaledTouchSlop();
        this.accessibilityHelper = new com.google.android.material.slider.Slider.AccessibilityHelper();
        androidx.core.h_renamed.v_renamed.a_renamed(this, this.accessibilityHelper);
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void loadResources(android.content.res.Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_slider_widget_height);
        this.trackSidePadding = resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_slider_track_side_padding);
        this.trackTop = resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_slider_label_padding);
    }

    private void processAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R_renamed.styleable.Slider, i_renamed, DEF_STYLE_RES, new int[0]);
        this.valueFrom = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.Slider_android_valueTo, 1.0f);
        setValue(typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.Slider_android_value, this.valueFrom));
        this.stepSize = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.Slider_android_stepSize, 0.0f);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Slider_trackColor);
        int i2 = zHasValue ? com.google.android.material.R_renamed.styleable.Slider_trackColor : com.google.android.material.R_renamed.styleable.Slider_trackColorInactive;
        int i3 = zHasValue ? com.google.android.material.R_renamed.styleable.Slider_trackColor : com.google.android.material.R_renamed.styleable.Slider_trackColorActive;
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i2);
        if (colorStateList == null) {
            colorStateList = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, com.google.android.material.R_renamed.color.material_slider_inactive_track_color);
        }
        setTrackColorInactive(colorStateList);
        android.content.res.ColorStateList colorStateList2 = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i3);
        if (colorStateList2 == null) {
            colorStateList2 = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, com.google.android.material.R_renamed.color.material_slider_active_track_color);
        }
        setTrackColorActive(colorStateList2);
        this.thumbDrawable.setFillColor(com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Slider_thumbColor));
        android.content.res.ColorStateList colorStateList3 = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, com.google.android.material.R_renamed.color.material_slider_halo_color);
        }
        setHaloColor(colorStateList3);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Slider_tickColor);
        int i4 = zHasValue2 ? com.google.android.material.R_renamed.styleable.Slider_tickColor : com.google.android.material.R_renamed.styleable.Slider_tickColorInactive;
        int i5 = zHasValue2 ? com.google.android.material.R_renamed.styleable.Slider_tickColor : com.google.android.material.R_renamed.styleable.Slider_tickColorActive;
        android.content.res.ColorStateList colorStateList4 = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i4);
        if (colorStateList4 == null) {
            colorStateList4 = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, com.google.android.material.R_renamed.color.material_slider_inactive_tick_marks_color);
        }
        setTickColorInactive(colorStateList4);
        android.content.res.ColorStateList colorStateList5 = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i5);
        if (colorStateList5 == null) {
            colorStateList5 = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, com.google.android.material.R_renamed.color.material_slider_active_tick_marks_color);
        }
        setTickColorActive(colorStateList5);
        setThumbRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Slider_trackHeight, 0));
        this.labelBehavior = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.Slider_labelBehavior, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.android.material.tooltip.TooltipDrawable parseLabelDrawable(android.content.Context context, android.content.res.TypedArray typedArray) {
        return com.google.android.material.tooltip.TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(com.google.android.material.R_renamed.styleable.Slider_labelStyle, com.google.android.material.R_renamed.style.Widget_MaterialComponents_Tooltip));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            throw new java.lang.IllegalStateException(EXCEPTION_ILLEGAL_VALUE_FROM);
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            throw new java.lang.IllegalStateException(EXCEPTION_ILLEGAL_VALUE_TO);
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && ((this.valueTo - this.valueFrom) / r0) % 1.0f > THRESHOLD) {
            throw new java.lang.IllegalStateException(EXCEPTION_ILLEGAL_STEP_SIZE);
        }
    }

    private void validateValues() {
        java.util.Iterator<java.lang.Float> it = this.values.iterator();
        while (it.hasNext()) {
            java.lang.Float next = it.next();
            if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                throw new java.lang.IllegalStateException(EXCEPTION_ILLEGAL_VALUE);
            }
            if (this.stepSize > 0.0f && ((this.valueFrom - next.floatValue()) / this.stepSize) % 1.0f > THRESHOLD) {
                throw new java.lang.IllegalStateException(EXCEPTION_ILLEGAL_DISCRETE_VALUE);
            }
        }
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            this.dirtyConfig = false;
        }
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public void setValueFrom(float f_renamed) {
        this.valueFrom = f_renamed;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public void setValueTo(float f_renamed) {
        this.valueTo = f_renamed;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public float getValue() {
        if (this.values.size() > 1) {
            throw new java.lang.IllegalStateException("More than one value is_renamed set on_renamed the Slider. Use getValues() instead.");
        }
        return this.values.get(0).floatValue();
    }

    public java.util.List<java.lang.Float> getValues() {
        return new java.util.ArrayList(this.values);
    }

    public void setValue(float f_renamed) {
        setValues(java.lang.Float.valueOf(f_renamed));
    }

    public void setValues(java.lang.Float... fArr) {
        java.util.ArrayList<java.lang.Float> arrayList = new java.util.ArrayList<>();
        java.util.Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public void setValues(java.util.List<java.lang.Float> list) {
        setValuesInternal(new java.util.ArrayList<>(list));
    }

    private void setValuesInternal(java.util.ArrayList<java.lang.Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new java.lang.IllegalArgumentException("At least one value must be_renamed set");
        }
        java.util.Collections.sort(arrayList);
        if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
            return;
        }
        this.values = arrayList;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgramatically();
        postInvalidate();
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            this.labels.subList(this.values.size(), this.labels.size()).clear();
        }
        while (this.labels.size() < this.values.size()) {
            this.labels.add(this.labelMaker.createTooltipDrawable());
        }
        int i_renamed = this.labels.size() == 1 ? 0 : 1;
        java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(i_renamed);
        }
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public void setStepSize(float f_renamed) {
        if (f_renamed < 0.0f) {
            throw new java.lang.IllegalArgumentException(EXCEPTION_ILLEGAL_STEP_SIZE);
        }
        if (this.stepSize != f_renamed) {
            this.stepSize = f_renamed;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public float getMaximumValue() {
        return this.values.get(r1.size() - 1).floatValue();
    }

    public float getMinimumValue() {
        return this.values.get(0).floatValue();
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public void setFocusedThumbIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.values.size()) {
            throw new java.lang.IllegalArgumentException("index out of_renamed range");
        }
        this.focusedThumbIdx = i_renamed;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        postInvalidate();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public void addOnChangeListener(com.google.android.material.slider.Slider.OnChangeListener onChangeListener) {
        this.changeListeners.add(onChangeListener);
    }

    public void removeOnChangeListener(com.google.android.material.slider.Slider.OnChangeListener onChangeListener) {
        this.changeListeners.remove(onChangeListener);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void addOnSliderTouchListener(com.google.android.material.slider.Slider.OnSliderTouchListener onSliderTouchListener) {
        this.touchListeners.add(onSliderTouchListener);
    }

    public void removeOnSliderTouchListener(com.google.android.material.slider.Slider.OnSliderTouchListener onSliderTouchListener) {
        this.touchListeners.remove(onSliderTouchListener);
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public void setLabelFormatter(com.google.android.material.slider.Slider.LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    public void setThumbElevation(float f_renamed) {
        this.thumbDrawable.setElevation(f_renamed);
    }

    public void setThumbElevationResource(int i_renamed) {
        setThumbElevation(getResources().getDimension(i_renamed));
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public void setThumbRadius(int i_renamed) {
        if (i_renamed == this.thumbRadius) {
            return;
        }
        this.thumbRadius = i_renamed;
        this.thumbDrawable.setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        int i2 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i2 * 2, i2 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(int i_renamed) {
        setThumbRadius(getResources().getDimensionPixelSize(i_renamed));
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public void setHaloRadius(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (i_renamed == this.haloRadius) {
            return;
        }
        this.haloRadius = i_renamed;
        if (!shouldDrawCompatHalo()) {
            android.graphics.drawable.Drawable background = getBackground();
            if (background instanceof android.graphics.drawable.RippleDrawable) {
                com.google.android.material.drawable.DrawableUtils.setRippleDrawableRadius((android.graphics.drawable.RippleDrawable) background, this.haloRadius);
                return;
            }
            return;
        }
        postInvalidate();
    }

    public void setHaloRadiusResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setHaloRadius(getResources().getDimensionPixelSize(i_renamed));
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public void setLabelBehavior(int i_renamed) {
        if (this.labelBehavior != i_renamed) {
            this.labelBehavior = i_renamed;
            requestLayout();
        }
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public void setTrackHeight(int i_renamed) {
        if (this.trackHeight != i_renamed) {
            this.trackHeight = i_renamed;
            invalidateTrack();
            postInvalidate();
        }
    }

    public android.content.res.ColorStateList getHaloColor() {
        return this.haloColor;
    }

    public void setHaloColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        if (!shouldDrawCompatHalo()) {
            android.graphics.drawable.Drawable background = getBackground();
            if (background instanceof android.graphics.drawable.RippleDrawable) {
                ((android.graphics.drawable.RippleDrawable) background).setColor(colorStateList);
                return;
            }
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public android.content.res.ColorStateList getThumbColor() {
        return this.thumbDrawable.getFillColor();
    }

    public void setThumbColor(android.content.res.ColorStateList colorStateList) {
        this.thumbDrawable.setFillColor(colorStateList);
    }

    public android.content.res.ColorStateList getTickColor() {
        if (!this.tickColorInactive.equals(this.tickColorActive)) {
            throw new java.lang.IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
        }
        return this.tickColorActive;
    }

    public void setTickColor(android.content.res.ColorStateList colorStateList) {
        setTickColorInactive(colorStateList);
        setTickColorActive(colorStateList);
    }

    public android.content.res.ColorStateList getTickColorActive() {
        return this.tickColorActive;
    }

    public void setTickColorActive(android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        invalidate();
    }

    public android.content.res.ColorStateList getTickColorInactive() {
        return this.tickColorInactive;
    }

    public void setTickColorInactive(android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        invalidate();
    }

    public android.content.res.ColorStateList getTrackColor() {
        if (!this.trackColorInactive.equals(this.trackColorActive)) {
            throw new java.lang.IllegalStateException("The inactive and active parts of_renamed the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
        }
        return this.trackColorActive;
    }

    public void setTrackColor(android.content.res.ColorStateList colorStateList) {
        setTrackColorInactive(colorStateList);
        setTrackColorActive(colorStateList);
    }

    public android.content.res.ColorStateList getTrackColorActive() {
        return this.trackColorActive;
    }

    public void setTrackColorActive(android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        invalidate();
    }

    public android.content.res.ColorStateList getTrackColorInactive() {
        return this.trackColorInactive;
    }

    public void setTrackColorInactive(android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        setLayerType(z_renamed ? 0 : 2, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setRelativeToView(com.google.android.material.internal.ViewUtils.getContentView(this));
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        com.google.android.material.slider.Slider.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        for (com.google.android.material.tooltip.TooltipDrawable tooltipDrawable : this.labels) {
            com.google.android.material.internal.ViewOverlayImpl contentViewOverlay = com.google.android.material.internal.ViewUtils.getContentViewOverlay(this);
            if (contentViewOverlay != null) {
                contentViewOverlay.remove(tooltipDrawable);
                tooltipDrawable.detachView(com.google.android.material.internal.ViewUtils.getContentView(this));
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, android.view.View.MeasureSpec.makeMeasureSpec(this.widgetHeight + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        this.trackWidth = i_renamed - (this.trackSidePadding * 2);
        if (this.stepSize > 0.0f) {
            calculateTicksCoordinates();
        }
        updateHaloHotspot();
    }

    private void calculateTicksCoordinates() {
        validateConfigurationIfDirty();
        int iMin = java.lang.Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != iMin * 2) {
            this.ticksCoordinates = new float[iMin * 2];
        }
        float f_renamed = this.trackWidth / (iMin - 1);
        for (int i_renamed = 0; i_renamed < iMin * 2; i_renamed += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i_renamed] = this.trackSidePadding + ((i_renamed / 2) * f_renamed);
            fArr2[i_renamed + 1] = calculateTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (shouldDrawCompatHalo() || getMeasuredWidth() <= 0) {
            return;
        }
        android.graphics.drawable.Drawable background = getBackground();
        if (background instanceof android.graphics.drawable.RippleDrawable) {
            int iNormalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
            int iCalculateTop = calculateTop();
            int i_renamed = this.haloRadius;
            androidx.core.graphics.drawable.a_renamed.a_renamed(background, iNormalizeValue - i_renamed, iCalculateTop - i_renamed, iNormalizeValue + i_renamed, iCalculateTop + i_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateTop() {
        return this.trackTop + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            if (this.stepSize > 0.0f) {
                calculateTicksCoordinates();
            }
        }
        super.onDraw(canvas);
        int iCalculateTop = calculateTop();
        drawInactiveTrack(canvas, this.trackWidth, iCalculateTop);
        if (getMaximumValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, iCalculateTop);
        }
        if (this.stepSize > 0.0f) {
            drawTicks(canvas);
        }
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawHalo(canvas, this.trackWidth, iCalculateTop);
            if (this.activeThumbIdx != -1) {
                ensureLabels();
            }
        }
        drawThumbs(canvas, this.trackWidth, iCalculateTop);
    }

    private float[] getActiveRange() {
        float fNormalizeValue = normalizeValue(this.values.size() == 1 ? this.valueFrom : getMinimumValue());
        float fNormalizeValue2 = normalizeValue(getMaximumValue());
        if (androidx.core.h_renamed.v_renamed.g_renamed(this) == 1) {
            return new float[]{fNormalizeValue2, fNormalizeValue};
        }
        return new float[]{fNormalizeValue, fNormalizeValue2};
    }

    private void drawInactiveTrack(android.graphics.Canvas canvas, int i_renamed, int i2) {
        float[] activeRange = getActiveRange();
        float f_renamed = i_renamed;
        float f2 = this.trackSidePadding + (activeRange[1] * f_renamed);
        if (f2 < r1 + i_renamed) {
            float f3 = i2;
            canvas.drawLine(f2, f3, r1 + i_renamed, f3, this.inactiveTrackPaint);
        }
        int i3 = this.trackSidePadding;
        float f4 = i3 + (activeRange[0] * f_renamed);
        if (f4 > i3) {
            float f5 = i2;
            canvas.drawLine(i3, f5, f4, f5, this.inactiveTrackPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float normalizeValue(float f_renamed) {
        float f2 = this.valueFrom;
        float f3 = (f_renamed - f2) / (this.valueTo - f2);
        return androidx.core.h_renamed.v_renamed.g_renamed(this) == 1 ? 1.0f - f3 : f3;
    }

    private void drawActiveTrack(android.graphics.Canvas canvas, int i_renamed, int i2) {
        float[] activeRange = getActiveRange();
        int i3 = this.trackSidePadding;
        float f_renamed = i_renamed;
        float f2 = i2;
        canvas.drawLine(i3 + (activeRange[0] * f_renamed), f2, i3 + (activeRange[1] * f_renamed), f2, this.activeTrackPaint);
    }

    private void drawTicks(android.graphics.Canvas canvas) {
        float[] activeRange = getActiveRange();
        int iPivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int iPivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
        int i_renamed = iPivotIndex * 2;
        canvas.drawPoints(this.ticksCoordinates, 0, i_renamed, this.inactiveTicksPaint);
        int i2 = iPivotIndex2 * 2;
        canvas.drawPoints(this.ticksCoordinates, i_renamed, i2 - i_renamed, this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, i2, fArr.length - i2, this.inactiveTicksPaint);
    }

    private void drawThumbs(android.graphics.Canvas canvas, int i_renamed, int i2) {
        if (!isEnabled()) {
            java.util.Iterator<java.lang.Float> it = this.values.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.trackSidePadding + (normalizeValue(it.next().floatValue()) * i_renamed), i2, this.thumbRadius, this.thumbPaint);
            }
        }
        java.util.Iterator<java.lang.Float> it2 = this.values.iterator();
        while (it2.hasNext()) {
            java.lang.Float next = it2.next();
            canvas.save();
            int iNormalizeValue = this.trackSidePadding + ((int) (normalizeValue(next.floatValue()) * i_renamed));
            int i3 = this.thumbRadius;
            canvas.translate(iNormalizeValue - i3, i2 - i3);
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void maybeDrawHalo(android.graphics.Canvas canvas, int i_renamed, int i2) {
        if (shouldDrawCompatHalo()) {
            int iNormalizeValue = (int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i_renamed));
            if (android.os.Build.VERSION.SDK_INT < 28) {
                int i3 = this.haloRadius;
                canvas.clipRect(iNormalizeValue - i3, i2 - i3, iNormalizeValue + i3, i3 + i2, android.graphics.Region.Op.UNION);
            }
            canvas.drawCircle(iNormalizeValue, i2, this.haloRadius, this.haloPaint);
        }
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || android.os.Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof android.graphics.drawable.RippleDrawable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x_renamed = motionEvent.getX();
        this.touchPosition = (x_renamed - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = java.lang.Math.max(0.0f, this.touchPosition);
        this.touchPosition = java.lang.Math.min(1.0f, this.touchPosition);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x_renamed;
            if (!isInScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            android.view.MotionEvent motionEvent2 = this.lastEvent;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && this.lastEvent.getX() == motionEvent.getX() && this.lastEvent.getY() == motionEvent.getY()) {
                pickActiveThumb();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
            }
            java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
            while (it.hasNext()) {
                com.google.android.material.internal.ViewUtils.getContentViewOverlay(this).remove(it.next());
            }
            onStopTrackingTouch();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (java.lang.Math.abs(x_renamed - this.touchDownX) < this.scaledTouchSlop) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                onStartTrackingTouch();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = android.view.MotionEvent.obtain(motionEvent);
        return true;
    }

    private static int pivotIndex(float[] fArr, float f_renamed) {
        return java.lang.Math.round(f_renamed * ((fArr.length / 2) - 1));
    }

    private double snapPosition(float f_renamed) {
        float f2 = this.stepSize;
        if (f2 <= 0.0f) {
            return f_renamed;
        }
        return java.lang.Math.round(f_renamed * r2) / ((int) ((this.valueTo - this.valueFrom) / f2));
    }

    private boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPosition = getValueOfTouchPosition();
        float fValueToX = valueToX(valueOfTouchPosition);
        float fMin = java.lang.Math.min(fValueToX, this.touchDownX);
        float fMax = java.lang.Math.max(fValueToX, this.touchDownX);
        this.activeThumbIdx = 0;
        float fAbs = java.lang.Math.abs(this.values.get(this.activeThumbIdx).floatValue() - valueOfTouchPosition);
        for (int i_renamed = 0; i_renamed < this.values.size(); i_renamed++) {
            float fAbs2 = java.lang.Math.abs(this.values.get(i_renamed).floatValue() - valueOfTouchPosition);
            float fValueToX2 = valueToX(this.values.get(i_renamed).floatValue());
            float fAbs3 = java.lang.Math.abs(fValueToX2 - fValueToX);
            float fAbs4 = java.lang.Math.abs(valueToX(this.values.get(this.activeThumbIdx).floatValue()) - fValueToX);
            if (fMin < fValueToX2 && fMax > fValueToX2) {
                this.activeThumbIdx = i_renamed;
                return true;
            }
            int i2 = this.scaledTouchSlop;
            if (fAbs3 < i2 && fAbs4 < i2 && java.lang.Math.abs(fAbs3 - fAbs4) > THRESHOLD) {
                this.activeThumbIdx = -1;
                return false;
            }
            if (fAbs2 < fAbs) {
                this.activeThumbIdx = i_renamed;
                fAbs = fAbs2;
            }
        }
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private boolean snapActiveThumbToValue(float f_renamed) {
        return snapThumbToValue(this.activeThumbIdx, f_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int i_renamed, float f_renamed) {
        if (java.lang.Math.abs(f_renamed - this.values.get(i_renamed).floatValue()) < THRESHOLD) {
            return false;
        }
        this.values.set(i_renamed, java.lang.Float.valueOf(f_renamed));
        java.util.Collections.sort(this.values);
        if (i_renamed == this.activeThumbIdx) {
            i_renamed = this.values.indexOf(java.lang.Float.valueOf(f_renamed));
        }
        this.activeThumbIdx = i_renamed;
        this.focusedThumbIdx = i_renamed;
        dispatchOnChangedFromUser(i_renamed);
        return true;
    }

    private float getValueOfTouchPosition() {
        double dSnapPosition = snapPosition(this.touchPosition);
        if (androidx.core.h_renamed.v_renamed.g_renamed(this) == 1) {
            dSnapPosition = 1.0d - dSnapPosition;
        }
        float f_renamed = this.valueTo;
        return (float) ((dSnapPosition * (f_renamed - r4)) + this.valueFrom);
    }

    private float valueToX(float f_renamed) {
        return (normalizeValue(f_renamed) * this.trackWidth) + this.trackSidePadding;
    }

    private void ensureLabels() {
        if (this.labelBehavior == 2) {
            return;
        }
        java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
        for (int i_renamed = 0; i_renamed < this.values.size() && it.hasNext(); i_renamed++) {
            if (i_renamed != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i_renamed).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new java.lang.IllegalStateException("Not enough labels to display all the values");
        }
        setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String formatValue(float f_renamed) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f_renamed);
        }
        return java.lang.String.format(((float) ((int) f_renamed)) == f_renamed ? "%.0f" : "%.2f", java.lang.Float.valueOf(f_renamed));
    }

    private void setValueForLabel(com.google.android.material.tooltip.TooltipDrawable tooltipDrawable, float f_renamed) {
        tooltipDrawable.setText(formatValue(f_renamed));
        int iNormalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f_renamed) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int iCalculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(iNormalizeValue, iCalculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + iNormalizeValue, iCalculateTop);
        android.graphics.Rect rect = new android.graphics.Rect(tooltipDrawable.getBounds());
        com.google.android.material.internal.DescendantOffsetUtils.offsetDescendantRect(com.google.android.material.internal.ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        com.google.android.material.internal.ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInScrollingContainer() {
        for (android.view.ViewParent parent = getParent(); parent instanceof android.view.ViewGroup; parent = parent.getParent()) {
            if (((android.view.ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void dispatchOnChangedProgramatically() {
        for (com.google.android.material.slider.Slider.OnChangeListener onChangeListener : this.changeListeners) {
            java.util.Iterator<java.lang.Float> it = this.values.iterator();
            while (it.hasNext()) {
                onChangeListener.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void dispatchOnChangedFromUser(int i_renamed) {
        java.util.Iterator<com.google.android.material.slider.Slider.OnChangeListener> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onValueChange(this, this.values.get(i_renamed).floatValue(), true);
        }
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        scheduleAccessibilityEventSender(i_renamed);
    }

    private void onStartTrackingTouch() {
        java.util.Iterator<com.google.android.material.slider.Slider.OnSliderTouchListener> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        java.util.Iterator<com.google.android.material.slider.Slider.OnSliderTouchListener> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStopTrackingTouch(this);
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (com.google.android.material.tooltip.TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    private int getColorForState(android.content.res.ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    void forceDrawCompatHalo(boolean z_renamed) {
        this.forceDrawCompatHalo = z_renamed;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        if (isEnabled()) {
            if (this.values.size() == 1) {
                this.activeThumbIdx = 0;
            }
            if (this.activeThumbIdx == -1) {
                if (i_renamed == 61) {
                    if (keyEvent.hasNoModifiers()) {
                        moveFocus(1);
                        return true;
                    }
                    if (!keyEvent.isShiftPressed()) {
                        return false;
                    }
                    moveFocus(-1);
                    return true;
                }
                if (i_renamed != 66) {
                    if (i_renamed != 69) {
                        if (i_renamed != 81) {
                            switch (i_renamed) {
                            }
                            return true;
                        }
                        moveFocus(1);
                        return true;
                    }
                    moveFocus(-1);
                    return true;
                }
                this.activeThumbIdx = this.focusedThumbIdx;
                postInvalidate();
                return true;
            }
            this.isLongPress |= keyEvent.isLongPress();
            java.lang.Float fCalculateIncrementForKey = calculateIncrementForKey(keyEvent, i_renamed);
            if (fCalculateIncrementForKey != null) {
                if (androidx.core.h_renamed.v_renamed.g_renamed(this) == 1) {
                    fCalculateIncrementForKey = java.lang.Float.valueOf(-fCalculateIncrementForKey.floatValue());
                }
                if (snapActiveThumbToValue(androidx.core.c_renamed.a_renamed.a_renamed(this.values.get(this.activeThumbIdx).floatValue() + fCalculateIncrementForKey.floatValue(), this.valueFrom, this.valueTo))) {
                    updateHaloHotspot();
                    postInvalidate();
                }
                return true;
            }
        }
        return super.onKeyDown(i_renamed, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i_renamed, android.view.KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i_renamed, keyEvent);
    }

    private void moveFocus(int i_renamed) {
        this.focusedThumbIdx += i_renamed;
        this.focusedThumbIdx = androidx.core.c_renamed.a_renamed.a_renamed(this.focusedThumbIdx, 0, this.values.size() - 1);
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = this.focusedThumbIdx;
        }
        updateHaloHotspot();
        postInvalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Float calculateIncrementForKey(android.view.KeyEvent r2, int r3) {
        /*
            r1 = this;
            boolean r0 = r1.isLongPress
            if (r0 == 0) goto Lb
            r0 = 20
            float r1 = r1.calculateStepIncrement(r0)
            goto Lf
        Lb:
            float r1 = r1.calculateStepIncrement()
        Lf:
            r0 = 21
            if (r3 == r0) goto L3a
            r0 = 22
            if (r3 == r0) goto L3b
            r0 = 61
            if (r3 == r0) goto L29
            r2 = 81
            if (r3 == r2) goto L3b
            r2 = 69
            if (r3 == r2) goto L3a
            r2 = 70
            if (r3 == r2) goto L3b
            r1 = 0
            return r1
        L29:
            boolean r2 = r2.isShiftPressed()
            if (r2 == 0) goto L35
            float r1 = -r1
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            return r1
        L35:
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            return r1
        L3a:
            float r1 = -r1
        L3b:
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.Slider.calculateIncrementForKey(android.view.KeyEvent, int):java.lang.Float");
    }

    private float calculateStepIncrement() {
        float f_renamed = this.stepSize;
        if (f_renamed == 0.0f) {
            return 1.0f;
        }
        return f_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int i_renamed) {
        float fCalculateStepIncrement = calculateStepIncrement();
        return (this.valueTo - this.valueFrom) / fCalculateStepIncrement <= i_renamed ? fCalculateStepIncrement : java.lang.Math.round(r1 / r2) * fCalculateStepIncrement;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z_renamed, int i_renamed, android.graphics.Rect rect) {
        super.onFocusChanged(z_renamed, i_renamed, rect);
        if (!z_renamed) {
            this.activeThumbIdx = -1;
            java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
            while (it.hasNext()) {
                com.google.android.material.internal.ViewUtils.getContentViewOverlay(this).remove(it.next());
            }
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(Integer.MIN_VALUE);
            return;
        }
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    @Override // android.view.View
    public java.lang.CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(android.view.MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    private void scheduleAccessibilityEventSender(int i_renamed) {
        com.google.android.material.slider.Slider.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.accessibilityEventSender = new com.google.android.material.slider.Slider.AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.accessibilityEventSender.setVirtualViewId(i_renamed);
        postDelayed(this.accessibilityEventSender, 200L);
    }

    private class AccessibilityEventSender implements java.lang.Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        void setVirtualViewId(int i_renamed) {
            this.virtualViewId = i_renamed;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.slider.Slider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.slider.Slider.SliderState sliderState = new com.google.android.material.slider.Slider.SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new java.util.ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        com.google.android.material.slider.Slider.SliderState sliderState = (com.google.android.material.slider.Slider.SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        this.values = sliderState.values;
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    static class SliderState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.slider.Slider.SliderState> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.slider.Slider.SliderState>() { // from class: com.google.android.material.slider.Slider.SliderState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.material.slider.Slider.SliderState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.slider.Slider.SliderState(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.material.slider.Slider.SliderState[] newArray(int i_renamed) {
                return new com.google.android.material.slider.Slider.SliderState[i_renamed];
            }
        };
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        java.util.ArrayList<java.lang.Float> values;

        SliderState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(android.os.Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            this.values = new java.util.ArrayList<>();
            parcel.readList(this.values, java.lang.Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    private class AccessibilityHelper extends androidx.customview.a_renamed.a_renamed {
        android.graphics.Rect bounds;

        AccessibilityHelper() {
            super(com.google.android.material.slider.Slider.this);
            this.bounds = new android.graphics.Rect();
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected int getVirtualViewAt(float f_renamed, float f2) {
            for (int i_renamed = 0; i_renamed < com.google.android.material.slider.Slider.this.getValues().size(); i_renamed++) {
                updateBoundsForVirturalViewId(i_renamed);
                if (this.bounds.contains((int) f_renamed, (int) f2)) {
                    return i_renamed;
                }
            }
            return -1;
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void getVisibleVirtualViews(java.util.List<java.lang.Integer> list) {
            for (int i_renamed = 0; i_renamed < com.google.android.material.slider.Slider.this.getValues().size(); i_renamed++) {
                list.add(java.lang.Integer.valueOf(i_renamed));
            }
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void onPopulateNodeForVirtualView(int i_renamed, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.H_renamed);
            float fFloatValue = com.google.android.material.slider.Slider.this.getValues().get(i_renamed).floatValue();
            if (com.google.android.material.slider.Slider.this.isEnabled()) {
                if (fFloatValue > com.google.android.material.slider.Slider.this.valueFrom) {
                    dVar.a_renamed(8192);
                }
                if (fFloatValue < com.google.android.material.slider.Slider.this.valueTo) {
                    dVar.a_renamed(4096);
                }
            }
            dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.AccessibilityNodeInfoCompat_5.a_renamed(1, com.google.android.material.slider.Slider.this.valueFrom, com.google.android.material.slider.Slider.this.valueTo, fFloatValue));
            dVar.b_renamed((java.lang.CharSequence) android.widget.SeekBar.class.getName());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (com.google.android.material.slider.Slider.this.getContentDescription() != null) {
                sb.append(com.google.android.material.slider.Slider.this.getContentDescription());
                sb.append(",");
            }
            if (com.google.android.material.slider.Slider.this.values.size() > 1) {
                android.content.Context context = com.google.android.material.slider.Slider.this.getContext();
                int i2 = com.google.android.material.R_renamed.string.mtrl_slider_range_content_description;
                com.google.android.material.slider.Slider slider = com.google.android.material.slider.Slider.this;
                com.google.android.material.slider.Slider slider2 = com.google.android.material.slider.Slider.this;
                sb.append(context.getString(i2, slider.formatValue(slider.getMinimumValue()), slider2.formatValue(slider2.getMaximumValue())));
            }
            dVar.e_renamed(sb.toString());
            updateBoundsForVirturalViewId(i_renamed);
            dVar.b_renamed(this.bounds);
        }

        private void updateBoundsForVirturalViewId(int i_renamed) {
            int i2 = com.google.android.material.slider.Slider.this.trackSidePadding;
            com.google.android.material.slider.Slider slider = com.google.android.material.slider.Slider.this;
            int iNormalizeValue = i2 + ((int) (slider.normalizeValue(slider.getValues().get(i_renamed).floatValue()) * com.google.android.material.slider.Slider.this.trackWidth));
            int iCalculateTop = com.google.android.material.slider.Slider.this.calculateTop();
            this.bounds.set(iNormalizeValue - com.google.android.material.slider.Slider.this.thumbRadius, iCalculateTop - com.google.android.material.slider.Slider.this.thumbRadius, iNormalizeValue + com.google.android.material.slider.Slider.this.thumbRadius, iCalculateTop + com.google.android.material.slider.Slider.this.thumbRadius);
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected boolean onPerformActionForVirtualView(int i_renamed, int i2, android.os.Bundle bundle) {
            if (!com.google.android.material.slider.Slider.this.isEnabled()) {
                return false;
            }
            if (i2 == 4096 || i2 == 8192) {
                float fCalculateStepIncrement = com.google.android.material.slider.Slider.this.calculateStepIncrement(20);
                if (i2 == 8192) {
                    fCalculateStepIncrement = -fCalculateStepIncrement;
                }
                if (androidx.core.h_renamed.v_renamed.g_renamed(com.google.android.material.slider.Slider.this) == 1) {
                    fCalculateStepIncrement = -fCalculateStepIncrement;
                }
                float fA_renamed = androidx.core.c_renamed.a_renamed.a_renamed(((java.lang.Float) com.google.android.material.slider.Slider.this.values.get(i_renamed)).floatValue() + fCalculateStepIncrement, com.google.android.material.slider.Slider.this.valueFrom, com.google.android.material.slider.Slider.this.valueTo);
                if (!com.google.android.material.slider.Slider.this.snapThumbToValue(i_renamed, fA_renamed)) {
                    return false;
                }
                com.google.android.material.slider.Slider.this.updateHaloHotspot();
                com.google.android.material.slider.Slider.this.postInvalidate();
                if (com.google.android.material.slider.Slider.this.values.indexOf(java.lang.Float.valueOf(fA_renamed)) != i_renamed) {
                    sendEventForVirtualView(com.google.android.material.slider.Slider.this.values.indexOf(java.lang.Float.valueOf(fA_renamed)), 8);
                } else {
                    invalidateVirtualView(i_renamed);
                }
                return true;
            }
            if (i2 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (com.google.android.material.slider.Slider.this.snapThumbToValue(i_renamed, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    com.google.android.material.slider.Slider.this.updateHaloHotspot();
                    com.google.android.material.slider.Slider.this.postInvalidate();
                    invalidateVirtualView(i_renamed);
                    return true;
                }
            }
            return false;
        }
    }
}
