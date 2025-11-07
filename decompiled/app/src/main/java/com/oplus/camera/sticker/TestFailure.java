package com.oplus.camera.sticker;

/* compiled from: StickerDataRequest.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5468a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.f_renamed.a_renamed f5469b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.BroadcastReceiver f5470c = new android.content.BroadcastReceiver() { // from class: com.oplus.camera.sticker.f_renamed.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "onReceive intent: " + intent.toString());
            if (!"com.sticker.thumbnail.service".equals(intent.getAction()) || com.oplus.camera.sticker.f_renamed.this.f5469b == null) {
                return;
            }
            com.oplus.camera.sticker.f_renamed.this.f5469b.a_renamed(1);
        }
    };

    /* compiled from: StickerDataRequest.java */
    public interface a_renamed {
        void a_renamed(int i_renamed);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "register this: " + this);
        androidx.e_renamed.a_renamed.a_renamed.a_renamed(this.f5468a.getApplicationContext()).a_renamed(this.f5470c, new android.content.IntentFilter("com.sticker.thumbnail.service"));
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "unregister this: " + this);
        androidx.e_renamed.a_renamed.a_renamed.a_renamed(this.f5468a.getApplicationContext()).a_renamed(this.f5470c);
    }

    public void a_renamed(com.oplus.camera.sticker.f_renamed.a_renamed aVar) {
        this.f5469b = aVar;
    }

    public f_renamed(android.content.Context context) {
        this.f5468a = null;
        this.f5468a = context;
    }

    public void c_renamed() {
        if (java.lang.System.currentTimeMillis() - com.oplus.camera.sticker.c_renamed.d_renamed.c_renamed(this.f5468a) <= com.oplus.camera.sticker.c_renamed.d_renamed.b_renamed(this.f5468a)) {
            com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "checkUpdateData, do not need update data!");
            a_renamed(this.f5468a);
            b_renamed(this.f5468a);
            return;
        }
        d_renamed();
    }

    private void d_renamed() {
        int iF = com.oplus.camera.sticker.c_renamed.d_renamed.f_renamed(this.f5468a);
        com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "requestData, mode: " + iF);
        com.oplus.camera.sticker.b_renamed.a_renamed aVar = new com.oplus.camera.sticker.b_renamed.a_renamed(this.f5468a);
        okhttp3.RequestBody requestBodyA = aVar.a_renamed(a_renamed(iF));
        java.lang.String strA = aVar.a_renamed(this.f5468a);
        if (strA == null || strA.isEmpty()) {
            com.oplus.camera.e_renamed.f_renamed("StickerDataRequest", "requestData, routeURL is_renamed null");
        } else {
            aVar.a_renamed(aVar.a_renamed(com.oplus.camera.sticker.b_renamed.a_renamed.b_renamed.POST, aVar.a_renamed(this.f5468a, iF), a_renamed(this.f5468a, iF), requestBodyA), new com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed() { // from class: com.oplus.camera.sticker.f_renamed.2
                @Override // com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed
                public void a_renamed(okhttp3.ResponseBody responseBody) throws java.lang.Throwable {
                    try {
                        com.oplus.camera.sticker.f_renamed.this.a_renamed(com.oplus.camera.sticker.protocol.StickerResponse.ADAPTER.decode(responseBody.bytes()), java.lang.System.currentTimeMillis());
                    } catch (java.lang.Exception e_renamed) {
                        com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "requestData exception: " + e_renamed);
                    }
                }

                @Override // com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed
                public void a_renamed(java.lang.String str) {
                    com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "onFail errorMsg: " + str);
                }
            });
        }
    }

    private java.util.Map<java.lang.String, java.lang.String> a_renamed(android.content.Context context, int i_renamed) {
        return new java.util.HashMap();
    }

    private byte[] a_renamed(int i_renamed) {
        com.oplus.camera.sticker.protocol.StickerRequest.Builder builder = new com.oplus.camera.sticker.protocol.StickerRequest.Builder();
        builder.model(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().b_renamed());
        builder.resResolution(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().b_renamed(this.f5468a));
        builder.protocolVersion("100");
        builder.clientVersion(java.lang.String.valueOf(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().a_renamed(this.f5468a)));
        builder.oplusosVersion(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().c_renamed());
        builder.androidVersion(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().e_renamed());
        builder.otaVersion(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().d_renamed());
        builder.locale(com.oplus.camera.sticker.c_renamed.a_renamed.a_renamed().f_renamed());
        builder.localDataVersion(java.lang.Long.valueOf(com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(this.f5468a)));
        builder.compatibleApp(1L);
        return com.oplus.camera.sticker.protocol.StickerRequest.ADAPTER.encode(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.sticker.protocol.StickerResponse stickerResponse, long j_renamed) throws java.lang.Throwable {
        if (stickerResponse == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "dealStickerResponseData, response is_renamed null!");
            return;
        }
        if (stickerResponse.resultCode.intValue() == 8000) {
            long jA = com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(this.f5468a);
            long jLongValue = stickerResponse.dataVersion.longValue();
            com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "dealStickerResponseData, localDataVersion: " + jA + ", responseVersion: " + jLongValue);
            if (jLongValue > jA) {
                com.oplus.camera.sticker.a_renamed.b_renamed.b_renamed(this.f5468a);
                com.oplus.camera.sticker.c_renamed.d_renamed.b_renamed(this.f5468a, stickerResponse.checkInterval.intValue() * com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
                java.lang.String str = stickerResponse.fileServerHost;
                if (android.text.TextUtils.isEmpty(str)) {
                    com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "dealStickerResponseData, hort url is_renamed empty!");
                    return;
                }
                java.util.List<com.oplus.camera.sticker.protocol.StickerCategory> list = stickerResponse.category;
                if (list == null) {
                    com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "dealStickerResponseData, responseStickerCategoryList is_renamed null!");
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                for (com.oplus.camera.sticker.protocol.StickerCategory stickerCategory : list) {
                    com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapperA = a_renamed(stickerCategory, str, j_renamed);
                    arrayList.add(stickerCategoryItemWrapperA);
                    java.util.List<com.oplus.camera.sticker.protocol.Sticker> list2 = stickerCategory.sticker;
                    if (list2 == null) {
                        com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "dealStickerResponseData, stickerList is_renamed null!");
                    } else {
                        java.util.Iterator<com.oplus.camera.sticker.protocol.Sticker> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(a_renamed(it.next(), stickerCategoryItemWrapperA, str, j_renamed));
                            stickerCategoryItemWrapperA = stickerCategoryItemWrapperA;
                        }
                    }
                }
                boolean zA = com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(this.f5468a, arrayList);
                boolean zA2 = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5468a, arrayList2);
                if (zA && zA2) {
                    com.oplus.camera.sticker.c_renamed.d_renamed.a_renamed(this.f5468a, jLongValue);
                    com.oplus.camera.sticker.c_renamed.d_renamed.c_renamed(this.f5468a, j_renamed);
                } else {
                    com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "dealStickerResponseData db_renamed fail! updateCategoryResult: " + zA + ", updateItemResult: " + zA2);
                }
                com.oplus.camera.sticker.a_renamed.b_renamed.c_renamed(this.f5468a);
            } else {
                com.oplus.camera.e_renamed.b_renamed("StickerDataRequest", "dealStickerResponseData, data version already new. do not update!");
            }
            a_renamed(this.f5468a);
            b_renamed(this.f5468a);
            return;
        }
        com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "dealStickerResponseData error! resultCode: " + stickerResponse.resultCode + ", resultDesc: " + stickerResponse.resultDesc);
    }

    private com.oplus.camera.sticker.data.StickerItemWrapper a_renamed(com.oplus.camera.sticker.protocol.Sticker sticker, com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapper, java.lang.String str, long j_renamed) {
        com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper = new com.oplus.camera.sticker.data.StickerItemWrapper();
        stickerItemWrapper.setStickerId(sticker.id_renamed.longValue());
        stickerItemWrapper.setStickerUUID(sticker.uuid);
        stickerItemWrapper.setStickerName(sticker.name);
        if (!android.text.TextUtils.isEmpty(sticker.filePath)) {
            stickerItemWrapper.setFileDownloadUrl(str + sticker.filePath);
        }
        stickerItemWrapper.setFileMd5(sticker.fileMd5);
        if (!android.text.TextUtils.isEmpty(sticker.thumbnailPath)) {
            stickerItemWrapper.setThumbnailUrl(str + sticker.thumbnailPath);
        }
        stickerItemWrapper.setThumbnailMd5(sticker.thumbnailMd5);
        if (!android.text.TextUtils.isEmpty(sticker.logoPath)) {
            stickerItemWrapper.setLogoUrl(str + sticker.logoPath);
        }
        stickerItemWrapper.setLogoMd5(sticker.logoMd5);
        stickerItemWrapper.setVersion(sticker.version.longValue());
        stickerItemWrapper.setLastRequestTime(j_renamed);
        stickerItemWrapper.setCategoryId(stickerCategoryItemWrapper.getReadableId());
        stickerItemWrapper.setCategoryPosition(stickerCategoryItemWrapper.getPosition());
        stickerItemWrapper.setPosition(sticker.position.intValue());
        stickerItemWrapper.setAttribute(sticker.compatibleApp.longValue());
        stickerItemWrapper.setHasMusic(sticker.hasMusic.booleanValue());
        stickerItemWrapper.setIsBuildIn(false);
        stickerItemWrapper.setMaterialType(sticker.materialType.intValue());
        if (sticker.isNew != null) {
            stickerItemWrapper.setStickerNew(sticker.isNew.booleanValue());
        }
        return stickerItemWrapper;
    }

    private com.oplus.camera.sticker.data.StickerCategoryItemWrapper a_renamed(com.oplus.camera.sticker.protocol.StickerCategory stickerCategory, java.lang.String str, long j_renamed) {
        com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapper = new com.oplus.camera.sticker.data.StickerCategoryItemWrapper();
        stickerCategoryItemWrapper.setCategoryName(stickerCategory.name);
        if (!android.text.TextUtils.isEmpty(stickerCategory.iconPath)) {
            stickerCategoryItemWrapper.setIconUrl(str + stickerCategory.iconPath);
        }
        stickerCategoryItemWrapper.setIconMd5(stickerCategory.iconMd5);
        if (!android.text.TextUtils.isEmpty(stickerCategory.highlightIconPath)) {
            stickerCategoryItemWrapper.setIconHighlightUrl(str + stickerCategory.highlightIconPath);
        }
        stickerCategoryItemWrapper.setIconHighlightMd5(stickerCategory.highlightIconMd5);
        stickerCategoryItemWrapper.setLastRequestTime(j_renamed);
        stickerCategoryItemWrapper.setReadableId(stickerCategory.readableId);
        stickerCategoryItemWrapper.setPosition(stickerCategory.position.intValue());
        if (stickerCategory.isNew != null) {
            stickerCategoryItemWrapper.setCategoryNew(stickerCategory.isNew.booleanValue());
        }
        return stickerCategoryItemWrapper;
    }

    private void a_renamed(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService.class);
        intent.setAction("com.oplusos.providers.sticker.download.category.thumbnail");
        try {
            context.startService(intent);
        } catch (java.lang.IllegalStateException e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "startDownloadCategoryThumbnail, e_renamed: " + e_renamed);
        }
    }

    private void b_renamed(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService.class);
        intent.setAction("com.oplusos.providers.sticker.download.sticker.thumbnail");
        try {
            context.startService(intent);
        } catch (java.lang.IllegalStateException e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerDataRequest", "startDownloadStickerThumbnail, e_renamed: " + e_renamed);
        }
    }
}
