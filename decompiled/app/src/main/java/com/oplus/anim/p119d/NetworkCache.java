package com.oplus.anim.p119d;

import android.content.Context;
import android.util.Pair;
import com.oplus.anim.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
class NetworkCache {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f10345a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f10346b;

    NetworkCache(Context context, String str) {
        this.f10345a = context.getApplicationContext();
        this.f10346b = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m9145a(String str, FileExtension enumC2362a, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("effective_anim_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? enumC2362a.tempExtension() : enumC2362a.extension);
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Pair<FileExtension, InputStream> m9146a() {
        FileExtension enumC2362a;
        try {
            File fileM9144a = m9144a(this.f10346b);
            if (fileM9144a == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileM9144a);
            if (fileM9144a.getAbsolutePath().endsWith(".zip")) {
                enumC2362a = FileExtension.ZIP;
            } else {
                enumC2362a = FileExtension.JSON;
            }
            L.m9347a("Cache hit for " + this.f10346b + " at " + fileM9144a.getAbsolutePath());
            return new Pair<>(enumC2362a, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    File m9147a(InputStream inputStream, FileExtension enumC2362a) throws IOException {
        File file = new File(this.f10345a.getCacheDir(), m9145a(this.f10346b, enumC2362a, true));
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
    void m9148a(FileExtension enumC2362a) {
        File file = new File(this.f10345a.getCacheDir(), m9145a(this.f10346b, enumC2362a, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        L.m9347a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        L.m9348b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private File m9144a(String str) throws FileNotFoundException {
        File file = new File(this.f10345a.getCacheDir(), m9145a(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f10345a.getCacheDir(), m9145a(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }
}
