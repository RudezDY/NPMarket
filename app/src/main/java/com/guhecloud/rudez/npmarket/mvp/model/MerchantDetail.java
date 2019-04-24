package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/22.
 */

public class MerchantDetail{


    /**
     * accNbr : string
     * businessNbr : string
     * businessTypeId : string
     * certNum : string
     * custAddr : string
     * custEnterGoodsDTOList : [{"custId":"string","custName":"string","dateNo":20190412,"enterDt":"2019-04-23T09:11:18.558Z","id":1,"monthNo":201904,"offerAlias":"string","offerId":"string","offerName":"string","wgtD":1}]
     * custGradeId : string
     * custId : string
     * custName : string
     * custTypeId : string
     * faxNbr : string
     * id : 1
     * likeName : string
     * linkAccNbr : string
     * mainBusinessOffer : string
     * shopStallsDTOList : [{"endTime":"2019-04-23T09:11:18.558Z","pactState":"string","regionId":"string","regionName":"string","shopStallsId":"string","shopStallsName":"string","startTime":"2019-04-23T09:11:18.558Z"}]
     * state : string
     */

    public String accNbr;
    public String businessNbr;
    public String businessTypeId;
    public String certNum;
    public String custAddr;
    public String custGradeId;
    public String custId;
    public String custName;
    public String custTypeId;
    public String faxNbr;
    public int id;
    public String likeName;
    public String linkAccNbr;
    public String mainBusinessOffer;
    public String state;
    public List<GoodsEnter> custEnterGoodsDTOList;
    public List<Booth> shopStallsDTOList;

    public static class GoodsEnter {
        /**
         * custId : string
         * custName : string
         * dateNo : 20190412
         * enterDt : 2019-04-23T09:11:18.558Z
         * id : 1
         * monthNo : 201904
         * offerAlias : string
         * offerId : string
         * offerName : string
         * wgtD : 1
         */

        public String custId;
        public String custName;
        public int dateNo;
        public String enterDt;
        public int id;
        public int monthNo;
        public String offerAlias;
        public String offerId;
        public String offerName;
        public int wgtD;
    }

    public static class Booth {
        /**
         * endTime : 2019-04-23T09:11:18.558Z
         * pactState : string
         * regionId : string
         * regionName : string
         * shopStallsId : string
         * shopStallsName : string
         * startTime : 2019-04-23T09:11:18.558Z
         */

        public String endTime;
        public String pactState;
        public String regionId;
        public String regionName;
        public String shopStallsId;
        public String shopStallsName;
        public String startTime;
    }
}
