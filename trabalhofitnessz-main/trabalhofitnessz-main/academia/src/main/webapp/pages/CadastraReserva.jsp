<%@ page import="static br.vianna.edu.academia.util.UtilService.formatarHorario" %>
<%@ page import="br.vianna.edu.academia.model.Piscina" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.getAttribute("reservas");
    List<Piscina> horarios = (List<Piscina>) request.getAttribute("reservas");
%>
<div class="container mt-5">
    <h2>Cadastro de Horário</h2>
    <form action="/index?ac=saveCadReserva" method="POST">
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="inputDia">Dia:</label>
                <input type="number" class="form-control" id="inputDia" name="dia" required>
            </div>
            <div class="form-group col-md-2">
                <label for="inputMes">Mês:</label>
                <input type="number" class="form-control" id="inputMes" name="mes" required>
            </div>
            <div class="form-group col-md-2">
                <label for="inputAno">Ano:</label>
                <input type="number" class="form-control" id="inputAno" name="ano" required>
            </div>
            <div class="form-group col-md-2">
                <label for="inputHora">Hora:</label>
                <input type="number" class="form-control" id="inputHora" name="hora" required>
            </div>
            <div class="form-group col-md-2">
                <label for="inputMinutos">Minutos:</label>
                <input type="number" class="form-control" id="inputMinutos" name="minutos" required>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>

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
        <form method="post" action="/index?ac=delHorario">
            <div class="form-group">
                <label>ID</label>
                <input type="number" class="form-control" id="id" name="id" min="0" required>
            </div>
            <button type="submit" class="btn btn-primary">DELETAR</button>
        </form>
    </table>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%
    }
%>