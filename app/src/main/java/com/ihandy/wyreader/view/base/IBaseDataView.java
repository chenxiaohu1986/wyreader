package com.ihandy.wyreader.view.base;

/**
 * Created by cxh on 18/5/22.
 */

public interface IBaseDataView extends IBaseLoadView{

	void emptyData();
	void errorData(String error);
	void NetWorkError();

}
