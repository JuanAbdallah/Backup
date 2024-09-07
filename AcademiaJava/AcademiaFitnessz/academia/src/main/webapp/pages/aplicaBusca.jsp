<%@ page import="br.vianna.edu.academia.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="br.vianna.edu.academia.model.Exercicio" %>
<%@ page import="static br.vianna.edu.academia.util.UtilService.formatarHorario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Exercicio> l = (List<Exercicio>) request.getAttribute("exercicios");
    User u = (User) request.getAttribute("user");
    int i = 1;
%>

<div class="container mt-5">
    <h2 class="text-center mb-4">Informações</h2>
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


            <tr>
                <th><%=u.getId() %></th>
                <th><%=u.getNome() %></th>
                <th><%=u.getLogin() %></th>
                <th><%=u.getEmail() %></th>
                <th><%=u.getTipo() %></th>
            </tr>


            </tbody>
        </table>
    </div>
</div>
<br>
<br>
<% if(u.getReserva() != null){ %>
<div class="container mt-5">
    <h2>Horário Reservados para a Piscina</h2>
    <table class="table table-bordered mt-4">
        <thead class="thead-light">
        <tr>
            <th scope="col">Horário Reservado</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td><%=formatarHorario( u.getReserva().getData() ) %></td>
        </tr>

        </tbody>
    </table>
    <form method="post" action="/index?ac=delReserva">
        <input type="hidden" name="nome" value="<%= u.getLogin() %>">
        <button type="submit" class="btn btn-primary">FINALIZAR</button>
    </form>
</div>
<br>
<br>
<br>
<% } %>
<%
    if(!l.isEmpty()){
%>

<div class="container">
    <h1 class="mb-4">Alteração de Exercícios</h1>
    <form action="/index?ac=saveAlt" method="post">
        <% for (Exercicio e : l) { %>
        <div class="mb-3">
            <label for="nome<%=i%>" class="form-label">Exercício <%=i%></label>
            <div class="input-group">
                <input type="text" class="form-control" id="nome<%=i%>" name="nome<%=i%>" placeholder="Nome do Exercício" value="<%=e.getNome()%>" required>
                <input type="number" class="form-control" id="series<%=i%>" name="series<%=i%>" placeholder="Séries" value="<%=e.getSeries()%>" required>
                <input type="number" class="form-control" id="repeticoes<%=i%>" name="repeticoes<%=i%>" placeholder="Repetições" value="<%=e.getRepeticoes()%>"required>
                <input type="hidden" name="userLogin" value="<%=u.getLogin()%>">
            </div>
        </div>
        <%i++; } %>
        <button type="submit" class="btn btn-primary">Alterar Exercícios</button>
<%}%>
    </form>

    <div class="container">
        <br>
        <br>
        <a href="/index?ac=index" class="btn btn-primary">Sair</a>
    </div>

    <br><br><br><br><br><br>
</div>
