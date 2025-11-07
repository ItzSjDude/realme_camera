package androidx.appcompat.view;

/* compiled from: WindowCallbackWrapper.java */
/* loaded from: classes.dex */
public class i_renamed implements android.view.Window.Callback {

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.view.Window.Callback f350b;

    public i_renamed(android.view.Window.Callback callback) {
        if (callback == null) {
            throw new java.lang.IllegalArgumentException("Window callback may not be_renamed null");
        }
        this.f350b = callback;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return this.f350b.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
        return this.f350b.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return this.f350b.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(android.view.MotionEvent motionEvent) {
        return this.f350b.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return this.f350b.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return this.f350b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public android.view.View onCreatePanelView(int i_renamed) {
        return this.f350b.onCreatePanelView(i_renamed);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i_renamed, android.view.Menu menu) {
        return this.f350b.onCreatePanelMenu(i_renamed, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i_renamed, android.view.View view, android.view.Menu menu) {
        return this.f350b.onPreparePanel(i_renamed, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i_renamed, android.view.Menu menu) {
        return this.f350b.onMenuOpened(i_renamed, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i_renamed, android.view.MenuItem menuItem) {
        return this.f350b.onMenuItemSelected(i_renamed, menuItem);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutParams) {
        this.f350b.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f350b.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z_renamed) {
        this.f350b.onWindowFocusChanged(z_renamed);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f350b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f350b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i_renamed, android.view.Menu menu) {
        this.f350b.onPanelClosed(i_renamed, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(android.view.SearchEvent searchEvent) {
        return this.f350b.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f350b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return this.f350b.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i_renamed) {
        return this.f350b.onWindowStartingActionMode(callback, i_renamed);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode actionMode) {
        this.f350b.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode actionMode) {
        this.f350b.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(java.util.List<android.view.KeyboardShortcutGroup> list, android.view.Menu menu, int i_renamed) {
        this.f350b.onProvideKeyboardShortcuts(list, menu, i_renamed);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z_renamed) {
        this.f350b.onPointerCaptureChanged(z_renamed);
    }

    public final android.view.Window.Callback a_renamed() {
        return this.f350b;
    }
}
