package com.oplus.camera.sticker.download.thumbnail;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.p044e.p045a.LocalBroadcastManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.data.StickerCategoryItemWrapper;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.data.StickerItemWrapper;
import com.oplus.camera.sticker.download.thumbnail.ThumbnailDownloadThread;
import com.oplus.camera.sticker.p165a.StickerCategoryTableHelper;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import com.oplus.camera.sticker.p167c.MD5Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ThumbDownloadService extends Service implements ThumbnailDownloadThread.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private ThreadPoolExecutor f16239a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f16240b = 0;

    @Override // com.oplus.camera.sticker.download.thumbnail.ThumbnailDownloadThread.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16924b(Context context, boolean z, String str) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CameraLog.m12959b("ThumbDownloadService", "onCreate");
        this.f16239a = m16917a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ThreadPoolExecutor m16917a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int OplusGLSurfaceView_13, int i2) {
        if (intent == null) {
            CameraLog.m12966e("ThumbDownloadService", "onStartCommand, intent is null");
            return 1;
        }
        final String action = intent.getAction();
        CameraLog.m12959b("ThumbDownloadService", "onStartCommand, action: " + action);
        this.f16239a.submit(new Runnable() { // from class: com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService.1
            @Override // java.lang.Runnable
            public void run() {
                if ("com.oplusos.providers.sticker.download.category.thumbnail".equals(action)) {
                    ThumbDownloadService thumbDownloadService = ThumbDownloadService.this;
                    thumbDownloadService.m16918a(thumbDownloadService);
                } else if ("com.oplusos.providers.sticker.download.sticker.thumbnail".equals(action)) {
                    ThumbDownloadService thumbDownloadService2 = ThumbDownloadService.this;
                    thumbDownloadService2.m16921b(thumbDownloadService2);
                }
            }
        });
        return super.onStartCommand(intent, OplusGLSurfaceView_13, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16918a(Context context) {
        List<StickerCategoryItem> listM16744a = StickerCategoryTableHelper.m16744a(context);
        ArrayList arrayList = new ArrayList();
        for (StickerCategoryItem stickerCategoryItem : listM16744a) {
            if (stickerCategoryItem instanceof StickerCategoryItemWrapper) {
                StickerCategoryItemWrapper stickerCategoryItemWrapper = (StickerCategoryItemWrapper) stickerCategoryItem;
                if (TextUtils.isEmpty(stickerCategoryItemWrapper.getIconUrl()) && TextUtils.isEmpty(stickerCategoryItemWrapper.getIconHighlightUrl())) {
                    CameraLog.m12966e("ThumbDownloadService", "no download url, categoryItemWrapper: " + stickerCategoryItemWrapper.getReadableId());
                } else if (TextUtils.isEmpty(stickerCategoryItem.getIconFileUri()) || TextUtils.isEmpty(stickerCategoryItem.getIconHighlightFileUri())) {
                    arrayList.add(stickerCategoryItemWrapper);
                } else if (!m16920a(stickerCategoryItemWrapper.getIconPath(), stickerCategoryItemWrapper.getIconMd5())) {
                    arrayList.add(stickerCategoryItemWrapper);
                } else if (!m16920a(stickerCategoryItemWrapper.getIconHighlightPath(), stickerCategoryItemWrapper.getIconHighlightMd5())) {
                    arrayList.add(stickerCategoryItemWrapper);
                }
            }
        }
        synchronized (this) {
            this.f16240b += arrayList.size();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f16239a.submit(new ThumbnailDownloadThread(this, (StickerCategoryItemWrapper) it.next(), this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16921b(Context context) {
        List<StickerItem> listM16755a = StickerItemTableHelper.m16755a(context, false);
        ArrayList arrayList = new ArrayList();
        for (StickerItem stickerItem : listM16755a) {
            if (stickerItem instanceof StickerItemWrapper) {
                StickerItemWrapper stickerItemWrapper = (StickerItemWrapper) stickerItem;
                if (TextUtils.isEmpty(stickerItemWrapper.getThumbnailUrl()) && TextUtils.isEmpty(stickerItemWrapper.getLogoUrl())) {
                    CameraLog.m12966e("ThumbDownloadService", "downloadStickerThumbnail, no download url, sticker uuid: " + stickerItemWrapper.getStickerUUID() + ", name: " + stickerItemWrapper.getStickerName());
                } else if (TextUtils.isEmpty(stickerItemWrapper.getThumbnailFileUri())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!TextUtils.isEmpty(stickerItemWrapper.getLogoUrl()) && TextUtils.isEmpty(stickerItemWrapper.getLogoFileUri())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!m16920a(stickerItemWrapper.getThumbnailPath(), stickerItemWrapper.getThumbnailMd5())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!TextUtils.isEmpty(stickerItemWrapper.getLogoPath()) && !m16920a(stickerItemWrapper.getLogoPath(), stickerItemWrapper.getLogoMd5())) {
                    arrayList.add(stickerItemWrapper);
                }
            }
        }
        synchronized (this) {
            this.f16240b += arrayList.size();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f16239a.submit(new ThumbnailDownloadThread(this, (StickerItemWrapper) it.next(), this));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m16920a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            CameraLog.m12966e("ThumbDownloadService", "checkMd5, empty value! filePath: " + str + ", fileMd5: " + str2);
            return false;
        }
        return MD5Utils.m16823a(str, str2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CameraLog.m12959b("ThumbDownloadService", "onDestroy");
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.ThumbnailDownloadThread.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16923a(Context context, boolean z, String str) {
        synchronized (this) {
            this.f16240b--;
            CameraLog.m12959b("ThumbDownloadService", "onFirstDownloadFinish, mThumbnailDownloadCount: " + this.f16240b);
            if (this.f16240b == 0) {
                LocalBroadcastManager.m3241a(getApplicationContext()).m3245a(new Intent("com.sticker.thumbnail.service"));
            }
        }
    }
}
