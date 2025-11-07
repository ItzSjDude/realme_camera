package com.oplus.camera.sticker.data;

/* compiled from: BuildInStickerTools.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static void a_renamed(android.content.Context context) throws java.lang.Throwable {
        com.oplus.camera.e_renamed.b_renamed("BuildInStickerTools", "checkBuildInData");
        b_renamed(context);
        c_renamed(context);
        com.oplus.camera.sticker.h_renamed.a_renamed(context).d_renamed();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:54:0x0167 -> B_renamed:75:0x016a). Please report as_renamed a_renamed decompilation issue!!! */
    private static void b_renamed(android.content.Context context) throws java.lang.Throwable {
        java.io.InputStreamReader inputStreamReader;
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                inputStreamReader = new java.io.InputStreamReader(context.getAssets().open(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER + java.io.File.separator + "category.cfg"), "UTF-8");
                try {
                    try {
                        bufferedReader = new java.io.BufferedReader(inputStreamReader);
                    } catch (java.lang.Exception e_renamed) {
                        e_renamed = e_renamed;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                }
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.c_renamed("BuildInStickerTools", "checkBuildInCategory.close reader, e_renamed: ", e2);
            }
        } catch (java.lang.Exception e3) {
            e_renamed = e3;
            inputStreamReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStreamReader = null;
            bufferedReader = null;
        }
        try {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
                stringBuffer.append("\n_renamed");
            }
            java.util.List<com.oplus.camera.sticker.data.BuildInStickerCategory> list = (java.util.List) new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(stringBuffer.toString(), new com.google.gson.reflect.TypeToken<java.util.List<com.oplus.camera.sticker.data.BuildInStickerCategory>>() { // from class: com.oplus.camera.sticker.data.a_renamed.1
            }.getType());
            if (list != null && !list.isEmpty()) {
                for (com.oplus.camera.sticker.data.BuildInStickerCategory buildInStickerCategory : list) {
                    int iA = com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(context, buildInStickerCategory);
                    if (iA > 0) {
                        java.lang.String strA = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(buildInStickerCategory.getIconPath());
                        java.lang.String strA2 = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(buildInStickerCategory.getIconHighlightPath());
                        java.lang.String strA3 = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, com.oplus.camera.sticker.c_renamed.b_renamed.g_renamed, strA);
                        java.lang.String strA4 = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, com.oplus.camera.sticker.c_renamed.b_renamed.g_renamed, strA2);
                        boolean z_renamed = iA == 2;
                        boolean zA = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context.getAssets().open(buildInStickerCategory.getIconPath()), strA3, z_renamed, true);
                        boolean zA2 = com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context.getAssets().open(buildInStickerCategory.getIconHighlightPath()), strA4, z_renamed, true);
                        if (zA && zA2) {
                            android.net.Uri uriA = com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, "com.oplus.camera.providers.sticker.file.provider", new java.io.File(strA3));
                            android.net.Uri uriA2 = com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, "com.oplus.camera.providers.sticker.file.provider", new java.io.File(strA4));
                            com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapperObtainStickerCategoryItem = buildInStickerCategory.obtainStickerCategoryItem();
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconPath(strA3);
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconFileUri(uriA.toString());
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconHighlightPath(strA4);
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconHighlightFileUri(uriA2.toString());
                            com.oplus.camera.e_renamed.b_renamed("BuildInStickerTools", "checkBuildInCategory result: " + com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(context, stickerCategoryItemWrapperObtainStickerCategoryItem) + ", newItem: " + stickerCategoryItemWrapperObtainStickerCategoryItem);
                        } else {
                            com.oplus.camera.e_renamed.e_renamed("BuildInStickerTools", "checkBuildInCategory, save category fail! saveIcon: " + zA + ", saveIconHighlight: " + zA2);
                        }
                    }
                }
            }
            try {
                bufferedReader.close();
            } catch (java.io.IOException e4) {
                com.oplus.camera.e_renamed.c_renamed("BuildInStickerTools", "checkBuildInCategory.close bufferedReader, e_renamed: ", e4);
            }
            inputStreamReader.close();
        } catch (java.lang.Exception e5) {
            e_renamed = e5;
            bufferedReader2 = bufferedReader;
            com.oplus.camera.e_renamed.c_renamed("BuildInStickerTools", "checkBuildInCategory, e_renamed:", e_renamed);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException e6) {
                    com.oplus.camera.e_renamed.c_renamed("BuildInStickerTools", "checkBuildInCategory.close bufferedReader, e_renamed: ", e6);
                }
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e7) {
                    com.oplus.camera.e_renamed.c_renamed("BuildInStickerTools", "checkBuildInCategory.close bufferedReader, e_renamed: ", e7);
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                    throw th;
                } catch (java.lang.Exception e8) {
                    com.oplus.camera.e_renamed.c_renamed("BuildInStickerTools", "checkBuildInCategory.close reader, e_renamed: ", e8);
                    throw th;
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Can't_renamed wrap try/catch for region: R_renamed(11:0|2|(2:83|(8:76|3|80|4|65|5|(2:6|(1:8)(1:86))|9))|(2:11|(7:13|(2:14|(6:16|67|17|88|(3:87|19|91)(1:90)|89)(0))|24|28|75|82|51)(0))(0)|71|24|28|75|82|51|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:26:0x00b8, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:27:0x00b9, code lost:
    
        com.oplus.camera.e_renamed.c_renamed("BuildInStickerTools", "checkBuildInSticker.close bufferedReader, e_renamed: ", r9);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:50:0x00e3 -> B_renamed:75:0x00e6). Please report as_renamed a_renamed decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void c_renamed(android.content.Context r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.data.a_renamed.c_renamed(android.content.Context):void");
    }
}
