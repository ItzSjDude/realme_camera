package com.airbnb.lottie.p089e;

import com.airbnb.lottie.p084c.DocumentData_3;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class DocumentDataParser_2 implements ValueParser_2<DocumentData_3> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final DocumentDataParser_2 f5784a = new DocumentDataParser_2();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5785b = JsonReader.PlatformImplementations.kt_3.m5929a("t", "COUIBaseListPopupWindow_12", "s", "OplusGLSurfaceView_15", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private DocumentDataParser_2() {
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public DocumentData_3 mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        DocumentData_3.PlatformImplementations.kt_3 aVar = DocumentData_3.PlatformImplementations.kt_3.CENTER;
        abstractC1149c.mo5917c();
        DocumentData_3.PlatformImplementations.kt_3 aVar2 = aVar;
        String strMo5923i = null;
        String strMo5923i2 = null;
        int iMo5926l = 0;
        int iM5988a = 0;
        int iM5988a2 = 0;
        float fMo5925k = 0.0f;
        float fMo5925k2 = 0.0f;
        float fMo5925k3 = 0.0f;
        float fMo5925k4 = 0.0f;
        boolean zMo5924j = true;
        while (abstractC1149c.mo5919e()) {
            switch (abstractC1149c.mo5912a(f5785b)) {
                case 0:
                    strMo5923i = abstractC1149c.mo5923i();
                    break;
                case 1:
                    strMo5923i2 = abstractC1149c.mo5923i();
                    break;
                case 2:
                    fMo5925k = (float) abstractC1149c.mo5925k();
                    break;
                case 3:
                    int iMo5926l2 = abstractC1149c.mo5926l();
                    if (iMo5926l2 > DocumentData_3.PlatformImplementations.kt_3.CENTER.ordinal() || iMo5926l2 < 0) {
                        aVar2 = DocumentData_3.PlatformImplementations.kt_3.CENTER;
                        break;
                    } else {
                        aVar2 = DocumentData_3.PlatformImplementations.kt_3.values()[iMo5926l2];
                        break;
                    }
                    break;
                case 4:
                    iMo5926l = abstractC1149c.mo5926l();
                    break;
                case 5:
                    fMo5925k2 = (float) abstractC1149c.mo5925k();
                    break;
                case 6:
                    fMo5925k3 = (float) abstractC1149c.mo5925k();
                    break;
                case 7:
                    iM5988a = JsonUtils_3.m5988a(abstractC1149c);
                    break;
                case 8:
                    iM5988a2 = JsonUtils_3.m5988a(abstractC1149c);
                    break;
                case 9:
                    fMo5925k4 = (float) abstractC1149c.mo5925k();
                    break;
                case 10:
                    zMo5924j = abstractC1149c.mo5924j();
                    break;
                default:
                    abstractC1149c.mo5922h();
                    abstractC1149c.mo5927m();
                    break;
            }
        }
        abstractC1149c.mo5918d();
        return new DocumentData_3(strMo5923i, strMo5923i2, fMo5925k, aVar2, iMo5926l, fMo5925k2, fMo5925k3, iM5988a, iM5988a2, fMo5925k4, zMo5924j);
    }
}
