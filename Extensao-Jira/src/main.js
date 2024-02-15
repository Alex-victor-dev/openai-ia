var botaoLeituraHistoria = criarBotaoLeituraHistoria();
var menu = document.getElementsByClassName('css-njhh6c')[0];
var botaoCriar = document.querySelector('[data-testid="create-button-wrapper"]');

if (menu && botaoCriar) {
    botaoCriar.appendChild(botaoLeituraHistoria);
} else {
    console.log('Não foi possível encontrar o contêiner ou o botão "Criar"');
}