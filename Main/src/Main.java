public class Main {
    public static String DectoHex(int N) {
        if (N == 0) return "0";

        StringBuilder hex = new StringBuilder();
        while (N > 0) {
            int remainder = N % 16;
            if (remainder < 10) {
                hex.insert(0, (char) ('0' + remainder));
            } else {
                hex.insert(0, (char) ('A' + remainder - 10));
            }
            N /= 16;
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        double N = -85.125;
        String Sign = "";
        if (N < 0) Sign = "1";
        else Sign = "0";
        int TempFirst = Math.abs((int) N);
        String first = DectoHex(TempFirst);

        double TempSend = Math.abs(N) - TempFirst;

        double div = 0.5;
        double Sum = 0;
        String output = "";
        int Limit = 6;
        while (Sum < TempSend && Limit > 0) {
            int temp_X = 0;
            if ((Sum + div) <= TempSend) {
                temp_X = 1;
                Sum += div;
            }
            output += String.valueOf(temp_X);
            div = div / 2;
            Limit--;
        }

        System.out.println("Fake binary is " + first + "." + output);

        int Count = first.length() - 1;

        String Exponent = "";
        Exponent = DectoHex(Count + 127);
        while (Exponent.length() < 8) {
            Exponent = "0" + Exponent;
        }

        String temp = first.substring(1) + output;

        while (temp.length() < 23)
            temp = temp + "0";
        System.out.println("Sign: " + Sign);
        System.out.println("Exponent: " + Exponent);
        System.out.println("Mantissa: " + temp);
    }
}
