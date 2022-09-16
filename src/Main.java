import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

  private String filePath = "src/danske-postnumre-byer.csv";
  HashMap<String, String> cities = new HashMap<>();

  public static void main(String[] args) {
    Main main = new Main();
    main.run();
  }

  private void run() {
    getData();
    input();

  }

  private void getData() {
    try {
      FileReader fr = new FileReader(filePath);
      BufferedReader br = new BufferedReader(fr);

      String line = br.readLine();
      while (line != null) {
        List<String> lineData = Arrays.asList(line.split(","));
        cities.put(lineData.get(0), lineData.get(1));
        line = br.readLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void input() {
    String input = "";
    Scanner sc = new Scanner(System.in);
    boolean isRunning = true;
    while (isRunning) {
      while (!tryParseInt(input)) {
        System.out.print("Indtast postnummer: ");
        input = sc.nextLine();
        if (getCity(input) != null) {
          System.out.println(getCity(input));
        } else {
          System.out.println("No such zipcode.");
        }
      }
      System.out.print("Continue? (y/n): ");
      String continueInput = sc.nextLine();
      ;
      if (continueInput.equalsIgnoreCase("n")) {
        isRunning = false;
      } else if (continueInput.equalsIgnoreCase("y")) {
        input = "";
      }
    }

  }

  private String getCity(String zipCode) {
    return cities.get(zipCode);
  }


  public boolean tryParseInt(String str) {
    try {
      Integer.parseInt(str);
    } catch (Exception E) {
      return false;
    }
    return true;
  }
}