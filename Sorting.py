

dataset = [3,5,2,1,4,6,4,5,3,45,6,]

min = 0

for x in range(len(dataset)):
    for i in range(len(dataset)-1):
        if dataset[i] > dataset[i+1]:
            temp = dataset[i+1]
            dataset[i+1] = dataset[i]
            dataset[i] = temp
            i = i + 1;


for i in range(len(dataset)):
       print(dataset[i])