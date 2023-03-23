public class Planet{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
	xxPos = xP;
	yyPos = yP;
	xxVel = xV;
	yyVel = yV;
	mass = m;
	imgFileName = img;
    }

    public Planet(Planet p){
	xxPos = p.xxPos;
	yyPos = p.yyPos;
	xxVel = p.xxVel;
	yyVel = p.yyVel;
	mass = p.mass;
	imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
	return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
	double r = calcDistance(p);
	return G * this.mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p){
	return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }
    
    public double calcForceExertedByY(Planet p){
	return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p); 
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
	double netforceX = 0.0;
	for (Planet p : allPlanets){
	    if (this.equals(p)){
		continue;
	    }
	    netforceX += calcForceExertedByX(p);
	}
	return netforceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
	double netforceY = 0.0;
	for (Planet p : allPlanets){
	    if (this.equals(p)){
		continue;
	    }
	    netforceY += calcForceExertedByY(p);
	}
	return netforceY;
    }

    public void update(double dt, double fX, double fY){
	double aX = fX / this.mass;
	double aY = fY / this.mass;
	xxVel += aX * dt;
	yyVel += aY * dt;
	xxPos += xxVel * dt;
	yyPos += yyVel * dt;
    }

    public void draw(){
	StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
    }
}
