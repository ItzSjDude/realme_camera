package com.oplus.camera.p172ui.menu.setting;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.p172ui.widget.SuperColorToolTips;
import com.oplus.camera.util.Util;

/* compiled from: CameraMenuOptionSecondLevel.java */
/* renamed from: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class CameraMenuOptionSecondLevel extends CameraMenuOption implements View.OnClickListener, View.OnTouchListener, InverseAble {

    /* renamed from: r */
    private final PathInterpolator f20159r;

    /* renamed from: s */
    private final ArgbEvaluator f20160s;

    /* renamed from: t */
    private RotateImageView f20161t;

    /* renamed from: u */
    private SuperColorToolTips f20162u;

    /* renamed from: v */
    private boolean f20163v;

    /* renamed from: w */
    private boolean f20164w;

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo21135b(boolean z) {
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: s */
    protected boolean mo21181s() {
        return true;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: z */
    public int mo21188z() {
        return 1;
    }

    public CameraMenuOptionSecondLevel(ComboPreferences comboPreferences, Context context, CameraUIListener cameraUIListener, int OplusGLSurfaceView_13) {
        super(comboPreferences, context, null, null, cameraUIListener, OplusGLSurfaceView_13, null);
        this.f20159r = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20160s = new ArgbEvaluator();
        this.f20161t = null;
        this.f20162u = null;
        this.f20163v = false;
        this.f20164w = false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo21132b() {
        this.f20161t = new RotateImageView(this.f19928k);
        this.f20161t.setOnClickListener(this);
        this.f20161t.setOnTouchListener(this);
        this.f20161t.setLayoutParams(new ViewGroup.LayoutParams(this.f19928k.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width), this.f19928k.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_height)));
        this.f20161t.setBackground(ContextCompat.m2248a(this.f19928k, R.drawable.drawer_item_iv_background).mutate());
        InverseManager.INS.registerInverse(this.f19928k, this);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21105a(View view) {
        this.f20161t = (RotateImageView) view;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: J */
    public View mo21081J() {
        return this.f20161t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f19930m != null) {
            this.f19930m.mo20299a(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.mo21106a(view, motionEvent);
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: w */
    public void mo21185w() {
        SuperColorToolTips c3520c = this.f20162u;
        if (c3520c != null) {
            if (c3520c.isShowing()) {
                this.f20162u.dismiss();
            }
            this.f20162u = null;
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21112a(final String str, String str2, final String str3, final int OplusGLSurfaceView_13, final int i2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        if (this.f20162u != null) {
            mo21185w();
        }
        if (this.f20161t != null) {
            this.f20162u = new SuperColorToolTips(this.f19928k);
            this.f20162u.m8139a(true);
            this.f20162u.m8138a(str2);
            this.f20162u.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$OplusGLSurfaceView_15$gJqMt1VT08CVyMyJH7kPUoloYbg
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.COUIBaseListPopupWindow_12$0.m21452a(str, str3, view, motionEvent);
                }
            });
            if (this.f20162u.isShowing()) {
                return;
            }
            this.f20161t.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_15.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (CameraMenuOptionSecondLevel.this.m21078G() == 0) {
                        CameraMenuOptionSecondLevel.this.f20161t.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        try {
                            CameraMenuOptionSecondLevel.this.f20162u.m24102a(OplusGLSurfaceView_13, i2);
                            CameraMenuOptionSecondLevel.this.f20162u.m8135a(CameraMenuOptionSecondLevel.this.f20161t, 4);
                        } catch (WindowManager.BadTokenException COUIBaseListPopupWindow_8) {
                            CameraLog.m12966e("CameraMenuOptionSecondLevel", "showSubMenuOptionTipsBubble, exception: " + COUIBaseListPopupWindow_8.getMessage());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ boolean m21452a(String str, String str2, View view, MotionEvent motionEvent) {
        mo21185w();
        if (this.f19918a != null && str != null) {
            SharedPreferences.Editor editorEdit = this.f19918a.edit();
            editorEdit.putBoolean(str + "_" + str2, false);
            editorEdit.apply();
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: B */
    public int mo21073B() {
        if (this.f20161t != null) {
            if (1 == this.f19931n.mo10816ca()) {
                return this.f19928k.getResources().getDimensionPixelSize(R.dimen.fold_tool_second_level_item_width);
            }
            return this.f19928k.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width);
        }
        return super.mo21073B();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: C */
    public int mo21074C() {
        if (this.f20161t != null) {
            if (1 == this.f19931n.mo10816ca()) {
                return this.f19928k.getResources().getDimensionPixelSize(R.dimen.fold_tool_second_level_item_width);
            }
            return this.f19928k.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width);
        }
        return super.mo21074C();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo21163h(String str) {
        RotateImageView rotateImageView = this.f20161t;
        if (rotateImageView != null) {
            rotateImageView.setContentDescription(str);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21104a(Drawable drawable, boolean z) {
        RotateImageView rotateImageView = this.f20161t;
        if (rotateImageView != null) {
            rotateImageView.setImageDrawable(drawable);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21455b(Drawable drawable, boolean z) {
        RotateImageView rotateImageView = this.f20161t;
        if (rotateImageView != null) {
            rotateImageView.setImageDrawable(drawable);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21103a(int OplusGLSurfaceView_13, boolean z) {
        RotateImageView rotateImageView = this.f20161t;
        if (rotateImageView != null) {
            rotateImageView.m18348a(OplusGLSurfaceView_13, z);
        }
        super.mo21103a(OplusGLSurfaceView_13, z);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: A */
    protected void mo21072A() {
        if (this.f20161t != null) {
            super.mo21072A();
            mo21105a((View) null);
            InverseManager.INS.unRegisterInverse(this.f19928k, this);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21149d(boolean z) {
        m21454h(z);
        RotateImageView rotateImageView = this.f20161t;
        if (rotateImageView != null) {
            rotateImageView.setSelected(z);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21117a(boolean z, boolean z2, long OplusGLSurfaceView_15) {
        if (this.f20164w == z) {
            return;
        }
        this.f20164w = z;
        if (!z2) {
            m21454h(this.f20161t.isSelected());
            return;
        }
        if (this.f20161t.isSelected()) {
            return;
        }
        int color = this.f19928k.getColor(R.color.color_white_with_15_percent_transparency);
        int color2 = this.f19928k.getColor(R.color.color_black_with_30_percent_transparency);
        ArgbEvaluator argbEvaluator = this.f20160s;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(z ? color2 : color);
        if (!z) {
            color = color2;
        }
        objArr[1] = Integer.valueOf(color);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(argbEvaluator, objArr);
        valueAnimatorOfObject.setInterpolator(this.f20159r);
        valueAnimatorOfObject.setDuration(OplusGLSurfaceView_15);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_15.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (CameraMenuOptionSecondLevel.this.f20161t == null || CameraMenuOptionSecondLevel.this.f20161t.isSelected()) {
                    return;
                }
                CameraMenuOptionSecondLevel.this.f20161t.getBackground().setTint(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfObject.start();
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f20163v = z;
        RotateImageView rotateImageView = this.f20161t;
        if (rotateImageView != null) {
            m21454h(rotateImageView.isSelected());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m21454h(boolean z) {
        int color;
        int color2;
        if (this.f20161t != null) {
            if (z) {
                if (this.f20163v) {
                    color = this.f19928k.getColor(R.color.color_black_with_full_percent_transparency);
                    color2 = Util.m24164A(this.f19928k);
                } else {
                    color = this.f19928k.getColor(R.color.color_black_with_85_percent_transparency);
                    color2 = Util.m24164A(this.f19928k);
                }
            } else if (this.f19931n != null && 1 == this.f19931n.mo10816ca()) {
                color = this.f19928k.getColor(R.color.color_white_with_full_percent_transparency);
                color2 = this.f19928k.getColor(R.color.color_white_with_0_percent_transparency);
            } else if (this.f20163v) {
                color = this.f19928k.getColor(R.color.color_white_with_full_percent_transparency);
                color2 = this.f19928k.getColor(R.color.color_black_with_30_percent_transparency);
            } else {
                color = this.f19928k.getColor(R.color.color_white_with_full_percent_transparency);
                if (this.f20164w) {
                    color2 = this.f19928k.getColor(R.color.color_white_with_15_percent_transparency);
                } else {
                    color2 = this.f19928k.getColor(R.color.color_black_with_30_percent_transparency);
                }
            }
            this.f20161t.m18347a(color, color2);
            this.f20161t.invalidate();
        }
    }
}
