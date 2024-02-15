package academy.wakanda.jiratuneup.jira.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.jiratuneup.jira.application.service.JiraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/ia")
@RequiredArgsConstructor
public class JiraController {

	private final JiraService jiraService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public JiraResponse enviaDescricap(@RequestBody String descricao) {
		JiraResponse jira = jiraService.enviaDescricao(descricao);
		return jira;
	}
}
