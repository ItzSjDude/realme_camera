package com.oplus.ocs.base.internal.safeparcel;

import android.os.Parcel;
import com.sensetime.stmobile.STMobileHumanActionNative;

/* renamed from: com.oplus.ocs.base.internal.safeparcel.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class C3678b {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25115a(Parcel parcel, int OplusGLSurfaceView_13, int i2) {
        m25117c(parcel, OplusGLSurfaceView_13);
        parcel.writeInt(i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25114a(Parcel parcel, int OplusGLSurfaceView_13) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(OplusGLSurfaceView_13 - 4);
        parcel.writeInt(iDataPosition - OplusGLSurfaceView_13);
        parcel.setDataPosition(iDataPosition);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m25116b(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(OplusGLSurfaceView_13 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m25117c(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(OplusGLSurfaceView_13 | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
    }
}
