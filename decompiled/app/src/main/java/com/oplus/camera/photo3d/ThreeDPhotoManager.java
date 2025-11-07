package com.oplus.camera.photo3d;

import android.app.Activity;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.Surface;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.photo3d.ThreeDVideoHelper;
import com.oplus.camera.photo3d.p159ui.SceneItem;
import com.oplus.camera.photo3d.p159ui.ThreeDPhotoUIControl;
import com.p094b.p095a.O3DPHOTO_MODEL;
import com.p094b.p095a.RenderEngineFactory;
import com.p094b.p095a.RenderEngine;
import com.p094b.p095a.SurfaceListener;
import com.p094b.p095a.p096a.AnimConfig;
import com.p094b.p095a.p096a.AnimationManager;
import com.p094b.p095a.p096a.AnimDirection;
import com.p094b.p095a.p096a.AnimID;
import com.p094b.p095a.p096a.IAnimator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreeDPhotoManager.java */
/* renamed from: com.oplus.camera.photo3d.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ThreeDPhotoManager implements ThreeDVideoHelper.IntrinsicsJvm.kt_4, ThreeDPhotoUIControl.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Activity f15185c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Context f15186d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final CameraInterface f15187e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final CameraUIInterface f15188f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final ThreeDVideoHelper f15189g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private RenderEngine f15190h;

    /* renamed from: OplusGLSurfaceView_13 */
    private O3DPHOTO_MODEL f15191i;

    /* renamed from: OplusGLSurfaceView_15 */
    private RecordingListener f15192j;

    /* renamed from: OplusGLSurfaceView_5 */
    private AnimationManager f15193k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f15194l;

    /* renamed from: q */
    private int f15199q;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f15195m = true;

    /* renamed from: OplusGLSurfaceView_11 */
    private final ConditionVariable f15196n = new ConditionVariable();

    /* renamed from: o */
    private AtomicBoolean f15197o = new AtomicBoolean(false);

    /* renamed from: p */
    private AtomicLong f15198p = new AtomicLong(0);

    /* renamed from: r */
    private boolean f15200r = false;

    /* renamed from: s */
    private SurfaceListener f15201s = new SurfaceListener() { // from class: com.oplus.camera.photo3d.IntrinsicsJvm.kt_4.1
        @Override // com.p094b.p095a.SurfaceListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6353a(Surface surface) {
            CameraLog.m12959b(f6238a, "onRenderStart, mbPortraitDirection: " + ThreeDPhotoManager.this.f15195m + ", mbMainObjectOnRight: " + ThreeDPhotoManager.this.f15200r);
            IAnimator interfaceC1229jMo6315a = ThreeDPhotoManager.this.f15190h.mo6315a(ThreeDPhotoManager.this.m15207g(), ThreeDPhotoManager.this.f15195m, ThreeDPhotoManager.this.m15210h());
            if (interfaceC1229jMo6315a != null) {
                ThreeDPhotoManager.this.m15203e().m6259a(interfaceC1229jMo6315a).m6261a();
            }
        }

        @Override // com.p094b.p095a.SurfaceListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo6356b(Surface surface) {
            CameraLog.m12959b(f6238a, "onRenderFinish");
        }

        @Override // com.p094b.p095a.SurfaceListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6354a(AnimationManager c1224e) {
            CameraLog.m12959b(f6238a, "onAnimationStart");
        }

        @Override // com.p094b.p095a.SurfaceListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo6357b(AnimationManager c1224e) {
            CameraLog.m12959b(f6238a, "onAnimationComplete");
            ThreeDPhotoManager.this.f15183a.sendEmptyMessage(CommonStatusCodes.AUTHENTICATE_SUCCESS);
        }

        @Override // com.p094b.p095a.SurfaceListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo6358c(AnimationManager c1224e) {
            CameraLog.m12959b(f6238a, "onAnimationFinish");
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private Handler f15183a = m15191a("3d photo thread");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Handler f15184b = m15191a("3d photo mesh thread");

    public ThreeDPhotoManager(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        this.f15194l = 1;
        this.f15199q = 0;
        this.f15185c = activity;
        this.f15186d = this.f15185c.getApplicationContext();
        this.f15187e = interfaceC2646a;
        this.f15188f = cameraUIInterface;
        this.f15189g = new ThreeDVideoHelper(this.f15186d, this.f15183a, this.f15187e, this.f15188f);
        this.f15189g.m15242a(this);
        this.f15194l = this.f15187e.mo10590t().getInt("pref_3d_photo_scene_type", 1);
        this.f15199q = CameraLog.m12957a() ? 8 : 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Handler m15191a(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new IntrinsicsJvm.kt_4(handlerThread.getLooper());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15220a(long OplusGLSurfaceView_15, long j2) {
        this.f15184b.obtainMessage(1000, new PlatformImplementations.kt_3(m15198b(OplusGLSurfaceView_15), j2)).sendToTarget();
    }

    @Override // com.oplus.camera.photo3d.ThreeDVideoHelper.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15221a(Surface surface) {
        CameraLog.m12959b("ThreeDPhotoManager", "onEncodeSurfaceCreated");
        this.f15183a.obtainMessage(1002, surface).sendToTarget();
    }

    @Override // com.oplus.camera.photo3d.p159ui.ThreeDPhotoUIControl.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15223a(SceneItem c2873d) {
        this.f15194l = c2873d.m15277a();
        CameraLog.m12959b("ThreeDPhotoManager", "onMenuItemClicked, item: " + c2873d.m15277a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15219a() {
        this.f15184b.removeMessages(1000);
    }

    /* compiled from: ThreeDPhotoManager.java */
    /* renamed from: com.oplus.camera.photo3d.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Handler {
        public IntrinsicsJvm.kt_4(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            super.handleMessage(message);
            switch (message.what) {
                case 1000:
                    PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) message.obj;
                    ThreeDPhotoManager.this.f15191i = aVar.f15203a;
                    ThreeDPhotoManager c2864b = ThreeDPhotoManager.this;
                    c2864b.f15195m = c2864b.f15191i.f6196g;
                    ThreeDPhotoManager.this.m15195a(-1L);
                    ThreeDPhotoManager.this.f15197o.set(true);
                    ThreeDPhotoManager.this.f15189g.m15240a();
                    ThreeDPhotoManager.this.f15198p.set(aVar.f15204b);
                    break;
                case CommonStatusCodes.AUTHENTICATE_SUCCESS /* 1001 */:
                    ThreeDPhotoManager.this.f15189g.m15244c();
                    ThreeDPhotoManager.this.f15190h.mo6320b();
                    ThreeDPhotoManager.this.m15202d();
                    break;
                case 1002:
                    Surface surface = (Surface) message.obj;
                    Size sizeM15243b = ThreeDPhotoManager.this.f15189g.m15243b();
                    ThreeDPhotoManager c2864b2 = ThreeDPhotoManager.this;
                    c2864b2.f15190h = RenderEngineFactory.m6321a(c2864b2.f15185c, ThreeDPhotoManager.this.f15191i).mo6316a(surface, sizeM15243b.getHeight(), sizeM15243b.getWidth()).mo6317a(ThreeDPhotoManager.this.f15201s);
                    ThreeDPhotoManager.this.f15190h.m6319a(ThreeDPhotoManager.this.f15199q);
                    ThreeDPhotoManager.this.f15190h.mo6318a();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15195a(long OplusGLSurfaceView_15) {
        if (this.f15197o.get()) {
            CameraLog.m12959b("ThreeDPhotoManager", "waitRendingDone");
            this.f15196n.close();
            if (OplusGLSurfaceView_15 > 0) {
                this.f15196n.block(OplusGLSurfaceView_15);
            } else {
                this.f15196n.block();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15202d() {
        CameraLog.m12959b("ThreeDPhotoManager", "notifyRecordingStop");
        RecordingListener interfaceC2863a = this.f15192j;
        if (interfaceC2863a != null) {
            interfaceC2863a.mo15190a(this.f15198p.get());
        }
        this.f15197o.set(false);
        this.f15196n.open();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private O3DPHOTO_MODEL m15198b(long OplusGLSurfaceView_15) {
        PhotoMeshData meshData = PhotoMeshData.getMeshData(OplusGLSurfaceView_15);
        O3DPHOTO_MODEL c1236g = new O3DPHOTO_MODEL();
        c1236g.f6190a = meshData.mVerticesBuffer;
        c1236g.f6191b = meshData.mColorsBuffer;
        c1236g.f6192c = meshData.mFacesBuffer;
        c1236g.f6194e = meshData.mStride;
        c1236g.f6193d = meshData.mLabels;
        c1236g.f6195f = meshData.mRotated;
        c1236g.f6197h = meshData.mTextureData;
        c1236g.f6196g = meshData.mbPortraitDirection;
        this.f15200r = meshData.mbMainObjectOnRight;
        return c1236g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15224b() {
        RenderEngine interfaceC1237h = this.f15190h;
        if (interfaceC1237h != null) {
            interfaceC1237h.mo6320b();
        }
        m15195a(3000L);
        Handler handler = this.f15183a;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f15183a = null;
        }
        Handler handler2 = this.f15184b;
        if (handler2 != null) {
            handler2.getLooper().quitSafely();
            this.f15184b = null;
        }
        this.f15192j = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15222a(RecordingListener interfaceC2863a) {
        this.f15192j = interfaceC2863a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimationManager m15203e() {
        AnimationManager c1224e = this.f15193k;
        if (c1224e == null) {
            this.f15193k = new AnimationManager(m15205f()).m6260a(false);
            return this.f15193k;
        }
        c1224e.m6258a(0).m6249b((IAnimator) null);
        this.f15193k.m6262a(m15205f());
        return this.f15193k;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int m15205f() {
        int OplusGLSurfaceView_13 = this.f15194l;
        return (2 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13) ? 5000 : 3000;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m15225c() {
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_3D_PHOTO_MESH_PROCESS_TIME) + m15205f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimID m15207g() {
        int OplusGLSurfaceView_13 = this.f15194l;
        if (OplusGLSurfaceView_13 == 1) {
            return AnimID.DollyZoom;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return AnimID.Circle;
        }
        if (OplusGLSurfaceView_13 == 3) {
            return AnimID.Swing;
        }
        if (OplusGLSurfaceView_13 == 4) {
            return AnimID.FixedGaze;
        }
        return AnimID.DollyZoom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public AnimConfig m15210h() {
        if (4 != this.f15194l) {
            return null;
        }
        return new AnimConfig(m15212i());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private AnimDirection m15212i() {
        int iMo10592v = this.f15187e.mo10592v();
        if (iMo10592v == 0 || iMo10592v == 90) {
            if (this.f15200r) {
                return AnimDirection.ANIM_DIRECTION_FIXEDGAZE_LEFT2RIGHT;
            }
            return AnimDirection.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT;
        }
        if (iMo10592v == 180 || iMo10592v == 270) {
            if (this.f15200r) {
                return AnimDirection.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT;
            }
            return AnimDirection.ANIM_DIRECTION_FIXEDGAZE_LEFT2RIGHT;
        }
        return AnimDirection.ANIM_DIRECTION_DEFAULT;
    }

    /* compiled from: ThreeDPhotoManager.java */
    /* renamed from: com.oplus.camera.photo3d.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        O3DPHOTO_MODEL f15203a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        long f15204b;

        public PlatformImplementations.kt_3(O3DPHOTO_MODEL c1236g, long OplusGLSurfaceView_15) {
            this.f15203a = c1236g;
            this.f15204b = OplusGLSurfaceView_15;
        }
    }
}
