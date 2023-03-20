public class NBody{
    public static double readRadius(String filename){
	In in = new In(filename);
	int planet_number = in.readInt();
	double radius = in.readDouble();
	return radius;
    }

    public static Planet[] readPlanets(String filename){
	In in = new In(filename);
	int planet_number = in.readInt();
	Planet[] planets_Array = new Planet[planet_number];
	double radius = in.readDouble();
	for (int i = 0; i < planet_number; i++){
	    double xxPos = in.readDouble();
	    double yyPos = in.readDouble();
	    double xxVel = in.readDouble();
	    double yyVel = in.readDouble();
	    double mass = in.readDouble();
	    String imgFileName = in.readString();
	    planets_Array[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
	}
	return planets_Array;
    }

    public static void main(String[] args){
	/* Collecting All Needed Input. */
	double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	Planet[] planets = readPlanets(filename);
	double universe_radius = readRadius(filename);

	StdDraw.setScale(-universe_radius, universe_radius);
	StdDraw.clear();
	StdDraw.picture(0, 0, "images/starfield.jpg");
	for (Planet p : planets){
		p.draw();
	}
	StdDraw.enableDoubleBuffering();

	double time = 0.0;
	int planet_number = planets.length;
	while (time <= T){
	    double[] xForces = new double[planet_number];
	    double[] yForces = new double[planet_number];
	    for (int i = 0; i < planet_number; i++){
		xForces[i] = planets[i].calcNetForceExertedByX(planets);
		yForces[i] = planets[i].calcNetForceExertedByY(planets);
	    }
	    for (int i = 0; i < planet_number; i++){
		planets[i].update(dt, xForces[i], yForces[i]);
	    }
	
	    StdDraw.clear();
	    /* Draw the background image. */
	    StdDraw.picture(0, 0, "images/starfield.jpg");

	    /* Draw all of the planets. */
	    for (Planet p : planets){
		p.draw();
	    }

	    /* Show the offscreen buffer. */
	    StdDraw.show();

	    /* Pause the animation for 10 milliseconds. */
	    StdDraw.pause(10);

	    time += dt;
	}
	
	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n", universe_radius);
	for (Planet p : planets){
	    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
	}
    }
}
