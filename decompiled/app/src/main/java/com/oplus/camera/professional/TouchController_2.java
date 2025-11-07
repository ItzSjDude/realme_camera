package com.oplus.camera.professional;

/* compiled from: NightPanelContainer.java */
/* loaded from: classes2.dex */
public class m_renamed extends com.oplus.camera.professional.p_renamed {
    public m_renamed(android.content.Context context, com.oplus.camera.capmode.a_renamed aVar) {
        super(context, aVar);
    }

    @Override // com.oplus.camera.professional.p_renamed
    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, android.os.Handler handler, com.oplus.camera.professional.p_renamed.a_renamed aVar) {
        a_renamed(hVar.u_renamed(), hVar.v_renamed(), hVar.w_renamed(), handler);
        a_renamed((aVar == null || aVar.f5203a <= 0) ? hVar.x_renamed() : aVar.f5203a, (aVar == null || aVar.f5204b <= 0) ? hVar.y_renamed() : aVar.f5204b, hVar.a_renamed(256), handler);
        a_renamed(hVar.B_renamed(), handler);
        a_renamed(hVar.n_renamed(), hVar.m_renamed(), handler);
        e_renamed();
    }

    @Override // com.oplus.camera.professional.p_renamed
    protected void a_renamed(com.oplus.camera.professional.z_renamed zVar, long j_renamed, long j2, java.util.List<android.util.Size> list) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        zVar.c_renamed().clear();
        zVar.f_renamed(com.oplus.camera.R_renamed.array.night_pro_exposure_time_names);
        super.a_renamed(zVar, j_renamed, j2, list);
    }
}
