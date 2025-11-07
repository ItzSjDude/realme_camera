package com.oplus.camera.ui.menu.setting;

/* compiled from: BaseLocationPreferenceFragment.java */
/* loaded from: classes2.dex */
public abstract class b_renamed extends com.oplus.camera.ui.menu.setting.c_renamed {
    private com.coui.appcompat.dialog.app.b_renamed f_renamed = null;
    private com.coui.appcompat.dialog.app.b_renamed g_renamed = null;
    private com.coui.appcompat.dialog.app.b_renamed h_renamed = null;
    private com.coui.appcompat.dialog.app.b_renamed i_renamed = null;
    private com.oplus.camera.ComboPreferences j_renamed = null;
    private androidx.appcompat.app.f_renamed k_renamed = null;
    private android.content.BroadcastReceiver l_renamed = new android.content.BroadcastReceiver() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.oplus.camera.ui.menu.setting.b_renamed.this.m_renamed();
        }
    };
    private android.content.DialogInterface.OnClickListener m_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.9
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
            if (i_renamed == -2) {
                dialogInterface.dismiss();
                com.oplus.camera.h_renamed.a_renamed(com.oplus.camera.ui.menu.setting.b_renamed.this.getActivity(), com.oplus.camera.ui.menu.setting.b_renamed.this.l_renamed(), (java.util.List<java.lang.String>) java.util.Arrays.asList("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), "cancel");
            } else {
                if (i_renamed != -1) {
                    return;
                }
                com.oplus.camera.ui.menu.setting.b_renamed.this.startActivityForResult(new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.fromParts("package", com.oplus.camera.ui.menu.setting.b_renamed.this.getActivity().getPackageName(), null)), 2);
                dialogInterface.dismiss();
                com.oplus.camera.h_renamed.a_renamed(com.oplus.camera.ui.menu.setting.b_renamed.this.getActivity(), com.oplus.camera.ui.menu.setting.b_renamed.this.l_renamed(), (java.util.List<java.lang.String>) java.util.Arrays.asList("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), com.oplus.camera.statistics.model.EnterExitDcsMsgData.RESULT_SETTING);
            }
        }
    };
    private android.content.DialogInterface.OnClickListener n_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.10
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
            if (i_renamed == -2) {
                com.oplus.camera.ui.menu.setting.b_renamed.this.k_renamed();
            } else {
                if (i_renamed != -1) {
                    return;
                }
                try {
                    com.oplus.camera.ui.menu.setting.b_renamed.this.startActivityForResult(new android.content.Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        }
    };
    private android.content.DialogInterface.OnClickListener o_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.2
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
            if (i_renamed == -2) {
                com.oplus.camera.ui.menu.setting.b_renamed.this.k_renamed();
                dialogInterface.dismiss();
                com.oplus.camera.h_renamed.a_renamed(com.oplus.camera.ui.menu.setting.b_renamed.this.getActivity(), com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, "cancel");
            } else {
                if (i_renamed != -1) {
                    return;
                }
                com.oplus.camera.ui.menu.setting.b_renamed bVar = com.oplus.camera.ui.menu.setting.b_renamed.this;
                bVar.a_renamed((android.content.Context) bVar.getActivity(), "pref_allow_network_access", true);
                if (com.oplus.camera.ui.menu.setting.b_renamed.this.j_renamed == null) {
                    com.oplus.camera.ui.menu.setting.b_renamed.this.t_renamed();
                }
                android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.menu.setting.b_renamed.this.j_renamed.edit();
                editorEdit.putBoolean("pref_camera_statement_agree", true);
                editorEdit.putBoolean("pref_camera_statement_key", true);
                editorEdit.apply();
                if (com.oplus.camera.ui.menu.setting.b_renamed.this.h_renamed()) {
                    com.oplus.camera.ui.menu.setting.b_renamed.this.j_renamed();
                }
                dialogInterface.dismiss();
                com.oplus.camera.h_renamed.a_renamed(com.oplus.camera.ui.menu.setting.b_renamed.this.getActivity(), com.oplus.camera.statistics.model.EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, com.oplus.camera.statistics.model.EnterExitDcsMsgData.RESULT_AGREE);
            }
        }
    };

    protected void j_renamed() {
    }

    protected void k_renamed() {
    }

    protected int l_renamed() {
        return 0;
    }

    protected void m_renamed() {
    }

    @Override // com.oplus.camera.ui.menu.setting.c_renamed, com.coui.appcompat.preference.e_renamed, androidx.preference.g_renamed
    public void a_renamed(android.os.Bundle bundle, java.lang.String str) {
        super.a_renamed(bundle, str);
        w_renamed();
    }

    @Override // androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            a_renamed(bundle);
        }
    }

    @Override // androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        t_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t_renamed() {
        this.j_renamed = new com.oplus.camera.ComboPreferences(getActivity());
    }

    @Override // androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        b_renamed(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        x_renamed();
    }

    @Override // androidx.preference.g_renamed, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.coui.appcompat.dialog.app.b_renamed bVar = this.f_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.f_renamed.dismiss();
        }
        this.f_renamed = null;
        com.coui.appcompat.dialog.app.b_renamed bVar2 = this.h_renamed;
        if (bVar2 != null && bVar2.isShowing()) {
            this.h_renamed.dismiss();
        }
        this.h_renamed = null;
        com.coui.appcompat.dialog.app.b_renamed bVar3 = this.i_renamed;
        if (bVar3 != null && bVar3.isShowing()) {
            this.i_renamed.dismiss();
        }
        this.i_renamed = null;
        com.coui.appcompat.dialog.app.b_renamed bVar4 = this.g_renamed;
        if (bVar4 != null && bVar4.isShowing()) {
            this.g_renamed.dismiss();
        }
        this.g_renamed = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i_renamed, int i2, android.content.Intent intent) {
        super.onActivityResult(i_renamed, i2, intent);
        if (i_renamed == 1) {
            if (!com.oplus.camera.util.Util.x_renamed(getActivity())) {
                k_renamed();
                return;
            } else {
                if (h_renamed()) {
                    j_renamed();
                    return;
                }
                return;
            }
        }
        if (i_renamed != 2) {
            return;
        }
        if (!i_renamed()) {
            k_renamed();
        } else if (h_renamed()) {
            j_renamed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i_renamed, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i_renamed, strArr, iArr);
        com.oplus.camera.e_renamed.a_renamed("BaseLocationPreferenceFragment", "onRequestPermissionsResult, requestCode: " + i_renamed + ", permissions: " + java.util.Arrays.toString(strArr) + ", grantResults: " + java.util.Arrays.toString(iArr));
        if (i_renamed == 3 || i_renamed == 4) {
            if (a_renamed(strArr, iArr)) {
                if (h_renamed()) {
                    j_renamed();
                }
            } else {
                k_renamed();
                a_renamed(this.m_renamed);
            }
            com.oplus.camera.h_renamed.a_renamed(getActivity(), i_renamed, strArr, iArr);
            return;
        }
        if (i_renamed != 5) {
            return;
        }
        a_renamed((android.content.Context) getActivity(), com.oplus.camera.ui.CameraUIInterface.KEY_EXPORT_PERMISSION_REQUESTED, true);
        if (a_renamed(strArr, iArr)) {
            j_renamed();
        } else {
            k_renamed();
        }
    }

    protected boolean h_renamed() {
        return a_renamed(com.oplus.camera.R_renamed.string.camera_net_location_discribe, this.o_renamed);
    }

    protected boolean a_renamed(int i_renamed, android.content.DialogInterface.OnClickListener onClickListener) {
        if (u_renamed()) {
            return false;
        }
        if (!b_renamed(getActivity(), "pref_allow_network_access", false)) {
            a_renamed(onClickListener, i_renamed);
            return false;
        }
        if (com.oplus.camera.l_renamed.c_renamed.c_renamed()) {
            if (i_renamed()) {
                return true;
            }
            if (!b_renamed(getActivity(), com.oplus.camera.ui.CameraUIInterface.KEY_EXPORT_PERMISSION_REQUESTED, false) || shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")) {
                androidx.appcompat.app.f_renamed fVar = this.k_renamed;
                if (fVar != null && fVar.isShowing()) {
                    this.k_renamed.dismiss();
                }
                com.oplus.camera.util.g_renamed.a_renamed(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", new com.oplus.camera.util.g_renamed.b_renamed() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.1
                    @Override // com.oplus.camera.util.g_renamed.b_renamed
                    public void a_renamed(androidx.appcompat.app.f_renamed fVar2) {
                        com.oplus.camera.ui.menu.setting.b_renamed.this.k_renamed = fVar2;
                    }

                    @Override // com.oplus.camera.util.g_renamed.b_renamed
                    public void a_renamed(androidx.appcompat.app.f_renamed fVar2, boolean z_renamed) {
                        if (fVar2 != null && fVar2.isShowing()) {
                            fVar2.dismiss();
                        }
                        if (z_renamed) {
                            com.oplus.camera.ui.menu.setting.b_renamed.this.requestPermissions(new java.lang.String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 5);
                        }
                    }
                });
                com.oplus.camera.e_renamed.a_renamed("BaseLocationPreferenceFragment", "checkBeforeOpenLocation, request code: 5");
            } else {
                v_renamed();
            }
            return false;
        }
        if (i_renamed()) {
            return true;
        }
        int iL = l_renamed();
        requestPermissions(new java.lang.String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, iL);
        com.oplus.camera.e_renamed.a_renamed("BaseLocationPreferenceFragment", "checkBeforeOpenLocation, request code: " + iL);
        return false;
    }

    protected boolean a_renamed(android.os.Bundle bundle) {
        if (bundle.getBoolean("key_location_service_dialog_show", false)) {
            u_renamed();
            return true;
        }
        if (bundle.getBoolean("key_network_dialog_show", false)) {
            a_renamed(this.o_renamed, com.oplus.camera.R_renamed.string.camera_net_location_discribe);
            return true;
        }
        if (com.oplus.camera.l_renamed.c_renamed.d_renamed()) {
            if (bundle.getBoolean("key_location_guide_dialog_show", false)) {
                v_renamed();
                return true;
            }
        } else if (bundle.getBoolean("key_permission_dialog_show", false)) {
            a_renamed(this.m_renamed);
            return true;
        }
        return false;
    }

    protected void b_renamed(android.os.Bundle bundle) {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.f_renamed;
        bundle.putBoolean("key_location_service_dialog_show", bVar != null && bVar.isShowing());
        com.oplus.camera.l_renamed.c_renamed.a_renamed(bundle, this.h_renamed, this.g_renamed, this.i_renamed);
    }

    private boolean u_renamed() {
        if (getActivity() == null || com.oplus.camera.util.Util.x_renamed(getActivity())) {
            return false;
        }
        com.coui.appcompat.dialog.app.b_renamed bVar = this.f_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.f_renamed.dismiss();
        }
        this.f_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(getActivity(), com.oplus.camera.R_renamed.style.DialogAlert).setTitle(com.oplus.camera.R_renamed.string.camera_location_content).setPositiveButton(com.oplus.camera.R_renamed.string.camera_location_setting, this.n_renamed).setNegativeButton(com.oplus.camera.R_renamed.string.camera_location_cancle, this.n_renamed).create();
        if (getActivity().isFinishing()) {
            return true;
        }
        this.f_renamed.show();
        return true;
    }

    private void a_renamed(android.content.DialogInterface.OnClickListener onClickListener) {
        com.oplus.camera.e_renamed.a_renamed("BaseLocationPreferenceFragment", "showPermissionDialog");
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity == null) {
            com.oplus.camera.e_renamed.f_renamed("BaseLocationPreferenceFragment", "showPermissionDialog, return");
            return;
        }
        com.coui.appcompat.dialog.app.b_renamed bVar = this.g_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.g_renamed.dismiss();
        }
        this.g_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                if (i_renamed != 4) {
                    return true;
                }
                com.oplus.camera.ui.menu.setting.b_renamed.this.getActivity().finish();
                return true;
            }
        }).setTitle(getString(com.oplus.camera.R_renamed.string.camera_permission_dialog_title, getString(com.oplus.camera.R_renamed.string.camera_permission_name_location))).setMessage(getString(com.oplus.camera.R_renamed.string.camera_permission_description_location)).setPositiveButton(com.oplus.camera.R_renamed.string.camera_permission_dialog_ok, onClickListener).setNegativeButton(com.oplus.camera.R_renamed.string.camera_permission_dialog_cancel, onClickListener).setCancelable(false).create();
        if (activity.isFinishing()) {
            return;
        }
        this.g_renamed.show();
    }

    private void v_renamed() {
        com.oplus.camera.e_renamed.a_renamed("BaseLocationPreferenceFragment", "showLocationGuideDialog");
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity == null) {
            com.oplus.camera.e_renamed.f_renamed("BaseLocationPreferenceFragment", "showLocationGuideDialog, return");
            return;
        }
        com.coui.appcompat.dialog.app.b_renamed bVar = this.h_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.h_renamed.dismiss();
        }
        this.h_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                if (i_renamed != 4) {
                    return true;
                }
                com.oplus.camera.ui.menu.setting.b_renamed.this.k_renamed();
                dialogInterface.dismiss();
                return true;
            }
        }).setTitle(getString(com.oplus.camera.R_renamed.string.color_runtime_warning_dialog_title, getString(com.oplus.camera.R_renamed.string.camera_app_name))).setMessage(getString(com.oplus.camera.R_renamed.string.color_runtime_warning_dialog_disc, getString(com.oplus.camera.R_renamed.string.camera_app_name), getString(com.oplus.camera.R_renamed.string.color_runtime_access_fine_location))).setPositiveButton(com.oplus.camera.R_renamed.string.color_runtime_warning_dialog_ok, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.menu.setting.b_renamed.this.startActivityForResult(new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.fromParts("package", com.oplus.camera.ui.menu.setting.b_renamed.this.getActivity().getPackageName(), null)), 2);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(com.oplus.camera.R_renamed.string.camera_location_cancle, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.menu.setting.b_renamed.this.k_renamed();
                dialogInterface.dismiss();
            }
        }).setCancelable(false).create();
        if (activity.isFinishing()) {
            return;
        }
        this.h_renamed.show();
    }

    private void a_renamed(android.content.DialogInterface.OnClickListener onClickListener, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("BaseLocationPreferenceFragment", "showNetDialog");
        final androidx.fragment.app.c_renamed activity = getActivity();
        if (activity == null) {
            com.oplus.camera.e_renamed.f_renamed("BaseLocationPreferenceFragment", "showNetDialog, return");
            return;
        }
        com.coui.appcompat.dialog.app.b_renamed bVar = this.i_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.i_renamed.dismiss();
        }
        this.i_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.b_renamed.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i2, android.view.KeyEvent keyEvent) {
                if (4 != i2) {
                    return true;
                }
                activity.finish();
                return true;
            }
        }).setTitle(com.oplus.camera.R_renamed.string.camera_net_permisstion_notic_title).setMessage(i_renamed).setNegativeButton(com.oplus.camera.R_renamed.string.camera_net_cancel_btn, onClickListener).setPositiveButton(com.oplus.camera.R_renamed.string.camera_net_sure_btn, onClickListener).setCancelable(false).create();
        if (activity.isFinishing()) {
            return;
        }
        this.i_renamed.show();
    }

    public boolean i_renamed() {
        return getActivity() != null && getActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private boolean a_renamed(java.lang.String[] strArr, int[] iArr) {
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            if ("android.permission.ACCESS_COARSE_LOCATION".equalsIgnoreCase(strArr[i_renamed]) && iArr[i_renamed] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean b_renamed(android.content.Context context, java.lang.String str, boolean z_renamed) {
        try {
            return android.preference.PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z_renamed);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    protected void a_renamed(android.content.Context context, java.lang.String str, boolean z_renamed) {
        android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z_renamed).apply();
    }

    private void w_renamed() {
        if (getActivity() != null) {
            getActivity().registerReceiver(this.l_renamed, new android.content.IntentFilter("android.location.MODE_CHANGED"));
        }
    }

    private void x_renamed() {
        if (getActivity() != null) {
            getActivity().unregisterReceiver(this.l_renamed);
        }
    }

    protected void a_renamed(com.coui.appcompat.preference.COUISwitchPreference cOUISwitchPreference) {
        if (com.oplus.camera.util.Util.ap_renamed()) {
            cOUISwitchPreference.b_renamed(com.oplus.camera.R_renamed.layout.oos_couiswitch_dark);
        } else {
            cOUISwitchPreference.b_renamed(com.oplus.camera.R_renamed.layout.oos_couiswitch);
        }
    }
}
