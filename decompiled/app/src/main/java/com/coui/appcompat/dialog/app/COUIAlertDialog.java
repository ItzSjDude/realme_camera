package com.coui.appcompat.dialog.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import com.coui.appcompat.dialog.app.COUIAlertController;
import coui.support.appcompat.R;

/* compiled from: COUIAlertDialog.java */
/* renamed from: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class COUIAlertDialog extends AlertDialog implements DialogInterface {

    /* renamed from: IntrinsicsJvm.kt_4 */
    final AlertController f6562b;

    protected COUIAlertDialog(Context context) {
        this(context, 0);
    }

    protected COUIAlertDialog(Context context, int OplusGLSurfaceView_13) {
        super(context, m6559b(context, OplusGLSurfaceView_13));
        this.f6562b = new COUIAlertController(getContext(), this, getWindow());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static int m6559b(Context context, int OplusGLSurfaceView_13) {
        if (((OplusGLSurfaceView_13 >>> 24) & 255) >= 1) {
            return OplusGLSurfaceView_13;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.couiAlertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.AlertDialog
    /* renamed from: PlatformImplementations.kt_3 */
    public Button mo901a(int OplusGLSurfaceView_13) {
        return this.f6562b.m6553d(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.app.AlertDialog
    /* renamed from: PlatformImplementations.kt_3 */
    public ListView mo902a() {
        return this.f6562b.m6551c();
    }

    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f6562b.m6544a(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo905a(CharSequence charSequence) {
        this.f6562b.m6548b(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo904a(View view) {
        this.f6562b.m6552c(view);
    }

    @Override // androidx.appcompat.app.AlertDialog
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo903a(int OplusGLSurfaceView_13, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f6562b.m6540a(OplusGLSurfaceView_13, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        AlertController c1288a = this.f6562b;
        if (c1288a instanceof COUIAlertController) {
            ((COUIAlertController) c1288a).m6523a(z);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        AlertController c1288a = this.f6562b;
        if (c1288a instanceof COUIAlertController) {
            ((COUIAlertController) c1288a).m6523a(z);
        }
    }

    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        this.f6562b.m6538a();
    }

    @Override // androidx.appcompat.app.AlertDialog, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (this.f6562b.m6545a(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // androidx.appcompat.app.AlertDialog, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (this.f6562b.m6549b(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        return super.onKeyUp(OplusGLSurfaceView_13, keyEvent);
    }

    /* compiled from: COUIAlertDialog.java */
    /* renamed from: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends AlertDialog.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final COUIAlertController.C1287a f6563a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f6564b;

        public PlatformImplementations.kt_3(Context context) {
            this(context, COUIAlertDialog.m6559b(context, 0));
        }

        public PlatformImplementations.kt_3(Context context, int OplusGLSurfaceView_13) {
            super(context, OplusGLSurfaceView_13);
            this.f6563a = new COUIAlertController.C1287a(new ContextThemeWrapper(context, COUIAlertDialog.m6559b(context, OplusGLSurfaceView_13)));
            this.f6564b = OplusGLSurfaceView_13;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        public Context getContext() {
            return this.f6563a.f6515a;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setTitle(int OplusGLSurfaceView_13) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6520f = c1287a.f6515a.getText(OplusGLSurfaceView_13);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setTitle(CharSequence charSequence) {
            this.f6563a.f6520f = charSequence;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setCustomTitle(View view) {
            this.f6563a.f6521g = view;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setMessage(int OplusGLSurfaceView_13) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6522h = c1287a.f6515a.getText(OplusGLSurfaceView_13);
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setMessage(CharSequence charSequence) {
            this.f6563a.f6522h = charSequence;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setIcon(int OplusGLSurfaceView_13) {
            this.f6563a.f6517c = OplusGLSurfaceView_13;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setIcon(Drawable drawable) {
            this.f6563a.f6518d = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setIconAttribute(int OplusGLSurfaceView_13) {
            TypedValue typedValue = new TypedValue();
            this.f6563a.f6515a.getTheme().resolveAttribute(OplusGLSurfaceView_13, typedValue, true);
            this.f6563a.f6517c = typedValue.resourceId;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setPositiveButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6523i = c1287a.f6515a.getText(OplusGLSurfaceView_13);
            this.f6563a.f6525k = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6523i = charSequence;
            c1287a.f6525k = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setPositiveButtonIcon(Drawable drawable) {
            this.f6563a.f6524j = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setNegativeButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6526l = c1287a.f6515a.getText(OplusGLSurfaceView_13);
            this.f6563a.f6528n = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6526l = charSequence;
            c1287a.f6528n = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setNegativeButtonIcon(Drawable drawable) {
            this.f6563a.f6527m = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setNeutralButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6529o = c1287a.f6515a.getText(OplusGLSurfaceView_13);
            this.f6563a.f6531q = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6529o = charSequence;
            c1287a.f6531q = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setNeutralButtonIcon(Drawable drawable) {
            this.f6563a.f6530p = drawable;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setCancelable(boolean z) {
            this.f6563a.f6532r = z;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f6563a.f6534t = onCancelListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f6563a.f6535u = onDismissListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f6563a.f6536v = onKeyListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setItems(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6537w = c1287a.f6515a.getResources().getTextArray(OplusGLSurfaceView_13);
            this.f6563a.f6494A = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6537w = charSequenceArr;
            c1287a.f6494A = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6540z = listAdapter;
            c1287a.f6494A = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6507N = cursor;
            c1287a.f6508O = str;
            c1287a.f6494A = onClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setMultiChoiceItems(int OplusGLSurfaceView_13, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6537w = c1287a.f6515a.getResources().getTextArray(OplusGLSurfaceView_13);
            COUIAlertController.C1287a c1287a2 = this.f6563a;
            c1287a2.f6506M = onMultiChoiceClickListener;
            c1287a2.f6502I = zArr;
            c1287a2.f6503J = true;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6537w = charSequenceArr;
            c1287a.f6506M = onMultiChoiceClickListener;
            c1287a.f6502I = zArr;
            c1287a.f6503J = true;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6507N = cursor;
            c1287a.f6506M = onMultiChoiceClickListener;
            c1287a.f6509P = str;
            c1287a.f6508O = str2;
            c1287a.f6503J = true;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setSingleChoiceItems(int OplusGLSurfaceView_13, int i2, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6537w = c1287a.f6515a.getResources().getTextArray(OplusGLSurfaceView_13);
            COUIAlertController.C1287a c1287a2 = this.f6563a;
            c1287a2.f6494A = onClickListener;
            c1287a2.f6505L = i2;
            c1287a2.f6504K = true;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setSingleChoiceItems(Cursor cursor, int OplusGLSurfaceView_13, String str, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6507N = cursor;
            c1287a.f6494A = onClickListener;
            c1287a.f6505L = OplusGLSurfaceView_13;
            c1287a.f6508O = str;
            c1287a.f6504K = true;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setSingleChoiceItems(CharSequence[] charSequenceArr, int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6537w = charSequenceArr;
            c1287a.f6494A = onClickListener;
            c1287a.f6505L = OplusGLSurfaceView_13;
            c1287a.f6504K = true;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setSingleChoiceItems(ListAdapter listAdapter, int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6540z = listAdapter;
            c1287a.f6494A = onClickListener;
            c1287a.f6505L = OplusGLSurfaceView_13;
            c1287a.f6504K = true;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f6563a.f6511R = onItemSelectedListener;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_8, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setView(int OplusGLSurfaceView_13) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6496C = null;
            c1287a.f6495B = OplusGLSurfaceView_13;
            c1287a.f6501H = false;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setView(View view) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6496C = view;
            c1287a.f6495B = 0;
            c1287a.f6501H = false;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        @Deprecated
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setView(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            COUIAlertController.C1287a c1287a = this.f6563a;
            c1287a.f6496C = view;
            c1287a.f6495B = 0;
            c1287a.f6501H = true;
            c1287a.f6497D = OplusGLSurfaceView_13;
            c1287a.f6498E = i2;
            c1287a.f6499F = i3;
            c1287a.f6500G = i4;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        @Deprecated
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setInverseBackgroundForced(boolean z) {
            this.f6563a.f6510Q = z;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 setRecycleOnMeasureEnabled(boolean z) {
            this.f6563a.f6513T = z;
            return this;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public PlatformImplementations.kt_3 m6600f(int OplusGLSurfaceView_13) {
            this.f6563a.f6514U = OplusGLSurfaceView_13;
            return this;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public COUIAlertDialog create() {
            COUIAlertDialog dialogInterfaceC1289b = new COUIAlertDialog(this.f6563a.f6515a, this.f6564b);
            this.f6563a.mo6530a(dialogInterfaceC1289b.f6562b);
            dialogInterfaceC1289b.setCancelable(this.f6563a.f6532r);
            if (this.f6563a.f6532r) {
                dialogInterfaceC1289b.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC1289b.setOnCancelListener(this.f6563a.f6534t);
            dialogInterfaceC1289b.setOnDismissListener(this.f6563a.f6535u);
            if (this.f6563a.f6536v != null) {
                dialogInterfaceC1289b.setOnKeyListener(this.f6563a.f6536v);
            }
            return dialogInterfaceC1289b;
        }

        @Override // androidx.appcompat.app.AlertDialog.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
        public COUIAlertDialog show() {
            COUIAlertDialog dialogInterfaceC1289bCreate = create();
            dialogInterfaceC1289bCreate.show();
            return dialogInterfaceC1289bCreate;
        }
    }
}
