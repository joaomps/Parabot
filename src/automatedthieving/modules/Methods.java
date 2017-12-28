package automatedthieving.modules;

public class Methods {
	private static final char[] SUFFIXES = {'k', 'm', 'g', 't', 'p', 'e'};

	public static String formatValues(long number) {
		if (number < 1000) {
			return String.valueOf(number);
		}
		final String string = String.valueOf(number);
		final int magnitude = (string.length() - 1) / 3;
		final int digits = (string.length() - 1) % 3 + 1;

		char[] value = new char[4];
		for (int i = 0; i < digits; i++) {
			value[i] = string.charAt(i);
		}
		int valueLength = digits;

		if (digits == 1 && string.charAt(1) != '0') {
			value[valueLength++] = '.';
			value[valueLength++] = string.charAt(1);
		}
		value[valueLength++] = SUFFIXES[magnitude - 1];
		return new String(value, 0, valueLength);
	}
}
