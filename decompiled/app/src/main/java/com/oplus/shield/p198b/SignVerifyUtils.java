package com.oplus.shield.p198b;

import android.content.Context;
import com.oplus.shield.authcode.p197a.PublicKeyInfo;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SignVerifyUtils.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class SignVerifyUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23778a = Signature.class.getSimpleName();

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25209a(Context context, String str, byte[] bArr, int OplusGLSurfaceView_13, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        boolean zVerify;
        PublicKey publicKeyM25207a;
        byte[] bArrM25188a = CertUtils.m25188a(str, CertUtils.m25183a(context, str));
        byte[] bArr6 = new byte[bArrM25188a.length + OplusGLSurfaceView_13 + 10];
        SystemUtils.m25212a(bArr, 0, bArr6, 0, 1);
        SystemUtils.m25212a(bArr2, 0, bArr6, 1, 1);
        SystemUtils.m25212a(bArrM25188a, 0, bArr6, 2, bArrM25188a.length);
        SystemUtils.m25212a(bArr3, 0, bArr6, bArrM25188a.length + 2, 4);
        SystemUtils.m25212a(bArr4, 0, bArr6, bArrM25188a.length + 6, OplusGLSurfaceView_13);
        SystemUtils.m25212a(SystemUtils.m25213a(OplusGLSurfaceView_13), 0, bArr6, bArrM25188a.length + OplusGLSurfaceView_13 + 6, 4);
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            List<PublicKeyInfo> listM25208a = m25208a();
            zVerify = false;
            for (int i2 = 0; i2 < listM25208a.size(); i2++) {
                try {
                    if ("OK".equals(listM25208a.get(i2).m25143b()) && (publicKeyM25207a = m25207a(Base64Utils.m25182a(listM25208a.get(i2).m25141a()), "EC")) != null) {
                        signature.initVerify(publicKeyM25207a);
                        signature.update(bArr6);
                        zVerify = signature.verify(bArr5);
                        if (zVerify) {
                            break;
                        }
                    }
                } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                    COUIBaseListPopupWindow_8.printStackTrace();
                    PLog.m25195b("Verify signing get an exception is " + COUIBaseListPopupWindow_8.getMessage());
                    return zVerify;
                }
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e2) {
            COUIBaseListPopupWindow_8 = e2;
            zVerify = false;
        }
        return zVerify;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<PublicKeyInfo> m25208a() {
        ArrayList arrayList = new ArrayList();
        PublicKeyInfo c3692b = new PublicKeyInfo();
        c3692b.m25142a("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEvE0DoqARwzQKOb/b0cx7B0BQ4Ux8mTdND8rX9KHproZAuOP/M049VdcJ53sjVujUF1URD4IGMtkId2QYwXoDHw==");
        c3692b.m25144b("OK");
        arrayList.add(c3692b);
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PublicKey m25207a(byte[] bArr, String str) {
        try {
            return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            PLog.m25195b("convertPublicKey get exception - " + COUIBaseListPopupWindow_8.getMessage());
            return null;
        }
    }
}
