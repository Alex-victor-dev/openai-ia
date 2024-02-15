package academy.wakanda.jiratuneup.ia.application.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenAIResponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("choices")
	private List<Choice> choices;

	@Getter
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Choice {

		@JsonProperty("message")
		private Message message;

	}

	@Getter
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Message {

		@JsonProperty("role")
		private String role;

		@JsonProperty("content")
		private String content;
	}
}