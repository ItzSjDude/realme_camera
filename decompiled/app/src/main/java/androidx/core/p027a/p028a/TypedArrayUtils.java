package androidx.core.p027a.p028a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class TypedArrayUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2317a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m2305a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return !m2317a(xmlPullParser, str) ? COUIBaseListPopupWindow_12 : typedArray.getFloat(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2316a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13, boolean z) {
        return !m2317a(xmlPullParser, str) ? z : typedArray.getBoolean(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2308a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13, int i2) {
        return !m2317a(xmlPullParser, str) ? i2 : typedArray.getInt(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m2319b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13, int i2) {
        return !m2317a(xmlPullParser, str) ? i2 : typedArray.getColor(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ComplexColorCompat m2313a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int OplusGLSurfaceView_13, int i2) {
        if (m2317a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(OplusGLSurfaceView_13, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return ComplexColorCompat.m2261a(typedValue.data);
            }
            ComplexColorCompat c0418bM2263a = ComplexColorCompat.m2263a(typedArray.getResources(), typedArray.getResourceId(OplusGLSurfaceView_13, 0), theme);
            if (c0418bM2263a != null) {
                return c0418bM2263a;
            }
        }
        return ComplexColorCompat.m2261a(i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ColorStateList m2309a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int OplusGLSurfaceView_13) {
        if (!m2317a(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(OplusGLSurfaceView_13, typedValue);
        if (typedValue.type == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + OplusGLSurfaceView_13 + ": " + typedValue);
        }
        if (typedValue.type >= 28 && typedValue.type <= 31) {
            return m2310a(typedValue);
        }
        return ColorStateListInflaterCompat.m2256a(typedArray.getResources(), typedArray.getResourceId(OplusGLSurfaceView_13, 0), theme);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static ColorStateList m2310a(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m2322c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13, int i2) {
        return !m2317a(xmlPullParser, str) ? i2 : typedArray.getResourceId(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m2314a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13) {
        if (m2317a(xmlPullParser, str)) {
            return typedArray.getString(OplusGLSurfaceView_13);
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static TypedValue m2320b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int OplusGLSurfaceView_13) {
        if (m2317a(xmlPullParser, str)) {
            return typedArray.peekValue(OplusGLSurfaceView_13);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static TypedArray m2311a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2315a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2, boolean z) {
        return typedArray.getBoolean(OplusGLSurfaceView_13, typedArray.getBoolean(i2, z));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Drawable m2312a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        Drawable drawable = typedArray.getDrawable(OplusGLSurfaceView_13);
        return drawable == null ? typedArray.getDrawable(i2) : drawable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2307a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2, int i3) {
        return typedArray.getInt(OplusGLSurfaceView_13, typedArray.getInt(i2, i3));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m2318b(TypedArray typedArray, int OplusGLSurfaceView_13, int i2, int i3) {
        return typedArray.getResourceId(OplusGLSurfaceView_13, typedArray.getResourceId(i2, i3));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m2321b(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        String string = typedArray.getString(OplusGLSurfaceView_13);
        return string == null ? typedArray.getString(i2) : string;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static CharSequence m2323c(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        CharSequence text = typedArray.getText(OplusGLSurfaceView_13);
        return text == null ? typedArray.getText(i2) : text;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static CharSequence[] m2324d(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(OplusGLSurfaceView_13);
        return textArray == null ? typedArray.getTextArray(i2) : textArray;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2306a(Context context, int OplusGLSurfaceView_13, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(OplusGLSurfaceView_13, typedValue, true);
        return typedValue.resourceId != 0 ? OplusGLSurfaceView_13 : i2;
    }
}
