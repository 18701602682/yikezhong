package z.com.utils;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import z.com.base.BaseBean;
import z.com.bean.GetjokeBean;
import z.com.bean.LoginBean;
import z.com.bean.UserBean;
import z.com.bean.VideoBean;
import z.com.bean.ZhuCeBean;

/**
 * Created by lenovo on 2017/11/28.
 */

public interface ApiService {

    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@FieldMap Map<String,String> map);

    //注册
    @POST("quarter/register")
    @FormUrlEncoded
    Observable<ZhuCeBean> zhuce(@FieldMap Map<String,String> map);

    //获取用户信息
    @POST("/user/getUserInfo")
    @FormUrlEncoded
    Observable<UserBean> user(@Field("uid") String uid);

    //修改昵称
    @POST("user/updateNickName")
    @FormUrlEncoded
    Observable<BaseBean> updateNickName(@FieldMap Map<String,String> map);

    //上传头像
    @POST("file/upload")
    @Multipart
    Observable<BaseBean> upload(@Part List<MultipartBody.Part> list);

    //获取段子
    @POST("quarter/getJokes")
    @FormUrlEncoded
    Observable<GetjokeBean> getJokes(@Field("page") String page);

    //发布段子
    @POST("quarter/publishJoke")
    @Multipart
    Observable<BaseBean> publishJoke(@Part List<MultipartBody.Part> list);

    //关注用户
    @POST("quarter/follow")
    @FormUrlEncoded
    Observable<VideoBean> follow(@FieldMap Map<String,String> map);

    //获取推荐视频
    @POST("quarter/getVideos")
    @FormUrlEncoded
    Observable<VideoBean> getVideos(@FieldMap Map<String,String> map);


}
