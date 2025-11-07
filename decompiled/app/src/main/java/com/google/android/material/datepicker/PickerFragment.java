package com.google.android.material.datepicker;

/* loaded from: classes.dex */
abstract class PickerFragment<S_renamed> extends androidx.fragment.app.Fragment {
    protected final java.util.LinkedHashSet<com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed>> onSelectionChangedListeners = new java.util.LinkedHashSet<>();

    abstract com.google.android.material.datepicker.DateSelector<S_renamed> getDateSelector();

    PickerFragment() {
    }

    boolean addOnSelectionChangedListener(com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    boolean removeOnSelectionChangedListener(com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
    }

    void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }
}
