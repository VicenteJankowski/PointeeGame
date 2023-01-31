# PointeeGame

Welcome to PointeeGame! PointeeGame is a simple CLI game. 

As a player, you get checkerboard of 15x15 size. Each field of checkerboard contains a coupon with Pointee. All Pointees have the same value of 1 point. At the begining of a game you have to select field you would like to redeem at the end. Your goal is to store as many points on selected field as possible.

The tricky part is, there is a bird flying on the checkerboard and Pointees are afraid of it. Each times bird approaches to a field, all Pointees jump to random adjectent field. The bird is flying on checkerboard radomly, until it jump off. Pointees can't jump off the checkerboard.

## Installation

After downloading the repository use Maven to compile it.

```bash
mvn clean install
```
To run application:
```bash
mvn exec:java -Dexec.mainClass=pl.admonster.App
```
To run test:
```bash
mvn test
```
## Usage
You start by selecting a coordinates of field with coupon to redeem. Please, keep in mind that X axis is vertical, Y axis is horizontal. Coordinates of top left field are (0, 0).
In each round you have to pass a starting point coordinates for bird.

You can finish a game after 5th, 25th, 50th or 100th round. At the end of the game application will print coupon with maximum points and the points you have gathered on your coupon.

Good luck!
