package com.zy.multistatepage.base;

import android.app.Application;
import android.view.View;

import com.zy.multistatepage.MultiStateContainer;
import com.zy.multistatepage.MultiStatePage;
import com.zy.multistatepage.state.LottieOtherState;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/19 12:39
 */
class Test extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       /* new Config.Builder()
                .alphaDuration()
                .emptyIcon()
                .emptyMsg()
                .errorIcon()
                .errorMsg()
                .loadingMsg()
                .build();
        MultiStatePage.config(config);*/

        View view = new View(this);

        MultiStateContainer multiStateContainer = MultiStatePage.bindMultiState(view, new Function1<MultiStateContainer, Unit>() {
            @Override
            public Unit invoke(MultiStateContainer multiStateContainer) {

                return Unit.INSTANCE;
            }
        });

        multiStateContainer.show(LottieOtherState.class, new Function1<LottieOtherState, Unit>() {
            @Override
            public Unit invoke(LottieOtherState lottieOtherState) {
                //回调
                return null;
            }
        });

    }
}
