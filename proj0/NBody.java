/**
 * NBody
 */
public class NBody {

    /**
     * Read the radies.
     * @param file_path
     * @return
     */
    public static double readRadius(String file_path) {
        In in = new In(file_path);
        in.readInt();
        return in.readDouble();
    }

    /**
     * Read the planets.
     * @param file_path
     * @return
     */
    public static Planet[] readPlanets(String file_path) {
        In in = new In(file_path);
        int n = in.readInt();
        Planet[] planet_list = new Planet[n];
        in.readDouble();
        for (int i = 0; i < n; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planet_list[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return planet_list;
    }

    /**
     * The main function.
     * @param args
     */
    public static void main(String[] args) {

        String imageToDraw = "images/starfield.jpg";

        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double universe_radius = readRadius(filename);
        Planet[] planet_list = readPlanets(filename);
        int n = planet_list.length;

        StdDraw.enableDoubleBuffering();

        /** Sets up the universe */
        StdDraw.setScale(universe_radius * (-1), universe_radius);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Stamps images/starfield.jpg */
        StdDraw.picture(0, 0, imageToDraw);

        for (Planet planet : planet_list) {
            planet.draw();
        }

        double time = 0;

        while (time < T) {
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            for (int i = 0; i < n; i++) {
                xForces[i] = planet_list[i].calcNetForceExertedByX(planet_list);
                yForces[i] = planet_list[i].calcNetForceExertedByY(planet_list);
            }
            for (int i = 0; i < n; i++) {
                planet_list[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, imageToDraw);
            for (Planet planet : planet_list) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", planet_list.length);
        StdOut.printf("%.2e\n", universe_radius);
        for (int i = 0; i < planet_list.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planet_list[i].xxPos, planet_list[i].yyPos,
                          planet_list[i].xxVel, planet_list[i].yyVel,
                          planet_list[i].mass, planet_list[i].imgFileName);
        }
    }
}
