package com.coui.appcompat.widget.popupwindow;

/* compiled from: COUIPopupWindow.java */
/* loaded from: classes.dex */
public class e_renamed extends com.coui.appcompat.widget.popupwindow.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.popupwindow.e_renamed.b_renamed f3063a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.popupwindow.e_renamed.a_renamed f3064b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f3065c;

    /* compiled from: COUIPopupWindow.java */
    public interface a_renamed {
        void a_renamed(com.coui.appcompat.widget.popupwindow.e_renamed eVar);

        void b_renamed(com.coui.appcompat.widget.popupwindow.e_renamed eVar);
    }

    /* compiled from: COUIPopupWindow.java */
    public interface b_renamed {
        void a_renamed(android.view.WindowManager.LayoutParams layoutParams);
    }

    public e_renamed(android.content.Context context) {
        this(context, null);
    }

    public e_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.popupWindowStyle);
    }

    public e_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public e_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f3063a = null;
        this.f3064b = null;
        this.f3065c = false;
    }

    public e_renamed() {
        this((android.view.View) null, 0, 0);
    }

    public e_renamed(android.view.View view, int i_renamed, int i2) {
        this(view, i_renamed, i2, false);
    }

    public e_renamed(android.view.View view, int i_renamed, int i2, boolean z_renamed) {
        super(view, i_renamed, i2, z_renamed);
        this.f3063a = null;
        this.f3064b = null;
        this.f3065c = false;
    }

    @Override // com.coui.appcompat.widget.popupwindow.b_renamed, android.widget.PopupWindow
    public void dismiss() {
        if (this.f3065c) {
            return;
        }
        this.f3065c = true;
        com.coui.appcompat.widget.popupwindow.e_renamed.a_renamed aVar = this.f3064b;
        if (aVar != null) {
            aVar.a_renamed(this);
        } else {
            b_renamed();
        }
    }

    @Override // com.coui.appcompat.widget.popupwindow.b_renamed
    void a_renamed(android.view.WindowManager.LayoutParams layoutParams) {
        com.coui.appcompat.widget.popupwindow.e_renamed.b_renamed bVar = this.f3063a;
        if (bVar != null) {
            bVar.a_renamed(layoutParams);
        }
        super.a_renamed(layoutParams);
    }

    public void a_renamed(com.coui.appcompat.widget.popupwindow.e_renamed.b_renamed bVar) {
        this.f3063a = bVar;
    }

    public void b_renamed() {
        super.dismiss();
        this.f3065c = false;
        com.coui.appcompat.widget.popupwindow.e_renamed.a_renamed aVar = this.f3064b;
        if (aVar != null) {
            aVar.b_renamed(this);
        }
    }
}
