package com.ihandy.wyreader.view.activity;


import com.ihandy.wyreader.model.AppUpdateBean;
import com.ihandy.wyreader.view.base.IBaseLoadView;

/**
 * Created by Liang_Lu on 2018/1/22.
 */

public interface ISetting extends IBaseLoadView {
    void appUpdate(AppUpdateBean appUpdateBean);
}
