package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;

/* compiled from: ListPreferenceDialogFragmentCompat.java */
/* renamed from: androidx.preference.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    int f3866a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence[] f3867b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence[] f3868c;

    /* renamed from: PlatformImplementations.kt_3 */
    public static ListPreferenceDialogFragmentCompat m3915a(String str) {
        ListPreferenceDialogFragmentCompat c0659c = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c0659c.setArguments(bundle);
        return c0659c;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference listPreferenceM3916c = m3916c();
            if (listPreferenceM3916c.m3767l() == null || listPreferenceM3916c.m3768m() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f3866a = listPreferenceM3916c.m3766b(listPreferenceM3916c.m3770o());
            this.f3867b = listPreferenceM3916c.m3767l();
            this.f3868c = listPreferenceM3916c.m3768m();
            return;
        }
        this.f3866a = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.f3867b = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.f3868c = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f3866a);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f3867b);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f3868c);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ListPreference m3916c() {
        return (ListPreference) m3930b();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3917a(AlertDialog.PlatformImplementations.kt_3 aVar) {
        super.mo3917a(aVar);
        aVar.setSingleChoiceItems(this.f3867b, this.f3866a, new DialogInterface.OnClickListener() { // from class: androidx.preference.IntrinsicsJvm.kt_3.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                ListPreferenceDialogFragmentCompat c0659c = ListPreferenceDialogFragmentCompat.this;
                c0659c.f3866a = OplusGLSurfaceView_13;
                c0659c.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        aVar.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3911a(boolean z) {
        int OplusGLSurfaceView_13;
        if (!z || (OplusGLSurfaceView_13 = this.f3866a) < 0) {
            return;
        }
        String string = this.f3868c[OplusGLSurfaceView_13].toString();
        ListPreference listPreferenceM3916c = m3916c();
        if (listPreferenceM3916c.m3831b((Object) string)) {
            listPreferenceM3916c.m3765a(string);
        }
    }
}
