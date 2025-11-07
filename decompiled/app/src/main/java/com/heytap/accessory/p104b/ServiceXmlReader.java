package com.heytap.accessory.p104b;

import android.content.Context;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.p106b.ServiceProfileBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: ServiceXmlReader.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class ServiceXmlReader {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9504a = "COUIBaseListPopupWindow_10";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ServiceXmlReader f9505b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f9506c;

    private ServiceXmlReader(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context:" + ((Object) null));
        }
        this.f9506c = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized ServiceXmlReader m8605a(Context context) {
        if (f9505b == null) {
            f9505b = new ServiceXmlReader(context.getApplicationContext());
        }
        return f9505b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized byte[][] m8608a(String str) throws ResourceParserException {
        String[] strArrM8607b = m8607b(str);
        if (strArrM8607b == null) {
            SdkLog.m8382d(f9504a, "configFileLocationGroup is empty,config error with ".concat(String.valueOf(str)));
            return null;
        }
        byte[][] bArr = new byte[strArrM8607b.length][];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArrM8607b.length; OplusGLSurfaceView_13++) {
            String str2 = strArrM8607b[OplusGLSurfaceView_13];
            if (str2 != null) {
                bArr[OplusGLSurfaceView_13] = XmlReader.m8612a(this.f9506c, str, str2);
            }
        }
        return bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized List<ServiceProfile> m8606a(byte[] bArr) throws ResourceParserException {
        ArrayList arrayList = new ArrayList();
        SdkLog.m8378b(f9504a, "Start parseServicesXML");
        synchronized (ServiceXmlReader.class) {
            String str = new String(bArr, 0, bArr.length);
            try {
                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                if (xmlPullParserNewPullParser != null) {
                    xmlPullParserNewPullParser.setInput(new StringReader(str));
                }
                if (xmlPullParserNewPullParser == null) {
                    return null;
                }
                ServiceProfileBuilder c2159a = new ServiceProfileBuilder();
                try {
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType == 3) {
                            if (c2159a.m8580b(xmlPullParserNewPullParser)) {
                                arrayList.add(c2159a.m8579b());
                                c2159a.m8577a();
                            }
                        } else if (eventType == 2) {
                            c2159a.m8578a(xmlPullParserNewPullParser);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        SdkLog.m8382d(f9504a, "End parse profile: Unable to parse the accessory services configuration file");
                        throw new ResourceParserException("Unable to parse the accessory services configuration file");
                    }
                    SdkLog.m8378b(f9504a, "End parse profile:".concat(String.valueOf(arrayList)));
                    return arrayList;
                } catch (IOException | XmlPullParserException COUIBaseListPopupWindow_8) {
                    throw new ResourceParserException(COUIBaseListPopupWindow_8);
                }
            } catch (XmlPullParserException unused) {
                throw new ResourceParserException("XmlPullParserFactory Exception for Accssory Service profile XML file");
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String[] m8607b(String str) throws ResourceParserException {
        String strM8614b;
        String strM8614b2;
        try {
            strM8614b = XmlReader.m8614b(this.f9506c, str, "InternalAccessoryServicesLocation");
        } catch (ResourceParserException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(f9504a, "get internalServiceConfig failed", COUIBaseListPopupWindow_8);
            strM8614b = null;
        }
        try {
            strM8614b2 = XmlReader.m8614b(this.f9506c, str, "AccessoryServicesLocation");
        } catch (ResourceParserException e2) {
            SdkLog.m8379b(f9504a, "get serviceConfig failed", e2);
            strM8614b2 = null;
        }
        if (strM8614b == null && strM8614b2 == null) {
            SdkLog.m8383e(f9504a, "No meta data found with key:AccessoryServicesLocation");
            return null;
        }
        if (strM8614b != null && strM8614b2 == null) {
            String[] strArr = {strM8614b};
            SdkLog.m8381c(f9504a, "internalServiceConfig : ".concat(String.valueOf(strM8614b)));
            return strArr;
        }
        if (strM8614b == null) {
            String[] strArr2 = {strM8614b2};
            SdkLog.m8381c(f9504a, "serviceConfig : ".concat(String.valueOf(strM8614b2)));
            return strArr2;
        }
        String[] strArr3 = {strM8614b2, strM8614b};
        SdkLog.m8381c(f9504a, "internalServiceConfig : " + strM8614b + " serviceConfig : " + strM8614b2);
        return strArr3;
    }
}
