package z.com.base;

/**
 * Created by lenovo on 2017/11/23.
 *
 */

public interface BaseView<A>{

    void Success(A result);//成功
    void data_faile(A msg);//请求数据失败
    void faile(A msg);//失败
}
