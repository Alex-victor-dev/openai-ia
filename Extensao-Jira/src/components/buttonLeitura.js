function criarBotaoLeituraHistoria() {
    var buttonLeituraHistoria = document.createElement('button');
    buttonLeituraHistoria.innerHTML = 'Leitura de História';
    buttonLeituraHistoria.setAttribute('type', 'button');
    buttonLeituraHistoria.classList.add('aui-button', 'aui-button-primary');
    buttonLeituraHistoria.style.marginLeft = '10px'; // Adicionando margem esquerda para separação

    buttonLeituraHistoria.addEventListener('click', capturarTexto);

    return buttonLeituraHistoria;
}
