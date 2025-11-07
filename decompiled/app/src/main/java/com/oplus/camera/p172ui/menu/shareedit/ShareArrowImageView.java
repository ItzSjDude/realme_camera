package com.oplus.camera.p172ui.menu.shareedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseImageView;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class ShareArrowImageView extends InverseImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20373a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Handler f20374b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f20375c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PathInterpolator f20376d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PathInterpolator f20377e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f20378f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20379g;

    public ShareArrowImageView(Context context) {
        super(context);
        this.f20373a = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.arrow_anim_height);
        this.f20374b = null;
        this.f20375c = 0L;
        this.f20376d = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f20377e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20378f = 0.0f;
        this.f20379g = 0;
        m21635a(context, null, 0);
    }

    public ShareArrowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20373a = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.arrow_anim_height);
        this.f20374b = null;
        this.f20375c = 0L;
        this.f20376d = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f20377e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20378f = 0.0f;
        this.f20379g = 0;
        m21635a(context, attributeSet, 0);
    }

    public ShareArrowImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20373a = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.arrow_anim_height);
        this.f20374b = null;
        this.f20375c = 0L;
        this.f20376d = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f20377e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20378f = 0.0f;
        this.f20379g = 0;
        m21635a(context, attributeSet, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21635a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this.f20374b = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.menu.shareedit.ShareArrowImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 3 && ShareArrowImageView.this.getVisibility() == 0) {
                    ShareArrowImageView.this.m21634a();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m21634a() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.shareedit.ShareArrowImageView.m21634a():void");
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        int visibility = getVisibility();
        super.setVisibility(OplusGLSurfaceView_13);
        if ((visibility != OplusGLSurfaceView_13 || m21637b()) && OplusGLSurfaceView_13 == 0) {
            this.f20379g = 0;
            this.f20378f = 0.0f;
            this.f20375c = AnimationUtils.currentAnimationTimeMillis();
            this.f20374b.sendEmptyMessageDelayed(3, 33L);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m21637b() {
        return 0 != this.f20375c && AnimationUtils.currentAnimationTimeMillis() - this.f20375c > 2851;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int OplusGLSurfaceView_13 = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        if (OplusGLSurfaceView_13 == 0 || i2 == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int saveCount = canvas.getSaveCount();
        canvas.translate(paddingLeft + (width / 2), paddingTop + (height / 2));
        canvas.translate((-OplusGLSurfaceView_13) / 2, (-i2) / 2);
        canvas.translate(0.0f, this.f20379g);
        drawable.setAlpha((int) (this.f20378f * 255.0f));
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }
}
