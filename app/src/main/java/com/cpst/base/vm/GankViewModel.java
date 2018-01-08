package com.cpst.base.vm;

import com.cpst.base.adapter.GankAdapter;
import com.cpst.base.base.BaseFragment;
import com.cpst.base.network.ErrorHanding;
import com.cpst.base.network.GankRequest;


/**
 * Created by wy on 2017/11/25.
 * 干货的ViewModel
 */

public class GankViewModel {
    private GankAdapter adapter = new GankAdapter();
    private int page = 1;
    private BaseFragment mFragment;

    public GankViewModel(BaseFragment baseFragment, GankAdapter adapter) {
        this.mFragment = baseFragment;
        this.adapter = adapter;
    }

    public void getDate(boolean isRefresh, String category ){
        if(isRefresh) {
            //初始化，需要加载Shimmer动画、
            mFragment.showLoading();
            page = 1;
        }
        GankRequest.getDate(category,10,page)
                .subscribe(list -> {
                    mFragment.showContent();
                    if (isRefresh){
                        adapter.setNewData(list.getResults());
                    }else {
                        adapter.addData(list.getResults());
                    }
                    adapter.loadMoreComplete();
                    page++;
                }, throwable -> {
                   if(isRefresh) {
                       mFragment.showError(ErrorHanding.handError(throwable));
                   }else {
                       adapter.loadMoreFail();
                   }
                });
    }
}
