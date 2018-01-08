package com.cpst.base.view.fragment;

import android.view.View;

import com.cpst.base.R;
import com.cpst.base.base.BaseFragment;
import com.cpst.base.databinding.FragmentJokesBinding;
import com.cpst.base.utils.EmsDialog;
import com.cpst.base.utils.ViewUtils;

/**
 * 段子fragment
 * 进度条、dialog的使用。
 */
public class JokesFragment extends BaseFragment<FragmentJokesBinding> {
    public EmsDialog dialog;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_jokes;
    }

    @Override
    protected void init() {
        /**
         * 开始动画，点击屏幕不能获得焦点，只能点击返回键停止
         */
        mBinding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ViewUtils.showLoading(getActivity(), "");
            }
        });

        /**
         * 停止动画,根据需要在程序中调用
         */
        mBinding.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ViewUtils.isLoadingDialogShow()) {
                    ViewUtils.dismissLoading();
                }
            }
        });

        /**
         * 一个按钮，点击确定，可以继续调用方法
         */
        mBinding.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new EmsDialog(getActivity());
                dialog.setTitle("提示").setMessage("成功").isFirst(true).setOkText("确定ENT").show();
            }
        });

        /**
         * 两个按钮，点击不同按钮，分别执行不同方法
         */
        mBinding.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new EmsDialog(getActivity());
                dialog.setTitle("提示").setMessage("可以吗？").isFirst(false)
                        .isTrue(true).setCancelClick(new EmsDialog.ClickListener() {
                    @Override
                    public void click(View v) {
                        dialog.dismiss();
                    }
                }).setConfirmClick(new EmsDialog.ClickListener() {
                    @Override
                    public void click(View v) {


                    }
                }).setCancelText("否").setConfirmText("是").show();
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }
}
