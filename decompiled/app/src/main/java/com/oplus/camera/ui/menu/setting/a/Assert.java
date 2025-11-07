package com.oplus.camera.ui.menu.setting.a_renamed;

/* compiled from: ActivityDelegate.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.app.Activity f6585a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.camera.ui.menu.setting.a_renamed f6586b;

    public void a_renamed() {
    }

    public a_renamed(android.app.Activity activity) {
        this.f6585a = activity;
        this.f6586b = (com.oplus.camera.ui.menu.setting.a_renamed) this.f6585a;
    }

    public void a_renamed(androidx.appcompat.app.e_renamed eVar) {
        com.oplus.camera.ui.menu.setting.a_renamed.b_renamed.a_renamed(this.f6585a, this.f6586b.c_renamed());
    }

    public void b_renamed(androidx.appcompat.app.e_renamed eVar) {
        androidx.appcompat.app.a_renamed aVarA = eVar.a_renamed();
        if (aVarA != null) {
            aVarA.a_renamed(this.f6586b.a_renamed());
        }
        if (this.f6586b.h__renamed()) {
            com.oplus.camera.ui.menu.setting.a_renamed.c_renamed.a_renamed(this.f6585a);
        }
    }

    public void a_renamed(android.view.MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.f6585a.finish();
        }
    }
}
