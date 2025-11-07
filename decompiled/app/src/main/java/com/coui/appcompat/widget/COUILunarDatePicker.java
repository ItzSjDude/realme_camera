package com.coui.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
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
import java.util.Locale;

/* loaded from: classes.dex */
public class COUILunarDatePicker extends FrameLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f7444a = "COUILunarDatePicker";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String f7446c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final LinearLayout f7449f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final COUINumberPicker f7450g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final COUINumberPicker f7451h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final COUINumberPicker f7452i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Locale f7453j;

    /* renamed from: OplusGLSurfaceView_5 */
    private InterfaceC1404b f7454k;

    /* renamed from: OplusGLSurfaceView_14 */
    private String[] f7455l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f7456m;

    /* renamed from: OplusGLSurfaceView_11 */
    private C1403a f7457n;

    /* renamed from: o */
    private C1403a f7458o;

    /* renamed from: p */
    private int f7459p;

    /* renamed from: q */
    private int f7460q;

    /* renamed from: r */
    private boolean f7461r;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String[] f7445b = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Calendar f7447d = Calendar.getInstance();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Calendar f7448e = Calendar.getInstance();

    /* renamed from: com.coui.appcompat.widget.COUILunarDatePicker$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1404b {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7245a(COUILunarDatePicker cOUILunarDatePicker, int OplusGLSurfaceView_13, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m7223c() {
    }

    public CalendarView getCalendarView() {
        return null;
    }

    public boolean getCalendarViewShown() {
        return false;
    }

    public void setCalendarViewShown(boolean z) {
    }

    static {
        f7447d.set(1910, 2, 10, 0, 0);
        f7448e.set(2036, 11, 31, 23, 59);
    }

    /* renamed from: com.coui.appcompat.widget.COUILunarDatePicker$1 */
    class C14011 implements COUINumberPicker.InterfaceC1410f {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUILunarDatePicker f7462a;

        @Override // com.coui.appcompat.widget.COUINumberPicker.InterfaceC1410f
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo7059a(COUINumberPicker cOUINumberPicker, int OplusGLSurfaceView_13, int i2) {
            this.f7462a.f7457n.m7237a(this.f7462a.f7458o);
            COUILunarUtil.m7832a(this.f7462a.f7457n.m7233a(1), this.f7462a.f7457n.m7233a(2) + 1, this.f7462a.f7457n.m7233a(5));
            if (cOUINumberPicker == this.f7462a.f7450g) {
                this.f7462a.f7457n.m7240b(5, OplusGLSurfaceView_13, i2);
            } else if (cOUINumberPicker == this.f7462a.f7451h) {
                this.f7462a.f7457n.m7240b(2, OplusGLSurfaceView_13, i2);
            } else if (cOUINumberPicker == this.f7462a.f7452i) {
                this.f7462a.f7457n.m7240b(1, OplusGLSurfaceView_13, i2);
            } else {
                throw new IllegalArgumentException();
            }
            COUILunarDatePicker cOUILunarDatePicker = this.f7462a;
            cOUILunarDatePicker.setDate(cOUILunarDatePicker.f7457n);
            this.f7462a.m7221b();
            this.f7462a.m7223c();
            this.f7462a.m7225d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m7214a(C1403a c1403a) {
        int[] iArrM7832a = COUILunarUtil.m7832a(c1403a.m7233a(1), c1403a.m7233a(2) + 1, c1403a.m7233a(5));
        return m7213a(iArrM7832a[0], iArrM7832a[1], iArrM7832a[2], iArrM7832a[3]);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m7213a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i2 <= 0) {
            return "";
        }
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder();
            sb.append(OplusGLSurfaceView_13);
            sb.append("年");
            sb.append(i4 == 0 ? f7446c : "");
            sb.append(f7445b[i2 - 1]);
            sb.append("月");
            sb.append(COUILunarUtil.m7838d(i3));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i4 == 0 ? f7446c : "");
        sb2.append(f7445b[i2 - 1]);
        sb2.append("月");
        sb2.append(COUILunarUtil.m7838d(i3));
        return sb2.toString();
    }

    public long getMinDate() {
        return f7447d.getTimeInMillis();
    }

    public void setMinDate(long OplusGLSurfaceView_15) {
        this.f7457n.m7236a(OplusGLSurfaceView_15);
        if (this.f7457n.m7233a(1) == f7447d.get(1) && this.f7457n.m7233a(6) != f7447d.get(6)) {
            Log.w(f7444a, "setMinDate failed!:" + this.f7457n.m7233a(1) + "<->" + f7447d.get(1) + ":" + this.f7457n.m7233a(6) + "<->" + f7447d.get(6));
            return;
        }
        f7447d.setTimeInMillis(OplusGLSurfaceView_15);
        if (this.f7458o.m7241b(f7447d)) {
            this.f7458o.m7236a(f7447d.getTimeInMillis());
            m7223c();
        }
        m7221b();
    }

    public long getMaxDate() {
        return f7448e.getTimeInMillis();
    }

    public void setMaxDate(long OplusGLSurfaceView_15) {
        this.f7457n.m7236a(OplusGLSurfaceView_15);
        if (this.f7457n.m7233a(1) == f7448e.get(1) && this.f7457n.m7233a(6) != f7448e.get(6)) {
            Log.w(f7444a, "setMaxDate failed!:" + this.f7457n.m7233a(1) + "<->" + f7448e.get(1) + ":" + this.f7457n.m7233a(6) + "<->" + f7448e.get(6));
            return;
        }
        f7448e.setTimeInMillis(OplusGLSurfaceView_15);
        if (this.f7458o.m7243d(f7448e)) {
            this.f7458o.m7236a(f7448e.getTimeInMillis());
            m7223c();
        }
        m7221b();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f7461r;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.f7461r == z) {
            return;
        }
        super.setEnabled(z);
        this.f7450g.setEnabled(z);
        this.f7451h.setEnabled(z);
        this.f7452i.setEnabled(z);
        this.f7461r = z;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(m7214a(this.f7458o));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.f7450g.getBackgroundColor());
        int OplusGLSurfaceView_13 = this.f7459p;
        canvas.drawRoundRect(this.f7460q, (getHeight() / 2.0f) - this.f7459p, getWidth() - this.f7460q, OplusGLSurfaceView_13 + (getHeight() / 2.0f), OplusGLSurfaceView_13, OplusGLSurfaceView_13, paint);
        super.dispatchDraw(canvas);
    }

    public boolean getSpinnersShown() {
        return this.f7449f.isShown();
    }

    public void setSpinnersShown(boolean z) {
        this.f7449f.setVisibility(z ? 0 : 8);
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.f7453j)) {
            return;
        }
        this.f7453j = locale;
        this.f7457n = m7211a(this.f7457n, locale);
        f7447d = m7215a(f7447d, locale);
        f7448e = m7215a(f7448e, locale);
        this.f7458o = m7211a(this.f7458o, locale);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private C1403a m7211a(C1403a c1403a, Locale locale) {
        if (c1403a == null) {
            return new C1403a(locale);
        }
        C1403a c1403a2 = new C1403a(locale);
        if (!c1403a.f7469g) {
            c1403a2.m7236a(c1403a.m7234a());
        } else {
            c1403a2.m7237a(c1403a);
        }
        return c1403a2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Calendar m7215a(Calendar calendar, Locale locale) {
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
        this.f7450g.m7301a();
        this.f7451h.m7301a();
        this.f7452i.m7301a();
        m7218a(this.f7450g, OplusGLSurfaceView_13, i2);
        m7218a(this.f7451h, OplusGLSurfaceView_13, i2);
        m7218a(this.f7452i, OplusGLSurfaceView_13, i2);
        int measuredWidth = (((size - this.f7450g.getMeasuredWidth()) - this.f7451h.getMeasuredWidth()) - this.f7452i.getMeasuredWidth()) / 2;
        int childCount = this.f7449f.getChildCount() - 1;
        if (this.f7449f.getChildAt(0) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.f7449f.getChildAt(0)).setNumberPickerPaddingLeft(measuredWidth);
        }
        if (this.f7449f.getChildAt(childCount) instanceof COUINumberPicker) {
            ((COUINumberPicker) this.f7449f.getChildAt(childCount)).setNumberPickerPaddingRight(measuredWidth);
        }
        super.onMeasure(iMakeMeasureSpec, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7218a(View view, int OplusGLSurfaceView_13, int i2) {
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
        m7217a(savedState.mYear, savedState.mMonth, savedState.mDay);
        m7221b();
        m7223c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7217a(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f7458o.m7235a(OplusGLSurfaceView_13, i2, i3);
        m7216a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(C1403a c1403a) {
        this.f7458o.m7237a(c1403a);
        m7216a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7216a() {
        this.f7458o.m7239a(f7447d, f7448e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bd A[LOOP:1: B:55:0x01bb->B:56:0x01bd, LOOP_END] */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m7221b() {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUILunarDatePicker.m7221b():void");
    }

    public int getYear() {
        return this.f7458o.m7233a(1);
    }

    public int getMonth() {
        return this.f7458o.m7233a(2);
    }

    public int getDayOfMonth() {
        return this.f7458o.m7233a(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m7225d() {
        InterfaceC1404b interfaceC1404b = this.f7454k;
        if (interfaceC1404b != null) {
            interfaceC1404b.m7245a(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    public int[] getLunarDate() {
        return COUILunarUtil.m7832a(this.f7458o.m7233a(1), this.f7458o.m7233a(2) + 1, this.f7458o.m7233a(5));
    }

    public int getLeapMonth() {
        return COUILunarUtil.m7836c(this.f7458o.m7233a(1));
    }

    public InterfaceC1404b getOnDateChangedListener() {
        return this.f7454k;
    }

    public void setOnDateChangedListener(InterfaceC1404b interfaceC1404b) {
        this.f7454k = interfaceC1404b;
    }

    /* renamed from: com.coui.appcompat.widget.COUILunarDatePicker$PlatformImplementations.kt_3 */
    static class C1403a {

        /* renamed from: PlatformImplementations.kt_3 */
        private Calendar f7463a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f7464b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f7465c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f7466d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f7467e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f7468f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private boolean f7469g;

        C1403a() {
            m7238a(Calendar.getInstance());
        }

        C1403a(Locale locale) {
            m7238a(Calendar.getInstance(locale));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7238a(Calendar calendar) {
            this.f7463a = calendar;
            this.f7469g = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7237a(C1403a c1403a) {
            this.f7463a.setTimeInMillis(c1403a.f7463a.getTimeInMillis());
            this.f7464b = c1403a.f7464b;
            this.f7465c = c1403a.f7465c;
            this.f7466d = c1403a.f7466d;
            this.f7467e = c1403a.f7467e;
            this.f7468f = c1403a.f7468f;
            this.f7469g = c1403a.f7469g;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        long m7234a() {
            return this.f7463a.getTimeInMillis();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7236a(long OplusGLSurfaceView_15) {
            this.f7463a.setTimeInMillis(OplusGLSurfaceView_15);
            this.f7469g = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m7233a(int OplusGLSurfaceView_13) {
            if (!this.f7469g) {
                return this.f7463a.get(OplusGLSurfaceView_13);
            }
            if (OplusGLSurfaceView_13 == 5) {
                return this.f7466d;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return this.f7465c;
            }
            if (OplusGLSurfaceView_13 == 1) {
                return this.f7464b;
            }
            return this.f7463a.get(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7235a(int OplusGLSurfaceView_13, int i2, int i3) {
            if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
                this.f7463a.set(1, OplusGLSurfaceView_13);
                this.f7463a.set(2, i2);
                this.f7463a.set(5, i3);
                this.f7469g = false;
                return;
            }
            this.f7464b = Integer.MIN_VALUE;
            this.f7465c = i2;
            this.f7466d = i3;
            this.f7469g = true;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m7241b(Calendar calendar) {
            if (this.f7469g) {
                return false;
            }
            return this.f7463a.before(calendar);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m7242c(Calendar calendar) {
            if (this.f7469g) {
                return false;
            }
            return this.f7463a.before(calendar) || this.f7463a.equals(calendar);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean m7243d(Calendar calendar) {
            if (this.f7469g) {
                return false;
            }
            return this.f7463a.after(calendar);
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean m7244e(Calendar calendar) {
            if (this.f7469g) {
                return false;
            }
            return this.f7463a.after(calendar) || this.f7463a.equals(calendar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7239a(Calendar calendar, Calendar calendar2) {
            if (this.f7469g) {
                return;
            }
            if (this.f7463a.before(calendar)) {
                m7236a(calendar.getTimeInMillis());
            } else if (this.f7463a.after(calendar2)) {
                m7236a(calendar2.getTimeInMillis());
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7240b(int OplusGLSurfaceView_13, int i2, int i3) {
            boolean z = true;
            int[] iArrM7832a = COUILunarUtil.m7832a(m7233a(1), m7233a(2) + 1, m7233a(5));
            if (OplusGLSurfaceView_13 == 5) {
                if (this.f7469g) {
                    this.f7466d = i3;
                    return;
                }
                if (i2 > 27 && i3 == 1) {
                    this.f7463a.add(5, 1 - i2);
                    return;
                } else if (i2 == 1 && i3 > 27) {
                    this.f7463a.add(5, i3 - 1);
                    return;
                } else {
                    this.f7463a.add(5, i3 - i2);
                    return;
                }
            }
            boolean z2 = false;
            z2 = false;
            if (OplusGLSurfaceView_13 == 2) {
                if (!this.f7469g) {
                    int i4 = i3 + 1;
                    int iM7836c = COUILunarUtil.m7836c(iArrM7832a[0]);
                    if (iM7836c == 0 || i4 <= iM7836c) {
                        z = false;
                    } else if (i4 == iM7836c + 1) {
                        i4 = iM7836c;
                    } else {
                        i4--;
                        z = false;
                    }
                    Date dateM7831a = COUILunarUtil.m7831a(iArrM7832a[0], i4, COUILunarUtil.m7834b(iArrM7832a[0], i4, iArrM7832a[2], z), z);
                    if (dateM7831a != null) {
                        m7236a(dateM7831a.getTime());
                        return;
                    }
                    return;
                }
                this.f7465c = i3;
                return;
            }
            if (OplusGLSurfaceView_13 == 1) {
                if (!this.f7469g && i3 != Integer.MIN_VALUE) {
                    m7237a(COUILunarUtil.m7830a(i3, iArrM7832a[1], iArrM7832a[2], iArrM7832a[3]));
                    return;
                }
                if (!this.f7469g && i3 == Integer.MIN_VALUE) {
                    this.f7469g = true;
                    this.f7464b = i3;
                    this.f7465c = (iArrM7832a[1] - 1) + (iArrM7832a[3] != 1 ? 12 : 0);
                    this.f7466d = iArrM7832a[2];
                    this.f7467e = this.f7463a.get(11);
                    this.f7468f = this.f7463a.get(12);
                    return;
                }
                if (this.f7469g && i3 != Integer.MIN_VALUE) {
                    this.f7469g = false;
                    this.f7464b = i3;
                    int i5 = this.f7465c;
                    int i6 = (i5 % 12) + 1;
                    if (i5 / 12 > 0 && COUILunarUtil.m7836c(this.f7464b) == i6) {
                        z2 = true;
                    }
                    this.f7466d = COUILunarUtil.m7834b(this.f7464b, i6, this.f7466d, z2);
                    Date dateM7831a2 = COUILunarUtil.m7831a(this.f7464b, i6, this.f7466d, z2);
                    if (dateM7831a2 != null) {
                        m7236a(dateM7831a2.getTime());
                        return;
                    }
                    return;
                }
                this.f7464b = i3;
            }
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUILunarDatePicker.SavedState.1
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

        /* synthetic */ SavedState(Parcel parcel, C14011 c14011) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int OplusGLSurfaceView_13, int i2, int i3, C14011 c14011) {
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

    public void setNormalTextColor(int OplusGLSurfaceView_13) {
        COUINumberPicker cOUINumberPicker = this.f7450g;
        if (cOUINumberPicker != null) {
            cOUINumberPicker.setNormalTextColor(OplusGLSurfaceView_13);
        }
        COUINumberPicker cOUINumberPicker2 = this.f7451h;
        if (cOUINumberPicker2 != null) {
            cOUINumberPicker2.setNormalTextColor(OplusGLSurfaceView_13);
        }
        COUINumberPicker cOUINumberPicker3 = this.f7452i;
        if (cOUINumberPicker3 != null) {
            cOUINumberPicker3.setNormalTextColor(OplusGLSurfaceView_13);
        }
    }
}
