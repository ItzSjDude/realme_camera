package com.oplus.camera.ui;

/* compiled from: GalleryBottomMenuLayout.java */
/* loaded from: classes2.dex */
public class j_renamed extends com.oplus.camera.ui.inverse.InverseLinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6258a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6259b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f6260c;
    private android.widget.ImageButton d_renamed;
    private android.widget.ImageButton e_renamed;
    private android.widget.ImageButton f_renamed;
    private android.view.animation.PathInterpolator g_renamed;
    private android.animation.AnimatorSet h_renamed;
    private android.animation.AnimatorSet i_renamed;
    private com.oplus.camera.ui.CameraUIListener j_renamed;
    private com.coui.appcompat.dialog.app.b_renamed k_renamed;
    private com.oplus.camera.ComboPreferences l_renamed;
    private com.oplus.camera.Camera m_renamed;
    private com.oplus.camera.ui.k_renamed n_renamed;
    private java.lang.String o_renamed;

    public j_renamed(android.content.Context context) {
        super(context);
        this.f6258a = 0;
        this.f6259b = 0;
        this.f6260c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = "";
        this.f6260c = context;
    }

    public void a_renamed(com.oplus.camera.ui.CameraUIListener cameraUIListener, com.oplus.camera.ComboPreferences comboPreferences, android.app.Activity activity, com.oplus.camera.ui.k_renamed kVar) {
        com.oplus.camera.e_renamed.a_renamed("GalleryBottomMenuLayout", "initGalleryBottomMenu");
        this.j_renamed = cameraUIListener;
        this.l_renamed = comboPreferences;
        this.m_renamed = (com.oplus.camera.Camera) activity;
        this.o_renamed = this.m_renamed.getPackageName();
        this.n_renamed = kVar;
        this.f6258a = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_bottom_share_menu_width);
        this.f6259b = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_bottom_menu_bar_height);
        this.f_renamed = new android.widget.ImageButton(this.f6260c);
        this.f_renamed.setImageDrawable(getResources().getDrawable(com.oplus.camera.R_renamed.drawable.ic_share_gallery_bottom_menu_fold, null));
        this.f_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.gallery_bottom_toolbar_menu_bg);
        this.f_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$j_renamed$qzgT2McSJNVfFmhctzgAHR1jR9A
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.c_renamed(view);
            }
        });
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(this.f6258a, this.f6259b);
        layoutParams.gravity = 17;
        layoutParams.topMargin = 0;
        layoutParams.setMarginStart(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_bottom_share_menu_left_margin));
        addView(this.f_renamed, layoutParams);
        this.e_renamed = new android.widget.ImageButton(this.f6260c);
        this.e_renamed.setImageDrawable(getResources().getDrawable(com.oplus.camera.R_renamed.drawable.ic_edit_gallery_bottom_menu_fold, null));
        this.e_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.gallery_bottom_toolbar_menu_bg);
        this.e_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$j_renamed$D96y8EcUnV4L2vkBoBYWYhBsp2o
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.b_renamed(view);
            }
        });
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(this.f6258a, this.f6259b);
        layoutParams2.gravity = 17;
        layoutParams2.setMarginStart(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_bottom_edit_menu_left_margin));
        addView(this.e_renamed, layoutParams2);
        this.d_renamed = new android.widget.ImageButton(this.f6260c);
        this.d_renamed.setImageDrawable(getResources().getDrawable(com.oplus.camera.R_renamed.drawable.ic_delete_gallery_bottom_menu_fold, null));
        this.d_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.gallery_bottom_toolbar_menu_bg);
        this.d_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$j_renamed$UU0oNqlyvYX0dAlvUck3N9_Fzc0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.a_renamed(view);
            }
        });
        android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(this.f6258a, this.f6259b);
        layoutParams3.gravity = 17;
        layoutParams3.setMarginStart(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_bottom_delete_menu_left_margin));
        addView(this.d_renamed, layoutParams3);
        a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.view.View view) {
        e_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.view.View view) {
        f_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view) {
        com.oplus.camera.Camera camera = this.m_renamed;
        if (camera != null) {
            a_renamed((android.app.Activity) camera);
        }
    }

    private void d_renamed() {
        android.animation.AnimatorSet animatorSet = this.i_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.i_renamed.cancel();
        }
        android.widget.ImageButton imageButton = this.e_renamed;
        if (imageButton == null || imageButton.isShown()) {
            return;
        }
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.e_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.g_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        this.h_renamed = new android.animation.AnimatorSet();
        this.h_renamed.play(objectAnimatorOfFloat);
        this.h_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.j_renamed.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                if (com.oplus.camera.ui.j_renamed.this.e_renamed != null) {
                    com.oplus.camera.ui.j_renamed.this.e_renamed.setVisibility(0);
                    com.oplus.camera.ui.j_renamed.this.b_renamed(false);
                }
            }
        });
        this.h_renamed.start();
    }

    private void a_renamed(boolean z_renamed) {
        android.animation.AnimatorSet animatorSet = this.h_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.h_renamed.cancel();
        }
        android.widget.ImageButton imageButton = this.e_renamed;
        if (imageButton == null || !imageButton.isShown()) {
            return;
        }
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.e_renamed, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.g_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            this.i_renamed = new android.animation.AnimatorSet();
            this.i_renamed.play(objectAnimatorOfFloat);
            this.i_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.j_renamed.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.j_renamed.this.e_renamed != null) {
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setAlpha(1.0f);
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.j_renamed.this.e_renamed != null) {
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setVisibility(8);
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.j_renamed.this.e_renamed.setAlpha(0.0f);
                        com.oplus.camera.ui.j_renamed.this.b_renamed(true);
                    }
                }
            });
            this.i_renamed.start();
            return;
        }
        this.e_renamed.setAlpha(0.0f);
        this.e_renamed.setVisibility(8);
        b_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed) {
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(this.f6258a, this.f6259b);
        layoutParams.gravity = 17;
        if (z_renamed) {
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_bottom_delete_menu_left_margin_hide_edit));
        } else {
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_bottom_delete_menu_left_margin));
        }
        this.d_renamed.setLayoutParams(layoutParams);
    }

    private void e_renamed() {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.j_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.j_renamed.this.g_renamed();
            }
        }, "share");
        com.oplus.camera.ComboPreferences comboPreferences = this.l_renamed;
        if (comboPreferences != null) {
            comboPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
        }
        b_renamed(46);
    }

    private void f_renamed() {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.j_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.j_renamed.this.j_renamed();
            }
        }, "mark");
        com.oplus.camera.ComboPreferences comboPreferences = this.l_renamed;
        if (comboPreferences != null) {
            comboPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
        }
        b_renamed(47);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g_renamed() {
        com.oplus.camera.ui.k_renamed kVar = this.n_renamed;
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVarE = kVar != null ? kVar.e_renamed() : null;
        if (aVarE == null || this.m_renamed == null) {
            return;
        }
        android.net.Uri uriG = aVarE.g_renamed();
        if (a_renamed(uriG, com.oplus.camera.util.Util.a_renamed(uriG))) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.SEND");
            java.lang.String strD = aVarE.d_renamed();
            if (strD == null) {
                strD = a_renamed(aVarE.f_renamed());
            }
            if (strD == null) {
                strD = com.oplus.camera.util.Util.a_renamed(uriG) ? "image/*" : "video/*";
            }
            intent.setType(strD);
            intent.putExtra("android.intent.extra.STREAM", uriG);
            if (b_renamed()) {
                intent.setFlags(268468224);
            }
            h_renamed();
            try {
                this.m_renamed.startActivity(android.content.Intent.createChooser(intent, null));
                this.m_renamed.overridePendingTransition(0, 0);
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.f_renamed("GalleryBottomMenuLayout", "jumpSystemShare: " + th);
            }
        }
    }

    private void h_renamed() {
        if (b_renamed()) {
            try {
                new android.view.OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (android.os.RemoteException e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("GalleryBottomMenuLayout", "OplusWindowManager exception:" + e_renamed.toString());
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.d_renamed("GalleryBottomMenuLayout", "OplusWindowManager error:", e2);
            }
        }
    }

    private boolean a_renamed(android.net.Uri uri, boolean z_renamed) throws java.lang.Throwable {
        com.oplus.camera.Camera camera;
        if (uri != null && (camera = this.m_renamed) != null) {
            boolean zA = com.oplus.camera.util.Util.a_renamed(uri, camera.getContentResolver());
            if (!i_renamed() && zA) {
                return !z_renamed || a_renamed(uri);
            }
            com.oplus.camera.e_renamed.e_renamed("GalleryBottomMenuLayout", "onThumbNailClick, imageCaptureListIsEmpty: " + com.oplus.camera.m_renamed.b_renamed.a_renamed().j_renamed() + ", imageSaveListIsEmpty: " + com.oplus.camera.m_renamed.b_renamed.a_renamed().g_renamed() + ", isUriValid: " + zA);
        }
        return false;
    }

    private java.lang.String a_renamed(java.lang.String str) {
        java.lang.String[] strArrSplit;
        if (android.text.TextUtils.isEmpty(str) || (strArrSplit = str.split("\\.")) == null || 1 > strArrSplit.length) {
            return null;
        }
        java.lang.String str2 = strArrSplit[strArrSplit.length - 1];
        if (com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equalsIgnoreCase(str2) || "jpg".equalsIgnoreCase(str2)) {
            return "image/jpeg";
        }
        if ("raw".equalsIgnoreCase(str2) || "dng".equalsIgnoreCase(str2)) {
            return "image/x_renamed-adobe-dng";
        }
        if ("heic_8bits".equalsIgnoreCase(str2) || "heic_10bits".equalsIgnoreCase(str2) || "heic".equalsIgnoreCase(str2)) {
            return "image/heic";
        }
        if ("mp4".equalsIgnoreCase(str2)) {
            return com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4;
        }
        if ("3gp".equalsIgnoreCase(str2)) {
            return "video/3gp";
        }
        return null;
    }

    private boolean i_renamed() {
        return (com.oplus.camera.m_renamed.b_renamed.a_renamed().j_renamed() && com.oplus.camera.m_renamed.b_renamed.a_renamed().g_renamed()) ? false : true;
    }

    private boolean a_renamed(android.net.Uri uri) {
        try {
            return (this.m_renamed != null ? this.m_renamed.getContentResolver().loadThumbnail(uri, new android.util.Size(1, 1), null) : null) != null;
        } catch (java.lang.Exception unused) {
            com.oplus.camera.e_renamed.f_renamed("GalleryBottomMenuLayout", "checkFileOk: " + uri.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        com.oplus.camera.ui.k_renamed kVar = this.n_renamed;
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVarE = kVar != null ? kVar.e_renamed() : null;
        if (aVarE == null || this.m_renamed == null) {
            return;
        }
        android.net.Uri uriG = aVarE.g_renamed();
        if (a_renamed(uriG, com.oplus.camera.util.Util.a_renamed(uriG))) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.EDIT");
            intent.setData(uriG);
            intent.putExtra("edit_skill", "doodle");
            intent.putExtra("finish_operate", "save,share");
            intent.putExtra("from", this.o_renamed);
            intent.putExtra("isInternalSdcard", true);
            intent.putExtra("editor_state_item", "graffiti");
            intent.setPackage(com.oplus.camera.util.Util.aP_renamed());
            intent.setFlags(1);
            if (b_renamed()) {
                intent.addFlags(268468224);
            }
            h_renamed();
            try {
                this.m_renamed.startActivity(intent);
                this.m_renamed.overridePendingTransition(com.oplus.camera.R_renamed.anim.gallery_push_up_enter, com.oplus.camera.R_renamed.anim.camera_fade_out_for_edit);
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.f_renamed("GalleryBottomMenuLayout", "split screen mode jumpMark: " + th);
            }
        }
    }

    private void a_renamed(android.app.Activity activity) {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.k_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.k_renamed.dismiss();
        }
        this.k_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(activity).f_renamed(1).setNeutralButton(com.oplus.camera.R_renamed.string.camera_shooting_reference_delete, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.j_renamed.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.j_renamed.this.a_renamed(83, "delete");
                if (com.oplus.camera.ui.j_renamed.this.n_renamed != null) {
                    com.oplus.camera.ui.j_renamed.this.n_renamed.g_renamed();
                }
                dialogInterface.dismiss();
            }
        }).setNegativeButton(android.R_renamed.string.cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.j_renamed.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.ui.j_renamed.this.a_renamed(83, "cancel");
                dialogInterface.dismiss();
            }
        }).create();
        if (activity.isFinishing()) {
            return;
        }
        this.k_renamed.show();
    }

    public void a_renamed() {
        com.oplus.camera.ui.k_renamed kVar = this.n_renamed;
        if (kVar == null) {
            return;
        }
        a_renamed(kVar.h_renamed(), false);
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.k_renamed kVar = this.n_renamed;
        if (kVar == null) {
            return;
        }
        a_renamed(kVar.c_renamed(i_renamed), true);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        if (!z_renamed) {
            d_renamed();
        } else {
            a_renamed(z2);
        }
    }

    public boolean b_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.j_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.bc_renamed().w_renamed();
        }
        return false;
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.j_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.i_renamed(i_renamed);
        }
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.j_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.a_renamed(i_renamed, str);
        }
    }

    public void c_renamed() {
        this.m_renamed = null;
        this.l_renamed = null;
        this.n_renamed = null;
        this.j_renamed = null;
    }
}
