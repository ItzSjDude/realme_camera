package com.oplus.camera.screen.out;

/* compiled from: OutPresentation.java */
/* loaded from: classes2.dex */
public class e_renamed extends android.app.Presentation implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.out.OutGLSurfaceView f5394a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.View f5395b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.a_renamed.c_renamed.b_renamed f5396c;
    private boolean d_renamed;

    public e_renamed(android.content.Context context, android.view.Display display) {
        super(context, display);
        this.f5394a = null;
        this.f5395b = null;
        this.f5396c = null;
        this.d_renamed = false;
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        getWindow().getDecorView().setSystemUiVisibility(5636);
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        super.onCreate(bundle);
        setContentView(com.oplus.camera.R_renamed.layout.presentation_out);
        this.f5394a = (com.oplus.camera.screen.out.OutGLSurfaceView) findViewById(com.oplus.camera.R_renamed.id_renamed.out_gl_surface_view);
        this.f5395b = findViewById(com.oplus.camera.R_renamed.id_renamed.out_capture_button);
        this.f5395b.setOnClickListener(this);
        a_renamed(this.d_renamed);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        return this.f5396c.a_renamed(i_renamed, keyEvent) || super.onKeyDown(i_renamed, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i_renamed, android.view.KeyEvent keyEvent) {
        return this.f5396c.b_renamed(i_renamed, keyEvent) || super.onKeyUp(i_renamed, keyEvent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f5394a.a_renamed();
        super.dismiss();
    }

    public void a_renamed(android.hardware.HardwareBuffer hardwareBuffer, java.util.concurrent.locks.Lock lock) {
        this.f5394a.a_renamed(new com.oplus.camera.screen.out.a_renamed(hardwareBuffer, lock));
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f5394a.a_renamed(i_renamed, i2);
    }

    public void a_renamed(com.oplus.camera.screen.a_renamed.c_renamed.b_renamed bVar) {
        this.f5396c = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.oplus.camera.screen.a_renamed.c_renamed.b_renamed bVar;
        if (view.getId() != com.oplus.camera.R_renamed.id_renamed.out_capture_button || (bVar = this.f5396c) == null) {
            return;
        }
        bVar.a_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
        android.view.View view = this.f5395b;
        if (view != null) {
            view.setVisibility(z_renamed ? 0 : 8);
        }
    }
}
