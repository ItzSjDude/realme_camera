package androidx.p021b.p022a;

import android.database.Cursor;
import android.widget.Filter;

/* compiled from: CursorFilter.java */
/* renamed from: androidx.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class CursorFilter extends Filter {

    /* renamed from: PlatformImplementations.kt_3 */
    PlatformImplementations.kt_3 f2034a;

    /* compiled from: CursorFilter.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        Cursor mo1764a();

        /* renamed from: PlatformImplementations.kt_3 */
        Cursor mo1522a(CharSequence charSequence);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo1526a(Cursor cursor);

        /* renamed from: IntrinsicsJvm.kt_4 */
        CharSequence mo1528b(Cursor cursor);
    }

    CursorFilter(PlatformImplementations.kt_3 aVar) {
        this.f2034a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f2034a.mo1528b((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorMo1522a = this.f2034a.mo1522a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorMo1522a != null) {
            filterResults.count = cursorMo1522a.getCount();
            filterResults.values = cursorMo1522a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorMo1764a = this.f2034a.mo1764a();
        if (filterResults.values == null || filterResults.values == cursorMo1764a) {
            return;
        }
        this.f2034a.mo1526a((Cursor) filterResults.values);
    }
}
