package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class StorageSaveToExternalPreference extends com.coui.appcompat.preference.COUIPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.View f6583a;

    public StorageSaveToExternalPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        if (this.f6583a == null) {
            this.f6583a = lVar.itemView;
            lVar.itemView.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_storage_save_to_external_button).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.StorageSaveToExternalPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    androidx.preference.Preference.c_renamed cVarI = com.oplus.camera.ui.menu.setting.StorageSaveToExternalPreference.this.I_renamed();
                    if (cVarI != null) {
                        cVarI.onPreferenceClick(com.oplus.camera.ui.menu.setting.StorageSaveToExternalPreference.this);
                    }
                }
            });
        }
    }
}
