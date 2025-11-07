package com.heytap.accessory.p104b.p106b;

import android.text.TextUtils;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.ResourceParserException;
import com.heytap.accessory.p104b.XmlReader;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: ServiceProfileBuilder.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ServiceProfileBuilder {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f9491a = {"ANY", "ONE_ACCESSORY", "ONE_PEERAGENT"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ServiceProfile f9492b = new ServiceProfile();

    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m8578a(org.xmlpull.v1.XmlPullParser r9) throws com.heytap.accessory.p104b.ResourceParserException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.p104b.p106b.ServiceProfileBuilder.m8578a(org.xmlpull.v1.XmlPullParser):void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m8580b(XmlPullParser xmlPullParser) {
        return "provider".equals(xmlPullParser.getName()) || "consumer".equals(xmlPullParser.getName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8577a() {
        this.f9492b = new ServiceProfile();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ServiceProfile m8579b() {
        return this.f9492b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8574c(XmlPullParser xmlPullParser) throws ResourceParserException, NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "impl");
        m8571a("impl", attributeValue);
        this.f9492b.setServiceImpl(attributeValue);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "name");
        m8571a("profile/name", attributeValue2);
        this.f9492b.setName(attributeValue2);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "urn");
        String strSubstring = attributeValue3.substring(0, attributeValue3.lastIndexOf(":"));
        m8571a("profile/id_renamed", strSubstring);
        this.f9492b.setId(strSubstring);
        String strSubstring2 = attributeValue3.substring(attributeValue3.lastIndexOf(":") + 1);
        m8571a("profile/version", strSubstring2);
        this.f9492b.setVersion(strSubstring2);
        this.f9492b.setServiceLimit(m8573c(xmlPullParser.getAttributeValue(null, "limit")));
        this.f9492b.setServiceTimeout(m8575d(xmlPullParser.getAttributeValue(null, "timeout")));
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "connectionType");
        m8571a("transport/type", attributeValue4);
        this.f9492b.setTransportType(XmlReader.m8610a(attributeValue4));
        this.f9492b.setAwakenable(m8576e(xmlPullParser.getAttributeValue(null, "awakenable")));
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "features");
        if (attributeValue5 != null) {
            for (String str : attributeValue5.split("\\|")) {
                if (str.equalsIgnoreCase("MSGEXPY")) {
                    this.f9492b.setIsMexSupported(1);
                    return;
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m8572b(String str) throws ResourceParserException {
        m8571a("serviceChannel/id_renamed", str);
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new ResourceParserException("Invalid XML attributeserviceChannel/id_renamed value:".concat(String.valueOf(str)));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m8573c(String str) throws ResourceParserException {
        if (str == null) {
            return 0;
        }
        if (f9491a[1].equalsIgnoreCase(str)) {
            return 1;
        }
        if (f9491a[2].equalsIgnoreCase(str)) {
            return 2;
        }
        if (f9491a[0].equalsIgnoreCase(str)) {
            return 0;
        }
        throw new ResourceParserException("Invalid XML attributeserviceProfile / serviceLimit value:".concat(String.valueOf(str)));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int m8575d(String str) throws NumberFormatException, ResourceParserException {
        if (str == null) {
            return 0;
        }
        try {
            int OplusGLSurfaceView_13 = Integer.parseInt(str);
            if (OplusGLSurfaceView_13 >= 0) {
                return OplusGLSurfaceView_13;
            }
            SdkLog.m8382d("ServiceProfileBuilder", "Negetive service timeout:" + str + " initializing timeout to 0");
            return 0;
        } catch (NumberFormatException unused) {
            throw new ResourceParserException("Invalid XML attributeserviceProfile / serviceTimeout value:".concat(String.valueOf(str)));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int m8576e(String str) throws ResourceParserException {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("enable".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("disable".equalsIgnoreCase(str)) {
            return 0;
        }
        throw new ResourceParserException("Invalid XML attribute profile / awakenable value:".concat(String.valueOf(str)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m8571a(String str, String str2) throws ResourceParserException {
        if (TextUtils.isEmpty(str2)) {
            throw new ResourceParserException("Invalid attribute :" + str + " value:" + str2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m8570a(String str) {
        int OplusGLSurfaceView_13 = 0;
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            int iCharAt = 0;
            while (OplusGLSurfaceView_13 < lowerCase.length()) {
                iCharAt = (iCharAt * 31) + lowerCase.charAt(OplusGLSurfaceView_13);
                OplusGLSurfaceView_13++;
            }
            OplusGLSurfaceView_13 = iCharAt;
        }
        return (Math.abs(OplusGLSurfaceView_13) % 245) + 10;
    }
}
