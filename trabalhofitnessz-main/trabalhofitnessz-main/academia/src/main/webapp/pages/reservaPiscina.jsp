<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.vianna.edu.academia.model.ReservaPiscina" %>
<%@ page import="java.util.List" %>
<%@ page import="br.vianna.edu.academia.model.Piscina" %>
<%@ page import="static br.vianna.edu.academia.util.UtilService.formatarHorario" %>
<%@ page import="br.vianna.edu.academia.model.User" %>
<% User u = (User)session.getAttribute("user");  %>
<%
    request.getAttribute("reservas");
    List<Piscina> horarios = (List<Piscina>) request.getAttribute("reservas");

%>
<div class="container mt-5">
<h2>Horário Disponíveis para a Piscina</h2>
    <%
        if(horarios == null){
    %>
      <h3>Não existe horários disponiveis</h3>

    <%
        }else{
    %>
<table class="table table-bordered mt-4">
    <thead class="thead-light">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Horário Disponíveis</th>
    </tr>
    </thead>
    <tbody>
    <%  for(Piscina p : horarios) {%>
    <tr>
        <td><%= p.getId() %></td>
        <td><%=formatarHorario( p.getHorarioDisponivel() ) %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</div>
<%
    }
        if(u.getReserva() == null ){
%>
<div class="container mt-5">
<h2>Cadastrar Reserva de Horário</h2>
<form action="/index?ac=cadHora" method="POST">
    <div class="form-group">
        <label for="idHorario">ID do Horário:</label>
        <input type="text" class="form-control" id="idHorario" name="cadReserva" required>
    </div>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
    <h5>Obs: o horário cadastrado será valido por apenas uma hora</h5>
</form>
</div>
<%
    }else{
%>
<div class="container">
    <h5>Você já possui horário cadastrado</h5>
</div>
<% } %>