TRAINING
========
p01-preparing-data-machine-learning-java
---
https://app.pluralsight.com/library/courses/preparing-data-machine-learning-java

PREPARATION
====

RESTORING SAMPLE DATA 
---
```shell
echo ******************************** RESTORING SAMPLE DATA
if [ -d "./.data" ]; then
  rm -rf ./.data
else
  git clone git@github.com:aivars-playground/Data_20250505.git ./.data
fi
```

Snippets - reading different files types
---
```shell
echo ******************************** RESTORING WORKDIR
rm -rf ./workdir/data
mkdir ./workdir/data
cp .data/preparing-data-machine-learning-java/purchases/sales-june-2020.csv ./workdir/data/
echo ******************************** READING CSV
mvn exec:java -pl snippets -Dexec.mainClass=CsvFileReader -Dexec.args="workdir/data/sales-june-2020.csv"
```
