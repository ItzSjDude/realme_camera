package com.oplus.camera.professional;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Size;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.professional.PanelContainer;
import java.util.List;

/* compiled from: NightPanelContainer.java */
/* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class NightPanelContainer extends PanelContainer {
    public NightPanelContainer(Context context, CameraInterface interfaceC2646a) {
        super(context, interfaceC2646a);
    }

    @Override // com.oplus.camera.professional.PanelContainer
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15728a(OplusCameraCharacteristics c2698h, Handler handler, PanelContainer.PlatformImplementations.kt_3 aVar) {
        m15808a(c2698h.m13286u(), c2698h.m13287v(), c2698h.m13288w(), handler);
        m15812a((aVar == null || aVar.f15649a <= 0) ? c2698h.m13289x() : aVar.f15649a, (aVar == null || aVar.f15650b <= 0) ? c2698h.m13290y() : aVar.f15650b, c2698h.m13258a(256), handler);
        m15816a(c2698h.m13245B(), handler);
        m15805a(c2698h.m13279n(), c2698h.m13278m(), handler);
        m15832e();
    }

    @Override // com.oplus.camera.professional.PanelContainer
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo15729a(SubModeBarData c2908z, long OplusGLSurfaceView_15, long j2, List<Size> list) throws Resources.NotFoundException, NumberFormatException {
        c2908z.m16147c().clear();
        c2908z.m16153f(R.array.night_pro_exposure_time_names);
        super.mo15729a(c2908z, OplusGLSurfaceView_15, j2, list);
    }
}
