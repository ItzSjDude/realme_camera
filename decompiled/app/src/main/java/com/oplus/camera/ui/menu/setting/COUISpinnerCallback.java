package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraSubSettingFragment.java */
/* loaded from: classes2.dex */
public class p_renamed extends com.oplus.camera.ui.menu.setting.b_renamed {
    private static java.lang.String f_renamed = "、";
    private int g_renamed = 0;
    private com.oplus.camera.ComboPreferences h_renamed = null;
    private androidx.preference.PreferenceScreen i_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory j_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory k_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory l_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory m_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory n_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory o_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory p_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory q_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory r_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory s_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory t_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory u_renamed = null;
    private com.coui.appcompat.preference.COUIPreferenceCategory v_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference w_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference x_renamed = null;
    private com.android.ui.menu.CameraShutterSettingPreference y_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference z_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference A_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference B_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference C_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference D_renamed = null;
    private com.coui.appcompat.preference.COUIMarkPreference E_renamed = null;
    private com.coui.appcompat.preference.COUIMarkPreference F_renamed = null;
    private com.coui.appcompat.preference.COUIMarkPreference G_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference H_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference I_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference J_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference K_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference L_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference M_renamed = null;
    private com.coui.appcompat.preference.COUIJumpPreference N_renamed = null;
    private androidx.preference.Preference O_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference P_renamed = null;
    private com.android.ui.menu.CameraWatermarkVisualPreference Q_renamed = null;
    private com.coui.appcompat.preference.COUIPreference R_renamed = null;
    private com.coui.appcompat.preference.COUIMultiSelectListPreference S_renamed = null;
    private com.coui.appcompat.preference.COUISwitchPreference T_renamed = null;
    private com.coui.appcompat.preference.COUISwitchPreference U_renamed = null;
    private com.coui.appcompat.preference.COUISwitchPreference V_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference W_renamed = null;
    private com.coui.appcompat.preference.COUIListPreference X_renamed = null;
    private com.android.ui.menu.a_renamed Y_renamed = null;
    private com.coui.appcompat.dialog.panel.b_renamed Z_renamed = null;
    private com.android.ui.menu.CameraSwitchPreference aa_renamed = null;
    private com.android.ui.menu.CameraWatermarkVisualPreference ab_renamed = null;
    private long ac_renamed = 0;
    private boolean ad_renamed = true;
    private boolean ae_renamed = false;
    private boolean af_renamed = true;
    private boolean ag_renamed = true;
    private boolean ah_renamed = false;
    private boolean ai_renamed = false;
    private boolean aj_renamed = true;
    private boolean ak_renamed = false;
    private boolean al_renamed = false;
    private boolean am_renamed = false;
    private boolean an_renamed = false;
    private int ao_renamed = 0;
    private boolean ap_renamed = true;
    private boolean aq_renamed = false;
    private java.lang.String ar_renamed = null;
    private android.location.Location as_renamed = null;
    private com.oplus.camera.x_renamed at_renamed = null;
    private androidx.recyclerview.widget.RecyclerView au_renamed = null;
    private com.android.ui.menu.a_renamed.InterfaceC0052a av_renamed = new com.android.ui.menu.a_renamed.InterfaceC0052a() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.4
        @Override // com.android.ui.menu.a_renamed.InterfaceC0052a
        public boolean a_renamed(java.lang.CharSequence charSequence, java.util.Set<java.lang.String> set) {
            if (charSequence.equals(com.oplus.camera.ui.menu.setting.p_renamed.this.getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_info_option_location)) && set.contains("Location")) {
                return com.oplus.camera.ui.menu.setting.p_renamed.this.i_renamed() && com.oplus.camera.c_renamed.a_renamed(com.oplus.camera.ui.menu.setting.p_renamed.this.getActivity(), com.oplus.camera.ui.menu.setting.p_renamed.this.h_renamed);
            }
            return set.contains(charSequence.toString());
        }

        @Override // com.android.ui.menu.a_renamed.InterfaceC0052a
        public boolean a_renamed(java.lang.CharSequence charSequence, int i_renamed) {
            if (i_renamed == 0 && com.oplus.camera.ui.menu.setting.p_renamed.this.getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_info_option_location).equals(charSequence.toString())) {
                return !com.oplus.camera.ui.menu.setting.p_renamed.this.h_renamed();
            }
            return false;
        }

        @Override // com.android.ui.menu.a_renamed.InterfaceC0052a
        public void a_renamed(java.lang.String str) {
            com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, com.oplus.camera.ui.menu.setting.p_renamed.this.S_renamed.m_renamed().toString().replace("[", "").replace("]", "").replace(",", com.oplus.camera.statistics.model.DcsMsgData.DIVIDER), str);
        }
    };
    private android.content.BroadcastReceiver aw_renamed = new android.content.BroadcastReceiver() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.11
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String action = intent.getAction();
            com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "onReceive(), action: " + action);
            if ("android.intent.action.MEDIA_MOUNTED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
                com.oplus.camera.ui.menu.setting.p_renamed.this.B_renamed();
            }
        }
    };
    private com.oplus.camera.q_renamed.f_renamed ax_renamed = new com.oplus.camera.q_renamed.f_renamed() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.2
        @Override // com.oplus.camera.q_renamed.f_renamed
        public void a_renamed(android.location.Location location, boolean z_renamed) {
            if (location == null || com.oplus.camera.ui.menu.setting.p_renamed.this.getContext() == null) {
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("CameraSubSettingFragment", "onLocationUpdated");
            if (!com.oplus.camera.c_renamed.a_renamed(com.oplus.camera.MyApplication.d_renamed(), com.oplus.camera.ui.menu.setting.p_renamed.this.h_renamed)) {
                com.oplus.camera.e_renamed.a_renamed("CameraSubSettingFragment", "onLocationUpdated watermark of_renamed location is_renamed closed");
                com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(location);
                return;
            }
            if (z_renamed && "zh-CN".equals(com.oplus.camera.util.Util.ax_renamed())) {
                com.oplus.camera.q_renamed.a_renamed aVarA = com.oplus.camera.util.h_renamed.a_renamed(com.oplus.camera.MyApplication.d_renamed(), location);
                com.oplus.camera.e_renamed.a_renamed("CameraSubSettingFragment", "onLocationUpdated, isLastKnownLocation");
                if (aVarA != null) {
                    aVarA.i_renamed = location;
                    com.oplus.camera.ui.menu.setting.p_renamed.this.ar_renamed = com.oplus.camera.util.h_renamed.a_renamed(com.oplus.camera.MyApplication.d_renamed(), aVarA);
                    com.oplus.camera.ui.menu.setting.p_renamed pVar = com.oplus.camera.ui.menu.setting.p_renamed.this;
                    pVar.a_renamed(pVar.getActivity());
                    return;
                }
            }
            com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(location);
        }
    };
    private java.lang.Runnable ay_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.3
        @Override // java.lang.Runnable
        public void run() throws java.io.IOException {
            android.location.Address addressA = com.oplus.camera.util.Util.a_renamed(com.oplus.camera.MyApplication.d_renamed(), com.oplus.camera.ui.menu.setting.p_renamed.this.as_renamed, true);
            if (addressA == null) {
                com.oplus.camera.e_renamed.e_renamed("CameraSubSettingFragment", "getAddressRunnable, address is_renamed null, return");
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("CameraSubSettingFragment", "getAddressRunnable");
            com.oplus.camera.q_renamed.a_renamed aVarA = com.oplus.camera.util.h_renamed.a_renamed(addressA);
            com.oplus.camera.ui.menu.setting.p_renamed.this.ar_renamed = com.oplus.camera.util.h_renamed.a_renamed(com.oplus.camera.MyApplication.d_renamed(), aVarA);
            com.oplus.camera.ui.menu.setting.p_renamed pVar = com.oplus.camera.ui.menu.setting.p_renamed.this;
            pVar.a_renamed(pVar.getActivity());
        }
    };

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected int l_renamed() {
        return 4;
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed, com.oplus.camera.ui.menu.setting.c_renamed, com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed
    public void a_renamed(android.os.Bundle bundle, java.lang.String str) throws android.content.res.Resources.NotFoundException {
        super.a_renamed(bundle, str);
        ((com.oplus.camera.MyApplication) getContext().getApplicationContext()).i_renamed();
        com.oplus.camera.e_renamed.f_renamed("CameraSubSettingFragment", "onCreatePreferences");
        if (com.oplus.camera.util.Util.aq_renamed()) {
            f_renamed = "、";
        } else {
            f_renamed = ",";
        }
        this.at_renamed = new com.oplus.camera.x_renamed(this.h_renamed);
        com.oplus.camera.x_renamed xVar = this.at_renamed;
        if (xVar != null && 2 == this.ao_renamed) {
            xVar.a_renamed(getActivity());
            this.at_renamed.a_renamed();
        }
        if (com.oplus.camera.util.Util.t_renamed()) {
            b_renamed(com.oplus.camera.R_renamed.xml.camera_setting_sub_preferences_fold);
        } else {
            b_renamed(com.oplus.camera.R_renamed.xml.camera_setting_sub_preferences);
        }
        t_renamed();
        v_renamed();
        u_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed, androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        c_renamed(getResources().getColor(com.oplus.camera.R_renamed.color.camera_setting_setting_bg_color));
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (2 == this.ao_renamed) {
            com.oplus.camera.q_renamed.a_renamed().a_renamed(this.ax_renamed);
            com.oplus.camera.q_renamed.a_renamed().b_renamed(this.h_renamed);
        }
    }

    @Override // com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed
    public androidx.recyclerview.widget.RecyclerView a_renamed(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.au_renamed = super.a_renamed(layoutInflater, viewGroup, bundle);
        return this.au_renamed;
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.au_renamed = null;
    }

    private void t_renamed() {
        a_renamed().b_renamed((java.lang.CharSequence) p_renamed());
        this.h_renamed = new com.oplus.camera.ComboPreferences(o_renamed());
        this.h_renamed.setLocalId(o_renamed(), this.d_renamed);
        this.i_renamed = (androidx.preference.PreferenceScreen) a_renamed("camera_setting_advance_root_preference");
        this.O_renamed = a_renamed("pref_bottom_line");
        this.j_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_shutter_setting_function");
        this.k_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_self_setting_function");
        this.l_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_lens_dirty_detection_function");
        this.m_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_other_setting_function");
        this.n_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_build_image_setting_function");
        this.o_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_gradienter_setting_function");
        this.p_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_video_sound_function");
        this.q_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_video_sound_noise_function");
        this.z_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR);
        this.A_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION);
        this.C_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH);
        this.D_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE);
        this.B_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_CODEC);
        this.w_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER);
        this.x_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        this.y_renamed = (com.android.ui.menu.CameraShutterSettingPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SHUTTER_SETTING_GUIDE);
        this.r_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_watermark_visual_category");
        this.s_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_watermark_visual_content_category");
        this.t_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_watermark_visual_config_category");
        this.v_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_watermark_visual_makeup_category");
        this.P_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION);
        this.Q_renamed = (com.android.ui.menu.CameraWatermarkVisualPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_PREVIEW);
        this.Q_renamed.e_renamed(this.ad_renamed);
        this.R_renamed = (com.coui.appcompat.preference.COUIPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR);
        this.S_renamed = (com.coui.appcompat.preference.COUIMultiSelectListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO);
        this.T_renamed = (com.coui.appcompat.preference.COUISwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME);
        this.U_renamed = (com.coui.appcompat.preference.COUISwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_PHONE);
        this.V_renamed = (com.coui.appcompat.preference.COUISwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION);
        this.W_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE);
        this.X_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION);
        this.aa_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION);
        this.ab_renamed = (com.android.ui.menu.CameraWatermarkVisualPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_PREVIEW);
        this.E_renamed = (com.coui.appcompat.preference.COUIMarkPreference) a_renamed("pref_video_sound_normal_key");
        this.F_renamed = (com.coui.appcompat.preference.COUIMarkPreference) a_renamed("pref_video_sound_panorama_key");
        this.G_renamed = (com.coui.appcompat.preference.COUIMarkPreference) a_renamed("pref_video_sound_focusing_key");
        this.H_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_NOISE_FILTER);
        this.K_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_PHOTO);
        this.L_renamed = (com.coui.appcompat.preference.COUIListPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO);
        this.I_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER);
        this.J_renamed = (com.android.ui.menu.CameraSwitchPreference) a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_AND_MARK);
        this.u_renamed = (com.coui.appcompat.preference.COUIPreferenceCategory) a_renamed("pref_about_setting_function");
        this.M_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed("pref_about_setting_open_source_license");
        this.N_renamed = (com.coui.appcompat.preference.COUIJumpPreference) a_renamed("pref_about_setting_privacy_policy");
        this.P_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.W_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.W_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.X_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.X_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.S_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.S_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.T_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.T_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.U_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.U_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.V_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.V_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.V_renamed.a_renamed(this.ad_renamed);
        this.R_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.R_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.aa_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.w_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.x_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.z_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.A_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.C_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.D_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.B_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.E_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.F_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.G_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.H_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.K_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.L_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.I_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.J_renamed.a_renamed(new androidx.preference.Preference.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.b_renamed
            public final boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) {
                return this.f_renamed$0.onPreferenceChange(preference, obj);
            }
        });
        this.M_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        this.N_renamed.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.c_renamed
            public final boolean onPreferenceClick(androidx.preference.Preference preference) {
                return this.f_renamed$0.onPreferenceClick(preference);
            }
        });
        if (com.oplus.camera.util.Util.ao_renamed() && com.oplus.camera.util.Util.ak_renamed()) {
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.w_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.x_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.z_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.A_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.C_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.D_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.H_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.I_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.J_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.P_renamed);
            a_renamed((com.coui.appcompat.preference.COUISwitchPreference) this.aa_renamed);
            a_renamed(this.T_renamed);
            a_renamed(this.U_renamed);
            a_renamed(this.V_renamed);
            this.M_renamed.b_renamed((android.graphics.drawable.Drawable) null);
            this.N_renamed.b_renamed((android.graphics.drawable.Drawable) null);
        }
    }

    private void u_renamed() {
        java.lang.String configStringValue;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT) && (configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT_MODE)) != null && 20 == java.lang.Integer.parseInt(configStringValue)) {
            this.C_renamed.a_renamed((java.lang.CharSequence) getResources().getString(com.oplus.camera.R_renamed.string.camera_subsetting_quick_launch_street_summary));
        }
    }

    private void v_renamed() throws android.content.res.Resources.NotFoundException {
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory2;
        java.lang.CharSequence charSequenceX;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory3;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory4;
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory5;
        com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "addOrRemoveCameraPreference()");
        if (this.m_renamed != null && this.D_renamed != null) {
            if ((com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) && com.oplus.camera.util.Util.c_renamed(o_renamed(), "com.coloros.movetosdcard")) || !com.oplus.camera.Storage.b_renamed(false)) {
                this.m_renamed.d_renamed(this.D_renamed);
            } else if (this.m_renamed.d_renamed((java.lang.CharSequence) com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                this.m_renamed.c_renamed((androidx.preference.Preference) this.D_renamed);
            }
        }
        if (this.ao_renamed == 0) {
            if ((!this.ah_renamed || this.ai_renamed) && (cOUIPreferenceCategory5 = this.m_renamed) != null) {
                cOUIPreferenceCategory5.d_renamed(this.B_renamed);
            }
            if (!this.ag_renamed) {
                this.i_renamed.d_renamed(this.l_renamed);
            }
        } else {
            this.i_renamed.d_renamed(this.k_renamed);
            this.i_renamed.d_renamed(this.l_renamed);
            this.i_renamed.d_renamed(this.m_renamed);
        }
        if (1 != this.ao_renamed) {
            this.i_renamed.d_renamed(this.j_renamed);
        } else {
            this.i_renamed.d_renamed(this.O_renamed);
        }
        if (2 != this.ao_renamed) {
            com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory6 = this.r_renamed;
            if (cOUIPreferenceCategory6 != null) {
                this.i_renamed.d_renamed(cOUIPreferenceCategory6);
            }
        } else {
            a_renamed("on_renamed".equals(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, getString(com.oplus.camera.R_renamed.string.camera_slogan_default_value))));
        }
        if (3 != this.ao_renamed) {
            this.i_renamed.d_renamed(this.p_renamed);
            this.i_renamed.d_renamed(this.q_renamed);
        } else if (!com.oplus.camera.util.Util.D_renamed()) {
            this.i_renamed.d_renamed(this.q_renamed);
        }
        if (4 != this.ao_renamed) {
            this.i_renamed.d_renamed(this.n_renamed);
            this.i_renamed.d_renamed(this.o_renamed);
        }
        if (5 != this.ao_renamed) {
            this.i_renamed.d_renamed(this.u_renamed);
            this.i_renamed.d_renamed(this.N_renamed);
            this.i_renamed.d_renamed(this.M_renamed);
        } else {
            this.i_renamed.d_renamed(this.O_renamed);
        }
        if (com.oplus.camera.util.Util.al_renamed()) {
            com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory7 = this.t_renamed;
            if (cOUIPreferenceCategory7 != null) {
                cOUIPreferenceCategory7.d_renamed(this.X_renamed);
            }
            com.coui.appcompat.preference.COUISwitchPreference cOUISwitchPreference = this.V_renamed;
            if (cOUISwitchPreference != null && (cOUIPreferenceCategory4 = this.s_renamed) != null) {
                cOUIPreferenceCategory4.d_renamed(cOUISwitchPreference);
            }
            java.lang.String[] stringArray = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_option);
            this.S_renamed.a_renamed((java.lang.CharSequence[]) java.util.Arrays.copyOfRange(stringArray, 0, stringArray.length - 1));
        }
        if (com.oplus.camera.util.Util.am_renamed() && !com.oplus.camera.util.Util.ar_renamed() && (cOUIPreferenceCategory3 = this.t_renamed) != null) {
            cOUIPreferenceCategory3.d_renamed(this.X_renamed);
            this.t_renamed.d_renamed(this.W_renamed);
        }
        if (com.oplus.camera.util.Util.ar_renamed() && (charSequenceX = this.U_renamed.x_renamed()) != null && charSequenceX.toString().toLowerCase().contains("oneplus")) {
            this.U_renamed.d_renamed(com.oplus.camera.R_renamed.string.camera_slogan_model_name);
        }
        if (!this.ap_renamed && (cOUIPreferenceCategory2 = this.m_renamed) != null) {
            cOUIPreferenceCategory2.d_renamed(this.C_renamed);
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SHARE_EDIT_SUPPORT) && (cOUIPreferenceCategory = this.m_renamed) != null) {
            cOUIPreferenceCategory.d_renamed(this.J_renamed);
        }
        a_renamed(this.k_renamed);
        a_renamed(this.l_renamed);
        a_renamed(this.m_renamed);
    }

    private void a_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        android.os.Bundle arguments;
        com.oplus.camera.e_renamed.a_renamed("CameraSubSettingFragment", "updateWatermarkCategoryPreference, watermarkOn: " + z_renamed);
        boolean z2 = false;
        if (z_renamed) {
            b_renamed(true);
            com.oplus.camera.q_renamed.a_renamed().b_renamed(this.h_renamed);
            this.r_renamed.c_renamed((androidx.preference.Preference) this.Q_renamed);
            this.r_renamed.c_renamed((androidx.preference.Preference) this.s_renamed);
            this.r_renamed.c_renamed((androidx.preference.Preference) this.t_renamed);
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_WATERMARK_FRONT)) {
                this.r_renamed.c_renamed((androidx.preference.Preference) this.v_renamed);
            } else {
                this.r_renamed.d_renamed(this.v_renamed);
            }
            if (!com.oplus.camera.util.Util.al_renamed() && (!com.oplus.camera.util.Util.am_renamed() || com.oplus.camera.util.Util.ar_renamed())) {
                this.t_renamed.c_renamed((androidx.preference.Preference) this.X_renamed);
            }
            com.coui.appcompat.preference.COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.S_renamed;
            c_renamed(cOUIMultiSelectListPreference, cOUIMultiSelectListPreference.m_renamed());
            c_renamed(this.R_renamed, this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, ""));
            com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.W_renamed;
            c_renamed(cOUIListPreference, cOUIListPreference.o_renamed());
            com.coui.appcompat.preference.COUIListPreference cOUIListPreference2 = this.X_renamed;
            c_renamed(cOUIListPreference2, cOUIListPreference2.o_renamed());
            java.util.Set<java.lang.String> stringSet = this.h_renamed.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
            if (stringSet != null && !stringSet.isEmpty()) {
                java.lang.String[] stringArray = o_renamed().getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
                boolean zContains = stringSet.contains(stringArray[0]);
                boolean zContains2 = stringSet.contains(stringArray[1]);
                c_renamed(this.V_renamed, java.lang.Boolean.valueOf(stringSet.contains(stringArray[2])));
                c_renamed(this.T_renamed, java.lang.Boolean.valueOf(zContains2));
                c_renamed(this.U_renamed, java.lang.Boolean.valueOf(zContains));
            }
            a_renamed(getActivity());
            this.am_renamed = true;
        } else {
            com.oplus.camera.q_renamed.a_renamed().b_renamed(this.ax_renamed);
            if (this.am_renamed) {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.menu.setting.p_renamed.this.w_renamed();
                    }
                });
            } else {
                w_renamed();
            }
            this.i_renamed.c_renamed(this.O_renamed);
            b_renamed(false);
            androidx.fragment.app.Fragment fragmentA = getFragmentManager().a_renamed("androidx.preference.PreferenceFragment.DIALOG");
            if (fragmentA != null && (fragmentA instanceof com.coui.appcompat.preference.c_renamed) && (arguments = fragmentA.getArguments()) != null) {
                java.lang.String string = arguments.getString("key");
                if (com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE.equals(string) || com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION.equals(string)) {
                    ((com.coui.appcompat.preference.c_renamed) fragmentA).dismiss();
                }
            }
        }
        this.i_renamed.d_renamed(this.O_renamed);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_WATERMARK_FRONT)) {
            if ("on_renamed".equals(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, getString(com.oplus.camera.R_renamed.string.camera_slogan_default_value))) && z_renamed) {
                z2 = true;
            }
            c_renamed(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w_renamed() {
        this.r_renamed.d_renamed(this.Q_renamed);
        this.r_renamed.d_renamed(this.s_renamed);
        this.r_renamed.d_renamed(this.t_renamed);
        this.r_renamed.d_renamed(this.aa_renamed);
        this.r_renamed.d_renamed(this.v_renamed);
    }

    private void b_renamed(boolean z_renamed) {
        this.s_renamed.a_renamed(z_renamed);
        this.t_renamed.a_renamed(z_renamed);
        this.v_renamed.a_renamed(z_renamed);
    }

    private void c_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.v_renamed.c_renamed((androidx.preference.Preference) this.ab_renamed);
            this.ab_renamed.a_renamed(false, this.h_renamed);
            androidx.recyclerview.widget.RecyclerView recyclerView = this.au_renamed;
            if (recyclerView == null || recyclerView.getAdapter() == null) {
                return;
            }
            androidx.recyclerview.widget.RecyclerView recyclerView2 = this.au_renamed;
            recyclerView2.smoothScrollToPosition(recyclerView2.getAdapter().getItemCount());
            return;
        }
        this.v_renamed.d_renamed(this.ab_renamed);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    private void c_renamed(androidx.preference.Preference preference, java.lang.Object obj) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed = this.h_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN, true);
        android.content.SharedPreferences.Editor editorEdit = this.h_renamed.edit();
        java.lang.String[] stringArray = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        java.lang.String[] stringArray2 = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_option);
        java.lang.String[] stringArray3 = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_values);
        com.oplus.camera.e_renamed.a_renamed("CameraSubSettingFragment", "updateWatermarkContentAndConfig, isFirstOpen: " + z_renamed);
        boolean zH = false;
        if (z_renamed) {
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN, false).apply();
            if (this.S_renamed.m_renamed().isEmpty()) {
                this.S_renamed.a_renamed(java.util.Set.of_renamed(stringArray[0]));
            }
            com.coui.appcompat.preference.COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.S_renamed;
            cOUIMultiSelectListPreference.b_renamed((java.lang.Object) cOUIMultiSelectListPreference.m_renamed());
            this.R_renamed.d_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_setting_slogan_name_default));
            this.W_renamed.a_renamed(stringArray3[1]);
            com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.W_renamed;
            cOUIListPreference.b_renamed((java.lang.Object) cOUIListPreference.o_renamed());
            this.X_renamed.a_renamed("bottom_left_corner");
            com.coui.appcompat.preference.COUIListPreference cOUIListPreference2 = this.X_renamed;
            cOUIListPreference2.b_renamed((java.lang.Object) cOUIListPreference2.o_renamed());
        } else if (obj != null) {
            if (preference == this.S_renamed) {
                boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOGAN_LOCATION_SUPPORT);
                java.lang.String[] stringArray4 = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_description);
                if (!configBooleanValue) {
                    java.lang.String[] stringArray5 = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_option);
                    this.S_renamed.a_renamed((java.lang.CharSequence[]) java.util.Arrays.copyOfRange(stringArray5, 0, stringArray5.length - 1));
                } else {
                    this.S_renamed.b_renamed((java.lang.CharSequence[]) stringArray4);
                }
                java.util.Set set = (java.util.Set) obj;
                if (set.contains(stringArray[2]) && !h_renamed()) {
                    set.remove(stringArray[2]);
                }
                boolean zContains = set.contains(stringArray[0]);
                boolean zContains2 = set.contains(stringArray[1]);
                boolean zContains3 = set.contains(stringArray[2]);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                if (zContains) {
                    sb.append(stringArray2[0]);
                    sb.append(f_renamed);
                }
                if (zContains2) {
                    sb.append(stringArray2[1]);
                    sb.append(f_renamed);
                }
                if (zContains3) {
                    sb.append(stringArray2[2]);
                    sb.append(f_renamed);
                    com.oplus.camera.q_renamed.a_renamed().a_renamed(this.h_renamed);
                }
                this.S_renamed.c_renamed((java.lang.CharSequence) ((android.text.TextUtils.isEmpty(sb.toString()) || !f_renamed.equals(java.lang.String.valueOf(sb.charAt(sb.length() - 1)))) ? sb.toString() : sb.substring(0, sb.length() - 1)));
                this.S_renamed.a_renamed((java.util.Set<java.lang.String>) new java.util.HashSet(set));
            } else if (preference == this.T_renamed) {
                boolean zBooleanValue = ((java.lang.Boolean) obj).booleanValue();
                java.util.Set<java.lang.String> stringSet = this.h_renamed.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
                if (stringSet != null) {
                    boolean zContains4 = stringSet.contains(stringArray[1]);
                    if (zContains4 && !zBooleanValue) {
                        stringSet.remove(stringArray[1]);
                    } else if (!zContains4 && zBooleanValue) {
                        stringSet.add(stringArray[1]);
                    }
                    this.S_renamed.a_renamed((java.util.Set<java.lang.String>) new java.util.HashSet(stringSet));
                }
            } else if (preference == this.U_renamed) {
                boolean zBooleanValue2 = ((java.lang.Boolean) obj).booleanValue();
                java.util.Set<java.lang.String> stringSet2 = this.h_renamed.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
                if (stringSet2 != null) {
                    boolean zB = this.U_renamed.b_renamed();
                    if (zB && !zBooleanValue2) {
                        this.U_renamed.e_renamed(false);
                        stringSet2.remove(stringArray[0]);
                    } else if (!zB && zBooleanValue2) {
                        this.U_renamed.e_renamed(true);
                        stringSet2.add(stringArray[0]);
                    }
                    this.S_renamed.a_renamed((java.util.Set<java.lang.String>) new java.util.HashSet(stringSet2));
                }
            } else if (preference == this.V_renamed) {
                boolean zBooleanValue3 = ((java.lang.Boolean) obj).booleanValue();
                if (zBooleanValue3) {
                    zH = h_renamed();
                    this.an_renamed = !zH;
                }
                java.util.Set<java.lang.String> stringSet3 = this.h_renamed.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
                if (stringSet3 != null) {
                    boolean zContains5 = stringSet3.contains(stringArray[2]);
                    if (zContains5 && !zBooleanValue3) {
                        stringSet3.remove(stringArray[2]);
                        com.oplus.camera.q_renamed.a_renamed().a_renamed(this.h_renamed);
                    } else if (!zContains5 && zBooleanValue3 && zH) {
                        stringSet3.add(stringArray[2]);
                        if (android.text.TextUtils.isEmpty(this.ar_renamed)) {
                            com.oplus.camera.q_renamed.a_renamed().a_renamed(this.h_renamed);
                        }
                    }
                    this.S_renamed.a_renamed((java.util.Set<java.lang.String>) new java.util.HashSet(stringSet3));
                }
                this.V_renamed.e_renamed(zBooleanValue3);
            } else if (preference == this.R_renamed) {
                java.lang.String string = (java.lang.String) obj;
                this.h_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, string).apply();
                if (android.text.TextUtils.isEmpty(string)) {
                    string = getResources().getString(com.oplus.camera.R_renamed.string.camera_setting_slogan_name_default);
                }
                this.R_renamed.d_renamed((java.lang.CharSequence) string);
            } else if (preference == this.W_renamed) {
                java.lang.String str = (java.lang.String) obj;
                java.lang.String[] stringArray6 = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_size_names);
                if (stringArray3[0].equals(str)) {
                    this.W_renamed.c_renamed((java.lang.CharSequence) stringArray6[0]);
                } else if (stringArray3[1].equals(str)) {
                    this.W_renamed.c_renamed((java.lang.CharSequence) stringArray6[1]);
                } else {
                    this.W_renamed.c_renamed((java.lang.CharSequence) stringArray6[2]);
                }
                this.W_renamed.a_renamed(str);
            } else if (preference == this.X_renamed) {
                java.lang.String str2 = (java.lang.String) obj;
                if (!com.oplus.camera.util.Util.am_renamed() || com.oplus.camera.util.Util.ar_renamed()) {
                    char c2 = 65535;
                    switch (str2.hashCode()) {
                        case -1364013995:
                            if (str2.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.CENTER)) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -1297425040:
                            if (str2.equals("upper_left_corner")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -1027670443:
                            if (str2.equals("upper_right_corner")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -994491540:
                            if (str2.equals("bottom_right_corner")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 643307897:
                            if (str2.equals("bottom_left_corner")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        this.X_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_location_names_upper_left_corner));
                    } else if (c2 == 1) {
                        this.X_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_location_names_upper_right_corner));
                    } else if (c2 == 2) {
                        this.X_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_location_names_center));
                    } else if (c2 == 3) {
                        this.X_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_location_names_bottom_left_corner));
                    } else if (c2 == 4) {
                        this.X_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_location_names_bottom_right_corner));
                    } else {
                        this.X_renamed.c_renamed((java.lang.CharSequence) getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_location_names_upper_right_corner));
                        str2 = "bottom_left_corner";
                    }
                } else {
                    str2 = (!com.oplus.camera.util.Util.am_renamed() || com.oplus.camera.util.Util.an_renamed()) ? "oplus_c_watermark_position" : "oplus_left_bottom_watermark_position";
                }
                this.X_renamed.a_renamed(str2);
            }
        }
        editorEdit.apply();
        G_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.app.Activity activity) {
        com.oplus.camera.q_renamed.a_renamed().a_renamed(this.ar_renamed);
        this.Q_renamed.a_renamed(activity, this.h_renamed);
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
            if (cOUIPreferenceCategory.c_renamed() == 0) {
                this.i_renamed.d_renamed(cOUIPreferenceCategory);
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.oplus.camera.q_renamed.a_renamed().b_renamed(this.ax_renamed);
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity == null || !activity.isFinishing()) {
            return;
        }
        d_renamed(false);
        this.Z_renamed = null;
        e_renamed(false);
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected boolean a_renamed(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        if (getActivity() != null && this.D_renamed != null && bundle.getBoolean("key_storage_dialog_show", false)) {
            this.D_renamed.c_renamed();
            return true;
        }
        if (getActivity() != null && bundle.getParcelable("watermark_author_dialog_state") != null) {
            a_renamed(bundle.getParcelable("watermark_author_dialog_state"));
            return true;
        }
        if (getActivity() != null && getFragmentManager() != null) {
            this.Y_renamed = (com.android.ui.menu.a_renamed) getFragmentManager().a_renamed("DISPLAY_INFO");
            com.android.ui.menu.a_renamed aVar = this.Y_renamed;
            if (aVar != null) {
                aVar.a_renamed(this.av_renamed);
            }
            return true;
        }
        return super.a_renamed(bundle);
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected void b_renamed(android.os.Bundle bundle) {
        super.b_renamed(bundle);
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.D_renamed;
        bundle.putBoolean("key_storage_dialog_show", cameraSwitchPreference != null && cameraSwitchPreference.e_renamed());
        com.coui.appcompat.dialog.panel.b_renamed bVar = this.Z_renamed;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        bundle.putParcelable("watermark_author_dialog_state", ((com.coui.appcompat.widget.COUIEditText) this.Z_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_sheet_edit)).onSaveInstanceState());
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed, androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.oplus.camera.ComboPreferences comboPreferences = this.h_renamed;
        if (comboPreferences != null) {
            comboPreferences.a_renamed(o_renamed());
            this.h_renamed = null;
        }
        androidx.preference.PreferenceScreen preferenceScreen = this.i_renamed;
        if (preferenceScreen != null) {
            preferenceScreen.d_renamed();
            this.i_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory = this.j_renamed;
        if (cOUIPreferenceCategory != null) {
            cOUIPreferenceCategory.d_renamed();
            this.j_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory2 = this.k_renamed;
        if (cOUIPreferenceCategory2 != null) {
            cOUIPreferenceCategory2.d_renamed();
            this.k_renamed = null;
        }
        if (this.A_renamed != null) {
            this.l_renamed.d_renamed();
            this.l_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory3 = this.m_renamed;
        if (cOUIPreferenceCategory3 != null) {
            cOUIPreferenceCategory3.d_renamed();
            this.m_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory4 = this.r_renamed;
        if (cOUIPreferenceCategory4 != null) {
            cOUIPreferenceCategory4.d_renamed();
            this.r_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory5 = this.n_renamed;
        if (cOUIPreferenceCategory5 != null) {
            cOUIPreferenceCategory5.d_renamed();
            this.n_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory6 = this.o_renamed;
        if (cOUIPreferenceCategory6 != null) {
            cOUIPreferenceCategory6.d_renamed();
            this.o_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory7 = this.q_renamed;
        if (cOUIPreferenceCategory7 != null) {
            cOUIPreferenceCategory7.d_renamed();
            this.q_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory8 = this.u_renamed;
        if (cOUIPreferenceCategory8 != null) {
            cOUIPreferenceCategory8.d_renamed();
            this.u_renamed = null;
        }
        com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory9 = this.p_renamed;
        if (cOUIPreferenceCategory9 != null) {
            cOUIPreferenceCategory9.d_renamed();
            this.p_renamed = null;
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.D_renamed;
        if (cameraSwitchPreference != null && cameraSwitchPreference.e_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("CameraSubSettingFragment", "onDestroyView, Storage Dialog dismiss");
            if (this.D_renamed.e_renamed()) {
                this.D_renamed.f_renamed();
            }
            this.D_renamed.d_renamed();
            this.D_renamed = null;
        }
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.H_renamed = null;
        this.E_renamed = null;
        this.G_renamed = null;
        this.F_renamed = null;
        this.I_renamed = null;
        this.L_renamed = null;
        this.K_renamed = null;
        this.J_renamed = null;
        this.M_renamed = null;
        this.N_renamed = null;
    }

    @Override // androidx.preference.Preference.c_renamed
    public boolean onPreferenceClick(androidx.preference.Preference preference) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        if (((com.oplus.camera.ui.menu.setting.CameraSubSettingActivity) getActivity()) == null) {
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_CODEC.equals(preference.B_renamed())) {
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_CODEC, (java.lang.Object) null);
            b_renamed("oplus.intent.action.APP_CODE_SETTING");
        } else if (preference == this.E_renamed) {
            this.h_renamed.edit().putString(F_renamed(), "normal").apply();
            A_renamed();
        } else if (preference == this.F_renamed) {
            this.h_renamed.edit().putString(F_renamed(), com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA).apply();
            A_renamed();
        } else if (preference == this.G_renamed) {
            this.h_renamed.edit().putString(F_renamed(), "focusing").apply();
            A_renamed();
        } else if (preference == this.R_renamed) {
            a_renamed((android.os.Parcelable) null);
            a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, (java.lang.Object) null);
        } else if (preference == this.S_renamed) {
            a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, (java.lang.Object) null);
        } else if (preference == this.W_renamed) {
            a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, (java.lang.Object) null);
        } else if (preference == this.X_renamed) {
            a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, (java.lang.Object) null);
        } else if (preference == this.M_renamed) {
            startActivity(new android.content.Intent("oplus.intent.action.APP_OPEN_SOURCE"));
        } else if (preference == this.N_renamed) {
            android.content.Intent intent = new android.content.Intent("com.oplus.bootreg.activity.statementpage");
            intent.putExtra("statement_intent_flag", 2);
            startActivity(intent);
        }
        return false;
    }

    private void b_renamed(java.lang.String str) {
        a_renamed(str, 0);
    }

    private void a_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.menu.setting.l_renamed lVar = (com.oplus.camera.ui.menu.setting.l_renamed) getActivity();
        if (lVar != null) {
            lVar.b_renamed(true);
        }
        android.content.Intent intent = new android.content.Intent(str);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, this.d_renamed);
        bundle.putInt("camera_enter_type", this.f6599c);
        bundle.putInt("camera_property_camera_id", this.e_renamed);
        bundle.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, this.f6598b);
        bundle.putBoolean("camera_enter_form_lock_screen", this.aq_renamed);
        bundle.putInt("camera_slogan_setting_from", i_renamed);
        intent.putExtra("camera_intent_data", bundle);
        startActivity(intent);
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    public java.lang.String p_renamed() {
        androidx.fragment.app.c_renamed activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    protected void c_renamed(android.os.Bundle bundle) {
        com.oplus.camera.e_renamed.f_renamed("CameraSubSettingFragment", "parseActivityArguments start");
        if (bundle == null) {
            return;
        }
        this.af_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, true);
        this.ag_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION, true);
        this.aj_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_IS_CAPTURE_MODE, true);
        this.ak_renamed = bundle.getBoolean("KEY_CAMERA_MENU", true);
        this.al_renamed = bundle.getBoolean("camera_entry_from", false);
        this.ao_renamed = bundle.getInt("camera_sub_setting_from");
        this.ah_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC);
        this.ai_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE);
        this.ap_renamed = bundle.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, true);
        this.aq_renamed = bundle.getBoolean("camera_enter_form_lock_screen", false);
        this.ad_renamed = bundle.getBoolean("allow_location", true);
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    protected void q_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.z_renamed;
        if (cameraSwitchPreference != null) {
            this.z_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.z_renamed.B_renamed(), "off")));
        }
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference2 = this.A_renamed;
        if (cameraSwitchPreference2 != null) {
            this.A_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference2.L_renamed().getString(this.A_renamed.B_renamed(), "on_renamed")));
        }
        if (this.C_renamed != null) {
            androidx.fragment.app.c_renamed activity = getActivity();
            if (activity != null) {
                this.g_renamed = android.provider.Settings.Secure.getInt(activity.getContentResolver(), "com.oplus.camera quick launch", 0);
            }
            this.C_renamed.e_renamed(1 == this.g_renamed);
        }
        if (1 == this.ao_renamed) {
            D_renamed();
            E_renamed();
        }
        if (this.ao_renamed == 0) {
            B_renamed();
            C_renamed();
        }
        if (3 == this.ao_renamed) {
            A_renamed();
        }
        if (4 == this.ao_renamed) {
            z_renamed();
            y_renamed();
            x_renamed();
        }
        if (this.J_renamed != null) {
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SHARE_EDIT_SUPPORT)) {
                this.J_renamed.e_renamed(false);
                this.J_renamed.a_renamed(false);
            } else {
                this.J_renamed.e_renamed("on_renamed".equals(this.J_renamed.L_renamed().getString(this.J_renamed.B_renamed(), "on_renamed")));
            }
        }
    }

    private void x_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.I_renamed;
        if (cameraSwitchPreference != null) {
            this.I_renamed.e_renamed("on_renamed".equals(this.h_renamed.getString(cameraSwitchPreference.B_renamed(), "off")));
        }
    }

    private void y_renamed() {
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.L_renamed;
        if (cOUIListPreference != null) {
            java.lang.String string = this.h_renamed.getString(cOUIListPreference.B_renamed(), "off");
            this.L_renamed.c_renamed(d_renamed(this.L_renamed, string));
            this.L_renamed.a_renamed(string);
        }
    }

    private void z_renamed() {
        com.coui.appcompat.preference.COUIListPreference cOUIListPreference = this.K_renamed;
        if (cOUIListPreference != null) {
            java.lang.String string = this.h_renamed.getString(cOUIListPreference.B_renamed(), "off");
            this.K_renamed.c_renamed(d_renamed(this.K_renamed, string));
            this.K_renamed.a_renamed(string);
        }
    }

    private void A_renamed() {
        if (this.G_renamed == null || this.F_renamed == null || this.E_renamed == null || this.H_renamed == null) {
            return;
        }
        java.lang.String string = this.h_renamed.getString(F_renamed(), com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA);
        java.lang.String string2 = this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_NOISE_FILTER, "off");
        this.E_renamed.e_renamed("normal".equals(string));
        this.F_renamed.e_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(string));
        this.G_renamed.e_renamed("focusing".equals(string));
        this.H_renamed.e_renamed("on_renamed".equals(string2));
        this.H_renamed.a_renamed(!"normal".equals(string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "updateStoragePreference()");
        if (this.D_renamed != null) {
            if (com.oplus.camera.util.Util.c_renamed(o_renamed(), "com.coloros.movetosdcard") && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL)) {
                return;
            }
            if (this.m_renamed != null) {
                if (!com.oplus.camera.Storage.b_renamed(false)) {
                    this.m_renamed.d_renamed(this.D_renamed);
                    return;
                }
                if (this.m_renamed.d_renamed((java.lang.CharSequence) com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                    this.D_renamed.a_renamed(true);
                    this.m_renamed.c_renamed((androidx.preference.Preference) this.D_renamed);
                }
                if (!com.oplus.camera.util.Util.ac_renamed()) {
                    this.D_renamed.a_renamed(false);
                    this.D_renamed.c_renamed((java.lang.Object) false);
                    return;
                }
            }
            if (com.oplus.camera.Storage.b_renamed(true) && 8.0d > com.oplus.camera.Storage.g_renamed()) {
                this.D_renamed.c_renamed((java.lang.Object) true);
            } else {
                this.D_renamed.c_renamed((java.lang.Object) false);
            }
            this.D_renamed.e_renamed("on_renamed".equals(this.D_renamed.L_renamed().getString(this.D_renamed.B_renamed(), "off")));
        }
    }

    private void C_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences = this.h_renamed;
        if (comboPreferences != null) {
            this.B_renamed.d_renamed((java.lang.CharSequence) a_renamed(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG"), this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264)));
        }
    }

    private void D_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.w_renamed;
        if (cameraSwitchPreference != null) {
            this.w_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.w_renamed.B_renamed(), "off")));
        }
    }

    private void E_renamed() {
        com.android.ui.menu.CameraSwitchPreference cameraSwitchPreference = this.x_renamed;
        if (cameraSwitchPreference != null) {
            this.x_renamed.e_renamed("on_renamed".equals(cameraSwitchPreference.L_renamed().getString(this.x_renamed.B_renamed(), "off")));
        }
    }

    private java.lang.String a_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if ("HEIF".equals(str)) {
            str3 = "" + getString(com.oplus.camera.R_renamed.string.camera_setting_reference_line_photo) + ": HEIF";
        } else {
            str3 = "" + getString(com.oplus.camera.R_renamed.string.camera_setting_reference_line_photo) + ": JPEG";
        }
        java.lang.String str4 = str3 + "/";
        if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(str2)) {
            return str4 + getString(com.oplus.camera.R_renamed.string.camera_setting_reference_line_video) + ": H_renamed.265";
        }
        return str4 + getString(com.oplus.camera.R_renamed.string.camera_setting_reference_line_video) + ": H_renamed.264";
    }

    private java.lang.String F_renamed() {
        return n_renamed() ? com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT : com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR;
    }

    private static java.lang.CharSequence d_renamed(androidx.preference.Preference preference, java.lang.Object obj) {
        java.lang.String string = obj.toString();
        if (!(preference instanceof androidx.preference.ListPreference)) {
            return string;
        }
        androidx.preference.ListPreference listPreference = (androidx.preference.ListPreference) preference;
        int iB = listPreference.b_renamed(string);
        return iB >= 0 ? listPreference.l_renamed()[iB] : "";
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed
    protected void r_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "installIntentFilterIfNeeded");
        androidx.fragment.app.c_renamed activity = getActivity();
        if (this.ae_renamed || activity == null) {
            return;
        }
        this.ae_renamed = true;
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
        if (!this.ae_renamed || activity == null) {
            return;
        }
        this.ae_renamed = false;
        activity.getApplicationContext().unregisterReceiver(this.aw_renamed);
    }

    @Override // androidx.preference.Preference.b_renamed
    public boolean onPreferenceChange(androidx.preference.Preference preference, java.lang.Object obj) throws android.content.res.Resources.NotFoundException {
        if (preference == null) {
            return false;
        }
        if (!(preference instanceof com.coui.appcompat.preference.COUISwitchWithDividerPreference) && preference != this.R_renamed && preference != this.S_renamed) {
            super.b_renamed(preference, obj);
        }
        if (preference instanceof com.coui.appcompat.preference.COUIListPreference) {
            ((com.coui.appcompat.preference.COUIListPreference) preference).c_renamed(d_renamed(preference, obj));
        }
        if (preference == this.C_renamed) {
            if (obj instanceof java.lang.Boolean ? ((java.lang.Boolean) obj).booleanValue() : false) {
                this.g_renamed = 1;
            } else {
                this.g_renamed = 0;
            }
            com.oplus.compat.a_renamed.a_renamed.SettingsNative_2.a_renamed("com.oplus.camera quick launch", this.g_renamed);
        } else if (preference == this.P_renamed) {
            a_renamed(((java.lang.Boolean) obj).booleanValue());
        } else if (preference == this.S_renamed || preference == this.R_renamed || preference == this.T_renamed || preference == this.U_renamed || preference == this.W_renamed || preference == this.X_renamed) {
            c_renamed(preference, obj);
            a_renamed(getActivity());
        } else if (preference == this.V_renamed) {
            c_renamed(preference, obj);
            a_renamed(getActivity());
            if (this.an_renamed) {
                this.an_renamed = false;
                return false;
            }
        } else if (preference == this.x_renamed) {
            if (!((java.lang.Boolean) obj).booleanValue()) {
                this.h_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_CAMERA_GESTURE_SHUTTER, getString(com.oplus.camera.R_renamed.string.camera_gesture_shutter_default_value)).apply();
            }
        } else if (preference == this.aa_renamed) {
            c_renamed(((java.lang.Boolean) obj).booleanValue());
        }
        if (preference instanceof com.android.ui.menu.CameraSwitchPreference) {
            return ((com.android.ui.menu.CameraSwitchPreference) preference).onPreferenceChange(preference, obj);
        }
        return true;
    }

    private void G_renamed() {
        java.util.Set<java.lang.String> stringSet = this.h_renamed.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
        java.lang.String string = this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        if ((stringSet == null || stringSet.isEmpty()) && ((string == null || string.isEmpty()) && 1 != com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEVICE_SERIES))) {
            this.W_renamed.a_renamed(false);
            this.X_renamed.a_renamed(false);
        } else {
            this.W_renamed.a_renamed(true);
            this.X_renamed.a_renamed(true);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    public void j_renamed() throws android.content.res.Resources.NotFoundException {
        java.util.Set<java.lang.String> setM;
        java.lang.String[] stringArray = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        com.android.ui.menu.a_renamed aVar = this.Y_renamed;
        if (aVar != null) {
            setM = aVar.e_renamed;
        } else {
            setM = this.S_renamed.m_renamed();
        }
        setM.add(stringArray[2]);
        this.S_renamed.a_renamed(java.util.Set.of_renamed(setM.toArray(new java.lang.String[0])));
        com.coui.appcompat.preference.COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.S_renamed;
        cOUIMultiSelectListPreference.b_renamed((java.lang.Object) cOUIMultiSelectListPreference.m_renamed());
        this.V_renamed.e_renamed(true);
        e_renamed(false);
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    public void k_renamed() throws android.content.res.Resources.NotFoundException {
        java.lang.String[] stringArray = getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
        this.S_renamed.m_renamed().remove(stringArray[2]);
        this.S_renamed.a_renamed(java.util.Set.of_renamed(r1.toArray(new java.lang.String[0])));
        com.coui.appcompat.preference.COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.S_renamed;
        cOUIMultiSelectListPreference.b_renamed((java.lang.Object) cOUIMultiSelectListPreference.m_renamed());
        this.V_renamed.e_renamed(false);
        com.oplus.camera.q_renamed.a_renamed().a_renamed(this.h_renamed);
        e_renamed(false);
    }

    @Override // com.oplus.camera.ui.menu.setting.b_renamed
    protected void m_renamed() throws android.content.res.Resources.NotFoundException {
        if (com.oplus.camera.util.Util.x_renamed(getActivity())) {
            return;
        }
        k_renamed();
    }

    @Override // com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed, androidx.preference.j_renamed.a_renamed
    public void b_renamed(androidx.preference.Preference preference) {
        if (preference == this.S_renamed && getFragmentManager() != null) {
            this.Y_renamed = com.android.ui.menu.a_renamed.b_renamed(preference.B_renamed());
            e_renamed(true);
        } else {
            super.b_renamed(preference);
        }
    }

    private void a_renamed(android.os.Parcelable parcelable) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        com.coui.appcompat.dialog.panel.b_renamed bVar = this.Z_renamed;
        if (bVar != null && bVar.isShowing()) {
            com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "showWatermarkAuthorDialog, dialog showing");
            return;
        }
        this.Z_renamed = new com.coui.appcompat.dialog.panel.b_renamed(getContext(), com.oplus.camera.R_renamed.style.DefaultBottomSheetDialog);
        android.view.View viewInflate = android.view.View.inflate(getContext(), com.oplus.camera.R_renamed.layout.camera_setting_custiomize_info_layout, null);
        com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar = (com.coui.appcompat.widget.toolbar.COUIToolbar) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_sheet_toolbar);
        final com.coui.appcompat.widget.COUIEditText cOUIEditText = (com.coui.appcompat.widget.COUIEditText) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_sheet_edit);
        this.Z_renamed.setContentView(viewInflate);
        this.Z_renamed.setOwnerActivity(getActivity());
        cOUIToolbar.setTitle(getResources().getString(com.oplus.camera.R_renamed.string.camera_setting_watermark_custom_info_title));
        cOUIToolbar.setIsTitleCenterStyle(true);
        if (parcelable != null) {
            cOUIEditText.onRestoreInstanceState(parcelable);
        } else {
            cOUIEditText.setText(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, ""));
        }
        cOUIEditText.setFastDeletable(true);
        cOUIEditText.setFilters(new android.text.InputFilter[]{new android.text.InputFilter() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.5
            @Override // android.text.InputFilter
            public java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i_renamed, int i2, android.text.Spanned spanned, int i3, int i4) {
                int length = 10 - (spanned.length() - (i4 - i3));
                if (length > 0 && length >= i2 - i_renamed) {
                    return null;
                }
                com.oplus.camera.util.o_renamed.b_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.string.camera_namelength_outofrange);
                return (length <= 0 || java.lang.Character.isHighSurrogate(charSequence.charAt(i_renamed))) ? "" : charSequence.subSequence(i_renamed, length + i_renamed);
            }
        }});
        this.Z_renamed.a_renamed(false, getContext().getResources().getString(com.oplus.camera.R_renamed.string.camera_statement_dialog_cancel), new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.6
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "onClick, mWatermarkAuthorEditDialog cancel");
                com.oplus.camera.ui.menu.setting.p_renamed.this.d_renamed(false);
                java.lang.String string = com.oplus.camera.ui.menu.setting.p_renamed.this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
                com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, java.lang.Integer.valueOf(string != null ? string.length() : 0), "1");
            }
        }, getContext().getResources().getString(com.oplus.camera.R_renamed.string.beauty3d_save), new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.7
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "onClick, mWatermarkAuthorEditDialog save");
                android.text.Editable text = cOUIEditText.getText();
                java.lang.String string = text == null ? "" : text.toString();
                com.oplus.camera.ui.menu.setting.p_renamed.this.R_renamed.b_renamed((java.lang.Object) string);
                com.oplus.camera.ui.menu.setting.p_renamed.this.d_renamed(false);
                com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, java.lang.Integer.valueOf(string.length()), "0");
            }
        }, null, null);
        com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> behavior = this.Z_renamed.getBehavior();
        if (behavior != null) {
            ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) behavior).a_renamed(new com.coui.appcompat.dialog.panel.e_renamed() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.8
                @Override // com.coui.appcompat.dialog.panel.e_renamed
                public boolean a_renamed() {
                    com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "onDragWhileEditing");
                    return com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(cOUIEditText, com.oplus.camera.R_renamed.string.camera_slogan_toast_pull_down, "3");
                }
            });
        }
        this.Z_renamed.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.9
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                if (4 != i_renamed || 1 != keyEvent.getAction()) {
                    return false;
                }
                com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "onKey, back key action up_renamed");
                if (com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(cOUIEditText, com.oplus.camera.R_renamed.string.camera_slogan_toast_click_back, "4")) {
                    com.oplus.camera.ui.menu.setting.p_renamed.this.Z_renamed.b_renamed();
                }
                return true;
            }
        });
        this.Z_renamed.a_renamed(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.p_renamed.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "onTouch, outside touch");
                if (com.oplus.camera.ui.menu.setting.p_renamed.this.a_renamed(cOUIEditText, com.oplus.camera.R_renamed.string.camera_slogan_toast_click_blank, "2")) {
                    com.oplus.camera.ui.menu.setting.p_renamed.this.Z_renamed.b_renamed();
                }
                return true;
            }
        });
        android.view.Window window = this.Z_renamed.getWindow();
        if (window != null) {
            cOUIEditText.setFocusable(true);
            cOUIEditText.requestFocus();
            window.setSoftInputMode(5);
        }
        d_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(com.coui.appcompat.widget.COUIEditText cOUIEditText, int i_renamed, java.lang.String str) {
        if (cOUIEditText.length() == 0 || com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS >= java.lang.System.currentTimeMillis() - this.ac_renamed) {
            com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "decisionAuthorDialogDismiss, need to dismiss editText length: " + cOUIEditText.length());
            d_renamed(false);
            a_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, java.lang.Integer.valueOf(cOUIEditText.length()), str);
            return false;
        }
        this.ac_renamed = java.lang.System.currentTimeMillis();
        com.oplus.camera.util.o_renamed.a_renamed(getContext(), i_renamed);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.location.Location location) {
        this.as_renamed = location;
        com.oplus.camera.util.Util.b_renamed(this.ay_renamed);
        com.oplus.camera.util.Util.a_renamed(this.ay_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.Object obj, java.lang.String str2) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(o_renamed());
        menuClickMsgData.mCaptureMode = this.f6598b;
        menuClickMsgData.mCaptureType = a_renamed(str);
        menuClickMsgData.mCameraEnterType = java.lang.String.valueOf(this.f6599c);
        menuClickMsgData.mCameraId = this.e_renamed;
        menuClickMsgData.mGuesture = str2;
        if (obj != null) {
            menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.e_renamed) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
            menuClickMsgData.buildSettingMenuItem(str, obj);
        } else {
            menuClickMsgData.buildSettingJumpItem(str);
        }
        menuClickMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(boolean z_renamed) {
        com.coui.appcompat.dialog.panel.b_renamed bVar = this.Z_renamed;
        if (bVar == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraSubSettingFragment", "handleWatermarkAuthorEditDialog, mWatermarkAuthorEditDialog is_renamed null");
            return;
        }
        android.app.Activity ownerActivity = bVar.getOwnerActivity();
        if (ownerActivity != null) {
            com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "handleWatermarkAuthorEditDialog, isShow: " + z_renamed + ", isFinishing: " + ownerActivity.isFinishing() + ", isShowing: " + this.Z_renamed.isShowing());
            if (z_renamed) {
                if (ownerActivity.isFinishing() || this.Z_renamed.isShowing()) {
                    return;
                }
                this.Z_renamed.show();
                this.Z_renamed.c_renamed().getDragView().setVisibility(4);
                this.ac_renamed = 0L;
                return;
            }
            if (ownerActivity.isFinishing() || !this.Z_renamed.isShowing()) {
                return;
            }
            this.Z_renamed.dismiss();
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("CameraSubSettingFragment", "handleWatermarkAuthorEditDialog, watermarkDialogActivity is_renamed null");
    }

    private void e_renamed(boolean z_renamed) {
        if (this.Y_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraSubSettingFragment", "handleWatermarkDisplayInfoDialog, mCameraWatermarkDisplayInfoDialog is_renamed null");
            return;
        }
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity != null && getFragmentManager() != null) {
            com.oplus.camera.e_renamed.b_renamed("CameraSubSettingFragment", "handleWatermarkDisplayInfoDialog, isShow: " + z_renamed + ", isFinishing: " + activity.isFinishing());
            if (z_renamed) {
                if (activity.isFinishing()) {
                    return;
                }
                this.Y_renamed.setTargetFragment(this, 0);
                this.Y_renamed.a_renamed(this.av_renamed);
                this.Y_renamed.show(getFragmentManager(), "DISPLAY_INFO");
                return;
            }
            this.Y_renamed.dismissAllowingStateLoss();
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("CameraSubSettingFragment", "handleWatermarkDisplayInfoDialog, CameraWaterMarkInfoDialogActivity, getFragmentManager is_renamed null");
    }
}
