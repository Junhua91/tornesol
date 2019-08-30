package com.ximalaya.webgroup.tdkservice.tdk.pipeline;

import com.ximalaya.webgroup.tdkservice.tdk.valve.Valve;

import java.util.ArrayList;
import java.util.List;

public class StandardPipeline implements Pipeline {

    protected Valve basic;
    protected Valve first;


    @Override
    public void addValve(Valve valve) {
        if (first == null) {
            first = valve;
            valve.setNext(basic);
        } else {
            Valve current = first;
            while (current != null) {
                if (current.getNext() == basic) {
                    current.setNext(valve);
                    valve.setNext(basic);
                    break;
                }
                current = current.getNext();
            }
        }
    }

    @Override
    public List<Valve> getValves() {
        Valve current = first;
        List<Valve> valveList = new ArrayList<>();

        if (current == null) current = basic;
        while (current != null) {
            valveList.add(current);
            current = current.getNext();
        }
        return valveList;
    }

    @Override
    public void removeValve(Valve valve) {

        Valve current = null;
        if (first == valve) {
            first = first.getNext();
        } else {
            current = first;
        }

        while (current != null) {
            if (current.getNext() == valve) {
                current.setNext(valve.getNext());
                break;
            }
            current = current.getNext();
        }

        if (first == basic) first = null;
    }

    @Override
    public Valve getBasic() {
        return basic;
    }

    @Override
    public void setBasic(Valve valve) {
        this.basic = valve;
    }

    @Override
    public Valve getFirst() {
        return (first == null) ? basic : first;
    }

    @Override
    public void setFirst(Valve first) {
        this.first = first;
    }
}
