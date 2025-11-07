package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIPreference;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class StorageSaveToExternalPreference extends COUIPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private View f19992a;

    public StorageSaveToExternalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        if (this.f19992a == null) {
            this.f19992a = c0668l.itemView;
            c0668l.itemView.findViewById(R.id_renamed.camera_storage_save_to_external_button).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.StorageSaveToExternalPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Preference.InterfaceC0645c interfaceC0645cI = StorageSaveToExternalPreference.this.m3798I();
                    if (interfaceC0645cI != null) {
                        interfaceC0645cI.onPreferenceClick(StorageSaveToExternalPreference.this);
                    }
                }
            });
        }
    }
}
