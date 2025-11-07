package com.oplus.camera.p172ui.menu.setting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: ExpandableMenuPanel.java */
/* renamed from: com.oplus.camera.ui.menu.setting.q */
/* loaded from: classes2.dex */
public class ExpandableMenuPanel extends View {
    public static final String DEFALUT_MENU = "DefaultExpandPanel";
    public static final int EXPAND_MENU_HIDE = 0;
    public static final int EXPAND_MENU_SHOW = 1;
    private static final String TAG = "ExpandableMenuPanel";
    public static String mCurrentMenuKey = "DefaultExpandPanel";
    public IntrinsicsJvm.kt_4 mExpandMenuListener;
    protected int mMenuTranslateY;
    public boolean mbEnterAnimationRunning;
    public boolean mbExitAnimationRunning;
    private boolean mbViewExpand;

    /* compiled from: ExpandableMenuPanel.java */
    /* renamed from: com.oplus.camera.ui.menu.setting.q$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20039a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20040a(String str, boolean z, boolean z2);
    }

    public void hideWithoutAnim(boolean z, boolean z2) {
    }

    public boolean openMenuCanDisableHighLight() {
        return false;
    }

    public void scrollToNext() {
    }

    public void scrollToPrevious() {
    }

    public ExpandableMenuPanel(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.mbViewExpand = false;
        this.mMenuTranslateY = 0;
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
        this.mExpandMenuListener = null;
    }

    public ExpandableMenuPanel(Activity activity) {
        super(activity.getApplicationContext());
        this.mbViewExpand = false;
        this.mMenuTranslateY = 0;
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
        this.mExpandMenuListener = null;
        this.mMenuTranslateY = activity.getResources().getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
    }

    public void showMenuPanel(String str, boolean z, boolean z2) {
        CameraLog.m12954a(TAG, "showMenuPanel");
        this.mbViewExpand = true;
        setCurrentMenuKey(str);
        IntrinsicsJvm.kt_4 bVar = this.mExpandMenuListener;
        if (bVar != null) {
            bVar.mo20039a(mCurrentMenuKey);
        }
    }

    public void hideMenuPanel(boolean z, boolean z2) {
        CameraLog.m12954a(TAG, "hideMenuPanel");
        this.mbViewExpand = false;
        IntrinsicsJvm.kt_4 bVar = this.mExpandMenuListener;
        if (bVar != null) {
            bVar.mo20040a(mCurrentMenuKey, z, z2);
        }
        setCurrentMenuKey(DEFALUT_MENU);
    }

    public void setExpandMenuListener(IntrinsicsJvm.kt_4 bVar) {
        this.mExpandMenuListener = bVar;
    }

    public int respondSingleTouchEventY() {
        return Util.getScreenHeight() - Util.m24187O();
    }

    public boolean onSingleTapUp(int OplusGLSurfaceView_13, int i2) {
        if (!this.mbViewExpand || i2 >= respondSingleTouchEventY() || isAnimationRunning()) {
            return false;
        }
        hideMenuPanel(true, false);
        return true;
    }

    public boolean onBackPressed() {
        if (!this.mbViewExpand || isAnimationRunning()) {
            return false;
        }
        hideMenuPanel(true, false);
        return true;
    }

    public boolean isAnimationRunning() {
        return this.mbEnterAnimationRunning || this.mbExitAnimationRunning;
    }

    public void setCurrentMenuKey(String str) {
        mCurrentMenuKey = str;
    }

    public String getCurrentMenuKey() {
        return mCurrentMenuKey;
    }

    public boolean isEffectMenuOpen() {
        return this.mbViewExpand || this.mbEnterAnimationRunning;
    }

    public boolean isEffectOpen() {
        return this.mbViewExpand || this.mbEnterAnimationRunning;
    }

    public void setExpandMenuAnimation(View view, int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        if (z) {
            if (OplusGLSurfaceView_13 == 0) {
                Util.m24296a(view, OplusGLSurfaceView_13, R.anim.expand_menu_enter, true, true, (Animation.AnimationListener) new PlatformImplementations.kt_3(view, OplusGLSurfaceView_13));
                return;
            } else {
                Util.m24296a(view, OplusGLSurfaceView_13, R.anim.expand_menu_exit, true, true, (Animation.AnimationListener) new PlatformImplementations.kt_3(view, OplusGLSurfaceView_13));
                return;
            }
        }
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(OplusGLSurfaceView_13);
            this.mbEnterAnimationRunning = false;
            this.mbExitAnimationRunning = false;
        }
    }

    public void setExpandTextAnimation(View view, int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        if (z) {
            if (OplusGLSurfaceView_13 == 0) {
                Util.m24296a(view, OplusGLSurfaceView_13, R.anim.expand_text_show, true, true, (Animation.AnimationListener) new PlatformImplementations.kt_3(view, OplusGLSurfaceView_13));
                return;
            } else {
                Util.m24296a(view, OplusGLSurfaceView_13, R.anim.expand_text_hide, true, true, (Animation.AnimationListener) new PlatformImplementations.kt_3(view, OplusGLSurfaceView_13));
                return;
            }
        }
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* compiled from: ExpandableMenuPanel.java */
    /* renamed from: com.oplus.camera.ui.menu.setting.q$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 implements Animation.AnimationListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private View f20359b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f20360c;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        public PlatformImplementations.kt_3(View view, int OplusGLSurfaceView_13) {
            this.f20359b = null;
            this.f20360c = 4;
            this.f20359b = view;
            this.f20360c = OplusGLSurfaceView_13;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            int OplusGLSurfaceView_13 = this.f20360c;
            if (OplusGLSurfaceView_13 == 0) {
                this.f20359b.setVisibility(OplusGLSurfaceView_13);
                ExpandableMenuPanel.this.mbEnterAnimationRunning = true;
            } else {
                ExpandableMenuPanel.this.mbExitAnimationRunning = true;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            int OplusGLSurfaceView_13 = this.f20360c;
            if (OplusGLSurfaceView_13 != 0) {
                this.f20359b.setVisibility(OplusGLSurfaceView_13);
            }
            if (this.f20360c == 0) {
                ExpandableMenuPanel.this.mbEnterAnimationRunning = false;
            } else {
                ExpandableMenuPanel.this.mbExitAnimationRunning = false;
            }
        }
    }
}
