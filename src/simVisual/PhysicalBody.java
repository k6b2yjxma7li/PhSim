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
	double xAcc;
	double yAcc;
	double xVel;
	double yVel;
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
	}
	//copying constructor
	PhysicalBody(PhysicalBody ref) {
		xAcc = ref.getAx();
		yAcc = ref.getAy();
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
		x = x + dT*xVel;
		y = y + dT*yVel;
	}
	void calcAcc(double Force, double fAngle) {
		double xForce = Force*Math.cos(fAngle);
		double yForce = Force*Math.sin(fAngle);
		//
		xAcc = xForce / m;
		yAcc = yForce / m;
	}
}