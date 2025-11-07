package com.oplus.camera.professional;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;

/* compiled from: AutoTextView.java */
/* renamed from: com.oplus.camera.professional.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AutoTextView extends TextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f15388a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f15389b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f15390c;

    public AutoTextView(Context context) {
        this(context, null);
    }

    public AutoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15390c = false;
        this.f15388a = context.getColor(R.color.camera_white);
        this.f15389b = Util.m24164A(context);
        m15393a();
        m15394b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15393a() {
        setText(R.string.camera_manual_auto);
        setContentDescription(getContext().getResources().getString(R.string.camera_description_professional_auto));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15394b() {
        final Spring c1032fM15923a = ProfessionalAnimUtil.m15923a();
        setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.professional.PlatformImplementations.kt_3.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    ProfessionalAnimUtil.m15924a((View) AutoTextView.this, c1032fM15923a, true);
                } else if (action == 1 || action == 3) {
                    ProfessionalAnimUtil.m15924a((View) AutoTextView.this, c1032fM15923a, false);
                }
                return false;
            }
        });
    }

    public void setAuto(boolean z) {
        if (this.f15390c == z) {
            return;
        }
        this.f15390c = z;
        ProfessionalAnimUtil.m15928a(this, z ? this.f15388a : this.f15389b, z ? this.f15389b : this.f15388a, 250, (Interpolator) null, (Animator.AnimatorListener) null);
    }
}
