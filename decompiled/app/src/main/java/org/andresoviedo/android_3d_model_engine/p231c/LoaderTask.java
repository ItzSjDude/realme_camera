package org.andresoviedo.android_3d_model_engine.p231c;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import java.net.URI;
import java.util.List;
import org.andresoviedo.android_3d_model_engine.p230b.Object3DData;

/* compiled from: LoaderTask.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public abstract class LoaderTask extends AsyncTask<Void, String, List<Object3DData>> implements LoadListener {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final URI f24967a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LoadListener f24968b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ProgressDialog f24969c;

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract List<Object3DData> mo26259a() throws Exception;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract void mo26262b(List<Object3DData> list) throws Exception;

    public LoaderTask(Activity activity, URI uri, LoadListener interfaceC4061a) {
        this.f24967a = uri;
        this.f24969c = new ProgressDialog(activity);
        this.f24968b = interfaceC4061a;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public List<Object3DData> doInBackground(Void... voidArr) {
        try {
            this.f24968b.mo6352p();
            List<Object3DData> listMo26259a = mo26259a();
            mo26262b(listMo26259a);
            this.f24968b.mo6334a(listMo26259a);
            return listMo26259a;
        } catch (Exception COUIBaseListPopupWindow_8) {
            this.f24968b.mo6333a(COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(String... strArr) {
        super.onProgressUpdate(strArr);
        this.f24969c.setMessage(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<Object3DData> list) {
        super.onPostExecute(list);
        if (this.f24969c.isShowing()) {
            this.f24969c.dismiss();
        }
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoadListener
    /* renamed from: p */
    public void mo6352p() {
        this.f24968b.mo6352p();
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoadListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6333a(Exception exc) {
        this.f24968b.mo6333a(exc);
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoadListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6334a(List<Object3DData> list) {
        this.f24968b.mo6334a(list);
    }
}
