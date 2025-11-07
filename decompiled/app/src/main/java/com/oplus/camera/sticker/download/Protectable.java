package com.oplus.camera.sticker.download;

/* compiled from: StickerInstaller.java */
/* loaded from: classes2.dex */
public class c_renamed {
    public static boolean a_renamed(android.content.Context context, com.oplus.camera.sticker.data.BuildInSticker buildInSticker) {
        if (context == null || buildInSticker == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installBuildInSticker, parameter is_renamed null! context: " + context);
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerInstaller", "installBuildInSticker, buildInSticker: " + buildInSticker);
        try {
            java.lang.String strA = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, com.oplus.camera.sticker.c_renamed.b_renamed.l_renamed, buildInSticker.getStickerUUID());
            if (com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context.getAssets().open(buildInSticker.getAssetThumbnailPath()), strA, true, true)) {
                android.net.Uri uriA = com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, "com.oplus.camera.providers.sticker.file.provider", new java.io.File(strA));
                com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapperObtainStickerItem = buildInSticker.obtainStickerItem();
                stickerItemWrapperObtainStickerItem.setIsBuildIn(true);
                stickerItemWrapperObtainStickerItem.setThumbnailPath(strA);
                stickerItemWrapperObtainStickerItem.setThumbnailFileUri(uriA.toString());
                int materialType = stickerItemWrapperObtainStickerItem.getMaterialType();
                if (materialType == 0) {
                    return b_renamed(context, stickerItemWrapperObtainStickerItem, buildInSticker.getAssetFilePath());
                }
                if (materialType == 1) {
                    return c_renamed(context, stickerItemWrapperObtainStickerItem, buildInSticker.getAssetFilePath());
                }
                if (materialType == 2) {
                    return a_renamed(context, stickerItemWrapperObtainStickerItem, buildInSticker.getAssetFilePath(), buildInSticker.getBackgroundColor());
                }
                com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installBuildInSticker, can not supported material type!");
            } else {
                com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installBuildInSticker, saveThumb fail!");
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installBuildInSticker, Exception: " + e_renamed);
        }
        return false;
    }

    public static boolean a_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, java.lang.String str) {
        if (context == null || stickerItemWrapper == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installSticker, parameter is_renamed null! context: " + context);
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerInstaller", "installSticker, srcFilePath: " + str + ", stickerItem: " + stickerItemWrapper);
        int materialType = stickerItemWrapper.getMaterialType();
        if (materialType == 0) {
            return b_renamed(context, stickerItemWrapper, str);
        }
        if (materialType == 1) {
            return c_renamed(context, stickerItemWrapper, str);
        }
        if (materialType == 2) {
            return a_renamed(context, stickerItemWrapper, str, null);
        }
        com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installBuildInSticker, can not supported material type!");
        return false;
    }

    private static boolean b_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, java.lang.String str) throws java.lang.Throwable {
        try {
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installNormalSticker exception e_renamed: " + e_renamed);
        }
        if (context == null || stickerItemWrapper == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installNormalSticker, null parameter! context: " + context);
            return false;
        }
        if (stickerItemWrapper.getMaterialType() != 0) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installNormalSticker, not a_renamed normal type! item: " + stickerItemWrapper);
            return false;
        }
        java.lang.String strA = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, com.oplus.camera.sticker.c_renamed.b_renamed.h_renamed, stickerItemWrapper.getStickerUUID());
        boolean zA = true;
        if (!stickerItemWrapper.isRecycleBin()) {
            if (android.text.TextUtils.isEmpty(str)) {
                com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installNormalSticker, file path is_renamed empty!");
                return false;
            }
            if (stickerItemWrapper.isBuildIn() && str.startsWith("sticker/material")) {
                zA = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context.getAssets().open(str), strA, true, true);
            } else {
                zA = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(str, strA);
                if (!zA && !(zA = com.oplus.camera.sticker.c_renamed.c_renamed.a_renamed(strA, stickerItemWrapper.getFileMd5()))) {
                    com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installNormalSticker, md5CheckSum error! stickerItem: " + stickerItemWrapper);
                }
            }
        }
        if (zA) {
            stickerItemWrapper.setFileContentUri(com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, "com.oplus.camera.providers.sticker.file.provider", new java.io.File(strA)).toString());
            stickerItemWrapper.setFilePath(strA);
            stickerItemWrapper.setDownloadState(8);
            stickerItemWrapper.setNeedUpdate(false);
            if (!stickerItemWrapper.isBuildIn() && stickerItemWrapper.getDownloadTime() == 0) {
                stickerItemWrapper.setDownloadTime(java.lang.System.currentTimeMillis());
            }
            return com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, stickerItemWrapper);
        }
        com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "installNormalSticker, save saveFile!");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:143:0x0326 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:156:0x0307 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c_renamed(android.content.Context r13, com.oplus.camera.sticker.data.StickerItemWrapper r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.download.c_renamed.c_renamed(android.content.Context, com.oplus.camera.sticker.data.StickerItemWrapper, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:106:0x0234 A_renamed[Catch: IOException -> 0x0230, TRY_LEAVE, TryCatch #7 {IOException -> 0x0230, blocks: (B_renamed:102:0x022c, B_renamed:106:0x0234), top: B_renamed:134:0x022c }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:111:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:120:0x0260 A_renamed[Catch: IOException -> 0x025c, TRY_LEAVE, TryCatch #11 {IOException -> 0x025c, blocks: (B_renamed:116:0x0258, B_renamed:120:0x0260), top: B_renamed:137:0x0258 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:125:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:134:0x022c A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:137:0x0258 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:157:? A_renamed[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:55:0x0167 A_renamed[Catch: Exception -> 0x0213, all -> 0x0254, TRY_LEAVE, TryCatch #1 {all -> 0x0254, blocks: (B_renamed:53:0x0161, B_renamed:55:0x0167, B_renamed:68:0x0196, B_renamed:70:0x01c5, B_renamed:72:0x01cf, B_renamed:73:0x01d6, B_renamed:75:0x01e0, B_renamed:76:0x01e5, B_renamed:100:0x0227), top: B_renamed:129:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:68:0x0196 A_renamed[Catch: Exception -> 0x0213, all -> 0x0254, TRY_ENTER, TryCatch #1 {all -> 0x0254, blocks: (B_renamed:53:0x0161, B_renamed:55:0x0167, B_renamed:68:0x0196, B_renamed:70:0x01c5, B_renamed:72:0x01cf, B_renamed:73:0x01d6, B_renamed:75:0x01e0, B_renamed:76:0x01e5, B_renamed:100:0x0227), top: B_renamed:129:0x0024 }] */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a_renamed(android.content.Context r17, com.oplus.camera.sticker.data.StickerItemWrapper r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.download.c_renamed.a_renamed(android.content.Context, com.oplus.camera.sticker.data.StickerItemWrapper, java.lang.String, java.lang.String):boolean");
    }

    private static com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo a_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "parserAniMojiExtendInfo empty content");
            return null;
        }
        try {
            return (com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo) new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo.class);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "parserAniMojiExtendInfo exception: " + e_renamed);
            return null;
        }
    }

    private static java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> b_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "parserMultiStickerExtendInfo empty content");
            return null;
        }
        try {
            return (java.util.List) new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, new com.google.gson.reflect.TypeToken<java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>>() { // from class: com.oplus.camera.sticker.download.c_renamed.1
            }.getType());
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "parserMultiStickerExtendInfo exception: " + e_renamed);
            return null;
        }
    }

    private static java.util.List<java.util.zip.ZipEntry> a_renamed(java.util.zip.ZipFile zipFile) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory()) {
                arrayList.add(zipEntryNextElement);
            }
        }
        java.util.Collections.sort(arrayList, new java.util.Comparator<java.util.zip.ZipEntry>() { // from class: com.oplus.camera.sticker.download.c_renamed.2
            @Override // java.util.Comparator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public int compare(java.util.zip.ZipEntry zipEntry, java.util.zip.ZipEntry zipEntry2) {
                int iA = a_renamed(zipEntry.getName());
                int iA2 = a_renamed(zipEntry2.getName());
                if (iA > iA2) {
                    return 1;
                }
                return iA < iA2 ? -1 : 0;
            }

            private int a_renamed(java.lang.String str) {
                return str.endsWith("StickerMultiCfg.json") ? 0 : 1;
            }
        });
        return arrayList;
    }

    public static void a_renamed(android.content.Context context, java.util.List<com.oplus.camera.sticker.data.StickerItem> list, boolean z_renamed) {
        if (list == null || list.isEmpty()) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "deleteSticker, list is_renamed empty!");
            return;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        for (com.oplus.camera.sticker.data.StickerItem stickerItem : list) {
            if (stickerItem == null) {
                com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "deleteSticker, item is_renamed null!");
            } else {
                contentValues.clear();
                com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapperA = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItem.getStickerUUID());
                if (stickerItemWrapperA == null) {
                    com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "deleteSticker, can not find this sticker! name: " + stickerItem.getStickerName() + ", uuid: " + stickerItem.getStickerUUID());
                } else {
                    com.oplus.camera.e_renamed.b_renamed("StickerInstaller", "deleteSticker, start delete one sticker, item: " + stickerItemWrapperA);
                    if (stickerItemWrapperA.isBuildIn()) {
                        contentValues.put("download_time", (java.lang.Integer) 0);
                        stickerItemWrapperA.setDownloadTime(0L);
                    } else {
                        int iA = a_renamed(context, stickerItemWrapperA);
                        if (iA == 0) {
                            contentValues.put("download_time", (java.lang.Integer) 0);
                            contentValues.put("need_update", (java.lang.Integer) 0);
                            contentValues.put("file_path", "");
                            contentValues.put("file_content_uri", "");
                            contentValues.put("download_state", (java.lang.Integer) 0);
                            stickerItemWrapperA.setDownloadTime(0L);
                            stickerItemWrapperA.setNeedUpdate(false);
                            stickerItemWrapperA.setDownloadState(0);
                        } else {
                            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "deleteSticker, delete item fail! result: " + iA + ", name: " + stickerItemWrapperA.getStickerName() + ", uuid: " + stickerItem.getStickerUUID());
                        }
                    }
                    com.oplus.camera.e_renamed.b_renamed("StickerInstaller", "deleteSticker, updateStickerItem count: " + com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues));
                    if (z_renamed) {
                        com.oplus.camera.sticker.h_renamed.a_renamed(context).d_renamed(stickerItemWrapperA);
                    }
                }
            }
        }
    }

    public static int a_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "deleteSticker, parameter is_renamed null! context: " + context);
            return -2;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerInstaller", "deleteSticker, stickerItem: " + stickerItemWrapper);
        if (stickerItemWrapper.isBuildIn()) {
            return 0;
        }
        int materialType = stickerItemWrapper.getMaterialType();
        if (materialType == 0) {
            return b_renamed(context, stickerItemWrapper);
        }
        if (materialType == 1) {
            return c_renamed(context, stickerItemWrapper);
        }
        if (materialType != 2) {
            return -1;
        }
        return d_renamed(context, stickerItemWrapper);
    }

    public static int b_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper) {
        java.io.File file;
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        if (stickerItemWrapper.getMaterialType() != 0) {
            return -3;
        }
        java.lang.String filePath = stickerItemWrapper.getFilePath();
        try {
            if (android.text.TextUtils.isEmpty(stickerItemWrapper.getFilePath())) {
                file = com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, android.net.Uri.parse(stickerItemWrapper.getFileContentUri()));
            } else {
                file = new java.io.File(filePath);
            }
            if (file == null) {
                return -4;
            }
            return com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(file) ? 0 : -5;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "deleteNormalSticker exception: " + e_renamed);
            return -1;
        }
    }

    public static int c_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        boolean zA = true;
        if (stickerItemWrapper.getMaterialType() != 1) {
            return -3;
        }
        java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> listC = com.oplus.camera.sticker.a_renamed.b_renamed.c_renamed(context, stickerItemWrapper);
        if (listC == null || listC.isEmpty()) {
            return -6;
        }
        for (com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo : listC) {
            zA = zA & com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, multiStickerExtendedInfo.getFileContentUri16x9()) & com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, multiStickerExtendedInfo.getFileContentUri4x3()) & com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, multiStickerExtendedInfo.getFileContentUri1x1());
        }
        if (zA) {
            return com.oplus.camera.sticker.a_renamed.b_renamed.d_renamed(context, stickerItemWrapper) ? 0 : -7;
        }
        return -5;
    }

    public static int d_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper) {
        java.io.File file;
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        if (stickerItemWrapper.getMaterialType() != 2) {
            return -3;
        }
        java.lang.String filePath = stickerItemWrapper.getFilePath();
        try {
            if (android.text.TextUtils.isEmpty(stickerItemWrapper.getFilePath())) {
                file = com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, android.net.Uri.parse(stickerItemWrapper.getFileContentUri()));
            } else {
                file = new java.io.File(filePath);
            }
            if (file == null) {
                return -4;
            }
            if (com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(file)) {
                return com.oplus.camera.sticker.a_renamed.b_renamed.b_renamed(context, stickerItemWrapper) ? 0 : -7;
            }
            return -5;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerInstaller", "deleteAnimojiSticker exception: " + e_renamed);
            return -1;
        }
    }
}
