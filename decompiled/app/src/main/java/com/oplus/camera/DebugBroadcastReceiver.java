package com.oplus.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.oplus.camera.sticker.p167c.PrefUtils;

/* loaded from: classes2.dex */
public class DebugBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f11229a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f11230b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private DialogInterface.OnClickListener f11231c = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.DebugBroadcastReceiver.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
            if (TextUtils.isEmpty(DebugBroadcastReceiver.this.f11229a)) {
            }
            if (OplusGLSurfaceView_13 == -1) {
                CameraLog.m12959b("DebugBroadcastReceiver", "onClick, mCurrCode: " + DebugBroadcastReceiver.this.f11229a);
                switch (DebugBroadcastReceiver.this.f11229a) {
                    case "*#2785*6787#":
                        PrefUtils.m16825a(DebugBroadcastReceiver.this.f11230b, 1);
                        break;
                    case "*#2785*8378#":
                        PrefUtils.m16825a(DebugBroadcastReceiver.this.f11230b, 2);
                        break;
                    case "*#2785*82757#":
                        PrefUtils.m16825a(DebugBroadcastReceiver.this.f11230b, 5);
                        break;
                    case "*#2785*757#":
                        PrefUtils.m16825a(DebugBroadcastReceiver.this.f11230b, 3);
                        break;
                    case "*#2785*368*324#":
                        PrefUtils.m16827a(DebugBroadcastReceiver.this.f11230b, true);
                        break;
                    case "*#2785*368*757#":
                        PrefUtils.m16827a(DebugBroadcastReceiver.this.f11230b, false);
                        break;
                    case "*#2872*324*66#":
                        PrefUtils.m16830b(DebugBroadcastReceiver.this.f11230b, true);
                        break;
                    case "*#2872*324*633#":
                        PrefUtils.m16830b(DebugBroadcastReceiver.this.f11230b, false);
                        break;
                    case "*#2785*324*51#":
                        PrefUtils.m16833c(DebugBroadcastReceiver.this.f11230b, true);
                        break;
                    case "*#2785*324*52#":
                        PrefUtils.m16833c(DebugBroadcastReceiver.this.f11230b, false);
                        break;
                }
            }
        }
    };

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.oplus.engineermode.EngineerModeMain".equals(intent.getAction())) {
            String stringExtra = null;
            try {
                stringExtra = intent.getStringExtra("order");
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (!TextUtils.isEmpty(stringExtra) && m11080a(stringExtra)) {
                this.f11230b = context;
                m11079a(context, stringExtra);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m11080a(String str) {
        return "*#2785*6787#".equals(str) || "*#2785*8378#".equals(str) || "*#2785*82757#".equals(str) || "*#2785*757#".equals(str) || "*#2785*368*324#".equals(str) || "*#2785*368*757#".equals(str) || "*#2872*324*66#".equals(str) || "*#2872*324*633#".equals(str) || "*#2785*324*51#".equals(str) || "*#2785*324*52#".equals(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11079a(Context context, String str) {
        this.f11229a = str;
        COUIAlertDialog.PlatformImplementations.kt_3 aVar = new COUIAlertDialog.PlatformImplementations.kt_3(context, 2131821271);
        aVar.setTitle(R.string.audit_mode_warning_title);
        aVar.setMessage(m11082b(context, str));
        aVar.setCancelable(false);
        aVar.setPositiveButton(android.R.string.ok, this.f11231c);
        if (!m11083b(str)) {
            aVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        }
        COUIAlertDialog dialogInterfaceC1289bCreate = aVar.create();
        dialogInterfaceC1289bCreate.getWindow().setType(2038);
        dialogInterfaceC1289bCreate.show();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m11083b(String str) {
        return "*#2785*368*757#".equals(str) || "*#2785*757#".equals(str) || "*#2872*324*633#".equals(str) || "*#2785*324*52#".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String m11082b(android.content.Context r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.DebugBroadcastReceiver.m11082b(android.content.Context, java.lang.String):java.lang.String");
    }
}
