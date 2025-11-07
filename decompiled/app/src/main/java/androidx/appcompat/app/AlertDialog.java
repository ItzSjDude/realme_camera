package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog.java */
/* renamed from: androidx.appcompat.app.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: PlatformImplementations.kt_3 */
    final AlertController f1006a;

    protected AlertDialog(Context context, int OplusGLSurfaceView_13) {
        super(context, m900a(context, OplusGLSurfaceView_13));
        this.f1006a = new AlertController(getContext(), this, getWindow());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m900a(Context context, int OplusGLSurfaceView_13) {
        if (((OplusGLSurfaceView_13 >>> 24) & 255) >= 1) {
            return OplusGLSurfaceView_13;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Button mo901a(int OplusGLSurfaceView_13) {
        return this.f1006a.m762d(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ListView mo902a() {
        return this.f1006a.m755b();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1006a.m753a(charSequence);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo905a(CharSequence charSequence) {
        this.f1006a.m758b(charSequence);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo904a(View view) {
        this.f1006a.m761c(view);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo903a(int OplusGLSurfaceView_13, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1006a.m750a(OplusGLSurfaceView_13, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1006a.m748a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (this.f1006a.m754a(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (this.f1006a.m759b(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        return super.onKeyUp(OplusGLSurfaceView_13, keyEvent);
    }

    /* compiled from: AlertDialog.java */
    /* renamed from: androidx.appcompat.app.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: P */
        private final AlertController.C0183a f1007P;
        private final int mTheme;

        public PlatformImplementations.kt_3(Context context) {
            this(context, AlertDialog.m900a(context, 0));
        }

        public PlatformImplementations.kt_3(Context context, int OplusGLSurfaceView_13) {
            this.f1007P = new AlertController.C0183a(new ContextThemeWrapper(context, AlertDialog.m900a(context, OplusGLSurfaceView_13)));
            this.mTheme = OplusGLSurfaceView_13;
        }

        public Context getContext() {
            return this.f1007P.f867a;
        }

        public PlatformImplementations.kt_3 setTitle(int OplusGLSurfaceView_13) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f872f = c0183a.f867a.getText(OplusGLSurfaceView_13);
            return this;
        }

        public PlatformImplementations.kt_3 setTitle(CharSequence charSequence) {
            this.f1007P.f872f = charSequence;
            return this;
        }

        public PlatformImplementations.kt_3 setCustomTitle(View view) {
            this.f1007P.f873g = view;
            return this;
        }

        public PlatformImplementations.kt_3 setMessage(int OplusGLSurfaceView_13) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f874h = c0183a.f867a.getText(OplusGLSurfaceView_13);
            return this;
        }

        public PlatformImplementations.kt_3 setMessage(CharSequence charSequence) {
            this.f1007P.f874h = charSequence;
            return this;
        }

        public PlatformImplementations.kt_3 setIcon(int OplusGLSurfaceView_13) {
            this.f1007P.f869c = OplusGLSurfaceView_13;
            return this;
        }

        public PlatformImplementations.kt_3 setIcon(Drawable drawable) {
            this.f1007P.f870d = drawable;
            return this;
        }

        public PlatformImplementations.kt_3 setIconAttribute(int OplusGLSurfaceView_13) {
            TypedValue typedValue = new TypedValue();
            this.f1007P.f867a.getTheme().resolveAttribute(OplusGLSurfaceView_13, typedValue, true);
            this.f1007P.f869c = typedValue.resourceId;
            return this;
        }

        public PlatformImplementations.kt_3 setPositiveButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f875i = c0183a.f867a.getText(OplusGLSurfaceView_13);
            this.f1007P.f877k = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f875i = charSequence;
            c0183a.f877k = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setPositiveButtonIcon(Drawable drawable) {
            this.f1007P.f876j = drawable;
            return this;
        }

        public PlatformImplementations.kt_3 setNegativeButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f878l = c0183a.f867a.getText(OplusGLSurfaceView_13);
            this.f1007P.f880n = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f878l = charSequence;
            c0183a.f880n = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setNegativeButtonIcon(Drawable drawable) {
            this.f1007P.f879m = drawable;
            return this;
        }

        public PlatformImplementations.kt_3 setNeutralButton(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f881o = c0183a.f867a.getText(OplusGLSurfaceView_13);
            this.f1007P.f883q = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f881o = charSequence;
            c0183a.f883q = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setNeutralButtonIcon(Drawable drawable) {
            this.f1007P.f882p = drawable;
            return this;
        }

        public PlatformImplementations.kt_3 setCancelable(boolean z) {
            this.f1007P.f884r = z;
            return this;
        }

        public PlatformImplementations.kt_3 setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f1007P.f885s = onCancelListener;
            return this;
        }

        public PlatformImplementations.kt_3 setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f1007P.f886t = onDismissListener;
            return this;
        }

        public PlatformImplementations.kt_3 setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f1007P.f887u = onKeyListener;
            return this;
        }

        public PlatformImplementations.kt_3 setItems(int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f888v = c0183a.f867a.getResources().getTextArray(OplusGLSurfaceView_13);
            this.f1007P.f890x = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f888v = charSequenceArr;
            c0183a.f890x = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f889w = listAdapter;
            c0183a.f890x = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f860K = cursor;
            c0183a.f861L = str;
            c0183a.f890x = onClickListener;
            return this;
        }

        public PlatformImplementations.kt_3 setMultiChoiceItems(int OplusGLSurfaceView_13, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f888v = c0183a.f867a.getResources().getTextArray(OplusGLSurfaceView_13);
            AlertController.C0183a c0183a2 = this.f1007P;
            c0183a2.f859J = onMultiChoiceClickListener;
            c0183a2.f855F = zArr;
            c0183a2.f856G = true;
            return this;
        }

        public PlatformImplementations.kt_3 setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f888v = charSequenceArr;
            c0183a.f859J = onMultiChoiceClickListener;
            c0183a.f855F = zArr;
            c0183a.f856G = true;
            return this;
        }

        public PlatformImplementations.kt_3 setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f860K = cursor;
            c0183a.f859J = onMultiChoiceClickListener;
            c0183a.f862M = str;
            c0183a.f861L = str2;
            c0183a.f856G = true;
            return this;
        }

        public PlatformImplementations.kt_3 setSingleChoiceItems(int OplusGLSurfaceView_13, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f888v = c0183a.f867a.getResources().getTextArray(OplusGLSurfaceView_13);
            AlertController.C0183a c0183a2 = this.f1007P;
            c0183a2.f890x = onClickListener;
            c0183a2.f858I = i2;
            c0183a2.f857H = true;
            return this;
        }

        public PlatformImplementations.kt_3 setSingleChoiceItems(Cursor cursor, int OplusGLSurfaceView_13, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f860K = cursor;
            c0183a.f890x = onClickListener;
            c0183a.f858I = OplusGLSurfaceView_13;
            c0183a.f861L = str;
            c0183a.f857H = true;
            return this;
        }

        public PlatformImplementations.kt_3 setSingleChoiceItems(CharSequence[] charSequenceArr, int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f888v = charSequenceArr;
            c0183a.f890x = onClickListener;
            c0183a.f858I = OplusGLSurfaceView_13;
            c0183a.f857H = true;
            return this;
        }

        public PlatformImplementations.kt_3 setSingleChoiceItems(ListAdapter listAdapter, int OplusGLSurfaceView_13, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f889w = listAdapter;
            c0183a.f890x = onClickListener;
            c0183a.f858I = OplusGLSurfaceView_13;
            c0183a.f857H = true;
            return this;
        }

        public PlatformImplementations.kt_3 setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f1007P.f864O = onItemSelectedListener;
            return this;
        }

        public PlatformImplementations.kt_3 setView(int OplusGLSurfaceView_13) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f892z = null;
            c0183a.f891y = OplusGLSurfaceView_13;
            c0183a.f854E = false;
            return this;
        }

        public PlatformImplementations.kt_3 setView(View view) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f892z = view;
            c0183a.f891y = 0;
            c0183a.f854E = false;
            return this;
        }

        @Deprecated
        public PlatformImplementations.kt_3 setView(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            AlertController.C0183a c0183a = this.f1007P;
            c0183a.f892z = view;
            c0183a.f891y = 0;
            c0183a.f854E = true;
            c0183a.f850A = OplusGLSurfaceView_13;
            c0183a.f851B = i2;
            c0183a.f852C = i3;
            c0183a.f853D = i4;
            return this;
        }

        @Deprecated
        public PlatformImplementations.kt_3 setInverseBackgroundForced(boolean z) {
            this.f1007P.f863N = z;
            return this;
        }

        public PlatformImplementations.kt_3 setRecycleOnMeasureEnabled(boolean z) {
            this.f1007P.f866Q = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog dialogInterfaceC0204b = new AlertDialog(this.f1007P.f867a, this.mTheme);
            this.f1007P.m766a(dialogInterfaceC0204b.f1006a);
            dialogInterfaceC0204b.setCancelable(this.f1007P.f884r);
            if (this.f1007P.f884r) {
                dialogInterfaceC0204b.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC0204b.setOnCancelListener(this.f1007P.f885s);
            dialogInterfaceC0204b.setOnDismissListener(this.f1007P.f886t);
            if (this.f1007P.f887u != null) {
                dialogInterfaceC0204b.setOnKeyListener(this.f1007P.f887u);
            }
            return dialogInterfaceC0204b;
        }

        public AlertDialog show() {
            AlertDialog dialogInterfaceC0204bCreate = create();
            dialogInterfaceC0204bCreate.show();
            return dialogInterfaceC0204bCreate;
        }
    }
}
