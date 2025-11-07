package com.coui.appcompat.dialog.panel;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.COUIPanelPreferenceLinearLayoutManager;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.dialog.panel.COUIBottomSheetChoiceListAdapter;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import coui.support.appcompat.R;

/* compiled from: COUIListBottomSheetDialog.java */
/* renamed from: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class COUIListBottomSheetDialog {

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIBottomSheetDialog f6812a;

    /* compiled from: COUIListBottomSheetDialog.java */
    /* renamed from: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends AlertDialog.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean[] f6813a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f6814b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public DialogInterface.OnMultiChoiceClickListener f6815c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public DialogInterface.OnClickListener f6816d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private COUIListBottomSheetDialog f6817e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private View f6818f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private CharSequence f6819g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private Context f6820h;

        /* renamed from: OplusGLSurfaceView_13 */
        private CharSequence[] f6821i;

        /* renamed from: OplusGLSurfaceView_15 */
        private CharSequence[] f6822j;

        /* renamed from: OplusGLSurfaceView_5 */
        private String f6823k;

        /* renamed from: OplusGLSurfaceView_14 */
        private View.OnClickListener f6824l;

        /* renamed from: OplusGLSurfaceView_6 */
        private String f6825m;

        /* renamed from: OplusGLSurfaceView_11 */
        private View.OnClickListener f6826n;

        /* renamed from: o */
        private String f6827o;

        /* renamed from: p */
        private View.OnClickListener f6828p;

        /* renamed from: q */
        private boolean f6829q;

        /* renamed from: r */
        private boolean f6830r;

        /* renamed from: s */
        private int f6831s;

        public PlatformImplementations.kt_3(Context context) {
            super(context);
            this.f6817e = new COUIListBottomSheetDialog();
            this.f6814b = -1;
            this.f6829q = false;
            m6826a(context);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m6826a(Context context) {
            this.f6820h = context;
            this.f6818f = LayoutInflater.from(this.f6820h).inflate(R.layout.coui_list_bottom_sheet_dialog_layout, (ViewGroup) null);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public Dialog m6829a() {
            return this.f6817e.f6812a;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setTitle(CharSequence charSequence) {
            this.f6819g = charSequence;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setTitle(int OplusGLSurfaceView_13) {
            this.f6819g = this.f6820h.getString(OplusGLSurfaceView_13);
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m6835a(CharSequence[] charSequenceArr) {
            this.f6822j = charSequenceArr;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setMultiChoiceItems(int OplusGLSurfaceView_13, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f6821i = this.f6820h.getResources().getTextArray(OplusGLSurfaceView_13);
            this.f6813a = zArr;
            this.f6829q = true;
            this.f6815c = onMultiChoiceClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f6821i = charSequenceArr;
            this.f6813a = zArr;
            this.f6829q = true;
            this.f6815c = onMultiChoiceClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setSingleChoiceItems(int OplusGLSurfaceView_13, int i2, DialogInterface.OnClickListener onClickListener) {
            this.f6821i = this.f6820h.getResources().getTextArray(OplusGLSurfaceView_13);
            this.f6816d = onClickListener;
            this.f6814b = i2;
            this.f6829q = false;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setSingleChoiceItems(CharSequence[] charSequenceArr, int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            this.f6821i = charSequenceArr;
            this.f6816d = onClickListener;
            this.f6814b = OplusGLSurfaceView_13;
            this.f6829q = false;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m6834a(String str, View.OnClickListener onClickListener) {
            this.f6823k = str;
            this.f6824l = onClickListener;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public PlatformImplementations.kt_3 m6838b(String str, View.OnClickListener onClickListener) {
            this.f6827o = str;
            this.f6828p = onClickListener;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public COUIListBottomSheetDialog m6839b() throws Resources.NotFoundException, ClassNotFoundException {
            COUIBottomSheetChoiceListAdapter c1308a;
            this.f6817e.f6812a = new COUIBottomSheetDialog(this.f6820h, R.style.DefaultBottomSheetDialog);
            this.f6817e.f6812a.setContentView(this.f6818f);
            this.f6817e.f6812a.m6807a(this.f6830r);
            this.f6817e.f6812a.m6802a(this.f6831s);
            COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) this.f6817e.f6812a.findViewById(R.id_renamed.select_dialog_listview);
            COUIPanelPreferenceLinearLayoutManager cOUIPanelPreferenceLinearLayoutManager = new COUIPanelPreferenceLinearLayoutManager(this.f6820h);
            cOUIPanelPreferenceLinearLayoutManager.setOrientation(1);
            cOUIRecyclerView.setLayoutManager(cOUIPanelPreferenceLinearLayoutManager);
            cOUIRecyclerView.setItemAnimator(null);
            COUIToolbar cOUIToolbar = (COUIToolbar) this.f6817e.f6812a.findViewById(R.id_renamed.toolbar);
            cOUIToolbar.setTitle(this.f6819g);
            cOUIToolbar.setIsTitleCenterStyle(true);
            if (this.f6829q) {
                this.f6817e.f6812a.m6808a(true, this.f6823k, this.f6824l, this.f6825m, this.f6826n, this.f6827o, this.f6828p);
                ((LinearLayout.LayoutParams) cOUIRecyclerView.getLayoutParams()).bottomMargin = 0;
                c1308a = new COUIBottomSheetChoiceListAdapter(this.f6820h, R.layout.coui_select_dialog_multichoice, this.f6821i, this.f6822j, -1, this.f6813a, true);
            } else {
                c1308a = new COUIBottomSheetChoiceListAdapter(this.f6820h, R.layout.coui_select_dialog_singlechoice, this.f6821i, this.f6822j, this.f6814b);
            }
            this.f6817e.f6812a.m6812c().getDragView().setVisibility(4);
            cOUIRecyclerView.setAdapter(c1308a);
            c1308a.m6693a(new COUIBottomSheetChoiceListAdapter.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.1
                @Override // com.coui.appcompat.dialog.panel.COUIBottomSheetChoiceListAdapter.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6696a(View view, int OplusGLSurfaceView_13, int i2) {
                    if (PlatformImplementations.kt_3.this.f6829q) {
                        if (PlatformImplementations.kt_3.this.f6815c != null) {
                            PlatformImplementations.kt_3.this.f6815c.onClick(PlatformImplementations.kt_3.this.f6817e.f6812a, OplusGLSurfaceView_13, i2 == 2);
                        }
                    } else if (PlatformImplementations.kt_3.this.f6816d != null) {
                        PlatformImplementations.kt_3.this.f6816d.onClick(PlatformImplementations.kt_3.this.f6817e.f6812a, OplusGLSurfaceView_13);
                    }
                }
            });
            return this.f6817e;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6825a() {
        COUIBottomSheetDialog dialogC1309b = this.f6812a;
        if (dialogC1309b != null) {
            dialogC1309b.dismiss();
        }
    }
}
