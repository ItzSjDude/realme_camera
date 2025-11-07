package com.coui.appcompat.dialog.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.coui.appcompat.p099a.COUIThemeOverlay;
import com.coui.appcompat.widget.SummaryAdapter;
import coui.support.appcompat.R;
import java.lang.ref.WeakReference;

/* compiled from: AlertController.java */
/* renamed from: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class AlertController {

    /* renamed from: A */
    boolean f6433A;

    /* renamed from: B */
    int f6434B;

    /* renamed from: C */
    private final Context f6435C;

    /* renamed from: D */
    private final int f6436D;

    /* renamed from: E */
    private View f6437E;

    /* renamed from: F */
    private int f6438F;

    /* renamed from: G */
    private int f6439G;

    /* renamed from: H */
    private int f6440H;

    /* renamed from: I */
    private int f6441I;

    /* renamed from: J */
    private int f6442J;

    /* renamed from: L */
    private Drawable f6444L;

    /* renamed from: M */
    private Drawable f6445M;

    /* renamed from: N */
    private Drawable f6446N;

    /* renamed from: P */
    private Drawable f6448P;

    /* renamed from: Q */
    private ImageView f6449Q;

    /* renamed from: R */
    private TextView f6450R;

    /* renamed from: S */
    private TextView f6451S;

    /* renamed from: T */
    private View f6452T;

    /* renamed from: U */
    private int f6453U;

    /* renamed from: V */
    private boolean f6454V;

    /* renamed from: PlatformImplementations.kt_3 */
    final AppCompatDialog f6458a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Window f6459b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    CharSequence f6460c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    CharSequence f6461d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    ListView f6462e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    Button f6463f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    CharSequence f6464g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    Message f6465h;

    /* renamed from: OplusGLSurfaceView_13 */
    Button f6466i;

    /* renamed from: OplusGLSurfaceView_15 */
    CharSequence f6467j;

    /* renamed from: OplusGLSurfaceView_5 */
    Message f6468k;

    /* renamed from: OplusGLSurfaceView_14 */
    Button f6469l;

    /* renamed from: OplusGLSurfaceView_6 */
    CharSequence f6470m;

    /* renamed from: OplusGLSurfaceView_11 */
    Message f6471n;

    /* renamed from: o */
    ScrollView f6472o;

    /* renamed from: p */
    ListAdapter f6473p;

    /* renamed from: r */
    protected int f6475r;

    /* renamed from: s */
    int f6476s;

    /* renamed from: t */
    int f6477t;

    /* renamed from: u */
    int f6478u;

    /* renamed from: v */
    int f6479v;

    /* renamed from: w */
    Handler f6480w;

    /* renamed from: y */
    boolean f6482y;

    /* renamed from: z */
    boolean f6483z;

    /* renamed from: K */
    private boolean f6443K = false;

    /* renamed from: O */
    private int f6447O = 0;

    /* renamed from: q */
    int f6474q = -1;

    /* renamed from: W */
    private int f6455W = 0;

    /* renamed from: X */
    private int f6456X = 0;

    /* renamed from: x */
    boolean f6481x = false;

    /* renamed from: Y */
    private final View.OnClickListener f6457Y = new View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            if (view == AlertController.this.f6463f && AlertController.this.f6465h != null) {
                messageObtain = Message.obtain(AlertController.this.f6465h);
            } else if (view == AlertController.this.f6466i && AlertController.this.f6468k != null) {
                messageObtain = Message.obtain(AlertController.this.f6468k);
            } else {
                messageObtain = (view != AlertController.this.f6469l || AlertController.this.f6471n == null) ? null : Message.obtain(AlertController.this.f6471n);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController.this.f6480w.obtainMessage(1, AlertController.this.f6458a).sendToTarget();
        }
    };

    /* compiled from: AlertController.java */
    /* renamed from: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static final class IntrinsicsJvm.kt_4 extends Handler {

        /* renamed from: PlatformImplementations.kt_3 */
        private WeakReference<DialogInterface> f6553a;

        public IntrinsicsJvm.kt_4(DialogInterface dialogInterface) {
            this.f6553a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == -3 || OplusGLSurfaceView_13 == -2 || OplusGLSurfaceView_13 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f6553a.get(), message.what);
            } else {
                if (OplusGLSurfaceView_13 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m6535a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, AppCompatDialog dialogC0208f, Window window) {
        this.f6435C = context;
        this.f6458a = dialogC0208f;
        this.f6459b = window;
        this.f6480w = new IntrinsicsJvm.kt_4(dialogC0208f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.COUIAlertDialog, R.attr.couiAlertDialogStyle, 0);
        this.f6475r = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIAlertDialog_android_layout, 0);
        this.f6434B = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIAlertDialog_layoutBackgroundTint, 0);
        this.f6453U = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIAlertDialog_buttonPanelSideLayout, 0);
        this.f6476s = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIAlertDialog_listLayout, 0);
        this.f6477t = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIAlertDialog_multiChoiceItemLayout, 0);
        this.f6478u = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIAlertDialog_singleChoiceItemLayout, 0);
        this.f6479v = typedArrayObtainStyledAttributes.getResourceId(R.styleable.COUIAlertDialog_listItemLayout, 0);
        this.f6454V = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIAlertDialog_showTitle, true);
        this.f6436D = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIAlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogC0208f.supportRequestWindowFeature(1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m6536a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m6536a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6538a() throws Resources.NotFoundException, ClassNotFoundException {
        int iMo6524b = mo6524b();
        COUIThemeOverlay.m6468a().m6479a(this.f6435C);
        this.f6458a.setContentView(iMo6524b);
        mo6527d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int mo6524b() {
        int OplusGLSurfaceView_13 = this.f6453U;
        if (OplusGLSurfaceView_13 == 0) {
            return this.f6475r;
        }
        return this.f6455W == 1 ? OplusGLSurfaceView_13 : this.f6475r;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6544a(CharSequence charSequence) {
        this.f6460c = charSequence;
        TextView textView = this.f6450R;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6547b(View view) {
        this.f6452T = view;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6548b(CharSequence charSequence) {
        this.f6461d = charSequence;
        TextView textView = this.f6451S;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6539a(int OplusGLSurfaceView_13) {
        this.f6437E = null;
        this.f6438F = OplusGLSurfaceView_13;
        this.f6443K = false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6552c(View view) {
        this.f6437E = view;
        this.f6438F = 0;
        this.f6443K = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6542a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f6437E = view;
        this.f6438F = 0;
        this.f6443K = true;
        this.f6439G = OplusGLSurfaceView_13;
        this.f6440H = i2;
        this.f6441I = i3;
        this.f6442J = i4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6540a(int OplusGLSurfaceView_13, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f6480w.obtainMessage(OplusGLSurfaceView_13, onClickListener);
        }
        if (OplusGLSurfaceView_13 == -3) {
            this.f6470m = charSequence;
            this.f6471n = message;
            this.f6446N = drawable;
        } else if (OplusGLSurfaceView_13 == -2) {
            this.f6467j = charSequence;
            this.f6468k = message;
            this.f6445M = drawable;
        } else {
            if (OplusGLSurfaceView_13 == -1) {
                this.f6464g = charSequence;
                this.f6465h = message;
                this.f6444L = drawable;
                return;
            }
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6546b(int OplusGLSurfaceView_13) {
        this.f6448P = null;
        this.f6447O = OplusGLSurfaceView_13;
        ImageView imageView = this.f6449Q;
        if (imageView != null) {
            if (OplusGLSurfaceView_13 != 0) {
                imageView.setVisibility(0);
                this.f6449Q.setImageResource(this.f6447O);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6541a(Drawable drawable) {
        this.f6448P = drawable;
        this.f6447O = 0;
        ImageView imageView = this.f6449Q;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.f6449Q.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m6550c(int OplusGLSurfaceView_13) {
        TypedValue typedValue = new TypedValue();
        this.f6435C.getTheme().resolveAttribute(OplusGLSurfaceView_13, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ListView m6551c() {
        return this.f6462e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Button m6553d(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -3) {
            return this.f6469l;
        }
        if (OplusGLSurfaceView_13 == -2) {
            return this.f6466i;
        }
        if (OplusGLSurfaceView_13 != -1) {
            return null;
        }
        return this.f6463f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6545a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        ScrollView scrollView = this.f6472o;
        return scrollView != null && scrollView.executeKeyEvent(keyEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m6549b(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        ScrollView scrollView = this.f6472o;
        return scrollView != null && scrollView.executeKeyEvent(keyEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ViewGroup m6531a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo6527d() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f6459b.findViewById(R.id_renamed.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(R.id_renamed.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(R.id_renamed.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(R.id_renamed.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R.id_renamed.customPanel);
        m6537d(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(R.id_renamed.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id_renamed.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(R.id_renamed.buttonPanel);
        ViewGroup viewGroupM6531a = m6531a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM6531a2 = m6531a(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupM6531a3 = m6531a(viewFindViewById9, viewFindViewById6);
        mo6525b(viewGroupM6531a2);
        mo6526c(viewGroupM6531a3);
        m6543a(viewGroupM6531a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupM6531a == null || viewGroupM6531a.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupM6531a3 == null || viewGroupM6531a3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupM6531a2 != null && (viewFindViewById2 = viewGroupM6531a2.findViewById(R.id_renamed.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            ScrollView scrollView = this.f6472o;
            if (scrollView != null) {
                scrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f6461d == null && this.f6462e == null) ? null : viewGroupM6531a.findViewById(R.id_renamed.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupM6531a2 != null && (viewFindViewById = viewGroupM6531a2.findViewById(R.id_renamed.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f6462e;
        if (listView instanceof IntrinsicsJvm.kt_5) {
            ((IntrinsicsJvm.kt_5) listView).m6558a(z2, z3);
        }
        if (!z) {
            View view = this.f6462e;
            if (view == null) {
                view = this.f6472o;
            }
            if (view != null) {
                m6533a(viewGroupM6531a2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f6462e;
        if (listView2 == null || (listAdapter = this.f6473p) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int OplusGLSurfaceView_13 = this.f6474q;
        if (OplusGLSurfaceView_13 > -1) {
            listView2.setItemChecked(OplusGLSurfaceView_13, true);
            listView2.setSelection(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6533a(ViewGroup viewGroup, View view, int OplusGLSurfaceView_13, int i2) {
        final View viewFindViewById = this.f6459b.findViewById(R.id_renamed.scrollIndicatorUp);
        final View viewFindViewById2 = this.f6459b.findViewById(R.id_renamed.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (OplusGLSurfaceView_13 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (OplusGLSurfaceView_13 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f6461d != null) {
            this.f6472o.post(new Runnable() { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.2
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.m6532a(AlertController.this.f6472o, viewFindViewById, viewFindViewById2);
                }
            });
            return;
        }
        ListView listView = this.f6462e;
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i3) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                    AlertController.m6532a(absListView, viewFindViewById, viewFindViewById2);
                }
            });
            this.f6462e.post(new Runnable() { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.4
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.m6532a(AlertController.this.f6462e, viewFindViewById, viewFindViewById2);
                }
            });
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6537d(ViewGroup viewGroup) {
        View viewInflate = this.f6437E;
        if (viewInflate == null) {
            viewInflate = this.f6438F != 0 ? LayoutInflater.from(this.f6435C).inflate(this.f6438F, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !m6536a(viewInflate)) {
            this.f6459b.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f6459b.findViewById(R.id_renamed.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f6443K) {
                frameLayout.setPadding(this.f6439G, this.f6440H, this.f6441I, this.f6442J);
            }
            if (this.f6462e != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m6543a(ViewGroup viewGroup) {
        if (this.f6452T != null) {
            viewGroup.addView(this.f6452T, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f6459b.findViewById(R.id_renamed.title_template).setVisibility(8);
            return;
        }
        this.f6449Q = (ImageView) this.f6459b.findViewById(android.R.id_renamed.icon);
        if ((!TextUtils.isEmpty(this.f6460c)) && this.f6454V) {
            this.f6450R = (TextView) this.f6459b.findViewById(R.id_renamed.alertTitle);
            this.f6450R.setText(this.f6460c);
            int OplusGLSurfaceView_13 = this.f6447O;
            if (OplusGLSurfaceView_13 != 0) {
                this.f6449Q.setImageResource(OplusGLSurfaceView_13);
                return;
            }
            Drawable drawable = this.f6448P;
            if (drawable != null) {
                this.f6449Q.setImageDrawable(drawable);
                return;
            } else {
                this.f6450R.setPadding(this.f6449Q.getPaddingLeft(), this.f6449Q.getPaddingTop(), this.f6449Q.getPaddingRight(), this.f6449Q.getPaddingBottom());
                this.f6449Q.setVisibility(8);
                return;
            }
        }
        this.f6459b.findViewById(R.id_renamed.title_template).setVisibility(8);
        this.f6449Q.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo6525b(ViewGroup viewGroup) {
        this.f6472o = (ScrollView) this.f6459b.findViewById(R.id_renamed.scrollView);
        this.f6472o.setFocusable(false);
        this.f6472o.setNestedScrollingEnabled(false);
        this.f6451S = (TextView) viewGroup.findViewById(android.R.id_renamed.message);
        TextView textView = this.f6451S;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f6461d;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f6472o.removeView(this.f6451S);
        if (this.f6462e != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f6472o.getParent();
            int iIndexOfChild = viewGroup2.indexOfChild(this.f6472o);
            viewGroup2.removeViewAt(iIndexOfChild);
            viewGroup2.addView(this.f6462e, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m6532a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo6526c(ViewGroup viewGroup) {
        int OplusGLSurfaceView_13;
        this.f6463f = (Button) viewGroup.findViewById(android.R.id_renamed.button1);
        this.f6463f.setOnClickListener(this.f6457Y);
        if (TextUtils.isEmpty(this.f6464g) && this.f6444L == null) {
            this.f6463f.setVisibility(8);
            OplusGLSurfaceView_13 = 0;
        } else {
            this.f6463f.setText(this.f6464g);
            Drawable drawable = this.f6444L;
            if (drawable != null) {
                int i2 = this.f6436D;
                drawable.setBounds(0, 0, i2, i2);
                this.f6463f.setCompoundDrawables(this.f6444L, null, null, null);
            }
            this.f6463f.setVisibility(0);
            OplusGLSurfaceView_13 = 1;
        }
        this.f6466i = (Button) viewGroup.findViewById(android.R.id_renamed.button2);
        this.f6466i.setOnClickListener(this.f6457Y);
        if (TextUtils.isEmpty(this.f6467j) && this.f6445M == null) {
            this.f6466i.setVisibility(8);
        } else {
            this.f6466i.setText(this.f6467j);
            Drawable drawable2 = this.f6445M;
            if (drawable2 != null) {
                int i3 = this.f6436D;
                drawable2.setBounds(0, 0, i3, i3);
                this.f6466i.setCompoundDrawables(this.f6445M, null, null, null);
            }
            this.f6466i.setVisibility(0);
            OplusGLSurfaceView_13 |= 2;
        }
        this.f6469l = (Button) viewGroup.findViewById(android.R.id_renamed.button3);
        this.f6469l.setOnClickListener(this.f6457Y);
        if (TextUtils.isEmpty(this.f6470m) && this.f6446N == null) {
            this.f6469l.setVisibility(8);
        } else {
            this.f6469l.setText(this.f6470m);
            Drawable drawable3 = this.f6444L;
            if (drawable3 != null) {
                int i4 = this.f6436D;
                drawable3.setBounds(0, 0, i4, i4);
                this.f6463f.setCompoundDrawables(this.f6444L, null, null, null);
            }
            this.f6469l.setVisibility(0);
            OplusGLSurfaceView_13 |= 4;
        }
        if (m6535a(this.f6435C)) {
            if (OplusGLSurfaceView_13 == 1) {
                m6534a(this.f6463f);
            } else if (OplusGLSurfaceView_13 == 2) {
                m6534a(this.f6466i);
            } else if (OplusGLSurfaceView_13 == 4) {
                m6534a(this.f6469l);
            }
        }
        if (OplusGLSurfaceView_13 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6534a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m6554e() {
        return this.f6456X;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6555e(int OplusGLSurfaceView_13) {
        this.f6456X = OplusGLSurfaceView_13;
    }

    /* compiled from: AlertController.java */
    /* renamed from: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 extends ListView {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int f6560a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f6561b;

        public IntrinsicsJvm.kt_5(Context context) {
            this(context, null);
        }

        public IntrinsicsJvm.kt_5(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f6561b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f6560a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m6558a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f6560a, getPaddingRight(), z2 ? getPaddingBottom() : this.f6561b);
        }
    }

    /* compiled from: AlertController.java */
    /* renamed from: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: A */
        public DialogInterface.OnClickListener f6494A;

        /* renamed from: B */
        public int f6495B;

        /* renamed from: C */
        public View f6496C;

        /* renamed from: D */
        public int f6497D;

        /* renamed from: E */
        public int f6498E;

        /* renamed from: F */
        public int f6499F;

        /* renamed from: G */
        public int f6500G;

        /* renamed from: I */
        public boolean[] f6502I;

        /* renamed from: J */
        public boolean f6503J;

        /* renamed from: K */
        public boolean f6504K;

        /* renamed from: M */
        public DialogInterface.OnMultiChoiceClickListener f6506M;

        /* renamed from: N */
        public Cursor f6507N;

        /* renamed from: O */
        public String f6508O;

        /* renamed from: P */
        public String f6509P;

        /* renamed from: Q */
        public boolean f6510Q;

        /* renamed from: R */
        public AdapterView.OnItemSelectedListener f6511R;

        /* renamed from: S */
        public AlertController_5 f6512S;

        /* renamed from: U */
        public int f6514U;

        /* renamed from: PlatformImplementations.kt_3 */
        public final Context f6515a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final LayoutInflater f6516b;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Drawable f6518d;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public CharSequence f6520f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public View f6521g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public CharSequence f6522h;

        /* renamed from: OplusGLSurfaceView_13 */
        public CharSequence f6523i;

        /* renamed from: OplusGLSurfaceView_15 */
        public Drawable f6524j;

        /* renamed from: OplusGLSurfaceView_5 */
        public DialogInterface.OnClickListener f6525k;

        /* renamed from: OplusGLSurfaceView_14 */
        public CharSequence f6526l;

        /* renamed from: OplusGLSurfaceView_6 */
        public Drawable f6527m;

        /* renamed from: OplusGLSurfaceView_11 */
        public DialogInterface.OnClickListener f6528n;

        /* renamed from: o */
        public CharSequence f6529o;

        /* renamed from: p */
        public Drawable f6530p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f6531q;

        /* renamed from: s */
        public boolean f6533s;

        /* renamed from: t */
        public DialogInterface.OnCancelListener f6534t;

        /* renamed from: u */
        public DialogInterface.OnDismissListener f6535u;

        /* renamed from: v */
        public DialogInterface.OnKeyListener f6536v;

        /* renamed from: w */
        public CharSequence[] f6537w;

        /* renamed from: x */
        public CharSequence[] f6538x;

        /* renamed from: y */
        public boolean f6539y;

        /* renamed from: z */
        public ListAdapter f6540z;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f6517c = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f6519e = 0;

        /* renamed from: H */
        public boolean f6501H = false;

        /* renamed from: L */
        public int f6505L = -1;

        /* renamed from: T */
        public boolean f6513T = true;

        /* renamed from: r */
        public boolean f6532r = true;

        /* compiled from: AlertController.java */
        /* renamed from: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        public interface AlertController_5 {
            /* renamed from: PlatformImplementations.kt_3 */
            void m6557a(ListView listView);
        }

        public PlatformImplementations.kt_3(Context context) {
            this.f6515a = context;
            this.f6516b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6530a(AlertController c1288a) {
            View view = this.f6521g;
            if (view != null) {
                c1288a.m6547b(view);
            } else {
                CharSequence charSequence = this.f6520f;
                if (charSequence != null) {
                    c1288a.m6544a(charSequence);
                }
                Drawable drawable = this.f6518d;
                if (drawable != null) {
                    c1288a.m6541a(drawable);
                }
                int OplusGLSurfaceView_13 = this.f6517c;
                if (OplusGLSurfaceView_13 != 0) {
                    c1288a.m6546b(OplusGLSurfaceView_13);
                }
                int i2 = this.f6519e;
                if (i2 != 0) {
                    c1288a.m6546b(c1288a.m6550c(i2));
                }
            }
            c1288a.f6481x = this.f6539y;
            CharSequence charSequence2 = this.f6522h;
            if (charSequence2 != null) {
                c1288a.m6548b(charSequence2);
            }
            if (this.f6523i != null || this.f6524j != null) {
                c1288a.m6540a(-1, this.f6523i, this.f6525k, (Message) null, this.f6524j);
            }
            if (this.f6526l != null || this.f6527m != null) {
                c1288a.m6540a(-2, this.f6526l, this.f6528n, (Message) null, this.f6527m);
            }
            if (this.f6529o != null || this.f6530p != null) {
                c1288a.m6540a(-3, this.f6529o, this.f6531q, (Message) null, this.f6530p);
            }
            if (this.f6537w != null || this.f6507N != null || this.f6540z != null) {
                m6556b(c1288a);
            }
            View view2 = this.f6496C;
            if (view2 != null) {
                if (this.f6501H) {
                    c1288a.m6542a(view2, this.f6497D, this.f6498E, this.f6499F, this.f6500G);
                } else {
                    c1288a.m6552c(view2);
                }
            } else {
                int i3 = this.f6495B;
                if (i3 != 0) {
                    c1288a.m6539a(i3);
                }
            }
            c1288a.m6555e(this.f6514U);
            c1288a.f6482y = this.f6504K;
            c1288a.f6483z = this.f6503J;
            c1288a.f6433A = this.f6533s;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m6556b(final AlertController c1288a) {
            ListAdapter c1532z;
            final IntrinsicsJvm.kt_5 dVar = (IntrinsicsJvm.kt_5) this.f6516b.inflate(c1288a.f6476s, (ViewGroup) null);
            if (this.f6503J) {
                Cursor cursor = this.f6507N;
                if (cursor == null) {
                    c1532z = new ArrayAdapter<CharSequence>(this.f6515a, c1288a.f6477t, android.R.id_renamed.text1, this.f6537w) { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(OplusGLSurfaceView_13, view, viewGroup);
                            if (PlatformImplementations.kt_3.this.f6502I != null && PlatformImplementations.kt_3.this.f6502I[OplusGLSurfaceView_13]) {
                                dVar.setItemChecked(OplusGLSurfaceView_13, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    c1532z = new CursorAdapter(this.f6515a, cursor, false) { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.PlatformImplementations.kt_3.2

                        /* renamed from: IntrinsicsJvm.kt_5 */
                        private final int f6546d;

                        /* renamed from: COUIBaseListPopupWindow_8 */
                        private final int f6547e;

                        {
                            Cursor cursor2 = getCursor();
                            this.f6546d = cursor2.getColumnIndexOrThrow(PlatformImplementations.kt_3.this.f6508O);
                            this.f6547e = cursor2.getColumnIndexOrThrow(PlatformImplementations.kt_3.this.f6509P);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor2) {
                            ((CheckedTextView) view.findViewById(android.R.id_renamed.text1)).setText(cursor2.getString(this.f6546d));
                            dVar.setItemChecked(cursor2.getPosition(), cursor2.getInt(this.f6547e) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor2, ViewGroup viewGroup) {
                            return PlatformImplementations.kt_3.this.f6516b.inflate(c1288a.f6477t, viewGroup, false);
                        }
                    };
                }
            } else if (this.f6504K) {
                int OplusGLSurfaceView_13 = c1288a.f6478u;
                Cursor cursor2 = this.f6507N;
                if (cursor2 != null) {
                    c1532z = new SimpleCursorAdapter(this.f6515a, OplusGLSurfaceView_13, cursor2, new String[]{this.f6508O}, new int[]{android.R.id_renamed.text1});
                } else {
                    ListAdapter cVar = this.f6540z;
                    if (cVar == null) {
                        cVar = new IntrinsicsJvm.kt_3(this.f6515a, OplusGLSurfaceView_13, android.R.id_renamed.text1, this.f6537w);
                    }
                    c1532z = cVar;
                }
            } else {
                c1532z = this.f6540z;
                if (c1532z == null) {
                    c1532z = new SummaryAdapter(this.f6515a, !TextUtils.isEmpty(this.f6520f), !TextUtils.isEmpty(this.f6522h), this.f6537w, this.f6538x);
                }
            }
            AlertController_5 interfaceC4117a = this.f6512S;
            if (interfaceC4117a != null) {
                interfaceC4117a.m6557a(dVar);
            }
            c1288a.f6473p = c1532z;
            c1288a.f6474q = this.f6505L;
            if (this.f6494A != null) {
                dVar.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.PlatformImplementations.kt_3.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                        PlatformImplementations.kt_3.this.f6494A.onClick(c1288a.f6458a, i2);
                        if (PlatformImplementations.kt_3.this.f6504K) {
                            return;
                        }
                        c1288a.f6458a.dismiss();
                    }
                });
            } else if (this.f6506M != null) {
                dVar.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3.PlatformImplementations.kt_3.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                        if (PlatformImplementations.kt_3.this.f6502I != null) {
                            PlatformImplementations.kt_3.this.f6502I[i2] = dVar.isItemChecked(i2);
                        }
                        PlatformImplementations.kt_3.this.f6506M.onClick(c1288a.f6458a, i2, dVar.isItemChecked(i2));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f6511R;
            if (onItemSelectedListener != null) {
                dVar.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f6504K) {
                dVar.setSelector(R.drawable.coui_alert_dialog_item_background);
                dVar.setItemsCanFocus(false);
                dVar.setChoiceMode(1);
            } else if (this.f6503J) {
                dVar.setSelector(R.drawable.coui_alert_dialog_item_background);
                dVar.setItemsCanFocus(false);
                dVar.setChoiceMode(2);
            }
            c1288a.f6462e = dVar;
        }
    }

    /* compiled from: AlertController.java */
    /* renamed from: com.coui.appcompat.dialog.app.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3 extends ArrayAdapter<CharSequence> {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f6554a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f6555b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f6556c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f6557d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f6558e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f6559f;

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public IntrinsicsJvm.kt_3(Context context, int OplusGLSurfaceView_13, int i2, CharSequence[] charSequenceArr) {
            super(context, OplusGLSurfaceView_13, i2, charSequenceArr);
            this.f6554a = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_left);
            this.f6555b = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_right);
            this.f6557d = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_vertical);
            this.f6558e = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_item_padding_offset);
            this.f6556c = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_vertical);
            this.f6559f = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_list_item_min_height);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            View view2 = super.getView(OplusGLSurfaceView_13, view, viewGroup);
            view2.setMinimumHeight(this.f6559f);
            view2.setPaddingRelative(this.f6554a, this.f6556c, this.f6555b, this.f6557d);
            return view2;
        }
    }
}
