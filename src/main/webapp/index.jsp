<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/12
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script>
    $(function(){
        $("#testJson").click(function(){
            var url = this.href;
            var args = {};
            $.post(url,args,function(data){
                for(var i = 0; i < data.length; i++ ){
                    var sno = data[i].sno;
                    var name = data[i].name;
                    alert(sno + ":" + name);
                }
            });
            return false;
        })
    })
</script>
<body>
    <a href="stus">list</a><br>
    <a id="testJson" href="testJson">Test Json</a><br>
    <br><br>
    <form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
        File:<input type="file" name="file">
        Desc:<input type="text" name="desc">
        <input type="submit" value="submit">
    </form>
    <br><br>
    <a href="testResponseEntity">testResponseEntity</a>

    <!--
        关于国际化
        1、在页面上能够根据浏览器语言设置情况对文本（不是内容），时间，数值进行本地化处理
        2、可以在bean中获取国际化资源文件Locale 对应的消息
        3、可以通过超链接切换Locale，而不再依赖于浏览器的语言设置情况


        解决:
        1、使用jstl的fmt标签
        2、在bean中注入ResourceBundleMessageSource 的实例，使用其对应的getMessage方法即可
        3、配置LocalResolver和LocaleChangeInterceptor
     -->
    <br><br>
    <a href="i18n">i18n</a>

    <br><br>
    <a href="fileupload">fileupload</a>

    <br><br>
    <a href="testExceptionHandler?i=0">异常处理by zero（testExceptionHandler）</a>
</body>
</html>
