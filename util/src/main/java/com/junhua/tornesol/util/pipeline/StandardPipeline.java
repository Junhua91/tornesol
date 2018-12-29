package com.junhua.tornesol.util.pipeline;

import java.util.ArrayList;
import java.util.List;

public class StandardPipeline implements Pipeline {

    protected Valve basic = null;
    protected Valve first = null;

    @Override
    public Valve getFirst() {
        if (first != null) return first;
        else return basic;
    }

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
        List<Valve> result = new ArrayList();
        Valve current = first;
        if (current == null) current = basic;

        while (current != null) {
            result.add(current);
            current = current.getNext();
        }
        return result;
    }

    @Override
    public void removeValve(Valve valve) {
        Valve current = null;
        if (first == valve) {
            first = first.getNext();
        } else current = first;

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
}
