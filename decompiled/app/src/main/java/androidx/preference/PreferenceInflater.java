package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: PreferenceInflater.java */
/* renamed from: androidx.preference.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
class PreferenceInflater {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Class<?>[] f3914a = {Context.class, AttributeSet.class};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final HashMap<String, Constructor> f3915b = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Context f3916c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Object[] f3917d = new Object[2];

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PreferenceManager f3918e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String[] f3919f;

    public PreferenceInflater(Context context, PreferenceManager c0666j) {
        this.f3916c = context;
        m3972a(c0666j);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3972a(PreferenceManager c0666j) {
        this.f3918e = c0666j;
        m3980a(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3980a(String[] strArr) {
        this.f3919f = strArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Context m3976a() {
        return this.f3916c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Preference m3977a(int OplusGLSurfaceView_13, PreferenceGroup preferenceGroup) throws Resources.NotFoundException {
        XmlResourceParser xml = m3976a().getResources().getXml(OplusGLSurfaceView_13);
        try {
            return m3979a(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Preference m3979a(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup preferenceGroupM3971a;
        synchronized (this.f3917d) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f3917d[0] = this.f3916c;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException COUIBaseListPopupWindow_8) {
                    throw COUIBaseListPopupWindow_8;
                } catch (IOException e2) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (XmlPullParserException e3) {
                    InflateException inflateException2 = new InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroupM3971a = m3971a(preferenceGroup, (PreferenceGroup) m3975b(xmlPullParser.getName(), attributeSetAsAttributeSet));
            m3974a(xmlPullParser, preferenceGroupM3971a, attributeSetAsAttributeSet);
        }
        return preferenceGroupM3971a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PreferenceGroup m3971a(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.m3822a(this.f3918e);
        return preferenceGroup2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Preference m3970a(String str, String[] strArr, AttributeSet attributeSet) throws InflateException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> cls;
        Constructor<?> constructor = f3915b.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f3916c.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        ClassNotFoundException COUIBaseListPopupWindow_8 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e2) {
                                COUIBaseListPopupWindow_8 = e2;
                            }
                        }
                        if (cls == null) {
                            if (COUIBaseListPopupWindow_8 == null) {
                                throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw COUIBaseListPopupWindow_8;
                        }
                    }
                    constructor = cls.getConstructor(f3914a);
                    constructor.setAccessible(true);
                    f3915b.put(str, constructor);
                } catch (ClassNotFoundException e3) {
                    throw e3;
                }
            } catch (Exception e4) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e4);
                throw inflateException;
            }
        }
        Object[] objArr = this.f3917d;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected Preference m3978a(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return m3970a(str, this.f3919f, attributeSet);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Preference m3975b(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return m3978a(str, attributeSet);
            }
            return m3970a(str, (String[]) null, attributeSet);
        } catch (InflateException COUIBaseListPopupWindow_8) {
            throw COUIBaseListPopupWindow_8;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3974a(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.m3812a(Intent.parseIntent(m3976a().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(COUIBaseListPopupWindow_8);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    m3976a().getResources().parseBundleExtra("extra", attributeSet, preference.m3852t());
                    try {
                        m3973a(xmlPullParser);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e2);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceM3975b = m3975b(name, attributeSet);
                    ((PreferenceGroup) preference).m3865b(preferenceM3975b);
                    m3974a(xmlPullParser, preferenceM3975b, attributeSet);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3973a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }
}
