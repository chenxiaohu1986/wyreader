package com.ihandy.wyreader.api;

import com.allen.library.bean.BaseData;
import com.ihandy.wyreader.model.BookClassifyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by cxh on 18/5/23.
 */

public interface BookService {


	/**
	 * 获取所有分类
	 *
	 * @return
	 */
	@GET(ModelPath.API + "/classify")
	Observable<BaseData<BookClassifyBean>> bookClassify();





}
