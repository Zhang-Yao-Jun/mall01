<%--
  Created by IntelliJ IDEA.
  User: 张尧俊
  Date: 2019/3/14
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ItemsServelt">
    <input type="hidden" name="method" value="update">
    <table>
        <tr>
            <td>id</td>
            <td>
                <input type="text" name="id"  readonly vlaue="${map.id}">
            </td>
        </tr>
        <tr>
            <td>name</td>
            <td>
                <input type="text" name="name" vlaue="${map.name}">

            </td>
        </tr>
        <tr>
            <td>city</td>
            <td>
                <input type="text" name="city" vlaue="${map.city}">

            </td>
        </tr>
        <tr>
            <td>price</td>
            <td>
                <input type="text" name="price" vlaue="${map.price}">

            </td>
        </tr>
        <tr>
            <td>number</td>
            <td>
                <input type="text" name="number" vlaue="${map.number}">

            </td>
        </tr>
        <tr>
            <td>picture</td>
            <td>
                <input type="text" name="picture" vlaue="${map.picture}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="save">
                <input type="reset" value="reset">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
