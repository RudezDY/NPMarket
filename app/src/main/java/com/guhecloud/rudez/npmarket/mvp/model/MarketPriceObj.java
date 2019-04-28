package com.guhecloud.rudez.npmarket.mvp.model;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by homework on 2019/4/24.
 */

public class MarketPriceObj  extends AbstractExpandableItem<MarketPriceObj.PriceList> implements MultiItemEntity {

    /**
     * offerType : 蔬菜/根茎类
     * unit : 元/斤
     * startDate : 2019-03-25
     * endDate : 2019-03-31
     * priceList : [{"offerId":"01010101","offerName":"大白花土豆","avgPrice":1.59,"lastAvgPrice":null,"hb":null,"price0":1.5,"price1":1.6,"price2":1.3,"price3":1.4,"price4":1.7,"price5":1.8,"price6":1.8},{"offerId":"01010102","offerName":"新鲜土豆","avgPrice":1.7,"lastAvgPrice":null,"hb":null,"price0":null,"price1":null,"price2":1.5,"price3":1.9,"price4":null,"price5":null,"price6":null},{"offerId":"01010103","offerName":"菜土豆","avgPrice":null,"lastAvgPrice":null,"hb":null,"price0":null,"price1":null,"price2":null,"price3":null,"price4":null,"price5":null,"price6":null}]
     */

    public String offerType;
    public String unit;
    public String startDate;
    public String endDate;
    public List<PriceList> priceList;
    public List<String> dateList;

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return 0;
    }

    public static class PriceList  implements MultiItemEntity{
        /**
         * offerId : 01010101
         * offerName : 大白花土豆
         * avgPrice : 1.59
         * lastAvgPrice : null
         * hb : null
         * price0 : 1.5
         * price1 : 1.6
         * price2 : 1.3
         * price3 : 1.4
         * price4 : 1.7
         * price5 : 1.8
         * price6 : 1.8
         */

        public String offerId;
        public String offerName;
        public double avgPrice;
        public Object lastAvgPrice;
        public Object hb;
        public double price0;
        public double price1;
        public double price2;
        public double price3;
        public double price4;
        public double price5;
        public double price6;

        @Override
        public int getItemType() {
            return 1;
        }
    }
}
