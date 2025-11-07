package com.oplus.camera.ui.menu.setting;

/* compiled from: BasePreferenceFragment.java */
/* loaded from: classes2.dex */
public abstract class c_renamed extends com.coui.appcompat.preference.e_renamed implements androidx.preference.Preference.b_renamed, androidx.preference.Preference.c_renamed {
    private com.coui.appcompat.widget.toolbar.COUIToolbar g_renamed;
    private com.google.android.material.appbar.AppBarLayout h_renamed;
    private android.content.Context j_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    public java.lang.String f6598b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f6599c = 2;
    public int d_renamed = 0;
    public int e_renamed = 0;
    private java.lang.Boolean f_renamed = null;
    private android.view.View i_renamed = null;

    protected abstract void c_renamed(android.os.Bundle bundle);

    public abstract java.lang.String p_renamed();

    protected abstract void q_renamed();

    protected abstract void r_renamed();

    protected abstract void s_renamed();

    @Override // com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed
    public void a_renamed(android.os.Bundle bundle, java.lang.String str) {
        super.a_renamed(bundle, str);
        android.os.Bundle arguments = getArguments();
        if (arguments != null) {
            this.f6598b = arguments.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, null);
            this.f6599c = arguments.getInt("camera_enter_type");
            this.d_renamed = arguments.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID);
            this.e_renamed = arguments.getInt("camera_property_camera_id");
        }
        c_renamed(arguments);
    }

    protected boolean n_renamed() {
        if (this.f_renamed == null) {
            this.f_renamed = java.lang.Boolean.valueOf(com.oplus.camera.e_renamed.a_renamed.a_renamed(this.d_renamed));
        }
        return this.f_renamed.booleanValue();
    }

    @Override // com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.g_renamed = (com.coui.appcompat.widget.toolbar.COUIToolbar) viewOnCreateView.findViewById(com.oplus.camera.R_renamed.id_renamed.toolbar);
        com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar = this.g_renamed;
        if (cOUIToolbar == null) {
            return viewOnCreateView;
        }
        cOUIToolbar.setNavigationIcon(com.oplus.camera.R_renamed.drawable.coui_back_arrow);
        this.g_renamed.setNavigationContentDescription(com.oplus.camera.R_renamed.string.abc_action_bar_up_description);
        this.g_renamed.setNavigationOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.c_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.oplus.camera.ui.menu.setting.c_renamed.this.getActivity().onBackPressed();
            }
        });
        androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) e_renamed(), true);
        e_renamed().setBackgroundColor(getResources().getColor(com.oplus.camera.R_renamed.color.coui_list_overscroll_background_color));
        this.g_renamed.setTitle(p_renamed());
        if (getActivity().getTitle().equals(getString(com.oplus.camera.R_renamed.string.camera_setting_about))) {
            new com.oplus.camera.algovisualization.h_renamed(this.g_renamed, getContext(), "showInfo", "visualizationState", "currentTime", "ALOG visualization has opened", "ALOG visualization opened").a_renamed();
        }
        this.h_renamed = (com.google.android.material.appbar.AppBarLayout) viewOnCreateView.findViewById(com.oplus.camera.R_renamed.id_renamed.appBarLayout);
        this.h_renamed.setPadding(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.preference_topbar_padding_top), 0, 0);
        this.i_renamed = this.h_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.divider_line);
        android.view.View view = this.i_renamed;
        if (view != null) {
            view.setAlpha(0.0f);
        }
        return viewOnCreateView;
    }

    public void c_renamed(int i_renamed) {
        if (e_renamed() != null) {
            e_renamed().setBackgroundColor(i_renamed);
        }
        com.google.android.material.appbar.AppBarLayout appBarLayout = this.h_renamed;
        if (appBarLayout != null) {
            appBarLayout.setBackgroundColor(i_renamed);
        }
        if (getActivity() != null) {
            if (30 < android.os.Build.VERSION.SDK_INT && com.oplus.camera.util.Util.ab_renamed()) {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(5888);
                getActivity().getWindow().setNavigationBarContrastEnforced(false);
                getActivity().getWindow().setNavigationBarColor(0);
                return;
            }
            getActivity().getWindow().setNavigationBarColor(i_renamed);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        r_renamed();
        q_renamed();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        s_renamed();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.content.Context context) {
        super.onAttach(context);
        this.j_renamed = context.getApplicationContext();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    public android.content.Context o_renamed() {
        return this.j_renamed;
    }

    static java.lang.Object a_renamed(androidx.preference.Preference preference, java.lang.Object obj) {
        java.lang.String strB = preference.B_renamed();
        if (strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_SOUND) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY) || strB.equals(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_TRACK_FOCUS) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_INERTIAL_ZOOM) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_AND_MARK) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT) || strB.equals(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME) || strB.equals(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_LOCATION) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR_SETTING) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_HEIF_FORMAT) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_HEVC_VIDEO_FORMAT) || strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
            if (obj instanceof java.lang.Boolean ? ((java.lang.Boolean) obj).booleanValue() : false) {
                return "on_renamed";
            }
        } else {
            if (!strB.equals(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH)) {
                return obj;
            }
            if (obj instanceof java.lang.Boolean ? ((java.lang.Boolean) obj).booleanValue() : false) {
                return "only_start";
            }
        }
        return "off";
    }

    void a_renamed(java.lang.String str, java.lang.Object obj) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(o_renamed());
        menuClickMsgData.mCaptureMode = this.f6598b;
        menuClickMsgData.mCaptureType = a_renamed(str);
        menuClickMsgData.mCameraEnterType = java.lang.String.valueOf(this.f6599c);
        int i_renamed = this.e_renamed;
        menuClickMsgData.mCameraId = i_renamed;
        if (obj != null) {
            menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
            menuClickMsgData.buildSettingMenuItem(str, obj);
        } else {
            menuClickMsgData.buildSettingJumpItem(str);
        }
        menuClickMsgData.report();
    }

    public int a_renamed(java.lang.String str) {
        if (!com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR.equals(str) && !com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(str)) {
            if (!com.oplus.camera.ui.CameraUIInterface.KEY_HELP_AND_FEEDBACK.equals(str) && !com.oplus.camera.ui.CameraUIInterface.KEY_REFERENCE_LINE.equals(str)) {
                return 0;
            }
            java.lang.String str2 = this.f6598b;
            char c2 = 65535;
            int iHashCode = str2.hashCode();
            if (iHashCode != -1933413040) {
                if (iHashCode != -35510913) {
                    if (iHashCode == 764302074 && str2.equals(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO)) {
                        c2 = 2;
                    }
                } else if (str2.equals(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO)) {
                    c2 = 1;
                }
            } else if (str2.equals(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON)) {
                c2 = 0;
            }
            if (c2 != 0 && c2 != 1 && c2 != 2) {
                return 0;
            }
        }
        return 1;
    }

    void b_renamed(androidx.preference.Preference preference, java.lang.Object obj) {
        if (this.f6598b == null) {
            com.oplus.camera.e_renamed.f_renamed("BasePreferenceFragment", "report Msg data failed, current mode is_renamed null!");
        } else {
            a_renamed(preference.B_renamed(), a_renamed(preference, obj));
        }
    }
}
