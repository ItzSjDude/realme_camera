package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.C1694R;

/* loaded from: classes.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    public Float get(ViewGroup viewGroup) {
        Float COUIBaseListPopupWindow_12 = (Float) viewGroup.getTag(C1694R.id_renamed.mtrl_internal_children_alpha_tag);
        return COUIBaseListPopupWindow_12 != null ? COUIBaseListPopupWindow_12 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public void set(ViewGroup viewGroup, Float COUIBaseListPopupWindow_12) {
        float fFloatValue = COUIBaseListPopupWindow_12.floatValue();
        viewGroup.setTag(C1694R.id_renamed.mtrl_internal_children_alpha_tag, Float.valueOf(fFloatValue));
        int childCount = viewGroup.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            viewGroup.getChildAt(OplusGLSurfaceView_13).setAlpha(fFloatValue);
        }
    }
}
