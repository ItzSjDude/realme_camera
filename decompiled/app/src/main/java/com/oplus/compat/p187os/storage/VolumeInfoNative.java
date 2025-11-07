package com.oplus.compat.p187os.storage;

import android.os.storage.DiskInfo;
import android.os.storage.VolumeInfo;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.storage.VolumeInfoWrapper;
import java.io.File;

/* loaded from: classes2.dex */
public class VolumeInfoNative {
    private static final String TAG = "VolumeInfoNative";
    private VolumeInfo mVolumeInfo;
    private Object mVolumeInfoObj;

    private static Object getFsUuidCompat(Object obj) {
        return null;
    }

    private static Object getIdCompat(Object obj) {
        return null;
    }

    private static Object getPathCompat(Object obj) {
        return null;
    }

    private static Object getStringPathCompat(Object obj) {
        return null;
    }

    private static Object isSdCompat(Object obj) {
        return null;
    }

    private VolumeInfoNative() {
    }

    VolumeInfoNative(Object obj) {
        if (VersionUtils.m24887c()) {
            this.mVolumeInfo = (VolumeInfo) obj;
        } else {
            this.mVolumeInfoObj = obj;
        }
    }

    public Object getVolumeInfo() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return this.mVolumeInfo;
        }
        if (VersionUtils.m24895k()) {
            return this.mVolumeInfoObj;
        }
        throw new UnSupportedApiVersionException();
    }

    public String getId() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return this.mVolumeInfo.getId();
        }
        if (VersionUtils.m24886b()) {
            return ((VolumeInfoWrapper) this.mVolumeInfoObj).getId();
        }
        if (VersionUtils.m24889e()) {
            return (String) getIdCompat(this.mVolumeInfoObj);
        }
        throw new UnSupportedApiVersionException();
    }

    public File getPath() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return this.mVolumeInfo.getPath();
        }
        if (VersionUtils.m24886b()) {
            return ((VolumeInfoWrapper) this.mVolumeInfoObj).getPath();
        }
        if (VersionUtils.m24889e()) {
            return (File) getPathCompat(this.mVolumeInfoObj);
        }
        throw new UnSupportedApiVersionException();
    }

    public String getStringPath() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return this.mVolumeInfo.path;
        }
        if (VersionUtils.m24886b()) {
            return ((VolumeInfoWrapper) this.mVolumeInfoObj).getStringPath();
        }
        if (VersionUtils.m24889e()) {
            return (String) getStringPathCompat(this.mVolumeInfoObj);
        }
        throw new UnSupportedApiVersionException();
    }

    public String getFsUuid() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return this.mVolumeInfo.getFsUuid();
        }
        if (VersionUtils.m24886b()) {
            return ((VolumeInfoWrapper) this.mVolumeInfoObj).getFsUuid();
        }
        if (VersionUtils.m24889e()) {
            return (String) getFsUuidCompat(this.mVolumeInfoObj);
        }
        throw new UnSupportedApiVersionException();
    }

    public boolean isSd() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            DiskInfo disk = this.mVolumeInfo.getDisk();
            return disk != null && disk.isSd();
        }
        if (VersionUtils.m24886b()) {
            return ((VolumeInfoWrapper) this.mVolumeInfoObj).isSd();
        }
        if (VersionUtils.m24889e()) {
            return ((Boolean) isSdCompat(this.mVolumeInfoObj)).booleanValue();
        }
        throw new UnSupportedApiVersionException();
    }
}
