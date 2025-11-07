package com.oplus.shield.b_renamed;

/* compiled from: SignVerifyUtils.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7636a = java.security.Signature.class.getSimpleName();

    public static boolean a_renamed(android.content.Context context, java.lang.String str, byte[] bArr, int i_renamed, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) throws java.security.NoSuchAlgorithmException, java.security.SignatureException, java.security.InvalidKeyException {
        boolean zVerify;
        java.security.PublicKey publicKeyA;
        byte[] bArrA = com.oplus.shield.b_renamed.b_renamed.a_renamed(str, com.oplus.shield.b_renamed.b_renamed.a_renamed(context, str));
        byte[] bArr6 = new byte[bArrA.length + i_renamed + 10];
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr, 0, bArr6, 0, 1);
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr2, 0, bArr6, 1, 1);
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArrA, 0, bArr6, 2, bArrA.length);
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr3, 0, bArr6, bArrA.length + 2, 4);
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr4, 0, bArr6, bArrA.length + 6, i_renamed);
        com.oplus.shield.b_renamed.h_renamed.a_renamed(com.oplus.shield.b_renamed.h_renamed.a_renamed(i_renamed), 0, bArr6, bArrA.length + i_renamed + 6, 4);
        try {
            java.security.Signature signature = java.security.Signature.getInstance("SHA256withECDSA");
            java.util.List<com.oplus.shield.authcode.a_renamed.b_renamed> listA = a_renamed();
            zVerify = false;
            for (int i2 = 0; i2 < listA.size(); i2++) {
                try {
                    if ("OK".equals(listA.get(i2).b_renamed()) && (publicKeyA = a_renamed(com.oplus.shield.b_renamed.a_renamed.a_renamed(listA.get(i2).a_renamed()), "EC")) != null) {
                        signature.initVerify(publicKeyA);
                        signature.update(bArr6);
                        zVerify = signature.verify(bArr5);
                        if (zVerify) {
                            break;
                        }
                    }
                } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | java.security.SignatureException e_renamed) {
                    e_renamed = e_renamed;
                    e_renamed.printStackTrace();
                    com.oplus.shield.b_renamed.d_renamed.b_renamed("Verify signing get an_renamed exception is_renamed " + e_renamed.getMessage());
                    return zVerify;
                }
            }
        } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | java.security.SignatureException e2) {
            e_renamed = e2;
            zVerify = false;
        }
        return zVerify;
    }

    private static java.util.List<com.oplus.shield.authcode.a_renamed.b_renamed> a_renamed() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.oplus.shield.authcode.a_renamed.b_renamed bVar = new com.oplus.shield.authcode.a_renamed.b_renamed();
        bVar.a_renamed("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEvE0DoqARwzQKOb/b0cx7B0BQ4Ux8mTdND8rX9KHproZAuOP/M049VdcJ53sjVujUF1URD4IGMtkId2QYwXoDHw==");
        bVar.b_renamed("OK");
        arrayList.add(bVar);
        return arrayList;
    }

    private static java.security.PublicKey a_renamed(byte[] bArr, java.lang.String str) {
        try {
            return java.security.KeyFactory.getInstance(str).generatePublic(new java.security.spec.X509EncodedKeySpec(bArr));
        } catch (java.security.NoSuchAlgorithmException | java.security.spec.InvalidKeySpecException e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.shield.b_renamed.d_renamed.b_renamed("convertPublicKey get exception - " + e_renamed.getMessage());
            return null;
        }
    }
}
