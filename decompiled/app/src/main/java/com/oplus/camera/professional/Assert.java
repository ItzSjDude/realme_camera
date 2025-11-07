package com.oplus.camera.professional;

/* compiled from: AutoTextView.java */
/* loaded from: classes2.dex */
public class a_renamed extends android.widget.TextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f5105a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f5106b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5107c;

    public a_renamed(android.content.Context context) {
        this(context, null);
    }

    public a_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5107c = false;
        this.f5105a = context.getColor(com.oplus.camera.R_renamed.color.camera_white);
        this.f5106b = com.oplus.camera.util.Util.A_renamed(context);
        a_renamed();
        b_renamed();
    }

    private void a_renamed() {
        setText(com.oplus.camera.R_renamed.string.camera_manual_auto);
        setContentDescription(getContext().getResources().getString(com.oplus.camera.R_renamed.string.camera_description_professional_auto));
    }

    private void b_renamed() {
        final com.a_renamed.a_renamed.f_renamed fVarA = com.oplus.camera.professional.u_renamed.a_renamed();
        setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.professional.a_renamed.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.professional.a_renamed.this, fVarA, true);
                } else if (action == 1 || action == 3) {
                    com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.professional.a_renamed.this, fVarA, false);
                }
                return false;
            }
        });
    }

    public void setAuto(boolean z_renamed) {
        if (this.f5107c == z_renamed) {
            return;
        }
        this.f5107c = z_renamed;
        com.oplus.camera.professional.u_renamed.a_renamed(this, z_renamed ? this.f5105a : this.f5106b, z_renamed ? this.f5106b : this.f5105a, 250, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
    }
}
