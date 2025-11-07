package com.coui.appcompat.widget.toolbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ViewUtils_2;
import androidx.core.p036h.ViewCompat;
import com.coui.appcompat.p099a.COUIHintRedDotHelper;
import com.coui.appcompat.widget.popupwindow.PopupListItem;
import com.coui.appcompat.widget.popupwindow.COUIPopupListWindow;
import coui.support.appcompat.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: COUIActionMenuView.java */
/* renamed from: com.coui.appcompat.widget.toolbar.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class COUIActionMenuView extends ActionMenuView {

    /* renamed from: A */
    private COUIHintRedDotHelper f8812A;

    /* renamed from: B */
    private PopupWindow.OnDismissListener f8813B;

    /* renamed from: C */
    private View f8814C;

    /* renamed from: D */
    private String f8815D;

    /* renamed from: E */
    private String f8816E;

    /* renamed from: F */
    private int f8817F;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public COUIPopupListWindow f8818c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private MenuBuilder f8819d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private List<Class<?>> f8820e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f8821f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f8822g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ArrayList f8823h;

    /* renamed from: OplusGLSurfaceView_13 */
    private MenuItemImpl f8824i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f8825j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f8826k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f8827l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f8828m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f8829n;

    /* renamed from: o */
    private int f8830o;

    /* renamed from: p */
    private boolean f8831p;

    /* renamed from: q */
    private int f8832q;

    /* renamed from: r */
    private HashMap<Integer, Integer> f8833r;

    /* renamed from: s */
    private int f8834s;

    /* renamed from: t */
    private int f8835t;

    /* renamed from: u */
    private int f8836u;

    /* renamed from: v */
    private int f8837v;

    /* renamed from: w */
    private int f8838w;

    /* renamed from: x */
    private int f8839x;

    /* renamed from: y */
    private int f8840y;

    /* renamed from: z */
    private int f8841z;

    public COUIActionMenuView(Context context) {
        this(context, null);
    }

    public COUIActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8819d = null;
        this.f8820e = new ArrayList();
        this.f8831p = true;
        this.f8832q = 0;
        this.f8832q = getResources().getDimensionPixelSize(R.dimen.coui_actionbar_menuview_padding);
        this.f8825j = getResources().getDimensionPixelSize(R.dimen.coui_action_menu_item_min_width);
        this.f8826k = getResources().getDimensionPixelSize(R.dimen.overflow_button_padding_horizontal);
        this.f8827l = getResources().getDimensionPixelSize(R.dimen.toolbar_edge_text_menu_item_margin);
        this.f8828m = getResources().getDimensionPixelSize(R.dimen.toolbar_edge_icon_menu_item_margin);
        this.f8829n = getResources().getDimensionPixelSize(R.dimen.toolbar_icon_item_horizontal_offset);
        this.f8830o = getResources().getDimensionPixelSize(R.dimen.toolbar_item_vertical_offset);
        this.f8822g = getResources().getDimensionPixelSize(R.dimen.coui_action_menu_text_extra_padding);
        this.f8821f = getResources().getDimensionPixelSize(R.dimen.coui_actionbar_menuitemview_item_spacing);
        this.f8833r = new HashMap<>();
        this.f8836u = getResources().getDimensionPixelSize(R.dimen.coui_toolbar_menu_red_dot_horizontal_offset);
        this.f8837v = getResources().getDimensionPixelSize(R.dimen.coui_toolbar_menu_red_dot_vertical_offset);
        this.f8838w = getResources().getDimensionPixelSize(R.dimen.f24259x3828e3e);
        this.f8839x = getResources().getDimensionPixelSize(R.dimen.f24258xd1274150);
        this.f8840y = getResources().getDimensionPixelSize(R.dimen.f24257x5d365baf);
        this.f8841z = getResources().getDimensionPixelSize(R.dimen.coui_toolbar_menu_icon_top_padding);
        this.f8812A = new COUIHintRedDotHelper(getContext(), null, R.styleable.COUIHintRedDot, 0, R.style.Widget_COUI_COUIHintRedDot_Small);
        this.f8815D = getResources().getString(R.string.abc_action_menu_overflow_description);
        this.f8816E = getResources().getString(R.string.red_dot_description);
        this.f8817F = R.plurals.red_dot_with_number_description;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coui.appcompat.widget.toolbar.PlatformImplementations.kt_3.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return true;
            }
        });
        view.setHapticFeedbackEnabled(false);
        if (((ActionMenuView.C0264c) layoutParams).f1544a) {
            this.f8814C = view;
            this.f8814C.setBackgroundResource(R.drawable.coui_toolbar_menu_bg);
            layoutParams.height = -1;
            this.f8814C.setMinimumWidth(this.f8825j);
            View view2 = this.f8814C;
            view2.setPadding(this.f8826k, view2.getPaddingTop(), this.f8826k, this.f8814C.getPaddingBottom());
            this.f8814C.setOnTouchListener(null);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.toolbar.PlatformImplementations.kt_3.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (COUIActionMenuView.this.f8818c == null) {
                        COUIActionMenuView c1526a = COUIActionMenuView.this;
                        c1526a.f8818c = new COUIPopupListWindow(c1526a.getContext());
                        COUIActionMenuView.this.f8818c.setInputMethodMode(2);
                        COUIActionMenuView.this.f8818c.m8098a(true);
                        COUIActionMenuView.this.f8818c.setOnDismissListener(COUIActionMenuView.this.f8813B);
                        COUIActionMenuView.this.f8823h = new ArrayList();
                    }
                    COUIActionMenuView.this.f8823h.clear();
                    if (COUIActionMenuView.this.f8819d != null) {
                        for (int i2 = 0; i2 < COUIActionMenuView.this.f8819d.getNonActionItems().size(); i2++) {
                            COUIActionMenuView c1526a2 = COUIActionMenuView.this;
                            c1526a2.f8824i = c1526a2.f8819d.getNonActionItems().get(i2);
                            COUIActionMenuView.this.f8823h.add(new PopupListItem(COUIActionMenuView.this.f8824i.getIcon(), COUIActionMenuView.this.f8824i.getTitle() != null ? COUIActionMenuView.this.f8824i.getTitle().toString() : "", COUIActionMenuView.this.f8824i.isCheckable(), COUIActionMenuView.this.f8824i.isChecked(), COUIActionMenuView.this.f8833r.containsKey(Integer.valueOf(COUIActionMenuView.this.f8824i.getItemId())) ? ((Integer) COUIActionMenuView.this.f8833r.get(Integer.valueOf(COUIActionMenuView.this.f8824i.getItemId()))).intValue() : -1, COUIActionMenuView.this.f8824i.isEnabled()));
                        }
                        COUIActionMenuView.this.f8818c.m8097a(COUIActionMenuView.this.f8823h);
                        COUIActionMenuView.this.f8818c.m8096a(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.widget.toolbar.PlatformImplementations.kt_3.2.1
                            @Override // android.widget.AdapterView.OnItemClickListener
                            public void onItemClick(AdapterView<?> adapterView, View view4, int i3, long OplusGLSurfaceView_15) {
                                COUIActionMenuView.this.f8819d.performItemAction(COUIActionMenuView.this.f8819d.getNonActionItems().get(i3), 0);
                                COUIActionMenuView.this.f8818c.dismiss();
                            }
                        });
                    }
                    COUIActionMenuView.this.f8818c.m8095a(COUIActionMenuView.this.f8814C);
                }
            });
        }
        super.addView(view, OplusGLSurfaceView_13, layoutParams);
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        if (this.f8819d == null) {
            super.onMeasure(OplusGLSurfaceView_13, i2);
            return;
        }
        this.f8831p = true;
        if ((getParent() instanceof COUIToolbar) && ((COUIToolbar) getParent()).getIsTitleCenterStyle()) {
            this.f8831p = false;
        }
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        boolean z = ViewCompat.m2885g(this) == 1;
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int size2 = View.MeasureSpec.getSize(i2);
        m8234k();
        int iM8227b = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            iM8227b += m8227b(getChildAt(i3), OplusGLSurfaceView_13, iM8227b, i2, 0);
        }
        if (this.f8831p) {
            int childCount = getChildCount();
            if (childCount > 0) {
                int i4 = -1;
                int i5 = 0;
                for (int i6 = 0; i6 < childCount; i6++) {
                    if (getChildAt(i6).getVisibility() != 8) {
                        i5++;
                        i4 = i6;
                    }
                }
                int i7 = iM8227b + ((i5 - 1) * this.f8821f);
                if (i4 != -1) {
                    View childAt = getChildAt(i4);
                    if ((childAt instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt).getText())) {
                        i7 += this.f8822g;
                    }
                }
                size = i7;
            } else {
                size = 0;
            }
            if (z) {
                setPadding(getPaddingLeft(), getPaddingTop(), 0, getPaddingBottom());
            }
        }
        setMeasuredDimension(size, size2);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m8234k() {
        int OplusGLSurfaceView_13 = 0;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4).getVisibility() != 8) {
                OplusGLSurfaceView_13++;
                if (OplusGLSurfaceView_13 == 1) {
                    i2 = i4;
                    i3 = i2;
                } else {
                    i3 = i4;
                }
            }
        }
        if (i2 != -1 && !this.f8831p && OplusGLSurfaceView_13 > 1) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuItemView) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (((ActionMenuItemView) childAt).getItemData().getIcon() == null) {
                    if (m8235l()) {
                        marginLayoutParams.rightMargin = this.f8827l;
                    } else {
                        marginLayoutParams.leftMargin = this.f8827l;
                    }
                } else if (m8235l()) {
                    marginLayoutParams.rightMargin = this.f8828m;
                } else {
                    marginLayoutParams.leftMargin = this.f8828m;
                }
            }
        }
        if (i3 != -1) {
            View childAt2 = getChildAt(i3);
            if (childAt2 instanceof ActionMenuItemView) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                if (((ActionMenuItemView) childAt2).getItemData().getIcon() == null) {
                    if (m8235l()) {
                        marginLayoutParams2.leftMargin = this.f8827l;
                        return;
                    } else {
                        marginLayoutParams2.rightMargin = this.f8827l;
                        return;
                    }
                }
                if (m8235l()) {
                    marginLayoutParams2.leftMargin = this.f8828m;
                } else {
                    marginLayoutParams2.rightMargin = this.f8828m;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            if (getChildAt(i7).getVisibility() != 8) {
                i6++;
            }
        }
        if (i6 > 5) {
            super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
            return;
        }
        boolean zM1623a = ViewUtils_2.m1623a(this);
        int i8 = (i4 - i2) / 2;
        if (this.f8831p) {
            if (zM1623a) {
                int width = getWidth() - getPaddingRight();
                while (i5 < childCount) {
                    View childAt = getChildAt(i5);
                    ActionMenuView.C0264c c0264c = (ActionMenuView.C0264c) childAt.getLayoutParams();
                    if (childAt.getVisibility() != 8) {
                        int i9 = width - c0264c.rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i10 = i8 - (measuredHeight / 2);
                        childAt.layout(i9 - measuredWidth, i10, i9, measuredHeight + i10);
                        width = i9 - ((measuredWidth + c0264c.leftMargin) + this.f8821f);
                    }
                    i5++;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                ActionMenuView.C0264c c0264c2 = (ActionMenuView.C0264c) childAt2.getLayoutParams();
                if (childAt2.getVisibility() != 8) {
                    int i11 = paddingLeft + c0264c2.leftMargin;
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    int i12 = i8 - (measuredHeight2 / 2);
                    childAt2.layout(i11, i12, i11 + measuredWidth2, measuredHeight2 + i12);
                    paddingLeft = i11 + measuredWidth2 + c0264c2.rightMargin + this.f8821f;
                }
                i5++;
            }
            return;
        }
        if (zM1623a) {
            int paddingLeft2 = getPaddingLeft();
            boolean z2 = true;
            for (int i13 = childCount - 1; i13 >= 0; i13--) {
                View childAt3 = getChildAt(i13);
                ActionMenuView.C0264c c0264c3 = (ActionMenuView.C0264c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8) {
                    paddingLeft2 += c0264c3.leftMargin;
                    if (z2) {
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            paddingLeft2 += this.f8822g;
                        }
                        z2 = false;
                    }
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i14 = i8 - (measuredHeight3 / 2);
                    if (i13 == 0 && i6 > 1) {
                        int width2 = ((getWidth() - getPaddingRight()) - c0264c3.rightMargin) - measuredWidth3;
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            width2 -= this.f8832q;
                        }
                        childAt3.layout(width2, i14, measuredWidth3 + width2, measuredHeight3 + i14);
                    } else {
                        childAt3.layout(paddingLeft2, i14, paddingLeft2 + measuredWidth3, measuredHeight3 + i14);
                        paddingLeft2 += measuredWidth3 + c0264c3.rightMargin + this.f8821f;
                    }
                }
            }
            return;
        }
        int width3 = getWidth() - getPaddingRight();
        boolean z3 = true;
        for (int i15 = childCount - 1; i15 >= 0; i15--) {
            View childAt4 = getChildAt(i15);
            ActionMenuView.C0264c c0264c4 = (ActionMenuView.C0264c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8) {
                width3 -= c0264c4.rightMargin;
                if (z3) {
                    if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                        width3 -= this.f8822g;
                    }
                    z3 = false;
                }
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i16 = i8 - (measuredHeight4 / 2);
                if (i15 == 0 && i6 > 1) {
                    int paddingLeft3 = getPaddingLeft() + c0264c4.leftMargin;
                    if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                        paddingLeft3 += this.f8832q;
                    }
                    childAt4.layout(paddingLeft3, i16, measuredWidth4 + paddingLeft3, measuredHeight4 + i16);
                } else {
                    childAt4.layout(width3 - measuredWidth4, i16, width3, measuredHeight4 + i16);
                    width3 -= (measuredWidth4 + c0264c4.leftMargin) + this.f8821f;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public void setOverflowReserved(boolean z) {
        super.setOverflowReserved(z);
        COUIPopupListWindow viewOnLayoutChangeListenerC1502d = this.f8818c;
        if (viewOnLayoutChangeListenerC1502d == null || !viewOnLayoutChangeListenerC1502d.isShowing()) {
            return;
        }
        this.f8823h.clear();
        if (this.f8819d.getNonActionItems().size() == 0) {
            ((BaseAdapter) this.f8818c.m8100c().getAdapter()).notifyDataSetChanged();
            this.f8818c.dismiss();
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f8819d.getNonActionItems().size(); OplusGLSurfaceView_13++) {
            this.f8824i = this.f8819d.getNonActionItems().get(OplusGLSurfaceView_13);
            this.f8823h.add(new PopupListItem(this.f8824i.getIcon(), this.f8824i.getTitle() != null ? this.f8824i.getTitle().toString() : "", this.f8824i.isCheckable(), this.f8824i.isChecked(), this.f8833r.containsKey(Integer.valueOf(this.f8824i.getItemId())) ? this.f8833r.get(Integer.valueOf(this.f8824i.getItemId())).intValue() : -1, this.f8824i.isEnabled()));
        }
        ((BaseAdapter) this.f8818c.m8100c().getAdapter()).notifyDataSetChanged();
        this.f8818c.m8094a();
        COUIPopupListWindow viewOnLayoutChangeListenerC1502d2 = this.f8818c;
        viewOnLayoutChangeListenerC1502d2.update(viewOnLayoutChangeListenerC1502d2.getWidth(), this.f8818c.getHeight());
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public Menu getMenu() {
        this.f8819d = (MenuBuilder) super.getMenu();
        return this.f8819d;
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder c0236h) {
        this.f8819d = c0236h;
        super.initialize(c0236h);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m8227b(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        view.measure(getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + i5 + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + i5;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m8236j() {
        this.f8835t = 0;
        this.f8834s = 0;
        this.f8833r.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m8228b(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != -1 ? OplusGLSurfaceView_13 != 0 ? getResources().getQuantityString(this.f8817F, OplusGLSurfaceView_13, Integer.valueOf(OplusGLSurfaceView_13)) : this.f8816E : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (this.f8833r.containsKey(Integer.valueOf(childAt.getId()))) {
                m8226a(childAt, this.f8833r.get(Integer.valueOf(childAt.getId())).intValue(), canvas);
            }
            if (((ActionMenuView.C0264c) childAt.getLayoutParams()).f1544a) {
                int i2 = this.f8834s == 0 ? -1 : this.f8835t;
                m8226a(childAt, i2, canvas);
                childAt.setContentDescription(this.f8815D + "," + m8228b(i2));
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8226a(View view, int OplusGLSurfaceView_13, Canvas canvas) {
        int i2;
        int i3;
        float x;
        float x2;
        int i4 = OplusGLSurfaceView_13 != -1 ? OplusGLSurfaceView_13 != 0 ? 2 : 1 : 0;
        if (view != null) {
            int iM6413a = this.f8812A.m6413a(i4, OplusGLSurfaceView_13);
            int iM6412a = this.f8812A.m6412a(i4);
            if (i4 == 1) {
                i2 = this.f8836u;
                i3 = this.f8837v;
            } else if (OplusGLSurfaceView_13 < 100) {
                i2 = this.f8839x;
                i3 = this.f8838w;
            } else {
                i2 = this.f8840y;
                i3 = this.f8838w;
            }
            RectF rectF = new RectF();
            if ((view instanceof ActionMenuItemView) && ((ActionMenuItemView) view).getItemData().getIcon() == null) {
                if (m8235l()) {
                    x2 = (view.getX() + i2) - this.f8832q;
                    x = x2 - iM6413a;
                } else {
                    x = ((view.getX() + view.getWidth()) - i2) + this.f8832q;
                    x2 = iM6413a + x;
                }
            } else if (m8235l()) {
                x2 = ((view.getX() + i2) - this.f8832q) + this.f8829n;
                x = x2 - iM6413a;
            } else {
                x = (((view.getX() + view.getWidth()) - i2) + this.f8832q) - this.f8829n;
                x2 = iM6413a + x;
            }
            float COUIBaseListPopupWindow_12 = (this.f8841z - i3) + this.f8830o;
            rectF.left = x;
            rectF.top = COUIBaseListPopupWindow_12;
            rectF.right = x2;
            rectF.bottom = iM6412a + COUIBaseListPopupWindow_12;
            this.f8812A.m6415a(canvas, i4, OplusGLSurfaceView_13, rectF);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m8235l() {
        return ViewCompat.m2885g(this) == 1;
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f8813B = onDismissListener;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo1279e() {
        if (this.f8818c == null) {
            return false;
        }
        this.f8823h.clear();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f8819d.getNonActionItems().size(); OplusGLSurfaceView_13++) {
            this.f8824i = this.f8819d.getNonActionItems().get(OplusGLSurfaceView_13);
            this.f8823h.add(new PopupListItem(this.f8824i.getIcon(), this.f8824i.getTitle() != null ? this.f8824i.getTitle().toString() : "", this.f8824i.isCheckable(), this.f8824i.isChecked(), this.f8833r.containsKey(Integer.valueOf(this.f8824i.getItemId())) ? this.f8833r.get(Integer.valueOf(this.f8824i.getItemId())).intValue() : -1, this.f8824i.isEnabled()));
        }
        ((BaseAdapter) this.f8818c.m8100c().getAdapter()).notifyDataSetChanged();
        this.f8818c.m8095a(this.f8814C);
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo1283i() {
        COUIPopupListWindow viewOnLayoutChangeListenerC1502d = this.f8818c;
        if (viewOnLayoutChangeListenerC1502d != null) {
            viewOnLayoutChangeListenerC1502d.dismiss();
        }
        super.mo1283i();
    }
}
