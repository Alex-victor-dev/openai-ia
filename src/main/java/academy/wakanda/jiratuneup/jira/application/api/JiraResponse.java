package academy.wakanda.jiratuneup.jira.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JiraResponse {

	private String descricaoHistoria;

	public JiraResponse(String descricaoHistoria) {
		this.descricaoHistoria = "Seu Teste Foi Um Sucesso";
	}

}
