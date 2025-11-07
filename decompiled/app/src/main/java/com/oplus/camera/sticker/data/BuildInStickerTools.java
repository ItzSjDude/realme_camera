package com.oplus.camera.sticker.data;

import android.content.Context;
import android.net.Uri;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.p165a.StickerCategoryTableHelper;
import com.oplus.camera.sticker.p167c.FileUtils;
import com.oplus.camera.sticker.provider.FileProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* compiled from: BuildInStickerTools.java */
/* renamed from: com.oplus.camera.sticker.data.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class BuildInStickerTools {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16850a(Context context) throws Throwable {
        CameraLog.m12959b("BuildInStickerTools", "checkBuildInData");
        m16851b(context);
        m16852c(context);
        StickerMediator.m16958a(context).m16971d();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0167 -> B:75:0x016a). Please report as PlatformImplementations.kt_3 decompilation issue!!! */
    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m16851b(Context context) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(context.getAssets().open(ApsConstant.CAPTURE_MODE_STICKER + File.separator + "category.cfg"), "UTF-8");
                try {
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                }
            } catch (Exception e2) {
                CameraLog.m12963c("BuildInStickerTools", "checkBuildInCategory.close reader, COUIBaseListPopupWindow_8: ", e2);
            }
        } catch (Exception e3) {
            COUIBaseListPopupWindow_8 = e3;
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            bufferedReader = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
                stringBuffer.append("\OplusGLSurfaceView_11");
            }
            List<BuildInStickerCategory> list = (List) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(stringBuffer.toString(), new TypeToken<List<BuildInStickerCategory>>() { // from class: com.oplus.camera.sticker.data.PlatformImplementations.kt_3.1
            }.getType());
            if (list != null && !list.isEmpty()) {
                for (BuildInStickerCategory buildInStickerCategory : list) {
                    int iM16739a = StickerCategoryTableHelper.m16739a(context, buildInStickerCategory);
                    if (iM16739a > 0) {
                        String strM16810a = FileUtils.m16810a(buildInStickerCategory.getIconPath());
                        String strM16810a2 = FileUtils.m16810a(buildInStickerCategory.getIconHighlightPath());
                        String strM16809a = FileUtils.m16809a(context, FileUtils.f16219g, strM16810a);
                        String strM16809a2 = FileUtils.m16809a(context, FileUtils.f16219g, strM16810a2);
                        boolean z = iM16739a == 2;
                        boolean zM16815a = FileUtils.m16815a(context.getAssets().open(buildInStickerCategory.getIconPath()), strM16809a, z, true);
                        boolean zM16815a2 = FileUtils.m16815a(context.getAssets().open(buildInStickerCategory.getIconHighlightPath()), strM16809a2, z, true);
                        if (zM16815a && zM16815a2) {
                            Uri uriM16977a = FileProvider.m16977a(context, "com.oplus.camera.providers.sticker.file.provider", new File(strM16809a));
                            Uri uriM16977a2 = FileProvider.m16977a(context, "com.oplus.camera.providers.sticker.file.provider", new File(strM16809a2));
                            StickerCategoryItemWrapper stickerCategoryItemWrapperObtainStickerCategoryItem = buildInStickerCategory.obtainStickerCategoryItem();
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconPath(strM16809a);
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconFileUri(uriM16977a.toString());
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconHighlightPath(strM16809a2);
                            stickerCategoryItemWrapperObtainStickerCategoryItem.setIconHighlightFileUri(uriM16977a2.toString());
                            CameraLog.m12959b("BuildInStickerTools", "checkBuildInCategory result: " + StickerCategoryTableHelper.m16746a(context, stickerCategoryItemWrapperObtainStickerCategoryItem) + ", newItem: " + stickerCategoryItemWrapperObtainStickerCategoryItem);
                        } else {
                            CameraLog.m12966e("BuildInStickerTools", "checkBuildInCategory, save category fail! saveIcon: " + zM16815a + ", saveIconHighlight: " + zM16815a2);
                        }
                    }
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                CameraLog.m12963c("BuildInStickerTools", "checkBuildInCategory.close bufferedReader, COUIBaseListPopupWindow_8: ", e4);
            }
            inputStreamReader.close();
        } catch (Exception e5) {
            COUIBaseListPopupWindow_8 = e5;
            bufferedReader2 = bufferedReader;
            CameraLog.m12963c("BuildInStickerTools", "checkBuildInCategory, COUIBaseListPopupWindow_8:", COUIBaseListPopupWindow_8);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    CameraLog.m12963c("BuildInStickerTools", "checkBuildInCategory.close bufferedReader, COUIBaseListPopupWindow_8: ", e6);
                }
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                    CameraLog.m12963c("BuildInStickerTools", "checkBuildInCategory.close bufferedReader, COUIBaseListPopupWindow_8: ", e7);
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                    throw th;
                } catch (Exception e8) {
                    CameraLog.m12963c("BuildInStickerTools", "checkBuildInCategory.close reader, COUIBaseListPopupWindow_8: ", e8);
                    throw th;
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:83|(8:76|3|80|4|65|5|(2:6|(1:8)(1:86))|9))|(2:11|(7:13|(2:14|(6:16|67|17|88|(3:87|19|91)(1:90)|89)(0))|24|28|75|82|51)(0))(0)|71|24|28|75|82|51|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b8, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b9, code lost:
    
        com.oplus.camera.CameraLog.m12963c("BuildInStickerTools", "checkBuildInSticker.close bufferedReader, COUIBaseListPopupWindow_8: ", r9);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00e3 -> B:75:0x00e6). Please report as PlatformImplementations.kt_3 decompilation issue!!! */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m16852c(android.content.Context r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.data.BuildInStickerTools.m16852c(android.content.Context):void");
    }
}
