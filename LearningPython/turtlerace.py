import turtle
import random
wn = turtle.Screen()
alex = turtle.Turtle()
tina = turtle.Turtle()
check = turtle.Turtle()
alex.up()
alex.color("blue")
tina.up()


alex.backward(300)
tina.left(90)
tina.forward(100)
tina.right(90)
tina.backward(300)

check.up()
check.left(90)
check.backward(50)
check.color("red")
check.down()
check.forward(200)
check.right(180)
check.up()
y = random.randrange(1,100)
tina.down();
tina.speed(y)
tina.forward(400)

x = random.randrange(1,300)
alex.down();
alex.speed(x)
alex.forward(400)









    
