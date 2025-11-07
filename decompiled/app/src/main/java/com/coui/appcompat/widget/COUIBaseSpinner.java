package com.coui.appcompat.widget;

import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.ViewUtils_2;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;
import com.coui.appcompat.p099a.COUITintManager;
import com.coui.appcompat.widget.COUIAdapterView;
import com.coui.appcompat.widget.COUIAbsSpinner;
import com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow;
import com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow;
import com.coui.appcompat.widget.popupwindow.COUIListPopupWindow;

/* loaded from: classes.dex */
class COUIBaseSpinner extends COUIAbsSpinner implements DialogInterface.OnClickListener {

    /* renamed from: E */
    protected COUIBaseListPopupWindow.IntrinsicsJvm.kt_3 f7099E;

    /* renamed from: F */
    InterfaceC1354c f7100F;

    /* renamed from: G */
    int f7101G;

    /* renamed from: H */
    private C1352a f7102H;

    /* renamed from: I */
    private int f7103I;

    /* renamed from: J */
    private boolean f7104J;

    /* renamed from: K */
    private Rect f7105K;

    /* renamed from: L */
    private final COUITintManager f7106L;

    /* renamed from: com.coui.appcompat.widget.COUIBaseSpinner$IntrinsicsJvm.kt_3 */
    interface InterfaceC1354c {
        /* renamed from: PlatformImplementations.kt_3 */
        CharSequence mo6979a();

        /* renamed from: PlatformImplementations.kt_3 */
        void m6985a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo6980a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo6981a(ListAdapter listAdapter);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo6982a(CharSequence charSequence);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m6986b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo6987c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean m6988d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        Drawable m6989e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        int m6990f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        int m6991g();
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC1354c interfaceC1354c = this.f7100F;
        if (!(interfaceC1354c instanceof C1353b)) {
            Log.COUIBaseListPopupWindow_8("COUIBaseSpinner", "setPopupBackgroundDrawable: incompatible spinner mode; ignoring...");
        } else {
            ((C1353b) interfaceC1354c).m8029a(drawable);
        }
    }

    public void setPopupBackgroundResource(int OplusGLSurfaceView_13) {
        setPopupBackgroundDrawable(this.f7106L.m6491a(OplusGLSurfaceView_13));
    }

    public Drawable getPopupBackground() {
        return this.f7100F.m6989e();
    }

    public void setDropDownVerticalOffset(int OplusGLSurfaceView_13) {
        this.f7100F.m6985a(OplusGLSurfaceView_13);
    }

    public int getDropDownVerticalOffset() {
        return this.f7100F.m6990f();
    }

    public void setDropDownHorizontalOffset(int OplusGLSurfaceView_13) {
        this.f7100F.m6986b(OplusGLSurfaceView_13);
    }

    public int getDropDownHorizontalOffset() {
        return this.f7100F.m6991g();
    }

    public void setDropDownWidth(int OplusGLSurfaceView_13) {
        if (!(this.f7100F instanceof C1353b)) {
            Log.COUIBaseListPopupWindow_8("COUIBaseSpinner", "Cannot set dropdown width for MODE_DIALOG, ignoring");
        } else {
            this.f7101G = OplusGLSurfaceView_13;
        }
    }

