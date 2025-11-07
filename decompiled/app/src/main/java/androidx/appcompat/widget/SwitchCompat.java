package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class SwitchCompat extends android.widget.CompoundButton {
    private static final java.lang.String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private android.text.Layout mOffLayout;
    private android.text.Layout mOnLayout;
    android.animation.ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private android.text.method.TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final android.graphics.Rect mTempRect;
    private android.content.res.ColorStateList mTextColors;
    private final androidx.appcompat.widget.v_renamed mTextHelper;
    private java.lang.CharSequence mTextOff;
    private java.lang.CharSequence mTextOn;
    private final android.text.TextPaint mTextPaint;
    private android.graphics.drawable.Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private android.content.res.ColorStateList mThumbTintList;
    private android.graphics.PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private android.graphics.drawable.Drawable mTrackDrawable;
    private android.content.res.ColorStateList mTrackTintList;
    private android.graphics.PorterDuff.Mode mTrackTintMode;
    private android.view.VelocityTracker mVelocityTracker;
    private static final android.util.Property<androidx.appcompat.widget.SwitchCompat, java.lang.Float> THUMB_POS = new android.util.Property<androidx.appcompat.widget.SwitchCompat, java.lang.Float>(java.lang.Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.lang.Float get(androidx.appcompat.widget.SwitchCompat switchCompat) {
            return java.lang.Float.valueOf(switchCompat.mThumbPosition);
        }

        @Override // android.util.Property
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void set(androidx.appcompat.widget.SwitchCompat switchCompat, java.lang.Float f_renamed) {
            switchCompat.setThumbPosition(f_renamed.floatValue());
        }
    };
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};

    private static float constrain(float f_renamed, float f2, float f3) {
        return f_renamed < f2 ? f2 : f_renamed > f3 ? f3 : f_renamed;
    }

    public SwitchCompat(android.content.Context context) {
        this(context, null);
    }

    public SwitchCompat(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.switchStyle);
    }

    public SwitchCompat(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = android.view.VelocityTracker.obtain();
        this.mTempRect = new android.graphics.Rect();
        this.mTextPaint = new android.text.TextPaint(1);
        android.content.res.Resources resources = getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, attributeSet, androidx.appcompat.R_renamed.styleable.SwitchCompat, i_renamed, 0);
        this.mThumbDrawable = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_android_thumb);
        android.graphics.drawable.Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.mTrackDrawable = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_track);
        android.graphics.drawable.Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.mTextOn = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_android_textOn);
        this.mTextOff = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_android_textOff);
        this.mShowText = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_splitTrack, false);
        android.content.res.ColorStateList colorStateListE = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_thumbTint);
        if (colorStateListE != null) {
            this.mThumbTintList = colorStateListE;
            this.mHasThumbTint = true;
        }
        android.graphics.PorterDuff.Mode modeA = androidx.appcompat.widget.aa_renamed.a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.mThumbTintMode != modeA) {
            this.mThumbTintMode = modeA;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        android.content.res.ColorStateList colorStateListE2 = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_trackTint);
        if (colorStateListE2 != null) {
            this.mTrackTintList = colorStateListE2;
            this.mHasTrackTint = true;
        }
        android.graphics.PorterDuff.Mode modeA2 = androidx.appcompat.widget.aa_renamed.a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.mTrackTintMode != modeA2) {
            this.mTrackTintMode = modeA2;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int iG = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.SwitchCompat_switchTextAppearance, 0);
        if (iG != 0) {
            setSwitchTextAppearance(context, iG);
        }
        this.mTextHelper = new androidx.appcompat.widget.v_renamed(this);
        this.mTextHelper.a_renamed(attributeSet, i_renamed);
        arVarA.b_renamed();
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(android.content.Context context, int i_renamed) {
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, i_renamed, androidx.appcompat.R_renamed.styleable.TextAppearance);
        android.content.res.ColorStateList colorStateListE = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textColor);
        if (colorStateListE != null) {
            this.mTextColors = colorStateListE;
        } else {
            this.mTextColors = getTextColors();
        }
        int iE = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textSize, 0);
        if (iE != 0) {
            float f_renamed = iE;
            if (f_renamed != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f_renamed);
                requestLayout();
            }
        }
        setSwitchTypefaceByIndex(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_typeface, -1), arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textStyle, -1));
        if (arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.TextAppearance_textAllCaps, false)) {
            this.mSwitchTransformationMethod = new androidx.appcompat.c_renamed.a_renamed(getContext());
        } else {
            this.mSwitchTransformationMethod = null;
        }
        arVarA.b_renamed();
    }

    private void setSwitchTypefaceByIndex(int i_renamed, int i2) {
        android.graphics.Typeface typeface;
        if (i_renamed == 1) {
            typeface = android.graphics.Typeface.SANS_SERIF;
        } else if (i_renamed == 2) {
            typeface = android.graphics.Typeface.SERIF;
        } else {
            typeface = i_renamed != 3 ? null : android.graphics.Typeface.MONOSPACE;
        }
        setSwitchTypeface(typeface, i2);
    }

    public void setSwitchTypeface(android.graphics.Typeface typeface, int i_renamed) {
        android.graphics.Typeface typefaceCreate;
        if (i_renamed > 0) {
            if (typeface == null) {
                typefaceCreate = android.graphics.Typeface.defaultFromStyle(i_renamed);
            } else {
                typefaceCreate = android.graphics.Typeface.create(typeface, i_renamed);
            }
            setSwitchTypeface(typefaceCreate);
            int i2 = (~(typefaceCreate != null ? typefaceCreate.getStyle() : 0)) & i_renamed;
            this.mTextPaint.setFakeBoldText((i2 & 1) != 0);
            this.mTextPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(android.graphics.Typeface typeface) {
        if ((this.mTextPaint.getTypeface() == null || this.mTextPaint.getTypeface().equals(typeface)) && (this.mTextPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        this.mTextPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setSwitchPadding(int i_renamed) {
        this.mSwitchPadding = i_renamed;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public void setSwitchMinWidth(int i_renamed) {
        this.mSwitchMinWidth = i_renamed;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public void setThumbTextPadding(int i_renamed) {
        this.mThumbTextPadding = i_renamed;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public void setTrackDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i_renamed) {
        setTrackDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    public android.graphics.drawable.Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public void setTrackTintList(android.content.res.ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public android.content.res.ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public void setTrackTintMode(android.graphics.PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    public android.graphics.PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    private void applyTrackTint() {
        if (this.mTrackDrawable != null) {
            if (this.mHasTrackTint || this.mHasTrackTintMode) {
                this.mTrackDrawable = androidx.core.graphics.drawable.a_renamed.g_renamed(this.mTrackDrawable).mutate();
                if (this.mHasTrackTint) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.mTrackDrawable, this.mTrackTintList);
                }
                if (this.mHasTrackTintMode) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.mTrackDrawable, this.mTrackTintMode);
                }
                if (this.mTrackDrawable.isStateful()) {
                    this.mTrackDrawable.setState(getDrawableState());
                }
            }
        }
    }

    public void setThumbDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i_renamed) {
        setThumbDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    public android.graphics.drawable.Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public void setThumbTintList(android.content.res.ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public android.content.res.ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public void setThumbTintMode(android.graphics.PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public android.graphics.PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    private void applyThumbTint() {
        if (this.mThumbDrawable != null) {
            if (this.mHasThumbTint || this.mHasThumbTintMode) {
                this.mThumbDrawable = androidx.core.graphics.drawable.a_renamed.g_renamed(this.mThumbDrawable).mutate();
                if (this.mHasThumbTint) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.mThumbDrawable, this.mThumbTintList);
                }
                if (this.mHasThumbTintMode) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.mThumbDrawable, this.mThumbTintMode);
                }
                if (this.mThumbDrawable.isStateful()) {
                    this.mThumbDrawable.setState(getDrawableState());
                }
            }
        }
    }

    public void setSplitTrack(boolean z_renamed) {
        this.mSplitTrack = z_renamed;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public java.lang.CharSequence getTextOn() {
        return this.mTextOn;
    }

    public void setTextOn(java.lang.CharSequence charSequence) {
        this.mTextOn = charSequence;
        requestLayout();
    }

    public java.lang.CharSequence getTextOff() {
        return this.mTextOff;
    }

    public void setTextOff(java.lang.CharSequence charSequence) {
        this.mTextOff = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z_renamed) {
        if (this.mShowText != z_renamed) {
            this.mShowText = z_renamed;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOn);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOff);
            }
        }
        android.graphics.Rect rect = this.mTempRect;
        android.graphics.drawable.Drawable drawable = this.mThumbDrawable;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.mThumbWidth = java.lang.Math.max(this.mShowText ? java.lang.Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2) : 0, intrinsicWidth);
        android.graphics.drawable.Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        android.graphics.drawable.Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            android.graphics.Rect rectA = androidx.appcompat.widget.aa_renamed.a_renamed(drawable3);
            iMax = java.lang.Math.max(iMax, rectA.left);
            iMax2 = java.lang.Math.max(iMax2, rectA.right);
        }
        int iMax3 = java.lang.Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + iMax + iMax2);
        int iMax4 = java.lang.Math.max(intrinsicHeight2, intrinsicHeight);
        this.mSwitchWidth = iMax3;
        this.mSwitchHeight = iMax4;
        super.onMeasure(i_renamed, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        java.lang.CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private android.text.Layout makeLayout(java.lang.CharSequence charSequence) {
        android.text.method.TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        java.lang.CharSequence charSequence2 = charSequence;
        return new android.text.StaticLayout(charSequence2, this.mTextPaint, charSequence2 != null ? (int) java.lang.Math.ceil(android.text.Layout.getDesiredWidth(charSequence2, r2)) : 0, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean hitThumb(float f_renamed, float f2) {
        if (this.mThumbDrawable == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i_renamed = this.mSwitchTop;
        int i2 = this.mTouchSlop;
        int i3 = i_renamed - i2;
        int i4 = (this.mSwitchLeft + thumbOffset) - i2;
        int i5 = this.mThumbWidth + i4 + this.mTempRect.left + this.mTempRect.right;
        int i6 = this.mTouchSlop;
        return f_renamed > ((float) i4) && f_renamed < ((float) (i5 + i6)) && f2 > ((float) i3) && f2 < ((float) (this.mSwitchBottom + i6));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x008b  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.mTouchMode
            if (r0 == 0) goto Lb9
            if (r0 == r1) goto L57
            if (r0 == r2) goto L20
            goto Lb9
        L20:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.mTouchX
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L34
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L34:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L3a
            r2 = r3
            goto L3d
        L3a:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3d:
            boolean r0 = androidx.appcompat.widget.ax_renamed.a_renamed(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.mThumbPosition
            float r0 = r0 + r2
            float r0 = constrain(r0, r4, r3)
            float r2 = r6.mThumbPosition
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.mTouchX = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.mTouchX
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.mTouchY
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.mTouchMode = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.mTouchX = r0
            r6.mTouchY = r3
            return r1
        L8b:
            int r0 = r6.mTouchMode
            if (r0 != r2) goto L96
            r6.stopDrag(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.mTouchMode = r0
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.hitThumb(r0, r2)
            if (r3 == 0) goto Lb9
            r6.mTouchMode = r1
            r6.mTouchX = r0
            r6.mTouchY = r2
        Lb9:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void cancelSuperTouch(android.view.MotionEvent motionEvent) {
        android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void stopDrag(android.view.MotionEvent motionEvent) {
        boolean targetCheckedState;
        this.mTouchMode = 0;
        boolean z_renamed = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (java.lang.Math.abs(xVelocity) > this.mMinFlingVelocity) {
                if (!androidx.appcompat.widget.ax_renamed.a_renamed(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z_renamed = false;
                }
                targetCheckedState = z_renamed;
            } else {
                targetCheckedState = getTargetCheckedState();
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        cancelSuperTouch(motionEvent);
    }

    private void animateThumbToCheckedState(boolean z_renamed) {
        this.mPositionAnimator = android.animation.ObjectAnimator.ofFloat(this, THUMB_POS, z_renamed ? 1.0f : 0.0f);
        this.mPositionAnimator.setDuration(250L);
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            this.mPositionAnimator.setAutoCancel(true);
        }
        this.mPositionAnimator.start();
    }

    private void cancelPositionAnimator() {
        android.animation.ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    void setThumbPosition(float f_renamed) {
        this.mThumbPosition = f_renamed;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        super.setChecked(z_renamed);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && androidx.core.h_renamed.v_renamed.A_renamed(this)) {
            animateThumbToCheckedState(zIsChecked);
        } else {
            cancelPositionAnimator();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int iMax;
        int width;
        int paddingLeft;
        int i5;
        int paddingTop;
        int height;
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        int iMax2 = 0;
        if (this.mThumbDrawable != null) {
            android.graphics.Rect rect = this.mTempRect;
            android.graphics.drawable.Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            android.graphics.Rect rectA = androidx.appcompat.widget.aa_renamed.a_renamed(this.mThumbDrawable);
            iMax = java.lang.Math.max(0, rectA.left - rect.left);
            iMax2 = java.lang.Math.max(0, rectA.right - rect.right);
        } else {
            iMax = 0;
        }
        if (androidx.appcompat.widget.ax_renamed.a_renamed(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.mSwitchWidth + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.mSwitchWidth) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i5 = this.mSwitchHeight;
            paddingTop = paddingTop2 - (i5 / 2);
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            i5 = this.mSwitchHeight;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.mSwitchHeight;
            this.mSwitchLeft = paddingLeft;
            this.mSwitchTop = paddingTop;
            this.mSwitchBottom = height;
            this.mSwitchRight = width;
        }
        height = i5 + paddingTop;
        this.mSwitchLeft = paddingLeft;
        this.mSwitchTop = paddingTop;
        this.mSwitchBottom = height;
        this.mSwitchRight = width;
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.graphics.Rect rectA;
        int i_renamed;
        int i2;
        android.graphics.Rect rect = this.mTempRect;
        int i3 = this.mSwitchLeft;
        int i4 = this.mSwitchTop;
        int i5 = this.mSwitchRight;
        int i6 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i3;
        android.graphics.drawable.Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            rectA = androidx.appcompat.widget.aa_renamed.a_renamed(drawable);
        } else {
            rectA = androidx.appcompat.widget.aa_renamed.f520a;
        }
        android.graphics.drawable.Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            thumbOffset += rect.left;
            if (rectA != null) {
                if (rectA.left > rect.left) {
                    i3 += rectA.left - rect.left;
                }
                i_renamed = rectA.top > rect.top ? (rectA.top - rect.top) + i4 : i4;
                if (rectA.right > rect.right) {
                    i5 -= rectA.right - rect.right;
                }
                if (rectA.bottom > rect.bottom) {
                    i2 = i6 - (rectA.bottom - rect.bottom);
                }
                this.mTrackDrawable.setBounds(i3, i_renamed, i5, i2);
            } else {
                i_renamed = i4;
            }
            i2 = i6;
            this.mTrackDrawable.setBounds(i3, i_renamed, i5, i2);
        }
        android.graphics.drawable.Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i7 = thumbOffset - rect.left;
            int i8 = thumbOffset + this.mThumbWidth + rect.right;
            this.mThumbDrawable.setBounds(i7, i4, i8, i6);
            android.graphics.drawable.Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(background, i7, i4, i8, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int width;
        super.onDraw(canvas);
        android.graphics.Rect rect = this.mTempRect;
        android.graphics.drawable.Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i_renamed = this.mSwitchTop;
        int i2 = this.mSwitchBottom;
        int i3 = i_renamed + rect.top;
        int i4 = i2 - rect.bottom;
        android.graphics.drawable.Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mSplitTrack && drawable2 != null) {
                android.graphics.Rect rectA = androidx.appcompat.widget.aa_renamed.a_renamed(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectA.left;
                rect.right -= rectA.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, android.graphics.Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            } else {
                drawable.draw(canvas);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        android.text.Layout layout = getTargetCheckedState() ? this.mOnLayout : this.mOffLayout;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            android.content.res.ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                android.graphics.Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!androidx.appcompat.widget.ax_renamed.a_renamed(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        return !android.text.TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.mSwitchPadding : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (androidx.appcompat.widget.ax_renamed.a_renamed(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        return !android.text.TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.mSwitchPadding : compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f_renamed;
        if (androidx.appcompat.widget.ax_renamed.a_renamed(this)) {
            f_renamed = 1.0f - this.mThumbPosition;
        } else {
            f_renamed = this.mThumbPosition;
        }
        return (int) ((f_renamed * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.graphics.Rect rectA;
        android.graphics.drawable.Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        android.graphics.Rect rect = this.mTempRect;
        drawable.getPadding(rect);
        android.graphics.drawable.Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            rectA = androidx.appcompat.widget.aa_renamed.a_renamed(drawable2);
        } else {
            rectA = androidx.appcompat.widget.aa_renamed.f520a;
        }
        return ((((this.mSwitchWidth - this.mThumbWidth) - rect.left) - rect.right) - rectA.left) - rectA.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        android.graphics.drawable.Drawable drawable = this.mThumbDrawable;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        android.graphics.drawable.Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f_renamed, float f2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f_renamed, f2);
        }
        android.graphics.drawable.Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, f_renamed, f2);
        }
        android.graphics.drawable.Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable2, f_renamed, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        android.graphics.drawable.Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        android.graphics.drawable.Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        android.animation.ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        java.lang.CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
        if (android.text.TextUtils.isEmpty(charSequence)) {
            return;
        }
        java.lang.CharSequence text = accessibilityNodeInfo.getText();
        if (android.text.TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(android.view.ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i_renamed.a_renamed(this, callback));
    }
}
