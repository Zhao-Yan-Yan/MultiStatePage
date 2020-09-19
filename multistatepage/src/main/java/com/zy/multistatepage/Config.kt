package com.zy.multistatepage

import androidx.annotation.DrawableRes

/**
 * @ProjectName: MultiStatePage
 * @Author: 赵岩
 * @Email: 17635289240@163.com
 * @Description: TODO
 * @CreateDate: 2020/9/19 12:30
 */

data class Config(
    val errorMsg: String ="哎呀,出错了",
    @DrawableRes val errorIcon: Int = R.mipmap.state_error,
    val emptyMsg: String = "这里什么都没有",
    @DrawableRes val emptyIcon: Int = R.mipmap.state_empty,
    val loadingMsg: String = "loading...",
) {

}