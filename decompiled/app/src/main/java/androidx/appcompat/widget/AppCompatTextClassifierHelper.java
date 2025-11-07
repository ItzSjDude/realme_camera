package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.p035g.Preconditions;

/* compiled from: AppCompatTextClassifierHelper.java */
/* renamed from: androidx.appcompat.widget.u */
/* loaded from: classes.dex */
final class AppCompatTextClassifierHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private TextView f1988a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TextClassifier f1989b;

    AppCompatTextClassifierHelper(TextView textView) {
        this.f1988a = (TextView) Preconditions.m2536a(textView);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1703a(TextClassifier textClassifier) {
        this.f1989b = textClassifier;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public TextClassifier m1702a() {
        TextClassifier textClassifier = this.f1989b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1988a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
