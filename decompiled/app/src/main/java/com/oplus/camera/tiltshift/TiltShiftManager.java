package com.oplus.camera.tiltshift;

/* loaded from: classes2.dex */
public class TiltShiftManager {
    private static final long DELAY_RESET_ADJUSTING_STATE_DURATION = 300;
    private static final float INIT_TILT_SHIFT_RADIUS = 300.0f;
    private static final int MSG_RESET_ADJUSTING_STATE = 1;
    private static final java.lang.String TAG = "TiltShiftManager";
    private android.app.Activity mActivity;
    private com.oplus.camera.capmode.a_renamed mCameraInterface;
    private com.oplus.camera.ui.CameraUIInterface mCameraUIInterface;
    private com.oplus.camera.ComboPreferences mPreferences;
    private android.view.ViewGroup mPreviewLayout;
    private float mMaxTiltShiftRadiusRatio = 0.5f;
    private float mMinTiltShiftRadiusRatio = 0.1f;
    private float mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
    private double mCurrentTiltShiftCenterX = 1.0d;
    private double mCurrentTiltShiftCenterY = 1.0d;
    private double mCurrentTiltShiftRotation = 0.0d;
    private double mCurrentTiltShiftDegree = 0.0d;
    private boolean mbCurrentTiltShiftAdjusting = false;
    private boolean mbCircle = false;
    private android.graphics.PointF mPoint1 = null;
    private android.graphics.PointF mPoint2 = null;
    private android.graphics.PointF mPoint3 = null;
    private android.graphics.PointF mPoint4 = null;
    private int mPreviewHeight = 0;
    private int mPreviewWidth = 0;
    private int mPreviewAreaTop = 0;
    private int mPreviewAreaLeft = 0;
    private int mPreviewAreaRight = 0;
    private int mPreviewAreaBottom = 0;
    private int mPreviewAreaWidth = 0;
    private int mPreviewAreaHeight = 0;
    private android.util.Size mPreviewSize = null;
    private android.graphics.Rect mPreviewArea = null;
    private com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener mCameraTiltShiftListener = null;
    private android.os.Handler mMainHandler = null;
    private com.oplus.camera.tiltshift.TiltShiftParam mTiltShiftParam = new com.oplus.camera.tiltshift.TiltShiftParam();
    private com.oplus.camera.tiltshift.TiltShiftManager.Mode mGestureMode = com.oplus.camera.tiltshift.TiltShiftManager.Mode.NONE;
    private float mTouchDownX = 0.0f;
    private float mTouchDownY = 0.0f;
    private float mTouchSpacing = 0.0f;
    private float mTouchDegree = 0.0f;
    private float mTouchTranslationX = 0.0f;
    private float mTouchTranslationY = 0.0f;
    private float mTouchScale = 1.0f;
    private float mTouchRotation = 0.0f;
    private float mTouchTiltShiftRadius = 0.0f;
    private float mTouchTiltShiftDegree = 0.0f;
    private double mTouchTiltShiftX = 0.0d;
    private double mTouchTiltShiftY = 0.0d;

    public interface CameraTiltShiftListener {
        boolean getSupportTiltShif();

        boolean getTiltShifGestureEnabled();

        boolean isEffectMenuAnimRunning();

        void setTiltShiftParams(com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParam);
    }

    enum Mode {
        NONE,
        SCALE,
        MOVE,
        ROTATE
    }

    public TiltShiftManager(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.mActivity = null;
        this.mPreviewLayout = null;
        this.mPreferences = null;
        this.mCameraInterface = null;
        this.mCameraUIInterface = null;
        this.mActivity = activity;
        this.mPreferences = comboPreferences;
        this.mCameraInterface = aVar;
        this.mCameraUIInterface = cameraUIInterface;
        this.mPreviewLayout = (android.view.ViewGroup) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        initMainHandler();
    }

