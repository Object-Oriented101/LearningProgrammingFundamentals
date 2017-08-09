from Tkinter import*
from random import randint
root = Tk();
root.title("Unit Circle Practice")


check = [['sin(30)','1/2'],['sin(45)', '2/2'],['sin(60)','3/2'],['sin(90)', '1'],['cos(30)', '3/2'],['cos(45)', '2/2'],['cos(60)','1/2'],['cos(90)','0'],
['sin(120)', '3/2'],['sin(135)','2/2'],['sin(150)','1/2'],['sin(180)','0'],['cos(120)', '-1/2'],['cos(135)', '-2/2'],['cos(150)','-3/2'],['cos(180)','-1']]

counter = randint(0,16)
answer_master = ['Answer1','Answer2','Answer3']
def check_function():
       entry = Entry.get()
       if check[counter][1] == entry:
        print("correct")
        #global counter;
        #if counter == len(check):
        #    counter = 0;
        #counter = counter + 1;
        global counter
        counter = randint(0,6)
        Question['text'] = check[counter][0]



Question = Label(root, text= check[counter][0])

#Answer0 = Button(root, text = "1/2",command = check_function)
#Answer1 = Button(root, text = "2/2")
#Answer2 = Button(root, text = "3/2")

Entry = Entry(root)
Submit = Button(root, text = "Submit", command = check_function)

Question.grid(row = "0", column = "0");
#Answer0.grid(column = "0", row = "1");
#Answer1.grid(column = "1", row = "1");
#Answer2.grid(column = "2", row = "1");
Entry.grid(column = "0", row = "1")
Submit.grid(column = "0", row = "2")




root.mainloop();



















