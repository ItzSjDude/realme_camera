package com.oplus.camera.doubleexposure;

import com.oplus.camera.doubleexposure.VideoClipManager;

/* compiled from: DecodeVideoRequest.java */
/* renamed from: com.oplus.camera.doubleexposure.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class DecodeVideoRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private ClipVideoInfo f13183a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f13184b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private VideoClipManager.PlatformImplementations.kt_3 f13185c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private BlurViewHideCallback f13186d;

    public DecodeVideoRequest(ClipVideoInfo c2683b, boolean z, VideoClipManager.PlatformImplementations.kt_3 aVar, BlurViewHideCallback interfaceC2682a) {
        this.f13183a = null;
        this.f13184b = false;
        this.f13185c = null;
        this.f13186d = null;
        this.f13183a = c2683b;
        this.f13184b = z;
        this.f13185c = aVar;
        this.f13186d = interfaceC2682a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ClipVideoInfo m12905a() {
        return this.f13183a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m12906b() {
        return this.f13184b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public VideoClipManager.PlatformImplementations.kt_3 m12907c() {
        return this.f13185c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public BlurViewHideCallback m12908d() {
        return this.f13186d;
    }
}
