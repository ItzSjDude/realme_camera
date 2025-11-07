package com.oplus.camera.p172ui.menu.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceDialogFragmentCompat;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.widget.COUISwitch;
import com.oplus.camera.R;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.menu.levelcontrol.VideoSoundSettingSummaryAdapter;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;

/* compiled from: VideoSoundSettingFragment.java */
/* renamed from: com.oplus.camera.ui.menu.setting.r */
/* loaded from: classes2.dex */
public class VideoSoundSettingFragment extends PreferenceDialogFragmentCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private TextView f20361a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUISwitch f20362b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20363c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20364d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20365e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f20366f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f20367g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CharSequence[] f20368h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private CharSequence[] f20369i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private CharSequence[] f20370j = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public static VideoSoundSettingFragment m21630a(String str, String str2, int OplusGLSurfaceView_13, int i2) {
        VideoSoundSettingFragment c3338r = new VideoSoundSettingFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        bundle.putString(CameraUIInterface.KEY_CAMERA_MODE, str2);
        bundle.putInt(CameraUIInterface.KEY_CAMERA_ID, OplusGLSurfaceView_13);
        bundle.putInt("camera_property_camera_id", i2);
        c3338r.setArguments(bundle);
        return c3338r;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21633a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            this.f20361a.setEnabled(false);
            this.f20361a.setTextColor(getResources().getColor(R.color.video_textView_dewind_noise_color));
            this.f20362b.setEnabled(false);
        } else {
            this.f20361a.setEnabled(true);
            this.f20361a.setTextColor(-16777216);
            this.f20362b.setEnabled(true);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3917a(AlertDialog.PlatformImplementations.kt_3 aVar) {
        super.mo3917a(aVar);
        final VideoSoundSettingSummaryAdapter c3294s = new VideoSoundSettingSummaryAdapter(getActivity(), true, true, this.f20363c, CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(this.f20367g), this.f20368h, this.f20370j);
        aVar.setSingleChoiceItems(c3294s, this.f20363c, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.r.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                VideoSoundSettingFragment.this.f20363c = OplusGLSurfaceView_13;
                if (Util.m24170D()) {
                    c3294s.m21033a(OplusGLSurfaceView_13);
                    VideoSoundSettingFragment.this.m21633a(OplusGLSurfaceView_13);
                } else {
                    VideoSoundSettingFragment.this.onClick(dialogInterface, -1);
                    dialogInterface.dismiss();
                }
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraCustomListPreference m21632c() {
        return (CameraCustomListPreference) m3930b();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            CameraCustomListPreference cameraCustomListPreferenceM21632c = m21632c();
            if (cameraCustomListPreferenceM21632c.m3767l() == null || cameraCustomListPreferenceM21632c.m3768m() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f20363c = cameraCustomListPreferenceM21632c.m3766b(cameraCustomListPreferenceM21632c.m3770o());
            this.f20368h = cameraCustomListPreferenceM21632c.m3767l();
            this.f20369i = cameraCustomListPreferenceM21632c.m3768m();
            this.f20370j = cameraCustomListPreferenceM21632c.m21045V();
            this.f20367g = cameraCustomListPreferenceM21632c.m3791B();
        } else {
            this.f20363c = bundle.getInt("VideoSoundSettingFragment.index", 0);
            this.f20368h = bundle.getCharSequenceArray("VideoSoundSettingFragment.entries");
            this.f20369i = bundle.getCharSequenceArray("VideoSoundSettingFragment.entryValues");
            this.f20370j = bundle.getCharSequenceArray("VideoSoundSettingFragment.entrySummary");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20366f = arguments.getString(CameraUIInterface.KEY_CAMERA_MODE);
            this.f20364d = arguments.getInt(CameraUIInterface.KEY_CAMERA_ID);
            this.f20365e = arguments.getInt("camera_property_camera_id");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("VideoSoundSettingFragment.index", this.f20363c);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entries", this.f20368h);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entryValues", this.f20369i);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entrySummary", this.f20370j);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3911a(boolean z) {
        int OplusGLSurfaceView_13;
        if (!z || (OplusGLSurfaceView_13 = this.f20363c) < 0) {
            return;
        }
        String string = this.f20369i[OplusGLSurfaceView_13].toString();
        CameraCustomListPreference cameraCustomListPreferenceM21632c = m21632c();
        if (cameraCustomListPreferenceM21632c.m3831b((Object) string)) {
            cameraCustomListPreferenceM21632c.m3765a(string);
        }
        if (Util.m24170D()) {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_NOISE_FILTER, this.f20362b.isChecked() ? "on" : "off");
            editorEdit.apply();
            m21631a(CameraUIInterface.KEY_VIDEO_NOISE_FILTER, this.f20362b.isChecked() ? MenuClickMsgData.WNR_ON : MenuClickMsgData.WNR_OFF);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        COUIAlertDialog.PlatformImplementations.kt_3 icon = new COUIAlertDialog.PlatformImplementations.kt_3(activity).setTitle(m3930b().m3737a()).setIcon(m3930b().m3739c());
        if (Util.m24170D()) {
            icon.setPositiveButton(getString(R.string.beauty3d_save), this).setNegativeButton(m3930b().m3741e(), this);
            View viewInflate = LayoutInflater.from(activity).inflate(R.layout.video_sound_dewind_noise_switch_layout, (ViewGroup) null);
            this.f20361a = (TextView) viewInflate.findViewById(R.id_renamed.dewind_noise_text);
            this.f20362b = (COUISwitch) viewInflate.findViewById(R.id_renamed.dewind_noise_switch);
            m21633a(this.f20363c);
            this.f20362b.setChecked("on".equals(PreferenceManager.getDefaultSharedPreferences(activity).getString(CameraUIInterface.KEY_VIDEO_NOISE_FILTER, "on")));
            mo3910a(viewInflate);
            icon.setView(viewInflate);
        } else {
            icon.setMessage(m3930b().m3738b());
        }
        mo3917a(icon);
        return icon.create();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21631a(String str, Object obj) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(getActivity());
        menuClickMsgData.mCaptureMode = this.f20366f;
        menuClickMsgData.mCaptureType = 1;
        menuClickMsgData.mCameraId = this.f20365e;
        menuClickMsgData.mOrientation = 0;
        menuClickMsgData.buildSettingMenuItem(str, obj);
        menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f20365e) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }
}
