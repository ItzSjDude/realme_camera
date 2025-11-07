package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraSettingActivityFragment.java */
/* loaded from: classes2.dex */
public class k_renamed extends com.oplus.camera.ui.menu.setting.b_renamed {
    private static final boolean f_renamed = com.oplus.camera.util.Util.h_renamed("oplus.software.video.surround_record_support");
    private static final boolean g_renamed = com.oplus.camera.util.Util.h_renamed("oplus.software.motor.breathled");
    private android.widget.Toast h_renamed = null;
    private com.oplus.camera.ComboPreferences i_renamed = null;
    private androidx.preference.PreferenceScreen j_renamed = null;
    private androidx.preference.Preference k_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory l_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference m_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference n_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference o_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference p_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference q_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference r_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference s_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory t_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference u_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference v_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference w_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference x_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference y_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference z_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference A_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference B_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory C_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference D_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference E_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference F_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory G_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference H_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference I_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference J_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference K_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference L_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference M_renamed = null;
    private androidx.preference.Preference N_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory O_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference P_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference Q_renamed = null;
    private androidx.preference.Preference R_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference S_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference T_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference U_renamed = null;
    private com.coui.appcompat.dialog.app.b_renamed V_renamed = null;
    private com.coui.appcompat.dialog.app.b_renamed W_renamed = null;
    private boolean X_renamed = true;
    private boolean Y_renamed = true;
    private boolean Z_renamed = true;
    private boolean aa_renamed = false;
    private boolean ab_renamed = false;
    private boolean ac_renamed = true;
    private boolean ad_renamed = false;
    private boolean ae_renamed = false;
    private boolean af_renamed = true;
    private boolean ag_renamed = true;
    private boolean ah_renamed = false;
    private boolean ai_renamed = true;
    private boolean aj_renamed = true;
    private boolean ak_renamed = true;
    private boolean al_renamed = true;
    private boolean am_renamed = true;
    private boolean an_renamed = true;
    private boolean ao_renamed = true;
    private boolean ap_renamed = true;
    private boolean aq_renamed = false;
    private boolean ar_renamed = true;
    private boolean as_renamed = false;
    private boolean at_renamed = false;
    private boolean au_renamed = false;
    private boolean av_renamed = false;
    private android.content.BroadcastReceiver aw_renamed = new android.content.BroadcastReceiver() { // from class: com.oplus.camera.ui.menu.setting.k_renamed.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String action = intent.getAction();
            com.oplus.camera.e_renamed.b_renamed("SettingActivityFragment", "onReceive(), action: " + action);
            if ("android.intent.action.MEDIA_MOUNTED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
                if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) || !com.oplus.camera.util.Util.c_renamed(com.oplus.camera.ui.menu.setting.k_renamed.this.o_renamed(), "com.coloros.movetosdcard") || com.oplus.camera.ui.menu.setting.k_renamed.this.i_renamed.getBoolean("pref_storage_save_to_external", false) || !com.oplus.camera.Storage.b_renamed(false)) {
                    com.oplus.camera.ui.menu.setting.k_renamed.this.j_renamed.d_renamed(com.oplus.camera.ui.menu.setting.k_renamed.this.k_renamed);
                } else if (com.oplus.camera.ui.menu.setting.k_renamed.this.a_renamed((java.lang.CharSequence) "pref_storage_save_to_external") == null) {
                    com.oplus.camera.ui.menu.setting.k_renamed.this.k_renamed.a_renamed(true);
                    com.oplus.camera.ui.menu.setting.k_renamed.this.j_renamed.c_renamed(com.oplus.camera.ui.menu.setting.k_renamed.this.k_renamed);
                }
            }
        }
    };

    private void N_renamed() {
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected int l_renamed() {
        return 3;
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed, com.oplus.camera.ui.menu.setting.c_renamed, com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed
    public void a_renamed(android.os.Bundle bundle, java.lang.String str) {
        super.a_renamed(bundle, str);
        com.oplus.camera.e_renamed.b_renamed("SettingActivityFragment", "onCreatePreferences start");
        ((com.oplus.camera.MyApplication) getContext().getApplicationContext()).i_renamed();
        b_renamed(com.oplus.camera.R_renamed.xml.camera_setting_preferences);
        v_renamed();
        R_renamed();
        S_renamed();
        this.av_renamed = this.i_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false);
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed, androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        c_renamed(getResources().getColor(com.oplus.camera.R_renamed.color.camera_setting_setting_bg_color));
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed, androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.oplus.camera.e_renamed.b_renamed("SettingActivityFragment", "onDestroyView: " + this);
        com.coui.appcompat.dialog.app.b_renamed bVar = this.V_renamed;
        if (bVar != null && bVar.isShowing()) {
            com.oplus.camera.e_renamed.a_renamed("SettingActivityFragment", "onDestroyView, mResetSettingDialog dismiss");
            this.V_renamed.dismiss();
        }
        this.V_renamed = null;
        com.coui.appcompat.dialog.app.b_renamed bVar2 = this.W_renamed;
        if (bVar2 != null && bVar2.isShowing()) {
            com.oplus.camera.e_renamed.a_renamed("SettingActivityFragment", "onDestroyView, mConfirmPhotoCodecDialog dismiss");
            this.W_renamed.dismiss();
        }
        this.W_renamed = null;
        ac_renamed();
        super.onDestroyView();
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    public java.lang.String p_renamed() {
        androidx.fragment.app.c_renamed activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected boolean a_renamed(android.os.Bundle bundle) {
        if (getActivity() != null && this.s_renamed != null && bundle.getBoolean("key_storage_dialog_show", false)) {
            this.s_renamed.c_renamed();
            return true;
        }
        if (getActivity() != null && bundle.getBoolean("key_reset_dialog_show", false)) {
            a_renamed(getActivity());
            return true;
        }
        return super.a_renamed(bundle);
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected void b_renamed(android.os.Bundle bundle) {
        super.b_renamed(bundle);
        com.coui.appcompat.dialog.app.b_renamed bVar = this.V_renamed;
        bundle.putBoolean("key_reset_dialog_show", bVar != null && bVar.isShowing());
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.s_renamed;
        bundle.putBoolean("key_storage_dialog_show", cameraSwitchPreference != null && cameraSwitchPreference.e_renamed());
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    protected void c_renamed(android.os.Bundle bundle) {
        com.oplus.camera.e_renamed.b_renamed("SettingActivityFragment", "parseActivityArguments start");
        if (bundle == null) {
            return;
        }
        this.X_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, true);
        this.Y_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION, true);
        this.Z_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, true);
        this.ac_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_IS_CAPTURE_MODE, true);
        this.ad_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_IS_VIDEO_MODE, false);
        this.ae_renamed = !android.text.TextUtils.isEmpty(bundle.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, null));
        this.af_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN, true);
        this.ag_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, false);
        this.ah_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY, false);
        this.ai_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RAW, true);
        this.aj_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER, true);
        this.ak_renamed = this.f6599c == 1;
        this.at_renamed = bundle.getBoolean("camera_enter_form_lock_screen", false);
        this.aa_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, true);
        this.ab_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, true);
        this.aq_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_SUPPORT_IN_CURRENT_MODE, false);
        this.al_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_KEY, true);
        this.am_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, true);
        this.an_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, true);
        this.ao_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265);
        this.ap_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE, true);
        this.au_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_QR_CODE, false);
        this.ar_renamed = bundle.getBoolean("allow_location", true);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:121:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:123:? A_renamed[RETURN, SYNTHETIC] */
    @Override // androidx.preference.Preference.b_renamed
    @android.annotation.SuppressLint({"ApplySharedPref"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onPreferenceChange(androidx.preference.Preference r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.k_renamed.onPreferenceChange(androidx.preference.Preference, java.lang.Object):boolean");
    }

    private boolean a_renamed(boolean z_renamed) {
        android.content.SharedPreferences.Editor editorEdit = this.i_renamed.edit();
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off");
        }
        if (!"on_renamed".equals(this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off"))) {
            java.lang.String str = z_renamed ? "HEIF" : "JPEG";
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, str);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
        } else if (z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "HEIF");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "HEIF");
        } else {
            editorEdit.apply();
            t_renamed();
            return false;
        }
        editorEdit.apply();
        return true;
    }

    private void t_renamed() {
        android.content.Context context = getContext();
        if (context != null) {
            this.W_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(context).setCustomTitle(android.view.LayoutInflater.from(context).inflate(com.oplus.camera.R_renamed.layout.capture_format_dialog_layout, (android.view.ViewGroup) null)).setPositiveButton(android.R_renamed.string.ok, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.k_renamed.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                    android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.menu.setting.k_renamed.this.i_renamed.edit();
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "JPEG");
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
                    com.oplus.camera.ui.menu.setting.k_renamed.this.A_renamed.e_renamed(false);
                    com.oplus.camera.ui.menu.setting.k_renamed.this.B_renamed.e_renamed(false);
                    editorEdit.apply();
                    com.oplus.camera.ui.menu.setting.k_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                }
            }).setNegativeButton(android.R_renamed.string.cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.k_renamed.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                    dialogInterface.dismiss();
                }
            }).create();
            this.W_renamed.show();
        }
    }

    private void b_renamed(boolean z_renamed) {
        java.lang.String str = z_renamed ? com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265 : com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264;
        android.content.SharedPreferences.Editor editorEdit = this.i_renamed.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, str);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off");
        }
        editorEdit.apply();
    }

    private void c_renamed(boolean z_renamed) {
        this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, z_renamed ? "on_renamed" : "off").apply();
    }

    private java.lang.String u_renamed() {
        return n_renamed() ? com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT : com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR;
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    protected void q_renamed() {
        C_renamed();
        E_renamed();
        F_renamed();
        G_renamed();
        N_renamed();
    }

    @Override // com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed, androidx.preference.j_renamed.a_renamed
    public void b_renamed(androidx.preference.Preference preference) {
        androidx.fragment.app.h_renamed fragmentManager = getFragmentManager();
        if (fragmentManager == null || fragmentManager.a_renamed("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        androidx.fragment.app.b_renamed bVarA = null;
        if (preference instanceof com.oplus.camera.ui.menu.setting.CameraCustomListPreference) {
            if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR.equals(preference.B_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(preference.B_renamed())) {
                bVarA = com.oplus.camera.ui.menu.setting.r_renamed.a_renamed(preference.B_renamed(), this.f6598b, this.d_renamed, this.e_renamed);
            } else {
                bVarA = com.oplus.camera.ui.menu.setting.e_renamed.a_renamed(preference.B_renamed());
            }
        } else {
            super.b_renamed(preference);
        }
        if (bVarA != null) {
            bVarA.setTargetFragment(this, 0);
            bVarA.show(fragmentManager, "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    protected void r_renamed() {
        androidx.fragment.app.c_renamed activity = getActivity();
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) || !com.oplus.camera.util.Util.c_renamed(o_renamed(), "com.coloros.movetosdcard") || this.as_renamed || activity == null) {
            return;
        }
        this.as_renamed = true;
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        activity.getApplicationContext().registerReceiver(this.aw_renamed, intentFilter, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    protected void s_renamed() {
        androidx.fragment.app.c_renamed activity = getActivity();
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) && com.oplus.camera.util.Util.c_renamed(o_renamed(), "com.coloros.movetosdcard") && this.as_renamed && activity != null) {
            this.as_renamed = false;
            activity.getApplicationContext().unregisterReceiver(this.aw_renamed);
        }
    }

    private void v_renamed() {
        this.i_renamed = new com.oplus.camera.ComboPreferences(o_renamed());
        this.i_renamed.setLocalId(o_renamed(), this.d_renamed);
        this.j_renamed = (androidx.preference.PreferenceScreen) a_renamed("camera_setting_menu_root_preference");
        w_renamed();
        x_renamed();
        y_renamed();
        z_renamed();
        A_renamed();
        B_renamed();
    }

    private void w_renamed() {
        this.k_renamed = a_renamed("pref_storage_save_to_external");
        this.k_renamed.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
    }

    private void x_renamed() {
        this.l_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_common_function");
        this.m_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_WATERMARK_SETTING_IMAGE);
        this.n_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_REFERENCE_LINE);
        this.o_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER);
        this.p_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR_SETTING);
        this.q_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_SOUND);
        this.r_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION);
        this.s_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE);
        this.U_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_FINGERPRINT_SHUTTER);
        com.coui.appcompat.preference.COUIJumpPreference cOUIJumpPreference = this.m_renamed;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                this.m_renamed.b_renamed((android.graphics.drawable.Drawable) null);
            }
        }
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.n_renamed;
        if (cOUIListPreference != null) {
            cOUIListPreference.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.o_renamed;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.o_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference2 = this.p_renamed;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.p_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference3 = this.q_renamed;
        if (cameraSwitchPreference3 != null) {
            cameraSwitchPreference3.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.q_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference4 = this.r_renamed;
        if (cameraSwitchPreference4 != null) {
            cameraSwitchPreference4.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            this.r_renamed.a_renamed(this.ar_renamed);
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.r_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference5 = this.s_renamed;
        if (cameraSwitchPreference5 != null) {
            cameraSwitchPreference5.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.s_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference6 = this.U_renamed;
        if (cameraSwitchPreference6 != null) {
            cameraSwitchPreference6.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
    }

    private void y_renamed() {
        this.t_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_capture_function");
        this.u_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE);
        this.v_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SHUTTER_HELP);
        this.w_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
        this.x_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY);
        this.y_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT);
        this.z_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN);
        this.A_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE);
        this.B_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HEIF_FORMAT);
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.u_renamed;
        if (cOUIListPreference != null) {
            cOUIListPreference.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        com.coui.appcompat.preference.COUIJumpPreference cOUIJumpPreference = this.v_renamed;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                this.v_renamed.b_renamed((android.graphics.drawable.Drawable) null);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.w_renamed;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.w_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference2 = this.x_renamed;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.x_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference3 = this.y_renamed;
        if (cameraSwitchPreference3 != null) {
            cameraSwitchPreference3.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.y_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference4 = this.z_renamed;
        if (cameraSwitchPreference4 != null) {
            cameraSwitchPreference4.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.z_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference5 = this.A_renamed;
        if (cameraSwitchPreference5 != null) {
            cameraSwitchPreference5.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.A_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference6 = this.B_renamed;
        if (cameraSwitchPreference6 != null) {
            cameraSwitchPreference6.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.B_renamed);
            }
        }
        this.S_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ADVANCE_SETTING_IMAGE);
        this.T_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BUILD_IMAGE_SETTING);
        com.coui.appcompat.preference.COUIJumpPreference cOUIJumpPreference2 = this.S_renamed;
        if (cOUIJumpPreference2 != null) {
            cOUIJumpPreference2.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                this.S_renamed.b_renamed((android.graphics.drawable.Drawable) null);
            }
        }
        com.coui.appcompat.preference.COUIJumpPreference cOUIJumpPreference3 = this.T_renamed;
        if (cOUIJumpPreference3 != null) {
            cOUIJumpPreference3.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                this.T_renamed.b_renamed((android.graphics.drawable.Drawable) null);
            }
        }
    }

    private void z_renamed() {
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference;
        this.C_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_video_function");
        this.D_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_EFFECT_KEY);
        this.E_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TRACK_FOCUS);
        this.F_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HEVC_VIDEO_FORMAT);
        if (f_renamed && (cOUIListPreference = this.D_renamed) != null) {
            cOUIListPreference.a_renamed((java.lang.CharSequence[]) getResources().getStringArray(com.oplus.camera.R_renamed.array.setting_video_sound_summaries));
            this.D_renamed.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        if (this.E_renamed != null) {
            aa_renamed();
            this.E_renamed.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.E_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.F_renamed;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.F_renamed);
            }
        }
        this.av_renamed = this.i_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false);
    }

    private void A_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference;
        this.G_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_camera_utility_function");
        this.H_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VOLUME_KEY_FUNCTION);
        this.I_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH);
        this.J_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER);
        this.K_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_QR_CODE);
        this.L_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_AND_MARK);
        this.M_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION);
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.H_renamed;
        if (cOUIListPreference != null) {
            cOUIListPreference.a_renamed((androidx.preference.Preference.b_renamed) this);
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference2 = this.I_renamed;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.I_renamed);
            }
        }
        if (g_renamed && (cameraSwitchPreference = this.J_renamed) != null) {
            cameraSwitchPreference.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.J_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference3 = this.K_renamed;
        if (cameraSwitchPreference3 != null) {
            cameraSwitchPreference3.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.K_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference4 = this.L_renamed;
        if (cameraSwitchPreference4 != null) {
            cameraSwitchPreference4.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.L_renamed);
            }
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference5 = this.M_renamed;
        if (cameraSwitchPreference5 != null) {
            cameraSwitchPreference5.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.M_renamed);
            }
        }
    }

    private void B_renamed() {
        this.O_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_help_and_feedback_function");
        this.N_renamed = a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_TYPE);
        this.P_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HELP_AND_FEEDBACK);
        this.Q_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING_ABOUT);
        this.R_renamed = a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_BLANK);
        androidx.preference.Preference preference = this.N_renamed;
        if (preference != null) {
            preference.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            this.N_renamed.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        com.coui.appcompat.preference.COUIJumpPreference cOUIJumpPreference = this.Q_renamed;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                this.Q_renamed.b_renamed((android.graphics.drawable.Drawable) null);
            }
        }
        if (this.P_renamed != null) {
            if (((com.oplus.camera.ui.menu.setting.CameraSettingActivity) getActivity()).m_renamed()) {
                this.P_renamed.a_renamed(false);
            }
            this.P_renamed.a_renamed((androidx.preference.Preference.c_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            this.P_renamed.a_renamed((androidx.preference.Preference.b_renamed) new com.oplus.camera.ui.menu.setting.$$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
                this.P_renamed.b_renamed((android.graphics.drawable.Drawable) null);
            }
        }
    }

    private void C_renamed() {
        com.coui.appcompat.preference.COUIJumpPreference cOUIJumpPreference = this.m_renamed;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.d_renamed((java.lang.CharSequence) getString(D_renamed() ? com.oplus.camera.R_renamed.string.camera_setting_slogan_on : com.oplus.camera.R_renamed.string.camera_setting_switch_off));
        }
        if (this.n_renamed != null) {
            java.lang.String string = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_PHOTO, "off");
            this.n_renamed.c_renamed(c_renamed(this.n_renamed, string == null ? "" : string));
            this.n_renamed.a_renamed(string);
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.o_renamed;
        if (cameraSwitchPreference != null) {
            this.o_renamed.e_renamed("on_renamed".equals(this.i_renamed.getString(cameraSwitchPreference.B_renamed(), "off")));
        }
        if (this.p_renamed != null) {
            this.p_renamed.e_renamed(!"on_renamed".equals(this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR, "off")));
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference2 = this.q_renamed;
        if (cameraSwitchPreference2 != null) {
            this.q_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference2.L_renamed().getString(this.q_renamed.B_renamed(), "off")));
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference3 = this.r_renamed;
        if (cameraSwitchPreference3 != null) {
            this.r_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference3.L_renamed().getString(this.r_renamed.B_renamed(), "off")) && com.oplus.camera.util.Util.x_renamed(getActivity()));
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference4 = this.U_renamed;
        if (cameraSwitchPreference4 != null) {
            this.U_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference4.L_renamed().getString(this.U_renamed.B_renamed(), getString(com.oplus.camera.R_renamed.string.camera_fingerprint_capture_default_value))));
        }
        if (this.s_renamed != null) {
            if (this.l_renamed != null) {
                if (!com.oplus.camera.Storage.b_renamed(false)) {
                    this.l_renamed.d_renamed(this.s_renamed);
                    return;
                }
                if (this.l_renamed.d_renamed((java.lang.CharSequence) com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                    this.s_renamed.a_renamed(true);
                    this.l_renamed.c_renamed((androidx.preference.Preference) this.s_renamed);
                }
                if (!com.oplus.camera.util.Util.ac_renamed()) {
                    this.s_renamed.a_renamed(false);
                    this.s_renamed.c_renamed((java.lang.Object) false);
                    return;
                }
            }
            if (com.oplus.camera.Storage.b_renamed(true) && 8.0d > com.oplus.camera.Storage.g_renamed()) {
                this.s_renamed.c_renamed((java.lang.Object) true);
            } else {
                this.s_renamed.c_renamed((java.lang.Object) false);
            }
            this.s_renamed.e_renamed("on_renamed".equals(this.s_renamed.L_renamed().getString(this.s_renamed.B_renamed(), "off")));
        }
    }

    private boolean D_renamed() {
        return "on_renamed".equals(this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"));
    }

    private void E_renamed() {
        L_renamed();
        M_renamed();
        Y_renamed();
        W_renamed();
        T_renamed();
        U_renamed();
        V_renamed();
    }

    private void F_renamed() {
        Q_renamed();
        Z_renamed();
        ab_renamed();
    }

    private void G_renamed() {
        K_renamed();
        J_renamed();
        O_renamed();
        P_renamed();
        I_renamed();
        H_renamed();
    }

    private void H_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.M_renamed;
        if (cameraSwitchPreference != null) {
            this.M_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.M_renamed.B_renamed(), "on_renamed")));
        }
    }

    private void I_renamed() {
        if (this.L_renamed != null) {
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SHARE_EDIT_SUPPORT)) {
                this.L_renamed.e_renamed(false);
                this.L_renamed.a_renamed(false);
            } else {
                this.L_renamed.e_renamed("on_renamed".equals(this.L_renamed.L_renamed().getString(this.L_renamed.B_renamed(), "on_renamed")));
            }
        }
    }

    private void J_renamed() {
        if (this.I_renamed != null) {
            androidx.fragment.app.c_renamed activity = getActivity();
            this.I_renamed.e_renamed((activity != null ? android.provider.Settings.Secure.getInt(activity.getContentResolver(), "com.oplus.camera quick launch", 0) : 0) != 0);
        }
    }

    private void K_renamed() {
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.H_renamed;
        if (cOUIListPreference != null) {
            java.lang.String string = cOUIListPreference.L_renamed().getString(this.H_renamed.B_renamed(), getString(com.oplus.camera.R_renamed.string.camera_volume_key_function_default_value));
            this.H_renamed.c_renamed(c_renamed(this.H_renamed, string));
            this.H_renamed.a_renamed(string);
        }
    }

    private void L_renamed() {
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.u_renamed;
        if (cOUIListPreference != null) {
            java.lang.String string = cOUIListPreference.L_renamed().getString(this.u_renamed.B_renamed(), getString(com.oplus.camera.R_renamed.string.camera_setting_long_process_shutter_default_value));
            this.u_renamed.c_renamed(c_renamed(this.u_renamed, string));
            this.u_renamed.a_renamed(string);
        }
    }

    private void M_renamed() {
        if (this.w_renamed != null) {
            this.w_renamed.e_renamed("on_renamed".equals(this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.d_renamed))));
        }
    }

    private void O_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference;
        if (!g_renamed || (cameraSwitchPreference = this.J_renamed) == null) {
            return;
        }
        this.J_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.J_renamed.B_renamed(), "on_renamed")));
    }

    private void P_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.K_renamed;
        if (cameraSwitchPreference != null) {
            this.K_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.K_renamed.B_renamed(), "off")));
            this.K_renamed.a_renamed(this.ak_renamed && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_QR_CODE_ENABLE) && this.au_renamed);
        }
    }

    private void Q_renamed() {
        if (this.D_renamed != null) {
            if ("normal".equals(this.i_renamed.getString(u_renamed(), "all_around"))) {
                this.D_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_video_normal_sound));
                this.D_renamed.a_renamed("normal");
            } else {
                this.D_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_video_all_round_sound));
                this.D_renamed.a_renamed("all_around");
            }
            this.D_renamed.a_renamed(f_renamed);
        }
    }

    private void R_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference;
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference2;
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference3;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory;
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference4;
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference;
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference5;
        com.oplus.camera.e_renamed.b_renamed("SettingActivityFragment", "addOrRemoveCameraPreference()");
        if (this.l_renamed != null && this.s_renamed != null) {
            if (!com.oplus.camera.Storage.b_renamed(false)) {
                this.l_renamed.d_renamed(this.s_renamed);
            } else if (this.l_renamed.d_renamed((java.lang.CharSequence) com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                this.l_renamed.c_renamed((androidx.preference.Preference) this.s_renamed);
            }
        }
        if (this.t_renamed != null) {
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT)) {
                this.t_renamed.d_renamed(this.u_renamed);
            }
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_RECTIFY_SUPPORT)) {
                this.t_renamed.d_renamed(this.x_renamed);
            }
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_CLEAR_PORTRAIT)) {
                this.t_renamed.d_renamed(this.y_renamed);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
                this.t_renamed.d_renamed(this.z_renamed);
            }
            if (!this.ab_renamed) {
                this.t_renamed.d_renamed(this.A_renamed);
            }
            if (!this.aa_renamed && (cameraSwitchPreference5 = this.B_renamed) != null) {
                this.t_renamed.d_renamed(cameraSwitchPreference5);
            }
        }
        if (this.C_renamed != null) {
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)) {
                this.C_renamed.d_renamed(this.E_renamed);
            }
            this.C_renamed.c_renamed((java.lang.CharSequence) (n_renamed() ? com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR : com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT));
            if (!f_renamed && (cOUIListPreference = this.D_renamed) != null) {
                this.C_renamed.d_renamed(cOUIListPreference);
            }
            if (!this.am_renamed && (cameraSwitchPreference4 = this.F_renamed) != null) {
                this.C_renamed.d_renamed(cameraSwitchPreference4);
            }
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_RECTIFY_SUPPORT) && (cOUIPreferenceCategory = this.t_renamed) != null) {
                cOUIPreferenceCategory.d_renamed(this.x_renamed);
            }
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory2 = this.G_renamed;
        if (cOUIPreferenceCategory2 != null) {
            if (!this.Y_renamed && (cameraSwitchPreference3 = this.M_renamed) != null) {
                cOUIPreferenceCategory2.d_renamed(cameraSwitchPreference3);
            }
            if (g_renamed) {
                this.G_renamed.c_renamed((androidx.preference.Preference) this.J_renamed);
            } else {
                this.G_renamed.d_renamed(this.J_renamed);
            }
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SHARE_EDIT_SUPPORT) && (cameraSwitchPreference2 = this.L_renamed) != null) {
                this.G_renamed.d_renamed(cameraSwitchPreference2);
            }
            if (!this.an_renamed && (cameraSwitchPreference = this.I_renamed) != null) {
                this.G_renamed.d_renamed(cameraSwitchPreference);
            }
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory3 = this.O_renamed;
        if (cOUIPreferenceCategory3 != null) {
            com.oplus.camera.l_renamed.c_renamed.a_renamed(cOUIPreferenceCategory3, this.P_renamed);
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) || !com.oplus.camera.util.Util.c_renamed(o_renamed(), "com.coloros.movetosdcard") || this.i_renamed.getBoolean("pref_storage_save_to_external", false) || !com.oplus.camera.Storage.b_renamed(false)) {
            this.j_renamed.d_renamed(this.k_renamed);
        }
        a_renamed(this.l_renamed);
        a_renamed(this.t_renamed);
        a_renamed(this.C_renamed);
        a_renamed(this.G_renamed);
        a_renamed(this.O_renamed);
    }

    private void S_renamed() {
        java.lang.String configStringValue;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT) && (configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT_MODE)) != null && 20 == java.lang.Integer.parseInt(configStringValue)) {
            this.I_renamed.a_renamed((java.lang.CharSequence) getResources().getString(com.oplus.camera.R_renamed.string.camera_subsetting_quick_launch_street_summary));
        }
    }

    private void a_renamed(com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory) {
        if (cOUIPreferenceCategory != null) {
            int i_renamed = 0;
            while (i_renamed < cOUIPreferenceCategory.c_renamed()) {
                androidx.preference.Preference preferenceJ = cOUIPreferenceCategory.j_renamed(i_renamed);
                if (preferenceJ != null && !com.oplus.camera.aps.config.CameraConfig.getSupportSettingMenuKey(preferenceJ.B_renamed())) {
                    cOUIPreferenceCategory.d_renamed(preferenceJ);
                    i_renamed--;
                }
                i_renamed++;
            }
        }
    }

    private void T_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences;
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.z_renamed;
        if (cameraSwitchPreference != null) {
            this.z_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.z_renamed.B_renamed(), "on_renamed")));
            this.z_renamed.a_renamed(this.af_renamed && (((com.oplus.camera.ui.menu.setting.CameraSettingActivity) getActivity()).l_renamed() || (this.ac_renamed && this.ae_renamed)));
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI) || (comboPreferences = this.i_renamed) == null) {
            return;
        }
        this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN, comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, getResources().getString(com.oplus.camera.R_renamed.string.camera_pi_ai_default_value))).apply();
    }

    private void U_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference;
        if (!this.ab_renamed || (cameraSwitchPreference = this.A_renamed) == null) {
            return;
        }
        this.A_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.A_renamed.B_renamed(), "on_renamed")));
    }

    private void V_renamed() {
        if (this.B_renamed != null) {
            this.B_renamed.e_renamed("HEIF".equals(this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG")));
        }
    }

    private void W_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.y_renamed;
        if (cameraSwitchPreference != null) {
            this.y_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.y_renamed.B_renamed(), "off")));
            this.y_renamed.a_renamed(this.ag_renamed && (((com.oplus.camera.ui.menu.setting.CameraSettingActivity) getActivity()).l_renamed() || (this.ac_renamed && this.ae_renamed)));
        }
    }

    private void X_renamed() {
        if (this.i_renamed != null) {
            java.lang.String configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_RECTIFY_CONFIG_VALUE);
            java.lang.String string = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY_SET_DEFAULT_VALUE, "");
            if (android.text.TextUtils.isEmpty(configStringValue) || !android.text.TextUtils.isEmpty(string)) {
                return;
            }
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY, configStringValue).putString(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY_SET_DEFAULT_VALUE, "1").apply();
        }
    }

    private void Y_renamed() {
        if (this.x_renamed != null) {
            X_renamed();
            this.x_renamed.e_renamed("on_renamed".equals(this.x_renamed.L_renamed().getString(this.x_renamed.B_renamed(), "off")));
            this.x_renamed.a_renamed(this.ah_renamed && (((com.oplus.camera.ui.menu.setting.CameraSettingActivity) getActivity()).l_renamed() || (this.ac_renamed && this.ae_renamed)));
        }
    }

    private void Z_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.E_renamed;
        if (cameraSwitchPreference != null) {
            this.E_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.E_renamed.B_renamed(), "on_renamed")));
            aa_renamed();
        }
    }

    private void aa_renamed() {
        if (this.E_renamed != null) {
            java.lang.String string = this.i_renamed.getString(u_renamed(), "all_around");
            boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_60FPS_TRACK_FOCUS_SUPPORT);
            int i_renamed = configBooleanValue ? com.oplus.camera.R_renamed.string.camera_setting_auto_focus_summary : com.oplus.camera.R_renamed.string.camera_setting_auto_focus_not_support_60fps_summary;
            if (com.oplus.camera.util.Util.G_renamed() && !"normal".equals(string)) {
                i_renamed = configBooleanValue ? com.oplus.camera.R_renamed.string.camera_setting_auto_track_focus_both_video_audio_summary : com.oplus.camera.R_renamed.string.camera_setting_auto_track_focus_both_video_audio_not_support_60fps_summary;
            }
            this.E_renamed.f_renamed(i_renamed);
        }
    }

    private void ab_renamed() {
        if (this.F_renamed != null) {
            boolean z_renamed = this.ao_renamed;
            java.lang.String string = com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264;
            if (z_renamed) {
                string = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264);
            }
            this.F_renamed.e_renamed(com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(string));
        }
    }

    private void ac_renamed() {
        com.oplus.camera.e_renamed.b_renamed("SettingActivityFragment", "releasePreferences");
        if (this.s_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("SettingActivityFragment", "onDestroyView, Storage Dialog dismiss");
            if (this.s_renamed.e_renamed()) {
                this.s_renamed.f_renamed();
            }
            this.s_renamed.d_renamed();
            this.s_renamed = null;
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.r_renamed;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.d_renamed();
            this.r_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory = this.l_renamed;
        if (cOUIPreferenceCategory != null) {
            cOUIPreferenceCategory.d_renamed();
            this.l_renamed = null;
        }
        this.H_renamed = null;
        this.S_renamed = null;
        this.T_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.U_renamed = null;
        this.q_renamed = null;
        this.u_renamed = null;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory2 = this.t_renamed;
        if (cOUIPreferenceCategory2 != null) {
            cOUIPreferenceCategory2.d_renamed();
            this.t_renamed = null;
        }
        this.J_renamed = null;
        this.z_renamed = null;
        this.y_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory3 = this.C_renamed;
        if (cOUIPreferenceCategory3 != null) {
            cOUIPreferenceCategory3.d_renamed();
            this.C_renamed = null;
        }
        this.D_renamed = null;
        androidx.preference.PreferenceScreen preferenceScreen = this.j_renamed;
        if (preferenceScreen != null) {
            preferenceScreen.d_renamed();
            this.j_renamed = null;
        }
        com.oplus.camera.ComboPreferences comboPreferences = this.i_renamed;
        if (comboPreferences != null) {
            comboPreferences.a_renamed(o_renamed());
            this.i_renamed = null;
        }
        this.N_renamed = null;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory4 = this.O_renamed;
        if (cOUIPreferenceCategory4 != null) {
            cOUIPreferenceCategory4.d_renamed();
            this.O_renamed = null;
        }
        this.P_renamed = null;
        this.A_renamed = null;
        this.F_renamed = null;
        this.K_renamed = null;
        this.L_renamed = null;
        this.M_renamed = null;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x009b  */
    @Override // androidx.preference.Preference.c_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onPreferenceClick(androidx.preference.Preference r17) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.k_renamed.onPreferenceClick(androidx.preference.Preference):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad_renamed() throws android.content.pm.PackageManager.NameNotFoundException {
        if (com.oplus.camera.util.f_renamed.a_renamed(getActivity(), "com.oplus.vip")) {
            com.oplus.camera.util.f_renamed.a_renamed(getActivity(), java.lang.String.format(getActivity().getResources().getString(com.oplus.camera.R_renamed.string.camera_disable_com_oplus_vip), com.oplus.camera.util.f_renamed.b_renamed(getActivity(), "com.oplus.vip")), "com.oplus.vip", "");
        } else {
            com.oplus.camera.l_renamed.b_renamed(com.oplus.camera.util.Util.l_renamed());
        }
    }

    private void a_renamed(android.app.Activity activity) {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.V_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.V_renamed.dismiss();
        }
        this.V_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).f_renamed(1).setNeutralButton(getString(com.oplus.camera.R_renamed.string.camera_setting_restore_default), new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.k_renamed.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.menu.setting.k_renamed.this.ae_renamed();
                com.oplus.camera.ui.menu.setting.k_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_TYPE, (java.lang.Object) true);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(android.R_renamed.string.cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.k_renamed.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.menu.setting.k_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_TYPE, (java.lang.Object) false);
                dialogInterface.dismiss();
            }
        }).create();
        if (activity.isFinishing()) {
            return;
        }
        this.V_renamed.show();
        if (this.V_renamed.a_renamed(-3) == null || !com.oplus.camera.util.Util.ao_renamed()) {
            return;
        }
        this.V_renamed.a_renamed(-3).setTextColor(getContext().getColor(com.oplus.camera.R_renamed.color.color_primary_light_hasselblad));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae_renamed() {
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity != null) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_CODEC, "").apply();
            af_renamed();
            androidx.preference.j_renamed.a_renamed((android.content.Context) activity, com.oplus.camera.R_renamed.xml.camera_setting_preferences, true);
            if (f_renamed) {
                android.content.SharedPreferences.Editor editorEdit = androidx.preference.j_renamed.a_renamed(getActivity()).edit();
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_NOISE_FILTER, "on_renamed");
                editorEdit.apply();
            }
            q_renamed();
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("SettingActivityFragment", "restore Camera settings failed, due to activity is_renamed null!");
    }

    private void af_renamed() {
        com.oplus.compat.a_renamed.a_renamed.SettingsNative_2.a_renamed("com.oplus.camera quick launch", 0);
        android.content.SharedPreferences.Editor editorEdit = this.i_renamed.edit();
        editorEdit.remove(this.H_renamed.B_renamed());
        editorEdit.remove(this.q_renamed.B_renamed());
        editorEdit.remove(this.r_renamed.B_renamed());
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_AND_MARK);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_ASSISTANT_LINE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_QR_CODE);
        editorEdit.remove(this.z_renamed.B_renamed());
        editorEdit.remove(this.y_renamed.B_renamed());
        editorEdit.remove(this.x_renamed.B_renamed());
        editorEdit.remove(this.E_renamed.B_renamed());
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_SLOGAN_CUSTOMIZE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_RAW);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_BACKUP);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT);
        editorEdit.remove(this.P_renamed.B_renamed());
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_PHOTO);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_FINGERPRINT_SHUTTER);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE_BACKUP);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY_SET_DEFAULT_VALUE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_PHONE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME);
        editorEdit.remove(this.p_renamed.B_renamed());
        editorEdit.apply();
    }

    private void b_renamed(java.lang.String str) {
        a_renamed(str, 0);
    }

    private void a_renamed(java.lang.String str, int i_renamed) {
        android.content.Intent intent = new android.content.Intent(str);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("camera_entry_from", ((com.oplus.camera.ui.menu.setting.CameraSettingActivity) getActivity()).l_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.X_renamed);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION, this.Y_renamed);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.Z_renamed);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, this.aa_renamed);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, this.ab_renamed);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_IS_CAPTURE_MODE, this.ac_renamed);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER, this.aj_renamed);
        bundle.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, this.d_renamed);
        bundle.putInt("camera_enter_type", this.f6599c);
        bundle.putInt("camera_property_camera_id", this.e_renamed);
        bundle.putBoolean("camera_enter_form_lock_screen", this.at_renamed);
        bundle.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, this.f6598b);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_IS_VIDEO_MODE, this.ad_renamed);
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, this.an_renamed);
        bundle.putInt("camera_sub_setting_from", i_renamed);
        bundle.putBoolean("allow_location", this.ar_renamed);
        intent.putExtra("camera_intent_data", bundle);
        startActivity(intent);
    }

    private static java.lang.CharSequence c_renamed(androidx.preference.Preference preference, java.lang.Object obj) {
        java.lang.String string = obj.toString();
        if (!(preference instanceof androidx.preference.ListPreference)) {
            return string;
        }
        androidx.preference.ListPreference listPreference = (androidx.preference.ListPreference) preference;
        int iB = listPreference.b_renamed(string);
        return iB >= 0 ? listPreference.l_renamed()[iB] : "";
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    public void j_renamed() {
        android.content.SharedPreferences.Editor editorEdit = this.i_renamed.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, "on_renamed");
        editorEdit.apply();
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.r_renamed;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.e_renamed(true);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    public void k_renamed() {
        android.content.SharedPreferences.Editor editorEdit = this.i_renamed.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, "off");
        editorEdit.apply();
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.r_renamed;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.e_renamed(false);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected void m_renamed() {
        if (this.r_renamed == null || this.i_renamed == null || com.oplus.camera.util.Util.x_renamed(getActivity())) {
            return;
        }
        this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, "off").apply();
        this.r_renamed.e_renamed(false);
    }
}
