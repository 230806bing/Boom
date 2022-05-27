package com.example.boom.base.retrofit;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Description：存放接口请求配置
 * Param：
 * return：
 * PackageName：com.example.shimmer.base.retrofitwithrxjava
 * Author：陈冰
 * Date：2022/1/14 13:31
 */
public interface RetrofitApiUrl {
    //测试接口
    @GET("index")
    Observable<String> getTest();

//    @Multipart
//    @POST("common/upload/image")
//    Observable<BaseResponse<PictureBean>> uploadFile(@Header("token") String token, @Part MultipartBody.Part file);
//
//
//    @GET(Constant.browseQueryCreator)
//    Observable<BaseResponse<List<CreatorBean>>> getAllCreators(@Header("token") String token);

//    @POST(Constant.browseComplete)
//    Observable<BaseResponse> isNodeCompleted(@Header("token") String token,@Query("id")int id);

}
