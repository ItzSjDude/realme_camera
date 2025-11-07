package com.oplus.camera;

/* compiled from: CameraStatementAlert.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.appcompat.app.c_renamed f4702a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.i_renamed.a_renamed f4704c;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f4703b = null;
    private com.coui.appcompat.widget.COUIFullPageStatement d_renamed = null;
    private com.oplus.camera.ui.v_renamed e_renamed = null;
    private com.oplus.camera.ui.v_renamed f_renamed = null;
    private boolean g_renamed = false;
    private boolean h_renamed = true;

    /* compiled from: CameraStatementAlert.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(boolean z_renamed);

        void b_renamed(boolean z_renamed);
    }

    public i_renamed(android.app.Activity activity, com.oplus.camera.i_renamed.a_renamed aVar) {
        this.f4702a = null;
        this.f4704c = null;
        this.f4702a = (androidx.appcompat.app.c_renamed) activity;
        this.f4704c = aVar;
    }

    public boolean a_renamed(android.content.SharedPreferences sharedPreferences) {
        com.oplus.camera.e_renamed.a_renamed("CameraStatementAlert", "showDialog, preferences: " + sharedPreferences);
        this.f4703b = sharedPreferences;
        android.content.SharedPreferences sharedPreferences2 = this.f4703b;
        if (sharedPreferences2 == null) {
            return false;
        }
        if (sharedPreferences2.getBoolean("pref_camera_statement_key", false)) {
            com.oplus.camera.e_renamed.a_renamed("CameraStatementAlert", "showDialog, has show dialog");
            return false;
        }
        if (this.e_renamed == null) {
            c_renamed();
            this.e_renamed.show(this.f4702a.j_renamed(), "StatementDialogFragment");
            this.g_renamed = true;
        }
        return true;
    }

    private void c_renamed() {
        this.e_renamed = new com.oplus.camera.ui.v_renamed();
        this.e_renamed.a_renamed(new com.oplus.camera.ui.v_renamed.a_renamed() { // from class: com.oplus.camera.i_renamed.1
            @Override // com.oplus.camera.ui.v_renamed.a_renamed
            public void a_renamed() {
                if (com.oplus.camera.i_renamed.this.f4704c != null) {
                    com.oplus.camera.i_renamed.this.f4704c.a_renamed(true);
                }
                com.oplus.camera.i_renamed iVar = com.oplus.camera.i_renamed.this;
                iVar.d_renamed = iVar.e_renamed.b_renamed();
                com.oplus.camera.i_renamed.this.d_renamed.setStatementMaxHeight(com.oplus.camera.i_renamed.this.f4702a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.camera_user_notice_max_height));
                com.oplus.camera.i_renamed.this.d_renamed.setButtonListener(new com.coui.appcompat.widget.COUIFullPageStatement.a_renamed() { // from class: com.oplus.camera.i_renamed.1.1
                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.a_renamed
                    public void a_renamed() {
                        com.oplus.camera.i_renamed.this.e_renamed.dismiss();
                        com.oplus.camera.i_renamed.this.g_renamed = false;
                        if (com.oplus.camera.i_renamed.this.f4704c != null) {
                            com.oplus.camera.i_renamed.this.f4704c.b_renamed(true);
                        }
                    }

                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.a_renamed
                    public void b_renamed() {
                        if (!com.oplus.camera.util.Util.ak_renamed()) {
                            if (com.oplus.camera.i_renamed.this.f4704c != null) {
                                com.oplus.camera.i_renamed.this.f4704c.a_renamed(true);
                            }
                            com.oplus.camera.i_renamed.this.f_renamed();
                            return;
                        }
                        com.oplus.camera.i_renamed.this.f4702a.finish();
                    }
                });
                int i_renamed = com.oplus.camera.R_renamed.string.camera_sticker_geographic_fitter_content;
                if (com.oplus.camera.i_renamed.this.d_renamed() && !com.oplus.camera.i_renamed.this.e_renamed()) {
                    i_renamed = com.oplus.camera.R_renamed.string.camera_sticker_no_geographic_fitter_content;
                } else if (!com.oplus.camera.i_renamed.this.d_renamed() && com.oplus.camera.i_renamed.this.e_renamed()) {
                    i_renamed = com.oplus.camera.R_renamed.string.camera_geographic_filter_no_sticker_content;
                } else if (!com.oplus.camera.i_renamed.this.d_renamed() && !com.oplus.camera.i_renamed.this.e_renamed()) {
                    i_renamed = com.oplus.camera.util.Util.al_renamed() ? com.oplus.camera.R_renamed.string.camera_statement_description_no_sticker_location_v4 : com.oplus.camera.R_renamed.string.camera_no_sticker_geographic_filter_content;
                }
                if (com.oplus.camera.util.Util.ak_renamed()) {
                    i_renamed = com.oplus.camera.R_renamed.string.camera_statement_description_for_export;
                    com.oplus.camera.i_renamed.this.d_renamed.setButtonText(com.oplus.camera.i_renamed.this.f4702a.getResources().getString(com.oplus.camera.R_renamed.string.camera_dialog_app_info_positive));
                    com.oplus.camera.i_renamed.this.d_renamed.setExitButtonText(com.oplus.camera.i_renamed.this.f4702a.getString(com.oplus.camera.R_renamed.string.camera_exit_button_str));
                }
                com.oplus.camera.i_renamed iVar2 = com.oplus.camera.i_renamed.this;
                iVar2.a_renamed(i_renamed, com.oplus.camera.R_renamed.string.privacy_policy_link, iVar2.d_renamed);
            }

            @Override // com.oplus.camera.ui.v_renamed.a_renamed
            public void b_renamed() {
                if (com.oplus.camera.i_renamed.this.f4704c != null) {
                    com.oplus.camera.i_renamed.this.f4704c.a_renamed();
                }
            }

            @Override // com.oplus.camera.ui.v_renamed.a_renamed
            public void c_renamed() {
                com.oplus.camera.i_renamed.this.h_renamed = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, int i2, com.coui.appcompat.widget.COUIFullPageStatement cOUIFullPageStatement) {
        if (cOUIFullPageStatement == null) {
            return;
        }
        java.lang.String string = this.f4702a.getString(i2);
        final int iIndexOf = this.f4702a.getString(i_renamed, new java.lang.Object[]{string}).indexOf(string);
        final int length = string.length();
        java.lang.CharSequence charSequenceA = a_renamed(i_renamed, i2);
        android.widget.TextView textView = (android.widget.TextView) cOUIFullPageStatement.findViewById(com.oplus.camera.R_renamed.id_renamed.txt_exit);
        androidx.appcompat.app.c_renamed cVar = this.f4702a;
        textView.setTextColor(com.coui.appcompat.a_renamed.d_renamed.a_renamed(cVar, com.oplus.camera.R_renamed.attr.couiTintControlNormal, cVar.getColor(com.oplus.camera.R_renamed.color.color_primary_light_yellow)));
        final android.widget.TextView appStatement = cOUIFullPageStatement.getAppStatement();
        appStatement.setText(charSequenceA);
        appStatement.setTextSize(0, this.f4702a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_user_notice_content_text_size));
        appStatement.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        appStatement.setHighlightColor(this.f4702a.getResources().getColor(android.R_renamed.color.transparent));
        appStatement.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.i_renamed.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                int offsetForPosition = appStatement.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                int i3 = iIndexOf;
                boolean z_renamed = offsetForPosition <= i3 || offsetForPosition >= i3 + length;
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        appStatement.setPressed(false);
                        appStatement.postInvalidateDelayed(70L);
                    }
                } else {
                    if (z_renamed) {
                        return true;
                    }
                    appStatement.setPressed(true);
                    appStatement.invalidate();
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed() {
        this.f_renamed = new com.oplus.camera.ui.v_renamed(this.f4702a.getString(com.oplus.camera.R_renamed.string.camera_user_disagrre_title));
        this.f_renamed.a_renamed(this.f4702a.getString(com.oplus.camera.R_renamed.string.camera_exit_button_str));
        this.f_renamed.b_renamed(this.f4702a.getResources().getString(com.oplus.camera.R_renamed.string.camera_disagree_enter_btn));
        this.f_renamed.a_renamed(new com.oplus.camera.ui.v_renamed.a_renamed() { // from class: com.oplus.camera.i_renamed.3
            @Override // com.oplus.camera.ui.v_renamed.a_renamed
            public void a_renamed() {
                int i_renamed;
                com.coui.appcompat.widget.COUIFullPageStatement cOUIFullPageStatementB = com.oplus.camera.i_renamed.this.f_renamed.b_renamed();
                cOUIFullPageStatementB.setStatementMaxHeight(com.oplus.camera.i_renamed.this.f4702a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.camera_user_notice_max_height));
                cOUIFullPageStatementB.setButtonListener(new com.coui.appcompat.widget.COUIFullPageStatement.a_renamed() { // from class: com.oplus.camera.i_renamed.3.1
                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.a_renamed
                    public void a_renamed() {
                        com.oplus.camera.i_renamed.this.f_renamed.dismiss();
                        com.oplus.camera.i_renamed.this.g_renamed = false;
                        if (com.oplus.camera.i_renamed.this.f4704c != null) {
                            com.oplus.camera.i_renamed.this.f4704c.b_renamed(false);
                        }
                    }

                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.a_renamed
                    public void b_renamed() {
                        com.oplus.camera.i_renamed.this.f4702a.finish();
                    }
                });
                if (com.oplus.camera.i_renamed.this.d_renamed() && !com.oplus.camera.i_renamed.this.e_renamed()) {
                    i_renamed = com.oplus.camera.R_renamed.string.camera_disagree_sticker_no_geographic_filtter;
                } else if (!com.oplus.camera.i_renamed.this.d_renamed() && com.oplus.camera.i_renamed.this.e_renamed()) {
                    i_renamed = com.oplus.camera.R_renamed.string.camera_disagree_geograhic_fillter_no_sticker;
                } else if (com.oplus.camera.i_renamed.this.d_renamed() || com.oplus.camera.i_renamed.this.e_renamed()) {
                    i_renamed = com.oplus.camera.R_renamed.string.camera_disagree_sticker_geograhic_filter_sticker;
                } else {
                    i_renamed = com.oplus.camera.util.Util.al_renamed() ? com.oplus.camera.R_renamed.string.camera_disagree_no_sticker_geographic_location_filter : com.oplus.camera.R_renamed.string.camera_disagree_no_sticker_geographic_filter;
                }
                com.oplus.camera.i_renamed.this.a_renamed(i_renamed, com.oplus.camera.R_renamed.string.privacy_policy_link, cOUIFullPageStatementB);
            }

            @Override // com.oplus.camera.ui.v_renamed.a_renamed
            public void b_renamed() {
                com.oplus.camera.i_renamed.this.e_renamed.dismiss();
            }

            @Override // com.oplus.camera.ui.v_renamed.a_renamed
            public void c_renamed() {
                com.oplus.camera.i_renamed.this.h_renamed = true;
            }
        });
        this.f_renamed.show(this.f4702a.j_renamed(), "StatementDialogFragment");
    }

    private java.lang.CharSequence a_renamed(int i_renamed, int i2) {
        java.lang.String string = this.f4702a.getString(i2);
        java.lang.String string2 = this.f4702a.getString(i_renamed, new java.lang.Object[]{string});
        int iIndexOf = string2.indexOf(string);
        int length = string.length();
        com.coui.appcompat.widget.c_renamed cVar = new com.coui.appcompat.widget.c_renamed(this.f4702a);
        cVar.a_renamed(new com.coui.appcompat.widget.c_renamed.a_renamed() { // from class: com.oplus.camera.i_renamed.4
            @Override // com.coui.appcompat.widget.c_renamed.a_renamed
            public void a_renamed() {
                try {
                    if (com.oplus.camera.i_renamed.this.h_renamed) {
                        com.oplus.camera.i_renamed.this.h_renamed = false;
                        android.content.Intent intent = new android.content.Intent("com.oplus.bootreg.activity.statementpage");
                        intent.putExtra("statement_intent_flag", 2);
                        com.oplus.camera.i_renamed.this.f4702a.startActivity(intent);
                    }
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    com.oplus.camera.i_renamed.this.h_renamed = true;
                }
            }
        });
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(string2);
        spannableStringBuilder.setSpan(cVar, iIndexOf, length + iIndexOf, 33);
        return spannableStringBuilder;
    }

    public boolean a_renamed() {
        return this.g_renamed;
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraStatementAlert", "release");
        if (a_renamed()) {
            com.oplus.camera.ui.v_renamed vVar = this.e_renamed;
            if (vVar != null && !vVar.isStateSaved() && this.e_renamed.a_renamed()) {
                this.e_renamed.dismiss();
            } else {
                com.oplus.camera.ui.v_renamed vVar2 = this.f_renamed;
                if (vVar2 != null && !vVar2.isStateSaved() && this.f_renamed.a_renamed()) {
                    this.f_renamed.dismiss();
                }
            }
        }
        this.g_renamed = false;
        this.f4704c = null;
    }
}
