package com.google.android.material.datepicker;

/* loaded from: classes.dex */
abstract class DateFormatTextWatcher implements android.text.TextWatcher {
    private final com.google.android.material.datepicker.CalendarConstraints constraints;
    private final java.text.DateFormat dateFormat;
    private final java.lang.String formatHint;
    private final java.lang.String outOfRange;
    private final com.google.android.material.textfield.TextInputLayout textInputLayout;

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
    }

    void onInvalidDate() {
    }

    abstract void onValidDate(java.lang.Long l_renamed);

    DateFormatTextWatcher(java.lang.String str, java.text.DateFormat dateFormat, com.google.android.material.textfield.TextInputLayout textInputLayout, com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
        this.formatHint = str;
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(com.google.android.material.R_renamed.string.mtrl_picker_out_of_range);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) throws java.text.ParseException {
        if (android.text.TextUtils.isEmpty(charSequence)) {
            this.textInputLayout.setError(null);
            onValidDate(null);
            return;
        }
        try {
            java.util.Date date = this.dateFormat.parse(charSequence.toString());
            this.textInputLayout.setError(null);
            long time = date.getTime();
            if (this.constraints.getDateValidator().isValid(time) && this.constraints.isWithinBounds(time)) {
                onValidDate(java.lang.Long.valueOf(date.getTime()));
            } else {
                this.textInputLayout.setError(java.lang.String.format(this.outOfRange, com.google.android.material.datepicker.DateStrings.getDateString(time)));
                onInvalidDate();
            }
        } catch (java.text.ParseException unused) {
            java.lang.String string = this.textInputLayout.getContext().getString(com.google.android.material.R_renamed.string.mtrl_picker_invalid_format);
            java.lang.String str = java.lang.String.format(this.textInputLayout.getContext().getString(com.google.android.material.R_renamed.string.mtrl_picker_invalid_format_use), this.formatHint);
            java.lang.String str2 = java.lang.String.format(this.textInputLayout.getContext().getString(com.google.android.material.R_renamed.string.mtrl_picker_invalid_format_example), this.dateFormat.format(new java.util.Date(com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis())));
            this.textInputLayout.setError(string + "\n_renamed" + str + "\n_renamed" + str2);
            onInvalidDate();
        }
    }
}
