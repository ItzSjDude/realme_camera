package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.TintableBackgroundView;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f1575c = {R.attr.spinnerMode};

    /* renamed from: PlatformImplementations.kt_3 */
    int f1576a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Rect f1577b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AppCompatBackgroundHelper f1578d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Context f1579e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ForwardingListener f1580f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SpinnerAdapter f1581g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final boolean f1582h;

    /* renamed from: OplusGLSurfaceView_13 */
    private InterfaceC0275d f1583i;

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$IntrinsicsJvm.kt_5 */
    interface InterfaceC0275d {
        /* renamed from: PlatformImplementations.kt_3 */
        CharSequence mo1307a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo1308a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo1309a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo1310a(Drawable drawable);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo1311a(ListAdapter listAdapter);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo1312a(CharSequence charSequence);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo1313b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo1314b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo1315c(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean mo1316c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        Drawable mo1317d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        int mo1318e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        int mo1319f();
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        this(context, attributeSet, OplusGLSurfaceView_13, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[PHI: r10 r11
      0x004a: PHI (r10v2 int) = (r10v0 int), (r10v4 int) binds: [B:24:0x005c, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r11v9 android.content.res.TypedArray) = (r11v8 android.content.res.TypedArray), (r11v11 android.content.res.TypedArray) binds: [B:24:0x005c, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1579e;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            interfaceC0275d.mo1310a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int OplusGLSurfaceView_13) {
        setPopupBackgroundDrawable(AppCompatResources.m732b(getPopupContext(), OplusGLSurfaceView_13));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            return interfaceC0275d.mo1317d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int OplusGLSurfaceView_13) {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            interfaceC0275d.mo1308a(OplusGLSurfaceView_13);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            return interfaceC0275d.mo1318e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int OplusGLSurfaceView_13) {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            interfaceC0275d.mo1315c(OplusGLSurfaceView_13);
            this.f1583i.mo1314b(OplusGLSurfaceView_13);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            return interfaceC0275d.mo1319f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int OplusGLSurfaceView_13) {
        if (this.f1583i != null) {
            this.f1576a = OplusGLSurfaceView_13;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f1583i != null) {
            return this.f1576a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1582h) {
            this.f1581g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1583i != null) {
            Context context = this.f1579e;
            if (context == null) {
                context = getContext();
            }
            this.f1583i.mo1311a(new C0273b(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d == null || !interfaceC0275d.mo1316c()) {
            return;
        }
        this.f1583i.mo1313b();
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener abstractViewOnAttachStateChangeListenerC0308ad = this.f1580f;
        if (abstractViewOnAttachStateChangeListenerC0308ad == null || !abstractViewOnAttachStateChangeListenerC0308ad.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f1583i == null || View.MeasureSpec.getMode(OplusGLSurfaceView_13) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m1303a(getAdapter(), getBackground())), View.MeasureSpec.getSize(OplusGLSurfaceView_13)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            if (interfaceC0275d.mo1316c()) {
                return true;
            }
            m1304a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        if (interfaceC0275d != null) {
            interfaceC0275d.mo1312a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterfaceC0275d interfaceC0275d = this.f1583i;
        return interfaceC0275d != null ? interfaceC0275d.mo1307a() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int OplusGLSurfaceView_13) {
        super.setBackgroundResource(OplusGLSurfaceView_13);
        AppCompatBackgroundHelper c0333e = this.f1578d;
        if (c0333e != null) {
            c0333e.m1647a(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper c0333e = this.f1578d;
        if (c0333e != null) {
            c0333e.m1650a(drawable);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper c0333e = this.f1578d;
        if (c0333e != null) {
            c0333e.m1648a(colorStateList);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper c0333e = this.f1578d;
        if (c0333e != null) {
            return c0333e.m1646a();
        }
        return null;
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper c0333e = this.f1578d;
        if (c0333e != null) {
            c0333e.m1649a(mode);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper c0333e = this.f1578d;
        if (c0333e != null) {
            return c0333e.m1652b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper c0333e = this.f1578d;
        if (c0333e != null) {
            c0333e.m1654c();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m1303a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int OplusGLSurfaceView_13 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        int iMax2 = 0;
        View view = null;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != OplusGLSurfaceView_13) {
                view = null;
                OplusGLSurfaceView_13 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f1577b);
        return iMax2 + this.f1577b.left + this.f1577b.right;
    }

    final InterfaceC0275d getInternalPopup() {
        return this.f1583i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1304a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1583i.mo1309a(getTextDirection(), getTextAlignment());
        } else {
            this.f1583i.mo1309a(-1, -1);
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        InterfaceC0275d interfaceC0275d = this.f1583i;
        savedState.mShowDropdown = interfaceC0275d != null && interfaceC0275d.mo1316c();
        return savedState;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.mShowDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!AppCompatSpinner.this.getInternalPopup().mo1316c()) {
                    AppCompatSpinner.this.m1304a();
                }
                ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver2.removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.AppCompatSpinner.SavedState.1
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
        boolean mShowDropdown;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.mShowDropdown = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$IntrinsicsJvm.kt_4 */
    private static class C0273b implements ListAdapter, SpinnerAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        private SpinnerAdapter f1591a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ListAdapter f1592b;

        @Override // android.widget.Adapter
        public int getItemViewType(int OplusGLSurfaceView_13) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public C0273b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1591a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1592b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter interfaceC0318an = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (interfaceC0318an.m1534a() == null) {
                        interfaceC0318an.m1535a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1591a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int OplusGLSurfaceView_13) {
            SpinnerAdapter spinnerAdapter = this.f1591a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            SpinnerAdapter spinnerAdapter = this.f1591a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            return getDropDownView(OplusGLSurfaceView_13, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1591a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(OplusGLSurfaceView_13, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1591a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1591a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1591a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1592b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int OplusGLSurfaceView_13) {
            ListAdapter listAdapter = this.f1592b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(OplusGLSurfaceView_13);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$PlatformImplementations.kt_3 */
    class DialogInterfaceOnClickListenerC0272a implements DialogInterface.OnClickListener, InterfaceC0275d {

        /* renamed from: PlatformImplementations.kt_3 */
        AlertDialog f1587a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private ListAdapter f1589c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private CharSequence f1590d;

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: IntrinsicsJvm.kt_5 */
        public Drawable mo1317d() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: COUIBaseListPopupWindow_8 */
        public int mo1318e() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: COUIBaseListPopupWindow_12 */
        public int mo1319f() {
            return 0;
        }

        DialogInterfaceOnClickListenerC0272a() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo1313b() {
            AlertDialog dialogInterfaceC0204b = this.f1587a;
            if (dialogInterfaceC0204b != null) {
                dialogInterfaceC0204b.dismiss();
                this.f1587a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo1316c() {
            AlertDialog dialogInterfaceC0204b = this.f1587a;
            if (dialogInterfaceC0204b != null) {
                return dialogInterfaceC0204b.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1311a(ListAdapter listAdapter) {
            this.f1589c = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1312a(CharSequence charSequence) {
            this.f1590d = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public CharSequence mo1307a() {
            return this.f1590d;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1309a(int OplusGLSurfaceView_13, int i2) {
            if (this.f1589c == null) {
                return;
            }
            AlertDialog.PlatformImplementations.kt_3 aVar = new AlertDialog.PlatformImplementations.kt_3(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f1590d;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            this.f1587a = aVar.setSingleChoiceItems(this.f1589c, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            ListView listViewMo902a = this.f1587a.mo902a();
            if (Build.VERSION.SDK_INT >= 17) {
                listViewMo902a.setTextDirection(OplusGLSurfaceView_13);
                listViewMo902a.setTextAlignment(i2);
            }
            this.f1587a.show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
            AppCompatSpinner.this.setSelection(OplusGLSurfaceView_13);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, OplusGLSurfaceView_13, this.f1589c.getItemId(OplusGLSurfaceView_13));
            }
            mo1313b();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1310a(Drawable drawable) {
            Log.COUIBaseListPopupWindow_8("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1308a(int OplusGLSurfaceView_13) {
            Log.COUIBaseListPopupWindow_8("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo1314b(int OplusGLSurfaceView_13) {
            Log.COUIBaseListPopupWindow_8("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo1315c(int OplusGLSurfaceView_13) {
            Log.COUIBaseListPopupWindow_8("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$IntrinsicsJvm.kt_3 */
    class C0274c extends ListPopupWindow implements InterfaceC0275d {

        /* renamed from: PlatformImplementations.kt_3 */
        ListAdapter f1593a;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private CharSequence f1595h;

        /* renamed from: OplusGLSurfaceView_13 */
        private final Rect f1596i;

        /* renamed from: OplusGLSurfaceView_15 */
        private int f1597j;

        public C0274c(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
            super(context, attributeSet, OplusGLSurfaceView_13);
            this.f1596i = new Rect();
            m1432b(AppCompatSpinner.this);
            m1430a(true);
            m1435d(0);
            m1428a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.IntrinsicsJvm.kt_3.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, C0274c.this.f1593a.getItemId(i2));
                    }
                    C0274c.this.mo1137b();
                }
            });
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1311a(ListAdapter listAdapter) {
            super.mo1311a(listAdapter);
            this.f1593a = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public CharSequence mo1307a() {
            return this.f1595h;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1312a(CharSequence charSequence) {
            this.f1595h = charSequence;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        void m1322g() {
            int iM1323h;
            Drawable drawableD = m1434d();
            int OplusGLSurfaceView_13 = 0;
            if (drawableD != null) {
                drawableD.getPadding(AppCompatSpinner.this.f1577b);
                OplusGLSurfaceView_13 = ViewUtils_2.m1623a(AppCompatSpinner.this) ? AppCompatSpinner.this.f1577b.right : -AppCompatSpinner.this.f1577b.left;
            } else {
                Rect rect = AppCompatSpinner.this.f1577b;
                AppCompatSpinner.this.f1577b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f1576a == -2) {
                int iM1303a = AppCompatSpinner.this.m1303a((SpinnerAdapter) this.f1593a, m1434d());
                int i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.f1577b.left) - AppCompatSpinner.this.f1577b.right;
                if (iM1303a > i2) {
                    iM1303a = i2;
                }
                m1441h(Math.max(iM1303a, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.f1576a == -1) {
                m1441h((width - paddingLeft) - paddingRight);
            } else {
                m1441h(AppCompatSpinner.this.f1576a);
            }
            if (ViewUtils_2.m1623a(AppCompatSpinner.this)) {
                iM1323h = OplusGLSurfaceView_13 + (((width - paddingRight) - m1446k()) - m1323h());
            } else {
                iM1323h = OplusGLSurfaceView_13 + paddingLeft + m1323h();
            }
            m1431b(iM1323h);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1309a(int OplusGLSurfaceView_13, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ViewTreeObserver viewTreeObserver;
            boolean zC = mo1142c();
            m1322g();
            m1442i(2);
            super.mo1136a_();
            ListView listViewB_ = mo1140b_();
            listViewB_.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listViewB_.setTextDirection(OplusGLSurfaceView_13);
                listViewB_.setTextAlignment(i2);
            }
            m1445j(AppCompatSpinner.this.getSelectedItemPosition());
            if (zC || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.IntrinsicsJvm.kt_3.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    C0274c c0274c = C0274c.this;
                    if (!c0274c.m1321a(AppCompatSpinner.this)) {
                        C0274c.this.mo1137b();
                    } else {
                        C0274c.this.m1322g();
                        C0274c.super.mo1136a_();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            m1429a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.IntrinsicsJvm.kt_3.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m1321a(View view) {
            return ViewCompat.m2826D(view) && view.getGlobalVisibleRect(this.f1596i);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0275d
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo1315c(int OplusGLSurfaceView_13) {
            this.f1597j = OplusGLSurfaceView_13;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int m1323h() {
            return this.f1597j;
        }
    }
}
