package com.oplus.camera.tiltshift;

/* loaded from: classes2.dex */
public class TiltShiftBlurMenu extends com.oplus.camera.ui.menu.levelcontrol.c_renamed {
    private static final java.lang.String PERCENT_TEXT = "%";
    private static final float DEFAULT_DOT_FOCUS_VALUE = 70.0f;
    private static final float[] TiltShift_BLUR_VALUES = {0.0f, 5.0f, 10.0f, 15.0f, 20.0f, 25.0f, 30.0f, 35.0f, 40.0f, 45.0f, 50.0f, 55.0f, 60.0f, 65.0f, DEFAULT_DOT_FOCUS_VALUE, 75.0f, 80.0f, 85.0f, 90.0f, 95.0f, 100.0f};

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected int getBlurTextWidth(float f_renamed) {
        return -1;
    }

    public TiltShiftBlurMenu(android.app.Activity activity, com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed aVar) {
        super(activity, aVar);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected java.lang.String convertValueToFocus(float f_renamed) {
        return ((int) f_renamed) + PERCENT_TEXT;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected int getTextValuesLength() {
        return TiltShift_BLUR_VALUES.length;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected float convertBlurMenuValueToTextValue(int i_renamed) {
        return TiltShift_BLUR_VALUES[i_renamed];
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected int getMaxValue() {
        return TiltShift_BLUR_VALUES.length;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected int getRealValue(int i_renamed) {
        return java.lang.Math.round(TiltShift_BLUR_VALUES[i_renamed]);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected float getOffset(int i_renamed, int i2) {
        return java.lang.Math.abs(TiltShift_BLUR_VALUES[i_renamed] - i2);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    public void show(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        super.show(z_renamed, z2);
        hideBlurMenuValuePrefixText();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed
    protected void initBlurSeekbarDefaultDotPosition() {
        if (!this.mBlurMenuSeekBar.d_renamed() || this.mBlurMenuSeekBar.f_renamed()) {
            return;
        }
        for (int i_renamed = 0; i_renamed < getMaxValue(); i_renamed++) {
            if (DEFAULT_DOT_FOCUS_VALUE == convertBlurMenuValueToTextValue(i_renamed)) {
                this.mBlurMenuSeekBar.setDefaultDotPosition(i_renamed);
                return;
            }
        }
    }
}
