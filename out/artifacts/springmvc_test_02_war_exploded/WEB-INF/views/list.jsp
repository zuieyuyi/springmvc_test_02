<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/12
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>list</title>
</head>
<!--
	SpringMVC 处理静态资源:
	1. 为什么会有这样的问题:
	优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
	若将 DispatcherServlet 请求映射配置为 /,
	则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理,
	因找不到对应处理器将导致错误。
	2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
-->
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<!--
    当delete类被点击
    获取delete类的href属性
    将form标签的action属性值替换为delete类的href属性
    提交表单
-->
<script>
    $(function () {
        $(".delete").click(function(){
            var href = $(this).attr("href");
            $("form").attr("action",href).submit();
            return false;
        })
    })
</script>
<body>
    <c:if test="${empty requestScope.students }">
        没有任何学生信息
    </c:if>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <c:if test="${!empty requestScope.students }">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>成绩</th>
                <th>任教老师编号</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${requestScope.students}" var="stu">
                <tr>
                    <td>${stu.sno}</td>
                    <td>${stu.name}</td>
                    <td>${stu.age}</td>
                    <td>${stu.mark}</td>
                    <td>${stu.teacherno}</td>
                    <td><a href="stu/${stu.sno}">编辑</a></td>
                    <td><a class="delete" href="stu/${stu.sno}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br><br>

    <a href="stu">add new Student</a>
    <a href="gotoConverer">gotoConverer</a>
</body>
</html>
