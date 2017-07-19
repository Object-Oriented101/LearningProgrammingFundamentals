from Tkinter import*

root = Tk();
root.title("GPA Calculator")

menu = Menu(root);
root.config(menu = menu);

subMenu = Menu(menu)
menu.add_cascade(label = "File", menu = subMenu)  #casacading means adding a drop down menu
subMenu.add_command(label="GPA Calculator", command = root)



#Below is code for GPA Calculator
Label1 = Label(root, text="Class 1")
Label2 = Label(root, text="Class 2")
Label3 = Label(root, text="Class 3")
Label4 = Label(root, text="Class 4")
Label5 = Label(root, text="Class 5")
Label6 = Label(root, text="Class 6")

Label1.grid(row = "0", column = "0");
Label2.grid(row = "1", column = "0");
Label3.grid(row = "2", column = "0");
Label4.grid(row = "3", column = "0");
Label5.grid(row = "4", column = "0");
Label6.grid(row = "5", column = "0");

Entry1 = Entry(root)
Entry2 = Entry(root)
Entry3 = Entry(root)
Entry4 = Entry(root)
Entry5 = Entry(root)
Entry6 = Entry(root)

Entry1.grid(row = "0",column = "1")
Entry2.grid(row = "1",column = "1")
Entry3.grid(row = "2",column = "1")
Entry4.grid(row = "3",column = "1")
Entry5.grid(row = "4",column = "1")
Entry6.grid(row = "5",column = "1")

GPA = Entry(root)
GPA.grid(row = "6", column = "1")

def calculator():
    input1 = float(Entry1.get())
    input2 = float(Entry2.get())
    input3 = float(Entry3.get())
    input4 = float(Entry4.get())
    input5 = float(Entry5.get())
    input6 = float(Entry6.get())

    Sum = input1+input2+input3+input4+input5+input6;
    Sum = Sum/6;

    GPA.insert(0,Sum)


submit = Button(root, text = "Submit", command = calculator)
submit.grid(row = "6", column = "0")


root.mainloop();