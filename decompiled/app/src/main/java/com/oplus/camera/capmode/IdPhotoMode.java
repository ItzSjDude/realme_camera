package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import com.arcsoft.camera.wideselfie.ArcWideSelfieDef;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.util.Util;

/* compiled from: IdPhotoMode.java */
/* renamed from: com.oplus.camera.capmode.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class IdPhotoMode extends CommonCapMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f12908g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f12909h;

    /* renamed from: OplusGLSurfaceView_13 */
    private long f12910i;

    /* renamed from: OplusGLSurfaceView_15 */
    private long f12911j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f12912k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f12913l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Handler f12914m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f12915n;

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        return ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_IDPHOTO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return ArcWideSelfieDef.ResultCode.AWS_MWARN_MOVE_SLOPE_TO_DOWN;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportFaceView() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isNightAlgoCaptureTriggered() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isSatOpen() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateDimHintView(boolean z) {
    }

    public IdPhotoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12908g = 0;
        this.f12909h = 0;
        this.f12910i = 0L;
        this.f12911j = 0L;
        this.f12912k = false;
        this.f12913l = 0;
        this.f12914m = null;
        this.f12915n = false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.mCameraUIInterface.mo18177b(R.string.camera_mode_more);
        this.f12912k = this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, false);
        if (this.f12914m == null) {
            this.f12914m = new Handler() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_14.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 != 1) {
                        if (OplusGLSurfaceView_13 != 2) {
                            if (OplusGLSurfaceView_13 != 3) {
                                return;
                            }
                            IdPhotoMode.this.f12915n = true;
                            return;
                        } else {
                            if (IdPhotoMode.this.mCameraUIInterface != null && IdPhotoMode.this.f12909h != 0) {
                                IdPhotoMode.this.mCameraUIInterface.mo18067a(IdPhotoMode.this.f12909h);
                            }
                            IdPhotoMode.this.f12909h = 0;
                            return;
                        }
                    }
                    if (IdPhotoMode.this.mCameraUIInterface != null && IdPhotoMode.this.f12909h != 0 && R.string.camera_id_photo_mode_no_faces_retake != IdPhotoMode.this.f12909h) {
                        IdPhotoMode.this.mCameraUIInterface.mo18067a(IdPhotoMode.this.f12909h);
                    }
                    boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                    int i2 = message.arg1;
                    IdPhotoMode.this.m12490a(i2, zBooleanValue, message.arg2);
                    if (zBooleanValue) {
                        return;
                    }
                    IdPhotoMode.this.m12489a(i2);
                }
            };
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return CameraUIInterface.KEY_IDPHOTO_CUSTOM_BEAUTY;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isIdPhotoOpen() {
        return getSupportFunction(CameraFunction.ID_PHOTO);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.m19235c("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return Util.m24378b(c2698h.m13258a(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, double IntrinsicsJvm.kt_5) {
        return super.getPreviewSize(c2698h, 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, String str) {
        return super.getPreviewSize(c2698h, 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        return super.getPreviewSize(c2698h, 1.3333333333333333d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0162  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.IdPhotoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED.equals(str)) {
            this.f12912k = sharedPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, false);
            if (this.f12912k) {
                this.mCameraUIInterface.mo18231j(true);
            }
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.mCameraUIInterface.mo18231j(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        this.f12915n = false;
        if (this.f12909h != 0) {
            m12497b();
            this.f12914m.removeMessages(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult r5) {
        /*
            r4 = this;
            super.onPreviewCaptureResult(r5)
            boolean r0 = r4.mbPaused
            if (r0 != 0) goto Ld1
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r0 = r4.mCameraInterface
            if (r0 == 0) goto Ld1
            boolean r0 = r4.f12912k
            if (r0 == 0) goto Ld1
            boolean r0 = r4.f12915n
            if (r0 == 0) goto Ld1
            android.hardware.camera2.CaptureResult r0 = r5.getCaptureResult()
            android.hardware.camera2.CaptureResult$Key<int[]> r1 = com.oplus.camera.p141e.CameraMetadataKey.f13259Y
            java.lang.Object r0 = com.oplus.camera.p141e.CameraMetadataKey.m13005a(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L37
            boolean r3 = r0 instanceof int[]
            if (r3 == 0) goto L37
            int[] r0 = (int[]) r0
            r0 = r0[r2]
            r4.mFlashTrigger = r0
            int r0 = r4.mFlashTrigger
            if (r1 != r0) goto L37
            boolean r0 = r4.mbAutoFlash
            if (r0 != 0) goto L37
            r0 = 2131755516(0x7f1001fc, float:1.9141913E38)
            goto L38
        L37:
            r0 = r2
        L38:
            android.hardware.camera2.CaptureResult r5 = r5.getCaptureResult()
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.STATISTICS_FACES
            java.lang.Object r5 = r5.get(r3)
            android.hardware.camera2.params.Face[] r5 = (android.hardware.camera2.params.Face[]) r5
            if (r5 == 0) goto L48
            int r5 = r5.length
            goto L49
        L48:
            r5 = r2
        L49:
            r4.f12913l = r5
            if (r0 != 0) goto L5a
            int r5 = r4.f12913l
            if (r5 != 0) goto L55
            r0 = 2131755517(0x7f1001fd, float:1.9141916E38)
            goto L5a
        L55:
            if (r5 <= r1) goto L5a
            r0 = 2131755514(0x7f1001fa, float:1.914191E38)
        L5a:
            com.oplus.camera.ui.CameraUIInterface r5 = r4.mCameraUIInterface
            java.lang.String r5 = r5.mo18237l()
            com.oplus.camera.ui.CameraUIInterface r3 = r4.mCameraUIInterface
            int r3 = r3.mo18241m()
            if (r3 == 0) goto L86
            if (r0 != 0) goto L78
            android.os.Handler r5 = r4.f12914m
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto Ld1
            android.os.Handler r4 = r4.f12914m
            r4.removeMessages(r1)
            goto Ld1
        L78:
            android.os.Handler r5 = r4.f12914m
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto Ld1
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.m12491a(r0, r2, r5, r2)
            goto Ld1
        L86:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 == 0) goto La5
            if (r0 != 0) goto L9f
            r4.m12497b()
            android.os.Handler r5 = r4.f12914m
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto Ld1
            android.os.Handler r4 = r4.f12914m
            r4.removeMessages(r1)
            goto Ld1
        L9f:
            r4.f12909h = r2
            r4.m12491a(r0, r2, r2, r2)
            goto Ld1
        La5:
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto Ld1
            if (r0 != 0) goto Lc2
            int r5 = r4.f12909h
            if (r5 == 0) goto Lc2
            r4.m12497b()
            android.os.Handler r5 = r4.f12914m
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto Ld1
            android.os.Handler r4 = r4.f12914m
            r4.removeMessages(r1)
            goto Ld1
        Lc2:
            int r5 = r4.f12909h
            if (r5 == r0) goto Ld1
            android.os.Handler r5 = r4.f12914m
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto Ld1
            r4.m12491a(r0, r2, r2, r2)
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.IdPhotoMode.onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback$CameraPreviewResult):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12491a(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        Message messageObtainMessage = this.f12914m.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.arg2 = i3;
        messageObtainMessage.obj = Boolean.valueOf(z);
        this.f12914m.sendMessageDelayed(messageObtainMessage, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12489a(int OplusGLSurfaceView_13) {
        String str;
        switch (OplusGLSurfaceView_13) {
            case R.string.camera_id_photo_mode_more_faces /* 2131755514 */:
                str = "more_face";
                break;
            case R.string.camera_id_photo_mode_more_faces_retake /* 2131755515 */:
            default:
                return;
            case R.string.camera_id_photo_mode_need_more_light /* 2131755516 */:
                str = ReminderMsgData.CODE_FLASH_ON;
                break;
            case R.string.camera_id_photo_mode_no_faces /* 2131755517 */:
                str = "no_face";
                break;
        }
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.mActivity, true);
        if (this.mCameraInterface != null) {
            reminderMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        }
        reminderMsgData.mReminderCodeValue = str;
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_ADVICE;
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12494a() {
        int OplusGLSurfaceView_13 = this.f12908g;
        if (OplusGLSurfaceView_13 == 0) {
            m12491a(R.string.camera_id_photo_mode_no_faces_retake, true, 1000, 2000);
            return false;
        }
        if (OplusGLSurfaceView_13 <= 1) {
            return true;
        }
        m12491a(R.string.camera_id_photo_mode_more_faces_retake, true, 1000, 2000);
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z) {
        InverseManager.INS.setPositionRatio(this.mActivity, 0.5f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12490a(int OplusGLSurfaceView_13, boolean z, int i2) {
        if (this.mCameraUIInterface == null || this.f12911j >= System.currentTimeMillis()) {
            return;
        }
        this.f12910i = System.currentTimeMillis();
        this.f12911j = this.f12910i + i2;
        this.f12909h = OplusGLSurfaceView_13;
        this.mCameraUIInterface.mo18072a(OplusGLSurfaceView_13, 0, z, true, false, false, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12497b() {
        Message messageObtainMessage = this.f12914m.obtainMessage();
        messageObtainMessage.what = 2;
        long jCurrentTimeMillis = 1000 - (System.currentTimeMillis() - this.f12910i);
        this.f12914m.sendMessageDelayed(messageObtainMessage, jCurrentTimeMillis > 0 ? jCurrentTimeMillis : 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        Uri uriMo18151ao;
        super.onAfterPictureTaken(bArr, z);
        resetAfterPictureTaken(false, z);
        if (this.mbPaused || !m12494a() || (uriMo18151ao = this.mCameraUIInterface.mo18151ao()) == null) {
            return;
        }
        Intent intent = new Intent("oplus.intent.action.galleryfeature");
        intent.putExtra("feature", "aiidphoto");
        intent.putExtra("from", this.mActivity.getPackageName());
        intent.putExtra("aiidphotouri", uriMo18151ao);
        try {
            try {
                this.mActivity.startActivity(intent);
                this.mActivity.overridePendingTransition(1 == this.mActivity.getResources().getConfiguration().getLayoutDirection() ? R.anim.gallery_in_rtl : R.anim.gallery_in, 0);
            } catch (Throwable th) {
                CameraLog.m12965d("IdPhotoMode", "onAfterPictureTaken, start gallery error!", th);
                if (this.mbDisplayOnLock) {
                }
            }
            if (this.mbDisplayOnLock) {
                this.mActivity.finish();
            }
            this = "onAfterPictureTaken, uri: " + uriMo18151ao;
            CameraLog.m12966e("IdPhotoMode", this);
        } catch (Throwable th2) {
            if (this.mbDisplayOnLock) {
                this.mActivity.finish();
            }
            throw th2;
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        this.f12908g = this.f12913l;
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getExifCameraMode() {
        return this.f12908g != 1 ? ApsConstant.CAPTURE_MODE_COMMON : ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        if (this.mbPaused || this.mCameraUIInterface == null) {
            return;
        }
        super.onAfterStartPreview(z);
        if (!this.mCameraUIInterface.mo18057R() && this.f12912k) {
            this.mCameraUIInterface.mo18231j(true);
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$OplusGLSurfaceView_14$7r-zgZmBNCoqD1744u2G_LH-TuI
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12498c();
            }
        });
        Handler handler = this.f12914m;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(3, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m12498c() {
        if (this.mbPaused || this.mPreferences == null || this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, false) || this.mCameraUIInterface.mo18057R()) {
            return;
        }
        this.mCameraUIInterface.mo18234k(4);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        super.onDeInitCameraMode(str);
        this.mCameraUIInterface.mo18108a(true, true, true);
        this.mCameraUIInterface.mo18203e(4, true);
        this.mCameraUIInterface.mo18231j(false);
        this.f12909h = 0;
        this.f12910i = 0L;
        this.f12915n = false;
        m12497b();
        if (this.f12914m.hasMessages(1)) {
            this.f12914m.removeMessages(1);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        this.mCameraUIInterface.mo18231j(false);
        this.mCameraUIInterface.mo18203e(4, true);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        this.mCameraUIInterface.mo18231j(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(CameraApsDecision cameraApsDecision) {
        return cameraApsDecision != null && cameraApsDecision.mMultiFrameCount > 0;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (getIsCapturingState()) {
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(c2693c);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }
}
