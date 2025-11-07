package com.oplus.camera.sticker.download.thumbnail;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.p166b.HttpRequestHelper;
import com.oplus.camera.sticker.p167c.FileUtils;
import com.oplus.camera.sticker.p167c.MD5Utils;
import java.io.File;

/* compiled from: ThumbnailDownloadThread.java */
/* renamed from: com.oplus.camera.sticker.download.thumbnail.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ThumbnailDownloadThread implements Runnable {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f16243a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IThumbDownloadTask f16244b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f16245c;

    /* compiled from: ThumbnailDownloadThread.java */
    /* renamed from: com.oplus.camera.sticker.download.thumbnail.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16923a(Context context, boolean z, String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo16924b(Context context, boolean z, String str);
    }

    public ThumbnailDownloadThread(Context context, IThumbDownloadTask interfaceC2996a, PlatformImplementations.kt_3 aVar) {
        this.f16243a = null;
        this.f16244b = null;
        this.f16245c = null;
        this.f16243a = context;
        this.f16244b = interfaceC2996a;
        this.f16245c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String firstDownloadUrl = this.f16244b.getFirstDownloadUrl();
        if (!TextUtils.isEmpty(firstDownloadUrl)) {
            final String downloadFilePath = this.f16244b.getDownloadFilePath(this.f16243a, firstDownloadUrl);
            if (!m16927a(downloadFilePath, this.f16244b.getFirstDownloadFileMd5())) {
                m16926a(firstDownloadUrl, downloadFilePath, new HttpRequestHelper.PlatformImplementations.kt_3() { // from class: com.oplus.camera.sticker.download.thumbnail.IntrinsicsJvm.kt_4.1
                    @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo16792a() {
                        ThumbnailDownloadThread.this.f16244b.onFirstDownloadFinish(ThumbnailDownloadThread.this.f16243a, true, downloadFilePath);
                        ThumbnailDownloadThread.this.f16245c.mo16923a(ThumbnailDownloadThread.this.f16243a, true, downloadFilePath);
                        CameraLog.m12959b("ThumbnailDownloadThread", "onSuccess, download success!");
                    }

                    @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo16793a(String str) {
                        ThumbnailDownloadThread.this.f16244b.onFirstDownloadFinish(ThumbnailDownloadThread.this.f16243a, false, downloadFilePath);
                        ThumbnailDownloadThread.this.f16245c.mo16923a(ThumbnailDownloadThread.this.f16243a, false, downloadFilePath);
                        if (FileUtils.m16813a(new File(downloadFilePath))) {
                            CameraLog.m12959b("ThumbnailDownloadThread", "onFail, download fail! delete exist file fail!");
                        }
                        CameraLog.m12966e("ThumbnailDownloadThread", "download fail! errorMsg: " + str);
                    }
                });
            } else {
                CameraLog.m12959b("ThumbnailDownloadThread", "run, md5 is verified!, do not need download anymore!");
            }
        } else {
            CameraLog.m12959b("ThumbnailDownloadThread", "firstDownloadUrl is empty!");
        }
        String secondDownloadUrl = this.f16244b.getSecondDownloadUrl();
        if (!TextUtils.isEmpty(secondDownloadUrl)) {
            final String downloadFilePath2 = this.f16244b.getDownloadFilePath(this.f16243a, secondDownloadUrl);
            if (!m16927a(downloadFilePath2, this.f16244b.getSecondDownloadFileMd5())) {
                m16926a(secondDownloadUrl, downloadFilePath2, new HttpRequestHelper.PlatformImplementations.kt_3() { // from class: com.oplus.camera.sticker.download.thumbnail.IntrinsicsJvm.kt_4.2
                    @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo16792a() {
                        ThumbnailDownloadThread.this.f16244b.onSecondDownloadFinish(ThumbnailDownloadThread.this.f16243a, true, downloadFilePath2);
                        ThumbnailDownloadThread.this.f16245c.mo16924b(ThumbnailDownloadThread.this.f16243a, true, downloadFilePath2);
                        CameraLog.m12959b("ThumbnailDownloadThread", "onSuccess, second download success!");
                    }

                    @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo16793a(String str) {
                        ThumbnailDownloadThread.this.f16244b.onSecondDownloadFinish(ThumbnailDownloadThread.this.f16243a, false, downloadFilePath2);
                        ThumbnailDownloadThread.this.f16245c.mo16924b(ThumbnailDownloadThread.this.f16243a, false, downloadFilePath2);
                        if (FileUtils.m16813a(new File(downloadFilePath2))) {
                            CameraLog.m12959b("ThumbnailDownloadThread", "second download fail! delete exist file fail!");
                        }
                        CameraLog.m12966e("ThumbnailDownloadThread", "onFail, second download fail! errorMsg: " + str);
                    }
                });
                return;
            } else {
                CameraLog.m12959b("ThumbnailDownloadThread", "run, md5 is verified!, do not need download anymore!");
                return;
            }
        }
        CameraLog.m12959b("ThumbnailDownloadThread", "secondDownloadUrl is empty!");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16926a(String str, String str2, HttpRequestHelper.PlatformImplementations.kt_3 aVar) {
        CameraLog.m12959b("ThumbnailDownloadThread", "download, destPath: " + str2);
        HttpRequestHelper c2975a = new HttpRequestHelper(this.f16243a);
        c2975a.m16791a(c2975a.m16787a(HttpRequestHelper.IntrinsicsJvm.kt_4.POST, str, null, null), str2, aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m16927a(String str, String str2) {
        if (!new File(str).exists()) {
            CameraLog.m12966e("ThumbnailDownloadThread", "checkMd5, file not exist!");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            CameraLog.m12966e("ThumbnailDownloadThread", "checkMd5, empty md5!");
            return false;
        }
        return MD5Utils.m16823a(str, str2);
    }
}
