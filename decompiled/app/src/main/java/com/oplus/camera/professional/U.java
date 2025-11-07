package com.oplus.camera.professional;

/* compiled from: NightPro.java */
/* loaded from: classes2.dex */
public class n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.app.Activity f5190a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.CameraUIInterface f5191b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.capmode.a_renamed f5192c;
    private com.oplus.camera.e_renamed.d_renamed f_renamed;
    private android.content.SharedPreferences h_renamed;
    private java.lang.String i_renamed;
    private com.oplus.camera.professional.r_renamed d_renamed = null;
    private com.oplus.camera.professional.s_renamed e_renamed = null;
    private com.oplus.camera.professional.n_renamed.a_renamed g_renamed = null;
    private java.util.ArrayList j_renamed = null;

    /* compiled from: NightPro.java */
    public interface a_renamed {
        boolean a_renamed();

        boolean a_renamed(java.lang.String str);

        boolean b_renamed();

        int c_renamed();

        com.oplus.camera.ui.control.b_renamed d_renamed();

        boolean e_renamed();
    }

    public n_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, java.lang.String str, com.oplus.camera.e_renamed.d_renamed dVar) {
        this.f5190a = activity;
        this.f5191b = cameraUIInterface;
        this.f5192c = aVar;
        this.h_renamed = this.f5192c.t_renamed();
        this.i_renamed = str;
        this.f_renamed = dVar;
    }

    public boolean a_renamed() {
        return a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) && !(1 == java.lang.Integer.parseInt(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0))));
    }

    private boolean a_renamed(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences;
        if (this.g_renamed.a_renamed(str) && (sharedPreferences = this.h_renamed) != null) {
            return "on_renamed".equals(sharedPreferences.getString(str, "off"));
        }
        return false;
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("NightPro", "onDeInitCameraMode");
        this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_pro_fixed_tips_oplus_r);
        this.f5191b.a_renamed(true, true, false);
        com.oplus.camera.professional.r_renamed rVar = this.d_renamed;
        if (rVar != null) {
            rVar.g_renamed();
            this.d_renamed.a_renamed((com.oplus.camera.professional.r_renamed.b_renamed) null);
            this.d_renamed = null;
        }
        com.oplus.camera.professional.s_renamed sVar = this.e_renamed;
        if (sVar != null) {
            sVar.a_renamed();
            this.e_renamed = null;
        }
    }

    public void c_renamed() {
        this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_pro_fixed_tips_oplus_r);
        this.f5191b.a_renamed(true, true, false);
        if (this.d_renamed == null || !a_renamed()) {
            return;
        }
        this.d_renamed.m_renamed();
    }

    public boolean d_renamed() {
        com.oplus.camera.professional.r_renamed rVar = this.d_renamed;
        if (rVar != null) {
            return rVar.i_renamed();
        }
        return false;
    }

    public boolean e_renamed() {
        com.oplus.camera.professional.r_renamed rVar = this.d_renamed;
        if (rVar != null) {
            return rVar.h_renamed();
        }
        return false;
    }

    public boolean f_renamed() {
        com.oplus.camera.professional.r_renamed rVar = this.d_renamed;
        return rVar != null && rVar.i_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("NightPro", "onBeforePreview");
        com.oplus.camera.e_renamed.d_renamed dVar = this.f_renamed;
        if (dVar != null) {
            dVar.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>>) com.oplus.ocs.camera.CameraParameter.ZOOM_RATIO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) java.lang.Float.valueOf(this.f5192c.ak_renamed()));
        }
        if (this.d_renamed == null || !a_renamed()) {
            return;
        }
        this.d_renamed.c_renamed(z_renamed);
    }

    public boolean a_renamed(com.oplus.camera.e_renamed.c_renamed cVar, boolean z_renamed) {
        boolean zB = this.g_renamed.b_renamed();
        if (this.d_renamed != null && a_renamed() && !this.d_renamed.a_renamed(zB)) {
            return false;
        }
        if (zB) {
            this.f5190a.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.n_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.n_renamed.this.f5192c.aI_renamed();
                }
            });
        }
        if (this.e_renamed == null) {
            return true;
        }
        if (!z_renamed && !cVar.Y_renamed) {
            return true;
        }
        this.e_renamed.a_renamed(8, false);
        return true;
    }

    public void a_renamed(byte[] bArr, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("NightPro", "onAfterPictureTaken");
        if (a_renamed()) {
            this.f5191b.n_renamed();
            this.f5192c.aJ_renamed();
        }
        if (this.d_renamed != null && a_renamed()) {
            this.d_renamed.a_renamed(bArr, z_renamed, z2);
        }
        if (this.e_renamed == null || !this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) || v_renamed() || this.f5191b.A_renamed() || this.f5191b.aw_renamed() || f_renamed()) {
            return;
        }
        this.e_renamed.a_renamed(0, true);
    }

    public void g_renamed() {
        if (this.e_renamed != null && this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) && v_renamed()) {
            this.e_renamed.a_renamed(0, true);
        }
    }

    private boolean v_renamed() {
        android.app.Activity activity;
        android.content.SharedPreferences sharedPreferences = this.h_renamed;
        if (sharedPreferences == null || (activity = this.f5190a) == null) {
            return false;
        }
        return "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, activity.getString(com.oplus.camera.R_renamed.string.camera_night_tripod_mode_default_value)));
    }

    public void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        if (this.d_renamed == null || !a_renamed()) {
            return;
        }
        this.d_renamed.a_renamed(captureResult);
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.professional.r_renamed rVar;
        com.oplus.camera.e_renamed.f_renamed("NightPro", "onResume");
        if (!a_renamed() || (rVar = this.d_renamed) == null) {
            return;
        }
        rVar.e_renamed();
    }

    public void h_renamed() {
        if (a_renamed()) {
            c_renamed(0, false);
        }
        this.e_renamed = new com.oplus.camera.professional.s_renamed(this.f5190a, this.f5192c, this.f5191b);
        this.e_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE);
        b_renamed(this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) ? 0 : 8, false);
        this.f5191b.z_renamed(false);
    }

    public void i_renamed() {
        if (this.d_renamed != null && a_renamed()) {
            this.d_renamed.u_renamed();
        }
        if (this.e_renamed != null && !f_renamed()) {
            this.e_renamed.c_renamed();
        }
        if (a_renamed()) {
            c_renamed(0, false);
            this.f5191b.z_renamed(false);
        }
    }

    private void b_renamed(int i_renamed, boolean z_renamed) {
        if (this.e_renamed == null) {
            if (i_renamed != 0) {
                return;
            }
            this.e_renamed = new com.oplus.camera.professional.s_renamed(this.f5190a, this.f5192c, this.f5191b);
            this.e_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE);
        }
        this.e_renamed.a_renamed(i_renamed, z_renamed);
    }

    public void a_renamed(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        com.oplus.camera.professional.r_renamed rVar = this.d_renamed;
        if (rVar != null) {
            rVar.a_renamed(sharedPreferences, str);
        }
    }

    private void c_renamed(int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("NightPro", "setProMenuVisibility visibility: " + i_renamed);
        if (this.d_renamed == null) {
            if (i_renamed != 0) {
                return;
            } else {
                j_renamed();
            }
        }
        this.d_renamed.a_renamed(i_renamed, z_renamed);
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.professional.r_renamed rVar = this.d_renamed;
        if (rVar != null) {
            rVar.a_renamed(i_renamed);
        }
    }

    public void j_renamed() {
        this.d_renamed = new com.oplus.camera.professional.o_renamed(this.f5190a, this.f5192c, this.f5191b, this.i_renamed);
        this.d_renamed.a_renamed(new com.oplus.camera.professional.r_renamed.b_renamed() { // from class: com.oplus.camera.professional.n_renamed.2
            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean b_renamed() {
                return com.oplus.camera.professional.n_renamed.this.a_renamed();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean a_renamed() {
                return com.oplus.camera.professional.n_renamed.this.g_renamed.a_renamed();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean a_renamed(java.lang.String str) {
                return com.oplus.camera.professional.n_renamed.this.g_renamed.a_renamed(str);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public int c_renamed() {
                return com.oplus.camera.professional.n_renamed.this.g_renamed.c_renamed();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void b_renamed(java.lang.String str) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.b_renamed(str);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(int i_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.a_renamed(i_renamed, true);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public int d_renamed() {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    return com.oplus.camera.professional.n_renamed.this.f_renamed.p_renamed();
                }
                return 1;
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void b_renamed(int i_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.a_renamed(i_renamed, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(float f_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.a_renamed(f_renamed, true);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(long j_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.b_renamed(j_renamed);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(boolean z_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.l_renamed(z_renamed);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void c_renamed(int i_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.x_renamed(i_renamed);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void e_renamed() {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.i_renamed(true);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void d_renamed(int i_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void e_renamed(int i_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(i_renamed));
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void f_renamed() {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void g_renamed() {
                if (com.oplus.camera.professional.n_renamed.this.f_renamed != null) {
                    com.oplus.camera.professional.n_renamed.this.f_renamed.j_renamed(true);
                }
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public com.oplus.camera.ui.control.b_renamed h_renamed() {
                return com.oplus.camera.professional.n_renamed.this.g_renamed.d_renamed();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean i_renamed() {
                return com.oplus.camera.professional.n_renamed.this.g_renamed.e_renamed();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void b_renamed(boolean z_renamed) {
                if (com.oplus.camera.professional.n_renamed.this.e_renamed == null || !com.oplus.camera.professional.n_renamed.this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
                    return;
                }
                com.oplus.camera.professional.n_renamed.this.e_renamed.a_renamed(z_renamed ? 0 : 8, false);
            }
        });
    }

    public boolean k_renamed() {
        if (this.d_renamed == null || !a_renamed()) {
            return false;
        }
        return this.d_renamed.c_renamed();
    }

    private void w_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.d_renamed == null || this.h_renamed == null || !a_renamed() || !this.h_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_NIGHT_PRO_PARAMS, false)) {
            return;
        }
        this.h_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_NIGHT_PRO_PARAMS).apply();
        this.d_renamed.n_renamed();
    }

    public void l_renamed() {
        com.oplus.camera.e_renamed.a_renamed("NightPro", "onMoreModeShown");
        if (a_renamed()) {
            c_renamed(8, false);
        }
        b_renamed(8, false);
    }

    public void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed("NightPro", "onMoreModeHidden");
        if (a_renamed()) {
            c_renamed(0, false);
        }
        b_renamed((!this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) || f_renamed()) ? 8 : 0, false);
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        if (this.d_renamed == null || !a_renamed()) {
            return false;
        }
        return this.d_renamed.a_renamed(motionEvent);
    }

    public void n_renamed() {
        if (this.d_renamed != null && a_renamed()) {
            this.d_renamed.s_renamed();
        }
        if (this.e_renamed == null || !this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) || this.g_renamed.a_renamed() || this.f5192c.A_renamed() || this.f5191b.A_renamed() || f_renamed()) {
            return;
        }
        this.e_renamed.a_renamed(0, true);
    }

    public void o_renamed() {
        if (this.d_renamed != null && a_renamed()) {
            this.d_renamed.t_renamed();
        }
        if (this.e_renamed == null || !this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            return;
        }
        this.e_renamed.a_renamed(4, true);
    }

    public void b_renamed(int i_renamed) {
        if (this.d_renamed == null || !a_renamed()) {
            return;
        }
        this.d_renamed.b_renamed(i_renamed);
    }

    public void c_renamed(boolean z_renamed) {
        c_renamed(z_renamed ? 0 : 8, false);
        this.e_renamed.a_renamed(z_renamed);
        w_renamed();
        if (this.f5192c.J_renamed()) {
            this.f5191b.F_renamed(true);
            if (this.g_renamed.e_renamed()) {
                this.f5191b.a_renamed(0, true);
            } else {
                this.f5191b.a_renamed(0, 1);
            }
        }
        this.f5192c.aH_renamed();
        this.f5191b.z_renamed(false);
        if (!z_renamed) {
            this.d_renamed.n_renamed();
            this.d_renamed.b_renamed(false);
            if (!this.f5191b.d_renamed() && !this.f5191b.A_renamed() && !this.g_renamed.e_renamed()) {
                this.f5191b.a_renamed(0, 1);
            }
            this.f5191b.d_renamed(0);
            this.f5191b.b_renamed(true, false);
            return;
        }
        this.d_renamed.b_renamed(true);
        this.d_renamed.x_renamed();
        this.f5192c.a_renamed();
    }

    public void d_renamed(boolean z_renamed) {
        this.f5191b.a_renamed(true, true, false);
        if (z_renamed) {
            com.oplus.camera.professional.s_renamed sVar = this.e_renamed;
            if (sVar != null) {
                sVar.a_renamed(8, false);
            }
            if (this.d_renamed != null) {
                c_renamed(8, false);
            }
        }
        com.oplus.camera.professional.r_renamed rVar = this.d_renamed;
        if (rVar != null) {
            rVar.d_renamed(true);
        }
    }

    public void p_renamed() {
        if (!"off".equals(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE, "off"))) {
            this.h_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE, "off").apply();
        }
        com.oplus.camera.professional.s_renamed sVar = this.e_renamed;
        if (sVar != null) {
            sVar.a_renamed(false);
            boolean z_renamed = 1 == java.lang.Integer.parseInt(this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0)));
            if (this.e_renamed.b_renamed() || z_renamed || this.f5191b.aw_renamed() || this.f5191b.A_renamed()) {
                return;
            }
            this.e_renamed.a_renamed(0, false);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    public void q_renamed() {
        if (a_renamed()) {
            if (!f_renamed()) {
                this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_pro_fixed_tips_oplus_r, -1, false, false, true);
            }
            java.lang.String string = this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.f5190a.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
            char c2 = 65535;
            switch (string.hashCode()) {
                case -1993005596:
                    if (string.equals("standard_high")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -894674659:
                    if (string.equals("square")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1514655:
                    if (string.equals("16_9")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3154575:
                    if (string.equals(com.oplus.camera.statistics.model.DcsMsgData.FULL)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1312628413:
                    if (string.equals("standard")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_4_3);
                return;
            }
            if (c2 == 2) {
                this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_full);
                return;
            } else if (c2 == 3) {
                this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_16_9);
                return;
            } else {
                if (c2 != 4) {
                    return;
                }
                this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_1_1);
                return;
            }
        }
        this.f5191b.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_pro_fixed_tips_oplus_r);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("NightPro", "changeModeAllView animationType: " + i_renamed + ", isShow: " + z_renamed);
        if (3 == i_renamed && this.g_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            if (this.d_renamed != null) {
                this.d_renamed.b_renamed((z_renamed && this.g_renamed.a_renamed()) ? false : z_renamed);
            }
            if (z_renamed) {
                if (a_renamed()) {
                    c_renamed(a_renamed() ? 0 : 8, true);
                }
                b_renamed(0, false);
            } else {
                if (a_renamed()) {
                    c_renamed(8, true);
                }
                b_renamed(8, false);
            }
        }
    }

    public java.util.List<java.lang.Integer> r_renamed() {
        java.util.ArrayList arrayList = this.j_renamed;
        if (arrayList != null) {
            return arrayList;
        }
        this.j_renamed = new java.util.ArrayList();
        this.j_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_tips));
        this.j_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_light_collect_tips_oplus_r));
        this.j_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_low_exposure_time_tips_oplus_r));
        this.j_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_image_optimizing_tips_oplus_r));
        return this.j_renamed;
    }

    public void a_renamed(com.oplus.camera.professional.n_renamed.a_renamed aVar) {
        this.g_renamed = aVar;
    }

    public void e_renamed(boolean z_renamed) {
        if (this.d_renamed == null || !a_renamed()) {
            return;
        }
        this.d_renamed.d_renamed(true);
    }

    public void s_renamed() {
        com.oplus.camera.professional.s_renamed sVar = this.e_renamed;
        if (sVar != null) {
            sVar.d_renamed();
        }
    }

    public void t_renamed() {
        com.oplus.camera.professional.s_renamed sVar = this.e_renamed;
        if (sVar != null) {
            sVar.e_renamed();
        }
    }

    public void u_renamed() {
        com.oplus.camera.professional.s_renamed sVar = this.e_renamed;
        if (sVar != null) {
            sVar.f_renamed();
        }
    }
}
