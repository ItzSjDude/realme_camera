package com.oplus.camera.tuningupgrade;

import android.content.Context;
import android.os.Build;
import com.oplus.camera.statistics.model.DcsMsgData;

/* compiled from: TuningParameterUpgradeDcsMsgData.java */
/* renamed from: com.oplus.camera.tuningupgrade.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class TuningParameterUpgradeDcsMsgData extends DcsMsgData {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f17059a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f17060b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f17061c;

    public TuningParameterUpgradeDcsMsgData(Context context) {
        super(context, "204", "");
        this.f17059a = 0;
        this.f17060b = "";
        this.f17061c = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17942a() {
        this.mEventId = "receive_sau_broadcast";
        report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17943a(int OplusGLSurfaceView_13, String str) {
        m17944a(OplusGLSurfaceView_13, str, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17944a(int OplusGLSurfaceView_13, String str, int i2) {
        this.mEventId = "copy_file";
        this.f17059a = OplusGLSurfaceView_13;
        this.f17060b = str;
        this.f17061c = i2;
        report();
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (this.mEventId.equals("receive_sau_broadcast")) {
            checkEmptyCondition("system_version", String.valueOf(Build.TIME / 1000));
        }
        if (this.mEventId.equals("copy_file")) {
            checkGreatCondition("result", this.f17059a, -1);
            checkEmptyCondition("path", this.f17060b);
            checkGreatCondition("number", this.f17061c, 0);
        }
        super.report();
    }
}
