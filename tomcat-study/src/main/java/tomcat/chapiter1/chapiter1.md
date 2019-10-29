#一个简单的web服务器

###简介:
>HTTP允许web服务器和浏览器通过Internet发送并接收数据。在http中总是客户端发起连接；分为http 请求和http响应。
在创建request，和response时，都必须要满足相应的格式，如：requst->（请求方法+URI+请求协议／版本号）+ 请求头（用来指定客户端的相应属性，比如接收请求内容的格式，是否压缩等等）+请求体（在post请求中用来传递参数）；response->(协议（HTTP/1.1）-状态码（200）-描述（OK）) + 响应头（描述该response的相关性质，如压缩方式，content-type等）+ "CRLF"（不可缺失） + body（客户端想要接收到的信息）

##一. Request 类
封装了InputStream，用来读取客户端过来的请求，并解析出客户端请求的资源地址
    
##二. Response 类
封装了OutputStream，和Request；根据request找到客户端请求资源的地址，然后去本地找到相应的资源返回通过outputStream返回给客户端。

##三. notes
* socket之间的数据传输都是基于bytes
* outputStream在write时，数据并没有立即通过socket传输出去；于是可以调用多次outputStream来拼接成一个符合协议规范的http response 发送出去
    