package academy.wakanda.jiratuneup.ia.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import academy.wakanda.jiratuneup.handler.APIException;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIRequest;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class GPTMessageInfraIntegrator implements GPTMessageSenderIntegrator {

	private final GPTMessageSenderClientIntegrator gptMessageSenderClientIntegrator;

	@Value("${jiratuneup.openai.token-ia}")
	private String openaiToken;

	@Override
	public OpenAIResponse sendMessage(OpenAIRequest openAIRequest) {
		log.info("[inicia] GPTMessageInfraIntegrator - sendMessage");
		try {
			String authorizationHeader = "Bearer " + openaiToken;
			OpenAIResponse openAiResponse = gptMessageSenderClientIntegrator.sendMessage(authorizationHeader,
					openAIRequest);
			log.info("[openAIRequest] {}", openAIRequest);
			return openAiResponse;

		} catch (FeignException feignException) {
			int statusCode = feignException.status();
			String responseBody = feignException.contentUTF8();
			throw APIException.build(HttpStatus.valueOf(statusCode), "Falha na Integração com a API do OPENAI. Status: "
					+ statusCode + ", Response Body: " + responseBody);

		} catch (Exception e) {
			log.error("Ocorreu uma exceção não tratada", e);
			throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu uma exceção Não Tratada");

		} finally {
			log.info("[finaliza] GPTMessageInfraIntegrator - sendMessage");
		}
	}
}
