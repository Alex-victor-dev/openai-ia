 /** 
  function capturarTexto() {
    var descricaoHistoriaElement = document.querySelector('.ak-renderer-document');

    if (descricaoHistoriaElement) {
        var descricaoHistoria = descricaoHistoriaElement.innerText;
        var textoCompleto = `Descrição da História:\n${descricaoHistoria}\n\n`;

        downloadTxtFile(textoCompleto, 'descricao_historia.txt');
    } else {
        console.log('Elemento com a descrição da história não encontrado');
    }
}

function downloadTxtFile(text, filename) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);

    element.style.display = 'none';
    document.body.appendChild(element);

    element.click();

    document.body.removeChild(element);
}
*/
/**
function downloadJsonFile(content, fileName) {
    var jsonContent = JSON.stringify(content, null, 2);
    
    var blob = new Blob([jsonContent], { type: 'application/json' });
    var link = document.createElement('a');
    link.href = window.URL.createObjectURL(blob);
    link.download = fileName;
    
    document.body.appendChild(link);
    link.click();
    
    document.body.removeChild(link);
}

function capturarTexto() {
    var descricaoHistoriaElement = document.querySelector('.ak-renderer-document');

    if (descricaoHistoriaElement) {
        var descricaoHistoria = descricaoHistoriaElement.innerText;
        var jsonContent = {
            descricaoHistoria: descricaoHistoria
        };

        downloadJsonFile(jsonContent, 'descricao_historia.json');
    } else {
        console.log('Elemento com a descrição da história não encontrado');
    }
}

function enviarParaAPI() {
    var descricaoHistoriaElement = document.querySelector('.ak-renderer-document');

    if (descricaoHistoriaElement) {
        var descricaoHistoria = descricaoHistoriaElement.innerText;
        var jsonContent = {
            texto: descricaoHistoria
        };

        var urlDoBackend = 'localhost:8080/jira/api/v1/ia'; // Substitua pela URL do seu backend

        fetch(urlDoBackend, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                // Adicione cabeçalhos adicionais, como autenticação, se necessário
            },
            body: JSON.stringify(jsonContent),
        })
        .then(response => response.json())
        .then(data => {
            // Use a resposta do seu backend para atualizar o campo de descrição no Jira
            atualizarCampoDescricao(data.resposta);

            // Salvar o retorno da API em um arquivo de texto
            salvarEmArquivo(data.resposta);
        })
        .catch(error => {
            console.error('Erro ao enviar texto para o backend:', error);
        });
    } else {
        console.log('Elemento com a descrição da história não encontrado');
    }
}

function salvarEmArquivo(retornoDaAPI) {
    // Use a API de File System para salvar em um arquivo
    // Esta parte depende do ambiente em que você está executando o código (navegador, Node.js, etc.)
    // Aqui está um exemplo para navegador:
    
    const blob = new Blob([retornoDaAPI], { type: 'text/plain' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'retorno_da_api.txt';
    link.click();
}

 */
/** Codigo Novo -----
function enviarParaAPI(texto) {
    // Substitua 'URL_DO_SEU_BACKEND/endpoint' pela URL do seu backend
    var urlDoBackend = '';

    fetch(urlDoBackend, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            // Adicione cabeçalhos adicionais, como autenticação, se necessário
        },
        body: JSON.stringify({
            texto: texto,
        }),
    })
    .then(response => response.json())
    .then(data => {
        // Use a resposta do seu backend para atualizar o campo de descrição no Jira
        atualizarCampoDescricao(data.resposta);
    })
    .catch(error => {
        console.error('Erro ao enviar texto para o backend:', error);
    });

    */ 
/**
function enviarParaAPI() {
    var descricaoHistoriaElement = document.querySelector('.ak-renderer-document');

    if (descricaoHistoriaElement) {
        var descricaoHistoria = descricaoHistoriaElement.innerText;
        var jsonContent = {
            texto: descricaoHistoria
        };

        var urlDoBackend = 'localhost:8080/jira/api/v1/ia'; // Substitua pela URL do seu backend

        fetch(urlDoBackend, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                // Adicione cabeçalhos adicionais, como autenticação, se necessário
            },
            body: JSON.stringify(jsonContent),
        })
        .then(response => response.json())
        .then(data => {
            // Use a resposta do seu backend para atualizar o campo de descrição no Jira
            atualizarCampoDescricao(data.resposta);
        })
        .catch(error => {
            console.error('Erro ao enviar texto para o backend:', error);
        });
    } else {
        console.log('Elemento com a descrição da história não encontrado');
    }
     
}
 */

function downloadJsonFile(content, fileName) {
    const jsonContent = JSON.stringify(content, null, 2);
    
    const blob = new Blob([jsonContent], { type: 'application/json' });
    const link = createAndClickDownloadLink(blob, fileName);
    document.body.removeChild(link);
}

function capturarTexto() {
    const descricaoHistoriaElement = document.querySelector('.ak-renderer-document');

    if (descricaoHistoriaElement) {
        const descricaoHistoria = descricaoHistoriaElement.innerText;
        const jsonContent = {
            descricaoHistoria: descricaoHistoria
        };

        downloadJsonFile(jsonContent, 'descricao_historia.json');
    } else {
        console.log('Elemento com a descrição da história não encontrado');
    }
}

function enviarParaAPI() {
    const descricaoHistoriaElement = document.querySelector('.ak-renderer-document');

    if (descricaoHistoriaElement) {
        const descricaoHistoria = descricaoHistoriaElement.innerText;
        const jsonContent = {
            texto: descricaoHistoria
        };

        const urlDoBackend = 'localhost:8080/jira/api/v1/ia'; // Substitua pela URL do seu backend
        enviarRequisicaoParaBackend(urlDoBackend, jsonContent);
    } else {
        console.log('Elemento com a descrição da história não encontrado');
    }
}


function enviarRequisicaoParaBackend(url, content) {
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            // Adicione cabeçalhos adicionais, como autenticação, se necessário
        },
        body: JSON.stringify(content),
    })
    .then(response => response.json())
    .then(data => {
        atualizarCampoDescricao(data.resposta);
        salvarEmArquivo(data.resposta);
    })
    .catch(error => {
        console.error('Erro ao enviar texto para o backend:', error);
    });
}

function salvarEmArquivo(retornoDaAPI) {
    const blob = new Blob([retornoDaAPI], { type: 'text/plain' });
    const link = createAndClickDownloadLink(blob, 'retorno_da_api.txt');
    document.body.removeChild(link);
}

function createAndClickDownloadLink(blob, fileName) {
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = fileName;
    link.style.display = 'none';
    
    document.body.appendChild(link);
    link.click();

    return link;
}
