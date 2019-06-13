package com.junhua.rpc.common;

import java.util.Map;

public class URL {

    private final String host;

    private final int port;
    private final String path;
    private final Map<String, String> parameters;

    protected URL() {
        this.host = null;
        this.port = 0;
        this.parameters = null;
        this.path = null;
    }


}
