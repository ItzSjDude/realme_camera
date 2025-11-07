package com.b_renamed.a_renamed;

/* compiled from: TouchController.java */
/* loaded from: classes.dex */
class m_renamed {
    public static float a_renamed(android.view.MotionEvent motionEvent) {
        double x_renamed = motionEvent.getX(0) - motionEvent.getX(1);
        double y_renamed = motionEvent.getY(0) - motionEvent.getY(1);
        double degrees = java.lang.Math.toDegrees(java.lang.Math.atan2(java.lang.Math.abs(y_renamed), java.lang.Math.abs(x_renamed)));
        if ((x_renamed <= 0.0d || y_renamed != 0.0d) && (x_renamed <= 0.0d || y_renamed >= 0.0d)) {
            if ((x_renamed == 0.0d && y_renamed < 0.0d) || (x_renamed < 0.0d && y_renamed < 0.0d)) {
                degrees = 180.0d - degrees;
            } else if ((x_renamed < 0.0d && y_renamed == 0.0d) || (x_renamed < 0.0d && y_renamed > 0.0d)) {
                degrees += 180.0d;
            } else if ((x_renamed == 0.0d && y_renamed > 0.0d) || (x_renamed > 0.0d && y_renamed > 0.0d)) {
                degrees = 360.0d - degrees;
            }
        }
        return (float) degrees;
    }

    public static int b_renamed(android.view.MotionEvent motionEvent) {
        double x_renamed = motionEvent.getX(0) - motionEvent.getX(1);
        double y_renamed = motionEvent.getY(0) - motionEvent.getY(1);
        if (x_renamed > 0.0d && y_renamed == 0.0d) {
            return 1;
        }
        if (x_renamed > 0.0d && y_renamed < 0.0d) {
            return 1;
        }
        if ((x_renamed == 0.0d && y_renamed < 0.0d) || (x_renamed < 0.0d && y_renamed < 0.0d)) {
            return 2;
        }
        if ((x_renamed >= 0.0d || y_renamed != 0.0d) && (x_renamed >= 0.0d || y_renamed <= 0.0d)) {
            return ((x_renamed != 0.0d || y_renamed <= 0.0d) && (x_renamed <= 0.0d || y_renamed <= 0.0d)) ? 1 : 4;
        }
        return 3;
    }
}
