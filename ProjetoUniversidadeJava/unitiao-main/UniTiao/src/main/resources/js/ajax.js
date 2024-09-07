$(document).ready(function() {
    $.ajax({
        url: '/nome',
        type: 'GET',
        success: function(data) {
            $('#nomeUsuario').text(data);
        },
        error: function(xhr, status, error) {
            console.error('Erro ao carregar nome do usuário:', error);

        }
    });
});