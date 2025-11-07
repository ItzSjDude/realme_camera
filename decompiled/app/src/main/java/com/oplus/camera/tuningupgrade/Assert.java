package com.oplus.camera.tuningupgrade;

/* compiled from: TuningParameterUpgradeDcsMsgData.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.camera.statistics.model.DcsMsgData {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5728a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f5729b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5730c;

    public a_renamed(android.content.Context context) {
        super(context, "204", "");
        this.f5728a = 0;
        this.f5729b = "";
        this.f5730c = 0;
    }

    public void a_renamed() {
        this.mEventId = "receive_sau_broadcast";
        report();
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        a_renamed(i_renamed, str, 0);
    }

    public void a_renamed(int i_renamed, java.lang.String str, int i2) {
        this.mEventId = "copy_file";
        this.f5728a = i_renamed;
        this.f5729b = str;
        this.f5730c = i2;
        report();
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (this.mEventId.equals("receive_sau_broadcast")) {
            checkEmptyCondition("system_version", java.lang.String.valueOf(android.os.Build.TIME / 1000));
        }
        if (this.mEventId.equals("copy_file")) {
            checkGreatCondition("result", this.f5728a, -1);
            checkEmptyCondition("path", this.f5729b);
            checkGreatCondition("number", this.f5730c, 0);
        }
        super.report();
    }
}
