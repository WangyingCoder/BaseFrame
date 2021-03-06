package com.cpst.base.network;

import com.cpst.base.model.GankList;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by wy on 2017/11/25.
 *
 */

public interface APIService {

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     */
    @GET("data/{category}/{count}/{page}")
    Flowable<GankList> getData(@Path("category") String category, @Path("count") int count, @Path("page") int page);

}