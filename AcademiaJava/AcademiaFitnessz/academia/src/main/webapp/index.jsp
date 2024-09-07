<%@ page import="br.vianna.edu.academia.model.User" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="script.js"></script>
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <% User u = (User)session.getAttribute("user");  %>
 <header>
    <nav>
            <ul>
                <li>
                    <a href="/index">Home</a>
                </li>
                    <% if (u != null && u.isAdmin() ){ %>
                <li>
                    <a href="/index?ac=CadastraReserva">Gerenciar Horarios da Piscina</a>
                </li>
                <li>
                    <a href="/index?ac=cadExercicios">Cadastrar Ficha</a>
                </li>
                <li>
                    <a href="/index?ac=buscar">Buscar Usuarios</a>
                </li>
                    <% }%>
                    <% if (u != null && u.isUser()){ %>
                <li>
                    <a href="/index?ac=reservaPiscina">Reservar Horário Piscina</a>
                </li>
                <li>
                    <a href="/index?ac=altUser">Alterar informações</a>
                </li>

                     <% }%>
                     <li>
                         <% if (u == null){ %>
                         <a href="/index?ac=login">Login</a>
                         <% }else{ %>
                         <a href="/index?ac=logout">Sair</a>
                         <% } %>
                     </li>
                     <% if (u == null){ %>
                     <li>
                         <a href="/index?ac=cadUser">Cadastre-se</a>
                     </li>
                     <% } %>
                 </ul>
             </nav>
         </div>

     </div>

 </header>

    <%
        String pg = request.getParameter("pg");
        pg = (pg == null)? "home" : pg;
        pg = "/pages/"+pg+".jsp";
    %>

    <jsp:include page="<%= pg %>" />

    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 Academia Fitness. Todos os direitos reservados.</p>
        </div>
    </footer>

    <style>


        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }


        .header {
            background-color: #333;
            color: #fff;
            padding: 20px 0;
        }

        .logo {
            font-size: 24px;
        }

        .navigation {
            text-align: right;
        }

        .menu {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .menu-item {
            color: #fff;
            text-decoration: none;
            margin-left: 20px;
        }

        /* Estilos para a seção herói */
        .hero {
            background-color: #f2f2f2;
            padding: 100px 0;
            text-align: center;
        }

        .hero-title {
            font-size: 36px;
            margin-bottom: 20px;
        }

        .hero-text {
            font-size: 18px;
            margin-bottom: 40px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn-primary {
            background-color: #ff4500;
            margin-left: 20px;
        }

        /* Estilos para a seção de recursos */
        .features {
            padding: 80px 0;
        }

        .section-title {
            text-align: center;
            font-size: 32px;
            margin-bottom: 40px;
        }

        .feature {
            text-align: center;
            margin-bottom: 40px;
        }

        .feature i {
            font-size: 48px;
            color: #333;
            margin-bottom: 20px;
        }

        .feature-title {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .feature-text {
            font-size: 18px;
        }

        /* Estilos para o rodapé */
        .footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px 0;
        }
        footer {
            position: fixed; /* ou absolute */
            bottom: 0;
            width: 100%;
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center; /* Centralizar o conteúdo */
        }

        nav ul li {
            display: inline-block;
            margin-right: 20px; /* Espaçamento entre os itens */
        }

        nav ul li a {
            text-decoration: none;
            color: #333; /* Cor do texto */
            font-weight: bold;
            font-size: 16px;
            padding: 10px 20px; /* Espaçamento interno */
            border-radius: 5px; /* Borda arredondada */
            border: 2px solid transparent; /* Borda transparente */
            transition: all 0.3s ease; /* Transição suave */
        }

        /* Estilizando os links quando passa o mouse */
        nav ul li a:hover {
            background-color: #f0f0f0; /* Cor de fundo ao passar o mouse */
            color: #666; /* Cor do texto ao passar o mouse */
        }

        /* Estilizando o link ativo */
        nav ul li a.active {
            background-color: #ff0000; /* Cor de fundo do link ativo */
            color: #fff; /* Cor do texto do link ativo */
        }

        /* Estilizando a navegação para dispositivos móveis */
        @media screen and (max-width: 600px) {
            nav ul li {
                display: block;
                margin: 10px 0; /* Espaçamento entre os itens */
            }
        }



    </style>

</body>
</html>