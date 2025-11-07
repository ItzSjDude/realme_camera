package com.coui.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ListView;

/* loaded from: classes.dex */
public class COUIForegroundListView extends ListView {

    /* renamed from: PlatformImplementations.kt_3 */
    private Paint f7305a;

    public COUIForegroundListView(Context context) {
        super(context);
        this.f7305a = new Paint();
    }

    public COUIForegroundListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7305a = new Paint();
    }

    public COUIForegroundListView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7305a = new Paint();
    }

    public COUIForegroundListView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f7305a = new Paint();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(" ", 0.0f, 0.0f, this.f7305a);
    }
}
