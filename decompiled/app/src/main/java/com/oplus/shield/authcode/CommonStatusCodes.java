package com.oplus.shield.authcode;

import com.heytap.accessory.CommonStatusCodes;

/* compiled from: CommonStatusCodes.java */
/* renamed from: com.oplus.shield.authcode.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CommonStatusCodes {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25151a(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case CommonStatusCodes.AUTHENTICATE_SUCCESS /* 1001 */:
                return "AUTHENTICATE_SUCCESS";
            case 1002:
                return "AUTHENTICATE_FAIL";
            case CommonStatusCodes.TIME_EXPIRED /* 1003 */:
                return "TIME_EXPIRED";
            case CommonStatusCodes.AUTHCODE_EXPECTED /* 1004 */:
                return "AUTHCODE_EXPECTED";
            case CommonStatusCodes.VERSION_INCOMPATIBLE /* 1005 */:
                return "VERSION_INCOMPATIBLE";
            case CommonStatusCodes.AUTHCODE_RECYCLE /* 1006 */:
                return "AUTHCODE_RECYCLE";
            case CommonStatusCodes.AUTHCODE_INVALID /* 1007 */:
                return "AUTHCODE_INVALID";
            case CommonStatusCodes.CAPABILITY_EXCEPTION /* 1008 */:
                return "CAPABILITY_EXCEPTION";
            case CommonStatusCodes.INTERNAL_EXCEPTION /* 1009 */:
                return "INTERNAL_EXCEPTION";
            case CommonStatusCodes.PERMISSION_DENIAL /* 1010 */:
                return "NONE_PERMISSION";
            default:
                return "unknown status code: " + OplusGLSurfaceView_13;
        }
    }
}
