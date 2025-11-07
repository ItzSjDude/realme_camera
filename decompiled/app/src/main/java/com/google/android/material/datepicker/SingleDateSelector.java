package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public class SingleDateSelector implements com.google.android.material.datepicker.DateSelector<java.lang.Long> {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.SingleDateSelector> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.datepicker.SingleDateSelector>() { // from class: com.google.android.material.datepicker.SingleDateSelector.2
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.SingleDateSelector createFromParcel(android.os.Parcel parcel) {
            com.google.android.material.datepicker.SingleDateSelector singleDateSelector = new com.google.android.material.datepicker.SingleDateSelector();
            singleDateSelector.selectedItem = (java.lang.Long) parcel.readValue(java.lang.Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.SingleDateSelector[] newArray(int i_renamed) {
            return new com.google.android.material.datepicker.SingleDateSelector[i_renamed];
        }
    };
    private java.lang.Long selectedItem;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j_renamed) {
        this.selectedItem = java.lang.Long.valueOf(j_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(java.lang.Long l_renamed) {
        this.selectedItem = l_renamed == null ? null : java.lang.Long.valueOf(com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(l_renamed.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public java.util.Collection<androidx.core.g_renamed.d_renamed<java.lang.Long, java.lang.Long>> getSelectedRanges() {
        return new java.util.ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public java.util.Collection<java.lang.Long> getSelectedDays() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.Long l_renamed = this.selectedItem;
        if (l_renamed != null) {
            arrayList.add(l_renamed);
        }
        return arrayList;
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public java.lang.Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public android.view.View onCreateTextInputView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle, com.google.android.material.datepicker.CalendarConstraints calendarConstraints, final com.google.android.material.datepicker.OnSelectionChangedListener<java.lang.Long> onSelectionChangedListener) throws android.content.res.Resources.NotFoundException {
        android.view.View viewInflate = layoutInflater.inflate(com.google.android.material.R_renamed.layout.mtrl_picker_text_input_date, viewGroup, false);
        com.google.android.material.textfield.TextInputLayout textInputLayout = (com.google.android.material.textfield.TextInputLayout) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_picker_text_input_date);
        android.widget.EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.ManufacturerUtils.isLGEDevice() && com.google.android.material.internal.ManufacturerUtils.isSamsungDevice()) {
            editText.setInputType(17);
        }
        java.text.SimpleDateFormat textInputFormat = com.google.android.material.datepicker.UtcDates.getTextInputFormat();
        java.lang.String textInputHint = com.google.android.material.datepicker.UtcDates.getTextInputHint(viewInflate.getResources(), textInputFormat);
        java.lang.Long l_renamed = this.selectedItem;
        if (l_renamed != null) {
            editText.setText(textInputFormat.format(l_renamed));
        }
        editText.addTextChangedListener(new com.google.android.material.datepicker.DateFormatTextWatcher(textInputHint, textInputFormat, textInputLayout, calendarConstraints) { // from class: com.google.android.material.datepicker.SingleDateSelector.1
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void onValidDate(java.lang.Long l2) {
                if (l2 == null) {
                    com.google.android.material.datepicker.SingleDateSelector.this.clearSelection();
                } else {
                    com.google.android.material.datepicker.SingleDateSelector.this.select(l2.longValue());
                }
                onSelectionChangedListener.onSelectionChanged(com.google.android.material.datepicker.SingleDateSelector.this.getSelection());
            }
        });
        com.google.android.material.internal.ViewUtils.requestFocusAndShowKeyboard(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(android.content.Context context) {
        return com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R_renamed.attr.materialCalendarTheme, com.google.android.material.datepicker.MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public java.lang.String getSelectionDisplayString(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        java.lang.Long l_renamed = this.selectedItem;
        if (l_renamed == null) {
            return resources.getString(com.google.android.material.R_renamed.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(com.google.android.material.R_renamed.string.mtrl_picker_date_header_selected, com.google.android.material.datepicker.DateStrings.getYearMonthDay(l_renamed.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return com.google.android.material.R_renamed.string.mtrl_picker_date_header_title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeValue(this.selectedItem);
    }
}
