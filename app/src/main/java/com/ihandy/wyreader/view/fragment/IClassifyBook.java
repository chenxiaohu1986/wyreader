package com.ihandy.wyreader.view.fragment;

import com.ihandy.wyreader.model.BookClassifyBean;
import com.ihandy.wyreader.view.base.IBaseDataView;

/**
 * Created by cxh on 18/5/22.
 */

public interface IClassifyBook extends IBaseDataView {

	void getBookClassify(BookClassifyBean bookClassifyBean);

}
