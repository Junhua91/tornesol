package com.ximalaya.webgroup.tdkservice.tdk.pipeline;

import com.ximalaya.webgroup.tdkservice.tdk.valve.Valve;

import java.util.List;

public interface Pipeline {

    void addValve(Valve valve);

    List<Valve> getValves();

    void removeValve(Valve valve);

    Valve getBasic();

    void setBasic(Valve valve);

    void setFirst(Valve valve);

    Valve getFirst();
}
