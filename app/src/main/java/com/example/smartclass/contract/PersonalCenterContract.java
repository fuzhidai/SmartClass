package com.example.smartclass.contract;

import com.example.smartclass.base.BasePresenter;
import com.example.smartclass.base.BaseView;

/**
 * Created by YangFan
 * On 2019/2/23
 * GitHub: https://github.com/TIYangFan
 * Email: yangfan_98@163.com
 */
public interface PersonalCenterContract {

    interface View extends BaseView<Presenter>{

        void showUserInformation();

        void setLoadingIndicator(boolean active);

        void showLoadingClassInformationError();
    }

    interface Presenter extends BasePresenter{

        void loadUserInformation();
    }
}
