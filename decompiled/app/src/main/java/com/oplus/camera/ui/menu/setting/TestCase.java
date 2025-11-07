package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraCustomListPreferenceFragment.java */
/* loaded from: classes2.dex */
public class e_renamed extends androidx.preference.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6632a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f6633b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f6634c = null;
    private java.lang.CharSequence[] d_renamed = null;

    public static com.oplus.camera.ui.menu.setting.e_renamed a_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.e_renamed eVar = new com.oplus.camera.ui.menu.setting.e_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        eVar.setArguments(bundle);
        return eVar;
    }

    @Override // androidx.preference.f_renamed
    protected void a_renamed(androidx.appcompat.app.b_renamed.a_renamed aVar) {
        super.a_renamed(aVar);
        aVar.setSingleChoiceItems(new com.oplus.camera.ui.menu.levelcontrol.d_renamed(getActivity(), true, true, this.f6632a, this.f6633b, this.d_renamed), this.f6632a, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.e_renamed.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.menu.setting.e_renamed.this.f6632a = i_renamed;
                com.oplus.camera.ui.menu.setting.e_renamed.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
    }

    private com.oplus.camera.ui.menu.setting.CameraCustomListPreference c_renamed() {
        return (com.oplus.camera.ui.menu.setting.CameraCustomListPreference) b_renamed();
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            com.oplus.camera.ui.menu.setting.CameraCustomListPreference cameraCustomListPreferenceC = c_renamed();
            if (cameraCustomListPreferenceC.l_renamed() == null || cameraCustomListPreferenceC.m_renamed() == null) {
                throw new java.lang.IllegalStateException("ListPreference requires an_renamed entries array and an_renamed entryValues array.");
            }
            this.f6632a = cameraCustomListPreferenceC.b_renamed(cameraCustomListPreferenceC.o_renamed());
            this.f6633b = cameraCustomListPreferenceC.l_renamed();
            this.f6634c = cameraCustomListPreferenceC.m_renamed();
            this.d_renamed = cameraCustomListPreferenceC.V_renamed();
            return;
        }
        this.f6632a = bundle.getInt("CameraCustomListPreferenceFragment.index", 0);
        this.f6633b = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entries");
        this.f6634c = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entryValues");
        this.d_renamed = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entrySummary");
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("CameraCustomListPreferenceFragment.index", this.f6632a);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entries", this.f6633b);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entryValues", this.f6634c);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entrySummary", this.d_renamed);
    }

    @Override // androidx.preference.f_renamed
    public void a_renamed(boolean z_renamed) {
        int i_renamed;
        if (!z_renamed || (i_renamed = this.f6632a) < 0) {
            return;
        }
        java.lang.String string = this.f6634c[i_renamed].toString();
        com.oplus.camera.ui.menu.setting.CameraCustomListPreference cameraCustomListPreferenceC = c_renamed();
        if (cameraCustomListPreferenceC.b_renamed((java.lang.Object) string)) {
            cameraCustomListPreferenceC.a_renamed(string);
        }
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        com.coui.appcompat.dialog.app.b_renamed.a_renamed message = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(getActivity()).f_renamed(1).setTitle(b_renamed().a_renamed()).setIcon(b_renamed().c_renamed()).setMessage(b_renamed().b_renamed());
        a_renamed(message);
        return message.create();
    }
}
