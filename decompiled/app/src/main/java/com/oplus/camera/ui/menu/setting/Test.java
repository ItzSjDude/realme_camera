package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraCodeSettingFragment.java */
/* loaded from: classes2.dex */
public class d_renamed extends androidx.fragment.app.Fragment {
    private com.coui.appcompat.dialog.app.b_renamed.a_renamed g_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6601a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6602b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6603c = 0;
    private java.lang.String d_renamed = null;
    private int e_renamed = -1;
    private int f_renamed = -1;
    private com.oplus.camera.ComboPreferences h_renamed = null;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        android.os.Bundle arguments;
        super.onCreate(bundle);
        this.h_renamed = new com.oplus.camera.ComboPreferences(getActivity().getApplicationContext());
        if ("oplus.intent.action.APP_CODE_SETTING".equals(getActivity().getIntent().getAction()) && (arguments = getArguments()) != null) {
            this.f6603c = arguments.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID);
            this.d_renamed = arguments.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, null);
            this.e_renamed = arguments.getInt("camera_enter_type");
            this.f_renamed = arguments.getInt("camera_property_camera_id");
        }
        this.h_renamed.setLocalId(getActivity(), this.f6603c);
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        return layoutInflater.inflate(com.oplus.camera.R_renamed.layout.camera_setting_codec, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        a_renamed(view);
        b_renamed(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.oplus.camera.ComboPreferences comboPreferences = this.h_renamed;
        if (comboPreferences != null) {
            comboPreferences.a_renamed(getActivity().getApplicationContext());
            this.h_renamed = null;
        }
    }

    private void a_renamed(android.view.View view) {
        this.f6601a = "JPEG".equals(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG")) ? 1 : 0;
        final com.oplus.camera.ui.FixedListView fixedListView = (com.oplus.camera.ui.FixedListView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.list_photo_codec);
        fixedListView.setNestedScrollingEnabled(true);
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("HEIF");
        arrayList.add("JPEG");
        final java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(getString(com.oplus.camera.R_renamed.string.camera_photo_codec_heif_effect_summary));
        arrayList2.add(getString(com.oplus.camera.R_renamed.string.camera_photo_codec_jpeg_effect_summary));
        final com.oplus.camera.ui.menu.setting.d_renamed.a_renamed aVar = new com.oplus.camera.ui.menu.setting.d_renamed.a_renamed(getActivity(), com.oplus.camera.R_renamed.layout.oplus_preference_select_layout, com.oplus.camera.R_renamed.id_renamed.pref_title, arrayList) { // from class: com.oplus.camera.ui.menu.setting.d_renamed.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public android.view.View getView(int i_renamed, android.view.View view2, android.view.ViewGroup viewGroup) {
                android.view.View view3 = super.getView(i_renamed, view2, viewGroup);
                android.widget.CheckBox checkBox = (android.widget.CheckBox) view3.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_checkbox);
                android.widget.TextView textView = (android.widget.TextView) view3.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_summary);
                textView.setText((java.lang.CharSequence) arrayList2.get(i_renamed));
                textView.setVisibility(0);
                if (i_renamed == com.oplus.camera.ui.menu.setting.d_renamed.this.f6601a) {
                    fixedListView.setItemChecked(com.oplus.camera.ui.menu.setting.d_renamed.this.f6601a + fixedListView.getHeaderViewsCount(), true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(i_renamed)) {
                    ((android.widget.TextView) view3.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_title)).setTextColor(com.oplus.camera.ui.menu.setting.d_renamed.this.getResources().getColor(com.oplus.camera.R_renamed.color.setting_pref_text_disable_color));
                }
                return view3;
            }
        };
        fixedListView.setAdapter((android.widget.ListAdapter) aVar);
        fixedListView.setChoiceMode(1);
        fixedListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.oplus.camera.ui.menu.setting.d_renamed.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view2, int i_renamed, long j_renamed) {
                com.oplus.camera.ui.menu.setting.d_renamed.this.f6601a = i_renamed - fixedListView.getHeaderViewsCount();
                boolean zEquals = "on_renamed".equals(com.oplus.camera.ui.menu.setting.d_renamed.this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off"));
                java.lang.String string = com.oplus.camera.ui.menu.setting.d_renamed.this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                java.lang.String str = (java.lang.String) arrayList.get(com.oplus.camera.ui.menu.setting.d_renamed.this.f6601a);
                android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.menu.setting.d_renamed.this.h_renamed.edit();
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, string);
                java.lang.String string2 = com.oplus.camera.ui.menu.setting.d_renamed.this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
                if (zEquals && "JPEG".equals(str) && "HEIF".equals(string2)) {
                    com.oplus.camera.ui.menu.setting.d_renamed.this.a_renamed(str, aVar);
                    return;
                }
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, (java.lang.String) arrayList.get(com.oplus.camera.ui.menu.setting.d_renamed.this.f6601a));
                editorEdit.apply();
                com.oplus.camera.ui.menu.setting.d_renamed dVar = com.oplus.camera.ui.menu.setting.d_renamed.this;
                dVar.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, arrayList.get(dVar.f6601a));
                aVar.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final java.lang.String str, final com.oplus.camera.ui.menu.setting.d_renamed.a_renamed aVar) {
        this.g_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(getContext()).setCustomTitle(android.view.LayoutInflater.from(getContext()).inflate(com.oplus.camera.R_renamed.layout.capture_format_dialog_layout, (android.view.ViewGroup) null)).setPositiveButton(android.R_renamed.string.ok, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.d_renamed.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.menu.setting.d_renamed.this.h_renamed.edit();
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, str);
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
                editorEdit.apply();
                com.oplus.camera.ui.menu.setting.d_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, str);
                aVar.notifyDataSetChanged();
            }
        }).setNegativeButton(android.R_renamed.string.cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.d_renamed.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                dialogInterface.dismiss();
            }
        });
        this.g_renamed.create().show();
    }

    private void b_renamed(android.view.View view) {
        this.f6602b = !com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264)) ? 1 : 0;
        final com.oplus.camera.ui.FixedListView fixedListView = (com.oplus.camera.ui.FixedListView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.list_video_codec);
        fixedListView.setNestedScrollingEnabled(true);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("H_renamed.265");
        arrayList.add("H_renamed.264");
        final com.oplus.camera.ui.menu.setting.d_renamed.a_renamed aVar = new com.oplus.camera.ui.menu.setting.d_renamed.a_renamed(getActivity(), com.oplus.camera.R_renamed.layout.oplus_preference_select_layout, com.oplus.camera.R_renamed.id_renamed.pref_title, arrayList) { // from class: com.oplus.camera.ui.menu.setting.d_renamed.5
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public android.view.View getView(int i_renamed, android.view.View view2, android.view.ViewGroup viewGroup) {
                android.view.View view3 = super.getView(i_renamed, view2, viewGroup);
                android.widget.CheckBox checkBox = (android.widget.CheckBox) view3.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_checkbox);
                android.widget.TextView textView = (android.widget.TextView) view3.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_summary);
                textView.setVisibility(0);
                textView.setText(i_renamed == 0 ? com.oplus.camera.R_renamed.string.camera_video_codec_high_effect_summary : com.oplus.camera.R_renamed.string.camera_video_codec_well_compatibility_summary);
                if (i_renamed == com.oplus.camera.ui.menu.setting.d_renamed.this.f6602b) {
                    com.oplus.camera.ui.FixedListView fixedListView2 = fixedListView;
                    fixedListView2.setItemChecked(fixedListView2.getHeaderViewsCount() + i_renamed, true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(i_renamed)) {
                    ((android.widget.TextView) view3.findViewById(com.oplus.camera.R_renamed.id_renamed.pref_title)).setTextColor(com.oplus.camera.ui.menu.setting.d_renamed.this.getResources().getColor(com.oplus.camera.R_renamed.color.setting_pref_text_disable_color));
                }
                return view3;
            }
        };
        fixedListView.setAdapter((android.widget.ListAdapter) aVar);
        fixedListView.setChoiceMode(1);
        fixedListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.oplus.camera.ui.menu.setting.d_renamed.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view2, int i_renamed, long j_renamed) {
                com.oplus.camera.ui.menu.setting.d_renamed.this.f6602b = i_renamed - fixedListView.getHeaderViewsCount();
                android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.menu.setting.d_renamed.this.h_renamed.edit();
                int i2 = com.oplus.camera.ui.menu.setting.d_renamed.this.f6602b;
                java.lang.String str = com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265;
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, i2 == 0 ? com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265 : com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264);
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && com.oplus.camera.ui.menu.setting.d_renamed.this.f6602b != 0) {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off");
                }
                editorEdit.apply();
                com.oplus.camera.ui.menu.setting.d_renamed dVar = com.oplus.camera.ui.menu.setting.d_renamed.this;
                if (dVar.f6602b != 0) {
                    str = com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264;
                }
                dVar.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, str);
                aVar.notifyDataSetChanged();
            }
        });
    }

    void a_renamed(java.lang.String str, java.lang.Object obj) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(getContext());
        menuClickMsgData.mCaptureMode = this.d_renamed;
        menuClickMsgData.mCaptureType = a_renamed(str);
        menuClickMsgData.mCameraEnterType = java.lang.String.valueOf(this.e_renamed);
        int i_renamed = this.f_renamed;
        menuClickMsgData.mCameraId = i_renamed;
        menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        menuClickMsgData.buildSettingMenuItem(str, obj);
        menuClickMsgData.report();
    }

    private int a_renamed(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT.equals(str)) {
            return 1;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_HELP_AND_FEEDBACK.equals(str)) {
            return (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON.equals(this.d_renamed) || com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO.equals(this.d_renamed) || com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO.equals(this.d_renamed)) ? 1 : 0;
        }
        return 0;
    }

    /* compiled from: CameraCodeSettingFragment.java */
    private class a_renamed extends android.widget.ArrayAdapter {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i_renamed) {
            return i_renamed;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        a_renamed(android.content.Context context, int i_renamed, int i2, java.util.List list) {
            super(context, i_renamed, i2, list);
        }
    }
}
