package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public final class MaterialTextInputPicker<S_renamed> extends com.google.android.material.datepicker.PickerFragment<S_renamed> {
    private static final java.lang.String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final java.lang.String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    private com.google.android.material.datepicker.DateSelector<S_renamed> dateSelector;

    static <T_renamed> com.google.android.material.datepicker.MaterialTextInputPicker<T_renamed> newInstance(com.google.android.material.datepicker.DateSelector<T_renamed> dateSelector, com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
        com.google.android.material.datepicker.MaterialTextInputPicker<T_renamed> materialTextInputPicker = new com.google.android.material.datepicker.MaterialTextInputPicker<>();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(DATE_SELECTOR_KEY, dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.dateSelector = (com.google.android.material.datepicker.DateSelector) bundle.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (com.google.android.material.datepicker.CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        return this.dateSelector.onCreateTextInputView(layoutInflater, viewGroup, bundle, this.calendarConstraints, new com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed>() { // from class: com.google.android.material.datepicker.MaterialTextInputPicker.1
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void onSelectionChanged(S_renamed s_renamed) {
                java.util.Iterator<com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed>> it = com.google.android.material.datepicker.MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSelectionChanged(s_renamed);
                }
            }
        });
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public com.google.android.material.datepicker.DateSelector<S_renamed> getDateSelector() {
        com.google.android.material.datepicker.DateSelector<S_renamed> dateSelector = this.dateSelector;
        if (dateSelector != null) {
            return dateSelector;
        }
        throw new java.lang.IllegalStateException("dateSelector should not be_renamed null. Use MaterialTextInputPicker#newInstance() to create this fragment with a_renamed DateSelector, and call this method after the fragment has been created.");
    }
}
