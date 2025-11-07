package com.google.android.apps.lens.library.base;

/* loaded from: classes.dex */
public class LensServiceBridge extends com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback.Stub implements android.content.ServiceConnection {
    private static final java.lang.String BIND_INTENT_ACTION = "com.google.android.apps.gsa.publicsearch.IPublicSearchService";
    private static final boolean DEBUG = false;
    private static final java.lang.String LENS_CLIENT_SESSION_TYPE = "LENS_SERVICE_SESSION";
    private static final java.lang.String TAG = "LensServiceBridge";
    private static final int TARGET_SERVICE_API_VERSION = 1;
    private final android.content.Context context;
    private com.google.android.apps.gsa.publicsearch.IPublicSearchService lensService;
    private volatile com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession lensServiceSession;
    private int serviceApiVersion;

    public LensServiceBridge(android.content.Context context) {
        this.context = context;
    }

    public boolean bindService() {
        ensureOnMainThread();
        android.content.Intent intent = new android.content.Intent(BIND_INTENT_ACTION);
        intent.setPackage("com.google.android.googlequicksearchbox");
        try {
            if (this.context.bindService(intent, this, 65)) {
                return true;
            }
            android.util.Log.e_renamed(TAG, "Unable to bind Lens service.");
            return false;
        } catch (java.lang.SecurityException unused) {
            android.util.Log.i_renamed(TAG, "Unable to bind Lens service due to security exception. Maybe the service is_renamed not available yet.");
            return false;
        }
    }

    public void unbindService() {
        ensureOnMainThread();
        endLensSession();
        this.context.unbindService(this);
        this.lensService = null;
        this.lensServiceSession = null;
        this.serviceApiVersion = 0;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        ensureOnMainThread();
        android.util.Log.i_renamed(TAG, "Lens service connected.");
        this.lensService = com.google.android.apps.gsa.publicsearch.IPublicSearchService.Stub.asInterface(iBinder);
        beginLensSession();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        ensureOnMainThread();
        android.util.Log.w_renamed(TAG, "Lens service disconnected.");
    }

    @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback
    public void onServiceEvent(byte[] bArr, com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper systemParcelableWrapper) {
        try {
            com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto from = com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto.parseFrom(bArr);
            if (from.getEventId() == 240 && from.hasExtension(com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceEvent.lensServiceEventData)) {
                this.serviceApiVersion = ((com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceEventData) from.getExtension(com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceEvent.lensServiceEventData)).getServiceApiVersion();
            }
        } catch (com.google.protobuf.nano.InvalidProtocolBufferNanoException e_renamed) {
            android.util.Log.e_renamed(TAG, "Unable to parse the protobuf.", e_renamed);
        }
    }

    public boolean prewarmLensActivity() {
        ensureOnMainThread();
        if (!isLensSessionReady()) {
            android.util.Log.i_renamed(TAG, "Lens session is_renamed not ready for prewarm.");
            return false;
        }
        try {
            this.lensServiceSession.onGenericClientEvent(com.google.protobuf.nano.MessageNano.toByteArray(new com.google.android.apps.gsa.search.shared.service.proto.nano.ClientEventProto().setEventId(347)));
            return true;
        } catch (android.os.RemoteException | java.lang.SecurityException e_renamed) {
            android.util.Log.e_renamed(TAG, "Unable to send prewarm signal.", e_renamed);
            return false;
        }
    }

    private boolean isLensSessionReady() {
        return (this.lensService == null || this.lensServiceSession == null || this.serviceApiVersion <= 0) ? false : true;
    }

    private void beginLensSession() {
        if (this.lensService == null) {
            return;
        }
        com.google.android.apps.gsa.search.shared.service.proto.nano.ClientEventProto eventId = new com.google.android.apps.gsa.search.shared.service.proto.nano.ClientEventProto().setEventId(348);
        eventId.setExtension(com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceClientEvent.lensServiceClientEventData, new com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceClientEventData().setTargetServiceApiVersion(1));
        try {
            this.lensServiceSession = this.lensService.beginSession(LENS_CLIENT_SESSION_TYPE, this, com.google.protobuf.nano.MessageNano.toByteArray(eventId));
        } catch (android.os.RemoteException | java.lang.SecurityException e_renamed) {
            android.util.Log.e_renamed(TAG, "Unable to begin Lens service session.", e_renamed);
        }
    }

    private void endLensSession() {
        if (this.lensService == null || this.lensServiceSession == null) {
            return;
        }
        try {
            this.lensServiceSession.onGenericClientEvent(com.google.protobuf.nano.MessageNano.toByteArray(new com.google.android.apps.gsa.search.shared.service.proto.nano.ClientEventProto().setEventId(345)));
        } catch (android.os.RemoteException | java.lang.SecurityException e_renamed) {
            android.util.Log.e_renamed(TAG, "Unable to end Lens service session.", e_renamed);
        }
    }

    private void ensureOnMainThread() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("This should be_renamed running on_renamed the main thread.");
        }
    }
}
