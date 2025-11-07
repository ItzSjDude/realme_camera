package com.coui.appcompat.widget.keyboard;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coui.appcompat.widget.keyboard.SecurityKeyboard;
import com.coui.appcompat.widget.popupwindow.COUIPopupWindow;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SecurityKeyboardView extends View implements View.OnClickListener {

    /* renamed from: aJ */
    private static int[][][] f8154aJ;

    /* renamed from: aK */
    private static int[][] f8155aK;

    /* renamed from: A */
    private SecurityKeyboard.PlatformImplementations.kt_3[] f8161A;

    /* renamed from: B */
    private InterfaceC1483b f8162B;

    /* renamed from: C */
    private int f8163C;

    /* renamed from: D */
    private int f8164D;

    /* renamed from: E */
    private boolean f8165E;

    /* renamed from: F */
    private boolean f8166F;

    /* renamed from: G */
    private boolean f8167G;

    /* renamed from: H */
    private int f8168H;

    /* renamed from: I */
    private int f8169I;

    /* renamed from: J */
    private int f8170J;

    /* renamed from: K */
    private int f8171K;

    /* renamed from: L */
    private int f8172L;

    /* renamed from: M */
    private int f8173M;

    /* renamed from: N */
    private boolean f8174N;

    /* renamed from: O */
    private Paint f8175O;

    /* renamed from: P */
    private Rect f8176P;

    /* renamed from: Q */
    private long f8177Q;

    /* renamed from: R */
    private long f8178R;

    /* renamed from: S */
    private int f8179S;

    /* renamed from: T */
    private int f8180T;

    /* renamed from: U */
    private int f8181U;

    /* renamed from: V */
    private int f8182V;

    /* renamed from: W */
    private int f8183W;

    /* renamed from: PlatformImplementations.kt_3 */
    Handler f8184a;

    /* renamed from: aA */
    private StringBuilder f8185aA;

    /* renamed from: aB */
    private boolean f8186aB;

    /* renamed from: aC */
    private Rect f8187aC;

    /* renamed from: aD */
    private Bitmap f8188aD;

    /* renamed from: aE */
    private boolean f8189aE;

    /* renamed from: aF */
    private Canvas f8190aF;

    /* renamed from: aG */
    private AccessibilityManager f8191aG;

    /* renamed from: aH */
    private AudioManager f8192aH;

    /* renamed from: aM */
    private int f8193aM;

    /* renamed from: aN */
    private int f8194aN;

    /* renamed from: aO */
    private ColorStateList f8195aO;

    /* renamed from: aP */
    private ColorStateList f8196aP;

    /* renamed from: aQ */
    private Drawable f8197aQ;

    /* renamed from: aR */
    private Drawable f8198aR;

    /* renamed from: aS */
    private Typeface f8199aS;

    /* renamed from: aT */
    private InterfaceC1484c f8200aT;

    /* renamed from: aU */
    private int f8201aU;

    /* renamed from: aV */
    private int f8202aV;

    /* renamed from: aW */
    private int f8203aW;

    /* renamed from: aX */
    private int f8204aX;

    /* renamed from: aY */
    private int f8205aY;

    /* renamed from: aZ */
    private int f8206aZ;

    /* renamed from: aa */
    private long f8207aa;

    /* renamed from: ab */
    private long f8208ab;

    /* renamed from: ac */
    private int[] f8209ac;

    /* renamed from: ad */
    private GestureDetector f8210ad;

    /* renamed from: ae */
    private int f8211ae;

    /* renamed from: af */
    private int f8212af;

    /* renamed from: ag */
    private int f8213ag;

    /* renamed from: ah */
    private int f8214ah;

    /* renamed from: ai */
    private boolean f8215ai;

    /* renamed from: aj */
    private SecurityKeyboard.PlatformImplementations.kt_3 f8216aj;

    /* renamed from: ak */
    private Rect f8217ak;

    /* renamed from: al */
    private boolean f8218al;

    /* renamed from: am */
    private C1485d f8219am;

    /* renamed from: an */
    private int f8220an;

    /* renamed from: ao */
    private boolean f8221ao;

    /* renamed from: ap */
    private int f8222ap;

    /* renamed from: aq */
    private float f8223aq;

    /* renamed from: ar */
    private float f8224ar;

    /* renamed from: as */
    private Drawable f8225as;

    /* renamed from: av */
    private int[] f8226av;

    /* renamed from: aw */
    private int f8227aw;

    /* renamed from: ax */
    private int f8228ax;

    /* renamed from: ay */
    private long f8229ay;

    /* renamed from: az */
    private boolean f8230az;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected List<Integer> f8231b;

    /* renamed from: ba */
    private boolean f8232ba;

    /* renamed from: bb */
    private int f8233bb;

    /* renamed from: bc */
    private boolean f8234bc;

    /* renamed from: bd */
    private float f8235bd;

    /* renamed from: be */
    private int f8236be;

    /* renamed from: bf */
    private int f8237bf;

    /* renamed from: bg_renamed */
    private String[] f8238bg;

    /* renamed from: bh */
    private int f8239bh;

    /* renamed from: bi */
    private ColorStateList f8240bi;

    /* renamed from: bj */
    private int f8241bj;

    /* renamed from: bk */
    private int f8242bk;

    /* renamed from: bl */
    private int f8243bl;

    /* renamed from: bm */
    private ArrayList<C1482a> f8244bm;

    /* renamed from: bn */
    private ArrayList<Drawable> f8245bn;

    /* renamed from: bo */
    private Drawable f8246bo;

    /* renamed from: bp */
    private List<int[]> f8247bp;

    /* renamed from: bq */
    private int f8248bq;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SecurityKeyboard f8249e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f8250f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f8251g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8252h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8253i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f8254j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f8255k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f8256l;

    /* renamed from: OplusGLSurfaceView_6 */
    private TextView f8257m;

    /* renamed from: OplusGLSurfaceView_11 */
    private COUIPopupWindow f8258n;

    /* renamed from: o */
    private int f8259o;

    /* renamed from: p */
    private int f8260p;

    /* renamed from: q */
    private int f8261q;

    /* renamed from: r */
    private final int[] f8262r;

    /* renamed from: s */
    private PopupWindow f8263s;

    /* renamed from: t */
    private View f8264t;

    /* renamed from: u */
    private SecurityKeyboardView f8265u;

    /* renamed from: v */
    private boolean f8266v;

    /* renamed from: w */
    private View f8267w;

    /* renamed from: x */
    private int f8268x;

    /* renamed from: y */
    private int f8269y;

    /* renamed from: z */
    private Map<SecurityKeyboard.PlatformImplementations.kt_3, View> f8270z;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f8159c = {-5};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final int[] f8160d = {R.attr.state_long_pressable};

    /* renamed from: at */
    private static final int f8157at = ViewConfiguration.getLongPressTimeout();

    /* renamed from: au */
    private static int f8158au = 12;

    /* renamed from: aI */
    private static final int[] f8153aI = {R.attr.state_window_focused, 1, R.attr.state_selected, 2, R.attr.state_focused, 4, R.attr.state_enabled, 8, R.attr.state_pressed, 16, R.attr.state_activated, 32, R.attr.state_accelerated, 64, R.attr.state_hovered, 128, R.attr.state_drag_can_accept, 256, R.attr.state_drag_hovered, 512};

    /* renamed from: aL */
    private static int f8156aL = coui.support.appcompat.R.styleable.ViewDrawableStates.length;

    /* renamed from: com.coui.appcompat.widget.keyboard.SecurityKeyboardView$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1483b {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7897a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo7898a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo7899a(int OplusGLSurfaceView_13, int[] iArr);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo7900a(CharSequence charSequence);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo7901b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo7902b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo7903c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo7904d();
    }

    /* renamed from: com.coui.appcompat.widget.keyboard.SecurityKeyboardView$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1484c {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7912a(String str, int OplusGLSurfaceView_13);
    }

    public void setVerticalCorrection(int OplusGLSurfaceView_13) {
    }

    static {
        int[] iArr = f8153aI;
        int length = iArr.length / 2;
        if (length != f8156aL) {
            throw new IllegalStateException("VIEW_STATE_IDS array length does not match ViewDrawableStates style array");
        }
        int[] iArr2 = new int[iArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < f8156aL; OplusGLSurfaceView_13++) {
            int i2 = coui.support.appcompat.R.styleable.ViewDrawableStates[OplusGLSurfaceView_13];
            int i3 = 0;
            while (true) {
                int[] iArr3 = f8153aI;
                if (i3 < iArr3.length) {
                    if (iArr3[i3] == i2) {
                        int i4 = OplusGLSurfaceView_13 * 2;
                        iArr2[i4] = i2;
                        iArr2[i4 + 1] = iArr3[i3 + 1];
                    }
                    i3 += 2;
                }
            }
        }
        int i5 = 1 << length;
        f8154aJ = new int[i5][][];
        f8155aK = new int[i5][];
        for (int i6 = 0; i6 < f8155aK.length; i6++) {
            f8155aK[i6] = new int[Integer.bitCount(i6)];
            int i7 = 0;
            for (int i8 = 0; i8 < iArr2.length; i8 += 2) {
                if ((iArr2[i8 + 1] & i6) != 0) {
                    f8155aK[i6][i7] = iArr2[i8];
                    i7++;
                }
            }
        }
    }

    public SecurityKeyboardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R.attr.securityKeyboardViewStyle);
    }

    public SecurityKeyboardView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, coui.support.appcompat.R.style.SecurityKeyboardView);
    }

    public SecurityKeyboardView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f8250f = -1;
        this.f8262r = new int[2];
        this.f8165E = false;
        this.f8166F = true;
        this.f8167G = true;
        this.f8182V = -1;
        this.f8183W = -1;
        this.f8209ac = new int[12];
        this.f8213ag = -1;
        this.f8217ak = new Rect(0, 0, 0, 0);
        this.f8219am = new C1485d();
        this.f8222ap = 1;
        this.f8226av = new int[f8158au];
        this.f8185aA = new StringBuilder(1);
        this.f8187aC = new Rect();
        this.f8231b = new ArrayList();
        this.f8194aN = 0;
        this.f8197aQ = null;
        this.f8198aR = null;
        this.f8199aS = null;
        this.f8201aU = 0;
        this.f8202aV = 0;
        this.f8203aW = 0;
        this.f8204aX = 0;
        this.f8205aY = 0;
        this.f8206aZ = 0;
        this.f8232ba = true;
        this.f8233bb = -1;
        this.f8234bc = false;
        this.f8235bd = -1.0f;
        this.f8236be = -1;
        this.f8237bf = -1;
        this.f8238bg = null;
        this.f8241bj = -1;
        this.f8242bk = 2;
        this.f8243bl = -1;
        this.f8244bm = new ArrayList<>();
        this.f8245bn = new ArrayList<>();
        this.f8247bp = new ArrayList();
        if (attributeSet != null) {
            this.f8248bq = attributeSet.getStyleAttribute();
            if (this.f8248bq == 0) {
                this.f8248bq = OplusGLSurfaceView_13;
            }
        } else {
            this.f8248bq = OplusGLSurfaceView_13;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R.styleable.SecurityKeyboardView, OplusGLSurfaceView_13, coui.support.appcompat.R.style.SecurityKeyboardView);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f8225as = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiSecurityKeyBackground);
        this.f8163C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiVerticalCorrection, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiKeyPreviewLayout, 0);
        this.f8260p = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiKeyPreviewOffset, 0);
        this.f8261q = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiKeyPreviewHeight, 80);
        this.f8193aM = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiKeyPreviewWidth, 80);
        this.f8252h = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiSecurityKeyTextSize, 18);
        this.f8253i = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiSecurityKeyTextColor, -16777216);
        this.f8251g = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiLabelTextSize, 14);
        this.f8214ah = typedArrayObtainStyledAttributes.getResourceId(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiPopupLayout, 0);
        this.f8255k = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiShadowColor, 0);
        this.f8254j = typedArrayObtainStyledAttributes.getFloat(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiShadowRadius, 0.0f);
        this.f8194aN = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiKeyBoardType, 0);
        this.f8195aO = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiTextColor);
        this.f8196aP = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiGoTextColor);
        this.f8197aQ = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiSpecialKeyBg);
        this.f8198aR = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiEndKeyBg);
        this.f8240bi = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiItemSymbolsColor);
        this.f8246bo = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R.styleable.SecurityKeyboardView_couiSpecialItemBg);
        this.f8256l = 0.5f;
        this.f8258n = new COUIPopupWindow(context);
        if (resourceId != 0) {
            this.f8257m = (TextView) layoutInflater.inflate(resourceId, (ViewGroup) null);
            this.f8259o = (int) this.f8257m.getTextSize();
            this.f8258n.setContentView(this.f8257m);
            this.f8258n.setBackgroundDrawable(null);
        } else {
            this.f8166F = false;
        }
        this.f8258n.setTouchable(false);
        this.f8258n.m8101a(new COUIPopupWindow.IntrinsicsJvm.kt_4() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.1
            @Override // com.coui.appcompat.widget.popupwindow.COUIPopupWindow.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo7896a(WindowManager.LayoutParams layoutParams) {
                layoutParams.flags |= 8192;
                layoutParams.setTitle("COUISecurityPopupWindow");
            }
        });
        this.f8263s = new PopupWindow(context);
        this.f8263s.setBackgroundDrawable(null);
        this.f8267w = this;
        this.f8175O = new Paint();
        this.f8175O.setAntiAlias(true);
        this.f8175O.setTextSize(0);
        this.f8175O.setTextAlign(Paint.Align.CENTER);
        this.f8175O.setAlpha(255);
        this.f8176P = new Rect(0, 0, 0, 0);
        this.f8270z = new HashMap();
        Drawable drawable = this.f8225as;
        if (drawable != null) {
            drawable.getPadding(this.f8176P);
        }
        this.f8220an = (int) (getResources().getDisplayMetrics().density * 500.0f);
        this.f8221ao = true;
        this.f8191aG = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f8192aH = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        m7879n();
        setKeyboardType(1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    @SuppressLint({"HandlerLeak"})
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m7870i();
        if (this.f8184a == null) {
            this.f8184a = new Handler() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 == 1) {
                        SecurityKeyboardView.this.m7862d(message.arg1);
                        return;
                    }
                    if (OplusGLSurfaceView_13 == 2) {
                        Log.IntrinsicsJvm.kt_5("SecurityKeyboardView", "handleMessage MSG_REMOVE_PREVIEW");
                        SecurityKeyboardView.this.f8257m.setVisibility(4);
                    } else if (OplusGLSurfaceView_13 != 3) {
                        if (OplusGLSurfaceView_13 != 4) {
                            return;
                        }
                        SecurityKeyboardView.this.m7852a((MotionEvent) message.obj);
                    } else if (SecurityKeyboardView.this.m7874k()) {
                        sendMessageDelayed(Message.obtain(this, 3), 50L);
                    }
                }
            };
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m7870i() {
        if (this.f8210ad == null) {
            this.f8210ad = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
                    if (SecurityKeyboardView.this.f8218al) {
                        return false;
                    }
                    float fAbs = Math.abs(COUIBaseListPopupWindow_12);
                    float fAbs2 = Math.abs(f2);
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    int width = SecurityKeyboardView.this.getWidth() / 2;
                    int height = SecurityKeyboardView.this.getHeight() / 2;
                    SecurityKeyboardView.this.f8219am.m7915a(1000);
                    float fM7918b = SecurityKeyboardView.this.f8219am.m7918b();
                    float fM7919c = SecurityKeyboardView.this.f8219am.m7919c();
                    boolean z = true;
                    if (COUIBaseListPopupWindow_12 <= SecurityKeyboardView.this.f8220an || fAbs2 >= fAbs || x <= width) {
                        if (COUIBaseListPopupWindow_12 >= (-SecurityKeyboardView.this.f8220an) || fAbs2 >= fAbs || x >= (-width)) {
                            if (f2 >= (-SecurityKeyboardView.this.f8220an) || fAbs >= fAbs2 || y >= (-height)) {
                                if (f2 <= SecurityKeyboardView.this.f8220an || fAbs >= fAbs2 / 2.0f || y <= height) {
                                    z = false;
                                } else if (!SecurityKeyboardView.this.f8221ao || fM7919c >= f2 / 4.0f) {
                                    SecurityKeyboardView.this.m7892e();
                                    return true;
                                }
                            } else if (!SecurityKeyboardView.this.f8221ao || fM7919c <= f2 / 4.0f) {
                                SecurityKeyboardView.this.m7891d();
                                return true;
                            }
                        } else if (!SecurityKeyboardView.this.f8221ao || fM7918b <= COUIBaseListPopupWindow_12 / 4.0f) {
                            SecurityKeyboardView.this.m7890c();
                            return true;
                        }
                    } else if (!SecurityKeyboardView.this.f8221ao || fM7918b >= COUIBaseListPopupWindow_12 / 4.0f) {
                        SecurityKeyboardView.this.m7886b();
                        return true;
                    }
                    if (z) {
                        SecurityKeyboardView securityKeyboardView = SecurityKeyboardView.this;
                        securityKeyboardView.m7843a(securityKeyboardView.f8183W, SecurityKeyboardView.this.f8172L, SecurityKeyboardView.this.f8173M, motionEvent.getEventTime());
                    }
                    return false;
                }
            });
            this.f8210ad.setIsLongpressEnabled(false);
        }
    }

    protected InterfaceC1483b getOnKeyboardActionListener() {
        return this.f8162B;
    }

    public void setOnKeyboardActionListener(InterfaceC1483b interfaceC1483b) {
        this.f8162B = interfaceC1483b;
    }

    public void setKeyBackground(Drawable drawable) {
        if (drawable != null) {
            this.f8225as = drawable;
            this.f8225as.getPadding(this.f8176P);
            invalidate();
        }
    }

    public void setKeyTextColor(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f8253i) {
            this.f8253i = OplusGLSurfaceView_13;
            invalidate();
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f8195aO = colorStateList;
            invalidate();
        }
    }

    public void setGoTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f8196aP = colorStateList;
            invalidate();
        }
    }

    public void setSpecialKeyBg(Drawable drawable) {
        if (drawable != null) {
            this.f8197aQ = drawable;
            invalidate();
        }
    }

    public void setEndKeyBg(Drawable drawable) {
        if (drawable != null) {
            this.f8198aR = drawable;
            invalidate();
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f8240bi = colorStateList;
            m7880o();
            invalidate();
        }
    }

    public void setSpecialItemBg(Drawable drawable) {
        if (drawable != null) {
            this.f8246bo = drawable;
            m7880o();
            invalidate();
        }
    }

    public SecurityKeyboard getKeyboard() {
        return this.f8249e;
    }

    public void setKeyboard(SecurityKeyboard c1486a) {
        if (this.f8249e != null) {
            m7857c(-1);
        }
        m7876l();
        this.f8249e = c1486a;
        List<SecurityKeyboard.PlatformImplementations.kt_3> listM7934a = this.f8249e.m7934a();
        this.f8161A = (SecurityKeyboard.PlatformImplementations.kt_3[]) listM7934a.toArray(new SecurityKeyboard.PlatformImplementations.kt_3[listM7934a.size()]);
        requestLayout();
        this.f8189aE = true;
        m7881a();
        m7851a(c1486a);
        this.f8270z.clear();
        this.f8213ag = -1;
        this.f8215ai = true;
    }

    public void setNewShifted(int OplusGLSurfaceView_13) {
        SecurityKeyboard c1486a = this.f8249e;
        if (c1486a != null) {
            c1486a.m7935a(OplusGLSurfaceView_13);
            m7881a();
        }
    }

    public int getNewShifted() {
        SecurityKeyboard c1486a = this.f8249e;
        if (c1486a != null) {
            return c1486a.m7940d();
        }
        return -1;
    }

    public void setPreviewEnabled(boolean z) {
        this.f8166F = z;
    }

    public void setPopupParent(View view) {
        this.f8267w = view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7883a(int OplusGLSurfaceView_13, int i2) {
        this.f8268x = OplusGLSurfaceView_13;
        this.f8269y = i2;
        if (this.f8258n.isShowing()) {
            Log.IntrinsicsJvm.kt_5("SecurityKeyboardView", "PopupView is Showing");
            this.f8258n.dismiss();
        }
    }

    public void setProximityCorrectionEnabled(boolean z) {
        this.f8174N = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m7878m();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private CharSequence m7842a(CharSequence charSequence) {
        return (getNewShifted() < 1 || charSequence == null || charSequence.length() >= 3 || !Character.isLowerCase(charSequence.charAt(0))) ? charSequence : charSequence.toString().toUpperCase();
    }

    @Override // android.view.View
    public void onMeasure(int OplusGLSurfaceView_13, int i2) {
        if (this.f8249e == null) {
            setMeasuredDimension(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(OplusGLSurfaceView_13), this.f8249e.m7937b() + getPaddingTop() + getPaddingBottom());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7851a(SecurityKeyboard c1486a) {
        SecurityKeyboard.PlatformImplementations.kt_3[] aVarArr;
        if (c1486a == null || (aVarArr = this.f8161A) == null) {
            return;
        }
        int length = aVarArr.length;
        int iMin = 0;
        for (SecurityKeyboard.PlatformImplementations.kt_3 aVar : aVarArr) {
            iMin += Math.min(aVar.f8319e, aVar.f8320f) + aVar.f8321g;
        }
        if (iMin < 0 || length == 0) {
            return;
        }
        this.f8164D = (int) ((iMin * 1.4f) / length);
        int OplusGLSurfaceView_13 = this.f8164D;
        this.f8164D = OplusGLSurfaceView_13 * OplusGLSurfaceView_13;
    }

    @Override // android.view.View
    public void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        SecurityKeyboard c1486a = this.f8249e;
        this.f8188aD = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8186aB || this.f8188aD == null || this.f8189aE) {
            m7872j();
        }
        canvas.drawBitmap(this.f8188aD, 0.0f, 0.0f, (Paint) null);
        if (m7895h()) {
            m7848a(canvas, this.f8239bh);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0247  */
    /* renamed from: OplusGLSurfaceView_15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m7872j() {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.m7872j():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f A[PHI: r6
      0x003f: PHI (r6v9 int) = (r6v3 int), (r6v11 int) binds: [B:13:0x003d, B:10:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086 A[PHI: r12 r13
      0x0086: PHI (r12v2 int) = (r12v1 int), (r12v5 int) binds: [B:16:0x0044, B:20:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0086: PHI (r13v2 int) = (r13v1 int), (r13v5 int) binds: [B:16:0x0044, B:20:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m7840a(int r19, int r20, int[] r21) {
        /*
            Method dump skipped, instructions count: 179
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.m7840a(int, int, int[]):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7843a(int OplusGLSurfaceView_13, int i2, int i3, long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_13 != -1) {
            SecurityKeyboard.PlatformImplementations.kt_3[] aVarArr = this.f8161A;
            if (OplusGLSurfaceView_13 < aVarArr.length) {
                SecurityKeyboard.PlatformImplementations.kt_3 aVar = aVarArr[OplusGLSurfaceView_13];
                if (aVar.f8327m != null) {
                    this.f8162B.mo7900a(aVar.f8327m);
                    this.f8162B.mo7902b(-1);
                } else {
                    int i4 = aVar.f8315a[0];
                    int[] iArr = new int[f8158au];
                    Arrays.fill(iArr, -1);
                    m7840a(i2, i3, iArr);
                    if (this.f8230az) {
                        if (this.f8228ax != -1) {
                            this.f8162B.mo7899a(-5, f8159c);
                            m7845a(i4, aVar);
                        } else {
                            this.f8228ax = 0;
                        }
                        i4 = aVar.f8315a[this.f8228ax];
                    }
                    m7845a(i4, aVar);
                    this.f8162B.mo7899a(i4, iArr);
                    this.f8162B.mo7902b(i4);
                }
                this.f8227aw = OplusGLSurfaceView_13;
                this.f8229ay = OplusGLSurfaceView_15;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence m7855b(SecurityKeyboard.PlatformImplementations.kt_3 aVar) {
        if (this.f8230az) {
            this.f8185aA.setLength(0);
            StringBuilder sb = this.f8185aA;
            int[] iArr = aVar.f8315a;
            int OplusGLSurfaceView_13 = this.f8228ax;
            sb.append((char) iArr[OplusGLSurfaceView_13 >= 0 ? OplusGLSurfaceView_13 : 0]);
            return m7842a(this.f8185aA);
        }
        return m7842a(aVar.f8316b);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7857c(int OplusGLSurfaceView_13) {
        int i2 = this.f8250f;
        COUIPopupWindow c1503e = this.f8258n;
        this.f8250f = OplusGLSurfaceView_13;
        SecurityKeyboard.PlatformImplementations.kt_3[] aVarArr = this.f8161A;
        int i3 = this.f8250f;
        if (i2 != i3) {
            if (i2 != -1 && aVarArr.length > i2) {
                SecurityKeyboard.PlatformImplementations.kt_3 aVar = aVarArr[i2];
                aVar.m7943a(i3 == -1);
                m7882a(i2);
                int i4 = aVar.f8315a[0];
                m7858c(256, i4);
                m7858c(65536, i4);
            }
            int i5 = this.f8250f;
            if (i5 != -1 && aVarArr.length > i5) {
                SecurityKeyboard.PlatformImplementations.kt_3 aVar2 = aVarArr[i5];
                aVar2.m7942a();
                m7882a(this.f8250f);
                int i6 = aVar2.f8315a[0];
                m7844a(128, i6, aVar2);
                m7844a(32768, i6, aVar2);
            }
        }
        boolean zM7865f = m7865f(this.f8250f);
        if (i2 != this.f8250f && this.f8166F && zM7865f) {
            this.f8184a.removeMessages(1);
            if (c1503e.isShowing() && OplusGLSurfaceView_13 == -1) {
                Handler handler = this.f8184a;
                handler.sendMessageDelayed(handler.obtainMessage(2), 75L);
            }
            if (OplusGLSurfaceView_13 != -1) {
                if (c1503e.isShowing() && this.f8257m.getVisibility() == 0) {
                    m7862d(OplusGLSurfaceView_13);
                } else {
                    m7862d(OplusGLSurfaceView_13);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m7862d(int OplusGLSurfaceView_13) {
        COUIPopupWindow c1503e = this.f8258n;
        SecurityKeyboard.PlatformImplementations.kt_3[] aVarArr = this.f8161A;
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= aVarArr.length) {
            return;
        }
        SecurityKeyboard.PlatformImplementations.kt_3 aVar = aVarArr[OplusGLSurfaceView_13];
        if (aVar.f8317c != null) {
            this.f8257m.setCompoundDrawables(null, null, null, aVar.f8318d != null ? aVar.f8318d : aVar.f8317c);
            this.f8257m.setText((CharSequence) null);
        } else {
            this.f8257m.setCompoundDrawables(null, null, null, null);
            this.f8257m.setText(m7855b(aVar));
            if (aVar.f8316b.length() > 1 && aVar.f8315a.length < 2) {
                this.f8257m.setTextSize(0, this.f8252h);
                this.f8257m.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                this.f8257m.setTextSize(0, this.f8259o);
                this.f8257m.setTypeface(this.f8199aS);
            }
        }
        this.f8257m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int i2 = this.f8193aM;
        int i3 = this.f8261q;
        ViewGroup.LayoutParams layoutParams = this.f8257m.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        if (!this.f8165E) {
            this.f8168H = ((aVar.f8323i + (aVar.f8319e / 2)) - (this.f8193aM / 2)) + getPaddingLeft();
            this.f8169I = (aVar.f8324j - i3) + this.f8260p;
        } else {
            this.f8168H = 160 - (this.f8257m.getMeasuredWidth() / 2);
            this.f8169I = -this.f8257m.getMeasuredHeight();
        }
        this.f8184a.removeMessages(2);
        getLocationInWindow(this.f8262r);
        int[] iArr = this.f8262r;
        iArr[0] = iArr[0] + this.f8268x;
        iArr[1] = iArr[1] + this.f8269y;
        this.f8257m.getBackground().setState(aVar.f8332r != 0 ? f8160d : EMPTY_STATE_SET);
        int i4 = this.f8168H;
        int[] iArr2 = this.f8262r;
        this.f8168H = i4 + iArr2[0];
        this.f8169I += iArr2[1];
        getLocationOnScreen(iArr2);
        if (this.f8169I + this.f8262r[1] < 0) {
            if (aVar.f8323i + aVar.f8319e <= getWidth() / 2) {
                this.f8168H += (int) (aVar.f8319e * 2.5d);
            } else {
                this.f8168H -= (int) (aVar.f8319e * 2.5d);
            }
            this.f8169I += i3;
        }
        if (c1503e.isShowing()) {
            c1503e.update(this.f8168H, this.f8169I, i2, i3);
        } else {
            c1503e.setWidth(i2);
            c1503e.setHeight(i3);
            c1503e.showAtLocation(this.f8267w, 0, this.f8168H, this.f8169I);
        }
        this.f8257m.setVisibility(0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7858c(int OplusGLSurfaceView_13, int i2) {
        String string;
        AccessibilityManager accessibilityManager = this.f8191aG;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(OplusGLSurfaceView_13);
        onInitializeAccessibilityEvent(accessibilityEventObtain);
        if (i2 != 10) {
            switch (i2) {
                case -6:
                    string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_alt);
                    break;
                case -5:
                    string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_delete);
                    break;
                case -4:
                    string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_done);
                    break;
                case -3:
                    string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_cancel);
                    break;
                case -2:
                    string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_mode_change);
                    break;
                case -1:
                    string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_shift);
                    break;
                default:
                    string = String.valueOf((char) i2);
                    break;
            }
        } else {
            string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_enter);
        }
        accessibilityEventObtain.getText().add(string);
        this.f8191aG.sendAccessibilityEvent(accessibilityEventObtain);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7881a() {
        this.f8187aC.union(0, 0, getWidth(), getHeight());
        this.f8186aB = true;
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7882a(int OplusGLSurfaceView_13) {
        SecurityKeyboard.PlatformImplementations.kt_3[] aVarArr = this.f8161A;
        if (aVarArr != null && OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < aVarArr.length) {
            SecurityKeyboard.PlatformImplementations.kt_3 aVar = aVarArr[OplusGLSurfaceView_13];
            this.f8216aj = aVar;
            this.f8187aC.union(aVar.f8323i + getPaddingLeft(), aVar.f8324j + getPaddingTop(), aVar.f8323i + aVar.f8319e + getPaddingLeft(), aVar.f8324j + aVar.f8320f + getPaddingTop());
            m7872j();
            invalidate(aVar.f8323i + getPaddingLeft(), aVar.f8324j + getPaddingTop(), aVar.f8323i + aVar.f8319e + getPaddingLeft(), aVar.f8324j + aVar.f8320f + getPaddingTop());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7852a(MotionEvent motionEvent) {
        int OplusGLSurfaceView_13;
        if (this.f8214ah != 0 && (OplusGLSurfaceView_13 = this.f8182V) >= 0) {
            SecurityKeyboard.PlatformImplementations.kt_3[] aVarArr = this.f8161A;
            if (OplusGLSurfaceView_13 < aVarArr.length) {
                boolean zM7885a = m7885a(aVarArr[OplusGLSurfaceView_13]);
                if (zM7885a) {
                    this.f8215ai = true;
                    m7857c(-1);
                }
                return zM7885a;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m7885a(SecurityKeyboard.PlatformImplementations.kt_3 aVar) {
        SecurityKeyboard c1486a;
        int OplusGLSurfaceView_13 = aVar.f8332r;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        this.f8264t = this.f8270z.get(aVar);
        View view = this.f8264t;
        if (view == null) {
            this.f8264t = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.f8214ah, (ViewGroup) null);
            this.f8265u = (SecurityKeyboardView) this.f8264t.findViewById(R.id_renamed.keyboardView);
            View viewFindViewById = this.f8264t.findViewById(R.id_renamed.closeButton);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(this);
            }
            this.f8265u.setOnKeyboardActionListener(new InterfaceC1483b() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.4
                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo7897a() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo7901b() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: IntrinsicsJvm.kt_3 */
                public void mo7903c() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: IntrinsicsJvm.kt_5 */
                public void mo7904d() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo7899a(int i2, int[] iArr) {
                    SecurityKeyboardView.this.f8162B.mo7899a(i2, iArr);
                    SecurityKeyboardView.this.m7878m();
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo7900a(CharSequence charSequence) {
                    SecurityKeyboardView.this.f8162B.mo7900a(charSequence);
                    SecurityKeyboardView.this.m7878m();
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo7898a(int i2) {
                    SecurityKeyboardView.this.f8162B.mo7898a(i2);
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.InterfaceC1483b
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo7902b(int i2) {
                    SecurityKeyboardView.this.f8162B.mo7902b(i2);
                }
            });
            if (aVar.f8328n != null) {
                c1486a = new SecurityKeyboard(getContext(), OplusGLSurfaceView_13, aVar.f8328n, -1, getPaddingRight() + getPaddingLeft());
            } else {
                c1486a = new SecurityKeyboard(getContext(), OplusGLSurfaceView_13);
            }
            this.f8265u.setKeyboard(c1486a);
            this.f8265u.setPopupParent(this);
            this.f8264t.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
            this.f8270z.put(aVar, this.f8264t);
        } else {
            this.f8265u = (SecurityKeyboardView) view.findViewById(R.id_renamed.keyboardView);
        }
        getLocationInWindow(this.f8262r);
        this.f8211ae = aVar.f8323i + getPaddingLeft();
        this.f8212af = aVar.f8324j + getPaddingTop();
        this.f8211ae = (this.f8211ae + aVar.f8319e) - this.f8264t.getMeasuredWidth();
        this.f8212af -= this.f8264t.getMeasuredHeight();
        int paddingRight = this.f8211ae + this.f8264t.getPaddingRight() + this.f8262r[0];
        int paddingBottom = this.f8212af + this.f8264t.getPaddingBottom() + this.f8262r[1];
        this.f8265u.m7883a(paddingRight < 0 ? 0 : paddingRight, paddingBottom);
        this.f8265u.setNewShifted(getNewShifted());
        this.f8263s.setContentView(this.f8264t);
        this.f8263s.setWidth(this.f8264t.getMeasuredWidth());
        this.f8263s.setHeight(this.f8264t.getMeasuredHeight());
        this.f8263s.showAtLocation(this, 0, paddingRight, paddingBottom);
        this.f8266v = true;
        m7881a();
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = this.f8191aG;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        long eventTime = motionEvent.getEventTime();
        boolean zM7853a = true;
        if (pointerCount != this.f8222ap) {
            if (pointerCount == 1) {
                MotionEvent motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                boolean zM7853a2 = m7853a(motionEventObtain, false);
                motionEventObtain.recycle();
                zM7853a = action == 1 ? m7853a(motionEvent, true) : zM7853a2;
            } else {
                MotionEvent motionEventObtain2 = MotionEvent.obtain(eventTime, eventTime, 1, this.f8223aq, this.f8224ar, motionEvent.getMetaState());
                zM7853a = m7853a(motionEventObtain2, true);
                motionEventObtain2.recycle();
            }
        } else if (pointerCount == 1) {
            zM7853a = m7853a(motionEvent, false);
            this.f8223aq = motionEvent.getX();
            this.f8224ar = motionEvent.getY();
        }
        this.f8222ap = pointerCount;
        return zM7853a;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m7853a(android.view.MotionEvent r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.m7853a(android.view.MotionEvent, boolean):boolean");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7864e(int OplusGLSurfaceView_13) {
        String string;
        AccessibilityManager accessibilityManager = this.f8191aG;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_asterisk);
        } else if (OplusGLSurfaceView_13 == 1) {
            string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_minus);
        } else if (OplusGLSurfaceView_13 == 2) {
            string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_atsymbol);
        } else {
            string = OplusGLSurfaceView_13 != 3 ? null : getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_dollar);
        }
        if (string != null) {
            announceForAccessibility(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m7874k() {
        SecurityKeyboard.PlatformImplementations.kt_3 aVar = this.f8161A[this.f8213ag];
        m7843a(this.f8182V, aVar.f8323i, aVar.f8324j, this.f8229ay);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m7886b() {
        this.f8162B.mo7901b();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m7890c() {
        this.f8162B.mo7897a();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void m7891d() {
        this.f8162B.mo7903c();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void m7892e() {
        this.f8162B.mo7904d();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m7893f() {
        if (this.f8258n.isShowing()) {
            this.f8258n.dismiss();
        }
        this.f8233bb = -1;
        m7876l();
        m7878m();
        this.f8188aD = null;
        this.f8190aF = null;
        this.f8270z.clear();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m7876l() {
        Handler handler = this.f8184a;
        if (handler != null) {
            handler.removeMessages(3);
            this.f8184a.removeMessages(4);
            this.f8184a.removeMessages(1);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7893f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m7878m() {
        if (this.f8263s.isShowing()) {
            this.f8263s.dismiss();
            this.f8266v = false;
            m7881a();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m7879n() {
        this.f8227aw = -1;
        this.f8228ax = 0;
        this.f8229ay = -1L;
        this.f8230az = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7847a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -1) {
            return;
        }
        SecurityKeyboard.PlatformImplementations.kt_3 aVar = this.f8161A[OplusGLSurfaceView_13];
        if (aVar.f8315a.length <= 1) {
            if (OplusGLSurfaceView_15 > this.f8229ay + 800 || OplusGLSurfaceView_13 != this.f8227aw) {
                m7879n();
                return;
            }
            return;
        }
        this.f8230az = true;
        if (OplusGLSurfaceView_15 < this.f8229ay + 800 && OplusGLSurfaceView_13 == this.f8227aw) {
            this.f8228ax = (this.f8228ax + 1) % aVar.f8315a.length;
        } else {
            this.f8228ax = -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7848a(Canvas canvas, int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12 = this.f8237bf;
        String[] strArr = this.f8238bg;
        float length = (COUIBaseListPopupWindow_12 - ((strArr.length - 1) * this.f8235bd)) / strArr.length;
        for (int i2 = 0; i2 < this.f8238bg.length; i2++) {
            Drawable drawableM7911d = this.f8244bm.get(i2).m7911d();
            if (drawableM7911d != null) {
                int paddingLeft = getPaddingLeft() + OplusGLSurfaceView_13;
                int i3 = this.f8236be + paddingLeft;
                float f2 = i2;
                float f3 = length * f2;
                int paddingTop = (int) (getPaddingTop() + f3 + (this.f8235bd * f2));
                float paddingTop2 = getPaddingTop() + f3 + (f2 * this.f8235bd);
                drawableM7911d.setBounds(paddingLeft, paddingTop, i3, (int) (paddingTop + length));
                drawableM7911d.draw(canvas);
                this.f8244bm.get(i2).m7909b(paddingTop2 + length);
                this.f8244bm.get(i2).m7907a(paddingTop2);
            }
        }
        for (int i4 = 0; i4 < this.f8238bg.length; i4++) {
            TextPaint textPaint = this.f8244bm.get(i4).f8282h;
            Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
            if (this.f8238bg[i4] != null) {
                canvas.drawText(this.f8238bg[i4], getPaddingLeft() + ((this.f8236be - ((int) textPaint.measureText(r4))) / 2) + OplusGLSurfaceView_13, (int) (((((getPaddingTop() + this.f8242bk) + (i4 * (this.f8235bd + length))) + (length / 2.0f)) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - fontMetricsInt.ascent), textPaint);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7845a(int OplusGLSurfaceView_13, SecurityKeyboard.PlatformImplementations.kt_3 aVar) {
        InterfaceC1484c interfaceC1484c = this.f8200aT;
        if (interfaceC1484c == null || OplusGLSurfaceView_13 == -1 || OplusGLSurfaceView_13 == -2 || OplusGLSurfaceView_13 == -6 || OplusGLSurfaceView_13 == -7) {
            return;
        }
        if (OplusGLSurfaceView_13 == 10) {
            interfaceC1484c.m7912a("", 2);
            return;
        }
        if (OplusGLSurfaceView_13 == 32) {
            interfaceC1484c.m7912a(" ", 0);
            return;
        }
        if (OplusGLSurfaceView_13 == -5) {
            interfaceC1484c.m7912a("", 1);
            return;
        }
        String string = aVar.f8316b == null ? null : m7842a(aVar.f8316b).toString();
        if (string != null) {
            this.f8200aT.m7912a(string, 0);
        }
    }

    /* renamed from: o */
    private void m7880o() {
        int length = this.f8238bg.length;
        if (length < 0) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            this.f8245bn.add(this.f8246bo.getConstantState().newDrawable());
            this.f8244bm.add(new C1482a(this.f8245bn.get(OplusGLSurfaceView_13), this.f8238bg[OplusGLSurfaceView_13]));
        }
        for (int i2 = 0; i2 < length; i2++) {
            int[][][] iArr = f8154aJ;
            int[][] iArr2 = f8155aK;
            iArr[i2] = new int[iArr2.length][];
            System.arraycopy(iArr2, 0, iArr[i2], 0, iArr2.length);
        }
        this.f8247bp.clear();
        this.f8231b.clear();
        for (int i3 = 0; i3 < length; i3++) {
            this.f8247bp.add(new int[f8156aL]);
            this.f8231b.add(new Integer(0));
            m7884a(i3, this.f8244bm.get(i3).m7911d());
            ColorStateList colorStateList = this.f8240bi;
            if (colorStateList != null) {
                this.f8244bm.get(i3).f8282h.setColor(colorStateList.getColorForState(m7888b(i3), this.f8240bi.getDefaultColor()));
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m7884a(int OplusGLSurfaceView_13, Drawable drawable) {
        this.f8231b.set(OplusGLSurfaceView_13, Integer.valueOf(this.f8231b.get(OplusGLSurfaceView_13).intValue() | 1024));
        m7887b(OplusGLSurfaceView_13, drawable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m7887b(int OplusGLSurfaceView_13, Drawable drawable) {
        int[] iArrM7888b = m7888b(OplusGLSurfaceView_13);
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(iArrM7888b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int[] m7888b(int OplusGLSurfaceView_13) {
        int iIntValue = this.f8231b.get(OplusGLSurfaceView_13).intValue();
        if ((iIntValue & 1024) != 0) {
            this.f8247bp.set(OplusGLSurfaceView_13, m7889b(OplusGLSurfaceView_13, 0));
            this.f8231b.set(OplusGLSurfaceView_13, Integer.valueOf(iIntValue & (-1025)));
        }
        return this.f8247bp.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int[] m7889b(int OplusGLSurfaceView_13, int i2) {
        int iIntValue = this.f8231b.get(OplusGLSurfaceView_13).intValue();
        int i3 = (this.f8231b.get(OplusGLSurfaceView_13).intValue() & 16384) != 0 ? 16 : 0;
        if ((iIntValue & 32) == 0) {
            i3 |= 8;
        }
        if (hasWindowFocus()) {
            i3 |= 1;
        }
        int[] iArr = f8154aJ[OplusGLSurfaceView_13][i3];
        if (i2 == 0) {
            return iArr;
        }
        if (iArr != null) {
            int[] iArr2 = new int[iArr.length + i2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return new int[i2];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7846a(int OplusGLSurfaceView_13, boolean z) {
        int iIntValue = this.f8231b.get(OplusGLSurfaceView_13).intValue();
        this.f8231b.set(OplusGLSurfaceView_13, Integer.valueOf(z ? iIntValue | 16384 : iIntValue & (-16385)));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m7860d(int OplusGLSurfaceView_13, int i2) {
        String[] strArr;
        int length;
        if (!m7895h() || (strArr = this.f8238bg) == null || (length = strArr.length) <= 0) {
            return -1;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (OplusGLSurfaceView_13 >= getPaddingLeft() && OplusGLSurfaceView_13 <= this.f8236be + getPaddingLeft()) {
                float COUIBaseListPopupWindow_12 = i2;
                if (COUIBaseListPopupWindow_12 >= this.f8244bm.get(i3).m7906a() && COUIBaseListPopupWindow_12 <= this.f8244bm.get(i3).m7908b()) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private void setItemRestore(int OplusGLSurfaceView_13) {
        m7846a(OplusGLSurfaceView_13, false);
        Drawable drawableM7911d = this.f8244bm.get(OplusGLSurfaceView_13).m7911d();
        String strM7910c = this.f8244bm.get(OplusGLSurfaceView_13).m7910c();
        m7884a(OplusGLSurfaceView_13, drawableM7911d);
        if (strM7910c == null || this.f8240bi == null) {
            return;
        }
        int[] iArrM7888b = m7888b(OplusGLSurfaceView_13);
        ColorStateList colorStateList = this.f8240bi;
        this.f8244bm.get(OplusGLSurfaceView_13).f8282h.setColor(colorStateList.getColorForState(iArrM7888b, colorStateList.getDefaultColor()));
        invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m7894g() {
        return this.f8232ba;
    }

    public void setKeyboardViewEnabled(boolean z) {
        this.f8232ba = z;
    }

    public void setOnKeyboardCharListener(InterfaceC1484c interfaceC1484c) {
        this.f8200aT = interfaceC1484c;
    }

    public void setKeyboardType(int OplusGLSurfaceView_13) {
        this.f8199aS = Typeface.DEFAULT;
        this.f8201aU = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_security_keyboard_lower_letter_text_size);
        this.f8203aW = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_security_keyboard_space_label_text_size);
        this.f8202aV = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_security_keyboard_lower_letter_text_size);
        this.f8204aX = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_security_keyboard_end_label_text_size);
        this.f8241bj = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_security_numeric_keyboard_special_text_size);
        this.f8205aY = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_password_kbd_symbols_special_symbols_textSize);
        this.f8206aZ = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_password_kbd_skip_symbols_key_labelSize);
        this.f8235bd = getResources().getDimension(coui.support.appcompat.R.dimen.coui_password_numeric_keyboard_line_width);
        this.f8238bg = getResources().getStringArray(coui.support.appcompat.R.array.coui_security_numeric_keyboard_special_symbol);
        this.f8239bh = getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.f24252x49e600ce);
        this.f8236be = getResources().getDimensionPixelSize(coui.support.appcompat.R.dimen.f24253x2133da53);
        this.f8237bf = getResources().getDimensionPixelSize(coui.support.appcompat.R.dimen.coui_security_password_numeric_special_height);
        this.f8236be = (int) (this.f8236be * SecurityKeyboard.m7920a(getContext()));
        this.f8237bf = (int) (this.f8237bf * SecurityKeyboard.m7920a(getContext()));
        this.f8235bd *= SecurityKeyboard.m7920a(getContext());
        this.f8239bh = (int) (this.f8239bh * SecurityKeyboard.m7920a(getContext()));
        m7880o();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m7895h() {
        return this.f8249e.m7941e() == 3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7844a(int OplusGLSurfaceView_13, int i2, SecurityKeyboard.PlatformImplementations.kt_3 aVar) {
        AccessibilityManager accessibilityManager = this.f8191aG;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(OplusGLSurfaceView_13);
        onInitializeAccessibilityEvent(accessibilityEventObtain);
        String string = null;
        String string2 = aVar.f8316b == null ? null : m7842a(aVar.f8316b).toString();
        if (i2 != -7) {
            if (i2 != -6) {
                if (i2 == -5) {
                    string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_delete);
                } else if (i2 != -2) {
                    if (i2 != -1) {
                        if (i2 == 10) {
                            string = getContext().getString(coui.support.appcompat.R.string.keyboardview_keycode_enter);
                        } else {
                            string = String.valueOf((char) i2);
                        }
                    } else if (getNewShifted() == 2) {
                        string = getContext().getString(coui.support.appcompat.R.string.coui_keyboard_view_keycode_low_shift);
                    } else if (getNewShifted() == 0) {
                        string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_initialcapitalization);
                    } else if (getNewShifted() == 1) {
                        string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_capslock);
                    }
                } else if (string2 != null && string2.equals("ABC")) {
                    string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_letters);
                } else if (string2 != null && string2.equals("?#+")) {
                    string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_symbol);
                }
            } else if (string2 != null && string2.equals("ABC")) {
                string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_letters);
            } else if (string2 != null && string2.equals("123")) {
                string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_number);
            }
        } else if (string2 != null && string2.equals("?#+")) {
            string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_symbol);
        } else if (string2 != null && string2.equals("$¥€")) {
            string = getContext().getString(coui.support.appcompat.R.string.coui_keyboardview_keycode_moresymbols);
        }
        if (i2 == -5 || i2 == -2 || i2 == -1 || i2 == 10 || i2 == -6 || i2 == -7) {
            announceForAccessibility(string);
            return;
        }
        if (aVar.f8329o != null) {
            announceForAccessibility(aVar.f8329o.toString());
        } else if (aVar.f8316b != null) {
            announceForAccessibility(aVar.f8316b.toString());
        } else {
            accessibilityEventObtain.getText().add(String.valueOf((char) i2));
            this.f8191aG.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m7865f(int OplusGLSurfaceView_13) {
        if (this.f8184a == null) {
            Log.IntrinsicsJvm.kt_5("SecurityKeyboardView", "handler is null");
            return false;
        }
        if (OplusGLSurfaceView_13 == -1) {
            Log.IntrinsicsJvm.kt_5("SecurityKeyboardView", "handler isn't null and keyIndex is -1");
            Handler handler = this.f8184a;
            handler.sendMessageDelayed(handler.obtainMessage(2), 75L);
            return false;
        }
        int i2 = this.f8161A[OplusGLSurfaceView_13].f8315a[0];
        if (this.f8161A[OplusGLSurfaceView_13].f8316b != null && i2 != -1 && i2 != -5 && i2 != -2 && i2 != 10 && i2 != 32 && i2 != -6 && i2 != -7) {
            return true;
        }
        Handler handler2 = this.f8184a;
        handler2.sendMessageDelayed(handler2.obtainMessage(2), 75L);
        return false;
    }

    /* renamed from: com.coui.appcompat.widget.keyboard.SecurityKeyboardView$IntrinsicsJvm.kt_5 */
    private static class C1485d {

        /* renamed from: PlatformImplementations.kt_3 */
        final float[] f8283a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final float[] f8284b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final long[] f8285c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        float f8286d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        float f8287e;

        private C1485d() {
            this.f8283a = new float[4];
            this.f8284b = new float[4];
            this.f8285c = new long[4];
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7914a() {
            this.f8285c[0] = 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7917a(MotionEvent motionEvent) {
            long eventTime = motionEvent.getEventTime();
            int historySize = motionEvent.getHistorySize();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < historySize; OplusGLSurfaceView_13++) {
                m7913a(motionEvent.getHistoricalX(OplusGLSurfaceView_13), motionEvent.getHistoricalY(OplusGLSurfaceView_13), motionEvent.getHistoricalEventTime(OplusGLSurfaceView_13));
            }
            m7913a(motionEvent.getX(), motionEvent.getY(), eventTime);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7913a(float COUIBaseListPopupWindow_12, float f2, long OplusGLSurfaceView_15) {
            long[] jArr = this.f8285c;
            int OplusGLSurfaceView_13 = -1;
            int i2 = 0;
            while (i2 < 4 && jArr[i2] != 0) {
                if (jArr[i2] < OplusGLSurfaceView_15 - 200) {
                    OplusGLSurfaceView_13 = i2;
                }
                i2++;
            }
            if (i2 == 4 && OplusGLSurfaceView_13 < 0) {
                OplusGLSurfaceView_13 = 0;
            }
            if (OplusGLSurfaceView_13 == i2) {
                OplusGLSurfaceView_13--;
            }
            float[] fArr = this.f8283a;
            float[] fArr2 = this.f8284b;
            if (OplusGLSurfaceView_13 >= 0) {
                int i3 = OplusGLSurfaceView_13 + 1;
                int i4 = (4 - OplusGLSurfaceView_13) - 1;
                System.arraycopy(fArr, i3, fArr, 0, i4);
                System.arraycopy(fArr2, i3, fArr2, 0, i4);
                System.arraycopy(jArr, i3, jArr, 0, i4);
                i2 -= i3;
            }
            fArr[i2] = COUIBaseListPopupWindow_12;
            fArr2[i2] = f2;
            jArr[i2] = OplusGLSurfaceView_15;
            int i5 = i2 + 1;
            if (i5 < 4) {
                jArr[i5] = 0;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7915a(int OplusGLSurfaceView_13) {
            m7916a(OplusGLSurfaceView_13, Float.MAX_VALUE);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7916a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
            float fMin;
            float fMin2;
            float[] fArr;
            float[] fArr2 = this.f8283a;
            float[] fArr3 = this.f8284b;
            long[] jArr = this.f8285c;
            int i2 = 0;
            float f2 = fArr2[0];
            float f3 = fArr3[0];
            long OplusGLSurfaceView_15 = jArr[0];
            while (i2 < 4 && jArr[i2] != 0) {
                i2++;
            }
            int i3 = 1;
            float f4 = 0.0f;
            float f5 = 0.0f;
            while (i3 < i2) {
                int i4 = (int) (jArr[i3] - OplusGLSurfaceView_15);
                if (i4 == 0) {
                    fArr = fArr2;
                } else {
                    float f6 = i4;
                    float f7 = (fArr2[i3] - f2) / f6;
                    fArr = fArr2;
                    float f8 = OplusGLSurfaceView_13;
                    float f9 = f7 * f8;
                    if (f4 != 0.0f) {
                        f9 = (f4 + f9) * 0.5f;
                    }
                    float f10 = ((fArr3[i3] - f3) / f6) * f8;
                    f5 = f5 == 0.0f ? f10 : (f5 + f10) * 0.5f;
                    f4 = f9;
                }
                i3++;
                fArr2 = fArr;
            }
            if (f4 < 0.0f) {
                fMin = Math.max(f4, -COUIBaseListPopupWindow_12);
            } else {
                fMin = Math.min(f4, COUIBaseListPopupWindow_12);
            }
            this.f8287e = fMin;
            if (f5 < 0.0f) {
                fMin2 = Math.max(f5, -COUIBaseListPopupWindow_12);
            } else {
                fMin2 = Math.min(f5, COUIBaseListPopupWindow_12);
            }
            this.f8286d = fMin2;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float m7918b() {
            return this.f8287e;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float m7919c() {
            return this.f8286d;
        }
    }

    /* renamed from: com.coui.appcompat.widget.keyboard.SecurityKeyboardView$PlatformImplementations.kt_3 */
    private class C1482a {

        /* renamed from: PlatformImplementations.kt_3 */
        public String f8275a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public Drawable f8276b;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f8278d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f8279e = 0;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f8280f = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f8281g = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private TextPaint f8282h = new TextPaint(1);

        public C1482a(Drawable drawable, String str) {
            this.f8275a = null;
            this.f8276b = null;
            this.f8282h.setAntiAlias(true);
            this.f8282h.setTextSize(SecurityKeyboardView.this.f8241bj);
            this.f8282h.setTypeface(SecurityKeyboardView.this.f8199aS);
            this.f8275a = str;
            this.f8276b = drawable;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public float m7906a() {
            return this.f8280f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7907a(float COUIBaseListPopupWindow_12) {
            this.f8280f = COUIBaseListPopupWindow_12;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float m7908b() {
            return this.f8281g;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7909b(float COUIBaseListPopupWindow_12) {
            this.f8281g = COUIBaseListPopupWindow_12;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String m7910c() {
            String str = this.f8275a;
            if (str != null) {
                return str;
            }
            return null;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Drawable m7911d() {
            Drawable drawable = this.f8276b;
            if (drawable != null) {
                return drawable;
            }
            return null;
        }
    }
}
