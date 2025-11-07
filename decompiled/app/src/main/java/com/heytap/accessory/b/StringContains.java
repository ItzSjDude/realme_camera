package com.heytap.accessory.b_renamed;

/* compiled from: XmlReader.java */
/* loaded from: classes2.dex */
public class j_renamed {
    public static synchronized byte[] a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.heytap.accessory.b_renamed.f_renamed {
        java.lang.StringBuilder sb;
        sb = new java.lang.StringBuilder();
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    com.heytap.accessory.a_renamed.a_renamed.a_renamed("XmlReader", "Start document");
                } else if (eventType == 2) {
                    sb.append(java.lang.String.format("<%s_renamed ", xmlPullParser.getName().trim()));
                    int attributeCount = xmlPullParser.getAttributeCount();
                    if (attributeCount > 0) {
                        for (int i_renamed = 0; i_renamed < attributeCount; i_renamed++) {
                            sb.append(java.lang.String.format("%s_renamed=\"%s_renamed\"", xmlPullParser.getAttributeName(i_renamed).trim(), xmlPullParser.getAttributeValue(i_renamed).trim()));
                        }
                    }
                    sb.append(">");
                } else if (eventType == 3) {
                    sb.append(java.lang.String.format("</%s_renamed>", xmlPullParser.getName()));
                } else if (eventType == 4) {
                    sb.append(xmlPullParser.getText().trim());
                }
                if (sb.length() < 65529) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new com.heytap.accessory.b_renamed.f_renamed("Accessory Service XML is_renamed too long! Services XML cannot be_renamed more than 64k in_renamed size");
                }
            }
        } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException e_renamed) {
            throw new com.heytap.accessory.b_renamed.f_renamed(e_renamed);
        }
        return sb.toString().getBytes(com.heytap.accessory.b_renamed.g_renamed.d_renamed());
    }

    public static synchronized byte[] a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) throws com.heytap.accessory.b_renamed.f_renamed {
        byte[] bArrA;
        if (str2.startsWith("/res")) {
            java.lang.String strSubstring = str2.substring(str2.lastIndexOf(java.io.File.separator) + 1, str2.lastIndexOf("."));
            com.heytap.accessory.a_renamed.a_renamed.b_renamed("XmlReader", "Fetching xml from /res/xml/".concat(java.lang.String.valueOf(strSubstring)));
            android.content.res.XmlResourceParser xml = null;
            try {
                try {
                    android.content.res.Resources resourcesA = a_renamed(context, str);
                    xml = resourcesA.getXml(resourcesA.getIdentifier(strSubstring, "xml", str));
                    bArrA = a_renamed(xml);
                } finally {
                    if (xml != null) {
                        xml.close();
                    }
                }
            } catch (android.content.res.Resources.NotFoundException e_renamed) {
                throw new com.heytap.accessory.b_renamed.f_renamed("configuration XML file not found at_renamed:" + str2 + ", pkg:" + str, e_renamed);
            } catch (java.lang.Exception e2) {
                throw new com.heytap.accessory.b_renamed.f_renamed("configuration XML file parse failed:" + str2 + ", pkg:" + str, e2);
            }
        } else {
            if (!str2.startsWith("/assets/")) {
                throw new com.heytap.accessory.b_renamed.f_renamed("Endpoint profile xml must be_renamed in_renamed /res or /assets directory.");
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed("XmlReader", "Fetching xml from /assets");
            try {
                java.io.InputStream inputStreamOpen = context.getAssets().open(str2.substring(8));
                try {
                    org.xmlpull.v1.XmlPullParserFactory xmlPullParserFactoryNewInstance = org.xmlpull.v1.XmlPullParserFactory.newInstance();
                    xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                    org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                    xmlPullParserNewPullParser.setInput(inputStreamOpen, com.heytap.accessory.b_renamed.g_renamed.d_renamed());
                    byte[] bArrA2 = a_renamed(xmlPullParserNewPullParser);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    bArrA = bArrA2;
                } catch (java.lang.Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (java.lang.Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException e3) {
                throw new com.heytap.accessory.b_renamed.f_renamed("Parsing Accessory service configuration failed from:".concat(java.lang.String.valueOf(str2)), e3);
            }
        }
        return bArrA;
    }

    public static java.lang.String b_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) throws com.heytap.accessory.b_renamed.f_renamed {
        java.lang.String str3 = "Unable to fetch metadata: " + str2 + ", did you forget to add " + str2 + " in_renamed manifest?";
        try {
            android.os.Bundle bundle = context.getApplicationContext().getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed("XmlReader", str3);
                throw new com.heytap.accessory.b_renamed.f_renamed(str3);
            }
            java.lang.String string = bundle.getString(str2, null);
            if (string == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed("XmlReader", "No meta data found with key: " + str2 + " in_renamed " + str);
            }
            return string;
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed("XmlReader", str3);
            throw new com.heytap.accessory.b_renamed.f_renamed(str3, e_renamed);
        }
    }

    public static int a_renamed(java.lang.String str) {
        int i_renamed = 0;
        for (java.lang.String str2 : str.split("\\|")) {
            if ("BLE".equalsIgnoreCase(str2)) {
                i_renamed |= 4;
            }
            if ("BT".equalsIgnoreCase(str2)) {
                i_renamed |= 2;
            }
            if ("WIFI".equalsIgnoreCase(str2)) {
                i_renamed = i_renamed | 1 | 8;
            }
            if ("ALL".equalsIgnoreCase(str2)) {
                i_renamed |= 255;
            }
        }
        return i_renamed;
    }

    public static android.content.res.Resources a_renamed(android.content.Context context, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        return context.getPackageManager().getResourcesForApplication(str);
    }
}
