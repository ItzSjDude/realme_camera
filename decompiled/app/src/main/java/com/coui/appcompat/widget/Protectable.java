package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIDatePicker extends android.widget.FrameLayout {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.String f2706c = "COUIDatePicker";
    private static char[] d_renamed = {'d_renamed', 'M_renamed', 'y_renamed'};

    /* renamed from: a_renamed, reason: collision with root package name */
    int f2707a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f2708b;
    private final android.widget.LinearLayout e_renamed;
    private final com.coui.appcompat.widget.COUINumberPicker f_renamed;
    private final com.coui.appcompat.widget.COUINumberPicker g_renamed;
    private final com.coui.appcompat.widget.COUINumberPicker h_renamed;
    private android.content.Context i_renamed;
    private java.util.Locale j_renamed;
    private com.coui.appcompat.widget.COUIDatePicker.c_renamed k_renamed;
    private java.lang.String[] l_renamed;
    private int m_renamed;
    private com.coui.appcompat.widget.COUIDatePicker.b_renamed n_renamed;
    private java.util.Calendar o_renamed;
    private java.util.Calendar p_renamed;
    private com.coui.appcompat.widget.COUIDatePicker.b_renamed q_renamed;
    private boolean r_renamed;
    private com.coui.appcompat.widget.COUIDatePicker.a_renamed s_renamed;
    private com.coui.appcompat.widget.COUIDatePicker.a_renamed t_renamed;
    private com.coui.appcompat.widget.COUIDatePicker.a_renamed u_renamed;
    private int v_renamed;
    private int w_renamed;
    private int x_renamed;
    private int y_renamed;
    private java.util.Date z_renamed;

    public interface c_renamed {
        void a_renamed(com.coui.appcompat.widget.COUIDatePicker cOUIDatePicker, int i_renamed, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
    }

    public android.widget.CalendarView getCalendarView() {
        return null;
    }

    public boolean getCalendarViewShown() {
        return false;
    }

    public void setCalendarViewShown(boolean z_renamed) {
    }

    /* renamed from: com.coui.appcompat.widget.COUIDatePicker$1, reason: invalid class name */
    class SceneLoader_2 implements com.coui.appcompat.widget.COUINumberPicker.f_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.COUIDatePicker f2709a;

        @Override // com.coui.appcompat.widget.COUINumberPicker.f_renamed
        public void a_renamed(com.coui.appcompat.widget.COUINumberPicker cOUINumberPicker, int i_renamed, int i2) {
            this.f2709a.n_renamed.a_renamed(this.f2709a.q_renamed);
            if (cOUINumberPicker == this.f2709a.f_renamed) {
                this.f2709a.n_renamed.a_renamed(5, i2);
            } else if (cOUINumberPicker == this.f2709a.g_renamed) {
                this.f2709a.n_renamed.a_renamed(2, i2);
            } else if (cOUINumberPicker == this.f2709a.h_renamed) {
                this.f2709a.n_renamed.a_renamed(1, i2);
            } else {
                throw new java.lang.IllegalArgumentException();
            }
            com.coui.appcompat.widget.COUIDatePicker cOUIDatePicker = this.f2709a;
            cOUIDatePicker.setDate(cOUIDatePicker.n_renamed);
            this.f2709a.d_renamed();
            this.f2709a.e_renamed();
            this.f2709a.f_renamed();
        }
    }

    private java.lang.String a_renamed() {
        return !this.q_renamed.f2714b ? android.text.format.DateUtils.formatDateTime(this.i_renamed, this.q_renamed.f2713a.getTimeInMillis(), 20) : android.text.format.DateUtils.formatDateTime(this.i_renamed, this.q_renamed.f2713a.getTimeInMillis(), 24);
    }

    public long getMinDate() {
        return this.o_renamed.getTimeInMillis();
    }

    public void setMinDate(long j_renamed) {
        this.n_renamed.a_renamed(j_renamed);
        if (this.n_renamed.a_renamed(1) != this.o_renamed.get(1) || this.n_renamed.a_renamed(6) == this.o_renamed.get(6)) {
            this.o_renamed.setTimeInMillis(j_renamed);
            if (this.q_renamed.a_renamed(this.o_renamed)) {
                this.q_renamed.a_renamed(this.o_renamed.getTimeInMillis());
                e_renamed();
            }
            d_renamed();
        }
    }

    public long getMaxDate() {
        return this.p_renamed.getTimeInMillis();
    }

    public void setMaxDate(long j_renamed) {
        this.n_renamed.a_renamed(j_renamed);
        if (this.n_renamed.a_renamed(1) != this.p_renamed.get(1) || this.n_renamed.a_renamed(6) == this.p_renamed.get(6)) {
            this.p_renamed.setTimeInMillis(j_renamed);
            if (this.q_renamed.b_renamed(this.p_renamed)) {
                this.q_renamed.a_renamed(this.p_renamed.getTimeInMillis());
                e_renamed();
            }
            d_renamed();
        }
    }

    @Override // android.view.View
    public void setBackground(android.graphics.drawable.Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackground(int i_renamed) {
        setBackgroundDrawable(getContext().getResources().getDrawable(i_renamed));
    }

    public void setNormalColor(int i_renamed) {
        this.v_renamed = i_renamed;
        b_renamed();
    }

    public void setFocusColor(int i_renamed) {
        this.w_renamed = i_renamed;
        b_renamed();
    }

    private void b_renamed() {
        int i_renamed = this.v_renamed;
        if (i_renamed != -1) {
            this.f_renamed.setPickerNormalColor(i_renamed);
            this.g_renamed.setPickerNormalColor(this.v_renamed);
            this.h_renamed.setPickerNormalColor(this.v_renamed);
        }
        int i2 = this.w_renamed;
        if (i2 != -1) {
            this.f_renamed.setPickerFocusColor(i2);
            this.g_renamed.setPickerFocusColor(this.w_renamed);
            this.h_renamed.setPickerFocusColor(this.w_renamed);
        }
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.r_renamed;
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        if (this.r_renamed == z_renamed) {
            return;
        }
        super.setEnabled(z_renamed);
        this.f_renamed.setEnabled(z_renamed);
        this.g_renamed.setEnabled(z_renamed);
        this.h_renamed.setEnabled(z_renamed);
        this.r_renamed = z_renamed;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(a_renamed());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public boolean getSpinnersShown() {
        return this.e_renamed.isShown();
    }

    public void setSpinnersShown(boolean z_renamed) {
        this.e_renamed.setVisibility(z_renamed ? 0 : 8);
    }

    private void setCurrentLocale(java.util.Locale locale) {
        if (locale.equals(this.j_renamed)) {
            return;
        }
        this.j_renamed = locale;
        this.n_renamed = a_renamed(this.n_renamed, locale);
        this.o_renamed = a_renamed(this.o_renamed, locale);
        this.p_renamed = a_renamed(this.p_renamed, locale);
        this.q_renamed = a_renamed(this.q_renamed, locale);
        this.m_renamed = this.n_renamed.c_renamed(2) + 1;
        this.l_renamed = new java.lang.String[this.m_renamed];
    }

    private com.coui.appcompat.widget.COUIDatePicker.b_renamed a_renamed(com.coui.appcompat.widget.COUIDatePicker.b_renamed bVar, java.util.Locale locale) {
        if (bVar == null) {
            return new com.coui.appcompat.widget.COUIDatePicker.b_renamed(locale);
        }
        com.coui.appcompat.widget.COUIDatePicker.b_renamed bVar2 = new com.coui.appcompat.widget.COUIDatePicker.b_renamed(locale);
        if (!bVar.f2714b) {
            bVar2.a_renamed(bVar.a_renamed());
        } else {
            bVar2.a_renamed(bVar);
        }
        return bVar2;
    }

    private java.util.Calendar a_renamed(java.util.Calendar calendar, java.util.Locale locale) {
        if (calendar == null) {
            return java.util.Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public boolean isLayoutRtl() {
        return android.text.TextUtils.getLayoutDirectionFromLocale(java.util.Locale.getDefault()) == 1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(size, mode);
        this.f_renamed.a_renamed();
        this.g_renamed.a_renamed();
        this.h_renamed.a_renamed();
        a_renamed(this.f_renamed, i_renamed, i2);
        a_renamed(this.g_renamed, i_renamed, i2);
        a_renamed(this.h_renamed, i_renamed, i2);
        int measuredWidth = (((size - this.f_renamed.getMeasuredWidth()) - this.g_renamed.getMeasuredWidth()) - this.h_renamed.getMeasuredWidth()) / 2;
        if (this.e_renamed.getChildAt(this.f2707a) instanceof com.coui.appcompat.widget.COUINumberPicker) {
            ((com.coui.appcompat.widget.COUINumberPicker) this.e_renamed.getChildAt(this.f2707a)).setNumberPickerPaddingLeft(measuredWidth);
        }
        if (this.e_renamed.getChildAt(this.f2708b) instanceof com.coui.appcompat.widget.COUINumberPicker) {
            ((com.coui.appcompat.widget.COUINumberPicker) this.e_renamed.getChildAt(this.f2708b)).setNumberPickerPaddingRight(measuredWidth);
        }
        super.onMeasure(iMakeMeasureSpec, i2);
    }

    private void a_renamed(android.view.View view, int i_renamed, int i2) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        return new com.coui.appcompat.widget.COUIDatePicker.SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        com.coui.appcompat.widget.COUIDatePicker.SavedState savedState = (com.coui.appcompat.widget.COUIDatePicker.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a_renamed(savedState.mYear, savedState.mMonth, savedState.mDay);
        d_renamed();
        e_renamed();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setColor(this.f_renamed.getBackgroundColor());
        int i_renamed = this.x_renamed;
        canvas.drawRoundRect(this.y_renamed, (getHeight() / 2.0f) - this.x_renamed, getWidth() - this.y_renamed, i_renamed + (getHeight() / 2.0f), i_renamed, i_renamed, paint);
        super.dispatchDraw(canvas);
    }

    private void a_renamed(int i_renamed, int i2, int i3) {
        this.q_renamed.a_renamed(i_renamed, i2, i3);
        c_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(com.coui.appcompat.widget.COUIDatePicker.b_renamed bVar) {
        this.q_renamed.a_renamed(bVar);
        c_renamed();
    }

    private void c_renamed() {
        this.q_renamed.a_renamed(this.o_renamed, this.p_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed() {
        this.g_renamed.setFormatter(this.t_renamed);
        if (this.q_renamed.a_renamed(1) == this.o_renamed.get(1) && this.q_renamed.a_renamed(1) != this.p_renamed.get(1)) {
            this.g_renamed.setMinValue(this.o_renamed.get(2));
            this.g_renamed.setMaxValue(this.o_renamed.getActualMaximum(2));
            this.g_renamed.setWrapSelectorWheel(this.o_renamed.get(2) == 0);
        } else if (this.q_renamed.a_renamed(1) != this.o_renamed.get(1) && this.q_renamed.a_renamed(1) == this.p_renamed.get(1)) {
            this.g_renamed.setMinValue(0);
            this.g_renamed.setMaxValue(this.p_renamed.get(2));
            this.g_renamed.setWrapSelectorWheel(this.p_renamed.get(2) == this.p_renamed.getActualMaximum(2));
        } else if (this.q_renamed.a_renamed(1) == this.o_renamed.get(1) && this.q_renamed.a_renamed(1) == this.p_renamed.get(1)) {
            this.g_renamed.setMinValue(this.o_renamed.get(2));
            this.g_renamed.setMaxValue(this.p_renamed.get(2));
            this.g_renamed.setWrapSelectorWheel(this.p_renamed.get(2) == this.p_renamed.getActualMaximum(2) && this.o_renamed.get(2) == 0);
        } else {
            this.g_renamed.setMinValue(this.q_renamed.b_renamed(2));
            this.g_renamed.setMaxValue(this.q_renamed.c_renamed(2));
            this.g_renamed.setWrapSelectorWheel(true);
        }
        if (this.q_renamed.a_renamed(1) == this.o_renamed.get(1) && this.q_renamed.a_renamed(2) == this.o_renamed.get(2) && (this.q_renamed.a_renamed(1) != this.p_renamed.get(1) || this.q_renamed.a_renamed(2) != this.p_renamed.get(2))) {
            this.f_renamed.setMinValue(this.o_renamed.get(5));
            this.f_renamed.setMaxValue(this.o_renamed.getActualMaximum(5));
            this.f_renamed.setWrapSelectorWheel(this.o_renamed.get(5) == 1);
        } else if ((this.q_renamed.a_renamed(1) != this.o_renamed.get(1) || this.q_renamed.a_renamed(2) != this.o_renamed.get(2)) && this.q_renamed.a_renamed(1) == this.p_renamed.get(1) && this.q_renamed.a_renamed(2) == this.p_renamed.get(2)) {
            this.f_renamed.setMinValue(1);
            this.f_renamed.setMaxValue(this.p_renamed.get(5));
            this.f_renamed.setWrapSelectorWheel(this.p_renamed.get(5) == this.p_renamed.getActualMaximum(5));
        } else if (this.q_renamed.a_renamed(1) == this.o_renamed.get(1) && this.q_renamed.a_renamed(2) == this.o_renamed.get(2) && this.q_renamed.a_renamed(1) == this.p_renamed.get(1) && this.q_renamed.a_renamed(2) == this.p_renamed.get(2)) {
            this.f_renamed.setMinValue(this.o_renamed.get(5));
            this.f_renamed.setMaxValue(this.p_renamed.get(5));
            com.coui.appcompat.widget.COUINumberPicker cOUINumberPicker = this.f_renamed;
            if (this.p_renamed.get(5) == this.p_renamed.getActualMaximum(5) && this.o_renamed.get(5) == 1) {
                z_renamed = true;
            }
            cOUINumberPicker.setWrapSelectorWheel(z_renamed);
        } else {
            this.f_renamed.setMinValue(this.q_renamed.b_renamed(5));
            this.f_renamed.setMaxValue(this.q_renamed.c_renamed(5));
            this.f_renamed.setWrapSelectorWheel(true);
        }
        this.h_renamed.setMinValue(this.o_renamed.get(1));
        this.h_renamed.setMaxValue(this.p_renamed.get(1));
        this.h_renamed.setWrapSelectorWheel(true);
        this.h_renamed.setFormatter(this.s_renamed);
        this.h_renamed.setValue(this.q_renamed.a_renamed(1));
        this.g_renamed.setValue(this.q_renamed.a_renamed(2));
        this.f_renamed.setValue(this.q_renamed.a_renamed(5));
        this.f_renamed.setFormatter(this.u_renamed);
        if (this.f_renamed.getValue() > 27) {
            this.f_renamed.invalidate();
        }
    }

    public int getYear() {
        return this.q_renamed.a_renamed(1);
    }

    public int getMonth() {
        return this.q_renamed.a_renamed(2);
    }

    public int getDayOfMonth() {
        return this.q_renamed.a_renamed(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed() {
        com.coui.appcompat.widget.COUIDatePicker.c_renamed cVar = this.k_renamed;
        if (cVar != null) {
            cVar.a_renamed(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    public com.coui.appcompat.widget.COUIDatePicker.c_renamed getOnDateChangedListener() {
        return this.k_renamed;
    }

    public void setOnDateChangedListener(com.coui.appcompat.widget.COUIDatePicker.c_renamed cVar) {
        this.k_renamed = cVar;
    }

    private static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.coui.appcompat.widget.COUIDatePicker.SavedState> CREATOR = new android.os.Parcelable.Creator<com.coui.appcompat.widget.COUIDatePicker.SavedState>() { // from class: com.coui.appcompat.widget.COUIDatePicker.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.widget.COUIDatePicker.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.coui.appcompat.widget.COUIDatePicker.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.widget.COUIDatePicker.SavedState[] newArray(int i_renamed) {
                return new com.coui.appcompat.widget.COUIDatePicker.SavedState[i_renamed];
            }
        };
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        /* synthetic */ SavedState(android.os.Parcel parcel, com.coui.appcompat.widget.COUIDatePicker.SceneLoader_2 anonymousClass1) {
            this(parcel);
        }

        /* synthetic */ SavedState(android.os.Parcelable parcelable, int i_renamed, int i2, int i3, com.coui.appcompat.widget.COUIDatePicker.SceneLoader_2 anonymousClass1) {
            this(parcelable, i_renamed, i2, i3);
        }

        private SavedState(android.os.Parcelable parcelable, int i_renamed, int i2, int i3) {
            super(parcelable);
            this.mYear = i_renamed;
            this.mMonth = i2;
            this.mDay = i3;
        }

        private SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }
    }

    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.Calendar f2713a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f2714b;

        public b_renamed(java.util.Locale locale) {
            this.f2713a = java.util.Calendar.getInstance(locale);
        }

        public void a_renamed(com.coui.appcompat.widget.COUIDatePicker.b_renamed bVar) {
            this.f2713a.setTimeInMillis(bVar.f2713a.getTimeInMillis());
            this.f2714b = bVar.f2714b;
        }

        public long a_renamed() {
            return this.f2713a.getTimeInMillis();
        }

        public void a_renamed(long j_renamed) {
            this.f2713a.setTimeInMillis(j_renamed);
            this.f2714b = false;
        }

        public int a_renamed(int i_renamed) {
            if (!this.f2714b) {
                return this.f2713a.get(i_renamed);
            }
            if (i_renamed == 5) {
                return this.f2713a.get(i_renamed);
            }
            if (i_renamed == 2) {
                return this.f2713a.get(i_renamed);
            }
            if (i_renamed == 1) {
                return Integer.MIN_VALUE;
            }
            return this.f2713a.get(i_renamed);
        }

        public void a_renamed(int i_renamed, int i2) {
            if (i_renamed != 1) {
                if (i_renamed != 2) {
                    if (i_renamed == 5) {
                        this.f2713a.set(5, d_renamed(i2));
                        return;
                    }
                    return;
                } else {
                    int i3 = this.f2713a.get(1);
                    int i4 = this.f2713a.get(5);
                    this.f2713a.clear();
                    this.f2713a.set(1, i3);
                    this.f2713a.set(2, i2);
                    this.f2713a.set(5, d_renamed(i4));
                    return;
                }
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f2714b = false;
                int i5 = this.f2713a.get(2);
                int i6 = this.f2713a.get(5);
                this.f2713a.clear();
                this.f2713a.set(1, i2);
                this.f2713a.set(2, i5);
                this.f2713a.set(5, d_renamed(i6));
                return;
            }
            this.f2714b = true;
            int i7 = this.f2713a.get(2);
            int i8 = this.f2713a.get(5);
            this.f2713a.clear();
            this.f2713a.set(i_renamed, 2020);
            this.f2713a.set(2, i7);
            this.f2713a.set(5, d_renamed(i8));
        }

        public void a_renamed(int i_renamed, int i2, int i3) {
            a_renamed(1, i_renamed);
            a_renamed(2, i2);
            a_renamed(5, i3);
        }

        public boolean a_renamed(java.util.Calendar calendar) {
            if (this.f2714b) {
                return false;
            }
            return this.f2713a.before(calendar);
        }

        public boolean b_renamed(java.util.Calendar calendar) {
            if (this.f2714b) {
                return false;
            }
            return this.f2713a.after(calendar);
        }

        int b_renamed(int i_renamed) {
            return this.f2713a.getActualMinimum(i_renamed);
        }

        int c_renamed(int i_renamed) {
            return this.f2713a.getActualMaximum(i_renamed);
        }

        void a_renamed(java.util.Calendar calendar, java.util.Calendar calendar2) {
            if (this.f2714b) {
                return;
            }
            if (this.f2713a.before(calendar)) {
                a_renamed(1, calendar.get(1));
                a_renamed(2, calendar.get(2));
                a_renamed(5, calendar.get(5));
            } else if (this.f2713a.after(calendar2)) {
                a_renamed(1, calendar2.get(1));
                a_renamed(2, calendar2.get(2));
                a_renamed(5, calendar2.get(5));
            }
        }

        int d_renamed(int i_renamed) {
            int actualMaximum = this.f2713a.getActualMaximum(5);
            return i_renamed > actualMaximum ? actualMaximum : i_renamed;
        }
    }

    class a_renamed implements com.coui.appcompat.widget.COUINumberPicker.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f2710a;

        /* renamed from: b_renamed, reason: collision with root package name */
        java.lang.String f2711b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.COUIDatePicker f2712c;

        @Override // com.coui.appcompat.widget.COUINumberPicker.c_renamed
        public java.lang.String a_renamed(int i_renamed) {
            if (this.f2711b.equals("MONTH")) {
                this.f2712c.z_renamed.setMonth(i_renamed);
                return android.text.format.DateUtils.formatDateTime(this.f2712c.getContext(), this.f2712c.z_renamed.getTime(), 65576);
            }
            if (!java.util.Locale.getDefault().getLanguage().equals("zh")) {
                java.util.Formatter formatter = new java.util.Formatter(new java.lang.StringBuilder(), this.f2712c.j_renamed);
                if (this.f2711b.equals("YEAR")) {
                    formatter.format("%d_renamed", java.lang.Integer.valueOf(i_renamed));
                    return formatter.toString();
                }
                if (this.f2711b.equals("DAY")) {
                    formatter.format("%02d", java.lang.Integer.valueOf(i_renamed));
                    return formatter.toString();
                }
            }
            return i_renamed + this.f2712c.getResources().getString(this.f2710a);
        }
    }

    public void setNormalTextColor(int i_renamed) {
        com.coui.appcompat.widget.COUINumberPicker cOUINumberPicker = this.f_renamed;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setNormalTextColor(i_renamed);
        }
        com.coui.appcompat.widget.COUINumberPicker cOUINumberPicker2 = this.g_renamed;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setNormalTextColor(i_renamed);
        }
        com.coui.appcompat.widget.COUINumberPicker cOUINumberPicker3 = this.h_renamed;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.setNormalTextColor(i_renamed);
        }
    }
}
