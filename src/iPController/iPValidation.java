package iPController;

public class iPValidation {

	public static void main(String[] args) {

		// Test
		String iP = "192.168.111.111";
		String iP2 = "8.8.8.AS";
		String iP3 = "182.1.4.9999";
		iPValidation ip = new iPValidation();
		System.out.println(ip.checkPoint(iP));
		System.out.println(ip.checkPoint(iP2));
		System.out.println(ip.checkPoint(iP3));
	}

	public boolean checkPoint(String iP) {
		boolean res = false;
		int number, sayac = 0;
		if (iP.length() < 16 && iP.length() > 6) {
			while (!iP.isEmpty()) {
				sayac++;
				int point = iP.indexOf(".");

				if (point == -1 && iP.length() < 4) {
					point = iP.length();
				}

				if (point < 4 && point > 0) {
					try {
						number = Integer.parseInt(iP.substring(0, point));

						if (!numberCheck(number)) {
							res = false;
							return res;
						} else {
							try {
								iP = iP.substring(point + 1);
								res = true;
							} catch (StringIndexOutOfBoundsException e) {
								iP = "";
							}
						}

					} catch (NumberFormatException e) {
						res = false;
						return res;
					}

				}

				else {
					res = false;
					return res;
				}
			}
			if (sayac != 4) {
				res = false;
				return res;
			}
		}

		else
			return res;

		return res;
	}

	public boolean numberCheck(int number) {

		if (number >= 0 && number < 256) {
			return true;
		} else
			return false;
	}
}
