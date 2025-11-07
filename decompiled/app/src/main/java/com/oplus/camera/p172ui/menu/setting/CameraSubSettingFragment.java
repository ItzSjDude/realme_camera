package com.oplus.camera.p172ui.menu.setting;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.android.p093ui.menu.C1217a;
import com.android.p093ui.menu.CameraShutterSettingPreference;
import com.android.p093ui.menu.CameraSwitchPreference;
import com.android.p093ui.menu.CameraWatermarkVisualPreference;
import com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior;
import com.coui.appcompat.dialog.panel.COUIBottomSheetDialog;
import com.coui.appcompat.dialog.panel.COUIPanelDragListener;
import com.coui.appcompat.preference.COUIListPreferenceDialogFragment;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIListPreference;
import com.coui.appcompat.preference.COUIMarkPreference;
import com.coui.appcompat.preference.COUIMultiSelectListPreference;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.coui.appcompat.preference.COUISwitchWithDividerPreference;
import com.coui.appcompat.widget.COUIEditText;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.CameraLog;
import com.oplus.camera.LocationManager;
import com.oplus.camera.OtaUpdateManager;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.LocationHelper;
import com.oplus.camera.util.ToastUtil;
import com.oplus.camera.util.Util;
import com.oplus.compat.p182a.SettingsNative;
import com.oplus.ocs.camera.CameraParameter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CameraSubSettingFragment.java */
/* renamed from: com.oplus.camera.ui.menu.setting.p */
/* loaded from: classes2.dex */
public class CameraSubSettingFragment extends BaseLocationPreferenceFragment {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static String f20271f = "、";

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20323g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ComboPreferences f20324h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private PreferenceScreen f20325i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private COUIPreferenceCategory f20326j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private COUIPreferenceCategory f20327k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private COUIPreferenceCategory f20328l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private COUIPreferenceCategory f20329m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private COUIPreferenceCategory f20330n = null;

    /* renamed from: o */
    private COUIPreferenceCategory f20331o = null;

    /* renamed from: p */
    private COUIPreferenceCategory f20332p = null;

    /* renamed from: q */
    private COUIPreferenceCategory f20333q = null;

    /* renamed from: r */
    private COUIPreferenceCategory f20334r = null;

    /* renamed from: s */
    private COUIPreferenceCategory f20335s = null;

    /* renamed from: t */
    private COUIPreferenceCategory f20336t = null;

    /* renamed from: u */
    private COUIPreferenceCategory f20337u = null;

    /* renamed from: v */
    private COUIPreferenceCategory f20338v = null;

    /* renamed from: w */
    private CameraSwitchPreference f20339w = null;

    /* renamed from: x */
    private CameraSwitchPreference f20340x = null;

    /* renamed from: y */
    private CameraShutterSettingPreference f20341y = null;

    /* renamed from: z */
    private CameraSwitchPreference f20342z = null;

    /* renamed from: A */
    private CameraSwitchPreference f20272A = null;

    /* renamed from: B */
    private COUIJumpPreference f20273B = null;

    /* renamed from: C */
    private CameraSwitchPreference f20274C = null;

    /* renamed from: D */
    private CameraSwitchPreference f20275D = null;

    /* renamed from: E */
    private COUIMarkPreference f20276E = null;

    /* renamed from: F */
    private COUIMarkPreference f20277F = null;

    /* renamed from: G */
    private COUIMarkPreference f20278G = null;

    /* renamed from: H */
    private CameraSwitchPreference f20279H = null;

    /* renamed from: I */
    private CameraSwitchPreference f20280I = null;

    /* renamed from: J */
    private CameraSwitchPreference f20281J = null;

    /* renamed from: K */
    private COUIListPreference f20282K = null;

    /* renamed from: L */
    private COUIListPreference f20283L = null;

    /* renamed from: M */
    private COUIJumpPreference f20284M = null;

    /* renamed from: N */
    private COUIJumpPreference f20285N = null;

    /* renamed from: O */
    private Preference f20286O = null;

    /* renamed from: P */
    private CameraSwitchPreference f20287P = null;

    /* renamed from: Q */
    private CameraWatermarkVisualPreference f20288Q = null;

    /* renamed from: R */
    private COUIPreference f20289R = null;

    /* renamed from: S */
    private COUIMultiSelectListPreference f20290S = null;

    /* renamed from: T */
    private COUISwitchPreference f20291T = null;

    /* renamed from: U */
    private COUISwitchPreference f20292U = null;

    /* renamed from: V */
    private COUISwitchPreference f20293V = null;

    /* renamed from: W */
    private COUIListPreference f20294W = null;

    /* renamed from: X */
    private COUIListPreference f20295X = null;

    /* renamed from: Y */
    private C1217a f20296Y = null;

    /* renamed from: Z */
    private COUIBottomSheetDialog f20297Z = null;

    /* renamed from: aa */
    private CameraSwitchPreference f20298aa = null;

    /* renamed from: ab */
    private CameraWatermarkVisualPreference f20299ab = null;

    /* renamed from: ac */
    private long f20300ac = 0;

    /* renamed from: ad */
    private boolean f20301ad = true;

    /* renamed from: ae */
    private boolean f20302ae = false;

    /* renamed from: af */
    private boolean f20303af = true;

    /* renamed from: ag */
    private boolean f20304ag = true;

    /* renamed from: ah */
    private boolean f20305ah = false;

    /* renamed from: ai */
    private boolean f20306ai = false;

    /* renamed from: aj */
    private boolean f20307aj = true;

    /* renamed from: ak */
    private boolean f20308ak = false;

    /* renamed from: al */
    private boolean f20309al = false;

    /* renamed from: am */
    private boolean f20310am = false;

    /* renamed from: an */
    private boolean f20311an = false;

    /* renamed from: ao */
    private int f20312ao = 0;

    /* renamed from: ap */
    private boolean f20313ap = true;

    /* renamed from: aq */
    private boolean f20314aq = false;

    /* renamed from: ar */
    private String f20315ar = null;

    /* renamed from: as */
    private Location f20316as = null;

    /* renamed from: at */
    private OtaUpdateManager f20317at = null;

    /* renamed from: au */
    private RecyclerView f20318au = null;

