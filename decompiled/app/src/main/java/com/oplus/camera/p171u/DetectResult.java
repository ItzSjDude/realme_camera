package com.oplus.camera.p171u;

import android.graphics.Point;
import android.graphics.PointF;
import java.util.Arrays;

/* compiled from: DetectResult.java */
/* renamed from: com.oplus.camera.u.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DetectResult {

    /* renamed from: PlatformImplementations.kt_3 */
    private Point[] f17064a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PointF[] f17065b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PointF[] f17066c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f17067d;

    public DetectResult() {
        this.f17067d = false;
        this.f17067d = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PointF[] m17953a() {
        return this.f17066c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17952a(PointF[] pointFArr) {
        this.f17066c = pointFArr;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PointF[] m17955b() {
        return this.f17065b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17954b(PointF[] pointFArr) {
        this.f17065b = pointFArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17951a(Point[] pointArr) {
        this.f17064a = pointArr;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m17956c() {
        return this.f17067d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17950a(boolean z) {
        this.f17067d = z;
    }

    public String toString() {
        return "DetectResult{mActualResultPointsArray=" + Arrays.toString(this.f17064a) + ", mPercentResultArrayForPreview=" + Arrays.toString(this.f17065b) + ", mPercentResultArrayForCapture=" + Arrays.toString(this.f17066c) + ", mbHasResult=" + this.f17067d + '}';
    }
}
