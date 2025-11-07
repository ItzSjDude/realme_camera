package androidx.appcompat.widget;

/* compiled from: AppCompatTextClassifierHelper.java */
/* loaded from: classes.dex */
final class u_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.TextView f639a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.textclassifier.TextClassifier f640b;

    u_renamed(android.widget.TextView textView) {
        this.f639a = (android.widget.TextView) androidx.core.g_renamed.f_renamed.a_renamed(textView);
    }

    public void a_renamed(android.view.textclassifier.TextClassifier textClassifier) {
        this.f640b = textClassifier;
    }

    public android.view.textclassifier.TextClassifier a_renamed() {
        android.view.textclassifier.TextClassifier textClassifier = this.f640b;
        if (textClassifier != null) {
            return textClassifier;
        }
        android.view.textclassifier.TextClassificationManager textClassificationManager = (android.view.textclassifier.TextClassificationManager) this.f639a.getContext().getSystemService(android.view.textclassifier.TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return android.view.textclassifier.TextClassifier.NO_OP;
    }
}
