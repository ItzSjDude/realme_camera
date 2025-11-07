package com.oplus.camera.p172ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.dynamicanimation.p043a.DynamicAnimation;
import androidx.dynamicanimation.p043a.FloatValueHolder;
import androidx.dynamicanimation.p043a.SpringAnimation;
import androidx.dynamicanimation.p043a.SpringForce;
import com.coui.appcompat.dialog.app.COUIRotatingSpinnerDialog;
import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsMultiThumbnailSequenceView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.p172ui.RotateImageView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* compiled from: VideoClipView.java */
/* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class VideoClipView extends ViewGroup implements View.OnClickListener, NvsMultiThumbnailSequenceView.OnScrollChangeListener {

    /* renamed from: A */
    private IntrinsicsJvm.kt_4 f22805A;

    /* renamed from: B */
    private RectF f22806B;

    /* renamed from: C */
    private RectF f22807C;

    /* renamed from: D */
    private RectF f22808D;

    /* renamed from: E */
    private RectF f22809E;

    /* renamed from: F */
    private RectF f22810F;

    /* renamed from: G */
    private RectF f22811G;

    /* renamed from: H */
    private RectF f22812H;

    /* renamed from: I */
    private NinePatch f22813I;

    /* renamed from: J */
    private DecimalFormat f22814J;

    /* renamed from: K */
    private float f22815K;

    /* renamed from: L */
    private float f22816L;

    /* renamed from: M */
    private float f22817M;

    /* renamed from: N */
    private Bitmap f22818N;

    /* renamed from: O */
    private boolean f22819O;

    /* renamed from: P */
    private boolean f22820P;

    /* renamed from: Q */
    private boolean f22821Q;

    /* renamed from: R */
    private float f22822R;

    /* renamed from: S */
    private float f22823S;

    /* renamed from: T */
    private int f22824T;

    /* renamed from: U */
    private boolean f22825U;

    /* renamed from: V */
    private boolean f22826V;

    /* renamed from: W */
    private RectF f22827W;

    /* renamed from: PlatformImplementations.kt_3 */
    private NvsLiveWindow f22828a;

    /* renamed from: aa */
    private boolean f22829aa;

    /* renamed from: ab */
    private boolean f22830ab;

    /* renamed from: ac */
    private Paint f22831ac;

    /* renamed from: ad */
    private Paint f22832ad;

    /* renamed from: ae */
    private int f22833ae;

    /* renamed from: af */
    private boolean f22834af;

    /* renamed from: ag */
    private Handler f22835ag;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private NvsMultiThumbnailSequenceView f22836b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RotateImageView f22837c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RotateImageView f22838d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private COUIRotatingSpinnerDialog f22839e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f22840f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22841g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22842h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22843i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22844j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22845k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22846l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f22847m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22848n;

    /* renamed from: o */
    private float f22849o;

    /* renamed from: p */
    private float f22850p;

    /* renamed from: q */
    private float f22851q;

    /* renamed from: r */
    private float f22852r;

    /* renamed from: s */
    private float f22853s;

    /* renamed from: t */
    private float f22854t;

    /* renamed from: u */
    private float f22855u;

    /* renamed from: v */
    private float f22856v;

    /* renamed from: w */
    private float f22857w;

    /* renamed from: x */
    private float f22858x;

    /* renamed from: y */
    private float f22859y;

    /* renamed from: z */
    private PlatformImplementations.kt_3 f22860z;

    /* compiled from: VideoClipView.java */
    /* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo12937c(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo12939d(float COUIBaseListPopupWindow_12);

        /* renamed from: OplusGLSurfaceView_5 */
        void mo12946k();
    }

    /* compiled from: VideoClipView.java */
    /* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo19648a(float COUIBaseListPopupWindow_12, float f2);

        /* renamed from: eB */
        void mo19914eB();
    }

    public VideoClipView(Context context) {
        super(context);
        this.f22828a = null;
        this.f22836b = null;
        this.f22837c = null;
        this.f22838d = null;
        this.f22839e = null;
        this.f22840f = 0;
        this.f22841g = 0;
        this.f22842h = 0;
        this.f22843i = 0;
        this.f22844j = 0;
        this.f22845k = VideoMode.VIDEO_1080P_WIDTH;
        this.f22846l = VideoMode.VIDEO_1080P_HEIGHT;
        this.f22847m = 0;
        this.f22848n = 0;
        this.f22849o = 1.7777778f;
        this.f22850p = 0.0f;
        this.f22851q = 0.0f;
        this.f22852r = 0.0f;
        this.f22853s = 15.0f;
        this.f22854t = 1.0f;
        this.f22855u = 0.0f;
        this.f22856v = 0.0f;
        this.f22857w = 1.0f;
        this.f22858x = 0.0f;
        this.f22859y = 0.0f;
        this.f22860z = null;
        this.f22805A = null;
        this.f22806B = new RectF();
        this.f22807C = new RectF();
        this.f22808D = new RectF();
        this.f22809E = new RectF();
        this.f22810F = new RectF();
        this.f22811G = new RectF();
        this.f22812H = new RectF();
        this.f22814J = new DecimalFormat("00");
        this.f22815K = 0.0f;
        this.f22816L = 0.0f;
        this.f22817M = 0.0f;
        this.f22818N = null;
        this.f22819O = false;
        this.f22820P = false;
        this.f22821Q = false;
        this.f22822R = 0.0f;
        this.f22823S = 0.0f;
        this.f22824T = 0;
        this.f22825U = false;
        this.f22826V = false;
        this.f22827W = new RectF();
        this.f22829aa = false;
        this.f22830ab = false;
        this.f22831ac = new Paint();
        this.f22832ad = new Paint();
        this.f22833ae = 0;
        this.f22834af = false;
        this.f22835ag = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_8.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (1 == message.what) {
                    if (VideoClipView.this.f22860z == null || !VideoClipView.this.f22821Q) {
                        return;
                    }
                    VideoClipView.this.f22821Q = false;
                    VideoClipView.this.f22860z.mo12939d(-1.0f);
                    return;
                }
                if (2 == message.what) {
                    VideoClipView.this.f22836b.updateThumbnails();
                    if (((ViewGroup) VideoClipView.this.f22836b.getChildAt(0)).getChildCount() == 0) {
                        VideoClipView.this.f22835ag.sendEmptyMessageDelayed(2, 100L);
                    }
                }
            }
        };
        m24123f();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m24123f() {
        this.f22831ac.setAntiAlias(true);
        this.f22831ac.setTextSize(getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_time_text_size));
        this.f22831ac.setColor(-1);
        this.f22831ac.setShadowLayer(getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_y), getResources().getColor(R.color.num_seekbar_thumb_text_shadow_color, null));
        this.f22832ad.setAntiAlias(true);
        this.f22832ad.setColor(-16777216);
        this.f22833ae = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_time_margin_bottom);
        this.f22820P = true;
        this.f22818N = BitmapFactory.decodeResource(getResources(), R.drawable.time_line);
        this.f22828a = new NvsLiveWindow(getContext());
        addView(this.f22828a, new ViewGroup.MarginLayoutParams(-2, -2));
        this.f22840f = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_height);
        this.f22841g = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_margin_bottom);
        this.f22842h = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_margin_left);
        this.f22843i = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_move_boundary);
        this.f22844j = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_offset);
        this.f22836b = new NvsMultiThumbnailSequenceView(getContext());
        addView(this.f22836b, new ViewGroup.MarginLayoutParams(-1, this.f22840f));
        this.f22836b.setOnScrollChangeListenser(this);
        this.f22836b.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_8.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (1 != motionEvent.getAction() || 15.0f >= VideoClipView.this.f22850p) {
                    return false;
                }
                VideoClipView.this.f22821Q = true;
                VideoClipView.this.f22835ag.removeMessages(1);
                VideoClipView.this.f22835ag.sendEmptyMessageDelayed(1, 50L);
                return false;
            }
        });
        this.f22837c = new RotateImageView(getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_back_margin_left);
        this.f22837c.setImageResource(R.drawable.btn_revert_pics_drawable);
        addView(this.f22837c, marginLayoutParams);
        this.f22837c.setOnClickListener(this);
        this.f22838d = new RotateImageView(getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_next_margin_bottom);
        this.f22838d.setImageResource(R.drawable.ic_next_step);
        addView(this.f22838d, marginLayoutParams2);
        this.f22838d.setOnClickListener(this);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.video_editor_trim_normal);
        this.f22813I = new NinePatch(bitmapDecodeResource, bitmapDecodeResource.getNinePatchChunk(), null);
        this.f22848n = getContext().getResources().getDisplayMetrics().widthPixels;
        this.f22847m = (int) (this.f22848n * this.f22849o);
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i3 - OplusGLSurfaceView_13;
        int i10 = i4 - i2;
        int i11 = i10 - ((i10 - this.f22847m) / 2);
        boolean z2 = 1 == getLayoutDirection();
        int i12 = this.f22845k;
        int i13 = this.f22846l;
        if (i12 > i13) {
            int i14 = this.f22847m;
            i6 = (i10 - i14) / 2;
            i7 = (i13 * i14) / i12;
            i8 = (i9 - i7) / 2;
            i5 = i14;
        } else {
            int i15 = this.f22848n;
            i5 = (i12 * i15) / i13;
            i6 = (i10 - i5) / 2;
            i7 = i15;
            i8 = OplusGLSurfaceView_13;
        }
        int i16 = this.f22847m;
        if (i5 > i16) {
            i5 = i16;
        }
        int i17 = this.f22848n;
        if (i7 > i17) {
            i7 = i17;
        }
        this.f22828a.layout(i8, i6, i7 + i8, i5 + i6);
        int i18 = 15.0f < this.f22850p ? OplusGLSurfaceView_13 : this.f22842h + this.f22844j;
        int i19 = 15.0f < this.f22850p ? i3 : (i3 - this.f22842h) - this.f22844j;
        int i20 = this.f22841g + ((i10 - this.f22847m) / 2);
        this.f22836b.layout(i18, (i4 - this.f22840f) - i20, i19, i4 - i20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22838d.getLayoutParams();
        int intrinsicWidth = this.f22838d.getDrawable().getIntrinsicWidth();
        int intrinsicWidth2 = this.f22838d.getDrawable().getIntrinsicWidth();
        int i21 = (i9 - intrinsicWidth) / 2;
        int i22 = (i11 - intrinsicWidth2) - marginLayoutParams.bottomMargin;
        this.f22838d.layout(i21, i22, intrinsicWidth + i21, i22 + intrinsicWidth2);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f22837c.getLayoutParams();
        int intrinsicWidth3 = this.f22837c.getDrawable().getIntrinsicWidth();
        int intrinsicWidth4 = this.f22837c.getDrawable().getIntrinsicWidth();
        int i23 = i22 + ((intrinsicWidth2 - intrinsicWidth4) / 2);
        int i24 = z2 ? (i9 - marginLayoutParams2.leftMargin) - intrinsicWidth3 : marginLayoutParams2.leftMargin;
        this.f22837c.layout(i24, i23, intrinsicWidth3 + i24, intrinsicWidth4 + i23);
        Rect rect = new Rect();
        this.f22836b.getHitRect(rect);
        if (!rect.contains((int) this.f22822R, (int) this.f22823S) && !this.f22819O && this.f22820P) {
            this.f22820P = false;
            this.f22806B.set(OplusGLSurfaceView_13, this.f22836b.getTop(), i3, this.f22836b.getBottom());
            this.f22811G.set(this.f22806B);
            RectF rectF = this.f22811G;
            int i25 = this.f22842h;
            rectF.left = OplusGLSurfaceView_13 + i25;
            rectF.right = i3 - i25;
            this.f22812H.set(rectF);
            this.f22809E.set(this.f22811G);
            RectF rectF2 = this.f22809E;
            rectF2.right = rectF2.left + this.f22844j;
            this.f22810F.set(this.f22811G);
            RectF rectF3 = this.f22810F;
            rectF3.left = rectF3.right - this.f22844j;
            this.f22806B.left = this.f22809E.right;
            this.f22806B.right = this.f22810F.left;
            this.f22808D.set(this.f22806B);
            this.f22827W.setEmpty();
            float COUIBaseListPopupWindow_12 = this.f22850p;
            if (15.0f < COUIBaseListPopupWindow_12) {
                this.f22852r = (COUIBaseListPopupWindow_12 / this.f22853s) * this.f22808D.width();
                this.f22836b.setPixelPerMicrosecond(this.f22852r / this.f22851q);
                this.f22836b.setStartPadding((int) (this.f22808D.left - getLeft()));
                this.f22836b.setEndPadding((int) (getRight() - this.f22808D.right));
                this.f22852r += this.f22836b.getStartPadding();
                this.f22852r += this.f22836b.getEndPadding();
                float scrollX = this.f22836b.getScrollX() + (this.f22806B.left - this.f22808D.left);
                this.f22856v = scrollX / ((this.f22852r - this.f22836b.getStartPadding()) - this.f22836b.getEndPadding());
                this.f22857w = (scrollX + this.f22806B.width()) / ((this.f22852r - this.f22836b.getStartPadding()) - this.f22836b.getEndPadding());
            } else {
                this.f22852r = this.f22836b.getWidth();
                this.f22836b.setPixelPerMicrosecond((r11.getWidth() * 1.0f) / this.f22851q);
                this.f22836b.setStartPadding(0);
                this.f22836b.setEndPadding(0);
                this.f22856v = 0.0f;
                this.f22857w = 1.0f;
            }
            this.f22859y = this.f22856v;
            setCurrentTime(getSelectTimeRatio() * this.f22853s);
            this.f22836b.updateThumbnails();
            this.f22836b.stopNestedScroll();
            this.f22836b.scrollTo(0, 0);
            this.f22836b.scrollBy(0, 0);
            this.f22836b.smoothScrollBy(0, 0);
            this.f22836b.smoothScrollTo(0, 0);
        }
        m24125g();
        if (((ViewGroup) this.f22836b.getChildAt(0)).getChildCount() == 0 && this.f22826V) {
            this.f22826V = false;
            this.f22835ag.removeMessages(2);
            this.f22835ag.sendEmptyMessage(2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.color_black_with_full_percent_transparency, null));
        super.dispatchDraw(canvas);
        String str = "00:" + this.f22814J.format(this.f22855u);
        canvas.drawText(str, (getWidth() - this.f22831ac.measureText(str)) / 2.0f, this.f22836b.getTop() - this.f22833ae, this.f22831ac);
        this.f22832ad.setAlpha(127);
        float scrollX = this.f22808D.left - this.f22836b.getScrollX();
        if (scrollX < getLeft()) {
            scrollX = getLeft();
        }
        canvas.drawRect(scrollX, this.f22808D.top, this.f22806B.left, this.f22808D.bottom, this.f22832ad);
        float scrollX2 = this.f22808D.right + ((this.f22852r - this.f22836b.getScrollX()) - this.f22836b.getWidth());
        if (scrollX2 > getRight()) {
            scrollX2 = getRight();
        }
        canvas.drawRect(this.f22806B.right, this.f22808D.top, scrollX2, this.f22808D.bottom, this.f22832ad);
        if (!this.f22827W.isEmpty() && (this.f22829aa || this.f22827W.right > this.f22812H.right || this.f22827W.left < this.f22812H.left)) {
            this.f22813I.draw(canvas, this.f22827W);
        } else {
            this.f22813I.draw(canvas, this.f22811G);
        }
        if (this.f22809E.contains(this.f22815K, this.f22816L) || this.f22810F.contains(this.f22815K, this.f22816L)) {
            return;
        }
        float fWidth = this.f22806B.left + (this.f22806B.width() * this.f22858x);
        float width = this.f22818N.getWidth() + fWidth;
        float height = this.f22806B.top - ((this.f22818N.getHeight() - this.f22806B.height()) / 2.0f);
        float COUIBaseListPopupWindow_12 = this.f22806B.right;
        if (width > COUIBaseListPopupWindow_12) {
            fWidth = COUIBaseListPopupWindow_12 - this.f22818N.getWidth();
        }
        this.f22832ad.setAlpha(255);
        canvas.drawBitmap(this.f22818N, fWidth, height, this.f22832ad);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f22822R = (int) motionEvent.getX();
            this.f22823S = (int) motionEvent.getY();
            this.f22819O = true;
        } else if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            this.f22822R = 0.0f;
            this.f22823S = 0.0f;
            this.f22819O = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f22809E.contains(this.f22822R, this.f22823S) || this.f22810F.contains(this.f22822R, this.f22823S) || this.f22807C.contains(this.f22822R, this.f22823S)) {
            this.f22830ab = 1 != motionEvent.getAction();
            return true;
        }
        if (motionEvent.getAction() == 0) {
            RectF rectF = new RectF(this.f22811G.right, this.f22811G.top, this.f22811G.right + this.f22844j, this.f22811G.bottom);
            RectF rectF2 = new RectF(this.f22811G.right - (this.f22844j * 2), this.f22811G.top, this.f22811G.right - this.f22844j, this.f22811G.bottom);
            RectF rectF3 = new RectF(this.f22811G.left - this.f22844j, this.f22811G.top, this.f22811G.left, this.f22811G.bottom);
            RectF rectF4 = new RectF(this.f22811G.left + this.f22844j, this.f22811G.top, this.f22811G.left + (this.f22844j * 2), this.f22811G.bottom);
            float fWidth = this.f22806B.left + (this.f22806B.width() * this.f22858x);
            float width = this.f22818N.getWidth() + fWidth;
            float height = this.f22806B.top - ((this.f22818N.getHeight() - this.f22806B.height()) / 2.0f);
            float COUIBaseListPopupWindow_12 = this.f22806B.right;
            if (width > COUIBaseListPopupWindow_12) {
                fWidth = COUIBaseListPopupWindow_12 - this.f22818N.getWidth();
            }
            this.f22807C.set(fWidth, height, this.f22818N.getWidth() + fWidth, this.f22818N.getHeight() + height);
            this.f22807C.left -= this.f22818N.getWidth();
            this.f22807C.right += this.f22818N.getWidth();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f22830ab = rectF3.contains(x, y) || rectF2.contains(x, y) || rectF.contains(x, y) || rectF4.contains(x, y) || this.f22807C.contains(x, y);
        } else if (this.f22830ab) {
            this.f22830ab = 1 != motionEvent.getAction();
            return true;
        }
        return this.f22830ab;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && !this.f22825U) {
            if (motionEvent.getAction() == 0) {
                this.f22815K = (int) motionEvent.getX();
                this.f22816L = (int) motionEvent.getY();
                this.f22817M = motionEvent.getX();
                if (this.f22860z != null && this.f22807C.contains(this.f22815K, this.f22816L)) {
                    this.f22834af = true;
                    this.f22860z.mo12937c(this.f22859y);
                } else {
                    RectF rectF = new RectF(this.f22811G.right, this.f22811G.top, this.f22811G.right + this.f22844j, this.f22811G.bottom);
                    RectF rectF2 = new RectF(this.f22811G.right - (this.f22844j * 2), this.f22811G.top, this.f22811G.right - this.f22844j, this.f22811G.bottom);
                    RectF rectF3 = new RectF(this.f22811G.left - this.f22844j, this.f22811G.top, this.f22811G.left, this.f22811G.bottom);
                    RectF rectF4 = new RectF(this.f22811G.left + this.f22844j, this.f22811G.top, this.f22811G.left + (this.f22844j * 2), this.f22811G.bottom);
                    if (this.f22808D.contains(this.f22815K, this.f22816L) && (rectF3.contains(this.f22815K, this.f22816L) || rectF4.contains(this.f22815K, this.f22816L))) {
                        RectF rectF5 = this.f22811G;
                        rectF5.left = this.f22815K - (this.f22844j / 2.0f);
                        this.f22809E.set(rectF5);
                        RectF rectF6 = this.f22809E;
                        rectF6.right = rectF6.left + this.f22844j;
                    } else if (this.f22808D.contains(this.f22815K, this.f22816L) && (rectF.contains(this.f22815K, this.f22816L) || rectF2.contains(this.f22815K, this.f22816L))) {
                        RectF rectF7 = this.f22811G;
                        rectF7.right = this.f22815K + (this.f22844j / 2.0f);
                        this.f22810F.set(rectF7);
                        RectF rectF8 = this.f22810F;
                        rectF8.left = rectF8.right - this.f22844j;
                    }
                    this.f22827W.set(this.f22811G);
                }
            }
            if (!m24113a(this.f22815K, this.f22816L) && !this.f22834af) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                float fWidth = ((this.f22854t / 15.0f) * this.f22808D.width()) + (this.f22844j * 2);
                if (this.f22860z != null && (15.0f < this.f22850p || m24113a(this.f22815K, this.f22816L) || this.f22834af)) {
                    this.f22860z.mo12939d(this.f22834af ? this.f22859y : -1.0f);
                }
                if (this.f22811G.left <= this.f22812H.left && this.f22811G.width() <= fWidth) {
                    this.f22811G.left = this.f22812H.left;
                    RectF rectF9 = this.f22811G;
                    rectF9.right = rectF9.left + fWidth;
                }
                if (this.f22827W.left <= this.f22812H.left && this.f22827W.width() <= fWidth) {
                    this.f22827W.set(this.f22811G);
                }
                if (this.f22811G.right >= this.f22812H.right && this.f22811G.width() <= fWidth) {
                    this.f22811G.right = this.f22812H.right;
                    RectF rectF10 = this.f22811G;
                    rectF10.left = rectF10.right - fWidth;
                }
                if (this.f22827W.right >= this.f22812H.right && this.f22827W.width() <= fWidth) {
                    this.f22827W.set(this.f22811G);
                }
                this.f22806B.left = this.f22811G.left + this.f22844j;
                this.f22806B.right = this.f22811G.right - this.f22844j;
                this.f22809E.set(this.f22811G);
                RectF rectF11 = this.f22809E;
                rectF11.right = rectF11.left + this.f22844j;
                this.f22810F.set(this.f22811G);
                RectF rectF12 = this.f22810F;
                rectF12.left = rectF12.right - this.f22844j;
                this.f22815K = 0.0f;
                this.f22816L = 0.0f;
                this.f22822R = 0.0f;
                this.f22823S = 0.0f;
                this.f22834af = false;
                setCurrentTime(getSelectTimeRatio() * this.f22853s);
                if (this.f22827W.right > this.f22812H.right) {
                    m24115b(false);
                }
                if (this.f22827W.left < this.f22812H.left) {
                    m24115b(true);
                }
                PlatformImplementations.kt_3 aVar = this.f22860z;
                if (aVar != null && 15.0f <= this.f22855u) {
                    aVar.mo12946k();
                }
            } else if (action == 2) {
                if (!this.f22834af && (this.f22809E.contains(this.f22815K, this.f22816L) || this.f22810F.contains(this.f22815K, this.f22816L))) {
                    m24112a(motionEvent);
                } else if (this.f22834af && (this.f22806B.contains(this.f22807C.left, this.f22807C.centerY()) || (this.f22806B.left < motionEvent.getX() && this.f22806B.right > motionEvent.getX()))) {
                    this.f22858x = ((motionEvent.getX() < this.f22806B.left ? this.f22806B.left : motionEvent.getX()) - this.f22806B.left) / this.f22806B.width();
                    float COUIBaseListPopupWindow_12 = this.f22856v;
                    this.f22859y = COUIBaseListPopupWindow_12 + (this.f22858x * (this.f22857w - COUIBaseListPopupWindow_12));
                    m24125g();
                    this.f22860z.mo12937c(this.f22859y);
                }
            }
            invalidate();
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24112a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float COUIBaseListPopupWindow_12 = x - this.f22817M;
        boolean z = 0.0f <= COUIBaseListPopupWindow_12;
        boolean zContains = this.f22809E.contains(this.f22815K, this.f22816L);
        boolean zContains2 = this.f22810F.contains(this.f22815K, this.f22816L);
        float fWidth = ((this.f22854t / 15.0f) * this.f22808D.width()) + (this.f22844j * 2);
        if (zContains) {
            float left = getLeft() + this.f22843i;
            if (this.f22827W.left > this.f22812H.left) {
                this.f22811G.left += COUIBaseListPopupWindow_12;
                this.f22827W.left = this.f22811G.left;
            } else {
                this.f22827W.left += COUIBaseListPopupWindow_12;
                this.f22811G.left = this.f22812H.left;
            }
            if (this.f22811G.width() < fWidth) {
                if (this.f22811G.right >= this.f22812H.right) {
                    this.f22811G.right = this.f22812H.right;
                } else {
                    this.f22811G.right += COUIBaseListPopupWindow_12;
                }
                this.f22827W.right = this.f22811G.right;
            }
            if (this.f22827W.left <= left) {
                this.f22827W.left = left;
            }
        } else if (zContains2) {
            float right = getRight() - this.f22843i;
            if (this.f22827W.right < this.f22812H.right) {
                this.f22811G.right += COUIBaseListPopupWindow_12;
                this.f22827W.right = this.f22811G.right;
            } else {
                this.f22827W.right += COUIBaseListPopupWindow_12;
                this.f22811G.right = this.f22812H.right;
            }
            if (this.f22811G.width() < fWidth) {
                if (this.f22811G.left <= this.f22812H.left) {
                    this.f22811G.left = this.f22812H.left;
                } else {
                    this.f22811G.left += COUIBaseListPopupWindow_12;
                }
                this.f22827W.left = this.f22811G.left;
            }
            if (this.f22827W.right >= right) {
                this.f22827W.right = right;
            }
        }
        if (zContains || zContains2) {
            if (this.f22811G.width() <= fWidth && 0.0f != COUIBaseListPopupWindow_12) {
                if (z && this.f22811G.right >= this.f22812H.right) {
                    this.f22811G.left = this.f22812H.right - fWidth;
                    this.f22811G.right = this.f22812H.right;
                } else if (this.f22811G.left <= this.f22812H.left) {
                    this.f22811G.left = this.f22812H.left;
                    this.f22811G.right = this.f22812H.left + fWidth;
                }
            }
            if (this.f22811G.left < this.f22812H.left) {
                this.f22811G.left = this.f22812H.left;
            }
            if (this.f22811G.right > this.f22812H.right) {
                this.f22811G.right = this.f22812H.right;
            }
            this.f22806B.left = this.f22811G.left + this.f22844j;
            this.f22806B.right = this.f22811G.right - this.f22844j;
            this.f22858x = 0.0f;
            float scrollX = this.f22836b.getScrollX() + (this.f22806B.left - this.f22808D.left);
            this.f22856v = scrollX / ((this.f22852r - this.f22836b.getStartPadding()) - this.f22836b.getEndPadding());
            this.f22857w = (scrollX + this.f22806B.width()) / ((this.f22852r - this.f22836b.getStartPadding()) - this.f22836b.getEndPadding());
            float f2 = this.f22809E.contains(this.f22815K, this.f22816L) ? this.f22856v : this.f22857w;
            setCurrentTime(getSelectTimeRatio() * this.f22853s);
            PlatformImplementations.kt_3 aVar = this.f22860z;
            if (aVar != null && f2 != this.f22859y) {
                aVar.mo12937c(f2);
            }
            this.f22859y = f2;
            this.f22817M = x;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m24115b(final boolean z) {
        float COUIBaseListPopupWindow_12 = z ? this.f22827W.left : this.f22827W.right;
        final float f2 = z ? this.f22812H.left : this.f22812H.right;
        SpringAnimation c0552f = new SpringAnimation(new FloatValueHolder(COUIBaseListPopupWindow_12));
        SpringForce c0553g = new SpringForce(f2);
        c0553g.m3236a(1500.0f);
        c0553g.m3239b(0.5f);
        c0552f.m3230a(c0553g);
        c0552f.m3217a(new DynamicAnimation.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_8.3
            @Override // androidx.dynamicanimation.p043a.DynamicAnimation.IntrinsicsJvm.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo3226a(DynamicAnimation abstractC0549c, float f3, float f4) {
                if (z) {
                    VideoClipView.this.f22827W.left = f3;
                } else {
                    VideoClipView.this.f22827W.right = f3;
                }
                VideoClipView.this.f22829aa = f3 != f2;
                VideoClipView.this.invalidate();
            }
        });
        c0552f.mo3191a();
    }

    private float getSelectTimeRatio() {
        if (0.0f == this.f22808D.width()) {
            return 1.0f;
        }
        return this.f22806B.width() / this.f22808D.width();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m24113a(float COUIBaseListPopupWindow_12, float f2) {
        return this.f22807C.contains((float) ((int) COUIBaseListPopupWindow_12), (float) ((int) f2)) || this.f22809E.contains(COUIBaseListPopupWindow_12, f2) || this.f22810F.contains(COUIBaseListPopupWindow_12, f2);
    }

    public NvsLiveWindow getLiveWindow() {
        return this.f22828a;
    }

    public void setLiveWindow(NvsLiveWindow nvsLiveWindow) {
        this.f22828a = nvsLiveWindow;
    }

    public NvsMultiThumbnailSequenceView getThumbnail() {
        return this.f22836b;
    }

    public void setThumbProcess(float COUIBaseListPopupWindow_12) {
        m24127a(COUIBaseListPopupWindow_12, true);
    }

    public float getThumbProcess() {
        return this.f22858x;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24127a(float COUIBaseListPopupWindow_12, boolean z) {
        if (COUIBaseListPopupWindow_12 == this.f22859y) {
            return;
        }
        float fFloatValue = new BigDecimal(1.0f - COUIBaseListPopupWindow_12).setScale(2, RoundingMode.DOWN).floatValue();
        float f2 = this.f22856v;
        if (COUIBaseListPopupWindow_12 < f2) {
            COUIBaseListPopupWindow_12 = f2;
        } else if (COUIBaseListPopupWindow_12 >= this.f22857w || 0.01f >= fFloatValue) {
            COUIBaseListPopupWindow_12 = this.f22857w;
        }
        this.f22859y = COUIBaseListPopupWindow_12;
        float f3 = this.f22857w;
        float f4 = this.f22856v;
        this.f22858x = (COUIBaseListPopupWindow_12 - f4) / (f3 - f4);
        if (z) {
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24128a(int OplusGLSurfaceView_13, int i2) {
        this.f22846l = OplusGLSurfaceView_13;
        this.f22845k = i2;
        this.f22820P = true;
        CameraLog.m12959b("VideoClipView", "setVideoSize mVideoWidth: " + this.f22846l + ", mVideoHeight: " + this.f22845k);
    }

    public void setTotalTime(long OplusGLSurfaceView_15) {
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_15;
        this.f22851q = COUIBaseListPopupWindow_12;
        this.f22825U = false;
        this.f22826V = true;
        this.f22824T = 0;
        this.f22850p = m24109a(COUIBaseListPopupWindow_12);
        this.f22856v = 0.0f;
        float f2 = this.f22850p;
        this.f22857w = f2 < 15.0f ? 1.0f : 15.0f / f2;
        this.f22858x = 0.0f;
        float f3 = this.f22850p;
        if (f3 >= 15.0f) {
            f3 = 15.0f;
        }
        this.f22853s = f3;
        requestLayout();
        invalidate();
        CameraLog.m12959b("VideoClipView", "totalTime: " + OplusGLSurfaceView_15 + " mTotalTimeSecond: " + this.f22850p);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m24125g() {
        float fWidth = this.f22806B.left + (this.f22806B.width() * this.f22858x);
        float width = this.f22818N.getWidth() + fWidth;
        float height = this.f22806B.top - ((this.f22818N.getHeight() - this.f22806B.height()) / 2.0f);
        float COUIBaseListPopupWindow_12 = this.f22806B.right;
        if (width > COUIBaseListPopupWindow_12) {
            fWidth = COUIBaseListPopupWindow_12 - this.f22818N.getWidth();
        }
        this.f22807C.set(fWidth, height, this.f22818N.getWidth() + fWidth, this.f22818N.getHeight() + height);
        this.f22807C.left -= this.f22818N.getWidth();
        this.f22807C.right += this.f22818N.getWidth();
    }

    public void setCurrentTime(float COUIBaseListPopupWindow_12) {
        this.f22855u = new BigDecimal(COUIBaseListPopupWindow_12).setScale(0, RoundingMode.DOWN).floatValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m24109a(float COUIBaseListPopupWindow_12) {
        return new BigDecimal((COUIBaseListPopupWindow_12 * 1.0f) / 1000000.0f).setScale(2, RoundingMode.DOWN).floatValue();
    }

    public void setSeekToCallback(PlatformImplementations.kt_3 aVar) {
        this.f22860z = aVar;
    }

    public float getLeftVideoProcess() {
        return this.f22856v;
    }

    public void setLeftVideoProcess(float COUIBaseListPopupWindow_12) {
        this.f22856v = COUIBaseListPopupWindow_12;
    }

    public float getRightVideoProcess() {
        return this.f22857w;
    }

    public void setRightVideoProcess(float COUIBaseListPopupWindow_12) {
        this.f22857w = COUIBaseListPopupWindow_12;
    }

    public void setVideoClipClick(IntrinsicsJvm.kt_4 bVar) {
        this.f22805A = bVar;
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f22837c.m18348a(OplusGLSurfaceView_13, true);
        this.f22838d.m18348a(OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24126a() {
        if (this.f22839e == null) {
            this.f22839e = new COUIRotatingSpinnerDialog(getContext());
            this.f22839e.setCancelable(false);
            this.f22839e.setCanceledOnTouchOutside(false);
            this.f22839e.setTitle(getResources().getString(R.string.mode_double_exposure_video_importing));
        }
        this.f22839e.show();
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            setAlpha(1.0f);
        }
        super.setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24129a(final boolean z) {
        this.f22836b.scrollTo(0, 0);
        this.f22836b.smoothScrollTo(0, 0);
        this.f22824T = 0;
        this.f22825U = true;
        ValueAnimator duration = ValueAnimator.ofInt(0, 255).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_8.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoClipView.this.f22824T = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                VideoClipView viewOnClickListenerC3522e = VideoClipView.this;
                viewOnClickListenerC3522e.f22825U = 255 != viewOnClickListenerC3522e.f22824T;
                if (z) {
                    if (255 == VideoClipView.this.f22824T) {
                        VideoClipView.this.setVisibility(8);
                    } else {
                        VideoClipView.this.setAlpha((255 - r3.f22824T) / 255.0f);
                    }
                }
                VideoClipView.this.invalidate();
            }
        });
        duration.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24130b() {
        COUIRotatingSpinnerDialog dialogC1290c = this.f22839e;
        if (dialogC1290c != null) {
            dialogC1290c.dismiss();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m24131c() {
        COUIRotatingSpinnerDialog dialogC1290c = this.f22839e;
        return dialogC1290c != null && dialogC1290c.isShowing();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m24132d() {
        return getVisibility() == 0 && getAnimationAlpha() == 0 && !m24133e();
    }

    public int getAnimationAlpha() {
        return this.f22824T;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m24133e() {
        return this.f22825U;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IntrinsicsJvm.kt_4 bVar = this.f22805A;
        if (bVar == null) {
            return;
        }
        if (view == this.f22837c) {
            bVar.mo19914eB();
        } else if (view == this.f22838d) {
            bVar.mo19648a(this.f22856v, this.f22857w);
        }
    }

    @Override // com.meicam.sdk.NvsMultiThumbnailSequenceView.OnScrollChangeListener
    public void onScrollChanged(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView, int OplusGLSurfaceView_13, int i2) {
        if (15.0f > this.f22850p) {
            return;
        }
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 + (this.f22806B.left - this.f22808D.left);
        this.f22856v = COUIBaseListPopupWindow_12 / ((this.f22852r - this.f22836b.getStartPadding()) - this.f22836b.getEndPadding());
        this.f22857w = (COUIBaseListPopupWindow_12 + this.f22806B.width()) / ((this.f22852r - this.f22836b.getStartPadding()) - this.f22836b.getEndPadding());
        this.f22859y = this.f22856v;
        m24127a(0.0f, true);
        PlatformImplementations.kt_3 aVar = this.f22860z;
        if (aVar != null) {
            aVar.mo12937c(this.f22859y);
        }
        this.f22835ag.removeMessages(1);
        this.f22835ag.sendEmptyMessageDelayed(1, 50L);
    }
}
