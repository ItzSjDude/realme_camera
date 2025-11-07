package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f3715a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ArrayAdapter f3716b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Spinner f3717c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AdapterView.OnItemSelectedListener f3718d;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3718d = new AdapterView.OnItemSelectedListener() { // from class: androidx.preference.DropDownPreference.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long OplusGLSurfaceView_15) {
                if (i3 >= 0) {
                    String string = DropDownPreference.this.m3768m()[i3].toString();
                    if (string.equals(DropDownPreference.this.m3770o()) || !DropDownPreference.this.m3831b((Object) string)) {
                        return;
                    }
                    DropDownPreference.this.m3765a(string);
                }
            }
        };
        this.f3715a = context;
        this.f3716b = m3747h();
        m3745U();
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo3743g() {
        this.f3717c.performClick();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected ArrayAdapter m3747h() {
        return new ArrayAdapter(this.f3715a, android.R.layout.simple_spinner_dropdown_item);
    }

    /* renamed from: U */
    private void m3745U() {
        this.f3716b.clear();
        if (m3767l() != null) {
            for (CharSequence charSequence : m3767l()) {
                this.f3716b.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_13 */
    protected void mo3748i() {
        super.mo3748i();
        ArrayAdapter arrayAdapter = this.f3716b;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        this.f3717c = (Spinner) c0668l.itemView.findViewById(R.id_renamed.spinner);
        this.f3717c.setAdapter((SpinnerAdapter) this.f3716b);
        this.f3717c.setOnItemSelectedListener(this.f3718d);
        this.f3717c.setSelection(m3746f(m3770o()));
        super.mo3736a(c0668l);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int m3746f(String str) {
        CharSequence[] charSequenceArrM = m3768m();
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
