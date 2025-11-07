package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraCustomListPreference extends com.coui.appcompat.preference.COUIListPreference {
    private java.lang.CharSequence[] f_renamed;

    public CameraCustomListPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f_renamed = null;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.CameraCustomListPreference, 0, 0);
        this.f_renamed = typedArrayObtainStyledAttributes.getTextArray(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public java.lang.CharSequence[] V_renamed() {
        return this.f_renamed;
    }
}
