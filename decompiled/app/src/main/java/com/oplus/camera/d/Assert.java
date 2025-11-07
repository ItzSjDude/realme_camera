package com.oplus.camera.d_renamed;

/* compiled from: Beauty3DEditHelper.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f4359a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4360b = true;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.beauty3d.d_renamed f4361c;
    private android.content.SharedPreferences d_renamed;
    private android.content.Context e_renamed;

    public a_renamed(android.app.Activity activity, com.oplus.camera.ui.beauty3d.d_renamed dVar) {
        this.d_renamed = null;
        this.e_renamed = null;
        this.e_renamed = activity.getApplicationContext();
        this.f4361c = dVar;
        this.d_renamed = this.e_renamed.getSharedPreferences(this.e_renamed.getPackageName() + "_beauty3d_preferences", 0);
    }

    public void a_renamed(java.lang.String str, int[] iArr) throws android.content.res.Resources.NotFoundException {
        if (this.f4361c == null) {
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
                this.f4361c.c_renamed(iArr);
                return;
            } else {
                if (this.f4361c.o_renamed() == 1 || (this.f4361c.o_renamed() == 2 && !this.f4359a)) {
                    this.f4361c.b_renamed(iArr);
                    if (this.f4361c.o_renamed() == 2) {
                        this.f4361c.b_renamed(this.d_renamed.getInt("key_chose_style", 0));
                        com.oplus.camera.util.Util.ay_renamed().postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.d_renamed.a_renamed.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.oplus.camera.d_renamed.a_renamed.this.f4361c.b_renamed(true);
                            }
                        }, 3000L);
                        this.f4359a = true;
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (iArr != null && iArr.length >= 5) {
            java.lang.String[] strArr = new java.lang.String[5];
            java.lang.String string = this.e_renamed.getResources().getString(com.oplus.camera.d_renamed.c_renamed.a_renamed().e_renamed(iArr[0]).intValue());
            if (string == null) {
                string = "";
            }
            strArr[0] = string;
            java.lang.String string2 = this.e_renamed.getResources().getString(com.oplus.camera.d_renamed.c_renamed.a_renamed().d_renamed(iArr[1]).intValue());
            if (string2 == null) {
                string2 = "";
            }
            strArr[1] = string2;
            java.lang.String string3 = this.e_renamed.getResources().getString(com.oplus.camera.d_renamed.c_renamed.a_renamed().c_renamed(iArr[2]).intValue());
            if (string3 == null) {
                string3 = "";
            }
            strArr[2] = string3;
            java.lang.String string4 = this.e_renamed.getResources().getString(com.oplus.camera.d_renamed.c_renamed.a_renamed().b_renamed(iArr[3]).intValue());
            if (string4 == null) {
                string4 = "";
            }
            strArr[3] = string4;
            java.lang.String string5 = this.e_renamed.getResources().getString(com.oplus.camera.d_renamed.c_renamed.a_renamed().a_renamed(iArr[4]).intValue());
            if (string5 == null) {
                string5 = "";
            }
            strArr[4] = string5;
            this.f4361c.a_renamed(strArr);
        }
    }

    public int a_renamed() {
        android.content.SharedPreferences sharedPreferences = this.d_renamed;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("key_chose_style", 0);
        }
        return 0;
    }

    public void b_renamed() {
        this.f4359a = false;
        if (this.f4360b) {
            c_renamed();
            int i_renamed = this.d_renamed.getInt("key_chose_style", 0);
            int[] iArr = {this.d_renamed.getInt("key_style_natural_high_nose", 50), this.d_renamed.getInt("key_style_natural_small_nose", 70), this.d_renamed.getInt("key_style_natural_eye", 30), this.d_renamed.getInt("key_style_natural_fix_face", 30), this.d_renamed.getInt("key_style_natural_small_face", 30), this.d_renamed.getInt("key_style_natural_cheek_bone", 50), this.d_renamed.getInt("key_style_natural_chin", 0), this.d_renamed.getInt("key_style_goose_egg_high_nose", 50), this.d_renamed.getInt("key_style_goose_egg_small_nose", 80), this.d_renamed.getInt("key_style_natural_eye", 30), this.d_renamed.getInt("key_style_natural_fix_face", 35), this.d_renamed.getInt("key_style_goose_egg_small_face", 20), this.d_renamed.getInt("key_style_goose_egg_cheek_bone", 30), this.d_renamed.getInt("key_style_goose_egg_chin", 0), this.d_renamed.getInt("key_style_lolita_high_nose", 50), this.d_renamed.getInt("key_style_lolita_small_nose", 80), this.d_renamed.getInt("key_style_lolita_eye", 40), this.d_renamed.getInt("key_style_lolita_fix_face", 25), this.d_renamed.getInt("key_style_lolita_small_face", 40), this.d_renamed.getInt("key_style_lolita_cheekbone", 30), this.d_renamed.getInt("key_style_lolita_chin", 0), this.d_renamed.getInt("key_style_mode_high_nose", 100), this.d_renamed.getInt("key_style_mode_small_nose", 80), this.d_renamed.getInt("key_style_mode_eye", 40), this.d_renamed.getInt("key_style_mode_fix_face", 50), this.d_renamed.getInt("key_style_mode_small_face", 0), this.d_renamed.getInt("key_style_mode_cheekbone", 50), this.d_renamed.getInt("key_style_mode_chin", 10)};
            com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f4361c;
            if (dVar != null) {
                dVar.a_renamed(i_renamed, iArr);
                this.f4360b = false;
            }
        }
    }

    public void c_renamed() {
        int[] iArr = {50, 70, 30, 30, 30, 50, 0, 50, 80, 30, 35, 20, 30, 0, 50, 80, 40, 25, 40, 30, 0, 100, 80, 40, 50, 0, 50, 10};
        com.oplus.camera.ui.beauty3d.d_renamed dVar = this.f4361c;
        if (dVar != null) {
            dVar.a_renamed(iArr);
        }
    }

    public void d_renamed() {
        int[] iArrP = this.f4361c.p_renamed();
        android.content.SharedPreferences.Editor editorEdit = this.d_renamed.edit();
        if (iArrP == null || iArrP.length != 8) {
            return;
        }
        int i_renamed = iArrP[0];
        if (i_renamed == 0) {
            editorEdit.putInt("key_chose_style", iArrP[0]);
            editorEdit.putInt("key_style_natural_high_nose", iArrP[1]);
            editorEdit.putInt("key_style_natural_small_nose", iArrP[2]);
            editorEdit.putInt("key_style_natural_eye", iArrP[3]);
            editorEdit.putInt("key_style_natural_fix_face", iArrP[4]);
            editorEdit.putInt("key_style_natural_small_face", iArrP[5]);
            editorEdit.putInt("key_style_natural_cheek_bone", iArrP[6]);
            editorEdit.putInt("key_style_natural_chin", iArrP[7]);
        } else if (i_renamed == 1) {
            editorEdit.putInt("key_chose_style", iArrP[0]);
            editorEdit.putInt("key_style_goose_egg_high_nose", iArrP[1]);
            editorEdit.putInt("key_style_goose_egg_small_nose", iArrP[2]);
            editorEdit.putInt("key_style_natural_eye", iArrP[3]);
            editorEdit.putInt("key_style_natural_fix_face", iArrP[4]);
            editorEdit.putInt("key_style_goose_egg_small_face", iArrP[5]);
            editorEdit.putInt("key_style_goose_egg_cheek_bone", iArrP[6]);
            editorEdit.putInt("key_style_goose_egg_chin", iArrP[7]);
        } else if (i_renamed == 2) {
            editorEdit.putInt("key_chose_style", iArrP[0]);
            editorEdit.putInt("key_style_lolita_high_nose", iArrP[1]);
            editorEdit.putInt("key_style_lolita_small_nose", iArrP[2]);
            editorEdit.putInt("key_style_lolita_eye", iArrP[3]);
            editorEdit.putInt("key_style_lolita_fix_face", iArrP[4]);
            editorEdit.putInt("key_style_lolita_small_face", iArrP[5]);
            editorEdit.putInt("key_style_lolita_cheekbone", iArrP[6]);
            editorEdit.putInt("key_style_lolita_chin", iArrP[7]);
        } else if (i_renamed == 3) {
            editorEdit.putInt("key_chose_style", iArrP[0]);
            editorEdit.putInt("key_style_mode_high_nose", iArrP[1]);
            editorEdit.putInt("key_style_mode_small_nose", iArrP[2]);
            editorEdit.putInt("key_style_mode_eye", iArrP[3]);
            editorEdit.putInt("key_style_mode_fix_face", iArrP[4]);
            editorEdit.putInt("key_style_mode_small_face", iArrP[5]);
            editorEdit.putInt("key_style_mode_cheekbone", iArrP[6]);
            editorEdit.putInt("key_style_mode_chin", iArrP[7]);
        }
        editorEdit.apply();
        this.f4360b = true;
    }

    public void e_renamed() {
        android.content.SharedPreferences sharedPreferences = this.d_renamed;
        if (sharedPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.apply();
            this.f4360b = true;
        }
    }
}
