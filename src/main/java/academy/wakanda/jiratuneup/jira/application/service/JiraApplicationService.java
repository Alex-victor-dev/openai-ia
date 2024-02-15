package academy.wakanda.jiratuneup.jira.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.jiratuneup.jira.application.api.JiraResponse;
import academy.wakanda.jiratuneup.jira.application.repository.JiraRepository;
import academy.wakanda.jiratuneup.jira.domain.Jira;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JiraApplicationService implements JiraService {

	private final JiraRepository jiraRepository;

	@Override
	public JiraResponse enviaDescricao(String descricao) {
		jiraRepository.salva(new Jira(descricao));
		return new JiraResponse(descricao);
	}

}
