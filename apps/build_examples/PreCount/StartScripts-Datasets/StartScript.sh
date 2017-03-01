#!/usr/bin/env bash
minlen=1
maxlen=10
#input file downloaded from http://www.manythings.org/vocabulary/lists/l/words.php?f=noll07
inputpath=$PRE_HOME/StartScripts-Datasets/dataset1
outputpath="result"
ispartitioned=true
cd ~/spark-2.1.0-bin-hadoop2.7
./bin/spark-submit --deploy-mode=cluster --master=spark://10.22.1.1:10086 /home/wfan/DFT-Project/apps/build_examples/PreCount/target/scala-2.11/prefixcount_2.11-1.0.0.jar $maxlen $minlen $inputpath $outputpath $ispartitioned
