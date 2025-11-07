package com.google.android.material.textfield;

/* loaded from: classes.dex */
public class TextInputLayout extends android.widget.LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_TextInputLayout;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final java.lang.String LOG_TAG = "TextInputLayout";
    private android.animation.ValueAnimator animator;
    private com.google.android.material.shape.MaterialShapeDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private com.google.android.material.shape.MaterialShapeDrawable boxUnderline;
    final com.google.android.material.internal.CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private android.content.res.ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private android.content.res.ColorStateList counterTextColor;
    private android.widget.TextView counterView;
    private int defaultFilledBackgroundColor;
    private android.content.res.ColorStateList defaultHintTextColor;
    private int defaultStrokeColor;
    private int disabledColor;
    private final int disabledFilledBackgroundColor;
    android.widget.EditText editText;
    private final java.util.LinkedHashSet<com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener> editTextAttachedListeners;
    private android.graphics.drawable.Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final java.util.LinkedHashSet<com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener> endIconChangedListeners;
    private final android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> endIconDelegates;
    private final android.widget.FrameLayout endIconFrame;
    private int endIconMode;
    private android.view.View.OnLongClickListener endIconOnLongClickListener;
    private android.content.res.ColorStateList endIconTintList;
    private android.graphics.PorterDuff.Mode endIconTintMode;
    private final com.google.android.material.internal.CheckableImageButton endIconView;
    private final android.widget.LinearLayout endLayout;
    private android.content.res.ColorStateList errorIconTintList;
    private final com.google.android.material.internal.CheckableImageButton errorIconView;
    private final int focusedFilledBackgroundColor;
    private int focusedStrokeColor;
    private android.content.res.ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private java.lang.CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredFilledBackgroundColor;
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final com.google.android.material.textfield.IndicatorViewController indicatorViewController;
    private final android.widget.FrameLayout inputFrame;
    private boolean isProvidingHint;
    private android.graphics.drawable.Drawable originalEditTextEndDrawable;
    private java.lang.CharSequence originalHint;
    private boolean placeholderEnabled;
    private java.lang.CharSequence placeholderText;
    private int placeholderTextAppearance;
    private android.content.res.ColorStateList placeholderTextColor;
    private android.widget.TextView placeholderTextView;
    private java.lang.CharSequence prefixText;
    private final android.widget.TextView prefixTextView;
    private boolean restoringSavedState;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;
    private android.graphics.drawable.Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private android.view.View.OnLongClickListener startIconOnLongClickListener;
    private android.content.res.ColorStateList startIconTintList;
    private android.graphics.PorterDuff.Mode startIconTintMode;
    private final com.google.android.material.internal.CheckableImageButton startIconView;
    private final android.widget.LinearLayout startLayout;
    private android.content.res.ColorStateList strokeErrorColor;
    private java.lang.CharSequence suffixText;
    private final android.widget.TextView suffixTextView;
    private final android.graphics.Rect tmpBoundsRect;
    private final android.graphics.Rect tmpRect;
    private final android.graphics.RectF tmpRectF;
    private android.graphics.Typeface typeface;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(com.google.android.material.textfield.TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(com.google.android.material.textfield.TextInputLayout textInputLayout, int i_renamed);
    }

    public TextInputLayout(android.content.Context context) {
        this(context, null);
    }

    public TextInputLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.textInputStyle);
    }

    public TextInputLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.indicatorViewController = new com.google.android.material.textfield.IndicatorViewController(this);
        this.tmpRect = new android.graphics.Rect();
        this.tmpBoundsRect = new android.graphics.Rect();
        this.tmpRectF = new android.graphics.RectF();
        this.editTextAttachedListeners = new java.util.LinkedHashSet<>();
        this.endIconMode = 0;
        this.endIconDelegates = new android.util.SparseArray<>();
        this.endIconChangedListeners = new java.util.LinkedHashSet<>();
        this.collapsingTextHelper = new com.google.android.material.internal.CollapsingTextHelper(this);
        android.content.Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.inputFrame = new android.widget.FrameLayout(context2);
        this.inputFrame.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        this.startLayout = new android.widget.LinearLayout(context2);
        this.startLayout.setOrientation(0);
        this.startLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1, 8388611));
        this.inputFrame.addView(this.startLayout);
        this.endLayout = new android.widget.LinearLayout(context2);
        this.endLayout.setOrientation(0);
        this.endLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1, 8388613));
        this.inputFrame.addView(this.endLayout);
        this.endIconFrame = new android.widget.FrameLayout(context2);
        this.endIconFrame.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1));
        this.collapsingTextHelper.setTextSizeInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setPositionInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setCollapsedTextGravity(com.google.android.material.badge.BadgeDrawable.TOP_START);
        androidx.appcompat.widget.ar_renamed arVarObtainTintedStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.TextInputLayout, i_renamed, DEF_STYLE_RES, com.google.android.material.R_renamed.styleable.TextInputLayout_counterTextAppearance, com.google.android.material.R_renamed.styleable.TextInputLayout_counterOverflowTextAppearance, com.google.android.material.R_renamed.styleable.TextInputLayout_errorTextAppearance, com.google.android.material.R_renamed.styleable.TextInputLayout_helperTextTextAppearance, com.google.android.material.R_renamed.styleable.TextInputLayout_hintTextAppearance);
        this.hintEnabled = arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_hintEnabled, true);
        setHint(arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.shapeAppearanceModel = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i_renamed, DEF_STYLE_RES).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = arVarObtainTintedStyledAttributes.d_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float fB_renamed = arVarObtainTintedStyledAttributes.b_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fB2 = arVarObtainTintedStyledAttributes.b_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fB3 = arVarObtainTintedStyledAttributes.b_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fB4 = arVarObtainTintedStyledAttributes.b_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        com.google.android.material.shape.ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        if (fB_renamed >= 0.0f) {
            builder.setTopLeftCornerSize(fB_renamed);
        }
        if (fB2 >= 0.0f) {
            builder.setTopRightCornerSize(fB2);
        }
        if (fB3 >= 0.0f) {
            builder.setBottomRightCornerSize(fB3);
        }
        if (fB4 >= 0.0f) {
            builder.setBottomLeftCornerSize(fB4);
        }
        this.shapeAppearanceModel = builder.build();
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateList != null) {
            this.defaultFilledBackgroundColor = colorStateList.getDefaultColor();
            this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R_renamed.attr.state_focused, android.R_renamed.attr.state_enabled}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R_renamed.attr.state_hovered, android.R_renamed.attr.state_enabled}, -1);
            } else {
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                android.content.res.ColorStateList colorStateListA = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context2, com.google.android.material.R_renamed.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateListA.getColorForState(new int[]{android.R_renamed.attr.state_hovered}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_android_textColorHint)) {
            android.content.res.ColorStateList colorStateListE = arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_android_textColorHint);
            this.focusedTextColor = colorStateListE;
            this.defaultHintTextColor = colorStateListE;
        }
        android.content.res.ColorStateList colorStateList2 = com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.TextInputLayout_boxStrokeColor);
        this.focusedStrokeColor = arVarObtainTintedStyledAttributes.b_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxStrokeColor, 0);
        this.defaultStrokeColor = androidx.core.a_renamed.a_renamed.c_renamed(context2, com.google.android.material.R_renamed.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = androidx.core.a_renamed.a_renamed.c_renamed(context2, com.google.android.material.R_renamed.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = androidx.core.a_renamed.a_renamed.c_renamed(context2, com.google.android.material.R_renamed.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList2 != null) {
            setBoxStrokeColorStateList(colorStateList2);
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.TextInputLayout_boxStrokeErrorColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int iG = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorTextAppearance, 0);
        java.lang.CharSequence charSequenceC = arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorContentDescription);
        boolean zA = arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorEnabled, false);
        this.errorIconView = (com.google.android.material.internal.CheckableImageButton) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R_renamed.layout.design_text_input_end_icon, (android.view.ViewGroup) this.endLayout, false);
        this.errorIconView.setVisibility(8);
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorIconDrawable));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.TextInputLayout_errorIconTint));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorIconTintMode, -1), null));
        }
        this.errorIconView.setContentDescription(getResources().getText(com.google.android.material.R_renamed.string.error_icon_content_description));
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
        int iG2 = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_helperTextEnabled, false);
        java.lang.CharSequence charSequenceC2 = arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_helperText);
        int iG3 = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_placeholderTextAppearance, 0);
        java.lang.CharSequence charSequenceC3 = arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_placeholderText);
        int iG4 = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_prefixTextAppearance, 0);
        java.lang.CharSequence charSequenceC4 = arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_prefixText);
        int iG5 = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_suffixTextAppearance, 0);
        java.lang.CharSequence charSequenceC5 = arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_suffixText);
        boolean zA3 = arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.startIconView = (com.google.android.material.internal.CheckableImageButton) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R_renamed.layout.design_text_input_start_icon, (android.view.ViewGroup) this.startLayout, false);
        this.startIconView.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconDrawable));
            if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconCheckable, true));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconTint)) {
            setStartIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.TextInputLayout_startIconTint));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_startIconTintMode, -1), null));
        }
        setBoxBackgroundMode(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_boxBackgroundMode, 0));
        this.endIconView = (com.google.android.material.internal.CheckableImageButton) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R_renamed.layout.design_text_input_end_icon, (android.view.ViewGroup) this.endIconFrame, false);
        this.endIconFrame.addView(this.endIconView);
        this.endIconView.setVisibility(8);
        this.endIconDelegates.append(-1, new com.google.android.material.textfield.CustomEndIconDelegate(this));
        this.endIconDelegates.append(0, new com.google.android.material.textfield.NoEndIconDelegate(this));
        this.endIconDelegates.append(1, new com.google.android.material.textfield.PasswordToggleEndIconDelegate(this));
        this.endIconDelegates.append(2, new com.google.android.material.textfield.ClearTextEndIconDelegate(this));
        this.endIconDelegates.append(3, new com.google.android.material.textfield.DropdownMenuEndIconDelegate(this));
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconMode)) {
            setEndIconMode(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconMode, 0));
            if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconDrawable));
            }
            if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconCheckable, true));
        } else if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleContentDescription));
            if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleTint));
            }
            if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleTintMode, -1), null));
            }
        }
        if (!arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_passwordToggleEnabled)) {
            if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconTint)) {
                setEndIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.TextInputLayout_endIconTint));
            }
            if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_endIconTintMode, -1), null));
            }
        }
        this.prefixTextView = new androidx.appcompat.widget.AppCompatTextView(context2);
        this.prefixTextView.setId(com.google.android.material.R_renamed.id_renamed.textinput_prefix_text);
        this.prefixTextView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        androidx.core.h_renamed.v_renamed.d_renamed(this.prefixTextView, 1);
        this.startLayout.addView(this.startIconView);
        this.startLayout.addView(this.prefixTextView);
        this.suffixTextView = new androidx.appcompat.widget.AppCompatTextView(context2);
        this.suffixTextView.setId(com.google.android.material.R_renamed.id_renamed.textinput_suffix_text);
        this.suffixTextView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2, 80));
        androidx.core.h_renamed.v_renamed.d_renamed(this.suffixTextView, 1);
        this.endLayout.addView(this.suffixTextView);
        this.endLayout.addView(this.errorIconView);
        this.endLayout.addView(this.endIconFrame);
        setHelperTextEnabled(zA2);
        setHelperText(charSequenceC2);
        setHelperTextTextAppearance(iG2);
        setErrorEnabled(zA);
        setErrorTextAppearance(iG);
        setErrorContentDescription(charSequenceC);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(charSequenceC3);
        setPlaceholderTextAppearance(iG3);
        setPrefixText(charSequenceC4);
        setPrefixTextAppearance(iG4);
        setSuffixText(charSequenceC5);
        setSuffixTextAppearance(iG5);
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_errorTextColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_helperTextTextColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_hintTextColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterTextColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_counterOverflowTextColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_placeholderTextColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_prefixTextColor)) {
            setPrefixTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_prefixTextColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_suffixTextColor));
        }
        setCounterEnabled(zA3);
        setEnabled(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.TextInputLayout_android_enabled, true));
        arVarObtainTintedStyledAttributes.b_renamed();
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this, 2);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        if (view instanceof android.widget.EditText) {
            android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((android.widget.EditText) view);
            return;
        }
        super.addView(view, i_renamed, layoutParams);
    }

    com.google.android.material.shape.MaterialShapeDrawable getBoxBackground() {
        int i_renamed = this.boxBackgroundMode;
        if (i_renamed == 1 || i_renamed == 2) {
            return this.boxBackground;
        }
        throw new java.lang.IllegalStateException();
    }

    public void setBoxBackgroundMode(int i_renamed) {
        if (i_renamed == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i_renamed;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void assignBoxBackgroundByMode() {
        int i_renamed = this.boxBackgroundMode;
        if (i_renamed == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
            return;
        }
        if (i_renamed == 1) {
            this.boxBackground = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderline = new com.google.android.material.shape.MaterialShapeDrawable();
        } else {
            if (i_renamed == 2) {
                if (this.hintEnabled && !(this.boxBackground instanceof com.google.android.material.textfield.CutoutDrawable)) {
                    this.boxBackground = new com.google.android.material.textfield.CutoutDrawable(this.shapeAppearanceModel);
                } else {
                    this.boxBackground = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
                }
                this.boxUnderline = null;
                return;
            }
            throw new java.lang.IllegalArgumentException(this.boxBackgroundMode + " is_renamed illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            androidx.core.h_renamed.v_renamed.a_renamed(this.editText, this.boxBackground);
        }
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        android.widget.EditText editText = this.editText;
        return (editText == null || this.boxBackground == null || editText.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
    }

    public void setBoxStrokeColor(int i_renamed) {
        if (this.focusedStrokeColor != i_renamed) {
            this.focusedStrokeColor = i_renamed;
            updateTextInputBoxState();
        }
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public void setBoxStrokeColorStateList(android.content.res.ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{android.R_renamed.attr.state_hovered, android.R_renamed.attr.state_enabled}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{android.R_renamed.attr.state_focused, android.R_renamed.attr.state_enabled}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(android.content.res.ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public android.content.res.ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public void setBoxBackgroundColorResource(int i_renamed) {
        setBoxBackgroundColor(androidx.core.a_renamed.a_renamed.c_renamed(getContext(), i_renamed));
    }

    public void setBoxBackgroundColor(int i_renamed) {
        if (this.boxBackgroundColor != i_renamed) {
            this.boxBackgroundColor = i_renamed;
            this.defaultFilledBackgroundColor = i_renamed;
            applyBoxAttributes();
        }
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public void setBoxCornerRadiiResources(int i_renamed, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i_renamed), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxCornerRadii(float f_renamed, float f2, float f3, float f4) {
        if (this.boxBackground.getTopLeftCornerResolvedSize() == f_renamed && this.boxBackground.getTopRightCornerResolvedSize() == f2 && this.boxBackground.getBottomRightCornerResolvedSize() == f4 && this.boxBackground.getBottomLeftCornerResolvedSize() == f3) {
            return;
        }
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f_renamed).setTopRightCornerSize(f2).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f3).build();
        applyBoxAttributes();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public void setTypeface(android.graphics.Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            this.indicatorViewController.setTypefaces(typeface);
            android.widget.TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public android.graphics.Typeface getTypeface() {
        return this.typeface;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(android.view.ViewStructure viewStructure, int i_renamed) {
        android.widget.EditText editText;
        if (this.originalHint == null || (editText = this.editText) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i_renamed);
            return;
        }
        boolean z_renamed = this.isProvidingHint;
        this.isProvidingHint = false;
        java.lang.CharSequence hint = editText.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i_renamed);
        } finally {
            this.editText.setHint(hint);
            this.isProvidingHint = z_renamed;
        }
    }

    private void setEditText(android.widget.EditText editText) {
        if (this.editText != null) {
            throw new java.lang.IllegalArgumentException("We already have an_renamed EditText, can only have one");
        }
        if (this.endIconMode != 3 && !(editText instanceof com.google.android.material.textfield.TextInputEditText)) {
            android.util.Log.i_renamed(LOG_TAG, "EditText added is_renamed not a_renamed TextInputEditText. Please switch to using that class instead.");
        }
        this.editText = editText;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int gravity = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(gravity);
        this.editText.addTextChangedListener(new android.text.TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                com.google.android.material.textfield.TextInputLayout.this.updateLabelState(!r0.restoringSavedState);
                if (com.google.android.material.textfield.TextInputLayout.this.counterEnabled) {
                    com.google.android.material.textfield.TextInputLayout.this.updateCounter(editable.length());
                }
                if (com.google.android.material.textfield.TextInputLayout.this.placeholderEnabled) {
                    com.google.android.material.textfield.TextInputLayout.this.updatePlaceholderText(editable.length());
                }
            }
        });
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (android.text.TextUtils.isEmpty(this.hint)) {
                this.originalHint = this.editText.getHint();
                setHint(this.originalHint);
                this.editText.setHint((java.lang.CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        updateLabelState(false, true);
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int iCalculateLabelMarginTop = calculateLabelMarginTop();
            if (iCalculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = iCalculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        android.widget.EditText editText = this.editText;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + calculateLabelMarginTop();
        }
        return super.getBaseline();
    }

    void updateLabelState(boolean z_renamed) {
        updateLabelState(z_renamed, false);
    }

    private void updateLabelState(boolean z_renamed, boolean z2) {
        android.content.res.ColorStateList colorStateList;
        android.widget.TextView textView;
        boolean zIsEnabled = isEnabled();
        android.widget.EditText editText = this.editText;
        boolean z3 = (editText == null || android.text.TextUtils.isEmpty(editText.getText())) ? false : true;
        android.widget.EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean zErrorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        android.content.res.ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!zIsEnabled) {
            android.content.res.ColorStateList colorStateList3 = this.defaultHintTextColor;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            this.collapsingTextHelper.setCollapsedTextColor(android.content.res.ColorStateList.valueOf(colorForState));
            this.collapsingTextHelper.setExpandedTextColor(android.content.res.ColorStateList.valueOf(colorForState));
        } else if (zErrorShouldBeShown) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z3 || (isEnabled() && (z4 || zErrorShouldBeShown))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z_renamed);
                return;
            }
            return;
        }
        if (z2 || !this.hintExpanded) {
            expandHint(z_renamed);
        }
    }

    public android.widget.EditText getEditText() {
        return this.editText;
    }

    public void setHint(java.lang.CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.setText(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    public java.lang.CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public void setHintEnabled(boolean z_renamed) {
        if (z_renamed != this.hintEnabled) {
            this.hintEnabled = z_renamed;
            if (!this.hintEnabled) {
                this.isProvidingHint = false;
                if (!android.text.TextUtils.isEmpty(this.hint) && android.text.TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                java.lang.CharSequence hint = this.editText.getHint();
                if (!android.text.TextUtils.isEmpty(hint)) {
                    if (android.text.TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((java.lang.CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public void setHintTextAppearance(int i_renamed) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i_renamed);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(android.content.res.ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    public android.content.res.ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public void setDefaultHintTextColor(android.content.res.ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public android.content.res.ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public void setErrorEnabled(boolean z_renamed) {
        this.indicatorViewController.setErrorEnabled(z_renamed);
    }

    public void setErrorTextAppearance(int i_renamed) {
        this.indicatorViewController.setErrorTextAppearance(i_renamed);
    }

    public void setErrorTextColor(android.content.res.ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public void setHelperTextTextAppearance(int i_renamed) {
        this.indicatorViewController.setHelperTextAppearance(i_renamed);
    }

    public void setHelperTextColor(android.content.res.ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public void setHelperTextEnabled(boolean z_renamed) {
        this.indicatorViewController.setHelperTextEnabled(z_renamed);
    }

    public void setHelperText(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        }
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public void setErrorContentDescription(java.lang.CharSequence charSequence) {
        this.indicatorViewController.setErrorContentDescription(charSequence);
    }

    public java.lang.CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    public void setError(java.lang.CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (android.text.TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.showError(charSequence);
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setErrorIconDrawable(int i_renamed) {
        setErrorIconDrawable(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed) : null);
    }

    public void setErrorIconDrawable(android.graphics.drawable.Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.isErrorEnabled());
    }

    public android.graphics.drawable.Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public void setErrorIconTintList(android.content.res.ColorStateList colorStateList) {
        this.errorIconTintList = colorStateList;
        android.graphics.drawable.Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setCounterEnabled(boolean z_renamed) {
        if (this.counterEnabled != z_renamed) {
            if (z_renamed) {
                this.counterView = new androidx.appcompat.widget.AppCompatTextView(getContext());
                this.counterView.setId(com.google.android.material.R_renamed.id_renamed.textinput_counter);
                android.graphics.Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                androidx.core.h_renamed.f_renamed.a_renamed((android.view.ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z_renamed;
        }
    }

    public void setCounterTextAppearance(int i_renamed) {
        if (this.counterTextAppearance != i_renamed) {
            this.counterTextAppearance = i_renamed;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(android.content.res.ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public android.content.res.ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public void setCounterOverflowTextAppearance(int i_renamed) {
        if (this.counterOverflowTextAppearance != i_renamed) {
            this.counterOverflowTextAppearance = i_renamed;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(android.content.res.ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public android.content.res.ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public void setCounterMaxLength(int i_renamed) {
        if (this.counterMaxLength != i_renamed) {
            if (i_renamed > 0) {
                this.counterMaxLength = i_renamed;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            android.widget.EditText editText = this.editText;
            updateCounter(editText == null ? 0 : editText.getText().length());
        }
    }

    void updateCounter(int i_renamed) {
        boolean z_renamed = this.counterOverflowed;
        int i2 = this.counterMaxLength;
        if (i2 == -1) {
            this.counterView.setText(java.lang.String.valueOf(i_renamed));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i_renamed > i2;
            updateCounterContentDescription(getContext(), this.counterView, i_renamed, this.counterMaxLength, this.counterOverflowed);
            if (z_renamed != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            this.counterView.setText(androidx.core.f_renamed.a_renamed.a_renamed().a_renamed(getContext().getString(com.google.android.material.R_renamed.string.character_counter_pattern, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(this.counterMaxLength))));
        }
        if (this.editText == null || z_renamed == this.counterOverflowed) {
            return;
        }
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }

    private static void updateCounterContentDescription(android.content.Context context, android.widget.TextView textView, int i_renamed, int i2, boolean z_renamed) {
        textView.setContentDescription(context.getString(z_renamed ? com.google.android.material.R_renamed.string.character_counter_overflowed_content_description : com.google.android.material.R_renamed.string.character_counter_content_description, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
    }

    public void setPlaceholderText(java.lang.CharSequence charSequence) {
        if (this.placeholderEnabled && android.text.TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        updatePlaceholderText();
    }

    public java.lang.CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    private void setPlaceholderTextEnabled(boolean z_renamed) {
        if (this.placeholderEnabled == z_renamed) {
            return;
        }
        if (z_renamed) {
            this.placeholderTextView = new androidx.appcompat.widget.AppCompatTextView(getContext());
            this.placeholderTextView.setId(com.google.android.material.R_renamed.id_renamed.textinput_placeholder);
            androidx.core.h_renamed.v_renamed.d_renamed(this.placeholderTextView, 1);
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
            addPlaceholderTextView();
        } else {
            removePlaceholderTextView();
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z_renamed;
    }

    private void updatePlaceholderText() {
        android.widget.EditText editText = this.editText;
        updatePlaceholderText(editText == null ? 0 : editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaceholderText(int i_renamed) {
        if (i_renamed == 0 && !this.hintExpanded) {
            showPlaceholderText();
        } else {
            hidePlaceholderText();
        }
    }

    private void showPlaceholderText() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText(this.placeholderText);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
    }

    private void hidePlaceholderText() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText((java.lang.CharSequence) null);
        this.placeholderTextView.setVisibility(4);
    }

    private void addPlaceholderTextView() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void removePlaceholderTextView() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setPlaceholderTextColor(android.content.res.ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            android.widget.TextView textView = this.placeholderTextView;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public android.content.res.ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public void setPlaceholderTextAppearance(int i_renamed) {
        this.placeholderTextAppearance = i_renamed;
        android.widget.TextView textView = this.placeholderTextView;
        if (textView != null) {
            androidx.core.widget.i_renamed.a_renamed(textView, i_renamed);
        }
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public void setPrefixText(java.lang.CharSequence charSequence) {
        this.prefixText = android.text.TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.prefixTextView.setText(charSequence);
        updatePrefixTextVisibility();
    }

    public java.lang.CharSequence getPrefixText() {
        return this.prefixText;
    }

    public android.widget.TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    private void updatePrefixTextVisibility() {
        this.prefixTextView.setVisibility((this.prefixText == null || isHintExpanded()) ? 8 : 0);
        updateDummyDrawables();
    }

    public void setPrefixTextColor(android.content.res.ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    public android.content.res.ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    public void setPrefixTextAppearance(int i_renamed) {
        androidx.core.widget.i_renamed.a_renamed(this.prefixTextView, i_renamed);
    }

    private void updatePrefixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        this.prefixTextView.setPadding(isStartIconVisible() ? 0 : this.editText.getPaddingLeft(), this.editText.getCompoundPaddingTop(), this.prefixTextView.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
    }

    public void setSuffixText(java.lang.CharSequence charSequence) {
        this.suffixText = android.text.TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public java.lang.CharSequence getSuffixText() {
        return this.suffixText;
    }

    public android.widget.TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    private void updateSuffixTextVisibility() {
        int visibility = this.suffixTextView.getVisibility();
        boolean z_renamed = (this.suffixText == null || isHintExpanded()) ? false : true;
        this.suffixTextView.setVisibility(z_renamed ? 0 : 8);
        if (visibility != this.suffixTextView.getVisibility()) {
            getEndIconDelegate().onSuffixVisibilityChanged(z_renamed);
        }
        updateDummyDrawables();
    }

    public void setSuffixTextColor(android.content.res.ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    public android.content.res.ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public void setSuffixTextAppearance(int i_renamed) {
        androidx.core.widget.i_renamed.a_renamed(this.suffixTextView, i_renamed);
    }

    private void updateSuffixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        android.widget.TextView textView = this.suffixTextView;
        textView.setPadding(textView.getPaddingLeft(), this.editText.getPaddingTop(), (isEndIconVisible() || isErrorIconVisible()) ? 0 : this.editText.getPaddingRight(), this.editText.getPaddingBottom());
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        recursiveSetEnabled(this, z_renamed);
        super.setEnabled(z_renamed);
    }

    private static void recursiveSetEnabled(android.view.ViewGroup viewGroup, boolean z_renamed) {
        int childCount = viewGroup.getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = viewGroup.getChildAt(i_renamed);
            childAt.setEnabled(z_renamed);
            if (childAt instanceof android.view.ViewGroup) {
                recursiveSetEnabled((android.view.ViewGroup) childAt, z_renamed);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    java.lang.CharSequence getCounterOverflowDescription() {
        android.widget.TextView textView;
        if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    private void updateCounterTextAppearanceAndColor() {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2;
        android.widget.TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
                return;
            }
            this.counterView.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void setTextAppearanceCompatWithErrorFallback(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.i_renamed.a_renamed(r3, r4)     // Catch: java.lang.Exception -> L1a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1a
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1a
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1a
        L18:
            r4 = 0
            r0 = r4
        L1a:
            if (r0 == 0) goto L2e
            int r4 = com.google.android.material.R_renamed.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.i_renamed.a_renamed(r3, r4)
            android.content.Context r2 = r2.getContext()
            int r4 = com.google.android.material.R_renamed.color.design_error
            int r2 = androidx.core.a_renamed.a_renamed.c_renamed(r2, r4)
            r3.setTextColor(r2)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.setTextAppearanceCompatWithErrorFallback(android.widget.TextView, int):void");
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i_renamed = this.boxBackgroundMode;
        if (i_renamed == 0 || i_renamed == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else {
            if (i_renamed != 2) {
                return 0;
            }
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private android.graphics.Rect calculateCollapsedTextBounds(android.graphics.Rect rect) {
        if (this.editText == null) {
            throw new java.lang.IllegalStateException();
        }
        android.graphics.Rect rect2 = this.tmpBoundsRect;
        boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
        rect2.bottom = rect.bottom;
        int i_renamed = this.boxBackgroundMode;
        if (i_renamed == 1) {
            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z_renamed);
            rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z_renamed);
            return rect2;
        }
        if (i_renamed == 2) {
            rect2.left = rect.left + this.editText.getPaddingLeft();
            rect2.top = rect.top - calculateLabelMarginTop();
            rect2.right = rect.right - this.editText.getPaddingRight();
            return rect2;
        }
        rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z_renamed);
        rect2.top = getPaddingTop();
        rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z_renamed);
        return rect2;
    }

    private int getLabelLeftBoundAlightWithPrefix(int i_renamed, boolean z_renamed) {
        int compoundPaddingLeft = i_renamed + this.editText.getCompoundPaddingLeft();
        return (this.prefixText == null || z_renamed) ? compoundPaddingLeft : (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    }

    private int getLabelRightBoundAlignedWithSuffix(int i_renamed, boolean z_renamed) {
        int compoundPaddingRight = i_renamed - this.editText.getCompoundPaddingRight();
        return (this.prefixText == null || !z_renamed) ? compoundPaddingRight : compoundPaddingRight + this.prefixTextView.getMeasuredWidth() + this.prefixTextView.getPaddingRight();
    }

    private android.graphics.Rect calculateExpandedTextBounds(android.graphics.Rect rect) {
        if (this.editText == null) {
            throw new java.lang.IllegalStateException();
        }
        android.graphics.Rect rect2 = this.tmpBoundsRect;
        float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
        rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
        rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
        rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
        return rect2;
    }

    private int calculateExpandedLabelTop(android.graphics.Rect rect, float f_renamed) {
        if (isSingleLineFilledTextField()) {
            return (int) (rect.centerY() - (f_renamed / 2.0f));
        }
        return rect.top + this.editText.getCompoundPaddingTop();
    }

    private int calculateExpandedLabelBottom(android.graphics.Rect rect, android.graphics.Rect rect2, float f_renamed) {
        if (isSingleLineFilledTextField()) {
            return (int) (rect2.top + f_renamed);
        }
        return rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private boolean isSingleLineFilledTextField() {
        return this.boxBackgroundMode == 1 && (android.os.Build.VERSION.SDK_INT < 16 || this.editText.getMinLines() <= 1);
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? com.google.android.material.color.MaterialColors.layer(com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorSurface, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    private void applyBoxAttributes() {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke()) {
            this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
        }
        this.boxBackgroundColor = calculateBoxBackgroundColor();
        this.boxBackground.setFillColor(android.content.res.ColorStateList.valueOf(this.boxBackgroundColor));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline == null) {
            return;
        }
        if (canDrawStroke()) {
            this.boxUnderline.setFillColor(android.content.res.ColorStateList.valueOf(this.boxStrokeColor));
        }
        invalidate();
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0;
    }

    void updateEditTextBackground() {
        android.graphics.drawable.Drawable background;
        android.widget.TextView textView;
        android.widget.EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.aa_renamed.c_renamed(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.errorShouldBeShown()) {
            background.setColorFilter(androidx.appcompat.widget.i_renamed.a_renamed(this.indicatorViewController.getErrorViewCurrentTextColor(), android.graphics.PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(androidx.appcompat.widget.i_renamed.a_renamed(textView.getCurrentTextColor(), android.graphics.PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a_renamed.f_renamed(background);
            this.editText.refreshDrawableState();
        }
    }

    static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.textfield.TextInputLayout.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.textfield.TextInputLayout.SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.google.android.material.textfield.TextInputLayout.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.textfield.TextInputLayout.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.textfield.TextInputLayout.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.textfield.TextInputLayout.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.textfield.TextInputLayout.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.textfield.TextInputLayout.SavedState[i_renamed];
            }
        };
        java.lang.CharSequence error;
        boolean isEndIconChecked;

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            android.text.TextUtils.writeToParcel(this.error, parcel, i_renamed);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
        }

        public java.lang.String toString() {
            return "TextInputLayout.SavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " error=" + ((java.lang.Object) this.error) + "}";
        }
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.textfield.TextInputLayout.SavedState savedState = new com.google.android.material.textfield.TextInputLayout.SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = hasEndIcon() && this.endIconView.isChecked();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.textfield.TextInputLayout.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.textfield.TextInputLayout.SavedState savedState = (com.google.android.material.textfield.TextInputLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new java.lang.Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    com.google.android.material.textfield.TextInputLayout.this.endIconView.performClick();
                    com.google.android.material.textfield.TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public java.lang.CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    public java.lang.CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean z_renamed) {
        this.hintAnimationEnabled = z_renamed;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        boolean zUpdateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean zUpdateDummyDrawables = updateDummyDrawables();
        if (zUpdateEditTextHeightBasedOnIcon || zUpdateDummyDrawables) {
            this.editText.post(new java.lang.Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    com.google.android.material.textfield.TextInputLayout.this.editText.requestLayout();
                }
            });
        }
        updatePlaceholderMeasurementsBasedOnEditText();
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int iMax;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (iMax = java.lang.Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(iMax);
        return true;
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        android.widget.EditText editText;
        if (this.placeholderTextView == null || (editText = this.editText) == null) {
            return;
        }
        this.placeholderTextView.setGravity(editText.getGravity());
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
    }

    public void setStartIconDrawable(int i_renamed) {
        setStartIconDrawable(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed) : null);
    }

    public void setStartIconDrawable(android.graphics.drawable.Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            applyStartIconTint();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((java.lang.CharSequence) null);
        }
    }

    public android.graphics.drawable.Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public void setStartIconOnClickListener(android.view.View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconVisible(boolean z_renamed) {
        if (isStartIconVisible() != z_renamed) {
            this.startIconView.setVisibility(z_renamed ? 0 : 8);
            updatePrefixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    public void setStartIconCheckable(boolean z_renamed) {
        this.startIconView.setCheckable(z_renamed);
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public void setStartIconContentDescription(int i_renamed) {
        setStartIconContentDescription(i_renamed != 0 ? getResources().getText(i_renamed) : null);
    }

    public void setStartIconContentDescription(java.lang.CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public java.lang.CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public void setStartIconTintList(android.content.res.ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setEndIconMode(int i_renamed) {
        int i2 = this.endIconMode;
        this.endIconMode = i_renamed;
        setEndIconVisible(i_renamed != 0);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            dispatchOnEndIconChanged(i2);
        } else {
            throw new java.lang.IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is_renamed not supported by_renamed the end icon mode " + i_renamed);
        }
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    public void setEndIconOnClickListener(android.view.View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconVisible(boolean z_renamed) {
        if (isEndIconVisible() != z_renamed) {
            this.endIconView.setVisibility(z_renamed ? 0 : 8);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public void setEndIconActivated(boolean z_renamed) {
        this.endIconView.setActivated(z_renamed);
    }

    public void setEndIconCheckable(boolean z_renamed) {
        this.endIconView.setCheckable(z_renamed);
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public void setEndIconDrawable(int i_renamed) {
        setEndIconDrawable(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed) : null);
    }

    public void setEndIconDrawable(android.graphics.drawable.Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public android.graphics.drawable.Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public void setEndIconContentDescription(int i_renamed) {
        setEndIconContentDescription(i_renamed != 0 ? getResources().getText(i_renamed) : null);
    }

    public void setEndIconContentDescription(java.lang.CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public java.lang.CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public void setEndIconTintList(android.content.res.ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void addOnEndIconChangedListener(com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    public void removeOnEndIconChangedListener(com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    public void addOnEditTextAttachedListener(com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void removeOnEditTextAttachedListener(com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleDrawable(int i_renamed) {
        setPasswordVisibilityToggleDrawable(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed) : null);
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleDrawable(android.graphics.drawable.Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i_renamed) {
        setPasswordVisibilityToggleContentDescription(i_renamed != 0 ? getResources().getText(i_renamed) : null);
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleContentDescription(java.lang.CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @java.lang.Deprecated
    public android.graphics.drawable.Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @java.lang.Deprecated
    public java.lang.CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @java.lang.Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z_renamed) {
        if (z_renamed && this.endIconMode != 1) {
            setEndIconMode(1);
        } else {
            if (z_renamed) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleTintList(android.content.res.ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleTintMode(android.graphics.PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    @java.lang.Deprecated
    public void passwordVisibilityToggleRequested(boolean z_renamed) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z_renamed) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void setTextInputAccessibilityDelegate(com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate accessibilityDelegate) {
        android.widget.EditText editText = this.editText;
        if (editText != null) {
            androidx.core.h_renamed.v_renamed.a_renamed(editText, accessibilityDelegate);
        }
    }

    com.google.android.material.internal.CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    private com.google.android.material.textfield.EndIconDelegate getEndIconDelegate() {
        com.google.android.material.textfield.EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
        return endIconDelegate != null ? endIconDelegate : this.endIconDelegates.get(0);
    }

    private void dispatchOnEditTextAttached() {
        java.util.Iterator<com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private void dispatchOnEndIconChanged(int i_renamed) {
        java.util.Iterator<com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i_renamed);
        }
    }

    private void tintEndIconOnError(boolean z_renamed) {
        if (z_renamed && getEndIconDrawable() != null) {
            android.graphics.drawable.Drawable drawableMutate = androidx.core.graphics.drawable.a_renamed.g_renamed(getEndIconDrawable()).mutate();
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawableMutate, this.indicatorViewController.getErrorViewCurrentTextColor());
            this.endIconView.setImageDrawable(drawableMutate);
            return;
        }
        applyEndIconTint();
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private boolean updateDummyDrawables() {
        boolean z_renamed;
        if (this.editText == null) {
            return false;
        }
        if (shouldUpdateStartDummyDrawable()) {
            int measuredWidth = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
            if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                this.startDummyDrawable = new android.graphics.drawable.ColorDrawable();
                this.startDummyDrawableWidth = measuredWidth;
                this.startDummyDrawable.setBounds(0, 0, this.startDummyDrawableWidth, 1);
            }
            android.graphics.drawable.Drawable[] drawableArrB = androidx.core.widget.i_renamed.b_renamed(this.editText);
            android.graphics.drawable.Drawable drawable = drawableArrB[0];
            android.graphics.drawable.Drawable drawable2 = this.startDummyDrawable;
            if (drawable != drawable2) {
                androidx.core.widget.i_renamed.a_renamed(this.editText, drawable2, drawableArrB[1], drawableArrB[2], drawableArrB[3]);
                z_renamed = true;
            }
            z_renamed = false;
        } else {
            if (this.startDummyDrawable != null) {
                android.graphics.drawable.Drawable[] drawableArrB2 = androidx.core.widget.i_renamed.b_renamed(this.editText);
                androidx.core.widget.i_renamed.a_renamed(this.editText, null, drawableArrB2[1], drawableArrB2[2], drawableArrB2[3]);
                this.startDummyDrawable = null;
                z_renamed = true;
            }
            z_renamed = false;
        }
        if (shouldUpdateEndDummyDrawable()) {
            int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
            com.google.android.material.internal.CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + androidx.core.h_renamed.f_renamed.a_renamed((android.view.ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            android.graphics.drawable.Drawable[] drawableArrB3 = androidx.core.widget.i_renamed.b_renamed(this.editText);
            android.graphics.drawable.Drawable drawable3 = this.endDummyDrawable;
            if (drawable3 != null && this.endDummyDrawableWidth != measuredWidth2) {
                this.endDummyDrawableWidth = measuredWidth2;
                drawable3.setBounds(0, 0, this.endDummyDrawableWidth, 1);
                androidx.core.widget.i_renamed.a_renamed(this.editText, drawableArrB3[0], drawableArrB3[1], this.endDummyDrawable, drawableArrB3[3]);
            } else {
                if (this.endDummyDrawable == null) {
                    this.endDummyDrawable = new android.graphics.drawable.ColorDrawable();
                    this.endDummyDrawableWidth = measuredWidth2;
                    this.endDummyDrawable.setBounds(0, 0, this.endDummyDrawableWidth, 1);
                }
                android.graphics.drawable.Drawable drawable4 = drawableArrB3[2];
                android.graphics.drawable.Drawable drawable5 = this.endDummyDrawable;
                if (drawable4 == drawable5) {
                    return z_renamed;
                }
                this.originalEditTextEndDrawable = drawableArrB3[2];
                androidx.core.widget.i_renamed.a_renamed(this.editText, drawableArrB3[0], drawableArrB3[1], drawable5, drawableArrB3[3]);
            }
            return true;
        }
        if (this.endDummyDrawable == null) {
            return z_renamed;
        }
        android.graphics.drawable.Drawable[] drawableArrB4 = androidx.core.widget.i_renamed.b_renamed(this.editText);
        if (drawableArrB4[2] == this.endDummyDrawable) {
            androidx.core.widget.i_renamed.a_renamed(this.editText, drawableArrB4[0], drawableArrB4[1], this.originalEditTextEndDrawable, drawableArrB4[3]);
            z_renamed = true;
        }
        this.endDummyDrawable = null;
        return z_renamed;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        return !(getStartIconDrawable() == null && this.prefixText == null) && this.startLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUpdateEndDummyDrawable() {
        return (this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0;
    }

    private com.google.android.material.internal.CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (hasEndIcon() && isEndIconVisible()) {
            return this.endIconView;
        }
        return null;
    }

    private void applyIconTint(com.google.android.material.internal.CheckableImageButton checkableImageButton, boolean z_renamed, android.content.res.ColorStateList colorStateList, boolean z2, android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z_renamed || z2)) {
            drawable = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
            if (z_renamed) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, colorStateList);
            }
            if (z2) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private static void setIconOnClickListener(com.google.android.material.internal.CheckableImageButton checkableImageButton, android.view.View.OnClickListener onClickListener, android.view.View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(com.google.android.material.internal.CheckableImageButton checkableImageButton, android.view.View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconClickable(com.google.android.material.internal.CheckableImageButton checkableImageButton, android.view.View.OnLongClickListener onLongClickListener) {
        boolean zE = androidx.core.h_renamed.v_renamed.E_renamed(checkableImageButton);
        boolean z_renamed = onLongClickListener != null;
        boolean z2 = zE || z_renamed;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zE);
        checkableImageButton.setPressable(zE);
        checkableImageButton.setLongClickable(z_renamed);
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) checkableImageButton, z2 ? 1 : 2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        android.widget.EditText editText = this.editText;
        if (editText != null) {
            android.graphics.Rect rect = this.tmpRect;
            com.google.android.material.internal.DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (!cutoutEnabled() || this.hintExpanded) {
                    return;
                }
                openCutout();
            }
        }
    }

    private void updateBoxUnderlineBounds(android.graphics.Rect rect) {
        if (this.boxUnderline != null) {
            this.boxUnderline.setBounds(rect.left, rect.bottom - this.boxStrokeWidthFocusedPx, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    private void drawHint(android.graphics.Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void drawBoxUnderline(android.graphics.Canvas canvas) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            android.graphics.Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void collapseHint(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z_renamed && this.hintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        showPlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !android.text.TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof com.google.android.material.textfield.CutoutDrawable);
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            android.graphics.RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void applyCutoutPadding(android.graphics.RectF rectF) {
        rectF.left -= this.boxLabelCutoutPaddingPx;
        rectF.top -= this.boxLabelCutoutPaddingPx;
        rectF.right += this.boxLabelCutoutPaddingPx;
        rectF.bottom += this.boxLabelCutoutPaddingPx;
    }

    boolean cutoutIsOpen() {
        return cutoutEnabled() && ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).hasCutout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        boolean state = collapsingTextHelper != null ? collapsingTextHelper.setState(drawableState) | false : false;
        if (this.editText != null) {
            updateLabelState(androidx.core.h_renamed.v_renamed.A_renamed(this) && isEnabled());
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (state) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    void updateTextInputBoxState() {
        android.widget.TextView textView;
        android.widget.EditText editText;
        android.widget.EditText editText2;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z_renamed = false;
        boolean z2 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.editText) != null && editText.isHovered());
        if (!isEnabled()) {
            this.boxStrokeColor = this.disabledColor;
        } else if (this.indicatorViewController.errorShouldBeShown()) {
            if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z2, z3);
            } else {
                this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
            }
        } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
            if (z2) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z3) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
        } else if (this.strokeErrorColor != null) {
            updateStrokeErrorColor(z2, z3);
        } else {
            this.boxStrokeColor = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.indicatorViewController.isErrorEnabled() && this.indicatorViewController.errorShouldBeShown()) {
            z_renamed = true;
        }
        setErrorIconVisible(z_renamed);
        updateIconColorOnState(this.errorIconView, this.errorIconTintList);
        updateIconColorOnState(this.startIconView, this.startIconTintList);
        updateIconColorOnState(this.endIconView, this.endIconTintList);
        if (getEndIconDelegate().shouldTintIconOnError()) {
            tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
        }
        if (z2 && isEnabled()) {
            this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        } else {
            this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                this.boxBackgroundColor = this.disabledFilledBackgroundColor;
            } else if (z3 && !z2) {
                this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
            } else if (z2) {
                this.boxBackgroundColor = this.focusedFilledBackgroundColor;
            } else {
                this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            }
        }
        applyBoxAttributes();
    }

    private void updateStrokeErrorColor(boolean z_renamed, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{android.R_renamed.attr.state_hovered, android.R_renamed.attr.state_enabled}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{android.R_renamed.attr.state_activated, android.R_renamed.attr.state_enabled}, defaultColor);
        if (z_renamed) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    private void setErrorIconVisible(boolean z_renamed) {
        this.errorIconView.setVisibility(z_renamed ? 0 : 8);
        this.endIconFrame.setVisibility(z_renamed ? 8 : 0);
        updateSuffixTextViewPadding();
        if (hasEndIcon()) {
            return;
        }
        updateDummyDrawables();
    }

    private boolean isErrorIconVisible() {
        return this.errorIconView.getVisibility() == 0;
    }

    private void updateIconColorOnState(com.google.android.material.internal.CheckableImageButton checkableImageButton, android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        android.graphics.drawable.Drawable drawableMutate = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
        androidx.core.graphics.drawable.a_renamed.a_renamed(drawableMutate, android.content.res.ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    private void expandHint(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z_renamed && this.hintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    void animateToExpansionFraction(float f_renamed) {
        if (this.collapsingTextHelper.getExpansionFraction() == f_renamed) {
            return;
        }
        if (this.animator == null) {
            this.animator = new android.animation.ValueAnimator();
            this.animator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.google.android.material.textfield.TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        this.animator.setFloatValues(this.collapsingTextHelper.getExpansionFraction(), f_renamed);
        this.animator.start();
    }

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public static class AccessibilityDelegate extends androidx.core.h_renamed.a_renamed {
        private final com.google.android.material.textfield.TextInputLayout layout;

        public AccessibilityDelegate(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            android.widget.EditText editText = this.layout.getEditText();
            java.lang.CharSequence text = editText != null ? editText.getText() : null;
            java.lang.CharSequence hint = this.layout.getHint();
            java.lang.CharSequence helperText = this.layout.getHelperText();
            java.lang.CharSequence error = this.layout.getError();
            int counterMaxLength = this.layout.getCounterMaxLength();
            java.lang.CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z_renamed = !android.text.TextUtils.isEmpty(text);
            boolean z2 = !android.text.TextUtils.isEmpty(hint);
            boolean z3 = !android.text.TextUtils.isEmpty(helperText);
            boolean z4 = !android.text.TextUtils.isEmpty(error);
            boolean z5 = z4 || !android.text.TextUtils.isEmpty(counterOverflowDescription);
            java.lang.String string = z2 ? hint.toString() : "";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(string);
            sb.append(((z4 || z3) && !android.text.TextUtils.isEmpty(string)) ? ", " : "");
            java.lang.String string2 = sb.toString();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(string2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = "";
            }
            sb2.append((java.lang.Object) helperText);
            java.lang.String string3 = sb2.toString();
            if (z_renamed) {
                dVar.c_renamed(text);
            } else if (!android.text.TextUtils.isEmpty(string3)) {
                dVar.c_renamed(string3);
            }
            if (!android.text.TextUtils.isEmpty(string3)) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    dVar.f_renamed(string3);
                } else {
                    if (z_renamed) {
                        string3 = ((java.lang.Object) text) + ", " + string3;
                    }
                    dVar.c_renamed(string3);
                }
                dVar.l_renamed(z_renamed ? false : true);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            dVar.b_renamed(counterMaxLength);
            if (z5) {
                if (z4) {
                    counterOverflowDescription = error;
                }
                dVar.g_renamed(counterOverflowDescription);
            }
        }
    }
}
