package com.oplus.camera.watch;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Size;
import androidx.p044e.p045a.LocalBroadcastManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.MyApplication;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.watch.WatchAgentCodec;
import com.oplus.camera.watch.WatchAgentParser;
import com.oplus.camera.watch.WatchAgentContract;
import com.oplus.camera.watch.proto.WatchAgentProto;
import com.oplus.compat.content.ContextNative;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WatchAgentProxy.java */
/* renamed from: com.oplus.camera.watch.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class WatchAgentProxy implements WatchAgentContract.IntrinsicsJvm.kt_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final List<String> f23205a = List.of(ApsConstant.CAPTURE_MODE_COMMON, ApsConstant.CAPTURE_MODE_NIGHT, ApsConstant.REC_MODE_COMMON, "portrait");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private WatchAgentService f23206b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private WatchAgentContract.PlatformImplementations.kt_3 f23207c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WatchAgentModel f23208d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private WatchAgentCodec f23209e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private AtomicBoolean f23210f = new AtomicBoolean(false);

    /* renamed from: COUIBaseListPopupWindow_11 */
    private AtomicBoolean f23211g = new AtomicBoolean(false);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AtomicBoolean f23212h = new AtomicBoolean(false);

    /* renamed from: OplusGLSurfaceView_13 */
    private AtomicBoolean f23213i = new AtomicBoolean(false);

    /* renamed from: OplusGLSurfaceView_15 */
    private WatchAgentHolder f23214j = new WatchAgentHolder();

    /* renamed from: OplusGLSurfaceView_5 */
    private WatchAgentCodec.PlatformImplementations.kt_3 f23215k = new WatchAgentCodec.PlatformImplementations.kt_3() { // from class: com.oplus.camera.watch.COUIBaseListPopupWindow_12.1
        @Override // com.oplus.camera.watch.WatchAgentCodec.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24727a(byte[] bArr) {
            if (WatchAgentProxy.this.f23208d != null) {
                WatchAgentProxy.this.f23208d.m24776a(bArr, false);
            }
        }
    };

    public WatchAgentProxy(WatchAgentService watchAgentService) {
        this.f23206b = null;
        this.f23206b = watchAgentService;
    }

    @Override // com.oplus.camera.watch.WatchAgentContract.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo24732a(WatchAgentContract.PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("WatchAgentProxy", "attachCameraContract, mbAgentReady: " + this.f23211g.get());
        this.f23206b.m24703a();
        this.f23207c = aVar;
        this.f23210f.set(true);
        m24794g();
    }

    @Override // com.oplus.camera.watch.WatchAgentContract.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo24728a() {
        CameraLog.m12954a("WatchAgentProxy", "detachCameraContract");
        if (this.f23213i.getAndSet(false)) {
            this.f23209e.m24725c();
            this.f23209e = null;
        }
        this.f23207c = null;
        this.f23210f.set(false);
        this.f23212h.set(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24795a(WatchAgentModel c3569d) {
        CameraLog.m12954a("WatchAgentProxy", "attachWatchAgent, mbCameraReady: " + this.f23210f.get());
        this.f23208d = c3569d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24797c() {
        CameraLog.m12954a("WatchAgentProxy", "detachWatchAgent");
        if (!this.f23211g.get()) {
            CameraLog.m12954a("WatchAgentProxy", "detachWatchAgent, mbAgentReady is false");
            return;
        }
        WatchAgentContract.PlatformImplementations.kt_3 aVar = this.f23207c;
        if (aVar != null) {
            aVar.mo10917b();
        }
        if (this.f23213i.getAndSet(false)) {
            this.f23209e.m24725c();
            this.f23209e = null;
        }
        WatchAgentModel c3569d = this.f23208d;
        if (c3569d != null) {
            c3569d.m24777b();
        }
        this.f23211g.set(false);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m24798d() {
        WatchAgentModel c3569d = this.f23208d;
        if (c3569d != null) {
            c3569d.m24779d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24796a(byte[] bArr) {
        WatchAgentParser.PlatformImplementations.kt_3 aVarM24784b = WatchAgentParser.m24784b(bArr);
        CameraLog.m12954a("WatchAgentProxy", "onMessageReceived, itemInfo: " + aVarM24784b);
        int iM24787a = aVarM24784b.m24787a();
        if (iM24787a == 1) {
            WatchAgentProto.WatchConnectPreviewMessage watchConnectPreviewMessage = (WatchAgentProto.WatchConnectPreviewMessage) aVarM24784b.m24790b();
            this.f23214j.m24741b(new Size(watchConnectPreviewMessage.getPreviewWidth(), watchConnectPreviewMessage.getPreviewHeight()));
            this.f23214j.m24736a(watchConnectPreviewMessage.getBitRate());
            this.f23214j.m24740b(watchConnectPreviewMessage.getFrameRate());
            this.f23214j.m24743c(watchConnectPreviewMessage.getFrameInterval());
            this.f23214j.m24745d(watchConnectPreviewMessage.getCaptureQuality());
            this.f23214j.m24747e(watchConnectPreviewMessage.getSinglePackageSize());
            this.f23214j.m24749f(watchConnectPreviewMessage.getSinglePackageDelay());
            if (watchConnectPreviewMessage.getIsNeedLauncherCamera()) {
                m24792e();
            }
            this.f23211g.set(true);
            m24794g();
            return;
        }
        if (iM24787a == 21) {
            if (this.f23213i.getAndSet(false)) {
                this.f23209e.m24725c();
                this.f23209e = null;
                return;
            }
            return;
        }
        if (iM24787a == 4) {
            if (this.f23210f.get()) {
                this.f23207c.mo10916a(ApsConstant.CAPTURE_MODE_COMMON);
                return;
            }
            return;
        }
        if (iM24787a == 5) {
            if (this.f23212h.get()) {
                CameraLog.m12954a("WatchAgentProxy", "onMessageReceived, delayCapturing");
                return;
            }
            WatchAgentProto.WatchCaptureMessage watchCaptureMessage = (WatchAgentProto.WatchCaptureMessage) aVarM24784b.m24790b();
            String str = "off";
            if (watchCaptureMessage.getCountDown() != 0) {
                if (1 == watchCaptureMessage.getCountDown()) {
                    str = "3";
                } else if (2 == watchCaptureMessage.getCountDown()) {
                    str = FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE;
                }
            }
            if (this.f23210f.get()) {
                this.f23207c.mo10918b(str);
                return;
            }
            return;
        }
        if (iM24787a == 6 && this.f23210f.get()) {
            this.f23207c.mo10923g();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m24792e() {
        boolean zM11096g = MyApplication.m11096g();
        Intent intent = new Intent();
        CameraLog.m12954a("WatchAgentProxy", "decideWayCameraBindWatchAgent, isCameraRunning: " + zM11096g);
        if (zM11096g) {
            intent.setAction("filter_bind_watch_agent");
            intent.putExtra("android_camera_launch_type", "watch_launch_from_framework");
            LocalBroadcastManager.m3241a(this.f23206b).m3245a(intent);
        } else {
            intent.setComponent(new ComponentName(this.f23206b, (Class<?>) Camera.class));
            intent.addFlags(872415232);
            intent.putExtra("android_camera_launch_type", "watch_launch_from_framework");
            if (!((KeyguardManager) this.f23206b.getSystemService("keyguard")).isKeyguardSecure()) {
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
            } else {
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA_SECURE");
            }
            try {
                ContextNative.m24902a(intent);
            } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                this.f23206b.startActivity(intent);
            }
        }
        CameraLog.m12954a("WatchAgentProxy", "decideWayCameraBindWatchAgent X");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m24793f() {
        WatchAgentContract.PlatformImplementations.kt_3 aVar = this.f23207c;
        if (aVar == null) {
            CameraLog.m12954a("WatchAgentProxy", "prepareWatchAgentCodec, mCameraContract is null");
            return;
        }
        this.f23214j.m24737a(aVar.mo10921e());
        Size sizeM24742c = this.f23214j.m24742c();
        if (sizeM24742c == null) {
            CameraLog.m12954a("WatchAgentProxy", "prepareWatchAgentCodec, codecSize is null");
            return;
        }
        CameraLog.m12954a("WatchAgentProxy", "prepareWatchAgentCodec");
        this.f23213i.set(true);
        this.f23207c.mo10915a(sizeM24742c);
        this.f23209e = new WatchAgentCodec();
        this.f23209e.m24719a(sizeM24742c);
        this.f23209e.m24720a(this.f23207c.mo10919c());
        this.f23209e.m24721a(this.f23215k);
        this.f23209e.m24718a(this.f23214j.m24744d());
        this.f23209e.m24724b(this.f23214j.m24746e());
        this.f23209e.m24726c(this.f23214j.m24748f());
        this.f23209e.m24722a(this.f23214j.m24753j());
        this.f23209e.m24723b();
        this.f23208d.m24773a(this.f23214j);
        this.f23208d.m24774a(this.f23207c.mo10920d(), sizeM24742c, this.f23207c.mo10922f());
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m24794g() {
        CameraLog.m12954a("WatchAgentProxy", "connectCameraPreviewIfAtomicReady, mbAgentReady: " + this.f23211g.get() + ", mbCameraReady: " + this.f23210f.get() + ", mbCodecRunning: " + this.f23213i.get());
        if (this.f23211g.get() && this.f23210f.get() && !this.f23213i.get()) {
            WatchAgentContract.PlatformImplementations.kt_3 aVar = this.f23207c;
            if (aVar != null) {
                aVar.mo10914a();
            }
            m24793f();
        }
    }

    @Override // com.oplus.camera.watch.WatchAgentContract.IntrinsicsJvm.kt_4
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo24734b() {
        CameraLog.m12954a("WatchAgentProxy", "onPause");
        if (!this.f23211g.get()) {
            CameraLog.m12954a("WatchAgentProxy", "onPause, mbAgentReady is false");
            return;
        }
        if (this.f23213i.getAndSet(false)) {
            this.f23209e.m24725c();
            this.f23209e = null;
        }
        WatchAgentModel c3569d = this.f23208d;
        if (c3569d != null) {
            c3569d.m24778c();
        }
    }

    @Override // com.oplus.camera.watch.WatchAgentContract.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo24733a(boolean z) {
        if (this.f23214j.m24735a() != null && this.f23207c != null && this.f23214j.m24735a().equals(this.f23207c.mo10921e()) && this.f23213i.get() && this.f23214j.m24753j() == z) {
            CameraLog.m12954a("WatchAgentProxy", "createNewConfig, size no change");
            this.f23208d.m24774a(this.f23207c.mo10920d(), this.f23214j.m24742c(), this.f23207c.mo10922f());
            return;
        }
        CameraLog.m12954a("WatchAgentProxy", "createNewConfig");
        if (this.f23213i.getAndSet(false)) {
            this.f23209e.m24725c();
            this.f23209e = null;
        }
        this.f23214j.m24738a(z);
        m24794g();
    }

    @Override // com.oplus.camera.watch.WatchAgentContract.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo24731a(int OplusGLSurfaceView_13, Bitmap bitmap) {
        CameraLog.m12954a("WatchAgentProxy", "captureStatusChange, status: " + OplusGLSurfaceView_13 + ", mbAgentReady: " + this.f23211g.get());
        if (this.f23211g.get()) {
            if (OplusGLSurfaceView_13 == 0) {
                this.f23208d.m24775a(true);
                this.f23212h.set(true);
            } else if (OplusGLSurfaceView_13 == 1) {
                this.f23208d.m24775a(false);
                this.f23212h.set(false);
            } else {
                if (OplusGLSurfaceView_13 != 2) {
                    return;
                }
                this.f23208d.m24772a(bitmap, this.f23214j.m24739b().getHeight(), this.f23214j.m24739b().getHeight());
                this.f23212h.set(false);
            }
        }
    }

    @Override // com.oplus.camera.watch.WatchAgentContract.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo24730a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (this.f23211g.get()) {
            this.f23208d.m24771a(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }
    }

    @Override // com.oplus.camera.watch.WatchAgentContract.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo24729a(int OplusGLSurfaceView_13) {
        if (this.f23211g.get()) {
            this.f23208d.m24770a(OplusGLSurfaceView_13);
        }
    }
}
