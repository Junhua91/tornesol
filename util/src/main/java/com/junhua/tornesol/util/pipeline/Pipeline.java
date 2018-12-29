package com.junhua.tornesol.util.pipeline;

import java.util.List;

public interface Pipeline {

    void addValve(Valve valve);

    List<Valve> getValves();

    void removeValve(Valve valve);

    Valve getBasic();

    void setBasic(Valve valve);

    Valve getFirst();
}
