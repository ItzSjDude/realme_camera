package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.WrapperListAdapter;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class FooterGridView extends GridView {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f16273a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f16274b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f16275c;

    public FooterGridView(Context context) {
        super(context);
        this.f16273a = false;
        this.f16274b = null;
        this.f16275c = true;
    }

    public FooterGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16273a = false;
        this.f16274b = null;
        this.f16275c = true;
    }

    public FooterGridView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f16273a = false;
        this.f16274b = null;
        this.f16275c = true;
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        if (this.f16275c) {
            int width = getWidth();
            int height = getHeight();
            if (this.f16274b == null) {
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, height, getResources().getColor(R.color.sticker_gradient_start_color), getResources().getColor(R.color.sticker_gradient_end_color), Shader.TileMode.CLAMP);
                this.f16274b = new Paint();
                this.f16274b.setShader(linearGradient);
            }
            canvas.drawRect(0.0f, 0.0f, width, height, this.f16274b);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("FooterGridView", "onMeasure");
        this.f16273a = true;
        super.onMeasure(OplusGLSurfaceView_13, i2);
        ListAdapter adapter = getAdapter();
        if (adapter == null || !(adapter instanceof C3005a)) {
            return;
        }
        C3005a c3005a = (C3005a) adapter;
        c3005a.m16994a(getNumColumns());
        c3005a.m16995b(getRowHeight());
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CameraLog.m12954a("FooterGridView", "onLayout");
        this.f16273a = false;
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        C3005a c3005a = new C3005a(baseAdapter);
        int numColumns = getNumColumns();
        if (numColumns > 1) {
            c3005a.m16994a(numColumns);
        }
        super.setAdapter((ListAdapter) c3005a);
    }

    public void setDrawForeground(boolean z) {
        this.f16275c = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getRowHeight() {
        /*
            r4 = this;
            android.widget.ListAdapter r0 = r4.getAdapter()
            r1 = 0
            if (r0 == 0) goto L1c
            boolean r2 = r0 instanceof com.oplus.camera.sticker.p168ui.FooterGridView.C3005a
            if (r2 == 0) goto L1c
            com.oplus.camera.sticker.ui.FooterGridView$PlatformImplementations.kt_3 r0 = (com.oplus.camera.sticker.p168ui.FooterGridView.C3005a) r0
            android.widget.ListAdapter r2 = r0.getWrappedAdapter()
            if (r2 == 0) goto L1c
            android.widget.ListAdapter r0 = r0.getWrappedAdapter()
            int r0 = r0.getCount()
            goto L1d
        L1c:
            r0 = r1
        L1d:
            if (r0 <= 0) goto L4f
            android.widget.ListAdapter r2 = r4.getAdapter()
            int r0 = r0 + (-1)
            r3 = 0
            android.view.View r0 = r2.getView(r0, r3, r4)
            if (r0 == 0) goto L4f
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            android.widget.AbsListView$LayoutParams r2 = (android.widget.AbsListView.LayoutParams) r2
            if (r2 != 0) goto L3e
            android.view.ViewGroup$LayoutParams r4 = r4.generateDefaultLayoutParams()
            r2 = r4
            android.widget.AbsListView$LayoutParams r2 = (android.widget.AbsListView.LayoutParams) r2
            r0.setLayoutParams(r2)
        L3e:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r1)
            int r2 = r2.height
            int r4 = getChildMeasureSpec(r4, r1, r2)
            r0.measure(r1, r4)
            int r1 = r0.getMeasuredHeight()
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p168ui.FooterGridView.getRowHeight():int");
    }

    /* renamed from: com.oplus.camera.sticker.ui.FooterGridView$PlatformImplementations.kt_3 */
    private class C3005a implements Filterable, WrapperListAdapter {

        /* renamed from: IntrinsicsJvm.kt_3 */
        private BaseAdapter f16278c;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final DataSetObservable f16277b = new DataSetObservable();

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f16279d = 1;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f16280e = 0;

        public C3005a(BaseAdapter baseAdapter) {
            this.f16278c = null;
            this.f16278c = baseAdapter;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m16994a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 1) {
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            }
            if (this.f16279d != OplusGLSurfaceView_13) {
                this.f16279d = OplusGLSurfaceView_13;
                m16993a();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m16995b(int OplusGLSurfaceView_13) {
            this.f16280e = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m16993a() {
            this.f16277b.notifyChanged();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter != null) {
                return baseAdapter.isEmpty();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter == null || baseAdapter.getCount() <= 0) {
                return 0;
            }
            return this.f16278c.getCount() + (this.f16279d * 2);
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter != null) {
                return baseAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int OplusGLSurfaceView_13) {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter == null || OplusGLSurfaceView_13 >= baseAdapter.getCount()) {
                return false;
            }
            return this.f16278c.isEnabled(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public Object getItem(int OplusGLSurfaceView_13) {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter == null || OplusGLSurfaceView_13 >= baseAdapter.getCount()) {
                return null;
            }
            return this.f16278c.getItem(OplusGLSurfaceView_13);
        }

        @Override // android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter != null) {
                return baseAdapter.getItemId(OplusGLSurfaceView_13);
            }
            return -1L;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter != null) {
                return baseAdapter.hasStableIds();
            }
            return false;
        }

        @Override // android.widget.Adapter
        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter == null) {
                return null;
            }
            if (OplusGLSurfaceView_13 < baseAdapter.getCount()) {
                BaseAdapter baseAdapter2 = this.f16278c;
                if (baseAdapter2 instanceof GridAdapter) {
                    ((GridAdapter) baseAdapter2).m17014a(FooterGridView.this.f16273a);
                }
                return this.f16278c.getView(OplusGLSurfaceView_13, view, viewGroup);
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setMinimumHeight(this.f16280e);
            view.setVisibility(4);
            return view;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int OplusGLSurfaceView_13) {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter == null) {
                return -1;
            }
            if (OplusGLSurfaceView_13 < baseAdapter.getCount()) {
                return this.f16278c.getItemViewType(OplusGLSurfaceView_13);
            }
            return -2;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter != null) {
                return baseAdapter.getViewTypeCount();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f16277b.registerObserver(dataSetObserver);
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter != null) {
                baseAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f16277b.unregisterObserver(dataSetObserver);
            BaseAdapter baseAdapter = this.f16278c;
            if (baseAdapter != null) {
                baseAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            SpinnerAdapter spinnerAdapter = this.f16278c;
            if (spinnerAdapter instanceof Filterable) {
                return ((Filterable) spinnerAdapter).getFilter();
            }
            return null;
        }

        @Override // android.widget.WrapperListAdapter
        public ListAdapter getWrappedAdapter() {
            return this.f16278c;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CameraLog.m12954a("FooterGridView", "onTouchEvent, action: " + motionEvent.getAction() + ", coord: " + motionEvent.getX() + "x" + motionEvent.getY());
        if (isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
