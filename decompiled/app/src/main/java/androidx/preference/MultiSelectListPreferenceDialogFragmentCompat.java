package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* renamed from: androidx.preference.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    Set<String> f3870a = new HashSet();

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f3871b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    CharSequence[] f3872c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    CharSequence[] f3873d;

    /* renamed from: PlatformImplementations.kt_3 */
    public static MultiSelectListPreferenceDialogFragmentCompat m3918a(String str) {
        MultiSelectListPreferenceDialogFragmentCompat c0660d = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c0660d.setArguments(bundle);
        return c0660d;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference multiSelectListPreferenceM3919c = m3919c();
            if (multiSelectListPreferenceM3919c.m3778h() == null || multiSelectListPreferenceM3919c.m3779l() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.f3870a.clear();
            this.f3870a.addAll(multiSelectListPreferenceM3919c.m3780m());
            this.f3871b = false;
            this.f3872c = multiSelectListPreferenceM3919c.m3778h();
            this.f3873d = multiSelectListPreferenceM3919c.m3779l();
            return;
        }
        this.f3870a.clear();
        this.f3870a.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.f3871b = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.f3872c = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.f3873d = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f3870a));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f3871b);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f3872c);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f3873d);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private MultiSelectListPreference m3919c() {
        return (MultiSelectListPreference) m3930b();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3917a(AlertDialog.PlatformImplementations.kt_3 aVar) {
        super.mo3917a(aVar);
        int length = this.f3873d.length;
        boolean[] zArr = new boolean[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            zArr[OplusGLSurfaceView_13] = this.f3870a.contains(this.f3873d[OplusGLSurfaceView_13].toString());
        }
        aVar.setMultiChoiceItems(this.f3872c, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.IntrinsicsJvm.kt_5.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                if (z) {
                    MultiSelectListPreferenceDialogFragmentCompat c0660d = MultiSelectListPreferenceDialogFragmentCompat.this;
                    c0660d.f3871b = MultiSelectListPreferenceDialogFragmentCompat.this.f3870a.add(MultiSelectListPreferenceDialogFragmentCompat.this.f3873d[i2].toString()) | c0660d.f3871b;
                } else {
                    MultiSelectListPreferenceDialogFragmentCompat c0660d2 = MultiSelectListPreferenceDialogFragmentCompat.this;
                    c0660d2.f3871b = MultiSelectListPreferenceDialogFragmentCompat.this.f3870a.remove(MultiSelectListPreferenceDialogFragmentCompat.this.f3873d[i2].toString()) | c0660d2.f3871b;
                }
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3911a(boolean z) {
        if (z && this.f3871b) {
            MultiSelectListPreference multiSelectListPreferenceM3919c = m3919c();
            if (multiSelectListPreferenceM3919c.m3831b((Object) this.f3870a)) {
                multiSelectListPreferenceM3919c.m3776a(this.f3870a);
            }
        }
        this.f3871b = false;
    }
}
