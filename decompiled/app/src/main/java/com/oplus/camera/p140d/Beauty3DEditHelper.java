package com.oplus.camera.p140d;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI;
import com.oplus.camera.util.Util;

/* compiled from: Beauty3DEditHelper.java */
/* renamed from: com.oplus.camera.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class Beauty3DEditHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f13122a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f13123b = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Beauty3DEditUI f13124c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SharedPreferences f13125d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f13126e;

    public Beauty3DEditHelper(Activity activity, Beauty3DEditUI viewOnClickListenerC3137d) {
        this.f13125d = null;
        this.f13126e = null;
        this.f13126e = activity.getApplicationContext();
        this.f13124c = viewOnClickListenerC3137d;
        this.f13125d = this.f13126e.getSharedPreferences(this.f13126e.getPackageName() + "_beauty3d_preferences", 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12803a(String str, int[] iArr) throws Resources.NotFoundException {
        if (this.f13124c == null) {
            return;
        }
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -826558116) {
            if (iHashCode != -624491669) {
                if (iHashCode == 175127237 && str.equals("com.oplus.beauty3d.analyses.ffd")) {
                    c2 = 1;
                }
            } else if (str.equals("com.oplus.beauty3d.custom.result")) {
                c2 = 2;
            }
        } else if (str.equals("com.oplus.beauty3d.analyses.result")) {
            c2 = 0;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                this.f13124c.m18638c(iArr);
                return;
            } else {
                if (this.f13124c.m18650o() == 1 || (this.f13124c.m18650o() == 2 && !this.f13122a)) {
                    this.f13124c.m18635b(iArr);
                    if (this.f13124c.m18650o() == 2) {
                        this.f13124c.m18632b(this.f13125d.getInt("key_chose_style", 0));
                        Util.m24362ay().postDelayed(new Runnable() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Beauty3DEditHelper.this.f13124c.m18634b(true);
                            }
                        }, 3000L);
                        this.f13122a = true;
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (iArr != null && iArr.length >= 5) {
            String[] strArr = new String[5];
            String string = this.f13126e.getResources().getString(Beauty3DTools.m12873a().m12881e(iArr[0]).intValue());
            if (string == null) {
                string = "";
            }
            strArr[0] = string;
            String string2 = this.f13126e.getResources().getString(Beauty3DTools.m12873a().m12880d(iArr[1]).intValue());
            if (string2 == null) {
                string2 = "";
            }
            strArr[1] = string2;
            String string3 = this.f13126e.getResources().getString(Beauty3DTools.m12873a().m12879c(iArr[2]).intValue());
            if (string3 == null) {
                string3 = "";
            }
            strArr[2] = string3;
            String string4 = this.f13126e.getResources().getString(Beauty3DTools.m12873a().m12878b(iArr[3]).intValue());
            if (string4 == null) {
                string4 = "";
            }
            strArr[3] = string4;
            String string5 = this.f13126e.getResources().getString(Beauty3DTools.m12873a().m12876a(iArr[4]).intValue());
            if (string5 == null) {
                string5 = "";
            }
            strArr[4] = string5;
            this.f13124c.m18630a(strArr);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m12802a() {
        SharedPreferences sharedPreferences = this.f13125d;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("key_chose_style", 0);
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12804b() {
        this.f13122a = false;
        if (this.f13123b) {
            m12805c();
            int OplusGLSurfaceView_13 = this.f13125d.getInt("key_chose_style", 0);
            int[] iArr = {this.f13125d.getInt("key_style_natural_high_nose", 50), this.f13125d.getInt("key_style_natural_small_nose", 70), this.f13125d.getInt("key_style_natural_eye", 30), this.f13125d.getInt("key_style_natural_fix_face", 30), this.f13125d.getInt("key_style_natural_small_face", 30), this.f13125d.getInt("key_style_natural_cheek_bone", 50), this.f13125d.getInt("key_style_natural_chin", 0), this.f13125d.getInt("key_style_goose_egg_high_nose", 50), this.f13125d.getInt("key_style_goose_egg_small_nose", 80), this.f13125d.getInt("key_style_natural_eye", 30), this.f13125d.getInt("key_style_natural_fix_face", 35), this.f13125d.getInt("key_style_goose_egg_small_face", 20), this.f13125d.getInt("key_style_goose_egg_cheek_bone", 30), this.f13125d.getInt("key_style_goose_egg_chin", 0), this.f13125d.getInt("key_style_lolita_high_nose", 50), this.f13125d.getInt("key_style_lolita_small_nose", 80), this.f13125d.getInt("key_style_lolita_eye", 40), this.f13125d.getInt("key_style_lolita_fix_face", 25), this.f13125d.getInt("key_style_lolita_small_face", 40), this.f13125d.getInt("key_style_lolita_cheekbone", 30), this.f13125d.getInt("key_style_lolita_chin", 0), this.f13125d.getInt("key_style_mode_high_nose", 100), this.f13125d.getInt("key_style_mode_small_nose", 80), this.f13125d.getInt("key_style_mode_eye", 40), this.f13125d.getInt("key_style_mode_fix_face", 50), this.f13125d.getInt("key_style_mode_small_face", 0), this.f13125d.getInt("key_style_mode_cheekbone", 50), this.f13125d.getInt("key_style_mode_chin", 10)};
            Beauty3DEditUI viewOnClickListenerC3137d = this.f13124c;
            if (viewOnClickListenerC3137d != null) {
                viewOnClickListenerC3137d.m18626a(OplusGLSurfaceView_13, iArr);
                this.f13123b = false;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12805c() {
        int[] iArr = {50, 70, 30, 30, 30, 50, 0, 50, 80, 30, 35, 20, 30, 0, 50, 80, 40, 25, 40, 30, 0, 100, 80, 40, 50, 0, 50, 10};
        Beauty3DEditUI viewOnClickListenerC3137d = this.f13124c;
        if (viewOnClickListenerC3137d != null) {
            viewOnClickListenerC3137d.m18629a(iArr);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12806d() {
        int[] iArrM18651p = this.f13124c.m18651p();
        SharedPreferences.Editor editorEdit = this.f13125d.edit();
        if (iArrM18651p == null || iArrM18651p.length != 8) {
            return;
        }
        int OplusGLSurfaceView_13 = iArrM18651p[0];
        if (OplusGLSurfaceView_13 == 0) {
            editorEdit.putInt("key_chose_style", iArrM18651p[0]);
            editorEdit.putInt("key_style_natural_high_nose", iArrM18651p[1]);
            editorEdit.putInt("key_style_natural_small_nose", iArrM18651p[2]);
            editorEdit.putInt("key_style_natural_eye", iArrM18651p[3]);
            editorEdit.putInt("key_style_natural_fix_face", iArrM18651p[4]);
            editorEdit.putInt("key_style_natural_small_face", iArrM18651p[5]);
            editorEdit.putInt("key_style_natural_cheek_bone", iArrM18651p[6]);
            editorEdit.putInt("key_style_natural_chin", iArrM18651p[7]);
        } else if (OplusGLSurfaceView_13 == 1) {
            editorEdit.putInt("key_chose_style", iArrM18651p[0]);
            editorEdit.putInt("key_style_goose_egg_high_nose", iArrM18651p[1]);
            editorEdit.putInt("key_style_goose_egg_small_nose", iArrM18651p[2]);
            editorEdit.putInt("key_style_natural_eye", iArrM18651p[3]);
            editorEdit.putInt("key_style_natural_fix_face", iArrM18651p[4]);
            editorEdit.putInt("key_style_goose_egg_small_face", iArrM18651p[5]);
            editorEdit.putInt("key_style_goose_egg_cheek_bone", iArrM18651p[6]);
            editorEdit.putInt("key_style_goose_egg_chin", iArrM18651p[7]);
        } else if (OplusGLSurfaceView_13 == 2) {
            editorEdit.putInt("key_chose_style", iArrM18651p[0]);
            editorEdit.putInt("key_style_lolita_high_nose", iArrM18651p[1]);
            editorEdit.putInt("key_style_lolita_small_nose", iArrM18651p[2]);
            editorEdit.putInt("key_style_lolita_eye", iArrM18651p[3]);
            editorEdit.putInt("key_style_lolita_fix_face", iArrM18651p[4]);
            editorEdit.putInt("key_style_lolita_small_face", iArrM18651p[5]);
            editorEdit.putInt("key_style_lolita_cheekbone", iArrM18651p[6]);
            editorEdit.putInt("key_style_lolita_chin", iArrM18651p[7]);
        } else if (OplusGLSurfaceView_13 == 3) {
            editorEdit.putInt("key_chose_style", iArrM18651p[0]);
            editorEdit.putInt("key_style_mode_high_nose", iArrM18651p[1]);
            editorEdit.putInt("key_style_mode_small_nose", iArrM18651p[2]);
            editorEdit.putInt("key_style_mode_eye", iArrM18651p[3]);
            editorEdit.putInt("key_style_mode_fix_face", iArrM18651p[4]);
            editorEdit.putInt("key_style_mode_small_face", iArrM18651p[5]);
            editorEdit.putInt("key_style_mode_cheekbone", iArrM18651p[6]);
            editorEdit.putInt("key_style_mode_chin", iArrM18651p[7]);
        }
        editorEdit.apply();
        this.f13123b = true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12807e() {
        SharedPreferences sharedPreferences = this.f13125d;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.apply();
            this.f13123b = true;
        }
    }
}
