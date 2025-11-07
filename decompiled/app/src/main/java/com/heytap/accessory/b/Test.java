package com.heytap.accessory.b_renamed;

/* compiled from: ConfigUtil.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f3268a = "d_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static com.heytap.accessory.b_renamed.d_renamed f3269b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.content.Context f3270c;
    private java.util.HashMap<java.lang.String, com.heytap.accessory.bean.ServiceProfile> d_renamed;

    private d_renamed(android.content.Context context) {
        this.f3270c = context;
    }

    private synchronized boolean a_renamed() throws com.heytap.accessory.b_renamed.f_renamed {
        synchronized (com.heytap.accessory.b_renamed.d_renamed.class) {
            byte[][] bArrA = com.heytap.accessory.b_renamed.h_renamed.a_renamed(this.f3270c).a_renamed(this.f3270c.getPackageName());
            if (bArrA == null) {
                throw new com.heytap.accessory.b_renamed.f_renamed("readXml failed");
            }
            java.util.ArrayList<com.heytap.accessory.bean.ServiceProfile> arrayList = new java.util.ArrayList();
            for (byte[] bArr : bArrA) {
                try {
                    java.util.List<com.heytap.accessory.bean.ServiceProfile> listA = com.heytap.accessory.b_renamed.h_renamed.a_renamed(bArr);
                    if (listA != null && !listA.isEmpty()) {
                        arrayList.addAll(listA);
                    }
                } catch (com.heytap.accessory.b_renamed.f_renamed e_renamed) {
                    throw new com.heytap.accessory.b_renamed.f_renamed(e_renamed);
                }
            }
            for (com.heytap.accessory.bean.ServiceProfile serviceProfile : arrayList) {
                if (this.d_renamed == null) {
                    this.d_renamed = new java.util.HashMap<>();
                }
                this.d_renamed.put(serviceProfile.getServiceImpl(), serviceProfile);
            }
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3268a, "End document");
        if (this.d_renamed == null) {
            throw new com.heytap.accessory.b_renamed.f_renamed("Unable to parse the accessory services configuration file");
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3268a, "parse the accessory services size:" + this.d_renamed.size());
        return true;
    }

    public static synchronized com.heytap.accessory.b_renamed.d_renamed a_renamed(android.content.Context context) {
        if (f3269b == null) {
            f3269b = new com.heytap.accessory.b_renamed.d_renamed(context);
        }
        return f3269b;
    }

    public synchronized com.heytap.accessory.bean.ServiceProfile a_renamed(java.lang.String str) {
        if (this.d_renamed == null) {
            try {
                a_renamed();
            } catch (com.heytap.accessory.b_renamed.f_renamed e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3268a, e_renamed);
            }
        }
        if (this.d_renamed != null && this.d_renamed.get(str) != null) {
            return this.d_renamed.get(str);
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3268a, "fetchServicesDescription: Class not found in_renamed registered list".concat(java.lang.String.valueOf(str)));
        return null;
    }
}
