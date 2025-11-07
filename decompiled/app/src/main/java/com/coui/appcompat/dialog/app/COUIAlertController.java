package com.coui.appcompat.dialog.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.coui.appcompat.dialog.app.AlertController;
import com.coui.appcompat.widget.ChoiceListAdapter;
import com.coui.appcompat.widget.ChoiceListCursorAdapter;
import com.coui.appcompat.widget.COUIButtonBarLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIAlertController extends AlertController {

    /* renamed from: C */
    private Context f6415C;

    /* renamed from: D */
    private int f6416D;

    /* renamed from: E */
    private boolean f6417E;

    public COUIAlertController(Context context, AppCompatDialog dialogC0208f, Window window) {
        super(context, dialogC0208f, window);
        this.f6417E = true;
        this.f6415C = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.couiCenterAlertDialogButtonTextColor});
        this.f6416D = typedArrayObtainStyledAttributes.getColor(0, this.f6415C.getResources().getColor(R.color.coui_bottom_alert_dialog_button_text_color));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.coui.appcompat.dialog.app.AlertController
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int mo6524b() {
        return m6518h() ? super.mo6524b() : R.layout.coui_bottom_alert_dialog;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m6517g() {
        WindowManager.LayoutParams attributes = this.f6459b.getAttributes();
        attributes.width = -1;
        if (m6518h()) {
            attributes.windowAnimations = R.style.Animation_COUI_Dialog_Alpha;
            this.f6459b.setGravity(17);
        } else {
            attributes.windowAnimations = R.style.Animation_COUI_Dialog;
            this.f6459b.setGravity(80);
        }
        this.f6459b.setAttributes(attributes);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m6518h() {
        return m6554e() == 0;
    }

    @Override // com.coui.appcompat.dialog.app.AlertController
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo6527d() {
        m6528f();
        m6519i();
        m6517g();
        ListView listViewC = m6551c();
        if (listViewC instanceof COUIRecyclerListView) {
            ((COUIRecyclerListView) listViewC).setNeedClip(m6520j());
        }
        super.mo6527d();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m6528f() {
        ViewGroup viewGroup;
        if (this.f6458a == null || this.f6459b == null || (viewGroup = (ViewGroup) this.f6459b.findViewById(android.R.id_renamed.content)) == null) {
            return;
        }
        viewGroup.setOnClickListener(!this.f6417E ? null : new View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.COUIAlertController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIAlertController.this.f6458a != null) {
                    COUIAlertController.this.f6458a.cancel();
                }
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m6519i() {
        View viewFindViewById = this.f6459b.findViewById(R.id_renamed.parentPanel);
        if (viewFindViewById == null || viewFindViewById.getBackground() == null || this.f6434B == 0) {
            return;
        }
        viewFindViewById.getBackground().setTint(this.f6434B);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m6520j() {
        return (m6521k() || m6522l() || m6518h()) ? false : true;
    }

    @Override // com.coui.appcompat.dialog.app.AlertController
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo6526c(ViewGroup viewGroup) {
        Typeface typefaceCreate;
        float dimensionPixelSize;
        super.mo6526c(viewGroup);
        if (!(viewGroup instanceof COUIButtonBarLayout) || this.f6482y || this.f6483z) {
            return;
        }
        Button button = (Button) viewGroup.findViewById(android.R.id_renamed.button1);
        Button button2 = (Button) viewGroup.findViewById(android.R.id_renamed.button2);
        Button button3 = (Button) viewGroup.findViewById(android.R.id_renamed.button3);
        if (m6518h()) {
            typefaceCreate = Typeface.create("sans-serif-medium", 0);
            dimensionPixelSize = this.f6415C.getResources().getDimensionPixelSize(R.dimen.TD07);
            ((COUIButtonBarLayout) viewGroup).setVerNegButVerPaddingOffset(0);
        } else {
            typefaceCreate = Typeface.create("sans-serif-regular", 0);
            float dimensionPixelSize2 = this.f6415C.getResources().getDimensionPixelSize(R.dimen.TD09);
            COUIButtonBarLayout cOUIButtonBarLayout = (COUIButtonBarLayout) viewGroup;
            cOUIButtonBarLayout.setVerNegButVerPaddingOffset(this.f6415C.getResources().getDimensionPixelSize(R.dimen.alert_dialog_list_last_item_padding_offset));
            cOUIButtonBarLayout.setForceVertical(true);
            button.setTextColor(this.f6416D);
            button2.setTextColor(this.f6416D);
            button3.setTextColor(this.f6415C.getResources().getColor(R.color.coui_bottom_alert_dialog_button_warning_color));
            dimensionPixelSize = dimensionPixelSize2;
        }
        button.setTypeface(typefaceCreate);
        button.setTextSize(0, dimensionPixelSize);
        button2.setTypeface(typefaceCreate);
        button2.setTextSize(0, dimensionPixelSize);
        button3.setTypeface(typefaceCreate);
        button3.setTextSize(0, dimensionPixelSize);
    }

    @Override // com.coui.appcompat.dialog.app.AlertController
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo6525b(ViewGroup viewGroup) {
        super.mo6525b(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id_renamed.listPanel);
        if (this.f6461d != null && viewGroup2 != null && this.f6462e != null) {
            viewGroup2.addView(this.f6462e, new ViewGroup.LayoutParams(-1, -1));
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id_renamed.coui_alert_dialog_list_divider);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        if (m6518h()) {
            if (this.f6461d != null) {
                m6516f(viewGroup);
                return;
            }
            return;
        }
        m6515e(viewGroup2);
        if ((this.f6482y || this.f6483z) && m6521k() && m6522l()) {
            m6514d(viewGroup);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6514d(ViewGroup viewGroup) {
        if (this.f6472o != null) {
            this.f6472o.setPadding(this.f6472o.getPaddingLeft(), this.f6415C.getResources().getDimensionPixelSize(R.dimen.center_dialog_scroll_padding_top), this.f6472o.getPaddingRight(), this.f6415C.getResources().getDimensionPixelSize(R.dimen.center_dialog_scroll_padding_bottom));
        }
        TextView textView = (TextView) viewGroup.findViewById(android.R.id_renamed.message);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.setMarginStart(this.f6415C.getResources().getDimensionPixelSize(R.dimen.bottom_choice_dialog_message_margin_start));
        layoutParams.setMarginEnd(this.f6415C.getResources().getDimensionPixelSize(R.dimen.bottom_choice_dialog_message_margin_end));
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(0, this.f6415C.getResources().getDimensionPixelSize(R.dimen.TD07));
        textView.setTextColor(this.f6415C.getResources().getColor(R.color.coui_alert_dialog_content_text_color));
        m6516f(viewGroup);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m6515e(ViewGroup viewGroup) {
        if (this.f6481x) {
            if (this.f6472o != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6472o.getLayoutParams();
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
                this.f6472o.setLayoutParams(layoutParams);
            }
            if (viewGroup != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams2.height = 0;
                layoutParams2.weight = 1.0f;
                viewGroup.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m6516f(ViewGroup viewGroup) {
        final TextView textView = (TextView) viewGroup.findViewById(android.R.id_renamed.message);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.dialog.app.COUIAlertController.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (textView.getLineCount() > 1) {
                    textView.setTextAlignment(2);
                } else {
                    textView.setTextAlignment(4);
                }
                TextView textView2 = textView;
                textView2.setText(textView2.getText());
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m6521k() {
        return !TextUtils.isEmpty(this.f6461d);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m6522l() {
        return !TextUtils.isEmpty(this.f6460c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m6523a(boolean z) {
        this.f6417E = z;
        m6528f();
    }

    public static class COUIRecyclerListView extends AlertController.IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        private Path f6421a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f6422b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f6423c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float[] f6424d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private RectF f6425e;

        public COUIRecyclerListView(Context context) {
            this(context, null);
        }

        public COUIRecyclerListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6422b = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_bottom_corner_radius);
            this.f6421a = new Path();
            this.f6425e = new RectF();
            int OplusGLSurfaceView_13 = this.f6422b;
            this.f6424d = new float[]{OplusGLSurfaceView_13, OplusGLSurfaceView_13, OplusGLSurfaceView_13, OplusGLSurfaceView_13, 0.0f, 0.0f, 0.0f, 0.0f};
        }

        @Override // android.widget.AbsListView, android.view.View
        public void draw(Canvas canvas) {
            canvas.save();
            if (this.f6423c) {
                canvas.clipPath(this.f6421a);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public void setNeedClip(boolean z) {
            this.f6423c = z;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
        protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
            this.f6421a.reset();
            this.f6425e.set(0.0f, 0.0f, OplusGLSurfaceView_13, i2);
            this.f6421a.addRoundRect(this.f6425e, this.f6424d, Path.Direction.CW);
        }
    }

    /* renamed from: com.coui.appcompat.dialog.app.COUIAlertController$PlatformImplementations.kt_3 */
    public static class C1287a extends AlertController.PlatformImplementations.kt_3 {

        /* renamed from: V */
        public String f6426V;

        public C1287a(Context context) {
            super(context);
        }

        @Override // com.coui.appcompat.dialog.app.AlertController.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6530a(AlertController c1288a) {
            super.mo6530a(c1288a);
            if (this.f6537w == null && this.f6507N == null && this.f6540z == null) {
                return;
            }
            m6529b(c1288a);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m6529b(final AlertController c1288a) {
            if (this.f6503J) {
                if (this.f6507N == null) {
                    c1288a.f6473p = new ChoiceListAdapter(this.f6515a, c1288a.f6477t, this.f6537w, this.f6538x, this.f6502I, true) { // from class: com.coui.appcompat.dialog.app.COUIAlertController.PlatformImplementations.kt_3.1
                        @Override // com.coui.appcompat.widget.ChoiceListAdapter, android.widget.Adapter
                        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(OplusGLSurfaceView_13, view, viewGroup);
                            if (C1287a.this.f6502I != null && C1287a.this.f6502I[OplusGLSurfaceView_13]) {
                                c1288a.f6462e.setItemChecked(OplusGLSurfaceView_13, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    c1288a.f6473p = new ChoiceListCursorAdapter(this.f6515a, this.f6507N, c1288a.f6477t, this.f6508O, this.f6509P, this.f6426V, this.f6503J) { // from class: com.coui.appcompat.dialog.app.COUIAlertController.PlatformImplementations.kt_3.2
                        @Override // com.coui.appcompat.widget.ChoiceListCursorAdapter, androidx.p021b.p022a.CursorAdapter
                        /* renamed from: PlatformImplementations.kt_3 */
                        public void mo1527a(View view, Context context, Cursor cursor) throws IllegalArgumentException {
                            super.mo1527a(view, context, cursor);
                            c1288a.f6462e.setItemChecked(cursor.getPosition(), cursor.getInt(cursor.getColumnIndexOrThrow(C1287a.this.f6509P)) == 1);
                        }
                    };
                }
            } else if (this.f6504K) {
                int OplusGLSurfaceView_13 = c1288a.f6478u;
                if (this.f6507N != null) {
                    c1288a.f6473p = new ChoiceListCursorAdapter(this.f6515a, this.f6507N, OplusGLSurfaceView_13, this.f6508O, this.f6426V);
                } else if (this.f6540z == null) {
                    c1288a.f6473p = new ChoiceListAdapter(this.f6515a, OplusGLSurfaceView_13, this.f6537w, this.f6538x);
                }
            }
            if (this.f6506M != null) {
                c1288a.f6462e.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.dialog.app.COUIAlertController.PlatformImplementations.kt_3.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                        if (C1287a.this.f6502I != null) {
                            C1287a.this.f6502I[i2] = c1288a.f6462e.isItemChecked(i2);
                        }
                        C1287a.this.f6506M.onClick(c1288a.f6458a, i2, c1288a.f6462e.isItemChecked(i2));
                        if (C1287a.this.f6503J) {
                            int i3 = c1288a.f6462e.isItemChecked(i2) ? 2 : 0;
                            if (C1287a.this.f6507N == null) {
                                ((ChoiceListAdapter) c1288a.f6473p).m8241a(i3, i2, c1288a.f6462e);
                            } else {
                                ((ChoiceListCursorAdapter) c1288a.f6473p).m8243a(i3, i2, c1288a.f6462e);
                            }
                        }
                    }
                });
            }
        }
    }
}
