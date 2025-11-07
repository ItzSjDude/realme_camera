package com.oplus.camera.sticker.download.thumbnail;

/* loaded from: classes2.dex */
public class ThumbDownloadService extends android.app.Service implements com.oplus.camera.sticker.download.thumbnail.b_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.concurrent.ThreadPoolExecutor f5457a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5458b = 0;

    @Override // com.oplus.camera.sticker.download.thumbnail.b_renamed.a_renamed
    public void b_renamed(android.content.Context context, boolean z_renamed, java.lang.String str) {
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.oplus.camera.e_renamed.b_renamed("ThumbDownloadService", "onCreate");
        this.f5457a = a_renamed();
    }

    private java.util.concurrent.ThreadPoolExecutor a_renamed() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(10, 10, 10L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i_renamed, int i2) {
        if (intent == null) {
            com.oplus.camera.e_renamed.e_renamed("ThumbDownloadService", "onStartCommand, intent is_renamed null");
            return 1;
        }
        final java.lang.String action = intent.getAction();
        com.oplus.camera.e_renamed.b_renamed("ThumbDownloadService", "onStartCommand, action: " + action);
        this.f5457a.submit(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService.1
            @Override // java.lang.Runnable
            public void run() {
                if ("com.oplusos.providers.sticker.download.category.thumbnail".equals(action)) {
                    com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService thumbDownloadService = com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService.this;
                    thumbDownloadService.a_renamed(thumbDownloadService);
                } else if ("com.oplusos.providers.sticker.download.sticker.thumbnail".equals(action)) {
                    com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService thumbDownloadService2 = com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService.this;
                    thumbDownloadService2.b_renamed(thumbDownloadService2);
                }
            }
        });
        return super.onStartCommand(intent, i_renamed, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.content.Context context) {
        java.util.List<com.oplus.camera.sticker.data.StickerCategoryItem> listA = com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(context);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.oplus.camera.sticker.data.StickerCategoryItem stickerCategoryItem : listA) {
            if (stickerCategoryItem instanceof com.oplus.camera.sticker.data.StickerCategoryItemWrapper) {
                com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapper = (com.oplus.camera.sticker.data.StickerCategoryItemWrapper) stickerCategoryItem;
                if (android.text.TextUtils.isEmpty(stickerCategoryItemWrapper.getIconUrl()) && android.text.TextUtils.isEmpty(stickerCategoryItemWrapper.getIconHighlightUrl())) {
                    com.oplus.camera.e_renamed.e_renamed("ThumbDownloadService", "no download url, categoryItemWrapper: " + stickerCategoryItemWrapper.getReadableId());
                } else if (android.text.TextUtils.isEmpty(stickerCategoryItem.getIconFileUri()) || android.text.TextUtils.isEmpty(stickerCategoryItem.getIconHighlightFileUri())) {
                    arrayList.add(stickerCategoryItemWrapper);
                } else if (!a_renamed(stickerCategoryItemWrapper.getIconPath(), stickerCategoryItemWrapper.getIconMd5())) {
                    arrayList.add(stickerCategoryItemWrapper);
                } else if (!a_renamed(stickerCategoryItemWrapper.getIconHighlightPath(), stickerCategoryItemWrapper.getIconHighlightMd5())) {
                    arrayList.add(stickerCategoryItemWrapper);
                }
            }
        }
        synchronized (this) {
            this.f5458b += arrayList.size();
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f5457a.submit(new com.oplus.camera.sticker.download.thumbnail.b_renamed(this, (com.oplus.camera.sticker.data.StickerCategoryItemWrapper) it.next(), this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(android.content.Context context) {
        java.util.List<com.oplus.camera.sticker.data.StickerItem> listA = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, false);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.oplus.camera.sticker.data.StickerItem stickerItem : listA) {
            if (stickerItem instanceof com.oplus.camera.sticker.data.StickerItemWrapper) {
                com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper = (com.oplus.camera.sticker.data.StickerItemWrapper) stickerItem;
                if (android.text.TextUtils.isEmpty(stickerItemWrapper.getThumbnailUrl()) && android.text.TextUtils.isEmpty(stickerItemWrapper.getLogoUrl())) {
                    com.oplus.camera.e_renamed.e_renamed("ThumbDownloadService", "downloadStickerThumbnail, no download url, sticker uuid: " + stickerItemWrapper.getStickerUUID() + ", name: " + stickerItemWrapper.getStickerName());
                } else if (android.text.TextUtils.isEmpty(stickerItemWrapper.getThumbnailFileUri())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!android.text.TextUtils.isEmpty(stickerItemWrapper.getLogoUrl()) && android.text.TextUtils.isEmpty(stickerItemWrapper.getLogoFileUri())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!a_renamed(stickerItemWrapper.getThumbnailPath(), stickerItemWrapper.getThumbnailMd5())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!android.text.TextUtils.isEmpty(stickerItemWrapper.getLogoPath()) && !a_renamed(stickerItemWrapper.getLogoPath(), stickerItemWrapper.getLogoMd5())) {
                    arrayList.add(stickerItemWrapper);
                }
            }
        }
        synchronized (this) {
            this.f5458b += arrayList.size();
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f5457a.submit(new com.oplus.camera.sticker.download.thumbnail.b_renamed(this, (com.oplus.camera.sticker.data.StickerItemWrapper) it.next(), this));
        }
    }

    private boolean a_renamed(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.oplus.camera.e_renamed.e_renamed("ThumbDownloadService", "checkMd5, empty value! filePath: " + str + ", fileMd5: " + str2);
            return false;
        }
        return com.oplus.camera.sticker.c_renamed.c_renamed.a_renamed(str, str2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.oplus.camera.e_renamed.b_renamed("ThumbDownloadService", "onDestroy");
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.b_renamed.a_renamed
    public void a_renamed(android.content.Context context, boolean z_renamed, java.lang.String str) {
        synchronized (this) {
            this.f5458b--;
            com.oplus.camera.e_renamed.b_renamed("ThumbDownloadService", "onFirstDownloadFinish, mThumbnailDownloadCount: " + this.f5458b);
            if (this.f5458b == 0) {
                androidx.e_renamed.a_renamed.a_renamed.a_renamed(getApplicationContext()).a_renamed(new android.content.Intent("com.sticker.thumbnail.service"));
            }
        }
    }
}
