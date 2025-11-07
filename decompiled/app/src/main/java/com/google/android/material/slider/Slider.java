package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p031c.MathUtils;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.p039a.ExploreByTouchHelper;
import com.google.android.material.C1694R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class Slider extends View {
    private static final int DEF_STYLE_RES = C1694R.style.Widget_MaterialComponents_Slider;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value must be equal to valueFrom plus PlatformImplementations.kt_3 multiple of stepSize when using stepSize";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize must be 0, or PlatformImplementations.kt_3 factor of the valueFrom-valueTo range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value must be greater or equal to valueFrom, and lower or equal to valueTo";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom must be smaller than valueTo";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo must be greater than valueFrom";
    private static final int HALO_ALPHA = 63;
    public static final int LABEL_FLOATING = 0;
    public static final int LABEL_GONE = 2;
    public static final int LABEL_WITHIN_BOUNDS = 1;
    private static final String TAG = "Slider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private AccessibilityEventSender accessibilityEventSender;
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    private final Paint activeTicksPaint;
    private final Paint activeTrackPaint;
    private final List<OnChangeListener> changeListeners;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    private ColorStateList haloColor;
    private final Paint haloPaint;
    private int haloRadius;
    private final Paint inactiveTicksPaint;
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private final TooltipDrawableFactory labelMaker;
    private int labelPadding;
    private final List<TooltipDrawable> labels;
    private MotionEvent lastEvent;
    private final int scaledTouchSlop;
    private float stepSize;
    private final MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;
    private final Paint thumbPaint;
    private int thumbRadius;
    private ColorStateList tickColorActive;
    private ColorStateList tickColorInactive;
    private float[] ticksCoordinates;
    private float touchDownX;
    private final List<OnSliderTouchListener> touchListeners;
    private float touchPosition;
    private ColorStateList trackColorActive;
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelBehavior {
    }

    public interface LabelFormatter {
        String getFormattedValue(float COUIBaseListPopupWindow_12);
    }

    public interface OnChangeListener {
        void onValueChange(Slider slider, float COUIBaseListPopupWindow_12, boolean z);
    }

    public interface OnSliderTouchListener {
        void onStartTrackingTouch(Slider slider);

        void onStopTrackingTouch(Slider slider);
    }

    private interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    public static final class BasicLabelFormatter implements LabelFormatter {
        private static final int BILLION = 1000000000;
        private static final int MILLION = 1000000;
        private static final int THOUSAND = 1000;
        private static final long TRILLION = 1000000000000L;

        @Override // com.google.android.material.slider.Slider.LabelFormatter
        public String getFormattedValue(float COUIBaseListPopupWindow_12) {
            return COUIBaseListPopupWindow_12 >= 1.0E12f ? String.format(Locale.US, "%.1fT", Float.valueOf(COUIBaseListPopupWindow_12 / 1.0E12f)) : COUIBaseListPopupWindow_12 >= 1.0E9f ? String.format(Locale.US, "%.1fB", Float.valueOf(COUIBaseListPopupWindow_12 / 1.0E9f)) : COUIBaseListPopupWindow_12 >= 1000000.0f ? String.format(Locale.US, "%.1fM", Float.valueOf(COUIBaseListPopupWindow_12 / 1000000.0f)) : COUIBaseListPopupWindow_12 >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(COUIBaseListPopupWindow_12 / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(COUIBaseListPopupWindow_12));
        }
    }

    public Slider(Context context) {
        this(context, null);
    }

    public Slider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1694R.attr.sliderStyle);
    }

    public Slider(Context context, final AttributeSet attributeSet, final int OplusGLSurfaceView_13) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        super(MaterialThemeOverlay.wrap(context, attributeSet, OplusGLSurfaceView_13, DEF_STYLE_RES), attributeSet, OplusGLSurfaceView_13);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        this.thumbDrawable = new MaterialShapeDrawable();
        Context context2 = getContext();
        this.inactiveTrackPaint = new Paint();
        this.inactiveTrackPaint.setStyle(Paint.Style.STROKE);
        this.inactiveTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        this.activeTrackPaint = new Paint();
        this.activeTrackPaint.setStyle(Paint.Style.STROKE);
        this.activeTrackPaint.setStrokeCap(Paint.Cap.ROUND);
        this.thumbPaint = new Paint(1);
        this.thumbPaint.setStyle(Paint.Style.FILL);
        this.thumbPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.haloPaint = new Paint(1);
        this.haloPaint.setStyle(Paint.Style.FILL);
        this.inactiveTicksPaint = new Paint();
        this.inactiveTicksPaint.setStyle(Paint.Style.STROKE);
        this.inactiveTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        this.activeTicksPaint = new Paint();
        this.activeTicksPaint.setStyle(Paint.Style.STROKE);
        this.activeTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new TooltipDrawableFactory() { // from class: com.google.android.material.slider.Slider.1
            @Override // com.google.android.material.slider.Slider.TooltipDrawableFactory
            public TooltipDrawable createTooltipDrawable() {
                TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(Slider.this.getContext(), attributeSet, C1694R.styleable.Slider, OplusGLSurfaceView_13, Slider.DEF_STYLE_RES, new int[0]);
                TooltipDrawable labelDrawable = Slider.parseLabelDrawable(Slider.this.getContext(), typedArrayObtainStyledAttributes);
                typedArrayObtainStyledAttributes.recycle();
                return labelDrawable;
            }
        };
        processAttributes(context2, attributeSet, OplusGLSurfaceView_13);
        setFocusable(true);
        this.thumbDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        this.accessibilityHelper = new AccessibilityHelper();
        ViewCompat.m2854a(this, this.accessibilityHelper);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void loadResources(Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(C1694R.dimen.mtrl_slider_widget_height);
        this.trackSidePadding = resources.getDimensionPixelOffset(C1694R.dimen.mtrl_slider_track_side_padding);
        this.trackTop = resources.getDimensionPixelOffset(C1694R.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(C1694R.dimen.mtrl_slider_label_padding);
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C1694R.styleable.Slider, OplusGLSurfaceView_13, DEF_STYLE_RES, new int[0]);
        this.valueFrom = typedArrayObtainStyledAttributes.getFloat(C1694R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = typedArrayObtainStyledAttributes.getFloat(C1694R.styleable.Slider_android_valueTo, 1.0f);
        setValue(typedArrayObtainStyledAttributes.getFloat(C1694R.styleable.Slider_android_value, this.valueFrom));
        this.stepSize = typedArrayObtainStyledAttributes.getFloat(C1694R.styleable.Slider_android_stepSize, 0.0f);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.Slider_trackColor);
        int i2 = zHasValue ? C1694R.styleable.Slider_trackColor : C1694R.styleable.Slider_trackColorInactive;
        int i3 = zHasValue ? C1694R.styleable.Slider_trackColor : C1694R.styleable.Slider_trackColorActive;
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i2);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.m729a(context, C1694R.color.material_slider_inactive_track_color);
        }
        setTrackColorInactive(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i3);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.m729a(context, C1694R.color.material_slider_active_track_color);
        }
        setTrackColorActive(colorStateList2);
        this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C1694R.styleable.Slider_thumbColor));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C1694R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.m729a(context, C1694R.color.material_slider_halo_color);
        }
        setHaloColor(colorStateList3);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.Slider_tickColor);
        int i4 = zHasValue2 ? C1694R.styleable.Slider_tickColor : C1694R.styleable.Slider_tickColorInactive;
        int i5 = zHasValue2 ? C1694R.styleable.Slider_tickColor : C1694R.styleable.Slider_tickColorActive;
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i4);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.m729a(context, C1694R.color.material_slider_inactive_tick_marks_color);
        }
        setTickColorInactive(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, i5);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.m729a(context, C1694R.color.material_slider_active_tick_marks_color);
        }
        setTickColorActive(colorStateList5);
        setThumbRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(C1694R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(C1694R.styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(C1694R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C1694R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = typedArrayObtainStyledAttributes.getInt(C1694R.styleable.Slider_labelBehavior, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TooltipDrawable parseLabelDrawable(Context context, TypedArray typedArray) {
        return TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(C1694R.styleable.Slider_labelStyle, C1694R.style.Widget_MaterialComponents_Tooltip));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(EXCEPTION_ILLEGAL_VALUE_FROM);
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            throw new IllegalStateException(EXCEPTION_ILLEGAL_VALUE_TO);
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && ((this.valueTo - this.valueFrom) / r0) % 1.0f > THRESHOLD) {
            throw new IllegalStateException(EXCEPTION_ILLEGAL_STEP_SIZE);
        }
    }

    private void validateValues() {
        Iterator<Float> it = this.values.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                throw new IllegalStateException(EXCEPTION_ILLEGAL_VALUE);
            }
            if (this.stepSize > 0.0f && ((this.valueFrom - next.floatValue()) / this.stepSize) % 1.0f > THRESHOLD) {
                throw new IllegalStateException(EXCEPTION_ILLEGAL_DISCRETE_VALUE);
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

    public void setValueFrom(float COUIBaseListPopupWindow_12) {
        this.valueFrom = COUIBaseListPopupWindow_12;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public void setValueTo(float COUIBaseListPopupWindow_12) {
        this.valueTo = COUIBaseListPopupWindow_12;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public float getValue() {
        if (this.values.size() > 1) {
            throw new IllegalStateException("More than one value is set on the Slider. Use getValues() instead.");
        }
        return this.values.get(0).floatValue();
    }

    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public void setValue(float COUIBaseListPopupWindow_12) {
        setValues(Float.valueOf(COUIBaseListPopupWindow_12));
    }

    public void setValues(Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
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
        int OplusGLSurfaceView_13 = this.labels.size() == 1 ? 0 : 1;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(OplusGLSurfaceView_13);
        }
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public void setStepSize(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 < 0.0f) {
            throw new IllegalArgumentException(EXCEPTION_ILLEGAL_STEP_SIZE);
        }
        if (this.stepSize != COUIBaseListPopupWindow_12) {
            this.stepSize = COUIBaseListPopupWindow_12;
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

    public void setFocusedThumbIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = OplusGLSurfaceView_13;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        postInvalidate();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public void addOnChangeListener(OnChangeListener onChangeListener) {
        this.changeListeners.add(onChangeListener);
    }

    public void removeOnChangeListener(OnChangeListener onChangeListener) {
        this.changeListeners.remove(onChangeListener);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void addOnSliderTouchListener(OnSliderTouchListener onSliderTouchListener) {
        this.touchListeners.add(onSliderTouchListener);
    }

    public void removeOnSliderTouchListener(OnSliderTouchListener onSliderTouchListener) {
        this.touchListeners.remove(onSliderTouchListener);
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public void setLabelFormatter(LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    public void setThumbElevation(float COUIBaseListPopupWindow_12) {
        this.thumbDrawable.setElevation(COUIBaseListPopupWindow_12);
    }

    public void setThumbElevationResource(int OplusGLSurfaceView_13) {
        setThumbElevation(getResources().getDimension(OplusGLSurfaceView_13));
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public void setThumbRadius(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.thumbRadius) {
            return;
        }
        this.thumbRadius = OplusGLSurfaceView_13;
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        int i2 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i2 * 2, i2 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(int OplusGLSurfaceView_13) {
        setThumbRadius(getResources().getDimensionPixelSize(OplusGLSurfaceView_13));
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public void setHaloRadius(int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (OplusGLSurfaceView_13 == this.haloRadius) {
            return;
        }
        this.haloRadius = OplusGLSurfaceView_13;
        if (!shouldDrawCompatHalo()) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
                return;
            }
            return;
        }
        postInvalidate();
    }

    public void setHaloRadiusResource(int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setHaloRadius(getResources().getDimensionPixelSize(OplusGLSurfaceView_13));
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public void setLabelBehavior(int OplusGLSurfaceView_13) {
        if (this.labelBehavior != OplusGLSurfaceView_13) {
            this.labelBehavior = OplusGLSurfaceView_13;
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

    public void setTrackHeight(int OplusGLSurfaceView_13) {
        if (this.trackHeight != OplusGLSurfaceView_13) {
            this.trackHeight = OplusGLSurfaceView_13;
            invalidateTrack();
            postInvalidate();
        }
    }

    public ColorStateList getHaloColor() {
        return this.haloColor;
    }

    public void setHaloColor(ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        if (!shouldDrawCompatHalo()) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                ((RippleDrawable) background).setColor(colorStateList);
                return;
            }
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public ColorStateList getThumbColor() {
        return this.thumbDrawable.getFillColor();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.thumbDrawable.setFillColor(colorStateList);
    }

    public ColorStateList getTickColor() {
        if (!this.tickColorInactive.equals(this.tickColorActive)) {
            throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
        }
        return this.tickColorActive;
    }

    public void setTickColor(ColorStateList colorStateList) {
        setTickColorInactive(colorStateList);
        setTickColorActive(colorStateList);
    }

    public ColorStateList getTickColorActive() {
        return this.tickColorActive;
    }

    public void setTickColorActive(ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        invalidate();
    }

    public ColorStateList getTickColorInactive() {
        return this.tickColorInactive;
    }

    public void setTickColorInactive(ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        invalidate();
    }

    public ColorStateList getTrackColor() {
        if (!this.trackColorInactive.equals(this.trackColorActive)) {
            throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
        }
        return this.trackColorActive;
    }

    public void setTrackColor(ColorStateList colorStateList) {
        setTrackColorInactive(colorStateList);
        setTrackColorActive(colorStateList);
    }

    public ColorStateList getTrackColorActive() {
        return this.trackColorActive;
    }

    public void setTrackColorActive(ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        invalidate();
    }

    public ColorStateList getTrackColorInactive() {
        return this.trackColorInactive;
    }

    public void setTrackColorInactive(ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setRelativeToView(ViewUtils.getContentView(this));
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        for (TooltipDrawable tooltipDrawable : this.labels) {
            ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
            if (contentViewOverlay != null) {
                contentViewOverlay.remove(tooltipDrawable);
                tooltipDrawable.detachView(ViewUtils.getContentView(this));
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, View.MeasureSpec.makeMeasureSpec(this.widgetHeight + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.trackWidth = OplusGLSurfaceView_13 - (this.trackSidePadding * 2);
        if (this.stepSize > 0.0f) {
            calculateTicksCoordinates();
        }
        updateHaloHotspot();
    }

    private void calculateTicksCoordinates() {
        validateConfigurationIfDirty();
        int iMin = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != iMin * 2) {
            this.ticksCoordinates = new float[iMin * 2];
        }
        float COUIBaseListPopupWindow_12 = this.trackWidth / (iMin - 1);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iMin * 2; OplusGLSurfaceView_13 += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[OplusGLSurfaceView_13] = this.trackSidePadding + ((OplusGLSurfaceView_13 / 2) * COUIBaseListPopupWindow_12);
            fArr2[OplusGLSurfaceView_13 + 1] = calculateTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (shouldDrawCompatHalo() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iNormalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
            int iCalculateTop = calculateTop();
            int OplusGLSurfaceView_13 = this.haloRadius;
            DrawableCompat.m2569a(background, iNormalizeValue - OplusGLSurfaceView_13, iCalculateTop - OplusGLSurfaceView_13, iNormalizeValue + OplusGLSurfaceView_13, iCalculateTop + OplusGLSurfaceView_13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateTop() {
        return this.trackTop + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
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
        if (ViewCompat.m2885g(this) == 1) {
            return new float[]{fNormalizeValue2, fNormalizeValue};
        }
        return new float[]{fNormalizeValue, fNormalizeValue2};
    }

    private void drawInactiveTrack(Canvas canvas, int OplusGLSurfaceView_13, int i2) {
        float[] activeRange = getActiveRange();
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = this.trackSidePadding + (activeRange[1] * COUIBaseListPopupWindow_12);
        if (f2 < r1 + OplusGLSurfaceView_13) {
            float f3 = i2;
            canvas.drawLine(f2, f3, r1 + OplusGLSurfaceView_13, f3, this.inactiveTrackPaint);
        }
        int i3 = this.trackSidePadding;
        float f4 = i3 + (activeRange[0] * COUIBaseListPopupWindow_12);
        if (f4 > i3) {
            float f5 = i2;
            canvas.drawLine(i3, f5, f4, f5, this.inactiveTrackPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float normalizeValue(float COUIBaseListPopupWindow_12) {
        float f2 = this.valueFrom;
        float f3 = (COUIBaseListPopupWindow_12 - f2) / (this.valueTo - f2);
        return ViewCompat.m2885g(this) == 1 ? 1.0f - f3 : f3;
    }

    private void drawActiveTrack(Canvas canvas, int OplusGLSurfaceView_13, int i2) {
        float[] activeRange = getActiveRange();
        int i3 = this.trackSidePadding;
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = i2;
        canvas.drawLine(i3 + (activeRange[0] * COUIBaseListPopupWindow_12), f2, i3 + (activeRange[1] * COUIBaseListPopupWindow_12), f2, this.activeTrackPaint);
    }

    private void drawTicks(Canvas canvas) {
        float[] activeRange = getActiveRange();
        int iPivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int iPivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
        int OplusGLSurfaceView_13 = iPivotIndex * 2;
        canvas.drawPoints(this.ticksCoordinates, 0, OplusGLSurfaceView_13, this.inactiveTicksPaint);
        int i2 = iPivotIndex2 * 2;
        canvas.drawPoints(this.ticksCoordinates, OplusGLSurfaceView_13, i2 - OplusGLSurfaceView_13, this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, i2, fArr.length - i2, this.inactiveTicksPaint);
    }

    private void drawThumbs(Canvas canvas, int OplusGLSurfaceView_13, int i2) {
        if (!isEnabled()) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.trackSidePadding + (normalizeValue(it.next().floatValue()) * OplusGLSurfaceView_13), i2, this.thumbRadius, this.thumbPaint);
            }
        }
        Iterator<Float> it2 = this.values.iterator();
        while (it2.hasNext()) {
            Float next = it2.next();
            canvas.save();
            int iNormalizeValue = this.trackSidePadding + ((int) (normalizeValue(next.floatValue()) * OplusGLSurfaceView_13));
            int i3 = this.thumbRadius;
            canvas.translate(iNormalizeValue - i3, i2 - i3);
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void maybeDrawHalo(Canvas canvas, int OplusGLSurfaceView_13, int i2) {
        if (shouldDrawCompatHalo()) {
            int iNormalizeValue = (int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * OplusGLSurfaceView_13));
            if (Build.VERSION.SDK_INT < 28) {
                int i3 = this.haloRadius;
                canvas.clipRect(iNormalizeValue - i3, i2 - i3, iNormalizeValue + i3, i3 + i2, Region.Op.UNION);
            }
            canvas.drawCircle(iNormalizeValue, i2, this.haloRadius, this.haloPaint);
        }
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        this.touchPosition = (x - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = Math.max(0.0f, this.touchPosition);
        this.touchPosition = Math.min(1.0f, this.touchPosition);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x;
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
            MotionEvent motionEvent2 = this.lastEvent;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && this.lastEvent.getX() == motionEvent.getX() && this.lastEvent.getY() == motionEvent.getY()) {
                pickActiveThumb();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
            }
            Iterator<TooltipDrawable> it = this.labels.iterator();
            while (it.hasNext()) {
                ViewUtils.getContentViewOverlay(this).remove(it.next());
            }
            onStopTrackingTouch();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (Math.abs(x - this.touchDownX) < this.scaledTouchSlop) {
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
        this.lastEvent = MotionEvent.obtain(motionEvent);
        return true;
    }

    private static int pivotIndex(float[] fArr, float COUIBaseListPopupWindow_12) {
        return Math.round(COUIBaseListPopupWindow_12 * ((fArr.length / 2) - 1));
    }

    private double snapPosition(float COUIBaseListPopupWindow_12) {
        float f2 = this.stepSize;
        if (f2 <= 0.0f) {
            return COUIBaseListPopupWindow_12;
        }
        return Math.round(COUIBaseListPopupWindow_12 * r2) / ((int) ((this.valueTo - this.valueFrom) / f2));
    }

    private boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPosition = getValueOfTouchPosition();
        float fValueToX = valueToX(valueOfTouchPosition);
        float fMin = Math.min(fValueToX, this.touchDownX);
        float fMax = Math.max(fValueToX, this.touchDownX);
        this.activeThumbIdx = 0;
        float fAbs = Math.abs(this.values.get(this.activeThumbIdx).floatValue() - valueOfTouchPosition);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.values.size(); OplusGLSurfaceView_13++) {
            float fAbs2 = Math.abs(this.values.get(OplusGLSurfaceView_13).floatValue() - valueOfTouchPosition);
            float fValueToX2 = valueToX(this.values.get(OplusGLSurfaceView_13).floatValue());
            float fAbs3 = Math.abs(fValueToX2 - fValueToX);
            float fAbs4 = Math.abs(valueToX(this.values.get(this.activeThumbIdx).floatValue()) - fValueToX);
            if (fMin < fValueToX2 && fMax > fValueToX2) {
                this.activeThumbIdx = OplusGLSurfaceView_13;
                return true;
            }
            int i2 = this.scaledTouchSlop;
            if (fAbs3 < i2 && fAbs4 < i2 && Math.abs(fAbs3 - fAbs4) > THRESHOLD) {
                this.activeThumbIdx = -1;
                return false;
            }
            if (fAbs2 < fAbs) {
                this.activeThumbIdx = OplusGLSurfaceView_13;
                fAbs = fAbs2;
            }
        }
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private boolean snapActiveThumbToValue(float COUIBaseListPopupWindow_12) {
        return snapThumbToValue(this.activeThumbIdx, COUIBaseListPopupWindow_12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        if (Math.abs(COUIBaseListPopupWindow_12 - this.values.get(OplusGLSurfaceView_13).floatValue()) < THRESHOLD) {
            return false;
        }
        this.values.set(OplusGLSurfaceView_13, Float.valueOf(COUIBaseListPopupWindow_12));
        Collections.sort(this.values);
        if (OplusGLSurfaceView_13 == this.activeThumbIdx) {
            OplusGLSurfaceView_13 = this.values.indexOf(Float.valueOf(COUIBaseListPopupWindow_12));
        }
        this.activeThumbIdx = OplusGLSurfaceView_13;
        this.focusedThumbIdx = OplusGLSurfaceView_13;
        dispatchOnChangedFromUser(OplusGLSurfaceView_13);
        return true;
    }

    private float getValueOfTouchPosition() {
        double dSnapPosition = snapPosition(this.touchPosition);
        if (ViewCompat.m2885g(this) == 1) {
            dSnapPosition = 1.0d - dSnapPosition;
        }
        float COUIBaseListPopupWindow_12 = this.valueTo;
        return (float) ((dSnapPosition * (COUIBaseListPopupWindow_12 - r4)) + this.valueFrom);
    }

    private float valueToX(float COUIBaseListPopupWindow_12) {
        return (normalizeValue(COUIBaseListPopupWindow_12) * this.trackWidth) + this.trackSidePadding;
    }

    private void ensureLabels() {
        if (this.labelBehavior == 2) {
            return;
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.values.size() && it.hasNext(); OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(OplusGLSurfaceView_13).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException("Not enough labels to display all the values");
        }
        setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatValue(float COUIBaseListPopupWindow_12) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(COUIBaseListPopupWindow_12);
        }
        return String.format(((float) ((int) COUIBaseListPopupWindow_12)) == COUIBaseListPopupWindow_12 ? "%.0f" : "%.2f", Float.valueOf(COUIBaseListPopupWindow_12));
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float COUIBaseListPopupWindow_12) {
        tooltipDrawable.setText(formatValue(COUIBaseListPopupWindow_12));
        int iNormalizeValue = (this.trackSidePadding + ((int) (normalizeValue(COUIBaseListPopupWindow_12) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int iCalculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(iNormalizeValue, iCalculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + iNormalizeValue, iCalculateTop);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void dispatchOnChangedProgramatically() {
        for (OnChangeListener onChangeListener : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                onChangeListener.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void dispatchOnChangedFromUser(int OplusGLSurfaceView_13) {
        Iterator<OnChangeListener> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onValueChange(this, this.values.get(OplusGLSurfaceView_13).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        scheduleAccessibilityEventSender(OplusGLSurfaceView_13);
    }

    private void onStartTrackingTouch() {
        Iterator<OnSliderTouchListener> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        Iterator<OnSliderTouchListener> it = this.touchListeners.iterator();
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
        for (TooltipDrawable tooltipDrawable : this.labels) {
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

    private int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    void forceDrawCompatHalo(boolean z) {
        this.forceDrawCompatHalo = z;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (isEnabled()) {
            if (this.values.size() == 1) {
                this.activeThumbIdx = 0;
            }
            if (this.activeThumbIdx == -1) {
                if (OplusGLSurfaceView_13 == 61) {
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
                if (OplusGLSurfaceView_13 != 66) {
                    if (OplusGLSurfaceView_13 != 69) {
                        if (OplusGLSurfaceView_13 != 81) {
                            switch (OplusGLSurfaceView_13) {
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
            Float fCalculateIncrementForKey = calculateIncrementForKey(keyEvent, OplusGLSurfaceView_13);
            if (fCalculateIncrementForKey != null) {
                if (ViewCompat.m2885g(this) == 1) {
                    fCalculateIncrementForKey = Float.valueOf(-fCalculateIncrementForKey.floatValue());
                }
                if (snapActiveThumbToValue(MathUtils.m2446a(this.values.get(this.activeThumbIdx).floatValue() + fCalculateIncrementForKey.floatValue(), this.valueFrom, this.valueTo))) {
                    updateHaloHotspot();
                    postInvalidate();
                }
                return true;
            }
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(OplusGLSurfaceView_13, keyEvent);
    }

    private void moveFocus(int OplusGLSurfaceView_13) {
        this.focusedThumbIdx += OplusGLSurfaceView_13;
        this.focusedThumbIdx = MathUtils.m2447a(this.focusedThumbIdx, 0, this.values.size() - 1);
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = this.focusedThumbIdx;
        }
        updateHaloHotspot();
        postInvalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003a  */
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
        float COUIBaseListPopupWindow_12 = this.stepSize;
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            return 1.0f;
        }
        return COUIBaseListPopupWindow_12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int OplusGLSurfaceView_13) {
        float fCalculateStepIncrement = calculateStepIncrement();
        return (this.valueTo - this.valueFrom) / fCalculateStepIncrement <= OplusGLSurfaceView_13 ? fCalculateStepIncrement : Math.round(r1 / r2) * fCalculateStepIncrement;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int OplusGLSurfaceView_13, Rect rect) {
        super.onFocusChanged(z, OplusGLSurfaceView_13, rect);
        if (!z) {
            this.activeThumbIdx = -1;
            Iterator<TooltipDrawable> it = this.labels.iterator();
            while (it.hasNext()) {
                ViewUtils.getContentViewOverlay(this).remove(it.next());
            }
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(Integer.MIN_VALUE);
            return;
        }
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    private void scheduleAccessibilityEventSender(int OplusGLSurfaceView_13) {
        AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.accessibilityEventSender.setVirtualViewId(OplusGLSurfaceView_13);
        postDelayed(this.accessibilityEventSender, 200L);
    }

    private class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        void setVirtualViewId(int OplusGLSurfaceView_13) {
            this.virtualViewId = OplusGLSurfaceView_13;
        }

        @Override // java.lang.Runnable
        public void run() {
            Slider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
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

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.Slider.SliderState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SliderState[] newArray(int OplusGLSurfaceView_13) {
                return new SliderState[OplusGLSurfaceView_13];
            }
        };
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            this.values = new ArrayList<>();
            parcel.readList(this.values, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    private class AccessibilityHelper extends ExploreByTouchHelper {
        Rect bounds;

        AccessibilityHelper() {
            super(Slider.this);
            this.bounds = new Rect();
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected int getVirtualViewAt(float COUIBaseListPopupWindow_12, float f2) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < Slider.this.getValues().size(); OplusGLSurfaceView_13++) {
                updateBoundsForVirturalViewId(OplusGLSurfaceView_13);
                if (this.bounds.contains((int) COUIBaseListPopupWindow_12, (int) f2)) {
                    return OplusGLSurfaceView_13;
                }
            }
            return -1;
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < Slider.this.getValues().size(); OplusGLSurfaceView_13++) {
                list.add(Integer.valueOf(OplusGLSurfaceView_13));
            }
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int OplusGLSurfaceView_13, AccessibilityNodeInfoCompat c0483d) {
            c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3010H);
            float fFloatValue = Slider.this.getValues().get(OplusGLSurfaceView_13).floatValue();
            if (Slider.this.isEnabled()) {
                if (fFloatValue > Slider.this.valueFrom) {
                    c0483d.m2676a(8192);
                }
                if (fFloatValue < Slider.this.valueTo) {
                    c0483d.m2676a(4096);
                }
            }
            c0483d.m2680a(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_5.m2748a(1, Slider.this.valueFrom, Slider.this.valueTo, fFloatValue));
            c0483d.m2690b((CharSequence) SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (Slider.this.getContentDescription() != null) {
                sb.append(Slider.this.getContentDescription());
                sb.append(",");
            }
            if (Slider.this.values.size() > 1) {
                Context context = Slider.this.getContext();
                int i2 = C1694R.string.mtrl_slider_range_content_description;
                Slider slider = Slider.this;
                Slider slider2 = Slider.this;
                sb.append(context.getString(i2, slider.formatValue(slider.getMinimumValue()), slider2.formatValue(slider2.getMaximumValue())));
            }
            c0483d.m2702e(sb.toString());
            updateBoundsForVirturalViewId(OplusGLSurfaceView_13);
            c0483d.m2687b(this.bounds);
        }

        private void updateBoundsForVirturalViewId(int OplusGLSurfaceView_13) {
            int i2 = Slider.this.trackSidePadding;
            Slider slider = Slider.this;
            int iNormalizeValue = i2 + ((int) (slider.normalizeValue(slider.getValues().get(OplusGLSurfaceView_13).floatValue()) * Slider.this.trackWidth));
            int iCalculateTop = Slider.this.calculateTop();
            this.bounds.set(iNormalizeValue - Slider.this.thumbRadius, iCalculateTop - Slider.this.thumbRadius, iNormalizeValue + Slider.this.thumbRadius, iCalculateTop + Slider.this.thumbRadius);
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            if (!Slider.this.isEnabled()) {
                return false;
            }
            if (i2 == 4096 || i2 == 8192) {
                float fCalculateStepIncrement = Slider.this.calculateStepIncrement(20);
                if (i2 == 8192) {
                    fCalculateStepIncrement = -fCalculateStepIncrement;
                }
                if (ViewCompat.m2885g(Slider.this) == 1) {
                    fCalculateStepIncrement = -fCalculateStepIncrement;
                }
                float fM2446a = MathUtils.m2446a(((Float) Slider.this.values.get(OplusGLSurfaceView_13)).floatValue() + fCalculateStepIncrement, Slider.this.valueFrom, Slider.this.valueTo);
                if (!Slider.this.snapThumbToValue(OplusGLSurfaceView_13, fM2446a)) {
                    return false;
                }
                Slider.this.updateHaloHotspot();
                Slider.this.postInvalidate();
                if (Slider.this.values.indexOf(Float.valueOf(fM2446a)) != OplusGLSurfaceView_13) {
                    sendEventForVirtualView(Slider.this.values.indexOf(Float.valueOf(fM2446a)), 8);
                } else {
                    invalidateVirtualView(OplusGLSurfaceView_13);
                }
                return true;
            }
            if (i2 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (Slider.this.snapThumbToValue(OplusGLSurfaceView_13, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    Slider.this.updateHaloHotspot();
                    Slider.this.postInvalidate();
                    invalidateVirtualView(OplusGLSurfaceView_13);
                    return true;
                }
            }
            return false;
        }
    }
}
