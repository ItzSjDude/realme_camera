package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p036h.ViewCompat;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIPreferenceFragment;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.algovisualization.NetworkAuthenticationUtils;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;

/* compiled from: BasePreferenceFragment.java */
/* renamed from: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public abstract class BasePreferenceFragment extends COUIPreferenceFragment implements Preference.InterfaceC0644b, Preference.InterfaceC0645c {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private COUIToolbar f20022g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AppBarLayout f20023h;

    /* renamed from: OplusGLSurfaceView_15 */
    private Context f20025j;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String f20017b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f20018c = 2;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f20019d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f20020e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Boolean f20021f = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private View f20024i = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected abstract void mo21317c(Bundle bundle);

    /* renamed from: p */
    public abstract String mo21320p();

    /* renamed from: q */
    protected abstract void mo21321q();

    /* renamed from: r */
    protected abstract void mo21322r();

    /* renamed from: s */
    protected abstract void mo21323s();

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3938a(Bundle bundle, String str) {
        super.mo3938a(bundle, str);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20017b = arguments.getString(CameraUIInterface.KEY_CAMERA_MODE, null);
            this.f20018c = arguments.getInt("camera_enter_type");
            this.f20019d = arguments.getInt(CameraUIInterface.KEY_CAMERA_ID);
            this.f20020e = arguments.getInt("camera_property_camera_id");
        }
        mo21317c(arguments);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    protected boolean m21318n() {
        if (this.f20021f == null) {
            this.f20021f = Boolean.valueOf(CameraCharacteristicsUtil.m12974a(this.f20019d));
        }
        return this.f20021f.booleanValue();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f20022g = (COUIToolbar) viewOnCreateView.findViewById(R.id_renamed.toolbar);
        COUIToolbar cOUIToolbar = this.f20022g;
        if (cOUIToolbar == null) {
            return viewOnCreateView;
        }
        cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
        this.f20022g.setNavigationContentDescription(R.string.abc_action_bar_up_description);
        this.f20022g.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BasePreferenceFragment.this.getActivity().onBackPressed();
            }
        });
        ViewCompat.m2875c((View) m3948e(), true);
        m3948e().setBackgroundColor(getResources().getColor(R.color.coui_list_overscroll_background_color));
        this.f20022g.setTitle(mo21320p());
        if (getActivity().getTitle().equals(getString(R.string.camera_setting_about))) {
            new NetworkAuthenticationUtils(this.f20022g, getContext(), "showInfo", "visualizationState", "currentTime", "ALOG visualization has opened", "ALOG visualization opened").m11633a();
        }
        this.f20023h = (AppBarLayout) viewOnCreateView.findViewById(R.id_renamed.appBarLayout);
        this.f20023h.setPadding(0, getResources().getDimensionPixelSize(R.dimen.preference_topbar_padding_top), 0, 0);
        this.f20024i = this.f20023h.findViewById(R.id_renamed.divider_line);
        View view = this.f20024i;
        if (view != null) {
            view.setAlpha(0.0f);
        }
        return viewOnCreateView;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21316c(int OplusGLSurfaceView_13) {
        if (m3948e() != null) {
            m3948e().setBackgroundColor(OplusGLSurfaceView_13);
        }
        AppBarLayout appBarLayout = this.f20023h;
        if (appBarLayout != null) {
            appBarLayout.setBackgroundColor(OplusGLSurfaceView_13);
        }
        if (getActivity() != null) {
            if (30 < Build.VERSION.SDK_INT && Util.m24339ab()) {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(5888);
                getActivity().getWindow().setNavigationBarContrastEnforced(false);
                getActivity().getWindow().setNavigationBarColor(0);
                return;
            }
            getActivity().getWindow().setNavigationBarColor(OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        mo21322r();
        mo21321q();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        mo21323s();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f20025j = context.getApplicationContext();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    /* renamed from: o */
    public Context m21319o() {
        return this.f20025j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static Object m21312a(Preference preference, Object obj) {
        String strM3791B = preference.m3791B();
        if (strM3791B.equals(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER) || strM3791B.equals(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || strM3791B.equals(CameraUIInterface.KEY_CAMERA_SOUND) || strM3791B.equals(CameraUIInterface.KEY_RECORD_LOCATION) || strM3791B.equals(CameraUIInterface.KEY_FACE_RECTIFY) || strM3791B.equals(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) || strM3791B.equals(CameraUIInterface.KEY_TRACK_FOCUS) || strM3791B.equals(CameraUIInterface.KEY_INERTIAL_ZOOM) || strM3791B.equals(CameraUIInterface.KEY_ASSIST_GRADIENTER) || strM3791B.equals(CameraUIInterface.KEY_SHARE_AND_MARK) || strM3791B.equals(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT) || strM3791B.equals(CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME) || strM3791B.equals(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION) || strM3791B.equals(CameraUIInterface.KEY_MIRROR_SETTING) || strM3791B.equals(CameraUIInterface.KEY_HEIF_FORMAT) || strM3791B.equals(CameraUIInterface.KEY_HEVC_VIDEO_FORMAT) || strM3791B.equals(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                return "on";
            }
        } else {
            if (!strM3791B.equals(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH)) {
                return obj;
            }
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                return "only_start";
            }
        }
        return "off";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m21314a(String str, Object obj) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(m21319o());
        menuClickMsgData.mCaptureMode = this.f20017b;
        menuClickMsgData.mCaptureType = m21313a(str);
        menuClickMsgData.mCameraEnterType = String.valueOf(this.f20018c);
        int OplusGLSurfaceView_13 = this.f20020e;
        menuClickMsgData.mCameraId = OplusGLSurfaceView_13;
        if (obj != null) {
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.buildSettingMenuItem(str, obj);
        } else {
            menuClickMsgData.buildSettingJumpItem(str);
        }
        menuClickMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m21313a(String str) {
        if (!CameraUIInterface.KEY_VIDEO_SOUND_REAR.equals(str) && !CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(str)) {
            if (!CameraUIInterface.KEY_HELP_AND_FEEDBACK.equals(str) && !CameraUIInterface.KEY_REFERENCE_LINE.equals(str)) {
                return 0;
            }
            String str2 = this.f20017b;
            char c2 = 65535;
            int iHashCode = str2.hashCode();
            if (iHashCode != -1933413040) {
                if (iHashCode != -35510913) {
                    if (iHashCode == 764302074 && str2.equals(ApsConstant.REC_MODE_SLOW_VIDEO)) {
                        c2 = 2;
                    }
                } else if (str2.equals(ApsConstant.REC_MODE_FAST_VIDEO)) {
                    c2 = 1;
                }
            } else if (str2.equals(ApsConstant.REC_MODE_COMMON)) {
                c2 = 0;
            }
            if (c2 != 0 && c2 != 1 && c2 != 2) {
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m21315b(Preference preference, Object obj) {
        if (this.f20017b == null) {
            CameraLog.m12967f("BasePreferenceFragment", "report Msg data failed, current mode is null!");
        } else {
            m21314a(preference.m3791B(), m21312a(preference, obj));
        }
    }
}
