package com.oplus.camera.ui.menu.setting;

/* compiled from: VideoSoundSettingFragment.java */
/* loaded from: classes2.dex */
public class r_renamed extends androidx.preference.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.TextView f6673a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.COUISwitch f6674b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6675c = 0;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private java.lang.String f_renamed = null;
    private java.lang.String g_renamed = null;
    private java.lang.CharSequence[] h_renamed = null;
    private java.lang.CharSequence[] i_renamed = null;
    private java.lang.CharSequence[] j_renamed = null;

    public static com.oplus.camera.ui.menu.setting.r_renamed a_renamed(java.lang.String str, java.lang.String str2, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.setting.r_renamed rVar = new com.oplus.camera.ui.menu.setting.r_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        bundle.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, str2);
        bundle.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, i_renamed);
        bundle.putInt("camera_property_camera_id", i2);
        rVar.setArguments(bundle);
        return rVar;
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed == 0) {
            this.f6673a.setEnabled(false);
            this.f6673a.setTextColor(getResources().getColor(com.oplus.camera.R_renamed.color.video_textView_dewind_noise_color));
            this.f6674b.setEnabled(false);
        } else {
            this.f6673a.setEnabled(true);
            this.f6673a.setTextColor(-16777216);
            this.f6674b.setEnabled(true);
        }
    }

    @Override // androidx.preference.f_renamed
    protected void a_renamed(androidx.appcompat.app.b_renamed.a_renamed aVar) {
        super.a_renamed(aVar);
        final com.oplus.camera.ui.menu.levelcontrol.s_renamed sVar = new com.oplus.camera.ui.menu.levelcontrol.s_renamed(getActivity(), true, true, this.f6675c, com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(this.g_renamed), this.h_renamed, this.j_renamed);
        aVar.setSingleChoiceItems(sVar, this.f6675c, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.r_renamed.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.menu.setting.r_renamed.this.f6675c = i_renamed;
                if (com.oplus.camera.util.Util.D_renamed()) {
                    sVar.a_renamed(i_renamed);
                    com.oplus.camera.ui.menu.setting.r_renamed.this.a_renamed(i_renamed);
                } else {
                    com.oplus.camera.ui.menu.setting.r_renamed.this.onClick(dialogInterface, -1);
                    dialogInterface.dismiss();
                }
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
            this.f6675c = cameraCustomListPreferenceC.b_renamed(cameraCustomListPreferenceC.o_renamed());
            this.h_renamed = cameraCustomListPreferenceC.l_renamed();
            this.i_renamed = cameraCustomListPreferenceC.m_renamed();
            this.j_renamed = cameraCustomListPreferenceC.V_renamed();
            this.g_renamed = cameraCustomListPreferenceC.B_renamed();
        } else {
            this.f6675c = bundle.getInt("VideoSoundSettingFragment.index", 0);
            this.h_renamed = bundle.getCharSequenceArray("VideoSoundSettingFragment.entries");
            this.i_renamed = bundle.getCharSequenceArray("VideoSoundSettingFragment.entryValues");
            this.j_renamed = bundle.getCharSequenceArray("VideoSoundSettingFragment.entrySummary");
        }
        android.os.Bundle arguments = getArguments();
        if (arguments != null) {
            this.f_renamed = arguments.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE);
            this.d_renamed = arguments.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID);
            this.e_renamed = arguments.getInt("camera_property_camera_id");
        }
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("VideoSoundSettingFragment.index", this.f6675c);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entries", this.h_renamed);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entryValues", this.i_renamed);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entrySummary", this.j_renamed);
    }

    @Override // androidx.preference.f_renamed
    public void a_renamed(boolean z_renamed) {
        int i_renamed;
        if (!z_renamed || (i_renamed = this.f6675c) < 0) {
            return;
        }
        java.lang.String string = this.i_renamed[i_renamed].toString();
        com.oplus.camera.ui.menu.setting.CameraCustomListPreference cameraCustomListPreferenceC = c_renamed();
        if (cameraCustomListPreferenceC.b_renamed((java.lang.Object) string)) {
            cameraCustomListPreferenceC.a_renamed(string);
        }
        if (com.oplus.camera.util.Util.D_renamed()) {
            android.content.SharedPreferences.Editor editorEdit = android.preference.PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_NOISE_FILTER, this.f6674b.isChecked() ? "on_renamed" : "off");
            editorEdit.apply();
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_NOISE_FILTER, this.f6674b.isChecked() ? com.oplus.camera.statistics.model.MenuClickMsgData.WNR_ON : com.oplus.camera.statistics.model.MenuClickMsgData.WNR_OFF);
        }
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        androidx.fragment.app.c_renamed activity = getActivity();
        com.coui.appcompat.dialog.app.b_renamed.a_renamed icon = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).setTitle(b_renamed().a_renamed()).setIcon(b_renamed().c_renamed());
        if (com.oplus.camera.util.Util.D_renamed()) {
            icon.setPositiveButton(getString(com.oplus.camera.R_renamed.string.beauty3d_save), this).setNegativeButton(b_renamed().e_renamed(), this);
            android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.video_sound_dewind_noise_switch_layout, (android.view.ViewGroup) null);
            this.f6673a = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.dewind_noise_text);
            this.f6674b = (com.coui.appcompat.widget.COUISwitch) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.dewind_noise_switch);
            a_renamed(this.f6675c);
            this.f6674b.setChecked("on_renamed".equals(android.preference.PreferenceManager.getDefaultSharedPreferences(activity).getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_NOISE_FILTER, "on_renamed")));
            a_renamed(viewInflate);
            icon.setView(viewInflate);
        } else {
            icon.setMessage(b_renamed().b_renamed());
        }
        a_renamed(icon);
        return icon.create();
    }

    private void a_renamed(java.lang.String str, java.lang.Object obj) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(getActivity());
        menuClickMsgData.mCaptureMode = this.f_renamed;
        menuClickMsgData.mCaptureType = 1;
        menuClickMsgData.mCameraId = this.e_renamed;
        menuClickMsgData.mOrientation = 0;
        menuClickMsgData.buildSettingMenuItem(str, obj);
        menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.e_renamed) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        menuClickMsgData.report();
    }
}
