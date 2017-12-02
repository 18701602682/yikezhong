package z.com.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/29.
 * 段子
 */

public interface Model_dz {

    void fabiao_duanzi(String uid,String content,List<String> jokeFiles);//发表段子
    void huoqu_duanzi(String page);//获取段子
}
