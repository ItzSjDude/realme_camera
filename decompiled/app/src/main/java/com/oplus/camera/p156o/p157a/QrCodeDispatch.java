package com.oplus.camera.p156o.p157a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: QrCodeDispatch.java */
/* renamed from: com.oplus.camera.o.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class QrCodeDispatch {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<Dispatch> f14772a = new ArrayList();

    public QrCodeDispatch() {
        this.f14772a.add(new LightGreyScale());
        this.f14772a.add(new OverBrightScale());
        this.f14772a.add(new OverDarkScale());
        this.f14772a.add(new RevGrayScale());
        this.f14772a.add(new InterruptGrayScale());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Dispatch m14803a(int OplusGLSurfaceView_13) {
        return this.f14772a.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m14802a() {
        return this.f14772a.size();
    }
}
