package com.example.boom.base.retrofit;

import com.example.boom.base.bean.UserRegisterBean;
import com.example.boom.base.retrofit.utils.BaseResponse;
import com.example.boom.bean.UserBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Description：存放接口请求配置
 * Param：
 * return：
 * PackageName：com.example.boom.retrofit
 * Author：陈冰
 * Date：2022/1/14 13:31
 */
public interface RetrofitApiUrl {
    //测试接口
    @GET("index")
    Observable<String> getTest();



//    @
//    @POST(Constant.userRegister)
//    Observable<BaseResponse> register(@Field("phone") );


    @GET(Constant.userMsg)
    Observable<BaseResponse<UserBean>> getAllCreators(@Header("token") String token, @Path(value = "userId") int userId);

//    @POST(Constant.browseComplete)
//    Observable<BaseResponse> isNodeCompleted(@Header("token") String token,@Query("id")int id);

}
