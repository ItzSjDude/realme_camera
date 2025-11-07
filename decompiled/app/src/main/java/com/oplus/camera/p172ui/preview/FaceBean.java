package com.oplus.camera.p172ui.preview;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FaceBean.java */
/* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class FaceBean {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<FacePointBean> f22123a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RectF f22124b = new RectF();

    public FaceBean(List<FacePointBean> list) {
        this.f22123a = new ArrayList();
        this.f22123a = list;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<FacePointBean> m23496a() {
        return this.f22123a;
    }
}
