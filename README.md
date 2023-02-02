# PointeeGame

Welcome to PointeeGame! PointeeGame is a simple CLI game.

As a player, you get a checkerboard of 15x15 size. Each field of checkerboard contains a coupon with a Pointee. All Pointees have the same value of 1 point. At the beginning of a game you have to select a field you would like to redeem at the end. Your goal is to store as many points on the selected field as possible.

The tricky part is, there is a bird flying on the checkerboard and Pointees are afraid of it. Each time a bird approaches a field, all Pointees jump to a random adjacent field. The bird is flying on the checkerboard randomly, until it jumps off. Pointees can't jump off the checkerboard.

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
You start by selecting the coordinates of the field with a coupon to redeem. Please, keep in mind that X axis is vertical, Y axis is horizontal. Coordinates of the top left field are (0, 0).
In each round you have to pass a starting point coordinates for the bird.

You can finish a game after the 5th, 25th, 50th. You can also continue until the 100th round, if you think you will get more points on your coupon. At the end of the game the application will print a coupon with maximum points and the points you have gathered on your coupon.

Good luck!
