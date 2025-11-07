package androidx.preference;

/* compiled from: ExpandButton.java */
/* loaded from: classes.dex */
final class b_renamed extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f1334a;

    b_renamed(android.content.Context context, java.util.List<androidx.preference.Preference> list, long j_renamed) {
        super(context);
        b_renamed();
        a_renamed(list);
        this.f1334a = j_renamed + 1000000;
    }

    private void b_renamed() {
        a_renamed(androidx.preference.R_renamed.layout.expand_button);
        e_renamed(androidx.preference.R_renamed.drawable.ic_arrow_down_24dp);
        d_renamed(androidx.preference.R_renamed.string.expand_button_title);
        c_renamed(999);
    }

    private void a_renamed(java.util.List<androidx.preference.Preference> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.CharSequence string = null;
        for (androidx.preference.Preference preference : list) {
            java.lang.CharSequence charSequenceX = preference.x_renamed();
            boolean z_renamed = preference instanceof androidx.preference.PreferenceGroup;
            if (z_renamed && !android.text.TextUtils.isEmpty(charSequenceX)) {
                arrayList.add((androidx.preference.PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.R_renamed())) {
                if (z_renamed) {
                    arrayList.add((androidx.preference.PreferenceGroup) preference);
                }
            } else if (!android.text.TextUtils.isEmpty(charSequenceX)) {
                string = string == null ? charSequenceX : K_renamed().getString(androidx.preference.R_renamed.string.summary_collapsed_preference_list, string, charSequenceX);
            }
        }
        a_renamed(string);
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        lVar.a_renamed(false);
    }

    @Override // androidx.preference.Preference
    long c__renamed() {
        return this.f1334a;
    }
}
