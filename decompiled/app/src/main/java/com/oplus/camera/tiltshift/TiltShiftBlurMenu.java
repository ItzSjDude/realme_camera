package com.oplus.camera.tiltshift;

import android.app.Activity;
import android.content.res.Resources;
import com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu;

/* loaded from: classes2.dex */
public class TiltShiftBlurMenu extends BlurMenu {
    private static final String PERCENT_TEXT = "%";
    private static final float DEFAULT_DOT_FOCUS_VALUE = 70.0f;
    private static final float[] TiltShift_BLUR_VALUES = {0.0f, 5.0f, 10.0f, 15.0f, 20.0f, 25.0f, 30.0f, 35.0f, 40.0f, 45.0f, 50.0f, 55.0f, 60.0f, 65.0f, DEFAULT_DOT_FOCUS_VALUE, 75.0f, 80.0f, 85.0f, 90.0f, 95.0f, 100.0f};

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected int getBlurTextWidth(float COUIBaseListPopupWindow_12) {
        return -1;
    }

    public TiltShiftBlurMenu(Activity activity, BlurMenu.PlatformImplementations.kt_3 aVar) {
        super(activity, aVar);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected String convertValueToFocus(float COUIBaseListPopupWindow_12) {
        return ((int) COUIBaseListPopupWindow_12) + PERCENT_TEXT;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected int getTextValuesLength() {
        return TiltShift_BLUR_VALUES.length;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected float convertBlurMenuValueToTextValue(int OplusGLSurfaceView_13) {
        return TiltShift_BLUR_VALUES[OplusGLSurfaceView_13];
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected int getMaxValue() {
        return TiltShift_BLUR_VALUES.length;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected int getRealValue(int OplusGLSurfaceView_13) {
        return Math.round(TiltShift_BLUR_VALUES[OplusGLSurfaceView_13]);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected float getOffset(int OplusGLSurfaceView_13, int i2) {
        return Math.abs(TiltShift_BLUR_VALUES[OplusGLSurfaceView_13] - i2);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    public void show(boolean z, boolean z2) throws Resources.NotFoundException {
        super.show(z, z2);
        hideBlurMenuValuePrefixText();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu
    protected void initBlurSeekbarDefaultDotPosition() {
        if (!this.mBlurMenuSeekBar.mo17421d() || this.mBlurMenuSeekBar.m20770f()) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getMaxValue(); OplusGLSurfaceView_13++) {
            if (DEFAULT_DOT_FOCUS_VALUE == convertBlurMenuValueToTextValue(OplusGLSurfaceView_13)) {
                this.mBlurMenuSeekBar.setDefaultDotPosition(OplusGLSurfaceView_13);
                return;
            }
        }
    }
}
