package androidx.preference;

/* compiled from: ListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class c_renamed extends androidx.preference.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f1335a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f1336b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f1337c;

    public static androidx.preference.c_renamed a_renamed(java.lang.String str) {
        androidx.preference.c_renamed cVar = new androidx.preference.c_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            androidx.preference.ListPreference listPreferenceC = c_renamed();
            if (listPreferenceC.l_renamed() == null || listPreferenceC.m_renamed() == null) {
                throw new java.lang.IllegalStateException("ListPreference requires an_renamed entries array and an_renamed entryValues array.");
            }
            this.f1335a = listPreferenceC.b_renamed(listPreferenceC.o_renamed());
            this.f1336b = listPreferenceC.l_renamed();
            this.f1337c = listPreferenceC.m_renamed();
            return;
        }
        this.f1335a = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.f1336b = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.f1337c = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f1335a);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f1336b);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f1337c);
    }

    private androidx.preference.ListPreference c_renamed() {
        return (androidx.preference.ListPreference) b_renamed();
    }

    @Override // androidx.preference.f_renamed
    protected void a_renamed(androidx.appcompat.app.b_renamed.a_renamed aVar) {
        super.a_renamed(aVar);
        aVar.setSingleChoiceItems(this.f1336b, this.f1335a, new android.content.DialogInterface.OnClickListener() { // from class: androidx.preference.c_renamed.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                androidx.preference.c_renamed cVar = androidx.preference.c_renamed.this;
                cVar.f1335a = i_renamed;
                cVar.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        aVar.setPositiveButton((java.lang.CharSequence) null, (android.content.DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.f_renamed
    public void a_renamed(boolean z_renamed) {
        int i_renamed;
        if (!z_renamed || (i_renamed = this.f1335a) < 0) {
            return;
        }
        java.lang.String string = this.f1337c[i_renamed].toString();
        androidx.preference.ListPreference listPreferenceC = c_renamed();
        if (listPreferenceC.b_renamed((java.lang.Object) string)) {
            listPreferenceC.a_renamed(string);
        }
    }
}
