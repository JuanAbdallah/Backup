<%@ page import="br.vianna.edu.academia.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    User u = (User)request.getAttribute("user");
%>

<form action="index" method="POST">

    <input type="hidden" name="ac" value="saveUser" />

    <div class="container">
        <div class="row">
            <label for="">Nome</label>
            <input type="text" name="cpNome" placeholder="nome"
                   required class="form-control"
            />
        </div>
        <div class="row">
            <label for="">Email</label>
            <input type="email" name="cpEmail" placeholder="Email"
                   required class="form-control"
            />
        </div>
        <div class="row">
            <label for="">Login</label>
            <input type="text" name="cpLogin" placeholder="login"
                   required min="8" max="18" class="form-control"/>
        </div>
        <div class="row">
            <label for="">Senha</label>
            <input type="password" class="form-control" name="cpSenha" placeholder="senha"
                   required />
        </div>
        <div class="row">
            <label for="">Repita a Senha</label>
            <input type="password" class="form-control" name="cpNewSenha" placeholder="senha"
                   required />
        </div>
        <div class="row">
            <%= (request.getAttribute("error") != null? request.getAttribute("error") : "") %>
        </div>
        <div class="row">
            <button class="btn btn-primary">Cadastrar</button>
        </div>


    </div>
</form>
