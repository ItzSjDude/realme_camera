package androidx.preference;

/* loaded from: classes.dex */
public class DropDownPreference extends androidx.preference.ListPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f1294a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.widget.ArrayAdapter f1295b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.Spinner f1296c;
    private final android.widget.AdapterView.OnItemSelectedListener d_renamed;

    public DropDownPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.preference.R_renamed.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public DropDownPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.d_renamed = new android.widget.AdapterView.OnItemSelectedListener() { // from class: androidx.preference.DropDownPreference.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i3, long j_renamed) {
                if (i3 >= 0) {
                    java.lang.String string = androidx.preference.DropDownPreference.this.m_renamed()[i3].toString();
                    if (string.equals(androidx.preference.DropDownPreference.this.o_renamed()) || !androidx.preference.DropDownPreference.this.b_renamed((java.lang.Object) string)) {
                        return;
                    }
                    androidx.preference.DropDownPreference.this.a_renamed(string);
                }
            }
        };
        this.f1294a = context;
        this.f1295b = h_renamed();
        U_renamed();
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void g_renamed() {
        this.f1296c.performClick();
    }

    protected android.widget.ArrayAdapter h_renamed() {
        return new android.widget.ArrayAdapter(this.f1294a, android.R_renamed.layout.simple_spinner_dropdown_item);
    }

    private void U_renamed() {
        this.f1295b.clear();
        if (l_renamed() != null) {
            for (java.lang.CharSequence charSequence : l_renamed()) {
                this.f1295b.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void i_renamed() {
        super.i_renamed();
        android.widget.ArrayAdapter arrayAdapter = this.f1295b;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        this.f1296c = (android.widget.Spinner) lVar.itemView.findViewById(androidx.preference.R_renamed.id_renamed.spinner);
        this.f1296c.setAdapter((android.widget.SpinnerAdapter) this.f1295b);
        this.f1296c.setOnItemSelectedListener(this.d_renamed);
        this.f1296c.setSelection(f_renamed(o_renamed()));
        super.a_renamed(lVar);
    }

    private int f_renamed(java.lang.String str) {
        java.lang.CharSequence[] charSequenceArrM = m_renamed();
        if (str == null || charSequenceArrM == null) {
            return -1;
        }
        for (int length = charSequenceArrM.length - 1; length >= 0; length--) {
            if (charSequenceArrM[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }
}
