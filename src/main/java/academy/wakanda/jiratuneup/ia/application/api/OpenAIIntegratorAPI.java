package academy.wakanda.jiratuneup.ia.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public interface OpenAIIntegratorAPI {

	@PostMapping("/send")
	@ResponseStatus(value = HttpStatus.OK)
	OpenAIResponse sendMessage(@Valid @RequestBody OpenAIRequest openAIRequest);
}
