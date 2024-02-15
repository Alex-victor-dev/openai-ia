package academy.wakanda.jiratuneup.jira.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.wakanda.jiratuneup.jira.domain.Jira;

public interface JiraInfraRepository extends JpaRepository<Jira, UUID> {

}
