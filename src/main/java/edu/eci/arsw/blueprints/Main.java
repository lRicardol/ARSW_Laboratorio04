package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BlueprintsServices services = ctx.getBean(BlueprintsServices.class);

        Point[] pts1 = new Point[]{new Point(10, 10), new Point(20, 20)};
        Blueprint bp1 = new Blueprint("Andres", "plano1", pts1);

        Point[] pts2 = new Point[]{new Point(30, 30), new Point(40, 40)};
        Blueprint bp2 = new Blueprint("Andres", "plano2", pts2);

        Point[] pts3 = new Point[]{new Point(5, 5), new Point(15, 15)};
        Blueprint bp3 = new Blueprint("maria", "plano3", pts3);

        services.addNewBlueprint(bp1);
        services.addNewBlueprint(bp2);
        services.addNewBlueprint(bp3);

        System.out.println("=== Todos los planos ===");
        services.getAllBlueprints().forEach(System.out::println);

        System.out.println("\n=== Planos de Andres ===");
        services.getBlueprintsByAuthor("Andres").forEach(System.out::println);

        System.out.println("\n=== Plano específico ===");
        System.out.println(services.getBlueprint("maria", "plano3"));
    }
}