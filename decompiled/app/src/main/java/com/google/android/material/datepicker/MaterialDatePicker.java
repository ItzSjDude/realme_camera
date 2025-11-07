package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public final class MaterialDatePicker<S_renamed> extends androidx.fragment.app.b_renamed {
    private static final java.lang.String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final java.lang.String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final java.lang.String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final java.lang.String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final java.lang.String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final java.lang.String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    private com.google.android.material.shape.MaterialShapeDrawable background;
    private com.google.android.material.datepicker.MaterialCalendar<S_renamed> calendar;
    private com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    private android.widget.Button confirmButton;
    private com.google.android.material.datepicker.DateSelector<S_renamed> dateSelector;
    private boolean fullscreen;
    private android.widget.TextView headerSelectionText;
    private com.google.android.material.internal.CheckableImageButton headerToggleButton;
    private int inputMode;
    private int overrideThemeResId;
    private com.google.android.material.datepicker.PickerFragment<S_renamed> pickerFragment;
    private java.lang.CharSequence titleText;
    private int titleTextResId;
    static final java.lang.Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
    static final java.lang.Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
    static final java.lang.Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    private final java.util.LinkedHashSet<com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener<? super S_renamed>> onPositiveButtonClickListeners = new java.util.LinkedHashSet<>();
    private final java.util.LinkedHashSet<android.view.View.OnClickListener> onNegativeButtonClickListeners = new java.util.LinkedHashSet<>();
    private final java.util.LinkedHashSet<android.content.DialogInterface.OnCancelListener> onCancelListeners = new java.util.LinkedHashSet<>();
    private final java.util.LinkedHashSet<android.content.DialogInterface.OnDismissListener> onDismissListeners = new java.util.LinkedHashSet<>();

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    public static long todayInUtcMilliseconds() {
        return com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis();
    }

    public static long thisMonthInUtcMilliseconds() {
        return com.google.android.material.datepicker.Month.today().timeInMillis;
    }

    public java.lang.String getHeaderText() {
        return this.dateSelector.getSelectionDisplayString(getContext());
    }

    static <S_renamed> com.google.android.material.datepicker.MaterialDatePicker<S_renamed> newInstance(com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> builder) {
        com.google.android.material.datepicker.MaterialDatePicker<S_renamed> materialDatePicker = new com.google.android.material.datepicker.MaterialDatePicker<>();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, builder.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.calendarConstraints);
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, builder.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, builder.titleText);
        bundle.putInt(INPUT_MODE_KEY, builder.inputMode);
        materialDatePicker.setArguments(bundle);
        return materialDatePicker;
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        com.google.android.material.datepicker.CalendarConstraints.Builder builder = new com.google.android.material.datepicker.CalendarConstraints.Builder(this.calendarConstraints);
        if (this.calendar.getCurrentMonth() != null) {
            builder.setOpenAt(this.calendar.getCurrentMonth().timeInMillis);
        }
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.build());
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, this.titleText);
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public final void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (com.google.android.material.datepicker.DateSelector) bundle.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (com.google.android.material.datepicker.CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.titleTextResId = bundle.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = bundle.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = bundle.getInt(INPUT_MODE_KEY);
    }

    private int getThemeResId(android.content.Context context) {
        int i_renamed = this.overrideThemeResId;
        return i_renamed != 0 ? i_renamed : this.dateSelector.getDefaultThemeResId(context);
    }

    @Override // androidx.fragment.app.b_renamed
    public final android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.Dialog dialog = new android.app.Dialog(requireContext(), getThemeResId(requireContext()));
        android.content.Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        int iResolveOrThrow = com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R_renamed.attr.colorSurface, com.google.android.material.datepicker.MaterialDatePicker.class.getCanonicalName());
        this.background = new com.google.android.material.shape.MaterialShapeDrawable(context, null, com.google.android.material.R_renamed.attr.materialCalendarStyle, com.google.android.material.R_renamed.style.Widget_MaterialComponents_MaterialCalendar);
        this.background.initializeElevationOverlay(context);
        this.background.setFillColor(android.content.res.ColorStateList.valueOf(iResolveOrThrow));
        this.background.setElevation(androidx.core.h_renamed.v_renamed.o_renamed(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View viewInflate = layoutInflater.inflate(this.fullscreen ? com.google.android.material.R_renamed.layout.mtrl_picker_fullscreen : com.google.android.material.R_renamed.layout.mtrl_picker_dialog, viewGroup);
        android.content.Context context = viewInflate.getContext();
        if (this.fullscreen) {
            viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_frame).setLayoutParams(new android.widget.LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            android.view.View viewFindViewById = viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_main_pane);
            android.view.View viewFindViewById2 = viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_frame);
            viewFindViewById.setLayoutParams(new android.widget.LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
            viewFindViewById2.setMinimumHeight(getDialogPickerHeight(requireContext()));
        }
        this.headerSelectionText = (android.widget.TextView) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_picker_header_selection_text);
        androidx.core.h_renamed.v_renamed.d_renamed(this.headerSelectionText, 1);
        this.headerToggleButton = (com.google.android.material.internal.CheckableImageButton) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_picker_header_toggle);
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_picker_title_text);
        java.lang.CharSequence charSequence = this.titleText;
        if (charSequence != null) {
            textView.setText(charSequence);
        } else {
            textView.setText(this.titleTextResId);
        }
        initHeaderToggle(context);
        this.confirmButton = (android.widget.Button) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.confirm_button);
        if (this.dateSelector.isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        this.confirmButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                java.util.Iterator it = com.google.android.material.datepicker.MaterialDatePicker.this.onPositiveButtonClickListeners.iterator();
                while (it.hasNext()) {
                    ((com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener) it.next()).onPositiveButtonClick(com.google.android.material.datepicker.MaterialDatePicker.this.getSelection());
                }
                com.google.android.material.datepicker.MaterialDatePicker.this.dismiss();
            }
        });
        android.widget.Button button = (android.widget.Button) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.cancel_button);
        button.setTag(CANCEL_BUTTON_TAG);
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                java.util.Iterator it = com.google.android.material.datepicker.MaterialDatePicker.this.onNegativeButtonClickListeners.iterator();
                while (it.hasNext()) {
                    ((android.view.View.OnClickListener) it.next()).onClick(view);
                }
                com.google.android.material.datepicker.MaterialDatePicker.this.dismiss();
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onStart() throws android.content.res.Resources.NotFoundException {
        super.onStart();
        android.view.Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_calendar_dialog_background_inset);
            android.graphics.Rect rect = new android.graphics.Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new android.graphics.drawable.InsetDrawable((android.graphics.drawable.Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new com.google.android.material.dialog.InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    @Override // androidx.fragment.app.b_renamed, android.content.DialogInterface.OnCancelListener
    public final void onCancel(android.content.DialogInterface dialogInterface) {
        java.util.Iterator<android.content.DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.b_renamed, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        java.util.Iterator<android.content.DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final S_renamed getSelection() {
        return this.dateSelector.getSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeader() {
        java.lang.String headerText = getHeaderText();
        this.headerSelectionText.setContentDescription(java.lang.String.format(getString(com.google.android.material.R_renamed.string.mtrl_picker_announce_current_selection), headerText));
        this.headerSelectionText.setText(headerText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPickerFragment() {
        this.calendar = com.google.android.material.datepicker.MaterialCalendar.newInstance(this.dateSelector, getThemeResId(requireContext()), this.calendarConstraints);
        this.pickerFragment = this.headerToggleButton.isChecked() ? com.google.android.material.datepicker.MaterialTextInputPicker.newInstance(this.dateSelector, this.calendarConstraints) : this.calendar;
        updateHeader();
        androidx.fragment.app.k_renamed kVarA = getChildFragmentManager().a_renamed();
        kVarA.a_renamed(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_frame, this.pickerFragment);
        kVarA.d_renamed();
        this.pickerFragment.addOnSelectionChangedListener(new com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void onSelectionChanged(S_renamed s_renamed) {
                com.google.android.material.datepicker.MaterialDatePicker.this.updateHeader();
                if (com.google.android.material.datepicker.MaterialDatePicker.this.dateSelector.isSelectionComplete()) {
                    com.google.android.material.datepicker.MaterialDatePicker.this.confirmButton.setEnabled(true);
                } else {
                    com.google.android.material.datepicker.MaterialDatePicker.this.confirmButton.setEnabled(false);
                }
            }
        });
    }

    private void initHeaderToggle(android.content.Context context) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(context));
        this.headerToggleButton.setChecked(this.inputMode != 0);
        androidx.core.h_renamed.v_renamed.a_renamed(this.headerToggleButton, (androidx.core.h_renamed.a_renamed) null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.google.android.material.datepicker.MaterialDatePicker.this.headerToggleButton.toggle();
                com.google.android.material.datepicker.MaterialDatePicker materialDatePicker = com.google.android.material.datepicker.MaterialDatePicker.this;
                materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
                com.google.android.material.datepicker.MaterialDatePicker.this.startPickerFragment();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToggleContentDescription(com.google.android.material.internal.CheckableImageButton checkableImageButton) {
        java.lang.String string;
        if (this.headerToggleButton.isChecked()) {
            string = checkableImageButton.getContext().getString(com.google.android.material.R_renamed.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(com.google.android.material.R_renamed.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.headerToggleButton.setContentDescription(string);
    }

    private static android.graphics.drawable.Drawable createHeaderToggleDrawable(android.content.Context context) {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R_renamed.attr.state_checked}, androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, com.google.android.material.R_renamed.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, com.google.android.material.R_renamed.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    static boolean isFullscreen(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R_renamed.attr.materialCalendarStyle, com.google.android.material.datepicker.MaterialCalendar.class.getCanonicalName()), new int[]{android.R_renamed.attr.windowFullscreen});
        boolean z_renamed = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z_renamed;
    }

    private static int getDialogPickerHeight(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_calendar_days_of_week_height) + (com.google.android.material.datepicker.MonthAdapter.MAXIMUM_WEEKS * resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_calendar_day_height)) + ((com.google.android.material.datepicker.MonthAdapter.MAXIMUM_WEEKS - 1) * resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_calendar_bottom_padding);
    }

    private static int getPaddedPickerWidth(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_calendar_content_padding);
        int i_renamed = com.google.android.material.datepicker.Month.today().daysInWeek;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_calendar_day_width) * i_renamed) + ((i_renamed - 1) * resources.getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_calendar_month_horizontal_padding));
    }

    public boolean addOnPositiveButtonClickListener(com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener<? super S_renamed> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.add(materialPickerOnPositiveButtonClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener<? super S_renamed> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.remove(materialPickerOnPositiveButtonClickListener);
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public boolean addOnNegativeButtonClickListener(android.view.View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.add(onClickListener);
    }

    public boolean removeOnNegativeButtonClickListener(android.view.View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.remove(onClickListener);
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public boolean addOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.add(onCancelListener);
    }

    public boolean removeOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.remove(onCancelListener);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public boolean addOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.add(onDismissListener);
    }

    public boolean removeOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.remove(onDismissListener);
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public static final class Builder<S_renamed> {
        com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
        final com.google.android.material.datepicker.DateSelector<S_renamed> dateSelector;
        int overrideThemeResId = 0;
        int titleTextResId = 0;
        java.lang.CharSequence titleText = null;
        S_renamed selection = null;
        int inputMode = 0;

        private Builder(com.google.android.material.datepicker.DateSelector<S_renamed> dateSelector) {
            this.dateSelector = dateSelector;
        }

        public static <S_renamed> com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> customDatePicker(com.google.android.material.datepicker.DateSelector<S_renamed> dateSelector) {
            return new com.google.android.material.datepicker.MaterialDatePicker.Builder<>(dateSelector);
        }

        public static com.google.android.material.datepicker.MaterialDatePicker.Builder<java.lang.Long> datePicker() {
            return new com.google.android.material.datepicker.MaterialDatePicker.Builder<>(new com.google.android.material.datepicker.SingleDateSelector());
        }

        public static com.google.android.material.datepicker.MaterialDatePicker.Builder<androidx.core.g_renamed.d_renamed<java.lang.Long, java.lang.Long>> dateRangePicker() {
            return new com.google.android.material.datepicker.MaterialDatePicker.Builder<>(new com.google.android.material.datepicker.RangeDateSelector());
        }

        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> setSelection(S_renamed s_renamed) {
            this.selection = s_renamed;
            return this;
        }

        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> setTheme(int i_renamed) {
            this.overrideThemeResId = i_renamed;
            return this;
        }

        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> setCalendarConstraints(com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
            this.calendarConstraints = calendarConstraints;
            return this;
        }

        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> setTitleText(int i_renamed) {
            this.titleTextResId = i_renamed;
            this.titleText = null;
            return this;
        }

        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> setTitleText(java.lang.CharSequence charSequence) {
            this.titleText = charSequence;
            this.titleTextResId = 0;
            return this;
        }

        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S_renamed> setInputMode(int i_renamed) {
            this.inputMode = i_renamed;
            return this;
        }

        public com.google.android.material.datepicker.MaterialDatePicker<S_renamed> build() {
            if (this.calendarConstraints == null) {
                this.calendarConstraints = new com.google.android.material.datepicker.CalendarConstraints.Builder().build();
            }
            if (this.titleTextResId == 0) {
                this.titleTextResId = this.dateSelector.getDefaultTitleResId();
            }
            S_renamed s_renamed = this.selection;
            if (s_renamed != null) {
                this.dateSelector.setSelection(s_renamed);
            }
            return com.google.android.material.datepicker.MaterialDatePicker.newInstance(this);
        }
    }
}
