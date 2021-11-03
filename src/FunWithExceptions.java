public class FunWithExceptions {
    public static void main(String[] args) {
        FunWithExceptions app = new FunWithExceptions();
        app.run();

    }
    public void run() {
        try {
            String[] strings = new String[10];

            for (int i = 0; i < strings.length; i++) {
                strings[i] = " " + i + " ";

                System.out.println(strings[i]);

            }
        }
        catch(Exception e) {
                System.out.println("Dette virker ikke");
            }
        finally {
            System.out.println("Gør altid det her");
        }

}}
