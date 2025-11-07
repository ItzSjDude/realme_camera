package com.google.android.apps.lens.library.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.apps.gsa.publicsearch.IPublicSearchService;
import com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession;
import com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback;
import com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper;
import com.google.android.apps.gsa.search.shared.service.proto.nano.ClientEventProto;
import com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceClientEvent;
import com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceClientEventData;
import com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceEvent;
import com.google.android.apps.gsa.search.shared.service.proto.nano.LensServiceEventData;
import com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventProto;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;

/* loaded from: classes.dex */
public class LensServiceBridge extends IPublicSearchServiceSessionCallback.Stub implements ServiceConnection {
    private static final String BIND_INTENT_ACTION = "com.google.android.apps.gsa.publicsearch.IPublicSearchService";
    private static final boolean DEBUG = false;
    private static final String LENS_CLIENT_SESSION_TYPE = "LENS_SERVICE_SESSION";
    private static final String TAG = "LensServiceBridge";
    private static final int TARGET_SERVICE_API_VERSION = 1;
    private final Context context;
    private IPublicSearchService lensService;
    private volatile IPublicSearchServiceSession lensServiceSession;
    private int serviceApiVersion;

    public LensServiceBridge(Context context) {
        this.context = context;
    }

    public boolean bindService() {
        ensureOnMainThread();
        Intent intent = new Intent(BIND_INTENT_ACTION);
        intent.setPackage("com.google.android.googlequicksearchbox");
        try {
            if (this.context.bindService(intent, this, 65)) {
                return true;
            }
            Log.COUIBaseListPopupWindow_8(TAG, "Unable to bind Lens service.");
            return false;
        } catch (SecurityException unused) {
            Log.OplusGLSurfaceView_13(TAG, "Unable to bind Lens service due to security exception. Maybe the service is not available yet.");
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
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ensureOnMainThread();
        Log.OplusGLSurfaceView_13(TAG, "Lens service connected.");
        this.lensService = IPublicSearchService.Stub.asInterface(iBinder);
        beginLensSession();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ensureOnMainThread();
        Log.w(TAG, "Lens service disconnected.");
    }

    @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback
    public void onServiceEvent(byte[] bArr, SystemParcelableWrapper systemParcelableWrapper) {
        try {
            ServiceEventProto from = ServiceEventProto.parseFrom(bArr);
            if (from.getEventId() == 240 && from.hasExtension(LensServiceEvent.lensServiceEventData)) {
                this.serviceApiVersion = ((LensServiceEventData) from.getExtension(LensServiceEvent.lensServiceEventData)).getServiceApiVersion();
            }
        } catch (InvalidProtocolBufferNanoException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "Unable to parse the protobuf.", COUIBaseListPopupWindow_8);
        }
    }

    public boolean prewarmLensActivity() {
        ensureOnMainThread();
        if (!isLensSessionReady()) {
            Log.OplusGLSurfaceView_13(TAG, "Lens session is not ready for prewarm.");
            return false;
        }
        try {
            this.lensServiceSession.onGenericClientEvent(MessageNano.toByteArray(new ClientEventProto().setEventId(347)));
            return true;
        } catch (RemoteException | SecurityException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "Unable to send prewarm signal.", COUIBaseListPopupWindow_8);
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
        ClientEventProto eventId = new ClientEventProto().setEventId(348);
        eventId.setExtension(LensServiceClientEvent.lensServiceClientEventData, new LensServiceClientEventData().setTargetServiceApiVersion(1));
        try {
            this.lensServiceSession = this.lensService.beginSession(LENS_CLIENT_SESSION_TYPE, this, MessageNano.toByteArray(eventId));
        } catch (RemoteException | SecurityException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "Unable to begin Lens service session.", COUIBaseListPopupWindow_8);
        }
    }

    private void endLensSession() {
        if (this.lensService == null || this.lensServiceSession == null) {
            return;
        }
        try {
            this.lensServiceSession.onGenericClientEvent(MessageNano.toByteArray(new ClientEventProto().setEventId(345)));
        } catch (RemoteException | SecurityException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "Unable to end Lens service session.", COUIBaseListPopupWindow_8);
        }
    }

    private void ensureOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("This should be running on the main thread.");
        }
    }
}
