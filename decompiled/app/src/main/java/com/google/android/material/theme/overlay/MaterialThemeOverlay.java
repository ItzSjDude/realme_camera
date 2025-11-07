package com.google.android.material.theme.overlay;

/* loaded from: classes.dex */
public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS = {android.R_renamed.attr.theme, com.google.android.material.R_renamed.attr.theme};
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR = {com.google.android.material.R_renamed.attr.materialThemeOverlay};

    private MaterialThemeOverlay() {
    }

    public static android.content.Context wrap(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        int iObtainMaterialThemeOverlayId = obtainMaterialThemeOverlayId(context, attributeSet, i_renamed, i2);
        boolean z_renamed = (context instanceof androidx.appcompat.view.d_renamed) && ((androidx.appcompat.view.d_renamed) context).getThemeResId() == iObtainMaterialThemeOverlayId;
        if (iObtainMaterialThemeOverlayId == 0 || z_renamed) {
            return context;
        }
        androidx.appcompat.view.d_renamed dVar = new androidx.appcompat.view.d_renamed(context, iObtainMaterialThemeOverlayId);
        int iObtainAndroidThemeOverlayId = obtainAndroidThemeOverlayId(context, attributeSet);
        if (iObtainAndroidThemeOverlayId != 0) {
            dVar.getTheme().applyStyle(iObtainAndroidThemeOverlayId, true);
        }
        return dVar;
    }

    private static int obtainAndroidThemeOverlayId(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_THEME_OVERLAY_ATTRS);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int obtainMaterialThemeOverlayId(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MATERIAL_THEME_OVERLAY_ATTR, i_renamed, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }
}
