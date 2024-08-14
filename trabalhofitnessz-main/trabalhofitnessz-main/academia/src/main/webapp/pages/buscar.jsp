<%@ page import="br.vianna.edu.academia.model.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<User> usuarios = (List<User>) request.getAttribute("alunos");
%>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">Buscar Usuário</h2>
            <form action="/index?ac=aplicaBusca" method="post">
                <div class="form-group">
                    <label for="nome">Login do Usuário:</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o login do usuário">
                </div>
                <button type="submit" class="btn btn-primary btn-block">Buscar</button>
            </form>
        </div>
    </div>
</div>


<div class="container mt-5">
    <h2 class="text-center mb-4">Lista de Usuários</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>

            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Login</th>
                <th>Email</th>
                <th>Tipo de Aluno</th>
            </tr>
            </thead>
            <tbody>

            <% for(User u: usuarios ){%>
            <tr>
                <th><%=u.getId() %></th>
                <th><%=u.getNome() %></th>
                <th><%=u.getLogin() %></th>
                <th><%=u.getEmail() %></th>
                <th><%=u.getTipo() %></th>
            </tr>
            <% }%>

            </tbody>
        </table>
    </div>
</div>