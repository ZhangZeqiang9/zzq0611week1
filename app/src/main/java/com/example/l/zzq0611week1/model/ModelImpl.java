package com.example.l.zzq0611week1.model;

import com.example.l.zzq0611week1.Contract;
import com.example.l.zzq0611week1.httputil.HttpUtil;

/*
 * M层
 */
public class ModelImpl implements Contract.Model {
    private String path = "https://www.apiopen.top/satinApi?type=1&page=";
    @Override
    public void ShowData(int page, final Contract.CallBack callBack) {
        HttpUtil.getInstance().getDatas(path+page, new HttpUtil.HttpUtilCallBack() {
            @Override
            public void getData(String data) {
                callBack.getData(data);
            }
        });
    }
}
