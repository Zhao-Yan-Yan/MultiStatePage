package com.zy.demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.zy.multistatepage.MultiStateContainer;
import com.zy.multistatepage.MultiStatePage;
import com.zy.multistatepage.OnNotifyListener;
import com.zy.multistatepage.OnRetryEventListener;
import com.zy.demo.state.LottieOtherState;

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/19 12:39
 */
class Test extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = new View(this);

        MultiStatePage.bindMultiState(this);
        MultiStatePage.bindMultiState(view);

        MultiStateContainer multiStateContainer = MultiStatePage.bindMultiState(view, new OnRetryEventListener() {
            @Override
            public void onRetryEvent(MultiStateContainer multiStateContainer) {

            }
        });


        multiStateContainer.show(LottieOtherState.class);

        multiStateContainer.show(LottieOtherState.class, new OnNotifyListener<LottieOtherState>() {
            @Override
            public void onNotify(LottieOtherState multiState) {
                System.out.println("");
            }
        });

    }
}
