package com.oplus.camera.p172ui.menu.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraPermission;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;
import com.oplus.camera.util.ExportPGrantUtil;
import com.oplus.camera.util.Util;
import java.util.Arrays;
import java.util.List;

/* compiled from: BaseLocationPreferenceFragment.java */
/* renamed from: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public abstract class BaseLocationPreferenceFragment extends BasePreferenceFragment {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private COUIAlertDialog f19996f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private COUIAlertDialog f19997g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUIAlertDialog f19998h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private COUIAlertDialog f19999i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private ComboPreferences f20000j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private AppCompatDialog f20001k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private BroadcastReceiver f20002l = new BroadcastReceiver() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BaseLocationPreferenceFragment.this.mo21311m();
        }
    };

    /* renamed from: OplusGLSurfaceView_6 */
    private DialogInterface.OnClickListener f20003m = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.9
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == -2) {
                dialogInterface.dismiss();
                CameraPermission.m14300a(BaseLocationPreferenceFragment.this.getActivity(), BaseLocationPreferenceFragment.this.mo21310l(), (List<String>) Arrays.asList("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), "cancel");
            } else {
                if (OplusGLSurfaceView_13 != -1) {
                    return;
                }
                BaseLocationPreferenceFragment.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", BaseLocationPreferenceFragment.this.getActivity().getPackageName(), null)), 2);
                dialogInterface.dismiss();
                CameraPermission.m14300a(BaseLocationPreferenceFragment.this.getActivity(), BaseLocationPreferenceFragment.this.mo21310l(), (List<String>) Arrays.asList("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"), EnterExitDcsMsgData.RESULT_SETTING);
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_11 */
    private DialogInterface.OnClickListener f20004n = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.10
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == -2) {
                BaseLocationPreferenceFragment.this.mo21309k();
            } else {
                if (OplusGLSurfaceView_13 != -1) {
                    return;
                }
                try {
                    BaseLocationPreferenceFragment.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        }
    };

    /* renamed from: o */
    private DialogInterface.OnClickListener f20005o = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.2
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == -2) {
                BaseLocationPreferenceFragment.this.mo21309k();
                dialogInterface.dismiss();
                CameraPermission.m14302a(BaseLocationPreferenceFragment.this.getActivity(), EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, "cancel");
            } else {
                if (OplusGLSurfaceView_13 != -1) {
                    return;
                }
                BaseLocationPreferenceFragment abstractC3315b = BaseLocationPreferenceFragment.this;
                abstractC3315b.m21301a((Context) abstractC3315b.getActivity(), "pref_allow_network_access", true);
                if (BaseLocationPreferenceFragment.this.f20000j == null) {
                    BaseLocationPreferenceFragment.this.m21296t();
                }
                SharedPreferences.Editor editorEdit = BaseLocationPreferenceFragment.this.f20000j.edit();
                editorEdit.putBoolean("pref_camera_statement_agree", true);
                editorEdit.putBoolean("pref_camera_statement_key", true);
                editorEdit.apply();
                if (BaseLocationPreferenceFragment.this.m21306h()) {
                    BaseLocationPreferenceFragment.this.mo21308j();
                }
                dialogInterface.dismiss();
                CameraPermission.m14302a(BaseLocationPreferenceFragment.this.getActivity(), EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, EnterExitDcsMsgData.RESULT_AGREE);
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_15 */
    protected void mo21308j() {
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected void mo21309k() {
    }

    /* renamed from: OplusGLSurfaceView_14 */
    protected int mo21310l() {
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    protected void mo21311m() {
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3938a(Bundle bundle, String str) {
        super.mo3938a(bundle, str);
        m21299w();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            mo21304a(bundle);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m21296t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m21296t() {
        this.f20000j = new ComboPreferences(getActivity());
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        mo21305b(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m21300x();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        COUIAlertDialog dialogInterfaceC1289b = this.f19996f;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f19996f.dismiss();
        }
        this.f19996f = null;
        COUIAlertDialog dialogInterfaceC1289b2 = this.f19998h;
        if (dialogInterfaceC1289b2 != null && dialogInterfaceC1289b2.isShowing()) {
            this.f19998h.dismiss();
        }
        this.f19998h = null;
        COUIAlertDialog dialogInterfaceC1289b3 = this.f19999i;
        if (dialogInterfaceC1289b3 != null && dialogInterfaceC1289b3.isShowing()) {
            this.f19999i.dismiss();
        }
        this.f19999i = null;
        COUIAlertDialog dialogInterfaceC1289b4 = this.f19997g;
        if (dialogInterfaceC1289b4 != null && dialogInterfaceC1289b4.isShowing()) {
            this.f19997g.dismiss();
        }
        this.f19997g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int OplusGLSurfaceView_13, int i2, Intent intent) {
        super.onActivityResult(OplusGLSurfaceView_13, i2, intent);
        if (OplusGLSurfaceView_13 == 1) {
            if (!Util.m24504x(getActivity())) {
                mo21309k();
                return;
            } else {
                if (m21306h()) {
                    mo21308j();
                    return;
                }
                return;
            }
        }
        if (OplusGLSurfaceView_13 != 2) {
            return;
        }
        if (!m21307i()) {
            mo21309k();
        } else if (m21306h()) {
            mo21308j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int OplusGLSurfaceView_13, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(OplusGLSurfaceView_13, strArr, iArr);
        CameraLog.m12954a("BaseLocationPreferenceFragment", "onRequestPermissionsResult, requestCode: " + OplusGLSurfaceView_13 + ", permissions: " + Arrays.toString(strArr) + ", grantResults: " + Arrays.toString(iArr));
        if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
            if (m21293a(strArr, iArr)) {
                if (m21306h()) {
                    mo21308j();
                }
            } else {
                mo21309k();
                m21291a(this.f20003m);
            }
            CameraPermission.m14301a(getActivity(), OplusGLSurfaceView_13, strArr, iArr);
            return;
        }
        if (OplusGLSurfaceView_13 != 5) {
            return;
        }
        m21301a((Context) getActivity(), CameraUIInterface.KEY_EXPORT_PERMISSION_REQUESTED, true);
        if (m21293a(strArr, iArr)) {
            mo21308j();
        } else {
            mo21309k();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected boolean m21306h() {
        return m21303a(R.string.camera_net_location_discribe, this.f20005o);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m21303a(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
        if (m21297u()) {
            return false;
        }
        if (!m21295b(getActivity(), "pref_allow_network_access", false)) {
            m21292a(onClickListener, OplusGLSurfaceView_13);
            return false;
        }
        if (RegionCommonFeatureAdapter.m14534c()) {
            if (m21307i()) {
                return true;
            }
            if (!m21295b(getActivity(), CameraUIInterface.KEY_EXPORT_PERMISSION_REQUESTED, false) || shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")) {
                AppCompatDialog dialogC0208f = this.f20001k;
                if (dialogC0208f != null && dialogC0208f.isShowing()) {
                    this.f20001k.dismiss();
                }
                ExportPGrantUtil.m24539a(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", new ExportPGrantUtil.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.1
                    @Override // com.oplus.camera.util.ExportPGrantUtil.IntrinsicsJvm.kt_4
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo12686a(AppCompatDialog dialogC0208f2) {
                        BaseLocationPreferenceFragment.this.f20001k = dialogC0208f2;
                    }

                    @Override // com.oplus.camera.util.ExportPGrantUtil.IntrinsicsJvm.kt_4
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo12687a(AppCompatDialog dialogC0208f2, boolean z) {
                        if (dialogC0208f2 != null && dialogC0208f2.isShowing()) {
                            dialogC0208f2.dismiss();
                        }
                        if (z) {
                            BaseLocationPreferenceFragment.this.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 5);
                        }
                    }
                });
                CameraLog.m12954a("BaseLocationPreferenceFragment", "checkBeforeOpenLocation, request code: 5");
            } else {
                m21298v();
            }
            return false;
        }
        if (m21307i()) {
            return true;
        }
        int iMo21310l = mo21310l();
        requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, iMo21310l);
        CameraLog.m12954a("BaseLocationPreferenceFragment", "checkBeforeOpenLocation, request code: " + iMo21310l);
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo21304a(Bundle bundle) {
        if (bundle.getBoolean("key_location_service_dialog_show", false)) {
            m21297u();
            return true;
        }
        if (bundle.getBoolean("key_network_dialog_show", false)) {
            m21292a(this.f20005o, R.string.camera_net_location_discribe);
            return true;
        }
        if (RegionCommonFeatureAdapter.m14535d()) {
            if (bundle.getBoolean("key_location_guide_dialog_show", false)) {
                m21298v();
                return true;
            }
        } else if (bundle.getBoolean("key_permission_dialog_show", false)) {
            m21291a(this.f20003m);
            return true;
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo21305b(Bundle bundle) {
        COUIAlertDialog dialogInterfaceC1289b = this.f19996f;
        bundle.putBoolean("key_location_service_dialog_show", dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing());
        RegionCommonFeatureAdapter.m14527a(bundle, this.f19998h, this.f19997g, this.f19999i);
    }

    /* renamed from: u */
    private boolean m21297u() {
        if (getActivity() == null || Util.m24504x(getActivity())) {
            return false;
        }
        COUIAlertDialog dialogInterfaceC1289b = this.f19996f;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f19996f.dismiss();
        }
        this.f19996f = new COUIAlertDialog.PlatformImplementations.kt_3(getActivity(), R.style.DialogAlert).setTitle(R.string.camera_location_content).setPositiveButton(R.string.camera_location_setting, this.f20004n).setNegativeButton(R.string.camera_location_cancle, this.f20004n).create();
        if (getActivity().isFinishing()) {
            return true;
        }
        this.f19996f.show();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21291a(DialogInterface.OnClickListener onClickListener) {
        CameraLog.m12954a("BaseLocationPreferenceFragment", "showPermissionDialog");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            CameraLog.m12967f("BaseLocationPreferenceFragment", "showPermissionDialog, return");
            return;
        }
        COUIAlertDialog dialogInterfaceC1289b = this.f19997g;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f19997g.dismiss();
        }
        this.f19997g = new COUIAlertDialog.PlatformImplementations.kt_3(activity).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                if (OplusGLSurfaceView_13 != 4) {
                    return true;
                }
                BaseLocationPreferenceFragment.this.getActivity().finish();
                return true;
            }
        }).setTitle(getString(R.string.camera_permission_dialog_title, getString(R.string.camera_permission_name_location))).setMessage(getString(R.string.camera_permission_description_location)).setPositiveButton(R.string.camera_permission_dialog_ok, onClickListener).setNegativeButton(R.string.camera_permission_dialog_cancel, onClickListener).setCancelable(false).create();
        if (activity.isFinishing()) {
            return;
        }
        this.f19997g.show();
    }

    /* renamed from: v */
    private void m21298v() {
        CameraLog.m12954a("BaseLocationPreferenceFragment", "showLocationGuideDialog");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            CameraLog.m12967f("BaseLocationPreferenceFragment", "showLocationGuideDialog, return");
            return;
        }
        COUIAlertDialog dialogInterfaceC1289b = this.f19998h;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f19998h.dismiss();
        }
        this.f19998h = new COUIAlertDialog.PlatformImplementations.kt_3(activity).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                if (OplusGLSurfaceView_13 != 4) {
                    return true;
                }
                BaseLocationPreferenceFragment.this.mo21309k();
                dialogInterface.dismiss();
                return true;
            }
        }).setTitle(getString(R.string.color_runtime_warning_dialog_title, getString(R.string.camera_app_name))).setMessage(getString(R.string.color_runtime_warning_dialog_disc, getString(R.string.camera_app_name), getString(R.string.color_runtime_access_fine_location))).setPositiveButton(R.string.color_runtime_warning_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                BaseLocationPreferenceFragment.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", BaseLocationPreferenceFragment.this.getActivity().getPackageName(), null)), 2);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(R.string.camera_location_cancle, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                BaseLocationPreferenceFragment.this.mo21309k();
                dialogInterface.dismiss();
            }
        }).setCancelable(false).create();
        if (activity.isFinishing()) {
            return;
        }
        this.f19998h.show();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21292a(DialogInterface.OnClickListener onClickListener, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("BaseLocationPreferenceFragment", "showNetDialog");
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            CameraLog.m12967f("BaseLocationPreferenceFragment", "showNetDialog, return");
            return;
        }
        COUIAlertDialog dialogInterfaceC1289b = this.f19999i;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f19999i.dismiss();
        }
        this.f19999i = new COUIAlertDialog.PlatformImplementations.kt_3(activity).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_4.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (4 != i2) {
                    return true;
                }
                activity.finish();
                return true;
            }
        }).setTitle(R.string.camera_net_permisstion_notic_title).setMessage(OplusGLSurfaceView_13).setNegativeButton(R.string.camera_net_cancel_btn, onClickListener).setPositiveButton(R.string.camera_net_sure_btn, onClickListener).setCancelable(false).create();
        if (activity.isFinishing()) {
            return;
        }
        this.f19999i.show();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m21307i() {
        return getActivity() != null && getActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21293a(String[] strArr, int[] iArr) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            if ("android.permission.ACCESS_COARSE_LOCATION".equalsIgnoreCase(strArr[OplusGLSurfaceView_13]) && iArr[OplusGLSurfaceView_13] == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m21295b(Context context, String str, boolean z) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21301a(Context context, String str, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).apply();
    }

    /* renamed from: w */
    private void m21299w() {
        if (getActivity() != null) {
            getActivity().registerReceiver(this.f20002l, new IntentFilter("android.location.MODE_CHANGED"));
        }
    }

    /* renamed from: x */
    private void m21300x() {
        if (getActivity() != null) {
            getActivity().unregisterReceiver(this.f20002l);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21302a(COUISwitchPreference cOUISwitchPreference) {
        if (Util.m24353ap()) {
            cOUISwitchPreference.m3826b(R.layout.oos_couiswitch_dark);
        } else {
            cOUISwitchPreference.m3826b(R.layout.oos_couiswitch);
        }
    }
}
