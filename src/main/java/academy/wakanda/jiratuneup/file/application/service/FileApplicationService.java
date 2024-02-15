package academy.wakanda.jiratuneup.file.application.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Service;

import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;

@Service
public class FileApplicationService implements FileSaver {

	@Override
	public void saveToFile(List<OpenAIResponse.Choice> choices) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Escolha o local para salvar o arquivo");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt"));

		int userSelection = fileChooser.showSaveDialog(null);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();

			try (PrintWriter writer = new PrintWriter(new FileWriter(selectedFile))) {
				writer.println("Cenário do Teste:");

				for (OpenAIResponse.Choice choice : choices) {
					writer.println("Dado que o papel é " + choice.getMessage().getRole());
					writer.println("Quando a mensagem é enviada ao chat");
					writer.println("Então a resposta deve ser: " + choice.getMessage().getContent());
					writer.println();
				}

				System.out.println("Respostas armazenadas em: " + selectedFile.getAbsolutePath());
			} catch (IOException e) {
				System.err.println("Erro ao armazenar as respostas em arquivo");
				e.printStackTrace();
			}
		}
	}
}
