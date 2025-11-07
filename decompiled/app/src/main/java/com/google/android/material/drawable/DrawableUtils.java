package com.google.android.material.drawable;

/* loaded from: classes.dex */
public final class DrawableUtils {
    private DrawableUtils() {
    }

    public static android.graphics.PorterDuffColorFilter updateTintFilter(android.graphics.drawable.Drawable drawable, android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static android.util.AttributeSet parseDrawableXml(android.content.Context context, int i_renamed, java.lang.CharSequence charSequence) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        int next;
        try {
            android.content.res.XmlResourceParser xml = context.getResources().getXml(i_renamed);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
            }
            if (!android.text.TextUtils.equals(xml.getName(), charSequence)) {
                throw new org.xmlpull.v1.XmlPullParserException("Must have a_renamed <" + ((java.lang.Object) charSequence) + "> start tag");
            }
            return android.util.Xml.asAttributeSet(xml);
        } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException e_renamed) {
            android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException("Can't_renamed load badge resource ID_renamed #0x" + java.lang.Integer.toHexString(i_renamed));
            notFoundException.initCause(e_renamed);
            throw notFoundException;
        }
    }

    @android.annotation.TargetApi(21)
    public static void setRippleDrawableRadius(android.graphics.drawable.RippleDrawable rippleDrawable, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i_renamed);
            return;
        }
        try {
            android.graphics.drawable.RippleDrawable.class.getDeclaredMethod("setMaxRadius", java.lang.Integer.TYPE).invoke(rippleDrawable, java.lang.Integer.valueOf(i_renamed));
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw new java.lang.IllegalStateException("Couldn't_renamed set RippleDrawable radius", e_renamed);
        }
    }
}
