package com.junhua.tornesol.util.pipeline;

public interface Container {

    Pipeline getPipeline();

    Response invoke(Request request);
}
