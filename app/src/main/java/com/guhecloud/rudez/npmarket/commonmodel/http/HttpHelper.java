package com.guhecloud.rudez.npmarket.commonmodel.http;


import com.guhecloud.rudez.npmarket.commonmodel.http.api.HaveCacheApis;
import com.guhecloud.rudez.npmarket.commonmodel.http.api.NoCacheHttpApis;

/**
 * Created by Chanin on 2017-07-07.
 */
public class HttpHelper implements IHttpHelper{


    public HaveCacheApis haveCacheApis;
    public NoCacheHttpApis noCacheHttpApis;


    public HttpHelper(HaveCacheApis haveCacheApis, NoCacheHttpApis noCacheHttpApis) {
        this.haveCacheApis = haveCacheApis;
        this.noCacheHttpApis = noCacheHttpApis;
    }



}
