package com.oplus.camera.p172ui.inverse;

import java.util.Objects;

/* compiled from: InverseChangeModeData.java */
/* renamed from: com.oplus.camera.ui.inverse.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class InverseChangeModeData {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f18738a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f18739b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f18740c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float f18741d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public long f18742e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public long f18743f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean f18744g;

    public String toString() {
        return "InverseChangeModeData{toScreenMode=" + this.f18738a + ", orientation=" + this.f18739b + ", toRadius=" + this.f18740c + ", toOffsetY=" + this.f18741d + ", duration=" + this.f18742e + ", isRackMode=" + this.f18744g + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InverseChangeModeData c3224b = (InverseChangeModeData) obj;
        return this.f18738a == c3224b.f18738a && this.f18739b == c3224b.f18739b && this.f18740c == c3224b.f18740c && this.f18744g == c3224b.f18744g;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f18738a), Integer.valueOf(this.f18739b), Integer.valueOf(this.f18740c), Boolean.valueOf(this.f18744g));
    }
}