    /* renamed from: av */
    private C1217a.PlatformImplementations.kt_3 f20319av = new C1217a.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.menu.setting.p.4
        @Override // com.android.p093ui.menu.C1217a.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo6229a(CharSequence charSequence, Set<String> set) {
            if (charSequence.equals(CameraSubSettingFragment.this.getString(R.string.camera_setting_watermark_info_option_location)) && set.contains("Location")) {
                return CameraSubSettingFragment.this.m21307i() && BaseSloganUtil.m11672a(CameraSubSettingFragment.this.getActivity(), CameraSubSettingFragment.this.f20324h);
            }
            return set.contains(charSequence.toString());
        }

        @Override // com.android.p093ui.menu.C1217a.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo6228a(CharSequence charSequence, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0 && CameraSubSettingFragment.this.getString(R.string.camera_setting_watermark_info_option_location).equals(charSequence.toString())) {
                return !CameraSubSettingFragment.this.m21306h();
            }
            return false;
        }

        @Override // com.android.p093ui.menu.C1217a.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6227a(String str) {
            CameraSubSettingFragment.this.m21605a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, CameraSubSettingFragment.this.f20290S.m3780m().toString().replace("[", "").replace("]", "").replace(",", DcsMsgData.DIVIDER), str);
        }
    };

    /* renamed from: aw */
    private BroadcastReceiver f20320aw = new BroadcastReceiver() { // from class: com.oplus.camera.ui.menu.setting.p.11
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            CameraLog.m12959b("CameraSubSettingFragment", "onReceive(), action: " + action);
            if ("android.intent.action.MEDIA_MOUNTED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
                CameraSubSettingFragment.this.m21587B();
            }
        }
    };

    /* renamed from: ax */
    private LocationManager.COUIBaseListPopupWindow_12 f20321ax = new LocationManager.COUIBaseListPopupWindow_12() { // from class: com.oplus.camera.ui.menu.setting.p.2
        @Override // com.oplus.camera.LocationManager.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10913a(Location location, boolean z) {
            if (location == null || CameraSubSettingFragment.this.getContext() == null) {
                return;
            }
            CameraLog.m12954a("CameraSubSettingFragment", "onLocationUpdated");
            if (!BaseSloganUtil.m11672a(MyApplication.m11092d(), CameraSubSettingFragment.this.f20324h)) {
                CameraLog.m12954a("CameraSubSettingFragment", "onLocationUpdated watermark of location is closed");
                CameraSubSettingFragment.this.m21596a(location);
                return;
            }
            if (z && "zh-CN".equals(Util.m24361ax())) {
                LocationManager.PlatformImplementations.kt_3 aVarM24549a = LocationHelper.m24549a(MyApplication.m11092d(), location);
                CameraLog.m12954a("CameraSubSettingFragment", "onLocationUpdated, isLastKnownLocation");
                if (aVarM24549a != null) {
                    aVarM24549a.f15847i = location;
                    CameraSubSettingFragment.this.f20315ar = LocationHelper.m24551a(MyApplication.m11092d(), aVarM24549a);
                    CameraSubSettingFragment c3336p = CameraSubSettingFragment.this;
                    c3336p.m21595a(c3336p.getActivity());
                    return;
                }
            }
            CameraSubSettingFragment.this.m21596a(location);
        }
    };

    /* renamed from: ay */
    private Runnable f20322ay = new Runnable() { // from class: com.oplus.camera.ui.menu.setting.p.3
        @Override // java.lang.Runnable
        public void run() throws IOException {
            Address addressM24229a = Util.m24229a(MyApplication.m11092d(), CameraSubSettingFragment.this.f20316as, true);
            if (addressM24229a == null) {
                CameraLog.m12966e("CameraSubSettingFragment", "getAddressRunnable, address is null, return");
                return;
            }
            CameraLog.m12954a("CameraSubSettingFragment", "getAddressRunnable");
            LocationManager.PlatformImplementations.kt_3 aVarM24550a = LocationHelper.m24550a(addressM24229a);
            CameraSubSettingFragment.this.f20315ar = LocationHelper.m24551a(MyApplication.m11092d(), aVarM24550a);
            CameraSubSettingFragment c3336p = CameraSubSettingFragment.this;
            c3336p.m21595a(c3336p.getActivity());
        }
    };

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_14 */
    protected int mo21310l() {
        return 4;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment, com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3938a(Bundle bundle, String str) throws Resources.NotFoundException {
        super.mo3938a(bundle, str);
        ((MyApplication) getContext().getApplicationContext()).m11104i();
        CameraLog.m12967f("CameraSubSettingFragment", "onCreatePreferences");
        if (Util.m24354aq()) {
            f20271f = "、";
        } else {
            f20271f = ",";
        }
        this.f20317at = new OtaUpdateManager(this.f20324h);
        OtaUpdateManager c3589x = this.f20317at;
        if (c3589x != null && 2 == this.f20312ao) {
            c3589x.m24828a(getActivity());
            this.f20317at.m24827a();
        }
        if (Util.m24495t()) {
            m3942b(R.xml.camera_setting_sub_preferences_fold);
        } else {
            m3942b(R.xml.camera_setting_sub_preferences);
        }
        m21622t();
        m21624v();
        m21623u();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m21316c(getResources().getColor(R.color.camera_setting_setting_bg_color));
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (2 == this.f20312ao) {
            LocationManager.m16155a().m16175a(this.f20321ax);
            LocationManager.m16155a().m16178b(this.f20324h);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public RecyclerView mo3935a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20318au = super.mo3935a(layoutInflater, viewGroup, bundle);
        return this.f20318au;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f20318au = null;
    }

    /* renamed from: t */
    private void m21622t() {
        m3934a().mo3829b((CharSequence) mo21320p());
        this.f20324h = new ComboPreferences(m21319o());
        this.f20324h.setLocalId(m21319o(), this.f20019d);
        this.f20325i = (PreferenceScreen) mo3744a("camera_setting_advance_root_preference");
        this.f20286O = mo3744a("pref_bottom_line");
        this.f20326j = (COUIPreferenceCategory) mo3744a("pref_shutter_setting_function");
        this.f20327k = (COUIPreferenceCategory) mo3744a("pref_self_setting_function");
        this.f20328l = (COUIPreferenceCategory) mo3744a("pref_lens_dirty_detection_function");
        this.f20329m = (COUIPreferenceCategory) mo3744a("pref_other_setting_function");
        this.f20330n = (COUIPreferenceCategory) mo3744a("pref_build_image_setting_function");
        this.f20331o = (COUIPreferenceCategory) mo3744a("pref_gradienter_setting_function");
        this.f20332p = (COUIPreferenceCategory) mo3744a("pref_video_sound_function");
        this.f20333q = (COUIPreferenceCategory) mo3744a("pref_video_sound_noise_function");
        this.f20342z = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_MIRROR);
        this.f20272A = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_LENS_DIRTY_DETECTION);
        this.f20274C = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH);
        this.f20275D = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_STORAGE_PLACE);
        this.f20273B = (COUIJumpPreference) mo3744a(CameraUIInterface.KEY_CAMERA_CODEC);
        this.f20339w = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER);
        this.f20340x = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        this.f20341y = (CameraShutterSettingPreference) mo3744a(CameraUIInterface.KEY_SHUTTER_SETTING_GUIDE);
        this.f20334r = (COUIPreferenceCategory) mo3744a("pref_watermark_visual_category");
        this.f20335s = (COUIPreferenceCategory) mo3744a("pref_watermark_visual_content_category");
        this.f20336t = (COUIPreferenceCategory) mo3744a("pref_watermark_visual_config_category");
        this.f20338v = (COUIPreferenceCategory) mo3744a("pref_watermark_visual_makeup_category");
        this.f20287P = (CameraSwitchPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION);
        this.f20288Q = (CameraWatermarkVisualPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_PREVIEW);
        this.f20288Q.m6218e(this.f20301ad);
        this.f20289R = (COUIPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR);
        this.f20290S = (COUIMultiSelectListPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO);
        this.f20291T = (COUISwitchPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME);
        this.f20292U = (COUISwitchPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_PHONE);
        this.f20293V = (COUISwitchPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION);
        this.f20294W = (COUIListPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE);
        this.f20295X = (COUIListPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION);
        this.f20298aa = (CameraSwitchPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION);
        this.f20299ab = (CameraWatermarkVisualPreference) mo3744a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_PREVIEW);
        this.f20276E = (COUIMarkPreference) mo3744a("pref_video_sound_normal_key");
        this.f20277F = (COUIMarkPreference) mo3744a("pref_video_sound_panorama_key");
        this.f20278G = (COUIMarkPreference) mo3744a("pref_video_sound_focusing_key");
        this.f20279H = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_VIDEO_NOISE_FILTER);
        this.f20282K = (COUIListPreference) mo3744a(CameraUIInterface.KEY_LINE_PHOTO);
        this.f20283L = (COUIListPreference) mo3744a(CameraUIInterface.KEY_LINE_VIDEO);
        this.f20280I = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_ASSIST_GRADIENTER);
        this.f20281J = (CameraSwitchPreference) mo3744a(CameraUIInterface.KEY_SHARE_AND_MARK);
        this.f20337u = (COUIPreferenceCategory) mo3744a("pref_about_setting_function");
        this.f20284M = (COUIJumpPreference) mo3744a("pref_about_setting_open_source_license");
        this.f20285N = (COUIJumpPreference) mo3744a("pref_about_setting_privacy_policy");
        this.f20287P.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20294W.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20294W.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20295X.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20295X.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20290S.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20290S.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20291T.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20291T.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20292U.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20292U.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20293V.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20293V.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20293V.m3824a(this.f20301ad);
        this.f20289R.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20289R.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20298aa.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20339w.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20340x.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20342z.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20272A.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20274C.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20275D.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20273B.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20276E.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20277F.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20278G.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20279H.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20282K.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20283L.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20280I.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20281J.m3817a(new Preference.InterfaceC0644b() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$MtykqXk9JIR7zId1igxjmKcMjLc
            @Override // androidx.preference.Preference.InterfaceC0644b
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceChange(preference, obj);
            }
        });
        this.f20284M.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        this.f20285N.m3818a(new Preference.InterfaceC0645c() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$UuQeMIsfcbAREyzPm3mx6Bly22k
            @Override // androidx.preference.Preference.InterfaceC0645c
            public final boolean onPreferenceClick(Preference preference) {
                return this.COUIBaseListPopupWindow_12$0.onPreferenceClick(preference);
            }
        });
        if (Util.m24352ao() && Util.m24348ak()) {
            m21302a((COUISwitchPreference) this.f20339w);
            m21302a((COUISwitchPreference) this.f20340x);
            m21302a((COUISwitchPreference) this.f20342z);
            m21302a((COUISwitchPreference) this.f20272A);
            m21302a((COUISwitchPreference) this.f20274C);
            m21302a((COUISwitchPreference) this.f20275D);
            m21302a((COUISwitchPreference) this.f20279H);
            m21302a((COUISwitchPreference) this.f20280I);
            m21302a((COUISwitchPreference) this.f20281J);
            m21302a((COUISwitchPreference) this.f20287P);
            m21302a((COUISwitchPreference) this.f20298aa);
            m21302a(this.f20291T);
            m21302a(this.f20292U);
            m21302a(this.f20293V);
            this.f20284M.m6900b((Drawable) null);
            this.f20285N.m6900b((Drawable) null);
        }
    }

    /* renamed from: u */
    private void m21623u() {
        String configStringValue;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT) && (configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT_MODE)) != null && 20 == Integer.parseInt(configStringValue)) {
            this.f20274C.mo3764a((CharSequence) getResources().getString(R.string.camera_subsetting_quick_launch_street_summary));
        }
    }

    /* renamed from: v */
    private void m21624v() throws Resources.NotFoundException {
        COUIPreferenceCategory cOUIPreferenceCategory;
        COUIPreferenceCategory cOUIPreferenceCategory2;
        CharSequence charSequenceX;
        COUIPreferenceCategory cOUIPreferenceCategory3;
        COUIPreferenceCategory cOUIPreferenceCategory4;
        COUIPreferenceCategory cOUIPreferenceCategory5;
        CameraLog.m12959b("CameraSubSettingFragment", "addOrRemoveCameraPreference()");
        if (this.f20329m != null && this.f20275D != null) {
            if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL) && Util.m24419c(m21319o(), "com.coloros.movetosdcard")) || !Storage.m11128b(false)) {
                this.f20329m.m3871d(this.f20275D);
            } else if (this.f20329m.m3869d((CharSequence) CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                this.f20329m.m3867c((Preference) this.f20275D);
            }
        }
        if (this.f20312ao == 0) {
            if ((!this.f20305ah || this.f20306ai) && (cOUIPreferenceCategory5 = this.f20329m) != null) {
                cOUIPreferenceCategory5.m3871d(this.f20273B);
            }
            if (!this.f20304ag) {
                this.f20325i.m3871d(this.f20328l);
            }
        } else {
            this.f20325i.m3871d(this.f20327k);
            this.f20325i.m3871d(this.f20328l);
            this.f20325i.m3871d(this.f20329m);
        }
        if (1 != this.f20312ao) {
            this.f20325i.m3871d(this.f20326j);
        } else {
            this.f20325i.m3871d(this.f20286O);
        }
        if (2 != this.f20312ao) {
            COUIPreferenceCategory cOUIPreferenceCategory6 = this.f20334r;
            if (cOUIPreferenceCategory6 != null) {
                this.f20325i.m3871d(cOUIPreferenceCategory6);
            }
        } else {
            m21606a("on".equals(this.f20324h.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, getString(R.string.camera_slogan_default_value))));
        }
        if (3 != this.f20312ao) {
            this.f20325i.m3871d(this.f20332p);
            this.f20325i.m3871d(this.f20333q);
        } else if (!Util.m24170D()) {
            this.f20325i.m3871d(this.f20333q);
        }
        if (4 != this.f20312ao) {
            this.f20325i.m3871d(this.f20330n);
            this.f20325i.m3871d(this.f20331o);
        }
        if (5 != this.f20312ao) {
            this.f20325i.m3871d(this.f20337u);
            this.f20325i.m3871d(this.f20285N);
            this.f20325i.m3871d(this.f20284M);
        } else {
            this.f20325i.m3871d(this.f20286O);
        }
        if (Util.m24349al()) {
            COUIPreferenceCategory cOUIPreferenceCategory7 = this.f20336t;
            if (cOUIPreferenceCategory7 != null) {
                cOUIPreferenceCategory7.m3871d(this.f20295X);
            }
            COUISwitchPreference cOUISwitchPreference = this.f20293V;
            if (cOUISwitchPreference != null && (cOUIPreferenceCategory4 = this.f20335s) != null) {
                cOUIPreferenceCategory4.m3871d(cOUISwitchPreference);
            }
            String[] stringArray = getResources().getStringArray(R.array.camera_setting_watermark_display_info_option);
            this.f20290S.m3777a((CharSequence[]) Arrays.copyOfRange(stringArray, 0, stringArray.length - 1));
        }
        if (Util.m24350am() && !Util.m24355ar() && (cOUIPreferenceCategory3 = this.f20336t) != null) {
            cOUIPreferenceCategory3.m3871d(this.f20295X);
            this.f20336t.m3871d(this.f20294W);
        }
        if (Util.m24355ar() && (charSequenceX = this.f20292U.m3856x()) != null && charSequenceX.toString().toLowerCase().contains("oneplus")) {
            this.f20292U.m3840d(R.string.camera_slogan_model_name);
        }
        if (!this.f20313ap && (cOUIPreferenceCategory2 = this.f20329m) != null) {
            cOUIPreferenceCategory2.m3871d(this.f20274C);
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SHARE_EDIT_SUPPORT) && (cOUIPreferenceCategory = this.f20329m) != null) {
            cOUIPreferenceCategory.m3871d(this.f20281J);
        }
        m21598a(this.f20327k);
        m21598a(this.f20328l);
        m21598a(this.f20329m);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21606a(boolean z) throws Resources.NotFoundException {
        Bundle arguments;
        CameraLog.m12954a("CameraSubSettingFragment", "updateWatermarkCategoryPreference, watermarkOn: " + z);
        boolean z2 = false;
        if (z) {
            m21611b(true);
            LocationManager.m16155a().m16178b(this.f20324h);
            this.f20334r.m3867c((Preference) this.f20288Q);
            this.f20334r.m3867c((Preference) this.f20335s);
            this.f20334r.m3867c((Preference) this.f20336t);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_WATERMARK_FRONT)) {
                this.f20334r.m3867c((Preference) this.f20338v);
            } else {
                this.f20334r.m3871d(this.f20338v);
            }
            if (!Util.m24349al() && (!Util.m24350am() || Util.m24355ar())) {
                this.f20336t.m3867c((Preference) this.f20295X);
            }
            COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.f20290S;
            m21613c(cOUIMultiSelectListPreference, cOUIMultiSelectListPreference.m3780m());
            m21613c(this.f20289R, this.f20324h.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, ""));
            COUIListPreference cOUIListPreference = this.f20294W;
            m21613c(cOUIListPreference, cOUIListPreference.m3770o());
            COUIListPreference cOUIListPreference2 = this.f20295X;
            m21613c(cOUIListPreference2, cOUIListPreference2.m3770o());
            Set<String> stringSet = this.f20324h.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
            if (stringSet != null && !stringSet.isEmpty()) {
                String[] stringArray = m21319o().getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
                boolean zContains = stringSet.contains(stringArray[0]);
                boolean zContains2 = stringSet.contains(stringArray[1]);
                m21613c(this.f20293V, Boolean.valueOf(stringSet.contains(stringArray[2])));
                m21613c(this.f20291T, Boolean.valueOf(zContains2));
                m21613c(this.f20292U, Boolean.valueOf(zContains));
            }
            m21595a(getActivity());
            this.f20310am = true;
        } else {
            LocationManager.m16155a().m16179b(this.f20321ax);
            if (this.f20310am) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.oplus.camera.ui.menu.setting.p.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraSubSettingFragment.this.m21625w();
                    }
                });
            } else {
                m21625w();
            }
            this.f20325i.m3867c(this.f20286O);
            m21611b(false);
            Fragment fragmentMo3388a = getFragmentManager().mo3388a("androidx.preference.PreferenceFragment.DIALOG");
            if (fragmentMo3388a != null && (fragmentMo3388a instanceof COUIListPreferenceDialogFragment) && (arguments = fragmentMo3388a.getArguments()) != null) {
                String string = arguments.getString("key");
                if (CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE.equals(string) || CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION.equals(string)) {
                    ((COUIListPreferenceDialogFragment) fragmentMo3388a).dismiss();
                }
            }
        }
        this.f20325i.m3871d(this.f20286O);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_WATERMARK_FRONT)) {
            if ("on".equals(this.f20324h.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, getString(R.string.camera_slogan_default_value))) && z) {
                z2 = true;
            }
            m21614c(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m21625w() {
        this.f20334r.m3871d(this.f20288Q);
        this.f20334r.m3871d(this.f20335s);
        this.f20334r.m3871d(this.f20336t);
        this.f20334r.m3871d(this.f20298aa);
        this.f20334r.m3871d(this.f20338v);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21611b(boolean z) {
        this.f20335s.m3824a(z);
        this.f20336t.m3824a(z);
        this.f20338v.m3824a(z);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21614c(boolean z) {
        if (z) {
            this.f20338v.m3867c((Preference) this.f20299ab);
            this.f20299ab.m6217a(false, this.f20324h);
            RecyclerView recyclerView = this.f20318au;
            if (recyclerView == null || recyclerView.getAdapter() == null) {
                return;
            }
            RecyclerView recyclerView2 = this.f20318au;
            recyclerView2.smoothScrollToPosition(recyclerView2.getAdapter().getItemCount());
            return;
        }
        this.f20338v.m3871d(this.f20299ab);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21613c(Preference preference, Object obj) throws Resources.NotFoundException {
        boolean z = this.f20324h.getBoolean(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN, true);
        SharedPreferences.Editor editorEdit = this.f20324h.edit();
        String[] stringArray = getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        String[] stringArray2 = getResources().getStringArray(R.array.camera_setting_watermark_display_info_option);
        String[] stringArray3 = getResources().getStringArray(R.array.camera_setting_watermark_size_values);
        CameraLog.m12954a("CameraSubSettingFragment", "updateWatermarkContentAndConfig, isFirstOpen: " + z);
        boolean zH = false;
        if (z) {
            editorEdit.putBoolean(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN, false).apply();
            if (this.f20290S.m3780m().isEmpty()) {
                this.f20290S.m3776a(Set.of(stringArray[0]));
            }
            COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.f20290S;
            cOUIMultiSelectListPreference.m3831b((Object) cOUIMultiSelectListPreference.m3780m());
            this.f20289R.m6915d((CharSequence) getString(R.string.camera_setting_slogan_name_default));
            this.f20294W.m3765a(stringArray3[1]);
            COUIListPreference cOUIListPreference = this.f20294W;
            cOUIListPreference.m3831b((Object) cOUIListPreference.m3770o());
            this.f20295X.m3765a("bottom_left_corner");
            COUIListPreference cOUIListPreference2 = this.f20295X;
            cOUIListPreference2.m3831b((Object) cOUIListPreference2.m3770o());
        } else if (obj != null) {
            if (preference == this.f20290S) {
                boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SLOGAN_LOCATION_SUPPORT);
                String[] stringArray4 = getResources().getStringArray(R.array.camera_setting_watermark_display_info_description);
                if (!configBooleanValue) {
                    String[] stringArray5 = getResources().getStringArray(R.array.camera_setting_watermark_display_info_option);
                    this.f20290S.m3777a((CharSequence[]) Arrays.copyOfRange(stringArray5, 0, stringArray5.length - 1));
                } else {
                    this.f20290S.m6909b((CharSequence[]) stringArray4);
                }
                Set set = (Set) obj;
                if (set.contains(stringArray[2]) && !m21306h()) {
                    set.remove(stringArray[2]);
                }
                boolean zContains = set.contains(stringArray[0]);
                boolean zContains2 = set.contains(stringArray[1]);
                boolean zContains3 = set.contains(stringArray[2]);
                StringBuilder sb = new StringBuilder();
                if (zContains) {
                    sb.append(stringArray2[0]);
                    sb.append(f20271f);
                }
                if (zContains2) {
                    sb.append(stringArray2[1]);
                    sb.append(f20271f);
                }
                if (zContains3) {
                    sb.append(stringArray2[2]);
                    sb.append(f20271f);
                    LocationManager.m16155a().m16174a(this.f20324h);
                }
                this.f20290S.m6910c((CharSequence) ((TextUtils.isEmpty(sb.toString()) || !f20271f.equals(String.valueOf(sb.charAt(sb.length() - 1)))) ? sb.toString() : sb.substring(0, sb.length() - 1)));
                this.f20290S.m3776a((Set<String>) new HashSet(set));
            } else if (preference == this.f20291T) {
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Set<String> stringSet = this.f20324h.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
                if (stringSet != null) {
                    boolean zContains4 = stringSet.contains(stringArray[1]);
                    if (zContains4 && !zBooleanValue) {
                        stringSet.remove(stringArray[1]);
                    } else if (!zContains4 && zBooleanValue) {
                        stringSet.add(stringArray[1]);
                    }
                    this.f20290S.m3776a((Set<String>) new HashSet(stringSet));
                }
            } else if (preference == this.f20292U) {
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                Set<String> stringSet2 = this.f20324h.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
                if (stringSet2 != null) {
                    boolean zB = this.f20292U.m3901b();
                    if (zB && !zBooleanValue2) {
                        this.f20292U.m3903e(false);
                        stringSet2.remove(stringArray[0]);
                    } else if (!zB && zBooleanValue2) {
                        this.f20292U.m3903e(true);
                        stringSet2.add(stringArray[0]);
                    }
                    this.f20290S.m3776a((Set<String>) new HashSet(stringSet2));
                }
            } else if (preference == this.f20293V) {
                boolean zBooleanValue3 = ((Boolean) obj).booleanValue();
                if (zBooleanValue3) {
                    zH = m21306h();
                    this.f20311an = !zH;
                }
                Set<String> stringSet3 = this.f20324h.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
                if (stringSet3 != null) {
                    boolean zContains5 = stringSet3.contains(stringArray[2]);
                    if (zContains5 && !zBooleanValue3) {
                        stringSet3.remove(stringArray[2]);
                        LocationManager.m16155a().m16174a(this.f20324h);
                    } else if (!zContains5 && zBooleanValue3 && zH) {
                        stringSet3.add(stringArray[2]);
                        if (TextUtils.isEmpty(this.f20315ar)) {
                            LocationManager.m16155a().m16174a(this.f20324h);
                        }
                    }
                    this.f20290S.m3776a((Set<String>) new HashSet(stringSet3));
                }
                this.f20293V.m3903e(zBooleanValue3);
            } else if (preference == this.f20289R) {
                String string = (String) obj;
                this.f20324h.edit().putString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, string).apply();
                if (TextUtils.isEmpty(string)) {
                    string = getResources().getString(R.string.camera_setting_slogan_name_default);
                }
                this.f20289R.m6915d((CharSequence) string);
            } else if (preference == this.f20294W) {
                String str = (String) obj;
                String[] stringArray6 = getResources().getStringArray(R.array.camera_setting_watermark_size_names);
                if (stringArray3[0].equals(str)) {
                    this.f20294W.m6903c((CharSequence) stringArray6[0]);
                } else if (stringArray3[1].equals(str)) {
                    this.f20294W.m6903c((CharSequence) stringArray6[1]);
                } else {
                    this.f20294W.m6903c((CharSequence) stringArray6[2]);
                }
                this.f20294W.m3765a(str);
            } else if (preference == this.f20295X) {
                String str2 = (String) obj;
                if (!Util.m24350am() || Util.m24355ar()) {
                    char c2 = 65535;
                    switch (str2.hashCode()) {
                        case -1364013995:
                            if (str2.equals(TtmlNode.CENTER)) {
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
                        this.f20295X.m6903c((CharSequence) getString(R.string.camera_setting_watermark_location_names_upper_left_corner));
                    } else if (c2 == 1) {
                        this.f20295X.m6903c((CharSequence) getString(R.string.camera_setting_watermark_location_names_upper_right_corner));
                    } else if (c2 == 2) {
                        this.f20295X.m6903c((CharSequence) getString(R.string.camera_setting_watermark_location_names_center));
                    } else if (c2 == 3) {
                        this.f20295X.m6903c((CharSequence) getString(R.string.camera_setting_watermark_location_names_bottom_left_corner));
                    } else if (c2 == 4) {
                        this.f20295X.m6903c((CharSequence) getString(R.string.camera_setting_watermark_location_names_bottom_right_corner));
                    } else {
                        this.f20295X.m6903c((CharSequence) getString(R.string.camera_setting_watermark_location_names_upper_right_corner));
                        str2 = "bottom_left_corner";
                    }
                } else {
                    str2 = (!Util.m24350am() || Util.m24351an()) ? "oplus_c_watermark_position" : "oplus_left_bottom_watermark_position";
                }
                this.f20295X.m3765a(str2);
            }
        }
        editorEdit.apply();
        m21592G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21595a(Activity activity) {
        LocationManager.m16155a().m16176a(this.f20315ar);
        this.f20288Q.m6216a(activity, this.f20324h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21598a(COUIPreferenceCategory cOUIPreferenceCategory) {
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
            if (cOUIPreferenceCategory.m3866c() == 0) {
                this.f20325i.m3871d(cOUIPreferenceCategory);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocationManager.m16155a().m16179b(this.f20321ax);
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isFinishing()) {
            return;
        }
        m21617d(false);
        this.f20297Z = null;
        m21619e(false);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo21304a(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        if (getActivity() != null && this.f20275D != null && bundle.getBoolean("key_storage_dialog_show", false)) {
            this.f20275D.m6202c();
            return true;
        }
        if (getActivity() != null && bundle.getParcelable("watermark_author_dialog_state") != null) {
            m21597a(bundle.getParcelable("watermark_author_dialog_state"));
            return true;
        }
        if (getActivity() != null && getFragmentManager() != null) {
            this.f20296Y = (C1217a) getFragmentManager().mo3388a("DISPLAY_INFO");
            C1217a c1217a = this.f20296Y;
            if (c1217a != null) {
                c1217a.m6226a(this.f20319av);
            }
            return true;
        }
        return super.mo21304a(bundle);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo21305b(Bundle bundle) {
        super.mo21305b(bundle);
        CameraSwitchPreference cameraSwitchPreference = this.f20275D;
        bundle.putBoolean("key_storage_dialog_show", cameraSwitchPreference != null && cameraSwitchPreference.m6204e());
        COUIBottomSheetDialog dialogC1309b = this.f20297Z;
        if (dialogC1309b == null || !dialogC1309b.isShowing()) {
            return;
        }
        bundle.putParcelable("watermark_author_dialog_state", ((COUIEditText) this.f20297Z.m6801a().findViewById(R.id_renamed.bottom_sheet_edit)).onSaveInstanceState());
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ComboPreferences comboPreferences = this.f20324h;
        if (comboPreferences != null) {
            comboPreferences.m11074a(m21319o());
            this.f20324h = null;
        }
        PreferenceScreen preferenceScreen = this.f20325i;
        if (preferenceScreen != null) {
            preferenceScreen.m3870d();
            this.f20325i = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory = this.f20326j;
        if (cOUIPreferenceCategory != null) {
            cOUIPreferenceCategory.m3870d();
            this.f20326j = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory2 = this.f20327k;
        if (cOUIPreferenceCategory2 != null) {
            cOUIPreferenceCategory2.m3870d();
            this.f20327k = null;
        }
        if (this.f20272A != null) {
            this.f20328l.m3870d();
            this.f20328l = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory3 = this.f20329m;
        if (cOUIPreferenceCategory3 != null) {
            cOUIPreferenceCategory3.m3870d();
            this.f20329m = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory4 = this.f20334r;
        if (cOUIPreferenceCategory4 != null) {
            cOUIPreferenceCategory4.m3870d();
            this.f20334r = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory5 = this.f20330n;
        if (cOUIPreferenceCategory5 != null) {
            cOUIPreferenceCategory5.m3870d();
            this.f20330n = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory6 = this.f20331o;
        if (cOUIPreferenceCategory6 != null) {
            cOUIPreferenceCategory6.m3870d();
            this.f20331o = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory7 = this.f20333q;
        if (cOUIPreferenceCategory7 != null) {
            cOUIPreferenceCategory7.m3870d();
            this.f20333q = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory8 = this.f20337u;
        if (cOUIPreferenceCategory8 != null) {
            cOUIPreferenceCategory8.m3870d();
            this.f20337u = null;
        }
        COUIPreferenceCategory cOUIPreferenceCategory9 = this.f20332p;
        if (cOUIPreferenceCategory9 != null) {
            cOUIPreferenceCategory9.m3870d();
            this.f20332p = null;
        }
        CameraSwitchPreference cameraSwitchPreference = this.f20275D;
        if (cameraSwitchPreference != null && cameraSwitchPreference.m6204e()) {
            CameraLog.m12954a("CameraSubSettingFragment", "onDestroyView, Storage Dialog dismiss");
            if (this.f20275D.m6204e()) {
                this.f20275D.m6205f();
            }
            this.f20275D.m6203d();
            this.f20275D = null;
        }
        this.f20342z = null;
        this.f20272A = null;
        this.f20273B = null;
        this.f20274C = null;
        this.f20339w = null;
        this.f20340x = null;
        this.f20341y = null;
        this.f20279H = null;
        this.f20276E = null;
        this.f20278G = null;
        this.f20277F = null;
        this.f20280I = null;
        this.f20283L = null;
        this.f20282K = null;
        this.f20281J = null;
        this.f20284M = null;
        this.f20285N = null;
    }

    @Override // androidx.preference.Preference.InterfaceC0645c
    public boolean onPreferenceClick(Preference preference) throws Resources.NotFoundException, ClassNotFoundException {
        if (((CameraSubSettingActivity) getActivity()) == null) {
            return false;
        }
        if (CameraUIInterface.KEY_CAMERA_CODEC.equals(preference.m3791B())) {
            m21314a(CameraUIInterface.KEY_CAMERA_CODEC, (Object) null);
            m21610b("oplus.intent.action.APP_CODE_SETTING");
        } else if (preference == this.f20276E) {
            this.f20324h.edit().putString(m21591F(), "normal").apply();
            m21586A();
        } else if (preference == this.f20277F) {
            this.f20324h.edit().putString(m21591F(), ApsConstant.CAPTURE_MODE_PANORAMA).apply();
            m21586A();
        } else if (preference == this.f20278G) {
            this.f20324h.edit().putString(m21591F(), "focusing").apply();
            m21586A();
        } else if (preference == this.f20289R) {
            m21597a((Parcelable) null);
            m21314a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, (Object) null);
        } else if (preference == this.f20290S) {
            m21314a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, (Object) null);
        } else if (preference == this.f20294W) {
            m21314a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, (Object) null);
        } else if (preference == this.f20295X) {
            m21314a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, (Object) null);
        } else if (preference == this.f20284M) {
            startActivity(new Intent("oplus.intent.action.APP_OPEN_SOURCE"));
        } else if (preference == this.f20285N) {
            Intent intent = new Intent("com.oplus.bootreg.activity.statementpage");
            intent.putExtra("statement_intent_flag", 2);
            startActivity(intent);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21610b(String str) {
        m21604a(str, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21604a(String str, int OplusGLSurfaceView_13) {
        CameraSettingBaseActivity abstractActivityC3332l = (CameraSettingBaseActivity) getActivity();
        if (abstractActivityC3332l != null) {
            abstractActivityC3332l.m21511b(true);
        }
        Intent intent = new Intent(str);
        Bundle bundle = new Bundle();
        bundle.putInt(CameraUIInterface.KEY_CAMERA_ID, this.f20019d);
        bundle.putInt("camera_enter_type", this.f20018c);
        bundle.putInt("camera_property_camera_id", this.f20020e);
        bundle.putString(CameraUIInterface.KEY_CAMERA_MODE, this.f20017b);
        bundle.putBoolean("camera_enter_form_lock_screen", this.f20314aq);
        bundle.putInt("camera_slogan_setting_from", OplusGLSurfaceView_13);
        intent.putExtra("camera_intent_data", bundle);
        startActivity(intent);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: p */
    public String mo21320p() {
        FragmentActivity activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo21317c(Bundle bundle) {
        CameraLog.m12967f("CameraSubSettingFragment", "parseActivityArguments start");
        if (bundle == null) {
            return;
        }
        this.f20303af = bundle.getBoolean(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, true);
        this.f20304ag = bundle.getBoolean(CameraUIInterface.KEY_LENS_DIRTY_DETECTION, true);
        this.f20307aj = bundle.getBoolean(CameraUIInterface.KEY_IS_CAPTURE_MODE, true);
        this.f20308ak = bundle.getBoolean("KEY_CAMERA_MENU", true);
        this.f20309al = bundle.getBoolean("camera_entry_from", false);
        this.f20312ao = bundle.getInt("camera_sub_setting_from");
        this.f20305ah = bundle.getBoolean(CameraUIInterface.KEY_PHOTO_CODEC);
        this.f20306ai = bundle.getBoolean(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE);
        this.f20313ap = bundle.getBoolean(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, true);
        this.f20314aq = bundle.getBoolean("camera_enter_form_lock_screen", false);
        this.f20301ad = bundle.getBoolean("allow_location", true);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: q */
    protected void mo21321q() {
        CameraSwitchPreference cameraSwitchPreference = this.f20342z;
        if (cameraSwitchPreference != null) {
            this.f20342z.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20342z.m3791B(), "off")));
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.f20272A;
        if (cameraSwitchPreference2 != null) {
            this.f20272A.m3903e("on".equals(cameraSwitchPreference2.m3801L().getString(this.f20272A.m3791B(), "on")));
        }
        if (this.f20274C != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.f20323g = Settings.Secure.getInt(activity.getContentResolver(), "com.oplus.camera quick launch", 0);
            }
            this.f20274C.m3903e(1 == this.f20323g);
        }
        if (1 == this.f20312ao) {
            m21589D();
            m21590E();
        }
        if (this.f20312ao == 0) {
            m21587B();
            m21588C();
        }
        if (3 == this.f20312ao) {
            m21586A();
        }
        if (4 == this.f20312ao) {
            m21628z();
            m21627y();
            m21626x();
        }
        if (this.f20281J != null) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SHARE_EDIT_SUPPORT)) {
                this.f20281J.m3903e(false);
                this.f20281J.m3824a(false);
            } else {
                this.f20281J.m3903e("on".equals(this.f20281J.m3801L().getString(this.f20281J.m3791B(), "on")));
            }
        }
    }

    /* renamed from: x */
    private void m21626x() {
        CameraSwitchPreference cameraSwitchPreference = this.f20280I;
        if (cameraSwitchPreference != null) {
            this.f20280I.m3903e("on".equals(this.f20324h.getString(cameraSwitchPreference.m3791B(), "off")));
        }
    }

    /* renamed from: y */
    private void m21627y() {
        COUIListPreference cOUIListPreference = this.f20283L;
        if (cOUIListPreference != null) {
            String string = this.f20324h.getString(cOUIListPreference.m3791B(), "off");
            this.f20283L.m6903c(m21616d(this.f20283L, string));
            this.f20283L.m3765a(string);
        }
    }

    /* renamed from: z */
    private void m21628z() {
        COUIListPreference cOUIListPreference = this.f20282K;
        if (cOUIListPreference != null) {
            String string = this.f20324h.getString(cOUIListPreference.m3791B(), "off");
            this.f20282K.m6903c(m21616d(this.f20282K, string));
            this.f20282K.m3765a(string);
        }
    }

    /* renamed from: A */
    private void m21586A() {
        if (this.f20278G == null || this.f20277F == null || this.f20276E == null || this.f20279H == null) {
            return;
        }
        String string = this.f20324h.getString(m21591F(), ApsConstant.CAPTURE_MODE_PANORAMA);
        String string2 = this.f20324h.getString(CameraUIInterface.KEY_VIDEO_NOISE_FILTER, "off");
        this.f20276E.m3903e("normal".equals(string));
        this.f20277F.m3903e(ApsConstant.CAPTURE_MODE_PANORAMA.equals(string));
        this.f20278G.m3903e("focusing".equals(string));
        this.f20279H.m3903e("on".equals(string2));
        this.f20279H.m3824a(!"normal".equals(string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m21587B() {
        CameraLog.m12959b("CameraSubSettingFragment", "updateStoragePreference()");
        if (this.f20275D != null) {
            if (Util.m24419c(m21319o(), "com.coloros.movetosdcard") && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STORAGE_SAVE_TO_EXTERNAL)) {
                return;
            }
            if (this.f20329m != null) {
                if (!Storage.m11128b(false)) {
                    this.f20329m.m3871d(this.f20275D);
                    return;
                }
                if (this.f20329m.m3869d((CharSequence) CameraUIInterface.KEY_STORAGE_PLACE) == null) {
                    this.f20275D.m3824a(true);
                    this.f20329m.m3867c((Preference) this.f20275D);
                }
                if (!Util.m24340ac()) {
                    this.f20275D.m3824a(false);
                    this.f20275D.m3837c((Object) false);
                    return;
                }
            }
            if (Storage.m11128b(true) && 8.0d > Storage.m11143g()) {
                this.f20275D.m3837c((Object) true);
            } else {
                this.f20275D.m3837c((Object) false);
            }
            this.f20275D.m3903e("on".equals(this.f20275D.m3801L().getString(this.f20275D.m3791B(), "off")));
        }
    }

    /* renamed from: C */
    private void m21588C() {
        ComboPreferences comboPreferences = this.f20324h;
        if (comboPreferences != null) {
            this.f20273B.m6915d((CharSequence) m21594a(comboPreferences.getString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG"), this.f20324h.getString(CameraUIInterface.KEY_VIDEO_CODEC, CameraParameter.VideoEncoder.H264)));
        }
    }

    /* renamed from: D */
    private void m21589D() {
        CameraSwitchPreference cameraSwitchPreference = this.f20339w;
        if (cameraSwitchPreference != null) {
            this.f20339w.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20339w.m3791B(), "off")));
        }
    }

    /* renamed from: E */
    private void m21590E() {
        CameraSwitchPreference cameraSwitchPreference = this.f20340x;
        if (cameraSwitchPreference != null) {
            this.f20340x.m3903e("on".equals(cameraSwitchPreference.m3801L().getString(this.f20340x.m3791B(), "off")));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m21594a(String str, String str2) {
        String str3;
        if ("HEIF".equals(str)) {
            str3 = "" + getString(R.string.camera_setting_reference_line_photo) + ": HEIF";
        } else {
            str3 = "" + getString(R.string.camera_setting_reference_line_photo) + ": JPEG";
        }
        String str4 = str3 + "/";
        if (CameraParameter.VideoEncoder.H265.equals(str2)) {
            return str4 + getString(R.string.camera_setting_reference_line_video) + ": H.265";
        }
        return str4 + getString(R.string.camera_setting_reference_line_video) + ": H.264";
    }

    /* renamed from: F */
    private String m21591F() {
        return m21318n() ? CameraUIInterface.KEY_VIDEO_SOUND_FRONT : CameraUIInterface.KEY_VIDEO_SOUND_REAR;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static CharSequence m21616d(Preference preference, Object obj) {
        String string = obj.toString();
        if (!(preference instanceof ListPreference)) {
            return string;
        }
        ListPreference listPreference = (ListPreference) preference;
        int iM3766b = listPreference.m3766b(string);
        return iM3766b >= 0 ? listPreference.m3767l()[iM3766b] : "";
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: r */
    protected void mo21322r() {
        CameraLog.m12959b("CameraSubSettingFragment", "installIntentFilterIfNeeded");
        FragmentActivity activity = getActivity();
        if (this.f20302ae || activity == null) {
            return;
        }
        this.f20302ae = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        activity.getApplicationContext().registerReceiver(this.f20320aw, intentFilter, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BasePreferenceFragment
    /* renamed from: s */
    protected void mo21323s() {
        FragmentActivity activity = getActivity();
        if (!this.f20302ae || activity == null) {
            return;
        }
        this.f20302ae = false;
        activity.getApplicationContext().unregisterReceiver(this.f20320aw);
    }

    @Override // androidx.preference.Preference.InterfaceC0644b
    public boolean onPreferenceChange(Preference preference, Object obj) throws Resources.NotFoundException {
        if (preference == null) {
            return false;
        }
        if (!(preference instanceof COUISwitchWithDividerPreference) && preference != this.f20289R && preference != this.f20290S) {
            super.m21315b(preference, obj);
        }
        if (preference instanceof COUIListPreference) {
            ((COUIListPreference) preference).m6903c(m21616d(preference, obj));
        }
        if (preference == this.f20274C) {
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                this.f20323g = 1;
            } else {
                this.f20323g = 0;
            }
            SettingsNative.PlatformImplementations.kt_3.m24843a("com.oplus.camera quick launch", this.f20323g);
        } else if (preference == this.f20287P) {
            m21606a(((Boolean) obj).booleanValue());
        } else if (preference == this.f20290S || preference == this.f20289R || preference == this.f20291T || preference == this.f20292U || preference == this.f20294W || preference == this.f20295X) {
            m21613c(preference, obj);
            m21595a(getActivity());
        } else if (preference == this.f20293V) {
            m21613c(preference, obj);
            m21595a(getActivity());
            if (this.f20311an) {
                this.f20311an = false;
                return false;
            }
        } else if (preference == this.f20340x) {
            if (!((Boolean) obj).booleanValue()) {
                this.f20324h.edit().putString(CameraUIInterface.KEY_LAST_CAMERA_GESTURE_SHUTTER, getString(R.string.camera_gesture_shutter_default_value)).apply();
            }
        } else if (preference == this.f20298aa) {
            m21614c(((Boolean) obj).booleanValue());
        }
        if (preference instanceof CameraSwitchPreference) {
            return ((CameraSwitchPreference) preference).onPreferenceChange(preference, obj);
        }
        return true;
    }

    /* renamed from: G */
    private void m21592G() {
        Set<String> stringSet = this.f20324h.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
        String string = this.f20324h.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
        if ((stringSet == null || stringSet.isEmpty()) && ((string == null || string.isEmpty()) && 1 != CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEVICE_SERIES))) {
            this.f20294W.m3824a(false);
            this.f20295X.m3824a(false);
        } else {
            this.f20294W.m3824a(true);
            this.f20295X.m3824a(true);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo21308j() throws Resources.NotFoundException {
        Set<String> setM;
        String[] stringArray = getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        C1217a c1217a = this.f20296Y;
        if (c1217a != null) {
            setM = c1217a.f6000e;
        } else {
            setM = this.f20290S.m3780m();
        }
        setM.add(stringArray[2]);
        this.f20290S.m3776a(Set.of(setM.toArray(new String[0])));
        COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.f20290S;
        cOUIMultiSelectListPreference.m3831b((Object) cOUIMultiSelectListPreference.m3780m());
        this.f20293V.m3903e(true);
        m21619e(false);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo21309k() throws Resources.NotFoundException {
        String[] stringArray = getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
        this.f20290S.m3780m().remove(stringArray[2]);
        this.f20290S.m3776a(Set.of(r1.toArray(new String[0])));
        COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.f20290S;
        cOUIMultiSelectListPreference.m3831b((Object) cOUIMultiSelectListPreference.m3780m());
        this.f20293V.m3903e(false);
        LocationManager.m16155a().m16174a(this.f20324h);
        m21619e(false);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.BaseLocationPreferenceFragment
    /* renamed from: OplusGLSurfaceView_6 */
    protected void mo21311m() throws Resources.NotFoundException {
        if (Util.m24504x(getActivity())) {
            return;
        }
        mo21309k();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3943b(Preference preference) {
        if (preference == this.f20290S && getFragmentManager() != null) {
            this.f20296Y = C1217a.m6221b(preference.m3791B());
            m21619e(true);
        } else {
            super.mo3943b(preference);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21597a(Parcelable parcelable) throws Resources.NotFoundException, ClassNotFoundException {
        COUIBottomSheetDialog dialogC1309b = this.f20297Z;
        if (dialogC1309b != null && dialogC1309b.isShowing()) {
            CameraLog.m12959b("CameraSubSettingFragment", "showWatermarkAuthorDialog, dialog showing");
            return;
        }
        this.f20297Z = new COUIBottomSheetDialog(getContext(), R.style.DefaultBottomSheetDialog);
        View viewInflate = View.inflate(getContext(), R.layout.camera_setting_custiomize_info_layout, null);
        COUIToolbar cOUIToolbar = (COUIToolbar) viewInflate.findViewById(R.id_renamed.bottom_sheet_toolbar);
        final COUIEditText cOUIEditText = (COUIEditText) viewInflate.findViewById(R.id_renamed.bottom_sheet_edit);
        this.f20297Z.setContentView(viewInflate);
        this.f20297Z.setOwnerActivity(getActivity());
        cOUIToolbar.setTitle(getResources().getString(R.string.camera_setting_watermark_custom_info_title));
        cOUIToolbar.setIsTitleCenterStyle(true);
        if (parcelable != null) {
            cOUIEditText.onRestoreInstanceState(parcelable);
        } else {
            cOUIEditText.setText(this.f20324h.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, ""));
        }
        cOUIEditText.setFastDeletable(true);
        cOUIEditText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.oplus.camera.ui.menu.setting.p.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int OplusGLSurfaceView_13, int i2, Spanned spanned, int i3, int i4) {
                int length = 10 - (spanned.length() - (i4 - i3));
                if (length > 0 && length >= i2 - OplusGLSurfaceView_13) {
                    return null;
                }
                ToastUtil.m24644b(Util.m24472l(), R.string.camera_namelength_outofrange);
                return (length <= 0 || Character.isHighSurrogate(charSequence.charAt(OplusGLSurfaceView_13))) ? "" : charSequence.subSequence(OplusGLSurfaceView_13, length + OplusGLSurfaceView_13);
            }
        }});
        this.f20297Z.m6808a(false, getContext().getResources().getString(R.string.camera_statement_dialog_cancel), new View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraLog.m12959b("CameraSubSettingFragment", "onClick, mWatermarkAuthorEditDialog cancel");
                CameraSubSettingFragment.this.m21617d(false);
                String string = CameraSubSettingFragment.this.f20324h.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "");
                CameraSubSettingFragment.this.m21605a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, Integer.valueOf(string != null ? string.length() : 0), "1");
            }
        }, getContext().getResources().getString(R.string.beauty3d_save), new View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.p.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraLog.m12959b("CameraSubSettingFragment", "onClick, mWatermarkAuthorEditDialog save");
                Editable text = cOUIEditText.getText();
                String string = text == null ? "" : text.toString();
                CameraSubSettingFragment.this.f20289R.m3831b((Object) string);
                CameraSubSettingFragment.this.m21617d(false);
                CameraSubSettingFragment.this.m21605a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, Integer.valueOf(string.length()), "0");
            }
        }, null, null);
        BottomSheetBehavior<FrameLayout> behavior = this.f20297Z.getBehavior();
        if (behavior != null) {
            ((COUIBottomSheetBehavior) behavior).m6639a(new COUIPanelDragListener() { // from class: com.oplus.camera.ui.menu.setting.p.8
                @Override // com.coui.appcompat.dialog.panel.COUIPanelDragListener
                /* renamed from: PlatformImplementations.kt_3 */
                public boolean mo6867a() {
                    CameraLog.m12959b("CameraSubSettingFragment", "onDragWhileEditing");
                    return CameraSubSettingFragment.this.m21607a(cOUIEditText, R.string.camera_slogan_toast_pull_down, "3");
                }
            });
        }
        this.f20297Z.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.menu.setting.p.9
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                if (4 != OplusGLSurfaceView_13 || 1 != keyEvent.getAction()) {
                    return false;
                }
                CameraLog.m12959b("CameraSubSettingFragment", "onKey, back key action up");
                if (CameraSubSettingFragment.this.m21607a(cOUIEditText, R.string.camera_slogan_toast_click_back, "4")) {
                    CameraSubSettingFragment.this.f20297Z.m6809b();
                }
                return true;
            }
        });
        this.f20297Z.m6805a(new View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.p.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                CameraLog.m12959b("CameraSubSettingFragment", "onTouch, outside touch");
                if (CameraSubSettingFragment.this.m21607a(cOUIEditText, R.string.camera_slogan_toast_click_blank, "2")) {
                    CameraSubSettingFragment.this.f20297Z.m6809b();
                }
                return true;
            }
        });
        Window window = this.f20297Z.getWindow();
        if (window != null) {
            cOUIEditText.setFocusable(true);
            cOUIEditText.requestFocus();
            window.setSoftInputMode(5);
        }
        m21617d(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21607a(COUIEditText cOUIEditText, int OplusGLSurfaceView_13, String str) {
        if (cOUIEditText.length() == 0 || AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS >= System.currentTimeMillis() - this.f20300ac) {
            CameraLog.m12959b("CameraSubSettingFragment", "decisionAuthorDialogDismiss, need to dismiss editText length: " + cOUIEditText.length());
            m21617d(false);
            m21605a(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, Integer.valueOf(cOUIEditText.length()), str);
            return false;
        }
        this.f20300ac = System.currentTimeMillis();
        ToastUtil.m24640a(getContext(), OplusGLSurfaceView_13);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21596a(Location location) {
        this.f20316as = location;
        Util.m24389b(this.f20322ay);
        Util.m24279a(this.f20322ay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21605a(String str, Object obj, String str2) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(m21319o());
        menuClickMsgData.mCaptureMode = this.f20017b;
        menuClickMsgData.mCaptureType = m21313a(str);
        menuClickMsgData.mCameraEnterType = String.valueOf(this.f20018c);
        menuClickMsgData.mCameraId = this.f20020e;
        menuClickMsgData.mGuesture = str2;
        if (obj != null) {
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f20020e) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.buildSettingMenuItem(str, obj);
        } else {
            menuClickMsgData.buildSettingJumpItem(str);
        }
        menuClickMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21617d(boolean z) {
        COUIBottomSheetDialog dialogC1309b = this.f20297Z;
        if (dialogC1309b == null) {
            CameraLog.m12967f("CameraSubSettingFragment", "handleWatermarkAuthorEditDialog, mWatermarkAuthorEditDialog is null");
            return;
        }
        Activity ownerActivity = dialogC1309b.getOwnerActivity();
        if (ownerActivity != null) {
            CameraLog.m12959b("CameraSubSettingFragment", "handleWatermarkAuthorEditDialog, isShow: " + z + ", isFinishing: " + ownerActivity.isFinishing() + ", isShowing: " + this.f20297Z.isShowing());
            if (z) {
                if (ownerActivity.isFinishing() || this.f20297Z.isShowing()) {
                    return;
                }
                this.f20297Z.show();
                this.f20297Z.m6812c().getDragView().setVisibility(4);
                this.f20300ac = 0L;
                return;
            }
            if (ownerActivity.isFinishing() || !this.f20297Z.isShowing()) {
                return;
            }
            this.f20297Z.dismiss();
            return;
        }
        CameraLog.m12967f("CameraSubSettingFragment", "handleWatermarkAuthorEditDialog, watermarkDialogActivity is null");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m21619e(boolean z) {
        if (this.f20296Y == null) {
            CameraLog.m12967f("CameraSubSettingFragment", "handleWatermarkDisplayInfoDialog, mCameraWatermarkDisplayInfoDialog is null");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && getFragmentManager() != null) {
            CameraLog.m12959b("CameraSubSettingFragment", "handleWatermarkDisplayInfoDialog, isShow: " + z + ", isFinishing: " + activity.isFinishing());
            if (z) {
                if (activity.isFinishing()) {
                    return;
                }
                this.f20296Y.setTargetFragment(this, 0);
                this.f20296Y.m6226a(this.f20319av);
                this.f20296Y.show(getFragmentManager(), "DISPLAY_INFO");
                return;
            }
            this.f20296Y.dismissAllowingStateLoss();
            return;
        }
        CameraLog.m12967f("CameraSubSettingFragment", "handleWatermarkDisplayInfoDialog, CameraWaterMarkInfoDialogActivity, getFragmentManager is null");
    }
}
