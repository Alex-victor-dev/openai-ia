package academy.wakanda.jiratuneup.jira.infra;

import org.springframework.stereotype.Repository;

import academy.wakanda.jiratuneup.jira.application.repository.JiraRepository;
import academy.wakanda.jiratuneup.jira.domain.Jira;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JiraInfraJpaRepository implements JiraRepository {

	private final JiraInfraRepository jiraInfraJpa;
	
	@Override
	public Jira salva(Jira jira) {
		jiraInfraJpa.save(jira);
		return jira;
	}

}
