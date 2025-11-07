package com.google.android.material.tabs;

/* loaded from: classes.dex */
public final class TabLayoutMediator {
    private androidx.recyclerview.widget.RecyclerView.a_renamed<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;
    private com.google.android.material.tabs.TabLayoutMediator.TabLayoutOnPageChangeCallback onPageChangeCallback;
    private com.google.android.material.tabs.TabLayout.OnTabSelectedListener onTabSelectedListener;
    private androidx.recyclerview.widget.RecyclerView.c_renamed pagerAdapterObserver;
    private final boolean smoothScroll;
    private final com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy tabConfigurationStrategy;
    private final com.google.android.material.tabs.TabLayout tabLayout;
    private final androidx.viewpager2.widget.ViewPager2 viewPager;

    public interface TabConfigurationStrategy {
        void onConfigureTab(com.google.android.material.tabs.TabLayout.Tab tab, int i_renamed);
    }

    public TabLayoutMediator(com.google.android.material.tabs.TabLayout tabLayout, androidx.viewpager2.widget.ViewPager2 viewPager2, com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(com.google.android.material.tabs.TabLayout tabLayout, androidx.viewpager2.widget.ViewPager2 viewPager2, boolean z_renamed, com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z_renamed, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(com.google.android.material.tabs.TabLayout tabLayout, androidx.viewpager2.widget.ViewPager2 viewPager2, boolean z_renamed, boolean z2, com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy tabConfigurationStrategy) {
        this.tabLayout = tabLayout;
        this.viewPager = viewPager2;
        this.autoRefresh = z_renamed;
        this.smoothScroll = z2;
        this.tabConfigurationStrategy = tabConfigurationStrategy;
    }

    public void attach() {
        if (this.attached) {
            throw new java.lang.IllegalStateException("TabLayoutMediator is_renamed already attached");
        }
        this.adapter = this.viewPager.getAdapter();
        if (this.adapter == null) {
            throw new java.lang.IllegalStateException("TabLayoutMediator attached before ViewPager2 has an_renamed adapter");
        }
        this.attached = true;
        this.onPageChangeCallback = new com.google.android.material.tabs.TabLayoutMediator.TabLayoutOnPageChangeCallback(this.tabLayout);
        this.viewPager.a_renamed(this.onPageChangeCallback);
        this.onTabSelectedListener = new com.google.android.material.tabs.TabLayoutMediator.ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
        this.tabLayout.addOnTabSelectedListener(this.onTabSelectedListener);
        if (this.autoRefresh) {
            this.pagerAdapterObserver = new com.google.android.material.tabs.TabLayoutMediator.PagerAdapterObserver();
            this.adapter.registerAdapterDataObserver(this.pagerAdapterObserver);
        }
        populateTabsFromPagerAdapter();
        this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
    }

    public void detach() {
        androidx.recyclerview.widget.RecyclerView.a_renamed<?> aVar;
        if (this.autoRefresh && (aVar = this.adapter) != null) {
            aVar.unregisterAdapterDataObserver(this.pagerAdapterObserver);
            this.pagerAdapterObserver = null;
        }
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.b_renamed(this.onPageChangeCallback);
        this.onTabSelectedListener = null;
        this.onPageChangeCallback = null;
        this.adapter = null;
        this.attached = false;
    }

    void populateTabsFromPagerAdapter() {
        this.tabLayout.removeAllTabs();
        androidx.recyclerview.widget.RecyclerView.a_renamed<?> aVar = this.adapter;
        if (aVar != null) {
            int itemCount = aVar.getItemCount();
            for (int i_renamed = 0; i_renamed < itemCount; i_renamed++) {
                com.google.android.material.tabs.TabLayout.Tab tabNewTab = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(tabNewTab, i_renamed);
                this.tabLayout.addTab(tabNewTab, false);
            }
            if (itemCount > 0) {
                int iMin = java.lang.Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1);
                if (iMin != this.tabLayout.getSelectedTabPosition()) {
                    com.google.android.material.tabs.TabLayout tabLayout = this.tabLayout;
                    tabLayout.selectTab(tabLayout.getTabAt(iMin));
                }
            }
        }
    }

    private static class TabLayoutOnPageChangeCallback extends androidx.viewpager2.widget.ViewPager2.e_renamed {
        private int previousScrollState;
        private int scrollState;
        private final java.lang.ref.WeakReference<com.google.android.material.tabs.TabLayout> tabLayoutRef;

        TabLayoutOnPageChangeCallback(com.google.android.material.tabs.TabLayout tabLayout) {
            this.tabLayoutRef = new java.lang.ref.WeakReference<>(tabLayout);
            reset();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
        public void onPageScrollStateChanged(int i_renamed) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i_renamed;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
        public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
            com.google.android.material.tabs.TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.setScrollPosition(i_renamed, f_renamed, this.scrollState != 2 || this.previousScrollState == 1, (this.scrollState == 2 && this.previousScrollState == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
        public void onPageSelected(int i_renamed) {
            com.google.android.material.tabs.TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i_renamed || i_renamed >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.scrollState;
            tabLayout.selectTab(tabLayout.getTabAt(i_renamed), i2 == 0 || (i2 == 2 && this.previousScrollState == 0));
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    private static class ViewPagerOnTabSelectedListener implements com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
        private final boolean smoothScroll;
        private final androidx.viewpager2.widget.ViewPager2 viewPager;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        ViewPagerOnTabSelectedListener(androidx.viewpager2.widget.ViewPager2 viewPager2, boolean z_renamed) {
            this.viewPager = viewPager2;
            this.smoothScroll = z_renamed;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
            this.viewPager.a_renamed(tab.getPosition(), this.smoothScroll);
        }
    }

    private class PagerAdapterObserver extends androidx.recyclerview.widget.RecyclerView.c_renamed {
        PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onChanged() {
            com.google.android.material.tabs.TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeChanged(int i_renamed, int i2) {
            com.google.android.material.tabs.TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeChanged(int i_renamed, int i2, java.lang.Object obj) {
            com.google.android.material.tabs.TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeInserted(int i_renamed, int i2) {
            com.google.android.material.tabs.TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeRemoved(int i_renamed, int i2) {
            com.google.android.material.tabs.TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeMoved(int i_renamed, int i2, int i3) {
            com.google.android.material.tabs.TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }
}
