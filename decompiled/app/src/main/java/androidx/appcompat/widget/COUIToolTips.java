package androidx.appcompat.widget;

/* compiled from: AppCompatSeekBar.java */
/* loaded from: classes.dex */
public class s_renamed extends android.widget.SeekBar {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.appcompat.widget.t_renamed f635a;

    public s_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.seekBarStyle);
    }

    public s_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super(context, attributeSet, i_renamed);
        this.f635a = new androidx.appcompat.widget.t_renamed(this);
        this.f635a.a_renamed(attributeSet, i_renamed);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.f635a.a_renamed(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f635a.c_renamed();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f635a.b_renamed();
    }
}
