package com.oplus.camera;

/* loaded from: classes2.dex */
public class CameraButtonIntentReceiver extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.content.Intent intent2 = new android.content.Intent("android.intent.action.MAIN");
        intent2.setClass(context, com.oplus.camera.Camera.class);
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setFlags(335544320);
        context.startActivity(intent2);
    }
}
