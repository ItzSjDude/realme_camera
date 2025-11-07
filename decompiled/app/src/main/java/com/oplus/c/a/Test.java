package com.oplus.c_renamed.a_renamed;

/* compiled from: LightVideoPlayer.kt */
/* loaded from: classes2.dex */
public final class d_renamed implements com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed f3766a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.content.Context f3767b;

    /* compiled from: LightVideoPlayer.kt */
    public enum a_renamed {
        TBL,
        MEDIA_PLAYER
    }

    public d_renamed(android.content.Context context, com.oplus.c_renamed.a_renamed.d_renamed.a_renamed aVar) {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed cVar;
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(aVar, com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE);
        this.f3767b = context;
        int i_renamed = com.oplus.c_renamed.a_renamed.e_renamed.f3789a[aVar.ordinal()];
        if (i_renamed == 1) {
            cVar = new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.c_renamed(this.f3767b);
        } else {
            if (i_renamed != 2) {
                throw new c_renamed.k_renamed();
            }
            cVar = new com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.d_renamed(this.f3767b);
        }
        this.f3766a = cVar;
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed(android.net.Uri uri, android.view.Surface surface, com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed.a_renamed aVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(uri, com.android.providers.downloads.Downloads.Impl.COLUMN_URI);
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(surface, "surface");
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        if (bVar != null) {
            bVar.a_renamed(uri, surface, aVar);
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed() {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        if (bVar != null) {
            bVar.a_renamed();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void b_renamed() {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        if (bVar != null) {
            bVar.b_renamed();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void a_renamed(float f_renamed) {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        if (bVar != null) {
            bVar.a_renamed(f_renamed);
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void c_renamed() {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        if (bVar != null) {
            bVar.c_renamed();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void d_renamed() {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        if (bVar != null) {
            bVar.d_renamed();
        }
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public boolean e_renamed() {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        return bVar != null && bVar.e_renamed();
    }

    @Override // com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed
    public void f_renamed() {
        com.oplus.c_renamed.a_renamed.d_renamed.b_renamed.b_renamed bVar = this.f3766a;
        if (bVar != null) {
            bVar.f_renamed();
        }
    }
}
