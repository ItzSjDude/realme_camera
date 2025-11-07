package com.google.android.material.datepicker;

/* loaded from: classes.dex */
class MonthAdapter extends android.widget.BaseAdapter {
    static final int MAXIMUM_WEEKS = com.google.android.material.datepicker.UtcDates.getUtcCalendar().getMaximum(4);
    final com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    com.google.android.material.datepicker.CalendarStyle calendarStyle;
    final com.google.android.material.datepicker.DateSelector<?> dateSelector;
    final com.google.android.material.datepicker.Month month;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    MonthAdapter(com.google.android.material.datepicker.Month month, com.google.android.material.datepicker.DateSelector<?> dateSelector, com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
    }

    @Override // android.widget.Adapter
    public java.lang.Long getItem(int i_renamed) {
        if (i_renamed < this.month.daysFromStartOfWeekToFirstOfMonth() || i_renamed > lastPositionInMonth()) {
            return null;
        }
        return java.lang.Long.valueOf(this.month.getDay(positionToDay(i_renamed)));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return i_renamed / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    public android.widget.TextView getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        initializeStyles(viewGroup.getContext());
        android.widget.TextView textView = (android.widget.TextView) view;
        if (view == null) {
            textView = (android.widget.TextView) android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R_renamed.layout.mtrl_calendar_day, viewGroup, false);
        }
        int iFirstPositionInMonth = i_renamed - firstPositionInMonth();
        if (iFirstPositionInMonth < 0 || iFirstPositionInMonth >= this.month.daysInMonth) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i2 = iFirstPositionInMonth + 1;
            textView.setTag(this.month);
            textView.setText(java.lang.String.valueOf(i2));
            long day = this.month.getDay(i2);
            if (this.month.year == com.google.android.material.datepicker.Month.today().year) {
                textView.setContentDescription(com.google.android.material.datepicker.DateStrings.getMonthDayOfWeekDay(day));
            } else {
                textView.setContentDescription(com.google.android.material.datepicker.DateStrings.getYearMonthDayOfWeekDay(day));
            }
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        java.lang.Long item = getItem(i_renamed);
        if (item == null) {
            return textView;
        }
        if (this.calendarConstraints.getDateValidator().isValid(item.longValue())) {
            textView.setEnabled(true);
            java.util.Iterator<java.lang.Long> it = this.dateSelector.getSelectedDays().iterator();
            while (it.hasNext()) {
                if (com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(item.longValue()) == com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                    this.calendarStyle.selectedDay.styleItem(textView);
                    return textView;
                }
            }
            if (com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis() == item.longValue()) {
                this.calendarStyle.todayDay.styleItem(textView);
                return textView;
            }
            this.calendarStyle.day.styleItem(textView);
            return textView;
        }
        textView.setEnabled(false);
        this.calendarStyle.invalidDay.styleItem(textView);
        return textView;
    }

    private void initializeStyles(android.content.Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new com.google.android.material.datepicker.CalendarStyle(context);
        }
    }

    int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    int positionToDay(int i_renamed) {
        return (i_renamed - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    int dayToPosition(int i_renamed) {
        return firstPositionInMonth() + (i_renamed - 1);
    }

    boolean withinMonth(int i_renamed) {
        return i_renamed >= firstPositionInMonth() && i_renamed <= lastPositionInMonth();
    }

    boolean isFirstInRow(int i_renamed) {
        return i_renamed % this.month.daysInWeek == 0;
    }

    boolean isLastInRow(int i_renamed) {
        return (i_renamed + 1) % this.month.daysInWeek == 0;
    }
}
