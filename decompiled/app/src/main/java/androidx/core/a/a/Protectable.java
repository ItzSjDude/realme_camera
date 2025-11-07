package androidx.core.a_renamed.a_renamed;

/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* compiled from: FontResourcesParserCompat.java */
    public interface a_renamed {
    }

    /* compiled from: FontResourcesParserCompat.java */
    public static final class d_renamed implements androidx.core.a_renamed.a_renamed.c_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final androidx.core.e_renamed.a_renamed f789a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f790b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f791c;

        public d_renamed(androidx.core.e_renamed.a_renamed aVar, int i_renamed, int i2) {
            this.f789a = aVar;
            this.f791c = i_renamed;
            this.f790b = i2;
        }

        public androidx.core.e_renamed.a_renamed a_renamed() {
            return this.f789a;
        }

        public int b_renamed() {
            return this.f791c;
        }

        public int c_renamed() {
            return this.f790b;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.a_renamed.a_renamed.c_renamed$c_renamed, reason: collision with other inner class name */
    public static final class FontResourcesParserCompat_4 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.String f786a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f787b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f788c;
        private java.lang.String d_renamed;
        private int e_renamed;
        private int f_renamed;

        public FontResourcesParserCompat_4(java.lang.String str, int i_renamed, boolean z_renamed, java.lang.String str2, int i2, int i3) {
            this.f786a = str;
            this.f787b = i_renamed;
            this.f788c = z_renamed;
            this.d_renamed = str2;
            this.e_renamed = i2;
            this.f_renamed = i3;
        }

        public java.lang.String a_renamed() {
            return this.f786a;
        }

        public int b_renamed() {
            return this.f787b;
        }

        public boolean c_renamed() {
            return this.f788c;
        }

        public java.lang.String d_renamed() {
            return this.d_renamed;
        }

        public int e_renamed() {
            return this.e_renamed;
        }

        public int f_renamed() {
            return this.f_renamed;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    public static final class b_renamed implements androidx.core.a_renamed.a_renamed.c_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4[] f785a;

        public b_renamed(androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4[] c0013cArr) {
            this.f785a = c0013cArr;
        }

        public androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4[] a_renamed() {
            return this.f785a;
        }
    }

    public static androidx.core.a_renamed.a_renamed.c_renamed.a_renamed a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
        }
        return b_renamed(xmlPullParser, resources);
    }

    private static androidx.core.a_renamed.a_renamed.c_renamed.a_renamed b_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c_renamed(xmlPullParser, resources);
        }
        a_renamed(xmlPullParser);
        return null;
    }

    private static androidx.core.a_renamed.a_renamed.c_renamed.a_renamed c_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlPullParser), androidx.core.R_renamed.styleable.FontFamily);
        java.lang.String string = typedArrayObtainAttributes.getString(androidx.core.R_renamed.styleable.FontFamily_fontProviderAuthority);
        java.lang.String string2 = typedArrayObtainAttributes.getString(androidx.core.R_renamed.styleable.FontFamily_fontProviderPackage);
        java.lang.String string3 = typedArrayObtainAttributes.getString(androidx.core.R_renamed.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(androidx.core.R_renamed.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(androidx.core.R_renamed.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(androidx.core.R_renamed.styleable.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a_renamed(xmlPullParser);
            }
            return new androidx.core.a_renamed.a_renamed.c_renamed.d_renamed(new androidx.core.e_renamed.a_renamed(string, string2, string3, a_renamed(resources, resourceId)), integer, integer2);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d_renamed(xmlPullParser, resources));
                } else {
                    a_renamed(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new androidx.core.a_renamed.a_renamed.c_renamed.b_renamed((androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4[]) arrayList.toArray(new androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4[arrayList.size()]));
    }

    private static int a_renamed(android.content.res.TypedArray typedArray, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i_renamed);
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        typedArray.getValue(i_renamed, typedValue);
        return typedValue.type;
    }

    public static java.util.List<java.util.List<byte[]>> a_renamed(android.content.res.Resources resources, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (i_renamed == 0) {
            return java.util.Collections.emptyList();
        }
        android.content.res.TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i_renamed);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return java.util.Collections.emptyList();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (a_renamed(typedArrayObtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(a_renamed(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a_renamed(resources.getStringArray(i_renamed)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static java.util.List<byte[]> a_renamed(java.lang.String[] strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            arrayList.add(android.util.Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 d_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlPullParser), androidx.core.R_renamed.styleable.FontFamilyFont);
        int i_renamed = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(androidx.core.R_renamed.styleable.FontFamilyFont_fontWeight) ? androidx.core.R_renamed.styleable.FontFamilyFont_fontWeight : androidx.core.R_renamed.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z_renamed = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(androidx.core.R_renamed.styleable.FontFamilyFont_fontStyle) ? androidx.core.R_renamed.styleable.FontFamilyFont_fontStyle : androidx.core.R_renamed.styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = typedArrayObtainAttributes.hasValue(androidx.core.R_renamed.styleable.FontFamilyFont_ttcIndex) ? androidx.core.R_renamed.styleable.FontFamilyFont_ttcIndex : androidx.core.R_renamed.styleable.FontFamilyFont_android_ttcIndex;
        java.lang.String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(androidx.core.R_renamed.styleable.FontFamilyFont_fontVariationSettings) ? androidx.core.R_renamed.styleable.FontFamilyFont_fontVariationSettings : androidx.core.R_renamed.styleable.FontFamilyFont_android_fontVariationSettings);
        int i3 = typedArrayObtainAttributes.getInt(i2, 0);
        int i4 = typedArrayObtainAttributes.hasValue(androidx.core.R_renamed.styleable.FontFamilyFont_font) ? androidx.core.R_renamed.styleable.FontFamilyFont_font : androidx.core.R_renamed.styleable.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i4, 0);
        java.lang.String string2 = typedArrayObtainAttributes.getString(i4);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a_renamed(xmlPullParser);
        }
        return new androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4(string2, i_renamed, z_renamed, string, i3, resourceId);
    }

    private static void a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i_renamed = 1;
        while (i_renamed > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i_renamed++;
            } else if (next == 3) {
                i_renamed--;
            }
        }
    }
}
