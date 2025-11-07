package androidx.core.p027a.p028a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.p033e.FontRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class FontResourcesParserCompat {

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_5 */
    public static final class IntrinsicsJvm.kt_5 implements PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final FontRequest f2698a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f2699b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f2700c;

        public IntrinsicsJvm.kt_5(FontRequest c0445a, int OplusGLSurfaceView_13, int i2) {
            this.f2698a = c0445a;
            this.f2700c = OplusGLSurfaceView_13;
            this.f2699b = i2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public FontRequest m2288a() {
            return this.f2698a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m2289b() {
            return this.f2700c;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m2290c() {
            return this.f2699b;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    public static final class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final String f2692a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f2693b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f2694c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f2695d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f2696e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f2697f;

        public IntrinsicsJvm.kt_3(String str, int OplusGLSurfaceView_13, boolean z, String str2, int i2, int i3) {
            this.f2692a = str;
            this.f2693b = OplusGLSurfaceView_13;
            this.f2694c = z;
            this.f2695d = str2;
            this.f2696e = i2;
            this.f2697f = i3;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m2282a() {
            return this.f2692a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m2283b() {
            return this.f2693b;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m2284c() {
            return this.f2694c;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public String m2285d() {
            return this.f2695d;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int m2286e() {
            return this.f2696e;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int m2287f() {
            return this.f2697f;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 implements PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final IntrinsicsJvm.kt_3[] f2691a;

        public IntrinsicsJvm.kt_4(IntrinsicsJvm.kt_3[] cVarArr) {
            this.f2691a = cVarArr;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_3[] m2281a() {
            return this.f2691a;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PlatformImplementations.kt_3 m2274a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return m2278b(xmlPullParser, resources);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static PlatformImplementations.kt_3 m2278b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m2279c(xmlPullParser, resources);
        }
        m2277a(xmlPullParser);
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static PlatformImplementations.kt_3 m2279c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                m2277a(xmlPullParser);
            }
            return new IntrinsicsJvm.kt_5(new FontRequest(string, string2, string3, m2275a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(m2280d(xmlPullParser, resources));
                } else {
                    m2277a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new IntrinsicsJvm.kt_4((IntrinsicsJvm.kt_3[]) arrayList.toArray(new IntrinsicsJvm.kt_3[arrayList.size()]));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m2273a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(OplusGLSurfaceView_13);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(OplusGLSurfaceView_13, typedValue);
        return typedValue.type;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<List<byte[]>> m2275a(Resources resources, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (OplusGLSurfaceView_13 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(OplusGLSurfaceView_13);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m2273a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m2276a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m2276a(resources.getStringArray(OplusGLSurfaceView_13)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<byte[]> m2276a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static IntrinsicsJvm.kt_3 m2280d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int OplusGLSurfaceView_13 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings);
        int i3 = typedArrayObtainAttributes.getInt(i2, 0);
        int i4 = typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i4, 0);
        String string2 = typedArrayObtainAttributes.getString(i4);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m2277a(xmlPullParser);
        }
        return new IntrinsicsJvm.kt_3(string2, OplusGLSurfaceView_13, z, string, i3, resourceId);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m2277a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int OplusGLSurfaceView_13 = 1;
        while (OplusGLSurfaceView_13 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                OplusGLSurfaceView_13++;
            } else if (next == 3) {
                OplusGLSurfaceView_13--;
            }
        }
    }
}
