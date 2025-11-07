package com.coui.appcompat.widget;

import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.customview.view.AbsSavedState;
import com.coui.appcompat.widget.COUIAdapterView;

/* loaded from: classes.dex */
abstract class COUIAbsSpinner extends COUIAdapterView<SpinnerAdapter> {

    /* renamed from: E */
    private DataSetObserver f7087E;

    /* renamed from: PlatformImplementations.kt_3 */
    SpinnerAdapter f7088a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f7089b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f7090c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f7091d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f7092e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f7093f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    int f7094g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    final Rect f7095h;

    /* renamed from: OplusGLSurfaceView_13 */
    final C1349a f7096i;

    /* renamed from: PlatformImplementations.kt_3 */
    abstract void mo6962a(int OplusGLSurfaceView_13, boolean z);

    @Override // com.coui.appcompat.widget.COUIAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        SpinnerAdapter spinnerAdapter2 = this.f7088a;
        if (spinnerAdapter2 != null) {
            spinnerAdapter2.unregisterDataSetObserver(this.f7087E);
            m6961a();
        }
        this.f7088a = spinnerAdapter;
        this.f7921B = -1;
        this.f7922C = Long.MIN_VALUE;
        if (this.f7088a != null) {
            this.f7920A = this.f7945z;
            this.f7945z = this.f7088a.getCount();
            m7531d();
            this.f7087E = new COUIAdapterView.PlatformImplementations.kt_3();
            this.f7088a.registerDataSetObserver(this.f7087E);
            int OplusGLSurfaceView_13 = this.f7945z > 0 ? 0 : -1;
            setSelectedPositionInt(OplusGLSurfaceView_13);
            setNextSelectedPositionInt(OplusGLSurfaceView_13);
            if (this.f7945z == 0) {
                m7534g();
            }
        } else {
            m7531d();
            m6961a();
            m7534g();
        }
        requestLayout();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m6961a() {
        this.f7940u = false;
        this.f7934o = false;
        removeAllViewsInLayout();
        this.f7921B = -1;
        this.f7922C = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r8)
            int r1 = r7.getPaddingLeft()
            int r2 = r7.getPaddingTop()
            int r3 = r7.getPaddingRight()
            int r4 = r7.getPaddingBottom()
            android.graphics.Rect r5 = r7.f7095h
            int r6 = r7.f7091d
            if (r1 <= r6) goto L1b
            goto L1c
        L1b:
            r1 = r6
        L1c:
            r5.left = r1
            android.graphics.Rect r1 = r7.f7095h
            int r5 = r7.f7092e
            if (r2 <= r5) goto L25
            goto L26
        L25:
            r2 = r5
        L26:
            r1.top = r2
            android.graphics.Rect r1 = r7.f7095h
            int r2 = r7.f7093f
            if (r3 <= r2) goto L2f
            r2 = r3
        L2f:
            r1.right = r2
            android.graphics.Rect r1 = r7.f7095h
            int r2 = r7.f7094g
            if (r4 <= r2) goto L38
            r2 = r4
        L38:
            r1.bottom = r2
            boolean r1 = r7.f7940u
            if (r1 == 0) goto L41
            r7.m7533f()
        L41:
            int r1 = r7.getSelectedItemPosition()
            r2 = 1
            r3 = 0
            if (r1 < 0) goto L9c
            android.widget.SpinnerAdapter r4 = r7.f7088a
            if (r4 == 0) goto L9c
            int r4 = r4.getCount()
            if (r1 >= r4) goto L9c
            com.coui.appcompat.widget.COUIAbsSpinner$PlatformImplementations.kt_3 r4 = r7.f7096i
            android.view.View r4 = r4.m6968a(r1)
            if (r4 != 0) goto L62
            android.widget.SpinnerAdapter r4 = r7.f7088a
            r5 = 0
            android.view.View r4 = r4.getView(r1, r5, r7)
        L62:
            if (r4 == 0) goto L9c
            com.coui.appcompat.widget.COUIAbsSpinner$PlatformImplementations.kt_3 r5 = r7.f7096i
            r5.m6970a(r1, r4)
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            if (r1 != 0) goto L7a
            r7.f7923D = r2
            android.view.ViewGroup$LayoutParams r1 = r7.generateDefaultLayoutParams()
            r4.setLayoutParams(r1)
            r7.f7923D = r3
        L7a:
            r7.measureChild(r4, r8, r9)
            int r1 = r7.m6960a(r4)
            android.graphics.Rect r2 = r7.f7095h
            int r2 = r2.top
            int r1 = r1 + r2
            android.graphics.Rect r2 = r7.f7095h
            int r2 = r2.bottom
            int r1 = r1 + r2
            int r2 = r7.m6963b(r4)
            android.graphics.Rect r4 = r7.f7095h
            int r4 = r4.left
            int r2 = r2 + r4
            android.graphics.Rect r4 = r7.f7095h
            int r4 = r4.right
            int r2 = r2 + r4
            r4 = r2
            r2 = r3
            goto L9e
        L9c:
            r1 = r3
            r4 = r1
        L9e:
            if (r2 == 0) goto Lb5
            android.graphics.Rect r1 = r7.f7095h
            int r1 = r1.top
            android.graphics.Rect r2 = r7.f7095h
            int r2 = r2.bottom
            int r1 = r1 + r2
            if (r0 != 0) goto Lb5
            android.graphics.Rect r0 = r7.f7095h
            int r0 = r0.left
            android.graphics.Rect r2 = r7.f7095h
            int r2 = r2.right
            int r4 = r0 + r2
        Lb5:
            int r0 = r7.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = r7.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r4, r1)
            int r0 = androidx.core.p036h.ViewCompat.m2837a(r0, r9, r3)
            int r1 = androidx.core.p036h.ViewCompat.m2837a(r1, r8, r3)
            r7.setMeasuredDimension(r1, r0)
            r7.f7089b = r9
            r7.f7090c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUIAbsSpinner.onMeasure(int, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m6960a(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    int m6963b(View view) {
        return view.getMeasuredWidth();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m6964b() {
        int childCount = getChildCount();
        C1349a c1349a = this.f7096i;
        int OplusGLSurfaceView_13 = this.f7929j;
        for (int i2 = 0; i2 < childCount; i2++) {
            c1349a.m6970a(OplusGLSurfaceView_13 + i2, getChildAt(i2));
        }
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView
    public void setSelection(int OplusGLSurfaceView_13) {
        setNextSelectedPositionInt(OplusGLSurfaceView_13);
        requestLayout();
        invalidate();
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView
    public View getSelectedView() {
        if (this.f7945z <= 0 || this.f7943x < 0) {
            return null;
        }
        return getChildAt(this.f7943x - this.f7929j);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f7923D) {
            return;
        }
        super.requestLayout();
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView
    public SpinnerAdapter getAdapter() {
        return this.f7088a;
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView
    public int getCount() {
        return this.f7945z;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.widget.COUIAbsSpinner.SavedState.1
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
        int position;
        long selectedId;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.selectedId = getSelectedItemId();
        if (savedState.selectedId >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.selectedId >= 0) {
            this.f7940u = true;
            this.f7934o = true;
            this.f7932m = savedState.selectedId;
            this.f7931l = savedState.position;
            this.f7935p = 0;
            requestLayout();
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUIAbsSpinner$PlatformImplementations.kt_3 */
    class C1349a {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUIAbsSpinner f7097a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final SparseArray<View> f7098b;

        /* renamed from: PlatformImplementations.kt_3 */
        public void m6970a(int OplusGLSurfaceView_13, View view) {
            this.f7098b.put(OplusGLSurfaceView_13, view);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        View m6968a(int OplusGLSurfaceView_13) {
            View view = this.f7098b.get(OplusGLSurfaceView_13);
            if (view != null) {
                this.f7098b.delete(OplusGLSurfaceView_13);
            }
            return view;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m6969a() {
            SparseArray<View> sparseArray = this.f7098b;
            int size = sparseArray.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                View viewValueAt = sparseArray.valueAt(OplusGLSurfaceView_13);
                if (viewValueAt != null) {
                    this.f7097a.removeDetachedView(viewValueAt, true);
                }
            }
            sparseArray.clear();
        }
    }
}
