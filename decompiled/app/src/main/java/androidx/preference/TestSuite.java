package androidx.preference;

/* compiled from: PreferenceInflater.java */
/* loaded from: classes.dex */
class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Class<?>[] f1366a = {android.content.Context.class, android.util.AttributeSet.class};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.HashMap<java.lang.String, java.lang.reflect.Constructor> f1367b = new java.util.HashMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.content.Context f1368c;
    private final java.lang.Object[] d_renamed = new java.lang.Object[2];
    private androidx.preference.j_renamed e_renamed;
    private java.lang.String[] f_renamed;

    public i_renamed(android.content.Context context, androidx.preference.j_renamed jVar) {
        this.f1368c = context;
        a_renamed(jVar);
    }

    private void a_renamed(androidx.preference.j_renamed jVar) {
        this.e_renamed = jVar;
        a_renamed(new java.lang.String[]{androidx.preference.Preference.class.getPackage().getName() + ".", androidx.preference.SwitchPreference.class.getPackage().getName() + "."});
    }

    public void a_renamed(java.lang.String[] strArr) {
        this.f_renamed = strArr;
    }

    public android.content.Context a_renamed() {
        return this.f1368c;
    }

    public androidx.preference.Preference a_renamed(int i_renamed, androidx.preference.PreferenceGroup preferenceGroup) throws android.content.res.Resources.NotFoundException {
        android.content.res.XmlResourceParser xml = a_renamed().getResources().getXml(i_renamed);
        try {
            return a_renamed(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public androidx.preference.Preference a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, androidx.preference.PreferenceGroup preferenceGroup) {
        int next;
        androidx.preference.PreferenceGroup preferenceGroupA;
        synchronized (this.d_renamed) {
            android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xmlPullParser);
            this.d_renamed[0] = this.f1368c;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (android.view.InflateException e_renamed) {
                    throw e_renamed;
                } catch (java.io.IOException e2) {
                    android.view.InflateException inflateException = new android.view.InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (org.xmlpull.v1.XmlPullParserException e3) {
                    android.view.InflateException inflateException2 = new android.view.InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new android.view.InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroupA = a_renamed(preferenceGroup, (androidx.preference.PreferenceGroup) b_renamed(xmlPullParser.getName(), attributeSetAsAttributeSet));
            a_renamed(xmlPullParser, preferenceGroupA, attributeSetAsAttributeSet);
        }
        return preferenceGroupA;
    }

    private androidx.preference.PreferenceGroup a_renamed(androidx.preference.PreferenceGroup preferenceGroup, androidx.preference.PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.a_renamed(this.e_renamed);
        return preferenceGroup2;
    }

    private androidx.preference.Preference a_renamed(java.lang.String str, java.lang.String[] strArr, android.util.AttributeSet attributeSet) throws android.view.InflateException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        java.lang.Class<?> cls;
        java.lang.reflect.Constructor<?> constructor = f1367b.get(str);
        if (constructor == null) {
            try {
                try {
                    java.lang.ClassLoader classLoader = this.f1368c.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = java.lang.Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        java.lang.ClassNotFoundException e_renamed = null;
                        for (java.lang.String str2 : strArr) {
                            try {
                                cls = java.lang.Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (java.lang.ClassNotFoundException e2) {
                                e_renamed = e2;
                            }
                        }
                        if (cls == null) {
                            if (e_renamed == null) {
                                throw new android.view.InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw e_renamed;
                        }
                    }
                    constructor = cls.getConstructor(f1366a);
                    constructor.setAccessible(true);
                    f1367b.put(str, constructor);
                } catch (java.lang.ClassNotFoundException e3) {
                    throw e3;
                }
            } catch (java.lang.Exception e4) {
                android.view.InflateException inflateException = new android.view.InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e4);
                throw inflateException;
            }
        }
        java.lang.Object[] objArr = this.d_renamed;
        objArr[1] = attributeSet;
        return (androidx.preference.Preference) constructor.newInstance(objArr);
    }

    protected androidx.preference.Preference a_renamed(java.lang.String str, android.util.AttributeSet attributeSet) throws java.lang.ClassNotFoundException {
        return a_renamed(str, this.f_renamed, attributeSet);
    }

    private androidx.preference.Preference b_renamed(java.lang.String str, android.util.AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return a_renamed(str, attributeSet);
            }
            return a_renamed(str, (java.lang.String[]) null, attributeSet);
        } catch (android.view.InflateException e_renamed) {
            throw e_renamed;
        } catch (java.lang.ClassNotFoundException e2) {
            android.view.InflateException inflateException = new android.view.InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (java.lang.Exception e3) {
            android.view.InflateException inflateException2 = new android.view.InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    private void a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, androidx.preference.Preference preference, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                java.lang.String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.a_renamed(android.content.Intent.parseIntent(a_renamed().getResources(), xmlPullParser, attributeSet));
                    } catch (java.io.IOException e_renamed) {
                        org.xmlpull.v1.XmlPullParserException xmlPullParserException = new org.xmlpull.v1.XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e_renamed);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    a_renamed().getResources().parseBundleExtra("extra", attributeSet, preference.t_renamed());
                    try {
                        a_renamed(xmlPullParser);
                    } catch (java.io.IOException e2) {
                        org.xmlpull.v1.XmlPullParserException xmlPullParserException2 = new org.xmlpull.v1.XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e2);
                        throw xmlPullParserException2;
                    }
                } else {
                    androidx.preference.Preference preferenceB = b_renamed(name, attributeSet);
                    ((androidx.preference.PreferenceGroup) preference).b_renamed(preferenceB);
                    a_renamed(xmlPullParser, preferenceB, attributeSet);
                }
            }
        }
    }

    private static void a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
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
