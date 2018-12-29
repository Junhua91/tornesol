package com.junhua.tornesol.util.pipeline;

public abstract class ContainerBase implements Container {

    protected Pipeline pipeline = new StandardPipeline();

    @Override
    public Pipeline getPipeline() {
        return pipeline;
    }
}
