package interfaces;

public interface Formual {
	double calculate(int a);
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

}
