#一个简单的servlet容器

###简述
>一个功能齐全的servlet应该做如下几件事情    
* 载入servlet，并调用init（仅此一次）
* 针对每个request请求生成一个ServletRequest 和ServletResponse实例
* 调用servlet的service方法（传入servletRequest 和servletResponse）
* 关闭servlet，调用destroy方法

##1. servlet 
**生命周期** : init(初始化，只会调用一次) -> service(当servlet客户端请求到达后，servlet就会调用service方法；service方法会调用多次) -> destroy （清理servlet自身的资源，如：内存，文件句柄，线程等）  