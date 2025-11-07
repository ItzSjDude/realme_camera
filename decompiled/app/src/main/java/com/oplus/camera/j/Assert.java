package com.oplus.camera.j_renamed;

/* compiled from: CommonBottomGuide.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f4723a = {com.oplus.camera.R_renamed.string.camera_id_photo_mode_tips_background, com.oplus.camera.R_renamed.string.camera_id_photo_mode_tips_distance, com.oplus.camera.R_renamed.string.camera_id_photo_mode_tips_align};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final int[] f4724b = {com.oplus.camera.R_renamed.drawable.id_photo_tips_background, com.oplus.camera.R_renamed.drawable.id_photo_tips_distance, com.oplus.camera.R_renamed.drawable.id_photo_tips_align};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int[] f4725c = {com.oplus.camera.R_renamed.string.camera_double_exposure_guide_hint, com.oplus.camera.R_renamed.string.camera_double_exposure_guide_hint_secord, com.oplus.camera.R_renamed.string.camera_double_exposure_guide_hint_third};
    private static final android.net.Uri[] d_renamed = new android.net.Uri[3];
    private static java.lang.String e_renamed = "CommonBottomGuide";
    private com.oplus.camera.ComboPreferences f_renamed;
    private com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed x_renamed;
    private com.oplus.camera.ui.CameraUIListener y_renamed;
    private android.os.Handler z_renamed;
    private com.oplus.camera.ui.s_renamed g_renamed = null;
    private com.oplus.camera.ui.s_renamed h_renamed = null;
    private com.oplus.camera.ui.s_renamed i_renamed = null;
    private com.oplus.camera.ui.s_renamed j_renamed = null;
    private com.oplus.camera.ui.s_renamed k_renamed = null;
    private com.oplus.camera.ui.s_renamed l_renamed = null;
    private android.app.Dialog m_renamed = null;
    private android.app.Dialog n_renamed = null;
    private android.app.Dialog o_renamed = null;
    private androidx.recyclerview.widget.RecyclerView p_renamed = null;
    private com.oplus.camera.longexposure.a_renamed q_renamed = null;
    private androidx.viewpager2.widget.ViewPager2 r_renamed = null;
    private com.coui.appcompat.widget.COUIPageIndicator s_renamed = null;
    private com.oplus.camera.ui.widget.TextureVideoView t_renamed = null;
    private com.oplus.camera.doubleexposure.DoubleExposureVideoView u_renamed = null;
    private android.widget.ImageView v_renamed = null;
    private java.lang.Thread w_renamed = null;
    private long A_renamed = 0;
    private int B_renamed = 0;
    private boolean C_renamed = false;
    private boolean D_renamed = false;
    private boolean E_renamed = false;

    public a_renamed(com.oplus.camera.ComboPreferences comboPreferences, com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed aVar, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.f_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.f_renamed = comboPreferences;
        this.x_renamed = aVar;
        this.y_renamed = cameraUIListener;
        if (this.z_renamed == null) {
            this.z_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
        }
    }

    public void a_renamed(android.app.Activity activity) {
        android.app.Dialog dialog = this.m_renamed;
        if (dialog != null && dialog.isShowing()) {
            a_renamed(3, false);
        } else {
            a_renamed(activity, 3);
        }
    }

    public void b_renamed(android.app.Activity activity) {
        android.app.Dialog dialog = this.n_renamed;
        if (dialog != null && dialog.isShowing()) {
            a_renamed(8, false);
        } else {
            a_renamed(activity, 8);
        }
    }

    public void a_renamed(android.app.Activity activity, int i_renamed) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        com.oplus.camera.e_renamed.b_renamed(e_renamed, "showCommonBottomGuide, start show type: " + i_renamed);
        switch (i_renamed) {
            case 1:
                l_renamed(activity);
                break;
            case 2:
                e_renamed(activity);
                break;
            case 3:
                d_renamed(activity);
                break;
            case 4:
                g_renamed(activity);
                break;
            case 5:
                m_renamed(activity);
                break;
            case 6:
                p_renamed(activity);
                break;
            case 7:
                f_renamed(activity);
                break;
            case 8:
                h_renamed(activity);
                break;
            case 9:
                q_renamed(activity);
                break;
        }
        com.oplus.camera.e_renamed.b_renamed(e_renamed, "showCommonBottomGuide, finish show type: " + i_renamed);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ComboPreferences comboPreferences;
        com.oplus.camera.ComboPreferences comboPreferences2;
        com.oplus.camera.e_renamed.b_renamed(e_renamed, "hideCommonBottomGuide, start hide type: " + i_renamed + ", remove: " + z_renamed);
        boolean z2 = false;
        switch (i_renamed) {
            case 1:
                com.oplus.camera.ui.s_renamed sVar = this.g_renamed;
                if (sVar != null) {
                    a_renamed(sVar);
                    if (z_renamed && (comboPreferences = this.f_renamed) != null) {
                        comboPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, false).apply();
                        break;
                    }
                }
                break;
            case 2:
                com.oplus.camera.ui.s_renamed sVar2 = this.h_renamed;
                if (sVar2 != null) {
                    a_renamed(sVar2);
                    if (z_renamed && (comboPreferences2 = this.f_renamed) != null) {
                        comboPreferences2.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_NIGHT_TRIPOD, false).apply();
                        break;
                    }
                }
                break;
            case 3:
                b_renamed(this.m_renamed);
                break;
            case 4:
                a_renamed(this.i_renamed);
                break;
            case 5:
                com.oplus.camera.ui.s_renamed sVar3 = this.k_renamed;
                if (sVar3 != null && !sVar3.b_renamed()) {
                    z2 = true;
                }
                this.E_renamed = z2;
                a_renamed(this.k_renamed);
                break;
            case 6:
                a_renamed(this.l_renamed);
                break;
            case 7:
                a_renamed(this.j_renamed);
                break;
            case 8:
                b_renamed(this.n_renamed);
                break;
            case 9:
                b_renamed(this.o_renamed);
                break;
        }
        com.oplus.camera.e_renamed.b_renamed(e_renamed, "hideCommonBottomGuide, finish hide type: " + i_renamed + ", remove: " + z_renamed);
    }

    public void a_renamed() {
        a_renamed(this.g_renamed);
        a_renamed(this.h_renamed);
        b_renamed(this.m_renamed);
        a_renamed(this.i_renamed);
        b_renamed(this.n_renamed);
        a_renamed(this.k_renamed);
        a_renamed(this.j_renamed);
        b_renamed(this.o_renamed);
    }

    private void a_renamed(androidx.fragment.app.b_renamed bVar) {
        if (bVar == null || bVar.getDialog() == null || !bVar.getDialog().isShowing()) {
            return;
        }
        bVar.getDialog().hide();
        bVar.dismiss();
    }

    private void b_renamed(android.app.Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.hide();
        dialog.dismiss();
    }

    private boolean i_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW);
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    private void d_renamed(android.app.Activity activity) {
        this.m_renamed = new android.app.Dialog(activity, com.oplus.camera.R_renamed.style.ProfessionalModeGuideTheme);
        this.m_renamed.setContentView(com.oplus.camera.R_renamed.layout.common_bottom_guide_professional_parameter_layout);
        this.m_renamed.setCanceledOnTouchOutside(true);
        this.m_renamed.setCancelable(true);
        android.view.Window window = this.m_renamed.getWindow();
        int iK = this.y_renamed.bL_renamed().k_renamed();
        if (com.oplus.camera.util.Util.u_renamed()) {
            iK = this.y_renamed.bM_renamed();
            if (iK % 180 != 0) {
                iK = 360 - iK;
            }
            android.view.View viewFindViewById = this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_parameter_layout);
            viewFindViewById.setRotation(iK);
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int screenWidth = (com.oplus.camera.util.Util.getScreenWidth() - com.oplus.camera.util.Util.getScreenHeight()) / 2;
            if (iK != 0) {
                layoutParams.leftMargin += screenWidth;
                layoutParams.rightMargin += screenWidth;
                layoutParams.topMargin -= screenWidth;
                layoutParams.bottomMargin -= screenWidth;
            }
        }
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
        this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ivCancel).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.a_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.j_renamed.a_renamed.this.m_renamed == null || !com.oplus.camera.j_renamed.a_renamed.this.m_renamed.isShowing()) {
                    return;
                }
                com.oplus.camera.j_renamed.a_renamed.this.m_renamed.dismiss();
                com.oplus.camera.j_renamed.a_renamed.this.m_renamed = null;
            }
        });
        a_renamed((android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvIsoTitle));
        a_renamed((android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvShutterTitle));
        a_renamed((android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvWhiteBalanceTitle));
        a_renamed((android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvWhiteAmfTitle));
        a_renamed((android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvWhiteEvfTitle));
        if (i_renamed()) {
            a_renamed((android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvRawTitle));
        }
        int i_renamed = i_renamed() ? 0 : 8;
        this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvRawTitle).setVisibility(i_renamed);
        this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tvRawDescription).setVisibility(i_renamed);
        android.view.View viewFindViewById2 = this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.svContent);
        viewFindViewById2.setOnScrollChangeListener(new android.view.View.OnScrollChangeListener() { // from class: com.oplus.camera.j_renamed.a_renamed.12
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(android.view.View view, int i2, int i3, int i4, int i5) {
                android.view.View viewFindViewById3;
                if (com.oplus.camera.j_renamed.a_renamed.this.m_renamed == null || !com.oplus.camera.j_renamed.a_renamed.this.m_renamed.isShowing() || (viewFindViewById3 = com.oplus.camera.j_renamed.a_renamed.this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.vDivider)) == null) {
                    return;
                }
                viewFindViewById3.setVisibility(!((androidx.core.widget.NestedScrollView) view).canScrollVertically(-1) ? 4 : 0);
            }
        });
        if (com.oplus.camera.util.Util.aa_renamed()) {
            androidx.appcompat.widget.LinearLayoutCompat.a_renamed aVar = (androidx.appcompat.widget.LinearLayoutCompat.a_renamed) viewFindViewById2.getLayoutParams();
            if (90 == iK) {
                aVar.rightMargin = com.oplus.camera.util.Util.Z_renamed();
            } else if (270 == iK) {
                aVar.leftMargin = com.oplus.camera.util.Util.Z_renamed();
                android.view.View viewFindViewById3 = this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ivCancel);
                androidx.appcompat.widget.LinearLayoutCompat.a_renamed aVar2 = (androidx.appcompat.widget.LinearLayoutCompat.a_renamed) viewFindViewById3.getLayoutParams();
                aVar2.leftMargin += com.oplus.camera.util.Util.Z_renamed();
                viewFindViewById3.setLayoutParams(aVar2);
            } else {
                aVar.bottomMargin = com.oplus.camera.util.Util.Z_renamed();
            }
        }
        if (this.m_renamed.isShowing()) {
            return;
        }
        try {
            a_renamed(this.m_renamed);
        } catch (android.view.WindowManager.BadTokenException e2) {
            if (this.m_renamed.isShowing()) {
                this.m_renamed.dismiss();
                this.m_renamed = null;
            }
            com.oplus.camera.e_renamed.e_renamed(e_renamed, "showProfessionalParameterBottomGuide, exception: " + e2.getMessage());
        }
    }

    private void a_renamed(android.widget.TextView textView) {
        java.lang.String string;
        int iIndexOf;
        try {
            if (1 != androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault()) || textView == null || textView.getText() == null || (iIndexOf = (string = textView.getText().toString()).indexOf(40)) <= 0 || iIndexOf >= string.length()) {
                return;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.String strSubstring = string.substring(0, iIndexOf);
            java.lang.String strSubstring2 = string.substring(iIndexOf);
            stringBuffer.append(strSubstring);
            stringBuffer.append(strSubstring2);
            textView.setText(androidx.core.f_renamed.a_renamed.a_renamed(true).a_renamed(stringBuffer, androidx.core.f_renamed.e_renamed.e_renamed));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed(e_renamed, " setRtlProfessionalTitleText error : " + e2.toString());
        }
    }

    private void e_renamed(android.app.Activity activity) {
        if (this.h_renamed == null) {
            this.h_renamed = a_renamed(activity, com.oplus.camera.R_renamed.layout.common_bottom_guide_night_tripod_layout, com.oplus.camera.R_renamed.string.tripod_night_guide_title, com.oplus.camera.R_renamed.string.night_tripod_guide_description_new);
            ((android.widget.ImageView) this.h_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.imageView)).setOutlineProvider(new com.oplus.camera.j_renamed.a_renamed.CommonBottomGuide_5());
            this.h_renamed.a_renamed(new com.oplus.camera.ui.s_renamed.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$-6t9oV8odGoNwtWwnveaxwn1wlQ
                @Override // com.oplus.camera.ui.s_renamed.a_renamed
                public final void onGuideDialogShowAction() {
                    this.f_renamed$0.o_renamed();
                }
            });
            this.h_renamed.a_renamed(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.j_renamed.a_renamed.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(android.content.DialogInterface dialogInterface) {
                    if (com.oplus.camera.j_renamed.a_renamed.this.f_renamed != null) {
                        com.oplus.camera.j_renamed.a_renamed.this.f_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_NIGHT_TRIPOD, false).apply();
                    }
                }
            });
        }
        if (this.h_renamed.isAdded()) {
            return;
        }
        this.h_renamed.show(((androidx.appcompat.app.c_renamed) activity).j_renamed(), "showNightTripodBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o_renamed() {
        this.h_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.guide_button_ok).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$ql4HwBFRIQZZ8Jq4CT11fqaDzAk
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.f_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f_renamed(android.view.View view) {
        a_renamed(this.h_renamed);
    }

    private void f_renamed(android.app.Activity activity) {
        if (this.j_renamed == null) {
            this.j_renamed = o_renamed(activity);
            this.j_renamed.a_renamed(new com.oplus.camera.ui.s_renamed.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$1M7jQtsmqnjbSz_U4xrvfeoYtUk
                @Override // com.oplus.camera.ui.s_renamed.a_renamed
                public final void onGuideDialogShowAction() {
                    this.f_renamed$0.n_renamed();
                }
            });
            this.j_renamed.a_renamed(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.j_renamed.a_renamed.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(android.content.DialogInterface dialogInterface) {
                    if (com.oplus.camera.j_renamed.a_renamed.this.f_renamed != null) {
                        com.oplus.camera.j_renamed.a_renamed.this.f_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_MAKEUP_TIPS_SHOWED, false).apply();
                    }
                }
            });
        }
        if (this.j_renamed.isAdded()) {
            return;
        }
        this.j_renamed.show(((androidx.appcompat.app.c_renamed) activity).j_renamed(), "showMakeupBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n_renamed() {
        this.j_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.guide_button_ok).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$3OmpZ2qhqPLhLksDR0qjSSJ9ig4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.e_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_renamed(android.view.View view) {
        a_renamed(this.j_renamed);
    }

    private void g_renamed(android.app.Activity activity) {
        if (this.i_renamed == null) {
            this.i_renamed = a_renamed(activity, com.oplus.camera.R_renamed.layout.common_bottom_guide_id_photo_layout, f4723a, f4724b);
            this.i_renamed.a_renamed(new com.oplus.camera.ui.s_renamed.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$VtXUHbd8H7d2BwCsP8oKrhE7SLU
                @Override // com.oplus.camera.ui.s_renamed.a_renamed
                public final void onGuideDialogShowAction() {
                    this.f_renamed$0.m_renamed();
                }
            });
            this.i_renamed.a_renamed(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.j_renamed.a_renamed.19
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(android.content.DialogInterface dialogInterface) {
                    if (com.oplus.camera.j_renamed.a_renamed.this.f_renamed != null) {
                        com.oplus.camera.j_renamed.a_renamed.this.f_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, true).apply();
                    }
                }
            });
        }
        if (this.i_renamed.isAdded()) {
            return;
        }
        this.i_renamed.show(((androidx.appcompat.app.c_renamed) activity).j_renamed(), "showIdPhotoBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m_renamed() {
        this.i_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.guide_button_ok).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$iSU3WfyJKlfazsV4Ws9aMQrRlVU
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.d_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(android.view.View view) {
        a_renamed(this.i_renamed);
    }

    private void h_renamed(android.app.Activity activity) {
        this.n_renamed = new android.app.Dialog(activity, com.oplus.camera.R_renamed.style.ProfessionalModeGuideTheme);
        this.n_renamed.setContentView(com.oplus.camera.R_renamed.layout.common_bottom_guide_longexposure_parameter_layout);
        this.n_renamed.setCanceledOnTouchOutside(true);
        this.n_renamed.setCancelable(true);
        android.view.Window window = this.n_renamed.getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.windowAnimations = com.oplus.camera.R_renamed.style.ProfessionalModeGuideDialog;
            window.setAttributes(attributes);
        }
        i_renamed(activity);
        this.n_renamed.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.j_renamed.a_renamed.20
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(android.content.DialogInterface dialogInterface) {
                com.oplus.camera.j_renamed.a_renamed.this.p_renamed = null;
            }
        });
        this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ivCancel).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.a_renamed.21
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.j_renamed.a_renamed.this.n_renamed == null || !com.oplus.camera.j_renamed.a_renamed.this.n_renamed.isShowing()) {
                    return;
                }
                com.oplus.camera.j_renamed.a_renamed.this.n_renamed.dismiss();
                com.oplus.camera.j_renamed.a_renamed.this.n_renamed = null;
            }
        });
        android.view.View viewFindViewById = this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.svContent);
        viewFindViewById.setOnScrollChangeListener(new android.view.View.OnScrollChangeListener() { // from class: com.oplus.camera.j_renamed.a_renamed.22
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(android.view.View view, int i_renamed, int i2, int i3, int i4) {
                android.view.View viewFindViewById2;
                if (com.oplus.camera.j_renamed.a_renamed.this.n_renamed == null || !com.oplus.camera.j_renamed.a_renamed.this.n_renamed.isShowing() || (viewFindViewById2 = com.oplus.camera.j_renamed.a_renamed.this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.vDivider)) == null) {
                    return;
                }
                viewFindViewById2.setVisibility(!((androidx.core.widget.NestedScrollView) view).canScrollVertically(-1) ? 4 : 0);
            }
        });
        if (com.oplus.camera.util.Util.aa_renamed()) {
            ((androidx.appcompat.widget.LinearLayoutCompat.a_renamed) viewFindViewById.getLayoutParams()).bottomMargin = com.oplus.camera.util.Util.Z_renamed();
        }
        if (this.n_renamed.isShowing()) {
            return;
        }
        try {
            a_renamed(this.n_renamed);
        } catch (android.view.WindowManager.BadTokenException e2) {
            if (this.n_renamed.isShowing()) {
                this.n_renamed.dismiss();
                this.n_renamed = null;
            }
            com.oplus.camera.e_renamed.e_renamed(e_renamed, "showLongExposureParameterBottomGuide, exception: " + e2.getMessage());
        }
    }

    private void i_renamed(android.app.Activity activity) {
        this.p_renamed = (androidx.recyclerview.widget.RecyclerView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.long_exposure_options_rv);
        this.p_renamed.setOverScrollMode(2);
        this.p_renamed.setClipChildren(false);
        this.p_renamed.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activity, 1, false));
        java.util.List<com.oplus.camera.longexposure.b_renamed> listK = k_renamed(activity);
        if (this.q_renamed == null) {
            this.q_renamed = new com.oplus.camera.longexposure.a_renamed(listK);
        }
        this.p_renamed.setAdapter(this.q_renamed);
    }

    private java.util.List<com.oplus.camera.longexposure.b_renamed> j_renamed(android.app.Activity activity) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.camera.longexposure.b_renamed(2, activity.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_busy_traffic)), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_busy_traffic_description), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_busy_traffic)));
        arrayList.add(new com.oplus.camera.longexposure.b_renamed(3, activity.getString(com.oplus.camera.R_renamed.string.camera_long_exposure_type_flowing_clouds_and_water), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_flowing_clouds_and_water_desc), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_flowing_clouds_and_water)));
        arrayList.add(new com.oplus.camera.longexposure.b_renamed(4, activity.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_painting)), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_light_painting_description), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_light_painting)));
        return arrayList;
    }

    private java.util.List<com.oplus.camera.longexposure.b_renamed> k_renamed(android.app.Activity activity) {
        java.util.List<com.oplus.camera.longexposure.b_renamed> listJ = j_renamed(activity);
        int[] configIntArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LONG_EXPOSURE_SCENE_TYPE_ARRAY);
        if (configIntArrayValue != null && configIntArrayValue.length > 0) {
            if (listJ != null && !listJ.isEmpty()) {
                listJ.clear();
            }
            for (int i_renamed : configIntArrayValue) {
                if (i_renamed == 1) {
                    listJ.add(new com.oplus.camera.longexposure.b_renamed(1, activity.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_rail_portrait)), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_light_rail_portrait_description), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_streamer_portrait)));
                } else if (i_renamed == 2) {
                    listJ.add(new com.oplus.camera.longexposure.b_renamed(2, activity.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_busy_traffic)), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_busy_traffic_description), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_busy_traffic)));
                } else if (i_renamed == 3) {
                    listJ.add(new com.oplus.camera.longexposure.b_renamed(3, activity.getString(com.oplus.camera.R_renamed.string.camera_long_exposure_type_flowing_clouds_and_water), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_flowing_clouds_and_water_desc), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_flowing_clouds_and_water)));
                } else if (i_renamed == 4) {
                    listJ.add(new com.oplus.camera.longexposure.b_renamed(4, activity.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_painting)), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_light_painting_description), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_light_painting)));
                } else if (i_renamed == 5) {
                    listJ.add(new com.oplus.camera.longexposure.b_renamed(5, activity.getString(com.oplus.camera.R_renamed.string.camera_long_exposure_type_moving_crowd), activity.getString(com.oplus.camera.R_renamed.string.long_exposure_mode_guide_moving_crowd_description), activity.getDrawable(com.oplus.camera.R_renamed.drawable.guide_long_exposure_moving_crowd)));
                }
            }
        }
        return listJ;
    }

    private void l_renamed(final android.app.Activity activity) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.g_renamed = a_renamed(activity, com.oplus.camera.R_renamed.layout.common_bottom_guide_fast_video_layout, com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_title, com.oplus.camera.R_renamed.string.hyper_lapse_guide_description);
        this.t_renamed = (com.oplus.camera.ui.widget.TextureVideoView) this.g_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.videoView);
        this.v_renamed = (android.widget.ImageView) this.g_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.iv_video_thumb);
        android.net.Uri uri = android.net.Uri.parse("android.resource://" + activity.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.fastvideo_guide);
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        final java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.oplus.camera.j_renamed.a_renamed.23
            @Override // java.lang.Runnable
            public void run() throws java.lang.IllegalStateException {
                if (com.oplus.camera.j_renamed.a_renamed.this.t_renamed != null) {
                    com.oplus.camera.j_renamed.a_renamed.this.t_renamed.start();
                    com.oplus.camera.j_renamed.a_renamed.this.t_renamed.requestFocus();
                }
            }
        };
        java.lang.Runnable runnable2 = new java.lang.Runnable() { // from class: com.oplus.camera.j_renamed.a_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.j_renamed.a_renamed.this.g_renamed.isAdded()) {
                    return;
                }
                com.oplus.camera.j_renamed.a_renamed.this.g_renamed.show(((androidx.appcompat.app.c_renamed) activity).j_renamed(), "showFastVideoBottomGuide");
            }
        };
        final java.lang.Runnable runnable3 = new java.lang.Runnable() { // from class: com.oplus.camera.j_renamed.a_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.j_renamed.a_renamed.this.x_renamed != null) {
                    com.oplus.camera.j_renamed.a_renamed.this.x_renamed.a_renamed();
                }
                if (com.oplus.camera.j_renamed.a_renamed.this.z_renamed != null) {
                    com.oplus.camera.j_renamed.a_renamed.this.z_renamed.removeCallbacksAndMessages(null);
                }
            }
        };
        this.v_renamed.setClipToOutline(true);
        this.v_renamed.setOutlineProvider(new com.oplus.camera.j_renamed.a_renamed.CommonBottomGuide_5());
        this.v_renamed.setOutlineSpotShadowColor(activity.getResources().getColor(android.R_renamed.color.transparent));
        this.t_renamed.setEnabled(false);
        this.t_renamed.setOutlineProvider(new com.oplus.camera.j_renamed.a_renamed.CommonBottomGuide_5());
        this.t_renamed.setClipToOutline(true);
        this.t_renamed.setVideoURI(uri);
        this.t_renamed.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.j_renamed.a_renamed.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(android.media.MediaPlayer mediaPlayer) {
                com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.j_renamed.a_renamed.e_renamed, "videoView onPrepared");
                mediaPlayer.setLooping(true);
                long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                if (0 <= jCurrentTimeMillis2) {
                    com.oplus.camera.j_renamed.a_renamed.this.z_renamed.post(runnable);
                } else {
                    com.oplus.camera.j_renamed.a_renamed.this.z_renamed.postDelayed(runnable, 0 - jCurrentTimeMillis2);
                }
            }
        });
        this.t_renamed.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() { // from class: com.oplus.camera.j_renamed.a_renamed.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i_renamed, int i2) {
                if (3 != i_renamed || com.oplus.camera.j_renamed.a_renamed.this.v_renamed == null) {
                    return true;
                }
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(com.oplus.camera.j_renamed.a_renamed.this.v_renamed, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat.setRepeatCount(0);
                objectAnimatorOfFloat.start();
                return true;
            }
        });
        this.t_renamed.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() { // from class: com.oplus.camera.j_renamed.a_renamed.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(android.media.MediaPlayer mediaPlayer, int i_renamed, int i2) {
                com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.j_renamed.a_renamed.e_renamed, "videoView onError, what: " + i_renamed + ", extra: " + i2);
                return false;
            }
        });
        this.g_renamed.a_renamed(new com.oplus.camera.ui.s_renamed.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$0iMX4jyKt8eDfyBKgkPVyYxlhb4
            @Override // com.oplus.camera.ui.s_renamed.a_renamed
            public final void onGuideDialogShowAction() {
                this.f_renamed$0.l_renamed();
            }
        });
        this.D_renamed = false;
        this.g_renamed.a_renamed(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.j_renamed.a_renamed.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(android.content.DialogInterface dialogInterface) throws java.lang.IllegalStateException {
                if (com.oplus.camera.j_renamed.a_renamed.this.D_renamed) {
                    com.oplus.camera.j_renamed.a_renamed.this.D_renamed = false;
                    return;
                }
                if (com.oplus.camera.j_renamed.a_renamed.this.v_renamed != null) {
                    com.oplus.camera.j_renamed.a_renamed.this.v_renamed.setAlpha(1.0f);
                    com.oplus.camera.j_renamed.a_renamed.this.v_renamed = null;
                }
                if (com.oplus.camera.j_renamed.a_renamed.this.t_renamed != null) {
                    com.oplus.camera.j_renamed.a_renamed.this.t_renamed.pause();
                    com.oplus.camera.j_renamed.a_renamed.this.t_renamed.setOnPreparedListener(null);
                    com.oplus.camera.j_renamed.a_renamed.this.t_renamed.setOnCompletionListener(null);
                    com.oplus.camera.j_renamed.a_renamed.this.t_renamed.setOnErrorListener(null);
                }
                if (com.oplus.camera.j_renamed.a_renamed.this.f_renamed != null) {
                    com.oplus.camera.j_renamed.a_renamed.this.f_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, false).apply();
                }
                com.oplus.camera.j_renamed.a_renamed.this.z_renamed.postDelayed(runnable3, 200L);
            }
        });
        a_renamed(this.v_renamed, activity, uri, this.z_renamed, runnable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l_renamed() {
        this.g_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.guide_button_ok).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$ZxjjRibKgFaoVG__GBJcVj6MNHo
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.c_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.view.View view) {
        a_renamed(this.g_renamed);
    }

    private void m_renamed(android.app.Activity activity) {
        androidx.viewpager2.widget.ViewPager2 viewPager2;
        this.A_renamed = android.os.SystemClock.uptimeMillis();
        this.C_renamed = true;
        this.E_renamed = false;
        com.oplus.camera.ui.s_renamed sVar = this.k_renamed;
        if (sVar == null) {
            this.k_renamed = n_renamed(activity);
            this.k_renamed.a_renamed(new com.oplus.camera.ui.s_renamed.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$RZhUdy5W-PUipRCC-bAInUltETc
                @Override // com.oplus.camera.ui.s_renamed.a_renamed
                public final void onGuideDialogShowAction() {
                    this.f_renamed$0.k_renamed();
                }
            });
            this.k_renamed.a_renamed(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.j_renamed.a_renamed.8
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(android.content.DialogInterface dialogInterface) throws java.lang.IllegalStateException {
                    if (com.oplus.camera.j_renamed.a_renamed.this.f_renamed != null) {
                        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                        stringBuffer.append(com.oplus.camera.j_renamed.a_renamed.this.r_renamed.getCurrentItem());
                        stringBuffer.append(":");
                        stringBuffer.append(android.os.SystemClock.uptimeMillis() - com.oplus.camera.j_renamed.a_renamed.this.A_renamed);
                        stringBuffer.append(":");
                        stringBuffer.append(com.oplus.camera.j_renamed.a_renamed.this.C_renamed ? com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_GLIDE : com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CLICK);
                        com.oplus.camera.j_renamed.a_renamed.this.f_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION, stringBuffer.toString()).apply();
                    }
                    if (com.oplus.camera.j_renamed.a_renamed.this.f_renamed != null) {
                        com.oplus.camera.j_renamed.a_renamed.this.f_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, false).apply();
                    }
                    if (com.oplus.camera.j_renamed.a_renamed.this.u_renamed != null) {
                        com.oplus.camera.j_renamed.a_renamed.this.u_renamed.b_renamed();
                    }
                    com.oplus.camera.j_renamed.a_renamed.this.A_renamed = 0L;
                }
            });
            this.k_renamed.a_renamed(new android.content.DialogInterface.OnShowListener() { // from class: com.oplus.camera.j_renamed.a_renamed.9
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(android.content.DialogInterface dialogInterface) throws java.lang.IllegalStateException {
                    com.oplus.camera.doubleexposure.DoubleExposureVideoView doubleExposureVideoView = (com.oplus.camera.doubleexposure.DoubleExposureVideoView) com.oplus.camera.j_renamed.a_renamed.this.r_renamed.getChildAt(0).findViewById(com.oplus.camera.R_renamed.id_renamed.videoView);
                    if (doubleExposureVideoView != null) {
                        doubleExposureVideoView.a_renamed();
                    }
                }
            });
            return;
        }
        if (sVar.b_renamed() || (viewPager2 = this.r_renamed) == null) {
            return;
        }
        viewPager2.a_renamed(0, false);
        this.s_renamed.setCurrentPosition(0);
        if (this.k_renamed.isAdded()) {
            return;
        }
        this.k_renamed.show(((androidx.appcompat.app.c_renamed) activity).j_renamed(), "showDoubleExposureBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k_renamed() {
        this.k_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.guide_button_ok).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$Hs4ow8r9eePT0cm43rzkak4YVYQ
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.b_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.view.View view) {
        a_renamed(this.k_renamed);
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    private com.oplus.camera.ui.s_renamed n_renamed(final android.app.Activity activity) {
        d_renamed[0] = android.net.Uri.parse("android.resource://" + activity.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.double_exposure_guide1);
        d_renamed[1] = android.net.Uri.parse("android.resource://" + activity.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.double_exposure_guide2);
        d_renamed[2] = android.net.Uri.parse("android.resource://" + activity.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.double_exposure_guide3);
        final com.oplus.camera.j_renamed.b_renamed bVar = new com.oplus.camera.j_renamed.b_renamed(activity, f4725c, d_renamed);
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.common_bottom_guide_double_exposure_layout, (android.view.ViewGroup) null);
        this.r_renamed = (androidx.viewpager2.widget.ViewPager2) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_content_container);
        this.r_renamed.setAdapter(bVar);
        this.r_renamed.setOffscreenPageLimit(3);
        this.s_renamed = (com.coui.appcompat.widget.COUIPageIndicator) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_content_indicator);
        this.s_renamed.setDotsCount(bVar.getItemCount());
        this.r_renamed.a_renamed(new androidx.viewpager2.widget.ViewPager2.e_renamed() { // from class: com.oplus.camera.j_renamed.a_renamed.10
            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
                super.onPageScrolled(i_renamed, f_renamed, i2);
                com.oplus.camera.j_renamed.a_renamed.this.s_renamed.a_renamed(i_renamed, f_renamed, i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageSelected(int i_renamed) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
                super.onPageSelected(i_renamed);
                com.oplus.camera.j_renamed.a_renamed aVar = com.oplus.camera.j_renamed.a_renamed.this;
                aVar.u_renamed = aVar.a_renamed(aVar.r_renamed, i_renamed);
                if (com.oplus.camera.j_renamed.a_renamed.this.u_renamed != null) {
                    com.oplus.camera.j_renamed.a_renamed.this.u_renamed.c_renamed();
                    com.oplus.camera.j_renamed.a_renamed.this.u_renamed.a_renamed();
                }
                com.oplus.camera.j_renamed.a_renamed aVar2 = com.oplus.camera.j_renamed.a_renamed.this;
                com.oplus.camera.doubleexposure.DoubleExposureVideoView doubleExposureVideoViewA = aVar2.a_renamed(aVar2.r_renamed, bVar.a_renamed());
                if (doubleExposureVideoViewA != null) {
                    doubleExposureVideoViewA.b_renamed();
                }
                bVar.a_renamed(i_renamed);
                com.oplus.camera.j_renamed.a_renamed.this.s_renamed.a_renamed(i_renamed);
                if (com.oplus.camera.j_renamed.a_renamed.this.f_renamed != null) {
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    stringBuffer.append(i_renamed);
                    stringBuffer.append(":");
                    stringBuffer.append(android.os.SystemClock.uptimeMillis() - com.oplus.camera.j_renamed.a_renamed.this.A_renamed);
                    stringBuffer.append(":");
                    stringBuffer.append(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CHANGE);
                    com.oplus.camera.j_renamed.a_renamed.this.f_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION, stringBuffer.toString()).apply();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageScrollStateChanged(int i_renamed) {
                super.onPageScrollStateChanged(i_renamed);
                com.oplus.camera.j_renamed.a_renamed.this.s_renamed.b_renamed(i_renamed);
            }
        });
        this.s_renamed.setOnDotClickListener(new com.coui.appcompat.widget.COUIPageIndicator.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$TbfY8TVF90n85sFBRpBVSCX_KEU
            @Override // com.coui.appcompat.widget.COUIPageIndicator.a_renamed
            public final void onClick(int i_renamed) {
                this.f_renamed$0.a_renamed(i_renamed);
            }
        });
        bVar.a_renamed(new com.oplus.camera.doubleexposure.DoubleExposureVideoView.a_renamed() { // from class: com.oplus.camera.j_renamed.a_renamed.11
            @Override // com.oplus.camera.doubleexposure.DoubleExposureVideoView.a_renamed
            public void a_renamed(android.graphics.Bitmap bitmap) {
                if (com.oplus.camera.j_renamed.a_renamed.this.k_renamed.b_renamed()) {
                    return;
                }
                bVar.a_renamed(bitmap);
                androidx.fragment.app.h_renamed hVarJ = ((androidx.appcompat.app.c_renamed) activity).j_renamed();
                if (com.oplus.camera.j_renamed.a_renamed.this.k_renamed.isAdded() || hVarJ.g_renamed()) {
                    return;
                }
                com.oplus.camera.j_renamed.a_renamed.this.k_renamed.show(hVarJ, "showDoubleExposureBottomGuide");
            }

            @Override // com.oplus.camera.doubleexposure.DoubleExposureVideoView.a_renamed
            public void a_renamed() {
                com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.j_renamed.a_renamed.e_renamed, "VideoViewPagerAdapter onLoadVideoThumbFail ");
            }
        });
        return new com.oplus.camera.ui.s_renamed(viewInflate, this.y_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(int i_renamed) {
        this.r_renamed.setCurrentItem(i_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.oplus.camera.doubleexposure.DoubleExposureVideoView a_renamed(androidx.viewpager2.widget.ViewPager2 viewPager2, int i_renamed) {
        android.view.View childAt;
        android.view.ViewGroup viewGroup = viewPager2.getChildCount() > 0 ? (android.view.ViewGroup) viewPager2.getChildAt(0) : null;
        if (viewGroup == null || i_renamed > viewGroup.getChildCount() || (childAt = viewGroup.getChildAt(i_renamed)) == null) {
            return null;
        }
        return (com.oplus.camera.doubleexposure.DoubleExposureVideoView) childAt.findViewById(com.oplus.camera.R_renamed.id_renamed.videoView);
    }

    private void a_renamed(android.widget.ImageView imageView, android.app.Activity activity, android.net.Uri uri, android.os.Handler handler, java.lang.Runnable runnable) {
        this.w_renamed = new java.lang.Thread(new com.oplus.camera.j_renamed.a_renamed.b_renamed(activity, handler, uri, imageView, runnable));
        this.w_renamed.start();
    }

    private com.oplus.camera.ui.s_renamed a_renamed(android.app.Activity activity, int i_renamed, int i2, int i3) {
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.common_full_page_guide_layout, (android.view.ViewGroup) null);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_image_content);
        ((android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_guide_title)).setText(i2);
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_guide_description);
        if (-1 != i3) {
            textView.setVisibility(0);
            textView.setText(i3);
        } else {
            textView.setVisibility(8);
        }
        viewGroup.addView(android.view.LayoutInflater.from(activity).inflate(i_renamed, viewGroup, false));
        return new com.oplus.camera.ui.s_renamed(viewInflate, this.y_renamed);
    }

    private com.oplus.camera.ui.s_renamed a_renamed(android.app.Activity activity, int i_renamed, int[] iArr, int[] iArr2) {
        com.oplus.camera.j_renamed.a_renamed.c_renamed cVar = new com.oplus.camera.j_renamed.a_renamed.c_renamed(iArr, iArr2);
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(i_renamed, (android.view.ViewGroup) null);
        com.oplus.camera.ui.s_renamed sVar = new com.oplus.camera.ui.s_renamed(viewInflate, this.y_renamed);
        final androidx.viewpager2.widget.ViewPager2 viewPager2 = (androidx.viewpager2.widget.ViewPager2) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_content_container);
        viewPager2.setOverScrollMode(2);
        viewPager2.setAdapter(cVar);
        final com.coui.appcompat.widget.COUIPageIndicator cOUIPageIndicator = (com.coui.appcompat.widget.COUIPageIndicator) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_content_indicator);
        cOUIPageIndicator.setDotsCount(cVar.getItemCount());
        viewPager2.a_renamed(new androidx.viewpager2.widget.ViewPager2.e_renamed() { // from class: com.oplus.camera.j_renamed.a_renamed.13
            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageScrolled(int i2, float f_renamed, int i3) {
                super.onPageScrolled(i2, f_renamed, i3);
                cOUIPageIndicator.a_renamed(i2, f_renamed, i3);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageSelected(int i2) {
                super.onPageSelected(i2);
                cOUIPageIndicator.a_renamed(i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageScrollStateChanged(int i2) {
                super.onPageScrollStateChanged(i2);
                cOUIPageIndicator.b_renamed(i2);
            }
        });
        cOUIPageIndicator.setOnDotClickListener(new com.coui.appcompat.widget.COUIPageIndicator.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$FACW_vYi5yynUMHixE2LrkteMFU
            @Override // com.coui.appcompat.widget.COUIPageIndicator.a_renamed
            public final void onClick(int i2) {
                viewPager2.setCurrentItem(i2);
            }
        });
        return sVar;
    }

    private com.oplus.camera.ui.s_renamed a_renamed(android.app.Activity activity, int i_renamed, int i2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.common_bottom_guide_mode_arrange, (android.view.ViewGroup) null);
        ((android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_tips_tv)).setText(i_renamed);
        ((android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_guide_description)).setText(i2);
        final com.oplus.anim.EffectiveAnimationView effectiveAnimationView = (com.oplus.anim.EffectiveAnimationView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_guide_effective_view);
        effectiveAnimationView.setRenderMode(com.oplus.anim.n_renamed.HARDWARE);
        com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> fVarB = com.oplus.anim.g_renamed.b_renamed(activity, "mode_arrage_guide.json");
        if (com.oplus.camera.util.Util.u_renamed() && (cameraUIListener = this.y_renamed) != null) {
            int iCa = cameraUIListener.ca_renamed();
            if (iCa == 1) {
                fVarB = com.oplus.anim.g_renamed.b_renamed(activity, "mode_arrange_guide_full.json");
            } else if (iCa == 3) {
                fVarB = com.oplus.anim.g_renamed.b_renamed(activity, "mode_arrange_guide_split.json");
            } else if (iCa == 4) {
                fVarB = com.oplus.anim.g_renamed.b_renamed(activity, "mode_arrange_guide_rack.json");
            }
            a_renamed(iCa, viewInflate, activity);
        }
        fVarB.a_renamed(new com.oplus.anim.c_renamed<com.oplus.anim.a_renamed>() { // from class: com.oplus.camera.j_renamed.a_renamed.14
            @Override // com.oplus.anim.c_renamed
            public void a_renamed(com.oplus.anim.a_renamed aVar) {
                effectiveAnimationView.setComposition(aVar);
            }
        });
        return new com.oplus.camera.ui.s_renamed(viewInflate, this.y_renamed);
    }

    private void a_renamed(int i_renamed, android.view.View view, android.app.Activity activity) {
        if (i_renamed == 1) {
            if (this.y_renamed.bL_renamed().k_renamed() == 0) {
                return;
            }
            int i2 = com.oplus.camera.screen.f_renamed.f5372b;
            int i3 = com.oplus.camera.screen.f_renamed.f5371a;
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(i2, i3);
            int i4 = i3 - i2;
            int i5 = (-i4) / 2;
            layoutParams.topMargin = i5;
            layoutParams.bottomMargin = i5;
            int i6 = i4 / 2;
            layoutParams.leftMargin = i6;
            layoutParams.rightMargin = i6;
            if (90 == this.y_renamed.bL_renamed().k_renamed()) {
                view.setRotation(90.0f);
                view.setLayoutParams(layoutParams);
                return;
            } else {
                if (270 == this.y_renamed.bL_renamed().k_renamed()) {
                    view.setRotation(270.0f);
                    view.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
        }
        if (i_renamed != 4) {
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), -1);
        if (this.y_renamed.bL_renamed().k_renamed() == 90) {
            view.setRotation(90.0f);
            layoutParams2.gravity = 3;
        } else {
            view.setRotation(270.0f);
            layoutParams2.gravity = 5;
        }
        view.setLayoutParams(layoutParams2);
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_tips_container);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams3.addRule(12);
        layoutParams3.addRule(14);
        layoutParams3.bottomMargin = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_common_bottom_guide_tips_container_margin_bottom);
        linearLayout.setLayoutParams(layoutParams3);
        android.view.View viewFindViewById = view.findViewById(com.oplus.camera.R_renamed.id_renamed.bottom_guide_effective_view);
        android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams4.height = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_guide_webview_height);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_common_bottom_guide_arrange_image_margin_bottom);
        viewFindViewById.setLayoutParams(layoutParams4);
    }

    private com.oplus.camera.ui.s_renamed o_renamed(android.app.Activity activity) {
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.common_bottom_guide_makeup_layout, (android.view.ViewGroup) null);
        androidx.appcompat.widget.AppCompatImageView appCompatImageView = (androidx.appcompat.widget.AppCompatImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.makeup_compare);
        appCompatImageView.setOutlineProvider(new com.oplus.camera.j_renamed.a_renamed.CommonBottomGuide_5());
        if (com.oplus.camera.util.Util.s_renamed(activity)) {
            appCompatImageView.setImageResource(com.oplus.camera.R_renamed.drawable.guide_makeup_cn);
        } else {
            appCompatImageView.setImageResource(com.oplus.camera.R_renamed.drawable.guide_makeup_exp);
        }
        return new com.oplus.camera.ui.s_renamed(viewInflate, this.y_renamed);
    }

    public void a_renamed(android.app.Dialog dialog) {
        android.view.Window window = dialog.getWindow();
        window.setFlags(8, 8);
        if (30 < android.os.Build.VERSION.SDK_INT && com.oplus.camera.util.Util.ab_renamed()) {
            window.clearFlags(134217728);
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(5892);
            window.setNavigationBarContrastEnforced(false);
            window.setNavigationBarColor(0);
        } else {
            window.getDecorView().setSystemUiVisibility(1284);
            window.clearFlags(8);
        }
        dialog.show();
    }

    public void b_renamed() {
        a_renamed(this.g_renamed, 0);
        a_renamed(this.h_renamed, 0);
        a_renamed(this.m_renamed, 0);
        a_renamed(this.i_renamed, 0);
        a_renamed(this.j_renamed, 0);
        a_renamed(this.n_renamed, 0);
        a_renamed(this.o_renamed, 0);
        this.x_renamed = null;
        c_renamed();
    }

    public boolean c_renamed() {
        boolean z_renamed;
        com.oplus.camera.ui.s_renamed sVar = this.g_renamed;
        if (sVar == null || !sVar.b_renamed()) {
            z_renamed = false;
        } else {
            this.g_renamed.dismiss();
            z_renamed = true;
        }
        com.oplus.camera.ui.s_renamed sVar2 = this.h_renamed;
        if (sVar2 != null && sVar2.b_renamed()) {
            this.h_renamed.dismiss();
            z_renamed = true;
        }
        android.app.Dialog dialog = this.m_renamed;
        if (dialog != null && dialog.isShowing()) {
            this.m_renamed.dismiss();
            this.m_renamed = null;
            z_renamed = true;
        }
        com.oplus.camera.ui.s_renamed sVar3 = this.i_renamed;
        if (sVar3 != null && sVar3.b_renamed()) {
            this.i_renamed.dismiss();
            this.i_renamed = null;
            z_renamed = true;
        }
        com.oplus.camera.ui.s_renamed sVar4 = this.l_renamed;
        if (sVar4 != null && sVar4.b_renamed()) {
            this.l_renamed.dismiss();
            this.l_renamed = null;
            z_renamed = true;
        }
        com.oplus.camera.ui.s_renamed sVar5 = this.j_renamed;
        if (sVar5 != null && sVar5.b_renamed()) {
            this.j_renamed.dismiss();
            this.j_renamed = null;
            z_renamed = true;
        }
        android.app.Dialog dialog2 = this.n_renamed;
        if (dialog2 != null && dialog2.isShowing()) {
            this.n_renamed.dismiss();
            this.n_renamed = null;
            z_renamed = true;
        }
        android.app.Dialog dialog3 = this.o_renamed;
        if (dialog3 != null && dialog3.isShowing()) {
            this.o_renamed.dismiss();
            this.o_renamed = null;
            z_renamed = true;
        }
        com.oplus.camera.e_renamed.b_renamed(e_renamed, "hideAllPopupWindow, isHide: " + z_renamed);
        return z_renamed;
    }

    private void a_renamed(android.app.Dialog dialog, int i_renamed) {
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setAlpha(i_renamed);
    }

    private void a_renamed(androidx.fragment.app.b_renamed bVar, int i_renamed) {
        android.app.Dialog dialog;
        if (bVar == null || (dialog = bVar.getDialog()) == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setAlpha(i_renamed);
    }

    public boolean d_renamed() {
        com.oplus.camera.ui.s_renamed sVar = this.g_renamed;
        if (sVar != null) {
            return sVar.b_renamed();
        }
        return false;
    }

    public void c_renamed(android.app.Activity activity) {
        this.D_renamed = true;
        com.oplus.camera.ui.s_renamed sVar = this.g_renamed;
        if (sVar != null && sVar.b_renamed()) {
            this.g_renamed.dismiss();
            this.g_renamed = null;
            a_renamed(activity, 1);
        } else {
            this.g_renamed = null;
        }
        com.oplus.camera.ui.s_renamed sVar2 = this.h_renamed;
        if (sVar2 != null && sVar2.b_renamed()) {
            this.h_renamed.dismiss();
            this.h_renamed = null;
            a_renamed(activity, 2);
        }
        android.app.Dialog dialog = this.m_renamed;
        if (dialog != null && dialog.isShowing()) {
            this.m_renamed.dismiss();
            this.m_renamed = null;
            a_renamed(activity, 3);
        }
        com.oplus.camera.ui.s_renamed sVar3 = this.i_renamed;
        if (sVar3 != null && sVar3.b_renamed()) {
            this.i_renamed.dismiss();
            this.i_renamed = null;
            a_renamed(activity, 4);
        }
        com.oplus.camera.ui.s_renamed sVar4 = this.k_renamed;
        if (sVar4 != null && sVar4.b_renamed()) {
            this.k_renamed.dismiss();
            this.k_renamed = null;
            a_renamed(activity, 5);
        } else {
            this.k_renamed = null;
        }
        android.app.Dialog dialog2 = this.n_renamed;
        if (dialog2 != null && dialog2.isShowing()) {
            this.n_renamed.dismiss();
            this.n_renamed = null;
            a_renamed(activity, 8);
        }
        com.oplus.camera.ui.s_renamed sVar5 = this.j_renamed;
        if (sVar5 != null && sVar5.b_renamed()) {
            this.j_renamed.dismiss();
            this.j_renamed = null;
            a_renamed(activity, 7);
        }
        android.app.Dialog dialog3 = this.o_renamed;
        if (dialog3 == null || !dialog3.isShowing()) {
            return;
        }
        this.o_renamed.dismiss();
        this.o_renamed = null;
        a_renamed(activity, 9);
    }

    public void e_renamed() {
        com.oplus.camera.ui.s_renamed sVar;
        com.oplus.camera.ui.widget.TextureVideoView textureVideoView;
        com.oplus.camera.ui.s_renamed sVar2 = this.g_renamed;
        if (sVar2 != null && sVar2.b_renamed() && (textureVideoView = this.t_renamed) != null) {
            textureVideoView.start();
            this.t_renamed.requestFocus();
        }
        if (this.u_renamed == null || (sVar = this.k_renamed) == null || !sVar.b_renamed()) {
            return;
        }
        this.u_renamed.c_renamed();
        this.u_renamed.a_renamed();
    }

    public void f_renamed() {
        com.oplus.camera.ui.s_renamed sVar;
        com.oplus.camera.e_renamed.b_renamed(e_renamed, "onPause");
        com.oplus.camera.ui.widget.TextureVideoView textureVideoView = this.t_renamed;
        if (textureVideoView != null) {
            textureVideoView.pause();
        }
        if (this.u_renamed != null && (sVar = this.k_renamed) != null && sVar.b_renamed()) {
            this.u_renamed.b_renamed();
        }
        com.oplus.camera.ui.s_renamed sVar2 = this.l_renamed;
        if (sVar2 == null || !sVar2.b_renamed()) {
            return;
        }
        this.l_renamed.dismiss();
        this.l_renamed = null;
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.b_renamed(e_renamed, "onDestroy");
        android.os.Handler handler = this.z_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        java.lang.Thread thread = this.w_renamed;
        if (thread != null && thread.isAlive()) {
            this.w_renamed.interrupt();
            this.w_renamed = null;
        }
        this.x_renamed = null;
        this.t_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.m_renamed = null;
        this.i_renamed = null;
        this.l_renamed = null;
        this.f_renamed = null;
        this.k_renamed = null;
        this.u_renamed = null;
        this.p_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
    }

    private void p_renamed(final android.app.Activity activity) {
        if (this.l_renamed == null) {
            this.l_renamed = a_renamed(activity, com.oplus.camera.R_renamed.string.camera_mode_arrange_guide_title, com.oplus.camera.R_renamed.string.camera_mode_drag_description);
            this.l_renamed.a_renamed(new com.oplus.camera.ui.s_renamed.a_renamed() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$i6OrcszzdMsv4IRziDTLrV1rg-g_renamed
                @Override // com.oplus.camera.ui.s_renamed.a_renamed
                public final void onGuideDialogShowAction() {
                    this.f_renamed$0.j_renamed();
                }
            });
            this.l_renamed.a_renamed(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$FcTA2FNmiiB6Yf8tAVsnh5yy-Nc
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    com.oplus.camera.j_renamed.a_renamed.a_renamed(activity, dialogInterface);
                }
            });
        }
        if (this.l_renamed.isAdded()) {
            return;
        }
        this.l_renamed.show(((androidx.appcompat.app.c_renamed) activity).j_renamed(), "showModeArrangeGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j_renamed() {
        this.l_renamed.a_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.guide_button_ok).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.-$$Lambda$a_renamed$0GIqP9J_wosn9_UMppyDJMDLmbs
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.a_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view) {
        a_renamed(this.l_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, android.content.DialogInterface dialogInterface) {
        androidx.preference.j_renamed.a_renamed(activity).edit().putBoolean("mode_arrange_reddot_show", false).apply();
    }

    private void q_renamed(android.app.Activity activity) {
        this.o_renamed = r_renamed(activity);
        if (this.o_renamed.isShowing()) {
            return;
        }
        try {
            a_renamed(this.o_renamed);
        } catch (android.view.WindowManager.BadTokenException e2) {
            if (this.o_renamed.isShowing()) {
                this.o_renamed.dismiss();
                this.o_renamed = null;
            }
            com.oplus.camera.e_renamed.e_renamed(e_renamed, "show3DPhotoGuide, exception: " + e2.getMessage());
        }
    }

    private android.app.Dialog r_renamed(android.app.Activity activity) {
        if (this.o_renamed == null) {
            this.o_renamed = new android.app.Dialog(activity, com.oplus.camera.R_renamed.style.ProfessionalModeGuideTheme);
            this.o_renamed.setContentView(com.oplus.camera.R_renamed.layout.common_bottom_guide_3d_photo_layout);
            this.o_renamed.setCanceledOnTouchOutside(true);
            this.o_renamed.setCancelable(true);
            android.view.Window window = this.o_renamed.getWindow();
            if (window != null) {
                android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                attributes.windowAnimations = com.oplus.camera.R_renamed.style.ProfessionalModeGuideDialog;
                window.setAttributes(attributes);
            }
            this.o_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_cancel).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.j_renamed.a_renamed.15
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    if (com.oplus.camera.j_renamed.a_renamed.this.o_renamed == null || !com.oplus.camera.j_renamed.a_renamed.this.o_renamed.isShowing()) {
                        return;
                    }
                    com.oplus.camera.j_renamed.a_renamed.this.o_renamed.dismiss();
                    com.oplus.camera.j_renamed.a_renamed.this.o_renamed = null;
                }
            });
            this.o_renamed.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.oplus.camera.j_renamed.a_renamed.16
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(android.content.DialogInterface dialogInterface) {
                    com.oplus.camera.j_renamed.a_renamed.this.o_renamed = null;
                }
            });
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) this.o_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_content);
            recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activity, 1, false));
            recyclerView.setAdapter(new com.oplus.camera.photo3d.ui.b_renamed(activity));
            if (com.oplus.camera.util.Util.aa_renamed()) {
                ((androidx.appcompat.widget.LinearLayoutCompat.a_renamed) recyclerView.getLayoutParams()).bottomMargin = com.oplus.camera.util.Util.Z_renamed();
            }
        }
        return this.o_renamed;
    }

    /* compiled from: CommonBottomGuide.java */
    private static class b_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.content.Context f4758a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.os.Handler f4759b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.net.Uri f4760c;
        private android.widget.ImageView d_renamed;
        private java.lang.Runnable e_renamed;

        public b_renamed(android.content.Context context, android.os.Handler handler, android.net.Uri uri, android.widget.ImageView imageView, java.lang.Runnable runnable) {
            this.f4758a = context;
            this.f4759b = handler;
            this.f4760c = uri;
            this.d_renamed = imageView;
            this.e_renamed = runnable;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.SecurityException, java.io.IOException, java.lang.IllegalArgumentException {
            android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f4758a, this.f4760c);
            try {
                try {
                    final android.graphics.Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                    if (frameAtIndex != null && this.f4759b != null) {
                        this.f4759b.post(new java.lang.Runnable() { // from class: com.oplus.camera.j_renamed.a_renamed.b_renamed.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.oplus.camera.j_renamed.a_renamed.b_renamed.this.d_renamed != null) {
                                    com.oplus.camera.j_renamed.a_renamed.b_renamed.this.d_renamed.setVisibility(0);
                                    com.oplus.camera.j_renamed.a_renamed.b_renamed.this.d_renamed.setImageBitmap(frameAtIndex);
                                }
                            }
                        });
                        this.f4759b.post(this.e_renamed);
                    }
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.j_renamed.a_renamed.e_renamed, "LoadThumbTask error " + e_renamed.toString());
                }
            } finally {
                mediaMetadataRetriever.close();
            }
        }
    }

    /* compiled from: CommonBottomGuide.java */
    public static class c_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.j_renamed.a_renamed.c_renamed.CommonBottomGuide_4> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int[] f4763a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int[] f4764b;

        public c_renamed(int[] iArr, int[] iArr2) {
            this.f4763a = null;
            this.f4764b = null;
            this.f4763a = iArr;
            this.f4764b = iArr2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.j_renamed.a_renamed.c_renamed.CommonBottomGuide_4 onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
            return new com.oplus.camera.j_renamed.a_renamed.c_renamed.CommonBottomGuide_4(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.panel_guides_pager_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(com.oplus.camera.j_renamed.a_renamed.c_renamed.CommonBottomGuide_4 c0104a, int i_renamed) {
            android.content.res.Resources resources = c0104a.a_renamed().getContext().getResources();
            c0104a.a_renamed().setImageResource(this.f4764b[i_renamed]);
            c0104a.a_renamed().setContentDescription(resources.getString(this.f4763a[i_renamed]));
            c0104a.b_renamed().setText(this.f4763a[i_renamed]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public int getItemCount() {
            return this.f4763a.length;
        }

        /* compiled from: CommonBottomGuide.java */
        /* renamed from: com.oplus.camera.j_renamed.a_renamed$c_renamed$a_renamed, reason: collision with other inner class name */
        public final class CommonBottomGuide_4 extends androidx.recyclerview.widget.RecyclerView.w_renamed {

            /* renamed from: b_renamed, reason: collision with root package name */
            private final android.widget.ImageView f4766b;

            /* renamed from: c_renamed, reason: collision with root package name */
            private final androidx.appcompat.widget.AppCompatTextView f4767c;

            public final android.widget.ImageView a_renamed() {
                return this.f4766b;
            }

            public final androidx.appcompat.widget.AppCompatTextView b_renamed() {
                return this.f4767c;
            }

            public CommonBottomGuide_4(android.view.View view) {
                super(view);
                this.f4766b = (android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.pager_item_im);
                this.f4766b.setOutlineProvider(new com.oplus.camera.j_renamed.a_renamed.CommonBottomGuide_5());
                this.f4767c = (androidx.appcompat.widget.AppCompatTextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_tips_tv);
            }
        }
    }

    /* compiled from: CommonBottomGuide.java */
    /* renamed from: com.oplus.camera.j_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class CommonBottomGuide_5 extends android.view.ViewOutlineProvider {
        private CommonBottomGuide_5() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(android.view.View view, android.graphics.Outline outline) {
            android.graphics.Rect rect = new android.graphics.Rect();
            view.getDrawingRect(rect);
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i_renamed = marginLayoutParams.leftMargin;
            int i2 = marginLayoutParams.topMargin;
            rect.set(i_renamed, i2, (rect.right - rect.left) - i_renamed, (rect.bottom - rect.top) - i2);
            outline.setAlpha(0.93f);
            outline.setRoundRect(rect, view.getContext().getResources().getDimension(com.oplus.camera.R_renamed.dimen.common_bottom_guide_background_radius));
            view.setClipToOutline(true);
        }
    }
}
