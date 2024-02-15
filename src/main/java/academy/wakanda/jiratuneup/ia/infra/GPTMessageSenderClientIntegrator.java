package academy.wakanda.jiratuneup.ia.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import academy.wakanda.jiratuneup.ia.application.api.OpenAIRequest;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;

@FeignClient(name = "gptMessageSenderClientIntegrator", url = "${jiratuneup.openai.server}")
public interface GPTMessageSenderClientIntegrator {

	@PostMapping(value = "/v1/chat/completions", consumes = MediaType.APPLICATION_JSON_VALUE)
	OpenAIResponse sendMessage(@RequestHeader("Authorization") String authorizationHeader,
			@RequestBody OpenAIRequest openAIRequest);
}