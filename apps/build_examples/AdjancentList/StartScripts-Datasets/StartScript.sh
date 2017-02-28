#!/usr/bin/env bash
#create data
size1=1000000
size2=1000
cd ~/spark-2.1.0-bin-hadoop2.7
java -classpath $ADJ_HOME/StartScripts-Datasets/ CreateAdjListData -size $size1
#start job
./bin/spark-submit --master=spark://10.22.1.1:10086 $ADJ_HOME/target/scala-2.11/adjancentlist_2.11-1.0.0.jar $size2 /home/wfan/DFT-Project/apps/build_examples/AdjancentList/java/StartScripts-Datasets/combined $ADJ_HOME/java/result true
