package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public interface DateSelector<S_renamed> extends android.os.Parcelable {
    int getDefaultThemeResId(android.content.Context context);

    int getDefaultTitleResId();

    java.util.Collection<java.lang.Long> getSelectedDays();

    java.util.Collection<androidx.core.g_renamed.d_renamed<java.lang.Long, java.lang.Long>> getSelectedRanges();

    S_renamed getSelection();

    java.lang.String getSelectionDisplayString(android.content.Context context);

    boolean isSelectionComplete();

    android.view.View onCreateTextInputView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle, com.google.android.material.datepicker.CalendarConstraints calendarConstraints, com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed> onSelectionChangedListener);

    void select(long j_renamed);

    void setSelection(S_renamed s_renamed);
}
