import java.awt.*;

public abstract class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private double xCoordinate, yCoordinate;
    private double angle = 0;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.stopEngine();
    }

    public String getModelName() {
        return modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
            return currentSpeed;
    }

    public double getxCoordinate(){
        return xCoordinate;
    }

    public double getyCoordinate(){
        return yCoordinate;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    private void setCurrentSpeed(double speed) {
        if (speed < 0 || speed > enginePower) {
            throw new IllegalArgumentException("Speed needs to be in the range of 0 and enginePower");
        } else { currentSpeed = speed;}

    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }



    public void move(){
        xCoordinate += currentSpeed;
        yCoordinate +=  currentSpeed;
    }

    public void toAngle(){
        xCoordinate += Math.cos(angle) * currentSpeed;
        yCoordinate += Math.sin(angle) * currentSpeed;
    }

    public void turnLeft(){
        angle += Math.PI / 2;
        toAngle();
    }

    public void turnRight(){
        angle -= Math.PI / 2;
        toAngle();
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Invalid input"); //write exception
        } else {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println(amount); //write exception
        } else {
            decrementSpeed(amount);
    }
 }
}
