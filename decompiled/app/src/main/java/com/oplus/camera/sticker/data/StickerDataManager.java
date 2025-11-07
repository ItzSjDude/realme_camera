package com.oplus.camera.sticker.data;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.StickerDataRequest;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.download.DownloadManagerHelper;
import com.oplus.camera.sticker.download.StickerInstaller;
import com.oplus.camera.sticker.p165a.StickerCategoryTableHelper;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import java.util.List;

/* compiled from: StickerDataManager.java */
/* renamed from: com.oplus.camera.sticker.data.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class StickerDataManager implements StickerDataRequest.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f16226a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IntrinsicsJvm.kt_4 f16227b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private HandlerThread f16228c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private StickerDataRequest f16229d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PlatformImplementations.kt_3 f16230e = null;

    /* compiled from: StickerDataManager.java */
    /* renamed from: com.oplus.camera.sticker.data.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16878a(int OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.sticker.StickerDataRequest.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16868a(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = this.f16230e;
        if (aVar != null) {
            aVar.mo16878a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16871a(PlatformImplementations.kt_3 aVar) {
        this.f16230e = aVar;
    }

    public StickerDataManager(Context context) {
        this.f16226a = null;
        this.f16227b = null;
        this.f16228c = null;
        this.f16229d = null;
        this.f16226a = context;
        this.f16229d = new StickerDataRequest(context);
        this.f16229d.m16945a(this);
        this.f16228c = new HandlerThread("StickerDataManager");
        this.f16228c.start();
        this.f16227b = new IntrinsicsJvm.kt_4(this.f16228c.getLooper());
        m16874c();
        CameraLog.m12959b("StickerDataManager", "StickerDataManager this: " + this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16867a() {
        CameraLog.m12959b("StickerDataManager", "register this: " + this);
        DownloadManagerHelper.m16879a().m16884a(this.f16226a);
        StickerDataRequest c2999f = this.f16229d;
        if (c2999f != null) {
            c2999f.m16944a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16873b() {
        CameraLog.m12959b("StickerDataManager", "unregister this: " + this);
        DownloadManagerHelper.m16879a().m16886b(this.f16226a);
        StickerDataRequest c2999f = this.f16229d;
        if (c2999f != null) {
            c2999f.m16946b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16874c() {
        if (this.f16227b.hasMessages(1)) {
            return;
        }
        this.f16227b.sendEmptyMessage(1);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16875d() {
        if (this.f16227b.hasMessages(2)) {
            return;
        }
        CameraLog.m12959b("StickerDataManager", "checkBuildInData");
        this.f16227b.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m16864g() throws Throwable {
        CameraLog.m12959b("StickerDataManager", "checkBuildInDataByThread");
        CameraLog.m12952a("checkBuildInDataByThread");
        BuildInStickerTools.m16850a(this.f16226a);
        m16874c();
        CameraLog.m12958b("checkBuildInDataByThread");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m16876e() {
        if (this.f16227b.hasMessages(3)) {
            return;
        }
        CameraLog.m12959b("StickerDataManager", "requestSticker");
        this.f16227b.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m16865h() {
        CameraLog.m12959b("StickerDataManager", "requestStickerByThread");
        CameraLog.m12952a("requestStickerByThread");
        this.f16229d.m16947c();
        CameraLog.m12958b("requestStickerByThread");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16869a(StickerItem stickerItem) {
        if (this.f16227b.hasMessages(5)) {
            return;
        }
        CameraLog.m12959b("StickerDataManager", "updateStickerDownloadTime, item: " + stickerItem);
        Message messageObtainMessage = this.f16227b.obtainMessage(5);
        messageObtainMessage.obj = stickerItem;
        this.f16227b.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16853a(StickerCategoryItem stickerCategoryItem) {
        CameraLog.m12959b("StickerDataManager", "clickStickerCategoryByThread, item: " + stickerCategoryItem);
        if (stickerCategoryItem.isCategoryNew()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_new", (Integer) 0);
            CameraLog.m12959b("StickerDataManager", "clickStickerCategoryByThread, count: " + StickerCategoryTableHelper.m16740a(this.f16226a, "readable_id", stickerCategoryItem.getReadableId(), contentValues));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16859b(StickerItem stickerItem) {
        CameraLog.m12959b("StickerDataManager", "updateStickerDownloadTimeByThread, item: " + stickerItem);
        if (!stickerItem.isBuildIn() || stickerItem.getDownloadTime() > 0) {
            return;
        }
        int iM16748a = StickerItemTableHelper.m16748a(this.f16226a, stickerItem);
        CameraLog.m12959b("StickerDataManager", "updateStickerDownloadTimeByThread, rowUpdate: " + iM16748a);
        if (iM16748a > 0) {
            StickerMediator.m16958a(this.f16226a).m16970c(stickerItem);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16870a(StickerItem stickerItem, boolean z) {
        if (this.f16227b.hasMessages(6)) {
            return;
        }
        CameraLog.m12959b("StickerDataManager", "startDownloadSticker, item: " + stickerItem);
        Message messageObtainMessage = this.f16227b.obtainMessage(6);
        messageObtainMessage.arg1 = z ? 1 : 0;
        messageObtainMessage.obj = stickerItem;
        this.f16227b.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16860b(StickerItem stickerItem, boolean z) {
        CameraLog.m12959b("StickerDataManager", "downloadStickerItemByThread, item: " + stickerItem + ", allowAllNetwork: " + z);
        if (stickerItem == null || TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            CameraLog.m12967f("StickerDataManager", "downloadStickerItemByThread, item is null or empty. item: " + stickerItem);
            return;
        }
        if (!stickerItem.isDownloaded() || stickerItem.needUpdate()) {
            DownloadManagerHelper.m16879a().m16889c(this.f16226a, stickerItem, z);
        } else {
            if (!stickerItem.isBuildIn() || stickerItem.getDownloadTime() > 0) {
                return;
            }
            StickerItemTableHelper.m16748a(this.f16226a, stickerItem);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16872a(List<StickerItem> list) {
        if (this.f16227b.hasMessages(7, list)) {
            return;
        }
        CameraLog.m12959b("StickerDataManager", "delete, list: " + list);
        Message messageObtainMessage = this.f16227b.obtainMessage(7);
        messageObtainMessage.obj = list;
        this.f16227b.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m16862b(List<StickerItem> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                StickerInstaller.m16905a(this.f16226a, list, true);
                return;
            }
        }
        CameraLog.m12966e("StickerDataManager", "deleteStickerItemsByThread, list is null or empty.");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m16877f() {
        if (this.f16227b.hasMessages(8)) {
            return;
        }
        CameraLog.m12959b("StickerDataManager", "autoClearClickNewStatus");
        this.f16227b.sendEmptyMessage(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m16866i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StickerItemTableHelper.m16756a(this.f16226a, jCurrentTimeMillis, 604800000L);
        StickerCategoryTableHelper.m16745a(this.f16226a, jCurrentTimeMillis, 604800000L);
    }

    /* compiled from: StickerDataManager.java */
    /* renamed from: com.oplus.camera.sticker.data.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Handler {
        public IntrinsicsJvm.kt_4(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            switch (message.what) {
                case 1:
                    break;
                case 2:
                    StickerDataManager.this.m16864g();
                    break;
                case 3:
                    StickerDataManager.this.m16865h();
                    break;
                case 4:
                    if (message.obj instanceof StickerCategoryItem) {
                        StickerDataManager.this.m16853a((StickerCategoryItem) message.obj);
                        break;
                    }
                    break;
                case 5:
                    if (message.obj instanceof StickerItem) {
                        StickerDataManager.this.m16859b((StickerItem) message.obj);
                        break;
                    }
                    break;
                case 6:
                    if (message.obj instanceof StickerItem) {
                        StickerDataManager.this.m16860b((StickerItem) message.obj, message.arg1 == 1);
                        break;
                    }
                    break;
                case 7:
                    StickerDataManager.this.m16862b((List<StickerItem>) message.obj);
                    break;
                case 8:
                    StickerDataManager.this.m16866i();
                    break;
                default:
                    CameraLog.m12967f("StickerDataManager", "handleMessage, message, what: " + message.what);
                    break;
            }
        }
    }
}
