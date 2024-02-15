package academy.wakanda.jiratuneup.jira.application.api;

import java.util.List;

import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JiraResponse {

	private String descricaoHistoria;

	public JiraResponse(List<OpenAIResponse.Choice> choices) {
		if (!choices.isEmpty()) {
			this.descricaoHistoria = choices.get(0).getMessage().getContent();
		} else {
			this.descricaoHistoria = "Nenhuma escolha disponível.";
		}
	}

}
