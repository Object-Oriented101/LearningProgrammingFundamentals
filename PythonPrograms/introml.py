from sklearn import tree

# [height, weight, shoe_size]
horsepower = [[500], [400],[350], [100], [200],[1000],[3000],[5000]]
Vehicle =    ['car','car','car','van','van','plane','plane','plane']


clf = tree.DecisionTreeClassifier();

clf.fit(horsepower,Vehicle)

prediction = clf.predict([[2000]])

print(prediction);