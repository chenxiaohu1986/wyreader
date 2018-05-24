package com.ihandy.wyreader.viewmodel.fragment;

import android.content.Context;

import com.allen.library.RxHttpUtils;
import com.allen.library.interceptor.Transformer;
import com.ihandy.wyreader.api.BookService;
import com.ihandy.wyreader.model.BookClassifyBean;
import com.ihandy.wyreader.utils.NetworkUtils;
import com.ihandy.wyreader.utils.rxhelper.RxObserver;
import com.ihandy.wyreader.view.fragment.IClassifyBook;
import com.ihandy.wyreader.viewmodel.BaseViewModel;

import io.reactivex.disposables.Disposable;

/**
 * Created by cxh on 18/5/23.
 */

public class VMBookClassify extends BaseViewModel {

	 IClassifyBook mIBookClassify;

	public VMBookClassify(Context mContext, IClassifyBook iClassifyBook) {
		super(mContext);
		mIBookClassify = iClassifyBook;
	}


	public void bookClassify() {
		if (!NetworkUtils.isConnected()) {
			if (mIBookClassify != null) {
				mIBookClassify.NetWorkError();
			}
			return;
		}

		RxHttpUtils.getSInstance().addHeaders(tokenMap()).createSApi(BookService.class)
				.bookClassify()
				.compose(Transformer.switchSchedulers())
				.subscribe(new RxObserver<BookClassifyBean>() {
					@Override
					protected void onError(String errorMsg) {
						if (mIBookClassify != null) {
							mIBookClassify.stopLoading();
							mIBookClassify.errorData(errorMsg);
						}
					}

					@Override
					protected void onSuccess(BookClassifyBean data) {
						if (mIBookClassify != null) {
							mIBookClassify.stopLoading();
							if (data == null){
								mIBookClassify.emptyData();
								return;
							}
							mIBookClassify.getBookClassify(data);
						}
					}

					@Override
					public void onSubscribe(Disposable d) {
						addDisposadle(d);
					}
				});


	}

}
