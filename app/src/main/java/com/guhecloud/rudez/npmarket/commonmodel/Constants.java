package com.guhecloud.rudez.npmarket.commonmodel;


import com.guhecloud.rudez.npmarket.commonmodel.http.api.NoCacheHttpApis;

import java.io.File;

import static com.guhecloud.rudez.npmarket.util.SystemUtil.getDiskCacheDir;


/**
 * Created by Chanin on 2017/6/9.
 */
public class Constants {

    public static final String BUGLY_ID = "6641104962";

    public static final String PATH_DATA = getDiskCacheDir() + File.separator + "data";
    public static final String PATH_HTTP_CACHE = PATH_DATA+File.separator+"httpCache";
    public static final String DOWNLOAD_URL = NoCacheHttpApis.HOST + "fj/xzbb?bbdz=";
    public static final String FJ_PICTURE_URL = NoCacheHttpApis.HOST + "fj/picture?fjlj=";
    public static final String FJ_AUDIO_URL = NoCacheHttpApis.HOST + "fj/audio?fjlj=";
    public static final String FJ_VIDEO_URL = NoCacheHttpApis.HOST + "fj/video?fjlj=";
    public static final String FJ_FILE_URL = NoCacheHttpApis.HOST + "fj/file?fjlj=";
    public static final boolean SIGN = true;

    public static final String STID = "stid";

    public static final String RWID = "rwid";
    public static final String RWMC = "rwmc";
    public static final String STMC = "stmc";
    public static final String rwjlId = "rwjlId";

    public static final String KEY = "test1234";//8字节秘钥

    public static final boolean IS_OFFLINE = false;
    public static final String COUNT = "UnReadCount";

    public static final String RELOGIN = "RELOGIN";
    //选择附件默认最大值
    public static final int AUTO_MAX_FILE_SELECTE_NUM = 10;
    //选择附件视频默认最大size
    public static final long AUTO_MAX_VIDEO_SELECTE_SIZE = 200*1024*1024;
    //选择附件文件默认最大size
    public static final long AUTO_MAX_FILE_SELECTE_SIZE = 10*1024*1024;
}
