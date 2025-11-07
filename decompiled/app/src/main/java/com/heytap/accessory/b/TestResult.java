package com.heytap.accessory.b_renamed;

/* compiled from: ServiceXmlReader.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f3274a = "h_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static com.heytap.accessory.b_renamed.h_renamed f3275b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f3276c;

    private h_renamed(android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Invalid context:" + ((java.lang.Object) null));
        }
        this.f3276c = context;
    }

    public static synchronized com.heytap.accessory.b_renamed.h_renamed a_renamed(android.content.Context context) {
        if (f3275b == null) {
            f3275b = new com.heytap.accessory.b_renamed.h_renamed(context.getApplicationContext());
        }
        return f3275b;
    }

    public synchronized byte[][] a_renamed(java.lang.String str) throws com.heytap.accessory.b_renamed.f_renamed {
        java.lang.String[] strArrB = b_renamed(str);
        if (strArrB == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3274a, "configFileLocationGroup is_renamed empty,config error with ".concat(java.lang.String.valueOf(str)));
            return null;
        }
        byte[][] bArr = new byte[strArrB.length][];
        for (int i_renamed = 0; i_renamed < strArrB.length; i_renamed++) {
            java.lang.String str2 = strArrB[i_renamed];
            if (str2 != null) {
                bArr[i_renamed] = com.heytap.accessory.b_renamed.j_renamed.a_renamed(this.f3276c, str, str2);
            }
        }
        return bArr;
    }

    public static synchronized java.util.List<com.heytap.accessory.bean.ServiceProfile> a_renamed(byte[] bArr) throws com.heytap.accessory.b_renamed.f_renamed {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3274a, "Start parseServicesXML");
        synchronized (com.heytap.accessory.b_renamed.h_renamed.class) {
            java.lang.String str = new java.lang.String(bArr, 0, bArr.length);
            try {
                org.xmlpull.v1.XmlPullParserFactory xmlPullParserFactoryNewInstance = org.xmlpull.v1.XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                if (xmlPullParserNewPullParser != null) {
                    xmlPullParserNewPullParser.setInput(new java.io.StringReader(str));
                }
                if (xmlPullParserNewPullParser == null) {
                    return null;
                }
                com.heytap.accessory.b_renamed.b_renamed.a_renamed aVar = new com.heytap.accessory.b_renamed.b_renamed.a_renamed();
                try {
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType == 3) {
                            if (aVar.b_renamed(xmlPullParserNewPullParser)) {
                                arrayList.add(aVar.b_renamed());
                                aVar.a_renamed();
                            }
                        } else if (eventType == 2) {
                            aVar.a_renamed(xmlPullParserNewPullParser);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3274a, "End parse profile: Unable to parse the accessory services configuration file");
                        throw new com.heytap.accessory.b_renamed.f_renamed("Unable to parse the accessory services configuration file");
                    }
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3274a, "End parse profile:".concat(java.lang.String.valueOf(arrayList)));
                    return arrayList;
                } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException e_renamed) {
                    throw new com.heytap.accessory.b_renamed.f_renamed(e_renamed);
                }
            } catch (org.xmlpull.v1.XmlPullParserException unused) {
                throw new com.heytap.accessory.b_renamed.f_renamed("XmlPullParserFactory Exception for Accssory Service profile XML file");
            }
        }
    }

    private java.lang.String[] b_renamed(java.lang.String str) throws com.heytap.accessory.b_renamed.f_renamed {
        java.lang.String strB;
        java.lang.String strB2;
        try {
            strB = com.heytap.accessory.b_renamed.j_renamed.b_renamed(this.f3276c, str, "InternalAccessoryServicesLocation");
        } catch (com.heytap.accessory.b_renamed.f_renamed e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3274a, "get internalServiceConfig failed", e_renamed);
            strB = null;
        }
        try {
            strB2 = com.heytap.accessory.b_renamed.j_renamed.b_renamed(this.f3276c, str, "AccessoryServicesLocation");
        } catch (com.heytap.accessory.b_renamed.f_renamed e2) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3274a, "get serviceConfig failed", e2);
            strB2 = null;
        }
        if (strB == null && strB2 == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3274a, "No meta data found with key:AccessoryServicesLocation");
            return null;
        }
        if (strB != null && strB2 == null) {
            java.lang.String[] strArr = {strB};
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3274a, "internalServiceConfig : ".concat(java.lang.String.valueOf(strB)));
            return strArr;
        }
        if (strB == null) {
            java.lang.String[] strArr2 = {strB2};
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3274a, "serviceConfig : ".concat(java.lang.String.valueOf(strB2)));
            return strArr2;
        }
        java.lang.String[] strArr3 = {strB2, strB};
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3274a, "internalServiceConfig : " + strB + " serviceConfig : " + strB2);
        return strArr3;
    }
}
