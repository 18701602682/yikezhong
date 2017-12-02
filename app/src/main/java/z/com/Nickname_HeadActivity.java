package z.com;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import z.com.base.BaseActivity;
import z.com.base.BaseBean;
import z.com.presenter.Xg_nickname_presenter;
import z.com.view.xg_nickname_view;

public class Nickname_HeadActivity extends BaseActivity<Xg_nickname_presenter> implements xg_nickname_view, View.OnClickListener {

    private EditText et_xg_nickname;
    private Button bt_xg_nickname;
    private ImageView iv_sc_head;
    private Button bt_sc_head;
    private SharedPreferences sp_uid;
    private String uid;

    //上传头像需要用到
    private static final int CHOOSE_PICTURE=0;
    private static final int TAKE_PICTURE=1;
    private static final int CROP_SMALL_PICTURE=2;
    private static Uri tempUri;

    @Override
    public Xg_nickname_presenter initPresenter() {
        return new Xg_nickname_presenter(this);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_nickname__head;
    }

    @Override
    public void creat()
    {
        initView();
    }

    @Override
    public boolean bool() {
        return false;
    }

    private void initView()
    {
        et_xg_nickname = findViewById(R.id.et_xg_nickname);
        bt_xg_nickname = findViewById(R.id.bt_xg_nickname);
        iv_sc_head = findViewById(R.id.iv_sc_head);
        bt_sc_head = findViewById(R.id.bt_sc_head);

        bt_xg_nickname.setOnClickListener(this);
        bt_sc_head.setOnClickListener(this);

        //显示原来的头像
        SharedPreferences sp_icon = getSharedPreferences("sp_icon",MODE_PRIVATE);
        String icon = sp_icon.getString("icon", "");
        iv_sc_head.setImageURI(Uri.parse(icon));

        sp_uid = getSharedPreferences("sp_uid",MODE_PRIVATE);
        uid = sp_uid.getString("uid", "");
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bt_xg_nickname:
                String nickname = et_xg_nickname.getText().toString();
                //presenter.xg_nickname(uid,nickname);

                SharedPreferences sp_nickname=getSharedPreferences("sp_nickname",MODE_PRIVATE);
                sp_nickname.edit().putString("nickname",nickname).commit();
                break;
            case R.id.bt_sc_head:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("设置头像");
                String[] items={"选择本地照片","拍照"};
                builder.setNegativeButton("取消",null);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case CHOOSE_PICTURE://选择本地照片
                                Intent openAlbumIntent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                                startActivityForResult(openAlbumIntent,CHOOSE_PICTURE);
                                break;
                            case TAKE_PICTURE://拍照
                                Intent openCameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                tempUri=Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"image.jpg"));
                                //指定照片保存路径sd卡，image.jpg为一个临时文件，每次拍照后这个图片都会被
                                openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,tempUri);
                                startActivityForResult(openCameraIntent,TAKE_PICTURE);
                                break;
                        }
                    }
                });
                builder.create().show();
                break;
        }
    }

    @Override
    public void Success(BaseBean result) {
        finish();
        ShowToast(result.msg);
    }

    @Override
    public void data_faile(BaseBean msg) {
        ShowToast(msg.msg);
    }

    @Override
    public void faile(BaseBean msg) {
        ShowToast(msg.msg);
    }


    /**
     * 上传头像的回调方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case TAKE_PICTURE:
                startPhotoZoom(tempUri);
                break;
            case CHOOSE_PICTURE:
                startPhotoZoom(data.getData());
                break;
            case CROP_SMALL_PICTURE:
                if(data!=null){
                    setImageToView(data);
                }
                break;
        }

    }
    /**
     * 裁剪图片方法实现
     * @param uri
     */
    protected  void startPhotoZoom(Uri uri){
        if(uri==null){
            Log.i("tag","The uri is not exist");
        }
        tempUri=uri;
        Intent intent=new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");
        //设置裁剪
        intent.putExtra("crop","true");
        //aspectX aspectY是宽高的比例
        intent.putExtra("aspectX",1);
        intent.putExtra("aspectY",1);
        //outputX outputY是裁剪图片的宽高
        intent.putExtra("outputX",150);
        intent.putExtra("outputY",150);
        intent.putExtra("return-data",true);
        startActivityForResult(intent,CROP_SMALL_PICTURE);
    }
    /**
     * 保存裁剪之后的图片数据
     * @param data
     */
    protected void setImageToView(Intent data){
        Bundle extras=data.getExtras();
        if(extras!=null){
            Bitmap photo=extras.getParcelable("sdcard");
            iv_sc_head.setImageBitmap(photo);
            saveImage(photo);
            File file=new File(getCacheDir()+"/y.jpg");

            presenter.sc_picture(uid,file);
        }
    }
    /**
     * 读取的图片存在一个路径里
     * @param photo
     */
    private void saveImage(Bitmap photo) {
        File file=new File(getCacheDir()+"/aa.jpg");
        try{
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
            photo.compress(Bitmap.CompressFormat.JPEG,100,bos);//压缩
            bos.flush();
            bos.close();
        }catch (Exception e){

        }
    }
}