    public int getDropDownWidth() {
        return this.f7101G;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f7104J) {
            int childCount = getChildCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                getChildAt(OplusGLSurfaceView_13).setEnabled(z);
            }
        }
    }

    public void setGravity(int OplusGLSurfaceView_13) {
        if (this.f7103I != OplusGLSurfaceView_13) {
            if ((OplusGLSurfaceView_13 & 7) == 0) {
                OplusGLSurfaceView_13 |= 8388611;
            }
            this.f7103I = OplusGLSurfaceView_13;
            requestLayout();
        }
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.COUIAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        this.f7096i.m6969a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != 1) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        }
        InterfaceC1354c interfaceC1354c = this.f7100F;
        if (interfaceC1354c != null) {
            interfaceC1354c.mo6981a(new C1352a(spinnerAdapter));
        } else {
            this.f7102H = new C1352a(spinnerAdapter);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        View childAt;
        int baseline;
        if (getChildCount() > 0) {
            childAt = getChildAt(0);
        } else if (this.f7088a == null || this.f7088a.getCount() <= 0) {
            childAt = null;
        } else {
            View viewM6973c = m6973c(0, false);
            this.f7096i.m6970a(0, viewM6973c);
            childAt = viewM6973c;
        }
        if (childAt == null || (baseline = childAt.getBaseline()) < 0) {
            return -1;
        }
        return childAt.getTop() + baseline;
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC1354c interfaceC1354c = this.f7100F;
        if (interfaceC1354c == null || !interfaceC1354c.m6988d()) {
            return;
        }
        this.f7100F.mo6987c();
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView
    public void setOnItemClickListener(COUIAdapterView.IntrinsicsJvm.kt_4 bVar) {
        throw new RuntimeException("setOnItemClickListener cannot be used with PlatformImplementations.kt_3 spinner.");
    }

    void setOnItemClickListenerInt(COUIAdapterView.IntrinsicsJvm.kt_4 bVar) {
        super.setOnItemClickListener(bVar);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        COUIBaseListPopupWindow.IntrinsicsJvm.kt_3 cVar = this.f7099E;
        if (cVar == null || !cVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f7100F == null || View.MeasureSpec.getMode(OplusGLSurfaceView_13) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), mo6974a(getAdapter(), getBackground())), View.MeasureSpec.getSize(OplusGLSurfaceView_13)), getMeasuredHeight());
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f7936q = true;
        mo6962a(0, false);
        this.f7936q = false;
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner
    /* renamed from: PlatformImplementations.kt_3 */
    void mo6962a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        int i3 = this.f7095h.left;
        int right = ((getRight() - getLeft()) - this.f7095h.left) - this.f7095h.right;
        if (this.f7940u) {
            m7533f();
        }
        if (this.f7945z == 0) {
            m6961a();
            return;
        }
        if (this.f7941v >= 0) {
            setSelectedPositionInt(this.f7941v);
        }
        m6964b();
        removeAllViewsInLayout();
        this.f7929j = this.f7943x;
        if (this.f7088a != null) {
            View viewM6973c = m6973c(this.f7943x, true);
            int measuredWidth = viewM6973c.getMeasuredWidth();
            int iM2773a = GravityCompat.m2773a(this.f7103I, ViewCompat.m2885g(this)) & 7;
            if (iM2773a == 1) {
                i2 = i3 + (right / 2);
                measuredWidth /= 2;
            } else {
                if (iM2773a == 5) {
                    i2 = i3 + right;
                }
                viewM6973c.offsetLeftAndRight(i3);
            }
            i3 = i2 - measuredWidth;
            viewM6973c.offsetLeftAndRight(i3);
        }
        this.f7096i.m6969a();
        invalidate();
        m7534g();
        this.f7940u = false;
        this.f7934o = false;
        setNextSelectedPositionInt(this.f7943x);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View m6973c(int OplusGLSurfaceView_13, boolean z) {
        View viewM6968a;
        if (!this.f7940u && (viewM6968a = this.f7096i.m6968a(OplusGLSurfaceView_13)) != null) {
            m6972a(viewM6968a, z);
            return viewM6968a;
        }
        View view = this.f7088a.getView(OplusGLSurfaceView_13, null, this);
        m6972a(view, z);
        return view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6972a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (z) {
            addViewInLayout(view, 0, layoutParams);
        }
        view.setSelected(hasFocus());
        if (this.f7104J) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.f7090c, this.f7095h.left + this.f7095h.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.f7089b, this.f7095h.top + this.f7095h.bottom, layoutParams.height));
        int measuredHeight = this.f7095h.top + ((((getMeasuredHeight() - this.f7095h.bottom) - this.f7095h.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (!zPerformClick) {
            zPerformClick = true;
            if (!this.f7100F.m6988d()) {
                this.f7100F.mo6980a(getTextDirection(), COUIViewCompat.m8183a(this));
            }
        }
        return zPerformClick;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
        setSelection(OplusGLSurfaceView_13);
        dialogInterface.dismiss();
    }

    public void setPrompt(CharSequence charSequence) {
        this.f7100F.mo6982a(charSequence);
    }

    public void setPromptId(int OplusGLSurfaceView_13) {
        setPrompt(getContext().getText(OplusGLSurfaceView_13));
    }

    public CharSequence getPrompt() {
        return this.f7100F.mo6979a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int mo6974a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int OplusGLSurfaceView_13 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
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
        drawable.getPadding(this.f7105K);
        return iMax2 + this.f7105K.left + this.f7105K.right;
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        InterfaceC1354c interfaceC1354c = this.f7100F;
        savedState.showDropdown = interfaceC1354c != null && interfaceC1354c.m6988d();
        return savedState;
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.showDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.widget.COUIBaseSpinner.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!COUIBaseSpinner.this.f7100F.m6988d()) {
                    COUIBaseSpinner.this.f7100F.mo6980a(COUIBaseSpinner.this.getTextDirection(), COUIViewCompat.m8183a(COUIBaseSpinner.this));
                }
                ViewTreeObserver viewTreeObserver2 = COUIBaseSpinner.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    viewTreeObserver2.removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    static class SavedState extends COUIAbsSpinner.SavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.widget.COUIBaseSpinner.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

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
        boolean showDropdown;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.showDropdown = parcel.readByte() != 0;
        }

        @Override // com.coui.appcompat.widget.COUIAbsSpinner.SavedState, androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeByte(this.showDropdown ? (byte) 1 : (byte) 0);
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUIBaseSpinner$PlatformImplementations.kt_3 */
    private static class C1352a implements ListAdapter, SpinnerAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        private SpinnerAdapter f7108a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ListAdapter f7109b;

        @Override // android.widget.Adapter
        public int getItemViewType(int OplusGLSurfaceView_13) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public C1352a(SpinnerAdapter spinnerAdapter) {
            this.f7108a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f7109b = (ListAdapter) spinnerAdapter;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f7108a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int OplusGLSurfaceView_13) {
            SpinnerAdapter spinnerAdapter = this.f7108a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            SpinnerAdapter spinnerAdapter = this.f7108a;
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
            SpinnerAdapter spinnerAdapter = this.f7108a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(OplusGLSurfaceView_13, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f7108a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7108a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7108a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f7109b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int OplusGLSurfaceView_13) {
            ListAdapter listAdapter = this.f7109b;
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

    /* renamed from: com.coui.appcompat.widget.COUIBaseSpinner$IntrinsicsJvm.kt_4 */
    class C1353b extends COUIListPopupWindow implements InterfaceC1354c {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIBaseSpinner f7110a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private CharSequence f7111b;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private ListAdapter f7112e;

        @Override // com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow, com.coui.appcompat.widget.COUIBaseSpinner.InterfaceC1354c
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6981a(ListAdapter listAdapter) {
            super.mo6981a(listAdapter);
            this.f7112e = listAdapter;
        }

        @Override // com.coui.appcompat.widget.COUIBaseSpinner.InterfaceC1354c
        /* renamed from: PlatformImplementations.kt_3 */
        public CharSequence mo6979a() {
            return this.f7111b;
        }

        @Override // com.coui.appcompat.widget.COUIBaseSpinner.InterfaceC1354c
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6982a(CharSequence charSequence) {
            this.f7111b = charSequence;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m6983b() {
            Drawable drawableE = m8035e();
            int OplusGLSurfaceView_13 = 0;
            if (drawableE != null) {
                drawableE.getPadding(this.f7110a.f7105K);
                OplusGLSurfaceView_13 = ViewUtils_2.m1623a(this.f7110a) ? this.f7110a.f7105K.right : -this.f7110a.f7105K.left;
            } else {
                Rect rect = this.f7110a.f7105K;
                this.f7110a.f7105K.right = 0;
                rect.left = 0;
            }
            int paddingLeft = this.f7110a.getPaddingLeft();
            int paddingRight = this.f7110a.getPaddingRight();
            int width = this.f7110a.getWidth();
            if (this.f7110a.f7101G == -2) {
                int iMo6974a = this.f7110a.mo6974a((SpinnerAdapter) this.f7112e, m8035e());
                int i2 = (this.f7110a.getContext().getResources().getDisplayMetrics().widthPixels - this.f7110a.f7105K.left) - this.f7110a.f7105K.right;
                if (iMo6974a > i2) {
                    iMo6974a = i2;
                }
                m8033d(Math.max(iMo6974a, (width - paddingLeft) - paddingRight));
            } else if (this.f7110a.f7101G == -1) {
                m8033d((width - paddingLeft) - paddingRight);
            } else {
                m8033d(this.f7110a.f7101G);
            }
            m8031b(ViewUtils_2.m1623a(this.f7110a) ? OplusGLSurfaceView_13 + ((width - paddingRight) - m8042m()) : OplusGLSurfaceView_13 + paddingLeft);
        }

        @Override // com.coui.appcompat.widget.COUIBaseSpinner.InterfaceC1354c
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6980a(int OplusGLSurfaceView_13, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean zD = m8034d();
            m6983b();
            m8038f(2);
            super.mo8014h();
            ListView listViewP = m8045p();
            listViewP.setChoiceMode(1);
            COUIViewCompat.m8184a(listViewP, i2);
            m8040g(this.f7110a.getSelectedItemPosition());
            if (zD || (viewTreeObserver = this.f7110a.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.widget.COUIBaseSpinner.IntrinsicsJvm.kt_4.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!COUIViewCompat.m8186c(C1353b.this.f7110a)) {
                        C1353b.this.mo6987c();
                    } else {
                        C1353b.this.m6983b();
                        C1353b.super.mo8014h();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            m8030a(new COUIBasePopupWindow.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.widget.COUIBaseSpinner.IntrinsicsJvm.kt_4.2
                @Override // com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6984a() {
                    ViewTreeObserver viewTreeObserver2 = C1353b.this.f7110a.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }
    }
}
