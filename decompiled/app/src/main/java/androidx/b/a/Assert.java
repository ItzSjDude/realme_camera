package androidx.b_renamed.a_renamed;

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a_renamed extends android.widget.BaseAdapter implements android.widget.Filterable, androidx.b_renamed.a_renamed.b_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected boolean f654a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected boolean f655b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected android.database.Cursor f656c;
    protected android.content.Context d_renamed;
    protected int e_renamed;
    protected androidx.b_renamed.a_renamed.a_renamed.CursorAdapter_2 f_renamed;
    protected android.database.DataSetObserver g_renamed;
    protected androidx.b_renamed.a_renamed.b_renamed h_renamed;
    protected android.widget.FilterQueryProvider i_renamed;

    public abstract android.view.View a_renamed(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup);

    public abstract void a_renamed(android.view.View view, android.content.Context context, android.database.Cursor cursor);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @java.lang.Deprecated
    public a_renamed(android.content.Context context, android.database.Cursor cursor) {
        a_renamed(context, cursor, 1);
    }

    public a_renamed(android.content.Context context, android.database.Cursor cursor, boolean z_renamed) {
        a_renamed(context, cursor, z_renamed ? 1 : 2);
    }

    void a_renamed(android.content.Context context, android.database.Cursor cursor, int i_renamed) {
        if ((i_renamed & 1) == 1) {
            i_renamed |= 2;
            this.f655b = true;
        } else {
            this.f655b = false;
        }
        boolean z_renamed = cursor != null;
        this.f656c = cursor;
        this.f654a = z_renamed;
        this.d_renamed = context;
        this.e_renamed = z_renamed ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i_renamed & 2) == 2) {
            this.f_renamed = new androidx.b_renamed.a_renamed.a_renamed.CursorAdapter_2();
            this.g_renamed = new androidx.b_renamed.a_renamed.a_renamed.b_renamed();
        } else {
            this.f_renamed = null;
            this.g_renamed = null;
        }
        if (z_renamed) {
            androidx.b_renamed.a_renamed.a_renamed.CursorAdapter_2 c0010a = this.f_renamed;
            if (c0010a != null) {
                cursor.registerContentObserver(c0010a);
            }
            android.database.DataSetObserver dataSetObserver = this.g_renamed;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // androidx.b_renamed.a_renamed.b_renamed.a_renamed
    public android.database.Cursor a_renamed() {
        return this.f656c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        android.database.Cursor cursor;
        if (!this.f654a || (cursor = this.f656c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i_renamed) {
        android.database.Cursor cursor;
        if (!this.f654a || (cursor = this.f656c) == null) {
            return null;
        }
        cursor.moveToPosition(i_renamed);
        return this.f656c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        android.database.Cursor cursor;
        if (this.f654a && (cursor = this.f656c) != null && cursor.moveToPosition(i_renamed)) {
            return this.f656c.getLong(this.e_renamed);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        if (!this.f654a) {
            throw new java.lang.IllegalStateException("this should only be_renamed called when the cursor is_renamed valid");
        }
        if (!this.f656c.moveToPosition(i_renamed)) {
            throw new java.lang.IllegalStateException("couldn't_renamed move cursor to position " + i_renamed);
        }
        if (view == null) {
            view = a_renamed(this.d_renamed, this.f656c, viewGroup);
        }
        a_renamed(view, this.d_renamed, this.f656c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public android.view.View getDropDownView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        if (!this.f654a) {
            return null;
        }
        this.f656c.moveToPosition(i_renamed);
        if (view == null) {
            view = b_renamed(this.d_renamed, this.f656c, viewGroup);
        }
        a_renamed(view, this.d_renamed, this.f656c);
        return view;
    }

    public android.view.View b_renamed(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        return a_renamed(context, cursor, viewGroup);
    }

    public void a_renamed(android.database.Cursor cursor) {
        android.database.Cursor cursorC = c_renamed(cursor);
        if (cursorC != null) {
            cursorC.close();
        }
    }

    public android.database.Cursor c_renamed(android.database.Cursor cursor) {
        android.database.Cursor cursor2 = this.f656c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            androidx.b_renamed.a_renamed.a_renamed.CursorAdapter_2 c0010a = this.f_renamed;
            if (c0010a != null) {
                cursor2.unregisterContentObserver(c0010a);
            }
            android.database.DataSetObserver dataSetObserver = this.g_renamed;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f656c = cursor;
        if (cursor != null) {
            androidx.b_renamed.a_renamed.a_renamed.CursorAdapter_2 c0010a2 = this.f_renamed;
            if (c0010a2 != null) {
                cursor.registerContentObserver(c0010a2);
            }
            android.database.DataSetObserver dataSetObserver2 = this.g_renamed;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.e_renamed = cursor.getColumnIndexOrThrow("_id");
            this.f654a = true;
            notifyDataSetChanged();
        } else {
            this.e_renamed = -1;
            this.f654a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public java.lang.CharSequence b_renamed(android.database.Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public android.database.Cursor a_renamed(java.lang.CharSequence charSequence) {
        android.widget.FilterQueryProvider filterQueryProvider = this.i_renamed;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f656c;
    }

    @Override // android.widget.Filterable
    public android.widget.Filter getFilter() {
        if (this.h_renamed == null) {
            this.h_renamed = new androidx.b_renamed.a_renamed.b_renamed(this);
        }
        return this.h_renamed;
    }

    protected void b_renamed() {
        android.database.Cursor cursor;
        if (!this.f655b || (cursor = this.f656c) == null || cursor.isClosed()) {
            return;
        }
        this.f654a = this.f656c.requery();
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: androidx.b_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private class CursorAdapter_2 extends android.database.ContentObserver {
        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        CursorAdapter_2() {
            super(new android.os.Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z_renamed) {
            androidx.b_renamed.a_renamed.a_renamed.this.b_renamed();
        }
    }

    /* compiled from: CursorAdapter.java */
    private class b_renamed extends android.database.DataSetObserver {
        b_renamed() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            androidx.b_renamed.a_renamed.a_renamed aVar = androidx.b_renamed.a_renamed.a_renamed.this;
            aVar.f654a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            androidx.b_renamed.a_renamed.a_renamed aVar = androidx.b_renamed.a_renamed.a_renamed.this;
            aVar.f654a = false;
            aVar.notifyDataSetInvalidated();
        }
    }
}
