package com.oplus.p125c.p126a.p130b;

import android.net.Uri;
import com.android.providers.downloads.Downloads;
import com.oplus.ocs.camera.CameraParameter;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: MediaItem.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class MediaItem.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f10512a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f10513b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f10514c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f10515d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f10516e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final String f10517f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Uri f10518g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final int f10519h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final long f10520i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final boolean f10521j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final boolean f10522k;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem.kt)) {
            return false;
        }
        MediaItem.kt c2436a = (MediaItem.kt) obj;
        return Intrinsics.m5299a((Object) this.f10516e, (Object) c2436a.f10516e) && Intrinsics.m5299a((Object) this.f10517f, (Object) c2436a.f10517f) && Intrinsics.m5299a(this.f10518g, c2436a.f10518g) && this.f10519h == c2436a.f10519h && this.f10520i == c2436a.f10520i && this.f10521j == c2436a.f10521j && this.f10522k == c2436a.f10522k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f10516e;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f10517f;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Uri uri = this.f10518g;
        int iHashCode3 = (((((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31) + Integer.hashCode(this.f10519h)) * 31) + Long.hashCode(this.f10520i)) * 31;
        boolean z = this.f10521j;
        int OplusGLSurfaceView_13 = z;
        if (z != 0) {
            OplusGLSurfaceView_13 = 1;
        }
        int i2 = (iHashCode3 + OplusGLSurfaceView_13) * 31;
        boolean z2 = this.f10522k;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        return i2 + i3;
    }

    public String toString() {
        return "MediaItem(mediaId=" + this.f10516e + ", filePath=" + this.f10517f + ", uri=" + this.f10518g + ", orientation=" + this.f10519h + ", dateModifiedInSec=" + this.f10520i + ", isVideo=" + this.f10521j + ", isCshot=" + this.f10522k + ")";
    }

    public MediaItem.kt(String str, String str2, Uri uri, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, boolean z, boolean z2) {
        Intrinsics.m5303c(str, "mediaId");
        Intrinsics.m5303c(str2, CameraParameter.WaterMarkParamKeys.FILE_PATH);
        Intrinsics.m5303c(uri, Downloads.Impl.COLUMN_URI);
        this.f10516e = str;
        this.f10517f = str2;
        this.f10518g = uri;
        this.f10519h = OplusGLSurfaceView_13;
        this.f10520i = OplusGLSurfaceView_15;
        this.f10521j = z;
        this.f10522k = z2;
        this.f10515d = "";
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final String m9432e() {
        return this.f10516e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final String m9433f() {
        return this.f10517f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final Uri m9434g() {
        return this.f10518g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public final int m9435h() {
        return this.f10519h;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public final long m9436i() {
        return this.f10520i;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public final boolean m9437j() {
        return this.f10521j;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public final boolean m9438k() {
        return this.f10522k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m9424a() {
        return this.f10512a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9425a(int OplusGLSurfaceView_13) {
        this.f10512a = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int m9427b() {
        return this.f10513b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m9428b(int OplusGLSurfaceView_13) {
        this.f10513b = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final int m9429c() {
        return this.f10514c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m9430c(int OplusGLSurfaceView_13) {
        this.f10514c = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m9426a(String str) {
        Intrinsics.m5303c(str, "<set-?>");
        this.f10515d = str;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final String m9431d() {
        return this.f10515d;
    }
}
