package com.oplus.camera.p172ui.inverse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseData;
import com.oplus.camera.p172ui.inverse.InverseViewHolder;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.CameraPreviewUI;
import java.util.HashMap;
import java.util.Map;

/* compiled from: InverseManager.java */
/* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public enum InverseManager {
    INS;

    private static final int ANIMATION_DURATION = 300;
    private static final int AUTO_INVERSE_DELAY = 500;
    private static final float BRIGHTNESS_MAX = 100.0f;
    private static final int MSG_INVERSE_DELAY = 1;
    private static final int MSG_POST_INVERSE = 2;
    private static final int SEND_MSG_CD = 3000;
    private static final String TAG = InverseManager.class.getSimpleName();
    private InverseViewHolder mInverseViewHolder = new InverseViewHolder();
    private IntrinsicsJvm.kt_4 mHandler = null;
    private Map<Integer, Boolean> mInverseMap = new HashMap();
    private int mInverseColor = 0;
    private Interpolator mInterpolator = null;
    private ValueAnimator mAnimator = null;
    private volatile boolean mbAnimationRunning = false;
    private final Object mLock = new Object();
    private Boolean mbDelayInverseColor = null;
    private long mDelayInverseTs = 0;
    private float mBrightness = 0.0f;
    private float mVideoBrightness = 0.0f;
    private float mCurrentHighBrightnessValue = 0.0f;
    private int mThreshold = 0;
    private int mThresholdRecover = 0;
    private boolean mbExecuteDelayMsg = true;

    /* compiled from: InverseManager.java */
    /* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void call();
    }

    /* compiled from: InverseManager.java */
    /* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        void call(InverseMaskView inverseMaskView);
    }

    InverseManager() {
    }

    public void init(Context context, int OplusGLSurfaceView_13, boolean z, int i2, int i3, int i4, int i5, int i6) {
        CameraLog.m12959b(TAG, "init, context.hashCode(): " + context.hashCode() + ", cameraEntryType: " + OplusGLSurfaceView_13);
        if (1 == OplusGLSurfaceView_13 && i4 > 0 && !z) {
            this.mInverseMap.put(Integer.valueOf(context.hashCode()), false);
            this.mInverseColor = i6;
            this.mBrightness = i2 / BRIGHTNESS_MAX;
            this.mVideoBrightness = i3 / BRIGHTNESS_MAX;
            this.mThreshold = i4;
            this.mThresholdRecover = i5;
            this.mInterpolator = AnimationUtils.loadInterpolator(context, R.anim.inverse_interpolator);
        }
        if (this.mHandler == null) {
            this.mHandler = new IntrinsicsJvm.kt_4();
        }
        CameraLog.m12959b(TAG, "init, X" + context.hashCode() + ", cameraEntryType: " + OplusGLSurfaceView_13 + ", mInverseViewMap.size(): " + this.mInverseViewHolder.m20152a());
    }

    public int getInverseColor() {
        return this.mInverseColor;
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public float getVideoBrightness() {
        return this.mVideoBrightness;
    }

    public float getCurrentHighBrightnessValue() {
        return this.mCurrentHighBrightnessValue;
    }

    public void setCurrentHighBrightnessValue(float COUIBaseListPopupWindow_12) {
        this.mCurrentHighBrightnessValue = COUIBaseListPopupWindow_12;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int getThresholdRecover() {
        return this.mThresholdRecover;
    }

    public void release(Context context) {
        CameraLog.m12959b(TAG, "release, context.hashCode(): " + context.hashCode());
        this.mInverseViewHolder.m20153a(context);
        this.mInverseMap.remove(Integer.valueOf(context.hashCode()));
        this.mbDelayInverseColor = null;
        CameraLog.m12959b(TAG, "release X");
    }

    public boolean setInverseDelay(Context context, boolean z, boolean z2, PlatformImplementations.kt_3 aVar) {
        Boolean bool;
        if (!this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) || System.currentTimeMillis() - this.mDelayInverseTs < 3000) {
            return false;
        }
        boolean z3 = !this.mHandler.hasMessages(1) ? isInverseColor(context.hashCode()) == z : (bool = this.mbDelayInverseColor) != null && bool.booleanValue() == z;
        if (z3) {
            this.mHandler.removeMessages(1);
            Message messageObtainMessage = this.mHandler.obtainMessage(1, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), aVar});
            messageObtainMessage.arg1 = context.hashCode();
            this.mHandler.sendMessageDelayed(messageObtainMessage, 500L);
            this.mbDelayInverseColor = Boolean.valueOf(z);
        }
        return z3;
    }

    public void setInverseColor(Context context, boolean z, boolean z2) {
        setInverseColor(context.hashCode(), z, z2);
    }

    public boolean isInverseColor(int OplusGLSurfaceView_13) {
        Boolean bool = this.mInverseMap.get(Integer.valueOf(OplusGLSurfaceView_13));
        return bool != null && bool.booleanValue();
    }

    public void setInverseColor(final int OplusGLSurfaceView_13, final boolean z, boolean z2) {
        CameraLog.m12959b(TAG, "setInverseColor, contextHash: " + OplusGLSurfaceView_13 + ", inverseColor: " + z + ", showAnimation: " + z2);
        if (!this.mInverseMap.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            CameraLog.m12959b(TAG, "setInverseColor, return, contextHash: " + OplusGLSurfaceView_13);
            return;
        }
        this.mHandler.removeMessages(1);
        this.mbDelayInverseColor = null;
        this.mDelayInverseTs = System.currentTimeMillis();
        if (isInverseColor(OplusGLSurfaceView_13) == z) {
            CameraLog.m12959b(TAG, "setInverseColor, color return, contextHash: " + OplusGLSurfaceView_13);
            return;
        }
        if (this.mbAnimationRunning) {
            CameraLog.m12959b(TAG, "setInverseColor, animation running, contextHash: " + OplusGLSurfaceView_13);
            this.mAnimator.cancel();
        }
        this.mInverseMap.put(Integer.valueOf(OplusGLSurfaceView_13), Boolean.valueOf(z));
        if (z2) {
            this.mAnimator = null;
            if (z) {
                this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            } else {
                this.mAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
            }
            this.mAnimator.setInterpolator(this.mInterpolator);
            this.mAnimator.setDuration(300L);
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$ZEKwizAYlwSTrBKb8Y1P6mBDVw8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.lambda$setInverseColor$1$COUIBaseListPopupWindow_8(OplusGLSurfaceView_13, z, valueAnimator);
                }
            });
            this.mAnimator.addListener(new COUIBaseListPopupWindow_2(OplusGLSurfaceView_13, z));
            this.mbAnimationRunning = true;
            this.mAnimator.start();
        } else {
            synchronized (this.mLock) {
                CameraLog.m12959b(TAG, "setInverseColor, no animation, mbAnimationRunning: " + this.mbAnimationRunning);
                this.mInverseViewHolder.m20154a(new InverseViewHolder.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$NmApdipZ8SULLMeyPpwuAOZmAfM
                    @Override // com.oplus.camera.p172ui.inverse.InverseViewHolder.PlatformImplementations.kt_3
                    public final boolean call(Object obj, InverseData c3225c) {
                        return this.COUIBaseListPopupWindow_12$0.lambda$setInverseColor$2$COUIBaseListPopupWindow_8(OplusGLSurfaceView_13, z, obj, c3225c);
                    }
                });
                CameraLog.m12959b(TAG, "setInverseColor, no animation X, mbAnimationRunning: " + this.mbAnimationRunning);
            }
        }
        CameraLog.m12959b(TAG, "setInverseColor X, contextHash: " + OplusGLSurfaceView_13);
    }

    public /* synthetic */ void lambda$setInverseColor$1$COUIBaseListPopupWindow_8(final int OplusGLSurfaceView_13, final boolean z, ValueAnimator valueAnimator) {
        final float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        synchronized (this.mLock) {
            CameraLog.m12959b(TAG, "setInverseColor, animation, mbAnimationRunning: " + this.mbAnimationRunning);
            if (this.mbAnimationRunning) {
                this.mInverseViewHolder.m20154a(new InverseViewHolder.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$2eRCD4iz2S25zIIgqQYyc22IGhc
                    @Override // com.oplus.camera.p172ui.inverse.InverseViewHolder.PlatformImplementations.kt_3
                    public final boolean call(Object obj, InverseData c3225c) {
                        return this.COUIBaseListPopupWindow_12$0.lambda$setInverseColor$0$COUIBaseListPopupWindow_8(OplusGLSurfaceView_13, fFloatValue, z, obj, c3225c);
                    }
                });
                CameraLog.m12959b(TAG, "setInverseColor, animation X, mbAnimationRunning: " + this.mbAnimationRunning);
            }
        }
    }

    public /* synthetic */ boolean lambda$setInverseColor$0$COUIBaseListPopupWindow_8(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, boolean z, Object obj, InverseData c3225c) {
        if (OplusGLSurfaceView_13 == c3225c.f18745a) {
            int i2 = XPanMode_2.f18754a[c3225c.f18749e.ordinal()];
            if (i2 != 2) {
                boolean z2 = true;
                if (i2 == 3) {
                    if (z) {
                        ((InverseMaskView) obj).setInverseColor(true);
                    }
                    ((InverseMaskView) obj).setAlpha(COUIBaseListPopupWindow_12);
                } else if (i2 == 4) {
                    CameraPreviewUI viewOnLayoutChangeListenerC3444g = (CameraPreviewUI) obj;
                    if (COUIBaseListPopupWindow_12 <= 0.0f && !z) {
                        z2 = false;
                    }
                    viewOnLayoutChangeListenerC3444g.m23356a(z2, getColorWithAlpha(this.mInverseColor, COUIBaseListPopupWindow_12));
                }
            } else {
                c3225c.f18748d = COUIBaseListPopupWindow_12;
                ((View) obj).setBackgroundColor(c3225c.f18746b);
            }
        }
        return false;
    }

    /* compiled from: InverseManager.java */
    /* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_8$1, reason: invalid class name */
    class COUIBaseListPopupWindow_2 extends AnimatorListenerAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ int f18751a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ boolean f18752b;

        COUIBaseListPopupWindow_2(int OplusGLSurfaceView_13, boolean z) {
            this.f18751a = OplusGLSurfaceView_13;
            this.f18752b = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            InverseManager.this.mbAnimationRunning = false;
            InverseViewHolder c3228f = InverseManager.this.mInverseViewHolder;
            final int OplusGLSurfaceView_13 = this.f18751a;
            final boolean z = this.f18752b;
            c3228f.m20154a(new InverseViewHolder.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$1$W1sVRVfWBsfr2cFBdKzfsC9KrZM
                @Override // com.oplus.camera.p172ui.inverse.InverseViewHolder.PlatformImplementations.kt_3
                public final boolean call(Object obj, InverseData c3225c) {
                    return InverseManager.COUIBaseListPopupWindow_2.m20151c(OplusGLSurfaceView_13, z, obj, c3225c);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_3 */
        public static /* synthetic */ boolean m20151c(int OplusGLSurfaceView_13, boolean z, Object obj, InverseData c3225c) {
            if (c3225c.f18749e != InverseData.PlatformImplementations.kt_3.mask || OplusGLSurfaceView_13 != c3225c.f18745a) {
                return true;
            }
            ((InverseMaskView) obj).setInverseColor(z);
            return true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InverseManager.this.mbAnimationRunning = false;
            InverseViewHolder c3228f = InverseManager.this.mInverseViewHolder;
            final int OplusGLSurfaceView_13 = this.f18751a;
            final boolean z = this.f18752b;
            c3228f.m20154a(new InverseViewHolder.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$1$URMfj-2p-yD7aA6ILT_9JgVt2TE
                @Override // com.oplus.camera.p172ui.inverse.InverseViewHolder.PlatformImplementations.kt_3
                public final boolean call(Object obj, InverseData c3225c) {
                    return InverseManager.COUIBaseListPopupWindow_2.m20150b(OplusGLSurfaceView_13, z, obj, c3225c);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public static /* synthetic */ boolean m20150b(int OplusGLSurfaceView_13, boolean z, Object obj, InverseData c3225c) {
            if (c3225c.f18749e != InverseData.PlatformImplementations.kt_3.mask || OplusGLSurfaceView_13 != c3225c.f18745a) {
                return true;
            }
            ((InverseMaskView) obj).setInverseColor(z);
            return true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            synchronized (InverseManager.this.mLock) {
                CameraLog.m12959b(InverseManager.TAG, "setInverseColor, onAnimationStart, mbAnimationRunning: " + InverseManager.this.mbAnimationRunning);
                if (InverseManager.this.mbAnimationRunning) {
                    InverseViewHolder c3228f = InverseManager.this.mInverseViewHolder;
                    final int OplusGLSurfaceView_13 = this.f18751a;
                    final boolean z = this.f18752b;
                    c3228f.m20154a(new InverseViewHolder.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$1$a0P70OsTK0EqwTy3lgJOw8c2yJU
                        @Override // com.oplus.camera.p172ui.inverse.InverseViewHolder.PlatformImplementations.kt_3
                        public final boolean call(Object obj, InverseData c3225c) {
                            return InverseManager.COUIBaseListPopupWindow_2.m20149a(OplusGLSurfaceView_13, z, obj, c3225c);
                        }
                    });
                    CameraLog.m12959b(InverseManager.TAG, "setInverseColor, onAnimationStart X, mbAnimationRunning: " + InverseManager.this.mbAnimationRunning);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public static /* synthetic */ boolean m20149a(int OplusGLSurfaceView_13, boolean z, Object obj, InverseData c3225c) {
            if (c3225c.f18749e != InverseData.PlatformImplementations.kt_3.common || OplusGLSurfaceView_13 != c3225c.f18745a) {
                return false;
            }
            try {
                ((InverseAble) obj).setInverseColor(z);
                return false;
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                CameraLog.m12959b(InverseManager.TAG, COUIBaseListPopupWindow_8.getMessage());
                return false;
            }
        }
    }

    /* compiled from: InverseManager.java */
    /* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_8$2, reason: invalid class name */
    static /* synthetic */ class XPanMode_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f18754a = new int[InverseData.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f18754a[InverseData.PlatformImplementations.kt_3.common.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18754a[InverseData.PlatformImplementations.kt_3.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18754a[InverseData.PlatformImplementations.kt_3.mask.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18754a[InverseData.PlatformImplementations.kt_3.preview.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public /* synthetic */ boolean lambda$setInverseColor$2$COUIBaseListPopupWindow_8(int OplusGLSurfaceView_13, boolean z, Object obj, InverseData c3225c) {
        if (OplusGLSurfaceView_13 != c3225c.f18745a) {
            return false;
        }
        int i2 = XPanMode_2.f18754a[c3225c.f18749e.ordinal()];
        if (i2 == 1) {
            ((InverseAble) obj).setInverseColor(z);
            return false;
        }
        if (i2 == 2) {
            c3225c.f18748d = 1.0f;
            ((View) obj).setBackgroundColor(c3225c.f18746b);
            return false;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                return false;
            }
            ((CameraPreviewUI) obj).m23356a(z, getColorWithAlpha(this.mInverseColor, 1.0f));
            return false;
        }
        InverseMaskView inverseMaskView = (InverseMaskView) obj;
        inverseMaskView.setInverseColor(z);
        inverseMaskView.setAlpha(1.0f);
        return false;
    }

    private int getColorWithAlpha(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return Color.argb((int) (Color.alpha(OplusGLSurfaceView_13) * COUIBaseListPopupWindow_12), Color.red(OplusGLSurfaceView_13), Color.green(OplusGLSurfaceView_13), Color.blue(OplusGLSurfaceView_13));
    }

    private int inverse(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, boolean z) {
        float f2;
        if (Color.alpha(OplusGLSurfaceView_13) != 0 || !z) {
            float f3 = 204.0f * COUIBaseListPopupWindow_12;
            int iAlpha = Color.alpha(OplusGLSurfaceView_13);
            f2 = (iAlpha * (1.0f - COUIBaseListPopupWindow_12)) + f3;
            float f4 = 1.0f - COUIBaseListPopupWindow_12;
            return Color.argb((int) f2, (int) ((Color.red(this.mInverseColor) * COUIBaseListPopupWindow_12) + (Color.red(OplusGLSurfaceView_13) * f4)), (int) ((Color.green(this.mInverseColor) * COUIBaseListPopupWindow_12) + (Color.green(OplusGLSurfaceView_13) * f4)), (int) ((Color.blue(this.mInverseColor) * COUIBaseListPopupWindow_12) + (Color.blue(OplusGLSurfaceView_13) * f4)));
        }
        f2 = 0.0f;
        float f42 = 1.0f - COUIBaseListPopupWindow_12;
        return Color.argb((int) f2, (int) ((Color.red(this.mInverseColor) * COUIBaseListPopupWindow_12) + (Color.red(OplusGLSurfaceView_13) * f42)), (int) ((Color.green(this.mInverseColor) * COUIBaseListPopupWindow_12) + (Color.green(OplusGLSurfaceView_13) * f42)), (int) ((Color.blue(this.mInverseColor) * COUIBaseListPopupWindow_12) + (Color.blue(OplusGLSurfaceView_13) * f42)));
    }

    public void registerBackgroundInverse(Context context, View view, boolean z) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.m20158c(view)) {
            Drawable background = view.getBackground();
            if (background instanceof ColorDrawable) {
                InverseData c3225c = new InverseData(InverseData.PlatformImplementations.kt_3.background);
                c3225c.f18745a = context.hashCode();
                c3225c.f18746b = ((ColorDrawable) background).getColor();
                c3225c.f18747c = z;
                this.mInverseViewHolder.m20156a(view, c3225c);
                view.setBackgroundColor(c3225c.f18746b);
            } else {
                InverseData c3225c2 = new InverseData(InverseData.PlatformImplementations.kt_3.background);
                c3225c2.f18745a = context.hashCode();
                this.mInverseViewHolder.m20156a(view, c3225c2);
            }
            CameraLog.m12959b(TAG, "registerBackgroundInverse, context.hashCode(): " + context.hashCode() + ", mInverseViewMap: " + this.mInverseViewHolder.m20152a());
        }
    }

    public int getBackgroundColor(View view, int OplusGLSurfaceView_13) {
        InverseData c3225cM20157b = this.mInverseViewHolder.m20157b(view);
        if (c3225cM20157b == null) {
            return OplusGLSurfaceView_13;
        }
        c3225cM20157b.f18746b = OplusGLSurfaceView_13;
        return (isInverseAble(view.getContext()) && this.mbAnimationRunning) || isInverseColor(view.getContext().hashCode()) ? inverse(OplusGLSurfaceView_13, c3225cM20157b.f18748d, c3225cM20157b.f18747c) : OplusGLSurfaceView_13;
    }

    public void registerInverse(Context context, InverseAble interfaceC3223a) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.m20158c(interfaceC3223a)) {
            InverseData c3225c = new InverseData(InverseData.PlatformImplementations.kt_3.common);
            c3225c.f18745a = context.hashCode();
            this.mInverseViewHolder.m20156a(interfaceC3223a, c3225c);
            interfaceC3223a.setInverseColor(isInverseColor(context.hashCode()));
            CameraLog.m12959b(TAG, "registerInverse, context.hashCode(): " + context.hashCode() + ", mInverseViewMap: " + this.mInverseViewHolder.m20152a());
        }
    }

    public void unRegisterInverse(Context context, InverseAble interfaceC3223a) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && this.mInverseViewHolder.m20158c(interfaceC3223a)) {
            this.mInverseViewHolder.m20155a(interfaceC3223a);
        }
    }

    public void setInverseMaskView(Context context, InverseMaskView inverseMaskView) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.m20158c(inverseMaskView)) {
            InverseData c3225c = new InverseData(InverseData.PlatformImplementations.kt_3.mask);
            c3225c.f18745a = context.hashCode();
            this.mInverseViewHolder.m20156a(inverseMaskView, c3225c);
            inverseMaskView.setInverseColor(isInverseColor(context.hashCode()));
        }
    }

    public void setCameraPreviewUI(Context context, CameraPreviewUI viewOnLayoutChangeListenerC3444g) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.m20158c(viewOnLayoutChangeListenerC3444g)) {
            InverseData c3225c = new InverseData(InverseData.PlatformImplementations.kt_3.preview);
            c3225c.f18745a = context.hashCode();
            this.mInverseViewHolder.m20156a(viewOnLayoutChangeListenerC3444g, c3225c);
            viewOnLayoutChangeListenerC3444g.m23356a(isInverseColor(context.hashCode()), getColorWithAlpha(this.mInverseColor, 1.0f));
        }
    }

    public void setMaskAlpha(Context context, final float COUIBaseListPopupWindow_12) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$TcnbrV-POqFtkYWdWgfyQbxY6CU
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.setMaskAlpha(COUIBaseListPopupWindow_12);
            }
        });
    }

    public void setMaskAlpha(Context context, final boolean z, final boolean z2) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$UwQQ8lvyz5fDxBO0LYnDIp3PqJI
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.m20144a(z, z2);
            }
        });
    }

    public void setMaskRadius(Context context, final int OplusGLSurfaceView_13) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$UvSetmnGetkQwEj1o83jUirBQiQ
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.setRadius(OplusGLSurfaceView_13);
            }
        });
    }

    public void setMaskSplitScreenYOffset(Context context, final float COUIBaseListPopupWindow_12) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$ItsNODwTfvVV3tObtXFbbmqIEw4
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.setSplitScreenYOffset(COUIBaseListPopupWindow_12);
            }
        });
    }

    public void startMaskScaleAnimation(final Context context) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$SrDI5Wvm1GWxBuOEfCmrpkoAjW0
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                this.COUIBaseListPopupWindow_12$0.lambda$startMaskScaleAnimation$7$COUIBaseListPopupWindow_8(context, inverseMaskView);
            }
        });
    }

    public /* synthetic */ void lambda$startMaskScaleAnimation$7$COUIBaseListPopupWindow_8(Context context, InverseMaskView inverseMaskView) {
        if (isInverseColor(context.hashCode())) {
            inverseMaskView.m20141a();
        }
    }

    public void setPositionRatio(Context context, final float COUIBaseListPopupWindow_12, final boolean z) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$_D9pG4Wxfn_fDLAZf7A3VrFHJlE
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.m20142a(COUIBaseListPopupWindow_12, z);
            }
        });
    }

    public void withMask(final Context context, final IntrinsicsJvm.kt_3 cVar) {
        if (context == null || !this.mInverseMap.containsKey(Integer.valueOf(context.hashCode()))) {
            return;
        }
        this.mInverseViewHolder.m20154a(new InverseViewHolder.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$Vvi6xFmtwTgzz_gQIctS5is5GaQ
            @Override // com.oplus.camera.p172ui.inverse.InverseViewHolder.PlatformImplementations.kt_3
            public final boolean call(Object obj, InverseData c3225c) {
                return InverseManager.lambda$withMask$9(context, cVar, obj, c3225c);
            }
        });
    }

    static /* synthetic */ boolean lambda$withMask$9(Context context, IntrinsicsJvm.kt_3 cVar, Object obj, InverseData c3225c) {
        if (c3225c.f18749e != InverseData.PlatformImplementations.kt_3.mask || c3225c.f18745a != context.hashCode()) {
            return false;
        }
        cVar.call((InverseMaskView) obj);
        return true;
    }

    public boolean isInverseAble(Context context) {
        return context != null && this.mInverseMap.containsKey(Integer.valueOf(context.hashCode()));
    }

    public void setExecuteDelayMsg(boolean z) {
        this.mbExecuteDelayMsg = z;
    }

    public void clear() {
        this.mInverseViewHolder.m20153a((Context) null);
    }

    public void removeMessages() {
        IntrinsicsJvm.kt_4 bVar = this.mHandler;
        if (bVar != null) {
            bVar.removeMessages(1);
        }
    }

    public void postInverseColor(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        Message messageObtainMessage = this.mHandler.obtainMessage(2, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.sendToTarget();
    }

    public void setMaskLayoutMode(Context context, final int OplusGLSurfaceView_13, final boolean z, final int i2) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$A3F90eOPeIl3geZj5UwWkcUPJz8
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.m20143a(OplusGLSurfaceView_13, z, i2);
            }
        });
    }

    public void setMaskToLayoutMode(Context context, final InverseChangeModeData c3224b) {
        withMask(context, new IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$COUIBaseListPopupWindow_8$doTLUz4QcIFO_Jls6o47v1Lekfk
            @Override // com.oplus.camera.p172ui.inverse.InverseManager.IntrinsicsJvm.kt_3
            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.setMaskToLayoutMode(c3224b);
            }
        });
    }

    /* compiled from: InverseManager.java */
    /* renamed from: com.oplus.camera.ui.inverse.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 extends Handler {
        public IntrinsicsJvm.kt_4() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.arg1;
            if (InverseManager.this.mInverseMap.containsKey(Integer.valueOf(OplusGLSurfaceView_13)) && InverseManager.this.mbExecuteDelayMsg) {
                if (1 == message.what) {
                    Object[] objArr = (Object[]) message.obj;
                    InverseManager.this.setInverseColor(OplusGLSurfaceView_13, ((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                    PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) objArr[2];
                    if (aVar != null) {
                        aVar.call();
                        return;
                    }
                    return;
                }
                if (2 == message.what) {
                    Object[] objArr2 = (Object[]) message.obj;
                    InverseManager.this.setInverseColor(OplusGLSurfaceView_13, ((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                }
            }
        }
    }
}
