package com.oplus.camera;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.widget.COUIClickableSpan;
import com.coui.appcompat.widget.COUIFullPageStatement;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.StatementDialogFragment;
import com.oplus.camera.util.Util;

/* compiled from: CameraStatementAlert.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class CameraStatementAlert {

    /* renamed from: PlatformImplementations.kt_3 */
    private AppCompatActivity f14351a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f14353c;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SharedPreferences f14352b = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private COUIFullPageStatement f14354d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private StatementDialogFragment f14355e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private StatementDialogFragment f14356f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f14357g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f14358h = true;

    /* compiled from: CameraStatementAlert.java */
    /* renamed from: com.oplus.camera.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14331a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14332a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo14333b(boolean z);
    }

    public CameraStatementAlert(Activity activity, PlatformImplementations.kt_3 aVar) {
        this.f14351a = null;
        this.f14353c = null;
        this.f14351a = (AppCompatActivity) activity;
        this.f14353c = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14360a(SharedPreferences sharedPreferences) {
        CameraLog.m12954a("CameraStatementAlert", "showDialog, preferences: " + sharedPreferences);
        this.f14352b = sharedPreferences;
        SharedPreferences sharedPreferences2 = this.f14352b;
        if (sharedPreferences2 == null) {
            return false;
        }
        if (sharedPreferences2.getBoolean("pref_camera_statement_key", false)) {
            CameraLog.m12954a("CameraStatementAlert", "showDialog, has show dialog");
            return false;
        }
        if (this.f14355e == null) {
            m14349c();
            this.f14355e.show(this.f14351a.m3341j(), "StatementDialogFragment");
            this.f14357g = true;
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14349c() {
        this.f14355e = new StatementDialogFragment();
        this.f14355e.m23915a(new StatementDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_13.1
            @Override // com.oplus.camera.p172ui.StatementDialogFragment.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo14362a() {
                if (CameraStatementAlert.this.f14353c != null) {
                    CameraStatementAlert.this.f14353c.mo14332a(true);
                }
                CameraStatementAlert c2778i = CameraStatementAlert.this;
                c2778i.f14354d = c2778i.f14355e.m23918b();
                CameraStatementAlert.this.f14354d.setStatementMaxHeight(CameraStatementAlert.this.f14351a.getResources().getDimensionPixelOffset(R.dimen.camera_user_notice_max_height));
                CameraStatementAlert.this.f14354d.setButtonListener(new COUIFullPageStatement.InterfaceC1386a() { // from class: com.oplus.camera.OplusGLSurfaceView_13.1.1
                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.InterfaceC1386a
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo7137a() {
                        CameraStatementAlert.this.f14355e.dismiss();
                        CameraStatementAlert.this.f14357g = false;
                        if (CameraStatementAlert.this.f14353c != null) {
                            CameraStatementAlert.this.f14353c.mo14333b(true);
                        }
                    }

                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.InterfaceC1386a
                    /* renamed from: IntrinsicsJvm.kt_4 */
                    public void mo7138b() {
                        if (!Util.m24348ak()) {
                            if (CameraStatementAlert.this.f14353c != null) {
                                CameraStatementAlert.this.f14353c.mo14332a(true);
                            }
                            CameraStatementAlert.this.m14354f();
                            return;
                        }
                        CameraStatementAlert.this.f14351a.finish();
                    }
                });
                int OplusGLSurfaceView_13 = R.string.camera_sticker_geographic_fitter_content;
                if (CameraStatementAlert.this.m14351d() && !CameraStatementAlert.this.m14353e()) {
                    OplusGLSurfaceView_13 = R.string.camera_sticker_no_geographic_fitter_content;
                } else if (!CameraStatementAlert.this.m14351d() && CameraStatementAlert.this.m14353e()) {
                    OplusGLSurfaceView_13 = R.string.camera_geographic_filter_no_sticker_content;
                } else if (!CameraStatementAlert.this.m14351d() && !CameraStatementAlert.this.m14353e()) {
                    OplusGLSurfaceView_13 = Util.m24349al() ? R.string.camera_statement_description_no_sticker_location_v4 : R.string.camera_no_sticker_geographic_filter_content;
                }
                if (Util.m24348ak()) {
                    OplusGLSurfaceView_13 = R.string.camera_statement_description_for_export;
                    CameraStatementAlert.this.f14354d.setButtonText(CameraStatementAlert.this.f14351a.getResources().getString(R.string.camera_dialog_app_info_positive));
                    CameraStatementAlert.this.f14354d.setExitButtonText(CameraStatementAlert.this.f14351a.getString(R.string.camera_exit_button_str));
                }
                CameraStatementAlert c2778i2 = CameraStatementAlert.this;
                c2778i2.m14343a(OplusGLSurfaceView_13, R.string.privacy_policy_link, c2778i2.f14354d);
            }

            @Override // com.oplus.camera.p172ui.StatementDialogFragment.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo14363b() {
                if (CameraStatementAlert.this.f14353c != null) {
                    CameraStatementAlert.this.f14353c.mo14331a();
                }
            }

            @Override // com.oplus.camera.p172ui.StatementDialogFragment.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo14364c() {
                CameraStatementAlert.this.f14358h = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m14351d() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m14353e() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14343a(int OplusGLSurfaceView_13, int i2, COUIFullPageStatement cOUIFullPageStatement) {
        if (cOUIFullPageStatement == null) {
            return;
        }
        String string = this.f14351a.getString(i2);
        final int iIndexOf = this.f14351a.getString(OplusGLSurfaceView_13, new Object[]{string}).indexOf(string);
        final int length = string.length();
        CharSequence charSequenceM14342a = m14342a(OplusGLSurfaceView_13, i2);
        TextView textView = (TextView) cOUIFullPageStatement.findViewById(R.id_renamed.txt_exit);
        AppCompatActivity activityC0205c = this.f14351a;
        textView.setTextColor(COUIContextUtil.m6399a(activityC0205c, R.attr.couiTintControlNormal, activityC0205c.getColor(R.color.color_primary_light_yellow)));
        final TextView appStatement = cOUIFullPageStatement.getAppStatement();
        appStatement.setText(charSequenceM14342a);
        appStatement.setTextSize(0, this.f14351a.getResources().getDimensionPixelSize(R.dimen.camera_user_notice_content_text_size));
        appStatement.setMovementMethod(LinkMovementMethod.getInstance());
        appStatement.setHighlightColor(this.f14351a.getResources().getColor(android.R.color.transparent));
        appStatement.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.OplusGLSurfaceView_13.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                int offsetForPosition = appStatement.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                int i3 = iIndexOf;
                boolean z = offsetForPosition <= i3 || offsetForPosition >= i3 + length;
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        appStatement.setPressed(false);
                        appStatement.postInvalidateDelayed(70L);
                    }
                } else {
                    if (z) {
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
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14354f() {
        this.f14356f = new StatementDialogFragment(this.f14351a.getString(R.string.camera_user_disagrre_title));
        this.f14356f.m23916a(this.f14351a.getString(R.string.camera_exit_button_str));
        this.f14356f.m23919b(this.f14351a.getResources().getString(R.string.camera_disagree_enter_btn));
        this.f14356f.m23915a(new StatementDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_13.3
            @Override // com.oplus.camera.p172ui.StatementDialogFragment.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo14362a() {
                int OplusGLSurfaceView_13;
                COUIFullPageStatement cOUIFullPageStatementM23918b = CameraStatementAlert.this.f14356f.m23918b();
                cOUIFullPageStatementM23918b.setStatementMaxHeight(CameraStatementAlert.this.f14351a.getResources().getDimensionPixelOffset(R.dimen.camera_user_notice_max_height));
                cOUIFullPageStatementM23918b.setButtonListener(new COUIFullPageStatement.InterfaceC1386a() { // from class: com.oplus.camera.OplusGLSurfaceView_13.3.1
                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.InterfaceC1386a
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo7137a() {
                        CameraStatementAlert.this.f14356f.dismiss();
                        CameraStatementAlert.this.f14357g = false;
                        if (CameraStatementAlert.this.f14353c != null) {
                            CameraStatementAlert.this.f14353c.mo14333b(false);
                        }
                    }

                    @Override // com.coui.appcompat.widget.COUIFullPageStatement.InterfaceC1386a
                    /* renamed from: IntrinsicsJvm.kt_4 */
                    public void mo7138b() {
                        CameraStatementAlert.this.f14351a.finish();
                    }
                });
                if (CameraStatementAlert.this.m14351d() && !CameraStatementAlert.this.m14353e()) {
                    OplusGLSurfaceView_13 = R.string.camera_disagree_sticker_no_geographic_filtter;
                } else if (!CameraStatementAlert.this.m14351d() && CameraStatementAlert.this.m14353e()) {
                    OplusGLSurfaceView_13 = R.string.camera_disagree_geograhic_fillter_no_sticker;
                } else if (CameraStatementAlert.this.m14351d() || CameraStatementAlert.this.m14353e()) {
                    OplusGLSurfaceView_13 = R.string.camera_disagree_sticker_geograhic_filter_sticker;
                } else {
                    OplusGLSurfaceView_13 = Util.m24349al() ? R.string.camera_disagree_no_sticker_geographic_location_filter : R.string.camera_disagree_no_sticker_geographic_filter;
                }
                CameraStatementAlert.this.m14343a(OplusGLSurfaceView_13, R.string.privacy_policy_link, cOUIFullPageStatementM23918b);
            }

            @Override // com.oplus.camera.p172ui.StatementDialogFragment.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo14363b() {
                CameraStatementAlert.this.f14355e.dismiss();
            }

            @Override // com.oplus.camera.p172ui.StatementDialogFragment.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo14364c() {
                CameraStatementAlert.this.f14358h = true;
            }
        });
        this.f14356f.show(this.f14351a.m3341j(), "StatementDialogFragment");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private CharSequence m14342a(int OplusGLSurfaceView_13, int i2) {
        String string = this.f14351a.getString(i2);
        String string2 = this.f14351a.getString(OplusGLSurfaceView_13, new Object[]{string});
        int iIndexOf = string2.indexOf(string);
        int length = string.length();
        COUIClickableSpan c1449c = new COUIClickableSpan(this.f14351a);
        c1449c.m7541a(new COUIClickableSpan.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_13.4
            @Override // com.coui.appcompat.widget.COUIClickableSpan.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo7542a() {
                try {
                    if (CameraStatementAlert.this.f14358h) {
                        CameraStatementAlert.this.f14358h = false;
                        Intent intent = new Intent("com.oplus.bootreg.activity.statementpage");
                        intent.putExtra("statement_intent_flag", 2);
                        CameraStatementAlert.this.f14351a.startActivity(intent);
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    CameraStatementAlert.this.f14358h = true;
                }
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        spannableStringBuilder.setSpan(c1449c, iIndexOf, length + iIndexOf, 33);
        return spannableStringBuilder;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14359a() {
        return this.f14357g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14361b() {
        CameraLog.m12954a("CameraStatementAlert", "release");
        if (m14359a()) {
            StatementDialogFragment c3469v = this.f14355e;
            if (c3469v != null && !c3469v.isStateSaved() && this.f14355e.m23917a()) {
                this.f14355e.dismiss();
            } else {
                StatementDialogFragment c3469v2 = this.f14356f;
                if (c3469v2 != null && !c3469v2.isStateSaved() && this.f14356f.m23917a()) {
                    this.f14356f.dismiss();
                }
            }
        }
        this.f14357g = false;
        this.f14353c = null;
    }
}
