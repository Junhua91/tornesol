package com.ximalaya.webgroup.tdkservice.tdk.valve;

import com.ximalaya.webgroup.tdkservice.model.TDKRequest;
import com.ximalaya.webgroup.tdkservice.model.TDKResponse;

public interface Valve {

    Valve getNext();

    void setNext(Valve valve);

    void invoke(TDKRequest request, TDKResponse response);


}
