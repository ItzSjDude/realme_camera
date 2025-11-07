package com.oplus.camera.sticker.download.thumbnail;

/* compiled from: ThumbnailDownloadThread.java */
/* loaded from: classes2.dex */
public class b_renamed implements java.lang.Runnable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5461a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.download.thumbnail.a_renamed f5462b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.download.thumbnail.b_renamed.a_renamed f5463c;

    /* compiled from: ThumbnailDownloadThread.java */
    public interface a_renamed {
        void a_renamed(android.content.Context context, boolean z_renamed, java.lang.String str);

        void b_renamed(android.content.Context context, boolean z_renamed, java.lang.String str);
    }

    public b_renamed(android.content.Context context, com.oplus.camera.sticker.download.thumbnail.a_renamed aVar, com.oplus.camera.sticker.download.thumbnail.b_renamed.a_renamed aVar2) {
        this.f5461a = null;
        this.f5462b = null;
        this.f5463c = null;
        this.f5461a = context;
        this.f5462b = aVar;
        this.f5463c = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String firstDownloadUrl = this.f5462b.getFirstDownloadUrl();
        if (!android.text.TextUtils.isEmpty(firstDownloadUrl)) {
            final java.lang.String downloadFilePath = this.f5462b.getDownloadFilePath(this.f5461a, firstDownloadUrl);
            if (!a_renamed(downloadFilePath, this.f5462b.getFirstDownloadFileMd5())) {
                a_renamed(firstDownloadUrl, downloadFilePath, new com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2() { // from class: com.oplus.camera.sticker.download.thumbnail.b_renamed.1
                    @Override // com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2
                    public void a_renamed() {
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5462b.onFirstDownloadFinish(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, true, downloadFilePath);
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5463c.a_renamed(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, true, downloadFilePath);
                        com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "onSuccess, download success!");
                    }

                    @Override // com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2
                    public void a_renamed(java.lang.String str) {
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5462b.onFirstDownloadFinish(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, false, downloadFilePath);
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5463c.a_renamed(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, false, downloadFilePath);
                        if (com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(new java.io.File(downloadFilePath))) {
                            com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "onFail, download fail! delete exist file fail!");
                        }
                        com.oplus.camera.e_renamed.e_renamed("ThumbnailDownloadThread", "download fail! errorMsg: " + str);
                    }
                });
            } else {
                com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "run, md5 is_renamed verified!, do not need download anymore!");
            }
        } else {
            com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "firstDownloadUrl is_renamed empty!");
        }
        java.lang.String secondDownloadUrl = this.f5462b.getSecondDownloadUrl();
        if (!android.text.TextUtils.isEmpty(secondDownloadUrl)) {
            final java.lang.String downloadFilePath2 = this.f5462b.getDownloadFilePath(this.f5461a, secondDownloadUrl);
            if (!a_renamed(downloadFilePath2, this.f5462b.getSecondDownloadFileMd5())) {
                a_renamed(secondDownloadUrl, downloadFilePath2, new com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2() { // from class: com.oplus.camera.sticker.download.thumbnail.b_renamed.2
                    @Override // com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2
                    public void a_renamed() {
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5462b.onSecondDownloadFinish(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, true, downloadFilePath2);
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5463c.b_renamed(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, true, downloadFilePath2);
                        com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "onSuccess, second download success!");
                    }

                    @Override // com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2
                    public void a_renamed(java.lang.String str) {
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5462b.onSecondDownloadFinish(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, false, downloadFilePath2);
                        com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5463c.b_renamed(com.oplus.camera.sticker.download.thumbnail.b_renamed.this.f5461a, false, downloadFilePath2);
                        if (com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(new java.io.File(downloadFilePath2))) {
                            com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "second download fail! delete exist file fail!");
                        }
                        com.oplus.camera.e_renamed.e_renamed("ThumbnailDownloadThread", "onFail, second download fail! errorMsg: " + str);
                    }
                });
                return;
            } else {
                com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "run, md5 is_renamed verified!, do not need download anymore!");
                return;
            }
        }
        com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "secondDownloadUrl is_renamed empty!");
    }

    private void a_renamed(java.lang.String str, java.lang.String str2, com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2 interfaceC0116a) {
        com.oplus.camera.e_renamed.b_renamed("ThumbnailDownloadThread", "download, destPath: " + str2);
        com.oplus.camera.sticker.b_renamed.a_renamed aVar = new com.oplus.camera.sticker.b_renamed.a_renamed(this.f5461a);
        aVar.a_renamed(aVar.a_renamed(com.oplus.camera.sticker.b_renamed.a_renamed.b_renamed.POST, str, null, null), str2, interfaceC0116a);
    }

    private boolean a_renamed(java.lang.String str, java.lang.String str2) {
        if (!new java.io.File(str).exists()) {
            com.oplus.camera.e_renamed.e_renamed("ThumbnailDownloadThread", "checkMd5, file not exist!");
            return false;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.oplus.camera.e_renamed.e_renamed("ThumbnailDownloadThread", "checkMd5, empty md5!");
            return false;
        }
        return com.oplus.camera.sticker.c_renamed.c_renamed.a_renamed(str, str2);
    }
}
