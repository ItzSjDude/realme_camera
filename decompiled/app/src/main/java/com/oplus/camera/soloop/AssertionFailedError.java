package com.oplus.camera.soloop;

/* compiled from: SoloopManager.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.dialog.app.b_renamed f5410a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f5411b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.soloop.a_renamed f5412c;

    public b_renamed(android.content.Context context) {
        this.f5411b = null;
        this.f5412c = null;
        this.f5411b = context;
        this.f5412c = new com.oplus.camera.soloop.a_renamed(context);
    }

    public void a_renamed() {
        com.oplus.camera.soloop.a_renamed aVar = this.f5412c;
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        android.content.Context context = this.f5411b;
        if (context == null) {
            return;
        }
        try {
            if (com.oplus.camera.util.Util.a_renamed(context, "com.oplus.videoeditor", 12400)) {
                b_renamed(i_renamed, z_renamed);
            } else {
                a_renamed(z_renamed);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("SoloopManager", "openSoloop error, reason: " + e_renamed.getMessage());
        }
    }

    public void a_renamed(final boolean z_renamed) {
        if (this.f5410a == null) {
            this.f5410a = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.f5411b, 2131821271).setTitle(com.oplus.camera.R_renamed.string.soloop_dialog_alert).setPositiveButton(com.oplus.camera.R_renamed.string.soloop_dialog_install, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.soloop.b_renamed.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                    com.oplus.camera.soloop.b_renamed.this.b_renamed(z_renamed);
                }
            }).setNegativeButton(com.oplus.camera.R_renamed.string.soloop_dialog_cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.soloop.b_renamed.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                    com.oplus.camera.soloop.b_renamed.this.f5410a.dismiss();
                    com.oplus.camera.soloop.b_renamed.this.f5410a = null;
                }
            }).create();
            this.f5410a.setCancelable(false);
        }
        if (this.f5410a.isShowing()) {
            return;
        }
        this.f5410a.show();
    }

    private void b_renamed(int i_renamed, boolean z_renamed) {
        android.content.Intent intent = new android.content.Intent("oplusos.intent.action.SOLOOP_TEMPLATE_CAMERA");
        intent.putExtra("template_camera_mode", "video");
        intent.putExtra("template_camera_id", i_renamed);
        if (z_renamed) {
            intent.addFlags(268468224);
        }
        c_renamed(z_renamed);
        this.f5411b.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("market://details?id_renamed=com.oplus.videoeditor"));
        if (z_renamed) {
            intent.addFlags(268468224);
        }
        c_renamed(z_renamed);
        this.f5411b.startActivity(intent);
    }

    public void b_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.f5410a;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.f5410a.dismiss();
        this.f5410a = null;
    }

    public void c_renamed() {
        com.oplus.camera.soloop.a_renamed aVar = this.f5412c;
        if (aVar != null) {
            aVar.b_renamed();
            this.f5412c = null;
        }
        this.f5411b = null;
    }

    private void c_renamed(boolean z_renamed) {
        if (z_renamed) {
            try {
                new android.view.OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (android.os.RemoteException e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("SoloopManager", "OplusWindowManager exception: " + e_renamed.getMessage());
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.f_renamed("SoloopManager", "OplusWindowManager error: " + e2.getMessage());
            }
        }
    }

    public void a_renamed(android.content.Context context, com.oplus.camera.ui.CameraUIListener cameraUIListener, int i_renamed) {
        com.oplus.camera.statistics.model.SwitchCameraMsgData switchCameraMsgData = new com.oplus.camera.statistics.model.SwitchCameraMsgData(context);
        switchCameraMsgData.mCameraId = cameraUIListener.I_renamed();
        switchCameraMsgData.mCaptureMode = cameraUIListener.ao_renamed();
        switchCameraMsgData.mOrientation = i_renamed;
        switchCameraMsgData.mCaptureType = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON.equals(cameraUIListener.ao_renamed()) ? 1 : 0;
        switchCameraMsgData.mCameraEnterType = java.lang.String.valueOf(cameraUIListener.bc_renamed().J_renamed());
        switchCameraMsgData.mToCaptureMode = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SOLOOP;
        switchCameraMsgData.mOperType = "1";
        switchCameraMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(cameraUIListener.H_renamed()) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        switchCameraMsgData.report();
    }
}
