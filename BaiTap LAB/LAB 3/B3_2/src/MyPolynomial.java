import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = Arrays.copyOf(coeffs, coeffs.length);
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = getDegree(); i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (sb.length() > 0 && coeffs[i] > 0) {
                    sb.append(" + ");
                } else if (coeffs[i] < 0) {
                    sb.append(" - ");
                }

                double absCoeff = Math.abs(coeffs[i]);
                if (i == 0 || absCoeff != 1) {
                    sb.append(absCoeff);
                }

                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.toString();
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = getDegree(); i >= 0; i--) {
            result = result * x + coeffs[i];
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxDegree = Math.max(this.getDegree(), right.getDegree());
        double[] newCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= this.getDegree(); i++) {
            newCoeffs[i] += this.coeffs[i];
        }
        for (int i = 0; i <= right.getDegree(); i++) {
            newCoeffs[i] += right.coeffs[i];
        }

        return new MyPolynomial(newCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int newDegree = this.getDegree() + right.getDegree();
        double[] newCoeffs = new double[newDegree + 1];

        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= right.getDegree(); j++) {
                newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }

        return new MyPolynomial(newCoeffs);
    }

    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1, -2, 3); // 3x^2 - 2x + 1
        MyPolynomial p2 = new MyPolynomial(2, 3);     // 3x + 2

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("Degree of p1: " + p1.getDegree());
        System.out.println("p1(2) = " + p1.evaluate(2));
        System.out.println("p1 + p2 = " + p1.add(p2));
        System.out.println("p1 * p2 = " + p1.multiply(p2));
    }
}
