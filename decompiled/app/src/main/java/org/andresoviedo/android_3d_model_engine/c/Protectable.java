package org.andresoviedo.android_3d_model_engine.c_renamed;

/* compiled from: O3DModelLoaderTask.java */
/* loaded from: classes2.dex */
public class c_renamed extends org.andresoviedo.android_3d_model_engine.c_renamed.b_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    static final java.lang.String f7988b = "c_renamed";

    /* renamed from: c_renamed, reason: collision with root package name */
    com.b_renamed.a_renamed.g_renamed[] f7989c;

    public c_renamed(android.app.Activity activity, com.b_renamed.a_renamed.g_renamed[] gVarArr, org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed aVar) {
        super(activity, null, aVar);
        this.f7989c = gVarArr;
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.b_renamed
    protected java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> a_renamed() throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.b_renamed.a_renamed.g_renamed gVar : this.f7989c) {
            com.b_renamed.a_renamed.o_renamed oVar = new com.b_renamed.a_renamed.o_renamed();
            oVar.a_renamed(gVar);
            org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar2 = new org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed(oVar.a_renamed(), oVar.b_renamed());
            gVar2.f7982a = gVar.d_renamed != null;
            gVar2.a_renamed("O3DPHOTO_MODEL " + gVar);
            gVar2.a_renamed(oVar);
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            gVar2.a_renamed(4);
            gVar2.a_renamed(oVar.c_renamed());
            arrayList.add(gVar2);
        }
        return arrayList;
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.b_renamed
    protected void b_renamed(java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> list) throws java.lang.Exception {
        for (int i_renamed = 0; i_renamed < this.f7989c.length; i_renamed++) {
            try {
                a_renamed(this.f7989c[i_renamed], list.get(i_renamed));
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                return;
            }
        }
    }

    private void a_renamed(com.b_renamed.a_renamed.g_renamed gVar, org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar2) throws java.lang.Exception {
        float f_renamed;
        try {
            gVar2.k_renamed().b_renamed(gVar);
            int i_renamed = 0;
            gVar2.b_renamed(new float[]{5.0f, 5.0f, 5.0f});
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            gVar2.a_renamed(4);
            com.b_renamed.a_renamed.o_renamed oVarK = gVar2.k_renamed();
            java.nio.FloatBuffer floatBufferB = org.andresoviedo.a_renamed.a_renamed.d_renamed.b_renamed(oVarK.d_renamed * 3 * 4);
            gVar2.c_renamed(floatBufferB);
            gVar2.a_renamed(true);
            java.util.List<com.b_renamed.a_renamed.o_renamed.a_renamed> list = oVarK == null ? null : oVarK.f_renamed;
            if (list != null && list.size() == oVarK.f2370b) {
                java.nio.FloatBuffer floatBufferB2 = org.andresoviedo.a_renamed.a_renamed.d_renamed.b_renamed(oVarK.d_renamed * 3 * 4);
                java.nio.FloatBuffer floatBufferB3 = gVar.d_renamed != null ? org.andresoviedo.a_renamed.a_renamed.d_renamed.b_renamed(oVarK.d_renamed * 3) : null;
                int i2 = 0;
                while (i2 < oVarK.d_renamed) {
                    for (int i3 = i_renamed; i3 < 3; i3++) {
                        int i4 = (i2 * 3) + i3;
                        int i5 = oVarK.e_renamed.get(i4);
                        int i6 = i4 * 3;
                        floatBufferB.put(i6, oVarK.a_renamed().get(oVarK.e_renamed.get(i4) * 3));
                        floatBufferB.put(i6 + 1, oVarK.a_renamed().get((oVarK.e_renamed.get(i4) * 3) + 1));
                        floatBufferB.put(i6 + 2, oVarK.a_renamed().get((oVarK.e_renamed.get(i4) * 3) + 2));
                        com.b_renamed.a_renamed.o_renamed.a_renamed aVar = oVarK.f_renamed.get(i5);
                        floatBufferB2.put(aVar.f2372a).put(aVar.f2373b).put(aVar.f2374c).put(aVar.d_renamed);
                        if (gVar.d_renamed != null) {
                            floatBufferB3.put(gVar.d_renamed[i5] & 255);
                        }
                    }
                    i2++;
                    i_renamed = 0;
                }
                gVar2.d_renamed(floatBufferB2);
                if (gVar.d_renamed != null) {
                    gVar2.e_renamed(floatBufferB3);
                }
            }
            if (gVar.f2351a.length > 0) {
                java.nio.FloatBuffer floatBufferB4 = org.andresoviedo.a_renamed.a_renamed.d_renamed.b_renamed(oVarK.d_renamed * 3 * 2);
                for (int i7 = 0; i7 < oVarK.d_renamed; i7++) {
                    for (int i8 = 0; i8 < 3; i8++) {
                        int i9 = oVarK.e_renamed.get((i7 * 3) + i8) * 3;
                        float f2 = 1.0f - ((gVar.f2351a[i9 + 0] + 1.0f) / 2.0f);
                        float f3 = 1.0f - ((gVar.f2351a[i9 + 1] + 1.0f) / 2.0f);
                        if (gVar.f_renamed) {
                            f_renamed = 1.0f - f2;
                        } else {
                            f_renamed = f3;
                            f3 = f2;
                        }
                        floatBufferB4.put(f3).put(f_renamed);
                    }
                }
                gVar2.g_renamed(floatBufferB4);
            }
            gVar2.a_renamed(gVar.h_renamed);
        } catch (java.lang.Exception e_renamed) {
            com.b_renamed.a_renamed.b_renamed.a_renamed(f7988b, e_renamed.getMessage(), e_renamed);
            throw e_renamed;
        }
    }
}
