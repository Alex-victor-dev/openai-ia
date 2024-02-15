
package academy.wakanda.jiratuneup.file.application.service;

import java.util.List;

import academy.wakanda.jiratuneup.ia.application.api.OpenAIResponse;

public interface FileSaver {

	void saveToFile(List<OpenAIResponse.Choice> choices);

}
