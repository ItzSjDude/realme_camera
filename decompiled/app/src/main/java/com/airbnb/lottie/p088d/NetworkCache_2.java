package com.airbnb.lottie.p088d;

import android.util.Pair;
import com.airbnb.lottie.p091f.Logger_3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_5.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class NetworkCache_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final LottieNetworkCacheProvider f5725a;

    public NetworkCache_2(LottieNetworkCacheProvider interfaceC1141e) {
        this.f5725a = interfaceC1141e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Pair<FileExtension_2, InputStream> m5870a(String str) {
        FileExtension_2 enumC1139c;
        try {
            File fileM5869b = m5869b(str);
            if (fileM5869b == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileM5869b);
            if (fileM5869b.getAbsolutePath().endsWith(".zip")) {
                enumC1139c = FileExtension_2.ZIP;
            } else {
                enumC1139c = FileExtension_2.JSON;
            }
            Logger_3.m6098a("Cache hit for " + str + " at " + fileM5869b.getAbsolutePath());
            return new Pair<>(enumC1139c, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    File m5871a(String str, InputStream inputStream, FileExtension_2 enumC1139c) throws IOException {
        File file = new File(m5867a(), m5868a(str, enumC1139c, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int OplusGLSurfaceView_13 = inputStream.read(bArr);
                    if (OplusGLSurfaceView_13 != -1) {
                        fileOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5872a(String str, FileExtension_2 enumC1139c) {
        File file = new File(m5867a(), m5868a(str, enumC1139c, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        Logger_3.m6098a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        Logger_3.m6100b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private File m5869b(String str) throws FileNotFoundException {
        File file = new File(m5867a(), m5868a(str, FileExtension_2.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(m5867a(), m5868a(str, FileExtension_2.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private File m5867a() {
        File fileMo5640a = this.f5725a.mo5640a();
        if (fileMo5640a.isFile()) {
            fileMo5640a.delete();
        }
        if (!fileMo5640a.exists()) {
            fileMo5640a.mkdirs();
        }
        return fileMo5640a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m5868a(String str, FileExtension_2 enumC1139c, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? enumC1139c.tempExtension() : enumC1139c.extension);
        return sb.toString();
    }
}
