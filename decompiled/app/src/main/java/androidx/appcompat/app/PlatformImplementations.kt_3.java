package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {

    /* renamed from: A */
    private int f790A;

    /* renamed from: C */
    private CharSequence f792C;

    /* renamed from: D */
    private Drawable f793D;

    /* renamed from: E */
    private CharSequence f794E;

    /* renamed from: F */
    private Drawable f795F;

    /* renamed from: G */
    private CharSequence f796G;

    /* renamed from: H */
    private Drawable f797H;

    /* renamed from: J */
    private Drawable f799J;

    /* renamed from: K */
    private ImageView f800K;

    /* renamed from: L */
    private TextView f801L;

    /* renamed from: M */
    private TextView f802M;

    /* renamed from: N */
    private View f803N;

    /* renamed from: O */
    private int f804O;

    /* renamed from: P */
    private int f805P;

    /* renamed from: Q */
    private boolean f806Q;

    /* renamed from: PlatformImplementations.kt_3 */
    final AppCompatDialog f809a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ListView f810b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Button f811c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    Message f812d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    Button f813e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    Message f814f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    Button f815g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    Message f816h;

    /* renamed from: OplusGLSurfaceView_13 */
    NestedScrollView f817i;

    /* renamed from: OplusGLSurfaceView_15 */
    ListAdapter f818j;

    /* renamed from: OplusGLSurfaceView_14 */
    int f820l;

    /* renamed from: OplusGLSurfaceView_6 */
    int f821m;

    /* renamed from: OplusGLSurfaceView_11 */
    int f822n;

    /* renamed from: o */
    int f823o;

    /* renamed from: p */
    Handler f824p;

    /* renamed from: q */
    private final Context f825q;

    /* renamed from: r */
    private final Window f826r;

    /* renamed from: s */
    private final int f827s;

    /* renamed from: t */
    private CharSequence f828t;

    /* renamed from: u */
    private CharSequence f829u;

    /* renamed from: v */
    private View f830v;

    /* renamed from: w */
    private int f831w;

    /* renamed from: x */
    private int f832x;

    /* renamed from: y */
    private int f833y;

    /* renamed from: z */
    private int f834z;

    /* renamed from: B */
    private boolean f791B = false;

    /* renamed from: I */
    private int f798I = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    int f819k = -1;

    /* renamed from: R */
    private int f807R = 0;

    /* renamed from: S */
    private final View.OnClickListener f808S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            if (view == AlertController.this.f811c && AlertController.this.f812d != null) {
                messageObtain = Message.obtain(AlertController.this.f812d);
            } else if (view == AlertController.this.f813e && AlertController.this.f814f != null) {
                messageObtain = Message.obtain(AlertController.this.f814f);
            } else {
                messageObtain = (view != AlertController.this.f815g || AlertController.this.f816h == null) ? null : Message.obtain(AlertController.this.f816h);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController.this.f824p.obtainMessage(1, AlertController.this.f809a).sendToTarget();
        }
    };

    /* renamed from: androidx.appcompat.app.AlertController$IntrinsicsJvm.kt_4 */
    private static final class HandlerC0184b extends Handler {

        /* renamed from: PlatformImplementations.kt_3 */
        private WeakReference<DialogInterface> f905a;

        public HandlerC0184b(DialogInterface dialogInterface) {
            this.f905a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == -3 || OplusGLSurfaceView_13 == -2 || OplusGLSurfaceView_13 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f905a.get(), message.what);
            } else {
                if (OplusGLSurfaceView_13 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m741a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, AppCompatDialog dialogC0208f, Window window) {
        this.f825q = context;
        this.f809a = dialogC0208f;
        this.f826r = window;
        this.f824p = new HandlerC0184b(dialogC0208f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f804O = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.f805P = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f820l = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f821m = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f822n = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f823o = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.f806Q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f827s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogC0208f.supportRequestWindowFeature(1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m742a(View view) {
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
            if (m742a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m748a() {
        this.f809a.setContentView(m744c());
        m746d();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m744c() {
        int OplusGLSurfaceView_13 = this.f805P;
        if (OplusGLSurfaceView_13 == 0) {
            return this.f804O;
        }
        return this.f807R == 1 ? OplusGLSurfaceView_13 : this.f804O;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m753a(CharSequence charSequence) {
        this.f828t = charSequence;
        TextView textView = this.f801L;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m757b(View view) {
        this.f803N = view;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m758b(CharSequence charSequence) {
        this.f829u = charSequence;
        TextView textView = this.f802M;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m749a(int OplusGLSurfaceView_13) {
        this.f830v = null;
        this.f831w = OplusGLSurfaceView_13;
        this.f791B = false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m761c(View view) {
        this.f830v = view;
        this.f831w = 0;
        this.f791B = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m752a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f830v = view;
        this.f831w = 0;
        this.f791B = true;
        this.f832x = OplusGLSurfaceView_13;
        this.f833y = i2;
        this.f834z = i3;
        this.f790A = i4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m750a(int OplusGLSurfaceView_13, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f824p.obtainMessage(OplusGLSurfaceView_13, onClickListener);
        }
        if (OplusGLSurfaceView_13 == -3) {
            this.f796G = charSequence;
            this.f816h = message;
            this.f797H = drawable;
        } else if (OplusGLSurfaceView_13 == -2) {
            this.f794E = charSequence;
            this.f814f = message;
            this.f795F = drawable;
        } else {
            if (OplusGLSurfaceView_13 == -1) {
                this.f792C = charSequence;
                this.f812d = message;
                this.f793D = drawable;
                return;
            }
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m756b(int OplusGLSurfaceView_13) {
        this.f799J = null;
        this.f798I = OplusGLSurfaceView_13;
        ImageView imageView = this.f800K;
        if (imageView != null) {
            if (OplusGLSurfaceView_13 != 0) {
                imageView.setVisibility(0);
                this.f800K.setImageResource(this.f798I);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m751a(Drawable drawable) {
        this.f799J = drawable;
        this.f798I = 0;
        ImageView imageView = this.f800K;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.f800K.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m760c(int OplusGLSurfaceView_13) {
        TypedValue typedValue = new TypedValue();
        this.f825q.getTheme().resolveAttribute(OplusGLSurfaceView_13, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ListView m755b() {
        return this.f810b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Button m762d(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -3) {
            return this.f815g;
        }
        if (OplusGLSurfaceView_13 == -2) {
            return this.f813e;
        }
        if (OplusGLSurfaceView_13 != -1) {
            return null;
        }
        return this.f811c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m754a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f817i;
        return nestedScrollView != null && nestedScrollView.m2986a(keyEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m759b(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f817i;
        return nestedScrollView != null && nestedScrollView.m2986a(keyEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ViewGroup m736a(View view, View view2) {
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
    private void m746d() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f826r.findViewById(R.id_renamed.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(R.id_renamed.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(R.id_renamed.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(R.id_renamed.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R.id_renamed.customPanel);
        m738a(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(R.id_renamed.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id_renamed.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(R.id_renamed.buttonPanel);
        ViewGroup viewGroupM736a = m736a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM736a2 = m736a(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupM736a3 = m736a(viewFindViewById9, viewFindViewById6);
        m745c(viewGroupM736a2);
        m747d(viewGroupM736a3);
        m743b(viewGroupM736a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupM736a == null || viewGroupM736a.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupM736a3 == null || viewGroupM736a3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupM736a2 != null && (viewFindViewById2 = viewGroupM736a2.findViewById(R.id_renamed.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.f817i;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f829u == null && this.f810b == null) ? null : viewGroupM736a.findViewById(R.id_renamed.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupM736a2 != null && (viewFindViewById = viewGroupM736a2.findViewById(R.id_renamed.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f810b;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).m764a(z2, z3);
        }
        if (!z) {
            View view = this.f810b;
            if (view == null) {
                view = this.f817i;
            }
            if (view != null) {
                m739a(viewGroupM736a2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f810b;
        if (listView2 == null || (listAdapter = this.f818j) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int OplusGLSurfaceView_13 = this.f819k;
        if (OplusGLSurfaceView_13 > -1) {
            listView2.setItemChecked(OplusGLSurfaceView_13, true);
            listView2.setSelection(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m739a(ViewGroup viewGroup, View view, int OplusGLSurfaceView_13, int i2) {
        final View viewFindViewById = this.f826r.findViewById(R.id_renamed.scrollIndicatorUp);
        View viewFindViewById2 = this.f826r.findViewById(R.id_renamed.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.m2843a(view, OplusGLSurfaceView_13, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (viewFindViewById != null && (OplusGLSurfaceView_13 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 == null || (OplusGLSurfaceView_13 & 2) != 0) {
            view2 = viewFindViewById2;
        } else {
            viewGroup.removeView(viewFindViewById2);
        }
        if (viewFindViewById == null && view2 == null) {
            return;
        }
        if (this.f829u != null) {
            this.f817i.setOnScrollChangeListener(new NestedScrollView.InterfaceC0520b() { // from class: androidx.appcompat.app.AlertController.2
                @Override // androidx.core.widget.NestedScrollView.InterfaceC0520b
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo763a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    AlertController.m737a(nestedScrollView, viewFindViewById, view2);
                }
            });
            this.f817i.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.m737a(AlertController.this.f817i, viewFindViewById, view2);
                }
            });
            return;
        }
        ListView listView = this.f810b;
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i3) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                    AlertController.m737a(absListView, viewFindViewById, view2);
                }
            });
            this.f810b.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.m737a(AlertController.this.f810b, viewFindViewById, view2);
                }
            });
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m738a(ViewGroup viewGroup) {
        View viewInflate = this.f830v;
        if (viewInflate == null) {
            viewInflate = this.f831w != 0 ? LayoutInflater.from(this.f825q).inflate(this.f831w, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !m742a(viewInflate)) {
            this.f826r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f826r.findViewById(R.id_renamed.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f791B) {
                frameLayout.setPadding(this.f832x, this.f833y, this.f834z, this.f790A);
            }
            if (this.f810b != null) {
                ((LinearLayoutCompat.C0277a) viewGroup.getLayoutParams()).f1616g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m743b(ViewGroup viewGroup) {
        if (this.f803N != null) {
            viewGroup.addView(this.f803N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f826r.findViewById(R.id_renamed.title_template).setVisibility(8);
            return;
        }
        this.f800K = (ImageView) this.f826r.findViewById(android.R.id_renamed.icon);
        if ((!TextUtils.isEmpty(this.f828t)) && this.f806Q) {
            this.f801L = (TextView) this.f826r.findViewById(R.id_renamed.alertTitle);
            this.f801L.setText(this.f828t);
            int OplusGLSurfaceView_13 = this.f798I;
            if (OplusGLSurfaceView_13 != 0) {
                this.f800K.setImageResource(OplusGLSurfaceView_13);
                return;
            }
            Drawable drawable = this.f799J;
            if (drawable != null) {
                this.f800K.setImageDrawable(drawable);
                return;
            } else {
                this.f801L.setPadding(this.f800K.getPaddingLeft(), this.f800K.getPaddingTop(), this.f800K.getPaddingRight(), this.f800K.getPaddingBottom());
                this.f800K.setVisibility(8);
                return;
            }
        }
        this.f826r.findViewById(R.id_renamed.title_template).setVisibility(8);
        this.f800K.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m745c(ViewGroup viewGroup) {
        this.f817i = (NestedScrollView) this.f826r.findViewById(R.id_renamed.scrollView);
        this.f817i.setFocusable(false);
        this.f817i.setNestedScrollingEnabled(false);
        this.f802M = (TextView) viewGroup.findViewById(android.R.id_renamed.message);
        TextView textView = this.f802M;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f829u;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f817i.removeView(this.f802M);
        if (this.f810b != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f817i.getParent();
            int iIndexOfChild = viewGroup2.indexOfChild(this.f817i);
            viewGroup2.removeViewAt(iIndexOfChild);
            viewGroup2.addView(this.f810b, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m737a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m747d(ViewGroup viewGroup) {
        int OplusGLSurfaceView_13;
        this.f811c = (Button) viewGroup.findViewById(android.R.id_renamed.button1);
        this.f811c.setOnClickListener(this.f808S);
        if (TextUtils.isEmpty(this.f792C) && this.f793D == null) {
            this.f811c.setVisibility(8);
            OplusGLSurfaceView_13 = 0;
        } else {
            this.f811c.setText(this.f792C);
            Drawable drawable = this.f793D;
            if (drawable != null) {
                int i2 = this.f827s;
                drawable.setBounds(0, 0, i2, i2);
                this.f811c.setCompoundDrawables(this.f793D, null, null, null);
            }
            this.f811c.setVisibility(0);
            OplusGLSurfaceView_13 = 1;
        }
        this.f813e = (Button) viewGroup.findViewById(android.R.id_renamed.button2);
        this.f813e.setOnClickListener(this.f808S);
        if (TextUtils.isEmpty(this.f794E) && this.f795F == null) {
            this.f813e.setVisibility(8);
        } else {
            this.f813e.setText(this.f794E);
            Drawable drawable2 = this.f795F;
            if (drawable2 != null) {
                int i3 = this.f827s;
                drawable2.setBounds(0, 0, i3, i3);
                this.f813e.setCompoundDrawables(this.f795F, null, null, null);
            }
            this.f813e.setVisibility(0);
            OplusGLSurfaceView_13 |= 2;
        }
        this.f815g = (Button) viewGroup.findViewById(android.R.id_renamed.button3);
        this.f815g.setOnClickListener(this.f808S);
        if (TextUtils.isEmpty(this.f796G) && this.f797H == null) {
            this.f815g.setVisibility(8);
        } else {
            this.f815g.setText(this.f796G);
            Drawable drawable3 = this.f793D;
            if (drawable3 != null) {
                int i4 = this.f827s;
                drawable3.setBounds(0, 0, i4, i4);
                this.f811c.setCompoundDrawables(this.f793D, null, null, null);
            }
            this.f815g.setVisibility(0);
            OplusGLSurfaceView_13 |= 4;
        }
        if (m741a(this.f825q)) {
            if (OplusGLSurfaceView_13 == 1) {
                m740a(this.f811c);
            } else if (OplusGLSurfaceView_13 == 2) {
                m740a(this.f813e);
            } else if (OplusGLSurfaceView_13 == 4) {
                m740a(this.f815g);
            }
        }
        if (OplusGLSurfaceView_13 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m740a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int f848a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f849b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f849b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f848a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m764a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f848a, getPaddingRight(), z2 ? getPaddingBottom() : this.f849b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$PlatformImplementations.kt_3 */
    public static class C0183a {

        /* renamed from: A */
        public int f850A;

        /* renamed from: B */
        public int f851B;

        /* renamed from: C */
        public int f852C;

        /* renamed from: D */
        public int f853D;

        /* renamed from: F */
        public boolean[] f855F;

        /* renamed from: G */
        public boolean f856G;

        /* renamed from: H */
        public boolean f857H;

        /* renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f859J;

        /* renamed from: K */
        public Cursor f860K;

        /* renamed from: L */
        public String f861L;

        /* renamed from: M */
        public String f862M;

        /* renamed from: N */
        public boolean f863N;

        /* renamed from: O */
        public AdapterView.OnItemSelectedListener f864O;

        /* renamed from: P */
        public PlatformImplementations.kt_3 f865P;

        /* renamed from: PlatformImplementations.kt_3 */
        public final Context f867a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final LayoutInflater f868b;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Drawable f870d;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public CharSequence f872f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public View f873g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public CharSequence f874h;

        /* renamed from: OplusGLSurfaceView_13 */
        public CharSequence f875i;

        /* renamed from: OplusGLSurfaceView_15 */
        public Drawable f876j;

        /* renamed from: OplusGLSurfaceView_5 */
        public DialogInterface.OnClickListener f877k;

        /* renamed from: OplusGLSurfaceView_14 */
        public CharSequence f878l;

        /* renamed from: OplusGLSurfaceView_6 */
        public Drawable f879m;

        /* renamed from: OplusGLSurfaceView_11 */
        public DialogInterface.OnClickListener f880n;

        /* renamed from: o */
        public CharSequence f881o;

        /* renamed from: p */
        public Drawable f882p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f883q;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f885s;

        /* renamed from: t */
        public DialogInterface.OnDismissListener f886t;

        /* renamed from: u */
        public DialogInterface.OnKeyListener f887u;

        /* renamed from: v */
        public CharSequence[] f888v;

        /* renamed from: w */
        public ListAdapter f889w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f890x;

        /* renamed from: y */
        public int f891y;

        /* renamed from: z */
        public View f892z;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f869c = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f871e = 0;

        /* renamed from: E */
        public boolean f854E = false;

        /* renamed from: I */
        public int f858I = -1;

        /* renamed from: Q */
        public boolean f866Q = true;

        /* renamed from: r */
        public boolean f884r = true;

        /* renamed from: androidx.appcompat.app.AlertController$PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
        public interface PlatformImplementations.kt_3 {
            /* renamed from: PlatformImplementations.kt_3 */
            void m767a(ListView listView);
        }

        public C0183a(Context context) {
            this.f867a = context;
            this.f868b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m766a(AlertController alertController) {
            View view = this.f873g;
            if (view != null) {
                alertController.m757b(view);
            } else {
                CharSequence charSequence = this.f872f;
                if (charSequence != null) {
                    alertController.m753a(charSequence);
                }
                Drawable drawable = this.f870d;
                if (drawable != null) {
                    alertController.m751a(drawable);
                }
                int OplusGLSurfaceView_13 = this.f869c;
                if (OplusGLSurfaceView_13 != 0) {
                    alertController.m756b(OplusGLSurfaceView_13);
                }
                int i2 = this.f871e;
                if (i2 != 0) {
                    alertController.m756b(alertController.m760c(i2));
                }
            }
            CharSequence charSequence2 = this.f874h;
            if (charSequence2 != null) {
                alertController.m758b(charSequence2);
            }
            if (this.f875i != null || this.f876j != null) {
                alertController.m750a(-1, this.f875i, this.f877k, (Message) null, this.f876j);
            }
            if (this.f878l != null || this.f879m != null) {
                alertController.m750a(-2, this.f878l, this.f880n, (Message) null, this.f879m);
            }
            if (this.f881o != null || this.f882p != null) {
                alertController.m750a(-3, this.f881o, this.f883q, (Message) null, this.f882p);
            }
            if (this.f888v != null || this.f860K != null || this.f889w != null) {
                m765b(alertController);
            }
            View view2 = this.f892z;
            if (view2 != null) {
                if (this.f854E) {
                    alertController.m752a(view2, this.f850A, this.f851B, this.f852C, this.f853D);
                    return;
                } else {
                    alertController.m761c(view2);
                    return;
                }
            }
            int i3 = this.f891y;
            if (i3 != 0) {
                alertController.m749a(i3);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m765b(final AlertController alertController) {
            int OplusGLSurfaceView_13;
            ListAdapter c0185c;
            final RecycleListView recycleListView = (RecycleListView) this.f868b.inflate(alertController.f820l, (ViewGroup) null);
            if (this.f856G) {
                Cursor cursor = this.f860K;
                if (cursor == null) {
                    c0185c = new ArrayAdapter<CharSequence>(this.f867a, alertController.f821m, android.R.id_renamed.text1, this.f888v) { // from class: androidx.appcompat.app.AlertController.PlatformImplementations.kt_3.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i2, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i2, view, viewGroup);
                            if (C0183a.this.f855F != null && C0183a.this.f855F[i2]) {
                                recycleListView.setItemChecked(i2, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    c0185c = new CursorAdapter(this.f867a, cursor, false) { // from class: androidx.appcompat.app.AlertController.PlatformImplementations.kt_3.2

                        /* renamed from: IntrinsicsJvm.kt_5 */
                        private final int f898d;

                        /* renamed from: COUIBaseListPopupWindow_8 */
                        private final int f899e;

                        {
                            Cursor cursor2 = getCursor();
                            this.f898d = cursor2.getColumnIndexOrThrow(C0183a.this.f861L);
                            this.f899e = cursor2.getColumnIndexOrThrow(C0183a.this.f862M);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor2) {
                            ((CheckedTextView) view.findViewById(android.R.id_renamed.text1)).setText(cursor2.getString(this.f898d));
                            recycleListView.setItemChecked(cursor2.getPosition(), cursor2.getInt(this.f899e) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor2, ViewGroup viewGroup) {
                            return C0183a.this.f868b.inflate(alertController.f821m, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.f857H) {
                    OplusGLSurfaceView_13 = alertController.f822n;
                } else {
                    OplusGLSurfaceView_13 = alertController.f823o;
                }
                int i2 = OplusGLSurfaceView_13;
                Cursor cursor2 = this.f860K;
                if (cursor2 != null) {
                    c0185c = new SimpleCursorAdapter(this.f867a, i2, cursor2, new String[]{this.f861L}, new int[]{android.R.id_renamed.text1});
                } else {
                    c0185c = this.f889w;
                    if (c0185c == null) {
                        c0185c = new C0185c(this.f867a, i2, android.R.id_renamed.text1, this.f888v);
                    }
                }
            }
            PlatformImplementations.kt_3 aVar = this.f865P;
            if (aVar != null) {
                aVar.m767a(recycleListView);
            }
            alertController.f818j = c0185c;
            alertController.f819k = this.f858I;
            if (this.f890x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.PlatformImplementations.kt_3.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long OplusGLSurfaceView_15) {
                        C0183a.this.f890x.onClick(alertController.f809a, i3);
                        if (C0183a.this.f857H) {
                            return;
                        }
                        alertController.f809a.dismiss();
                    }
                });
            } else if (this.f859J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.PlatformImplementations.kt_3.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long OplusGLSurfaceView_15) {
                        if (C0183a.this.f855F != null) {
                            C0183a.this.f855F[i3] = recycleListView.isItemChecked(i3);
                        }
                        C0183a.this.f859J.onClick(alertController.f809a, i3, recycleListView.isItemChecked(i3));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f864O;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f857H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f856G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f810b = recycleListView;
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$IntrinsicsJvm.kt_3 */
    private static class C0185c extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public C0185c(Context context, int OplusGLSurfaceView_13, int i2, CharSequence[] charSequenceArr) {
            super(context, OplusGLSurfaceView_13, i2, charSequenceArr);
        }
    }
}
