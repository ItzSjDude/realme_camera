package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.coui.appcompat.widget.COUINumberPicker;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUIDatePicker extends FrameLayout {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final String f7188c = "COUIDatePicker";

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static char[] f7189d = {'IntrinsicsJvm.kt_5', 'M', 'y'};

    /* renamed from: PlatformImplementations.kt_3 */
    int f7190a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f7191b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LinearLayout f7192e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final COUINumberPicker f7193f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final COUINumberPicker f7194g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final COUINumberPicker f7195h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Context f7196i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Locale f7197j;

    /* renamed from: OplusGLSurfaceView_5 */
    private InterfaceC1366c f7198k;

    /* renamed from: OplusGLSurfaceView_14 */
    private String[] f7199l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f7200m;

    /* renamed from: OplusGLSurfaceView_11 */
    private C1365b f7201n;

    /* renamed from: o */
    private Calendar f7202o;

    /* renamed from: p */
    private Calendar f7203p;

    /* renamed from: q */
    private C1365b f7204q;

    /* renamed from: r */
    private boolean f7205r;

    /* renamed from: s */
    private C1364a f7206s;

    /* renamed from: t */
    private C1364a f7207t;

    /* renamed from: u */
    private C1364a f7208u;

    /* renamed from: v */
    private int f7209v;

    /* renamed from: w */
    private int f7210w;

    /* renamed from: x */
    private int f7211x;

    /* renamed from: y */
    private int f7212y;

    /* renamed from: z */
    private Date f7213z;

    /* renamed from: com.coui.appcompat.widget.COUIDatePicker$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1366c {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7077a(COUIDatePicker cOUIDatePicker, int OplusGLSurfaceView_13, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m7052e() {
    }

    public CalendarView getCalendarView() {
        return null;
    }

    public boolean getCalendarViewShown() {
        return false;
    }

    public void setCalendarViewShown(boolean z) {
    }

    /* renamed from: com.coui.appcompat.widget.COUIDatePicker$1 */
    class C13621 implements COUINumberPicker.InterfaceC1410f {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIDatePicker f7214a;

        @Override // com.coui.appcompat.widget.COUINumberPicker.InterfaceC1410f
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo7059a(COUINumberPicker cOUINumberPicker, int OplusGLSurfaceView_13, int i2) {
            this.f7214a.f7201n.m7070a(this.f7214a.f7204q);
            if (cOUINumberPicker == this.f7214a.f7193f) {
                this.f7214a.f7201n.m7067a(5, i2);
            } else if (cOUINumberPicker == this.f7214a.f7194g) {
                this.f7214a.f7201n.m7067a(2, i2);
            } else if (cOUINumberPicker == this.f7214a.f7195h) {
                this.f7214a.f7201n.m7067a(1, i2);
            } else {
                throw new IllegalArgumentException();
            }
            COUIDatePicker cOUIDatePicker = this.f7214a;
            cOUIDatePicker.setDate(cOUIDatePicker.f7201n);
            this.f7214a.m7050d();
            this.f7214a.m7052e();
            this.f7214a.m7053f();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m7040a() {
        return !this.f7204q.f7219b ? DateUtils.formatDateTime(this.f7196i, this.f7204q.f7218a.getTimeInMillis(), 20) : DateUtils.formatDateTime(this.f7196i, this.f7204q.f7218a.getTimeInMillis(), 24);
    }

    public long getMinDate() {
        return this.f7202o.getTimeInMillis();
    }

    public void setMinDate(long OplusGLSurfaceView_15) {
        this.f7201n.m7069a(OplusGLSurfaceView_15);
        if (this.f7201n.m7065a(1) != this.f7202o.get(1) || this.f7201n.m7065a(6) == this.f7202o.get(6)) {
            this.f7202o.setTimeInMillis(OplusGLSurfaceView_15);
            if (this.f7204q.m7072a(this.f7202o)) {
                this.f7204q.m7069a(this.f7202o.getTimeInMillis());
                m7052e();
            }
            m7050d();
        }
    }

    public long getMaxDate() {
        return this.f7203p.getTimeInMillis();
    }

    public void setMaxDate(long OplusGLSurfaceView_15) {
        this.f7201n.m7069a(OplusGLSurfaceView_15);
        if (this.f7201n.m7065a(1) != this.f7203p.get(1) || this.f7201n.m7065a(6) == this.f7203p.get(6)) {
            this.f7203p.setTimeInMillis(OplusGLSurfaceView_15);
            if (this.f7204q.m7074b(this.f7203p)) {
                this.f7204q.m7069a(this.f7203p.getTimeInMillis());
                m7052e();
            }
            m7050d();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackground(int OplusGLSurfaceView_13) {
        setBackgroundDrawable(getContext().getResources().getDrawable(OplusGLSurfaceView_13));
    }

    public void setNormalColor(int OplusGLSurfaceView_13) {
        this.f7209v = OplusGLSurfaceView_13;
        m7046b();
    }

    public void setFocusColor(int OplusGLSurfaceView_13) {
        this.f7210w = OplusGLSurfaceView_13;
        m7046b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7046b() {
        int OplusGLSurfaceView_13 = this.f7209v;
        if (OplusGLSurfaceView_13 != -1) {
            this.f7193f.setPickerNormalColor(OplusGLSurfaceView_13);
            this.f7194g.setPickerNormalColor(this.f7209v);
            this.f7195h.setPickerNormalColor(this.f7209v);
        }
        int i2 = this.f7210w;
        if (i2 != -1) {
            this.f7193f.setPickerFocusColor(i2);
            this.f7194g.setPickerFocusColor(this.f7210w);
            this.f7195h.setPickerFocusColor(this.f7210w);
        }
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f7205r;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.f7205r == z) {
            return;
        }
        super.setEnabled(z);
        this.f7193f.setEnabled(z);
        this.f7194g.setEnabled(z);
        this.f7195h.setEnabled(z);
        this.f7205r = z;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(m7040a());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public boolean getSpinnersShown() {
        return this.f7192e.isShown();
    }

    public void setSpinnersShown(boolean z) {
        this.f7192e.setVisibility(z ? 0 : 8);
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.f7197j)) {
            return;
        }
        this.f7197j = locale;
        this.f7201n = m7038a(this.f7201n, locale);
        this.f7202o = m7041a(this.f7202o, locale);
        this.f7203p = m7041a(this.f7203p, locale);
        this.f7204q = m7038a(this.f7204q, locale);
        this.f7200m = this.f7201n.m7075c(2) + 1;
        this.f7199l = new String[this.f7200m];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private C1365b m7038a(C1365b c1365b, Locale locale) {
        if (c1365b == null) {
            return new C1365b(locale);
        }
        C1365b c1365b2 = new C1365b(locale);
        if (!c1365b.f7219b) {
            c1365b2.m7069a(c1365b.m7066a());
        } else {
            c1365b2.m7070a(c1365b);
        }
        return c1365b2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Calendar m7041a(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public boolean isLayoutRtl() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
        this.f7193f.m7301a();
        this.f7194g.m7301a();
        this.f7195h.m7301a();
        m7043a(this.f7193f, OplusGLSurfaceView_13, i2);
        m7043a(this.f7194g, OplusGLSurfaceView_13, i2);
        m7043a(this.f7195h, OplusGLSurfaceView_13, i2);
        int measuredWidth = (((size - this.f7193f.getMeasuredWidth()) - this.f7194g.getMeasuredWidth()) - this.f7195h.getMeasuredWidth()) / 2;
        if (this.f7192e.getChildAt(this.f7190a) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.f7192e.getChildAt(this.f7190a)).setNumberPickerPaddingLeft(measuredWidth);
        }
        if (this.f7192e.getChildAt(this.f7191b) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.f7192e.getChildAt(this.f7191b)).setNumberPickerPaddingRight(measuredWidth);
        }
        super.onMeasure(iMakeMeasureSpec, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7043a(View view, int OplusGLSurfaceView_13, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m7042a(savedState.mYear, savedState.mMonth, savedState.mDay);
        m7050d();
        m7052e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.f7193f.getBackgroundColor());
        int OplusGLSurfaceView_13 = this.f7211x;
        canvas.drawRoundRect(this.f7212y, (getHeight() / 2.0f) - this.f7211x, getWidth() - this.f7212y, OplusGLSurfaceView_13 + (getHeight() / 2.0f), OplusGLSurfaceView_13, OplusGLSurfaceView_13, paint);
        super.dispatchDraw(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7042a(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f7204q.m7068a(OplusGLSurfaceView_13, i2, i3);
        m7048c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(C1365b c1365b) {
        this.f7204q.m7070a(c1365b);
        m7048c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7048c() {
        this.f7204q.m7071a(this.f7202o, this.f7203p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m7050d() {
        this.f7194g.setFormatter(this.f7207t);
        if (this.f7204q.m7065a(1) == this.f7202o.get(1) && this.f7204q.m7065a(1) != this.f7203p.get(1)) {
            this.f7194g.setMinValue(this.f7202o.get(2));
            this.f7194g.setMaxValue(this.f7202o.getActualMaximum(2));
            this.f7194g.setWrapSelectorWheel(this.f7202o.get(2) == 0);
        } else if (this.f7204q.m7065a(1) != this.f7202o.get(1) && this.f7204q.m7065a(1) == this.f7203p.get(1)) {
            this.f7194g.setMinValue(0);
            this.f7194g.setMaxValue(this.f7203p.get(2));
            this.f7194g.setWrapSelectorWheel(this.f7203p.get(2) == this.f7203p.getActualMaximum(2));
        } else if (this.f7204q.m7065a(1) == this.f7202o.get(1) && this.f7204q.m7065a(1) == this.f7203p.get(1)) {
            this.f7194g.setMinValue(this.f7202o.get(2));
            this.f7194g.setMaxValue(this.f7203p.get(2));
            this.f7194g.setWrapSelectorWheel(this.f7203p.get(2) == this.f7203p.getActualMaximum(2) && this.f7202o.get(2) == 0);
        } else {
            this.f7194g.setMinValue(this.f7204q.m7073b(2));
            this.f7194g.setMaxValue(this.f7204q.m7075c(2));
            this.f7194g.setWrapSelectorWheel(true);
        }
        if (this.f7204q.m7065a(1) == this.f7202o.get(1) && this.f7204q.m7065a(2) == this.f7202o.get(2) && (this.f7204q.m7065a(1) != this.f7203p.get(1) || this.f7204q.m7065a(2) != this.f7203p.get(2))) {
            this.f7193f.setMinValue(this.f7202o.get(5));
            this.f7193f.setMaxValue(this.f7202o.getActualMaximum(5));
            this.f7193f.setWrapSelectorWheel(this.f7202o.get(5) == 1);
        } else if ((this.f7204q.m7065a(1) != this.f7202o.get(1) || this.f7204q.m7065a(2) != this.f7202o.get(2)) && this.f7204q.m7065a(1) == this.f7203p.get(1) && this.f7204q.m7065a(2) == this.f7203p.get(2)) {
            this.f7193f.setMinValue(1);
            this.f7193f.setMaxValue(this.f7203p.get(5));
            this.f7193f.setWrapSelectorWheel(this.f7203p.get(5) == this.f7203p.getActualMaximum(5));
        } else if (this.f7204q.m7065a(1) == this.f7202o.get(1) && this.f7204q.m7065a(2) == this.f7202o.get(2) && this.f7204q.m7065a(1) == this.f7203p.get(1) && this.f7204q.m7065a(2) == this.f7203p.get(2)) {
            this.f7193f.setMinValue(this.f7202o.get(5));
            this.f7193f.setMaxValue(this.f7203p.get(5));
            COUINumberPicker cOUINumberPicker = this.f7193f;
            if (this.f7203p.get(5) == this.f7203p.getActualMaximum(5) && this.f7202o.get(5) == 1) {
                z = true;
            }
            cOUINumberPicker.setWrapSelectorWheel(z);
        } else {
            this.f7193f.setMinValue(this.f7204q.m7073b(5));
            this.f7193f.setMaxValue(this.f7204q.m7075c(5));
            this.f7193f.setWrapSelectorWheel(true);
        }
        this.f7195h.setMinValue(this.f7202o.get(1));
        this.f7195h.setMaxValue(this.f7203p.get(1));
        this.f7195h.setWrapSelectorWheel(true);
        this.f7195h.setFormatter(this.f7206s);
        this.f7195h.setValue(this.f7204q.m7065a(1));
        this.f7194g.setValue(this.f7204q.m7065a(2));
        this.f7193f.setValue(this.f7204q.m7065a(5));
        this.f7193f.setFormatter(this.f7208u);
        if (this.f7193f.getValue() > 27) {
            this.f7193f.invalidate();
        }
    }

    public int getYear() {
        return this.f7204q.m7065a(1);
    }

    public int getMonth() {
        return this.f7204q.m7065a(2);
    }

    public int getDayOfMonth() {
        return this.f7204q.m7065a(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m7053f() {
        InterfaceC1366c interfaceC1366c = this.f7198k;
        if (interfaceC1366c != null) {
            interfaceC1366c.m7077a(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    public InterfaceC1366c getOnDateChangedListener() {
        return this.f7198k;
    }

    public void setOnDateChangedListener(InterfaceC1366c interfaceC1366c) {
        this.f7198k = interfaceC1366c;
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUIDatePicker.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        /* synthetic */ SavedState(Parcel parcel, C13621 c13621) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int OplusGLSurfaceView_13, int i2, int i3, C13621 c13621) {
            this(parcelable, OplusGLSurfaceView_13, i2, i3);
        }

        private SavedState(Parcelable parcelable, int OplusGLSurfaceView_13, int i2, int i3) {
            super(parcelable);
            this.mYear = OplusGLSurfaceView_13;
            this.mMonth = i2;
            this.mDay = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUIDatePicker$IntrinsicsJvm.kt_4 */
    private static class C1365b {

        /* renamed from: PlatformImplementations.kt_3 */
        private Calendar f7218a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f7219b;

        public C1365b(Locale locale) {
            this.f7218a = Calendar.getInstance(locale);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7070a(C1365b c1365b) {
            this.f7218a.setTimeInMillis(c1365b.f7218a.getTimeInMillis());
            this.f7219b = c1365b.f7219b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public long m7066a() {
            return this.f7218a.getTimeInMillis();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7069a(long OplusGLSurfaceView_15) {
            this.f7218a.setTimeInMillis(OplusGLSurfaceView_15);
            this.f7219b = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m7065a(int OplusGLSurfaceView_13) {
            if (!this.f7219b) {
                return this.f7218a.get(OplusGLSurfaceView_13);
            }
            if (OplusGLSurfaceView_13 == 5) {
                return this.f7218a.get(OplusGLSurfaceView_13);
            }
            if (OplusGLSurfaceView_13 == 2) {
                return this.f7218a.get(OplusGLSurfaceView_13);
            }
            if (OplusGLSurfaceView_13 == 1) {
                return Integer.MIN_VALUE;
            }
            return this.f7218a.get(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7067a(int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 != 2) {
                    if (OplusGLSurfaceView_13 == 5) {
                        this.f7218a.set(5, m7076d(i2));
                        return;
                    }
                    return;
                } else {
                    int i3 = this.f7218a.get(1);
                    int i4 = this.f7218a.get(5);
                    this.f7218a.clear();
                    this.f7218a.set(1, i3);
                    this.f7218a.set(2, i2);
                    this.f7218a.set(5, m7076d(i4));
                    return;
                }
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f7219b = false;
                int i5 = this.f7218a.get(2);
                int i6 = this.f7218a.get(5);
                this.f7218a.clear();
                this.f7218a.set(1, i2);
                this.f7218a.set(2, i5);
                this.f7218a.set(5, m7076d(i6));
                return;
            }
            this.f7219b = true;
            int i7 = this.f7218a.get(2);
            int i8 = this.f7218a.get(5);
            this.f7218a.clear();
            this.f7218a.set(OplusGLSurfaceView_13, 2020);
            this.f7218a.set(2, i7);
            this.f7218a.set(5, m7076d(i8));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7068a(int OplusGLSurfaceView_13, int i2, int i3) {
            m7067a(1, OplusGLSurfaceView_13);
            m7067a(2, i2);
            m7067a(5, i3);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m7072a(Calendar calendar) {
            if (this.f7219b) {
                return false;
            }
            return this.f7218a.before(calendar);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m7074b(Calendar calendar) {
            if (this.f7219b) {
                return false;
            }
            return this.f7218a.after(calendar);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m7073b(int OplusGLSurfaceView_13) {
            return this.f7218a.getActualMinimum(OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        int m7075c(int OplusGLSurfaceView_13) {
            return this.f7218a.getActualMaximum(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7071a(Calendar calendar, Calendar calendar2) {
            if (this.f7219b) {
                return;
            }
            if (this.f7218a.before(calendar)) {
                m7067a(1, calendar.get(1));
                m7067a(2, calendar.get(2));
                m7067a(5, calendar.get(5));
            } else if (this.f7218a.after(calendar2)) {
                m7067a(1, calendar2.get(1));
                m7067a(2, calendar2.get(2));
                m7067a(5, calendar2.get(5));
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        int m7076d(int OplusGLSurfaceView_13) {
            int actualMaximum = this.f7218a.getActualMaximum(5);
            return OplusGLSurfaceView_13 > actualMaximum ? actualMaximum : OplusGLSurfaceView_13;
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUIDatePicker$PlatformImplementations.kt_3 */
    class C1364a implements COUINumberPicker.InterfaceC1407c {

        /* renamed from: PlatformImplementations.kt_3 */
        int f7215a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        String f7216b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final /* synthetic */ COUIDatePicker f7217c;

        @Override // com.coui.appcompat.widget.COUINumberPicker.InterfaceC1407c
        /* renamed from: PlatformImplementations.kt_3 */
        public String mo7062a(int OplusGLSurfaceView_13) {
            if (this.f7216b.equals("MONTH")) {
                this.f7217c.f7213z.setMonth(OplusGLSurfaceView_13);
                return DateUtils.formatDateTime(this.f7217c.getContext(), this.f7217c.f7213z.getTime(), 65576);
            }
            if (!Locale.getDefault().getLanguage().equals("zh")) {
                Formatter formatter = new Formatter(new StringBuilder(), this.f7217c.f7197j);
                if (this.f7216b.equals("YEAR")) {
                    formatter.format("%IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13));
                    return formatter.toString();
                }
                if (this.f7216b.equals("DAY")) {
                    formatter.format("%02d", Integer.valueOf(OplusGLSurfaceView_13));
                    return formatter.toString();
                }
            }
            return OplusGLSurfaceView_13 + this.f7217c.getResources().getString(this.f7215a);
        }
    }

    public void setNormalTextColor(int OplusGLSurfaceView_13) {
        COUINumberPicker cOUINumberPicker = this.f7193f;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setNormalTextColor(OplusGLSurfaceView_13);
        }
        COUINumberPicker cOUINumberPicker2 = this.f7194g;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setNormalTextColor(OplusGLSurfaceView_13);
        }
        COUINumberPicker cOUINumberPicker3 = this.f7195h;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.setNormalTextColor(OplusGLSurfaceView_13);
        }
    }
}
