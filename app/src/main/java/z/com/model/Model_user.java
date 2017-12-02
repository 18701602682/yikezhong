package z.com.model;

import java.io.File;

/**
 * Created by lenovo on 2017/11/29.
 */

public interface Model_user {

    void getuser(String uid);//获取用户信息
    void xg_nickname(String uid,String nickname);//修改昵称
    void sc_picture(String uid,File file);//上传头像
}
