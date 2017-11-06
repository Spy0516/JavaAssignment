import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import models.Baby;
import models.Gift;
import models.BabyService;

public class BabyRegister {

    public static void main(String args[]) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        BabyService service = new BabyService();
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy/HH:mm");
        String userCommand;
        //Baby baby1 = new Baby();
        // Baby baby2 = new Baby("28/7/2003 07:23", "John", 'F');    
        //System.out.println(baby5.getBirthday().getYear());
        // Gift gift1 = new Gift("Firuz", "Cellphone", new Date(2005, 6, 13, 18, 12));
        //  service.addBaby(baby1);
        //service.addGifts(gift1);
        do {
            System.out.println("now time is: 07/11/2017/19:25");

            System.out.println("Say 'exit' 'addBaby', 'addGift', 'listOfBabyName' ,'listOfBabyAge', 'listGift' ");

            userCommand = scanner.next();

            switch (userCommand) {
                case "addBaby":

                    System.out.println("Say the name of the Baby");
                    String name = scanner.next();

                    System.out.println("Say the birthday of the Person(DD/MM/YYYY/HH/MM)");
                    String d = scanner.next();

                    Date day = new Date();
                    boolean validDate = false;
                    while (!validDate) {
                        try {
                            day = myFormat.parse(d);
                            validDate = true;
                        } catch (ParseException e) {
                            System.out.println("Invalid date, type it again");
                            validDate = false;
                        }
                    }

                    System.out.println("Enter the gender");
                    char gender = scanner.next().charAt(0);
                    boolean check = false;
                    while (!check) {
                        if (Character.toLowerCase(gender) == 'f' || Character.toLowerCase(gender) == 'm') {
                            check = true;
                        } else {
                            System.out.println("Enter the gender");
                            gender = scanner.next().charAt(0);
                        }
                    }

                    Baby baby1 = new Baby(day, name, gender);
                    BabyService.addBaby(baby1);

                    break;

                case "addGift":
                    System.out.println("Say the name of giver");
                    String whoGave = scanner.next();

                    System.out.println("Write some description about gift");
                    String description = scanner.next();

                    System.out.println("Say the date when the gift was given(DD/MM/YYYY/HH/MM)");
                    String d1 = scanner.next();
                    Date whenGave = new Date();

                    boolean validDate1 = false;
                    while (!validDate1) {
                        try {
                            whenGave = myFormat.parse(d1);
                            validDate1 = true;
                        } catch (ParseException e) {
                            System.out.println("Invalid date, type it again");
                            validDate1 = false;
                        }
                    }

                    Gift gift1 = new Gift(whoGave, description, whenGave);
                    BabyService.addGifts(gift1);
                    break;

                case "listOfBabyName":
                    System.out.println(BabyService.listBabyByName());
                    break;
                case "listOfBabyAge":
                    System.out.println(BabyService.listBabyByAge());
                    break;
                case "listGift":
                    System.out.println(BabyService.listGifts().toString());
                    break;

            }

        } while (!userCommand.equals("exit"));

    }

}
