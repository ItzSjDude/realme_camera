package com.oplus.camera.tiltshift;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;

/* loaded from: classes2.dex */
public class TiltShiftManager {
    private static final long DELAY_RESET_ADJUSTING_STATE_DURATION = 300;
    private static final float INIT_TILT_SHIFT_RADIUS = 300.0f;
    private static final int MSG_RESET_ADJUSTING_STATE = 1;
    private static final String TAG = "TiltShiftManager";
    private Activity mActivity;
    private CameraInterface mCameraInterface;
    private CameraUIInterface mCameraUIInterface;
    private ComboPreferences mPreferences;
    private ViewGroup mPreviewLayout;
    private float mMaxTiltShiftRadiusRatio = 0.5f;
    private float mMinTiltShiftRadiusRatio = 0.1f;
    private float mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
    private double mCurrentTiltShiftCenterX = 1.0d;
    private double mCurrentTiltShiftCenterY = 1.0d;
    private double mCurrentTiltShiftRotation = 0.0d;
    private double mCurrentTiltShiftDegree = 0.0d;
    private boolean mbCurrentTiltShiftAdjusting = false;
    private boolean mbCircle = false;
    private PointF mPoint1 = null;
    private PointF mPoint2 = null;
    private PointF mPoint3 = null;
    private PointF mPoint4 = null;
    private int mPreviewHeight = 0;
    private int mPreviewWidth = 0;
    private int mPreviewAreaTop = 0;
    private int mPreviewAreaLeft = 0;
    private int mPreviewAreaRight = 0;
    private int mPreviewAreaBottom = 0;
    private int mPreviewAreaWidth = 0;
    private int mPreviewAreaHeight = 0;
    private Size mPreviewSize = null;
    private Rect mPreviewArea = null;
    private CameraTiltShiftListener mCameraTiltShiftListener = null;
    private Handler mMainHandler = null;
    private TiltShiftParam mTiltShiftParam = new TiltShiftParam();
    private Mode mGestureMode = Mode.NONE;
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

