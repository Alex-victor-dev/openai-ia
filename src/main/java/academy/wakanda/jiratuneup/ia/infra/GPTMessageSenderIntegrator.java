package academy.wakanda.jiratuneup.ia.infra;

import academy.wakanda.jiratuneup.ia.application.api.OpenAIRequest;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;

public interface GPTMessageSenderIntegrator {

	OpenAIResponse sendMessage(OpenAIRequest openAIRequest);

}
