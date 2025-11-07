package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.p035g.Pair;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import com.google.android.material.C1694R;
import java.util.Calendar;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(C1694R.id_renamed.cancel_button);
            setNextFocusRightId(C1694R.id_renamed.confirm_button);
        }
        ViewCompat.m2854a(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.p036h.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
                super.onInitializeAccessibilityNodeInfo(view, c0483d);
                c0483d.m2683a((Object) null);
            }
        });
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (!super.onKeyDown(OplusGLSurfaceView_13, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != OplusGLSurfaceView_13) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof MonthAdapter)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to PlatformImplementations.kt_3 %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int iDayToPosition;
        int iHorizontalMidPoint;
        int iDayToPosition2;
        int iHorizontalMidPoint2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        Long item = adapter.getItem(adapter.firstPositionInMonth());
        Long item2 = adapter.getItem(adapter.lastPositionInMonth());
        for (Pair<Long, Long> c0457d : dateSelector.getSelectedRanges()) {
            if (c0457d.f2937a != null) {
                if (c0457d.f2938b == null) {
                    continue;
                } else {
                    long jLongValue = c0457d.f2937a.longValue();
                    long jLongValue2 = c0457d.f2938b.longValue();
                    if (skipMonth(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
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
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
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
    protected void onFocusChanged(boolean z, int OplusGLSurfaceView_13, Rect rect) {
        if (z) {
            gainFocus(OplusGLSurfaceView_13, rect);
        } else {
            super.onFocusChanged(false, OplusGLSurfaceView_13, rect);
        }
    }

    private void gainFocus(int OplusGLSurfaceView_13, Rect rect) {
        if (OplusGLSurfaceView_13 == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (OplusGLSurfaceView_13 == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, OplusGLSurfaceView_13, rect);
        }
    }

    private static boolean skipMonth(Long OplusGLSurfaceView_14, Long l2, Long l3, Long l4) {
        return OplusGLSurfaceView_14 == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < OplusGLSurfaceView_14.longValue();
    }

    private static int horizontalMidPoint(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
