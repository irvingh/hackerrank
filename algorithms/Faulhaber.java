public class Faulhaber {
	Faulhaber() {
		Rational[][] f = new Rational[401][0];
		f[0] = new Rational[1];
		f[0][0] = new Rational(1,1);
		for (int r = 1;r < f.length;r++) {
			f[r] = new Rational[r + 1];
			Rational sum = new Rational(0, 1);
			for (int c = 1; c <= r; c++) {
				f[r][c] = (new Rational(r, c + 1)).mult(f[r - 1][c - 1]);
				sum = sum.add(f[r][c]);
			}
			f[r][0] = (new Rational(1,1)).sub(sum);
		}
		System.out.println("");
	}

	class Rational {
		long a, b;
		Rational(long n, long d) {
			if (d == 0) {
				a = 0; d = 1;
			} else {
				long gcd = gcd(n, d);
				a = n/gcd; b = d/gcd;
			}
		}
		Rational add(Rational r) {
			return new Rational(a * r.b + b * r.a , b * r.b);
		}
		Rational sub(Rational r) {
			return new Rational(a * r.b - b * r.a , b * r.b);
		}
		Rational mult(Rational r) {
			return new Rational(a * r.a , b * r.b);
		}
		
		long gcd(long a, long b) {
			if (b == 0) {
				return a;
			} else {
				return gcd(b, a % b);
			}
		}
		
		public String toString() {
			if (b == 1) {
				return Long.toString(a);
			}
			if (b < 0) {
				return -a + "/" + -b;
			} else {
				return a + "/" + b;
			}
		}
	}
}