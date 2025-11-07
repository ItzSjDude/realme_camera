package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import coui.support.appcompat.R;

/* compiled from: COUIClickableSpan.java */
/* renamed from: com.coui.appcompat.widget.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class COUIClickableSpan extends ClickableSpan {

    /* renamed from: PlatformImplementations.kt_3 */
    PlatformImplementations.kt_3 f7949a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ColorStateList f7950b;

    /* compiled from: COUIClickableSpan.java */
    /* renamed from: com.coui.appcompat.widget.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7542a();
    }

    public COUIClickableSpan(Context context) {
        this.f7950b = context.getResources().getColorStateList(R.color.coui_clickable_text_color);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        PlatformImplementations.kt_3 aVar = this.f7949a;
        if (aVar != null) {
            aVar.mo7542a();
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f7950b.getColorForState(textPaint.drawableState, 0));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7541a(PlatformImplementations.kt_3 aVar) {
        this.f7949a = aVar;
    }
}
