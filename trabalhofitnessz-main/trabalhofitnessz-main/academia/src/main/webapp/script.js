function fazerChamadaAjax() {
    fetch('/index?ac=contagemPessoasTreinando')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao buscar a contagem de pessoas treinando.');
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("resultado").innerHTML = "Quantidade de pessoas treinando: " + data;
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}
