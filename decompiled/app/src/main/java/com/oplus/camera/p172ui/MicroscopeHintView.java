package com.oplus.camera.p172ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.tblplayer.monitor.ErrorCode;

/* loaded from: classes2.dex */
public class MicroscopeHintView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private LottieAnimationView f17125a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CameraUIInterface f17126b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ComboPreferences f17127c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private HandlerC3098b f17128d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f17129e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f17130f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private InterfaceC3097a f17131g;

    /* renamed from: com.oplus.camera.ui.MicroscopeHintView$PlatformImplementations.kt_3 */
    public interface InterfaceC3097a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12549a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo12550b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo12551c();
    }

    public MicroscopeHintView(Context context) {
        super(context);
        this.f17125a = null;
        this.f17126b = null;
        this.f17127c = null;
        this.f17128d = null;
        this.f17129e = 0;
        this.f17130f = false;
        this.f17131g = null;
        m18293a(context);
    }

    public MicroscopeHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17125a = null;
        this.f17126b = null;
        this.f17127c = null;
        this.f17128d = null;
        this.f17129e = 0;
        this.f17130f = false;
        this.f17131g = null;
        m18293a(context);
    }

    public MicroscopeHintView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17125a = null;
        this.f17126b = null;
        this.f17127c = null;
        this.f17128d = null;
        this.f17129e = 0;
        this.f17130f = false;
        this.f17131g = null;
        m18293a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18293a(Context context) {
        this.f17129e = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MICRO_GUIDE_ANIM_TYPE);
        this.f17128d = new HandlerC3098b(context.getMainLooper());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f17125a = (LottieAnimationView) findViewById(R.id_renamed.microscope_guide_anim);
        int OplusGLSurfaceView_13 = this.f17129e;
        if (OplusGLSurfaceView_13 == 0) {
            this.f17125a.setAnimation(R.raw.microscope_guide);
        } else if (OplusGLSurfaceView_13 == 1) {
            this.f17125a.setAnimation(R.raw.microscope_guide_lift_head);
        } else {
            this.f17125a.setAnimation(R.raw.microscope_guide);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18303a(InterfaceC3097a interfaceC3097a, CameraUIInterface cameraUIInterface, ComboPreferences comboPreferences) {
        if (this.f17130f) {
            return;
        }
        this.f17130f = true;
        this.f17126b = cameraUIInterface;
        this.f17127c = comboPreferences;
        this.f17131g = interfaceC3097a;
        this.f17128d.obtainMessage(1).sendToTarget();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18302a() {
        if (this.f17130f) {
            this.f17128d.obtainMessage(8).sendToTarget();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m18304b() {
        return this.f17130f;
    }

    /* renamed from: com.oplus.camera.ui.MicroscopeHintView$IntrinsicsJvm.kt_4 */
    public class HandlerC3098b extends Handler {
        public HandlerC3098b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (MicroscopeHintView.this.f17130f) {
                switch (message.what) {
                    case 1:
                        if (MicroscopeHintView.this.f17131g != null) {
                            MicroscopeHintView.this.f17131g.mo12549a();
                        }
                        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 <= 1; OplusGLSurfaceView_13++) {
                            if (OplusGLSurfaceView_13 == 0) {
                                obtainMessage(2).sendToTarget();
                            } else {
                                sendMessageDelayed(obtainMessage(2), OplusGLSurfaceView_13 * 7500);
                            }
                            int i2 = OplusGLSurfaceView_13 * 7500;
                            sendMessageDelayed(obtainMessage(3), i2 + 1000);
                            sendMessageDelayed(obtainMessage(4), i2 + 3483);
                            sendMessageDelayed(obtainMessage(5), i2 + 3767);
                            sendMessageDelayed(obtainMessage(6), i2 + ErrorCode.REASON_DS_PRIORITY);
                            if (1 == OplusGLSurfaceView_13) {
                                sendMessageDelayed(obtainMessage(7), (i2 + 7500) - 167);
                            }
                        }
                        break;
                    case 2:
                        MicroscopeHintView.this.f17126b.mo18070a(R.string.camera_hint_microscope_step1, -1, false, false, true);
                        break;
                    case 3:
                        MicroscopeHintView.this.f17125a.m5507a();
                        break;
                    case 4:
                        MicroscopeHintView.this.f17126b.mo18067a(R.string.camera_hint_microscope_step1);
                        break;
                    case 5:
                        int i3 = MicroscopeHintView.this.f17129e;
                        if (i3 == 0) {
                            MicroscopeHintView.this.f17126b.mo18070a(R.string.camera_hint_microscope_step2, -1, false, false, true);
                            break;
                        } else if (i3 == 1) {
                            MicroscopeHintView.this.f17126b.mo18070a(R.string.camera_hint_microscope_step2_lift_head, -1, false, false, true);
                            break;
                        }
                        break;
                    case 6:
                        int i4 = MicroscopeHintView.this.f17129e;
                        if (i4 == 0) {
                            MicroscopeHintView.this.f17126b.mo18067a(R.string.camera_hint_microscope_step2);
                            break;
                        } else if (i4 == 1) {
                            MicroscopeHintView.this.f17126b.mo18067a(R.string.camera_hint_microscope_step2_lift_head);
                            break;
                        }
                        break;
                    case 7:
                        MicroscopeHintView.this.f17130f = false;
                        if (MicroscopeHintView.this.f17131g != null) {
                            MicroscopeHintView.this.f17131g.mo12550b();
                        }
                        MicroscopeHintView.this.f17127c.edit().putBoolean(CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, false).apply();
                        break;
                    case 8:
                        MicroscopeHintView.this.f17130f = false;
                        if (MicroscopeHintView.this.f17131g != null) {
                            MicroscopeHintView.this.f17131g.mo12551c();
                        }
                        MicroscopeHintView.this.f17125a.m5518e();
                        MicroscopeHintView.this.f17125a.setProgress(0.0f);
                        MicroscopeHintView.this.f17128d.removeCallbacksAndMessages(null);
                        MicroscopeHintView.this.f17126b.mo18067a(R.string.camera_hint_microscope_step1);
                        int i5 = MicroscopeHintView.this.f17129e;
                        if (i5 == 0) {
                            MicroscopeHintView.this.f17126b.mo18067a(R.string.camera_hint_microscope_step2);
                            break;
                        } else if (i5 == 1) {
                            MicroscopeHintView.this.f17126b.mo18067a(R.string.camera_hint_microscope_step2_lift_head);
                            break;
                        }
                        break;
                }
            }
        }
    }
}
