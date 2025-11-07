package com.heytap.accessory.p104b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.heytap.accessory.p103a.SdkLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: XmlReader.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class XmlReader {
    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized byte[] m8613a(XmlPullParser xmlPullParser) throws ResourceParserException {
        StringBuilder sb;
        sb = new StringBuilder();
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    SdkLog.m8375a("XmlReader", "Start document");
                } else if (eventType == 2) {
                    sb.append(String.format("<%s ", xmlPullParser.getName().trim()));
                    int attributeCount = xmlPullParser.getAttributeCount();
                    if (attributeCount > 0) {
                        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < attributeCount; OplusGLSurfaceView_13++) {
                            sb.append(String.format("%s=\"%s\"", xmlPullParser.getAttributeName(OplusGLSurfaceView_13).trim(), xmlPullParser.getAttributeValue(OplusGLSurfaceView_13).trim()));
                        }
                    }
                    sb.append(">");
                } else if (eventType == 3) {
                    sb.append(String.format("</%s>", xmlPullParser.getName()));
                } else if (eventType == 4) {
                    sb.append(xmlPullParser.getText().trim());
                }
                if (sb.length() < 65529) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new ResourceParserException("Accessory Service XML is too long! Services XML cannot be more than 64k in size");
                }
            }
        } catch (IOException | XmlPullParserException COUIBaseListPopupWindow_8) {
            throw new ResourceParserException(COUIBaseListPopupWindow_8);
        }
        return sb.toString().getBytes(SdkConfig.m8599d());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized byte[] m8612a(Context context, String str, String str2) throws ResourceParserException {
        byte[] bArrM8613a;
        if (str2.startsWith("/res")) {
            String strSubstring = str2.substring(str2.lastIndexOf(File.separator) + 1, str2.lastIndexOf("."));
            SdkLog.m8378b("XmlReader", "Fetching xml from /res/xml/".concat(String.valueOf(strSubstring)));
            XmlResourceParser xml = null;
            try {
                try {
                    Resources resourcesM8611a = m8611a(context, str);
                    xml = resourcesM8611a.getXml(resourcesM8611a.getIdentifier(strSubstring, "xml", str));
                    bArrM8613a = m8613a(xml);
                } finally {
                    if (xml != null) {
                        xml.close();
                    }
                }
            } catch (Resources.NotFoundException COUIBaseListPopupWindow_8) {
                throw new ResourceParserException("configuration XML file not found at:" + str2 + ", pkg:" + str, COUIBaseListPopupWindow_8);
            } catch (Exception e2) {
                throw new ResourceParserException("configuration XML file parse failed:" + str2 + ", pkg:" + str, e2);
            }
        } else {
            if (!str2.startsWith("/assets/")) {
                throw new ResourceParserException("Endpoint profile xml must be in /res or /assets directory.");
            }
            SdkLog.m8378b("XmlReader", "Fetching xml from /assets");
            try {
                InputStream inputStreamOpen = context.getAssets().open(str2.substring(8));
                try {
                    XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                    xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                    XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                    xmlPullParserNewPullParser.setInput(inputStreamOpen, SdkConfig.m8599d());
                    byte[] bArrM8613a2 = m8613a(xmlPullParserNewPullParser);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    bArrM8613a = bArrM8613a2;
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException | XmlPullParserException e3) {
                throw new ResourceParserException("Parsing Accessory service configuration failed from:".concat(String.valueOf(str2)), e3);
            }
        }
        return bArrM8613a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m8614b(Context context, String str, String str2) throws ResourceParserException {
        String str3 = "Unable to fetch metadata: " + str2 + ", did you forget to add " + str2 + " in manifest?";
        try {
            Bundle bundle = context.getApplicationContext().getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle == null) {
                SdkLog.m8383e("XmlReader", str3);
                throw new ResourceParserException(str3);
            }
            String string = bundle.getString(str2, null);
            if (string == null) {
                SdkLog.m8383e("XmlReader", "No meta data found with key: " + str2 + " in " + str);
            }
            return string;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e("XmlReader", str3);
            throw new ResourceParserException(str3, COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m8610a(String str) {
        int OplusGLSurfaceView_13 = 0;
        for (String str2 : str.split("\\|")) {
            if ("BLE".equalsIgnoreCase(str2)) {
                OplusGLSurfaceView_13 |= 4;
            }
            if ("BT".equalsIgnoreCase(str2)) {
                OplusGLSurfaceView_13 |= 2;
            }
            if ("WIFI".equalsIgnoreCase(str2)) {
                OplusGLSurfaceView_13 = OplusGLSurfaceView_13 | 1 | 8;
            }
            if ("ALL".equalsIgnoreCase(str2)) {
                OplusGLSurfaceView_13 |= 255;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Resources m8611a(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getResourcesForApplication(str);
    }
}
