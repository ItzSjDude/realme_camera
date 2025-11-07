package com.oplus.camera.e_renamed;

/* compiled from: OneCamera.java */
/* loaded from: classes2.dex */
public interface d_renamed extends com.oplus.camera.d_renamed {
    public static final byte[] g_renamed = {0};
    public static final byte[] h_renamed = {1};
    public static final byte[] i_renamed = {2};
    public static final byte[] j_renamed = {0};
    public static final byte[] k_renamed = {1};
    public static final byte[] l_renamed = {2};
    public static final byte[] m_renamed = {3};

    /* compiled from: OneCamera.java */
    public interface a_renamed {
        void checkIfLockAutoExposure();

        void onCaptureCanceled(com.oplus.camera.e_renamed.c_renamed cVar);

        void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar);

        void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar);

        void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult);

        void onCapturePrepared();

        void onCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar);

        void onCaptureSequenceCompleted();

        void onCaptureStarted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, long j_renamed, long j2);

        void onFirstCaptureFrameAdd();
    }

    /* compiled from: OneCamera.java */
    public interface b_renamed {
        void a_renamed(int i_renamed);

        void a_renamed(int i_renamed, int i2);

        void a_renamed(boolean z_renamed, int i_renamed);

        void b_renamed(int i_renamed);

        void c_renamed(int i_renamed);
    }

    /* compiled from: OneCamera.java */
    public interface c_renamed {
        void a_renamed(long j_renamed);

        void a_renamed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult);

        void a_renamed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult, int i_renamed);

        void a_renamed(android.hardware.camera2.CaptureResult captureResult);

        void a_renamed(android.hardware.camera2.CaptureResult captureResult, int i_renamed, java.lang.String str);

        void a_renamed(android.media.Image image);

        void a_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult);

        void a_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult);

        java.util.Map<java.lang.String, java.lang.Object> b_renamed(android.media.Image image);

        void b_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult);
    }

    /* compiled from: OneCamera.java */
    /* renamed from: com.oplus.camera.e_renamed.d_renamed$d_renamed, reason: collision with other inner class name */
    public interface OneCamera_5 {
        void a_renamed();

        void a_renamed(com.oplus.camera.e_renamed.c_renamed cVar, int i_renamed);

        void a_renamed(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder);

        void a_renamed(java.util.LinkedHashMap<java.lang.String, android.view.Surface> linkedHashMap, int i_renamed);

        boolean a_renamed(int i_renamed);

        void b_renamed(int i_renamed);
    }

    /* compiled from: OneCamera.java */
    public interface e_renamed {
        void a_renamed();

        void a_renamed(android.hardware.camera2.CaptureResult captureResult, com.oplus.camera.e_renamed.c_renamed cVar);

        void a_renamed(boolean z_renamed);

        void b_renamed();
    }

    void A_renamed();

    void A_renamed(int i2);

    void A_renamed(boolean z_renamed);

    void B_renamed();

    void B_renamed(boolean z_renamed);

    void C_renamed();

    void C_renamed(boolean z_renamed);

    void D_renamed(boolean z_renamed);

    void E_renamed(boolean z_renamed);

    void F_renamed(boolean z_renamed);

    android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, android.hardware.camera2.CaptureResult captureResult, int i2, int i3, int i4);

    com.oplus.ocs.camera.CameraDeviceInfo a_renamed(java.lang.String str, java.lang.String str2);

    void a_renamed(byte b2);

    void a_renamed(float f_renamed);

    void a_renamed(float f_renamed, float f2);

    void a_renamed(float f_renamed, boolean z_renamed);

    void a_renamed(int i2);

    void a_renamed(int i2, android.graphics.RectF rectF, android.graphics.RectF rectF2, boolean z_renamed);

    void a_renamed(int i2, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar);

    void a_renamed(int i2, com.oplus.camera.e_renamed.d_renamed.b_renamed bVar, int i3);

    void a_renamed(int i2, boolean z_renamed);

    void a_renamed(int i2, android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr, android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr2, boolean z_renamed);

    void a_renamed(long j2);

    void a_renamed(long j2, boolean z_renamed);

    <T_renamed> void a_renamed(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed);

    void a_renamed(android.os.Bundle bundle);

    void a_renamed(android.util.Range range);

    void a_renamed(com.oplus.camera.e_renamed.d_renamed.c_renamed cVar);

    void a_renamed(com.oplus.camera.e_renamed.d_renamed.e_renamed eVar);

    void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar);

    void a_renamed(com.oplus.camera.e_renamed.i_renamed iVar);

    void a_renamed(com.oplus.camera.v_renamed.c_renamed cVar);

    <T_renamed> void a_renamed(com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed> previewKey, T_renamed t_renamed);

    void a_renamed(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback);

    void a_renamed(com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback, android.os.Handler handler);

    void a_renamed(java.lang.String str);

    void a_renamed(java.lang.String str, int i2);

    void a_renamed(java.lang.String str, boolean z_renamed);

    void a_renamed(java.lang.String str, boolean z_renamed, boolean z2);

    void a_renamed(java.lang.String str, int[] iArr);

    void a_renamed(boolean z_renamed);

    void a_renamed(boolean z_renamed, int i2, java.lang.String str);

    void a_renamed(boolean z_renamed, android.hardware.camera2.CameraDevice cameraDevice, boolean z2);

    void a_renamed(boolean z_renamed, android.os.Bundle bundle);

    void a_renamed(boolean z_renamed, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar);

    void a_renamed(boolean z_renamed, java.lang.String str);

    void a_renamed(boolean z_renamed, java.lang.String str, long j2);

    void a_renamed(boolean z_renamed, java.lang.String str, int[] iArr);

    void a_renamed(boolean z_renamed, boolean z2);

    void a_renamed(byte[] bArr);

    void a_renamed(int[] iArr);

    void a_renamed(java.lang.String[] strArr);

    boolean a_renamed();

    int[] a_renamed(android.hardware.camera2.CaptureResult.Key<?> key, android.hardware.camera2.CaptureResult captureResult);

    void b_renamed(byte b2);

    void b_renamed(float f_renamed);

    void b_renamed(int i2);

    void b_renamed(int i2, boolean z_renamed);

    void b_renamed(long j2);

    <T_renamed> void b_renamed(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed);

    void b_renamed(com.oplus.camera.e_renamed.i_renamed iVar);

    void b_renamed(java.lang.String str);

    void b_renamed(boolean z_renamed);

    void b_renamed(boolean z_renamed, boolean z2);

    void b_renamed(byte[] bArr);

    void b_renamed(int[] iArr);

    boolean b_renamed();

    int c_renamed();

    void c_renamed(int i2);

    void c_renamed(long j2);

    <T_renamed> void c_renamed(android.hardware.camera2.CaptureRequest.Key key, T_renamed t_renamed);

    void c_renamed(java.lang.String str);

    void c_renamed(boolean z_renamed);

    void d_renamed();

    void d_renamed(int i2);

    void d_renamed(long j2);

    void d_renamed(boolean z_renamed);

    boolean d_renamed(java.lang.String str);

    com.oplus.camera.e_renamed.h_renamed e_renamed();

    void e_renamed(int i2);

    void e_renamed(java.lang.String str);

    void e_renamed(boolean z_renamed);

    void f_renamed();

    void f_renamed(int i2);

    void f_renamed(java.lang.String str);

    void f_renamed(boolean z_renamed);

    void g_renamed();

    void g_renamed(int i2);

    void g_renamed(java.lang.String str);

    void g_renamed(boolean z_renamed);

    void h_renamed();

    void h_renamed(int i2);

    void h_renamed(boolean z_renamed);

    void i_renamed();

    void i_renamed(int i2);

    void i_renamed(boolean z_renamed);

    void j_renamed(int i2);

    void j_renamed(boolean z_renamed);

    boolean j_renamed();

    void k_renamed();

    void k_renamed(int i2);

    void k_renamed(boolean z_renamed);

    android.os.Handler l_renamed();

    void l_renamed(int i2);

    void l_renamed(boolean z_renamed);

    void m_renamed();

    void m_renamed(int i2);

    void m_renamed(boolean z_renamed);

    void n_renamed();

    void n_renamed(int i2);

    void n_renamed(boolean z_renamed);

    void o_renamed();

    void o_renamed(int i2);

    void o_renamed(boolean z_renamed);

    int p_renamed();

    void p_renamed(int i2);

    void p_renamed(boolean z_renamed);

    java.lang.String q_renamed();

    void q_renamed(int i2);

    void q_renamed(boolean z_renamed);

    void r_renamed();

    void r_renamed(int i2);

    void r_renamed(boolean z_renamed);

    void s_renamed();

    void s_renamed(int i2);

    void s_renamed(boolean z_renamed);

    int t_renamed();

    void t_renamed(int i2);

    void t_renamed(boolean z_renamed);

    void u_renamed(int i2);

    void u_renamed(boolean z_renamed);

    boolean u_renamed();

    com.oplus.camera.e_renamed.c_renamed v_renamed();

    void v_renamed(int i2);

    void v_renamed(boolean z_renamed);

    void w_renamed();

    void w_renamed(int i2);

    void w_renamed(boolean z_renamed);

    void x_renamed();

    void x_renamed(int i2);

    void x_renamed(boolean z_renamed);

    com.oplus.ocs.camera.CameraDeviceConfig.Builder y_renamed();

    void y_renamed(int i2);

    void y_renamed(boolean z_renamed);

    void z_renamed();

    void z_renamed(int i2);

    void z_renamed(boolean z_renamed);
}
