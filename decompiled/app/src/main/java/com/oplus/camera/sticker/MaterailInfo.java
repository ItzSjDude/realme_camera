package com.oplus.camera.sticker;

import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.RawTexture;
import com.sensetime.stmobile.STMobileStickerNative;
import com.sensetime.stmobile.model.STHumanAction;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: MaterailInfo.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class MaterailInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    private Object f16183a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private STMobileStickerNative f16184b = new STMobileStickerNative();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private STHumanAction f16185c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private STHumanAction f16186d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private LinkedHashMap<Long, STHumanAction> f16187e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f16188f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private RawTexture f16189g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16190h = -1;

    /* renamed from: OplusGLSurfaceView_13 */
    private Size f16191i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f16192j = 1.0f;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f16193k = 1.0f;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f16194l = false;

    /* renamed from: PlatformImplementations.kt_3 */
    public STMobileStickerNative m16773a() {
        return this.f16184b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16777a(STHumanAction sTHumanAction) {
        this.f16185c = sTHumanAction;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16780b(STHumanAction sTHumanAction) {
        synchronized (this.f16183a) {
            if (this.f16187e != null && !this.f16187e.isEmpty() && this.f16194l) {
                Iterator<Long> it = this.f16187e.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (this.f16187e.get(next) == null) {
                        this.f16187e.put(next, sTHumanAction);
                        CameraLog.m12954a("MaterialInfo", "setPreviewSTHumanActionForCheck, timeStamp: " + next);
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16774a(float COUIBaseListPopupWindow_12) {
        this.f16192j = COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public STHumanAction m16779b(float COUIBaseListPopupWindow_12) {
        return STHumanAction.humanActionResize(COUIBaseListPopupWindow_12 / this.f16192j, this.f16185c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16775a(long OplusGLSurfaceView_15) {
        this.f16188f = OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long m16778b() {
        return this.f16188f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16776a(RawTexture c2768s) {
        this.f16189g = c2768s;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public RawTexture m16781c() {
        return this.f16189g;
    }
}
