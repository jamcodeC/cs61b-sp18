public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
    static double  G = 6.67e-11;
	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img){
		this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;


	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;

	}
	public double calcDistance(Planet p){
		return Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		if (this.calcDistance(p)==0) {
			return 0;		
		}else{
		double distance = this.calcDistance(p); 
		return (G * this.mass * p.mass) / (distance*distance);
	    }
	}


	public double calcForceExertedByX(Planet p){
		if (this.calcDistance(p)==0) {
			return 0;		
		}else{
		double distance_x = p.xxPos - this.xxPos;

		return this.calcForceExertedBy(p) * distance_x / this.calcDistance(p);
	    }
	}
	public double calcForceExertedByY(Planet p){
		if (this.calcDistance(p)==0) {
			return 0;		
		}else{
		double distance_y = p.yyPos - this.yyPos;

		return this.calcForceExertedBy(p) * distance_y / this.calcDistance(p);
		}
	}

	public double calcNetForceExertedByX(Planet[] planets){
		double NetForceX = 0.0;
		for(Planet p:planets){
			if (this.calcDistance(p)==0){
			continue;
			}else{
			NetForceX += this.calcForceExertedByX(p);
			}
		}
		return NetForceX;
	}

	public double calcNetForceExertedByY(Planet[] planets){
		double NetForceY = 0.0;
		for(Planet p:planets){
			if (this.calcDistance(p)==0){
			continue;
			}else{
			NetForceY += this.calcForceExertedByY(p);
			}
		}
		return NetForceY;
	}

	public void update(double dt, double fx, double fy){
		double ax = fx/this.mass;
		double ay = fy/this.mass;
		this.xxVel += dt * ax;
		this.yyVel += dt * ay;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;

	}

	public void draw(){

		String imgFilepath = "images/"+ this.imgFileName;
		StdDraw.picture(this.xxPos,this.yyPos,imgFilepath);

	}





}