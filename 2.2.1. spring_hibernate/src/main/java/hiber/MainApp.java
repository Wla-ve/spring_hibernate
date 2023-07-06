package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User vasya = new User("Vanya", "Vasechkin", "vasechkin@mail.io");
      User petya = new User("Petya", "Sidorov", "sidorov@mail.io");
      User vlad = new User("Vladislav","Nedobugin","Vladuxa5555@gachi.org");

      Car volvo = new Car("Volvo", 9);
      Car bmw = new Car("BMW", 325);
      Car lada = new Car("Lada", 21014);

      userService.add(vasya.setCars(volvo).setUser(vasya));
      userService.add(petya.setCars(bmw).setUser(petya));
      userService.add(vlad.setCars(lada).setUser(vlad));

     for (User user : userService.listUsers()){
        System.out.println(user+ " " + user.getCars());
     }
      System.out.println(userService.getCarByUser("Lada",21014));
     context.close();
   }
}
