package com.oplus.camera.algovisualization;

/* compiled from: BatteryChangedReceiver.java */
/* loaded from: classes2.dex */
public class f_renamed extends android.content.BroadcastReceiver {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f4156a = -1;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f4157b = 10;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4158c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            this.f4158c = intent.getIntExtra("temperature", -1) / 10;
        }
    }

    public int a_renamed() {
        return this.f4158c;
    }
}
