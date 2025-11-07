package androidx.preference;

/* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
@java.lang.Deprecated
/* loaded from: classes.dex */
public class k_renamed extends androidx.recyclerview.widget.p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.recyclerview.widget.RecyclerView f1374a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final androidx.core.h_renamed.a_renamed f1375b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final androidx.core.h_renamed.a_renamed f1376c;

    public k_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super(recyclerView);
        this.f1375b = super.getItemDelegate();
        this.f1376c = new androidx.core.h_renamed.a_renamed() { // from class: androidx.preference.k_renamed.1
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                androidx.preference.Preference preferenceA;
                androidx.preference.k_renamed.this.f1375b.onInitializeAccessibilityNodeInfo(view, dVar);
                int childAdapterPosition = androidx.preference.k_renamed.this.f1374a.getChildAdapterPosition(view);
                androidx.recyclerview.widget.RecyclerView.a_renamed adapter = androidx.preference.k_renamed.this.f1374a.getAdapter();
                if ((adapter instanceof androidx.preference.h_renamed) && (preferenceA = ((androidx.preference.h_renamed) adapter).a_renamed(childAdapterPosition)) != null) {
                    preferenceA.a_renamed(dVar);
                }
            }

            @Override // androidx.core.h_renamed.a_renamed
            public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) {
                return androidx.preference.k_renamed.this.f1375b.performAccessibilityAction(view, i_renamed, bundle);
            }
        };
        this.f1374a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.p_renamed
    public androidx.core.h_renamed.a_renamed getItemDelegate() {
        return this.f1376c;
    }
}
