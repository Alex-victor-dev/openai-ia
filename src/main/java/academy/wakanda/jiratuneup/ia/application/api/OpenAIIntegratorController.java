package academy.wakanda.jiratuneup.ia.application.api;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.jiratuneup.ia.application.service.OpenAIIntegratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class OpenAIIntegratorController implements OpenAIIntegratorAPI {

	private final OpenAIIntegratorService openAIIntegratorService;

	@Override
	public OpenAIResponse sendMessage(OpenAIRequest openAIRequest) {
		log.info("[inicia] OpenAIIntegratorController - sendMessage");
		log.info("[openAIRequest] {}", openAIRequest);
		OpenAIResponse openAiResponse = openAIIntegratorService.sendMessage(openAIRequest);
		log.info("[finaliza] OpenAIIntegratorController - sendMessage");
		return openAiResponse;
	}

}
