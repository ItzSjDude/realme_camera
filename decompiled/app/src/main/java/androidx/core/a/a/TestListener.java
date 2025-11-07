package androidx.core.a_renamed.a_renamed;

/* compiled from: TypedArrayUtils.java */
/* loaded from: classes.dex */
public class g_renamed {
    public static boolean a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed, float f_renamed) {
        return !a_renamed(xmlPullParser, str) ? f_renamed : typedArray.getFloat(i_renamed, f_renamed);
    }

    public static boolean a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed, boolean z_renamed) {
        return !a_renamed(xmlPullParser, str) ? z_renamed : typedArray.getBoolean(i_renamed, z_renamed);
    }

    public static int a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed, int i2) {
        return !a_renamed(xmlPullParser, str) ? i2 : typedArray.getInt(i_renamed, i2);
    }

    public static int b_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed, int i2) {
        return !a_renamed(xmlPullParser, str) ? i2 : typedArray.getColor(i_renamed, i2);
    }

    public static androidx.core.a_renamed.a_renamed.b_renamed a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources.Theme theme, java.lang.String str, int i_renamed, int i2) {
        if (a_renamed(xmlPullParser, str)) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            typedArray.getValue(i_renamed, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return androidx.core.a_renamed.a_renamed.b_renamed.a_renamed(typedValue.data);
            }
            androidx.core.a_renamed.a_renamed.b_renamed bVarA = androidx.core.a_renamed.a_renamed.b_renamed.a_renamed(typedArray.getResources(), typedArray.getResourceId(i_renamed, 0), theme);
            if (bVarA != null) {
                return bVarA;
            }
        }
        return androidx.core.a_renamed.a_renamed.b_renamed.a_renamed(i2);
    }

    public static android.content.res.ColorStateList a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources.Theme theme, java.lang.String str, int i_renamed) {
        if (!a_renamed(xmlPullParser, str)) {
            return null;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        typedArray.getValue(i_renamed, typedValue);
        if (typedValue.type == 2) {
            throw new java.lang.UnsupportedOperationException("Failed to resolve attribute at_renamed index " + i_renamed + ": " + typedValue);
        }
        if (typedValue.type >= 28 && typedValue.type <= 31) {
            return a_renamed(typedValue);
        }
        return androidx.core.a_renamed.a_renamed.a_renamed.a_renamed(typedArray.getResources(), typedArray.getResourceId(i_renamed, 0), theme);
    }

    private static android.content.res.ColorStateList a_renamed(android.util.TypedValue typedValue) {
        return android.content.res.ColorStateList.valueOf(typedValue.data);
    }

    public static int c_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed, int i2) {
        return !a_renamed(xmlPullParser, str) ? i2 : typedArray.getResourceId(i_renamed, i2);
    }

    public static java.lang.String a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed) {
        if (a_renamed(xmlPullParser, str)) {
            return typedArray.getString(i_renamed);
        }
        return null;
    }

    public static android.util.TypedValue b_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed) {
        if (a_renamed(xmlPullParser, str)) {
            return typedArray.peekValue(i_renamed);
        }
        return null;
    }

    public static android.content.res.TypedArray a_renamed(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static boolean a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2, boolean z_renamed) {
        return typedArray.getBoolean(i_renamed, typedArray.getBoolean(i2, z_renamed));
    }

    public static android.graphics.drawable.Drawable a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        android.graphics.drawable.Drawable drawable = typedArray.getDrawable(i_renamed);
        return drawable == null ? typedArray.getDrawable(i2) : drawable;
    }

    public static int a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2, int i3) {
        return typedArray.getInt(i_renamed, typedArray.getInt(i2, i3));
    }

    public static int b_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2, int i3) {
        return typedArray.getResourceId(i_renamed, typedArray.getResourceId(i2, i3));
    }

    public static java.lang.String b_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        java.lang.String string = typedArray.getString(i_renamed);
        return string == null ? typedArray.getString(i2) : string;
    }

    public static java.lang.CharSequence c_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        java.lang.CharSequence text = typedArray.getText(i_renamed);
        return text == null ? typedArray.getText(i2) : text;
    }

    public static java.lang.CharSequence[] d_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        java.lang.CharSequence[] textArray = typedArray.getTextArray(i_renamed);
        return textArray == null ? typedArray.getTextArray(i2) : textArray;
    }

    public static int a_renamed(android.content.Context context, int i_renamed, int i2) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(i_renamed, typedValue, true);
        return typedValue.resourceId != 0 ? i_renamed : i2;
    }
}
