package com.oplus.camera.ui.menu.shareedit;

/* loaded from: classes2.dex */
public class ShareArrowImageView extends com.oplus.camera.ui.inverse.InverseImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6678a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.os.Handler f6679b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f6680c;
    private android.view.animation.PathInterpolator d_renamed;
    private android.view.animation.PathInterpolator e_renamed;
    private float f_renamed;
    private int g_renamed;

    public ShareArrowImageView(android.content.Context context) {
        super(context);
        this.f6678a = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.arrow_anim_height);
        this.f6679b = null;
        this.f6680c = 0L;
        this.d_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.e_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f_renamed = 0.0f;
        this.g_renamed = 0;
        a_renamed(context, null, 0);
    }

    public ShareArrowImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6678a = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.arrow_anim_height);
        this.f6679b = null;
        this.f6680c = 0L;
        this.d_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.e_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f_renamed = 0.0f;
        this.g_renamed = 0;
        a_renamed(context, attributeSet, 0);
    }

    public ShareArrowImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6678a = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.arrow_anim_height);
        this.f6679b = null;
        this.f6680c = 0L;
        this.d_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.e_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f_renamed = 0.0f;
        this.g_renamed = 0;
        a_renamed(context, attributeSet, i_renamed);
    }

    private void a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this.f6679b = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.menu.shareedit.ShareArrowImageView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 3 && com.oplus.camera.ui.menu.shareedit.ShareArrowImageView.this.getVisibility() == 0) {
                    com.oplus.camera.ui.menu.shareedit.ShareArrowImageView.this.a_renamed();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:48:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.shareedit.ShareArrowImageView.a_renamed():void");
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i_renamed) {
        int visibility = getVisibility();
        super.setVisibility(i_renamed);
        if ((visibility != i_renamed || b_renamed()) && i_renamed == 0) {
            this.g_renamed = 0;
            this.f_renamed = 0.0f;
            this.f6680c = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.f6679b.sendEmptyMessageDelayed(3, 33L);
        }
    }

    private boolean b_renamed() {
        return 0 != this.f6680c && android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.f6680c > 2851;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        android.graphics.Rect bounds = drawable.getBounds();
        int i_renamed = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        if (i_renamed == 0 || i2 == 0) {
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
        canvas.translate((-i_renamed) / 2, (-i2) / 2);
        canvas.translate(0.0f, this.g_renamed);
        drawable.setAlpha((int) (this.f_renamed * 255.0f));
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }
}
