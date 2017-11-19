/**
 * @author rumcajs
 * @version 16.11.2017
 */
package simVisual;

public class PhysicalBody {
	//declarations
	double x;
	double y;
	double m;
	double q;
	double xAcc;
	double yAcc;
	double xVel;
	double yVel;
	double radius;
	//default constructor
	PhysicalBody() {
		x = 0;
		y = 0;
		m = 1.0;
		xAcc = 0;
		yAcc = 0;
		xVel = 0;
		yVel = 0;
	}
	//main constructor
	PhysicalBody(double X, double Y) {
		x = X;
		y = Y;
		m = 1.0;
		xAcc = 0;
		yAcc = 0;
		xVel = 0;
		yVel = 0;
	}
	//copying constructor
	PhysicalBody(PhysicalBody ref) {
		xAcc = ref.getAx();
		yAcc = ref.getAy();
		q = ref.getQ();
		m = ref.getM();
		x = ref.getX();
		y = ref.getY();
		xVel = ref.getVx();
		yVel = ref.getVy();
	}
	//setters
	void setX(double X) {
		x = X;
	}
	void setY(double Y) {
		y = Y;
	}
	void setM(double M) {
		m = M;
	}
	void setQ(double Q) {
		q = Q;
	}
	void setAx(double Ax) {
		xAcc = Ax;
	}
	void setAy(double Ay) {
		yAcc = Ay;
	}
	void setVx(double Vx) {
		xVel = Vx;
	}
	void setVy(double Vy) {
		yVel = Vy;
	}
	void setRad(double Rad) {
		radius = Rad;
	}
	//getters
	double getX() {
		return x;
	}
	double getY() {
		return y;
	}
	double getM() {
		return m;
	}
	double getQ() {
		return q;
	}
	double getAx() {
		return xAcc;
	}
	double getAy() {
		return yAcc;
	}
	double getVx() {
		return xVel;
	}
	double getVy() {
		return yVel;
	}
	double getRad() {
		return radius;
	}
	//calculators
	void setVelVector(double vVector, double vAngle) {
		xVel = vVector*Math.cos(vAngle);
		yVel = vVector*Math.sin(vAngle);
	}
	void setAccVector(double aVector, double aAngle) {
		xAcc = aVector*Math.cos(aAngle);
		yAcc = aVector*Math.sin(aAngle);
	}
	void calcVel(double dT) {
		xVel = xVel + dT*xAcc;
		yVel = yVel + dT*xAcc;
	}
	void calcPosition(double dT) {
		x += dT*xVel;
		y += dT*yVel;
	}
	void calcAcc(double Force, double fAngle) {
		double xForce = Force*Math.cos(fAngle);
		double yForce = Force*Math.sin(fAngle);
		//
		xAcc = xForce / m;
		yAcc = yForce / m;
	}
	void calcBoundaries(int xSize, int ySize) {
		if(x > xSize) {
			xVel = -xVel;
		}
		if(y > ySize) {
			yVel = -yVel;
		}
		if(x < 0) {
			xVel = -xVel;
		}
		if(x < 0) {
			xVel = -xVel;
		}
	}
}