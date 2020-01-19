# -*- coding: utf-8 -*-
"""
Created on Sun Jan 19 16:06:52 2020

@author: hj
"""

import pandas as pd

train = pd.read_csv("C:/Users/tian1/Downloads/train.csv")
test = pd.read_csv("C:/Users/tian1/Downloads/test.csv")


import seaborn as sns

sns.countplot(data=train, x="Embarked", hue="Survived")

sns.countplot(data=train, x="Pclass", hue="Survived")


low_fare=train[train["Fare"] < 100]
sns.lmplot(data=low_fare, x="Age", y="Fare", hue="Survived", fit_reg=False)


### Preprocessing
# Encode Sex
train["_Sex_encoder"] = train["Sex"].replace("male",0).replace('female',1)


### Filling with Fare
# NaN(Not a Number), Null
train[train["Fare"].isnull()]
test.loc[test["Fare"].isnull(), "Fare"] = 0

test[test["Fare"].isnull()]

### Group Age
train["Child"] = train["Age"] <10
#train[""] ....

### Train

# Feature(X) - Pclass, Sex, Fare, ...
# Label(y) - Survived

feature_names = ["Pclass", "_Sex_encoder", "Fare"]
feature_names

X = train[feature_names]
X.head()

label_name = "Survived"
y = train[label_name]
y.head()



### Use Decision Tree
from sklearn.tree import DecisionTreeClassifier

# fit, predict

model = DecisionTreeClassifier()

model


# male, female은 의사결정나무에서 해석을 못
model.fit(X, y)


### Visualize
import graphviz
from sklearn.tree import export_graphviz

tree = export_graphviz(model, feature_names = feature_names, class_names=["Perish", "Survived"])
graphviz.Source(tree)


### Predict


### Submit



submit.to_csv("decision=tree.csv", index = False)


















