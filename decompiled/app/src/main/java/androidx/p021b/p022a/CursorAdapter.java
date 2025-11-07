package androidx.p021b.p022a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.p021b.p022a.CursorFilter;

/* compiled from: CursorAdapter.java */
/* renamed from: androidx.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean f2023a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean f2024b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Cursor f2025c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Context f2026d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f2027e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected PlatformImplementations.kt_3 f2028f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected DataSetObserver f2029g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected CursorFilter f2030h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected FilterQueryProvider f2031i;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract View mo1524a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo1527a(View view, Context context, Cursor cursor);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        m1765a(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        m1765a(context, cursor, z ? 1 : 2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1765a(Context context, Cursor cursor, int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & 1) == 1) {
            OplusGLSurfaceView_13 |= 2;
            this.f2024b = true;
        } else {
            this.f2024b = false;
        }
        boolean z = cursor != null;
        this.f2025c = cursor;
        this.f2023a = z;
        this.f2026d = context;
        this.f2027e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((OplusGLSurfaceView_13 & 2) == 2) {
            this.f2028f = new PlatformImplementations.kt_3();
            this.f2029g = new IntrinsicsJvm.kt_4();
        } else {
            this.f2028f = null;
            this.f2029g = null;
        }
        if (z) {
            PlatformImplementations.kt_3 aVar = this.f2028f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2029g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // androidx.p021b.p022a.CursorFilter.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor mo1764a() {
        return this.f2025c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f2023a || (cursor = this.f2025c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int OplusGLSurfaceView_13) {
        Cursor cursor;
        if (!this.f2023a || (cursor = this.f2025c) == null) {
            return null;
        }
        cursor.moveToPosition(OplusGLSurfaceView_13);
        return this.f2025c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        Cursor cursor;
        if (this.f2023a && (cursor = this.f2025c) != null && cursor.moveToPosition(OplusGLSurfaceView_13)) {
            return this.f2025c.getLong(this.f2027e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        if (!this.f2023a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f2025c.moveToPosition(OplusGLSurfaceView_13)) {
            throw new IllegalStateException("couldn't move cursor to position " + OplusGLSurfaceView_13);
        }
        if (view == null) {
            view = mo1524a(this.f2026d, this.f2025c, viewGroup);
        }
        mo1527a(view, this.f2026d, this.f2025c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        if (!this.f2023a) {
            return null;
        }
        this.f2025c.moveToPosition(OplusGLSurfaceView_13);
        if (view == null) {
            view = mo1766b(this.f2026d, this.f2025c, viewGroup);
        }
        mo1527a(view, this.f2026d, this.f2025c);
        return view;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public View mo1766b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo1524a(context, cursor, viewGroup);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1526a(Cursor cursor) {
        Cursor cursorM1768c = m1768c(cursor);
        if (cursorM1768c != null) {
            cursorM1768c.close();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Cursor m1768c(Cursor cursor) {
        Cursor cursor2 = this.f2025c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            PlatformImplementations.kt_3 aVar = this.f2028f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2029g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2025c = cursor;
        if (cursor != null) {
            PlatformImplementations.kt_3 aVar2 = this.f2028f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f2029g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f2027e = cursor.getColumnIndexOrThrow("_id");
            this.f2023a = true;
            notifyDataSetChanged();
        } else {
            this.f2027e = -1;
            this.f2023a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence mo1528b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor mo1522a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f2031i;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f2025c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f2030h == null) {
            this.f2030h = new CursorFilter(this);
        }
        return this.f2030h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m1767b() {
        Cursor cursor;
        if (!this.f2024b || (cursor = this.f2025c) == null || cursor.isClosed()) {
            return;
        }
        this.f2023a = this.f2025c.requery();
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends ContentObserver {
        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        PlatformImplementations.kt_3() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorAdapter.this.m1767b();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends DataSetObserver {
        IntrinsicsJvm.kt_4() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter abstractC0355a = CursorAdapter.this;
            abstractC0355a.f2023a = true;
            abstractC0355a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter abstractC0355a = CursorAdapter.this;
            abstractC0355a.f2023a = false;
            abstractC0355a.notifyDataSetInvalidated();
        }
    }
}
