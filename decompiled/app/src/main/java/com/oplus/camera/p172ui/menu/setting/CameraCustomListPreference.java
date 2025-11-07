package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.coui.appcompat.preference.COUIListPreference;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class CameraCustomListPreference extends COUIListPreference {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence[] f19895f;

    public CameraCustomListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19895f = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraCustomListPreference, 0, 0);
        this.f19895f = typedArrayObtainStyledAttributes.getTextArray(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: V */
    public CharSequence[] m21045V() {
        return this.f19895f;
    }
}
