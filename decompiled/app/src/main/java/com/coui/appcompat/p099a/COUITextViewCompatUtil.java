package com.coui.appcompat.p099a;

import android.os.Build;
import android.widget.TextView;
import com.coui.appcompat.widget.COUITextPressRippleDrawable;
import coui.support.appcompat.R;

/* compiled from: COUITextViewCompatUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.s */
/* loaded from: classes.dex */
public class COUITextViewCompatUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f6348a = "s";

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6466a(TextView textView) {
        if (textView == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setBackground(new COUITextPressRippleDrawable(textView.getContext()));
        } else {
            textView.setBackground(textView.getContext().getDrawable(R.drawable.text_ripple_bg));
        }
    }
}
