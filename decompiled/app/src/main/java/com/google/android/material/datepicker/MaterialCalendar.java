package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public final class MaterialCalendar<S_renamed> extends com.google.android.material.datepicker.PickerFragment<S_renamed> {
    private static final java.lang.String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final java.lang.String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final java.lang.String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final java.lang.String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    private com.google.android.material.datepicker.MaterialCalendar.CalendarSelector calendarSelector;
    private com.google.android.material.datepicker.CalendarStyle calendarStyle;
    private com.google.android.material.datepicker.Month current;
    private com.google.android.material.datepicker.DateSelector<S_renamed> dateSelector;
    private android.view.View dayFrame;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private int themeResId;
    private android.view.View yearFrame;
    private androidx.recyclerview.widget.RecyclerView yearSelector;
    static final java.lang.Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
    static final java.lang.Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
    static final java.lang.Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
    static final java.lang.Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";

    enum CalendarSelector {
        DAY,
        YEAR
    }

    interface OnDayClickListener {
        void onDayClick(long j_renamed);
    }

    static <T_renamed> com.google.android.material.datepicker.MaterialCalendar<T_renamed> newInstance(com.google.android.material.datepicker.DateSelector<T_renamed> dateSelector, int i_renamed, com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
        com.google.android.material.datepicker.MaterialCalendar<T_renamed> materialCalendar = new com.google.android.material.datepicker.MaterialCalendar<>();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(THEME_RES_ID_KEY, i_renamed);
        bundle.putParcelable(GRID_SELECTOR_KEY, dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints);
        bundle.putParcelable(CURRENT_MONTH_KEY, calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(THEME_RES_ID_KEY, this.themeResId);
        bundle.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        bundle.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (com.google.android.material.datepicker.DateSelector) bundle.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (com.google.android.material.datepicker.CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.current = (com.google.android.material.datepicker.Month) bundle.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        final int i2;
        android.view.ContextThemeWrapper contextThemeWrapper = new android.view.ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new com.google.android.material.datepicker.CalendarStyle(contextThemeWrapper);
        android.view.LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.Month start = this.calendarConstraints.getStart();
        if (com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i_renamed = com.google.android.material.R_renamed.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i_renamed = com.google.android.material.R_renamed.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        android.view.View viewInflate = layoutInflaterCloneInContext.inflate(i_renamed, viewGroup, false);
        android.widget.GridView gridView = (android.widget.GridView) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_days_of_week);
        androidx.core.h_renamed.v_renamed.a_renamed(gridView, new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.datepicker.MaterialCalendar.1
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                dVar.a_renamed((java.lang.Object) null);
            }
        });
        gridView.setAdapter((android.widget.ListAdapter) new com.google.android.material.datepicker.DaysOfWeekAdapter());
        gridView.setNumColumns(start.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (androidx.recyclerview.widget.RecyclerView) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new com.google.android.material.datepicker.SmoothCalendarLayoutManager(getContext(), i2, false) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected void calculateExtraLayoutSpace(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int[] iArr) {
                if (i2 == 0) {
                    iArr[0] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getWidth();
                    iArr[1] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getWidth();
                } else {
                    iArr[0] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getHeight();
                    iArr[1] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getHeight();
                }
            }
        });
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter = new com.google.android.material.datepicker.MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
            public void onDayClick(long j_renamed) {
                if (com.google.android.material.datepicker.MaterialCalendar.this.calendarConstraints.getDateValidator().isValid(j_renamed)) {
                    com.google.android.material.datepicker.MaterialCalendar.this.dateSelector.select(j_renamed);
                    java.util.Iterator<com.google.android.material.datepicker.OnSelectionChangedListener<S_renamed>> it = com.google.android.material.datepicker.MaterialCalendar.this.onSelectionChangedListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onSelectionChanged(com.google.android.material.datepicker.MaterialCalendar.this.dateSelector.getSelection());
                    }
                    com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getAdapter().notifyDataSetChanged();
                    if (com.google.android.material.datepicker.MaterialCalendar.this.yearSelector != null) {
                        com.google.android.material.datepicker.MaterialCalendar.this.yearSelector.getAdapter().notifyDataSetChanged();
                    }
                }
            }
        });
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(com.google.android.material.R_renamed.integer.mtrl_calendar_year_selector_span);
        this.yearSelector = (androidx.recyclerview.widget.RecyclerView) viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_year_selector_frame);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.yearSelector;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager((android.content.Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new com.google.android.material.datepicker.YearGridAdapter(this));
            this.yearSelector.addItemDecoration(createItemDecoration());
        }
        if (viewInflate.findViewById(com.google.android.material.R_renamed.id_renamed.month_navigation_fragment_toggle) != null) {
            addActionsToMonthNavigation(viewInflate, monthsPagerAdapter);
        }
        if (!com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            new androidx.recyclerview.widget.k_renamed().a_renamed(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.getPosition(this.current));
        return viewInflate;
    }

    private androidx.recyclerview.widget.RecyclerView.h_renamed createItemDecoration() {
        return new androidx.recyclerview.widget.RecyclerView.h_renamed() { // from class: com.google.android.material.datepicker.MaterialCalendar.4
            private final java.util.Calendar startItem = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
            private final java.util.Calendar endItem = com.google.android.material.datepicker.UtcDates.getUtcCalendar();

            @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
            public void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
                int width;
                if ((recyclerView.getAdapter() instanceof com.google.android.material.datepicker.YearGridAdapter) && (recyclerView.getLayoutManager() instanceof androidx.recyclerview.widget.GridLayoutManager)) {
                    com.google.android.material.datepicker.YearGridAdapter yearGridAdapter = (com.google.android.material.datepicker.YearGridAdapter) recyclerView.getAdapter();
                    androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = (androidx.recyclerview.widget.GridLayoutManager) recyclerView.getLayoutManager();
                    for (androidx.core.g_renamed.d_renamed<java.lang.Long, java.lang.Long> dVar : com.google.android.material.datepicker.MaterialCalendar.this.dateSelector.getSelectedRanges()) {
                        if (dVar.f918a != null && dVar.f919b != null) {
                            this.startItem.setTimeInMillis(dVar.f918a.longValue());
                            this.endItem.setTimeInMillis(dVar.f919b.longValue());
                            int positionForYear = yearGridAdapter.getPositionForYear(this.startItem.get(1));
                            int positionForYear2 = yearGridAdapter.getPositionForYear(this.endItem.get(1));
                            android.view.View viewFindViewByPosition = gridLayoutManager.findViewByPosition(positionForYear);
                            android.view.View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(positionForYear2);
                            int iA = positionForYear / gridLayoutManager.a_renamed();
                            int iA2 = positionForYear2 / gridLayoutManager.a_renamed();
                            int i_renamed = iA;
                            while (i_renamed <= iA2) {
                                android.view.View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.a_renamed() * i_renamed);
                                if (viewFindViewByPosition3 != null) {
                                    int top = viewFindViewByPosition3.getTop() + com.google.android.material.datepicker.MaterialCalendar.this.calendarStyle.year.getTopInset();
                                    int bottom = viewFindViewByPosition3.getBottom() - com.google.android.material.datepicker.MaterialCalendar.this.calendarStyle.year.getBottomInset();
                                    int left = i_renamed == iA ? viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2) : 0;
                                    if (i_renamed == iA2) {
                                        width = viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2);
                                    } else {
                                        width = recyclerView.getWidth();
                                    }
                                    canvas.drawRect(left, top, width, bottom, com.google.android.material.datepicker.MaterialCalendar.this.calendarStyle.rangeFill);
                                }
                                i_renamed++;
                            }
                        }
                    }
                }
            }
        };
    }

    com.google.android.material.datepicker.Month getCurrentMonth() {
        return this.current;
    }

    com.google.android.material.datepicker.CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    void setCurrentMonth(com.google.android.material.datepicker.Month month) {
        com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter = (com.google.android.material.datepicker.MonthsPagerAdapter) this.recyclerView.getAdapter();
        int position = monthsPagerAdapter.getPosition(month);
        int position2 = position - monthsPagerAdapter.getPosition(this.current);
        boolean z_renamed = java.lang.Math.abs(position2) > 3;
        boolean z2 = position2 > 0;
        this.current = month;
        if (z_renamed && z2) {
            this.recyclerView.scrollToPosition(position - 3);
            postSmoothRecyclerViewScroll(position);
        } else if (z_renamed) {
            this.recyclerView.scrollToPosition(position + 3);
            postSmoothRecyclerViewScroll(position);
        } else {
            postSmoothRecyclerViewScroll(position);
        }
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public com.google.android.material.datepicker.DateSelector<S_renamed> getDateSelector() {
        return this.dateSelector;
    }

    com.google.android.material.datepicker.CalendarStyle getCalendarStyle() {
        return this.calendarStyle;
    }

    static int getDayHeight(android.content.Context context) {
        return context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_calendar_day_height);
    }

    void setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector calendarSelector) {
        this.calendarSelector = calendarSelector;
        if (calendarSelector == com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((com.google.android.material.datepicker.YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
        } else if (calendarSelector == com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    void toggleVisibleSelector() {
        if (this.calendarSelector == com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.YEAR) {
            setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY);
        } else if (this.calendarSelector == com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY) {
            setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.YEAR);
        }
    }

    private void addActionsToMonthNavigation(android.view.View view, final com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter) {
        final com.google.android.material.button.MaterialButton materialButton = (com.google.android.material.button.MaterialButton) view.findViewById(com.google.android.material.R_renamed.id_renamed.month_navigation_fragment_toggle);
        materialButton.setTag(SELECTOR_TOGGLE_TAG);
        androidx.core.h_renamed.v_renamed.a_renamed(materialButton, new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.datepicker.MaterialCalendar.5
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view2, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                java.lang.String string;
                super.onInitializeAccessibilityNodeInfo(view2, dVar);
                if (com.google.android.material.datepicker.MaterialCalendar.this.dayFrame.getVisibility() == 0) {
                    string = com.google.android.material.datepicker.MaterialCalendar.this.getString(com.google.android.material.R_renamed.string.mtrl_picker_toggle_to_year_selection);
                } else {
                    string = com.google.android.material.datepicker.MaterialCalendar.this.getString(com.google.android.material.R_renamed.string.mtrl_picker_toggle_to_day_selection);
                }
                dVar.f_renamed(string);
            }
        });
        com.google.android.material.button.MaterialButton materialButton2 = (com.google.android.material.button.MaterialButton) view.findViewById(com.google.android.material.R_renamed.id_renamed.month_navigation_previous);
        materialButton2.setTag(NAVIGATION_PREV_TAG);
        com.google.android.material.button.MaterialButton materialButton3 = (com.google.android.material.button.MaterialButton) view.findViewById(com.google.android.material.R_renamed.id_renamed.month_navigation_next);
        materialButton3.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = view.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_year_selector_frame);
        this.dayFrame = view.findViewById(com.google.android.material.R_renamed.id_renamed.mtrl_calendar_day_selector_frame);
        setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY);
        materialButton.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.n_renamed() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
            @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
            public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
                int iFindLastVisibleItemPosition;
                if (i_renamed < 0) {
                    iFindLastVisibleItemPosition = com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition();
                } else {
                    iFindLastVisibleItemPosition = com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
                }
                com.google.android.material.datepicker.MaterialCalendar.this.current = monthsPagerAdapter.getPageMonth(iFindLastVisibleItemPosition);
                materialButton.setText(monthsPagerAdapter.getPageTitle(iFindLastVisibleItemPosition));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
                if (i_renamed == 0) {
                    java.lang.CharSequence text = materialButton.getText();
                    if (android.os.Build.VERSION.SDK_INT >= 16) {
                        recyclerView.announceForAccessibility(text);
                    } else {
                        recyclerView.sendAccessibilityEvent(2048);
                    }
                }
            }
        });
        materialButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                com.google.android.material.datepicker.MaterialCalendar.this.toggleVisibleSelector();
            }
        });
        materialButton3.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                int iFindFirstVisibleItemPosition = com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
                if (iFindFirstVisibleItemPosition < com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
                    com.google.android.material.datepicker.MaterialCalendar.this.setCurrentMonth(monthsPagerAdapter.getPageMonth(iFindFirstVisibleItemPosition));
                }
            }
        });
        materialButton2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                int iFindLastVisibleItemPosition = com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
                if (iFindLastVisibleItemPosition >= 0) {
                    com.google.android.material.datepicker.MaterialCalendar.this.setCurrentMonth(monthsPagerAdapter.getPageMonth(iFindLastVisibleItemPosition));
                }
            }
        });
    }

    private void postSmoothRecyclerViewScroll(final int i_renamed) {
        this.recyclerView.post(new java.lang.Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
            @Override // java.lang.Runnable
            public void run() {
                com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.smoothScrollToPosition(i_renamed);
            }
        });
    }

    androidx.recyclerview.widget.LinearLayoutManager getLayoutManager() {
        return (androidx.recyclerview.widget.LinearLayoutManager) this.recyclerView.getLayoutManager();
    }
}
