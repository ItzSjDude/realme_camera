package com.oplus.camera.p144g;

import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.exif.OplusExifTag;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: OplusExif.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class C2735b {

    /* renamed from: PlatformImplementations.kt_3 */
    private static ConcurrentHashMap<String, Integer> f13806a = new ConcurrentHashMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13775a() {
        f13806a.put("beauty", 2);
        f13806a.put(ApsConstant.CAPTURE_MODE_PANORAMA, 4);
        f13806a.put(ApsConstant.REC_MODE_FAST_VIDEO, 8);
        f13806a.put(ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO, 8);
        f13806a.put(ApsConstant.REC_MODE_TIMELASPE_PRO, 8);
        f13806a.put("portrait", 16);
        f13806a.put(ApsConstant.CAPTURE_MODE_PROFESSIONAL, 256);
        f13806a.put(ApsConstant.CAPTURE_MODE_STICKER, 512);
        f13806a.put(ApsConstant.CAPTURE_MODE_NIGHT, 2048);
        f13806a.put(ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, 8192);
        f13806a.put(ApsConstant.CAPTURE_MODE_ID_PHOTO, 16384);
        f13806a.put(ApsConstant.REC_MODE_DOUBLE_EXPOSURE, 32768);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m13773a(String str, int OplusGLSurfaceView_13) {
        if (f13806a.isEmpty()) {
            m13775a();
        }
        return (str == null || f13806a.get(str) == null) ? OplusGLSurfaceView_13 : f13806a.get(str).intValue() | OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m13779b(String str, int OplusGLSurfaceView_13) {
        return OplusExifTag.EXIF_TAG_PREFIX.concat(String.valueOf(m13773a(str, OplusGLSurfaceView_13)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m13777a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArrM13719a = MP4BoxHeader.m13719a(bytes.length + 8);
        byte[] bytes2 = "titl".getBytes();
        byte[] bArr = new byte[bytes.length + 8];
        System.arraycopy(bArrM13719a, 0, bArr, 0, bArrM13719a.length);
        System.arraycopy(bytes2, 0, bArr, 4, bytes2.length);
        System.arraycopy(bytes, 0, bArr, 8, bytes.length);
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [long] */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13776a(File file, byte[] bArr) throws Throwable {
        RandomAccessFile randomAccessFile;
        if (file.exists() && file.getName().endsWith(".mp4")) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ?? CurrentTimeMillis = 0;
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "rwd");
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = CurrentTimeMillis;
                }
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
            }
            try {
                List<MP4BoxHeader> listM13774a = m13774a(randomAccessFile);
                long OplusGLSurfaceView_15 = 0;
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 < listM13774a.size()) {
                        MP4BoxHeader c2726a = listM13774a.get(OplusGLSurfaceView_13);
                        if ("moov".equals(c2726a.f13755b)) {
                            if (listM13774a.size() - 1 == OplusGLSurfaceView_13) {
                                randomAccessFile.seek(OplusGLSurfaceView_15);
                                randomAccessFile.write(MP4BoxHeader.m13719a(c2726a.f13754a + bArr.length));
                                randomAccessFile.seek(OplusGLSurfaceView_15 + c2726a.f13754a);
                                randomAccessFile.write(bArr);
                            } else {
                                int i2 = OplusGLSurfaceView_13 + 1;
                                if ("free".equals(listM13774a.get(i2).f13755b)) {
                                    randomAccessFile.seek(OplusGLSurfaceView_15);
                                    randomAccessFile.write(MP4BoxHeader.m13719a(c2726a.f13754a + bArr.length));
                                    long j2 = OplusGLSurfaceView_15 + c2726a.f13754a;
                                    randomAccessFile.seek(j2);
                                    byte[] bArr2 = new byte[bArr.length];
                                    int i3 = randomAccessFile.read(bArr2);
                                    if (-1 != i3) {
                                        byte[] bArrM13719a = MP4BoxHeader.m13719a(listM13774a.get(i2).f13754a - bArr.length);
                                        System.arraycopy(bArrM13719a, 0, bArr2, 0, bArrM13719a.length);
                                        randomAccessFile.write(bArr2);
                                        randomAccessFile.seek(j2);
                                        randomAccessFile.write(bArr);
                                    } else {
                                        CameraLog.m12954a("OplusExif", "writeExifTag, read: " + i3);
                                    }
                                } else {
                                    CameraLog.m12959b("OplusExif", "writeExifTag, type: " + listM13774a.get(i2).f13755b);
                                }
                            }
                        } else {
                            OplusGLSurfaceView_15 += c2726a.f13754a;
                            OplusGLSurfaceView_13++;
                        }
                    }
                }
                try {
                    randomAccessFile.close();
                    break;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                COUIBaseListPopupWindow_8 = e3;
                randomAccessFile2 = randomAccessFile;
                COUIBaseListPopupWindow_8.printStackTrace();
                CameraLog.m12959b("OplusExif", "writeExifTag, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                ?? sb = new StringBuilder();
                sb.append("writeExifTag, cost: ");
                CurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis;
                sb.append(CurrentTimeMillis);
                sb.append("ms");
                CameraLog.m12959b("OplusExif", sb.toString());
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            ?? sb2 = new StringBuilder();
            sb2.append("writeExifTag, cost: ");
            CurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis;
            sb2.append(CurrentTimeMillis);
            sb2.append("ms");
            CameraLog.m12959b("OplusExif", sb2.toString());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<MP4BoxHeader> m13774a(RandomAccessFile randomAccessFile) throws IOException {
        ArrayList arrayList = new ArrayList();
        long size = randomAccessFile.getChannel().size();
        long OplusGLSurfaceView_15 = 0;
        while (OplusGLSurfaceView_15 < size - 1) {
            MP4BoxHeader c2726aM13778b = m13778b(randomAccessFile);
            arrayList.add(c2726aM13778b);
            OplusGLSurfaceView_15 += c2726aM13778b.f13754a;
            randomAccessFile.seek(OplusGLSurfaceView_15);
            CameraLog.m12959b("OplusExif", "getAllBoxHeader, offset: " + OplusGLSurfaceView_15 + ", BoxHeader is: " + c2726aM13778b.toString());
        }
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static MP4BoxHeader m13778b(RandomAccessFile randomAccessFile) throws IOException {
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr) == -1) {
            throw new IOException("read box error.");
        }
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 1) {
            return new MP4BoxHeader(bArr, false);
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[8];
        if (randomAccessFile.read(bArr3) == -1) {
            throw new IOException("read large box error.");
        }
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        System.arraycopy(bArr3, 0, bArr2, 8, 8);
        return new MP4BoxHeader(bArr2, true);
    }
}
