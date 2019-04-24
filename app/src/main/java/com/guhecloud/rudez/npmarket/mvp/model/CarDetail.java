package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/22.
 */

public class CarDetail  {

    /**
     * id : 1
     * carNo : 川A 99999
     * carTypeId : 1
     * carOwnerTypeId : null
     * carTypeName : 轿车
     * custId : 01
     * staffId : 01
     * carOwnerName : 莫尹
     * carCertNo : 51390298805267894
     * monthCardFlag : 1
     * contactNumber : 11111111111
     * descInfo : null
     * shopStallsName : 档位01,档位02
     * carEnterOutList : [{"entranceTime":"2019-04-12 14:12:46","outTime":"2019-04-12 15:12:55"},{"entranceTime":"2019-04-11 10:09:45","outTime":"2019-04-11 11:10:25"}]
     */

    public int id;
    public String carNo;
    public int carTypeId;
    public Object carOwnerTypeId;
    public String carTypeName;
    public String custId;
    public String staffId;
    public String carOwnerName;
    public String carCertNo;
    public int monthCardFlag;
    public String contactNumber;
    public Object descInfo;
    public String shopStallsName;
    public List<CarInOut> carEnterOutList;

    public static class CarInOut {
        /**
         * entranceTime : 2019-04-12 14:12:46
         * outTime : 2019-04-12 15:12:55
         */

        public String entranceTime;
        public String outTime;
    }
}
