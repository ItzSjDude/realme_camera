package com.android.ui.menu;

/* loaded from: classes.dex */
public class CameraSwitchPreference extends com.coui.appcompat.preference.COUISwitchPreference implements androidx.preference.Preference.b_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f2297b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.preference.Preference f2298c;
    private com.coui.appcompat.dialog.app.b_renamed d_renamed;
    private com.coui.appcompat.dialog.app.b_renamed e_renamed;
    private final android.content.DialogInterface.OnClickListener f_renamed;
    private final android.content.DialogInterface.OnClickListener g_renamed;

    public CameraSwitchPreference(android.content.Context context) {
        super(context);
        this.f2297b = null;
        this.f2298c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.android.ui.menu.CameraSwitchPreference.this.e_renamed(true);
            }
        };
        this.g_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.android.ui.menu.CameraSwitchPreference.this.l_renamed();
            }
        };
        this.f2297b = context;
        a_renamed((androidx.preference.Preference.b_renamed) this);
    }

    public CameraSwitchPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2297b = null;
        this.f2298c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.android.ui.menu.CameraSwitchPreference.this.e_renamed(true);
            }
        };
        this.g_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.android.ui.menu.CameraSwitchPreference.this.l_renamed();
            }
        };
        this.f2297b = context;
        a_renamed((androidx.preference.Preference.b_renamed) this);
    }

    public CameraSwitchPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2297b = null;
        this.f2298c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                com.android.ui.menu.CameraSwitchPreference.this.e_renamed(true);
            }
        };
        this.g_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.android.ui.menu.CameraSwitchPreference.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                com.android.ui.menu.CameraSwitchPreference.this.l_renamed();
            }
        };
        this.f2297b = context;
        a_renamed((androidx.preference.Preference.b_renamed) this);
    }

    @Override // androidx.preference.Preference
    protected boolean c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraSwitchPreference", "persistBoolean, key: " + B_renamed() + ", value: " + z_renamed);
        try {
            return d_renamed(z_renamed ? "on_renamed" : "off");
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraSwitchPreference", "persistBoolean, persistString error: " + e_renamed.getMessage());
            this.L_renamed().edit().remove(this.B_renamed()).commit();
            return this.d_renamed(z_renamed ? "on_renamed" : "off");
        }
    }

    @Override // androidx.preference.Preference
    protected boolean d_renamed(boolean z_renamed) {
        boolean zD;
        boolean zEquals;
        try {
            zEquals = "on_renamed".equals(e_renamed(z_renamed ? "on_renamed" : "off"));
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraSwitchPreference", "persistBoolean, getPersistedString error: " + e_renamed.getMessage());
            try {
                zD = super.d_renamed(z_renamed);
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.a_renamed("CameraSwitchPreference", "persistBoolean, super.getPersistedBoolean error: " + e2.getMessage());
                zD = z_renamed;
            }
            L_renamed().edit().remove(B_renamed()).commit();
            d_renamed(z_renamed ? "on_renamed" : "off");
            zEquals = zD;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraSwitchPreference", "persistBoolean, key: " + B_renamed() + ", defaultReturnValue: " + z_renamed + ", isOn: " + zEquals);
        return zEquals;
    }

    public void c_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.e_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.e_renamed.dismiss();
        }
        com.coui.appcompat.dialog.app.b_renamed.a_renamed aVar = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.f2297b, com.oplus.camera.R_renamed.style.DialogAlert);
        aVar.setTitle(com.oplus.camera.R_renamed.string.camera_storage_target_sdcard_switch_alert);
        aVar.setMessage(com.oplus.camera.R_renamed.string.camera_storage_footer_summary);
        aVar.setPositiveButton(com.oplus.camera.R_renamed.string.camera_storage_confirm, this.f_renamed);
        aVar.setNegativeButton(com.oplus.camera.R_renamed.string.camera_storage_cancel, this.g_renamed);
        this.e_renamed = aVar.create();
        if (!(this.f2297b instanceof android.app.Activity) || ((android.app.Activity) K_renamed()).isFinishing()) {
            return;
        }
        this.e_renamed.show();
    }

    @Override // androidx.preference.Preference.b_renamed
    public boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
        if (!com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE.equals(preference.B_renamed()) || !"off".equals(preference.L_renamed().getString(preference.B_renamed(), "off"))) {
            return true;
        }
        this.f2298c = preference;
        c_renamed();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        androidx.preference.Preference preference = this.f2298c;
        if (preference == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraSwitchPreference", "Exception: null == mPreference");
            return;
        }
        synchronized (preference) {
            android.content.SharedPreferences.Editor editorEdit = this.f2298c.L_renamed().edit();
            editorEdit.putString(this.f2298c.B_renamed(), "off");
            editorEdit.apply();
            e_renamed(false);
        }
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraSwitchPreference", "release");
        com.coui.appcompat.dialog.app.b_renamed bVar = this.d_renamed;
        if (bVar != null && bVar.isShowing()) {
            com.oplus.camera.e_renamed.a_renamed("CameraSwitchPreference", "release, mRecordLocationDialog dismiss");
            this.d_renamed.dismiss();
        }
        this.d_renamed = null;
        com.coui.appcompat.dialog.app.b_renamed bVar2 = this.e_renamed;
        if (bVar2 != null && bVar2.isShowing()) {
            com.oplus.camera.e_renamed.a_renamed("CameraSwitchPreference", "release, mStoragePlaceDialog dismiss");
            this.e_renamed.dismiss();
        }
        this.e_renamed = null;
    }

    public boolean e_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.e_renamed;
        return bVar != null && bVar.isShowing();
    }

    public void f_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.e_renamed;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.e_renamed.dismiss();
    }
}
