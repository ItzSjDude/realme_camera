package com.oplus.camera.p172ui.menu.setting;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.p093ui.menu.CameraSwitchPreference;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIListPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.camera.CameraLog;
import com.oplus.camera.FeedbackUtils;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.util.DisableUitl;
import com.oplus.camera.util.Util;
import com.oplus.compat.p182a.SettingsNative;
import com.oplus.ocs.camera.CameraParameter;

/* compiled from: CameraSettingActivityFragment.java */
/* renamed from: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class CameraSettingActivityFragment extends BaseLocationPreferenceFragment {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final boolean f20169f = Util.m24459h("oplus.software.video.surround_record_support");

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final boolean f20170g = Util.m24459h("oplus.software.motor.breathled");

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Toast f20220h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private ComboPreferences f20221i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private PreferenceScreen f20222j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private Preference f20223k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private COUIPreferenceCategory f20224l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private COUIJumpPreference f20225m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private COUIListPreference f20226n = null;

    /* renamed from: o */
    private CameraSwitchPreference f20227o = null;

    /* renamed from: p */
    private CameraSwitchPreference f20228p = null;

    /* renamed from: q */
    private CameraSwitchPreference f20229q = null;

    /* renamed from: r */
    private CameraSwitchPreference f20230r = null;

    /* renamed from: s */
    private CameraSwitchPreference f20231s = null;

    /* renamed from: t */
    private COUIPreferenceCategory f20232t = null;

    /* renamed from: u */
    private COUIListPreference f20233u = null;

    /* renamed from: v */
    private COUIJumpPreference f20234v = null;

    /* renamed from: w */
    private CameraSwitchPreference f20235w = null;

    /* renamed from: x */
    private CameraSwitchPreference f20236x = null;

    /* renamed from: y */
    private CameraSwitchPreference f20237y = null;

    /* renamed from: z */
    private CameraSwitchPreference f20238z = null;

    /* renamed from: A */
    private CameraSwitchPreference f20171A = null;

    /* renamed from: B */
    private CameraSwitchPreference f20172B = null;

    /* renamed from: C */
    private COUIPreferenceCategory f20173C = null;

    /* renamed from: D */
    private COUIListPreference f20174D = null;

    /* renamed from: E */
    private CameraSwitchPreference f20175E = null;

    /* renamed from: F */
    private CameraSwitchPreference f20176F = null;

    /* renamed from: G */
    private COUIPreferenceCategory f20177G = null;

    /* renamed from: H */
    private COUIListPreference f20178H = null;

    /* renamed from: I */
    private CameraSwitchPreference f20179I = null;

    /* renamed from: J */
    private CameraSwitchPreference f20180J = null;

    /* renamed from: K */
    private CameraSwitchPreference f20181K = null;

    /* renamed from: L */
    private CameraSwitchPreference f20182L = null;

    /* renamed from: M */
    private CameraSwitchPreference f20183M = null;

    /* renamed from: N */
    private Preference f20184N = null;

    /* renamed from: O */
    private COUIPreferenceCategory f20185O = null;

    /* renamed from: P */
    private COUIJumpPreference f20186P = null;

    /* renamed from: Q */
    private COUIJumpPreference f20187Q = null;

    /* renamed from: R */
    private Preference f20188R = null;

    /* renamed from: S */
    private COUIJumpPreference f20189S = null;

    /* renamed from: T */
    private COUIJumpPreference f20190T = null;

    /* renamed from: U */
    private CameraSwitchPreference f20191U = null;

    /* renamed from: V */
    private COUIAlertDialog f20192V = null;

    /* renamed from: W */
    private COUIAlertDialog f20193W = null;

    /* renamed from: X */
    private boolean f20194X = true;

    /* renamed from: Y */
    private boolean f20195Y = true;

    /* renamed from: Z */
    private boolean f20196Z = true;

    /* renamed from: aa */
    private boolean f20197aa = false;

    /* renamed from: ab */
    private boolean f20198ab = false;

    /* renamed from: ac */
    private boolean f20199ac = true;

    /* renamed from: ad */
    private boolean f20200ad = false;

    /* renamed from: ae */
    private boolean f20201ae = false;

    /* renamed from: af */
    private boolean f20202af = true;

    /* renamed from: ag */
    private boolean f20203ag = true;

    /* renamed from: ah */
    private boolean f20204ah = false;

    /* renamed from: ai */
    private boolean f20205ai = true;

    /* renamed from: aj */
    private boolean f20206aj = true;

    /* renamed from: ak */
    private boolean f20207ak = true;

    /* renamed from: al */
    private boolean f20208al = true;

    /* renamed from: am */
    private boolean f20209am = true;

    /* renamed from: an */
    private boolean f20210an = true;

    /* renamed from: ao */
    private boolean f20211ao = true;

    /* renamed from: ap */
    private boolean f20212ap = true;

    /* renamed from: aq */
    private boolean f20213aq = false;

    /* renamed from: ar */
    private boolean f20214ar = true;

    /* renamed from: as */
    private boolean f20215as = false;

    /* renamed from: at */
    private boolean f20216at = false;

    /* renamed from: au */
    private boolean f20217au = false;

    /* renamed from: av */
    private boolean f20218av = false;

    /* renamed from: aw */
    private BroadcastReceiver f20219aw = new BroadcastReceiver() { // from class: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_5.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            CameraLog.m12959b("SettingActivityFragment", "onReceive(), action: " + action);
            if ("android.intent.action.MEDIA_MOUNTED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) || !Util.m24419c(CameraSettingActivityFragment.this.m21319o(), "com.coloros.movetosdcard") || CameraSettingActivityFragment.this.f20221i.getBoolean("pref_storage_save_to_external", false) || !Storage.m11128b(false)) {
                    CameraSettingActivityFragment.this.f20222j.m3871d(CameraSettingActivityFragment.this.f20223k);
                } else if (CameraSettingActivityFragment.this.mo3744a((CharSequence) "pref_storage_save_to_external") == null) {
                    CameraSettingActivityFragment.this.f20223k.m3824a(true);
                    CameraSettingActivityFragment.this.f20222j.m3867c(CameraSettingActivityFragment.this.f20223k);
                }
            }
        }
    };

    /* renamed from: N */
    private void m21469N() {
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_14 */
    protected int mo21310l() {
        return 3;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment, com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3938a(Bundle bundle, String str) {
        super.mo3938a(bundle, str);
        CameraLog.m12959b("SettingActivityFragment", "onCreatePreferences start");
        ((MyApplication) getContext().getApplicationContext()).m11104i();
        m3942b(R.xml.camera_setting_preferences);
        m21505v();
        m21473R();
        m21474S();
        this.f20218av = this.f20221i.getBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m21316c(getResources().getColor(R.color.camera_setting_setting_bg_color));
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        CameraLog.m12959b("SettingActivityFragment", "onDestroyView: " + this);
        COUIAlertDialog dialogInterfaceC1289b = this.f20192V;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            CameraLog.m12954a("SettingActivityFragment", "onDestroyView, mResetSettingDialog dismiss");
            this.f20192V.dismiss();
        }
        this.f20192V = null;
        COUIAlertDialog dialogInterfaceC1289b2 = this.f20193W;
        if (dialogInterfaceC1289b2 != null && dialogInterfaceC1289b2.isShowing()) {
            CameraLog.m12954a("SettingActivityFragment", "onDestroyView, mConfirmPhotoCodecDialog dismiss");
            this.f20193W.dismiss();
        }
        this.f20193W = null;
        m21489ac();
        super.onDestroyView();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: p */
    public String mo21320p() {
        FragmentActivity activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo21304a(Bundle bundle) {
        if (getActivity() != null && this.f20231s != null && bundle.getBoolean("key_storage_dialog_show", false)) {
            this.f20231s.m6202c();
            return true;
        }
        if (getActivity() != null && bundle.getBoolean("key_reset_dialog_show", false)) {
            m21483a(getActivity());
            return true;
        }
        return super.mo21304a(bundle);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo21305b(Bundle bundle) {
        super.mo21305b(bundle);
        COUIAlertDialog dialogInterfaceC1289b = this.f20192V;
        bundle.putBoolean("key_reset_dialog_show", dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing());
        CameraSwitchPreference cameraSwitchPreference = this.f20231s;
        bundle.putBoolean("key_storage_dialog_show", cameraSwitchPreference != null && cameraSwitchPreference.m6204e());
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo21317c(Bundle bundle) {
        CameraLog.m12959b("SettingActivityFragment", "parseActivityArguments start");
        if (bundle == null) {
            return;
        }
        this.f20194X = bundle.getBoolean(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, true);
        this.f20195Y = bundle.getBoolean(CameraUIInterface.KEY_LENS_DIRTY_DETECTION, true);
        this.f20196Z = bundle.getBoolean(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, true);
        this.f20199ac = bundle.getBoolean(CameraUIInterface.KEY_IS_CAPTURE_MODE, true);
        this.f20200ad = bundle.getBoolean(CameraUIInterface.KEY_IS_VIDEO_MODE, false);
        this.f20201ae = !TextUtils.isEmpty(bundle.getString(CameraUIInterface.KEY_CAMERA_MODE, null));
        this.f20202af = bundle.getBoolean(CameraUIInterface.KEY_AI_SCN, true);
        this.f20203ag = bundle.getBoolean(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, false);
        this.f20204ah = bundle.getBoolean(CameraUIInterface.KEY_FACE_RECTIFY, false);
        this.f20205ai = bundle.getBoolean(CameraUIInterface.KEY_RAW, true);
        this.f20206aj = bundle.getBoolean(CameraUIInterface.KEY_ASSIST_GRADIENTER, true);
        this.f20207ak = this.f20018c == 1;
        this.f20216at = bundle.getBoolean("camera_enter_form_lock_screen", false);
        this.f20197aa = bundle.getBoolean(CameraUIInterface.KEY_PHOTO_CODEC, true);
        this.f20198ab = bundle.getBoolean(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, true);
        this.f20213aq = bundle.getBoolean(CameraUIInterface.KEY_10_BITS_SUPPORT_IN_CURRENT_MODE, false);
        this.f20208al = bundle.getBoolean(CameraUIInterface.KEY_VIDEO_SOUND_KEY, true);
        this.f20209am = bundle.getBoolean(CameraUIInterface.KEY_VIDEO_CODEC, true);
        this.f20210an = bundle.getBoolean(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, true);
        this.f20211ao = bundle.getBoolean(CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265);
        this.f20212ap = bundle.getBoolean(CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE, true);
        this.f20217au = bundle.getBoolean(CameraUIInterface.KEY_QR_CODE, false);
        this.f20214ar = bundle.getBoolean("allow_location", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    @Override // androidx.preference.Preference.InterfaceC0644b
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraSettingActivityFragment.onPreferenceChange(androidx.preference.Preference, java.lang.Object):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21486a(boolean z) {
        SharedPreferences.Editor editorEdit = this.f20221i.edit();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !z) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_HDR, "off");
        }
        if (!"on".equals(this.f20221i.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off"))) {
            String str = z ? "HEIF" : "JPEG";
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, str);
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
        } else if (z) {
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, "HEIF");
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "HEIF");
        } else {
            editorEdit.apply();
            m21503t();
            return false;
        }
        editorEdit.apply();
        return true;
    }

    /* renamed from: t */
    private void m21503t() {
        Context context = getContext();
        if (context != null) {
            this.f20193W = new COUIAlertDialog.PlatformImplementations.kt_3(context).setCustomTitle(LayoutInflater.from(context).inflate(R.layout.capture_format_dialog_layout, (ViewGroup) null)).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_5.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                    SharedPreferences.Editor editorEdit = CameraSettingActivityFragment.this.f20221i.edit();
                    editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                    editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "JPEG");
                    editorEdit.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
                    CameraSettingActivityFragment.this.f20171A.m3903e(false);
                    CameraSettingActivityFragment.this.f20172B.m3903e(false);
                    editorEdit.apply();
                    CameraSettingActivityFragment.this.m21314a(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                }
            }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_5.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                    dialogInterface.dismiss();
                }
            }).create();
            this.f20193W.show();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21495b(boolean z) {
        String str = z ? CameraParameter.VideoEncoder.H265 : CameraParameter.VideoEncoder.H264;
        SharedPreferences.Editor editorEdit = this.f20221i.edit();
        editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, str);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !z) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_HDR, "off");
        }
        editorEdit.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21498c(boolean z) {
        this.f20221i.edit().putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, z ? "on" : "off").apply();
    }

    /* renamed from: u */
    private String m21504u() {
        return m21318n() ? CameraUIInterface.KEY_VIDEO_SOUND_FRONT : CameraUIInterface.KEY_VIDEO_SOUND_REAR;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: q */
    protected void mo21321q() {
        m21458C();
        m21460E();
        m21461F();
        m21462G();
        m21469N();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3943b(Preference preference) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null || fragmentManager.mo3388a("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        DialogFragment dialogInterfaceOnCancelListenerC0580bM21630a = null;
        if (preference instanceof CameraCustomListPreference) {
            if (CameraUIInterface.KEY_VIDEO_SOUND_REAR.equals(preference.m3791B()) || CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(preference.m3791B())) {
                dialogInterfaceOnCancelListenerC0580bM21630a = VideoSoundSettingFragment.m21630a(preference.m3791B(), this.f20017b, this.f20019d, this.f20020e);
            } else {
                dialogInterfaceOnCancelListenerC0580bM21630a = CameraCustomListPreferenceFragment.m21400a(preference.m3791B());
            }
        } else {
            super.mo3943b(preference);
        }
        if (dialogInterfaceOnCancelListenerC0580bM21630a != null) {
            dialogInterfaceOnCancelListenerC0580bM21630a.setTargetFragment(this, 0);
            dialogInterfaceOnCancelListenerC0580bM21630a.show(fragmentManager, "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: r */
    protected void mo21322r() {
        FragmentActivity activity = getActivity();
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) || !Util.m24419c(m21319o(), "com.coloros.movetosdcard") || this.f20215as || activity == null) {
            return;
        }
        this.f20215as = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        activity.getApplicationContext().registerReceiver(this.f20219aw, intentFilter, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: s */
    protected void mo21323s() {
        FragmentActivity activity = getActivity();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) && Util.m24419c(m21319o(), "com.coloros.movetosdcard") && this.f20215as && activity != null) {
            this.f20215as = false;
            activity.getApplicationContext().unregisterReceiver(this.f20219aw);
        }
    }

    /* renamed from: v */
    private void m21505v() {
        this.f20221i = new ComboPreferences(m21319o());
        this.f20221i.setLocalId(m21319o(), this.f20019d);
        this.f20222j = (PreferenceScreen) mo3744a("camera_setting_menu_root_preference");
        m21506w();
        m21507x();
        m21508y();
        m21509z();
        m21456A();
        m21457B();
    }

    /* renamed from: w */
    private void m21506w() {
        this.f20223k = mo3744a("pref_storage_save_to_external");
        this.f20223k.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
    }

    /* renamed from: x */
    private void m21507x() {
        this.f20224l = (COUIPreferenceCategory) mo3744a("pref_common_function");
        this.f20225m = (COUIJumpPreference) mo3744a(CameraUIInterface.KEY_WATERMARK_SETTING_IMAGE);
        this.f20226n = (COUIListPreference) mo3744a(CameraUIInterface.KEY_REFERENCE_LINE);
        this.f20227o = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_ASSIST_GRADIENTER);
        this.f20228p = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_MIRROR_SETTING);
        this.f20229q = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_CAMERA_SOUND);
        this.f20230r = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_RECORD_LOCATION);
        this.f20231s = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_STORAGE_PLACE);
        this.f20191U = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_CAMERA_FINGERPRINT_SHUTTER);
        COUIJumpPreference cOUIJumpPreference = this.f20225m;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                this.f20225m.m6900b((Drawable) null);
            }
        }
        COUIListPreference cOUIListPreference = this.f20226n;
        if (cOUIListPreference != null) {
            cOUIListPreference.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        CameraSwitchPreference cameraSwitchPreference = this.f20227o;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20227o);
            }
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.f20228p;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20228p);
            }
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.f20229q;
        if (cameraSwitchPreference3 != null) {
            cameraSwitchPreference3.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20229q);
            }
        }
        CameraSwitchPreference cameraSwitchPreference4 = this.f20230r;
        if (cameraSwitchPreference4 != null) {
            cameraSwitchPreference4.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            this.f20230r.m3824a(this.f20214ar);
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20230r);
            }
        }
        CameraSwitchPreference cameraSwitchPreference5 = this.f20231s;
        if (cameraSwitchPreference5 != null) {
            cameraSwitchPreference5.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20231s);
            }
        }
        CameraSwitchPreference cameraSwitchPreference6 = this.f20191U;
        if (cameraSwitchPreference6 != null) {
            cameraSwitchPreference6.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
    }

    /* renamed from: y */
    private void m21508y() {
        this.f20232t = (COUIPreferenceCategory) mo3744a("pref_capture_function");
        this.f20233u = (COUIListPreference) mo3744a(CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE);
        this.f20234v = (COUIJumpPreference) mo3744a(CameraUIInterface.KEY_SHUTTER_HELP);
        this.f20235w = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_CAMERA_HDR_MODE);
        this.f20236x = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_FACE_RECTIFY);
        this.f20237y = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT);
        this.f20238z = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_AI_SCN);
        this.f20171A = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE);
        this.f20172B = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_HEIF_FORMAT);
        COUIListPreference cOUIListPreference = this.f20233u;
        if (cOUIListPreference != null) {
            cOUIListPreference.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        COUIJumpPreference cOUIJumpPreference = this.f20234v;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                this.f20234v.m6900b((Drawable) null);
            }
        }
        CameraSwitchPreference cameraSwitchPreference = this.f20235w;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20235w);
            }
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.f20236x;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20236x);
            }
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.f20237y;
        if (cameraSwitchPreference3 != null) {
            cameraSwitchPreference3.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20237y);
            }
        }
        CameraSwitchPreference cameraSwitchPreference4 = this.f20238z;
        if (cameraSwitchPreference4 != null) {
            cameraSwitchPreference4.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20238z);
            }
        }
        CameraSwitchPreference cameraSwitchPreference5 = this.f20171A;
        if (cameraSwitchPreference5 != null) {
            cameraSwitchPreference5.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20171A);
            }
        }
        CameraSwitchPreference cameraSwitchPreference6 = this.f20172B;
        if (cameraSwitchPreference6 != null) {
            cameraSwitchPreference6.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20172B);
            }
        }
        this.f20189S = (COUIJumpPreference) mo3744a(CameraUIInterface.KEY_ADVANCE_SETTING_IMAGE);
        this.f20190T = (COUIJumpPreference) mo3744a(CameraUIInterface.KEY_BUILD_IMAGE_SETTING);
        COUIJumpPreference cOUIJumpPreference2 = this.f20189S;
        if (cOUIJumpPreference2 != null) {
            cOUIJumpPreference2.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                this.f20189S.m6900b((Drawable) null);
            }
        }
        COUIJumpPreference cOUIJumpPreference3 = this.f20190T;
        if (cOUIJumpPreference3 != null) {
            cOUIJumpPreference3.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                this.f20190T.m6900b((Drawable) null);
            }
        }
    }

    /* renamed from: z */
    private void m21509z() {
        COUIListPreference cOUIListPreference;
        this.f20173C = (COUIPreferenceCategory) mo3744a("pref_video_function");
        this.f20174D = (COUIListPreference) mo3744a(CameraUIInterface.KEY_VIDEO_SOUND_EFFECT_KEY);
        this.f20175E = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_TRACK_FOCUS);
        this.f20176F = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_HEVC_VIDEO_FORMAT);
        if (f20169f && (cOUIListPreference = this.f20174D) != null) {
            cOUIListPreference.m6902a((CharSequence[]) getResources().getStringArray(R.array.setting_video_sound_summaries));
            this.f20174D.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        if (this.f20175E != null) {
            m21487aa();
            this.f20175E.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20175E);
            }
        }
        CameraSwitchPreference cameraSwitchPreference = this.f20176F;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20176F);
            }
        }
        this.f20218av = this.f20221i.getBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false);
    }

    /* renamed from: A */
    private void m21456A() {
        CameraSwitchPreference cameraSwitchPreference;
        this.f20177G = (COUIPreferenceCategory) mo3744a("pref_camera_utility_function");
        this.f20178H = (COUIListPreference) mo3744a(CameraUIInterface.KEY_VOLUME_KEY_FUNCTION);
        this.f20179I = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH);
        this.f20180J = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER);
        this.f20181K = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_QR_CODE);
        this.f20182L = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_SHARE_AND_MARK);
        this.f20183M = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_LENS_DIRTY_DETECTION);
        COUIListPreference cOUIListPreference = this.f20178H;
        if (cOUIListPreference != null) {
            cOUIListPreference.m3817a((Preference.InterfaceC0644b) this);
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.f20179I;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20179I);
            }
        }
        if (f20170g && (cameraSwitchPreference = this.f20180J) != null) {
            cameraSwitchPreference.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20180J);
            }
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.f20181K;
        if (cameraSwitchPreference3 != null) {
            cameraSwitchPreference3.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20181K);
            }
        }
        CameraSwitchPreference cameraSwitchPreference4 = this.f20182L;
        if (cameraSwitchPreference4 != null) {
            cameraSwitchPreference4.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20182L);
            }
        }
        CameraSwitchPreference cameraSwitchPreference5 = this.f20183M;
        if (cameraSwitchPreference5 != null) {
            cameraSwitchPreference5.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                m21302a((COUISwitchPreference) this.f20183M);
            }
        }
    }

    /* renamed from: B */
    private void m21457B() {
        this.f20185O = (COUIPreferenceCategory) mo3744a("pref_help_and_feedback_function");
        this.f20184N = mo3744a(CameraUIInterface.KEY_RESTORE_TYPE);
        this.f20186P = (COUIJumpPreference) mo3744a(CameraUIInterface.KEY_HELP_AND_FEEDBACK);
        this.f20187Q = (COUIJumpPreference) mo3744a(CameraUIInterface.KEY_SETTING_ABOUT);
        this.f20188R = mo3744a(CameraUIInterface.KEY_BOTTOM_BLANK);
        Preference preference = this.f20184N;
        if (preference != null) {
            preference.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            this.f20184N.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
        }
        COUIJumpPreference cOUIJumpPreference = this.f20187Q;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                this.f20187Q.m6900b((Drawable) null);
            }
        }
        if (this.f20186P != null) {
            if (((CameraSettingActivity) getActivity()).m21514m()) {
                this.f20186P.m3824a(false);
            }
            this.f20186P.m3818a((Preference.InterfaceC0645c) new $$Lambda$i9w6_UWsvn0wfTHGFaGYvMaPfM(this));
            this.f20186P.m3817a((Preference.InterfaceC0644b) new $$Lambda$bOLdBrtJicjws171hwfwTJyz2RU(this));
            if (Util.m24352ao() && Util.m24348ak()) {
                this.f20186P.m6900b((Drawable) null);
            }
        }
    }

    /* renamed from: C */
    private void m21458C() {
        COUIJumpPreference cOUIJumpPreference = this.f20225m;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.m6915d((CharSequence) getString(m21459D() ? R.string.camera_setting_slogan_on : R.string.camera_setting_switch_off));
        }
        if (this.f20226n != null) {
            String string = this.f20221i.getString(CameraUIInterface.KEY_LINE_PHOTO, "off");
            this.f20226n.m6903c(m21497c(this.f20226n, string == null ? "" : string));
            this.f20226n.m3765a(string);
        }
        CameraSwitchPreference cameraSwitchPreference = this.f20227o;
        if (cameraSwitchPreference != null) {
            this.f20227o.m3903e("on".equals(this.f20221i.getString(cameraSwitchPreference.m3791B(), "off")));
        }
        if (this.f20228p != null) {
            this.f20228p.m3903e(!"on".equals(this.f20221i.getString(CameraUIInterface.KEY_MIRROR, "off")));
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.f20229q;
        if (cameraSwitchPreference2 != null) {
            this.f20229q.m3903e("on".equals(cameraSwitchPreference2.m3801L().getString(this.f20229q.m3791B(), "off")));
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.f20230r;
        if (cameraSwitchPreference3 != null) {
            this.f20230r.m3903e("on".equals(cameraSwitchPreference3.m3801L().getString(this.f20230r.m3791B(), "off")) && Util.m24504x(getActivity()));
        }
        CameraSwitchPreference cameraSwitchPreference4 = this.f20191U;
        if (cameraSwitchPreference4 != null) {
            this.f20191U.m3903e("on".equals(cameraSwitchPreference4.m3801L().getString(this.f20191U.m3791B(), getString(R.string.camera_fingerprint_capture_default_value))));
        }
        if (this.f20231s != null) {
            if (this.f20224l != null) {
                if (!Storage.m11128b(false)) {
                    this.f20224l.m3871d(this.f20231s);
                    return;
                }
                if (this.f20224l.m3869d((CharSequence) CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                    this.f20231s.m3824a(true);
                    this.f20224l.m3867c((Preference) this.f20231s);
                }
                if (!Util.m24340ac()) {
                    this.f20231s.m3824a(false);
                    this.f20231s.m3837c((Object) false);
                    return;
                }
            }
            if (Storage.m11128b(true) && 8.0d > Storage.m11143g()) {
                this.f20231s.m3837c((Object) true);
            } else {
                this.f20231s.m3837c((Object) false);
            }
            this.f20231s.m3903e("on".equals(this.f20231s.m3801L().getString(this.f20231s.m3791B(), "off")));
        }
    }

    /* renamed from: D */
    private boolean m21459D() {
        return "on".equals(this.f20221i.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"));
    }

    /* renamed from: E */
    private void m21460E() {
        m21467L();
        m21468M();
        m21480Y();
        m21478W();
        m21475T();
        m21476U();
        m21477V();
    }

    /* renamed from: F */
    private void m21461F() {
        m21472Q();
        m21481Z();
        m21488ab();
    }

    /* renamed from: G */
    private void m21462G() {
        m21466K();
        m21465J();
        m21470O();
        m21471P();
        m21464I();
        m21463H();
    }

    /* renamed from: H */
    private void m21463H() {
        CameraSwitchPreference cameraSwitchPreference = this.f20183M;
        if (cameraSwitchPreference != null) {
            this.f20183M.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20183M.m3791B(), "on")));
        }
    }

    /* renamed from: I */
    private void m21464I() {
        if (this.f20182L != null) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SHARE_EDIT_SUPPORT)) {
                this.f20182L.m3903e(false);
                this.f20182L.m3824a(false);
            } else {
                this.f20182L.m3903e("on".equals(this.f20182L.m3801L().getString(this.f20182L.m3791B(), "on")));
            }
        }
    }

    /* renamed from: J */
    private void m21465J() {
        if (this.f20179I != null) {
            FragmentActivity activity = getActivity();
            this.f20179I.m3903e((activity != null ? Settings.Secure.getInt(activity.getContentResolver(), "com.oplus.camera quick launch", 0) : 0) != 0);
        }
    }

    /* renamed from: K */
    private void m21466K() {
        COUIListPreference cOUIListPreference = this.f20178H;
        if (cOUIListPreference != null) {
            String string = cOUIListPreference.m3801L().getString(this.f20178H.m3791B(), getString(R.string.camera_volume_key_function_default_value));
            this.f20178H.m6903c(m21497c(this.f20178H, string));
            this.f20178H.m3765a(string);
        }
    }

    /* renamed from: L */
    private void m21467L() {
        COUIListPreference cOUIListPreference = this.f20233u;
        if (cOUIListPreference != null) {
            String string = cOUIListPreference.m3801L().getString(this.f20233u.m3791B(), getString(R.string.camera_setting_long_process_shutter_default_value));
            this.f20233u.m6903c(m21497c(this.f20233u, string));
            this.f20233u.m3765a(string);
        }
    }

    /* renamed from: M */
    private void m21468M() {
        if (this.f20235w != null) {
            this.f20235w.m3903e("on".equals(this.f20221i.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.f20019d))));
        }
    }

    /* renamed from: O */
    private void m21470O() {
        CameraSwitchPreference cameraSwitchPreference;
        if (!f20170g || (cameraSwitchPreference = this.f20180J) == null) {
            return;
        }
        this.f20180J.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20180J.m3791B(), "on")));
    }

    /* renamed from: P */
    private void m21471P() {
        CameraSwitchPreference cameraSwitchPreference = this.f20181K;
        if (cameraSwitchPreference != null) {
            this.f20181K.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20181K.m3791B(), "off")));
            this.f20181K.m3824a(this.f20207ak && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_QR_CODE_ENABLE) && this.f20217au);
        }
    }

    /* renamed from: Q */
    private void m21472Q() {
        if (this.f20174D != null) {
            if ("normal".equals(this.f20221i.getString(m21504u(), "all_around"))) {
                this.f20174D.m6903c((CharSequence) getString(R.string.camera_video_normal_sound));
                this.f20174D.m3765a("normal");
            } else {
                this.f20174D.m6903c((CharSequence) getString(R.string.camera_video_all_round_sound));
                this.f20174D.m3765a("all_around");
            }
            this.f20174D.m3824a(f20169f);
        }
    }

    /* renamed from: R */
    private void m21473R() {
        CameraSwitchPreference cameraSwitchPreference;
        CameraSwitchPreference cameraSwitchPreference2;
        CameraSwitchPreference cameraSwitchPreference3;
        COUIPreferenceCategory cOUIPreferenceCategory;
        CameraSwitchPreference cameraSwitchPreference4;
        COUIListPreference cOUIListPreference;
        CameraSwitchPreference cameraSwitchPreference5;
        CameraLog.m12959b("SettingActivityFragment", "addOrRemoveCameraPreference()");
        if (this.f20224l != null && this.f20231s != null) {
            if (!Storage.m11128b(false)) {
                this.f20224l.m3871d(this.f20231s);
            } else if (this.f20224l.m3869d((CharSequence) CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                this.f20224l.m3867c((Preference) this.f20231s);
            }
        }
        if (this.f20232t != null) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT)) {
                this.f20232t.m3871d(this.f20233u);
            }
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_RECTIFY_SUPPORT)) {
                this.f20232t.m3871d(this.f20236x);
            }
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_CLEAR_PORTRAIT)) {
                this.f20232t.m3871d(this.f20237y);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                this.f20232t.m3871d(this.f20238z);
            }
            if (!this.f20198ab) {
                this.f20232t.m3871d(this.f20171A);
            }
            if (!this.f20197aa && (cameraSwitchPreference5 = this.f20172B) != null) {
                this.f20232t.m3871d(cameraSwitchPreference5);
            }
        }
        if (this.f20173C != null) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)) {
                this.f20173C.m3871d(this.f20175E);
            }
            this.f20173C.m3868c((CharSequence) (m21318n() ? CameraUIInterface.KEY_VIDEO_SOUND_REAR : CameraUIInterface.KEY_VIDEO_SOUND_FRONT));
            if (!f20169f && (cOUIListPreference = this.f20174D) != null) {
                this.f20173C.m3871d(cOUIListPreference);
            }
            if (!this.f20209am && (cameraSwitchPreference4 = this.f20176F) != null) {
                this.f20173C.m3871d(cameraSwitchPreference4);
            }
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_RECTIFY_SUPPORT) && (cOUIPreferenceCategory = this.f20232t) != null) {
                cOUIPreferenceCategory.m3871d(this.f20236x);
            }
        }
        COUIPreferenceCategory cOUIPreferenceCategory2 = this.f20177G;
        if (cOUIPreferenceCategory2 != null) {
            if (!this.f20195Y && (cameraSwitchPreference3 = this.f20183M) != null) {
                cOUIPreferenceCategory2.m3871d(cameraSwitchPreference3);
            }
            if (f20170g) {
                this.f20177G.m3867c((Preference) this.f20180J);
            } else {
                this.f20177G.m3871d(this.f20180J);
            }
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SHARE_EDIT_SUPPORT) && (cameraSwitchPreference2 = this.f20182L) != null) {
                this.f20177G.m3871d(cameraSwitchPreference2);
            }
            if (!this.f20210an && (cameraSwitchPreference = this.f20179I) != null) {
                this.f20177G.m3871d(cameraSwitchPreference);
            }
        }
        COUIPreferenceCategory cOUIPreferenceCategory3 = this.f20185O;
        if (cOUIPreferenceCategory3 != null) {
            RegionCommonFeatureAdapter.m14528a(cOUIPreferenceCategory3, this.f20186P);
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) || !Util.m24419c(m21319o(), "com.coloros.movetosdcard") || this.f20221i.getBoolean("pref_storage_save_to_external", false) || !Storage.m11128b(false)) {
            this.f20222j.m3871d(this.f20223k);
        }
        m21484a(this.f20224l);
        m21484a(this.f20232t);
        m21484a(this.f20173C);
        m21484a(this.f20177G);
        m21484a(this.f20185O);
    }

    /* renamed from: S */
    private void m21474S() {
        String configStringValue;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT) && (configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT_MODE)) != null && 20 == Integer.parseInt(configStringValue)) {
            this.f20179I.mo3764a((CharSequence) getResources().getString(R.string.camera_subsetting_quick_launch_street_summary));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21484a(COUIPreferenceCategory cOUIPreferenceCategory) {
        if (cOUIPreferenceCategory != null) {
            int OplusGLSurfaceView_13 = 0;
            while (OplusGLSurfaceView_13 < cOUIPreferenceCategory.m3866c()) {
                Preference preferenceJ = cOUIPreferenceCategory.m3878j(OplusGLSurfaceView_13);
                if (preferenceJ != null && !CameraConfig.getSupportSettingMenuKey(preferenceJ.m3791B())) {
                    cOUIPreferenceCategory.m3871d(preferenceJ);
                    OplusGLSurfaceView_13--;
                }
                OplusGLSurfaceView_13++;
            }
        }
    }

    /* renamed from: T */
    private void m21475T() {
        ComboPreferences comboPreferences;
        CameraSwitchPreference cameraSwitchPreference = this.f20238z;
        if (cameraSwitchPreference != null) {
            this.f20238z.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20238z.m3791B(), "on")));
            this.f20238z.m3824a(this.f20202af && (((CameraSettingActivity) getActivity()).m21513l() || (this.f20199ac && this.f20201ae)));
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || (comboPreferences = this.f20221i) == null) {
            return;
        }
        this.f20221i.edit().putString(CameraUIInterface.KEY_AI_SCN, comboPreferences.getString(CameraUIInterface.KEY_PI_AI, getResources().getString(R.string.camera_pi_ai_default_value))).apply();
    }

    /* renamed from: U */
    private void m21476U() {
        CameraSwitchPreference cameraSwitchPreference;
        if (!this.f20198ab || (cameraSwitchPreference = this.f20171A) == null) {
            return;
        }
        this.f20171A.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20171A.m3791B(), "on")));
    }

    /* renamed from: V */
    private void m21477V() {
        if (this.f20172B != null) {
            this.f20172B.m3903e("HEIF".equals(this.f20221i.getString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG")));
        }
    }

    /* renamed from: W */
    private void m21478W() {
        CameraSwitchPreference cameraSwitchPreference = this.f20237y;
        if (cameraSwitchPreference != null) {
            this.f20237y.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20237y.m3791B(), "off")));
            this.f20237y.m3824a(this.f20203ag && (((CameraSettingActivity) getActivity()).m21513l() || (this.f20199ac && this.f20201ae)));
        }
    }

    /* renamed from: X */
    private void m21479X() {
        if (this.f20221i != null) {
            String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_FACE_RECTIFY_CONFIG_VALUE);
            String string = this.f20221i.getString(CameraUIInterface.KEY_FACE_RECTIFY_SET_DEFAULT_VALUE, "");
            if (TextUtils.isEmpty(configStringValue) || !TextUtils.isEmpty(string)) {
                return;
            }
            this.f20221i.edit().putString(CameraUIInterface.KEY_FACE_RECTIFY, configStringValue).putString(CameraUIInterface.KEY_FACE_RECTIFY_SET_DEFAULT_VALUE, "1").apply();
        }
    }

    /* renamed from: Y */
    private void m21480Y() {
        if (this.f20236x != null) {
            m21479X();
            this.f20236x.m3903e("on".equals(this.f20236x.m3801L().getString(this.f20236x.m3791B(), "off")));
            this.f20236x.m3824a(this.f20204ah && (((CameraSettingActivity) getActivity()).m21513l() || (this.f20199ac && this.f20201ae)));
        }
    }

    /* renamed from: Z */
    private void m21481Z() {
        CameraSwitchPreference cameraSwitchPreference = this.f20175E;
        if (cameraSwitchPreference != null) {
            this.f20175E.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20175E.m3791B(), "on")));
            m21487aa();
        }
    }

    /* renamed from: aa */
    private void m21487aa() {
        if (this.f20175E != null) {
            String string = this.f20221i.getString(m21504u(), "all_around");
            boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_60FPS_TRACK_FOCUS_SUPPORT);
            int OplusGLSurfaceView_13 = configBooleanValue ? R.string.camera_setting_auto_focus_summary : R.string.camera_setting_auto_focus_not_support_60fps_summary;
            if (Util.m24176G() && !"normal".equals(string)) {
                OplusGLSurfaceView_13 = configBooleanValue ? R.string.camera_setting_auto_track_focus_both_video_audio_summary : R.string.camera_setting_auto_track_focus_both_video_audio_not_support_60fps_summary;
            }
            this.f20175E.m3846f(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: ab */
    private void m21488ab() {
        if (this.f20176F != null) {
            boolean z = this.f20211ao;
            String string = CameraParameter.VideoEncoder.H264;
            if (z) {
                string = this.f20221i.getString(CameraUIInterface.KEY_VIDEO_CODEC, CameraParameter.VideoEncoder.H264);
            }
            this.f20176F.m3903e(CameraParameter.VideoEncoder.H265.equals(string));
        }
    }

    /* renamed from: ac */
    private void m21489ac() {
        CameraLog.m12959b("SettingActivityFragment", "releasePreferences");
        if (this.f20231s != null) {
            CameraLog.m12954a("SettingActivityFragment", "onDestroyView, Storage Dialog dismiss");
            if (this.f20231s.m6204e()) {
                this.f20231s.m6205f();
            }
            this.f20231s.m6203d();
            this.f20231s = null;
        }
        CameraSwitchPreference cameraSwitchPreference = this.f20230r;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.m6203d();
            this.f20230r = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory = this.f20224l;
        if (cOUIPreferenceCategory != null) {
            cOUIPreferenceCategory.m3870d();
            this.f20224l = null;
        }
        this.f20178H = null;
        this.f20189S = null;
        this.f20190T = null;
        this.f20225m = null;
        this.f20226n = null;
        this.f20227o = null;
        this.f20228p = null;
        this.f20191U = null;
        this.f20229q = null;
        this.f20233u = null;
        COUIPreferenceCategory cOUIPreferenceCategory2 = this.f20232t;
        if (cOUIPreferenceCategory2 != null) {
            cOUIPreferenceCategory2.m3870d();
            this.f20232t = null;
        }
        this.f20180J = null;
        this.f20238z = null;
        this.f20237y = null;
        this.f20234v = null;
        this.f20235w = null;
        COUIPreferenceCategory cOUIPreferenceCategory3 = this.f20173C;
        if (cOUIPreferenceCategory3 != null) {
            cOUIPreferenceCategory3.m3870d();
            this.f20173C = null;
        }
        this.f20174D = null;
        PreferenceScreen preferenceScreen = this.f20222j;
        if (preferenceScreen != null) {
            preferenceScreen.m3870d();
            this.f20222j = null;
        }
        ComboPreferences comboPreferences = this.f20221i;
        if (comboPreferences != null) {
            comboPreferences.m11074a(m21319o());
            this.f20221i = null;
        }
        this.f20184N = null;
        COUIPreferenceCategory cOUIPreferenceCategory4 = this.f20185O;
        if (cOUIPreferenceCategory4 != null) {
            cOUIPreferenceCategory4.m3870d();
            this.f20185O = null;
        }
        this.f20186P = null;
        this.f20171A = null;
        this.f20176F = null;
        this.f20181K = null;
        this.f20182L = null;
        this.f20183M = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    @Override // androidx.preference.Preference.InterfaceC0645c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onPreferenceClick(androidx.preference.Preference r17) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraSettingActivityFragment.onPreferenceClick(androidx.preference.Preference):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ad */
    public void m21490ad() throws PackageManager.NameNotFoundException {
        if (DisableUitl.m24536a(getActivity(), "com.oplus.vip")) {
            DisableUitl.m24535a(getActivity(), String.format(getActivity().getResources().getString(R.string.camera_disable_com_oplus_vip), DisableUitl.m24537b(getActivity(), "com.oplus.vip")), "com.oplus.vip", "");
        } else {
            FeedbackUtils.m14509b(Util.m24472l());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21483a(Activity activity) {
        COUIAlertDialog dialogInterfaceC1289b = this.f20192V;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f20192V.dismiss();
        }
        this.f20192V = new COUIAlertDialog.PlatformImplementations.kt_3(activity).m6600f(1).setNeutralButton(getString(R.string.camera_setting_restore_default), new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_5.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                CameraSettingActivityFragment.this.m21491ae();
                CameraSettingActivityFragment.this.m21314a(CameraUIInterface.KEY_RESTORE_TYPE, (Object) true);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_5.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                CameraSettingActivityFragment.this.m21314a(CameraUIInterface.KEY_RESTORE_TYPE, (Object) false);
                dialogInterface.dismiss();
            }
        }).create();
        if (activity.isFinishing()) {
            return;
        }
        this.f20192V.show();
        if (this.f20192V.mo901a(-3) == null || !Util.m24352ao()) {
            return;
        }
        this.f20192V.mo901a(-3).setTextColor(getContext().getColor(R.color.color_primary_light_hasselblad));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ae */
    public void m21491ae() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f20221i.edit().putString(CameraUIInterface.KEY_LASTED_VIDEO_CODEC, "").apply();
            m21492af();
            PreferenceManager.m3982a((Context) activity, R.xml.camera_setting_preferences, true);
            if (f20169f) {
                SharedPreferences.Editor editorEdit = PreferenceManager.m3981a(getActivity()).edit();
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_NOISE_FILTER, "on");
                editorEdit.apply();
            }
            mo21321q();
            return;
        }
        CameraLog.m12967f("SettingActivityFragment", "restore Camera settings failed, due to activity is null!");
    }

    /* renamed from: af */
    private void m21492af() {
        SettingsNative.PlatformImplementations.kt_3.m24843a("com.oplus.camera quick launch", 0);
        SharedPreferences.Editor editorEdit = this.f20221i.edit();
        editorEdit.remove(this.f20178H.m3791B());
        editorEdit.remove(this.f20229q.m3791B());
        editorEdit.remove(this.f20230r.m3791B());
        editorEdit.remove(CameraUIInterface.KEY_MIRROR);
        editorEdit.remove(CameraUIInterface.KEY_LENS_DIRTY_DETECTION);
        editorEdit.remove(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH);
        editorEdit.remove(CameraUIInterface.KEY_STORAGE_PLACE);
        editorEdit.remove(CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER);
        editorEdit.remove(CameraUIInterface.KEY_SHARE_AND_MARK);
        editorEdit.remove(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER);
        editorEdit.remove(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        editorEdit.remove(CameraUIInterface.KEY_ASSISTANT_LINE);
        editorEdit.remove(CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE);
        editorEdit.remove(CameraUIInterface.KEY_QR_CODE);
        editorEdit.remove(this.f20238z.m3791B());
        editorEdit.remove(this.f20237y.m3791B());
        editorEdit.remove(this.f20236x.m3791B());
        editorEdit.remove(this.f20175E.m3791B());
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_CODEC);
        editorEdit.remove(CameraUIInterface.KEY_SLOGAN_CUSTOMIZE);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION);
        editorEdit.remove(CameraUIInterface.KEY_RAW);
        editorEdit.remove(CameraUIInterface.KEY_PHOTO_CODEC);
        editorEdit.remove(CameraUIInterface.KEY_PHOTO_CODEC_BACKUP);
        editorEdit.remove(CameraUIInterface.KEY_PHOTO_CODEC_CLICK);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_CODEC);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_SOUND_REAR);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_SOUND_FRONT);
        editorEdit.remove(this.f20186P.m3791B());
        editorEdit.remove(CameraUIInterface.KEY_LINE_PHOTO);
        editorEdit.remove(CameraUIInterface.KEY_LINE_VIDEO);
        editorEdit.remove(CameraUIInterface.KEY_ASSIST_GRADIENTER);
        editorEdit.remove(CameraUIInterface.KEY_CAMERA_FINGERPRINT_SHUTTER);
        editorEdit.remove(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE);
        editorEdit.remove(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE_BACKUP);
        editorEdit.remove(CameraUIInterface.KEY_FACE_RECTIFY_SET_DEFAULT_VALUE);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_PHONE);
        editorEdit.remove(CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME);
        editorEdit.remove(this.f20228p.m3791B());
        editorEdit.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21494b(String str) {
        m21485a(str, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21485a(String str, int OplusGLSurfaceView_13) {
        Intent intent = new Intent(str);
        Bundle bundle = new Bundle();
        bundle.putBoolean("camera_entry_from", ((CameraSettingActivity) getActivity()).m21513l());
        bundle.putBoolean(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.f20194X);
        bundle.putBoolean(CameraUIInterface.KEY_LENS_DIRTY_DETECTION, this.f20195Y);
        bundle.putBoolean(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.f20196Z);
        bundle.putBoolean(CameraUIInterface.KEY_PHOTO_CODEC, this.f20197aa);
        bundle.putBoolean(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, this.f20198ab);
        bundle.putBoolean(CameraUIInterface.KEY_IS_CAPTURE_MODE, this.f20199ac);
        bundle.putBoolean(CameraUIInterface.KEY_ASSIST_GRADIENTER, this.f20206aj);
        bundle.putInt(CameraUIInterface.KEY_CAMERA_ID, this.f20019d);
        bundle.putInt("camera_enter_type", this.f20018c);
        bundle.putInt("camera_property_camera_id", this.f20020e);
        bundle.putBoolean("camera_enter_form_lock_screen", this.f20216at);
        bundle.putString(CameraUIInterface.KEY_CAMERA_MODE, this.f20017b);
        bundle.putBoolean(CameraUIInterface.KEY_IS_VIDEO_MODE, this.f20200ad);
        bundle.putBoolean(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, this.f20210an);
        bundle.putInt("camera_sub_setting_from", OplusGLSurfaceView_13);
        bundle.putBoolean("allow_location", this.f20214ar);
        intent.putExtra("camera_intent_data", bundle);
        startActivity(intent);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static CharSequence m21497c(Preference preference, Object obj) {
        String string = obj.toString();
        if (!(preference instanceof ListPreference)) {
            return string;
        }
        ListPreference listPreference = (ListPreference) preference;
        int iM3766b = listPreference.m3766b(string);
        return iM3766b >= 0 ? listPreference.m3767l()[iM3766b] : "";
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo21308j() {
        SharedPreferences.Editor editorEdit = this.f20221i.edit();
        editorEdit.putString(CameraUIInterface.KEY_RECORD_LOCATION, "on");
        editorEdit.apply();
        CameraSwitchPreference cameraSwitchPreference = this.f20230r;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.m3903e(true);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo21309k() {
        SharedPreferences.Editor editorEdit = this.f20221i.edit();
        editorEdit.putString(CameraUIInterface.KEY_RECORD_LOCATION, "off");
        editorEdit.apply();
        CameraSwitchPreference cameraSwitchPreference = this.f20230r;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.m3903e(false);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_6 */
    protected void mo21311m() {
        if (this.f20230r == null || this.f20221i == null || Util.m24504x(getActivity())) {
            return;
        }
        this.f20221i.edit().putString(CameraUIInterface.KEY_RECORD_LOCATION, "off").apply();
        this.f20230r.m3903e(false);
    }
}
