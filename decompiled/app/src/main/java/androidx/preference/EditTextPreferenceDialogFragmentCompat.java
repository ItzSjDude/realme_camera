package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* compiled from: EditTextPreferenceDialogFragmentCompat.java */
/* renamed from: androidx.preference.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private EditText f3863a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence f3864b;

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo3912a() {
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static EditTextPreferenceDialogFragmentCompat m3908a(String str) {
        EditTextPreferenceDialogFragmentCompat c0657a = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c0657a.setArguments(bundle);
        return c0657a;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f3864b = m3909c().m3753h();
        } else {
            this.f3864b = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f3864b);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3910a(View view) {
        super.mo3910a(view);
        this.f3863a = (EditText) view.findViewById(android.R.id_renamed.edit);
        EditText editText = this.f3863a;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id_renamed @android:id_renamed/edit");
        }
        editText.requestFocus();
        this.f3863a.setText(this.f3864b);
        EditText editText2 = this.f3863a;
        editText2.setSelection(editText2.getText().length());
        if (m3909c().m3756l() != null) {
            m3909c().m3756l().m3759a(this.f3863a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private EditTextPreference m3909c() {
        return (EditTextPreference) m3930b();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3911a(boolean z) {
        if (z) {
            String string = this.f3863a.getText().toString();
            EditTextPreference editTextPreferenceM3909c = m3909c();
            if (editTextPreferenceM3909c.m3831b((Object) string)) {
                editTextPreferenceM3909c.m3752a(string);
            }
        }
    }
}
