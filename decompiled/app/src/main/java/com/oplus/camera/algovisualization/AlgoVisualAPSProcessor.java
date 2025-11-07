package com.oplus.camera.algovisualization;

import com.oplus.camera.p141e.OneCamera;
import com.oplus.ocs.camera.CameraParameter;

/* compiled from: AlgoVisualAPSProcessor.java */
/* renamed from: com.oplus.camera.algovisualization.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AlgoVisualAPSProcessor {

    /* renamed from: PlatformImplementations.kt_3 */
    private OneCamera f12438a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f12439b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f12440c;

    public AlgoVisualAPSProcessor(OneCamera interfaceC2694d, boolean z, boolean z2) {
        this.f12438a = interfaceC2694d;
        this.f12439b = z;
        this.f12440c = z2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11601a() {
        this.f12438a.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.ALGO_VISUALIZATION_ENABLE, (CameraParameter.PreviewKey<String>) (this.f12439b ? "on" : "off"));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11602b() {
        this.f12438a.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.PICTURE_VISUALIZATION_ENABLE, (CameraParameter.PreviewKey<String>) (this.f12440c ? "on" : "off"));
    }
}
