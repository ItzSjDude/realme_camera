package com.oplus.camera.entry;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.MyApplication;
import com.oplus.camera.statistics.model.PreviewStaticInfoMsgData;

/* loaded from: classes2.dex */
public class EntryProvider extends ContentProvider implements CameraConstant {

    /* renamed from: COUIBaseListPopupWindow_11 */
    CameraInfoCursor f13543g = null;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (this.f13543g == null) {
            this.f13543g = new CameraInfoCursor();
            ((MyApplication) getContext().getApplicationContext()).m11104i();
            this.f13543g.m13364a();
            this.f13543g.m13365b();
            this.f13543g.m13366c();
            this.f13543g.m13367d();
            this.f13543g.m13368e();
        }
        String path = uri.getPath();
        CameraLog.m12967f("EntryProvider", "query, uri path: " + path);
        if (path == null || !path.contains(PreviewStaticInfoMsgData.EVENT_STATIC_INFO)) {
            return null;
        }
        return this.f13543g;
    }
}
