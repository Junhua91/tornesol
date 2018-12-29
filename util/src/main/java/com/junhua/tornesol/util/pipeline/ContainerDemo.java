package com.junhua.tornesol.util.pipeline;

public class ContainerDemo extends ContainerBase {

    public ContainerDemo() {
        Valve basic = new BasicValve();
        Valve test = new TestValve();
        getPipeline().setBasic(basic);
        getPipeline().addValve(test);
    }

    @Override
    public Response invoke(Request request) {
        Response response = new Response();

        getPipeline().getFirst().invoke(request, response);
        return response;
    }

    static public void main(String[] args) {
        Container container = new ContainerDemo();
        Request request = new Request("www.ximalaya.com", "web");

        Response response = container.invoke(request);
        System.out.println(response.getUriOut());
    }
}
