<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
<form action="/index" method="POST">

    <input type="hidden" name="ac" value="verify" />

    Login <input type="text" name="cpLogin" class="form-control">
    Senha <input type="password" name="cpSenha" class="form-control">

    <button class="btn btn-primary">OK</button>
    <br>
    <%= ((String)request.getAttribute("msg") == null)?"":(String)request.getAttribute("msg") %>
</form>

</div>