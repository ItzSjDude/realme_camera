package com.google.android.material.datepicker;

/* loaded from: classes.dex */
class DaysOfWeekAdapter extends android.widget.BaseAdapter {
    private static final int CALENDAR_DAY_STYLE;
    private static final int NARROW_FORMAT = 4;
    private final java.util.Calendar calendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
    private final int daysInWeek = this.calendar.getMaximum(7);
    private final int firstDayOfWeek = this.calendar.getFirstDayOfWeek();

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return 0L;
    }

    static {
        CALENDAR_DAY_STYLE = android.os.Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    @Override // android.widget.Adapter
    public java.lang.Integer getItem(int i_renamed) {
        if (i_renamed >= this.daysInWeek) {
            return null;
        }
        return java.lang.Integer.valueOf(positionToDayOfWeek(i_renamed));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.daysInWeek;
    }

    @Override // android.widget.Adapter
    @android.annotation.SuppressLint({"WrongConstant"})
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        android.widget.TextView textView = (android.widget.TextView) view;
        if (view == null) {
            textView = (android.widget.TextView) android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R_renamed.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.calendar.set(7, positionToDayOfWeek(i_renamed));
        textView.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, java.util.Locale.getDefault()));
        textView.setContentDescription(java.lang.String.format(viewGroup.getContext().getString(com.google.android.material.R_renamed.string.mtrl_picker_day_of_week_column_header), this.calendar.getDisplayName(7, 2, java.util.Locale.getDefault())));
        return textView;
    }

    private int positionToDayOfWeek(int i_renamed) {
        int i2 = i_renamed + this.firstDayOfWeek;
        int i3 = this.daysInWeek;
        return i2 > i3 ? i2 - i3 : i2;
    }
}
