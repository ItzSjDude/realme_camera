package com.oplus.camera.sticker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.p044e.p045a.LocalBroadcastManager;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.data.StickerCategoryItemWrapper;
import com.oplus.camera.sticker.data.StickerItemWrapper;
import com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService;
import com.oplus.camera.sticker.p165a.StickerCategoryTableHelper;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import com.oplus.camera.sticker.p166b.HttpRequestHelper;
import com.oplus.camera.sticker.p167c.DeviceInfo;
import com.oplus.camera.sticker.p167c.PrefUtils;
import com.oplus.camera.sticker.protocol.Sticker;
import com.oplus.camera.sticker.protocol.StickerCategory;
import com.oplus.camera.sticker.protocol.StickerRequest;
import com.oplus.camera.sticker.protocol.StickerResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: StickerDataRequest.java */
/* renamed from: com.oplus.camera.sticker.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class StickerDataRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f16250a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f16251b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private BroadcastReceiver f16252c = new BroadcastReceiver() { // from class: com.oplus.camera.sticker.COUIBaseListPopupWindow_12.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CameraLog.m12959b("StickerDataRequest", "onReceive intent: " + intent.toString());
            if (!"com.sticker.thumbnail.service".equals(intent.getAction()) || StickerDataRequest.this.f16251b == null) {
                return;
            }
            StickerDataRequest.this.f16251b.mo16868a(1);
        }
    };

    /* compiled from: StickerDataRequest.java */
    /* renamed from: com.oplus.camera.sticker.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16868a(int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16944a() {
        CameraLog.m12959b("StickerDataRequest", "register this: " + this);
        LocalBroadcastManager.m3241a(this.f16250a.getApplicationContext()).m3244a(this.f16252c, new IntentFilter("com.sticker.thumbnail.service"));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16946b() {
        CameraLog.m12959b("StickerDataRequest", "unregister this: " + this);
        LocalBroadcastManager.m3241a(this.f16250a.getApplicationContext()).m3243a(this.f16252c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16945a(PlatformImplementations.kt_3 aVar) {
        this.f16251b = aVar;
    }

    public StickerDataRequest(Context context) {
        this.f16250a = null;
        this.f16250a = context;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16947c() {
        if (System.currentTimeMillis() - PrefUtils.m16831c(this.f16250a) <= PrefUtils.m16828b(this.f16250a)) {
            CameraLog.m12959b("StickerDataRequest", "checkUpdateData, do not need update data!");
            m16938a(this.f16250a);
            m16942b(this.f16250a);
            return;
        }
        m16943d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m16943d() {
        int iM16836f = PrefUtils.m16836f(this.f16250a);
        CameraLog.m12959b("StickerDataRequest", "requestData, mode: " + iM16836f);
        HttpRequestHelper c2975a = new HttpRequestHelper(this.f16250a);
        RequestBody requestBodyM16788a = c2975a.m16788a(m16941a(iM16836f));
        String strM16784a = c2975a.m16784a(this.f16250a);
        if (strM16784a == null || strM16784a.isEmpty()) {
            CameraLog.m12967f("StickerDataRequest", "requestData, routeURL is null");
        } else {
            c2975a.m16790a(c2975a.m16787a(HttpRequestHelper.IntrinsicsJvm.kt_4.POST, c2975a.m16785a(this.f16250a, iM16836f), m16937a(this.f16250a, iM16836f), requestBodyM16788a), new HttpRequestHelper.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.sticker.COUIBaseListPopupWindow_12.2
                @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.IntrinsicsJvm.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo16719a(ResponseBody responseBody) throws Throwable {
                    try {
                        StickerDataRequest.this.m16940a(StickerResponse.ADAPTER.decode(responseBody.bytes()), System.currentTimeMillis());
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        CameraLog.m12966e("StickerDataRequest", "requestData exception: " + COUIBaseListPopupWindow_8);
                    }
                }

                @Override // com.oplus.camera.sticker.p166b.HttpRequestHelper.IntrinsicsJvm.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo16718a(String str) {
                    CameraLog.m12959b("StickerDataRequest", "onFail errorMsg: " + str);
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Map<String, String> m16937a(Context context, int OplusGLSurfaceView_13) {
        return new HashMap();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private byte[] m16941a(int OplusGLSurfaceView_13) {
        StickerRequest.Builder builder = new StickerRequest.Builder();
        builder.model(DeviceInfo.m16801a().m16803b());
        builder.resResolution(DeviceInfo.m16801a().m16804b(this.f16250a));
        builder.protocolVersion("100");
        builder.clientVersion(String.valueOf(DeviceInfo.m16801a().m16802a(this.f16250a)));
        builder.oplusosVersion(DeviceInfo.m16801a().m16805c());
        builder.androidVersion(DeviceInfo.m16801a().m16807e());
        builder.otaVersion(DeviceInfo.m16801a().m16806d());
        builder.locale(DeviceInfo.m16801a().m16808f());
        builder.localDataVersion(Long.valueOf(PrefUtils.m16824a(this.f16250a)));
        builder.compatibleApp(1L);
        return StickerRequest.ADAPTER.encode(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16940a(StickerResponse stickerResponse, long OplusGLSurfaceView_15) throws Throwable {
        if (stickerResponse == null) {
            CameraLog.m12966e("StickerDataRequest", "dealStickerResponseData, response is null!");
            return;
        }
        if (stickerResponse.resultCode.intValue() == 8000) {
            long jM16824a = PrefUtils.m16824a(this.f16250a);
            long jLongValue = stickerResponse.dataVersion.longValue();
            CameraLog.m12959b("StickerDataRequest", "dealStickerResponseData, localDataVersion: " + jM16824a + ", responseVersion: " + jLongValue);
            if (jLongValue > jM16824a) {
                StickerItemTableHelper.m16764b(this.f16250a);
                PrefUtils.m16829b(this.f16250a, stickerResponse.checkInterval.intValue() * DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
                String str = stickerResponse.fileServerHost;
                if (TextUtils.isEmpty(str)) {
                    CameraLog.m12966e("StickerDataRequest", "dealStickerResponseData, hort url is empty!");
                    return;
                }
                List<StickerCategory> list = stickerResponse.category;
                if (list == null) {
                    CameraLog.m12966e("StickerDataRequest", "dealStickerResponseData, responseStickerCategoryList is null!");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (StickerCategory stickerCategory : list) {
                    StickerCategoryItemWrapper stickerCategoryItemWrapperM16934a = m16934a(stickerCategory, str, OplusGLSurfaceView_15);
                    arrayList.add(stickerCategoryItemWrapperM16934a);
                    List<Sticker> list2 = stickerCategory.sticker;
                    if (list2 == null) {
                        CameraLog.m12966e("StickerDataRequest", "dealStickerResponseData, stickerList is null!");
                    } else {
                        Iterator<Sticker> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(m16935a(it.next(), stickerCategoryItemWrapperM16934a, str, OplusGLSurfaceView_15));
                            stickerCategoryItemWrapperM16934a = stickerCategoryItemWrapperM16934a;
                        }
                    }
                }
                boolean zM16747a = StickerCategoryTableHelper.m16747a(this.f16250a, arrayList);
                boolean zM16761a = StickerItemTableHelper.m16761a(this.f16250a, arrayList2);
                if (zM16747a && zM16761a) {
                    PrefUtils.m16826a(this.f16250a, jLongValue);
                    PrefUtils.m16832c(this.f16250a, OplusGLSurfaceView_15);
                } else {
                    CameraLog.m12966e("StickerDataRequest", "dealStickerResponseData db fail! updateCategoryResult: " + zM16747a + ", updateItemResult: " + zM16761a);
                }
                StickerItemTableHelper.m16769c(this.f16250a);
            } else {
                CameraLog.m12959b("StickerDataRequest", "dealStickerResponseData, data version already new. do not update!");
            }
            m16938a(this.f16250a);
            m16942b(this.f16250a);
            return;
        }
        CameraLog.m12966e("StickerDataRequest", "dealStickerResponseData error! resultCode: " + stickerResponse.resultCode + ", resultDesc: " + stickerResponse.resultDesc);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private StickerItemWrapper m16935a(Sticker sticker, StickerCategoryItemWrapper stickerCategoryItemWrapper, String str, long OplusGLSurfaceView_15) {
        StickerItemWrapper stickerItemWrapper = new StickerItemWrapper();
        stickerItemWrapper.setStickerId(sticker.f16261id.longValue());
        stickerItemWrapper.setStickerUUID(sticker.uuid);
        stickerItemWrapper.setStickerName(sticker.name);
        if (!TextUtils.isEmpty(sticker.filePath)) {
            stickerItemWrapper.setFileDownloadUrl(str + sticker.filePath);
        }
        stickerItemWrapper.setFileMd5(sticker.fileMd5);
        if (!TextUtils.isEmpty(sticker.thumbnailPath)) {
            stickerItemWrapper.setThumbnailUrl(str + sticker.thumbnailPath);
        }
        stickerItemWrapper.setThumbnailMd5(sticker.thumbnailMd5);
        if (!TextUtils.isEmpty(sticker.logoPath)) {
            stickerItemWrapper.setLogoUrl(str + sticker.logoPath);
        }
        stickerItemWrapper.setLogoMd5(sticker.logoMd5);
        stickerItemWrapper.setVersion(sticker.version.longValue());
        stickerItemWrapper.setLastRequestTime(OplusGLSurfaceView_15);
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

    /* renamed from: PlatformImplementations.kt_3 */
    private StickerCategoryItemWrapper m16934a(StickerCategory stickerCategory, String str, long OplusGLSurfaceView_15) {
        StickerCategoryItemWrapper stickerCategoryItemWrapper = new StickerCategoryItemWrapper();
        stickerCategoryItemWrapper.setCategoryName(stickerCategory.name);
        if (!TextUtils.isEmpty(stickerCategory.iconPath)) {
            stickerCategoryItemWrapper.setIconUrl(str + stickerCategory.iconPath);
        }
        stickerCategoryItemWrapper.setIconMd5(stickerCategory.iconMd5);
        if (!TextUtils.isEmpty(stickerCategory.highlightIconPath)) {
            stickerCategoryItemWrapper.setIconHighlightUrl(str + stickerCategory.highlightIconPath);
        }
        stickerCategoryItemWrapper.setIconHighlightMd5(stickerCategory.highlightIconMd5);
        stickerCategoryItemWrapper.setLastRequestTime(OplusGLSurfaceView_15);
        stickerCategoryItemWrapper.setReadableId(stickerCategory.readableId);
        stickerCategoryItemWrapper.setPosition(stickerCategory.position.intValue());
        if (stickerCategory.isNew != null) {
            stickerCategoryItemWrapper.setCategoryNew(stickerCategory.isNew.booleanValue());
        }
        return stickerCategoryItemWrapper;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16938a(Context context) {
        Intent intent = new Intent(context, (Class<?>) ThumbDownloadService.class);
        intent.setAction("com.oplusos.providers.sticker.download.category.thumbnail");
        try {
            context.startService(intent);
        } catch (IllegalStateException COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerDataRequest", "startDownloadCategoryThumbnail, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16942b(Context context) {
        Intent intent = new Intent(context, (Class<?>) ThumbDownloadService.class);
        intent.setAction("com.oplusos.providers.sticker.download.sticker.thumbnail");
        try {
            context.startService(intent);
        } catch (IllegalStateException COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerDataRequest", "startDownloadStickerThumbnail, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
    }
}
