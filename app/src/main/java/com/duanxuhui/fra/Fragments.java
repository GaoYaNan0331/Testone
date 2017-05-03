package com.duanxuhui.fra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.duanxuhui.base.MyBase;
import com.duanxuhui.bean.JsonBean;
import com.duanxuhui.util.MyXutils;
import com.duanxuhui.util.UrlUtils;
import com.example.administrator.duanxuhui20170503.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * data 2017/5/3  9:11.
 * author:段旭晖(Administrator)
 * function:
 */

public class Fragments extends android.support.v4.app.Fragment{
    private ListView lv;
    private String type;

    public Fragments(String type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        MyXutils myXutils = new MyXutils();
        myXutils.getData(UrlUtils.PATH);
        myXutils.transmitData(new MyXutils.Jiekou() {
            @Override
            public void transmit(List<JsonBean.ResultBean.RowsBean> list) {
                if (type.equals("sheng")){
                Collections.sort(list, new Comparator<JsonBean.ResultBean.RowsBean>() {
                    @Override
                    public int compare(JsonBean.ResultBean.RowsBean o1, JsonBean.ResultBean.RowsBean o2) {
                        if (o1.getInfo().getPrice()>o2.getInfo().getPrice()){
                            return 1;
                        }
                        if (o1.getInfo().getPrice()==o2.getInfo().getPrice()){
                            return 0;
                        }
                        return -1;
                    }

                });
                }else if (type.equals("jiang")){
                    Collections.sort(list, new Comparator<JsonBean.ResultBean.RowsBean>() {
                        @Override
                        public int compare(JsonBean.ResultBean.RowsBean o1, JsonBean.ResultBean.RowsBean o2) {
                            if (o1.getInfo().getPrice()<o2.getInfo().getPrice()){
                                return 1;
                            }
                            if (o1.getInfo().getPrice()==o2.getInfo().getPrice()){
                                return 0;
                            }
                            return -1;
                        }

                    });
                }
                lv.setAdapter(new MyBase(getActivity(),list));
            }
        });
    }


    private void initView() {
        lv= (ListView) getView().findViewById(R.id.lv);
    }
}
