package com.oplus.camera;

/* loaded from: classes2.dex */
public class DebugBroadcastReceiver extends android.content.BroadcastReceiver {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f4053a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f4054b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.DialogInterface.OnClickListener f4055c = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.DebugBroadcastReceiver.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
            if (android.text.TextUtils.isEmpty(com.oplus.camera.DebugBroadcastReceiver.this.f4053a)) {
            }
            if (i_renamed == -1) {
                com.oplus.camera.e_renamed.b_renamed("DebugBroadcastReceiver", "onClick, mCurrCode: " + com.oplus.camera.DebugBroadcastReceiver.this.f4053a);
                switch (com.oplus.camera.DebugBroadcastReceiver.this.f4053a) {
                    case "*#2785*6787#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, 1);
                        break;
                    case "*#2785*8378#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, 2);
                        break;
                    case "*#2785*82757#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, 5);
                        break;
                    case "*#2785*757#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, 3);
                        break;
                    case "*#2785*368*324#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, true);
                        break;
                    case "*#2785*368*757#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, false);
                        break;
                    case "*#2872*324*66#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.b_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, true);
                        break;
                    case "*#2872*324*633#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.b_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, false);
                        break;
                    case "*#2785*324*51#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.c_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, true);
                        break;
                    case "*#2785*324*52#":
                        com.oplus.camera.sticker.c_renamed.d_renamed.c_renamed(com.oplus.camera.DebugBroadcastReceiver.this.f4054b, false);
                        break;
                }
            }
        }
    };

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent != null && "com.oplus.engineermode.EngineerModeMain".equals(intent.getAction())) {
            java.lang.String stringExtra = null;
            try {
                stringExtra = intent.getStringExtra("order");
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            if (!android.text.TextUtils.isEmpty(stringExtra) && a_renamed(stringExtra)) {
                this.f4054b = context;
                a_renamed(context, stringExtra);
            }
        }
    }

    private boolean a_renamed(java.lang.String str) {
        return "*#2785*6787#".equals(str) || "*#2785*8378#".equals(str) || "*#2785*82757#".equals(str) || "*#2785*757#".equals(str) || "*#2785*368*324#".equals(str) || "*#2785*368*757#".equals(str) || "*#2872*324*66#".equals(str) || "*#2872*324*633#".equals(str) || "*#2785*324*51#".equals(str) || "*#2785*324*52#".equals(str);
    }

    private void a_renamed(android.content.Context context, java.lang.String str) {
        this.f4053a = str;
        com.coui.appcompat.dialog.app.b_renamed.a_renamed aVar = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(context, 2131821271);
        aVar.setTitle(com.oplus.camera.R_renamed.string.audit_mode_warning_title);
        aVar.setMessage(b_renamed(context, str));
        aVar.setCancelable(false);
        aVar.setPositiveButton(android.R_renamed.string.ok, this.f4055c);
        if (!b_renamed(str)) {
            aVar.setNegativeButton(android.R_renamed.string.cancel, (android.content.DialogInterface.OnClickListener) null);
        }
        com.coui.appcompat.dialog.app.b_renamed bVarCreate = aVar.create();
        bVarCreate.getWindow().setType(2038);
        bVarCreate.show();
    }

    private boolean b_renamed(java.lang.String str) {
        return "*#2785*368*757#".equals(str) || "*#2785*757#".equals(str) || "*#2872*324*633#".equals(str) || "*#2785*324*52#".equals(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b_renamed(android.content.Context r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.DebugBroadcastReceiver.b_renamed(android.content.Context, java.lang.String):java.lang.String");
    }
}
