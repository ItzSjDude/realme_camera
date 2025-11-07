package com.oplus.compat.os.storage;

/* loaded from: classes2.dex */
public class VolumeInfoNative {
    private static final java.lang.String TAG = "VolumeInfoNative";
    private android.os.storage.VolumeInfo mVolumeInfo;
    private java.lang.Object mVolumeInfoObj;

    private static java.lang.Object getFsUuidCompat(java.lang.Object obj) {
        return null;
    }

    private static java.lang.Object getIdCompat(java.lang.Object obj) {
        return null;
    }

    private static java.lang.Object getPathCompat(java.lang.Object obj) {
        return null;
    }

    private static java.lang.Object getStringPathCompat(java.lang.Object obj) {
        return null;
    }

    private static java.lang.Object isSdCompat(java.lang.Object obj) {
        return null;
    }

    private VolumeInfoNative() {
    }

    VolumeInfoNative(java.lang.Object obj) {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            this.mVolumeInfo = (android.os.storage.VolumeInfo) obj;
        } else {
            this.mVolumeInfoObj = obj;
        }
    }

    public java.lang.Object getVolumeInfo() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return this.mVolumeInfo;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return this.mVolumeInfoObj;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public java.lang.String getId() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return this.mVolumeInfo.getId();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return ((com.oplus.inner.os.storage.VolumeInfoWrapper) this.mVolumeInfoObj).getId();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.lang.String) getIdCompat(this.mVolumeInfoObj);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public java.io.File getPath() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return this.mVolumeInfo.getPath();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return ((com.oplus.inner.os.storage.VolumeInfoWrapper) this.mVolumeInfoObj).getPath();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.io.File) getPathCompat(this.mVolumeInfoObj);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public java.lang.String getStringPath() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return this.mVolumeInfo.path;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return ((com.oplus.inner.os.storage.VolumeInfoWrapper) this.mVolumeInfoObj).getStringPath();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.lang.String) getStringPathCompat(this.mVolumeInfoObj);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public java.lang.String getFsUuid() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return this.mVolumeInfo.getFsUuid();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return ((com.oplus.inner.os.storage.VolumeInfoWrapper) this.mVolumeInfoObj).getFsUuid();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.lang.String) getFsUuidCompat(this.mVolumeInfoObj);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public boolean isSd() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            android.os.storage.DiskInfo disk = this.mVolumeInfo.getDisk();
            return disk != null && disk.isSd();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return ((com.oplus.inner.os.storage.VolumeInfoWrapper) this.mVolumeInfoObj).isSd();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Boolean) isSdCompat(this.mVolumeInfoObj)).booleanValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
