<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% User u = (User)session.getAttribute("user");  %>
<br>

<h1 align="center">Bem vindo <%= u.getNome() %></h1>

<%@ page import="br.vianna.edu.academia.model.dao.imp.TreinoDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="static br.vianna.edu.academia.util.UtilService.formatarHorario" %>
<%@ page import="br.vianna.edu.academia.model.*" %>
<%
    Academia a = (Academia) request.getAttribute("academia");

%>

<% if (u != null && u.isUser() ){ %>


<%

    List<Exercicio> exercicios = (List<Exercicio>) request.getAttribute("exercicios");

%>
<div class="container mt-5">
    <h1 class="mb-4">Contagem de Pessoas Treinando</h1>
    <button class="btn btn-primary mb-3" onclick="fazerChamadaAjax()">Exibir</button>
    <div id="resultado" class="alert"></div>
</div>
<br>
<br>
<br>
<h1>Ficha:</h1>
<% if (!exercicios.isEmpty()) { %>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Nome do Exercício</th>
        <th>Séries</th>
        <th>Repetições</th>
    </tr>
    </thead>
    <tbody>
    <% for (Exercicio exercicio : exercicios) { %>
    <tr>
        <td><%= exercicio.getNome() %></td>
        <td><%= exercicio.getSeries() %></td>
        <td><%= exercicio.getRepeticoes() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<% } else { %>
<p>Não há exercícios disponíveis.</p>
<% } %>
<%

if (u.getReserva() != null){
%>

<div class="container mt-5">
    <h2>Horários Reservados para a Piscina</h2>
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
</div>
<%
        }
    }
    if(u.isAdmin()){
%>

<div class="container mt-5">
    <p class="lead">Pessoas na Academia: <%= (a != null )?a.getPessoasTreinando():0 %></p>
    <h2>Registro de Pessoas na Academia</h2>
    <form method="post" action="/index?ac=qtdAluno">
        <div class="form-group">
            <label for="inputPessoas">Número de Pessoas na Academia:</label>
            <input type="number" class="form-control" id="inputPessoas" name="pessoas" min="0" required>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>

<%
    }
%>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

