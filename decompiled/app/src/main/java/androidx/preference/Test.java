package androidx.preference;

/* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class d_renamed extends androidx.preference.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    java.util.Set<java.lang.String> f1339a = new java.util.HashSet();

    /* renamed from: b_renamed, reason: collision with root package name */
    boolean f1340b;

    /* renamed from: c_renamed, reason: collision with root package name */
    java.lang.CharSequence[] f1341c;
    java.lang.CharSequence[] d_renamed;

    public static androidx.preference.d_renamed a_renamed(java.lang.String str) {
        androidx.preference.d_renamed dVar = new androidx.preference.d_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            androidx.preference.MultiSelectListPreference multiSelectListPreferenceC = c_renamed();
            if (multiSelectListPreferenceC.h_renamed() == null || multiSelectListPreferenceC.l_renamed() == null) {
                throw new java.lang.IllegalStateException("MultiSelectListPreference requires an_renamed entries array and an_renamed entryValues array.");
            }
            this.f1339a.clear();
            this.f1339a.addAll(multiSelectListPreferenceC.m_renamed());
            this.f1340b = false;
            this.f1341c = multiSelectListPreferenceC.h_renamed();
            this.d_renamed = multiSelectListPreferenceC.l_renamed();
            return;
        }
        this.f1339a.clear();
        this.f1339a.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.f1340b = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.f1341c = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.d_renamed = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new java.util.ArrayList<>(this.f1339a));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f1340b);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f1341c);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.d_renamed);
    }

    private androidx.preference.MultiSelectListPreference c_renamed() {
        return (androidx.preference.MultiSelectListPreference) b_renamed();
    }

    @Override // androidx.preference.f_renamed
    protected void a_renamed(androidx.appcompat.app.b_renamed.a_renamed aVar) {
        super.a_renamed(aVar);
        int length = this.d_renamed.length;
        boolean[] zArr = new boolean[length];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            zArr[i_renamed] = this.f1339a.contains(this.d_renamed[i_renamed].toString());
        }
        aVar.setMultiChoiceItems(this.f1341c, zArr, new android.content.DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.d_renamed.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2, boolean z_renamed) {
                if (z_renamed) {
                    androidx.preference.d_renamed dVar = androidx.preference.d_renamed.this;
                    dVar.f1340b = androidx.preference.d_renamed.this.f1339a.add(androidx.preference.d_renamed.this.d_renamed[i2].toString()) | dVar.f1340b;
                } else {
                    androidx.preference.d_renamed dVar2 = androidx.preference.d_renamed.this;
                    dVar2.f1340b = androidx.preference.d_renamed.this.f1339a.remove(androidx.preference.d_renamed.this.d_renamed[i2].toString()) | dVar2.f1340b;
                }
            }
        });
    }

    @Override // androidx.preference.f_renamed
    public void a_renamed(boolean z_renamed) {
        if (z_renamed && this.f1340b) {
            androidx.preference.MultiSelectListPreference multiSelectListPreferenceC = c_renamed();
            if (multiSelectListPreferenceC.b_renamed((java.lang.Object) this.f1339a)) {
                multiSelectListPreferenceC.a_renamed(this.f1339a);
            }
        }
        this.f1340b = false;
    }
}
