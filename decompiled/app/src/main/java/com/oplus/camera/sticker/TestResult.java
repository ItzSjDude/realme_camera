package com.oplus.camera.sticker;

/* compiled from: StickerMediator.java */
/* loaded from: classes2.dex */
public class h_renamed implements com.oplus.camera.sticker.data.b_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.sticker.h_renamed f5473a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f5474b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.data.b_renamed f5475c;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.oplus.camera.sticker.a_renamed> d_renamed = new java.util.concurrent.ConcurrentHashMap<>();
    private boolean e_renamed = false;
    private boolean f_renamed = false;

    public static com.oplus.camera.sticker.h_renamed a_renamed(android.content.Context context) {
        if (f5473a == null) {
            synchronized (com.oplus.camera.sticker.h_renamed.class) {
                if (f5473a == null) {
                    com.oplus.camera.e_renamed.b_renamed("StickerMediator", "getInstance");
                    f5473a = new com.oplus.camera.sticker.h_renamed(context.getApplicationContext());
                }
            }
        }
        return f5473a;
    }

    private h_renamed(android.content.Context context) {
        this.f5474b = null;
        this.f5475c = null;
        com.oplus.camera.e_renamed.b_renamed("StickerMediator", "StickerMediator");
        this.f5474b = context;
        this.f5475c = new com.oplus.camera.sticker.data.b_renamed(context);
        this.f5475c.a_renamed(this);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.b_renamed("StickerMediator", "create, mbCreated: " + this.e_renamed + ", mbDataLoaded: " + this.f_renamed);
        com.oplus.camera.e_renamed.a_renamed("StickerMediator.create");
        com.oplus.camera.sticker.download.a_renamed.a_renamed().c_renamed(this.f5474b);
        if (!this.e_renamed) {
            this.f5475c.a_renamed();
            this.e_renamed = true;
            if (!this.f_renamed) {
                this.f5475c.d_renamed();
                com.oplus.camera.sticker.c_renamed.b_renamed.c_renamed(com.oplus.camera.sticker.c_renamed.b_renamed.k_renamed);
                this.f_renamed = true;
            }
        }
        com.oplus.camera.e_renamed.b_renamed("StickerMediator.create");
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("StickerMediator", "release, mIsCreated: " + this.e_renamed);
        if (this.e_renamed) {
            this.f5475c.b_renamed();
            this.e_renamed = false;
        }
    }

    public synchronized void a_renamed(com.oplus.camera.sticker.a_renamed aVar) {
        this.f5475c.f_renamed();
        if (aVar != null) {
            java.lang.String strValueOf = java.lang.String.valueOf(android.os.Binder.getCallingPid());
            if (this.d_renamed.get(strValueOf) != null) {
                this.d_renamed.remove(strValueOf);
            }
            this.d_renamed.put(strValueOf, aVar);
            com.oplus.camera.e_renamed.b_renamed("StickerMediator", "addStickerCallback, mStickerCallbacks.size: " + this.d_renamed.size());
        }
    }

    public synchronized void b_renamed(com.oplus.camera.sticker.a_renamed aVar) {
        java.lang.String strValueOf = java.lang.String.valueOf(android.os.Binder.getCallingPid());
        if (this.d_renamed.get(strValueOf) != null) {
            this.d_renamed.remove(strValueOf);
        }
        if (this.d_renamed.isEmpty()) {
            this.f5474b.stopService(new android.content.Intent(this.f5474b, (java.lang.Class<?>) com.oplus.camera.sticker.download.thumbnail.ThumbDownloadService.class));
            com.oplus.camera.e_renamed.b_renamed("StickerMediator", "removeStickerCallback, stop ThumbDownloadService");
        }
        com.oplus.camera.e_renamed.b_renamed("StickerMediator", "removeStickerCallback, mStickerCallbacks.size: " + this.d_renamed.size());
    }

    public void c_renamed() {
        this.f5475c.e_renamed();
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        com.oplus.camera.e_renamed.b_renamed("StickerMediator", "updateStickerDownloadTime, item: " + stickerItem);
        this.f5475c.a_renamed(stickerItem);
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        this.f5475c.a_renamed(stickerItem, z_renamed);
    }

    public void a_renamed(java.util.List<com.oplus.camera.sticker.data.StickerItem> list) {
        this.f5475c.a_renamed(list);
    }

    @Override // com.oplus.camera.sticker.data.b_renamed.a_renamed
    public void a_renamed(int i_renamed) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.camera.sticker.a_renamed>> it = this.d_renamed.entrySet().iterator();
        while (it.hasNext()) {
            try {
                com.oplus.camera.sticker.a_renamed value = it.next().getValue();
                if (value != null) {
                    value.a_renamed(i_renamed);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.camera.sticker.a_renamed>> it = this.d_renamed.entrySet().iterator();
        while (it.hasNext()) {
            try {
                com.oplus.camera.sticker.a_renamed value = it.next().getValue();
                if (value != null) {
                    value.b_renamed(stickerItem);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void c_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.camera.sticker.a_renamed>> it = this.d_renamed.entrySet().iterator();
        while (it.hasNext()) {
            try {
                com.oplus.camera.sticker.a_renamed value = it.next().getValue();
                if (value != null) {
                    value.c_renamed(stickerItem);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void d_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.camera.sticker.a_renamed>> it = this.d_renamed.entrySet().iterator();
        while (it.hasNext()) {
            try {
                com.oplus.camera.sticker.a_renamed value = it.next().getValue();
                if (value != null) {
                    value.a_renamed(stickerItem);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void d_renamed() {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.camera.sticker.a_renamed>> it = this.d_renamed.entrySet().iterator();
        while (it.hasNext()) {
            try {
                com.oplus.camera.sticker.a_renamed value = it.next().getValue();
                if (value != null) {
                    value.a_renamed();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.camera.sticker.a_renamed>> it = this.d_renamed.entrySet().iterator();
        while (it.hasNext()) {
            try {
                com.oplus.camera.sticker.a_renamed value = it.next().getValue();
                if (value != null) {
                    value.a_renamed(stickerItem, i_renamed);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public void b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.camera.sticker.a_renamed>> it = this.d_renamed.entrySet().iterator();
        while (it.hasNext()) {
            try {
                com.oplus.camera.sticker.a_renamed value = it.next().getValue();
                if (value != null) {
                    value.b_renamed(stickerItem, i_renamed);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }
}
