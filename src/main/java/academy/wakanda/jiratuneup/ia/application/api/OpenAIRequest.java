package academy.wakanda.jiratuneup.ia.application.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenAIRequest {

	@JsonProperty("model")
	private String model;

	@Valid
	@JsonProperty("messages")
	private List<Message> messages;

	@Getter
	@ToString
	public static class Message {

		@JsonProperty("role")
		private String role;

		@NotBlank(message = "Campo não pode estar vazio")
		@JsonProperty("content")
		private String content;
	}
}