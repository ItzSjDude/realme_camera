package com.oplus.camera.g_renamed;

/* compiled from: OplusExif.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> f4562a = new java.util.concurrent.ConcurrentHashMap<>();

    private static void a_renamed() {
        f4562a.put("beauty", 2);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA, 4);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO, 8);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO, 8);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO, 8);
        f4562a.put("portrait", 16);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL, 256);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER, 512);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT, 2048);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, 8192);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO, 16384);
        f4562a.put(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_DOUBLE_EXPOSURE, 32768);
    }

    public static int a_renamed(java.lang.String str, int i_renamed) {
        if (f4562a.isEmpty()) {
            a_renamed();
        }
        return (str == null || f4562a.get(str) == null) ? i_renamed : f4562a.get(str).intValue() | i_renamed;
    }

    public static java.lang.String b_renamed(java.lang.String str, int i_renamed) {
        return com.oplus.exif.OplusExifTag.EXIF_TAG_PREFIX.concat(java.lang.String.valueOf(a_renamed(str, i_renamed)));
    }

    public static byte[] a_renamed(java.lang.String str) {
        byte[] bytes = str.getBytes();
        byte[] bArrA = com.oplus.camera.g_renamed.a_renamed.a_renamed(bytes.length + 8);
        byte[] bytes2 = "titl".getBytes();
        byte[] bArr = new byte[bytes.length + 8];
        java.lang.System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
        java.lang.System.arraycopy(bytes2, 0, bArr, 4, bytes2.length);
        java.lang.System.arraycopy(bytes, 0, bArr, 8, bytes.length);
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [long] */
    public static void a_renamed(java.io.File file, byte[] bArr) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        if (file.exists() && file.getName().endsWith(".mp4")) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            ?? CurrentTimeMillis = 0;
            java.io.RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    randomAccessFile = new java.io.RandomAccessFile(file, "rwd");
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = CurrentTimeMillis;
                }
            } catch (java.io.IOException e_renamed) {
                e_renamed = e_renamed;
            }
            try {
                java.util.List<com.oplus.camera.g_renamed.a_renamed> listA = a_renamed(randomAccessFile);
                long j_renamed = 0;
                int i_renamed = 0;
                while (true) {
                    if (i_renamed < listA.size()) {
                        com.oplus.camera.g_renamed.a_renamed aVar = listA.get(i_renamed);
                        if ("moov".equals(aVar.f4540b)) {
                            if (listA.size() - 1 == i_renamed) {
                                randomAccessFile.seek(j_renamed);
                                randomAccessFile.write(com.oplus.camera.g_renamed.a_renamed.a_renamed(aVar.f4539a + bArr.length));
                                randomAccessFile.seek(j_renamed + aVar.f4539a);
                                randomAccessFile.write(bArr);
                            } else {
                                int i2 = i_renamed + 1;
                                if ("free".equals(listA.get(i2).f4540b)) {
                                    randomAccessFile.seek(j_renamed);
                                    randomAccessFile.write(com.oplus.camera.g_renamed.a_renamed.a_renamed(aVar.f4539a + bArr.length));
                                    long j2 = j_renamed + aVar.f4539a;
                                    randomAccessFile.seek(j2);
                                    byte[] bArr2 = new byte[bArr.length];
                                    int i3 = randomAccessFile.read(bArr2);
                                    if (-1 != i3) {
                                        byte[] bArrA = com.oplus.camera.g_renamed.a_renamed.a_renamed(listA.get(i2).f4539a - bArr.length);
                                        java.lang.System.arraycopy(bArrA, 0, bArr2, 0, bArrA.length);
                                        randomAccessFile.write(bArr2);
                                        randomAccessFile.seek(j2);
                                        randomAccessFile.write(bArr);
                                    } else {
                                        com.oplus.camera.e_renamed.a_renamed("OplusExif", "writeExifTag, read: " + i3);
                                    }
                                } else {
                                    com.oplus.camera.e_renamed.b_renamed("OplusExif", "writeExifTag, type: " + listA.get(i2).f4540b);
                                }
                            }
                        } else {
                            j_renamed += aVar.f4539a;
                            i_renamed++;
                        }
                    }
                }
                try {
                    randomAccessFile.close();
                    break;
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
            } catch (java.io.IOException e3) {
                e_renamed = e3;
                randomAccessFile2 = randomAccessFile;
                e_renamed.printStackTrace();
                com.oplus.camera.e_renamed.b_renamed("OplusExif", "writeExifTag, e_renamed: " + e_renamed);
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
                ?? sb = new java.lang.StringBuilder();
                sb.append("writeExifTag, cost: ");
                CurrentTimeMillis = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                sb.append(CurrentTimeMillis);
                sb.append("ms");
                com.oplus.camera.e_renamed.b_renamed("OplusExif", sb.toString());
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            ?? sb2 = new java.lang.StringBuilder();
            sb2.append("writeExifTag, cost: ");
            CurrentTimeMillis = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
            sb2.append(CurrentTimeMillis);
            sb2.append("ms");
            com.oplus.camera.e_renamed.b_renamed("OplusExif", sb2.toString());
        }
    }

    private static java.util.List<com.oplus.camera.g_renamed.a_renamed> a_renamed(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long size = randomAccessFile.getChannel().size();
        long j_renamed = 0;
        while (j_renamed < size - 1) {
            com.oplus.camera.g_renamed.a_renamed aVarB = b_renamed(randomAccessFile);
            arrayList.add(aVarB);
            j_renamed += aVarB.f4539a;
            randomAccessFile.seek(j_renamed);
            com.oplus.camera.e_renamed.b_renamed("OplusExif", "getAllBoxHeader, offset: " + j_renamed + ", BoxHeader is_renamed: " + aVarB.toString());
        }
        return arrayList;
    }

    private static com.oplus.camera.g_renamed.a_renamed b_renamed(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr) == -1) {
            throw new java.io.IOException("read box error.");
        }
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 1) {
            return new com.oplus.camera.g_renamed.a_renamed(bArr, false);
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[8];
        if (randomAccessFile.read(bArr3) == -1) {
            throw new java.io.IOException("read large box error.");
        }
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 8);
        java.lang.System.arraycopy(bArr3, 0, bArr2, 8, 8);
        return new com.oplus.camera.g_renamed.a_renamed(bArr2, true);
    }
}
