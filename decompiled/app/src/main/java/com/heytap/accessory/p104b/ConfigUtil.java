package com.heytap.accessory.p104b;

import android.content.Context;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.p103a.SdkLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ConfigUtil.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ConfigUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9493a = "IntrinsicsJvm.kt_5";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ConfigUtil f9494b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Context f9495c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private HashMap<String, ServiceProfile> f9496d;

    private ConfigUtil(Context context) {
        this.f9495c = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized boolean m8583a() throws ResourceParserException {
        synchronized (ConfigUtil.class) {
            byte[][] bArrM8608a = ServiceXmlReader.m8605a(this.f9495c).m8608a(this.f9495c.getPackageName());
            if (bArrM8608a == null) {
                throw new ResourceParserException("readXml failed");
            }
            ArrayList<ServiceProfile> arrayList = new ArrayList();
            for (byte[] bArr : bArrM8608a) {
                try {
                    List<ServiceProfile> listM8606a = ServiceXmlReader.m8606a(bArr);
                    if (listM8606a != null && !listM8606a.isEmpty()) {
                        arrayList.addAll(listM8606a);
                    }
                } catch (ResourceParserException COUIBaseListPopupWindow_8) {
                    throw new ResourceParserException(COUIBaseListPopupWindow_8);
                }
            }
            for (ServiceProfile serviceProfile : arrayList) {
                if (this.f9496d == null) {
                    this.f9496d = new HashMap<>();
                }
                this.f9496d.put(serviceProfile.getServiceImpl(), serviceProfile);
            }
        }
        SdkLog.m8381c(f9493a, "End document");
        if (this.f9496d == null) {
            throw new ResourceParserException("Unable to parse the accessory services configuration file");
        }
        SdkLog.m8378b(f9493a, "parse the accessory services size:" + this.f9496d.size());
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized ConfigUtil m8582a(Context context) {
        if (f9494b == null) {
            f9494b = new ConfigUtil(context);
        }
        return f9494b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized ServiceProfile m8584a(String str) {
        if (this.f9496d == null) {
            try {
                m8583a();
            } catch (ResourceParserException COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(f9493a, COUIBaseListPopupWindow_8);
            }
        }
        if (this.f9496d != null && this.f9496d.get(str) != null) {
            return this.f9496d.get(str);
        }
        SdkLog.m8383e(f9493a, "fetchServicesDescription: Class not found in registered list".concat(String.valueOf(str)));
        return null;
    }
}
