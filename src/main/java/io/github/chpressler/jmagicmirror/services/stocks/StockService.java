package io.github.chpressler.jmagicmirror.services.stocks;

import javax.annotation.PostConstruct;

/**
 * Created by christian on 12/23/16.
 */
public class StockService {

    @PostConstruct
    void init() {

    }

    public String getExchangeRate(String s) {
        return Double.toString(Math.random());//"0.983";
    }

}
