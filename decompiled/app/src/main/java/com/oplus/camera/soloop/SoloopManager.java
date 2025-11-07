package com.oplus.camera.soloop;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.view.OplusWindowManager;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.SwitchCameraMsgData;
import com.oplus.camera.util.Util;

/* compiled from: SoloopManager.java */
/* renamed from: com.oplus.camera.soloop.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class SoloopManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIAlertDialog f16127a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f16128b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SoloopDataRequest f16129c;

    public SoloopManager(Context context) {
        this.f16128b = null;
        this.f16129c = null;
        this.f16128b = context;
        this.f16129c = new SoloopDataRequest(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16726a() {
        SoloopDataRequest c2962a = this.f16129c;
        if (c2962a != null) {
            c2962a.m16716a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16727a(int OplusGLSurfaceView_13, boolean z) {
        Context context = this.f16128b;
        if (context == null) {
            return;
        }
        try {
            if (Util.m24288a(context, "com.oplus.videoeditor", 12400)) {
                m16723b(OplusGLSurfaceView_13, z);
            } else {
                m16729a(z);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("SoloopManager", "openSoloop error, reason: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16729a(final boolean z) {
        if (this.f16127a == null) {
            this.f16127a = new COUIAlertDialog.PlatformImplementations.kt_3(this.f16128b, 2131821271).setTitle(R.string.soloop_dialog_alert).setPositiveButton(R.string.soloop_dialog_install, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.soloop.IntrinsicsJvm.kt_4.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                    SoloopManager.this.m16724b(z);
                }
            }).setNegativeButton(R.string.soloop_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.soloop.IntrinsicsJvm.kt_4.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                    SoloopManager.this.f16127a.dismiss();
                    SoloopManager.this.f16127a = null;
                }
            }).create();
            this.f16127a.setCancelable(false);
        }
        if (this.f16127a.isShowing()) {
            return;
        }
        this.f16127a.show();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16723b(int OplusGLSurfaceView_13, boolean z) {
        Intent intent = new Intent("oplusos.intent.action.SOLOOP_TEMPLATE_CAMERA");
        intent.putExtra("template_camera_mode", "video");
        intent.putExtra("template_camera_id", OplusGLSurfaceView_13);
        if (z) {
            intent.addFlags(268468224);
        }
        m16725c(z);
        this.f16128b.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16724b(boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id_renamed=com.oplus.videoeditor"));
        if (z) {
            intent.addFlags(268468224);
        }
        m16725c(z);
        this.f16128b.startActivity(intent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16730b() {
        COUIAlertDialog dialogInterfaceC1289b = this.f16127a;
        if (dialogInterfaceC1289b == null || !dialogInterfaceC1289b.isShowing()) {
            return;
        }
        this.f16127a.dismiss();
        this.f16127a = null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16731c() {
        SoloopDataRequest c2962a = this.f16129c;
        if (c2962a != null) {
            c2962a.m16717b();
            this.f16129c = null;
        }
        this.f16128b = null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m16725c(boolean z) {
        if (z) {
            try {
                new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("SoloopManager", "OplusWindowManager exception: " + COUIBaseListPopupWindow_8.getMessage());
            } catch (Exception e2) {
                CameraLog.m12967f("SoloopManager", "OplusWindowManager error: " + e2.getMessage());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16728a(Context context, CameraUIListener cameraUIListener, int OplusGLSurfaceView_13) {
        SwitchCameraMsgData switchCameraMsgData = new SwitchCameraMsgData(context);
        switchCameraMsgData.mCameraId = cameraUIListener.mo10655I();
        switchCameraMsgData.mCaptureMode = cameraUIListener.mo10736ao();
        switchCameraMsgData.mOrientation = OplusGLSurfaceView_13;
        switchCameraMsgData.mCaptureType = ApsConstant.REC_MODE_COMMON.equals(cameraUIListener.mo10736ao()) ? 1 : 0;
        switchCameraMsgData.mCameraEnterType = String.valueOf(cameraUIListener.mo10786bc().m13317J());
        switchCameraMsgData.mToCaptureMode = ApsConstant.REC_MODE_SOLOOP;
        switchCameraMsgData.mOperType = "1";
        switchCameraMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(cameraUIListener.mo10654H()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        switchCameraMsgData.report();
    }
}
