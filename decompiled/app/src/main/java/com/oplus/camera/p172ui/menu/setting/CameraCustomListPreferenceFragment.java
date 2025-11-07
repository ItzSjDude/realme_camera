package com.oplus.camera.p172ui.menu.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceDialogFragmentCompat;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.oplus.camera.p172ui.menu.levelcontrol.CameraCustomListPreferenceSummaryAdapter;

/* compiled from: CameraCustomListPreferenceFragment.java */
/* renamed from: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class CameraCustomListPreferenceFragment extends PreferenceDialogFragmentCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20119a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence[] f20120b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence[] f20121c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CharSequence[] f20122d = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public static CameraCustomListPreferenceFragment m21400a(String str) {
        CameraCustomListPreferenceFragment c3325e = new CameraCustomListPreferenceFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c3325e.setArguments(bundle);
        return c3325e;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3917a(AlertDialog.PlatformImplementations.kt_3 aVar) {
        super.mo3917a(aVar);
        aVar.setSingleChoiceItems(new CameraCustomListPreferenceSummaryAdapter(getActivity(), true, true, this.f20119a, this.f20120b, this.f20122d), this.f20119a, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_8.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                CameraCustomListPreferenceFragment.this.f20119a = OplusGLSurfaceView_13;
                CameraCustomListPreferenceFragment.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraCustomListPreference m21401c() {
        return (CameraCustomListPreference) m3930b();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            CameraCustomListPreference cameraCustomListPreferenceM21401c = m21401c();
            if (cameraCustomListPreferenceM21401c.m3767l() == null || cameraCustomListPreferenceM21401c.m3768m() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f20119a = cameraCustomListPreferenceM21401c.m3766b(cameraCustomListPreferenceM21401c.m3770o());
            this.f20120b = cameraCustomListPreferenceM21401c.m3767l();
            this.f20121c = cameraCustomListPreferenceM21401c.m3768m();
            this.f20122d = cameraCustomListPreferenceM21401c.m21045V();
            return;
        }
        this.f20119a = bundle.getInt("CameraCustomListPreferenceFragment.index", 0);
        this.f20120b = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entries");
        this.f20121c = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entryValues");
        this.f20122d = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entrySummary");
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("CameraCustomListPreferenceFragment.index", this.f20119a);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entries", this.f20120b);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entryValues", this.f20121c);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entrySummary", this.f20122d);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3911a(boolean z) {
        int OplusGLSurfaceView_13;
        if (!z || (OplusGLSurfaceView_13 = this.f20119a) < 0) {
            return;
        }
        String string = this.f20121c[OplusGLSurfaceView_13].toString();
        CameraCustomListPreference cameraCustomListPreferenceM21401c = m21401c();
        if (cameraCustomListPreferenceM21401c.m3831b((Object) string)) {
            cameraCustomListPreferenceM21401c.m3765a(string);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        COUIAlertDialog.PlatformImplementations.kt_3 message = new COUIAlertDialog.PlatformImplementations.kt_3(getActivity()).m6600f(1).setTitle(m3930b().m3737a()).setIcon(m3930b().m3739c()).setMessage(m3930b().m3738b());
        mo3917a(message);
        return message.create();
    }
}
