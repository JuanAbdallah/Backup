<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <h1 class="mb-4">Cadastro de Exercícios</h1>
    <form action="/index?ac=saveExercicios" method="post">
        <div class="mb-3">
            <label for="userId" class="form-label">Login do Usuário</label>
            <input type="text" class="form-control" id="userId" name="userLogin" placeholder="Login do Usuário" required>
        </div>
        <% for (int i = 1; i <= 8; i++) { %>
        <div class="mb-3">
            <label for="nome<%=i%>" class="form-label">Exercício <%=i%></label>
            <div class="input-group">
                <input type="text" class="form-control" id="nome<%=i%>" name="nome<%=i%>" placeholder="Nome do Exercício" required>
                <input type="number" class="form-control" id="series<%=i%>" name="series<%=i%>" placeholder="Séries" required>
                <input type="number" class="form-control" id="repeticoes<%=i%>" name="repeticoes<%=i%>" placeholder="Repetições" required>
            </div>
        </div>
        <% } %>
        <button type="submit" class="btn btn-primary">Cadastrar Exercícios</button>
    </form>
    <br><br><br><br><br><br>
</div>
