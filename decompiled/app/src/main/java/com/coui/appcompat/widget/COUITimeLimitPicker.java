package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import coui.support.appcompat.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUITimeLimitPicker extends FrameLayout {

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final /* synthetic */ boolean f7847c = !COUITimeLimitPicker.class.desiredAssertionStatus();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final InterfaceC1433a f7848d = new InterfaceC1433a() { // from class: com.coui.appcompat.widget.COUITimeLimitPicker.1
        @Override // com.coui.appcompat.widget.COUITimeLimitPicker.InterfaceC1433a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo7476a(COUITimeLimitPicker cOUITimeLimitPicker, int OplusGLSurfaceView_13, int i2) {
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    int f7849a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f7850b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final COUINumberPicker f7851e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final COUINumberPicker f7852f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final COUINumberPicker f7853g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private LinearLayout f7854h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Button f7855i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final String[] f7856j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f7857k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f7858l;

    /* renamed from: OplusGLSurfaceView_6 */
    private TextView f7859m;

    /* renamed from: OplusGLSurfaceView_11 */
    private TextView f7860n;

    /* renamed from: o */
    private boolean f7861o;

    /* renamed from: p */
    private InterfaceC1433a f7862p;

    /* renamed from: q */
    private Calendar f7863q;

    /* renamed from: r */
    private Locale f7864r;

    /* renamed from: s */
    private int f7865s;

    /* renamed from: t */
    private int f7866t;

    /* renamed from: u */
    private Context f7867u;

    /* renamed from: com.coui.appcompat.widget.COUITimeLimitPicker$PlatformImplementations.kt_3 */
    public interface InterfaceC1433a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7476a(COUITimeLimitPicker cOUITimeLimitPicker, int OplusGLSurfaceView_13, int i2);
    }

    public void setTextVisibility(boolean z) {
        if (z) {
            this.f7859m.setVisibility(0);
            this.f7860n.setVisibility(0);
        } else {
            this.f7859m.setVisibility(8);
            this.f7860n.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.f7861o == z) {
            return;
        }
        super.setEnabled(z);
        this.f7852f.setEnabled(z);
        this.f7851e.setEnabled(z);
        COUINumberPicker cOUINumberPicker = this.f7853g;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setEnabled(z);
        } else {
            this.f7855i.setEnabled(z);
        }
        this.f7861o = z;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f7861o;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.f7851e.getBackgroundColor());
        int OplusGLSurfaceView_13 = this.f7865s;
        canvas.drawRoundRect(this.f7866t, (getHeight() / 2.0f) - this.f7865s, getWidth() - this.f7866t, OplusGLSurfaceView_13 + (getHeight() / 2.0f), OplusGLSurfaceView_13, OplusGLSurfaceView_13, paint);
        super.dispatchDraw(canvas);
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.f7864r)) {
            return;
        }
        this.f7864r = locale;
        this.f7863q = Calendar.getInstance(locale);
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUITimeLimitPicker.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        private final int mHour;
        private final int mMinute;

        private SavedState(Parcelable parcelable, int OplusGLSurfaceView_13, int i2) {
            super(parcelable);
            this.mHour = OplusGLSurfaceView_13;
            this.mMinute = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }

        int getHour() {
            return this.mHour;
        }

        int getMinute() {
            return this.mMinute;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.getHour()));
        setCurrentMinute(Integer.valueOf(savedState.getMinute()));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
        this.f7849a = -1;
        for (int i3 = 0; i3 < this.f7854h.getChildCount(); i3++) {
            View childAt = this.f7854h.getChildAt(i3);
            if ((childAt instanceof COUINumberPicker) && childAt.getVisibility() == 0) {
                if (this.f7849a == -1) {
                    this.f7849a = i3;
                }
                this.f7850b = i3;
                ((COUINumberPicker) childAt).m7301a();
                m7471a(childAt, OplusGLSurfaceView_13, i2);
                size -= childAt.getMeasuredWidth();
            }
        }
        int i4 = size / 2;
        if (isLayoutRtl()) {
            int i5 = this.f7849a;
            this.f7849a = this.f7850b;
            this.f7850b = i5;
        }
        if (this.f7854h.getChildAt(this.f7849a) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.f7854h.getChildAt(this.f7849a)).setNumberPickerPaddingLeft(i4);
        }
        if (this.f7854h.getChildAt(this.f7850b) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.f7854h.getChildAt(this.f7850b)).setNumberPickerPaddingRight(i4);
        }
        super.onMeasure(iMakeMeasureSpec, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7471a(View view, int OplusGLSurfaceView_13, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    public void setOnTimeChangedListener(InterfaceC1433a interfaceC1433a) {
        this.f7862p = interfaceC1433a;
    }

    public Integer getCurrentHour() {
        int value = this.f7851e.getValue();
        if (m7475a()) {
            return Integer.valueOf(value);
        }
        if (this.f7858l) {
            return Integer.valueOf(value % 12);
        }
        return Integer.valueOf((value % 12) + 12);
    }

    public void setCurrentHour(Integer num) {
        if (num == null || num == getCurrentHour()) {
            return;
        }
        if (!m7475a()) {
            if (num.intValue() >= 12) {
                this.f7858l = false;
                if (num.intValue() > 12) {
                    num = Integer.valueOf(num.intValue() - 12);
                }
            } else {
                this.f7858l = true;
                if (num.intValue() == 0) {
                    num = 12;
                }
            }
            m7473c();
        }
        this.f7851e.setValue(num.intValue());
        m7474d();
    }

    public void setIs24HourView(Boolean bool) {
        if (this.f7857k == bool.booleanValue()) {
            return;
        }
        int iIntValue = getCurrentHour().intValue();
        this.f7857k = bool.booleanValue();
        m7472b();
        setCurrentHour(Integer.valueOf(iIntValue));
        m7473c();
        this.f7851e.requestLayout();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7475a() {
        return this.f7857k;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f7852f.getValue());
    }

    public void setCurrentMinute(Integer num) {
        if (num.equals(getCurrentMinute())) {
            return;
        }
        this.f7852f.setValue(num.intValue());
        m7474d();
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f7851e.getBaseline();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        String str;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        String str2 = this.f7858l ? this.f7856j[0] : this.f7856j[1];
        if (this.f7857k) {
            str = getCurrentHour().toString() + this.f7867u.getString(R.string.coui_hour) + getCurrentMinute() + this.f7867u.getString(R.string.coui_minute);
        } else {
            str = str2 + this.f7851e.getValue() + this.f7867u.getString(R.string.coui_hour) + getCurrentMinute() + this.f7867u.getString(R.string.coui_minute);
        }
        accessibilityEvent.getText().add(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7472b() {
        if (m7475a()) {
            this.f7851e.setMinValue(0);
            this.f7851e.setMaxValue(23);
            this.f7851e.m7303b();
        } else {
            this.f7851e.setMinValue(1);
            this.f7851e.setMaxValue(12);
        }
        this.f7851e.setWrapSelectorWheel(true);
        this.f7852f.setWrapSelectorWheel(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7473c() {
        if (m7475a()) {
            COUINumberPicker cOUINumberPicker = this.f7853g;
            if (cOUINumberPicker != null) {
                cOUINumberPicker.setVisibility(8);
                return;
            } else {
                this.f7855i.setVisibility(8);
                return;
            }
        }
        int OplusGLSurfaceView_13 = !this.f7858l ? 1 : 0;
        COUINumberPicker cOUINumberPicker2 = this.f7853g;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setValue(OplusGLSurfaceView_13);
            this.f7853g.setVisibility(0);
        } else {
            this.f7855i.setText(this.f7856j[OplusGLSurfaceView_13]);
            this.f7855i.setVisibility(0);
        }
    }

    public boolean isLayoutRtl() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7474d() {
        InterfaceC1433a interfaceC1433a = this.f7862p;
        if (interfaceC1433a != null) {
            interfaceC1433a.mo7476a(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    public void setRowNumber(int OplusGLSurfaceView_13) {
        COUINumberPicker cOUINumberPicker;
        if (OplusGLSurfaceView_13 <= 0 || (cOUINumberPicker = this.f7851e) == null || this.f7852f == null || this.f7853g == null) {
            return;
        }
        cOUINumberPicker.setPickerRowNumber(OplusGLSurfaceView_13);
        this.f7852f.setPickerRowNumber(OplusGLSurfaceView_13);
        this.f7853g.setPickerRowNumber(OplusGLSurfaceView_13);
    }

    public void setNormalTextColor(int OplusGLSurfaceView_13) {
        COUINumberPicker cOUINumberPicker = this.f7851e;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setNormalTextColor(OplusGLSurfaceView_13);
        }
        COUINumberPicker cOUINumberPicker2 = this.f7852f;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setNormalTextColor(OplusGLSurfaceView_13);
        }
        COUINumberPicker cOUINumberPicker3 = this.f7853g;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.setNormalTextColor(OplusGLSurfaceView_13);
        }
    }
}
