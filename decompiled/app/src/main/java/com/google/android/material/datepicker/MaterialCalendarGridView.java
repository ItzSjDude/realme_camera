package com.google.android.material.datepicker;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends android.widget.GridView {
    private final java.util.Calendar dayCompute;

    public MaterialCalendarGridView(android.content.Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.dayCompute = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        if (com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(com.google.android.material.R_renamed.id_renamed.cancel_button);
            setNextFocusRightId(com.google.android.material.R_renamed.id_renamed.confirm_button);
        }
        androidx.core.h_renamed.v_renamed.a_renamed(this, new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                dVar.a_renamed((java.lang.Object) null);
            }
        });
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i_renamed) {
        if (i_renamed < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i_renamed);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        if (!super.onKeyDown(i_renamed, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i_renamed) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public com.google.android.material.datepicker.MonthAdapter getAdapter() {
        return (com.google.android.material.datepicker.MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(android.widget.ListAdapter listAdapter) {
        if (!(listAdapter instanceof com.google.android.material.datepicker.MonthAdapter)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("%1$s_renamed must have its Adapter set to a_renamed %2$s_renamed", com.google.android.material.datepicker.MaterialCalendarGridView.class.getCanonicalName(), com.google.android.material.datepicker.MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.view.View
    protected final void onDraw(android.graphics.Canvas canvas) {
        int iDayToPosition;
        int iHorizontalMidPoint;
        int iDayToPosition2;
        int iHorizontalMidPoint2;
        com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        com.google.android.material.datepicker.MonthAdapter adapter = getAdapter();
        com.google.android.material.datepicker.DateSelector<?> dateSelector = adapter.dateSelector;
        com.google.android.material.datepicker.CalendarStyle calendarStyle = adapter.calendarStyle;
        java.lang.Long item = adapter.getItem(adapter.firstPositionInMonth());
        java.lang.Long item2 = adapter.getItem(adapter.lastPositionInMonth());
        for (androidx.core.g_renamed.d_renamed<java.lang.Long, java.lang.Long> dVar : dateSelector.getSelectedRanges()) {
            if (dVar.f918a != null) {
                if (dVar.f919b == null) {
                    continue;
                } else {
                    long jLongValue = dVar.f918a.longValue();
                    long jLongValue2 = dVar.f919b.longValue();
                    if (skipMonth(item, item2, java.lang.Long.valueOf(jLongValue), java.lang.Long.valueOf(jLongValue2))) {
                        return;
                    }
                    if (jLongValue < item.longValue()) {
                        iDayToPosition = adapter.firstPositionInMonth();
                        iHorizontalMidPoint = adapter.isFirstInRow(iDayToPosition) ? 0 : materialCalendarGridView.getChildAt(iDayToPosition - 1).getRight();
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(jLongValue);
                        iDayToPosition = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        iHorizontalMidPoint = horizontalMidPoint(materialCalendarGridView.getChildAt(iDayToPosition));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iDayToPosition2 = adapter.lastPositionInMonth();
                        if (adapter.isLastInRow(iDayToPosition2)) {
                            iHorizontalMidPoint2 = getWidth();
                        } else {
                            iHorizontalMidPoint2 = materialCalendarGridView.getChildAt(iDayToPosition2).getRight();
                        }
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(jLongValue2);
                        iDayToPosition2 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        iHorizontalMidPoint2 = horizontalMidPoint(materialCalendarGridView.getChildAt(iDayToPosition2));
                    }
                    int itemId = (int) adapter.getItemId(iDayToPosition);
                    int itemId2 = (int) adapter.getItemId(iDayToPosition2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        android.view.View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > iDayToPosition ? 0 : iHorizontalMidPoint, childAt.getTop() + calendarStyle.day.getTopInset(), iDayToPosition2 > numColumns2 ? getWidth() : iHorizontalMidPoint2, childAt.getBottom() - calendarStyle.day.getBottomInset(), calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z_renamed, int i_renamed, android.graphics.Rect rect) {
        if (z_renamed) {
            gainFocus(i_renamed, rect);
        } else {
            super.onFocusChanged(false, i_renamed, rect);
        }
    }

    private void gainFocus(int i_renamed, android.graphics.Rect rect) {
        if (i_renamed == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i_renamed == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i_renamed, rect);
        }
    }

    private static boolean skipMonth(java.lang.Long l_renamed, java.lang.Long l2, java.lang.Long l3, java.lang.Long l4) {
        return l_renamed == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l_renamed.longValue();
    }

    private static int horizontalMidPoint(android.view.View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
