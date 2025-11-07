package androidx.core.p027a.p028a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.core.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ColorStateListInflaterCompat.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static ColorStateList m2256a(Resources resources, int OplusGLSurfaceView_13, Resources.Theme theme) {
        try {
            return m2257a(resources, resources.getXml(OplusGLSurfaceView_13), theme);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("CSLCompat", "Failed to inflate ColorStateList.", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ColorStateList m2257a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return m2258a(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ColorStateList m2258a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        return m2260b(resources, xmlPullParser, attributeSet, theme);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ColorStateList m2260b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int OplusGLSurfaceView_13 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrM2296a = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == OplusGLSurfaceView_13 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayM2259a = m2259a(resources, theme, attributeSet, R.styleable.ColorStateListItem);
                int color = typedArrayM2259a.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                float COUIBaseListPopupWindow_12 = 1.0f;
                if (typedArrayM2259a.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                    COUIBaseListPopupWindow_12 = typedArrayM2259a.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (typedArrayM2259a.hasValue(R.styleable.ColorStateListItem_alpha)) {
                    COUIBaseListPopupWindow_12 = typedArrayM2259a.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
                }
                typedArrayM2259a.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i3 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha) {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i3] = attributeNameResource;
                        i3 = i5;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i3);
                iArrM2296a = GrowingArrayUtils.m2296a(iArrM2296a, i2, m2255a(color, COUIBaseListPopupWindow_12));
                iArr = (int[][]) GrowingArrayUtils.m2297a(iArr, i2, iArrTrimStateSet);
                i2++;
            }
            OplusGLSurfaceView_13 = 1;
        }
        int[] iArr3 = new int[i2];
        int[][] iArr4 = new int[i2][];
        System.arraycopy(iArrM2296a, 0, iArr3, 0, i2);
        System.arraycopy(iArr, 0, iArr4, 0, i2);
        return new ColorStateList(iArr4, iArr3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static TypedArray m2259a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m2255a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return (OplusGLSurfaceView_13 & 16777215) | (Math.round(Color.alpha(OplusGLSurfaceView_13) * COUIBaseListPopupWindow_12) << 24);
    }
}
