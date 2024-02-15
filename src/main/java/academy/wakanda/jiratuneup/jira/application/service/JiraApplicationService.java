package academy.wakanda.jiratuneup.jira.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.jiratuneup.ia.application.api.OpenAIRequest;
import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;
import academy.wakanda.jiratuneup.ia.application.service.OpenAIIntegratorService;
import academy.wakanda.jiratuneup.jira.application.api.JiraResponse;
import academy.wakanda.jiratuneup.jira.application.repository.JiraRepository;
import academy.wakanda.jiratuneup.jira.domain.Jira;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JiraApplicationService implements JiraService {

	private final JiraRepository jiraRepository;
	private final OpenAIIntegratorService openAiIntegratorService;

	@Override
	public JiraResponse enviaDescricao(String descricao) {
		OpenAIResponse openAIResponse = openAiIntegratorService.sendMessage(new OpenAIRequest(descricao));
		jiraRepository.salva(new Jira(descricao));
		return new JiraResponse(openAIResponse.getChoices());
	}

}
