package com.oplus.camera.algovisualization;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: BatteryChangedReceiver.java */
/* renamed from: com.oplus.camera.algovisualization.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class BatteryChangedReceiver extends BroadcastReceiver {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f12516a = -1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f12517b = 10;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f12518c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            this.f12518c = intent.getIntExtra("temperature", -1) / 10;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m11620a() {
        return this.f12518c;
    }
}