        void setTiltShiftParams(TiltShiftParam tiltShiftParam);
    }

    enum Mode {
        NONE,
        SCALE,
        MOVE,
        ROTATE
    }

    public TiltShiftManager(Activity activity, ComboPreferences comboPreferences, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        this.mActivity = null;
        this.mPreviewLayout = null;
        this.mPreferences = null;
        this.mCameraInterface = null;
        this.mCameraUIInterface = null;
        this.mActivity = activity;
        this.mPreferences = comboPreferences;
        this.mCameraInterface = interfaceC2646a;
        this.mCameraUIInterface = cameraUIInterface;
        this.mPreviewLayout = (ViewGroup) this.mActivity.findViewById(R.id_renamed.frame_layout);
        initMainHandler();
    }

    private void initMainHandler() {
        this.mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.tiltshift.TiltShiftManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                TiltShiftManager.this.resetAjustingState();
            }
        };
    }

    public void setCameraTiltShiftListener(CameraTiltShiftListener cameraTiltShiftListener) {
        this.mCameraTiltShiftListener = cameraTiltShiftListener;
    }

    public void onPause() {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void initialize(Size size, Rect rect) {
        CameraLog.m12954a(TAG, "initialize, previewSize: " + size + ", previewArea: " + rect);
        this.mPreviewSize = size;
        this.mPreviewArea = rect;
        Rect rect2 = this.mPreviewArea;
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
        int OplusGLSurfaceView_13 = this.mPreviewAreaRight;
        int i2 = this.mPreviewAreaLeft;
        this.mCurrentTiltShiftCenterX = (OplusGLSurfaceView_13 - i2) / 2;
        int i3 = this.mPreviewAreaBottom;
        int i4 = this.mPreviewAreaTop;
        this.mCurrentTiltShiftCenterY = (i3 - i4) / 2;
        this.mPreviewWidth = OplusGLSurfaceView_13 - i2;
        this.mPreviewHeight = i3 - i4;
        this.mCurrentTiltShiftDegree = 0.0d;
        this.mCurrentTiltShiftRotation = Math.toRadians(this.mCurrentTiltShiftDegree);
        this.mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
        CameraLog.m12954a(TAG, "initTiftShiftPoint, mCurrentTiltShiftCenterX: " + this.mCurrentTiltShiftCenterX + ", mCurrentTiltShiftCenterY: " + this.mCurrentTiltShiftCenterY);
        calculateTiftShiftPoint();
    }

    private void reCalculateTiftShiftCenter() {
        this.mCurrentTiltShiftCenterX = (((this.mPoint1.x + this.mPoint2.x) + this.mPoint3.x) + this.mPoint4.x) / 4.0f;
        this.mCurrentTiltShiftCenterY = (((this.mPoint1.y + this.mPoint2.y) + this.mPoint3.y) + this.mPoint4.y) / 4.0f;
        calculateTiftShiftPoint();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0160  */
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

    public TiltShiftParam getTiltShiftCaptureParam() {
        TiltShiftParam tiltShiftParam = new TiltShiftParam(this.mTiltShiftParam);
        float[] transformedCaptureCenterPoints = getTransformedCaptureCenterPoints(new float[]{this.mTiltShiftParam.getCenterY(), this.mTiltShiftParam.getCenterX()});
        tiltShiftParam.setCenterX(transformedCaptureCenterPoints[0]);
        tiltShiftParam.setCenterY(transformedCaptureCenterPoints[1]);
        tiltShiftParam.setAngle(getCaptureDegree());
        return tiltShiftParam;
    }

    private float getCaptureDegree() {
        double IntrinsicsJvm.kt_5 = this.mCurrentTiltShiftDegree;
        return (float) (IntrinsicsJvm.kt_5 <= 90.0d ? IntrinsicsJvm.kt_5 + 90.0d : IntrinsicsJvm.kt_5 - 90.0d);
    }

    private float[] getTransformedCaptureCenterPoints(float[] fArr) {
        int iMin = Math.min(this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
        int iMax = Math.max(this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        matrix.postTranslate(iMax / 2, (-iMin) / 2);
        matrix.postScale(-1.0f, 1.0f);
        float[] fArr2 = new float[2];
        matrix.mapPoints(fArr2, fArr);
        return fArr2;
    }

    public void switchTiltShiftType(boolean z) {
        this.mbCircle = z;
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
            int OplusGLSurfaceView_13 = this.mPreviewAreaRight;
            int i2 = this.mPreviewAreaLeft;
            this.mCurrentTiltShiftCenterX = (OplusGLSurfaceView_13 - i2) / 2;
            int i3 = this.mPreviewAreaBottom;
            int i4 = this.mPreviewAreaTop;
            this.mCurrentTiltShiftCenterY = (i3 - i4) / 2;
            this.mPreviewWidth = OplusGLSurfaceView_13 - i2;
            this.mPreviewHeight = i3 - i4;
        }
        this.mCurrentTiltShiftRotation = Math.toRadians(0.0d);
        this.mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
    }

    private void clampInPreviewArea(PointF pointF) {
        if (pointF.x < 0.0f) {
            pointF.x = 0.0f;
        }
        if (pointF.y < 0.0f) {
            pointF.y = 0.0f;
        }
        float COUIBaseListPopupWindow_12 = pointF.x;
        int OplusGLSurfaceView_13 = this.mPreviewWidth;
        if (COUIBaseListPopupWindow_12 > OplusGLSurfaceView_13) {
            pointF.x = OplusGLSurfaceView_13;
        }
        float f2 = pointF.y;
        int i2 = this.mPreviewHeight;
        if (f2 > i2) {
            pointF.y = i2;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (needDispatchTouchEvent()) {
            return operateTouchEvent(motionEvent);
        }
        return false;
    }

    public void setPreviewSize(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a(TAG, "setPreviewSize, previewWidth: " + OplusGLSurfaceView_13 + ", previewHeight: " + i2);
        if (this.mPreviewWidth == OplusGLSurfaceView_13 && this.mPreviewHeight == i2) {
            return;
        }
        this.mPreviewWidth = OplusGLSurfaceView_13;
        this.mPreviewHeight = i2;
    }

    public void onDestroy() {
        CameraLog.m12954a(TAG, "onDestroy");
        resetTiltShiftParams();
        this.mActivity = null;
        this.mPreferences = null;
        this.mCameraInterface = null;
        this.mCameraTiltShiftListener = null;
    }

    public boolean isPointInTiltShift(float COUIBaseListPopupWindow_12, float f2) {
        if (this.mPreviewArea == null) {
            return false;
        }
        float f3 = COUIBaseListPopupWindow_12 - this.mPreviewAreaLeft;
        float f4 = f2 - this.mPreviewAreaTop;
        if (this.mbCircle) {
            return isPointInTiltShiftCircle(f3, f4);
        }
        return isPointInTiltShiftRect(f3, f4);
    }

    private boolean isPointInTiltShiftCircle(float COUIBaseListPopupWindow_12, float f2) {
        double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
        double d2 = this.mCurrentTiltShiftCenterX;
        double d3 = (IntrinsicsJvm.kt_5 - d2) * (IntrinsicsJvm.kt_5 - d2);
        double d4 = f2;
        double d5 = this.mCurrentTiltShiftCenterY;
        return Math.sqrt(d3 + ((d4 - d5) * (d4 - d5))) <= ((double) this.mCurrentTiltShiftRadius);
    }

    private boolean isPointInTiltShiftRect(float COUIBaseListPopupWindow_12, float f2) {
        RectF rectF = new RectF();
        float fSqrt = ((float) Math.sqrt(Math.pow(this.mPreviewWidth, 2.0d) + Math.pow(this.mPreviewHeight, 2.0d))) * 2.0f;
        float f3 = this.mCurrentTiltShiftRadius * 2.0f;
        double IntrinsicsJvm.kt_5 = this.mCurrentTiltShiftCenterX;
        float f4 = fSqrt / 2.0f;
        double d2 = this.mCurrentTiltShiftCenterY;
        float f5 = f3 / 2.0f;
        rectF.set(((float) IntrinsicsJvm.kt_5) - f4, ((float) d2) - f5, ((float) IntrinsicsJvm.kt_5) + f4, ((float) d2) + f5);
        float[] fArr = {rectF.left, rectF.top};
        float[] fArr2 = {rectF.left, rectF.bottom};
        float[] fArr3 = {rectF.right, rectF.bottom};
        float[] fArr4 = {rectF.right, rectF.top};
        Matrix matrix = new Matrix();
        matrix.setRotate((int) this.mCurrentTiltShiftDegree, rectF.centerX(), rectF.centerY());
        matrix.mapPoints(fArr);
        matrix.mapPoints(fArr2);
        matrix.mapPoints(fArr3);
        matrix.mapPoints(fArr4);
        float f6 = ((fArr2[0] - fArr[0]) * (f2 - fArr[1])) - ((fArr2[1] - fArr[1]) * (COUIBaseListPopupWindow_12 - fArr[0]));
        float f7 = ((fArr3[0] - fArr2[0]) * (f2 - fArr2[1])) - ((fArr3[1] - fArr2[1]) * (COUIBaseListPopupWindow_12 - fArr2[0]));
        float f8 = ((fArr4[0] - fArr3[0]) * (f2 - fArr3[1])) - ((fArr4[1] - fArr3[1]) * (COUIBaseListPopupWindow_12 - fArr3[0]));
        float f9 = ((fArr[0] - fArr4[0]) * (f2 - fArr4[1])) - ((fArr[1] - fArr4[1]) * (COUIBaseListPopupWindow_12 - fArr4[0]));
        if ((f6 > 0.0f && f7 > 0.0f && f8 > 0.0f && f9 > 0.0f) || (f6 < 0.0f && f7 < 0.0f && f8 < 0.0f && f9 < 0.0f)) {
            CameraLog.m12962c(TAG, "isPointInTiltShiftRect true");
            return true;
        }
        CameraLog.m12962c(TAG, "isPointInTiltShiftRect false");
        return false;
    }

    private boolean isPointInPreviewRect(int OplusGLSurfaceView_13, int i2) {
        if (new Rect(this.mPreviewLayout.getLeft(), this.mPreviewLayout.getTop(), this.mPreviewLayout.getRight(), this.mPreviewLayout.getBottom()).contains(OplusGLSurfaceView_13, i2)) {
            return getTouchEnable(OplusGLSurfaceView_13, i2);
        }
        return false;
    }

    private boolean getTouchEnable(int OplusGLSurfaceView_13, int i2) {
        return i2 >= this.mCameraUIInterface.mo18149am() && i2 <= this.mCameraUIInterface.mo18150an();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0115  */
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
        CameraTiltShiftListener cameraTiltShiftListener = this.mCameraTiltShiftListener;
        if (cameraTiltShiftListener != null) {
            return cameraTiltShiftListener.getSupportTiltShif();
        }
        return false;
    }

    private boolean getTiltShiftGestureEnabled() {
        return "off".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off"));
    }

    private boolean needDispatchTouchEvent() {
        CameraTiltShiftListener cameraTiltShiftListener = this.mCameraTiltShiftListener;
        return cameraTiltShiftListener != null && cameraTiltShiftListener.getTiltShifGestureEnabled() && !this.mCameraTiltShiftListener.isEffectMenuAnimRunning() && isSupportTiltShif() && getTiltShiftGestureEnabled();
    }

    private float getSpacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private float getDegree(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }
}
