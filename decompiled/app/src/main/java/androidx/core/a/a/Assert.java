package androidx.core.a_renamed.a_renamed;

/* compiled from: ColorStateListInflaterCompat.java */
/* loaded from: classes.dex */
public final class a_renamed {
    public static android.content.res.ColorStateList a_renamed(android.content.res.Resources resources, int i_renamed, android.content.res.Resources.Theme theme) {
        try {
            return a_renamed(resources, resources.getXml(i_renamed), theme);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("CSLCompat", "Failed to inflate ColorStateList.", e_renamed);
            return null;
        }
    }

    public static android.content.res.ColorStateList a_renamed(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
        }
        return a_renamed(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
    }

    public static android.content.res.ColorStateList a_renamed(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String name = xmlPullParser.getName();
        if (!name.equals("selector")) {
            throw new org.xmlpull.v1.XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        return b_renamed(resources, xmlPullParser, attributeSet, theme);
    }

    private static android.content.res.ColorStateList b_renamed(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth;
        int i_renamed = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i_renamed || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                android.content.res.TypedArray typedArrayA = a_renamed(resources, theme, attributeSet, androidx.core.R_renamed.styleable.ColorStateListItem);
                int color = typedArrayA.getColor(androidx.core.R_renamed.styleable.ColorStateListItem_android_color, -65281);
                float f_renamed = 1.0f;
                if (typedArrayA.hasValue(androidx.core.R_renamed.styleable.ColorStateListItem_android_alpha)) {
                    f_renamed = typedArrayA.getFloat(androidx.core.R_renamed.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (typedArrayA.hasValue(androidx.core.R_renamed.styleable.ColorStateListItem_alpha)) {
                    f_renamed = typedArrayA.getFloat(androidx.core.R_renamed.styleable.ColorStateListItem_alpha, 1.0f);
                }
                typedArrayA.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i3 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != androidx.core.R_renamed.attr.alpha) {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i3] = attributeNameResource;
                        i3 = i5;
                    }
                }
                int[] iArrTrimStateSet = android.util.StateSet.trimStateSet(iArr2, i3);
                iArrA = androidx.core.a_renamed.a_renamed.e_renamed.a_renamed(iArrA, i2, a_renamed(color, f_renamed));
                iArr = (int[][]) androidx.core.a_renamed.a_renamed.e_renamed.a_renamed(iArr, i2, iArrTrimStateSet);
                i2++;
            }
            i_renamed = 1;
        }
        int[] iArr3 = new int[i2];
        int[][] iArr4 = new int[i2][];
        java.lang.System.arraycopy(iArrA, 0, iArr3, 0, i2);
        java.lang.System.arraycopy(iArr, 0, iArr4, 0, i2);
        return new android.content.res.ColorStateList(iArr4, iArr3);
    }

    private static android.content.res.TypedArray a_renamed(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int a_renamed(int i_renamed, float f_renamed) {
        return (i_renamed & 16777215) | (java.lang.Math.round(android.graphics.Color.alpha(i_renamed) * f_renamed) << 24);
    }
}
