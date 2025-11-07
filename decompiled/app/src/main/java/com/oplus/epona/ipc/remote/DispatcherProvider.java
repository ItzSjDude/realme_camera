package com.oplus.epona.ipc.remote;

/* loaded from: classes2.dex */
public class DispatcherProvider extends android.content.ContentProvider {
    private static final java.lang.String SECURITY_PERMISSION = "com.oplus.permission.safe.SECURITY";
    private static final java.lang.String TAG = "DispatcherProvider";

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        if (!hasPermission()) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "<QUERY> Calling package : [" + getCallingPackage() + "] have no permission : " + SECURITY_PERMISSION, new java.lang.Object[0]);
            return null;
        }
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        if (pathSegments != null && pathSegments.size() > 0) {
            if (com.oplus.epona.utils.ProviderUtils.FIND_TRANSFER.equals(pathSegments.get(0))) {
                android.os.Bundle bundle = new android.os.Bundle();
                if (pathSegments.size() > 1) {
                    bundle.putBinder(com.oplus.epona.Constants.TRANSFER_VALUE, com.oplus.epona.ipc.remote.Dispatcher.getInstance().findRemoteTransfer(pathSegments.get(1)));
                    return com.oplus.epona.ipc.cursor.ProviderCursor.generateCursor(bundle);
                }
                com.oplus.epona.utils.Logger.e_renamed(TAG, "Get ComponentName error : " + uri, new java.lang.Object[0]);
                return null;
            }
            com.oplus.epona.utils.Logger.e_renamed(TAG, "The path is_renamed not /find_transfer : " + pathSegments.get(0), new java.lang.Object[0]);
        } else {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "Could not find the uri : " + uri, new java.lang.Object[0]);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public android.os.Bundle call(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        if (!hasPermission()) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "<CALL> Calling package : [" + getCallingPackage() + "] have no permission : " + SECURITY_PERMISSION, new java.lang.Object[0]);
            return null;
        }
        if (android.text.TextUtils.equals(str, com.oplus.epona.Constants.FIND_TRANSFER)) {
            return findTransfer(bundle);
        }
        if (android.text.TextUtils.equals(str, com.oplus.epona.Constants.REGISTER_TRANSFER)) {
            return registerTransfer(bundle, getCallingPackage());
        }
        return super.call(str, str2, bundle);
    }

    private android.os.Bundle findTransfer(android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        if (bundle != null) {
            bundle2.putBinder(com.oplus.epona.Constants.TRANSFER_VALUE, com.oplus.epona.ipc.remote.Dispatcher.getInstance().findRemoteTransfer(bundle.getString(com.oplus.epona.Constants.TRANSFER_KEY)));
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public void dump(java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        java.util.Objects.requireNonNull(strArr);
        com.oplus.epona.Dumper dumper = com.oplus.epona.Epona.getDumper().get(strArr[0]);
        if (dumper != null) {
            dumper.dump(fileDescriptor, printWriter, strArr);
        }
    }

    private android.os.Bundle registerTransfer(android.os.Bundle bundle, java.lang.String str) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        if (bundle != null) {
            bundle2.putBoolean(com.oplus.epona.Constants.REGISTER_TRANSFER_RESULT_KEY, com.oplus.epona.ipc.remote.Dispatcher.getInstance().registerRemoteTransfer(bundle.getString(com.oplus.epona.Constants.TRANSFER_KEY), bundle.getBinder(com.oplus.epona.Constants.TRANSFER_VALUE), str));
        }
        return bundle2;
    }

    private boolean hasPermission() {
        return getContext().checkCallingPermission(SECURITY_PERMISSION) == 0;
    }
}
