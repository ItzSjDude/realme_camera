package com.coui.appcompat.widget.popupwindow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import com.coui.appcompat.widget.COUIHintRedDot;
import coui.support.appcompat.R;
import java.util.List;

/* compiled from: DefaultAdapter.java */
/* renamed from: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class DefaultAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f8621a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<PopupListItem> f8622b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f8623c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f8624d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f8625e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f8626f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f8627g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8628h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8629i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ColorStateList f8630j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f8631k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f8632l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f8633m;

    /* renamed from: OplusGLSurfaceView_11 */
    private View.AccessibilityDelegate f8634n;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    public DefaultAdapter(Context context, List<PopupListItem> list) {
        this.f8621a = context;
        this.f8622b = list;
        Resources resources = context.getResources();
        this.f8623c = resources.getDimensionPixelSize(R.dimen.coui_popup_list_padding_vertical);
        this.f8624d = resources.getDimensionPixelSize(R.dimen.coui_popup_list_window_item_padding_top_and_bottom);
        this.f8625e = resources.getDimensionPixelSize(R.dimen.coui_popup_list_window_item_min_height);
        this.f8626f = resources.getDimensionPixelOffset(R.dimen.f24249x36fe1610);
        this.f8627g = this.f8621a.getResources().getDimensionPixelSize(R.dimen.f24250xc10cc93c);
        this.f8628h = this.f8621a.getResources().getDimensionPixelSize(R.dimen.coui_popup_list_window_item_title_margin_left);
        this.f8629i = this.f8621a.getResources().getDimensionPixelSize(R.dimen.coui_popup_list_window_item_title_margin_right);
        this.f8632l = this.f8621a.getResources().getDimensionPixelSize(R.dimen.coui_popup_list_window_item_title_text_size);
        this.f8633m = this.f8621a.getResources().getConfiguration().fontScale;
        this.f8634n = new View.AccessibilityDelegate() { // from class: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow_12.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName("");
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.couiPopupListWindowTextColor, R.attr.couiTintControlNormal});
        this.f8630j = typedArrayObtainStyledAttributes.getColorStateList(0);
        this.f8631k = typedArrayObtainStyledAttributes.getColor(1, this.f8621a.getResources().getColor(R.color.couiGreenTintControlNormal));
        if (this.f8630j == null) {
            this.f8630j = this.f8621a.getResources().getColorStateList(R.color.coui_popup_list_window_text_color_light);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8622b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int OplusGLSurfaceView_13) {
        return this.f8622b.get(OplusGLSurfaceView_13);
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        PlatformImplementations.kt_3 aVar;
        if (view == null) {
            PlatformImplementations.kt_3 aVar2 = new PlatformImplementations.kt_3();
            View viewInflate = LayoutInflater.from(this.f8621a).inflate(R.layout.coui_popup_list_window_item, viewGroup, false);
            aVar2.f8636a = (ImageView) viewInflate.findViewById(R.id_renamed.popup_list_window_item_icon);
            aVar2.f8637b = (TextView) viewInflate.findViewById(R.id_renamed.popup_list_window_item_title);
            aVar2.f8640e = (LinearLayout) viewInflate.findViewById(R.id_renamed.content);
            aVar2.f8639d = (COUIHintRedDot) viewInflate.findViewById(R.id_renamed.red_dot);
            aVar2.f8638c = (CheckBox) viewInflate.findViewById(R.id_renamed.checkbox);
            if (aVar2.f8638c != null) {
                aVar2.f8638c.setAccessibilityDelegate(this.f8634n);
            }
            viewInflate.setTag(aVar2);
            aVar = aVar2;
            view = viewInflate;
        } else {
            aVar = (PlatformImplementations.kt_3) view.getTag();
        }
        if (getCount() == 1) {
            view.setMinimumHeight(this.f8625e + (this.f8623c * 2));
            int i2 = this.f8624d;
            int i3 = this.f8623c;
            view.setPadding(0, i2 + i3, 0, i2 + i3);
        } else if (OplusGLSurfaceView_13 == 0) {
            view.setMinimumHeight(this.f8625e + this.f8623c);
            int i4 = this.f8624d;
            view.setPadding(0, this.f8623c + i4, 0, i4);
        } else if (OplusGLSurfaceView_13 == getCount() - 1) {
            view.setMinimumHeight(this.f8625e + this.f8623c);
            int i5 = this.f8624d;
            view.setPadding(0, i5, 0, this.f8623c + i5);
        } else {
            view.setMinimumHeight(this.f8625e);
            int i6 = this.f8624d;
            view.setPadding(0, i6, 0, i6);
        }
        boolean zM8110d = this.f8622b.get(OplusGLSurfaceView_13).m8110d();
        view.setEnabled(zM8110d);
        m8106a(this.f8622b.get(OplusGLSurfaceView_13), aVar.f8639d);
        m8103a(aVar.f8636a, aVar.f8637b, this.f8622b.get(OplusGLSurfaceView_13), zM8110d);
        m8105a(aVar.f8637b, this.f8622b.get(OplusGLSurfaceView_13), zM8110d);
        m8104a((LinearLayout) view, aVar.f8638c, aVar.f8637b, this.f8622b.get(OplusGLSurfaceView_13), zM8110d);
        return view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8103a(ImageView imageView, TextView textView, PopupListItem c1505g, boolean z) throws Resources.NotFoundException {
        Drawable drawableM8108b;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (c1505g.m8107a() == 0 && c1505g.m8108b() == null) {
            imageView.setVisibility(8);
            layoutParams.setMarginStart(this.f8627g);
            if (c1505g.m8113g() == -1 && !c1505g.m8111e()) {
                layoutParams.setMarginEnd(this.f8627g);
            } else {
                layoutParams.setMarginEnd(0);
            }
        } else {
            imageView.setVisibility(0);
            layoutParams.setMarginStart(this.f8628h);
            if (c1505g.m8113g() == -1 && !c1505g.m8111e()) {
                layoutParams.setMarginEnd(this.f8629i);
            } else {
                layoutParams.setMarginEnd(0);
            }
            if (c1505g.m8108b() == null) {
                drawableM8108b = this.f8621a.getResources().getDrawable(c1505g.m8107a());
            } else {
                drawableM8108b = c1505g.m8108b();
            }
            imageView.setImageDrawable(drawableM8108b);
        }
        textView.setLayoutParams(layoutParams);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8105a(TextView textView, PopupListItem c1505g, boolean z) {
        textView.setEnabled(z);
        textView.setText(c1505g.m8109c());
        textView.setTextColor(this.f8630j);
        textView.setTextSize(0, COUIChangeTextUtil.m6388a(this.f8632l, this.f8633m, 5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8104a(LinearLayout linearLayout, CheckBox checkBox, TextView textView, PopupListItem c1505g, boolean z) {
        if (c1505g.m8111e()) {
            int minimumWidth = linearLayout.getMinimumWidth();
            int OplusGLSurfaceView_13 = this.f8626f;
            if (minimumWidth != OplusGLSurfaceView_13) {
                linearLayout.setMinimumWidth(OplusGLSurfaceView_13);
            }
            checkBox.setVisibility(0);
            checkBox.setChecked(c1505g.m8112f());
            checkBox.setEnabled(z);
            if (c1505g.m8112f()) {
                textView.setTextColor(this.f8631k);
                return;
            }
            return;
        }
        if (linearLayout.getMinimumWidth() == this.f8626f) {
            linearLayout.setMinimumWidth(0);
        }
        checkBox.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8106a(PopupListItem c1505g, COUIHintRedDot cOUIHintRedDot) {
        cOUIHintRedDot.setPointNumber(c1505g.m8113g());
        int iM8113g = c1505g.m8113g();
        if (iM8113g == -1) {
            cOUIHintRedDot.setPointMode(0);
        } else if (iM8113g == 0) {
            cOUIHintRedDot.setPointMode(1);
            cOUIHintRedDot.setVisibility(0);
        } else {
            cOUIHintRedDot.setPointMode(2);
            cOUIHintRedDot.setVisibility(0);
        }
    }

    /* compiled from: DefaultAdapter.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        ImageView f8636a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        TextView f8637b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        CheckBox f8638c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        COUIHintRedDot f8639d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        LinearLayout f8640e;

        PlatformImplementations.kt_3() {
        }
    }
}
