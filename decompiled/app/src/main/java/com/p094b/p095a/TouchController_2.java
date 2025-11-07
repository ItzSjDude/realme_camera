package com.p094b.p095a;

import android.view.MotionEvent;

/* compiled from: TouchController.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
class TouchController_2 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static float m6360a(MotionEvent motionEvent) {
        double x = motionEvent.getX(0) - motionEvent.getX(1);
        double y = motionEvent.getY(0) - motionEvent.getY(1);
        double degrees = Math.toDegrees(Math.atan2(Math.abs(y), Math.abs(x)));
        if ((x <= 0.0d || y != 0.0d) && (x <= 0.0d || y >= 0.0d)) {
            if ((x == 0.0d && y < 0.0d) || (x < 0.0d && y < 0.0d)) {
                degrees = 180.0d - degrees;
            } else if ((x < 0.0d && y == 0.0d) || (x < 0.0d && y > 0.0d)) {
                degrees += 180.0d;
            } else if ((x == 0.0d && y > 0.0d) || (x > 0.0d && y > 0.0d)) {
                degrees = 360.0d - degrees;
            }
        }
        return (float) degrees;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m6361b(MotionEvent motionEvent) {
        double x = motionEvent.getX(0) - motionEvent.getX(1);
        double y = motionEvent.getY(0) - motionEvent.getY(1);
        if (x > 0.0d && y == 0.0d) {
            return 1;
        }
        if (x > 0.0d && y < 0.0d) {
            return 1;
        }
        if ((x == 0.0d && y < 0.0d) || (x < 0.0d && y < 0.0d)) {
            return 2;
        }
        if ((x >= 0.0d || y != 0.0d) && (x >= 0.0d || y <= 0.0d)) {
            return ((x != 0.0d || y <= 0.0d) && (x <= 0.0d || y <= 0.0d)) ? 1 : 4;
        }
        return 3;
    }
}
