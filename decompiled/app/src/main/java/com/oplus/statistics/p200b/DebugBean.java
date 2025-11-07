package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;

/* compiled from: DebugBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class DebugBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f23802a;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return CommonStatusCodes.INTERNAL_EXCEPTION;
    }

    public DebugBean(Context context, boolean z) {
        super(context);
        this.f23802a = false;
        this.f23802a = z;
        m25313a("debug", this.f23802a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25288a() {
        return this.f23802a;
    }

    public String toString() {
        return "type is :" + mo25267b() + "\nflag is :" + m25288a() + "\OplusGLSurfaceView_11";
    }
}
