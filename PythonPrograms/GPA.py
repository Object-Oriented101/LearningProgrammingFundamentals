from Tkinter import*

root = Tk();
root.title("GPA Calculator")

final = Tk();
final.title("Final Grade Calculator")
final.withdraw();

file = Menu(root);
root.config(menu = file);
file1 = Menu(final)
final.config(menu = file1);

def final_function():
    root.withdraw()
    final.deiconify()


def root_function():
    root.deiconify();
    final.withdraw();

subMenu = Menu(file)
file.add_cascade(label = "File", menu = subMenu)  #casacading means adding a drop down menu
subMenu.add_command(label="GPA Calculator", command = root_function)
subMenu.add_command(label="Final Grade Calculator", command = final_function)

subMenu = Menu(file1)
file1.add_cascade(label = "File", menu = subMenu)  #casacading means adding a drop down menu
subMenu.add_command(label="GPA Calculator", command = root_function)
subMenu.add_command(label="Final Grade Calculator", command = final_function)


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


#-------------------------------------------------------------------------------------------------
Lab1 = Label(final, text="Current Grade")
Lab2 = Label(final, text="Required Class Grade")
Lab3 = Label(final, text="Final Exam Weight")

Lab1.grid(row = "0", column = "0");
Lab2.grid(row = "1", column = "0");
Lab3.grid(row = "2", column = "0");

Ent1 = Entry(final)
Ent2 = Entry(final)
Ent3 = Entry(final)
Ent4 = Entry(final)

Ent1.grid(row = "0",column = "1")
Ent2.grid(row = "1",column = "1")
Ent3.grid(row = "2",column = "1")
Ent4.grid(row = "3",column = "1")

def calculate():
    current_Grade = float(Ent1.get())
    required_Grade = float(Ent2.get())
    weight = float(Ent3.get())

    Goal_Grade = (100*required_Grade-(100-weight)*current_Grade)/weight
    Ent4.insert(0,Goal_Grade)




calculate = Button(final, text = "Calculate", command = calculate)
calculate.grid(row = "3", column = "0")

root.mainloop();



















