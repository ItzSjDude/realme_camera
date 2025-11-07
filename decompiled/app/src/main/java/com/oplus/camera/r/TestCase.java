package com.oplus.camera.r_renamed;

/* compiled from: SLVFps960Mode.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.camera.r_renamed.a_renamed {
    private boolean d_renamed;
    private com.c_renamed.a_renamed e_renamed;
    private java.lang.String f_renamed;
    private java.lang.String g_renamed;
    private final com.c_renamed.b_renamed h_renamed;

    @Override // com.oplus.camera.r_renamed.a_renamed
    int a_renamed() {
        return com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960;
    }

    @Override // com.oplus.camera.r_renamed.a_renamed
    public boolean b_renamed() {
        return true;
    }

    @Override // com.oplus.camera.r_renamed.a_renamed
    public int c_renamed() {
        return 2250;
    }

    public e_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        super(activity, cameraUIInterface);
        this.d_renamed = false;
        this.h_renamed = new com.c_renamed.b_renamed() { // from class: com.oplus.camera.r_renamed.e_renamed.1

            /* renamed from: b_renamed, reason: collision with root package name */
            private boolean f5308b = false;

            @Override // com.c_renamed.b_renamed
            public void a_renamed(int i_renamed) {
                java.lang.String str;
                if (i_renamed == 1) {
                    this.f5308b = false;
                    return;
                }
                if (i_renamed != 2) {
                    if (i_renamed != 3) {
                        return;
                    }
                    str = com.oplus.camera.r_renamed.e_renamed.this.e_renamed != null ? com.oplus.camera.r_renamed.e_renamed.this.g_renamed : null;
                    this.f5308b = true;
                    com.oplus.camera.r_renamed.e_renamed.this.f5306c.b_renamed(str);
                    com.oplus.camera.e_renamed.f_renamed("SLVFps960Mode", "onCompileStatusChange, compile failed!");
                    return;
                }
                if (!this.f5308b) {
                    str = com.oplus.camera.r_renamed.e_renamed.this.e_renamed != null ? com.oplus.camera.r_renamed.e_renamed.this.g_renamed : null;
                    com.oplus.camera.e_renamed.b_renamed("SLVFps960Mode", "onCompileStatusChange mbStopped: " + com.oplus.camera.r_renamed.e_renamed.this.d_renamed);
                    if (com.oplus.camera.r_renamed.e_renamed.this.d_renamed) {
                        com.oplus.camera.r_renamed.e_renamed.this.d_renamed = false;
                        com.oplus.camera.r_renamed.e_renamed.this.f5306c.b_renamed(str);
                    } else {
                        com.oplus.camera.r_renamed.e_renamed.this.f5306c.a_renamed(str);
                    }
                    com.oplus.camera.e_renamed.b_renamed("SLVFps960Mode", "onCompileStatusChange, STATUS_COMPILE_FINISHED CostTime: " + (java.lang.System.currentTimeMillis() - com.oplus.camera.r_renamed.e_renamed.this.e_renamed.c_renamed()));
                    return;
                }
                com.oplus.camera.e_renamed.b_renamed("SLVFps960Mode", "onCompileStatusChange, compile finished, but already failed!");
            }
        };
        f_renamed();
        com.oplus.camera.e_renamed.b_renamed("SLVFps960Mode", "SLVFps960Mode, new MeicamVideoEngine");
    }

    private void f_renamed() {
        this.f5304a.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.e_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.r_renamed.e_renamed.this.e_renamed == null) {
                    com.oplus.camera.r_renamed.e_renamed eVar = com.oplus.camera.r_renamed.e_renamed.this;
                    eVar.e_renamed = new com.c_renamed.a_renamed(eVar.f5304a, com.oplus.camera.r_renamed.e_renamed.this.h_renamed);
                }
            }
        });
    }

    @Override // com.oplus.camera.r_renamed.a_renamed
    public void d_renamed() {
        this.d_renamed = true;
        com.c_renamed.a_renamed aVar = this.e_renamed;
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    @Override // com.oplus.camera.r_renamed.a_renamed
    public void e_renamed() {
        this.f5304a.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.e_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.r_renamed.e_renamed.this.e_renamed != null) {
                    com.oplus.camera.r_renamed.e_renamed.this.e_renamed.b_renamed();
                    com.oplus.camera.r_renamed.e_renamed.this.e_renamed = null;
                    com.oplus.camera.e_renamed.b_renamed("SLVFps960Mode", "exit, releaseMeicamVideoEngine");
                }
            }
        });
        super.e_renamed();
    }

    @Override // com.oplus.camera.r_renamed.a_renamed
    public com.oplus.camera.ui.control.b_renamed a_renamed(int i_renamed) {
        if (i_renamed == 2) {
            return new com.oplus.camera.ui.control.b_renamed(3, "button_color_inside_none", "button_shape_dial_still", 1);
        }
        return super.a_renamed(i_renamed);
    }

    @Override // com.oplus.camera.r_renamed.a_renamed
    public boolean a_renamed(int i_renamed, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str) {
        boolean zA = false;
        this.d_renamed = false;
        if (this.e_renamed != null && !android.text.TextUtils.isEmpty(this.f_renamed) && uri != null && contentValues != null) {
            java.lang.String strReplace = java.lang.String.valueOf(contentValues.get("_display_name")).replace("VID", "Slow");
            android.content.ContentValues contentValues2 = new android.content.ContentValues(7);
            contentValues2.put("title", str);
            contentValues2.put("_display_name", strReplace);
            contentValues2.put("mime_type", java.lang.String.valueOf(contentValues.get("mime_type")));
            contentValues2.put("relative_path", com.oplus.camera.Storage.e_renamed(null));
            contentValues2.put("is_pending", (java.lang.Integer) 1);
            this.g_renamed = com.oplus.camera.util.storage.a_renamed.a_renamed(this.f5304a, this.f5304a.getContentResolver(), contentValues2).toString();
            this.e_renamed.a_renamed(i_renamed);
            zA = this.e_renamed.a_renamed(uri.toString(), this.g_renamed, com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960 / java.lang.Integer.parseInt(this.f_renamed));
        }
        if (!zA) {
            this.f5306c.b_renamed(null);
        }
        return zA;
    }

    @Override // com.oplus.camera.r_renamed.a_renamed
    protected java.lang.String a_renamed(java.lang.String str) {
        this.f_renamed = str;
        return "slow_motion_platform_" + str + "_960";
    }
}
