TRAININGS
========
p01-preparing-data-machine-learning-java
---
https://app.pluralsight.com/library/courses/preparing-data-machine-learning-java

DATASETS
====

```shell
echo restoring sample data...
if [ -d "./.data" ]; then
  rm -rf ./.data
else
  git clone git@github.com:aivars-playground/Data_20250505.git ./.data
fi
```

```shell
echo restoring sample workdir......
rm -rf ./workdir/data
mkdir ./workdir/data
cp .data/preparing-data-machine-learning-java/purchases/sales-june-2020.csv ./workdir/data/
```
