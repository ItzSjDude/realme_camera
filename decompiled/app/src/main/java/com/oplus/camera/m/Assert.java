package com.oplus.camera.m_renamed;

/* compiled from: CallGalleryPreDecodeThread.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.camera.m_renamed.d_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static com.oplus.camera.m_renamed.a_renamed f4871c;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.n_renamed f4872b = null;

    public static com.oplus.camera.m_renamed.a_renamed a_renamed() {
        com.oplus.camera.m_renamed.a_renamed aVar;
        synchronized (com.oplus.camera.m_renamed.a_renamed.class) {
            if (f4871c == null) {
                f4871c = new com.oplus.camera.m_renamed.a_renamed();
            }
            aVar = f4871c;
        }
        return aVar;
    }

    public void a_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        d_renamed();
        if (cameraPicture == null || !cameraPicture.C_renamed) {
            return;
        }
        c_renamed(cameraPicture);
    }

    @Override // com.oplus.camera.m_renamed.d_renamed
    protected void b_renamed() {
        synchronized (this) {
            if (this.f4872b == null) {
                this.f4872b = new com.oplus.camera.n_renamed();
                this.f4872b.a_renamed(com.oplus.camera.util.Util.l_renamed());
            }
        }
    }

    @Override // com.oplus.camera.m_renamed.d_renamed
    protected void b_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) throws java.lang.Exception {
        com.oplus.camera.e_renamed.a_renamed("CallGalleryPreDecodeThread", "handlePicture, callGallery");
        com.oplus.camera.n_renamed nVar = this.f4872b;
        if (nVar != null) {
            nVar.a_renamed(com.oplus.camera.util.Util.l_renamed(), cameraPicture.f4068c, cameraPicture.mPath, cameraPicture.l_renamed, cameraPicture.B_renamed);
        }
    }

    public void c_renamed() {
        if (this.f4883a != null) {
            this.f4883a.submit(new java.lang.Runnable() { // from class: com.oplus.camera.m_renamed.a_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (com.oplus.camera.m_renamed.a_renamed.this) {
                        if (com.oplus.camera.m_renamed.a_renamed.this.f4872b != null) {
                            com.oplus.camera.m_renamed.a_renamed.this.f4872b.b_renamed(com.oplus.camera.util.Util.l_renamed());
                            com.oplus.camera.m_renamed.a_renamed.this.f4872b = null;
                        }
                    }
                }
            });
        }
    }
}
