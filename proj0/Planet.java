public class Planet {

    private static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * The first constructor.
     * 
     * @param xP  Its current x position
     * @param yP  Its current y position
     * @param xV  Its current velocity in the x direction
     * @param yV  Its current velocity in the y direction
     * @param m   Its mass
     * @param img The name of the file that corresponds to the image that depicts
     *            the planet
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /**
     * The second constructor.
     * 
     * @param p a planet
     */
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     * Calculate the distance between two Planets.
     * 
     * @param that another planet
     * @return the distance between tow planets in double
     */
    public double calcDistance(Planet that) {
        return Math.sqrt((this.xxPos - that.xxPos) * (this.xxPos - that.xxPos)
                + (this.yyPos - that.yyPos) * (this.yyPos - that.yyPos));
    }

    /**
     * Calculate the force exerted on this planet by the given planet.
     * 
     * @param that another planet
     * @return a double describing the force exerted on this planet by the given
     *         planet.
     */
    public double calcForceExertedBy(Planet that) {
        return G * this.mass * that.mass / (this.calcDistance(that) * this.calcDistance(that));
    }

    /**
     * Calculate the force exerted in the X direction
     * 
     * @param that another planet
     * @return a double describing the force exerted in the X direction
     */
    public double calcForceExertedByX(Planet that) {
        return this.calcForceExertedBy(that) / this.calcDistance(that) * (that.xxPos - this.xxPos);
    }

    /**
     * Calculate the force exerted in the Y direction
     * 
     * @param that another planet
     * @return a double describing the force exerted in the Y direction
     */
    public double calcForceExertedByY(Planet that) {
        return this.calcForceExertedBy(that) / this.calcDistance(that) * (that.yyPos - this.yyPos);
    }

    /**
     * Calculate the net X force exerted by all planets upon the current Planet.
     * 
     * @param planet_list an array of Planets
     * @return the net X force exerted by all planets upon the current Planet in
     *         double
     */
    public double calcNetForceExertedByX(Planet[] planet_list) {
        double force = 0;
        for (Planet planet : planet_list) {
            if (!this.equals(planet)) {
                force += this.calcForceExertedByX(planet);
            }
        }
        return force;
    }

    /**
     * Calculate the net Y force exerted by all planets upon the current Planet.
     * 
     * @param planet_list an array of Planets
     * @return the net Y force exerted by all planets upon the current Planet in
     *         double
     */
    public double calcNetForceExertedByY(Planet[] planet_list) {
        double force = 0;
        for (Planet planet : planet_list) {
            if (!this.equals(planet)) {
                force += this.calcForceExertedByY(planet);
            }
        }
        return force;
    }

    /**
     * Update the planet’s position and velocity instance variables.
     * 
     * @param dt a small period of time
     * @param fX x_force
     * @param fy y_force
     */
    public void update(double dt, double fX, double fY) {
        double a_x = fX / this.mass;
        double a_y = fY / this.mass;
        this.xxVel += dt * a_x;
        this.yyVel += dt * a_y;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
