package com.heytap.accessory.b_renamed.b_renamed;

/* compiled from: ServiceProfileBuilder.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f3266a = {"ANY", "ONE_ACCESSORY", "ONE_PEERAGENT"};

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.heytap.accessory.bean.ServiceProfile f3267b = new com.heytap.accessory.bean.ServiceProfile();

    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(org.xmlpull.v1.XmlPullParser r9) throws com.heytap.accessory.b_renamed.f_renamed, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.b_renamed.b_renamed.a_renamed.a_renamed(org.xmlpull.v1.XmlPullParser):void");
    }

    public boolean b_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return "provider".equals(xmlPullParser.getName()) || "consumer".equals(xmlPullParser.getName());
    }

    public void a_renamed() {
        this.f3267b = new com.heytap.accessory.bean.ServiceProfile();
    }

    public com.heytap.accessory.bean.ServiceProfile b_renamed() {
        return this.f3267b;
    }

    private void c_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.heytap.accessory.b_renamed.f_renamed, java.lang.NumberFormatException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "impl");
        a_renamed("impl", attributeValue);
        this.f3267b.setServiceImpl(attributeValue);
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue(null, "name");
        a_renamed("profile/name", attributeValue2);
        this.f3267b.setName(attributeValue2);
        java.lang.String attributeValue3 = xmlPullParser.getAttributeValue(null, "urn");
        java.lang.String strSubstring = attributeValue3.substring(0, attributeValue3.lastIndexOf(":"));
        a_renamed("profile/id_renamed", strSubstring);
        this.f3267b.setId(strSubstring);
        java.lang.String strSubstring2 = attributeValue3.substring(attributeValue3.lastIndexOf(":") + 1);
        a_renamed("profile/version", strSubstring2);
        this.f3267b.setVersion(strSubstring2);
        this.f3267b.setServiceLimit(c_renamed(xmlPullParser.getAttributeValue(null, "limit")));
        this.f3267b.setServiceTimeout(d_renamed(xmlPullParser.getAttributeValue(null, "timeout")));
        java.lang.String attributeValue4 = xmlPullParser.getAttributeValue(null, "connectionType");
        a_renamed("transport/type", attributeValue4);
        this.f3267b.setTransportType(com.heytap.accessory.b_renamed.j_renamed.a_renamed(attributeValue4));
        this.f3267b.setAwakenable(e_renamed(xmlPullParser.getAttributeValue(null, "awakenable")));
        java.lang.String attributeValue5 = xmlPullParser.getAttributeValue(null, "features");
        if (attributeValue5 != null) {
            for (java.lang.String str : attributeValue5.split("\\|")) {
                if (str.equalsIgnoreCase("MSGEXPY")) {
                    this.f3267b.setIsMexSupported(1);
                    return;
                }
            }
        }
    }

    private static int b_renamed(java.lang.String str) throws com.heytap.accessory.b_renamed.f_renamed {
        a_renamed("serviceChannel/id_renamed", str);
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException unused) {
            throw new com.heytap.accessory.b_renamed.f_renamed("Invalid XML attributeserviceChannel/id_renamed value:".concat(java.lang.String.valueOf(str)));
        }
    }

    private static int c_renamed(java.lang.String str) throws com.heytap.accessory.b_renamed.f_renamed {
        if (str == null) {
            return 0;
        }
        if (f3266a[1].equalsIgnoreCase(str)) {
            return 1;
        }
        if (f3266a[2].equalsIgnoreCase(str)) {
            return 2;
        }
        if (f3266a[0].equalsIgnoreCase(str)) {
            return 0;
        }
        throw new com.heytap.accessory.b_renamed.f_renamed("Invalid XML attributeserviceProfile / serviceLimit value:".concat(java.lang.String.valueOf(str)));
    }

    private static int d_renamed(java.lang.String str) throws java.lang.NumberFormatException, com.heytap.accessory.b_renamed.f_renamed {
        if (str == null) {
            return 0;
        }
        try {
            int i_renamed = java.lang.Integer.parseInt(str);
            if (i_renamed >= 0) {
                return i_renamed;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed("ServiceProfileBuilder", "Negetive service timeout:" + str + " initializing timeout to 0");
            return 0;
        } catch (java.lang.NumberFormatException unused) {
            throw new com.heytap.accessory.b_renamed.f_renamed("Invalid XML attributeserviceProfile / serviceTimeout value:".concat(java.lang.String.valueOf(str)));
        }
    }

    private static int e_renamed(java.lang.String str) throws com.heytap.accessory.b_renamed.f_renamed {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("enable".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("disable".equalsIgnoreCase(str)) {
            return 0;
        }
        throw new com.heytap.accessory.b_renamed.f_renamed("Invalid XML attribute profile / awakenable value:".concat(java.lang.String.valueOf(str)));
    }

    private static void a_renamed(java.lang.String str, java.lang.String str2) throws com.heytap.accessory.b_renamed.f_renamed {
        if (android.text.TextUtils.isEmpty(str2)) {
            throw new com.heytap.accessory.b_renamed.f_renamed("Invalid attribute :" + str + " value:" + str2);
        }
    }

    public static int a_renamed(java.lang.String str) {
        int i_renamed = 0;
        if (str != null && !str.isEmpty()) {
            java.lang.String lowerCase = str.toLowerCase();
            int iCharAt = 0;
            while (i_renamed < lowerCase.length()) {
                iCharAt = (iCharAt * 31) + lowerCase.charAt(i_renamed);
                i_renamed++;
            }
            i_renamed = iCharAt;
        }
        return (java.lang.Math.abs(i_renamed) % 245) + 10;
    }
}