    private void initMainHandler() {
        this.mMainHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.tiltshift.TiltShiftManager.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what != 1) {
                    return;
                }
                com.oplus.camera.tiltshift.TiltShiftManager.this.resetAjustingState();
            }
        };
    }

    public void setCameraTiltShiftListener(com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener cameraTiltShiftListener) {
        this.mCameraTiltShiftListener = cameraTiltShiftListener;
    }

    public void onPause() {
        android.os.Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void initialize(android.util.Size size, android.graphics.Rect rect) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "initialize, previewSize: " + size + ", previewArea: " + rect);
        this.mPreviewSize = size;
        this.mPreviewArea = rect;
        android.graphics.Rect rect2 = this.mPreviewArea;
        if (rect2 != null) {
            this.mPreviewAreaTop = rect2.top;
            this.mPreviewAreaLeft = this.mPreviewArea.left;
            this.mPreviewAreaRight = this.mPreviewArea.right;
            this.mPreviewAreaBottom = this.mPreviewArea.bottom;
            this.mPreviewAreaWidth = this.mPreviewArea.width();
            this.mPreviewAreaHeight = this.mPreviewArea.height();
        }
        initTiftShiftPoint();
        this.mTiltShiftParam.setPreviewSize(this.mPreviewSize);
    }

    private void initTiftShiftPoint() {
        int i_renamed = this.mPreviewAreaRight;
        int i2 = this.mPreviewAreaLeft;
        this.mCurrentTiltShiftCenterX = (i_renamed - i2) / 2;
        int i3 = this.mPreviewAreaBottom;
        int i4 = this.mPreviewAreaTop;
        this.mCurrentTiltShiftCenterY = (i3 - i4) / 2;
        this.mPreviewWidth = i_renamed - i2;
        this.mPreviewHeight = i3 - i4;
        this.mCurrentTiltShiftDegree = 0.0d;
        this.mCurrentTiltShiftRotation = java.lang.Math.toRadians(this.mCurrentTiltShiftDegree);
        this.mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
        com.oplus.camera.e_renamed.a_renamed(TAG, "initTiftShiftPoint, mCurrentTiltShiftCenterX: " + this.mCurrentTiltShiftCenterX + ", mCurrentTiltShiftCenterY: " + this.mCurrentTiltShiftCenterY);
        calculateTiftShiftPoint();
    }

    private void reCalculateTiftShiftCenter() {
        this.mCurrentTiltShiftCenterX = (((this.mPoint1.x_renamed + this.mPoint2.x_renamed) + this.mPoint3.x_renamed) + this.mPoint4.x_renamed) / 4.0f;
        this.mCurrentTiltShiftCenterY = (((this.mPoint1.y_renamed + this.mPoint2.y_renamed) + this.mPoint3.y_renamed) + this.mPoint4.y_renamed) / 4.0f;
        calculateTiftShiftPoint();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void calculateTiftShiftPoint() {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.tiltshift.TiltShiftManager.calculateTiftShiftPoint():void");
    }

    public com.oplus.camera.tiltshift.TiltShiftParam getTiltShiftCaptureParam() {
        com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParam = new com.oplus.camera.tiltshift.TiltShiftParam(this.mTiltShiftParam);
        float[] transformedCaptureCenterPoints = getTransformedCaptureCenterPoints(new float[]{this.mTiltShiftParam.getCenterY(), this.mTiltShiftParam.getCenterX()});
        tiltShiftParam.setCenterX(transformedCaptureCenterPoints[0]);
        tiltShiftParam.setCenterY(transformedCaptureCenterPoints[1]);
        tiltShiftParam.setAngle(getCaptureDegree());
        return tiltShiftParam;
    }

    private float getCaptureDegree() {
        double d_renamed = this.mCurrentTiltShiftDegree;
        return (float) (d_renamed <= 90.0d ? d_renamed + 90.0d : d_renamed - 90.0d);
    }

    private float[] getTransformedCaptureCenterPoints(float[] fArr) {
        int iMin = java.lang.Math.min(this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
        int iMax = java.lang.Math.max(this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(90.0f);
        matrix.postTranslate(iMax / 2, (-iMin) / 2);
        matrix.postScale(-1.0f, 1.0f);
        float[] fArr2 = new float[2];
        matrix.mapPoints(fArr2, fArr);
        return fArr2;
    }

    public void switchTiltShiftType(boolean z_renamed) {
        this.mbCircle = z_renamed;
        this.mbCurrentTiltShiftAdjusting = true;
        initTiftShiftPoint();
        this.mMainHandler.sendEmptyMessageDelayed(1, DELAY_RESET_ADJUSTING_STATE_DURATION);
    }

    public void resetAjustingState() {
        this.mbCurrentTiltShiftAdjusting = false;
        calculateTiftShiftPoint();
    }

    public void resetTiltShiftParams() {
        this.mbCurrentTiltShiftAdjusting = false;
        if (this.mPreviewArea != null) {
            int i_renamed = this.mPreviewAreaRight;
            int i2 = this.mPreviewAreaLeft;
            this.mCurrentTiltShiftCenterX = (i_renamed - i2) / 2;
            int i3 = this.mPreviewAreaBottom;
            int i4 = this.mPreviewAreaTop;
            this.mCurrentTiltShiftCenterY = (i3 - i4) / 2;
            this.mPreviewWidth = i_renamed - i2;
            this.mPreviewHeight = i3 - i4;
        }
        this.mCurrentTiltShiftRotation = java.lang.Math.toRadians(0.0d);
        this.mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
    }

    private void clampInPreviewArea(android.graphics.PointF pointF) {
        if (pointF.x_renamed < 0.0f) {
            pointF.x_renamed = 0.0f;
        }
        if (pointF.y_renamed < 0.0f) {
            pointF.y_renamed = 0.0f;
        }
        float f_renamed = pointF.x_renamed;
        int i_renamed = this.mPreviewWidth;
        if (f_renamed > i_renamed) {
            pointF.x_renamed = i_renamed;
        }
        float f2 = pointF.y_renamed;
        int i2 = this.mPreviewHeight;
        if (f2 > i2) {
            pointF.y_renamed = i2;
        }
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (needDispatchTouchEvent()) {
            return operateTouchEvent(motionEvent);
        }
        return false;
    }

    public void setPreviewSize(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setPreviewSize, previewWidth: " + i_renamed + ", previewHeight: " + i2);
        if (this.mPreviewWidth == i_renamed && this.mPreviewHeight == i2) {
            return;
        }
        this.mPreviewWidth = i_renamed;
        this.mPreviewHeight = i2;
    }

    public void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onDestroy");
        resetTiltShiftParams();
        this.mActivity = null;
        this.mPreferences = null;
        this.mCameraInterface = null;
        this.mCameraTiltShiftListener = null;
    }

    public boolean isPointInTiltShift(float f_renamed, float f2) {
        if (this.mPreviewArea == null) {
            return false;
        }
        float f3 = f_renamed - this.mPreviewAreaLeft;
        float f4 = f2 - this.mPreviewAreaTop;
        if (this.mbCircle) {
            return isPointInTiltShiftCircle(f3, f4);
        }
        return isPointInTiltShiftRect(f3, f4);
    }

    private boolean isPointInTiltShiftCircle(float f_renamed, float f2) {
        double d_renamed = f_renamed;
        double d2 = this.mCurrentTiltShiftCenterX;
        double d3 = (d_renamed - d2) * (d_renamed - d2);
        double d4 = f2;
        double d5 = this.mCurrentTiltShiftCenterY;
        return java.lang.Math.sqrt(d3 + ((d4 - d5) * (d4 - d5))) <= ((double) this.mCurrentTiltShiftRadius);
    }

    private boolean isPointInTiltShiftRect(float f_renamed, float f2) {
        android.graphics.RectF rectF = new android.graphics.RectF();
        float fSqrt = ((float) java.lang.Math.sqrt(java.lang.Math.pow(this.mPreviewWidth, 2.0d) + java.lang.Math.pow(this.mPreviewHeight, 2.0d))) * 2.0f;
        float f3 = this.mCurrentTiltShiftRadius * 2.0f;
        double d_renamed = this.mCurrentTiltShiftCenterX;
        float f4 = fSqrt / 2.0f;
        double d2 = this.mCurrentTiltShiftCenterY;
        float f5 = f3 / 2.0f;
        rectF.set(((float) d_renamed) - f4, ((float) d2) - f5, ((float) d_renamed) + f4, ((float) d2) + f5);
        float[] fArr = {rectF.left, rectF.top};
        float[] fArr2 = {rectF.left, rectF.bottom};
        float[] fArr3 = {rectF.right, rectF.bottom};
        float[] fArr4 = {rectF.right, rectF.top};
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate((int) this.mCurrentTiltShiftDegree, rectF.centerX(), rectF.centerY());
        matrix.mapPoints(fArr);
        matrix.mapPoints(fArr2);
        matrix.mapPoints(fArr3);
        matrix.mapPoints(fArr4);
        float f6 = ((fArr2[0] - fArr[0]) * (f2 - fArr[1])) - ((fArr2[1] - fArr[1]) * (f_renamed - fArr[0]));
        float f7 = ((fArr3[0] - fArr2[0]) * (f2 - fArr2[1])) - ((fArr3[1] - fArr2[1]) * (f_renamed - fArr2[0]));
        float f8 = ((fArr4[0] - fArr3[0]) * (f2 - fArr3[1])) - ((fArr4[1] - fArr3[1]) * (f_renamed - fArr3[0]));
        float f9 = ((fArr[0] - fArr4[0]) * (f2 - fArr4[1])) - ((fArr[1] - fArr4[1]) * (f_renamed - fArr4[0]));
        if ((f6 > 0.0f && f7 > 0.0f && f8 > 0.0f && f9 > 0.0f) || (f6 < 0.0f && f7 < 0.0f && f8 < 0.0f && f9 < 0.0f)) {
            com.oplus.camera.e_renamed.c_renamed(TAG, "isPointInTiltShiftRect true");
            return true;
        }
        com.oplus.camera.e_renamed.c_renamed(TAG, "isPointInTiltShiftRect false");
        return false;
    }

    private boolean isPointInPreviewRect(int i_renamed, int i2) {
        if (new android.graphics.Rect(this.mPreviewLayout.getLeft(), this.mPreviewLayout.getTop(), this.mPreviewLayout.getRight(), this.mPreviewLayout.getBottom()).contains(i_renamed, i2)) {
            return getTouchEnable(i_renamed, i2);
        }
        return false;
    }

    private boolean getTouchEnable(int i_renamed, int i2) {
        return i2 >= this.mCameraUIInterface.am_renamed() && i2 <= this.mCameraUIInterface.an_renamed();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean operateTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.tiltshift.TiltShiftManager.operateTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean isSupportTiltShif() {
        com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener cameraTiltShiftListener = this.mCameraTiltShiftListener;
        if (cameraTiltShiftListener != null) {
            return cameraTiltShiftListener.getSupportTiltShif();
        }
        return false;
    }

    private boolean getTiltShiftGestureEnabled() {
        return "off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"));
    }

    private boolean needDispatchTouchEvent() {
        com.oplus.camera.tiltshift.TiltShiftManager.CameraTiltShiftListener cameraTiltShiftListener = this.mCameraTiltShiftListener;
        return cameraTiltShiftListener != null && cameraTiltShiftListener.getTiltShifGestureEnabled() && !this.mCameraTiltShiftListener.isEffectMenuAnimRunning() && isSupportTiltShif() && getTiltShiftGestureEnabled();
    }

    private float getSpacing(android.view.MotionEvent motionEvent) {
        float x_renamed = motionEvent.getX(0) - motionEvent.getX(1);
        float y_renamed = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) java.lang.Math.sqrt((x_renamed * x_renamed) + (y_renamed * y_renamed));
    }

    private float getDegree(android.view.MotionEvent motionEvent) {
        return (float) java.lang.Math.toDegrees(java.lang.Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }
}
