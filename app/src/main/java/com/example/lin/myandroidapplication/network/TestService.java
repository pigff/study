package com.example.lin.myandroidapplication.network;

import com.example.lin.myandroidapplication.data.CityBean;
import com.example.lin.myandroidapplication.data.TestBean;
import com.example.lin.myandroidapplication.data.TextJokeResponse;
import com.example.lin.myandroidapplication.data.net.CameraBean;
import com.example.lin.myandroidapplication.data.net.CameraCategoryBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by lin on 2016/12/13.
 */
public interface TestService {

    @GET("apistore/weatherservice/citylist")
    Call<CityBean> getCity(@Header("apikey") String apikey, @Query("cityname") String cityName);

    @GET("articleCategory/findAll")
    Call<TestBean> getTest();

    @GET("{category}")
    Call<TextJokeResponse> getTextJokeData(@Path("category") String category,
                                           @Query("showapi_appid") String appid,
                                           @Query("showapi_sign") String sign,
                                           @Query("page") String page,
                                           @Query("maxResult") String maxResult);

    @POST("cameraModel/findByArea.json")
    Observable<CameraCategoryBean> getCameraCategory(@Query("areaId") Integer areaId);

    @POST("camera/findByCameraModel.json")
    Observable<CameraBean> getCamera(@Query("cameraModelId") Integer cameraModelId);

    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);
}
