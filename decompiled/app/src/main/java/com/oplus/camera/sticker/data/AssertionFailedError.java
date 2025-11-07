package com.oplus.camera.sticker.data;

/* compiled from: StickerDataManager.java */
/* loaded from: classes2.dex */
public class b_renamed implements com.oplus.camera.sticker.f_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5447a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.data.b_renamed.StickerDataManager_3 f5448b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.HandlerThread f5449c;
    private com.oplus.camera.sticker.f_renamed d_renamed;
    private com.oplus.camera.sticker.data.b_renamed.a_renamed e_renamed = null;

    /* compiled from: StickerDataManager.java */
    public interface a_renamed {
        void a_renamed(int i_renamed);
    }

    @Override // com.oplus.camera.sticker.f_renamed.a_renamed
    public void a_renamed(int i_renamed) {
        com.oplus.camera.sticker.data.b_renamed.a_renamed aVar = this.e_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.sticker.data.b_renamed.a_renamed aVar) {
        this.e_renamed = aVar;
    }

    public b_renamed(android.content.Context context) {
        this.f5447a = null;
        this.f5448b = null;
        this.f5449c = null;
        this.d_renamed = null;
        this.f5447a = context;
        this.d_renamed = new com.oplus.camera.sticker.f_renamed(context);
        this.d_renamed.a_renamed(this);
        this.f5449c = new android.os.HandlerThread("StickerDataManager");
        this.f5449c.start();
        this.f5448b = new com.oplus.camera.sticker.data.b_renamed.StickerDataManager_3(this.f5449c.getLooper());
        c_renamed();
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "StickerDataManager this: " + this);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "register this: " + this);
        com.oplus.camera.sticker.download.a_renamed.a_renamed().a_renamed(this.f5447a);
        com.oplus.camera.sticker.f_renamed fVar = this.d_renamed;
        if (fVar != null) {
            fVar.a_renamed();
        }
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "unregister this: " + this);
        com.oplus.camera.sticker.download.a_renamed.a_renamed().b_renamed(this.f5447a);
        com.oplus.camera.sticker.f_renamed fVar = this.d_renamed;
        if (fVar != null) {
            fVar.b_renamed();
        }
    }

    public void c_renamed() {
        if (this.f5448b.hasMessages(1)) {
            return;
        }
        this.f5448b.sendEmptyMessage(1);
    }

    public void d_renamed() {
        if (this.f5448b.hasMessages(2)) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "checkBuildInData");
        this.f5448b.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g_renamed() throws java.lang.Throwable {
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "checkBuildInDataByThread");
        com.oplus.camera.e_renamed.a_renamed("checkBuildInDataByThread");
        com.oplus.camera.sticker.data.a_renamed.a_renamed(this.f5447a);
        c_renamed();
        com.oplus.camera.e_renamed.b_renamed("checkBuildInDataByThread");
    }

    public void e_renamed() {
        if (this.f5448b.hasMessages(3)) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "requestSticker");
        this.f5448b.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h_renamed() {
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "requestStickerByThread");
        com.oplus.camera.e_renamed.a_renamed("requestStickerByThread");
        this.d_renamed.c_renamed();
        com.oplus.camera.e_renamed.b_renamed("requestStickerByThread");
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (this.f5448b.hasMessages(5)) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "updateStickerDownloadTime, item: " + stickerItem);
        android.os.Message messageObtainMessage = this.f5448b.obtainMessage(5);
        messageObtainMessage.obj = stickerItem;
        this.f5448b.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.sticker.data.StickerCategoryItem stickerCategoryItem) {
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "clickStickerCategoryByThread, item: " + stickerCategoryItem);
        if (stickerCategoryItem.isCategoryNew()) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("is_new", (java.lang.Integer) 0);
            com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "clickStickerCategoryByThread, count: " + com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(this.f5447a, "readable_id", stickerCategoryItem.getReadableId(), contentValues));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "updateStickerDownloadTimeByThread, item: " + stickerItem);
        if (!stickerItem.isBuildIn() || stickerItem.getDownloadTime() > 0) {
            return;
        }
        int iA = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5447a, stickerItem);
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "updateStickerDownloadTimeByThread, rowUpdate: " + iA);
        if (iA > 0) {
            com.oplus.camera.sticker.h_renamed.a_renamed(this.f5447a).c_renamed(stickerItem);
        }
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        if (this.f5448b.hasMessages(6)) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "startDownloadSticker, item: " + stickerItem);
        android.os.Message messageObtainMessage = this.f5448b.obtainMessage(6);
        messageObtainMessage.arg1 = z_renamed ? 1 : 0;
        messageObtainMessage.obj = stickerItem;
        this.f5448b.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "downloadStickerItemByThread, item: " + stickerItem + ", allowAllNetwork: " + z_renamed);
        if (stickerItem == null || android.text.TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            com.oplus.camera.e_renamed.f_renamed("StickerDataManager", "downloadStickerItemByThread, item is_renamed null or empty. item: " + stickerItem);
            return;
        }
        if (!stickerItem.isDownloaded() || stickerItem.needUpdate()) {
            com.oplus.camera.sticker.download.a_renamed.a_renamed().c_renamed(this.f5447a, stickerItem, z_renamed);
        } else {
            if (!stickerItem.isBuildIn() || stickerItem.getDownloadTime() > 0) {
                return;
            }
            com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5447a, stickerItem);
        }
    }

    public void a_renamed(java.util.List<com.oplus.camera.sticker.data.StickerItem> list) {
        if (this.f5448b.hasMessages(7, list)) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "delete, list: " + list);
        android.os.Message messageObtainMessage = this.f5448b.obtainMessage(7);
        messageObtainMessage.obj = list;
        this.f5448b.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b_renamed(java.util.List<com.oplus.camera.sticker.data.StickerItem> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                com.oplus.camera.sticker.download.c_renamed.a_renamed(this.f5447a, list, true);
                return;
            }
        }
        com.oplus.camera.e_renamed.e_renamed("StickerDataManager", "deleteStickerItemsByThread, list is_renamed null or empty.");
    }

    public void f_renamed() {
        if (this.f5448b.hasMessages(8)) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerDataManager", "autoClearClickNewStatus");
        this.f5448b.sendEmptyMessage(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5447a, jCurrentTimeMillis, 604800000L);
        com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(this.f5447a, jCurrentTimeMillis, 604800000L);
    }

    /* compiled from: StickerDataManager.java */
    /* renamed from: com.oplus.camera.sticker.data.b_renamed$b_renamed, reason: collision with other inner class name */
    private class StickerDataManager_3 extends android.os.Handler {
        public StickerDataManager_3(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws java.lang.Throwable {
            switch (message.what) {
                case 1:
                    break;
                case 2:
                    com.oplus.camera.sticker.data.b_renamed.this.g_renamed();
                    break;
                case 3:
                    com.oplus.camera.sticker.data.b_renamed.this.h_renamed();
                    break;
                case 4:
                    if (message.obj instanceof com.oplus.camera.sticker.data.StickerCategoryItem) {
                        com.oplus.camera.sticker.data.b_renamed.this.a_renamed((com.oplus.camera.sticker.data.StickerCategoryItem) message.obj);
                        break;
                    }
                    break;
                case 5:
                    if (message.obj instanceof com.oplus.camera.sticker.data.StickerItem) {
                        com.oplus.camera.sticker.data.b_renamed.this.b_renamed((com.oplus.camera.sticker.data.StickerItem) message.obj);
                        break;
                    }
                    break;
                case 6:
                    if (message.obj instanceof com.oplus.camera.sticker.data.StickerItem) {
                        com.oplus.camera.sticker.data.b_renamed.this.b_renamed((com.oplus.camera.sticker.data.StickerItem) message.obj, message.arg1 == 1);
                        break;
                    }
                    break;
                case 7:
                    com.oplus.camera.sticker.data.b_renamed.this.b_renamed((java.util.List<com.oplus.camera.sticker.data.StickerItem>) message.obj);
                    break;
                case 8:
                    com.oplus.camera.sticker.data.b_renamed.this.i_renamed();
                    break;
                default:
                    com.oplus.camera.e_renamed.f_renamed("StickerDataManager", "handleMessage, message, what: " + message.what);
                    break;
            }
        }
    }
}
