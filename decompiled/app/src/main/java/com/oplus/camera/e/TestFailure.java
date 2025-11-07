package com.oplus.camera.e_renamed;

/* compiled from: OneCameraProxy.java */
/* loaded from: classes2.dex */
public class f_renamed implements com.oplus.camera.e_renamed.d_renamed {
    private com.oplus.camera.e_renamed.e_renamed n_renamed;
    private com.oplus.camera.capmode.a_renamed.a_renamed o_renamed;

    public f_renamed() {
        this.n_renamed = null;
        this.o_renamed = null;
        this.n_renamed = new com.oplus.camera.e_renamed.e_renamed(1);
        this.o_renamed = new com.oplus.camera.capmode.a_renamed.a_renamed();
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed D_renamed() {
        return this.o_renamed;
    }

    public boolean B_renamed(int i_renamed) {
        return this.o_renamed != null && 2 == i_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed) {
        this.n_renamed.a_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(int i_renamed) {
        if (1 == i_renamed) {
            this.n_renamed.b_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(int i_renamed) {
        this.n_renamed.c_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(long j_renamed) {
        this.n_renamed.a_renamed(j_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed) {
        this.n_renamed.a_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, com.oplus.camera.e_renamed.d_renamed.b_renamed bVar, int i2) {
        this.n_renamed.a_renamed(i_renamed, bVar, i2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(boolean z_renamed) {
        this.n_renamed.b_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean a_renamed() {
        return this.n_renamed.a_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean b_renamed() {
        return this.n_renamed.b_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int c_renamed() {
        return this.n_renamed.c_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, android.hardware.camera2.CameraDevice cameraDevice, boolean z2) {
        this.n_renamed.a_renamed(z_renamed, cameraDevice, z2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed() {
        this.n_renamed.d_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.camera.e_renamed.h_renamed e_renamed() {
        return this.n_renamed.e_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        this.n_renamed.a_renamed(hVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed() {
        this.n_renamed.f_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed() {
        this.n_renamed.g_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void h_renamed() {
        this.n_renamed.h_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.d_renamed.c_renamed cVar) {
        this.n_renamed.a_renamed(cVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) {
        this.n_renamed.a_renamed(i_renamed, cVar, aVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void i_renamed() {
        this.n_renamed.i_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) {
        this.n_renamed.a_renamed(z_renamed, cVar, aVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void a_renamed(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        this.n_renamed.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key<T_renamed>>) key, (android.hardware.camera2.CaptureRequest.Key<T_renamed>) t_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void a_renamed(com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed> previewKey, T_renamed t_renamed) {
        this.n_renamed.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>>) previewKey, (com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>) t_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void b_renamed(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        this.n_renamed.b_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key<T_renamed>>) key, (android.hardware.camera2.CaptureRequest.Key<T_renamed>) t_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str) {
        this.n_renamed.a_renamed(str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void k_renamed() {
        this.n_renamed.k_renamed();
    }

    public void C_renamed(int i_renamed) {
        if (B_renamed(i_renamed)) {
            this.n_renamed.h_renamed(this.o_renamed.e_renamed());
        } else {
            this.n_renamed.k_renamed();
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public android.os.Handler l_renamed() {
        return this.n_renamed.l_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void m_renamed() {
        this.n_renamed.m_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(float f_renamed, boolean z_renamed) {
        this.n_renamed.a_renamed(f_renamed, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr, android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr2, boolean z_renamed) {
        this.n_renamed.a_renamed(i_renamed, meteringRectangleArr, meteringRectangleArr2, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, android.graphics.RectF rectF, android.graphics.RectF rectF2, boolean z_renamed) {
        this.n_renamed.a_renamed(i_renamed, rectF, rectF2, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.i_renamed iVar) {
        this.n_renamed.a_renamed(iVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(com.oplus.camera.e_renamed.i_renamed iVar) {
        this.n_renamed.b_renamed(iVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void n_renamed() {
        this.n_renamed.n_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void o_renamed() {
        this.n_renamed.o_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed(int i_renamed) {
        this.n_renamed.d_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int p_renamed() {
        return this.n_renamed.p_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public java.lang.String q_renamed() {
        return this.n_renamed.q_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void u_renamed(boolean z_renamed) {
        this.n_renamed.u_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(java.lang.String str) {
        this.n_renamed.b_renamed(str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(boolean z_renamed) {
        this.n_renamed.c_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed(boolean z_renamed) {
        this.n_renamed.d_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void c_renamed(android.hardware.camera2.CaptureRequest.Key key, T_renamed t_renamed) {
        this.n_renamed.c_renamed(key, (android.hardware.camera2.CaptureRequest.Key) t_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int[] a_renamed(android.hardware.camera2.CaptureResult.Key<?> key, android.hardware.camera2.CaptureResult captureResult) {
        return this.n_renamed.a_renamed(key, captureResult);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void e_renamed(int i_renamed) {
        this.n_renamed.e_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, boolean z_renamed, boolean z2) {
        this.n_renamed.a_renamed(str, z_renamed, z2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed(int i_renamed) {
        this.n_renamed.f_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void e_renamed(boolean z_renamed) {
        this.n_renamed.e_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed(boolean z_renamed) {
        this.n_renamed.f_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed(boolean z_renamed) {
        this.n_renamed.g_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, java.lang.String str, int[] iArr) {
        this.n_renamed.a_renamed(z_renamed, str, iArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, int i_renamed, java.lang.String str) {
        this.n_renamed.a_renamed(z_renamed, i_renamed, str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void h_renamed(boolean z_renamed) {
        this.n_renamed.h_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, java.lang.String str, long j_renamed) {
        this.n_renamed.a_renamed(z_renamed, str, j_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, android.os.Bundle bundle) {
        this.n_renamed.a_renamed(z_renamed, bundle);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed(int i_renamed) {
        this.n_renamed.g_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void h_renamed(int i_renamed) {
        this.n_renamed.h_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, int i_renamed) {
        this.n_renamed.a_renamed(str, i_renamed);
    }

    public void a_renamed(int i_renamed, int i2) {
        if (B_renamed(i2)) {
            this.n_renamed.b_renamed(this.o_renamed.e_renamed(), i_renamed);
        } else {
            this.n_renamed.h_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int[] iArr) {
        this.n_renamed.a_renamed(iArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.d_renamed.e_renamed eVar) {
        this.n_renamed.a_renamed(eVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void i_renamed(boolean z_renamed) {
        this.n_renamed.i_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.n_renamed.a_renamed(i_renamed, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void i_renamed(int i_renamed) {
        this.n_renamed.i_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(int i_renamed, boolean z_renamed) {
        this.n_renamed.b_renamed(i_renamed, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(long j_renamed, boolean z_renamed) {
        this.n_renamed.a_renamed(j_renamed, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        this.n_renamed.a_renamed(z_renamed, z2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void r_renamed() {
        this.n_renamed.r_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void j_renamed(boolean z_renamed) {
        this.n_renamed.j_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void j_renamed(int i_renamed) {
        this.n_renamed.j_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(android.os.Bundle bundle) {
        this.n_renamed.a_renamed(bundle);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(byte b2) {
        this.n_renamed.a_renamed(b2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(byte b2) {
        this.n_renamed.b_renamed(b2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void k_renamed(boolean z_renamed) {
        this.n_renamed.k_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(java.lang.String str) {
        this.n_renamed.c_renamed(str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(boolean z_renamed, boolean z2) {
        this.n_renamed.b_renamed(z_renamed, z2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void l_renamed(boolean z_renamed) {
        this.n_renamed.l_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void m_renamed(boolean z_renamed) {
        this.n_renamed.m_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void k_renamed(int i_renamed) {
        this.n_renamed.k_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void l_renamed(int i_renamed) {
        this.n_renamed.l_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, int[] iArr) {
        this.n_renamed.a_renamed(str, iArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, boolean z_renamed) {
        this.n_renamed.a_renamed(str, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean j_renamed() {
        return this.n_renamed.j_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void m_renamed(int i_renamed) {
        this.n_renamed.m_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean d_renamed(java.lang.String str) {
        return this.n_renamed.d_renamed(str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void n_renamed(boolean z_renamed) {
        this.n_renamed.n_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void e_renamed(java.lang.String str) {
        this.n_renamed.e_renamed(str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void o_renamed(boolean z_renamed) {
        this.n_renamed.o_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void n_renamed(int i_renamed) {
        this.n_renamed.n_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(byte[] bArr) {
        this.n_renamed.a_renamed(bArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(float f_renamed) {
        this.n_renamed.a_renamed(f_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void o_renamed(int i_renamed) {
        this.n_renamed.o_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void p_renamed(int i_renamed) {
        this.n_renamed.p_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void q_renamed(int i_renamed) {
        this.n_renamed.q_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void r_renamed(int i_renamed) {
        this.n_renamed.r_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void s_renamed(int i_renamed) {
        this.n_renamed.s_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void t_renamed(int i_renamed) {
        this.n_renamed.t_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void p_renamed(boolean z_renamed) {
        this.n_renamed.p_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void q_renamed(boolean z_renamed) {
        this.n_renamed.q_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void u_renamed(int i_renamed) {
        this.n_renamed.u_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void v_renamed(int i_renamed) {
        this.n_renamed.v_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void r_renamed(boolean z_renamed) {
        this.n_renamed.r_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void s_renamed(boolean z_renamed) {
        this.n_renamed.s_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void t_renamed(boolean z_renamed) {
        this.n_renamed.t_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void s_renamed() {
        this.n_renamed.s_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(byte[] bArr) {
        this.n_renamed.b_renamed(bArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void v_renamed(boolean z_renamed) {
        this.n_renamed.v_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int t_renamed() {
        return this.n_renamed.t_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.camera.e_renamed.c_renamed v_renamed() {
        return this.n_renamed.v_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void w_renamed() {
        this.n_renamed.w_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, java.lang.String str) {
        this.n_renamed.a_renamed(z_renamed, str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(android.util.Range range) {
        this.n_renamed.a_renamed(range);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void w_renamed(int i_renamed) {
        this.n_renamed.w_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void x_renamed(boolean z_renamed) {
        this.n_renamed.x_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void x_renamed() {
        this.n_renamed.x_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void y_renamed(boolean z_renamed) {
        this.n_renamed.y_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(float f_renamed) {
        this.n_renamed.b_renamed(f_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void z_renamed(boolean z_renamed) {
        this.n_renamed.z_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.v_renamed.c_renamed cVar) {
        this.n_renamed.a_renamed(cVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed(java.lang.String str) {
        this.n_renamed.f_renamed(str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void A_renamed(boolean z_renamed) {
        this.n_renamed.A_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(int[] iArr) {
        this.n_renamed.b_renamed(iArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void x_renamed(int i_renamed) {
        this.n_renamed.x_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(long j_renamed) {
        this.n_renamed.b_renamed(j_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void y_renamed(int i_renamed) {
        this.n_renamed.y_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(long j_renamed) {
        this.n_renamed.c_renamed(j_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void B_renamed(boolean z_renamed) {
        this.n_renamed.B_renamed(z_renamed);
    }

    public boolean E_renamed() {
        return this.n_renamed.I_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void C_renamed(boolean z_renamed) {
        this.n_renamed.C_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void D_renamed(boolean z_renamed) {
        this.n_renamed.D_renamed(z_renamed);
    }

    public void F_renamed() {
        this.n_renamed.G_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void z_renamed(int i_renamed) {
        this.n_renamed.z_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed(java.lang.String str) {
        this.n_renamed.g_renamed(str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.ocs.camera.CameraDeviceInfo a_renamed(java.lang.String str, java.lang.String str2) {
        return this.n_renamed.a_renamed(str, str2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.ocs.camera.CameraDeviceConfig.Builder y_renamed() {
        return this.n_renamed.y_renamed();
    }

    public void a_renamed(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder, com.oplus.camera.e_renamed.d_renamed.OneCamera_5 interfaceC0097d, int i_renamed) {
        this.n_renamed.b_renamed(builder, interfaceC0097d, i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback) {
        this.n_renamed.a_renamed(cameraPictureCallback);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void E_renamed(boolean z_renamed) {
        this.n_renamed.E_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String[] strArr) {
        this.n_renamed.a_renamed(strArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(float f_renamed, float f2) {
        this.n_renamed.a_renamed(f_renamed, f2);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback, android.os.Handler handler) {
        this.n_renamed.a_renamed(cameraRecordingCallback, handler);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean u_renamed() {
        return this.n_renamed.u_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void w_renamed(boolean z_renamed) {
        this.n_renamed.w_renamed(z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void z_renamed() {
        this.n_renamed.z_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void A_renamed() {
        this.n_renamed.A_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void B_renamed() {
        this.n_renamed.B_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, android.hardware.camera2.CaptureResult captureResult, int i_renamed, int i2, int i3) {
        return this.n_renamed.a_renamed(bitmap, captureResult, i_renamed, i2, i3);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed(long j_renamed) {
        this.n_renamed.d_renamed(j_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void A_renamed(int i_renamed) {
        this.n_renamed.A_renamed(i_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void C_renamed() {
        this.n_renamed.C_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void F_renamed(boolean z_renamed) {
        this.n_renamed.F_renamed(z_renamed);
    }
}
