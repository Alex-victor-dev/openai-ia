package academy.wakanda.jiratuneup.ia.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.jiratuneup.file.application.service.FileSaver;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIRequest;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;
import academy.wakanda.jiratuneup.ia.infra.GPTMessageSenderIntegrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class OpenAIIntegratorApplicationService implements OpenAIIntegratorService {

	private final GPTMessageSenderIntegrator gtpMessageSenderIntegratorClient;
	private final FileSaver fileSaver;

	@Override
	public OpenAIResponse sendMessage(OpenAIRequest openAIRequest) {
		log.info("[inicia] OpenAIIntegratorApplicationService - sendMessage");
		OpenAIResponse openAiResponse = gtpMessageSenderIntegratorClient.sendMessage(openAIRequest);
		// fileSaver.saveToFile(openAiResponse.getChoices());
		log.info("[finaliza] OpenAIIntegratorApplicationService - sendMessage");
		return openAiResponse;
	}

}
