package academy.wakanda.jiratuneup.ia.application.service;

import academy.wakanda.jiratuneup.ia.application.api.OpenAIRequest;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;

public interface OpenAIIntegratorService {

	OpenAIResponse sendMessage(OpenAIRequest openAIRequest);

}
