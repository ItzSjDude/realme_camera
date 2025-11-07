package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIForegroundListView extends android.widget.ListView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Paint f2727a;

    public COUIForegroundListView(android.content.Context context) {
        super(context);
        this.f2727a = new android.graphics.Paint();
    }

    public COUIForegroundListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2727a = new android.graphics.Paint();
    }

    public COUIForegroundListView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2727a = new android.graphics.Paint();
    }

    public COUIForegroundListView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f2727a = new android.graphics.Paint();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(" ", 0.0f, 0.0f, this.f2727a);
    }
}
