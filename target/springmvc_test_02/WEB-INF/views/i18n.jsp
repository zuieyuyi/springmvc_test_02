<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/22
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>i18n</title>
</head>
<body>
    <fmt:message key="i18n.user"></fmt:message>

    <br><br>
    <a href="i18n2">i18n2</a>

    <!-- SessionLocaleResolver & LocaleChangeInterceptor工作原理
        LocaleChangeInterceptor
            1、获取name=locale的请求参数
            2、把第一步的locale请求对象参数解析为Locale对象
            3、获取LocaleResolver对象
        SessionLocaleResolver
            4、把Locale对象设置为Session属性
            5、从Session中获取Locale对象
        应用程序
            6、使用Locale对象
     -->
    <br><br>
    <a href="i18n?locale=zn_CH">中文</a>
    <br><br>
    <a href="i18n?locale=en_US">英文</a>

</body>
</html>
