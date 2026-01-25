HTTP 请求体是流式读取, 但Servlet 规范未提供“回放”机制

getInputStream() / getReader() 本质上操作的是同一条流

如果在请求过程中使用了getInputStream() / getReader()读取流中数据, 则无法再次读取., 

解决思路是
1. 创建可重复读取的HttpServletRequestWrapper(定义缓存字节数组, 重写getInputStream() / getReader())
2. 依据HttpServletRequestWrapper构造Filter(将HttpServletRequestWrapper放入请求链)
3. 注册这个Filter, 并将其提升为最高优先级的过滤器(@Configuration)
4. 这样后续用户从UserInterceptor拦截器中拿到的request就是我们定义好的RepeatedlyRequestWrapper了

对于可以用创建的匿名内部类实例或者函数式接口, 都属于功能类, 如ServletInputStream

而且我们的RepeatedlyRequestWrapper具有成员变量byte[] body, 属于组件类