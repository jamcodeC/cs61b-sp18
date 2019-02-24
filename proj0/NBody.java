public class NBody {

	public static String backGround = "images/starfield.jpg";

	public static void main(String[] args){

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];


		In in = new In(filename);
		int n_planets = in.readInt(); 
		double radius = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);

		System.out.println(planets[1].yyPos);//test							

		StdDraw.setScale(-radius, radius);

		StdDraw.picture(0,0,backGround);

		for(Planet p:planets){
			p.draw();
		}

		StdDraw.enableDoubleBuffering();
		StdDraw.show();
		double t_start = 0;

		while(t_start<T){
			double[] xForces = new double[n_planets];
			double[] yForces = new double[n_planets];
			for(int n = 0;n<n_planets;n++){
				xForces[n] = planets[n].calcNetForceExertedByX(planets);
				yForces[n] = planets[n].calcNetForceExertedByY(planets);
				} 
			for(int n = 0;n<n_planets;n++) planets[n].update(dt,xForces[n],yForces[n]);

			StdDraw.clear();
			StdDraw.picture(0,0,backGround);
			for (int i = 0; i < planets.length; i++) {
					planets[i].draw();
				}
			StdDraw.show();
			StdDraw.pause(10);
			t_start += dt;
			System.out.println(t_start/T);
			}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}

	}

	public static double readRadius(String path){
    	In in = new In(path);
    	int n_planet = in.readInt();
    	double radius = in.readDouble();
    	return radius;

    }

    public static Planet[] readPlanets(String path){
    	In in = new In(path);
    	int n_planet = in.readInt();
    	Planet[] planets = new Planet[n_planet];
        for(int j = 0; j < n_planet; j++){
            planets[j] = new Planet(0,0,0,0,0,"");
        }

    	in.readDouble();
    	int i = 0;
    	while(!in.isEmpty()){
    		if(i == n_planet){
    			break;
    		}
    		planets[i].xxPos = in.readDouble();
    		planets[i].yyPos = in.readDouble();
    		planets[i].xxVel = in.readDouble();
    		planets[i].yyVel = in.readDouble();
    		planets[i].mass = in.readDouble();
    		planets[i].imgFileName = in.readString();
    		i += 1;
    	}
    	return planets;
	}
}
