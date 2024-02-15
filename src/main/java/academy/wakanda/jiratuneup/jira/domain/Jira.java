package academy.wakanda.jiratuneup.jira.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Jira {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idJira", updatable = false, unique = true, nullable = false)
	private UUID idJira;
	private String descricaoHistoria;

	public Jira(String descricao) {
		this.descricaoHistoria = descricao;
	}
}
