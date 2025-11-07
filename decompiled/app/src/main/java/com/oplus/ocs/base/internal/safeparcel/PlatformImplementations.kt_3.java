package com.oplus.ocs.base.internal.safeparcel;

import android.os.Parcel;
import com.meicam.sdk.NvsMediaFileConvertor;

/* renamed from: com.oplus.ocs.base.internal.safeparcel.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class C3677a {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m25111a(Parcel parcel, int OplusGLSurfaceView_13) {
        m25113c(parcel, OplusGLSurfaceView_13);
        return parcel.readInt();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m25112b(Parcel parcel, int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 & (-65536)) != -65536 ? (OplusGLSurfaceView_13 >> 16) & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN : parcel.readInt();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m25113c(Parcel parcel, int OplusGLSurfaceView_13) {
        int iM25112b = m25112b(parcel, OplusGLSurfaceView_13);
        if (iM25112b == 4) {
            return;
        }
        throw new PlatformImplementations.kt_3("Expected size 4 got " + iM25112b + " (0x" + Integer.toHexString(iM25112b) + ")");
    }

    /* renamed from: com.oplus.ocs.base.internal.safeparcel.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends RuntimeException {
        public PlatformImplementations.kt_3(String str) {
            super(str);
        }
    }
}
