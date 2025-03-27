<%@ page import="java.util.HashMap" %>
<%@ page import="code.MODEL.USER" %>
<%@ page import="code.MODEL.USERS" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý Người Dùng</title>
    <link rel="stylesheet" href="style.css">    
</head>
<body>
    <h2>Danh sách Người Dùng</h2>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>Tên</th>
            <th>SĐT</th>
            <th>Email</th>
            <th>Mật khẩu</th>
            <th>Vai trò</th>
            <th>Hành động</th>
        </tr>
        
        <%
            USERS users = new USERS();
            HashMap<String, USER> userList = users.getLISTUSER();
            if (userList != null && !userList.isEmpty()) {
                for (USER user : userList.values()) {
        %>
        <tr>
            <td><%= user.getUserId() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getPhone() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getPassword() %></td>
            <td><%= user.getroleId() %></td>
            <td>
                <a href="editUser.jsp?id=<%= user.getUserId() %>">Sửa</a>
                <a href="deleteUser.jsp?id=<%= user.getUserId() %>" onclick="return confirm('Bạn có chắc chắn xóa?')">Xóa</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">Không có dữ liệu.</td>
        </tr>
        <% } %>
    </table>

    <h2>Thêm Người Dùng</h2>
    <form action="addUser.jsp" method="post">
        <label>Tên:</label> <input type="text" name="name" required><br>
        <label>SĐT:</label> <input type="text" name="phone" required><br>
        <label>Email:</label> <input type="email" name="email" required><br>
        <label>Mật khẩu:</label> <input type="password" name="password" required><br>
        <label>Vai trò:</label>
        <select name="role">
            <option value="Khách hàng">Khách hàng</option>
            <option value="Nhân viên">Nhân viên</option>
            <option value="Admin">Admin</option>
        </select><br>
        <input type="submit" value="Thêm">
    </form>
</body>
</html>
