package data;

public class Answers {
	
	public static final FormAnswer EMPTY_ANSWERS = new FormAnswer("", "", "");
	
	public static final FormAnswer JOSE_FILHO = new FormAnswer(
			"Jos� Rocha Filho", // Name
			"09/20/1993", // Birthday
			"Porque acho que a �rea de testes � de suma import�ncia para a entrega de software de qualidade." // Why testing field
			);
	
	public static final FormAnswer USER_BIRTHDAY_FUTURE = new FormAnswer(
			"Maria Silva", // Name
			"01/13/2023", // Birthday in the future
			"Porque a �rea de testes precisa de pessoas que consideram que a qualidade do software � tao importante quanto a rapidez de desenvolvimento."
			);
	
	public static final FormAnswer USER_NAME_WITH_NUMBERS = new FormAnswer(
			"Raquel 1234", // Name with number characters
			"09/20/1993", // Birthday
			"Porque acho que a �rea de testes � de suma import�ncia para a entrega de software de qualidade." // Why testing field
			);
	
	public static final FormAnswer USER_NAME_WITH_SPECIAL_CHARACTERS = new FormAnswer(
			"Raquel s!&(,r", // Name with number characters
			"09/20/1993", // Birthday
			"Porque acho que a �rea de testes � de suma import�ncia para a entrega de software de qualidade." // Why testing field
			);
}
