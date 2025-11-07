package androidx.b_renamed.a_renamed;

/* compiled from: CursorFilter.java */
/* loaded from: classes.dex */
class b_renamed extends android.widget.Filter {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.b_renamed.a_renamed.b_renamed.a_renamed f659a;

    /* compiled from: CursorFilter.java */
    interface a_renamed {
        android.database.Cursor a_renamed();

        android.database.Cursor a_renamed(java.lang.CharSequence charSequence);

        void a_renamed(android.database.Cursor cursor);

        java.lang.CharSequence b_renamed(android.database.Cursor cursor);
    }

    b_renamed(androidx.b_renamed.a_renamed.b_renamed.a_renamed aVar) {
        this.f659a = aVar;
    }

    @Override // android.widget.Filter
    public java.lang.CharSequence convertResultToString(java.lang.Object obj) {
        return this.f659a.b_renamed((android.database.Cursor) obj);
    }

    @Override // android.widget.Filter
    protected android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence charSequence) {
        android.database.Cursor cursorA = this.f659a.a_renamed(charSequence);
        android.widget.Filter.FilterResults filterResults = new android.widget.Filter.FilterResults();
        if (cursorA != null) {
            filterResults.count = cursorA.getCount();
            filterResults.values = cursorA;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(java.lang.CharSequence charSequence, android.widget.Filter.FilterResults filterResults) {
        android.database.Cursor cursorA = this.f659a.a_renamed();
        if (filterResults.values == null || filterResults.values == cursorA) {
            return;
        }
        this.f659a.a_renamed((android.database.Cursor) filterResults.values);
    }
}
