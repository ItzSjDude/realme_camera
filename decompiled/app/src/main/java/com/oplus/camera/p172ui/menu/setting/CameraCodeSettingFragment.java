package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.FixedListView;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraCodeSettingFragment.java */
/* renamed from: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class CameraCodeSettingFragment extends Fragment {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private COUIAlertDialog.PlatformImplementations.kt_3 f20033g;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20027a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20028b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20029c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f20030d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20031e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20032f = -1;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ComboPreferences f20034h = null;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments;
        super.onCreate(bundle);
        this.f20034h = new ComboPreferences(getActivity().getApplicationContext());
        if ("oplus.intent.action.APP_CODE_SETTING".equals(getActivity().getIntent().getAction()) && (arguments = getArguments()) != null) {
            this.f20029c = arguments.getInt(CameraUIInterface.KEY_CAMERA_ID);
            this.f20030d = arguments.getString(CameraUIInterface.KEY_CAMERA_MODE, null);
            this.f20031e = arguments.getInt("camera_enter_type");
            this.f20032f = arguments.getInt("camera_property_camera_id");
        }
        this.f20034h.setLocalId(getActivity(), this.f20029c);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.camera_setting_codec, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m21327a(view);
        m21332b(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ComboPreferences comboPreferences = this.f20034h;
        if (comboPreferences != null) {
            comboPreferences.m11074a(getActivity().getApplicationContext());
            this.f20034h = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21327a(View view) {
        this.f20027a = "JPEG".equals(this.f20034h.getString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG")) ? 1 : 0;
        final FixedListView fixedListView = (FixedListView) view.findViewById(R.id_renamed.list_photo_codec);
        fixedListView.setNestedScrollingEnabled(true);
        final ArrayList arrayList = new ArrayList();
        arrayList.add("HEIF");
        arrayList.add("JPEG");
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.add(getString(R.string.camera_photo_codec_heif_effect_summary));
        arrayList2.add(getString(R.string.camera_photo_codec_jpeg_effect_summary));
        final PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(getActivity(), R.layout.oplus_preference_select_layout, R.id_renamed.pref_title, arrayList) { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int OplusGLSurfaceView_13, View view2, ViewGroup viewGroup) {
                View view3 = super.getView(OplusGLSurfaceView_13, view2, viewGroup);
                CheckBox checkBox = (CheckBox) view3.findViewById(R.id_renamed.pref_checkbox);
                TextView textView = (TextView) view3.findViewById(R.id_renamed.pref_summary);
                textView.setText((CharSequence) arrayList2.get(OplusGLSurfaceView_13));
                textView.setVisibility(0);
                if (OplusGLSurfaceView_13 == CameraCodeSettingFragment.this.f20027a) {
                    fixedListView.setItemChecked(CameraCodeSettingFragment.this.f20027a + fixedListView.getHeaderViewsCount(), true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(OplusGLSurfaceView_13)) {
                    ((TextView) view3.findViewById(R.id_renamed.pref_title)).setTextColor(CameraCodeSettingFragment.this.getResources().getColor(R.color.setting_pref_text_disable_color));
                }
                return view3;
            }
        };
        fixedListView.setAdapter((ListAdapter) aVar);
        fixedListView.setChoiceMode(1);
        fixedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
                CameraCodeSettingFragment.this.f20027a = OplusGLSurfaceView_13 - fixedListView.getHeaderViewsCount();
                boolean zEquals = "on".equals(CameraCodeSettingFragment.this.f20034h.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off"));
                String string = CameraCodeSettingFragment.this.f20034h.getString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                String str = (String) arrayList.get(CameraCodeSettingFragment.this.f20027a);
                SharedPreferences.Editor editorEdit = CameraCodeSettingFragment.this.f20034h.edit();
                editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, string);
                String string2 = CameraCodeSettingFragment.this.f20034h.getString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                if (zEquals && "JPEG".equals(str) && "HEIF".equals(string2)) {
                    CameraCodeSettingFragment.this.m21329a(str, aVar);
                    return;
                }
                editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
                editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, (String) arrayList.get(CameraCodeSettingFragment.this.f20027a));
                editorEdit.apply();
                CameraCodeSettingFragment c3317d = CameraCodeSettingFragment.this;
                c3317d.m21334a(CameraUIInterface.KEY_PHOTO_CODEC, arrayList.get(c3317d.f20027a));
                aVar.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21329a(final String str, final PlatformImplementations.kt_3 aVar) {
        this.f20033g = new COUIAlertDialog.PlatformImplementations.kt_3(getContext()).setCustomTitle(LayoutInflater.from(getContext()).inflate(R.layout.capture_format_dialog_layout, (ViewGroup) null)).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                SharedPreferences.Editor editorEdit = CameraCodeSettingFragment.this.f20034h.edit();
                editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, str);
                editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
                editorEdit.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
                editorEdit.apply();
                CameraCodeSettingFragment.this.m21334a(CameraUIInterface.KEY_PHOTO_CODEC, str);
                aVar.notifyDataSetChanged();
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                dialogInterface.dismiss();
            }
        });
        this.f20033g.create().show();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21332b(View view) {
        this.f20028b = !CameraParameter.VideoEncoder.H265.equals(this.f20034h.getString(CameraUIInterface.KEY_VIDEO_CODEC, CameraParameter.VideoEncoder.H264)) ? 1 : 0;
        final FixedListView fixedListView = (FixedListView) view.findViewById(R.id_renamed.list_video_codec);
        fixedListView.setNestedScrollingEnabled(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add("H.265");
        arrayList.add("H.264");
        final PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(getActivity(), R.layout.oplus_preference_select_layout, R.id_renamed.pref_title, arrayList) { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5.5
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int OplusGLSurfaceView_13, View view2, ViewGroup viewGroup) {
                View view3 = super.getView(OplusGLSurfaceView_13, view2, viewGroup);
                CheckBox checkBox = (CheckBox) view3.findViewById(R.id_renamed.pref_checkbox);
                TextView textView = (TextView) view3.findViewById(R.id_renamed.pref_summary);
                textView.setVisibility(0);
                textView.setText(OplusGLSurfaceView_13 == 0 ? R.string.camera_video_codec_high_effect_summary : R.string.camera_video_codec_well_compatibility_summary);
                if (OplusGLSurfaceView_13 == CameraCodeSettingFragment.this.f20028b) {
                    FixedListView fixedListView2 = fixedListView;
                    fixedListView2.setItemChecked(fixedListView2.getHeaderViewsCount() + OplusGLSurfaceView_13, true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(OplusGLSurfaceView_13)) {
                    ((TextView) view3.findViewById(R.id_renamed.pref_title)).setTextColor(CameraCodeSettingFragment.this.getResources().getColor(R.color.setting_pref_text_disable_color));
                }
                return view3;
            }
        };
        fixedListView.setAdapter((ListAdapter) aVar);
        fixedListView.setChoiceMode(1);
        fixedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
                CameraCodeSettingFragment.this.f20028b = OplusGLSurfaceView_13 - fixedListView.getHeaderViewsCount();
                SharedPreferences.Editor editorEdit = CameraCodeSettingFragment.this.f20034h.edit();
                int i2 = CameraCodeSettingFragment.this.f20028b;
                String str = CameraParameter.VideoEncoder.H265;
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, i2 == 0 ? CameraParameter.VideoEncoder.H265 : CameraParameter.VideoEncoder.H264);
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && CameraCodeSettingFragment.this.f20028b != 0) {
                    editorEdit.putString(CameraUIInterface.KEY_VIDEO_HDR, "off");
                }
                editorEdit.apply();
                CameraCodeSettingFragment c3317d = CameraCodeSettingFragment.this;
                if (c3317d.f20028b != 0) {
                    str = CameraParameter.VideoEncoder.H264;
                }
                c3317d.m21334a(CameraUIInterface.KEY_VIDEO_CODEC, str);
                aVar.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m21334a(String str, Object obj) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(getContext());
        menuClickMsgData.mCaptureMode = this.f20030d;
        menuClickMsgData.mCaptureType = m21326a(str);
        menuClickMsgData.mCameraEnterType = String.valueOf(this.f20031e);
        int OplusGLSurfaceView_13 = this.f20032f;
        menuClickMsgData.mCameraId = OplusGLSurfaceView_13;
        menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.buildSettingMenuItem(str, obj);
        menuClickMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21326a(String str) {
        if (CameraUIInterface.KEY_VIDEO_SOUND_REAR.equals(str) || CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(str)) {
            return 1;
        }
        if (CameraUIInterface.KEY_HELP_AND_FEEDBACK.equals(str)) {
            return (ApsConstant.REC_MODE_COMMON.equals(this.f20030d) || ApsConstant.REC_MODE_FAST_VIDEO.equals(this.f20030d) || ApsConstant.REC_MODE_SLOW_VIDEO.equals(this.f20030d)) ? 1 : 0;
        }
        return 0;
    }

    /* compiled from: CameraCodeSettingFragment.java */
    /* renamed from: com.oplus.camera.ui.menu.setting.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends ArrayAdapter {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        PlatformImplementations.kt_3(Context context, int OplusGLSurfaceView_13, int i2, List list) {
            super(context, OplusGLSurfaceView_13, i2, list);
        }
    }
}
