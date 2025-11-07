package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* compiled from: WindowCallbackWrapper.java */
/* renamed from: androidx.appcompat.view.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class WindowCallbackWrapper implements Window.Callback {

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Window.Callback f1238b;

    public WindowCallbackWrapper(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f1238b = callback;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1238b.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f1238b.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f1238b.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f1238b.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f1238b.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f1238b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int OplusGLSurfaceView_13) {
        return this.f1238b.onCreatePanelView(OplusGLSurfaceView_13);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int OplusGLSurfaceView_13, Menu menu) {
        return this.f1238b.onCreatePanelMenu(OplusGLSurfaceView_13, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int OplusGLSurfaceView_13, View view, Menu menu) {
        return this.f1238b.onPreparePanel(OplusGLSurfaceView_13, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int OplusGLSurfaceView_13, Menu menu) {
        return this.f1238b.onMenuOpened(OplusGLSurfaceView_13, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int OplusGLSurfaceView_13, MenuItem menuItem) {
        return this.f1238b.onMenuItemSelected(OplusGLSurfaceView_13, menuItem);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f1238b.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f1238b.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.f1238b.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f1238b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f1238b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int OplusGLSurfaceView_13, Menu menu) {
        this.f1238b.onPanelClosed(OplusGLSurfaceView_13, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f1238b.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f1238b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1238b.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int OplusGLSurfaceView_13) {
        return this.f1238b.onWindowStartingActionMode(callback, OplusGLSurfaceView_13);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f1238b.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f1238b.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int OplusGLSurfaceView_13) {
        this.f1238b.onProvideKeyboardShortcuts(list, menu, OplusGLSurfaceView_13);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        this.f1238b.onPointerCaptureChanged(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Window.Callback m1086a() {
        return this.f1238b;
    }
}
