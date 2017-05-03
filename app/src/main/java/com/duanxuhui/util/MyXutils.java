package com.duanxuhui.util;

import com.duanxuhui.bean.JsonBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * data 2017/5/3  9:25.
 * author:段旭晖(Administrator)
 * function:
 */

public class MyXutils {

    public void getData(String path){
        RequestParams params=new RequestParams(path);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                JsonBean jsonBean = gson.fromJson(result, JsonBean.class);
                List<JsonBean.ResultBean.RowsBean> rows = jsonBean.getResult().getRows();
                jiekou.transmit(rows);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                Gson gson=new Gson();
                JsonBean jsonBean = gson.fromJson(result, JsonBean.class);
                List<JsonBean.ResultBean.RowsBean> rows = jsonBean.getResult().getRows();
                jiekou.transmit(rows);
                return true;
            }
        });
    }
    Jiekou jiekou;
    public interface Jiekou{
        public void transmit(List<JsonBean.ResultBean.RowsBean> list);
    }
    public void transmitData(Jiekou jiekou){
        this.jiekou=jiekou;
    }
}
